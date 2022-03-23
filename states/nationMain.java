/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
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
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.API.MainAPI;
import states.API.SMassiveAPI;
import states.dynmapModule;
import states.main;

public class nationMain
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        String targetCity;
        String cities;
        String nation;
        String leader;
        String askNation;
        String leader2;
        String leader3;
        String capital;
        String nation2;
        String city;
        if (sender == null) {
            nationMain.$$$reportNull$$$0(0);
        }
        if (command == null) {
            nationMain.$$$reportNull$$$0(1);
        }
        if (s == null) {
            nationMain.$$$reportNull$$$0(2);
        }
        if (args == null) {
            nationMain.$$$reportNull$$$0(3);
        }
        MainAPI.createProfile(sender);
        String player = sender.getName().toLowerCase();
        Player p = Bukkit.getPlayer((String)player);
        if (args.length == 0) {
            if (main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city").equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String city2 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String nation3 = main.getInstance().getConfig().getString("states.city." + city2 + ".nation");
            if (nation3.equals("")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String nationName = main.getInstance().getConfig().getString("states.nation." + nation3 + ".name");
            String capital2 = MainAPI.getNationInfo(nation3, "capital");
            String capitalName = MainAPI.getCityInfo(capital2, "name");
            String leader4 = main.getInstance().getConfig().getString("states.nation." + nation3 + ".leader");
            String board = main.getInstance().getConfig().getString("states.nation." + nation3 + ".board");
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation3 + ".ministers");
            String citiesAmount = main.getInstance().getConfig().getString("states.nation." + nation3 + ".rang");
            String cities2 = main.getInstance().getConfig().getString("states.nation." + nation3 + ".cities");
            String currencyID = main.getInstance().getConfig().getString("states.nation." + nation3 + ".currencyID");
            String regionID = main.getInstance().getConfig().getString("states.nation." + nation3 + ".regionID");
            String askingCities = main.getInstance().getConfig().getString("states.nation." + nation3 + ".askingCities");
            if (ministers.equals("")) {
                ministers = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (askingCities.equals("")) {
                askingCities = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (nation3.equals("")) {
                nation3 = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442";
            }
            if (currencyID.equals("")) {
                currencyID = "\u0432\u0430\u043b\u044e\u0442\u0430 \u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u0430";
            }
            sender.sendMessage("\u00a76" + nationName);
            sender.sendMessage("");
            sender.sendMessage("\u00a7o" + board);
            sender.sendMessage("");
            sender.sendMessage("\u00a76\u041b\u0438\u0434\u0435\u0440 \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + leader4);
            sender.sendMessage("\u00a76\u0421\u0442\u043e\u043b\u0438\u0446\u0430 \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + capitalName);
            sender.sendMessage("\u00a76\u041c\u0438\u043d\u0438\u0441\u0442\u0440\u044b\u00a78: \u00a77" + ministers);
            sender.sendMessage("\u00a76\u0413\u043e\u0440\u043e\u0434\u0430 \u00a78(\u00a77" + citiesAmount + "\u00a78): \u00a77" + cities2);
            sender.sendMessage("\u00a76\u0413\u043e\u0440\u043e\u0434\u0430, \u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u044e\u0449\u0438\u0435 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044e\u00a78: \u00a77" + askingCities);
            sender.sendMessage("\u00a76ID \u0432\u0430\u043b\u044e\u0442\u044b\u00a78: \u00a77" + currencyID);
            sender.sendMessage("\u00a76ID \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + regionID);
            return true;
        }
        if (args[0].equals("info")) {
            String nation4 = args[1].toLowerCase();
            if (!main.getInstance().getConfig().isSet("states.nation." + nation4)) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            String nationName = main.getInstance().getConfig().getString("states.nation." + nation4 + ".name");
            String leader5 = main.getInstance().getConfig().getString("states.nation." + nation4 + ".leader");
            String capital3 = MainAPI.getNationInfo(nation4, "capital");
            String capitalName = MainAPI.getCityInfo(capital3, "name");
            String board = main.getInstance().getConfig().getString("states.nation." + nation4 + ".board");
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation4 + ".ministers");
            String citiesAmount = main.getInstance().getConfig().getString("states.nation." + nation4 + ".rang");
            String cities3 = main.getInstance().getConfig().getString("states.nation." + nation4 + ".cities");
            String currencyID = main.getInstance().getConfig().getString("states.nation." + nation4 + ".currencyID");
            String regionID = main.getInstance().getConfig().getString("states.nation." + nation4 + ".regionID");
            String askingCities = main.getInstance().getConfig().getString("states.nation." + nation4 + ".askingCities");
            if (ministers.equals("")) {
                ministers = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (askingCities.equals("")) {
                askingCities = "\u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u044e\u0442";
            }
            if (currencyID.equals("")) {
                currencyID = "\u0432\u0430\u043b\u044e\u0442\u0430 \u043d\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u0430";
            }
            sender.sendMessage("\u00a76" + nationName);
            sender.sendMessage("");
            sender.sendMessage("\u00a7o" + board);
            sender.sendMessage("");
            sender.sendMessage("\u00a76\u041b\u0438\u0434\u0435\u0440 \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + leader5);
            sender.sendMessage("\u00a76\u0421\u0442\u043e\u043b\u0438\u0446\u0430 \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + capitalName);
            sender.sendMessage("\u00a76\u041c\u0438\u043d\u0438\u0441\u0442\u0440\u044b\u00a78: \u00a77" + ministers);
            sender.sendMessage("\u00a76\u0413\u043e\u0440\u043e\u0434\u0430 \u00a78(\u00a77" + citiesAmount + "\u00a78): \u00a77" + cities3);
            sender.sendMessage("\u00a76\u0413\u043e\u0440\u043e\u0434\u0430, \u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u044e\u0449\u0438\u0435 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044e\u00a78: \u00a77" + askingCities);
            sender.sendMessage("\u00a76ID \u0432\u0430\u043b\u044e\u0442\u044b\u00a78: \u00a77" + currencyID);
            sender.sendMessage("\u00a76ID \u043d\u0430\u0446\u0438\u0438\u00a78: \u00a77" + regionID);
            return true;
        }
        if (args[0].equals("new")) {
            String leader6;
            String city3 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String playerNation = main.getInstance().getConfig().getString("states.city." + city3 + ".nation");
            if (args.length > 2) {
                Object message = "";
                for (int i = 1; i < args.length; ++i) {
                    message = String.valueOf(message) + args[i] + "_";
                }
                StringUtils.chop((String)message);
                args[1] = message;
            }
            if (args[1].length() < 2) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u0438\u0437 2 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f-_]+")) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b, \u0446\u0438\u0444\u0440\u044b, \u0442\u0438\u0440\u0435 \u0438 \u0437\u043d\u0430\u043a\u0438 \u043f\u043e\u0434\u0447\u0451\u0440\u043a\u0438\u0432\u0430\u043d\u0438\u044f");
                return true;
            }
            if (main.getInstance().getConfig().isSet("states.nation." + args[1].toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u0430\u044f \u043d\u0430\u0446\u0438\u044f \u0443\u0436\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            if (Objects.equals(city3, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043e\u0434\u043d\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435!");
            }
            if (!Objects.equals(leader6 = main.getInstance().getConfig().getString("states.city." + city3 + ".leader"), sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u0430\u0446\u0438\u044e \u0441\u043e \u0441\u0442\u043e\u043b\u0438\u0446\u0435\u0439 \u0432 \u00a76" + city3 + "\u00a7c, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u043b\u0438\u0434\u0435\u0440\u043e\u043c \u044d\u0442\u043e\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            if (!Objects.equals(playerNation, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043d\u0430\u0446\u0438\u0438 \u00a76" + playerNation);
                return true;
            }
            String askNation2 = main.getInstance().getConfig().getString("states.city." + city3 + ".askNation");
            if (!Objects.equals(askNation2, "")) {
                String askingCities = main.getInstance().getConfig().getString("states.nation." + askNation2 + ".askingCities");
                askingCities = SMassiveAPI.remove(askingCities, city3);
                main.getInstance().getConfig().set("states.nation." + askNation2 + ".askingCities", (Object)askingCities);
                main.getInstance().getConfig().set("states.city." + city3 + ".askNation", (Object)"");
                main.getInstance().saveConfig();
            }
            if (Bukkit.getPlayer((String)sender.getName()).getItemInHand().getType() != Material.NETHERITE_BLOCK) {
                MainAPI.badMessage(p, "\u0421\u0442\u043e\u0438\u043c\u043e\u0441\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u043d\u0430\u0446\u0438\u0438 - \u00a761 \u00a78\u043d\u0435\u0437\u0435\u0440\u0438\u0442\u043e\u0432\u044b\u0439 \u0431\u043b\u043e\u043a\u00a7c! \u0414\u043e\u0431\u0443\u0434\u044c \u044d\u0442\u043e\u0442 \u0431\u043b\u043e\u043a, \u0432\u043e\u0437\u044c\u043c\u0438 \u0435\u0433\u043e \u0432 \u0440\u0443\u043a\u0443 \u0438 \u043f\u043e\u043f\u0440\u043e\u0431\u0443\u0439 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0433\u043e\u0440\u043e\u0434 \u0441\u043d\u043e\u0432\u0430.");
                return true;
            }
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "clear " + sender.getName() + " netherite_block 1");
            Date current = new Date();
            long dateDelete = current.getTime() + 345600000L;
            long date = current.getTime();
            String nation5 = args[1].toLowerCase();
            String nationName = args[1];
            String cityName = main.getInstance().getConfig().getString("states.city." + city3 + ".name");
            main.getInstance().getConfig().set("lastNationID", (Object)date);
            main.getInstance().getConfig().set("states.city." + city3 + ".nation", (Object)nation5);
            main.getInstance().getConfig().set("states.city." + city3 + ".nationStatus", (Object)"capital");
            main.getInstance().getConfig().set("states.city." + city3 + ".isCapital", (Object)"true");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".name", (Object)nationName);
            main.getInstance().getConfig().set("states.nation." + nation5 + ".capital", (Object)city3);
            main.getInstance().getConfig().set("states.nation." + nation5 + ".board", (Object)"\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043d\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".ministers", (Object)"");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".currencyID", (Object)"");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".regionID", (Object)("n" + date));
            main.getInstance().getConfig().set("states.nation." + nation5 + ".color", (Object)MainAPI.randomColor());
            main.getInstance().getConfig().set("states.nation." + nation5 + ".government.company", (Object)"");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".government.occupation", (Object)"");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".rang", (Object)"1");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".deleteDate", (Object)dateDelete);
            main.getInstance().getConfig().set("states.nation." + nation5 + ".askingCities", (Object)"");
            main.getInstance().getConfig().set("states.nation." + nation5 + ".cities", (Object)city3);
            main.getInstance().getConfig().set("states.nation." + nation5 + ".leader", (Object)sender.getName().toLowerCase());
            MainAPI.sendGlobalMessage("\u0413\u043e\u0440\u043e\u0434 \u00a76" + cityName + "\u00a7f \u043e\u0441\u043d\u043e\u0432\u0430\u043b \u043d\u0430\u0446\u0438\u044e \u00a76" + args[1]);
            String nationList = main.getInstance().getConfig().getString("states.nationList");
            if (Objects.equals(nationList, "start")) {
                main.getInstance().getConfig().set("states.nationList", (Object)nation5);
            } else {
                String nationListNew = String.join((CharSequence)", ", main.getInstance().getConfig().getString("states.nationList"), nation5);
                main.getInstance().getConfig().set("states.nationList", (Object)nationListNew);
            }
            main.getInstance().saveConfig();
            dynmapModule.updateNation(nation5);
            return true;
        }
        if (args[0].equals("join")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation join\u00a77 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            if (args[1].length() < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438: \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u043a\u0430\u043a \u043c\u0438\u043d\u0438\u043c\u0443\u043c 2 \u0441\u0438\u043c\u0432\u043e\u043b\u0430");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f_-]+")) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438: \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b \u0438 \u0446\u0438\u0444\u0440\u044b");
                return true;
            }
            if (!main.getInstance().getConfig().isSet("states.nation." + args[1].toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            String city4 = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            String cityName = main.getInstance().getConfig().getString("states.city." + city4 + ".name");
            String cityNation = main.getInstance().getConfig().getString("states.city." + city4 + ".nation");
            String nation6 = main.getInstance().getConfig().getString("states.city." + city4 + ".nation");
            if (!Objects.equals(cityNation, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043d\u0430\u0446\u0438\u0438\u00a76 " + nation6);
                return true;
            }
            String askNation3 = main.getInstance().getConfig().getString("states.city." + city4 + ".askNation");
            String leader7 = main.getInstance().getConfig().getString("states.city." + city4 + ".leader");
            if (!Objects.equals(city4, "")) {
                if (!Objects.equals(leader7, sender.getName().toLowerCase())) {
                    MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0442\u044c \u0440\u0435\u0448\u0435\u043d\u0438\u044f \u043e \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u0438 \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76" + city4 + "\u00a7c \u0432 \u043d\u0430\u0446\u0438\u0438, \u043f\u043e\u0442\u043e\u043c\u0443 \u0447\u0442\u043e \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u0435\u0433\u043e \u043b\u0438\u0434\u0435\u0440\u043e\u043c");
                    return true;
                }
            } else {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            if (!Objects.equals(askNation3, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u043b \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044e \u043d\u0430\u0446\u0438\u0438 " + askNation3);
                return true;
            }
            nation6 = args[1].toLowerCase();
            String askingCities = String.join((CharSequence)", ", main.getInstance().getConfig().getString("states.nation." + nation6 + ".askingCities"), city4);
            main.getInstance().getConfig().set("states.nation." + nation6 + ".askingCities", (Object)askingCities);
            main.getInstance().getConfig().set("states.city." + city4 + ".askNation", (Object)nation6);
            MainAPI.sendCityMessage(city4, "\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u043b \u043d\u0430\u0446\u0438\u0438 \u00a76" + nation6 + "\u00a7f \u0438\u043d\u0442\u0435\u0433\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0442\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0432 \u0438\u0445 \u0441\u043e\u0441\u0442\u0430\u0432");
            MainAPI.sendNationMessage(nation6, "\u0412\u0430\u0448\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u043f\u043e\u0441\u0442\u0443\u043f\u0438\u043b\u043e \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u0438 \u043e\u0442 \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76" + cityName);
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("delete")) {
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (city.equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            if (nation2.equals("")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0441\u0430\u043c\u043e\u0441\u0442\u043e\u044f\u0442\u0435\u043b\u0435\u043d \u0438 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            capital = main.getInstance().getConfig().getString("states.nation." + nation2 + ".capital");
            if (!capital.equals(city)) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0441\u0442\u043e\u043b\u0438\u0446\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader3 = main.getInstance().getConfig().getString("states.city." + city + ".leader");
            if (!leader3.equals(sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u043b\u0438\u0434\u0435\u0440\u043e\u043c \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            MainAPI.badMessage(p, "\u0422\u044b \u0442\u043e\u0447\u043d\u043e \u0445\u043e\u0447\u0435\u0448\u044c \u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0438\u0442\u044c \u0441\u0432\u043e\u044e \u043d\u0430\u0446\u0438\u044e? \u0412\u0432\u0435\u0434\u0438 \u00a76/nation confirmdelete\u00a7c, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u0443\u0434\u0430\u043b\u0435\u043d\u0438\u0435.");
        }
        if (args[0].equals("confirmdelete")) {
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (city.equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            if (nation2.equals("")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0441\u0430\u043c\u043e\u0441\u0442\u043e\u044f\u0442\u0435\u043b\u0435\u043d \u0438 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            capital = main.getInstance().getConfig().getString("states.nation." + nation2 + ".capital");
            if (!capital.equals(city)) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0441\u0442\u043e\u043b\u0438\u0446\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader3 = main.getInstance().getConfig().getString("states.city." + city + ".leader");
            if (!leader3.equals(sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u043b\u0438\u0434\u0435\u0440\u043e\u043c \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            String citiesString = main.getInstance().getConfig().getString("states.nation." + nation2 + ".cities");
            String[] cities4 = SMassiveAPI.toMassive(citiesString);
            for (int i = 0; i < cities4.length; ++i) {
                main.getInstance().getConfig().set("states.city." + cities4[i] + ".nation", (Object)"");
                main.getInstance().getConfig().set("states.city." + cities4[i] + ".isCapital", (Object)"false");
                main.getInstance().getConfig().set("states.city." + cities4[i] + ".nationStatus", (Object)"free");
            }
            String nationList = main.getInstance().getConfig().getString("states.nationList");
            nationList = SMassiveAPI.remove(nationList, nation2);
            main.getInstance().getConfig().set("states.nationList", (Object)nationList);
            dynmapModule.updateNation(nation2);
            main.getInstance().getConfig().set("states.nation." + nation2, null);
            MainAPI.sendGlobalMessage("\u041d\u0430\u0446\u0438\u044f \u00a76" + nation2 + "\u00a7f \u0431\u044b\u043b\u0430 \u0443\u043d\u0438\u0447\u0442\u043e\u0436\u0435\u043d\u0430");
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("joinother")) {
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (city.equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            if (!nation2.equals("")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u0443\u0436\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u043d\u0430\u0446\u0438\u0438 \u00a76" + nation2);
                return true;
            }
            leader2 = main.getInstance().getConfig().getString("states.city." + city + ".leader");
            if (!leader2.equals(sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u043b\u0438\u0434\u0435\u0440\u043e\u043c \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430");
                return true;
            }
            askNation = main.getInstance().getConfig().getString("states.city." + city + ".askNation");
            if (Objects.equals(askNation, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u043b \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044e \u043d\u0438\u043a\u0430\u043a\u0438\u043c \u043d\u0430\u0446\u0438\u044f\u043c!");
                return true;
            }
            main.getInstance().getConfig().set("states.city." + city + ".askNation", (Object)"");
            MainAPI.goodMessage(p, "\u0422\u044b \u043e\u0442\u043c\u0435\u043d\u0438\u043b \u0441\u0432\u043e\u0451 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u0438 \u0434\u043b\u044f \u043d\u0430\u0446\u0438\u0438 \u00a76" + askNation);
            main.getInstance().saveConfig();
            String askingCities = main.getInstance().getConfig().getString("states.nation." + askNation + ".askingCities");
            askingCities = SMassiveAPI.remove(askingCities, city);
            main.getInstance().getConfig().set("states.nation." + askNation + ".askingCities", (Object)askingCities);
            main.getInstance().saveConfig();
        }
        if (args[0].equals("accept")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation accept \u00a77\u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            if (Objects.equals(nation2, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String asking = args[1].toLowerCase();
            askNation = main.getInstance().getConfig().getString("states.city." + asking + ".askNation");
            leader = main.getInstance().getConfig().getString("states.nation." + nation2 + ".leader");
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation2 + ".ministers");
            if (!Objects.equals(nation2, askNation)) {
                MainAPI.badMessage(p, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u043f\u0440\u0435\u0434\u043b\u0430\u0433\u0430\u043b \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u044e");
                return true;
            }
            if (!Objects.equals(leader, sender.getName().toLowerCase()) && ministers.indexOf(sender.getName().toLowerCase()) == -1) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0438 \u043d\u0435 \u043c\u0438\u043d\u0438\u0441\u0442\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String cities5 = main.getInstance().getConfig().getString("states.nation." + nation2 + ".cities");
            String newCities = String.join((CharSequence)", ", cities5, args[1].toLowerCase());
            String askingCities = main.getInstance().getConfig().getString("states.nation." + nation2 + ".askingCities");
            askingCities = SMassiveAPI.remove(askingCities, args[1].toLowerCase());
            int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.nation." + nation2 + ".rang")));
            main.getInstance().getConfig().set("states.nation." + nation2 + ".rang", (Object)(++r));
            main.getInstance().getConfig().set("states.city." + asking + ".askNation", (Object)"");
            main.getInstance().getConfig().set("states.city." + asking + ".nation", (Object)nation2);
            main.getInstance().getConfig().set("states.city." + asking + ".nationStatus", (Object)"slave");
            main.getInstance().getConfig().set("states.nation." + nation2 + ".askingCities", (Object)askingCities);
            main.getInstance().getConfig().set("states.nation." + nation2 + ".cities", (Object)newCities);
            MainAPI.sendNationMessage(nation2, "\u0412\u0430\u0448\u0430 \u043d\u0430\u0446\u0438\u044f \u043f\u0440\u0438\u043d\u044f\u043b\u0430 \u043f\u0440\u0435\u0434\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u0438 \u043e\u0442 \u0433\u043e\u0440\u043e\u0434\u0430 \u00a76" + args[1]);
            dynmapModule.updateCity(asking);
            main.getInstance().saveConfig();
            return true;
        }
        if (args[0].equals("leave")) {
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String cityLeader = main.getInstance().getConfig().getString("states.city." + city + ".leader");
            if (!Objects.equals(cityLeader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0448\u044c\u0441\u044f \u043c\u044d\u0440\u043e\u043c \u0441\u0432\u043e\u0435\u0433\u043e \u0433\u043e\u0440\u043e\u0434\u0430 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0442\u044c \u0440\u0435\u0448\u0435\u043d\u0438\u044f \u043e \u0434\u0435\u0438\u043d\u0442\u0435\u0433\u0440\u0430\u0446\u0438\u0438 \u0433\u043e\u0440\u043e\u0434\u0430 \u0438\u0437 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            String nationName = main.getInstance().getConfig().getString("states.nation." + nation + ".name");
            if (Objects.equals(nation, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String capital4 = main.getInstance().getConfig().getString("states.nation." + nation + ".capital");
            if (Objects.equals(capital4, city)) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 - \u0441\u0442\u043e\u043b\u0438\u0446\u0430 \u043d\u0430\u0446\u0438\u0438! \u0420\u0430\u0441\u0444\u043e\u0440\u043c\u0438\u0440\u0443\u0439 \u0435\u0451 \u0438\u043b\u0438 \u043f\u0435\u0440\u0435\u043d\u0435\u0441\u0438 \u0441\u0442\u043e\u043b\u0438\u0446\u0443, \u0447\u0442\u043e\u0431\u044b \u0434\u0435\u0438\u043d\u0442\u0435\u0433\u0440\u0438\u0440\u043e\u0432\u0430\u0442\u044c\u0441\u044f \u0438\u0437 \u043d\u0435\u0451");
                return true;
            }
            String residentsString = main.getInstance().getConfig().getString("states.city." + city + ".residents");
            String[] residents = SMassiveAPI.toMassive(residentsString);
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers");
            for (int i = 0; i < residents.length; ++i) {
                if (ministers.indexOf(residents[i]) == -1) continue;
                ministers = SMassiveAPI.remove(ministers, residents[i]);
                main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministers);
            }
            String cities6 = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
            cities6 = SMassiveAPI.remove(cities6, city);
            MainAPI.sendCityMessage(city, "\u00a76\u00a7l\u0413\u043e\u0441\u0443\u0434\u0430\u0440\u0441\u0442\u0432\u0430 \u00a78>> \u00a7f\u0412\u0430\u0448 \u0433\u043e\u0440\u043e\u0434 \u043f\u043e\u043a\u0438\u043d\u0443\u043b \u043d\u0430\u0446\u0438\u044e \u00a76" + nationName);
            main.getInstance().getConfig().set("states.nation." + nation + ".cities", (Object)cities6);
            main.getInstance().getConfig().set("states.city." + city + ".nation", (Object)"");
            main.getInstance().getConfig().set("states.city." + city + ".nationStatus", (Object)"free");
            MainAPI.sendNationMessage(nation, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + city + "\u00a7f \u043f\u043e\u043a\u0438\u043d\u0443\u043b \u0432\u0430\u0448\u0443 \u043d\u0430\u0446\u0438\u044e");
            main.getInstance().saveConfig();
            dynmapModule.updateCity(city);
            return true;
        }
        if (args[0].equals("kick")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: /nation kick \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            String senderCity = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (senderCity.equals("")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + senderCity + ".nation");
            if (nation2.equals("")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation2 + ".ministers");
            leader3 = main.getInstance().getConfig().getString("states.nation." + nation2 + ".leader");
            if (!Objects.equals(leader3, sender.getName().toLowerCase()) && ministers.indexOf(sender.getName().toLowerCase()) == -1) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0438 \u043d\u0435 \u043c\u0438\u043d\u0438\u0441\u0442\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0438\u0441\u043a\u043b\u044e\u0447\u0430\u0442\u044c \u0433\u043e\u0440\u043e\u0434\u0430 \u0438\u0437 \u0441\u043e\u0441\u0442\u0430\u0432\u0430 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String kickedCityNation = main.getInstance().getConfig().getString("states.city." + args[1].toLowerCase() + ".nation");
            if (!Objects.equals(nation2, kickedCityNation)) {
                MainAPI.badMessage(p, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0447\u0430\u0441\u0442\u044c\u044e \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            if (senderCity.equalsIgnoreCase(args[1])) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u0438\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0438\u0437 \u043d\u0430\u0446\u0438\u0438 \u0441\u043e\u0431\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0439 \u0433\u043e\u0440\u043e\u0434!");
                return true;
            }
            String citiesString = main.getInstance().getConfig().getString("states.nation." + nation2 + ".cities");
            String[] cities7 = SMassiveAPI.toMassive(citiesString);
            for (int i = 0; i < cities7.length; ++i) {
                String residentsString = main.getInstance().getConfig().getString("states.city." + cities7[i] + ".residents");
                String[] residents = SMassiveAPI.toMassive(residentsString);
                for (i = 0; i < residents.length; ++i) {
                    if (ministers.indexOf(residents[i].toLowerCase()) == -1) continue;
                    ministers = SMassiveAPI.remove(ministers, residents[i]);
                    main.getInstance().getConfig().set("states.nation." + nation2 + ".ministers", (Object)ministers);
                    return true;
                }
            }
            int r = Integer.parseInt(Objects.requireNonNull(main.getInstance().getConfig().getString("states.nation." + nation2 + ".rang")));
            main.getInstance().getConfig().set("states.nation." + nation2 + ".rang", (Object)(--r));
            String kickedCity = args[1].toLowerCase();
            citiesString = SMassiveAPI.remove(citiesString, args[2].toLowerCase());
            main.getInstance().getConfig().set("states.nation." + nation2 + ".cities", (Object)citiesString);
            main.getInstance().getConfig().set("states.city." + args[1].toLowerCase() + ".nation", (Object)"");
            MainAPI.sendNationMessage(nation2, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7f \u0431\u044b\u043b \u0438\u0441\u043a\u043b\u044e\u0447\u0451\u043d \u0438\u0437 \u0441\u043e\u0441\u0442\u0430\u0432\u0430 \u043d\u0430\u0446\u0438\u0438 \u0438\u0433\u0440\u043e\u043a\u043e\u043c \u00a76" + sender.getName());
            main.getInstance().getConfig().set("states.city." + kickedCity + ".nationStatus", (Object)"free");
            main.getInstance().saveConfig();
            dynmapModule.updateCity(kickedCity);
            return true;
        }
        if (args[0].equals("minister")) {
            if (args.length < 3) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation minister set/remove \u00a77\u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String ministerCity = main.getInstance().getConfig().getString("states.player." + args[2].toLowerCase() + ".city");
            if (Objects.equals(ministerCity, "")) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            cities = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
            if (cities.indexOf(ministerCity) == -1) {
                MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u0432 \u0433\u043e\u0440\u043e\u0434\u0435, \u043a\u043e\u0442\u043e\u0440\u044b\u0439 \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0447\u0430\u0441\u0442\u044c\u044e \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader = main.getInstance().getConfig().getString("states.nation." + nation + ".leader");
            if (!Objects.equals(leader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043d\u0430\u0437\u043d\u0430\u0447\u0430\u0442\u044c \u043c\u0438\u043d\u0438\u0441\u0442\u0440\u043e\u0432");
                return true;
            }
            String ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers");
            if (args[1].equals("set")) {
                if (ministers.indexOf(args[2].toLowerCase()) != -1) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0443\u0436\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043c\u0438\u043d\u0438\u0441\u0442\u0440\u043e\u043c \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                    return true;
                }
                String ministersNew = String.join((CharSequence)", ", ministers, args[2].toLowerCase());
                main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministersNew);
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0430\u0437\u043d\u0430\u0447\u0438\u043b \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[2].toLowerCase() + "\u00a7c \u043d\u0430 \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u044c \u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430.");
                main.getInstance().saveConfig();
                return true;
            }
            if (args[1].equals("remove")) {
                if (ministers.indexOf(args[2].toLowerCase()) == -1) {
                    MainAPI.badMessage(p, "\u0418\u0433\u0440\u043e\u043a \u00a76" + args[2] + "\u00a7c \u0438 \u0442\u0430\u043a \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043c\u0438\u043d\u0438\u0441\u0442\u0440\u043e\u043c \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                    return true;
                }
                ministers = SMassiveAPI.remove(ministers, args[2].toLowerCase());
                main.getInstance().getConfig().set("states.nation." + nation + ".ministers", (Object)ministers);
                MainAPI.badMessage(p, "\u0422\u044b \u0441\u043d\u044f\u043b \u0438\u0433\u0440\u043e\u043a\u0430 \u00a76" + args[2] + "\u00a7c \u0441 \u0434\u043e\u043b\u0436\u043d\u043e\u0441\u0442\u0438 \u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430.");
                main.getInstance().saveConfig();
                return true;
            }
        }
        if (args[0].equals("capital")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation capital\u00a77 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            targetCity = args[1].toLowerCase();
            nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            cities = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
            if (cities.indexOf(targetCity) == -1) {
                MainAPI.badMessage(p, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0447\u0430\u0441\u0442\u044c\u044e \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader = main.getInstance().getConfig().getString("states.nation." + nation + ".leader");
            if (!Objects.equals(leader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0438\u0442\u044c \u0441\u0442\u043e\u043b\u0438\u0446\u0443");
                return true;
            }
            MainAPI.badMessage(p, "\u0422\u044b \u0442\u043e\u0447\u043d\u043e \u0445\u043e\u0447\u0435\u0448\u044c \u043f\u0435\u0440\u0435\u043d\u0435\u0441\u0442\u0438 \u0441\u0442\u043e\u043b\u0438\u0446\u0443 \u043d\u0430\u0446\u0438\u0438 \u0432 \u0433\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7c? \u0421 \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u043e\u043c \u0441\u0442\u043e\u043b\u0438\u0446\u044b \u0442\u044b \u00a74\u043f\u043e\u0442\u0435\u0440\u044f\u0435\u0448\u044c\u00a7c \u043f\u0440\u0430\u0432\u0430 \u043b\u0438\u0434\u0435\u0440\u0430 \u043d\u0430\u0446\u0438\u0438!");
            MainAPI.badMessage(p, "\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0439 \u00a76/nation confirmcapital \u00a77" + args[1] + "\u00a7c, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u043f\u0435\u0440\u0435\u043d\u043e\u0441.");
        }
        if (args[0].equals("confirmcapital")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation confirmcapital\u00a77 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            targetCity = args[1].toLowerCase();
            nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            cities = main.getInstance().getConfig().getString("states.nation." + nation + ".cities");
            if (cities.indexOf(targetCity) == -1) {
                MainAPI.badMessage(p, "\u0413\u043e\u0440\u043e\u0434 \u00a76" + args[1] + "\u00a7c \u043d\u0435 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u0447\u0430\u0441\u0442\u044c\u044e \u0442\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader = main.getInstance().getConfig().getString("states.nation." + nation + ".leader");
            if (!Objects.equals(leader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043f\u0435\u0440\u0435\u043d\u043e\u0441\u0438\u0442\u044c \u0441\u0442\u043e\u043b\u0438\u0446\u0443");
                return true;
            }
            String oldCapital = MainAPI.getNationInfo(nation, "capital");
            if (oldCapital.equals(targetCity)) {
                MainAPI.badMessage(p, "\u0422\u044b \u0445\u043e\u0442\u044c \u0441\u0430\u043c \u043f\u043e\u043d\u044f\u043b, \u0447\u0435 \u043d\u0430\u043f\u0438\u0441\u0430\u043b?");
                return true;
            }
            String targetCityLeader = main.getInstance().getConfig().getString("states.city." + targetCity + ".leader");
            main.getInstance().getConfig().set("states.nation." + nation + ".capital", (Object)targetCity);
            main.getInstance().getConfig().set("states.nation." + nation + ".leader", (Object)targetCityLeader);
            main.getInstance().getConfig().set("states.city." + city + ".isCapital", (Object)"false");
            main.getInstance().getConfig().set("states.city." + city + ".nationStatus", (Object)"slave");
            main.getInstance().getConfig().set("states.city." + targetCity + ".isCapital", (Object)"true");
            main.getInstance().getConfig().set("states.city." + targetCity + ".nationStatus", (Object)"capital");
            MainAPI.sendNationMessage(nation, "\u0421\u0442\u043e\u043b\u0438\u0446\u0430 \u0432\u0430\u0448\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0431\u044b\u043b\u0430 \u043f\u0435\u0440\u0435\u043c\u0435\u0449\u0435\u043d\u0430 \u0432 \u0433\u043e\u0440\u043e\u0434 \u00a76" + args[1]);
            dynmapModule.updateNation(nation);
            main.getInstance().saveConfig();
        }
        if (args[0].equals("color")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation color\u00a77 \u0446\u0432\u0435\u0442");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            nation2 = main.getInstance().getConfig().getString("states.city." + city + ".nation");
            if (Objects.equals(nation2, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            leader2 = main.getInstance().getConfig().getString("states.nation." + nation2 + ".leader");
            if (!Objects.equals(leader2, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0438 \u043d\u0435 \u043c\u043e\u0436\u0435\u0448\u044c \u043c\u0435\u043d\u044f\u0442\u044c \u0446\u0432\u0435\u0442");
                return true;
            }
            String color = MainAPI.color(args[1]);
            if (color.equals("c9c9c9")) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u043e\u0433\u043e \u0446\u0432\u0435\u0442\u0430 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442! \u0414\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0446\u0432\u0435\u0442\u0430: darkblue, turquoise, orange, lightblue, blue, lightred, darkgray, white, lightgreen, green, darkred, purple, fullblack, gold");
                return true;
            }
            main.getInstance().getConfig().set("states.nation." + nation2 + ".color", (Object)color);
            main.getInstance().saveConfig();
            dynmapModule.updateNation(nation2);
            MainAPI.sendNationMessage(nation2, "\u041b\u0438\u0434\u0435\u0440 \u0432\u0430\u0448\u0435\u0439 \u043d\u0430\u0446\u0438\u0438 \u0441\u043c\u0435\u043d\u0438\u043b \u0446\u0432\u0435\u0442 \u043d\u0430\u0446\u0438\u0438 \u043d\u0430 \u00a76" + args[1]);
            return true;
        }
        if (args[0].equals("dontdoitpls")) {
            if (args.length < 2) {
                MainAPI.badMessage(p, "\u0422\u044b \u0432\u0432\u0451\u043b \u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u0430\u043b\u043e \u0430\u0440\u0433\u0443\u043c\u0435\u043d\u0442\u043e\u0432! \u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435: \u00a76/nation rename \u00a77\u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435");
                return true;
            }
            city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
            if (Objects.equals(city, "")) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0448\u044c \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u043c \u0433\u043e\u0440\u043e\u0434\u0435");
                return true;
            }
            String cityNation = MainAPI.getCityInfo(city, "nation");
            if (Objects.equals(cityNation, "")) {
                MainAPI.badMessage(p, "\u0422\u0432\u043e\u0439 \u0433\u043e\u0440\u043e\u0434 \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442 \u043d\u0438 \u0432 \u043a\u0430\u043a\u043e\u0439 \u043d\u0430\u0446\u0438\u0438");
                return true;
            }
            String nationLeader = main.getInstance().getConfig().getString("states.nation." + cityNation + ".leader");
            if (!Objects.equals(nationLeader, sender.getName().toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u044b \u043d\u0435 \u043b\u0438\u0434\u0435\u0440 \u0441\u0432\u043e\u0435\u0439 \u043d\u0430\u0446\u0438\u0438.");
                return true;
            }
            if (args.length > 2) {
                Object message = "";
                for (int i = 1; i < args.length; ++i) {
                    message = String.valueOf(message) + args[i] + "_";
                }
                args[1] = message;
            }
            if (main.getInstance().getConfig().isSet("states.nation." + args[1].toLowerCase())) {
                MainAPI.badMessage(p, "\u0422\u0430\u043a\u0430\u044f \u043d\u0430\u0446\u0438\u044f \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
                return true;
            }
            if (args[1].length() < 2) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438 \u0434\u043e\u043b\u0436\u043d\u043e \u0441\u043e\u0441\u0442\u043e\u044f\u0442\u044c \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u0438\u0437 2 \u0441\u0438\u043c\u0432\u043e\u043b\u043e\u0432");
                return true;
            }
            if (!args[1].matches("[a-zA-Z0-9\u0430-\u044f\u0410-\u042f-_]+")) {
                MainAPI.badMessage(p, "\u041d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u043e\u043b\u044c\u043a\u043e \u0431\u0443\u043a\u0432\u044b, \u0446\u0438\u0444\u0440\u044b, \u0442\u0438\u0440\u0435 \u0438 \u0437\u043d\u0430\u043a\u0438 \u043f\u043e\u0434\u0447\u0451\u0440\u043a\u0438\u0432\u0430\u043d\u0438\u044f");
                return true;
            }
            String nation7 = args[1].toLowerCase();
            if (cityNation.equals(nation7)) {
                MainAPI.badMessage(p, "\u041d\u043e\u0432\u043e\u0435 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043d\u0430\u0446\u0438\u0438 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442 \u0441\u043e \u0441\u0442\u0430\u0440\u044b\u043c");
                return true;
            }
            sender.sendMessage(cityNation);
            String nationName = args[1];
            String board = MainAPI.getNationInfo(cityNation, "board");
            String leader8 = MainAPI.getNationInfo(cityNation, "leader");
            String ministers = MainAPI.getNationInfo(cityNation, "ministers");
            String capital5 = MainAPI.getNationInfo(cityNation, "capital");
            String nationID = MainAPI.getNationInfo(cityNation, "regionID");
            String currencyID = MainAPI.getNationInfo(cityNation, "currencyID");
            String corporation = MainAPI.getNationInfo(cityNation, "government.company");
            String occupation = MainAPI.getNationInfo(cityNation, "government.occupation");
            String rang = MainAPI.getNationInfo(cityNation, "rang");
            String color = MainAPI.getNationInfo(cityNation, "color");
            String askingCities = MainAPI.getNationInfo(cityNation, "askingCities");
            String cities8 = MainAPI.getNationInfo(cityNation, "cities");
            String deleteDate = MainAPI.getNationInfo(cityNation, "deleteDate");
            String citiesString = Objects.requireNonNull(main.getInstance().getConfig().getString("states.nation." + cityNation + ".cities"));
            String[] citiesMassive = SMassiveAPI.toMassive(citiesString);
            for (int i = 0; i < citiesMassive.length; ++i) {
                main.getInstance().getConfig().set("states.city." + citiesMassive[i] + ".nation", (Object)nation7);
            }
            MainAPI.setNation(nation7, "name", nationName);
            MainAPI.setNation(nation7, "board", board);
            MainAPI.setNation(nation7, "leader", leader8);
            MainAPI.setNation(nation7, "ministers", ministers);
            MainAPI.setNation(nation7, "capital", capital5);
            MainAPI.setNation(nation7, "regionID", nationID);
            MainAPI.setNation(nation7, "currencyID", currencyID);
            MainAPI.setNation(nation7, "government.company", corporation);
            MainAPI.setNation(nation7, "government.occupation", occupation);
            MainAPI.setNation(nation7, "rang", rang);
            MainAPI.setNation(nation7, "color", color);
            MainAPI.setNation(nation7, "askingCities", askingCities);
            MainAPI.setNation(nation7, "cities", cities8);
            MainAPI.setNation(nation7, "deleteDate", deleteDate);
            String nationList = MainAPI.getString("states.nationList");
            String newNationList = nationList.replace(cityNation, nation7);
            MainAPI.set("states.nationList", newNationList);
            MainAPI.set("states.nation." + cityNation, null);
            MainAPI.sendNationMessage(nation7, "\u0412\u0430\u0448\u0430 \u043d\u0430\u0446\u0438\u044f \u0438\u0437\u043c\u0435\u043d\u0438\u043b\u0430 \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435! \u0422\u0435\u043f\u0435\u0440\u044c \u0432\u044b \u043f\u0440\u043e\u0436\u0438\u0432\u0430\u0435\u0442\u0435 \u0432 \u043d\u0430\u0446\u0438\u0438 \u00a76" + args[1]);
            MainAPI.save();
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
        arrobject[1] = "states/nationMain";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

