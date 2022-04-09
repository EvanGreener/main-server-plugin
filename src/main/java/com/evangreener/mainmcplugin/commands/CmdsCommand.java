package com.evangreener.mainmcplugin.commands;

import com.evangreener.mainmcplugin.MainMCPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class CmdsCommand implements CommandExecutor {

    private final MainMCPlugin mainMCPlugin;

    public CmdsCommand (MainMCPlugin mainMCPlugin){
        this.mainMCPlugin = mainMCPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || args[0].equals("help")) {
            var helpList =  mainMCPlugin.getConfig().getStringList("help");
            for (String cmd: helpList) {
                sender.sendMessage(cmd);
            }
            return true;
        }
        return true;
    }

}
