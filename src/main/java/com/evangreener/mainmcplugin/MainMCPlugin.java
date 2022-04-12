package com.evangreener.mainmcplugin;

import com.evangreener.mainmcplugin.commands.CmdsCommand;
import com.evangreener.mainmcplugin.commands.TpSpawnCommand;
import com.evangreener.mainmcplugin.events.ChatListener;
import com.evangreener.mainmcplugin.spiderpet.FeedSpiderListener;
import com.evangreener.mainmcplugin.spiderpet.PetSpiderListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MainMCPlugin extends JavaPlugin {

    public static final String PET_OWNER_KEY = "petOwner";

    @Override
    public void onEnable() {
        // Assign commands to their executor classes
        Objects.requireNonNull(this.getCommand("cmds")).setExecutor(new CmdsCommand(this));
        Objects.requireNonNull(this.getCommand("tp-spawn")).setExecutor(new TpSpawnCommand());

        //Register event listeners
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new FeedSpiderListener(this), this);
        getServer().getPluginManager().registerEvents(new PetSpiderListener(), this);



    }
}
