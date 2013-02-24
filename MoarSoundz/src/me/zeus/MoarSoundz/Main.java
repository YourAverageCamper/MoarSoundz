
package me.zeus.MoarSoundz;


import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {

    //=======================================================================

    @Override
    public void onEnable() {

        final PluginManager pm = getServer().getPluginManager();

        final BowEvent bowevent = new BowEvent(this);
        final SwordEvent swordevent = new SwordEvent(this);
        final ChatEvent chatevent = new ChatEvent(this);
        final CommandHandling commands = new CommandHandling(this);

        getCommand("moarsoundz").setExecutor(commands);

        pm.registerEvents(bowevent, this);
        pm.registerEvents(swordevent, this);
        pm.registerEvents(chatevent, this);

        if (!configExists()) {
            createConfig();
        }
    }

    //=======================================================================

    @SuppressWarnings("unused")
    private void createConfig() {
        if (!configExists()) {
            final File config = new File(getDataFolder() + File.separator + "config.yml");

            this.getConfig().addDefault("SOUNDS.PVP.SWORD.ENABLED", false);
            this.getConfig().addDefault("SOUNDS.PVP.BOW.ENABLED", false);
            
            this.getConfig().addDefault("SOUNDS.CHAT.NAME_SOUND.ENABLED", false);

            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        } else {
            System.out.println("[MoarSoundz] Config found! Loading...");
        }
    }

    //=======================================================================

    private boolean configExists() {
        final File config = new File(getDataFolder() + File.separator + "config.yml");
        return config.exists();
    }

    //=======================================================================

}
