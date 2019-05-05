package server;

import Bank.Currency;
import Bank.InvalidCurrencyException;
import CurrencyPackage.CurrencyRatesStreamGrpc;
import CurrencyPackage.RatesRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CurrencyClient {

    private static Map<Currency, Double> currencyRates;

    private final ManagedChannel channel;

    private final CurrencyRatesStreamGrpc.CurrencyRatesStreamStub stub;

    public CurrencyClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        stub = CurrencyRatesStreamGrpc.newStub(channel);
        currencyRates = new LinkedHashMap<>();
    }

    public void run(List<Currency> currencies) {
        for (Currency c : currencies){
            runGetCurrencyRates(c.toString());
        }
    }

    public void runGetCurrencyRates(String cur)  {

        RatesRequest request = RatesRequest.newBuilder().setCur(cur).build();

        try {
            stub.getCurrencyRates(request, new MyStreamObserver<>());
        } catch (StatusRuntimeException ex) {
            System.err.println(ex);
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
        }

        @Override
        public void onError(Throwable t) {
            System.out.println("error");
        }

        @Override
        public void onCompleted() {
            System.out.println("Stream ended.");
        }
    }

}







