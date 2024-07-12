/* Licensed under GNU General Public License v3.0 */
package joshdev.hunttheadmins.commands;

import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.jetbrains.annotations.NotNull;

public class RemoveScoreboard implements CommandExecutor {
  @Override
  public boolean onCommand(
      @NotNull CommandSender commandSender,
      @NotNull Command command,
      @NotNull String s,
      @NotNull String[] strings) {

    // Check if sender is a player
    if (!(commandSender instanceof Player player)) {
      commandSender.sendMessage(
          Component.text(
              "You must be a player to use this command.",
              NamedTextColor.RED,
              TextDecoration.BOLD));
      return true;
    }

    // Check if player has permission
    if (!player.hasPermission("hunttheadmins.removescoreboard")) {
      player.sendMessage(
          Component.text(
              "You do not have permission to use this command.",
              NamedTextColor.RED,
              TextDecoration.BOLD));
    }

    // Get main scoreboard
    ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    Scoreboard mainScoreboard = scoreboardManager.getMainScoreboard();

    // Check if the scoreboard exists.
    if (mainScoreboard.getObjective("hunt_the_admins") != null) {
      Objects.requireNonNull(mainScoreboard.getObjective("hunt_the_admins")).unregister();
      player.sendMessage(
          Component.text(
              "The scoreboard has been removed.", NamedTextColor.RED, TextDecoration.BOLD));
      return true;
    }

    player.sendMessage(
        Component.text(
            "The scoreboard has not been setup.", NamedTextColor.RED, TextDecoration.BOLD));
    return true;
  }
}
