/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Chunk
 *  org.bukkit.Location
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.jetbrains.annotations.NotNull
 */
package states;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;
import states.API.StatesAPI;

public class chunkMain
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender == null) {
            chunkMain.$$$reportNull$$$0(0);
        }
        if (command == null) {
            chunkMain.$$$reportNull$$$0(1);
        }
        if (s == null) {
            chunkMain.$$$reportNull$$$0(2);
        }
        if (args == null) {
            chunkMain.$$$reportNull$$$0(3);
        }
        Player p = (Player)sender;
        Location loc = p.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        Chunk chunk = loc.getChunk();
        MainAPI.sendMessage(p, "&7------------------------------");
        MainAPI.sendMessage(p, "\u0418\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044f \u043e \u0447\u0430\u043d\u043a\u0435 " + chunk.toString());
        if (city.equals("-1")) {
            if (outpost.equals("-1")) {
                MainAPI.sendMessage(p, "&6\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446&7: &8\u043d\u0438\u043a\u0442\u043e");
                MainAPI.sendMessage(p, "&7------------------------------");
                return true;
            }
            city = MainAPI.getOutpostInfo(outpost, "owner");
            MainAPI.sendMessage(p, "&6\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446&7: &8" + city);
            MainAPI.sendMessage(p, "&6#fact001&7: &8outpostStatus=true");
        }
        MainAPI.sendMessage(p, "&6\u0412\u043b\u0430\u0434\u0435\u043b\u0435\u0446&7: &8" + city);
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!privateChunk.equals("-1")) {
            String owner = MainAPI.getCityInfo(city, "chunks." + chunk);
            MainAPI.sendMessage(p, "&6#fact002&7: &8privateStatus=true");
            MainAPI.sendMessage(p, "&6#fact002:1&7: &8privateChunkOwner=" + owner);
        }
        MainAPI.sendMessage(p, "&7------------------------------");
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
        arrobject[1] = "states/chunkMain";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

