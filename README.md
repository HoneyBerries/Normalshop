# Normalshop

[![version](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/yourusername/Normalshop)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

**Normalshop** is a Minecraft plugin designed to create a simple, in-game shop where players can purchase items using various resources. It provides a user-friendly GUI to allow for easy access and a great experience.

## Features

*   **GUI-based Shop:** Players can access the shop via the `/shop` command, opening a clean and intuitive GUI.
*   **Item Purchase:** Players can buy items using different currencies (Emeralds, Diamonds, Gold Ingots, Iron Ingots).
*   **Multiple Currencies:** Supports purchasing items with different currencies and exchange rates.
*   **Wind Charges:** Players can buy packs of 16 Wind Charges for 1 Emerald each.
*   **Villager Spawn Egg:** Players can purchase a villager spawn egg using 4 Diamonds, 12 Emeralds, 16 Gold Ingots, or 32 Iron Ingots.
*   **Permission-Based Access:** Only players with the `normalshop.shop` permission can access the shop.
*   **Clear Feedback:** Players receive clear messages about their purchases and when they don't have enough resources.
*   **Error Prevention:** Prevents players from stealing items from the shop.
* **Item overflow** if there are no space in the player inventory, the remaining item will be dropped at the players feet.

## Commands

*   `/shop` (aliases: `/purchase`, `/buy`, `/store`): Opens the shop GUI.

## Permissions

*   `normalshop.shop`: Allows players to access and use the shop. (Granted to everyone by default)

## Installation

1.  **Download:** Download the `Normalshop.jar` file from the [Releases](https://github.com/yourusername/Normalshop/releases) page (once you create one).
2.  **Plugins Folder:** Place the `Normalshop.jar` file into your Minecraft server's `plugins` directory.
3.  **Restart:** Restart your Minecraft server.
4. **Permissions**: If you want to change the default permissions, use a plugin like LuckPerms to do so.

## Configuration

There is no configuration file yet for the `Normalshop` plugin. All the current settings are hardcoded. Future updates may introduce a configuration file for easier customization.

## Items and Prices

| Item                    | Price                                  |
| :---------------------- | :------------------------------------- |
| Wind Charge (x16)       | 1 Emerald                             |
| Villager Spawn Egg (x1) | 4 Diamonds / 12 Emeralds / 16 Gold Ingots / 32 Iron Ingots |

## Development

This plugin was developed by **HoneyBerries** and **Pepmon270**.

### Dependencies

*   [Bukkit/Spigot/Paper API](https://www.spigotmc.org/)

### Building from Source

1.  **Clone Repository:** Clone this repository to your local machine:
    ```bash
    git clone https://github.com/yourusername/Normalshop.git
    ```
    (Replace `yourusername` with your actual GitHub username).
2.  **Import Project:** Open IntelliJ IDEA and import the project.
3.  **Build:** You can build the project using Maven or Gradle. If you use maven, run the following command:
    ```bash
    mvn clean install
    ```
4. The `.jar` file will be inside the `target` folder.

## Support and Issues

If you encounter any issues or have suggestions for improvement, please open an issue on the [Issues](https://github.com/yourusername/Normalshop/issues) page.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
