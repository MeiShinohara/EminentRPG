package com.github.eminentrpg.skills;

import org.bukkit.block.BlockState;

import com.github.eminentrpg.configs.MiningConfig;
import com.github.eminentrpg.player.EminentPlayer;

public class Mining extends Skill {
	
	public static int getBlockEXP(BlockState block) {
		return MiningConfig.getInstance().getBlockEXP(block);
	}
	
	public Mining(EminentPlayer player) {
		super(player);
		this.skill = Skills.MINING;
		this.exp = player.getConfig().getSkillExp(Skills.MINING);
		this.level = player.getConfig().getSkillLevel(Skills.MINING);
	}
	
	@Override
	public String getSkillName() {
		return "Mining";
	}
	

	
}
