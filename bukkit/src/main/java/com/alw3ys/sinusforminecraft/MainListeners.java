package com.alw3ys.sinusforminecraft;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Set;

@RequiredArgsConstructor
class MainListeners implements Listener {

    private final SinusForMinecraftPlugin plugin;

    @EventHandler
    void onPlayerRemoveFromTrackAnnouncements(final PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Set<Player> playerList = plugin.getPlayerList();

        if (playerList.contains(player)) playerList.remove(player);
    }
}