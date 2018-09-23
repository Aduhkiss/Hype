package net.angusbeefgaming.hype.plugins;

import me.kbrewster.hypixelapi.HypixelAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;
import net.angusbeefgaming.hype.manager.CacheManager;

public class ClearCacheData extends Plugin {

	public ClearCacheData(HypixelAPI api) {
		super("cleardata", "Atticus Zambrana");
	}

	@Override
	public void execute() {
		Util.print("System", "Attempting to clear all cached data...");
		// do something usefull here
		CacheManager.clearCache();
		Util.print("System", "Done!");
	}

}
