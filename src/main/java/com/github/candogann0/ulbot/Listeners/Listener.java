package com.github.candogann0.ulbot.Listeners;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.github.candogann0.ulbot.UlBot.bot;

public class Listener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if(event.isFromType(ChannelType.TEXT)) {
            bot.getDb().UpdateUser(event.getAuthor(), event.getGuild());
        }
    }
}
