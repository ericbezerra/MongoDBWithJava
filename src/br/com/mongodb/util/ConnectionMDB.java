package br.com.mongodb.util;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnectionMDB {

    private final MongoClient client;
    private final DB db;
    private final String url = "localhost";
    private final int port = 27017;

    @SuppressWarnings("deprecation")
    public ConnectionMDB(String database){
        client = new MongoClient(url, port);
        
        db = client.getDB(database);
        System.out.println(client);

    }

    public MongoClient getClient() {
        return client;
    }

    public DB getDb() {
        return db;
    }
    
}
