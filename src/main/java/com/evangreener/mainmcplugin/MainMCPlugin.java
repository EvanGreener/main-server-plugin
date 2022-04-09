package com.evangreener.mainmcplugin;

import com.evangreener.mainmcplugin.commands.CmdsCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainMCPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("cmds").setExecutor(new CmdsCommand(this));
        

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
