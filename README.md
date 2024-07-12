# Hunt the Admins

Hunt The Admins is a plugin that has been specially created for the "Hunt the Admins" event
that will be taking place, or has taken place on the 13th July 2024. The plugin effectively
creates, updates and deletes a scoreboard, which is used to track the number of times that
players have killed the admins.

## Usage

### Installing the Plugin

Simply download one of the pre-compiled plugin JARs from the release page of this
and place it in your server's `plugins` folder. From there, you may start your server,
or restart it, if it is already running.

### Permissions

For a player to be considered an admin, they must have the `hunttheadmins.hunted`
permission. This permission must be manually assigned to each administrator that is
participating in the event. Permissions that are required to run the commands that
setup and remove the scoreboard are given in the commands section below.

### Commands

The plugin adds two commands to the server, which are as follows:

- `/setupscoreboard` - This command sets up the scoreboard for the event. The scoreboard
will be displayed as a sidebar on the right-hand side of the screen. You will need to run
this command before commencing the event.

- `/removescoreboard` - This command removes the scoreboard from the screen and is intended
for use after the event has concluded and the results have been recorded.

To run these commands, the player requires the `hunttheadmins.setupscoreboard` and
`hunttheadmins.removescoreboard` permissions respectively.