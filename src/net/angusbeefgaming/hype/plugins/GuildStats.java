package net.angusbeefgaming.hype.plugins;

import java.io.IOException;
import java.util.UUID;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.hypixelapi.HypixelAPI;
import me.kbrewster.hypixelapi.guild.Guild;
import me.kbrewster.hypixelapi.guild.Member;
import me.kbrewster.mojangapi.MojangAPI;
import net.angusbeefgaming.hype.Plugin;
import net.angusbeefgaming.hype.Util;

public class GuildStats extends Plugin {

	public GuildStats(HypixelAPI api) {
		super("Guild", "Atticus Zambrana");
	}

	@Override
	public void execute() {
		Util.print(getName(), "Who's Guild would you like to lookup?");
		
		String name = Util.getInput();
        String guildID = null;
		try {
			guildID = api.getGuildID(name);
		} catch (APIException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Gets Guilds Identifier
        Guild guild = null;
		try {
			guild = api.getGuild(guildID);
		} catch (APIException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.print("Guild Stats", "Showing Guild Stats for " + name);
        System.out.println("Name: " + guild.getName());
        System.out.println("ID: " + guild.getId());
        System.out.println("Tag: " + (guild.isCanTag() ? guild.getTag() : "None"));
        System.out.println("Coins: " + guild.getCoins());
        System.out.println("Guild Members: ");
        
        // Get the Guild Size
        int size = 0;
        for(Member member : guild.getMembers()) {
        	size++;
        }
        
        int tick = 0;
        for(Member member : guild.getMembers()) {
        	if(tick >= 60/* Max Cap for What we are showing */) {
        		Util.print(getName(), "And " + size + " more...");
        		return;
        	}
            String names = MojangAPI.getName(UUID.fromString(MojangAPI.addDashes(member.getUuid())));
            System.out.println(String.format("%s (%s)", names, member.getRank()));
            tick++;
            size--;
        }
	}

}
