package net.milkbowl.vault.chat;

import lombok.AllArgsConstructor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

@AllArgsConstructor
@SuppressWarnings({"DeprecatedIsStillUsed", "unused"})
public abstract class Chat {

    private final Permission permission;

    public abstract String getName();

    public abstract boolean isEnabled();

    @Deprecated
    public abstract String getPlayerPrefix(String world, String player);

    public String getPlayerPrefix(String world, OfflinePlayer player) {
        return this.getPlayerPrefix(world, player.getName());
    }

    @Deprecated
    public String getPlayerPrefix(World world, String player) {
        return this.getPlayerPrefix(world.getName(), player);
    }

    public String getPlayerPrefix(Player player) {
        return this.getPlayerPrefix(player.getWorld().getName(), player);
    }

    @Deprecated
    public abstract void setPlayerPrefix(String world, String player, String prefix);

    public void setPlayerPrefix(String world, OfflinePlayer player, String prefix) {
        this.setPlayerPrefix(world, player.getName(), prefix);
    }

    @Deprecated
    public void setPlayerPrefix(World world, String player, String prefix) {
        this.setPlayerPrefix(world.getName(), player, prefix);
    }

    public void setPlayerPrefix(Player player, String prefix) {
        this.setPlayerPrefix(player.getWorld().getName(), player, prefix);
    }

    @Deprecated
    public abstract String getPlayerSuffix(String world, String player);

    public String getPlayerSuffix(String world, OfflinePlayer player) {
        return this.getPlayerSuffix(world, player.getName());
    }

    @Deprecated
    public String getPlayerSuffix(World world, String player) {
        return this.getPlayerSuffix(world.getName(), player);
    }

    public String getPlayerSuffix(Player player) {
        return this.getPlayerSuffix(player.getWorld().getName(), player);
    }

    @Deprecated
    public abstract void setPlayerSuffix(String world, String player, String suffix);

    public void setPlayerSuffix(String world, OfflinePlayer player, String suffix) {
        this.setPlayerSuffix(world, player.getName(), suffix);
    }

    @Deprecated
    public void setPlayerSuffix(World world, String player, String suffix) {
        this.setPlayerSuffix(world.getName(), player, suffix);
    }

    public void setPlayerSuffix(Player player, String suffix) {
        this.setPlayerSuffix(player.getWorld().getName(), player, suffix);
    }

    public abstract String getGroupPrefix(String world, String group);

    public String getGroupPrefix(World world, String group) {
        return this.getGroupPrefix(world.getName(), group);
    }

    public abstract void setGroupPrefix(String world, String group, String prefix);

    public void setGroupPrefix(World world, String group, String prefix) {
        this.setGroupPrefix(world.getName(), group, prefix);
    }

    public abstract String getGroupSuffix(String world, String group);

    public String getGroupSuffix(World world, String group) {
        return this.getGroupSuffix(world.getName(), group);
    }

    public abstract void setGroupSuffix(String world, String group, String suffix);

    public void setGroupSuffix(World world, String group, String suffix) {
        this.setGroupSuffix(world.getName(), group, suffix);
    }

    public int getPlayerInfoInteger(String world, OfflinePlayer player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(world, player.getName(), node, defaultValue);
    }

    @Deprecated
    public abstract int getPlayerInfoInteger(String world, String player, String node, int defaultValue);

    @Deprecated
    public int getPlayerInfoInteger(World world, String player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(world.getName(), player, node, defaultValue);
    }

    public int getPlayerInfoInteger(Player player, String node, int defaultValue) {
        return this.getPlayerInfoInteger(player.getWorld().getName(), player, node, defaultValue);
    }

    public void setPlayerInfoInteger(String world, OfflinePlayer player, String node, int value) {
        this.setPlayerInfoInteger(world, player.getName(), node, value);
    }

    @Deprecated
    public abstract void setPlayerInfoInteger(String world, String player, String node, int value);

    @Deprecated
    public void setPlayerInfoInteger(World world, String player, String node, int value) {
        this.setPlayerInfoInteger(world.getName(), player, node, value);
    }

    public void setPlayerInfoInteger(Player player, String node, int value) {
        this.setPlayerInfoInteger(player.getWorld().getName(), player, node, value);
    }

    public abstract int getGroupInfoInteger(String world, String group, String node, int defaultValue);

    public int getGroupInfoInteger(World world, String group, String node, int defaultValue) {
        return this.getGroupInfoInteger(world.getName(), group, node, defaultValue);
    }

    public abstract void setGroupInfoInteger(String world, String group, String node, int value);

    public void setGroupInfoInteger(World world, String group, String node, int value) {
        this.setGroupInfoInteger(world.getName(), group, node, value);
    }

    public double getPlayerInfoDouble(String world, OfflinePlayer player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(world, player.getName(), node, defaultValue);
    }

    @Deprecated
    public abstract double getPlayerInfoDouble(String world, String player, String node, double defaultValue);

    @Deprecated
    public double getPlayerInfoDouble(World world, String player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(world.getName(), player, node, defaultValue);
    }

    public double getPlayerInfoDouble(Player player, String node, double defaultValue) {
        return this.getPlayerInfoDouble(player.getWorld().getName(), player, node, defaultValue);
    }

    public void setPlayerInfoDouble(String world, OfflinePlayer player, String node, double value) {
        this.setPlayerInfoDouble(world, player.getName(), node, value);
    }

    @Deprecated
    public abstract void setPlayerInfoDouble(String world, String player, String node, double value);

    @Deprecated
    public void setPlayerInfoDouble(World world, String player, String node, double value) {
        this.setPlayerInfoDouble(world.getName(), player, node, value);
    }

