package net.angusbeefgaming.hype;

import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);
	
	public static void print(String module, String message) {
		System.out.println(module + "> " + message);
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
}
