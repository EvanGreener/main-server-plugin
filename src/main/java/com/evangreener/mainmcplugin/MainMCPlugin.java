package com.evangreener.mainmcplugin;

import com.evangreener.mainmcplugin.commands.CmdsCommand;
import com.evangreener.mainmcplugin.commands.TpSpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MainMCPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Assign commands to their executor classes
        Objects.requireNonNull(this.getCommand("cmds")).setExecutor(new CmdsCommand(this));
        Objects.requireNonNull(this.getCommand("tp-spawn")).setExecutor(new TpSpawnCommand());

    }
}
