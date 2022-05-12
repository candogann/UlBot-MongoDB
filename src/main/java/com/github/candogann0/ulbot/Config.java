package com.github.candogann0.ulbot;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Locale;

public class Config {

    private static final Dotenv denv = Dotenv.load();
    public static String get(String key) {return denv.get(key.toUpperCase(Locale.ROOT));}

}
