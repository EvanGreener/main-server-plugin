package com.evangreener.mainmcplugin.spiderpet;

import com.evangreener.mainmcplugin.MainMCPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class PetSpiderListener implements Listener {

    /**
     * Make sure spider follows owner but doesn't damage them
     * @param e
     */
    @EventHandler
    public void onPetAttackPlayer(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damagee = e.getEntity();
        if (damager instanceof Spider && damagee instanceof Player){
            Spider spider = (Spider) damager;
            Player player = (Player) damagee;
            //Check if spider is about to damage owner
            List<MetadataValue> values = spider.getMetadata(MainMCPlugin.PET_OWNER_KEY);
            for (MetadataValue value: values) {
                if (value.asString().equals(player.getDisplayName())){
                    e.setCancelled(true);
                    break;
                }
            }

        }
    }
}
