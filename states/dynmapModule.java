/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 */
package states;

import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import states.API.MainAPI;
import states.API.SMassiveAPI;
import states.descriptionSetter;
import states.main;

public class dynmapModule {
    public static void createCity(CommandSender sender) {
        String cityName = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
        String regionID = main.getInstance().getConfig().getString("states.city." + cityName + ".regionID");
        Player p = Bukkit.getPlayer((String)sender.getName());
        int x = p.getLocation().getBlockX();
        int z = p.getLocation().getBlockZ();
        World world1 = p.getWorld();
        String world = world1.getName();
        String citycolor = MainAPI.color("citycolor");
        String command = "dmarker addcircle id:" + regionID + " " + cityName + " set:ancapcity x:" + x + " y:64 z:" + z + " fillcolor:" + citycolor + " color:000 radius:10 fillopacity:0.6 world:" + world;
        String markerCommand = "dmarker add id:" + regionID + " " + cityName + " set:ancapcity x:" + x + " y:64 z:" + z + " icon:greenflag world:" + world;
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)markerCommand);
        dynmapModule.updateCity(cityName);
    }

    public static void createCityCircle(String city) {
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        String cityName = main.getInstance().getConfig().getString("states.city." + city + ".name");
        Location loc = MainAPI.getLocation("states.city." + city + ".home");
        int x = loc.getBlockX();
        int z = loc.getBlockZ();
        World world1 = loc.getWorld();
        String world = world1.getName();
        String citycolor = MainAPI.color("citycolor");
        String command = "dmarker addcircle id:" + regionID + " " + cityName + " set:ancapcity x:" + x + " y:64 z:" + z + " fillcolor:" + citycolor + " color:000 radius:10 fillopacity:0.6 world:" + world;
        String markerCommand = "dmarker add id:" + regionID + " " + cityName + " set:ancapcity x:" + x + " y:64 z:" + z + " icon:greenflag world:" + world;
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)markerCommand);
        dynmapModule.updateCity(city);
    }

    public static void deleteCity(String city) {
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        String command = "dmarker deletecircle id:" + regionID + " set:ancapcity";
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
    }

    public static void updateCity(String city) {
        dynmapModule.updateCityColor(city);
        dynmapModule.updateCityMarker(city);
        dynmapModule.updateCityDescription(city);
        dynmapModule.updateCityRadius(city);
    }

    public static void updateNation(String nation) {
        String citiesString = Objects.requireNonNull(main.getInstance().getConfig().getString("states.nation." + nation + ".cities"));
        String[] cities = SMassiveAPI.toMassive(citiesString);
        for (int i = 0; i < cities.length; ++i) {
            String city = cities[i];
            dynmapModule.updateCityColor(city);
            dynmapModule.updateCityMarker(city);
            dynmapModule.updateCityDescription(city);
            dynmapModule.updateCityRadius(city);
        }
    }

    public static void updateCityColor(String city) {
        String nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        if (nation.equals("")) {
            String color = MainAPI.color("citycolor");
            String command = "dmarker updatecircle id:" + regionID + " set:ancapcity fillcolor:" + color;
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        } else {
            String nationColor = main.getInstance().getConfig().getString("states.nation." + nation + ".color");
            String command = "dmarker updatecircle id:" + regionID + " set:ancapcity fillcolor:" + nationColor;
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        }
    }

    public static void updateCityMarker(String city) {
        String command;
        String nation = MainAPI.getCityInfo(city, "nation");
        String nationStatus = "free";
        if (!nation.equals("")) {
            nationStatus = "slave";
            String capital = MainAPI.getNationInfo(nation, "capital");
            if (capital.equals(city)) {
                nationStatus = "capital";
            }
        }
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        if (nationStatus.equals("free")) {
            command = "dmarker update id:" + regionID + " set:ancapcity icon:greenflag";
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        }
        if (nationStatus.equals("capital")) {
            command = "dmarker update id:" + regionID + " set:ancapcity icon:king";
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        }
        if (nationStatus.equals("slave")) {
            command = "dmarker update id:" + regionID + " set:ancapcity icon:blueflag";
            Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
        }
    }

    public static void updateCityRadius(String city) {
        String radius = main.getInstance().getConfig().getString("states.city." + city + ".radius");
        if (radius.equals("30")) {
            main.getInstance().getConfig().set("states.city." + city + ".radius", (Object)50);
            radius = "50";
        }
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        String command = "dmarker updatecircle id:" + regionID + " set:ancapcity radius:" + radius;
        Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), (String)command);
    }

    public static void updateCityDescription(String city) {
        String cityName = main.getInstance().getConfig().getString("states.city." + city + ".name");
        String residents = main.getInstance().getConfig().getString("states.city." + city + ".residents");
        String regionID = main.getInstance().getConfig().getString("states.city." + city + ".regionID");
        String nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
        String nationName = MainAPI.getNationInfo(nation, "name");
        String corporation = main.getInstance().getConfig().getString("states.city." + city + ".corporationGovernment.company");
        String leader = main.getInstance().getConfig().getString("states.city." + city + ".leader");
        String residentsAmount = main.getInstance().getConfig().getString("states.city." + city + ".rang");
        String deputats = main.getInstance().getConfig().getString("states.city." + city + ".deputats");
        String board = main.getInstance().getConfig().getString("states.city." + city + ".board");
        String level = main.getInstance().getConfig().getString("states.city." + city + ".level");
        String description = "<center><strong>" + cityName + "</strong></center> <br><center><i>" + board + "</i></center> <br>\u041c\u044d\u0440 \u0433\u043e\u0440\u043e\u0434\u0430: " + leader + " <br> \u0410\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u044b: " + deputats + "  <br> \u041d\u0430\u0446\u0438\u044f: " + nationName + " <br> \u041a\u043e\u0440\u043f\u043e\u0440\u0430\u0446\u0438\u044f-\u0432\u043b\u0430\u0434\u0435\u043b\u0435\u0446: " + corporation + " <br> \u0416\u0438\u0442\u0435\u043b\u0438 (" + residentsAmount + "): " + residents + " <br> \u0420\u0430\u043d\u0433: " + level;
        descriptionSetter.setDescription(regionID, description);
    }
}

