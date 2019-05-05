package server;
// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Bank.*;
import com.zeroc.Ice.*;

import java.lang.Exception;

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

            System.out.println("Ready to work");

            CurrencyClient currencyClient = new CurrencyClient("localhost", 50051);
            currencyClient.run();

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
