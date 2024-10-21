package net.spiritmc.rules;

import net.spiritmc.rules.commands.RulesCommand;
import net.spiritmc.rules.listeners.MenuListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rules extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();

        getCommand("rules").setExecutor(new RulesCommand(this));

        getServer().getPluginManager().registerEvents(new MenuListeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}