package com.github.eminentrpg.listeners;

import java.util.LinkedHashMap;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.github.eminentrpg.configs.MiningConfig;
import com.github.eminentrpg.player.EminentPlayer;
import com.github.eminentrpg.skills.Mining;
import com.github.eminentrpg.skills.Skills;

public class BlockListener implements Listener {
	private static LinkedHashMap<Location, String> placedBlocks;
	
	public BlockListener() {
		placedBlocks = new LinkedHashMap<Location, String>();
	}
	
	public static boolean blockPlacedByPlayer(BlockState blockstate) {
		return placedBlocks.containsKey(blockstate.getLocation());
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		// unregister block as placed
		if(blockPlacedByPlayer(block.getState())) {
			placedBlocks.remove(block.getLocation());
		} else {
			MiningConfig config = MiningConfig.getInstance();
			EminentPlayer.getEminentPlayer(player).addExp(config.getBlockEXP(block.getState()), Skills.MINING);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		placedBlocks.put(block.getLocation(), player.getName());
	}
}
