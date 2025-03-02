package me.honeyberries.normalshop;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShopCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("You must be a player to use this command!").color(NamedTextColor.RED));
            return true;
        }

        Inventory shopInventory = Bukkit.createInventory(player, 27, Component.text("Shop").color(NamedTextColor.GREEN));

        ItemStack windChargeButton = new ItemStack(Material.WIND_CHARGE, 16);
        ItemMeta windChargeButtonMeta = windChargeButton.getItemMeta();
        windChargeButtonMeta.displayName(Component.text("Wind Charge").color(NamedTextColor.GREEN));
        windChargeButtonMeta.lore(List.of(
                Component.text("Costs 1 Emerald").color(NamedTextColor.DARK_PURPLE)
        ));

        windChargeButton.setItemMeta(windChargeButtonMeta);


        ItemStack villagerSpawnEggButton = new ItemStack(Material.VILLAGER_SPAWN_EGG);
        ItemMeta villagerSpawnEggButtonMeta = villagerSpawnEggButton.getItemMeta();
        villagerSpawnEggButtonMeta.displayName(Component.text("Villager Spawn Egg").color(NamedTextColor.GREEN));

        villagerSpawnEggButtonMeta.lore(List.of(
                Component.text("Buy with either:").color(NamedTextColor.DARK_PURPLE),
                Component.text("4 Diamonds").color(NamedTextColor.BLUE),
                Component.text("12 Emeralds").color(NamedTextColor.GREEN),
                Component.text("16 Gold Ingots").color(NamedTextColor.GOLD),
                Component.text("32 Iron Ingots").color(NamedTextColor.GRAY)
        ));

        villagerSpawnEggButton.setItemMeta(villagerSpawnEggButtonMeta);

        shopInventory.setItem(12, windChargeButton);
        shopInventory.setItem(14, villagerSpawnEggButton);

        player.openInventory(shopInventory);

        player.setMetadata("IsOpenShop", new FixedMetadataValue(Normalshop.getInstance(), true));

        return true;

    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of();
    }
}
