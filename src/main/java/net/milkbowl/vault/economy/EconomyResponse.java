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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Response object for Economy calls.
 *
 * @author Foulest
 */
@Data
@AllArgsConstructor
@SuppressWarnings("unused")
public class EconomyResponse {

    public final double amount;
    public final double balance;
    public final @NotNull ResponseType type;
    public final @Nullable String errorMessage;

    /**
     * Checks if the transaction was successful.
     *
     * @return Whether the transaction was successful.
     */
    public boolean transactionSuccess() {
        return type == EconomyResponse.ResponseType.SUCCESS;
    }

    /**
     * A list of possible response types.
     * These are returned by the Economy API.
     */
    @Getter
    @ToString
    @AllArgsConstructor
    public enum ResponseType {
        SUCCESS(1),
        FAILURE(2),
        NOT_IMPLEMENTED(3);

        private final int id;
    }
}
