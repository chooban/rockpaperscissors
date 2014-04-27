package com.rosshendry.rplsp;

import java.io.BufferedReader;
import java.io.IOException;
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
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		String p1Name = getPlayerName( br );
		String p2Name = computerNames[rand.nextInt( computerNames.length )];
		System.out.println( String.format( "%s will player %s!", p1Name, p2Name ) );

		System.out.println( "How many hands (between 0 and 10) would you like to play?" );
		String inputHands = br.readLine().trim();
		int totalHands = Integer.MIN_VALUE;

		while (totalHands < 0) {
			try {
				int hands = Integer.parseInt( inputHands );
				if ( hands < 0 || hands > 10 ) {
					System.out.println( "Not within bounds, try again" );
					continue;
				}
				totalHands = hands;
				System.out.println( String.format( "Great! You'll play for %d hands!", totalHands ) );
			} catch (NumberFormatException e) {
				System.out.println( "That wasn't a number, please try again" );
				continue;
			}
		}
		Player p1 = new HumanPlayer( p1Name );
		Player p2 = new RandomComputerPlayer( p2Name );

		RPLSPGame game = new RPLSPGame( p1, p2 );

		for ( int i = 0; i < totalHands; i++ ) {
			System.out.println( "Round " + i + "!" );
			game.play();
		}

		System.out.println( "\nThat's all folks!" );
		game.displayStatistics();
		System.out.println( "Thanks for playing! Come again!" );
	}

	private static String getPlayerName( BufferedReader br ) throws IOException {
		System.out.println( "What's your name, player?" );

		// Doesn't cope with empty strings very well, so don't type one.
		String p1Name = br.readLine().trim();
		return p1Name;
	}
}
