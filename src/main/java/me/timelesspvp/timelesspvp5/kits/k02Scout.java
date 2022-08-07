package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.helperMethods;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class k02Scout {

    public static void giveKit(Player p) {

        // Items

            //holy mackerel
        ItemStack holyMackerel = getHolyMack();

            // pocket pistol
        ItemStack pocketPistol = getPocketPistol(48);

            // reload
        ItemStack reload = getReload();

        p.getInventory().addItem(holyMackerel, pocketPistol);


        //Armor

            // Skull
        ItemStack nateSkull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta nateSkullMeta = (SkullMeta) nateSkull.getItemMeta();
//        nateSkullMeta.setOwningPlayer(Bukkit.getPlayer(
//                UUID.fromString("0090ef17-4c4b-461f-96c7-60ea0fd0b9cf")));
        nateSkullMeta.setOwner("SmittyMon");
        nateSkull.setItemMeta(nateSkullMeta);

        p.getInventory().setItem(EquipmentSlot.HEAD, nateSkull);


        // Potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        PotionEffect pSpeed = new PotionEffect(
                PotionEffectType.SPEED,
                10000000, 3,
                false, false);

        p.addPotionEffect(pSat);
        p.addPotionEffect(pSpeed);


        // Persistent data
        PersistentDataContainer data = p.getPersistentDataContainer();
        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutStacks"), PersistentDataType.INTEGER, 0);


        // Spawn Location
        Location loc = helperMethods.getLocationConfig("scout");
        p.teleport(loc);
    }


    public static ItemStack getPocketPistol(int amount) {
        ItemStack pocketPistol = new ItemStack(Material.STICK, amount);
        ItemMeta pocketPistolMeta = pocketPistol.getItemMeta();
        pocketPistolMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Pretty Boy's Pocket Pistol" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        pocketPistol.setItemMeta(pocketPistolMeta);

        return pocketPistol;
    }


    public static ItemStack getHolyMack() {
        ItemStack holyMackerel = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta holyMackerelMeta = holyMackerel.getItemMeta();
        holyMackerelMeta.setUnbreakable(true);
        holyMackerelMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        holyMackerelMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Holy Mackerel" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        holyMackerel.setItemMeta(holyMackerelMeta);
        return holyMackerel;
    }


    public static ItemStack getReload() {
        ItemStack reload = new ItemStack(Material.FEATHER, 1);
        ItemMeta reloadMeta = reload.getItemMeta();
        reloadMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Reload" );
        reload.setItemMeta(reloadMeta);
        return reload;
    }
}
