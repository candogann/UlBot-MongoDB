package com.github.candogann0.ulbot;

import com.github.candogann0.ulbot.Database.DatabaseCore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UlBot {


    public static final Bot bot = new Bot();
    public static final Logger log = (Logger) LoggerFactory.getLogger("UlBOT");
    public static final DatabaseCore db = new DatabaseCore();

    public static void main(String[] args) {
        try {
        bot.run();
    } catch (Exception ignored) {}
    }

}
