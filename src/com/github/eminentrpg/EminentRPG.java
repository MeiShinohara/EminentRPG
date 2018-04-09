package com.github.eminentrpg;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.eminentrpg.commands.CommandEminent;
import com.github.eminentrpg.commands.CommandSkill;
import com.github.eminentrpg.listeners.BlockListener;
import com.github.eminentrpg.listeners.PlayerListener;
import com.github.eminentrpg.player.EminentPlayer;

public class EminentRPG extends JavaPlugin {
	FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
		// register commands
		this.getCommand("eminent").setExecutor(new CommandEminent());
		this.getCommand("skill").setExecutor(new CommandSkill());
		
		// register event handlers
		this.getServer().getPluginManager().registerEvents(new BlockListener(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		for(Player online : Bukkit.getServer().getOnlinePlayers()) {
			EminentPlayer.addPlayer(online);
			
		}
	}
	
	@Override
	public void onDisable() {
		
	}

}
