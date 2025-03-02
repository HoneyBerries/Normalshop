package me.honeyberries.normalshop;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Map;

public class GUIListener implements Listener {

    /**
     * Handles the InventoryClickEvent for the shop GUI.
     * @param event The InventoryClickEvent.
     */
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (!player.hasMetadata("IsOpenShop")) {
            return; // Not our shop, ignore
        }

        Inventory shopInventory = event.getInventory(); // get the shop inventory

        if (event.getClickedInventory() == null) {
            return; // Clicked outside the inventory
        }

        // Prevent putting items into the shop
        if (event.getClickedInventory().equals(shopInventory)) {
            event.setCancelled(true); // Prevent stealing from shop

            int clickedSlot = event.getSlot();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null) {
                return; // Empty slot clicked, nothing to do
            }

            //Bought wind charge
            if (clickedSlot == 12 && clickedItem.getType().equals(Material.WIND_CHARGE)) {
                // Handle Wind Charge purchase
                if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 1)) {
                    purchaseItem(player, new ItemStack(Material.EMERALD, 1), new ItemStack(Material.WIND_CHARGE, 16));

                    player.sendMessage(Component.text("Purchased 16 Wind Charges!").color(NamedTextColor.GREEN));
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                } else {
                    player.sendMessage(Component.text("You need at least 1 Emerald to buy Wind Charges!").color(NamedTextColor.RED));
                }
            }

            //Bought villager spawn egg
            else if (clickedSlot == 14 && clickedItem.getType().equals(Material.VILLAGER_SPAWN_EGG)) {
                // Handle villager spawn egg button
                if (player.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 4)) {
                    purchaseItem(player, new ItemStack(Material.DIAMOND, 4), new ItemStack(Material.VILLAGER_SPAWN_EGG));
                } else if (player.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 12)) {
                    purchaseItem(player, new ItemStack(Material.EMERALD, 12), new ItemStack(Material.VILLAGER_SPAWN_EGG));
                } else if (player.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 16)) {
                    purchaseItem(player, new ItemStack(Material.GOLD_INGOT, 16), new ItemStack(Material.VILLAGER_SPAWN_EGG));
                } else if (player.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 32)) {
                    purchaseItem(player, new ItemStack(Material.IRON_INGOT, 32), new ItemStack(Material.VILLAGER_SPAWN_EGG));
                } else {
                    player.sendMessage(Component.text("You do not have enough resources to purchase this!").color(NamedTextColor.RED));
                }
            }

        // If they mess with their own inventory
        } else event.setCancelled(event.getClickedInventory().getType() != InventoryType.PLAYER);
    }

    /**
     * Helper method to handle item purchases.
     * @param player The player making the purchase.
     * @param cost The cost of the item.
     * @param item The item being purchased.
     */
    private void purchaseItem(Player player, ItemStack cost, ItemStack item) {
        player.getInventory().removeItem(cost);
        Map<Integer, ItemStack> remaining = player.getInventory().addItem(item);
        remaining.values().forEach(remainingItem -> player.getWorld().dropItemNaturally(player.getLocation(), remainingItem));
    }

    /**
     * Handles the InventoryCloseEvent for the shop GUI.
     * @param event The InventoryCloseEvent.
     */
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        if (player.hasMetadata("IsOpenShop")) {
            player.removeMetadata("IsOpenShop", Normalshop.getInstance());
        }
    }
}
