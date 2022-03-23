/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.jetbrains.annotations.NotNull
 */
package states;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;

public class corporationMain
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender == null) {
            corporationMain.$$$reportNull$$$0(0);
        }
        if (command == null) {
            corporationMain.$$$reportNull$$$0(1);
        }
        if (s == null) {
            corporationMain.$$$reportNull$$$0(2);
        }
        if (args == null) {
            corporationMain.$$$reportNull$$$0(3);
        }
        MainAPI.createProfile(sender);
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
                arrobject2[0] = "command";
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
        arrobject[1] = "states/corporationMain";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

