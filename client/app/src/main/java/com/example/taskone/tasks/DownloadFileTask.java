package com.example.taskone.tasks;

import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import dalvik.system.DexClassLoader;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.service.fileservice.DataChunk;
import io.grpc.service.fileservice.DownloadFileRequest;
import io.grpc.service.fileservice.FileServiceGrpc;
import io.grpc.stub.StreamObserver;

public class DownloadFileTask implements Callable<String> {
    private File fileDir;
    private String fileName;

    public DownloadFileTask(File fileDir, String fileName) {
        this.fileDir = fileDir;
        this.fileName = fileName;
    }

    @Override
    public String call() throws Exception {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("10.0.2.2", 50051)
                .keepAliveTime(60, TimeUnit.SECONDS)
                .keepAliveWithoutCalls(true)
                .usePlaintext().build();
        FileServiceGrpc.FileServiceBlockingStub blockingStub = FileServiceGrpc.newBlockingStub(channel);
        FileServiceGrpc.FileServiceStub nonBlockingStub = FileServiceGrpc.newStub(channel);

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final CountDownLatch finishLatch = new CountDownLatch(1);
        final AtomicBoolean completed = new AtomicBoolean(false);

        StreamObserver<DataChunk> streamObserver = new StreamObserver<DataChunk>() {
            @Override
            public void onNext(DataChunk dataChunk) {
                try {
                    baos.write(dataChunk.getData().toByteArray());
                } catch (IOException e) {
//                    log.error("error on write to byte array stream", e);
                    onError(e);
                }
            }

            @Override
            public void onError(Throwable t) {
//                log.error("downloadFile() error", t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
//                log.info("downloadFile() has been completed!");
                completed.compareAndSet(false, true);
                finishLatch.countDown();
            }
        };

        try {

            DownloadFileRequest.Builder builder = DownloadFileRequest
                    .newBuilder()
                    .setFileName(fileName);

            nonBlockingStub.downloadFile(builder.build(), streamObserver);

            finishLatch.await(5, TimeUnit.MINUTES);

            if (!completed.get()) {
                throw new Exception("The downloadFile() method did not complete");
            }

        } catch (Exception e) {
//            log.error("The downloadFile() method did not complete");
        } finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        InputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        FileOutputStream fileOutputStream = new FileOutputStream(fileDir + fileName);
        int byteRead;
        while ((byteRead = inputStream.read()) != -1) {
            fileOutputStream.write(byteRead);
        }
        return fileDir + fileName;
    }
}
