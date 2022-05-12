package com.github.candogann0.ulbot.Database;

import com.github.candogann0.ulbot.Bot;
import com.github.candogann0.ulbot.Config;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.lang.reflect.Array;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static com.github.candogann0.ulbot.UlBot.bot;
import static com.github.candogann0.ulbot.UlBot.log;


public class DatabaseCore {


    public String serverCollection(String id) {
        String sid = "server "+ id;
        return sid;
    }
    public boolean isIdInside(User user, Guild g) {

        ArrayList<Document> documentArrayList = MongoDBOps.getInstance().getCollection(serverCollection(g.getId()))
                .find(Filters.in("id", user.getId())).into(new ArrayList<>());
        if (documentArrayList.size() > 0) {
            MongoCollection coll = MongoDBOps.getInstance().getCollection(serverCollection(g.getId()));
            return true;
        }
        return false;
    }

    public void counterIncrease(User user, Guild g) {
        ArrayList<Document> documentArrayList = MongoDBOps.getInstance().getCollection(serverCollection(g.getId()))
                .find(Filters.in("id", user.getId())).into(new ArrayList<>());
        if (documentArrayList.size() > 0) {
            MongoCollection coll = MongoDBOps.getInstance().getCollection(serverCollection(g.getId()));
            Document d = documentArrayList.get(0);

            int c = (int)d.get("counter");
            d.replace("counter", ++c);

            Document query = new Document().append("id", user.getId());



            try {
                MongoDBOps.getInstance().getCollection(serverCollection(g.getId())).replaceOne(query,d); // @TODO: replace vs update? what's the difference
            } catch(MongoException me){
                log.error("Something bad happened while updating.");
            }

        }
    }

    public void UpdateUser(User user, Guild g) {



            counterIncrease(user,g);
            if (!isIdInside(user, g)) {
                Document userObject = new Document("id", user.getId()).append("name", user.getName()).append("accountbday", user.getTimeCreated().format(DateTimeFormatter.BASIC_ISO_DATE)).append("counter", 0);
                MongoDBOps.getInstance().getCollection("server " + g.getId()).insertOne(userObject);

        }
    }

}
