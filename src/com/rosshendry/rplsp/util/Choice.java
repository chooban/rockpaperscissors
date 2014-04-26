package com.rosshendry.rplsp.util;

public enum Choice {
	ROCK, PAPER, LIZARD, SCISSORS, SPOCK;

	public static Choice parseString( String s ) {
		for ( Choice v : values() ) {
			if ( v.name().equalsIgnoreCase( s ) ) {
				return v;
			}
		}
		return null;
	}
}
