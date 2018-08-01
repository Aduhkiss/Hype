package net.angusbeefgaming.hype;

import me.kbrewster.hypixelapi.HypixelAPI;

public abstract class Plugin {
	
	/*
	 * Base Plugin Class
	 * 
	 * Created by Atticus Zambrana
	 * 
	 * Current Version: 1.2
	 */
	
	public String name;
	public HypixelAPI api;
	public String author;
	public Plugin(String name, String author, HypixelAPI api) {
		this.name = name;
		this.api = api;
		this.author = author;
		// Took this out because it causes Spam
		//Util.print("Plugin Manager", "Registered " + name + " by " + author);
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public abstract void execute();
}
