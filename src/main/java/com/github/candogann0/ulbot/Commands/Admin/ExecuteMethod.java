package com.github.candogann0.ulbot.Commands.Admin;

import com.github.candogann0.ulbot.Bot;
import com.github.candogann0.ulbot.Commands.Categories;
import com.github.candogann0.ulbot.Database.DatabaseCore;
import com.github.candogann0.ulbot.UlBot;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;

import static com.github.candogann0.ulbot.UlBot.bot;

public class ExecuteMethod extends Command {

    public ExecuteMethod() {

        this.name = "exe";
        this.help = "A command for executing methods";

        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.category = Categories.ADMIN;
        this.ownerCommand = true;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        bot.getDb().UpdateUser(commandEvent.getAuthor(), commandEvent.getGuild());
    }
}
