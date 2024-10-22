package net.spiritmc.rules.commands;

import net.spiritmc.rules.util.Inventories;
import net.spiritmc.rules.Rules;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class RulesCommand implements CommandExecutor {

    private final Rules plugin;

    public RulesCommand(Rules plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender commandSender, @NonNull Command command, @NonNull String s, @NonNull String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                player.sendMessage("Opening Rules...");
                player.openInventory(Inventories.getRulesInitialInventory(player, plugin.getConfig()));
            } else {
                int tier = Integer.parseInt(strings[0]);
                player.sendMessage("Opening Rules: Tier " + tier + "...");
                player.openInventory(Inventories.getTierInventory(player, plugin.getConfig(), tier));

            }
        } else {
            commandSender.sendMessage("Only players can send this command!");
        }

        return true;
    }
}
