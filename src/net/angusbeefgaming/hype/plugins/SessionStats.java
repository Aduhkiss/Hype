package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.session.Session;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class SessionStats extends Plugin {
	public SessionStats(HypixelAPI api) {
		super("Session", "Atticus Zambrana", api);
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
		Util.print(getName(), "Showing Session Stats for " + name);
		
		Session s = null;
		try {
			s = api.getSession(name);
		} catch (APIException | IOException e) {
			System.out.println("There was an error grabbing Session Data for " + name + "!");
			e.printStackTrace();
		}
		
		System.out.println("Server: " + s.getServer());
		System.out.println("Player List: ");
		for(String str : s.getPlayers()) {
			System.out.println(str);
		}
		
		System.out.println("");
	}
}