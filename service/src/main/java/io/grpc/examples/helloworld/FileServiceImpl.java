package io.grpc.examples.helloworld;

import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.service.fileservice.DataChunk;
import io.grpc.service.fileservice.DownloadFileRequest;
import io.grpc.service.fileservice.FileServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FileServiceImpl extends FileServiceGrpc.FileServiceImplBase {
    @Override
    public void downloadFile(DownloadFileRequest request, StreamObserver<DataChunk> responseObserver) {
        try {
            String fileName = "/files/" + request.getFileName();

            // read the file and convert to a byte array
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            byte[] bytes = inputStream.readAllBytes();
            BufferedInputStream fileStream = new BufferedInputStream(new ByteArrayInputStream(bytes));

            int bufferSize = 1 * 1024;// 1K
            byte[] buffer = new byte[bufferSize];
            int length;
            while ((length = fileStream.read(buffer, 0, bufferSize)) != -1) {
                responseObserver.onNext(DataChunk.newBuilder()
                        .setData(ByteString.copyFrom(buffer, 0, length))
                        .setSize(bufferSize)
                        .build());
            }
            fileStream.close();
            responseObserver.onCompleted();
        } catch (Throwable e) {
            responseObserver.onError(Status.ABORTED
                    .withDescription("Unable to acquire the image " + request.getFileName())
                    .withCause(e)
                    .asException());
        }
    }
}
