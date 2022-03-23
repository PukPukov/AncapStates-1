/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.connorlinfoot.titleapi.TitleAPI
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package states.API;

import com.connorlinfoot.titleapi.TitleAPI;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import states.API.MainAPI;
import states.main;

public class StatesAPI {
    public static Location getHome(String city) {
        Location loc = MainAPI.getLocation("states.city." + city + ".home");
        return loc;
    }

    public static double getDistance(String city1, String city2) {
        Location loc1 = StatesAPI.getHome(city1);
        Location loc2 = StatesAPI.getHome(city2);
        World world = Bukkit.getWorld((String)"world");
        loc1.setWorld(world);
        loc2.setWorld(world);
        loc1.setY(64.0);
        loc2.setY(64.0);
        double distance = loc1.distance(loc2);
        return distance;
    }

    public static boolean collide(String city1, String city2, int ... additionalRadius) {
        double distance = StatesAPI.getDistance(city1, city2);
        int radius1 = main.getInstance().getConfig().getInt("states.city." + city1 + ".radius");
        int radius2 = main.getInstance().getConfig().getInt("states.city." + city2 + ".radius");
        boolean collideStatus = false;
        if (additionalRadius.length > 0) {
            if ((double)(radius1 + radius2 + additionalRadius[0]) > distance) {
                collideStatus = true;
            }
        } else if ((double)(radius1 + radius2) > distance) {
            collideStatus = true;
        }
        return collideStatus;
    }

    public static boolean collides(String city, int ... additionalRadius) {
        String[] cityList = main.getInstance().getConfig().getString("states.cityList").split(", ");
        if (additionalRadius.length > 0) {
            for (int i = 0; i < cityList.length; ++i) {
                if (city.equals(cityList[i])) continue;
                boolean collideStatus = StatesAPI.collide(city, cityList[i], additionalRadius[0]);
                if (!collideStatus) continue;
                return true;
            }
        } else {
            for (int i = 0; i < cityList.length; ++i) {
                boolean collideStatus;
                if (city.equals(cityList[i]) || !(collideStatus = StatesAPI.collide(city, cityList[i], new int[0]))) continue;
                return true;
            }
        }
        return false;
    }

    public static String inCity(Location loc1) {
        String[] cityList = main.getInstance().getConfig().getString("states.cityList").split(", ");
        loc1 = MainAPI.toWorld(loc1);
        for (int i = 0; i < cityList.length; ++i) {
            double distance;
            Location loc2 = MainAPI.getLocation("states.city." + cityList[i] + ".home");
            String radius = main.getInstance().getConfig().getString("states.city." + cityList[i] + ".radius");
            if (loc2 == null) {
                MainAPI.log.info("ERROR; CITY = " + cityList[i] + ";");
            }
            if (!((distance = loc1.distance(loc2 = MainAPI.toWorld(loc2))) < (double)Integer.valueOf(radius).intValue())) continue;
            return cityList[i];
        }
        return "-1";
    }

    public static boolean justInCity(Location loc1) {
        String[] cityList = main.getInstance().getConfig().getString("states.cityList").split(", ");
        loc1 = MainAPI.toWorld(loc1);
        for (int i = 0; i < cityList.length; ++i) {
            Location loc2 = MainAPI.getLocation("states.city." + cityList[i] + ".home");
            loc2 = MainAPI.toWorld(loc2);
            String radius = main.getInstance().getConfig().getString("states.city." + cityList[i] + ".radius");
            double distance = loc1.distance(loc2);
            if (!(distance < (double)Integer.valueOf(radius).intValue())) continue;
            return true;
        }
        return false;
    }

    public static boolean justInCity(Player p) {
        Location loc = p.getLocation();
        return StatesAPI.justInCity(loc);
    }

