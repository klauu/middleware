package server;


import Bank.Currency;
import Bank.InvalidCurrencyException;
import CurrencyPackage.CurrencyRatesStreamGrpc;
import CurrencyPackage.RatesRequest;
import CurrencyPackage.RatesRespond;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrencyClient {

    private static Map<Currency, Double> currencyRates;

    private static final Logger logger = Logger.getLogger(CurrencyClient.class.getName());

    private final ManagedChannel channel;

    private final CurrencyRatesStreamGrpc.CurrencyRatesStreamStub stub;

    public CurrencyClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid needing certificates.
                .usePlaintext(true)
                .build();

        stub = CurrencyRatesStreamGrpc.newStub(channel);
        currencyRates = new LinkedHashMap<>();
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void run(List<Currency> currencies) {

        for (Currency c : currencies){
            runGetCurrencyRates(c.toString());
        }
        //System.out.println(currencies);
        //TODO for each currency in list
        //sprawdzamy czy należą do enuma
      //  runGetCurrencyRates("EUR");
       // runGetCurrencyRates("GBP");
    }

    public void runGetCurrencyRates(String cur)  {

        RatesRequest request = RatesRequest.newBuilder().setCur(cur).build();

        try {
            stub.getCurrencyRates(request, new MyStreamObserver<>());
        } catch (StatusRuntimeException ex) {
            System.out.println("exception");
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());

        }

    }

    public static double getCurrencyRate(Currency cur) throws InvalidCurrencyException{
        if(!currencyRates.containsKey(cur)) throw new InvalidCurrencyException("Currency isn't available in the Bank", cur);
        return currencyRates.get(cur);
    }

    class MyStreamObserver<RatesRespond> implements StreamObserver<RatesRespond> {

        @Override
        public void onNext(RatesRespond ratesRespond) {
            String c = ((CurrencyPackage.RatesRespond)ratesRespond).getCur();
            double val = ((CurrencyPackage.RatesRespond)ratesRespond).getValue();

            System.out.println(c + ": " + val);

            currencyRates.put(Currency.valueOf(c), val);
           // currencyRates.put(Currency.valueOf(((CurrencyPackage.RatesRespond)ratesRespond).getCur()), ((CurrencyPackage.RatesRespond)ratesRespond).getValue());
            //System.out.println(((CurrencyPackage.RatesRespond)ratesRespond).getCur() + ": " +  ((CurrencyPackage.RatesRespond)ratesRespond).getValue());
        }

        @Override
        public void onError(Throwable t) {
            System.out.println("ON ERROR");
        }

        @Override
        public void onCompleted() {
            System.out.println("END ");
        }
    }

}







