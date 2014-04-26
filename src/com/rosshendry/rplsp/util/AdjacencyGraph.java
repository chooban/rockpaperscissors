package com.rosshendry.rplsp.util;

import java.util.HashMap;
import java.util.Map;

public class AdjacencyGraph<T> {

	private Map<T, Map<T,String>> adjacencies;
	
	@SafeVarargs
	public AdjacencyGraph( T... vertices ) {
		adjacencies = new HashMap<>( vertices.length );
		for ( T t : vertices ) {
			adjacencies.put( t, new HashMap<>( vertices.length ) );
		}
	}
	
	public void addEdge( T a , String meta , T b  ) {
		Map<T,String> currentEdges = adjacencies.get( a );
		
		if ( currentEdges.containsKey( b ) ) {
			throw new IllegalArgumentException( "Edge already defined" );
		}
		currentEdges.put( b, meta );
	}
	
	public String getEdge( T a, T b ) {
		return adjacencies.get( a ).get( b );
	}
	
	public Map<T, String> getEdges( T a ) {
		return adjacencies.get( a );
	}
}
