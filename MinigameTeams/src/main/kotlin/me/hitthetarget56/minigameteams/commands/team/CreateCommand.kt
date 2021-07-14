package com.smpearth.smpeboatracekotlin.commands.team


import com.smpearth.smpeboatracekotlin.model.Team
import me.hitthetarget56.minigameteams.MinigameTeams
import me.hitthetarget56.minigameteams.model.Privacy
import me.hitthetarget56.minigameteams.util.exists

import me.kodysimpson.simpapi.command.SubCommand
import org.bukkit.ChatColor
import org.bukkit.entity.Player

import java.util.*

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 18:51
 */
class CreateCommand : SubCommand() {
    override fun getName(): String {
        return "create"
    }

    override fun getAliases(): MutableList<String> {
        return mutableListOf("create", "new")
    }

    override fun getDescription(): String {
        return "Create a new team!"
    }

    override fun getSyntax(): String {
        return "/team create (name) (open/closed)"
    }

    override fun perform(player: Player?, args: Array<out String>?) {
        if(!player?.hasPermission("minigameteams.team.create")!!) player.sendMessage("${ChatColor.RED}Sorry! You do not have permission to do that.")
        if(args!!.isEmpty() || args.size != 3) player.sendMessage("${ChatColor.RED}$syntax")
        if(exists(args[1])) player.sendMessage("${ChatColor.RED}A team with this name already exists.")
        val privacy = if(args[2] == "open") Privacy.OPEN else Privacy.CLOSED
        val maxSize = 5 // todo get from config
        MinigameTeams.teams[UUID.randomUUID()] =
            Team(player.uniqueId, maxSize, args[1], mutableListOf(player.uniqueId), privacy)
        player.sendMessage("${ChatColor.GRAY}Successfully created team " +
                "${ChatColor.YELLOW}${args[1]}${ChatColor.GRAY} " +
                "with the privacy of ${privacy.display}${ChatColor.GRAY}." +
                "${ChatColor.YELLOW}${if(privacy == Privacy.OPEN) "Players can join using the command ${ChatColor.GREEN}/team join ${args[1]}${ChatColor.GRAY}."
                else "You can add players to this team using the command ${ChatColor.GREEN}/team add (player)${ChatColor.GRAY}." }")
    }

    override fun getSubcommandArguments(player: Player?, args: Array<out String>?): MutableList<String>? {
        return null
    }
}