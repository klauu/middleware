package server;

import Bank.AuthenticationFailedException;
import Bank.Client;
import Bank.InvalidIDException;
import Bank.Standard;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class StandardAccount implements Standard {
    @Override
    public double getBalance(String id, Current current) throws InvalidIDException, AuthenticationFailedException {

        Client client = (Client) current.adapter.find(new Identity(id, "standard"));

        if(client == null){ throw new InvalidIDException("Account doesn't exist", id); }

        if(!ClientDatabase.isValid(id, current.ctx.get(id))){ throw new AuthenticationFailedException("Cannot authenticate the account", id); }

        return client.balance;
    }
}
