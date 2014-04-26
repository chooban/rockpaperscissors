package com.rosshendry.rplsp.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rosshendry.rplsp.util.Choice;

public class HumanPlayer implements Player {

	private final String name;

	public HumanPlayer( String name ) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Choice getMove() {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		System.out.println( String.format( "What's your move, %s?", name ) );
		String inputChoice = "";
		Choice playerChoice = null;
		
		try {
			while ( playerChoice == null ) {
				inputChoice = br.readLine().trim();
				playerChoice = Choice.parseString( inputChoice );
				
				if ( playerChoice == null ) {
					System.out.println( "Sorry, I didn't recognise that. Try again..." );
				}
			}
		} catch (IOException e) {
			throw new RuntimeException( e );
		}
		return playerChoice;
	}

}
