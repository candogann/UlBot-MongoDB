package com.github.candogann0.ulbot.Commands.User;

import com.github.candogann0.ulbot.Commands.Categories;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class CommandInterfaceS extends Command {
    public CommandInterfaceS() {
        this.name = "@PARAM";
        this.help = "@PARAM";
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.category = Categories.USER;
        this.ownerCommand = false;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent commandEvent) {

    }

}
