package server;

import Bank.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class ClientFactory implements Bank.ClientFactory{

    @Override
    public NewClientResponse newClient(UserData data, double balance, Current current) throws InvalidIDException {

        AccountType type = AccountType.STANDARD;
        String types = "standard";

        if (isPremium(data.monthlyIncome)) {
            type = AccountType.PREMIUM;
            types = "premium";
        }

        if (current.adapter.find(new Identity(data.id, types)) != null) {
            throw new InvalidIDException(data.id, "Account already exists");
        }

        Client client = new Client(data, type, balance);
        current.adapter.add(client, new Identity(client.data.id, types));

        String key = ClientDatabase.generateKey(data.id);

        ClientDatabase.addClientPassword(data.id, key);

        return new NewClientResponse(type, key);
    }


    private boolean isPremium(double income){
        if(income > 10000) return true;
        return false;
    }


}
