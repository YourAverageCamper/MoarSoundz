
package me.zeus.MoarSoundz;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;



public class ChatEvent implements Listener {

    // ============================================================================

    private ArrayList<String> containedNames;

    private final Main plugin;

    public ChatEvent(final Main pl) {
        plugin = pl;
    }

    // ============================================================================

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {

        // if chat contains player name, play level up sound
        if (msgContainsName(e.getMessage())) {
            if (plugin.getConfig().getBoolean("SOUNDS.CHAT.NAME_SOUND.ENABLED") == true) {
                if (containedNamesFromString(e.getMessage()) != null) {
                    for (final Player p : Bukkit.getServer().getOnlinePlayers()) {
                        if (containedNames.contains(p.getName())) {
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5F, 1.0F);
                            containedNames.remove(p.getName());
                        }
                    }
                }
            }
        }
    }

    // ============================================================================

    // check for player name in there
    private boolean msgContainsName(final String s) {
        for (final Player p : Bukkit.getServer().getOnlinePlayers()) {
            return s.contains(p.getName());
        }
        return false;
    }

    // ============================================================================

    // get all players in message
    private ArrayList<String> containedNamesFromString(final String before) {
        containedNames = new ArrayList<String>();

        for (final Player p : Bukkit.getOnlinePlayers()) {
            final String name = p.getName();
            if (before.length() != before.replace(name, "").length()) {
                containedNames.add(name);
            }
        }
        return containedNames;
    }

    // ============================================================================

}
