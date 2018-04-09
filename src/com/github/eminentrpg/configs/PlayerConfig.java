package com.github.eminentrpg.configs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.github.eminentrpg.skills.Skills;

public class PlayerConfig extends ConfigBase {
	private String fileName;
	private static String directory = "player";
	
	public PlayerConfig(Player player) {
		fileName = player.getUniqueId().toString()+".yml";
		config = new YamlConfiguration();
		
		try {
			config.load(this.getFile(fileName, directory));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public int getSkillLevel(Skills skill) {
		return config.getInt(skill.toString().toLowerCase() + ".level");
	}
	
	public void setSkillLevel(int level, Skills skill) {
		config.set(skill.toString().toLowerCase() + ".level", level);
		save();
	}
	
	public int getSkillExp(Skills skill) {
		return config.getInt(skill.toString().toLowerCase() + ".exp");
	}
	
	public void setSkillExp(int exp, Skills skill) { 
		config.set(skill.toString().toLowerCase() + ".exp", exp);
		save();
	}
	
	public void save() {
		try {
			config.save(this.getFile(fileName, directory));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean playerExists(Player player) {
		UUID id = player.getUniqueId();
		return this.configExists(id.toString()+"yml", directory);
	}

}
