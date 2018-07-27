package net.angusbeefgaming.hype;

import java.util.ArrayList;
import java.util.List;

import me.kbrewster.hypixelapi.HypixelAPI;
import net.angusbeefgaming.hype.plugins.ArcadeStats;
import net.angusbeefgaming.hype.plugins.BedwarsStats;
import net.angusbeefgaming.hype.plugins.GuildStats;
import net.angusbeefgaming.hype.plugins.NetworkStats;
import net.angusbeefgaming.hype.plugins.TNTGamesStats;

public class Main {
	
	public static final String VERSION = "v1.2";
	public static final boolean BETA = false;
	
	public static List<Plugin> plugins = new ArrayList<Plugin>();
	public static void main(String[] args) {
		Util.print("Hype", "Welcome to Hype Stats by Atticus Zambrana");
		if(BETA) {
			Util.print("Hype", "You are running " + VERSION + " BETA!");
		}
		else {
			Util.print("Hype", "You are running " + VERSION + "!");
		}
		Util.print("Hype", "Please Enter your Hypixel API Key...");
		String KEY = Util.getInput();
		
		Util.print("Hype", "Registering Hypixel API...");
		HypixelAPI api = new HypixelAPI(KEY);
		Util.print("Plugin Manager", "Registering Plugins...");
		// Plugin Manager
		
		plugins.add(new ArcadeStats(api));
		plugins.add(new BedwarsStats(api));
		plugins.add(new NetworkStats(api));
		plugins.add(new TNTGamesStats(api));
		plugins.add(new GuildStats(api));
		
		start(api);
	}
	
	public static void start(HypixelAPI api) {
		Util.print("Hype", "Please State what you would like to search, and type HELP for all commands!");
		
		String input = Util.getInput();
		
		for(Plugin pl : plugins) {
			if(pl.getName().equalsIgnoreCase(input)) {
				pl.execute();
				start(api);
			}
		}
		
		if(input.equalsIgnoreCase("HELP")) {
			Util.print("Commands", "Commands to run: ");
			for(Plugin pl : plugins) {
				System.out.println(pl.getName());
			}
			start(api);
		}
		else {
			Util.print("Hype", "Unknown Command. Type HELP for Commands.");
			start(api);
		}
	}
}
