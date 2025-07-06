package Team303.MrOkun;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class HealthManipulation extends JavaPlugin {
    private Logger _logger;

    @Override
    public void onEnable() {
        _logger = getLogger();
        _logger.fine("[Health Manipulation] HealthManipulation plugin enabled");
    }

    @Override
    public void onDisable() {
        _logger.fine("[Health Manipulation] HealthManipulation plugin disabled");
    }
}
