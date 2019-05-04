package sr.ice.server;

import Bank.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class PremiumAccount implements Premium {
    @Override
    public LoanResponse getLoan(LoanRequest request, Current current) throws InvalidCurrencyException, InvalidIDException {
        return null;
    }

    @Override
    public double getBalance(String id, Current current) throws InvalidIDException {

        System.out.println(current.ctx.get("1234"));

        Client client = (Client) current.adapter.find(new Identity(id, "premium"));

        if (client == null){
            throw new InvalidIDException(id, "account doesn't exist");
        }

        return client.balance;
    }
}
