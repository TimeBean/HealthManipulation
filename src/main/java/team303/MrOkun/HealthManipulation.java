package src.main.java.team303.MrOkun;

import src.main.java.team303.MrOkun.Commands.HealthCommand;
import org.bukkit.plugin.java.JavaPlugin;
import src.main.java.team303.MrOkun.Commands.HealthCommandComplition;

import java.util.logging.Logger;

public class HealthManipulation extends JavaPlugin {
    private Logger _logger;

    @Override
    public void onEnable() {
        _logger = getLogger();
        getCommand("healthmanipulation").setExecutor(new HealthCommand());
        _logger.fine("[Health Manipulation] HealthManipulation command are enabled");
        getCommand("healthmanipulation").setTabCompleter(new HealthCommandComplition());
        _logger.fine("[Health Manipulation] HealthManipulation TabCompleter are enabled");

        _logger.fine("[Health Manipulation] HealthManipulation plugin enabled");
    }

    @Override
    public void onDisable() {
        _logger.fine("[Health Manipulation] HealthManipulation plugin disabled");
    }
}
