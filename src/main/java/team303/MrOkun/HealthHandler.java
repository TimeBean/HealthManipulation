package src.main.java.team303.MrOkun;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class HealthHandler {
    public void setHealth(Player player, double newMaxHealth, boolean changeHealthProportionaly) {
        var maxHealthAttribute = player.getAttribute(Attribute.MAX_HEALTH);
        if (maxHealthAttribute == null) {
            return;
        }

        double previousMax = maxHealthAttribute.getBaseValue();
        double previousHealth = player.getHealth();

        maxHealthAttribute.setBaseValue(newMaxHealth);

        if (changeHealthProportionaly && previousMax > 0) {
            double healthPercent = previousHealth / previousMax;
            player.setHealth(Math.min(healthPercent * newMaxHealth, newMaxHealth));
        }
    }

    public void changeHealth(Player player, double amount) {
        double current = player.getHealth();
        double max = player.getAttribute(Attribute.MAX_HEALTH).getBaseValue();
        player.setHealth(Math.min(current + amount, max));

        var maxHealthAttribute = player.getAttribute(Attribute.MAX_HEALTH);

        double previousMax = maxHealthAttribute.getBaseValue();
        var newMaxHealth = previousMax + amount;

        maxHealthAttribute.setBaseValue(newMaxHealth);
    }
}