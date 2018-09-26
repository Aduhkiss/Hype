package net.angusbeefgaming.hype;

import me.kbrewster.hypixelapi.HypixelAPI;

public abstract class Plugin {
	
	/*
	 * Base Plugin Class
	 * 
	 * Created by Atticus Zambrana
	 * 
	 * Current Version: 1.3
	 */
	
	public String name;
	public HypixelAPI api;
	public String author;
	public Plugin(String name, String author) {
		this.name = name;
		this.api = Main.getApi();
		this.author = author;
		// Took this out because it causes Spam
		//Util.print("Plugin Manager", "Registered " + name + " by " + author);
		startup();
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public abstract void execute();
	
	public abstract void startup();
}
