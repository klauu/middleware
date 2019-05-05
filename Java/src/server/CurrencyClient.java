package server;


import CurrencyPackage.CurrencyRatesStreamGrpc;
import CurrencyPackage.RatesRequest;
import CurrencyPackage.RatesRespond;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyClient {

   // public static double euroValue = 0;

    private static final Logger logger = Logger.getLogger(CurrencyClient.class.getName());

    private final ManagedChannel channel;

    private final CurrencyRatesStreamGrpc.CurrencyRatesStreamStub stub;

    public CurrencyClient(String host, int port) {
        System.out.println("start constructor");
        channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid needing certificates.
                .usePlaintext(true)
                .build();

        stub = CurrencyRatesStreamGrpc.newStub(channel);
        System.out.println("end constructor");
    }

  //  public static void main(String[] args) throws Exception {
   //     CurrencyClient client = new CurrencyClient("localhost", 50051);
    //    client.run();
    //}

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void run() {
        runGetCurrencyRates("EUR");
    }

    public void runGetCurrencyRates(String cur) {
        System.out.println("runCurrencyRates");

        //TODO dla każdej waluty
        RatesRequest request = RatesRequest.newBuilder().setCur(cur).build();

     //   Iterator<RatesRespond> values;
        try {
            System.out.println("stub1");
            stub.getCurrencyRates(request, new MyStreamObserver<>());
           // while (values.hasNext()) {
            //    euroValue = values.next().getValue();
           // }
            System.out.println("stub2");

        } catch (StatusRuntimeException ex) {
            System.out.println("exception");
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());

        }

    }

    class MyStreamObserver<RatesRespond> implements StreamObserver<RatesRespond> {

        @Override
        public void onNext(RatesRespond ratesRespond) {
            System.out.println("asdasd");
            System.out.println(((CurrencyPackage.RatesRespond)ratesRespond).getValue());
        }

        @Override
        public void onError(Throwable t) {
            System.out.println("ON ERROR");
        }

        @Override
        public void onCompleted() {
            // responseObserver.onNext(Report.newBuilder().setCount(count).build());
            // responseObserver.onCompleted();
            System.out.println("END ");
        }
    }

}







