package CurrencyPackage;

import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.processing.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: Currency.proto")
public final class CurrencyRatesStreamGrpc {

  private CurrencyRatesStreamGrpc() {}

  public static final String SERVICE_NAME = "Currency.CurrencyRatesStream";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CurrencyPackage.RatesRequest,
      CurrencyPackage.RatesRespond> METHOD_GET_CURRENCY_RATES =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "Currency.CurrencyRatesStream", "GetCurrencyRates"),
          io.grpc.protobuf.ProtoUtils.marshaller(CurrencyPackage.RatesRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(CurrencyPackage.RatesRespond.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrencyRatesStreamStub newStub(io.grpc.Channel channel) {
    return new CurrencyRatesStreamStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyRatesStreamBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrencyRatesStreamBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyRatesStreamFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrencyRatesStreamFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrencyRatesStreamImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCurrencyRates(CurrencyPackage.RatesRequest request,
                                 io.grpc.stub.StreamObserver<CurrencyPackage.RatesRespond> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_CURRENCY_RATES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_CURRENCY_RATES,
            asyncServerStreamingCall(
              new MethodHandlers<
                CurrencyPackage.RatesRequest,
                CurrencyPackage.RatesRespond>(
                  this, METHODID_GET_CURRENCY_RATES)))
          .build();
    }
  }

  /**
   */
  public static final class CurrencyRatesStreamStub extends io.grpc.stub.AbstractStub<CurrencyRatesStreamStub> {
    private CurrencyRatesStreamStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesStreamStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesStreamStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesStreamStub(channel, callOptions);
    }

    /**
     */
    public void getCurrencyRates(CurrencyPackage.RatesRequest request,
                                 io.grpc.stub.StreamObserver<CurrencyPackage.RatesRespond> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_CURRENCY_RATES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CurrencyRatesStreamBlockingStub extends io.grpc.stub.AbstractStub<CurrencyRatesStreamBlockingStub> {
    private CurrencyRatesStreamBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesStreamBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesStreamBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesStreamBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<CurrencyPackage.RatesRespond> getCurrencyRates(
            CurrencyPackage.RatesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_CURRENCY_RATES, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CurrencyRatesStreamFutureStub extends io.grpc.stub.AbstractStub<CurrencyRatesStreamFutureStub> {
    private CurrencyRatesStreamFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesStreamFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesStreamFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesStreamFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_CURRENCY_RATES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrencyRatesStreamImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrencyRatesStreamImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENCY_RATES:
          serviceImpl.getCurrencyRates((CurrencyPackage.RatesRequest) request,
              (io.grpc.stub.StreamObserver<CurrencyPackage.RatesRespond>) responseObserver);
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

  private static final class CurrencyRatesStreamDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CurrencyPackage.CurrencyProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CurrencyRatesStreamGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrencyRatesStreamDescriptorSupplier())
              .addMethod(METHOD_GET_CURRENCY_RATES)
              .build();
        }
      }
    }
    return result;
  }
}
