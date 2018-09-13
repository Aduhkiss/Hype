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
		return fullRank;
	}
	public String getPackageRank() {
		return packageRank;
	}
	public long getKarma() {
		return karma;
	}
}
