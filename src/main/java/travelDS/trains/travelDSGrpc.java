package travelDS.trains;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: trains.proto")
public class travelDSGrpc {

  public travelDSGrpc() {}

  public static final String SERVICE_NAME = "travelDS.travelDS";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<travelDS.trains.trainNumber,
      travelDS.trains.trainTimetable> getGetTimetableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTimetable",
      requestType = travelDS.trains.trainNumber.class,
      responseType = travelDS.trains.trainTimetable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<travelDS.trains.trainNumber,
      travelDS.trains.trainTimetable> getGetTimetableMethod() {
    io.grpc.MethodDescriptor<travelDS.trains.trainNumber, travelDS.trains.trainTimetable> getGetTimetableMethod;
    if ((getGetTimetableMethod = travelDSGrpc.getGetTimetableMethod) == null) {
      synchronized (travelDSGrpc.class) {
        if ((getGetTimetableMethod = travelDSGrpc.getGetTimetableMethod) == null) {
          travelDSGrpc.getGetTimetableMethod = getGetTimetableMethod = 
              io.grpc.MethodDescriptor.<travelDS.trains.trainNumber, travelDS.trains.trainTimetable>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "travelDS.travelDS", "getTimetable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainTimetable.getDefaultInstance()))
                  .setSchemaDescriptor(new travelDSMethodDescriptorSupplier("getTimetable"))
                  .build();
          }
        }
     }
     return getGetTimetableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<travelDS.trains.trainSpecific,
      travelDS.trains.trainAmount> getSeeBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "seeBus",
      requestType = travelDS.trains.trainSpecific.class,
      responseType = travelDS.trains.trainAmount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<travelDS.trains.trainSpecific,
      travelDS.trains.trainAmount> getSeeBusMethod() {
    io.grpc.MethodDescriptor<travelDS.trains.trainSpecific, travelDS.trains.trainAmount> getSeeBusMethod;
    if ((getSeeBusMethod = travelDSGrpc.getSeeBusMethod) == null) {
      synchronized (travelDSGrpc.class) {
        if ((getSeeBusMethod = travelDSGrpc.getSeeBusMethod) == null) {
          travelDSGrpc.getSeeBusMethod = getSeeBusMethod = 
              io.grpc.MethodDescriptor.<travelDS.trains.trainSpecific, travelDS.trains.trainAmount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "travelDS.travelDS", "seeBus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainSpecific.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainAmount.getDefaultInstance()))
                  .setSchemaDescriptor(new travelDSMethodDescriptorSupplier("seeBus"))
                  .build();
          }
        }
     }
     return getSeeBusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<travelDS.trains.trainNumber,
      travelDS.trains.trainDelete> getDeleteBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteBus",
      requestType = travelDS.trains.trainNumber.class,
      responseType = travelDS.trains.trainDelete.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<travelDS.trains.trainNumber,
      travelDS.trains.trainDelete> getDeleteBusMethod() {
    io.grpc.MethodDescriptor<travelDS.trains.trainNumber, travelDS.trains.trainDelete> getDeleteBusMethod;
    if ((getDeleteBusMethod = travelDSGrpc.getDeleteBusMethod) == null) {
      synchronized (travelDSGrpc.class) {
        if ((getDeleteBusMethod = travelDSGrpc.getDeleteBusMethod) == null) {
          travelDSGrpc.getDeleteBusMethod = getDeleteBusMethod = 
              io.grpc.MethodDescriptor.<travelDS.trains.trainNumber, travelDS.trains.trainDelete>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "travelDS.travelDS", "deleteBus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainNumber.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  travelDS.trains.trainDelete.getDefaultInstance()))
                  .setSchemaDescriptor(new travelDSMethodDescriptorSupplier("deleteBus"))
                  .build();
          }
        }
     }
     return getDeleteBusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static travelDSStub newStub(io.grpc.Channel channel) {
    return new travelDSStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static travelDSBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new travelDSBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static travelDSFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new travelDSFutureStub(channel);
  }

  /**
   */
  public static abstract class travelDSImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *get train timetables
     * </pre>
     */
    public void getTimetable(travelDS.trains.trainNumber request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainTimetable> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTimetableMethod(), responseObserver);
    }

    /**
     * <pre>
     *seeing all trains out on specific train journey
     * </pre>
     */
    public void seeBus(travelDS.trains.trainSpecific request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainAmount> responseObserver) {
      asyncUnimplementedUnaryCall(getSeeBusMethod(), responseObserver);
    }

    /**
     * <pre>
     *delete trains
     * </pre>
     */
    public void deleteBus(travelDS.trains.trainNumber request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainDelete> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTimetableMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                travelDS.trains.trainNumber,
                travelDS.trains.trainTimetable>(
                  this, METHODID_GET_TIMETABLE)))
          .addMethod(
            getSeeBusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                travelDS.trains.trainSpecific,
                travelDS.trains.trainAmount>(
                  this, METHODID_SEE_BUS)))
          .addMethod(
            getDeleteBusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                travelDS.trains.trainNumber,
                travelDS.trains.trainDelete>(
                  this, METHODID_DELETE_BUS)))
          .build();
    }
  }

  /**
   */
  public static final class travelDSStub extends io.grpc.stub.AbstractStub<travelDSStub> {
    private travelDSStub(io.grpc.Channel channel) {
      super(channel);
    }

    private travelDSStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected travelDSStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new travelDSStub(channel, callOptions);
    }

    /**
     * <pre>
     *get train timetables
     * </pre>
     */
    public void getTimetable(travelDS.trains.trainNumber request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainTimetable> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTimetableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *seeing all trains out on specific train journey
     * </pre>
     */
    public void seeBus(travelDS.trains.trainSpecific request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainAmount> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSeeBusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *delete trains
     * </pre>
     */
    public void deleteBus(travelDS.trains.trainNumber request,
        io.grpc.stub.StreamObserver<travelDS.trains.trainDelete> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class travelDSBlockingStub extends io.grpc.stub.AbstractStub<travelDSBlockingStub> {
    private travelDSBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private travelDSBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected travelDSBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new travelDSBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *get train timetables
     * </pre>
     */
    public travelDS.trains.trainTimetable getTimetable(travelDS.trains.trainNumber request) {
      return blockingUnaryCall(
          getChannel(), getGetTimetableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *seeing all trains out on specific train journey
     * </pre>
     */
    public travelDS.trains.trainAmount seeBus(travelDS.trains.trainSpecific request) {
      return blockingUnaryCall(
          getChannel(), getSeeBusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *delete trains
     * </pre>
     */
    public travelDS.trains.trainDelete deleteBus(travelDS.trains.trainNumber request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class travelDSFutureStub extends io.grpc.stub.AbstractStub<travelDSFutureStub> {
    private travelDSFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private travelDSFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected travelDSFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new travelDSFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *get train timetables
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<travelDS.trains.trainTimetable> getTimetable(
        travelDS.trains.trainNumber request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTimetableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *seeing all trains out on specific train journey
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<travelDS.trains.trainAmount> seeBus(
        travelDS.trains.trainSpecific request) {
      return futureUnaryCall(
          getChannel().newCall(getSeeBusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *delete trains
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<travelDS.trains.trainDelete> deleteBus(
        travelDS.trains.trainNumber request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TIMETABLE = 0;
  private static final int METHODID_SEE_BUS = 1;
  private static final int METHODID_DELETE_BUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final travelDSImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(travelDSImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TIMETABLE:
          serviceImpl.getTimetable((travelDS.trains.trainNumber) request,
              (io.grpc.stub.StreamObserver<travelDS.trains.trainTimetable>) responseObserver);
          break;
        case METHODID_SEE_BUS:
          serviceImpl.seeBus((travelDS.trains.trainSpecific) request,
              (io.grpc.stub.StreamObserver<travelDS.trains.trainAmount>) responseObserver);
          break;
        case METHODID_DELETE_BUS:
          serviceImpl.deleteBus((travelDS.trains.trainNumber) request,
              (io.grpc.stub.StreamObserver<travelDS.trains.trainDelete>) responseObserver);
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

  private static abstract class travelDSBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    travelDSBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return travelDS.trains.travelDSServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("travelDS");
    }
  }

  private static final class travelDSFileDescriptorSupplier
      extends travelDSBaseDescriptorSupplier {
    travelDSFileDescriptorSupplier() {}
  }

  private static final class travelDSMethodDescriptorSupplier
      extends travelDSBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    travelDSMethodDescriptorSupplier(String methodName) {
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
      synchronized (travelDSGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new travelDSFileDescriptorSupplier())
              .addMethod(getGetTimetableMethod())
              .addMethod(getSeeBusMethod())
              .addMethod(getDeleteBusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
