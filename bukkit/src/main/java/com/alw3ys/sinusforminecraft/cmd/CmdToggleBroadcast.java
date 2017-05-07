package com.alw3ys.sinusforminecraft.cmd;

import com.alw3ys.sinusforminecraft.SinusForMinecraftPlugin;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.Set;

@RequiredArgsConstructor
public class CmdToggleBroadcast implements CommandExecutor {

    private final SinusForMinecraftPlugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) return true;

        final Player player = (Player) sender;
        final ConfigurationSection toggleBroadcast = plugin.getConfig().getConfigurationSection("toggleBroadcast");


        if (!player.hasPermission("sinusbotminecraft.broadcast.toggle")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("noPermissions")));
            return true;
        }

        Set<Player> playerList = plugin.getPlayerList();

        if (!playerList.contains(player)) {
            playerList.add(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("enabled")));
        } else {
            playerList.remove(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', toggleBroadcast.getString("disabled")));
        }
        return false;
    }
}