# Vault

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![CodeQL](https://github.com/Foulest/Vault/actions/workflows/github-code-scanning/codeql/badge.svg)](https://github.com/Foulest/Vault/actions/workflows/github-code-scanning/codeql)
[![Downloads](https://img.shields.io/github/downloads/Foulest/Vault/total.svg)](https://github.com/Foulest/Vault/releases)
[![JitPack Badge](https://jitpack.io/v/Foulest/Vault.svg)](https://jitpack.io/#Foulest/Vault)

**Vault** is a permissions, chat, & economy API to give plugins easy hooks into.

> **Note:** This is an updated fork of the original **[Vault](https://github.com/milkbowl/Vault)** project.
>
> All credit for the original project goes to the **[MilkBowl](https://github.com/MilkBowl)** team.

## Changes Made

- Includes all features of the original Vault project *(version 1.7.3)*
- Re-coded the entire project for improved efficiency and maintainability
- Merged the VaultAPI repository into the project itself
- Removed all built-in support for obsolete permissions and chat plugins
- Moved existing commands under the `/vault` command and revised them
- Added JetBrains annotations to improve code quality
- Implemented Lombok to reduce boilerplate code
- Migrated from Maven to Gradle

## Compiling

1. Clone the repository.
2. Open a command prompt/terminal to the repository directory.
3. Run `gradlew shadowJar` on Windows, or `./gradlew shadowJar` on macOS or Linux.
4. The built `Vault-X.X.X.jar` file will be in the `build/libs` folder.

## Download and Run

1. Download the latest version from the [releases page](https://github.com/Foulest/Vault/releases) or compile it
   yourself.
2. Make sure your server is running Spigot version 1.8.8 or higher.
3. Place the `Vault-X.X.X.jar` file in your server's `plugins` folder.
4. Start or restart your server.

## Getting Help

For support or queries, please open an issue in the [Issues section](https://github.com/Foulest/Vault/issues).
