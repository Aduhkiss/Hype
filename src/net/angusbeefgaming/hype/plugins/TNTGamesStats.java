package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.player.stats.tnt.TNTGames;
import net.angusbeefgaming.hype.Util;

public class TNTGamesStats {
	public TNTGamesStats(HypixelAPI api, String name) {
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
		TNTGames tnt = player.getStats().getTNTGames();
		
		System.out.println("Coins: " + tnt.getCoins());
		System.out.println("Wins: " + tnt.getWins());
		System.out.println("Current Winstreak: " + tnt.getWinstreak());
		
		System.out.println("");
	}
}
