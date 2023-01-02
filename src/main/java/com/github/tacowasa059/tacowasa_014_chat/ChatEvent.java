package com.github.tacowasa059.tacowasa_014_chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class ChatEvent implements Listener {
    private final TACOWASA_014_chat plugin;
    private final wasawasa wasawasa;
    private final HashMap<String,Double> cool_down;
    public ChatEvent(TACOWASA_014_chat plugin){
        this.plugin=plugin;
        this.wasawasa=new wasawasa(plugin);
        this.cool_down=new HashMap<>();
        for(String str:plugin.getConfig().getStringList("sayings")){
            cool_down.put(str,Double.valueOf((double)System.currentTimeMillis()/1000.0));
        }
    }
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        Player player=event.getPlayer();
        String id014="aeba3a0147334edab540cce1561fd2bb";//UUID
        //System.out.println(player.getPlayerListName());
        if(player.getUniqueId().equals(id014)){
            event.setMessage(wasawasa.addWASAto014(event.getMessage()));
        }
        else{
            for(String key:cool_down.keySet()){
                double diff=(double)System.currentTimeMillis()/1000.0 - cool_down.get(key).doubleValue();
                if(event.getMessage().contains(key)&&diff>=plugin.getConfig().getDouble("cool_down_period")){
                    Bukkit.broadcastMessage(wasawasa.addWASA("<TACOWASA_014> "+key));
                    this.cool_down.put(key,Double.valueOf((double)System.currentTimeMillis()/1000.0));
                }
            }
        }

    }

}