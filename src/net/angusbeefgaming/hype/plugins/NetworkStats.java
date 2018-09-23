package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;
import net.angusbeefgaming.hype.manager.CacheManager;
import net.angusbeefgaming.hype.obj.NetworkData;

public class NetworkStats extends Plugin {
	public NetworkStats(HypixelAPI api) {
		super("Network", "Atticus Zambrana");
	}
	
	@Override
	public void execute() {
		Util.print(getName(), "Who would you like to lookup?");
		
		String name = Util.getInput();
		
		// Check if the player was found in the cache
		NetworkData data = null;
		
		if(CacheManager.getCachedData(name) != null) {
			data = CacheManager.getCachedData(name);
		}
		else {
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
			
			data = new NetworkData(name, player.getAbsoluteLevel(), player.getRank(), player.getPackageRank(), player.getKarma());
			CacheManager.cachedNetworkData.add(data);
		}

		Util.print("Network Stats", "Showing Network Stats for " + name);
		
		System.out.println("Network Level: " + data.getNetworkLevel());
		System.out.println("Rank: " + data.getFullRank());
		System.out.println("Karma: " + data.getKarma());
		System.out.println("Package Rank: " + data.getPackageRank());
		System.out.println("");
	}
}
