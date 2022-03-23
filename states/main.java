/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package states;

import java.util.logging.Logger;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import states.API.MainAPI;
import states.EventsListener;
import states.adminActionsHandler;
import states.breweryDonateCommands;
import states.chunkMain;
import states.cityMain;
import states.corporationMain;
import states.licenceHandler;
import states.nationMain;
import states.test;
import states.timeActionsHandler;

public class main
extends JavaPlugin {
    private static main instance;

    public static main getInstance() {
        return instance;
    }

    public void onEnable() {
        this.saveDefaultConfig();
        instance = this;
        Logger log = this.getLogger();
        log.info("Done!");
        this.getServer().getPluginCommand("city").setExecutor((CommandExecutor)new cityMain());
        this.getServer().getPluginCommand("chunk").setExecutor((CommandExecutor)new chunkMain());
        this.getServer().getPluginCommand("nation").setExecutor((CommandExecutor)new nationMain());
        this.getServer().getPluginCommand("corporation").setExecutor((CommandExecutor)new corporationMain());
        this.getServer().getPluginCommand("citycheck").setExecutor((CommandExecutor)new timeActionsHandler());
        this.getServer().getPluginCommand("admincity").setExecutor((CommandExecutor)new adminActionsHandler());
        this.getServer().getPluginCommand("licence").setExecutor((CommandExecutor)new licenceHandler());
        this.getServer().getPluginCommand("bdc").setExecutor((CommandExecutor)new breweryDonateCommands());
        this.getServer().getPluginCommand("test").setExecutor((CommandExecutor)new test());
        this.getServer().getPluginManager().registerEvents((Listener)new EventsListener(), (Plugin)this);
    }

    public void onDisable() {
        MainAPI.save();
    }
}

