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

import library.Hexagon;
import library.HexagonalGrid;
import library.Morton64;
import library.Orientation;
import library.Point;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import states.Hexagons.DynmapDrawer;
import states.Hexagons.MinecraftHexagonalGrid;

public class test
implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender == null) {
            test.$$$reportNull$$$0(0);
        }
        if (command == null) {
            test.$$$reportNull$$$0(1);
        }
        if (s == null) {
            test.$$$reportNull$$$0(2);
        }
        if (args == null) {
            test.$$$reportNull$$$0(3);
        }
        if (args.length == 0) {
            sender.sendMessage("no args");
            return true;
        }
        if (args[0].equals("hexagon")) {
            if (args.length == 1) {
                sender.sendMessage("no args");
                return true;
            }
            if (args[1].equals("start")) {
                sender.sendMessage("\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u0441\u0438\u0441\u0442\u0435\u043c\u044b \u0433\u0435\u043a\u0441\u0430\u0433\u043e\u043d\u043e\u0432 \u043d\u0430\u0447\u0430\u0442\u043e.");
                HexagonalGrid hexagonGrid = new HexagonalGrid(Orientation.FLAT, new Point(0.0, 0.0), new Point(100.0, 100.0), new Morton64(2L, 32L));
                Player p = (Player)sender;
                Hexagon hexagon = hexagonGrid.getHexagon(new Point(p.getLocation().getX(), p.getLocation().getZ()));
                Point[] corners = hexagon.getVertexPositions();
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"dmarker addset id:test world:world");
                for (int i = 0; i < 6; ++i) {
                    String x = String.valueOf(corners[i].getX());
                    String z = String.valueOf(corners[i].getY());
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("dmarker add icon:cross set:test x:" + x + " y:64 z:" + z + " world:world"));
                }
                Hexagon[] neighbours = hexagon.getNeighbors(1);
                Point[] centers = new Point[6];
                for (int i = 0; i < neighbours.length; ++i) {
                    centers[i] = neighbours[i].getCenter();
                    String x = String.valueOf(centers[i].getX());
                    String z = String.valueOf(centers[i].getY());
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("dmarker add icon:cross set:test x:" + x + " y:64 z:" + z + " world:world"));
                }
                sender.sendMessage("\u041f\u0440\u043e\u0446\u0435\u0434\u0443\u0440\u044b \u0442\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f \u0441\u0438\u0441\u0442\u0435\u043c\u044b \u0433\u0435\u043a\u0441\u0430\u0433\u043e\u043d\u043e\u0432 \u0437\u0430\u0432\u0435\u0440\u0448\u0435\u043d\u044b.");
                return true;
            }
            if (args[1].equals("draw")) {
                sender.sendMessage("\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u0441\u0438\u0441\u0442\u0435\u043c\u044b \u043e\u0442\u0440\u0438\u0441\u043e\u0432\u043a\u0438 \u0433\u0435\u043a\u0441\u0430\u0433\u043e\u043d\u043e\u0432 \u043d\u0430\u0447\u0430\u0442\u043e.");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"dmarker addset id:test world:world");
                Player p = (Player)sender;
                Hexagon[] hexagons = new Hexagon[9];
                DynmapDrawer drawer = new DynmapDrawer();
                MinecraftHexagonalGrid grid = new MinecraftHexagonalGrid(Orientation.FLAT, new Point(0.0, 0.0), new Point(100.0, 100.0), new Morton64(2L, 32L));
                hexagons[0] = grid.getHexagon(new Point(p.getLocation().getX(), p.getLocation().getZ()));
                hexagons[1] = hexagons[0].getNeighbor(1);
                hexagons[2] = hexagons[0].getNeighbor(2);
                hexagons[3] = hexagons[0].getNeighbor(3);
                hexagons[4] = hexagons[0].getNeighbor(4);
                hexagons[5] = hexagons[1].getNeighbor(1);
                hexagons[6] = hexagons[5].getNeighbor(2);
                hexagons[7] = hexagons[6].getNeighbor(3);
                hexagons[8] = hexagons[7].getNeighbor(4);
                drawer.drawFigure(hexagons);
                return true;
            }
            if (args[1].equals("stop")) {
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"dmarker deleteset id:test world:world");
                sender.sendMessage("\u0422\u0435\u0441\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0435 \u0441\u0438\u0441\u0442\u0435\u043c\u044b \u0433\u0435\u043a\u0441\u0430\u0433\u043e\u043d\u043e\u0432 \u0437\u0430\u043a\u043e\u043d\u0447\u0435\u043d\u043e.");
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
        arrobject[1] = "states/test";
        arrobject[2] = "onCommand";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arrobject));
    }
}

