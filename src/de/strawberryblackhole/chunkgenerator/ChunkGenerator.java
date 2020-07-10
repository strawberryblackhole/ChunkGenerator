package de.strawberryblackhole.chunkgenerator;

import org.bukkit.plugin.java.JavaPlugin;

public class ChunkGenerator extends JavaPlugin {
    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        this.getCommand("generateChunks").setExecutor(new ChunkGeneratorCommand());
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
}
