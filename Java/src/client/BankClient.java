package client;
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

import java.util.LinkedHashMap;
import java.util.Map;

public class BankClient
{
	public static void main(String[] args) 
	{
		int status = 0;
		Communicator communicator = null;

		try {
			communicator = Util.initialize(args);

			ObjectPrx factoryBase = communicator.stringToProxy("factory/fact1:tcp -h localhost -p 10000:udp -h localhost -p 10000");

            ObjectPrx standardBase = communicator.stringToProxy("accountManager/standard:tcp -h localhost -p 10000:udp -h localhost -p 10000");

            ObjectPrx premiumBase = communicator.stringToProxy("accountManager/premium:tcp -h localhost -p 10000:udp -h localhost -p 10000");

			ClientFactoryPrx factory = ClientFactoryPrx.checkedCast(factoryBase);
			if (factory == null) throw new Error("Invalid proxy");

            StandardPrx standard = StandardPrx.checkedCast(standardBase);
            if (standard == null) throw new Error("Invalid proxy");

            PremiumPrx premium = PremiumPrx.checkedCast(premiumBase);
            if (premium == null) throw new Error("Invalid proxy");

			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

			do{
				try{
					System.out.print(">> ");
					System.out.flush();
					line = in.readLine();
					if (line == null) {
						break;
					}
					else if (line.replace(" ","").equalsIgnoreCase("newclient")){

                        System.out.println("Type in: name surname pesel monthly_income initial_balance");
					    line = in.readLine();
					    String [] elems = line.split( " ");


					    if(elems.length == 5){
                            if(isPeselValid(elems[2])){
                                NewClientResponse resp = factory.newClient(new UserData(elems[0], elems[1], elems[2], Double.valueOf(elems[3] )), Double.valueOf(elems[4]));

                                System.out.println("Type: " + resp.type);
                                System.out.println("Key: " + resp.key);
                            }else{
                                System.out.println("Given ID is not valid - must be 11 digit long number");
                            }
                        }else{
                            System.out.println("Wrong number of arguments.\nTry again.");
                        }
					}
                    else if (line.replace(" ","").equalsIgnoreCase("balance")){
                        System.out.println("Type in: pesel account_type");

                        line = in.readLine();
                        String [] elems = line.split( " ");

                        if(elems.length != 2){
                            System.out.println("Wrong number of arguments.");
                        }
                        else{
                            System.out.println("Type your key: ");
                            String key = in.readLine();

                            Map<String, String> map = new LinkedHashMap<String, String>();
                            map.put(elems[0], key);

                            if(elems[1].equals("standard")){
                                standard = standard.ice_context(map);
                                try{
                                    System.out.println(standard.getBalance(elems[0]));
                                }catch (InvalidIDException | AuthenticationFailedException e){
                                    System.err.println(e.msg);
                                }
                            }else if(elems[1].equals("premium")){
                                premium = premium.ice_context(map);
                                try{
                                    System.out.println(premium.getBalance(elems[0]));
                                }catch (InvalidIDException | AuthenticationFailedException e){
                                    System.err.println(e.msg);
                                }
                            }else{
                                System.out.println("Wrong account type.");
                            }
                        }
                    }
                    else if (line.replace(" ","").equalsIgnoreCase("help")){
                        System.out.println("Available operations: \nnew client\nbalance\nloan\nhelp\nquit");
                    }
                    else if (line.replace(" ","").equalsIgnoreCase("loan")){

                        System.out.println("Type in: pesel currency amount time(in months)");
                        line = in.readLine();
                        String [] elems = line.split( " ");

                        if(elems.length == 4){

                            System.out.println("Type your key: ");
                            String key = in.readLine();

                            Map<String, String> map = new LinkedHashMap<String, String>();
                            map.put(elems[0], key);
                            premium = premium.ice_context(map);

                            Currency cur = null;

                            boolean currFlag = false;
                            try{
                                cur = Currency.valueOf(elems[1]);
                            }catch (IllegalArgumentException e){
                                currFlag = true;
                            }

                            if(currFlag){
                                System.out.println("No such currency.");
                            }else{
                                try{
                                    LoanResponse resp = premium.getLoan(new LoanRequest(elems[0], cur, Double.valueOf(elems[2]), Integer.valueOf(elems[3])));
                                    if(resp.agreed){
                                        System.out.println("Bank agreed to give You a loan.");
                                        System.out.println("Cost in foreign currency: " + resp.ForeignCurrency);
                                        System.out.println("Cost in native currency: " + resp.NativeCurrency);
                                    }
                                    else{
                                        System.out.println("Bank didn't agree to give You a loan. Sorry.");
                                    }
                                }catch (AuthenticationFailedException | InvalidIDException | InvalidCurrencyException e){
                                    System.err.println(e.msg);
                                }
                            }


                        }else{
                            System.out.println("Wrong number of arguments.\nTry again.");
                        }

                    }
                    else if (line.replace(" ","").equalsIgnoreCase("quit")) {
                        System.out.println("Thanks for using our application.");
                    }
                    else System.out.println("No such operation. Type help to see available operations.");
				}
				catch (java.io.IOException ex){
					System.err.println(ex);
				}
			}while (!line.equals("quit"));
		} catch (LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (communicator != null) {
			try {
				communicator.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}


	private static boolean isPeselValid(String id){
	    return id.replace(" ", "").length() == 4;
    }

}