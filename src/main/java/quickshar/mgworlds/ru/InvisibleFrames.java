package quickshar.mgworlds.ru;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import quickshar.mgworlds.ru.Events.framesEvents;

public final class InvisibleFrames extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new framesEvents(), this);

        getLogger().info("InvisibleFrames enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("InvisibleFrames disabled");
    }
}
