package Team303.MrOkun.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class BaseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player player){
            var saturation = player.getInventory().getHolder().getSaturation();
            player.chat(saturation + "");

            return true;
        }

        return false;
    }
}