    public static boolean inCity(Player p, int AdditionalRadius) {
        Location loc1 = p.getLocation();
        loc1 = MainAPI.toWorld(loc1);
        String[] cityList = main.getInstance().getConfig().getString("states.cityList").split(", ");
        for (int i = 0; i < cityList.length; ++i) {
            Location loc2 = MainAPI.getLocation("states.city." + cityList[i] + ".home");
            loc2 = MainAPI.toWorld(loc2);
            int radius = MainAPI.getInt("states.city." + cityList[i] + ".radius") + AdditionalRadius;
            double distance = loc1.distance(loc2);
            if (!(distance < (double)Integer.valueOf(radius).intValue())) continue;
            return true;
        }
        return false;
    }

    public static boolean canCreate(Location loc1) {
        String cityListString = main.getInstance().getConfig().getString("states.cityList");
        if (!Objects.equals(cityListString, "start")) {
            loc1 = MainAPI.toWorld(loc1);
            String[] cityList = main.getInstance().getConfig().getString("states.cityList").split(", ");
            for (int i = 0; i < cityList.length; ++i) {
                Location loc2 = MainAPI.getLocation("states.city." + cityList[i] + ".home");
                loc2 = MainAPI.toWorld(loc2);
                int radius = main.getInstance().getConfig().getInt("states.city." + cityList[i] + ".radius");
                double distance = loc1.distance(loc2);
                if (!(distance < (double)(radius + 50))) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean justInOutpost(Location loc) {
        String chunk = MainAPI.getChunk(loc);
        return MainAPI.isSet("states.chunks." + chunk);
    }

    public static String inOutpost(Location loc) {
        String chunk = MainAPI.getChunk(loc);
        if (MainAPI.isSet("states.chunks." + chunk)) {
            return chunk;
        }
        return "-1";
    }

    public static String inPrivateChunk(String city, Location loc) {
        String chunk = MainAPI.getChunk(loc);
        if (MainAPI.isSet("states.city." + city + ".chunks." + chunk)) {
            return chunk;
        }
        return "-1";
    }

    public static String inOutpost(Player p) {
        Location loc = p.getLocation();
        return StatesAPI.inOutpost(loc);
    }

    public static boolean justInOutpost(Player p) {
        Location loc = p.getLocation();
        return StatesAPI.justInOutpost(loc);
    }

    public static boolean canCreate(Player p) {
        Location loc = p.getLocation();
        return StatesAPI.canCreate(loc);
    }

    public static boolean canCreate(CommandSender sender) {
        Player p = Bukkit.getPlayer((String)sender.getName());
        Location loc = p.getLocation();
        return StatesAPI.canCreate(loc);
    }

    public static String inCity(Player p) {
        Location loc = p.getLocation();
        return StatesAPI.inCity(loc);
    }

    public static String inCity(CommandSender sender) {
        Player p = Bukkit.getPlayer((String)String.valueOf((Object)sender));
        Location loc = p.getLocation();
        return StatesAPI.inCity(loc);
    }

    public static void cityMove(Player p, String city) {
        if (Objects.equals(city, "-1")) {
            TitleAPI.sendTitle((Player)p, (int)20, (int)20, (int)20, (String)"", (String)"&c\u0411\u0443\u0434\u044c \u043e\u0441\u0442\u043e\u0440\u043e\u0436\u0435\u043d! \u0422\u044b \u0432\u044b\u0448\u0435\u043b \u0438\u0437 \u0433\u043e\u0440\u043e\u0434\u0430.");
        } else {
            String rang = main.getInstance().getConfig().getString("states.city." + city + ".rang");
            String cityName = main.getInstance().getConfig().getString("states.city." + city + ".name");
            TitleAPI.sendTitle((Player)p, (int)20, (int)20, (int)20, (String)("\u0422\u044b \u0432\u043e\u0448\u0451\u043b \u043d\u0430 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u044e \u0433\u043e\u0440\u043e\u0434\u0430 " + cityName), (String)("\u0412 \u0433\u043e\u0440\u043e\u0434\u0435 \u043f\u0440\u043e\u0436\u0438\u0432\u0430\u0435\u0442 " + rang + " \u0447\u0435\u043b\u043e\u0432\u0435\u043a"));
        }
    }
}

