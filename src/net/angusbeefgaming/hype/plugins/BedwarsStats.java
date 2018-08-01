package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.bedwars.Bedwars;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class BedwarsStats extends Plugin {
	public BedwarsStats(HypixelAPI api) {
		super("Bedwars", "Atticus Zambrana");
	}
	
	@Override
	public void execute() {
		Util.print(getName(), "Who would you like to lookup?");
		
		String name = Util.getInput();
		HypixelPlayer player = null;
		try {
			player = api.getPlayer(name);
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.print("Bedwars Stats", "Showing Bedwars Stats for " + name);
		Bedwars bed = player.getStats().getBedwars();
		
		System.out.println("Beds Broken: " + bed.getBedsBrokenBedwars());
		System.out.println("Beds Lost: " + bed.getBedsLostBedwars());
		System.out.println("Coins: " + bed.getCoins());
		System.out.println("Wins: " + bed.getWinsBedwars());
		System.out.println("Losses: " + bed.getLossesBedwars());
		System.out.println("Current Winstreak: " + bed.getWinstreak());
		System.out.println("");
	}
}
