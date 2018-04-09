package com.github.eminentrpg.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.eminentrpg.player.EminentPlayer;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		EminentPlayer.addPlayer(event.getPlayer());
		event.getPlayer().sendMessage("You joined a server using EminentRPG! The #1 RPG plugin!");
	}
	
	@EventHandler
	public void onPlayerDisconnect(PlayerQuitEvent event) {
		EminentPlayer.removePlayer(event.getPlayer());
	}
}
