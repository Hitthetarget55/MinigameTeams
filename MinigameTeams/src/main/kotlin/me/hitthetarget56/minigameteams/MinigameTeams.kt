package me.hitthetarget56.minigameteams

import com.smpearth.smpeboatracekotlin.commands.team.CreateCommand
import com.smpearth.smpeboatracekotlin.model.Team
import me.hitthetarget56.minigameteams.commands.team.JoinCommand
import me.hitthetarget56.minigameteams.commands.team.ViewTeams
import me.kodysimpson.simpapi.command.CommandList
import me.kodysimpson.simpapi.command.CommandManager
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class MinigameTeams : JavaPlugin() {
    companion object {
        lateinit var instance: MinigameTeams
        var teams = mutableMapOf<UUID, Team>()
    }

    override fun onEnable() {
        instance = this
        config.options().copyDefaults(true)
        saveDefaultConfig()
        CommandManager.createCoreCommand(this, "team", "Team Command", "/team", CommandList { player, subCommandList ->
            player.sendMessage(ChatColor.STRIKETHROUGH.toString() + "-------------------------")
            for (cmd in subCommandList) {
                player.sendMessage(ChatColor.GREEN.toString() + cmd.syntax + ChatColor.YELLOW + " - " + ChatColor.GREEN + cmd.description)
            }
            player.sendMessage(ChatColor.STRIKETHROUGH.toString() + "-------------------------")
        }, CreateCommand::class.java, ViewTeams::class.java, JoinCommand::class.java)
    }
}