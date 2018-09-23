package net.angusbeefgaming.hype.plugins;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.leaderboards.Leaderboard;
import me.kbrewster.hypixelapi.leaderboards.Leaderboards;
import me.kbrewster.mojangapi.MojangAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class BedwarsLeaderboards extends Plugin {
	
	public BedwarsLeaderboards(HypixelAPI api) {
		super("BedwarsLB", "Atticus Zambrana");
	}
	
	@Override
	public void execute() {
		List<Leaderboard> lb = null;
		try {
			lb = api.getLeaderboard(Leaderboards.BEDWARS);
		} catch (APIException e) {
			Util.error("The Hypixel API Returned an error. Please Try Again Later.");
		} catch (IOException e) {
			Util.error("An Error has occured. Please Try Again Later.");
		}
		
		Util.print(getName(), "Now Displaying All Bedwars Leaderboards");
		
		for(Leaderboard lboard : lb) {
			System.out.println("\n\n");
			System.out.println(String.format("==== %s (%s) ====", lboard.getTitle(), lboard.getPrefix()));
            for (int i = 0; lboard.getLeaders().size() > i; i++) {
                UUID uuid = UUID.fromString(lboard.getLeaders().get(i));
                
                System.out.println(i + ") " + MojangAPI.getName(uuid));
            }
		}
	}

}
