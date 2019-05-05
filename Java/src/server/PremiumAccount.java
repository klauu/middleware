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

        //czy waluta jest obsługiwana przez bank -> Invalid Currency Exception

        //pobieramy kurs dla danej waluty

        //wyliczamy na podstawie kursu, czasu i kwoty

        //new LoanResponse(...)

        System.out.println(request.cur);
        System.out.println(request.id);
        System.out.println(request.amount);
        System.out.println(request.time);

        LoanResponse resp = new LoanResponse( true, 12,12);
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
