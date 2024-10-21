package net.spiritmc.rules.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("Rules")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                Player player = (Player) e.getWhoClicked();
                player.performCommand("rules");
            }
        }

        if (e.getView().getTitle().equalsIgnoreCase("Rules")) {

            Player player = (Player) e.getWhoClicked();

            switch (e.getCurrentItem().getType()) {
                case BLUE_STAINED_GLASS -> player.performCommand("rules 1");
                case GREEN_STAINED_GLASS -> player.performCommand("rules 2");
                case YELLOW_STAINED_GLASS -> player.performCommand("rules 3");
                case ORANGE_STAINED_GLASS -> player.performCommand("rules 4");
                case RED_STAINED_GLASS -> player.performCommand("rules 5");
                default -> {}
            }
        }
    }

}
