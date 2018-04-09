package com.github.eminentrpg.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandEminent implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			ItemStack diamonds = new ItemStack(Material.DIAMOND, 99);
			player.getInventory().addItem(diamonds);
			return true;
		}
		return false;
		
	}

}
