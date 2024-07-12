/* Licensed under GNU General Public License v3.0 */
package joshdev.hunttheadmins;

import joshdev.hunttheadmins.commands.RemoveScoreboard;
import joshdev.hunttheadmins.commands.SetupScoreboard;
import joshdev.hunttheadmins.events.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HuntTheAdmins extends JavaPlugin {

  @Override
  public void onEnable() {
    // Register commands.
    try {
      this.getCommand("setupscoreboard").setExecutor(new SetupScoreboard());
      this.getCommand("removescoreboard").setExecutor(new RemoveScoreboard());
    } catch (NullPointerException e) {
      e.printStackTrace(); // More rob
    }
    // Register death event.
    getServer().getPluginManager().registerEvents(new DeathListener(), this);
  }

  @Override
  public void onDisable() {
    // Nothing, for now...
  }
}
