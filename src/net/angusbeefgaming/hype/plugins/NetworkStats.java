package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class NetworkStats extends Plugin {
	public NetworkStats(HypixelAPI api) {
		super("Network", api);
	}
	
	@Override
	public String getName() {
		 return super.name;
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
		Util.print("Network Stats", "Showing Network Stats for " + name);
		
		System.out.println("Network Level: " + player.getAbsoluteLevel());
		System.out.println("Rank: " + player.getRank());
		System.out.println("Karma: " + player.getKarma());
		System.out.println("Package Rank: " + player.getPackageRank());
		System.out.println("");
	}
}
