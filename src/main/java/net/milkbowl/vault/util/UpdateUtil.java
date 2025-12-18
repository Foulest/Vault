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
package net.milkbowl.vault.util;

import lombok.Cleanup;
import lombok.Data;
import net.milkbowl.vault.Vault;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for checking for updates.
 *
 * @author Foulest
 */
@Data
public class UpdateUtil {

    private static final String REPO_API_URL = "https://api.github.com/repos/Foulest/Vault/releases/latest";
    private static final String DOWNLOAD_URL = "https://github.com/Foulest/Vault/releases/latest";

    /**
     * Checks for updates and logs the result.
     */
    public static void checkForUpdates() {
        Vault plugin = Vault.getInstance();

        Runnable task = () -> {
            @Nullable String latestVersion = getLatestReleaseVersion();
            @NotNull String currentVersion = plugin.getDescription().getVersion();

            if (latestVersion != null) {
                if (!latestVersion.equals(currentVersion)) {
                    MessageUtil.log(Level.WARNING, "A new version is available."
                            + " (Current: " + currentVersion + ", Latest: " + latestVersion + ")");

                    MessageUtil.log(Level.WARNING, "Download it at: " + DOWNLOAD_URL);
                }
            } else {
                MessageUtil.log(Level.WARNING, "Failed to fetch the latest release version.");
            }
        };

        try {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
        } catch (UnsupportedOperationException ex) {
            MessageUtil.log(Level.WARNING, "Legacy scheduler unavailable; running update check asynchronously.");
            CompletableFuture.runAsync(task);
        }
    }

    /**
     * Fetches the latest release version from the GitHub API.
     *
     * @return The latest release version or null if an error occurred.
     */
    @SuppressWarnings("OverlyBroadCatchBlock")
    private static @Nullable String getLatestReleaseVersion() {
        try {
            @NotNull URL url = new URL(REPO_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            @Cleanup @NotNull BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            @NotNull StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            connection.disconnect();
            return extractVersion(content.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Extracts the version from the JSON response.
     *
     * @param jsonResponse The JSON response.
     * @return The version or null if not found.
     */
    private static @Nullable String extractVersion(@NotNull CharSequence jsonResponse) {
        @NotNull String versionRegex = "\"tag_name\":\"(.*?)\"";
        @NotNull Pattern pattern = Pattern.compile(versionRegex);
        @NotNull Matcher matcher = pattern.matcher(jsonResponse);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
