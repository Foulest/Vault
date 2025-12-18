/*
 * Vault - a permissions, chat, & economy API to give plugins easy hooks into.
 * Copyright (C) 2024 Foulest (https://github.com/Foulest)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package net.milkbowl.vault;

import lombok.Getter;
import net.milkbowl.vault.cmds.VaultCmd;
import net.milkbowl.vault.permission.Permission;
import net.milkbowl.vault.permission.SuperPerms;
import net.milkbowl.vault.util.MessageUtil;
import net.milkbowl.vault.util.UpdateUtil;
import net.milkbowl.vault.util.command.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

/**
 * Main class for Vault.
 *
 * @author Foulest
 */
@SuppressWarnings("unused")
public class Vault extends JavaPlugin {

    @Getter
    private static Vault instance;
    private CommandFramework framework;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Initializes the Command Framework.
        MessageUtil.log(Level.INFO, "Initializing Command Framework...");
        framework = new CommandFramework(this);

        // Loads SuperPerms as a backup in case no other permissions plugin is loaded.
        MessageUtil.log(Level.INFO, "Loading Backup Permission System...");
        @NotNull ServicesManager servicesManager = Bukkit.getServer().getServicesManager();
        servicesManager.register(Permission.class, new SuperPerms(this), this, ServicePriority.Lowest);

        // Loads the Vault commands.
        MessageUtil.log(Level.INFO, "Loading Commands...");
        loadCommands(new VaultCmd());

        // Schedules the update checker.
        scheduleUpdateCheck();

        MessageUtil.log(Level.INFO, "Loaded successfully.");
    }

    @Override
    public void onDisable() {
        // Removes all service registrations.
        getServer().getServicesManager().unregisterAll(this);

        // Cancels all scheduled tasks.
        try {
            Bukkit.getScheduler().cancelTasks(this);
        } catch (UnsupportedOperationException ex) {
            MessageUtil.log(Level.WARNING, "Bukkit scheduler unavailable; skipping task cancellation (is this a Folia-style server?)");
        }
    }

    /**
     * Schedules an update check for the plugin.
     *
     * @see UpdateUtil
     */
    private void scheduleUpdateCheck() {
        try {
            Bukkit.getScheduler().runTaskLater(this, UpdateUtil::checkForUpdates, 20L);
        } catch (UnsupportedOperationException ex) {
            MessageUtil.log(Level.WARNING, "Legacy scheduler unavailable; running update check asynchronously.");
            CompletableFuture.runAsync(UpdateUtil::checkForUpdates);
        }
    }

    /**
     * Loads the plugin's commands.
     *
     * @param commands Command to load.
     */
    private void loadCommands(Object @NotNull ... commands) {
        for (@NotNull Object command : commands) {
            framework.registerCommands(command);
        }
    }

    /**
     * Loads the plugin's listeners.
     *
     * @param listeners Listeners to load.
     */
    public void loadListeners(Listener @NotNull ... listeners) {
        for (@NotNull Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }
}
