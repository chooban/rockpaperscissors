package com.rosshendry.rplsp.util;

import java.util.HashMap;
import java.util.Map;

import com.rosshendry.rplsp.players.Player;

public class RPLSPGame {

	private final Player playerOne, playerTwo;
	private int numHands = 0;
	private final RPLSPGraph possibleMoves = new RPLSPGraph();
	private Map<Outcome, Integer> statistics;

	public RPLSPGame( Player p1, Player p2 ) {
		this.playerOne = p1;
		this.playerTwo = p2;
		this.statistics = new HashMap<>();
		for ( Outcome c : Outcome.values() ) {
			this.statistics.put( c, 0 );
		}
	}

	public Outcome play() {
		this.numHands++;
		Outcome outcome = null;

		Choice p1Choice = playerOne.getMove();
		Choice p2Choice = playerTwo.getMove();

		System.out.println( String.format( "%s picks %s", playerOne.getName(), p1Choice ) );
		System.out.println( String.format( "%s picks %s", playerTwo.getName(), p2Choice ) );

		if ( p1Choice.equals( p2Choice ) ) {
			System.out.println( "A tie! Go again..." );
			outcome = Outcome.DRAW;
		} else {

			String result = possibleMoves.getEdge( p1Choice, p2Choice );
			String p2Result = possibleMoves.getEdge( p2Choice, p1Choice );

			if ( result != null ) {
				System.out.println( String.format( "%s %s %s! %s won!", p1Choice.toString(), result, p2Choice.toString(), playerOne.getName() ) );
				outcome = Outcome.PLAYER1;
			} else if ( p2Result != null ) {
				System.out.println( String.format( "%s %s %s! %s won!", p2Choice.toString(), p2Result, p1Choice.toString(), playerTwo.getName() ) );
				outcome = Outcome.PLAYER2;
			} else {
				throw new RuntimeException( "Amazingly illegal move" );
			}
		}

		this.statistics.put( outcome, this.statistics.get( outcome ) + 1 );
		return outcome;
	}

	public void displayStatistics() {
		System.out.println( "Total hands played : " + numHands );
		System.out.println( String.format( "%s wins : %d (%.2f)", playerOne.getName(), statistics.get( Outcome.PLAYER1 ),
				(double) statistics.get( Outcome.PLAYER1 ) / numHands ) );
		System.out.println( String.format( "%s wins : %d (%.2f)", playerTwo.getName(), statistics.get( Outcome.PLAYER2 ),
				(double) statistics.get( Outcome.PLAYER2 ) / numHands ) );
		System.out.println( String.format( "Ties : %d (%.2f)", statistics.get( Outcome.DRAW ), (double) statistics.get( Outcome.DRAW ) / numHands ) );
	}
}
