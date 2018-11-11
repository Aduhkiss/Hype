package net.angusbeefgaming.hype.plugins;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.leaderboards.Leaderboard;
import me.kbrewster.hypixelapi.leaderboards.Leaderboards;
import me.kbrewster.mojangapi.MojangAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class ArcadeLB extends Plugin {

	public ArcadeLB(HypixelAPI api) {
		super("ArcadeLB", "Atticus Zambrana");
	}
	
	@Override
	public void startup() {
		
	}
	
	@Override
	public void execute() {
		List<Leaderboard> lb = null;
		try {
			lb = api.getLeaderboard(Leaderboards.ARCADE);
		} catch (APIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Util.print("Error", "There was an error accessing the Hypixel API! Please try again later. (Error code: APIException)");
		} catch (InvalidPlayerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Util.print("Error", "Sorry, but I was unable to find data for that player! Maybe a typo? (Error code: InvalidPlayerException)");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Util.print("Error", "There was an error parsing that command (Error code: IOException)");
		}
		
		Util.print(getName(), "Now Displaying All Arcade Leaderboards");
		
		for(Leaderboard lboard : lb) {
			System.out.println("\n");
			System.out.println(String.format("==== %s (%s) ====", lboard.getTitle(), lboard.getPrefix()));
            for (int i = 0; lboard.getLeaders().size() > i; i++) {
                UUID uuid = UUID.fromString(lboard.getLeaders().get(i));
                
                System.out.println(i + ") " + MojangAPI.getName(uuid));
            }
		}
	}

}
