package me.hitthetarget56.minigameteams.commands.team

import de.themoep.inventorygui.*
import me.hitthetarget56.minigameteams.MinigameTeams
import me.hitthetarget56.minigameteams.util.named
import me.kodysimpson.simpapi.command.SubCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

/**
 * MinigameTeams
 * @author Hitthetarget56 (https://github.com/Hitthetarget55)
 * 14/07/2021 at 20:14
 */
class ViewTeams : SubCommand() {
    override fun getName() = "view"

    override fun getAliases() = mutableListOf("list")

    override fun getDescription() = "View all teams"

    override fun getSyntax() = "/team view"

    override fun perform(player: Player?, args: Array<out String>?) {
        val layout: Array<String> = arrayOf(
            "    s    ",
            " ggggggg ",
            "fp  c  nl"
            /*
            * s - filter
            * c - close
            * f - first page
            * p - previous page
            * n - next page
            * l - last page
            * */
        )
        // todo filter
        val gui = InventoryGui(MinigameTeams.instance, player, "Teams",layout)
        gui.setFiller(named(Material.GRAY_STAINED_GLASS_PANE, " "))
        gui.addElement(StaticGuiElement('c', ItemStack(Material.RED_STAINED_GLASS_PANE), { click: GuiElement.Click ->
            click.whoClicked.closeInventory()
            true
        }))
        val group = GuiElementGroup('g')
        MinigameTeams.teams.forEach { (id, team) ->
            group.addElement(
                StaticGuiElement('e', ItemStack(Material.ACACIA_SIGN), {
                it.whoClicked.sendMessage("you clickef on a team woo")
                // todo do something on click
                true
            },
                "${ChatColor.YELLOW}${team.name}",
                "${ChatColor.YELLOW}ID: ${ChatColor.GREEN}$id",
                "${ChatColor.YELLOW}Privacy: ${team.privacy}",
                "${ChatColor.YELLOW}Leader: ${if(Bukkit.getPlayer(team.leader) != null) Bukkit.getPlayer(team.leader)?.name else "${ChatColor.RED}N/A" }"
            )
            )
        }
        gui.addElement(group)
        val book = ItemStack(Material.BOOK)
        gui.addElement(GuiPageElement('f', book, GuiPageElement.PageAction.FIRST, "${ChatColor.YELLOW}Go to the first page (current: %page%)"))
        gui.addElement(GuiPageElement('p', ItemStack(Material.RED_STAINED_GLASS_PANE), GuiPageElement.PageAction.PREVIOUS, "${ChatColor.YELLOW}Go to the previous page (%prevpage%)"))
        gui.addElement(GuiPageElement('n', ItemStack(Material.YELLOW_STAINED_GLASS_PANE), GuiPageElement.PageAction.NEXT, "${ChatColor.YELLOW}Go to the next page (%nextpage%)"))
        gui.addElement(GuiPageElement('l', book, GuiPageElement.PageAction.LAST, "${ChatColor.YELLOW}Go to the last page (%pages%)"))
        gui.show(player)
    }

    override fun getSubcommandArguments(player: Player?, args: Array<out String>?): MutableList<String>? {
        return null
    }
}