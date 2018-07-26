package net.angusbeefgaming.hype;

import me.kbrewster.hypixelapi.HypixelAPI;

public class Plugin {
	/*
	 * Base Class for all 1.1+ Plugins for Hype
	 * Created by Atticus Zambrana
	 */
	
	public String name;
	public HypixelAPI api;
	public Plugin(String name, HypixelAPI api) {
		this.name = name;
		this.api = api;
	}
	public String getName() {
		return name;
	}
	public void execute() {
		
	}
}
