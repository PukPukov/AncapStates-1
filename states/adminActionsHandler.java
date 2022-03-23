/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.jetbrains.annotations.NotNull
 */
package states;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import states.API.SMassiveAPI;
import states.dynmapModule;
import states.main;

public class adminActionsHandler
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (sender == null) {
            adminActionsHandler.$$$reportNull$$$0(0);
        }
        if (cmd == null) {
            adminActionsHandler.$$$reportNull$$$0(1);
        }
        if (s == null) {
            adminActionsHandler.$$$reportNull$$$0(2);
        }
        if (args == null) {
            adminActionsHandler.$$$reportNull$$$0(3);
        }
        if (args[0].equals("dreload")) {
            String cityListString = main.getInstance().getConfig().getString("states.cityList");
            String[] cityList = SMassiveAPI.toMassive(cityListString);
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)"dmarker deleteset id:ancapcity");
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)"dmarker addset id:ancapcity \u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430");
            for (int i = 0; i < cityList.length; ++i) {
                dynmapModule.createCityCircle(cityList[i]);
            }
        }
        return false;
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n) {
        Object[] arrobject;
        Object[] arrobject2 = new Object[3];
        switch (n) {
            default: {
                arrobject = arrobject2;
                arrobject2[0] = "sender";
                break;
            }
            case 1: {
                arrobject = arrobject2;
                arrobject2[0] = "cmd";
                break;
            }
            case 2: {
                arrobject = arrobject2;
                arrobject2[0] = "s";
                break;
            }
            case 3: {
                arrobject = arrobject2;
                arrobject2[0] = "args";
                break;
            }
        }
        arrobject[1] = "states/adminActionsHandler";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

