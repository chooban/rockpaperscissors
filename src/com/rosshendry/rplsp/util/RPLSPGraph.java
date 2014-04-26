package com.rosshendry.rplsp.util;

import static com.rosshendry.rplsp.util.Choice.LIZARD;
import static com.rosshendry.rplsp.util.Choice.PAPER;
import static com.rosshendry.rplsp.util.Choice.ROCK;
import static com.rosshendry.rplsp.util.Choice.SCISSORS;
import static com.rosshendry.rplsp.util.Choice.SPOCK;

public class RPLSPGraph extends AdjacencyGraph<Choice> {

	private RPLSPGraph( Choice... choices ) {
		// No creating your own
	}
	
	/**
	 * Scissors cut paper
	 * Paper covers rock
	 * Rock crushes lizard
	 * Lizard poisons Spock
	 * Spock smashes scissors
	 * Scissors decapitate lizard
	 * Lizard eats paper
	 * Paper disproves Spock
	 * Spock vaporizes rock
	 * Rock crushes scissors
	 */
	public RPLSPGraph() {
		super( ROCK, PAPER, LIZARD, SCISSORS, SPOCK );
		addEdge( SCISSORS, "cut", PAPER );
		addEdge( PAPER, "covers", ROCK );
		addEdge( ROCK, "crushes", LIZARD );
		addEdge( LIZARD, "poisons", SPOCK );
		addEdge( SPOCK, "smashes", SCISSORS );
		addEdge( SCISSORS, "decapitate", LIZARD );
		addEdge( LIZARD, "eats", PAPER );
		addEdge( PAPER, "disproves", SPOCK );
		addEdge( SPOCK, "vaporizes", ROCK );
		addEdge( ROCK, "crushes", SCISSORS );
	}
}
