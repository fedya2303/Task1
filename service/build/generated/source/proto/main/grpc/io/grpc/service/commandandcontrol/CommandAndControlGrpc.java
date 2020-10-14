package io.grpc.service.commandandcontrol;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: commandAndControl.proto")
public final class CommandAndControlGrpc {

  private CommandAndControlGrpc() {}

  public static final String SERVICE_NAME = "commandandcontrol.CommandAndControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.service.commandandcontrol.HelloRequest,
      io.grpc.service.commandandcontrol.NumberResponse> getGetNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNumber",
      requestType = io.grpc.service.commandandcontrol.HelloRequest.class,
      responseType = io.grpc.service.commandandcontrol.NumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.service.commandandcontrol.HelloRequest,
      io.grpc.service.commandandcontrol.NumberResponse> getGetNumberMethod() {
    io.grpc.MethodDescriptor<io.grpc.service.commandandcontrol.HelloRequest, io.grpc.service.commandandcontrol.NumberResponse> getGetNumberMethod;
    if ((getGetNumberMethod = CommandAndControlGrpc.getGetNumberMethod) == null) {
      synchronized (CommandAndControlGrpc.class) {
        if ((getGetNumberMethod = CommandAndControlGrpc.getGetNumberMethod) == null) {
          CommandAndControlGrpc.getGetNumberMethod = getGetNumberMethod =
              io.grpc.MethodDescriptor.<io.grpc.service.commandandcontrol.HelloRequest, io.grpc.service.commandandcontrol.NumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.service.commandandcontrol.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.service.commandandcontrol.NumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommandAndControlMethodDescriptorSupplier("GetNumber"))
              .build();
        }
      }
    }
    return getGetNumberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommandAndControlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandAndControlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandAndControlStub>() {
        @java.lang.Override
        public CommandAndControlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandAndControlStub(channel, callOptions);
        }
      };
    return CommandAndControlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommandAndControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandAndControlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandAndControlBlockingStub>() {
        @java.lang.Override
        public CommandAndControlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandAndControlBlockingStub(channel, callOptions);
        }
      };
    return CommandAndControlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommandAndControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandAndControlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandAndControlFutureStub>() {
        @java.lang.Override
        public CommandAndControlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandAndControlFutureStub(channel, callOptions);
        }
      };
    return CommandAndControlFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class CommandAndControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getNumber(io.grpc.service.commandandcontrol.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.service.commandandcontrol.NumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNumberMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNumberMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.service.commandandcontrol.HelloRequest,
                io.grpc.service.commandandcontrol.NumberResponse>(
                  this, METHODID_GET_NUMBER)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class CommandAndControlStub extends io.grpc.stub.AbstractAsyncStub<CommandAndControlStub> {
    private CommandAndControlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandAndControlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandAndControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getNumber(io.grpc.service.commandandcontrol.HelloRequest request,
        io.grpc.stub.StreamObserver<io.grpc.service.commandandcontrol.NumberResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNumberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class CommandAndControlBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommandAndControlBlockingStub> {
    private CommandAndControlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandAndControlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandAndControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public io.grpc.service.commandandcontrol.NumberResponse getNumber(io.grpc.service.commandandcontrol.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNumberMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class CommandAndControlFutureStub extends io.grpc.stub.AbstractFutureStub<CommandAndControlFutureStub> {
    private CommandAndControlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandAndControlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandAndControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.service.commandandcontrol.NumberResponse> getNumber(
        io.grpc.service.commandandcontrol.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNumberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_NUMBER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommandAndControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommandAndControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NUMBER:
          serviceImpl.getNumber((io.grpc.service.commandandcontrol.HelloRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.service.commandandcontrol.NumberResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommandAndControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommandAndControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.service.commandandcontrol.CommandAndControlProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommandAndControl");
    }
  }

  private static final class CommandAndControlFileDescriptorSupplier
      extends CommandAndControlBaseDescriptorSupplier {
    CommandAndControlFileDescriptorSupplier() {}
  }

  private static final class CommandAndControlMethodDescriptorSupplier
      extends CommandAndControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommandAndControlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommandAndControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommandAndControlFileDescriptorSupplier())
              .addMethod(getGetNumberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
