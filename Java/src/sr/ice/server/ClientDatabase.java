package sr.ice.server;

import Bank.Client;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClientDatabase {

    private static Map<String, String> passwords = new LinkedHashMap<String, String>();

    public static void addClientPassword(String id, String key){
        passwords.put(id, key);
    }

    public static boolean isValid(String id, String key){
        return passwords.get(id).equals(key);
    }

    public static String generateKey(String id){
        return String.valueOf(id.hashCode());
    }
}
