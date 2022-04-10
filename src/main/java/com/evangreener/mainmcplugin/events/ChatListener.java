package com.evangreener.mainmcplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent chatEvent) {
        String playerName = chatEvent.getPlayer().getDisplayName();
        if (playerName.equals("Rezanance")){
            chatEvent.setFormat(ChatColor.GOLD + "" + ChatColor.UNDERLINE + "[Owner]" + ChatColor.LIGHT_PURPLE + " <%s> " + ChatColor.RESET + "%s");
        }
        else{
            chatEvent.setFormat(ChatColor.RED + "[Pleb] " + ChatColor.RESET + "<%s> " + "%s");
        }

    }
}
