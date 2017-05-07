package com.alw3ys.sinusforminecraft;

import com.alw3ys.sinusforminecraft.cmd.CmdToggleBroadcast;
import com.alw3ys.sinusforminecraft.cmd.CmdTrack;
import com.alw3ys.sinusforminecraft.utils.TrackUtils;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;

@Getter
public class SinusForMinecraftPlugin extends JavaPlugin {

    private TrackUtils trackUtils;
    private Set<Player> playerList = new HashSet<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        trackUtils = new TrackUtils(this);
        getCommand("ttb").setExecutor(new CmdToggleBroadcast(this));
        getCommand("track").setExecutor(new CmdTrack(this));
        initSocketServer(this);
        getServer().getPluginManager().registerEvents(new MainListeners(this), this);
    }

    private void initSocketServer(final SinusForMinecraftPlugin plugin) {

        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(getConfig().getInt("port"));
                    while (true) {
                        Socket accept = serverSocket.accept();
                        Executors.newFixedThreadPool(10).submit(new SocketReader(plugin, accept));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(this);
    }
}