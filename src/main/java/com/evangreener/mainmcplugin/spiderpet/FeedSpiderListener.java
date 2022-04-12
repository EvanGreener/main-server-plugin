package com.evangreener.mainmcplugin.spiderpet;

import com.evangreener.mainmcplugin.MainMCPlugin;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;


public class FeedSpiderListener implements Listener {

    private final MainMCPlugin mainMCPlugin;

    public FeedSpiderListener (MainMCPlugin mainMCPlugin){
        this.mainMCPlugin = mainMCPlugin;
    }

    /**
     * Simulates "feeding" a spider by attacking it with rotten flesh in the player's main hand
     * thereby cancelling the damage event and taming the spider instead
     * @param e
     */
    @EventHandler
    public void onFeedSpider(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damagee = e.getEntity();
        if (damager instanceof Player && damagee instanceof Spider) {
            Player player = (Player) damager;
            Spider spider =  (Spider) damagee;
            // Check if the player attacked with rotten flesh in main hand and that the spider is not
            // someone else's pet
            Material itemInMainHand = player.getInventory().getItemInMainHand().getType();
            boolean hasOwner = spider.getMetadata(MainMCPlugin.PET_OWNER_KEY).get(0).asString().equals(player.getDisplayName());
            if (itemInMainHand == Material.ROTTEN_FLESH && !hasOwner) {
                // Cancel event
                e.setCancelled(true);
                // Pretend that spider ate the rotten flesh by replacing it with air (nothing)
                player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));

                //Turn the spider into a pet that will fight other mobs
                claimSpider(player, spider);
            }
        }

    }

    private void claimSpider(Player player, Spider spider) {
        String owner = player.getDisplayName();
        spider.playEffect(EntityEffect.LOVE_HEARTS);
        spider.setMetadata(MainMCPlugin.PET_OWNER_KEY, new FixedMetadataValue(mainMCPlugin, owner));
        spider.setCustomName(owner + "'s spider");
        spider.setCustomNameVisible(true);
    }


}
