package me.zeus.MoarSoundz;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandling implements CommandExecutor {
    
    //=======================================================================

    private Main plugin; 
    
    public CommandHandling(Main plugin){
        this.plugin = plugin;
    }

    //=======================================================================
    
    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
                    if (sender.hasPermission("MoarSoundz.Reload")) {
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.GREEN + " MoarSoundz config reloaded. ");
                    }
        return false;
    }
    
    //=======================================================================

}
