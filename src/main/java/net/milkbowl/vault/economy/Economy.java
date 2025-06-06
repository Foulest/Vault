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
package net.milkbowl.vault.economy;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Abstract class for Vault's Economy API.
 *
 * @author Foulest
 */
@SuppressWarnings("unused")
public interface Economy {

    /**
     * Checks if the economy system is enabled.
     *
     * @return Whether the economy system is enabled.
     */
    boolean isEnabled();

    /**
     * Gets the name of the economy system.
     *
     * @return Name of the economy system.
     */
    String getName();

    /**
     * Checks if the economy system supports banks.
     *
     * @return Whether the economy system supports banks.
     */
    boolean hasBankSupport();

    /**
     * Gets the fractional digits for the economy system.
     *
     * @return Fractional digits for the economy system.
     */
    int fractionalDigits();

    /**
     * Gets the format for the economy system.
     *
     * @param amount Amount to format.
     * @return Format for the economy system.
     */
    String format(double amount);

    /**
     * Gets the currency name for the economy system.
     *
     * @return Currency name for the economy system.
     */
    String currencyNamePlural();

    /**
     * Gets the currency name for the economy system.
     *
     * @return Currency name for the economy system.
     */
    String currencyNameSingular();

    /**
     * Checks if the given player has an account.
     *
     * @param uuid UUID of the player to check.
     * @return Whether the player has an account.
     */
    boolean hasAccount(UUID uuid);

