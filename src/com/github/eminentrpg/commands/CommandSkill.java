package com.github.eminentrpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.eminentrpg.player.EminentPlayer;
import com.github.eminentrpg.skills.Skills;

import net.md_5.bungee.api.ChatColor;

public class CommandSkill implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			EminentPlayer ePlayer = EminentPlayer.getEminentPlayer(player);
			
			if(args.length < 1) {
				return printAllSkills(player);
			}
			else {
				return printSkillLevel(ePlayer, args[0]);
			}
		}
		return false;
	}
	
	private boolean printSkillLevel(EminentPlayer ePlayer, String arg) {
		Skills skill = null;
		
		for(Skills s : Skills.values()){
			String argument = arg.toLowerCase();
			if(argument.equals(s.toString().toLowerCase())) {
				skill = s;
			}
		}
		
		if(skill != null) {
			ePlayer.getPlayer().sendMessage(ChatColor.YELLOW + "Your level in " + skill.toString().toLowerCase() + " is " + ePlayer.getConfig().getSkillLevel(skill) + "!");	
		}
		else {
			ePlayer.getPlayer().sendMessage(ChatColor.RED + "That skill does not exist!");
			return false;
		}
		return true;
	}
	
	private boolean printAllSkills(Player player) {
		String message = "";
		
		for(Skills s : Skills.values()){
			message = message + s.toString().toLowerCase() + ",";
		}
		
		message = message.substring(0, message.length()-1);
		
		player.sendMessage(ChatColor.GREEN + message);
		
		return true;
	}

}
