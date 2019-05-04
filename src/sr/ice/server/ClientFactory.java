package sr.ice.server;

import Bank.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class ClientFactory implements Bank.ClientFactory{

    @Override
    public Client newClient(UserData data, double balance, Current current) throws InvalidIDException {

        AccountType type = AccountType.STANDARD;
        String types = "standard";

        Client client;

        if (data.monthlyIncome > 10000) {
            type = AccountType.PREMIUM;
            types = "premium";
        }

        if (current.adapter.find(new Identity(data.id, types)) != null) {
            throw new InvalidIDException(data.id, "account already exists");
        }

        client = new Client(data, type, balance);
        current.adapter.add(client, new Identity(client.data.id, types));

        return client;

        //  return ClientFactoryPrx.uncheckedCast(current.adapter.add(new Client(data, type, balance), new Identity(data.id, types)));
    }


}
