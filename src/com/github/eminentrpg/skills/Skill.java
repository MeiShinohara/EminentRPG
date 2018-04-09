package com.github.eminentrpg.skills;

import com.github.eminentrpg.player.EminentPlayer;

public abstract class Skill {
	protected int level;
	protected int exp;
	protected Skills skill;
	protected EminentPlayer player;
	
	abstract String getSkillName();
	
	public Skill(EminentPlayer player) {
		this.player = player;
	}

	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}
	
	/**
	 * Add experience to the player's skill
	 * 
	 * @param exp is the amount of experience to add.
	 * @return is true if the amount of experience leveled the player up.
	 */
	public boolean addExp(int exp) {
		this.exp = this.exp + exp;
		int toNextLevel = expToNextLevel();
		
		if(this.exp >= toNextLevel) {
			this.level++;
			this.exp -= toNextLevel;
			player.getPlayer().sendMessage("You leveled up in " + skill.toString().toLowerCase() + ". "
					+ "("+level+")");
			player.getConfig().setSkillExp(this.exp, skill);
			player.getConfig().setSkillLevel(this.level, skill);
			return true;
		}
		player.getConfig().setSkillExp(this.exp, skill);
		return false;
	}
	
	public int expToNextLevel() {
		return (int) (100 * Math.pow(1.01, level));
	}
	
}

