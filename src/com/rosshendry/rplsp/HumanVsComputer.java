package com.rosshendry.rplsp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import com.rosshendry.rplsp.players.HumanPlayer;
import com.rosshendry.rplsp.players.Player;
import com.rosshendry.rplsp.players.RandomComputerPlayer;
import com.rosshendry.rplsp.util.RPLSPGame;

public class HumanVsComputer {

	private static final String[] computerNames = { "Sheldor", "HAL9000", "Deep Thought" };
	private static Random rand = new Random();

	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println( "What's your name, player?" );
		
		// Doesn't cope with empty strings very well, so don't type one.
		String p1Name = br.readLine().trim();
		String p2Name = computerNames[rand.nextInt(computerNames.length)];
		
		System.out.println( String.format( "%s will player %s!", p1Name, p2Name ) );
		
		Player p1 = new HumanPlayer( p1Name );
		Player p2 = new RandomComputerPlayer( p2Name );
		
		RPLSPGame game = new RPLSPGame( p1, p2, 5 );
		game.play();
		
		System.out.println( "Thanks for playing! Come again!" );
	}
}
