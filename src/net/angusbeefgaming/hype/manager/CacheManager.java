package net.angusbeefgaming.hype.manager;

import java.util.ArrayList;
import java.util.List;

import net.angusbeefgaming.hype.obj.NetworkData;

public class CacheManager {
	public static List<NetworkData> cachedNetworkData = new ArrayList<NetworkData>();
	
	public static NetworkData getCachedData(String playername) {
		boolean there = false;
		for(NetworkData data : cachedNetworkData) {
			if(data.getPlayername().equalsIgnoreCase(playername)) {
				// We found data
				return data;
			}
		}
		// There was nothing found.
		return null;
	}
	
	public static void clearCache() {
		cachedNetworkData = null;
		cachedNetworkData = new ArrayList<NetworkData>();
	}
}
