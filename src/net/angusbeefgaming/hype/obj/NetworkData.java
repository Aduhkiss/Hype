package net.angusbeefgaming.hype.obj;

public class NetworkData {
	/*
	 * Full Java Class
	 * for Storing data collected from Network API Queries.
	 * Written by Atticus Zambrana
	 */
	private String playername;
	private double networkLevel;
	private String fullRank;
	private String packageRank;
	private long karma;
	public NetworkData(String playername, double d, String fullRank, String packageRank, long l) {
		this.playername = playername;
		this.networkLevel = d;
		this.fullRank = fullRank;
		this.packageRank = packageRank;
		this.karma = l;
	}
	public String getPlayername() {
		return playername;
	}
	public double getNetworkLevel() {
		return networkLevel;
	}
	public String getFullRank() {
		if(fullRank == null) {
			return "NONE FOUND!";
		}
		if(fullRank.equals("NORMAL")) {
			return "NON";
		}
		return fullRank;
	}
	public String getPackageRank() {
		if(packageRank == null) {
			if(fullRank == null) {
				return "NON";
			}
			if(fullRank.equals("YOUTUBER")) {
				return "WAS A NON BEFORE YOUTUBE RANK!";
			}
			return "NONE FOUND!";
		}
		if(packageRank.equals("NORMAL")) {
			return "NON";
		}
		return packageRank;
	}
	public long getKarma() {
		return karma;
	}
}
