/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils
 *  org.bukkit.entity.Player
 *  org.jetbrains.annotations.NotNull
 */
package states;

import java.util.Date;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;
import states.API.SMassiveAPI;
import states.API.StatesAPI;
import states.dynmapModule;
import states.main;

public class cityMain
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        String cityLeader;
        String city;
        String city2;
        String cityLeader2;
        String city3;
        String senderCity;
        if (sender == null) {
            cityMain.$$$reportNull$$$0(0);
        }
        if (cmd == null) {
            cityMain.$$$reportNull$$$0(1);
        }
        if (s == null) {
            cityMain.$$$reportNull$$$0(2);
        }
        if (args == null) {
            cityMain.$$$reportNull$$$0(3);
        }
        MainAPI.createProfile(sender);
        String player = sender.getName().toLowerCase();
        Player p = Bukkit.getServer().getPlayer(player);
        if (args.length == 0) {
            if (!MainAPI.isResident(player)) {
                MainAPI.badMessage(p, "\u00a7c\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String city4 = main.getInstance().getConfig().getString("states.player." + player + ".city");
            String cityName = main.getInstance().getConfig().getString("states.city." + city4 + ".name");
            String residents = main.getInstance().getConfig().getString("states.city." + city4 + ".residents");
            String nation = main.getInstance().getConfig().getString("states.city." + city4 + ".nation");
            String nationName = MainAPI.getNationInfo(nation, "name");
            String corporation = main.getInstance().getConfig().getString("states.city." + city4 + ".corporationGovernment.company");
            String leader = main.getInstance().getConfig().getString("states.city." + city4 + ".leader");
            String board = main.getInstance().getConfig().getString("states.city." + city4 + ".board");
            String level = main.getInstance().getConfig().getString("states.city." + city4 + ".level");
            String residentsAmount = main.getInstance().getConfig().getString("states.city." + city4 + ".rang");
            String currencyID = main.getInstance().getConfig().getString("states.city." + city4 + ".currencyID");
            String regionID = main.getInstance().getConfig().getString("states.city." + city4 + ".regionID");
            String deputats = main.getInstance().getConfig().getString("states.city." + city4 + ".deputats");
            String askingPlayers = main.getInstance().getConfig().getString("states.city." + city4 + ".askingPlayers");
            if (deputats.equals("")) {
                deputats = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (askingPlayers.equals("")) {
                askingPlayers = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (nation.equals("")) {
                nationName = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442";
            }
            if (corporation.equals("")) {
                corporation = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442";
            }
            if (currencyID.equals("")) {
                currencyID = "\u0432\u0430\u043b\u044e\u0442\u0430 \u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u0430";
            }
            sender.sendMessage("\u00a76" + cityName);
            sender.sendMessage("");
            sender.sendMessage("\u00a7o" + board);
            sender.sendMessage("");
            sender.sendMessage("\u00a76\u041c\u044d\u0440 \u0433\u043e\u0440\u043e\u0434\u0430\u00a78: \u00a77" + leader);
            sender.sendMessage("\u00a76\u0410\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u044b\u00a78: \u00a77" + deputats);
            sender.sendMessage("\u00a76\u0416\u0438\u0442\u0435\u043b\u0438 \u00a78(\u00a77" + residentsAmount + "\u00a78):\u00a77 " + residents);
            sender.sendMessage("\u00a76\u0418\u0433\u0440\u043e\u043a\u0438, \u043f\u0440\u043e\u0441\u044f\u0449\u0438\u0435\u0441\u044f \u0432 \u0433\u043e\u0440\u043e\u0434\u00a78:\u00a77 " + askingPlayers);
            sender.sendMessage("\u00a76\u0420\u0430\u043d\u0433\u00a78:\u00a77 " + level);
            sender.sendMessage("\u00a76\u041d\u0430\u0446\u0438\u044f\u00a78:\u00a77 " + nationName);
            sender.sendMessage("\u00a76\u041a\u043e\u0440\u043f\u043e\u0440\u0430\u0446\u0438\u044f-\u0432\u043b\u0430\u0434\u0435\u043b\u0435\u0446\u00a78:\u00a77 " + corporation);
            sender.sendMessage("\u00a76ID \u0432\u0430\u043b\u044e\u0442\u044b\u00a78:\u00a77 " + currencyID);
            sender.sendMessage("\u00a76ID \u0433\u043e\u0440\u043e\u0434\u0430\u00a78:\u00a77 " + regionID);
            return true;
        }
        if (args[0].equals("info")) {
            String city5 = args[1].toLowerCase();
            if (!MainAPI.isCityExist(city5)) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            String cityName = main.getInstance().getConfig().getString("states.city." + city5 + ".name");
            String residents = main.getInstance().getConfig().getString("states.city." + city5 + ".residents");
            String nation = main.getInstance().getConfig().getString("states.city." + city5 + ".nation");
            String nationName = MainAPI.getNationInfo(nation, "name");
            String corporation = main.getInstance().getConfig().getString("states.city." + city5 + ".corporationGovernment.company");
            String leader = main.getInstance().getConfig().getString("states.city." + city5 + ".leader");
            String board = main.getInstance().getConfig().getString("states.city." + city5 + ".board");
            String level = main.getInstance().getConfig().getString("states.city." + city5 + ".level");
            String residentsAmount = main.getInstance().getConfig().getString("states.city." + city5 + ".rang");
            String currencyID = main.getInstance().getConfig().getString("states.city." + city5 + ".currencyID");
            String regionID = main.getInstance().getConfig().getString("states.city." + city5 + ".regionID");
            String deputats = main.getInstance().getConfig().getString("states.city." + city5 + ".deputats");
            if (deputats.equals("")) {
                deputats = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (nation.equals("")) {
                nationName = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442";
            }
            if (corporation.equals("")) {
                corporation = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442";
            }
            if (currencyID.equals("")) {
                currencyID = "\u0432\u0430\u043b\u044e\u0442\u0430 \u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u0430";
            }
            sender.sendMessage("\u00a76" + cityName);
            sender.sendMessage("");
            sender.sendMessage("\u00a7o" + board);
            sender.sendMessage("");
            sender.sendMessage("\u00a76\u041c\u044d\u0440 \u0433\u043e\u0440\u043e\u0434\u0430\u00a78: \u00a77" + leader);
            sender.sendMessage("\u00a76\u0410\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u044b\u00a78: \u00a77" + deputats);
            sender.sendMessage("\u00a76\u0416\u0438\u0442\u0435\u043b\u0438 \u00a78(\u00a77" + residentsAmount + "\u00a78):\u00a77 " + residents);
            sender.sendMessage("\u00a76\u0420\u0430\u043d\u0433\u00a78:\u00a77 " + level);
            sender.sendMessage("\u00a76\u041d\u0430\u0446\u0438\u044f\u00a78:\u00a77 " + nationName);
            sender.sendMessage("\u00a76\u041a\u043e\u0440\u043f\u043e\u0440\u0430\u0446\u0438\u044f-\u0432\u043b\u0430\u0434\u0435\u043b\u0435\u0446\u00a78:\u00a77 " + corporation);
            sender.sendMessage("\u00a76ID \u0432\u0430\u043b\u044e\u0442\u044b\u00a78:\u00a77 " + currencyID);
            sender.sendMessage("\u00a76ID \u0433\u043e\u0440\u043e\u0434\u0430\u00a78:\u00a77 " + regionID);
            return true;
        }
        if (args[0].equals("new")) {
            String name = args[1].toLowerCase();
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city new \u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            if (args.length > 2) {
                Object message = "";
                for (int i = 1; i < args.length; ++i) {
                    message = String.valueOf(message) + args[i] + "_";
                }
                StringUtils.chop((String)message);
                args[1] = message;
            }
            if (!MainAPI.isNameCorrect(name)) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u0438\u0437 2 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432, \u0442\u0430\u043a\u0436\u0435 \u043e\u043d\u043e \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b, \u0446\u0438\u0444\u0440\u044b, \u0442\u0438\u0440\u0435 \u0438 \u0437\u043d\u0430\u043a\u0438 \u043f\u043e\u0434\u0447\u0451\u0440\u043a\u0438\u0432\u0430\u043d\u0438\u044f.");
                return true;
            }
            if (MainAPI.isCityExist(name)) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            if (MainAPI.isResident(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u0432 \u043a\u0430\u043a\u043e\u043c-\u0442\u043e \u0433\u043e\u0440\u043e\u0434\u0435!");
                return true;
            }
            if (!StatesAPI.canCreate(sender)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0442\u0443\u0442 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0433\u043e\u0440\u043e\u0434, \u0442\u0430\u043a \u043a\u0430\u043a \u0442\u044b \u043d\u0430\u0445\u043e\u0434\u0438\u0448\u044c\u0441\u044f \u043d\u0430 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0438 \u0434\u0440\u0443\u0433\u043e\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0438\u043b\u0438 \u0440\u044f\u0434\u043e\u043c \u0441 \u043d\u0438\u043c");
                return true;
            }
            if (Bukkit.getPlayer((String)sender.getName()).getItemInHand().getType() != Material.NETHERITE_INGOT) {
                MainAPI.badMessage(p, "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u0433\u043e\u0440\u043e\u0434\u0430 - \u00a761 \u00a78\u043d\u0435\u0437\u0435\u0440\u0438\u0442\u043e\u0432\u044b\u0439 \u0441\u043b\u0438\u0442\u043e\u043a\u00a7c! \u0414\u043e\u0431\u0443\u0434\u044c \u044d\u0442\u043e\u0442 \u0441\u043b\u0438\u0442\u043e\u043a, \u0432\u043e\u0437\u044c\u043c\u0438 \u0435\u0433\u043e \u0432 \u0440\u0443\u043a\u0443 \u0438 \u043f\u043e\u043f\u0440\u043e\u0431\u0443\u0439 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0433\u043e\u0440\u043e\u0434 \u0441\u043d\u043e\u0432\u0430.");
                return true;
            }
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "clear " + player + " netherite_ingot 1");
            String askCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".askCity");
            if (!Objects.equals(askCity, "")) {
                String askingPlayers = main.getInstance().getConfig().getString("states.city." + askCity + ".askingPlayers");
                askingPlayers = SMassiveAPI.remove(askingPlayers, player);
                main.getInstance().getConfig().set("states.city." + askCity + ".askingPlayers", (Object)askingPlayers);
                main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".askCity", (Object)"");
                main.getInstance().saveConfig();
            }
            Date current = new Date();
            long dateDelete = current.getTime() + 345600000L;
            long date = current.getTime();
            String city6 = args[1].toLowerCase();
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".city", (Object)city6);
            main.getInstance().getConfig().set("states.city." + city6 + ".name", (Object)args[1]);
            main.getInstance().getConfig().set("states.city." + city6 + ".board", (Object)"\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043d\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e");
            main.getInstance().getConfig().set("states.city." + city6 + ".leader", (Object)sender.getName().toLowerCase());
            main.getInstance().getConfig().set("states.city." + city6 + ".deputats", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".isCapital", (Object)"false");
            main.getInstance().getConfig().set("states.city." + city6 + ".nationStatus", (Object)"free");
            main.getInstance().getConfig().set("states.city." + city6 + ".regionID", (Object)("c" + date));
            main.getInstance().getConfig().set("states.city." + city6 + ".currencyID", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".nation", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".allowLevel", (Object)"false");
            Player located = Bukkit.getServer().getPlayer(sender.getName());
            Location loc = located.getLocation();
            MainAPI.saveLocation("states.city." + city6 + ".home", loc);
            main.getInstance().getConfig().set("states.city." + city6 + ".corporationGovernment.company", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".rang", (Object)"1");
            main.getInstance().getConfig().set("states.city." + city6 + ".level", (Object)"I");
            main.getInstance().getConfig().set("states.city." + city6 + ".radius", (Object)"50");
            main.getInstance().getConfig().set("states.city." + city6 + ".askingPlayers", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".askNation", (Object)"");
            main.getInstance().getConfig().set("states.city." + city6 + ".limit.resident", (Object)"1");
            main.getInstance().getConfig().set("states.city." + city6 + ".limit.assistant", (Object)"5");
            main.getInstance().getConfig().set("states.city." + city6 + ".residents", (Object)sender.getName().toLowerCase());
            main.getInstance().getConfig().set("states.city." + city6 + ".deleteDate", (Object)dateDelete);
            String cityList = main.getInstance().getConfig().getString("states.cityList");
            if (Objects.equals(cityList, "start")) {
                main.getInstance().getConfig().set("states.cityList", (Object)city6);
            } else {
                String cityListNew = String.join((CharSequence)", ", main.getInstance().getConfig().getString("states.cityList"), city6);
                main.getInstance().getConfig().set("states.cityList", (Object)cityListNew);
            }
            MainAPI.sendGlobalMessage("\u0418\u0433\u0440\u043e\u043a \u00a77" + sender.getName() + "\u00a7f \u043e\u0441\u043d\u043e\u0432\u0430\u043b \u0433\u043e\u0440\u043e\u0434 \u00a76" + args[1]);
            main.getInstance().saveConfig();
            dynmapModule.createCity(sender);
            return true;
        }
        if (args[0].equals("delete")) {
            String city7 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (!MainAPI.isResident(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!MainAPI.isCityLeader(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            MainAPI.badMessage(p, "\u0422\u044b \u0442\u043e\u0447\u043d\u043e \u0445\u043e\u0447\u0435\u0448\u044c \u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0438\u0442\u044c \u0441\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434? \u041d\u0430\u043f\u0438\u0448\u0438 \u00a76/city confirmdelete\u00a7c, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0443\u0434\u0430\u043b\u0435\u043d\u0438\u0435");
            return true;
        }
        if (args[0].equals("confirmdelete")) {
            int i;
            String city8 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (!MainAPI.isResident(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!MainAPI.isCityLeader(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            String nation = main.getInstance().getConfig().getString("states.city." + city8 + ".nation");
            String capital = main.getInstance().getConfig().getString("states.nation." + nation + ".capital");
            if (Objects.equals(capital, city8)) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 - \u0441\u0442\u043e\u043b\u0438\u0446\u0430 \u043d\u0430\u0446\u0438\u0438! \u0420\u0430\u0441\u0444\u043e\u0440\u043c\u0438\u0440\u0443\u0439 \u043d\u0430\u0446\u0438\u044e \u0438\u043b\u0438 \u043f\u0435\u0440\u0435\u043d\u0435\u0441\u0438 \u0441\u0442\u043e\u043b\u0438\u0446\u0443, \u0447\u0442\u043e\u0431\u044b \u0443\u0434\u0430\u043b\u0438\u0442\u044c \u0433\u043e\u0440\u043e\u0434.");
                return true;
            }
            if (!Objects.equals(nation, "")) {
                String residentsString = main.getInstance().getConfig().getString("states.city." + city8 + ".residents");
                String[] residents = SMassiveAPI.toMassive(residentsString);
                String ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers");
                for (i = 0; i < residents.length; ++i) {
                    if (ministers.indexOf(residents[i]) == -1) continue;
                    ministers = SMassiveAPI.remove(ministers, residents[i]);
                    main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministers);
                    main.getInstance().saveConfig();
                }
                String cities = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
                cities = SMassiveAPI.remove(cities, city8);
                int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.nation." + nation + ".rang")));
                main.getInstance().getConfig().set("states.nation." + nation + ".rang", (Object)(--r));
                main.getInstance().getConfig().set("states.nation." + nation + ".cities", (Object)cities);
                main.getInstance().saveConfig();
            }
            dynmapModule.deleteCity(city8);
            String cityName = main.getInstance().getConfig().getString("states.city." + city8 + ".name");
            String residentsString = Objects.requireNonNull(main.getInstance().getConfig().getString("states.city." + city8 + ".residents"));
            String[] residents = SMassiveAPI.toMassive(residentsString);
            for (i = 0; i < residents.length; ++i) {
                main.getInstance().getConfig().set("states.player." + residents[i] + ".city", (Object)"");
            }
            main.getInstance().getConfig().set("states.city." + city8, null);
            String cityList = main.getInstance().getConfig().getString("states.cityList");
            cityList = SMassiveAPI.remove(cityList, city8);
            main.getInstance().getConfig().set("states.cityList", (Object)cityList);
            MainAPI.sendGlobalMessage("\u0413\u043e\u0440\u043e\u0434 \u00a76" + cityName + "\u00a7f \u0431\u044b\u043b \u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0435\u043d");
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("join")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city join \u00a77\u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            if (args[1].length() < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430: \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u043a\u0430\u043a \u043c\u0438\u043d\u0438\u043c\u0443\u043c 2 \u0441\u0438\u043c\u0432\u043e\u043b\u0430");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f-_]+")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430: \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b \u0438 \u0446\u0438\u0444\u0440\u044b");
                return true;
            }
            if (!main.getInstance().getConfig().isSet("states.city." + args[1].toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            String senderCity2 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (!Objects.equals(senderCity2, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u0432 \u0433\u043e\u0440\u043e\u0434\u0435 \u00a76" + senderCity2);
                return true;
            }
            String askCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".askCity");
            if (!Objects.equals(askCity, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u043f\u043e\u0434\u0430\u043b \u0437\u0430\u044f\u0432\u043a\u0443 \u0432 \u0433\u043e\u0440\u043e\u0434 \u00a76" + askCity);
                return true;
            }
            String city9 = args[1].toLowerCase();
            String askingPlayers = String.join((CharSequence)", ", main.getInstance().getConfig().getString("states.city." + city9 + ".askingPlayers"), sender.getName().toLowerCase());
            main.getInstance().getConfig().set("states.city." + city9 + ".askingPlayers", (Object)askingPlayers);
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".askCity", (Object)city9);
            MainAPI.goodMessage(p, "\u0422\u044b \u043f\u043e\u0434\u0430\u043b \u0437\u0430\u044f\u0432\u043a\u0443 \u043d\u0430 \u0432\u0441\u0442\u0443\u043f\u043b\u0435\u043d\u0438\u0435 \u0432 \u0433\u043e\u0440\u043e\u0434 \u00a76" + city9);
            MainAPI.sendCityMessage(city9, "\u0412 \u0432\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u043f\u0440\u043e\u0441\u0438\u043b\u0441\u044f \u0438\u0433\u0440\u043e\u043a \u00a76" + sender.getName() + "\u00a7f!");
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("board")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city board \u00a77\u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f]+")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0435 \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435: \u043d\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439 \u0437\u0430\u043f\u044f\u0442\u044b\u0435 \u0438 \u0441\u043f\u0435\u0446\u0438\u0430\u043b\u044c\u043d\u044b\u0435 \u0441\u0438\u043c\u0432\u043e\u043b\u044b.");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String senderCity3 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String cityLeader3 = main.getInstance().getConfig().getString("states.city." + senderCity3 + ".leader");
            String city10 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String deputats = main.getInstance().getConfig().getString("states.city." + city10 + ".deputats");
            if (!Objects.equals(cityLeader3, sender.getName().toLowerCase()) && deputats.indexOf(sender.getName().toLowerCase()) == -1) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0438 \u043d\u0435 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            Object board = "";
            for (int i = 1; i < args.length; ++i) {
                board = String.valueOf(board) + args[i] + " ";
            }
            main.getInstance().getConfig().set("states.city." + city10 + ".board", board);
            MainAPI.sendCityMessage(city10, " \u00a7f\u0414\u043b\u044f \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u00a77\"" + (String)board + "\"");
            dynmapModule.updateCityDescription(city10);
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("accept")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u00a7c\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city accept \u00a77\u043d\u0438\u043a");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u00a7c\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String senderCity4 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String askCity = main.getInstance().getConfig().getString("states.player." + args[1].toLowerCase() + ".askCity");
            String cityLeader4 = main.getInstance().getConfig().getString("states.city." + senderCity4 + ".leader");
            if (!senderCity4.equals(askCity)) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u043f\u0440\u043e\u0441\u0438\u0442\u0441\u044f \u0432 \u0442\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434");
                return true;
            }
            String city11 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String deputats = main.getInstance().getConfig().getString("states.city." + city11 + ".deputats");
            if (!Objects.equals(cityLeader4, sender.getName().toLowerCase()) && deputats.indexOf(sender.getName().toLowerCase()) == -1) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0438 \u043d\u0435 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            String residents = main.getInstance().getConfig().getString("states.city." + senderCity4 + ".residents");
            String newResidents = String.join((CharSequence)", ", residents, args[1].toLowerCase());
            String askingPlayers = main.getInstance().getConfig().getString("states.city." + city11 + ".askingPlayers");
            askingPlayers = SMassiveAPI.remove(askingPlayers, args[1].toLowerCase());
            int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.city." + city11 + ".rang")));
            main.getInstance().getConfig().set("states.city." + city11 + ".rang", (Object)(++r));
            main.getInstance().getConfig().set("states.player." + args[1].toLowerCase() + ".askCity", (Object)"");
            main.getInstance().getConfig().set("states.player." + args[1].toLowerCase() + ".city", (Object)city11);
            main.getInstance().getConfig().set("states.city." + city11 + ".askingPlayers", (Object)askingPlayers);
            main.getInstance().getConfig().set("states.city." + city11 + ".residents", (Object)newResidents);
            MainAPI.sendCityMessage(city11, "\u041a \u0432\u0430\u0448\u0435\u043c\u0443 \u0433\u043e\u0440\u043e\u0434\u0443 \u043f\u0440\u0438\u0441\u043e\u0435\u0434\u0438\u043d\u0438\u043b\u0441\u044f \u0438\u0433\u0440\u043e\u043a \u00a77" + args[1].toLowerCase());
            try {
                String accepted = args[1].toLowerCase();
                Player a = Bukkit.getPlayer((String)accepted);
                MainAPI.stateMessage(a, sender.getName() + " \u043f\u0440\u0438\u043d\u044f\u043b \u0442\u0435\u0431\u044f \u0432 \u0433\u043e\u0440\u043e\u0434 " + city11);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            dynmapModule.updateCityDescription(city11);
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("joinother")) {
            String city12 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (!Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u0432 \u0433\u043e\u0440\u043e\u0434\u0435 \u00a76" + city12 + "\u00a7c. \u0415\u0441\u043b\u0438 \u0445\u043e\u0447\u0435\u0448\u044c \u0437\u0430\u0439\u0442\u0438 \u0432 \u0434\u0440\u0443\u0433\u043e\u0439 \u0433\u043e\u0440\u043e\u0434, \u0432\u044b\u0439\u0434\u0438 \u0438\u0437 \u044d\u0442\u043e\u0433\u043e \u043a\u043e\u043c\u0430\u043d\u0434\u043e\u0439 \u00a76/city leave\u00a7c.");
                return true;
            }
            String askCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".askCity");
            if (Objects.equals(askCity, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043f\u043e\u0434\u0430\u0432\u0430\u043b \u0437\u0430\u044f\u0432\u043a\u0443 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u0433\u043e\u0440\u043e\u0434!");
                return true;
            }
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".askCity", (Object)"");
            MainAPI.badMessage(p, "\u0422\u044b \u043e\u0442\u043c\u0435\u043d\u0438\u043b \u0441\u0432\u043e\u044e \u0437\u0430\u044f\u0432\u043a\u0443 \u0432 \u0433\u043e\u0440\u043e\u0434 " + askCity);
            main.getInstance().saveConfig();
            String askingPlayers = main.getInstance().getConfig().getString("states.city." + askCity + ".askingPlayers");
            askingPlayers = SMassiveAPI.remove(askingPlayers, player);
            main.getInstance().getConfig().set("states.city." + askCity + ".askingPlayers", (Object)askingPlayers);
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("leave")) {
            String ministers;
            String nation;
            String city13 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city13, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u0432 \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String cityLeader5 = main.getInstance().getConfig().getString("states.city." + city13 + ".leader");
            if (Objects.equals(cityLeader5, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430! \u0420\u0430\u0441\u0444\u043e\u0440\u043c\u0438\u0440\u0443\u0439 \u0433\u043e\u0440\u043e\u0434 \u0438\u043b\u0438 \u043f\u0435\u0440\u0435\u0434\u0430\u0439 \u0432\u043b\u0430\u0441\u0442\u044c \u043a\u043e\u043c\u0443-\u043d\u0438\u0431\u0443\u0434\u044c \u0434\u0440\u0443\u0433\u043e\u043c\u0443, \u0447\u0442\u043e\u0431\u044b \u0432\u044b\u0439\u0442\u0438 \u0438\u0437 \u043d\u0435\u0433\u043e.");
                return true;
            }
            String deputats = main.getInstance().getConfig().getString("states.city." + city13 + ".deputats");
            if (deputats.indexOf(sender.getName().toLowerCase()) != -1) {
                deputats = SMassiveAPI.remove(deputats, player);
                main.getInstance().getConfig().set("states.city." + city13 + ".deputats", (Object)deputats);
            }
            if (!Objects.equals(nation = main.getInstance().getConfig().getString("states.city." + city13 + ".nation"), "") && (ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers")).indexOf(sender.getName().toLowerCase()) != -1) {
                ministers = SMassiveAPI.remove(ministers, player);
                main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministers);
            }
            MainAPI.unclaimPrivateChunks(player);
            String residents = main.getInstance().getConfig().getString("states.city." + city13 + ".residents");
            residents = SMassiveAPI.remove(residents, player);
            MainAPI.goodMessage(p, "\u0412\u044b \u0432\u044b\u0448\u043b\u0438 \u0438\u0437 \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76" + city13);
            int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.city." + city13 + ".rang")));
            main.getInstance().getConfig().set("states.city." + city13 + ".rang", (Object)(--r));
            main.getInstance().getConfig().set("states.city." + city13 + ".residents", (Object)residents);
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".city", (Object)"");
            MainAPI.sendCityMessage(city13, "\u0418\u0437 \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0432\u044b\u0448\u0435\u043b \u0438\u0433\u0440\u043e\u043a \u00a76" + sender.getName());
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("kick")) {
            String kickedCity;
            String ministers;
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city kick \u00a77\u043d\u0438\u043a");
                return true;
            }
            String kickedPlayer = args[1].toLowerCase();
            String city14 = main.getInstance().getConfig().getString("states.player." + player + ".city");
            if (Objects.equals(city14, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u0432 \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String senderCity5 = main.getInstance().getConfig().getString("states.player." + player + ".city");
            String deputats = main.getInstance().getConfig().getString("states.city." + senderCity5 + ".deputats");
            String cityLeader6 = main.getInstance().getConfig().getString("states.city." + senderCity5 + ".leader");
            if (!Objects.equals(cityLeader6, sender.getName().toLowerCase()) && deputats.indexOf(sender.getName().toLowerCase()) == -1) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0438 \u043d\u0435 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            String nation = main.getInstance().getConfig().getString("states.city." + senderCity5 + ".nation");
            if (!Objects.equals(nation, "") && (ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers")).indexOf(args[1]) != -1) {
                ministers = SMassiveAPI.remove(ministers, args[1].toLowerCase());
                main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministers);
            }
            if (!Objects.equals(senderCity5, kickedCity = main.getInstance().getConfig().getString("states.player." + args[1].toLowerCase() + ".city"))) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[1] + " \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (sender.getName().equalsIgnoreCase(args[1])) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043a\u0438\u043a\u043d\u0443\u0442\u044c \u0441\u0430\u043c\u043e\u0433\u043e \u0441\u0435\u0431\u044f");
                return true;
            }
            if (deputats.indexOf(args[1].toLowerCase()) != -1) {
                deputats = SMassiveAPI.remove(deputats, kickedPlayer);
                main.getInstance().getConfig().set("states.city." + senderCity5 + ".deputats", (Object)deputats);
            }
            MainAPI.unclaimPrivateChunks(kickedPlayer);
            String residents = main.getInstance().getConfig().getString("states.city." + senderCity5 + ".residents");
            residents = SMassiveAPI.remove(residents, args[1].toLowerCase());
            MainAPI.goodMessage(p, "\u0422\u044b \u043a\u0438\u043a\u043d\u0443\u043b \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[1] + "\u00a7a \u0438\u0437 \u0433\u043e\u0440\u043e\u0434\u0430");
            int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.city." + senderCity5 + ".rang")));
            main.getInstance().getConfig().set("states.city." + senderCity5 + ".rang", (Object)(--r));
            main.getInstance().getConfig().set("states.city." + senderCity5 + ".residents", (Object)residents);
            main.getInstance().getConfig().set("states.player." + args[1].toLowerCase() + ".city", (Object)"");
            MainAPI.sendCityMessage(senderCity5, "\u00a76\u00a7l\u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430 \u00a78>> \u00a76" + args[1] + " \u00a7f\u0431\u044b\u043b \u0438\u0437\u0433\u043d\u0430\u043d \u0438\u0437 \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0438\u0433\u0440\u043e\u043a\u043e\u043c " + sender.getName());
            main.getInstance().saveConfig();
            try {
                Player pKicked = Bukkit.getPlayer((String)kickedPlayer);
                MainAPI.stateMessage(pKicked, sender.getName() + " \u043a\u0438\u043a\u043d\u0443\u043b \u0442\u0435\u0431\u044f \u0438\u0437 \u0433\u043e\u0440\u043e\u0434\u0430 " + senderCity5);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            dynmapModule.updateCityDescription(senderCity5);
            return true;
        }
        if (args[0].equals("assistant")) {
            if (args.length < 3) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city assistant set/remove \u00a77\u043d\u0438\u043a");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            senderCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            city3 = main.getInstance().getConfig().getString("states.player." + args[2].toLowerCase() + ".city");
            cityLeader2 = main.getInstance().getConfig().getString("states.city." + senderCity + ".leader");
            if (!Objects.equals(senderCity, city3)) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u0442\u0432\u043e\u0435\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!Objects.equals(cityLeader2, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            String deputats = main.getInstance().getConfig().getString("states.city." + city3 + ".deputats");
            if (args[1].equals("set")) {
                if (deputats.indexOf(args[2].toLowerCase()) != -1) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0443\u0436\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u043e\u043c \u0432 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                    return true;
                }
                String deputatsNew = String.join((CharSequence)", ", deputats, args[2].toLowerCase());
                main.getInstance().getConfig().set("states.city." + city3 + ".deputats", (Object)deputatsNew);
                MainAPI.sendCityMessage(city3, "\u00a76" + args[2] + "\u00a7f \u0431\u044b\u043b \u043d\u0430\u0437\u043d\u0430\u0447\u0435\u043d \u043d\u0430 \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u044c \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u0430 \u043c\u044d\u0440\u043e\u043c \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0430\u0437\u043d\u0430\u0447\u0438\u043b \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[2].toLowerCase() + "\u00a7f \u043d\u0430 \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u044c \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u0430.");
                dynmapModule.updateCityDescription(senderCity);
                return true;
            }
            if (args[1].equals("remove")) {
                if (deputats.indexOf(args[2].toLowerCase()) == -1) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0438 \u0442\u0430\u043a \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u043e\u043c \u0442\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                    return true;
                }
                deputats = SMassiveAPI.remove(deputats, args[2].toLowerCase());
                main.getInstance().getConfig().set("states.city." + city3 + ".deputats", (Object)deputats);
                MainAPI.sendCityMessage(city3, "\u00a7c\u0422\u044b \u043d\u0430\u0437\u043d\u0430\u0447\u0438\u043b \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[2] + "\u00a7f \u0431\u044b\u043b \u0441\u043d\u044f\u0442 \u0441 \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u0430 \u043c\u044d\u0440\u043e\u043c \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                dynmapModule.updateCityDescription(senderCity);
                return true;
            }
        }
        if (args[0].equals("uprang")) {
            city2 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city2, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            Integer rang = main.getInstance().getConfig().getInt("states.city." + city2 + ".rang");
            String level = main.getInstance().getConfig().getString("states.city." + city2 + ".level");
            String leader = main.getInstance().getConfig().getString("states.city." + city2 + ".leader");
            if (!leader.equals(sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            if (level.equals("I")) {
                if (StatesAPI.collides(city2, 30)) {
                    MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0440\u0430\u0441\u0448\u0438\u0440\u0438\u0442\u044c \u0441\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u0432 \u0441\u043b\u0443\u0447\u0430\u0435 \u0440\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u0438\u044f \u043e\u043d \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0435\u0441\u0435\u043a\u0430\u0442\u044c\u0441\u044f \u0441 \u0434\u0440\u0443\u0433\u0438\u043c");
                    return true;
                }
                if (rang < 5) {
                    MainAPI.badMessage(p, "\u0412 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0434\u043b\u044f \u043f\u043e\u0432\u044b\u0448\u0435\u043d\u0438\u044f \u0440\u0430\u043d\u0433\u0430! \u0422\u0435\u0431\u0435 \u043d\u0443\u0436\u043d\u043e \u0438\u043c\u0435\u0442\u044c 5 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c II \u0440\u0430\u043d\u0433");
                    return true;
                }
                main.getInstance().getConfig().set("states.city." + city2 + ".level", (Object)"II");
                main.getInstance().getConfig().set("states.city." + city2 + ".radius", (Object)"80");
                MainAPI.sendCityMessage(city2, " \u00a7f\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u0432\u044b\u0441\u0438\u043b \u0440\u0430\u043d\u0433! \u0422\u0435\u043f\u0435\u0440\u044c \u043e\u043d \u0438\u043c\u0435\u0435\u0442 \u0440\u0430\u043d\u0433 \u00a76II");
                dynmapModule.updateCityRadius(city2);
            }
            if (level.equals("II")) {
                if (StatesAPI.collides(city2, 50)) {
                    MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0440\u0430\u0441\u0448\u0438\u0440\u0438\u0442\u044c \u0441\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u0432 \u0441\u043b\u0443\u0447\u0430\u0435 \u0440\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u0438\u044f \u043e\u043d \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0435\u0441\u0435\u043a\u0430\u0442\u044c\u0441\u044f \u0441 \u0434\u0440\u0443\u0433\u0438\u043c");
                    return true;
                }
                if (rang < 10) {
                    MainAPI.badMessage(p, "\u0412 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0434\u043b\u044f \u043f\u043e\u0432\u044b\u0448\u0435\u043d\u0438\u044f \u0440\u0430\u043d\u0433\u0430! \u0422\u0435\u0431\u0435 \u043d\u0443\u0436\u043d\u043e \u0438\u043c\u0435\u0442\u044c 10 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c III \u0440\u0430\u043d\u0433");
                    return true;
                }
                main.getInstance().getConfig().set("states.city." + city2 + ".level", (Object)"III");
                main.getInstance().getConfig().set("states.city." + city2 + ".radius", (Object)"130");
                MainAPI.sendCityMessage(city2, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u0432\u044b\u0441\u0438\u043b \u0440\u0430\u043d\u0433! \u0422\u0435\u043f\u0435\u0440\u044c \u043e\u043d \u0438\u043c\u0435\u0435\u0442 \u0440\u0430\u043d\u0433 \u00a76III");
                dynmapModule.updateCityRadius(city2);
            }
            if (level.equals("III")) {
                if (StatesAPI.collides(city2, 60)) {
                    MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0440\u0430\u0441\u0448\u0438\u0440\u0438\u0442\u044c \u0441\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u0432 \u0441\u043b\u0443\u0447\u0430\u0435 \u0440\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u0438\u044f \u043e\u043d \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0435\u0441\u0435\u043a\u0430\u0442\u044c\u0441\u044f \u0441 \u0434\u0440\u0443\u0433\u0438\u043c");
                    return true;
                }
                if (rang < 20) {
                    MainAPI.badMessage(p, "\u0412 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0434\u043b\u044f \u043f\u043e\u0432\u044b\u0448\u0435\u043d\u0438\u044f \u0440\u0430\u043d\u0433\u0430! \u0422\u0435\u0431\u0435 \u043d\u0443\u0436\u043d\u043e \u0438\u043c\u0435\u0442\u044c 20 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c IV \u0440\u0430\u043d\u0433");
                    return true;
                }
                main.getInstance().getConfig().set("states.city." + city2 + ".level", (Object)"IV");
                main.getInstance().getConfig().set("states.city." + city2 + ".radius", (Object)"190");
                MainAPI.sendCityMessage(city2, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u0432\u044b\u0441\u0438\u043b \u0440\u0430\u043d\u0433! \u0422\u0435\u043f\u0435\u0440\u044c \u043e\u043d \u0438\u043c\u0435\u0435\u0442 \u0440\u0430\u043d\u0433 \u00a76IV");
                dynmapModule.updateCityRadius(city2);
            }
            if (level.equals("IV")) {
                if (StatesAPI.collides(city2, 60)) {
                    MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0440\u0430\u0441\u0448\u0438\u0440\u0438\u0442\u044c \u0441\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u0432 \u0441\u043b\u0443\u0447\u0430\u0435 \u0440\u0430\u0441\u0448\u0438\u0440\u0435\u043d\u0438\u044f \u043e\u043d \u0431\u0443\u0434\u0435\u0442 \u043f\u0435\u0440\u0435\u0441\u0435\u043a\u0430\u0442\u044c\u0441\u044f \u0441 \u0434\u0440\u0443\u0433\u0438\u043c");
                    return true;
                }
                if (rang < 35) {
                    MainAPI.badMessage(p, "\u0412 \u0442\u0432\u043e\u0451\u043c \u0433\u043e\u0440\u043e\u0434\u0435 \u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u0434\u043b\u044f \u043f\u043e\u0432\u044b\u0448\u0435\u043d\u0438\u044f \u0440\u0430\u043d\u0433\u0430! \u0422\u0435\u0431\u0435 \u043d\u0443\u0436\u043d\u043e \u0438\u043c\u0435\u0442\u044c 35 \u0438\u0433\u0440\u043e\u043a\u043e\u0432, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u043b\u0443\u0447\u0438\u0442\u044c V \u0440\u0430\u043d\u0433");
                    return true;
                }
                main.getInstance().getConfig().set("states.city." + city2 + ".level", (Object)"V");
                main.getInstance().getConfig().set("states.city." + city2 + ".radius", (Object)"250");
                MainAPI.sendCityMessage(city2, " \u00a7f\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u0432\u044b\u0441\u0438\u043b \u0440\u0430\u043d\u0433! \u0422\u0435\u043f\u0435\u0440\u044c \u043e\u043d \u0438\u043c\u0435\u0435\u0442 \u0440\u0430\u043d\u0433 \u00a76V");
                dynmapModule.updateCityRadius(city2);
            }
            if (level.equals("V")) {
                MainAPI.badMessage(p, "\u0423 \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76" + city2 + "\u00a7c \u0443\u0436\u0435 \u043c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u044b\u0439, V \u0440\u0430\u043d\u0433");
            }
            return true;
        }
        if (args[0].equals("mayor")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city mayor \u00a77\u043d\u0438\u043a");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            senderCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            city3 = main.getInstance().getConfig().getString("states.player." + args[1].toLowerCase() + ".city");
            cityLeader2 = main.getInstance().getConfig().getString("states.city." + senderCity + ".leader");
            if (!Objects.equals(senderCity, city3)) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u0442\u0432\u043e\u0435\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!Objects.equals(cityLeader2, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430.");
                return true;
            }
            MainAPI.badMessage(p, "\u0422\u044b \u0442\u043e\u0447\u043d\u043e \u0445\u043e\u0447\u0435\u0448\u044c \u043f\u0435\u0440\u0435\u0434\u0430\u0442\u044c \u043f\u0440\u0430\u0432\u0430 \u043c\u044d\u0440\u0430 \u0433\u043e\u0440\u043e\u0434\u0430 \u0438\u0433\u0440\u043e\u043a\u0443 \u00a76" + args[1] + "\u00a7c? \u0427\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c, \u0432\u0432\u0435\u0434\u0438 \u043a\u043e\u043c\u0430\u043d\u0434\u0443 \u00a76/city confirmmayor \u00a77" + args[1]);
            dynmapModule.updateCityDescription(senderCity);
            return true;
        }
        if (args[0].equals("confirmmayor")) {
            String nationLeader;
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city mayor \u00a77\u043d\u0438\u043a");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            senderCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            city3 = main.getInstance().getConfig().getString("states.player." + args[1].toLowerCase() + ".city");
            cityLeader2 = main.getInstance().getConfig().getString("states.city." + senderCity + ".leader");
            if (!Objects.equals(senderCity, city3)) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u0442\u0432\u043e\u0435\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!Objects.equals(cityLeader2, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430.");
                return true;
            }
            String nation = main.getInstance().getConfig().getString("states.city." + city3 + ".nation");
            if (!Objects.equals(nation, "") && Objects.equals(nationLeader = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers"), sender.getName().toLowerCase())) {
                main.getInstance().getConfig().set("states.nation." + nation + ".leader", (Object)args[1].toLowerCase());
                MainAPI.sendNationMessage(nation, "\u00a76\u00a7l\u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430 \u00a78>> \u00a7f\u041c\u044d\u0440 \u0441\u0442\u043e\u043b\u0438\u0446\u044b \u0432\u0430\u0448\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 (\u00a76" + sender.getName() + "\u00a7f) \u0441\u043d\u044f\u043b \u0441 \u0441\u0435\u0431\u044f \u043f\u043e\u043b\u043d\u043e\u043c\u043e\u0447\u0438\u044f \u0432 \u043f\u043e\u043b\u044c\u0437\u0443 \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[1]);
            }
            main.getInstance().getConfig().set("states.city." + senderCity + ".leader", (Object)args[1].toLowerCase());
            MainAPI.sendCityMessage(city3, "\u041c\u044d\u0440 \u0432\u0430\u0448\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76(" + sender.getName() + "\u00a7f) \u0441\u043d\u044f\u043b \u0441 \u0441\u0435\u0431\u044f \u043f\u043e\u043b\u043d\u043e\u043c\u043e\u0447\u0438\u044f \u0432 \u043f\u043e\u043b\u044c\u0437\u0443 \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[1]);
            dynmapModule.updateCityDescription(senderCity);
            return true;
        }
        if (args[0].equals("spawn")) {
            if (main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city").equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (main.getInstance().getConfig().isSet("states.player." + sender.getName().toLowerCase() + ".cityTeleported1")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043b \u043e\u0434\u043d\u043e\u0440\u0430\u0437\u043e\u0432\u044b\u0439 \u0442\u0435\u043b\u0435\u043f\u043e\u0440\u0442 \u0432 \u0433\u043e\u0440\u043e\u0434");
                return true;
            }
            city2 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            Location loc = MainAPI.getLocationTP("states.city." + city2 + ".home");
            int x = loc.getBlockX();
            int z = loc.getBlockZ();
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "tp " + sender.getName() + " " + x + " 255 " + z);
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".cityTeleported1", (Object)true);
            return true;
        }
        if (args[0].equals("allow")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city allow \u00a77mayor\u00a76/\u00a77assistants\u00a76/\u00a77residents\u00a76/\u00a77nation-leader\u00a76/\u00a77nation-ministers\u00a76/\u00a77nation-assistants\u00a76/\u00a77nation\u00a76/\u00a77licentiate\u00a76/\u00a77everyone");
                return true;
            }
            args[1] = args[1].toLowerCase();
            String allow = args[1];
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String senderCity6 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String cityLeader7 = main.getInstance().getConfig().getString("states.city." + senderCity6 + ".leader");
            if (!Objects.equals(cityLeader7, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430.");
                return true;
            }
            if (!(args[1].equals("mayor") || args[1].equals("assistants") || args[1].equals("residents") || args[1].equals("nation-leader") || args[1].equals("nation-minister") || args[1].equals("nation-assistants") || args[1].equals("nation") || args[1].equals("everyone"))) {
                MainAPI.badMessage(p, "\u041d\u0435\u0432\u0435\u0440\u043d\u043e \u0432\u044b\u0431\u0440\u0430\u043d \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u0430! \u0414\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0443\u0440\u043e\u0432\u043d\u0438 \u0434\u043e\u0441\u0442\u0443\u043f\u0430: \u00a77mayor\u00a76,\u00a77assistants\u00a76,\u00a77residents\u00a76,\u00a77nation-leader\u00a76,\u00a77nation-ministers\u00a76,\u00a77nation-assistants\u00a76,\u00a77nation\u00a76,\u00a77licentiate\u00a76,\u00a77everyone");
                return true;
            }
            MainAPI.sendCityMessage(city, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u0438\u0437\u043c\u0435\u043d\u0438\u043b \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u0430! \u0422\u0435\u043a\u0443\u0449\u0438\u0439 \u0443\u0440\u043e\u0432\u0435\u043d\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u0430: \u00a76" + args[1]);
            int value = 4;
            if (allow.equals("mayor")) {
                value = 1;
            }
            if (allow.equals("assistants")) {
                value = 2;
            }
            if (allow.equals("residents")) {
                value = 3;
            }
            if (allow.equals("nation-ministers")) {
                value = 5;
            }
            if (allow.equals("nation")) {
                value = 6;
            }
            if (allow.equals("licentiate")) {
                value = 7;
            }
            if (allow.equals("everyone")) {
                value = 8;
            }
            String str = "" + value;
            MainAPI.setCity(city, "allowLevel", str);
            return true;
        }
        if (args[0].equals("dontdoitpls")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city rename \u00a77\u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String cityOld = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            cityLeader = main.getInstance().getConfig().getString("states.city." + cityOld + ".leader");
            if (!Objects.equals(cityLeader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430.");
                return true;
            }
            if (args[1].length() < 2) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u0438\u0437 2 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f-_]+")) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b, \u0446\u0438\u0444\u0440\u044b, \u0442\u0438\u0440\u0435 \u0438 \u0437\u043d\u0430\u043a\u0438 \u043f\u043e\u0434\u0447\u0451\u0440\u043a\u0438\u0432\u0430\u043d\u0438\u044f");
                return true;
            }
            if (args.length > 2) {
                Object message = "";
                for (int i = 1; i < args.length; ++i) {
                    message = String.valueOf(message) + args[i] + "_";
                }
                args[1] = message;
            }
            if (main.getInstance().getConfig().isSet("states.city." + args[1].toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            city = args[1].toLowerCase();
            if (cityOld.equals(city)) {
                MainAPI.badMessage(p, "\u041d\u043e\u0432\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0433\u043e\u0440\u043e\u0434\u0430 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442 \u0441\u043e \u0441\u0442\u0430\u0440\u044b\u043c");
                return true;
            }
            String cityName = args[1];
            String board = MainAPI.getCityInfo(cityOld, "board");
            String leader = MainAPI.getCityInfo(cityOld, "leader");
            String deputats = MainAPI.getCityInfo(cityOld, "deputats");
            String isCapital = MainAPI.getCityInfo(cityOld, "isCapital");
            String nationStatus = MainAPI.getCityInfo(cityOld, "nationStatus");
            String regionID = MainAPI.getCityInfo(cityOld, "regionID");
            String currencyID = MainAPI.getCityInfo(cityOld, "currencyID");
            String nation = MainAPI.getCityInfo(cityOld, "nation");
            String allowLevel = MainAPI.getCityInfo(cityOld, "allowLevel");
            String loc = MainAPI.getCityInfo(cityOld, "home");
            String corporation = MainAPI.getCityInfo(cityOld, "corporationGovernment.company");
            String rang = MainAPI.getCityInfo(cityOld, "rang");
            String level = MainAPI.getCityInfo(cityOld, "level");
            String radius = MainAPI.getCityInfo(cityOld, "radius");
            String askingPlayers = MainAPI.getCityInfo(cityOld, "askingPlayers");
            String askNation = MainAPI.getCityInfo(cityOld, "askNation");
            String residents = MainAPI.getCityInfo(cityOld, "residents");
            String deleteDate = MainAPI.getCityInfo(cityOld, "deleteDate");
            String residentsString = Objects.requireNonNull(main.getInstance().getConfig().getString("states.city." + cityOld + ".residents"));
            String[] residentsMassive = SMassiveAPI.toMassive(residentsString);
            for (int i = 0; i < residentsMassive.length; ++i) {
                main.getInstance().getConfig().set("states.player." + residentsMassive[i] + ".city", (Object)city);
            }
            main.getInstance().getConfig().set("states.player." + sender.getName().toLowerCase() + ".city", (Object)city);
            main.getInstance().getConfig().set("states.city." + city + ".name", (Object)cityName);
            main.getInstance().getConfig().set("states.city." + city + ".board", (Object)board);
            main.getInstance().getConfig().set("states.city." + city + ".leader", (Object)leader);
            main.getInstance().getConfig().set("states.city." + city + ".deputats", (Object)deputats);
            main.getInstance().getConfig().set("states.city." + city + ".isCapital", (Object)isCapital);
            main.getInstance().getConfig().set("states.city." + city + ".nationStatus", (Object)nationStatus);
            main.getInstance().getConfig().set("states.city." + city + ".regionID", (Object)regionID);
            main.getInstance().getConfig().set("states.city." + city + ".currencyID", (Object)currencyID);
            main.getInstance().getConfig().set("states.city." + city + ".nation", (Object)nation);
            main.getInstance().getConfig().set("states.city." + city + ".allowLevel", (Object)allowLevel);
            main.getInstance().getConfig().set("states.city." + city + ".home", (Object)loc);
            main.getInstance().getConfig().set("states.city." + city + ".corporationGovernment.company", (Object)corporation);
            main.getInstance().getConfig().set("states.city." + city + ".rang", (Object)rang);
            main.getInstance().getConfig().set("states.city." + city + ".level", (Object)level);
            main.getInstance().getConfig().set("states.city." + city + ".radius", (Object)radius);
            main.getInstance().getConfig().set("states.city." + city + ".askingPlayers", (Object)askingPlayers);
            main.getInstance().getConfig().set("states.city." + city + ".askNation", (Object)askNation);
            main.getInstance().getConfig().set("states.city." + city + ".residents", (Object)residents);
            main.getInstance().getConfig().set("states.city." + city + ".deleteDate", (Object)deleteDate);
            String cityList = main.getInstance().getConfig().getString("states.cityList");
            String newCityList = cityList.replace(", " + cityOld, city);
            newCityList = newCityList.replace(cityOld, city);
            main.getInstance().getConfig().set("states.cityList", (Object)newCityList);
            if (!Objects.equals(nation, "")) {
                String cities = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
                cities = cities.replace(cityOld, city);
                main.getInstance().getConfig().set("states.nation." + nation + ".cities", (Object)cities);
                String nationCapital = MainAPI.getNationInfo(nation, "capital");
                if (nationCapital.equals(cityOld)) {
                    MainAPI.setNation(nation, "capital", city);
                }
                main.getInstance().saveConfig();
            }
            main.getInstance().getConfig().set("states.city." + cityOld, null);
            MainAPI.save();
            MainAPI.sendCityMessage(city, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u0438\u0437\u043c\u0435\u043d\u0438\u043b \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435! \u0422\u0435\u043f\u0435\u0440\u044c \u0432\u044b \u043f\u0440\u043e\u0436\u0438\u0432\u0430\u0435\u0442\u0435 \u0432 \u0433\u043e\u0440\u043e\u0434\u0435 \u00a76" + args[1]);
            return true;
        }
        if (args[0].equals("chunk")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city chunk \u00a77outpost/private claim/unclaim");
                return true;
            }
            if (!MainAPI.isResident(player)) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            city2 = MainAPI.getPlayerInfo(player, "city");
            String chunk = MainAPI.getChunk(p);
            if (args[1].equals("outpost")) {
                if (args[2].equals("claim")) {
                    int rang;
                    if (!MainAPI.isCityLeader(player) && !MainAPI.isAssistant(player)) {
                        MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0438 \u043d\u0435 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0440\u0438\u0432\u0430\u0442\u0438\u0442\u044c \u0432\u043d\u0435\u0448\u043d\u0438\u0435 \u0447\u0430\u043d\u043a\u0438");
                        return true;
                    }
                    if (StatesAPI.justInCity(p)) {
                        MainAPI.badMessage(p, "\u0412\u043d\u0435\u0448\u043d\u0438\u043c\u0438 \u0447\u0430\u043d\u043a\u0430\u043c\u0438 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0447\u0430\u043d\u043a\u0438 \u0432\u043d\u0435 \u0433\u043e\u0440\u043e\u0434\u0430");
                        return true;
                    }
                    String chunksString = MainAPI.getCityInfo(city2, "newOutpostChunks");
                    String[] chunks = SMassiveAPI.toMassive(chunksString);
                    if (chunks.length >= (rang = Integer.parseInt(MainAPI.getCityInfo(city2, "rang"))) * 2) {
                        MainAPI.badMessage(p, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0438\u0441\u0447\u0435\u0440\u043f\u0430\u043b \u0441\u0432\u043e\u0439 \u043b\u0438\u043c\u0438\u0442 \u043d\u0430 \u043f\u0440\u0438\u0432\u0430\u0442 \u0432\u043d\u0435\u0448\u043d\u0438\u0445 \u0447\u0430\u043d\u043a\u043e\u0432! \u0414\u043b\u044f \u043a\u0430\u0436\u0434\u044b\u0445 2 \u0432\u043d\u0435\u0448\u043d\u0438\u0445 \u0447\u0430\u043d\u043a\u043e\u0432 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0438\u043c\u0435\u0442\u044c 1 \u0436\u0438\u0442\u0435\u043b\u044f \u0432 \u0433\u043e\u0440\u043e\u0434\u0435.");
                        return true;
                    }
                    if (MainAPI.isSet("states.chunks." + chunk)) {
                        MainAPI.badMessage(p, "\u042d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0447\u0435\u043d \u0433\u043d\u0438\u0434\u0430 \u0431\u043b\u044f\u0434\u044c");
                        return true;
                    }
                    MainAPI.setOutpost(chunk, city2);
                    MainAPI.goodMessage(p, "\u0422\u044b \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0442\u0438\u043b \u044d\u0442\u043e\u0442 \u0432\u043d\u0435\u0448\u043d\u0438\u0439 \u0447\u0430\u043d\u043a.");
                    return true;
                }
                if (args[2].equals("unclaim")) {
                    if (!MainAPI.isCityLeader(player) && !MainAPI.isAssistant(player)) {
                        MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0438 \u043d\u0435 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0440\u0438\u0432\u0430\u0442\u0438\u0442\u044c \u0432\u043d\u0435\u0448\u043d\u0438\u0435 \u0447\u0430\u043d\u043a\u0438");
                        return true;
                    }
                    if (!MainAPI.isSet("states.chunks." + chunk)) {
                        MainAPI.badMessage(p, "\u042d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a \u0438 \u0442\u0430\u043a \u043d\u0435 \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0447\u0435\u043d");
                        return true;
                    }
                    MainAPI.delOutpost(city2, chunk);
                    MainAPI.goodMessage(p, "\u0422\u044b \u0440\u0430\u0441\u043f\u0440\u0438\u0432\u0430\u0442\u0438\u043b \u044d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a");
                    return true;
                }
            }
            if (args[1].equals("private")) {
                if (args[2].equals("claim")) {
                    if (!MainAPI.isSet("states.city." + city2 + ".limit.personal." + player)) {
                        MainAPI.setCity(city2, "limit.personal." + player, "0");
                    }
                    if (!MainAPI.isSet("states.city." + city2 + ".limit.assistant")) {
                        MainAPI.setCity(city2, "limit.assistant", "5");
                    }
                    if (!MainAPI.isSet("states.city." + city2 + ".limit.resident")) {
                        MainAPI.setCity(city2, "limit.resident", "1");
                    }
                    int personalLimit = Integer.parseInt(MainAPI.getCityInfo(city2, "limit.personal." + player));
                    int limit = MainAPI.isAssistant(player) ? Integer.parseInt(MainAPI.getCityInfo(city2, "limit.assistant")) + personalLimit : Integer.parseInt(MainAPI.getCityInfo(city2, "limit.resident")) + personalLimit;
                    String chunksString = MainAPI.getPlayerInfo(player, "privateChunks");
                    String[] chunks = SMassiveAPI.toMassive(chunksString);
                    if (chunks.length >= limit) {
                        MainAPI.badMessage(p, "\u0422\u044b \u0443\u0436\u0435 \u0438\u0441\u0447\u0435\u0440\u043f\u0430\u043b \u0441\u0432\u043e\u0439 \u043b\u0438\u043c\u0438\u0442 \u043d\u0430 \u043f\u0440\u0438\u0432\u0430\u0442 \u0447\u0430\u043d\u043a\u043e\u0432! \u041f\u043e\u043f\u0440\u043e\u0441\u0438 \u043c\u044d\u0440\u0430 \u0433\u043e\u0440\u043e\u0434\u0430 \u0432\u044b\u0434\u0430\u0442\u044c \u0442\u0435\u0431\u0435 \u0431\u043e\u043b\u044c\u0448\u0435 \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0445 \u0447\u0430\u043d\u043a\u043e\u0432 \u0438\u043b\u0438 \u0436\u0435 \u0440\u0430\u0441\u0448\u0438\u0440\u0438\u0442\u044c \u043e\u0431\u0449\u0438\u0439 \u043b\u0438\u043c\u0438\u0442.");
                        return true;
                    }
                    if (MainAPI.isSet("states.city." + city2 + ".chunks." + chunk)) {
                        MainAPI.badMessage(p, "\u042d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0447\u0435\u043d \u0433\u043d\u0438\u0434\u0430 \u0431\u043b\u044f\u0434\u044c");
                        return true;
                    }
                    if (!StatesAPI.justInCity(p)) {
                        MainAPI.badMessage(p, "\u041f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u043c\u0438 \u0447\u0430\u043d\u043a\u0430\u043c\u0438 \u043c\u043e\u0433\u0443\u0442 \u0431\u044b\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0447\u0430\u043d\u043a\u0438 \u0432\u043d\u0443\u0442\u0440\u0438 \u0433\u043e\u0440\u043e\u0434\u0430");
                        return true;
                    }
                    MainAPI.setPrivateChunk(city2, chunk, player);
                    MainAPI.goodMessage(p, "\u0422\u044b \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0442\u0438\u043b \u044d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a.");
                    return true;
                }
                if (args[2].equals("unclaim")) {
                    if (!MainAPI.isSet("states.city." + city2 + ".chunks." + chunk)) {
                        MainAPI.badMessage(p, "\u042d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a \u043d\u0438\u043a\u0435\u043c \u043d\u0435 \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0447\u0435\u043d");
                        return true;
                    }
                    if (!MainAPI.isPrivateChunkOwner(city2, chunk, player)) {
                        MainAPI.badMessage(p, "\u042d\u0442\u043e \u043d\u0435 \u0442\u0432\u043e\u0439 \u0447\u0430\u043d\u043a");
                        return true;
                    }
                    MainAPI.delPrivateChunk(city2, chunk, player);
                    MainAPI.goodMessage(p, "\u0422\u044b \u0440\u0430\u0441\u043f\u0440\u0438\u0432\u0430\u0442\u0438\u043b \u044d\u0442\u043e\u0442 \u0447\u0430\u043d\u043a.");
                    return true;
                }
            }
        }
        if (args[0].equals("friend")) {
            Object friends;
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city friend \u00a77add/remove \u043d\u0438\u043a");
                return true;
            }
            String friend = args[2].toLowerCase();
            String friendName = args[2];
            if (args[1].equals("add")) {
                friends = MainAPI.getPlayerInfo(player, "friends");
                if (SMassiveAPI.contain((String)friends, args[2].toLowerCase())) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + friendName + "\u00a7c \u0443\u0436\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0442\u0432\u043e\u0438\u043c \u0434\u0440\u0443\u0433\u043e\u043c");
                    return true;
                }
                friends = (String)friends + ", " + friend;
                MainAPI.setPlayer(player, "friends", (String)friends);
                MainAPI.goodMessage(p, "\u0422\u044b \u0434\u043e\u0431\u0430\u0432\u0438\u043b \u0432 \u0434\u0440\u0443\u0437\u044c\u044f " + friendName);
            }
            if (args[1].equals("remove")) {
                friends = MainAPI.getPlayerInfo(player, "friends");
                if (!SMassiveAPI.contain((String)friends, args[2].toLowerCase())) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0438 \u0442\u0430\u043a \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0442\u0432\u043e\u0438\u043c \u0434\u0440\u0443\u0433\u043e\u043c");
                    return true;
                }
                friends = SMassiveAPI.remove((String)friends, friend);
                MainAPI.setPlayer(player, "friends", (String)friends);
                MainAPI.goodMessage(p, "\u0422\u044b \u0443\u0434\u0430\u043b\u0438\u043b \u0438\u0437 \u0434\u0440\u0443\u0437\u0435\u0439 " + friendName);
            }
        }
        if (args[0].equals("limit")) {
            if (args.length < 3) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city limit \u00a77resident/assistant/personal \u043b\u0438\u043c\u0438\u0442");
                return true;
            }
            if (Objects.equals(main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city"), "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            city2 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            cityLeader = main.getInstance().getConfig().getString("states.city." + city2 + ".leader");
            if (!Objects.equals(cityLeader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u044d\u0440 \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430.");
                return true;
            }
            if (args[1].equals("resident")) {
                if (!MainAPI.isNumeric(args[2])) {
                    MainAPI.badMessage(p, "\u0427\u0438\u0441\u043b\u043e \u0447\u0430\u043d\u043a\u043e\u0432 \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0437\u0430\u043f\u0438\u0441\u0430\u043d\u043e \u0446\u0438\u0444\u0440\u0430\u043c\u0438. \"" + args[2] + "\" - \u043d\u0435 \u0447\u0438\u0441\u043b\u043e.");
                }
                MainAPI.setCity(city2, "limit.resident", args[2]);
                MainAPI.sendCityMessage(city2, " \u00a7f\u041d\u043e\u0432\u044b\u0439 \u043b\u0438\u043c\u0438\u0442 \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0445 \u0447\u0430\u043d\u043a\u043e\u0432 \u0436\u0438\u0442\u0435\u043b\u044f \u0432 \u0432\u0430\u0448\u0435\u043c \u0433\u043e\u0440\u043e\u0434\u0435 - \u00a76" + args[1]);
                return true;
            }
            if (args[1].equals("assistant")) {
                if (!MainAPI.isNumeric(args[2])) {
                    MainAPI.badMessage(p, "\u0427\u0438\u0441\u043b\u043e \u0447\u0430\u043d\u043a\u043e\u0432 \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0437\u0430\u043f\u0438\u0441\u0430\u043d\u043e \u0446\u0438\u0444\u0440\u0430\u043c\u0438. \"" + args[2] + "\" - \u043d\u0435 \u0447\u0438\u0441\u043b\u043e.");
                }
                MainAPI.setCity(city2, "limit.assistant", args[2]);
                MainAPI.sendCityMessage(city2, " \u00a7f\u041d\u043e\u0432\u044b\u0439 \u043b\u0438\u043c\u0438\u0442 \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u044b\u0445 \u0447\u0430\u043d\u043a\u043e\u0432 \u0430\u0441\u0441\u0438\u0441\u0442\u0435\u043d\u0442\u0430 \u0432 \u0432\u0430\u0448\u0435\u043c \u0433\u043e\u0440\u043e\u0434\u0435 - \u00a76" + args[1]);
                return true;
            }
            if (args[1].equals("personal")) {
                if (args.length < 4) {
                    MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/city limit \u00a77personal \u043d\u0438\u043a \u043b\u0438\u043c\u0438\u0442");
                    return true;
                }
                if (!MainAPI.isNumeric(args[3])) {
                    MainAPI.badMessage(p, "\u0427\u0438\u0441\u043b\u043e \u0447\u0430\u043d\u043a\u043e\u0432 \u0434\u043e\u043b\u0436\u043d\u043e \u0431\u044b\u0442\u044c \u0437\u0430\u043f\u0438\u0441\u0430\u043d\u043e \u0446\u0438\u0444\u0440\u0430\u043c\u0438. \"" + args[2] + "\" - \u043d\u0435 \u0447\u0438\u0441\u043b\u043e.");
                }
                MainAPI.setCity(city2, "limit.personal." + args[2], args[3]);
                MainAPI.goodMessage(p, "\u0422\u044b \u0440\u0430\u0437\u0440\u0435\u0448\u0438\u043b \u0438\u0433\u0440\u043e\u043a\u0443 " + args[2] + " \u0437\u0430\u043f\u0440\u0438\u0432\u0430\u0442\u0438\u0442\u044c \u0434\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u0435\u043b\u044c\u043d\u043e " + args[3] + " \u0447\u0430\u043d\u043a\u043e\u0432.");
                return true;
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
        arrobject[1] = "states/cityMain";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

