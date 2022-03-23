/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Statistic
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.jetbrains.annotations.NotNull
 */
package states;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;

public class licenceHandler
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p;
        if (sender == null) {
            licenceHandler.$$$reportNull$$$0(0);
        }
        if (command == null) {
            licenceHandler.$$$reportNull$$$0(1);
        }
        if (s == null) {
            licenceHandler.$$$reportNull$$$0(2);
        }
        if (args == null) {
            licenceHandler.$$$reportNull$$$0(3);
        }
        if ((p = Bukkit.getPlayer((String)sender.getName())).getStatistic(Statistic.PLAY_ONE_MINUTE) <= 576000) {
            MainAPI.badMessage(p, "\u0427\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043b\u0438\u0446\u0435\u043d\u0437\u0438\u044e \u043d\u0430 \u0442\u043e\u0440\u0433\u043e\u0432\u043b\u044e \u043d\u0430 \u041a\u0438\u043f\u0440\u0435, \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u043e\u0442\u044b\u0433\u0440\u0430\u0442\u044c \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435 \u043c\u0438\u043d\u0438\u043c\u0443\u043c 8 \u0447\u0430\u0441\u043e\u0432.");
            return true;
        }
        MainAPI.set("states.player." + sender.getName().toLowerCase() + ".isLicentiate", "true");
        MainAPI.goodMessage(p, "\u0422\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u043b \u043b\u0438\u0446\u0435\u043d\u0437\u0438\u044e \u043d\u0430 \u0442\u043e\u0440\u0433\u043e\u0432\u043b\u044e \u043d\u0430 \u041a\u0438\u043f\u0440\u0435.");
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
        arrobject[1] = "states/licenceHandler";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

