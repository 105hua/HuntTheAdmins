/* Licensed under GNU General Public License v3.0 */
package joshdev.hunttheadmins.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

public class SetupScoreboard implements CommandExecutor {
  @Override
  public boolean onCommand(
      @NotNull CommandSender commandSender,
      @NotNull Command command,
      @NotNull String s,
      @NotNull String[] strings) {
    // Check if sender is player.
    if (!(commandSender instanceof Player player)) {
      commandSender.sendMessage("You must be a player to use this command.");
      return true;
    }

    // Check if player has permission
    if (!player.hasPermission("hunttheadmins.setupscoreboard")) {
      player.sendMessage(
          Component.text(
              "You do not have permission to use this command.",
              NamedTextColor.RED,
              TextDecoration.BOLD));
    }

    // Get main scoreboard.
    ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    Scoreboard mainScoreboard = scoreboardManager.getMainScoreboard();

    // Check if scoreboard already exists.
    if (mainScoreboard.getObjective("hunt_the_admins") != null) {
      player.sendMessage(
          Component.text(
              "The scoreboard is already setup!", NamedTextColor.RED, TextDecoration.BOLD));
      return true;
    }

    // If scoreboard is not setup, then perform setup.
    TextComponent scoreboardDisplayComponent =
        Component.text("- HUNT THE ADMINS -", NamedTextColor.RED, TextDecoration.BOLD);
    Objective huntTheAdminsObjective =
        mainScoreboard.registerNewObjective(
            "hunt_the_admins", Criteria.DUMMY, scoreboardDisplayComponent);
    huntTheAdminsObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

    // Send success message to player
    player.sendMessage(
        Component.text(
            "The scoreboard has been setup successfully!",
            NamedTextColor.GREEN,
            TextDecoration.BOLD));

    return true;
  }
}
