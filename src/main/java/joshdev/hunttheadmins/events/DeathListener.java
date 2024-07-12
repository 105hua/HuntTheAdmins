/* Licensed under GNU General Public License v3.0 */
package joshdev.hunttheadmins.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class DeathListener implements Listener {

  final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
  final Scoreboard mainScoreboard = scoreboardManager.getMainScoreboard();

  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent event) {
    Player player = event.getEntity();
    LivingEntity killer = player.getKiller();
    if (killer instanceof Player killerPlayer) {
      if (player.hasPermission("hunttheadmins.hunted")) {
        Objective huntTheAdminsObjective = mainScoreboard.getObjective("hunt_the_admins");
        if (huntTheAdminsObjective == null) {
          return;
        }
        String killerName = killerPlayer.getName();
        Score killerScore = huntTheAdminsObjective.getScore(killerName);
        killerScore.setScore(killerScore.getScore() + 1);
        killerPlayer.sendMessage(
            Component.text("You have killed an Admin!", NamedTextColor.RED, TextDecoration.BOLD));
      }
    }
  }
}
