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

        double rate = CurrencyClient.getCurrencyRate(request.cur);

        System.out.println("Currency rate: " + rate);

        boolean agreed = true;

        if(request.time < 12 || request.time > 120) agreed = false;
        else if(request.amount < 5000 || request.amount > 1000000) agreed = false;

        LoanResponse resp = null;
        if(agreed){
            resp = new LoanResponse( true, 1.06 * request.amount,1.06 * request.amount * rate);
            System.out.println("Bank agreed to give a loan");
        }else{
            resp = new LoanResponse( false, 0,0);
            System.out.println("Bank didn't agree to give a loan");
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
