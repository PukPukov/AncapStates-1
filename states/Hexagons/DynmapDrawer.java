/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.command.CommandSender
 */
package states.Hexagons;

import library.Hexagon;
import library.HexagonComponents.HexagonSide;
import library.HexagonalGrid;
import library.Point;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class DynmapDrawer {
    public void addPoints(Point[] points) {
        for (Point point : points) {
            double x = point.getX();
            double y = point.getY();
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("dmarker addcorner " + x + " 64 " + y + " world"));
        }
    }

    public void drawLine(Point[] points) {
        this.addPoints(points);
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"dmarker addline set:test weight:7 color:000 opacity:1.0");
    }

    public void draw(HexagonSide side) {
        Point[] points = side.getEnds();
        this.drawLine(points);
    }

    public void draw(HexagonSide[] sides) {
        for (HexagonSide side : sides) {
            this.draw(side);
        }
    }

    public void draw(Hexagon hexagon) {
        Point[] points = hexagon.getVertexPositions();
        this.addPoints(points);
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"dmarker addarea set:test weight:3 color:000 fillopacity:0.6 fillcolor:b80000 opacity:0.01");
    }

    public void draw(Hexagon[] hexagons) {
        for (Hexagon hexagon : hexagons) {
            this.draw(hexagon);
        }
    }

    public void drawFigure(Hexagon[] hexagons) {
        HexagonalGrid grid = hexagons[0].getGrid();
        HexagonSide[] sides = grid.getBounds(hexagons);
        this.draw(hexagons);
        this.draw(sides);
    }
}

