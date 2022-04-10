package com.evangreener.mainmcplugin.commands;

import com.evangreener.mainmcplugin.MainMCPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Map;

public class CmdsCommand implements CommandExecutor {

    private final MainMCPlugin mainMCPlugin;

    public CmdsCommand (MainMCPlugin mainMCPlugin){
        this.mainMCPlugin = mainMCPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || args[0].equals("help")) {
            var commandList = mainMCPlugin.getDescription().getCommands().entrySet();
            sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH +
                    "-----------------------------------------------------");
            for (Map.Entry<String, Map<String, Object>> entry : commandList) {
                var cmdProperties = entry.getValue();
                String usage = (String) cmdProperties.get("usage");
                String description = (String) cmdProperties.get("description");
                sender.sendMessage(ChatColor.LIGHT_PURPLE + usage + " - " + ChatColor.WHITE + description);
            }
        }
        return true;
    }

}
