package io.github.gmw.utils;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.Command;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.game.player.Player;
import io.github.gmw.MeaNoticeCore;

import java.util.*;

@Command(label = "meanotice", usage = "meanotice reload",
        description = "MeaNoticeCore command", aliases = {"mnotice"}, permission = "meo.notice")

public class MeaCommand implements CommandHandler {
    @Override
    public void execute(Player sender, Player targetPlayer, List<String> args) {
        switch (args.size()) {
            default: // *No args*
                CommandHandler.sendMessage(sender, "Usage: meanotice reload");
                return;
            case 1:
                if (Objects.equals(args.get(0), "reload")) {
                    MeaNoticeCore.getInstance().reloadConfig();

                    if(sender == null) {
                        Grasscutter.getLogger().info("[MeaNoticeCore] Reloaded!");
                    }else {
                        CommandHandler.sendMessage(sender, "MeaNoticeCore config reloaded");
                    }
                } else {
                    CommandHandler.sendMessage(sender, "Invalid args.");
                }
        }

    }
}

