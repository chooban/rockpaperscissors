package com.rosshendry.rplsp.players;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.rosshendry.rplsp.util.Choice;

/**
 * This player will simply select a random move each time.
 * 
 * @author ross
 *
 */
public class RandomComputerPlayer implements Player {

	private final Random rand;
	private final List<Choice> possibleChoices;
	private final int countOfChoices;
	private final String name;
	
	public RandomComputerPlayer( String name ) {
		this.name = name;
		rand = new Random();
		possibleChoices = Collections.unmodifiableList( Arrays.asList( Choice.values() ) );
		countOfChoices = possibleChoices.size();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Choice getMove() {
		return possibleChoices.get( rand.nextInt( countOfChoices ) );
	}

}
