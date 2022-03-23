/*
 * Decompiled with CFR 0.150.
 */
package states.Hexagons;

import library.HexagonalGrid;
import library.Morton64;
import library.Orientation;
import library.Point;

public class MinecraftHexagonalGrid
extends HexagonalGrid {
    public MinecraftHexagonalGrid(Orientation orientation, Point origin, Point size, Morton64 mort) {
        super(orientation, origin, size, mort);
    }
}

