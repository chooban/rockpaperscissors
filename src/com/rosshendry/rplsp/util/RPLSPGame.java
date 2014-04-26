package com.rosshendry.rplsp.util;

import com.rosshendry.rplsp.players.Player;

public class RPLSPGame {

	private final Player playerOne, playerTwo;
	private final int maxMoves;
	private boolean won = false;
	private int numMoves = 0;
	private final RPLSPGraph possibleMoves = new RPLSPGraph();

	public RPLSPGame( Player p1, Player p2, int maxMoves ) {
		this.playerOne = p1;
		this.playerTwo = p2;
		this.maxMoves = maxMoves;
	}

	public void play() {
		while (!won && numMoves < maxMoves) {
			Choice p1Choice = playerOne.getMove();
			Choice p2Choice = playerTwo.getMove();

			numMoves++;

			System.out.println( String.format( "%s picks %s", playerOne.getName(), p1Choice ) );
			System.out.println( String.format( "%s picks %s", playerTwo.getName(), p2Choice ) );

			if ( p1Choice.equals( p2Choice ) ) {
				System.out.println( "A tie! Go again..." );
				continue;
			}

			String result = possibleMoves.getEdge( p1Choice, p2Choice );
			String p2Result = possibleMoves.getEdge( p2Choice, p1Choice );
			if ( result != null ) {
				System.out.println( String.format( "%s %s %s! %s won!", p1Choice.toString(), result, p2Choice.toString(), playerOne.getName() ) );
				this.won = true;
			} else if ( p2Result != null ) {
				System.out.println( String.format( "%s %s %s! %s won!", p2Choice.toString(), p2Result, p1Choice.toString(), playerTwo.getName() ) );
				this.won = true;
			} else {
				throw new RuntimeException( "Amazingly illegal move" );
			}
		}
	}
}
