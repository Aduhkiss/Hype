package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.arcade.Arcade;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class ArcadeStats extends Plugin {
	public ArcadeStats(HypixelAPI api) {
		super("Arcade", "Atticus Zambrana");
	}
	
	@Override
	public void startup() {
		
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
		Util.print("Arcade Stats", "Showing Arcade Stats for " + name);

		Arcade ar = player.getStats().getArcade();
		
		System.out.println("Coins: " + ar.getCoins());
		System.out.println("Farm Hunt Wins: " + ar.getWinsFarmHunt());
		System.out.println("Build Battle Wins: " + ar.getWinsBuildbattle());
		System.out.println("Mini Walls Wins: " + ar.getWinsMiniWalls());
		System.out.println("Hypixel Says Wins: " + ar.getWinsSimonSays());
		System.out.println("Soccer Wins: " + ar.getWinsSoccer());
		System.out.println("Dragon Wars Wins: " + ar.getWinsDragonwars2());
		System.out.println("One in the Quiver Wins: " + ar.getWinsOneinthequiver());
		
		System.out.println("");
	}
}
