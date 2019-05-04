package sr.ice.client;
// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Bank.*;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.LocalException;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BankClient
{
	public static void main(String[] args) 
	{
		int status = 0;
		Communicator communicator = null;

		try {
			// 1. Inicjalizacja ICE
			communicator = Util.initialize(args);

			// 2. Uzyskanie referencji obiektu na podstawie linii w pliku konfiguracyjnym
			//Ice.ObjectPrx base = communicator.propertyToProxy("Calc1.Proxy");
			// 2. To samo co powy¿ej, ale mniej ³adnie
			ObjectPrx factoryBase = communicator.stringToProxy("factory/fact1:tcp -h localhost -p 10000:udp -h localhost -p 10000");

            ObjectPrx standardBase = communicator.stringToProxy("accountManager/standard:tcp -h localhost -p 10000:udp -h localhost -p 10000");

            ObjectPrx premiumBase = communicator.stringToProxy("accountManager/premium:tcp -h localhost -p 10000:udp -h localhost -p 10000");

            // 3. Rzutowanie, zawê¿anie
			ClientFactoryPrx factory = ClientFactoryPrx.checkedCast(factoryBase);
			if (factory == null) throw new Error("Invalid proxy");

            StandardPrx standard = StandardPrx.checkedCast(standardBase);
            if (standard == null) throw new Error("Invalid proxy");

            PremiumPrx premium = PremiumPrx.checkedCast(premiumBase);
            if (premium == null) throw new Error("Invalid proxy");


		//	ClientFactoryPrx objOneway = (ClientFactoryPrx)obj.ice_oneway();
	//		ClientFactoryPrx objBatchOneway = (ClientFactoryPrx)obj.ice_batchOneway();//
	//		ClientFactoryPrx objDatagram = (ClientFactoryPrx)obj.ice_datagram();
	//		ClientFactoryPrx objBatchDatagram = (ClientFactoryPrx)obj.ice_batchDatagram();

			// 4. Wywolanie zdalnych operacji




			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			//CompletableFuture<Long> cfl = null;
			do{
				try{
					System.out.print("==> ");
					System.out.flush();
					line = in.readLine();
					if (line == null) {
						break;
					}
					if (line.equals("new client")){

                        System.out.println("name surname pesel monthly_income initial_balance");
					    line = in.readLine();
					    String [] arguments = line.split( " ");

                        Client client = factory.newClient(new UserData(arguments[0], arguments[1], arguments[2], Integer.parseInt(arguments[3] )), Integer.parseInt(arguments[4]));

                        System.out.println(client.type);
					}
                    if (line.equals("balance")){
                        System.out.println("pesel key account_type");

                        line = in.readLine();
                        String [] arguments = line.split( " ");

                        if(arguments[2].equals("standard")){
                            Map<String, String> map = new LinkedHashMap<String, String>();
                            map.put(arguments[0], arguments[1]);
                            standard = standard.ice_context(map);

                            System.out.println(standard.getBalance(arguments[0]));
                        }

                        if(arguments[2].equals("premium")){
                            Map<String, String> map = new LinkedHashMap<String, String>();
                            map.put(arguments[0], arguments[1]);
                            premium = premium.ice_context(map);
                            System.out.println(premium.getBalance(arguments[0]));
                        }

                    }





					/*if (line.equals("add-with-ctx"))
					{
						Map<String,String> map = new HashMap<String, String>();
						map.put("key1", "val1");
						map.put("key2", "val2");
						long r = obj.add(7, 8, map);
						System.out.println("RESULT = " + r);
					}
					if (line.equals("subtract"))
					{
						long r = obj.subtract(7, 8);
						System.out.println("RESULT = " + r);
					}
					if (line.equals("add-asyn1")) //efekt jak dla callback
					{
						cfl = obj.addAsync(7000, 8000).whenComplete((result, ex) ->
						{
							System.out.println("RESULT (asyn) = " + result);
						});
					}
					if (line.equals("add-asyn2")) //zlecenie wywo³ania
					{
						cfl = obj.addAsync(7000, 8000);
					}
					if (line.equals("add-asyn2-res")) //odebranie wyniku
					{
						long r = cfl.join();
						System.out.println("RESULT = " + r);
					}
	                /*else if(line.equals("o"))
	                {
	                    objOneway.add(7,8);
	                }
	                else if(line.equals("O"))
	                {
	                    objBatchOneway.add(7, 8);
	                }
	                else if(line.equals("d"))
	                {
	                    objDatagram.add(7, 8);
	                }
	                else if(line.equals("D"))
	                {
	                    objBatchDatagram.add(7, 8);
	                }*/
					/*
					else if (line.equals("x"))
					{
						// Nothing to do
					}*/
				}
				catch (java.io.IOException ex){
					System.err.println(ex);
				}
			}while (!line.equals("x"));


		} catch (LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (communicator != null) {
			// Clean up
			//
			try {
				communicator.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}

}