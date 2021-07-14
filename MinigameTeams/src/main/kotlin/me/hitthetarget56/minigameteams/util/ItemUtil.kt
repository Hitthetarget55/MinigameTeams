package me.hitthetarget56.minigameteams.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 20:13
 */

fun named(material: Material, name: String): ItemStack {
    val item = ItemStack(material)
    val meta = item.itemMeta
    meta?.setDisplayName(name)
    item.itemMeta = meta
    return item
}