package net.angusbeefgaming.hype.plugins;

import java.io.IOException;
import java.util.UUID;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import me.kbrewster.hypixelapi.session.Session;
import me.kbrewster.mojangapi.MojangAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class SessionStats extends Plugin {
	public SessionStats(HypixelAPI api) {
		super("Session", "Atticus Zambrana");
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
		Util.print(getName(), "Showing Session Stats for " + name);
		
		Session s = null;
		try {
			s = api.getSession(name);
		} catch (APIException | IOException e) {
			Util.print(getName(), "No Session was found for " + name + "! In a game?");
			return;
		}
		
		System.out.println("Server: " + s.getServer());
		
		System.out.println("\n\n");
		
		System.out.println("Player List:");
		
		//Still gotta figure this out
		for(String str : s.getPlayers()) {
			String username = MojangAPI.getName(UUID.fromString(Util.getFullUUID(str)));
			System.out.println(username);
		}
		
		
		System.out.println("");
	}
}
