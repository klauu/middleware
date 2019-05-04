package server;

import Bank.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class PremiumAccount implements Premium {
    @Override
    public LoanResponse getLoan(LoanRequest request, Current current) throws InvalidCurrencyException, InvalidIDException {
        //TODO
        return null;
    }

    @Override
    public double getBalance(String id, Current current) throws InvalidIDException, AuthenticationFailedException {

        Client client = (Client) current.adapter.find(new Identity(id, "premium"));

        if(client == null){ throw new InvalidIDException("Account doesn't exist", id); }

        if(!ClientDatabase.isValid(id, current.ctx.get(id))){ throw new AuthenticationFailedException("Cannot authenticate the account", id); }

        return client.balance;
    }
}
