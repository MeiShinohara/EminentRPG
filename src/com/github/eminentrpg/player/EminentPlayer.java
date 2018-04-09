package com.github.eminentrpg.player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.github.eminentrpg.configs.PlayerConfig;
import com.github.eminentrpg.skills.Mining;
import com.github.eminentrpg.skills.Skills;

public class EminentPlayer {
	private static HashMap<UUID, EminentPlayer> activePlayers = new HashMap<UUID, EminentPlayer>();
	
	public static EminentPlayer getEminentPlayer(Player player) {
		return activePlayers.get(player.getUniqueId());
	}
	
	public static EminentPlayer addPlayer(Player player) {
		EminentPlayer ePlayer = new EminentPlayer(player);
		activePlayers.put(player.getUniqueId(), ePlayer);
		return ePlayer;
	}
	
	public static void removePlayer(Player player) {
		activePlayers.remove(player.getUniqueId());
	}
	
	private Player player;
	private PlayerConfig config;
	private Mining mining;
	
	public EminentPlayer(Player player) {
		this.player = player;
		config = new PlayerConfig(player);
		mining = new Mining(this);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public PlayerConfig getConfig() {
		return config;
	}
	
	public Mining getMining() {
		return mining;
	}
	
	public boolean addExp(int exp, Skills skill) {
		switch(skill) {
		case MINING: return this.mining.addExp(exp);
		}
		return false;
	}

	
}
