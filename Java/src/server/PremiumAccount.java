package server;

import Bank.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class PremiumAccount implements Premium {
    @Override
    public LoanResponse getLoan(LoanRequest request, Current current) throws InvalidCurrencyException, InvalidIDException, AuthenticationFailedException {

        Client client = (Client) current.adapter.find(new Identity(request.id, "premium"));

        if(client == null){ throw new InvalidIDException("Account doesn't exist", request.id); }

        if(!ClientDatabase.isValid(request.id, current.ctx.get(request.id))){ throw new AuthenticationFailedException("Cannot authenticate the account", request.id); }

        double rate = 0;
        //try{
            rate = CurrencyClient.getCurrencyRate(request.cur);
        //}catch (Exception e){
           // throw new InvalidCurrencyException("Currency isn't available in the Bank", request.cur);
       // }

        System.out.println("Kurs danej waluty: " + rate);


        //wyliczamy na podstawie kursu, czasu i kwoty

        //new LoanResponse(...)

        boolean agreed = true;

        if(request.time < 12 || request.time > 120) agreed = false;
        else if(request.amount < 5000 || request.amount > 100000) agreed = false;




    //    System.out.println(request.cur);
    //    System.out.println(request.id);
     //   System.out.println(request.amount);
      //  System.out.println(request.time);

        LoanResponse resp = null;
        if(agreed){
            resp = new LoanResponse( agreed, 0.06 * request.amount,1.06 * request.amount * rate);
        }else{
            resp = new LoanResponse( agreed, 0,0);
        }


        return resp;
    }

    @Override
    public double getBalance(String id, Current current) throws InvalidIDException, AuthenticationFailedException {

        Client client = (Client) current.adapter.find(new Identity(id, "premium"));

        if(client == null){ throw new InvalidIDException("Account doesn't exist", id); }

        if(!ClientDatabase.isValid(id, current.ctx.get(id))){ throw new AuthenticationFailedException("Cannot authenticate the account", id); }

        return client.balance;
    }
}
