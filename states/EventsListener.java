/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  fr.xephi.authme.api.v3.AuthMeApi
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.command.CommandSender
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Snowball
 *  org.bukkit.entity.SpectralArrow
 *  org.bukkit.entity.Trident
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityExplodeEvent
 *  org.bukkit.event.entity.ProjectileLaunchEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerMoveEvent
 */
package states;

import fr.xephi.authme.api.v3.AuthMeApi;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import states.API.MainAPI;
import states.API.StatesAPI;
import states.main;

public class EventsListener
implements Listener {
    HashMap<String, String> playerCities = new HashMap();

    @EventHandler
    public void pidorJoin(PlayerJoinEvent e) {
        Player sender = e.getPlayer();
        MainAPI.createProfile((CommandSender)sender);
        String city = main.getInstance().getConfig().getString("states.player." + sender.getName().toLowerCase() + ".city");
        if (city.equals("")) {
            return;
        }
        Date current = new Date();
        long dateDeletePro = current.getTime() + 216000000L;
        long dateDeleteLoh = current.getTime() + 129600000L;
        String nation = main.getInstance().getConfig().getString("states.city." + city + ".nation");
        String deputats = main.getInstance().getConfig().getString("states.city." + city + ".deputats");
        String ministers = main.getInstance().getConfig().getString("states.nation." + nation + ".ministers");
        String cityLeader = main.getInstance().getConfig().getString("states.city." + city + ".leader");
        String nationLeader = main.getInstance().getConfig().getString("states.nation." + nation + ".leader");
        if (Objects.equals(cityLeader, sender.getName().toLowerCase())) {
            main.getInstance().getConfig().set("states.city." + city + ".deleteDate", (Object)dateDeletePro);
        }
        if (deputats.indexOf(sender.getName().toLowerCase()) != -1) {
            main.getInstance().getConfig().set("states.city." + city + ".deleteDate", (Object)dateDeletePro);
        }
        if (!Objects.equals(cityLeader, sender.getName().toLowerCase()) && deputats.indexOf(sender.getName().toLowerCase()) == -1) {
            main.getInstance().getConfig().set("states.city." + city + ".deleteDate", (Object)dateDeleteLoh);
        }
        if (nation.equals("")) {
            return;
        }
        if (Objects.equals(nationLeader, sender.getName().toLowerCase())) {
            main.getInstance().getConfig().set("states.nation." + nation + ".deleteDate", (Object)dateDeletePro);
        }
        if (ministers.indexOf(sender.getName().toLowerCase()) != -1) {
            main.getInstance().getConfig().set("states.nation." + nation + ".deleteDate", (Object)dateDeletePro);
        }
        if (!Objects.equals(nationLeader, sender.getName().toLowerCase()) && ministers.indexOf(sender.getName().toLowerCase()) == -1) {
            main.getInstance().getConfig().set("states.nation." + nation + ".deleteDate", (Object)dateDeleteLoh);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void pidorIdet(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (!AuthMeApi.getInstance().isAuthenticated(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void damage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.PLAYER) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)e.getDamager();
        Player p1 = (Player)e.getEntity();
        if (!(StatesAPI.inCity(p, 50) || StatesAPI.inCity(p1, 50) || StatesAPI.justInOutpost(p) || StatesAPI.justInOutpost(p1))) {
            return;
        }
        p.sendMessage("\u00a7c\u0420\u044f\u0434\u043e\u043c \u0441 \u0433\u043e\u0440\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u043b\u044c\u0437\u044f \u0434\u0440\u0430\u0442\u044c\u0441\u044f!");
        e.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void abuseDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.ARROW) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        Arrow a = (Arrow)e.getDamager();
        if (((Entity)a.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)a.getShooter();
        Player p1 = (Player)e.getEntity();
        if (!(StatesAPI.inCity(p, 50) || StatesAPI.inCity(p1, 50) || StatesAPI.justInOutpost(p) || StatesAPI.justInOutpost(p1))) {
            return;
        }
        p.sendMessage("\u00a7c\u0420\u044f\u0434\u043e\u043c \u0441 \u0433\u043e\u0440\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u043b\u044c\u0437\u044f \u0434\u0440\u0430\u0442\u044c\u0441\u044f!");
        e.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void abuseDamage2(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.SPECTRAL_ARROW) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        SpectralArrow a = (SpectralArrow)e.getDamager();
        if (((Entity)a.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)a.getShooter();
        Player p1 = (Player)e.getEntity();
        if (!(StatesAPI.inCity(p, 50) || StatesAPI.inCity(p1, 50) || StatesAPI.justInOutpost(p) || StatesAPI.justInOutpost(p1))) {
            return;
        }
        p.sendMessage("\u00a7c\u0420\u044f\u0434\u043e\u043c \u0441 \u0433\u043e\u0440\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u043b\u044c\u0437\u044f \u0434\u0440\u0430\u0442\u044c\u0441\u044f!");
        e.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void abuseDamage3(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.SNOWBALL) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        Snowball s = (Snowball)e.getDamager();
        if (((Entity)s.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)s.getShooter();
        Player p1 = (Player)e.getEntity();
        if (!(StatesAPI.inCity(p, 50) || StatesAPI.inCity(p1, 50) || StatesAPI.justInOutpost(p) || StatesAPI.justInOutpost(p1))) {
            return;
        }
        p.sendMessage("\u00a7c\u0420\u044f\u0434\u043e\u043c \u0441 \u0433\u043e\u0440\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u043b\u044c\u0437\u044f \u0434\u0440\u0430\u0442\u044c\u0441\u044f!");
        e.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void abuseDamage4(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.TRIDENT) {
            return;
        }
        if (e.getEntityType() != EntityType.PLAYER) {
            return;
        }
        Trident t = (Trident)e.getDamager();
        if (((Entity)t.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)t.getShooter();
        Player p1 = (Player)e.getEntity();
        if (!(StatesAPI.inCity(p, 50) || StatesAPI.inCity(p1, 50) || StatesAPI.justInOutpost(p) || StatesAPI.justInOutpost(p1))) {
            return;
        }
        p.sendMessage("\u00a7c\u0420\u044f\u0434\u043e\u043c \u0441 \u0433\u043e\u0440\u043e\u0434\u0430\u043c\u0438 \u043d\u0435\u043b\u044c\u0437\u044f \u0434\u0440\u0430\u0442\u044c\u0441\u044f!");
        e.setCancelled(true);
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion1(BlockBreakEvent e) {
        Block b = e.getBlock();
        Location loc = b.getLocation();
        Player p = e.getPlayer();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion2(BlockPlaceEvent e) {
        Block b = e.getBlock();
        Location loc = b.getLocation();
        Player p = e.getPlayer();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion3(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)e.getDamager();
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion3Abuse(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.ARROW) {
            return;
        }
        Arrow a = (Arrow)e.getDamager();
        if (((Entity)a.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)a.getShooter();
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion3Abuse2(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.SPECTRAL_ARROW) {
            return;
        }
        SpectralArrow a = (SpectralArrow)e.getDamager();
        if (((Entity)a.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)a.getShooter();
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion3Abuse3(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.SNOWBALL) {
            return;
        }
        Snowball s = (Snowball)e.getDamager();
        if (((Entity)s.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)s.getShooter();
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion3Abuse4(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() != EntityType.TRIDENT) {
            return;
        }
        Trident t = (Trident)e.getDamager();
        if (((Entity)t.getShooter()).getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player)t.getShooter();
        Entity entity = e.getEntity();
        Location loc = entity.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion4(PlayerInteractEvent e) {
        Block b = e.getClickedBlock();
        if (b == null) {
            return;
        }
        Material bt = b.getType();
        if (bt.isInteractable() && (bt == Material.OAK_DOOR || bt == Material.SPRUCE_DOOR || bt == Material.DARK_OAK_DOOR || bt == Material.ACACIA_DOOR || bt == Material.BIRCH_DOOR || bt == Material.JUNGLE_DOOR || bt == Material.WARPED_DOOR || bt == Material.CRIMSON_DOOR)) {
            return;
        }
        Location loc = b.getLocation();
        Player p = e.getPlayer();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (city.equals("-1")) {
            if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                e.setCancelled(true);
                return;
            }
            return;
        }
        String privateChunk = StatesAPI.inPrivateChunk(city, loc);
        if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
            e.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void cityRegion5(ProjectileLaunchEvent e) {
        String privateChunk;
        String outpost;
        String city;
        Location loc;
        Player p;
        if (e.getEntityType() == EntityType.SPLASH_POTION) {
            if (!(e.getEntity().getShooter() instanceof Player)) {
                return;
            }
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntityType() == EntityType.FISHING_HOOK) {
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntityType() == EntityType.ARROW) {
            if (!(e.getEntity().getShooter() instanceof Player)) {
                return;
            }
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntityType() == EntityType.SPECTRAL_ARROW) {
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntityType() == EntityType.TRIDENT) {
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
        if (e.getEntityType() == EntityType.SNOWBALL) {
            if (!(e.getEntity().getShooter() instanceof Player)) {
                return;
            }
            p = (Player)e.getEntity().getShooter();
            loc = e.getLocation();
            city = StatesAPI.inCity(loc);
            outpost = StatesAPI.inOutpost(loc);
            if (city.equals("-1")) {
                if (!outpost.equals("-1") && !MainAPI.canInteractCity(city = MainAPI.getOutpostInfo(outpost, "owner"), p)) {
                    e.setCancelled(true);
                    return;
                }
                return;
            }
            privateChunk = StatesAPI.inPrivateChunk(city, loc);
            if (!MainAPI.canInteractCityDirectly(city, privateChunk, p)) {
                e.setCancelled(true);
                return;
            }
        }
    }

    @EventHandler
    public void explosion(EntityExplodeEvent e) {
        Location loc = e.getLocation();
        String city = StatesAPI.inCity(loc);
        String outpost = StatesAPI.inOutpost(loc);
        if (!city.equals("-1")) {
            e.setCancelled(true);
        }
        if (!outpost.equals("-1")) {
            e.setCancelled(true);
        }
    }
}

