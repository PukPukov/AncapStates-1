/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Chunk
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package states.API;

import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import states.API.SMassiveAPI;
import states.API.StatesAPI;
import states.dynmapModule;
import states.main;

public class MainAPI {
    static HashMap<String, String> positions = new HashMap();
    static Logger log = Bukkit.getLogger();

    public static void cityDelete(String city) {
        if (MainAPI.haveNation(city)) {
            if (MainAPI.isCapital(city)) {
                String nation = MainAPI.getCityInfo(city, "nation");
                MainAPI.nationDelete(nation);
            } else {
                MainAPI.removeMinisters(city);
            }
        }
        MainAPI.unclaimnewOutpostChunks(city);
        MainAPI.cityDeleteSelf(city);
    }

    public static void cityDeleteSelf(String city) {
    }

    public static boolean haveNation(String city) {
        String nation = MainAPI.getCityInfo(city, "nation");
        return !nation.equals("");
    }

    public static boolean isCapital(String city) {
        String nation = MainAPI.getCityInfo(city, "nation");
        String capital = MainAPI.getNationInfo(nation, "capital");
        return !city.equals(capital);
    }

    public static void removeMinisters(String city) {
        String nation = MainAPI.getCityInfo(city, "nation");
        String residentsString = MainAPI.getCityInfo(city, "residents");
        String[] residents = SMassiveAPI.toMassive(residentsString);
        String ministersString = MainAPI.getNationInfo(nation, "ministers");
        for (String resident : residents) {
            if (!MainAPI.isMinister(nation, resident)) continue;
            ministersString = SMassiveAPI.remove(ministersString, resident);
        }
        MainAPI.setNation(nation, "ministers", ministersString);
    }

    public static void nationDelete(String nation) {
        String citiesString = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
        String[] cities = SMassiveAPI.toMassive(citiesString);
        for (int i = 0; i < cities.length; ++i) {
            main.getInstance().getConfig().set("states.city." + cities[i] + ".nation", (Object)"");
            main.getInstance().getConfig().set("states.city." + cities[i] + ".isCapital", (Object)"false");
            main.getInstance().getConfig().set("states.city." + cities[i] + ".nationStatus", (Object)"free");
        }
        String nationList = main.getInstance().getConfig().getString("states.nationList");
        nationList = SMassiveAPI.remove(nationList, nation);
        main.getInstance().getConfig().set("states.nationList", (Object)nationList);
        dynmapModule.updateNation(nation);
        main.getInstance().getConfig().set("states.nation." + nation, null);
        main.getInstance().saveConfig();
    }

    public static void createProfile(Player p) {
        String player = p.getName().toLowerCase();
        String playerName = p.getName();
        if (!main.getInstance().getConfig().isSet("states.player." + player + ".name")) {
            main.getInstance().getConfig().set("states.player." + player + ".name", (Object)playerName);
            main.getInstance().getConfig().set("states.player." + player + ".city", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".askCity", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".inviteCity", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".corporation", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".isLicentiate", (Object)"false");
            main.getInstance().saveConfig();
        }
    }

