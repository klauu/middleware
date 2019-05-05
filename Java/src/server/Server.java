package server;

import Bank.*;
import com.zeroc.Ice.*;

import java.lang.Exception;
import java.util.LinkedList;
import java.util.List;

public class Server
{
	public void run(String[] args){

	    int status = 0;
	    Communicator communicator = null;
        try
        {
            communicator = Util.initialize(args);

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h localhost -p 10000:udp -h localhost -p 10000");

            server.ClientFactory factory = new server.ClientFactory();
            Standard standard = new StandardAccount();
            Premium premium = new PremiumAccount();

            adapter.add(factory, new Identity("fact1", "factory"));
            adapter.add(standard, new Identity("standard", "accountManager"));
            adapter.add(premium, new Identity("premium", "accountManager"));

            adapter.activate();

            System.out.println("Type in currency codes spearated by space: ");

            List<Currency> cur = new LinkedList<>();
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            String line = in.readLine();
            String[] list = line.split(" ");

            for(String elem : list){
                try{
                    Currency c = Currency.valueOf(elem);
                    cur.add(c);
                }catch (IllegalArgumentException e){  }
            }

            CurrencyClient currencyClient = new CurrencyClient("localhost", 50051);
            currencyClient.run(cur);

            communicator.waitForShutdown();
        }
        catch (Exception e)
        {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null){
            try{
                communicator.destroy();
            }
            catch (Exception e){
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
	}

	public static void main(String[] args)
	{
		Server app = new Server();
		app.run(args);
	}
}
