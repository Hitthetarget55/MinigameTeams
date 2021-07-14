package me.hitthetarget56.minigameteams.util

import me.hitthetarget56.minigameteams.MinigameTeams
import java.util.*

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 20:13
 */

fun exists(name: String): Boolean {
    for(team in MinigameTeams.teams.values){
        if(team.name == name) return true
    }
    return false
}
fun existsID(id: String) = MinigameTeams.teams[UUID.fromString(id)] != null
