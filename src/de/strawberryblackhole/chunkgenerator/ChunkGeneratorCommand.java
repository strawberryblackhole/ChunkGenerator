package de.strawberryblackhole.chunkgenerator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static java.lang.Integer.parseInt;

public class ChunkGeneratorCommand implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int x1, y1, x2, y2;
        try {
            x1 = parseInt(args[0]);
            y1 = parseInt(args[1]);
            x2 = parseInt(args[2]);
            y2 = parseInt(args[3]);
        } catch (NumberFormatException e) {
            return false;
        } catch (ArrayIndexOutOfBoundsException  e) {
            return false;
        }

        if(x2 < x1 || y2 < y1)
            return false;


        Player p = (Player)sender;
        if(p != null){
            int iChunk = 0;
            for(int x = x1; x <= x2; x++){
                for(int y = y1; y <= y2; y++){
                    p.getWorld().getChunkAt(x,y).load(true);
                    p.getWorld().getChunkAt(x,y).unload(true);

                    p.sendMessage(String.format("Progress: %.3f %%", + ((100.0*iChunk++)/((x2-x1 + 1)*(y2-y1 + 1)))));
                }
            }
        }
        return true;
    }
}
