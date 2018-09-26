package net.angusbeefgaming.hype.plugins;

import java.io.IOException;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.player.HypixelPlayer;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class SkywarsStats extends Plugin {
	
	public SkywarsStats(HypixelAPI api) {
		super("Skywars", "Atticus Zambrana");
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
		Util.print(getName(), "Showing Skywars Stats for " + name);
		//Skywars sky = player.getStats().getSk();
		
		// DUde??1!?!? There is no such thing as skywars??
	}

}