    public void setPlayerInfoDouble(Player player, String node, double value) {
        this.setPlayerInfoDouble(player.getWorld().getName(), player, node, value);
    }

    public abstract double getGroupInfoDouble(String world, String group, String node, double defaultValue);

    public double getGroupInfoDouble(World world, String group, String node, double defaultValue) {
        return this.getGroupInfoDouble(world.getName(), group, node, defaultValue);
    }

    public abstract void setGroupInfoDouble(String world, String group, String node, double value);

    public void setGroupInfoDouble(World world, String group, String node, double value) {
        this.setGroupInfoDouble(world.getName(), group, node, value);
    }

    public boolean getPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(world, player.getName(), node, defaultValue);
    }

    @Deprecated
    public abstract boolean getPlayerInfoBoolean(String world, String player, String node, boolean defaultValue);

    @Deprecated
    public boolean getPlayerInfoBoolean(World world, String player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(world.getName(), player, node, defaultValue);
    }

    public boolean getPlayerInfoBoolean(Player player, String node, boolean defaultValue) {
        return this.getPlayerInfoBoolean(player.getWorld().getName(), player, node, defaultValue);
    }

    public void setPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean value) {
        this.setPlayerInfoBoolean(world, player.getName(), node, value);
    }

    @Deprecated
    public abstract void setPlayerInfoBoolean(String world, String player, String node, boolean value);

    @Deprecated
    public void setPlayerInfoBoolean(World world, String player, String node, boolean value) {
        this.setPlayerInfoBoolean(world.getName(), player, node, value);
    }

    public void setPlayerInfoBoolean(Player player, String node, boolean value) {
        this.setPlayerInfoBoolean(player.getWorld().getName(), player, node, value);
    }

    public abstract boolean getGroupInfoBoolean(String world, String group, String node, boolean defaultValue);

    public boolean getGroupInfoBoolean(World world, String group, String node, boolean defaultValue) {
        return this.getGroupInfoBoolean(world.getName(), group, node, defaultValue);
    }

    public abstract void setGroupInfoBoolean(String world, String group, String node, boolean value);

    public void setGroupInfoBoolean(World world, String group, String node, boolean value) {
        this.setGroupInfoBoolean(world.getName(), group, node, value);
    }

    public String getPlayerInfoString(String world, OfflinePlayer player, String node, String defaultValue) {
        return this.getPlayerInfoString(world, player.getName(), node, defaultValue);
    }

    @Deprecated
    public abstract String getPlayerInfoString(String world, String player, String node, String defaultValue);

    @Deprecated
    public String getPlayerInfoString(World world, String player, String node, String defaultValue) {
        return this.getPlayerInfoString(world.getName(), player, node, defaultValue);
    }

    public String getPlayerInfoString(Player player, String node, String defaultValue) {
        return this.getPlayerInfoString(player.getWorld().getName(), player, node, defaultValue);
    }

    public void setPlayerInfoString(String world, OfflinePlayer player, String node, String value) {
        this.setPlayerInfoString(world, player.getName(), node, value);
    }

    @Deprecated
    public abstract void setPlayerInfoString(String world, String player, String node, String value);

    @Deprecated
    public void setPlayerInfoString(World world, String player, String node, String value) {
        this.setPlayerInfoString(world.getName(), player, node, value);
    }

    public void setPlayerInfoString(Player player, String node, String value) {
        this.setPlayerInfoString(player.getWorld().getName(), player, node, value);
    }

    public abstract String getGroupInfoString(String world, String group, String node, String defaultValue);

    public String getGroupInfoString(World world, String group, String node, String defaultValue) {
        return this.getGroupInfoString(world.getName(), group, node, defaultValue);
    }

    public abstract void setGroupInfoString(String world, String group, String node, String value);

    public void setGroupInfoString(World world, String group, String node, String value) {
        this.setGroupInfoString(world.getName(), group, node, value);
    }

    public boolean playerInGroup(String world, OfflinePlayer player, String group) {
        return this.permission.playerInGroup(world, player, group);
    }

    @Deprecated
    public boolean playerInGroup(String world, String player, String group) {
        return this.permission.playerInGroup(world, player, group);
    }

    @Deprecated
    public boolean playerInGroup(World world, String player, String group) {
        return this.playerInGroup(world.getName(), player, group);
    }

    public boolean playerInGroup(Player player, String group) {
        return this.playerInGroup(player.getWorld().getName(), player, group);
    }

    public String[] getPlayerGroups(String world, OfflinePlayer player) {
        return this.permission.getPlayerGroups(world, player);
    }

    @Deprecated
    public String[] getPlayerGroups(String world, String player) {
        return this.permission.getPlayerGroups(world, player);
    }

    @Deprecated
    public String[] getPlayerGroups(World world, String player) {
        return this.getPlayerGroups(world.getName(), player);
    }

    public String[] getPlayerGroups(Player player) {
        return this.getPlayerGroups(player.getWorld().getName(), player);
    }

    public String getPrimaryGroup(String world, OfflinePlayer player) {
        return this.permission.getPrimaryGroup(world, player);
    }

    @Deprecated
    public String getPrimaryGroup(String world, String player) {
        return this.permission.getPrimaryGroup(world, player);
    }

    @Deprecated
    public String getPrimaryGroup(World world, String player) {
        return this.getPrimaryGroup(world.getName(), player);
    }

    public String getPrimaryGroup(Player player) {
        return this.getPrimaryGroup(player.getWorld().getName(), player);
    }

    public String[] getGroups() {
        return this.permission.getGroups();
    }
}
