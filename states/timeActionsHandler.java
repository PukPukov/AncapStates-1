/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.jetbrains.annotations.NotNull
 */
package states;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;
import states.API.SMassiveAPI;
import states.main;

public class timeActionsHandler
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender == null) {
            timeActionsHandler.$$$reportNull$$$0(0);
        }
        if (command == null) {
            timeActionsHandler.$$$reportNull$$$0(1);
        }
        if (s == null) {
            timeActionsHandler.$$$reportNull$$$0(2);
        }
        if (args == null) {
            timeActionsHandler.$$$reportNull$$$0(3);
        }
        if (!sender.isOp()) {
            Player p = Bukkit.getPlayer((String)sender.getName());
            MainAPI.badMessage(p, "\u043d\u0443 \u0438 \u043d\u0430\u0445\u0443\u044f \u0442\u044b \u044d\u0442\u043e \u0432\u0432\u0451\u043b?");
            return true;
        }
        if (args[0].equals("checkpositions")) {
            Player[] Players = Bukkit.getOnlinePlayers().toArray((T[])new Player[0]);
            MainAPI.checkPositions(Players);
        }
        if (args[0].equals("last")) {
            String lastCityCheck = main.getInstance().getConfig().getString("states.lastCityCheck");
            if (lastCityCheck.equals(null)) {
                sender.sendMessage("no checks");
                return true;
            }
            sender.sendMessage(lastCityCheck);
            return true;
        }
        if (args[0].equals("newday")) {
            Date currentTime = new Date();
            long unixSeconds = currentTime.getTime();
            Date dateCheck = new Date(unixSeconds * 1000L);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+4"));
            String formattedDate = sdf.format(dateCheck);
            main.getInstance().getConfig().set("states.lastCityCheck", (Object)formattedDate);
            String cityListString = main.getInstance().getConfig().getString("states.cityList");
            String[] cityList = SMassiveAPI.toMassive(cityListString);
            String nationListString = main.getInstance().getConfig().getString("states.nationList");
            String[] nationList = SMassiveAPI.toMassive(nationListString);
            MainAPI.sendGlobalMessage("\u041d\u0430\u0441\u0442\u0443\u043f\u0430\u0435\u0442 \u043d\u043e\u0432\u044b\u0439 \u0434\u0435\u043d\u044c");
            for (int i = 0; i < cityList.length; ++i) {
                Date current = new Date();
                long date = current.getTime();
                long deleteDate = main.getInstance().getConfig().getLong("states.city." + cityList[i] + ".deleteDate");
                long cringe = 1L;
                String cringeStatus = "false";
                if (MainAPI.isSet("states.city." + cityList[i] + ".dateDelete")) {
                    cringe = main.getInstance().getConfig().getLong("states.city." + cityList[i] + ".dateDelete");
                }
                if (cringe > deleteDate) {
                    deleteDate = cringe;
                    cringeStatus = "true";
                }
                if (deleteDate >= date) continue;
                MainAPI.sendGlobalMessage("\u0413\u043e\u0440\u043e\u0434 " + cityList[i] + " \u043f\u0440\u0435\u043a\u0440\u0430\u0442\u0438\u043b \u0441\u0432\u043e\u0451 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u043e\u0432\u0430\u043d\u0438\u0435.");
                MainAPI.sendGlobalMessage("cringestatus=" + cringeStatus);
                MainAPI.sendGlobalMessage("deleteDate=" + deleteDate);
                MainAPI.cityDelete(cityList[i]);
            }
            for (int i1 = 0; i1 < nationList.length; ++i1) {
                Date current = new Date();
                long date = current.getTime();
                long deleteDate = main.getInstance().getConfig().getLong("states.nation." + nationList[i1] + ".deleteDate");
                long cringe = 1L;
                String cringeStatus = "false";
                if (MainAPI.isSet("states.nation." + nationList[i1] + ".dateDelete")) {
                    cringe = main.getInstance().getConfig().getLong("states.nation." + nationList[i1] + ".dateDelete");
                }
                if (cringe > deleteDate) {
                    deleteDate = cringe;
                    cringeStatus = "true";
                }
                if (deleteDate >= date) continue;
                MainAPI.sendGlobalMessage("\u041d\u0430\u0446\u0438\u044f " + nationList[i1] + " \u043f\u0440\u0435\u043a\u0440\u0430\u0442\u0438\u043b\u0430 \u0441\u0432\u043e\u0451 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u043e\u0432\u0430\u043d\u0438\u0435.");
                MainAPI.sendGlobalMessage("cringestatus=" + cringeStatus);
                MainAPI.sendGlobalMessage("deleteDate=" + deleteDate);
                MainAPI.nationDelete(nationList[i1]);
            }
            return true;
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
        arrobject[1] = "states/timeActionsHandler";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

