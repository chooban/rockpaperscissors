package com.rosshendry.rplsp;

import com.rosshendry.rplsp.players.Player;
import com.rosshendry.rplsp.players.RandomComputerPlayer;
import com.rosshendry.rplsp.util.RPLSPGame;

public class TwoComputerPlayers {

	public static void main( String[] args ) {
		Player aiOne = new RandomComputerPlayer( "HAL9000" );
		Player aiTwo = new RandomComputerPlayer( "Sheldor" );
		
		RPLSPGame game = new RPLSPGame( aiOne, aiTwo );
		game.play();
	}

}
