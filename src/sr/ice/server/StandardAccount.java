package sr.ice.server;

import Bank.Client;
import Bank.InvalidIDException;
import Bank.Standard;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class StandardAccount implements Standard {
    @Override
    public double getBalance(String id, Current current) throws InvalidIDException {

        System.out.println(current.ctx);

        Client client = (Client) current.adapter.find(new Identity(id, "standard"));

        if (client == null){
            throw new InvalidIDException(id, "account doesn't exist");
        }

        return client.balance;
    }
}
