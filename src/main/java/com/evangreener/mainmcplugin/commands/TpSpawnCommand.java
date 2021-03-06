package com.evangreener.mainmcplugin.commands;

import com.evangreener.mainmcplugin.MainMCPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Location spawn = player.getWorld().getSpawnLocation(); //Get world spawn location
            player.teleport(spawn);
        }
        return true;
    }
}
