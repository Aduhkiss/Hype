package net.angusbeefgaming.hype.plugins;

import java.io.IOException;
import java.util.UUID;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.key.APIKey;
import me.kbrewster.mojangapi.MojangAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class KeyInfo extends Plugin {
	public KeyInfo(HypixelAPI api) {
		super("keyinfo", "Atticus Zambrana");
	}

	@Override
	public void execute() {
		APIKey myKey = null;
		// TODO Auto-generated method stub
		// Get the current api key
		try {
			myKey = api.getKeyInfo();
		}
		catch(APIException | IOException ex) {
			Util.print(getName(), "There was an error proccessing your request! Try again later.");
			ex.printStackTrace();
		}
		
		Util.print("Showing data for your Hypixel API Key...");
		
		Util.print("Key Owner UUID: " + myKey.getOwnerUuid());
		Util.print("Key Owner username: " + MojangAPI.getName(UUID.fromString(Util.getFullUUID(myKey.getOwnerUuid()))));
		Util.print("Key Total Queries: " + myKey.getTotalQueries());
	}

	@Override
	public void startup() {
		// TODO Auto-generated method stub
		
	}
}
