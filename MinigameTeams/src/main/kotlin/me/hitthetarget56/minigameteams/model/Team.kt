package me.hitthetarget56.minigameteams.model


import me.hitthetarget56.minigameteams.model.Privacy
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

class Team(
    val leader: UUID,
    val maxSize: Int,
    val name: String,
    val players: MutableList<UUID>,
    val privacy: Privacy
)  {
    fun broadcast(message: String?) {
        for (uuid in players) {
            Bukkit.getPlayer(uuid)!!.sendMessage(message!!)
        }
    }
    fun addPlayer(player: Player) {
        players.add(player.uniqueId)
    }

    fun removePlayer(player: Player) {
        players.remove(player.uniqueId)
    }


}
