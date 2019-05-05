package currency;

import Bank.Currency;
import CurrencyPackage.CurrencyRatesStreamGrpc;
import CurrencyPackage.RatesRespond;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class CurrencyRatesStreamImpl extends CurrencyRatesStreamGrpc.CurrencyRatesStreamImplBase {

    private Map<CurrencyRatesServer.Cur, Double> currencies;
    private Random random;

    public CurrencyRatesStreamImpl(){
        currencies = new LinkedHashMap<>();
        random = new Random();
        initMap();
    }

    @Override
    public void getCurrencyRates(CurrencyPackage.RatesRequest request,
                                 io.grpc.stub.StreamObserver<CurrencyPackage.RatesRespond> responseObserver){
        System.out.println("Get currency rates");
        System.out.println("Currency: " + request.getCur());

        boolean flag = true;
        CurrencyRatesServer.Cur cur = null;
        try{
           cur = CurrencyRatesServer.Cur.valueOf(request.getCur());
        } catch (IllegalArgumentException e){
            flag = false;
            //TODO rzucanie wyjątkiem?
        }

        while(flag){
            RatesRespond resp = RatesRespond.newBuilder().setValue(getCurrencyRate(cur)).setCur(request.getCur()).build();
            responseObserver.onNext(resp);
            try { Thread.sleep(5000); } catch(java.lang.InterruptedException ex) { }
        }
        responseObserver.onCompleted();
    }

    private double getCurrencyRate(CurrencyRatesServer.Cur currency){
         return currencies.get(currency) + (random.nextDouble()/10.0 - 0.05);
    }

    private void initMap(){
        currencies.put(CurrencyRatesServer.Cur.EUR, 4.2795);
        currencies.put(CurrencyRatesServer.Cur.USD, 3.8177);
        currencies.put(CurrencyRatesServer.Cur.GBP, 4.9840);
        currencies.put(CurrencyRatesServer.Cur.JPY, 0.0342);
        currencies.put(CurrencyRatesServer.Cur.CAN, 2.8402);
        currencies.put(CurrencyRatesServer.Cur.CHF, 3.7480);
        currencies.put(CurrencyRatesServer.Cur.HKD, 0.4867);
        currencies.put(CurrencyRatesServer.Cur.NZD, 2.5324);
    }
}
