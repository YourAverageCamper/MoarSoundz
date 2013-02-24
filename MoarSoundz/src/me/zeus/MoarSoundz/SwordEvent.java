
package me.zeus.MoarSoundz;


import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;



public class SwordEvent implements Listener {

    // ============================================================================

    private final Main plugin;

    public SwordEvent(final Main pl) {
        plugin = pl;
    }

    // ============================================================================
    @EventHandler
    public void onPVP(final EntityDamageByEntityEvent e) {
        final Entity damagerEn = e.getDamager();
        final Entity victimEn = e.getEntity();

        if (damagerEn instanceof Player && victimEn instanceof Player) {
            final Player damager = (Player) damagerEn;
            final Player victim = (Player) victimEn;
            if (hasSword(damager)) {
                if (hasArmour(victim)) {
                    if (plugin.getConfig().getBoolean("SOUNDS.PVP.SWORD.ENABLED") == true) {
                        damager.playSound(damager.getLocation(), Sound.ANVIL_LAND, 1.0F, 2.0F);
                    }
                }
            }
        }
    }

    // ============================================================================

    private boolean hasSword(final Player p) {
        if (p.getItemInHand().getType().equals(Material.DIAMOND_SWORD) || p.getItemInHand().getType().equals(Material.GOLD_SWORD)
                || p.getItemInHand().getType().equals(Material.IRON_SWORD) || p.getItemInHand().getType().equals(Material.STONE_SWORD)) {
            return true;
        }
        return false;
    }
    
    // ============================================================================

    private boolean hasArmour(final Player p) {
        if ((p.getInventory().getChestplate() != null) || (p.getInventory().getHelmet() != null) || (p.getInventory().getLeggings() != null)
                || (p.getInventory().getBoots() != null)) {
            return true;
        }
        return false;
    }

    // ============================================================================

}
