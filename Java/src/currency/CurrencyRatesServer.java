package currency;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CurrencyRatesServer {

    private Server server;

    private void start() throws IOException
    {
        server = ServerBuilder.forPort(50051)
                .addService(new CurrencyRatesStreamImpl())
                .build()
                .start();

        System.out.println("Server is ready.");
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final CurrencyRatesServer server = new CurrencyRatesServer();
        server.start();
        server.blockUntilShutdown();
    }

    enum Cur{
        JPY, GBP, USD, EUR, CAN, CHF, HKD, SEK, NZD
    }
}