package com.github.eminentrpg.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigBase {
	protected FileConfiguration config;
	
	public File getFile(String fileName, String directory) {
		if(configExists(fileName, directory))
			return new File(directory + "\\" + fileName);
		else 
			return initConfig(fileName, directory);	
	}
	
	/**
	 * Creates a configuration file in the directory.
	 * Overwrites existing configuration.
	 * 
	 */
	public File initConfig(String fileName, String directory) {
		File dir = new File("plugins\\EminentRPGPlugin\\" + directory);
		dir.mkdirs();
		
		File config = new File(dir, fileName);
		try {
			config.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return config;
	}
	
	public boolean configExists(String fileName, String directory) {
		File config = new File(directory + "\\" + fileName);
		return config.exists() && !config.isDirectory();
	}
}
