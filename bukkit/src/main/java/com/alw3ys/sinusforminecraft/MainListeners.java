package com.alw3ys.sinusforminecraft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

class MainListeners implements Listener {

    private final SinusForMinecraft plugin;

    MainListeners(SinusForMinecraft plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerRemoveFromTrackAnnouncements(final PlayerQuitEvent event) {

        Player player = event.getPlayer();
        List<Player> playerList = plugin.getPlayerList();

        if (playerList.contains(player)) playerList.remove(player);
    }
}