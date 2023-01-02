package com.github.tacowasa059.tacowasa_014_chat;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.Bukkit;
import org.apache.commons.lang.StringUtils;
import java.util.Random;

public final class TACOWASA_014_chat extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //同調チャット
        getServer().getPluginManager().registerEvents(new ChatEvent(this),this);

        //wwwwの繰り返し
        BukkitScheduler scheduler=Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                String s="<TACOWASA_014> ";
                Random rand = new Random();
                int num = rand.nextInt(getConfig().getInt("max-w"))+1 ;
                String s2=StringUtils.repeat("w", num);
                Bukkit.broadcastMessage(s+s2);
            }
        }, 0L, 20L*getConfig().getLong("interval"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
