package com.example.taskone.tasks;

import android.provider.Settings;
import android.text.TextUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.service.commandandcontrol.CommandAndControlGrpc;
import io.grpc.service.commandandcontrol.HelloRequest;
import io.grpc.service.commandandcontrol.NumberResponse;

public class LongRunningTask implements Callable<Integer> {
    private final String[] params;

    public LongRunningTask(String[] params) {
        this.params = params;
    }

    @Override
    public Integer call() {
        String host = params[0];
        String portStr = params[1];
//        String host = "10.0.2.2";
//        String message = "fedya";
//        String portStr ="50051";

        int port = TextUtils.isEmpty(portStr) ? 0 : Integer.parseInt(portStr);
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            CommandAndControlGrpc.CommandAndControlBlockingStub stub = CommandAndControlGrpc.newBlockingStub(channel);
            HelloRequest request = HelloRequest.newBuilder().build();
            NumberResponse numberResponse = stub.getNumber(request);
            return numberResponse.getNumber();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            return 0;
        } finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}