    public static void createProfile(String player) {
        String playerName = player;
        try {
            playerName = Bukkit.getPlayer((String)player).getName();
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (!main.getInstance().getConfig().isSet("states.player." + player + ".name")) {
            main.getInstance().getConfig().set("states.player." + player + ".name", (Object)playerName);
            main.getInstance().getConfig().set("states.player." + player + ".city", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".askCity", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".inviteCity", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".corporation", (Object)"");
            main.getInstance().getConfig().set("states.player." + player + ".isLicentiate", (Object)"false");
            main.getInstance().saveConfig();
        }
    }

    public static void createProfile(CommandSender sender) {
        Player p = Bukkit.getPlayer((String)sender.getName());
        MainAPI.createProfile(p);
    }

    public static String randomColor() {
        double random = Math.random() * 11.0 + 1.0;
        int random1 = Math.toIntExact(Math.round(random));
        return switch (random1) {
            case 20 -> "575757";
            case 11 -> "004475";
            case 10 -> "09baba";
            case 9 -> "ffa500";
            case 8 -> "42aaff";
            case 7 -> "005ce5";
            case 6 -> "ff5252";
            case 5 -> "141414";
            case 4 -> "ebebeb";
            case 3 -> "54db00";
            case 2 -> "44b300";
            case 1 -> "b30000";
            default -> "6e0099";
        };
    }

    public static String color(String color) {
        return switch (color) {
            case "citycolor" -> "575757";
            case "darkblue" -> "004475";
            case "turquoise" -> "09baba";
            case "orange" -> "ffa500";
            case "lightblue" -> "42aaff";
            case "blue" -> "005ce5";
            case "lightred" -> "ff5252";
            case "darkgray" -> "2e2e2e";
            case "white" -> "ebebeb";
            case "lightgreen" -> "54db00";
            case "green" -> "44b300";
            case "darkred" -> "b30000";
            case "purple" -> "6e0099";
            case "fullblack" -> "000";
            case "gold" -> "db9514";
            default -> "c9c9c9";
        };
    }

    public static boolean isSet(String path) {
        return main.getInstance().getConfig().isSet(path);
    }

    public static boolean isOutpost(String chunk) {
        return MainAPI.isSet("states.chunks." + chunk);
    }

    public static boolean isOutpostOwner(String chunk, String city) {
        return MainAPI.getOutpostInfo(chunk, "owner").equals(city);
    }

    public static boolean isPrivateChunkOwner(String city, String chunk, String player) {
        return MainAPI.getPrivateChunkOwner(city, chunk).equals(player);
    }

    public static boolean isAssistant(String player) {
        String city = MainAPI.getPlayerInfo(player = player.toLowerCase(), "city");
        if (city.equals("")) {
            return false;
        }
        String deputats = MainAPI.getCityInfo(city, "deputats");
        return deputats.indexOf(player) != -1;
    }

    public static boolean isMinister(String nation, String player) {
        player = player.toLowerCase();
        String ministers = MainAPI.getCityInfo(nation, "ministers");
        if (ministers == null) {
            return false;
        }
        return ministers.indexOf(player) != -1;
    }

    public static boolean isNationLeader(String nation, String player) {
        player = player.toLowerCase();
        String nationLeader = MainAPI.getNationInfo(nation, "leader");
        return nationLeader.equals(player);
    }

    public static boolean isCityLeader(String player) {
        if (!MainAPI.isResident(player)) {
            return false;
        }
        String city = MainAPI.getPlayerInfo(player, "city");
        String cityLeader = MainAPI.getCityInfo(city, "leader");
        return cityLeader.equals(player);
    }

    public static boolean isLicentiate(String player) {
        boolean isLicentiate = Boolean.parseBoolean(MainAPI.getPlayerInfo(player = player.toLowerCase(), "isLicentiate"));
        return isLicentiate;
    }

    public static boolean isNationResident(String nation, String player) {
        String city = MainAPI.getPlayerInfo(player = player.toLowerCase(), "city");
        if (city.equals("")) {
            return false;
        }
        String cityNation = MainAPI.getCityInfo(city, "nation");
        return !cityNation.equals("") && cityNation.equals(nation);
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            int intValue = Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isResident(String player) {
        String city = MainAPI.getPlayerInfo(player, "city");
        return !city.equals("");
    }

    public static boolean isCityExist(String city) {
        return MainAPI.isSet("states.city." + city);
    }

    public static boolean isNameCorrect(String name) {
        return name.length() >= 2 && name.matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f-_]+");
    }

    public static boolean canInteractCity(String city, Player p) {
        int remotenessLevel;
        int allowLevel = MainAPI.getAllowLevel(city);
        if (allowLevel < (remotenessLevel = MainAPI.getRemoteness(city, p.getName().toLowerCase()))) {
            p.sendMessage("\u00a7c\u0423\u0440\u043e\u0432\u0435\u043d\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u0430 \u044d\u0442\u043e\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u043d\u0435 \u043f\u043e\u0437\u0432\u043e\u043b\u044f\u0435\u0442 \u0442\u0435\u0431\u0435 \u0441 \u043d\u0438\u043c \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c!");
            return false;
        }
        return true;
    }

    public static boolean canInteractCityDirectly(String city, String privateChunk, Player p) {
        boolean b = MainAPI.canInteractCity(city, p);
        if (!b) {
            return false;
        }
        if (MainAPI.canDoPrivateChunksModule(city, privateChunk, p)) {
            return true;
        }
        p.sendMessage("\u00a7c\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u043e\u0432\u0430\u0442\u044c \u0441 \u044d\u0442\u0438\u043c \u0447\u0430\u043d\u043a\u043e\u043c, \u0442\u0430\u043a \u043a\u0430\u043a \u043e\u043d \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0439 \u0438 \u043d\u0435 \u043f\u0440\u0438\u043d\u0430\u0434\u043b\u0435\u0436\u0438\u0442 \u0442\u0435\u0431\u0435!");
        return false;
    }

    public static boolean canDoPrivateChunksModule(String city, String chunk, Player p) {
        if (MainAPI.isSet("states.city." + city + ".chunks." + chunk)) {
            String player = p.getName().toLowerCase();
            String owner = MainAPI.getCityInfo(city, "chunks." + chunk);
            if (owner == null) {
                return true;
            }
            if (owner.equals(player)) {
                return true;
            }
            return MainAPI.isFriend(player, owner);
        }
        return true;
    }

    public static boolean isHave(Player p, Material m, int amount) {
        return p.getInventory().containsAtLeast(new ItemStack(m), amount);
    }

    public static boolean isFriend(String player, String owner) {
        String friendsString = MainAPI.getPlayerInfo(owner, "friends");
        return SMassiveAPI.contain(friendsString, player);
    }

    public static Location toWorld(Location loc) {
        loc.setY(64.0);
        World world = Bukkit.getWorld((String)"world");
        World locWorld = loc.getWorld();
        if (locWorld.getName().equals("world_nether")) {
            loc.setX(loc.getX() * 8.0);
            loc.setZ(loc.getZ() * 8.0);
        }
        loc.setWorld(world);
        return loc;
    }

    public static int getInt(String path) {
        return Integer.parseInt(main.getInstance().getConfig().getString(path));
    }

    public static void unclaimPrivateChunks(String player) {
        String[] chunks;
        String city = MainAPI.getPlayerInfo(player, "city");
        String chunksString = MainAPI.getPlayerInfo(player, "privateChunks");
        for (String chunk : chunks = SMassiveAPI.toMassive(chunksString)) {
            MainAPI.delPrivateChunk(city, chunk, player);
        }
    }

    public static void unclaimnewOutpostChunks(String city) {
        String[] chunks;
        String chunksString = MainAPI.getCityInfo(city, "newOutpostChunks");
        if (chunksString == null || chunksString.equals("")) {
            return;
        }
        for (String chunk : chunks = chunksString.split(" ,")) {
            MainAPI.delOutpost(city, chunk);
        }
    }

    public static void saveLocation(String path, Location loc) {
        String x = String.valueOf(loc.getBlockX());
        String y = String.valueOf(loc.getBlockY());
        String z = String.valueOf(loc.getBlockZ());
        String world = loc.getWorld().getName();
        String toConfig = world + "," + x + "," + y + "," + z;
        main.getInstance().getConfig().set(path, (Object)toConfig);
    }

    public static void save() {
        main.getInstance().saveConfig();
    }

    public static void set(String path, String str) {
        main.getInstance().getConfig().set(path, (Object)str);
        MainAPI.save();
    }

    public static void setCity(String city, String key, String str) {
        MainAPI.set("states.city." + city + "." + key, str);
        MainAPI.save();
    }

    public static void set(String path, int i) {
        main.getInstance().getConfig().set(path, (Object)i);
        MainAPI.save();
    }

    public static void setCity(String city, String key, int i) {
        MainAPI.set("states.city." + city + "." + key, i);
        MainAPI.save();
    }

    public static void setPlayer(String player, String key, int i) {
        MainAPI.set("states.player." + player + "." + key, i);
    }

    public static void setPlayer(String player, String key, String str) {
        MainAPI.set("states.player." + player + "." + key, str);
    }

    public static void setPrivateChunk(String city, String chunk, String player) {
        MainAPI.setCity(city, "chunks." + chunk, player);
        String privateChunks = MainAPI.getPlayerInfo(player, "privateChunks");
        privateChunks = SMassiveAPI.add(privateChunks, chunk);
        MainAPI.setPlayer(player, "privateChunks", privateChunks);
    }

    public static void setOutpost(String chunk, String city) {
        MainAPI.set("states.chunks." + chunk + ".owner", city);
        String newOutpostChunks = MainAPI.getCityInfo(city, "newOutpostChunks");
        newOutpostChunks = SMassiveAPI.add(newOutpostChunks, chunk);
        MainAPI.setCity(city, "newOutpostChunks", newOutpostChunks);
    }

    public static void delOutpost(String chunk, String city) {
        MainAPI.set("states.chunks." + chunk, null);
        String newOutpostChunks = MainAPI.getCityInfo(city, "newOutpostChunks");
        newOutpostChunks = SMassiveAPI.remove(newOutpostChunks, chunk);
        MainAPI.setCity(city, "newOutpostChunks", newOutpostChunks);
    }

    public static void setNation(String nation, String key, int i) {
        MainAPI.set("states.nation." + nation + "." + key, i);
    }

    public static void setNation(String nation, String key, String str) {
        MainAPI.set("states.nation." + nation + "." + key, str);
    }

    public static void delPrivateChunk(String city, String chunk, String player) {
        MainAPI.setCity(city, "chunks." + chunk, null);
        String privateChunks = MainAPI.getPlayerInfo(player, "privateChunks");
        privateChunks = SMassiveAPI.remove(privateChunks, chunk);
        MainAPI.setPlayer(player, "privateChunks", privateChunks);
    }

    public static Location getLocation(String path) {
        try {
            String[] locationString = main.getInstance().getConfig().getString(path).split(",");
            World world = Bukkit.getWorld((String)locationString[0]);
            double x = Double.valueOf(locationString[1]);
            double y = 64.0;
            double z = Double.valueOf(locationString[3]);
            Location loc = new Location(world, x, y, z);
            return loc;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Location getLocationTP(String path) {
        try {
            String[] locationString = main.getInstance().getConfig().getString(path).split(",");
            World world = Bukkit.getWorld((String)locationString[0]);
            double x = Double.valueOf(locationString[1]);
            double y = Double.valueOf(locationString[2]);
            double z = Double.valueOf(locationString[3]);
            Location loc = new Location(world, x, y, z);
            return loc;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static String getCityInfo(String city, String key) {
        return MainAPI.getString("states.city." + city + "." + key);
    }

    public static String getPlayerInfo(String player, String key) {
        MainAPI.createProfile(player);
        String string = MainAPI.getString("states.player." + player + "." + key);
        return string;
    }

    public static String getNationInfo(String nation, String key) {
        return MainAPI.getString("states.nation." + nation + "." + key);
    }

    public static String getChunkInfo(String chunk, String key) {
        return MainAPI.getString("states.chunks." + chunk + "." + key);
    }

    public static String getOutpostInfo(String chunk, String key) {
        return MainAPI.getString("states.chunks." + chunk + "." + key);
    }

    public static String getPrivateChunkOwner(String city, String chunk) {
        return MainAPI.getString("states.city." + city + ".chunks." + chunk);
    }

    public static String getString(String path) {
        return main.getInstance().getConfig().getString(path);
    }

    public static int getAllowLevel(String city) {
        if (!MainAPI.isSet("states.city." + city + ".allowLevel")) {
            MainAPI.set("states.city." + city + ".allowLevel", 4);
            return 4;
        }
        String allowLevelString = MainAPI.getCityInfo(city, "allowLevel");
        if (allowLevelString.equals("false")) {
            MainAPI.setCity(city, "allowLevel", 4);
            return 4;
        }
        int i = Integer.parseInt(MainAPI.getString("states.city." + city + ".allowLevel"));
        return i;
    }

    public static int getRemoteness(String city, String player) {
        String cityLeader;
        city = city.toLowerCase();
        if ((player = player.toLowerCase()).equals(cityLeader = MainAPI.getCityInfo(city, "leader"))) {
            return 1;
        }
        String playerCity = MainAPI.getPlayerInfo(player, "city");
        if (playerCity.equals(city)) {
            if (MainAPI.isAssistant(player)) {
                return 2;
            }
            return 3;
        }
        String nation = MainAPI.getCityInfo(city, "nation");
        if (nation.equals("")) {
            return 7;
        }
        if (MainAPI.isNationLeader(nation, player)) {
            return 4;
        }
        if (MainAPI.isMinister(nation, player)) {
            return 5;
        }
        if (MainAPI.isNationResident(nation, player)) {
            return 6;
        }
        if (MainAPI.isLicentiate(player)) {
            return 7;
        }
        return 8;
    }

    public static String getChunk(Location loc) {
        Chunk c = loc.getChunk();
        int x = c.getX();
        int z = c.getZ();
        World world = loc.getWorld();
        String worldName = world.getName();
        if (world.getName().equals("world_nether")) {
            x *= 8;
            z *= 8;
        }
        String chunk = x + ";" + z;
        return chunk;
    }

    public static String getChunk(Player p) {
        Location loc = p.getLocation();
        return MainAPI.getChunk(loc);
    }

    public static void checkPositions(Player[] Players) {
        for (Player player : Players) {
        }
    }

    public static void checkPosition(Player p) {
        String player = p.getName();
        String cityLast = positions.get(player);
        String city = StatesAPI.inCity(p);
        if (!city.equals(cityLast)) {
            StatesAPI.cityMove(p, city);
            positions.put(player, city);
        }
    }

    public static void badMessage(Player p, String mes) {
        p.sendMessage("\u00a7c" + mes);
        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
    }

    public static void goodMessage(Player p, String mes) {
        p.sendMessage("\u00a7a" + mes);
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
    }

    public static void stateMessage(Player p, String mes) {
        p.sendMessage("\u00a76\u00a7l\u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430 \u00a78>> \u00a7f" + mes);
        p.playSound(p.getLocation(), Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, 100.0f, 1.0f);
    }

    public static void sendCityMessage(String city, String message) {
        String residentsString = main.getInstance().getConfig().getString("states.city." + city + ".residents");
        String[] residents = SMassiveAPI.toMassive(residentsString);
        for (int i = 0; i < residents.length; ++i) {
            try {
                Player p = Bukkit.getPlayer((String)residents[i]);
                MainAPI.stateMessage(p, "\u00a76\u00a7l\u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430 \u00a78>> \u00a7f" + message);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static void sendGlobalMessage(String message) {
        Player[] players;
        for (Player p : players = Bukkit.getOnlinePlayers().toArray((T[])new Player[0])) {
            try {
                MainAPI.stateMessage(p, message);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static void sendNationMessage(String nation, String message) {
        String citiesString = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
        String[] cities = citiesString.split(", ");
        for (int i = 0; i < cities.length; ++i) {
            try {
                MainAPI.sendCityMessage(cities[i], message);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static void sendMessage(Player p, String message) {
        p.sendMessage(message.replace("&", "\u00a7"));
    }
}

