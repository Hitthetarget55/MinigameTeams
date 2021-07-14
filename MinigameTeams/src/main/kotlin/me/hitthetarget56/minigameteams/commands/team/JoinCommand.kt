package me.hitthetarget56.minigameteams.commands.team

import me.kodysimpson.simpapi.command.SubCommand
import org.bukkit.entity.Player

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 20:14
 */
class JoinCommand : SubCommand() {
    override fun getName() = "join"

    override fun getAliases() = mutableListOf("plscanijointhisteamthankyou", "pain")

    override fun getDescription() = "Join an open team"

    override fun getSyntax() = "/team join (name)"

    override fun perform(player: Player?, args: Array<out String>?) {
        // todo
    }

    override fun getSubcommandArguments(player: Player?, args: Array<out String>?): MutableList<String>? {
        return null
    }
}