package com.github.candogann0.ulbot;

import com.github.candogann0.ulbot.Commands.Admin.ExecuteMethod;
import com.github.candogann0.ulbot.Database.DatabaseCore;
import com.github.candogann0.ulbot.Listeners.Listener;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

// @TODO: rest api, node.js // expess framework // amazon elastic beanstalk
public class Bot {

    /*
    *   Main init for com.github.candogann0.ulbot.Bot
    *   here we setup our JDA and client,
    *   also probably setup our db
    *
    *
    */

    private final DatabaseCore db = new DatabaseCore();
    private MongoClient mdb;
    void run() throws LoginException {

                CommandClientBuilder client = new CommandClientBuilder().setOwnerId(Config.get("OWNER_ID")).
                        setPrefix(Config.get("PREFIX")).
                        setStatus(OnlineStatus.DO_NOT_DISTURB).
                        addCommand(new ExecuteMethod());

                System.out.println("test");
                JDABuilder jda = JDABuilder.createLight(Config.get("TOKEN"))
                        //.setEnabledIntents()  @TODO: study intents,
                        .setStatus(OnlineStatus.DO_NOT_DISTURB)
                        .setActivity(Activity.playing("onTest"))
                        .addEventListeners(new Listener(), client.build());


                jda.build();


    } // @TODO: web page for mongodb


    public MongoClient getMdb() {
        return mdb;
    }

    public DatabaseCore getDb() {
        return db;
    }
}

