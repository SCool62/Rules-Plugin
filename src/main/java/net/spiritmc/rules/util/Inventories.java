package net.spiritmc.rules.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class Inventories {

    public static Inventory getRulesInitialInventory(InventoryHolder holder, FileConfiguration config) {
        Inventory menu = Bukkit.createInventory(holder, 36, "Rules");

        // Buttons
        ItemStack tier1 = new ItemStack(Material.BLUE_STAINED_GLASS);
        ItemStack tier2 = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemStack tier3 = new ItemStack(Material.YELLOW_STAINED_GLASS);
        ItemStack tier4 = new ItemStack(Material.ORANGE_STAINED_GLASS);
        ItemStack tier5 = new ItemStack(Material.RED_STAINED_GLASS);

        // Metadata
        ItemMeta meta = tier1.getItemMeta();
        meta.setDisplayName("Tier 1");
        meta.setLore(Collections.singletonList(config.getString("tiers.1.description")));
        tier1.setItemMeta(meta);

        meta = tier2.getItemMeta();
        meta.setDisplayName("Tier 2");
        meta.setLore(Collections.singletonList(config.getString("tiers.2.description")));
        tier2.setItemMeta(meta);

        meta = tier3.getItemMeta();
        meta.setDisplayName("Tier 3");
        meta.setLore(Collections.singletonList(config.getString("tiers.3.description")));
        tier3.setItemMeta(meta);

        meta = tier4.getItemMeta();
        meta.setDisplayName("Tier 4");
        meta.setLore(Collections.singletonList(config.getString("tiers.4.description")));
        tier4.setItemMeta(meta);

        meta = tier5.getItemMeta();
        meta.setDisplayName("Tier 5");
        meta.setLore(Collections.singletonList(config.getString("tiers.5.description")));
        tier5.setItemMeta(meta);

        menu.setItem(20, tier1);
        menu.setItem(21, tier2);
        menu.setItem(22, tier3);
        menu.setItem(23, tier4);
        menu.setItem(24, tier5);

        return menu;
    }

    public static Inventory getTierInventory(InventoryHolder holder, FileConfiguration config, int tier) {
        Inventory menu = Bukkit.createInventory(holder, 36, "Rules: Tier " + tier);

        List<String> rules = config.getStringList("tiers." + tier + ".rules");

        Material material = switch (tier) {
            case 1: yield Material.BLUE_STAINED_GLASS;
            case 2: yield Material.GREEN_STAINED_GLASS;
            case 3: yield Material.YELLOW_STAINED_GLASS;
            case 4: yield Material.ORANGE_STAINED_GLASS;
            case 5: yield Material.RED_STAINED_GLASS;
            default:
                throw new IllegalStateException("Unexpected value: " + tier);
        };

        int itemPos = 10;
        for (String rule : rules) {
            ItemStack ruleItem = new ItemStack(material);
            ItemMeta meta = ruleItem.getItemMeta();
            meta.setDisplayName(rule);
            ruleItem.setItemMeta(meta);

            menu.setItem(itemPos, ruleItem);

            itemPos++;
            if (((itemPos + 1) % 9) == 0) {
                itemPos += 2;
            }
            if (itemPos == 28) {
                itemPos++;
            }
        }

        ItemStack backBtn = new ItemStack(Material.BARRIER);
        ItemMeta backMeta = backBtn.getItemMeta();
        backMeta.setDisplayName("Back");
        backBtn.setItemMeta(backMeta);

        menu.setItem(28, backBtn);

        return menu;
    }


}
