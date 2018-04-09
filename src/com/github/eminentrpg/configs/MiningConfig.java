package com.github.eminentrpg.configs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.block.BlockState;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class MiningConfig extends ConfigBase {
	private static MiningConfig instance;
	private static String fileName = "mining.yml";
	private static String directory = "mining";
	
	public static MiningConfig getInstance() {
		if(instance == null)
			instance = new MiningConfig();
		return instance;
	}
	
	public MiningConfig() {
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
	
	public int getBlockEXP(BlockState blockstate) {
		return config.getInt(blockstate.getType().name().toLowerCase());
	}
	
	public void save() {
		try {
			config.save(this.getFile(fileName, directory));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
