package quickshar.mgworlds.ru.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class framesEvents implements Listener {

    @EventHandler
    public void rightClick(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        //Check itemFrame
        if(!(entity instanceof ItemFrame)){ return;}
        ItemFrame frame = (ItemFrame) entity;

        //Checks if the player has shears in his hand
        if(player.getInventory().getItemInMainHand().getType() != Material.SHEARS){
            if(!frame.isGlowing()){ return; }
            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){ return; }

            frame.setVisible(false);
            frame.setGlowing(false);

            return;
        }
        //Cancels the movement of an item into a ItemFrame
        event.setCancelled(true);

        //If the ItemFrame contains an object, it becomes invisible.
        if(frame.getItem().getType() != Material.AIR){
            frame.setVisible(false);
            return;
        }

        frame.setGlowing(true);
    }

    @EventHandler
    public void leftClickOnItemFrame(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();

        if(!(entity instanceof ItemFrame)){ return; }
        ItemFrame frame = (ItemFrame) entity;
//        if(!(damager instanceof Player)){ return; }

        if(frame.isVisible()){ return; }

        frame.setVisible(true);
        frame.setGlowing(true);

    }

}