    @Deprecated
    default boolean hasAccount(@NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId);
    }

    @Deprecated
    default boolean hasAccount(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId);
    }

    @Deprecated
    default boolean hasAccount(@NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return hasAccount(player);
        } else {
            return hasAccount(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Checks if the given player has an account on the given world.
     *
     * @param uuid      UUID of the player to check.
     * @param world Name of the world to check.
     * @return Whether the player has an account on the given world.
     */
    boolean hasAccount(UUID uuid, String world);

    @Deprecated
    default boolean hasAccount(@NotNull Player player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId, world);
    }

    @Deprecated
    default boolean hasAccount(@NotNull OfflinePlayer player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return hasAccount(uniqueId, world);
    }

    @Deprecated
    default boolean hasAccount(@NotNull String playerName, String world) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return hasAccount(player, world);
        } else {
            return hasAccount(Bukkit.getOfflinePlayer(playerName), world);
        }
    }

    /**
     * Gets the balance of the given player.
     *
     * @param uuid UUID of the player to check.
     * @return Balance of the given player.
     */
    double getBalance(UUID uuid);

    @Deprecated
    default double getBalance(@NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId);
    }

    @Deprecated
    default double getBalance(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId);
    }

    @Deprecated
    default double getBalance(@NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getBalance(player);
        } else {
            return getBalance(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Gets the balance of the given player on the given world.
     *
     * @param uuid      UUID of the player to check.
     * @param world Name of the world to check.
     * @return Balance of the given player on the given world.
     */
    double getBalance(UUID uuid, String world);

    @Deprecated
    default double getBalance(@NotNull Player player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId, world);
    }

    @Deprecated
    default double getBalance(@NotNull OfflinePlayer player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return getBalance(uniqueId, world);
    }

    @Deprecated
    default double getBalance(@NotNull String playerName, String world) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return getBalance(player, world);
        } else {
            return getBalance(Bukkit.getOfflinePlayer(playerName), world);
        }
    }

    /**
     * Checks if the given player has at least the given amount.
     *
     * @param uuid UUID of the player to check.
     * @param amount Amount to check.
     * @return Whether the player has at least the given amount.
     */
    boolean has(UUID uuid, double amount);

    @Deprecated
    default boolean has(@NotNull Player player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, amount);
    }

    @Deprecated
    default boolean has(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, amount);
    }

    @Deprecated
    default boolean has(@NotNull String playerName, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return has(player, amount);
        } else {
            return has(Bukkit.getOfflinePlayer(playerName), amount);
        }
    }

    /**
     * Checks if the given player has at least the given amount on the given world.
     *
     * @param uuid      UUID of the player to check.
     * @param world Name of the world to check.
     * @param amount    Amount to check.
     * @return Whether the player has at least the given amount on the given world.
     */
    boolean has(UUID uuid, String world, double amount);

    @Deprecated
    default boolean has(@NotNull Player player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, world, amount);
    }

    @Deprecated
    default boolean has(@NotNull OfflinePlayer player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return has(uniqueId, world, amount);
    }

    @Deprecated
    default boolean has(@NotNull String playerName, String world, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return has(player, world, amount);
        } else {
            return has(Bukkit.getOfflinePlayer(playerName), world, amount);
        }
    }

    /**
     * Withdraws the given amount from the given player.
     *
     * @param uuid UUID of the player to withdraw from.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse withdrawPlayer(UUID uuid, double amount);

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull Player player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, amount);
    }

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, amount);
    }

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull String playerName, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return withdrawPlayer(player, amount);
        } else {
            return withdrawPlayer(Bukkit.getOfflinePlayer(playerName), amount);
        }
    }

    /**
     * Withdraws the given amount from the given player on the given world.
     *
     * @param uuid UUID of the player to withdraw from.
     * @param world Name of the world to withdraw from.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse withdrawPlayer(UUID uuid, String world, double amount);

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull Player player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, world, amount);
    }

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull OfflinePlayer player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return withdrawPlayer(uniqueId, world, amount);
    }

    @Deprecated
    default EconomyResponse withdrawPlayer(@NotNull String playerName, String world, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return withdrawPlayer(player, world, amount);
        } else {
            return withdrawPlayer(Bukkit.getOfflinePlayer(playerName), world, amount);
        }
    }

    /**
     * Deposits the given amount to the given player.
     *
     * @param uuid UUID of the player to deposit to.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse depositPlayer(UUID uuid, double amount);

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull Player player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, amount);
    }

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull OfflinePlayer player, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, amount);
    }

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull String playerName, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return depositPlayer(player, amount);
        } else {
            return depositPlayer(Bukkit.getOfflinePlayer(playerName), amount);
        }
    }

    /**
     * Deposits the given amount to the given player on the given world.
     *
     * @param uuid UUID of the player to deposit to.
     * @param world Name of the world to deposit to.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse depositPlayer(UUID uuid, String world, double amount);

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull Player player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, world, amount);
    }

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull OfflinePlayer player, String world, double amount) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return depositPlayer(uniqueId, world, amount);
    }

    @Deprecated
    default EconomyResponse depositPlayer(@NotNull String playerName, String world, double amount) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return depositPlayer(player, world, amount);
        } else {
            return depositPlayer(Bukkit.getOfflinePlayer(playerName), world, amount);
        }
    }

    /**
     * Creates a bank with the given name and owner.
     *
     * @param name Name of the bank.
     * @param uuid UUID of the owner of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse createBank(String name, UUID uuid);

    @Deprecated
    default EconomyResponse createBank(String name, @NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createBank(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse createBank(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createBank(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse createBank(String name, @NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return createBank(name, player);
        } else {
            return createBank(name, Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Deletes the bank with the given name.
     *
     * @param name Name of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse deleteBank(String name);

    /**
     * Gets the balance of the given bank.
     *
     * @param name Name of the bank.
     * @return Response object for the transaction.
     */
    EconomyResponse bankBalance(String name);

    /**
     * Checks if the given bank has at least the given amount.
     *
     * @param name Name of the bank.
     * @param amount Amount to check.
     * @return Response object for the transaction.
     */
    EconomyResponse bankHas(String name, double amount);

    /**
     * Withdraws the given amount from the given bank.
     *
     * @param name Name of the bank.
     * @param amount Amount to withdraw.
     * @return Response object for the transaction.
     */
    EconomyResponse bankWithdraw(String name, double amount);

    /**
     * Deposits the given amount to the given bank.
     *
     * @param name Name of the bank.
     * @param amount Amount to deposit.
     * @return Response object for the transaction.
     */
    EconomyResponse bankDeposit(String name, double amount);

    /**
     * Checks if the given player is the owner of the given bank.
     *
     * @param name Name of the bank.
     * @param uuid UUID of the player to check.
     * @return Response object for the transaction.
     */
    EconomyResponse isBankOwner(String name, UUID uuid);

    @Deprecated
    default EconomyResponse isBankOwner(String name, @NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankOwner(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse isBankOwner(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankOwner(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse isBankOwner(String name, @NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return isBankOwner(name, player);
        } else {
            return isBankOwner(name, Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Checks if the given player is a member of the given bank.
     *
     * @param name Name of the bank.
     * @param uuid UUID of the player to check.
     * @return Response object for the transaction.
     */
    EconomyResponse isBankMember(String name, UUID uuid);

    @Deprecated
    default EconomyResponse isBankMember(String name, @NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankMember(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse isBankMember(String name, @NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return isBankMember(name, uniqueId);
    }

    @Deprecated
    default EconomyResponse isBankMember(String name, @NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return isBankMember(name, player);
        } else {
            return isBankMember(name, Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Gets a list of all banks.
     *
     * @return List of all banks.
     */
    List<String> getBanks();

    /**
     * Creates an account for the given player.
     *
     * @param uuid UUID of the player to create an account for.
     * @return Whether the account was created.
     */
    boolean createPlayerAccount(UUID uuid);

    @Deprecated
    default boolean createPlayerAccount(@NotNull Player player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId);
    }

    @Deprecated
    default boolean createPlayerAccount(@NotNull OfflinePlayer player) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId);
    }

    @Deprecated
    default boolean createPlayerAccount(@NotNull String playerName) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return createPlayerAccount(player);
        } else {
            return createPlayerAccount(Bukkit.getOfflinePlayer(playerName));
        }
    }

    /**
     * Creates an account for the given player on the given world.
     *
     * @param uuid      UUID of the player to create an account for.
     * @param world Name of the world to create an account for.
     * @return Whether the account was created.
     */
    boolean createPlayerAccount(UUID uuid, String world);

    @Deprecated
    default boolean createPlayerAccount(@NotNull Player player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId, world);
    }

    @Deprecated
    default boolean createPlayerAccount(@NotNull OfflinePlayer player, String world) {
        @NotNull UUID uniqueId = player.getUniqueId();
        return createPlayerAccount(uniqueId, world);
    }

    @Deprecated
    default boolean createPlayerAccount(@NotNull String playerName, String world) {
        @Nullable Player player = Bukkit.getPlayer(playerName);

        if (player != null) {
            return createPlayerAccount(player, world);
        } else {
            return createPlayerAccount(Bukkit.getOfflinePlayer(playerName), world);
        }
    }
}
