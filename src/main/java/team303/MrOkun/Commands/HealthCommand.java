package src.main.java.team303.MrOkun.Commands;

import src.main.java.team303.MrOkun.HealthHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealthCommand implements CommandExecutor {
    private final HealthHandler _handler;

    public HealthCommand() {
        this._handler = new HealthHandler();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2 || args.length > 3) {
            sender.sendMessage("Usage: /" + label + " <set||increase||decrease> [player] <amount>");
            return true;
        }

        String action = args[0].toLowerCase();
        Player target;
        double amount;
        int amtIndex;

        if (args.length == 2) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can run this without specifying a target.");
                return true;
            }
            target = (Player) sender;
            amtIndex = 1;
        } else {
            target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                sender.sendMessage("Player '" + args[1] + "' not found or not online.");
                return true;
            }
            amtIndex = 2;
        }

        try {
            amount = Double.parseDouble(args[amtIndex]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Please enter a valid number for health.");
            return true;
        }

        switch (action) {
            case "set":
                _handler.setHealth(target, amount);
                break;
            case "increase":
                _handler.changeHealth(target, amount);
                break;
            case "decrease":
                _handler.changeHealth(target, -amount);
                break;
            default:
                sender.sendMessage("Unknown action '" + action + "'. Use set, increase, or decrease.");
                return true;
        }

        sender.sendMessage(capitalize(action) + " health of " + target.getName() + " by " + amount + ".");
        if (!sender.equals(target)) {
            target.sendMessage("Your health was " + action + "d by " + sender.getName() + " by " + amount + ".");
        }
        return true;
    }

    private String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}