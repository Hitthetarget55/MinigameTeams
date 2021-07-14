package me.hitthetarget56.minigameteams.util

import org.bukkit.entity.Player

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 20:13
 */

fun Player.send(result: Boolean, msg: String): Boolean {
    sendMessage(msg)
    return result
}
