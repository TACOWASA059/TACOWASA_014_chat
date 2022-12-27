package com.github.tacowasa059.tacowasa_014w;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.Bukkit;
import org.apache.commons.lang.StringUtils;
import java.util.Random;

public final class TACOWASA_014w extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register our command "kit" (set an instance of your command class as executor)


        BukkitScheduler scheduler=Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                String s="<TACOWASA_014>";
                Random rand = new Random();
                int num = rand.nextInt(15) ;
                String s2=StringUtils.repeat("w", num);
                Bukkit.broadcastMessage(s+s2);
            }
        }, 0L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
