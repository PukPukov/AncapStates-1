/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.dynmap.DynmapAPI
 *  org.dynmap.markers.CircleMarker
 *  org.dynmap.markers.Marker
 *  org.dynmap.markers.MarkerSet
 */
package states;

import org.bukkit.Bukkit;
import org.dynmap.DynmapAPI;
import org.dynmap.markers.CircleMarker;
import org.dynmap.markers.Marker;
import org.dynmap.markers.MarkerSet;

public class descriptionSetter {
    public static void setDescription(String id, String description) {
        DynmapAPI dynmap = (DynmapAPI)Bukkit.getServer().getPluginManager().getPlugin("Dynmap");
        MarkerSet m = dynmap.getMarkerAPI().getMarkerSet("ancapcity");
        CircleMarker cm = m.findCircleMarker(id);
        Marker mm = m.findMarker(id);
        cm.setDescription(description);
        mm.setDescription(description);
    }
}

