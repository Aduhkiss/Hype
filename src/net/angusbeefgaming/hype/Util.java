package net.angusbeefgaming.hype;

import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);
	
	public static void print(String module, String message) {
		System.out.println(module + "> " + message);
	}
	
	public static void debug(String message) {
		if(Main.BETA) {
			System.out.println("Debug" + "> " + message);
		}
	}
	
	public static void error(String message) {
		System.out.println("Error> " + message);
	}
	
	public static void pause(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getInput() {
		return sc.nextLine();
	}
	
	public static String getFullUUID(String trimmedUuid) {
		return java.util.UUID.fromString(
			    trimmedUuid
			    .replaceFirst( 
			        "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5" 
			    )
			).toString();
	}
}
