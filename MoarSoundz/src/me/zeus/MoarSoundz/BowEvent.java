
package me.zeus.MoarSoundz;


import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;



public class BowEvent implements Listener {

    // ============================================================================

    private final Main plugin;

    public BowEvent(final Main pl) {
        plugin = pl;
    }

    // ============================================================================

    @EventHandler
    public void onPVP(final EntityDamageByEntityEvent e) {

        final Entity damager = e.getDamager();
        final Entity victim = e.getEntity();

        if (damager instanceof Arrow) {
            final Arrow arrow = (Arrow) damager;

            if (arrow.getShooter() instanceof Player && victim instanceof Player) {
                if (plugin.getConfig().getBoolean("SOUNDS.PVP.BOW.ENABLED") == true) {
                    ((Player) ((Projectile) damager).getShooter()).playSound(damager.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
                }
            }
        }
    }

    // ============================================================================

}
