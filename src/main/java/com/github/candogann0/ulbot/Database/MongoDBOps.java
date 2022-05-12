package com.github.candogann0.ulbot.Database;

import com.github.candogann0.ulbot.Config;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBOps {

    private static MongoDBOps instance;
    private final MongoClient mongoClient;

    private MongoDBOps() {
        mongoClient = MongoClients.create(getConnectionSettings());
    }

    public MongoClientSettings getConnectionSettings() {

        ConnectionString connectionString = new ConnectionString(Config.get("DATABASE_URI"));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .applyToSslSettings(builder -> builder.enabled(true))
                .build();

        return settings;
    }

    public static MongoDBOps getInstance() {
        if (instance == null)
            instance = new MongoDBOps();
        return instance;
    }

    public MongoCollection<Document> getCollection(String collection) {
        MongoDatabase database = mongoClient.getDatabase("Servers");
        return database.getCollection(collection);
    }

}
