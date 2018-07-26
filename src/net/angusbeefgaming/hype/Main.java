package net.angusbeefgaming.hype;

import me.kbrewster.hypixelapi.HypixelAPI;
import net.angusbeefgaming.hype.plugins.ArcadeStats;
import net.angusbeefgaming.hype.plugins.BedwarsStats;
import net.angusbeefgaming.hype.plugins.NetworkStats;
import net.angusbeefgaming.hype.plugins.TNTGamesStats;

public class Main {
	public static void main(String[] args) {
		Util.print("Hype", "Welcome to Hype Stats by Atticus Zambrana");
		Util.pause(1);
		HypixelAPI api = new HypixelAPI("c63e883f-dc9c-449e-8bf4-fe72fdd370e0");
		start(api);
	}
	
	public static void start(HypixelAPI api) {
		Util.print("Hype", "Please State what you would like to search, and type HELP for all commands!");
		
		String input = Util.getInput();
		
		if(input.equals("HELP")) {
			Util.print("Commands", "Commands to run: HELP, NETWORK, BEDWARS, TNTGAMES, ARCADE");
			start(api);
		}
		if(input.equals("NETWORK")) {
			Util.print("Network Stats", "Who would you like to display the stats of?");
			String playername = Util.getInput();
			new NetworkStats(api, playername);
			start(api);
		}
		if(input.equals("BEDWARS")) {
			Util.print("Bedwars Stats", "Who would you like to display the stats of?");
			String playername = Util.getInput();
			new BedwarsStats(api, playername);
			start(api);
		}
		if(input.equals("TNTGAMES")) {
			Util.print("TNT Games Stats", "Who would you like to display the stats of?");
			String playername = Util.getInput();
			new TNTGamesStats(api, playername);
			start(api);
		}
		if(input.equals("ARCADE")) {
			Util.print("Arcade Stats", "Who would you like to display the stats of?");
			String playername = Util.getInput();
			new ArcadeStats(api, playername);
			start(api);
		}
		else {
			Util.print("Hype", "Unknown Command. Type HELP for Commands.");
			start(api);
		}
	}
}
