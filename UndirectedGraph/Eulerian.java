/*
 * Eulerian path and tour for undirected graph 
 * Eulerian Path is a path in graph that visits every edge exactly once.
 * Eulerian Tour is an eulerian path which starts and ends on the same vertex.
 * 
 * Eulerian Cycle
 * An undirected graph has eulerian cycle if the following two conditions are true.
 * 1. all vertices with non-zero degree are connected.
 * 2. all vertices have even degree.
 * 
 * Eulerian Path
 * An undirected graph has eulerian path if the following two conditions are true.
 * 1. all vertices with non-zero degree are connected.
 * 2. if zero or two vertices have odd degree and all other vertices have even degree. Note
 * that only one vertex with odd degree is not possible in an undirected graph because the sum
 * of all degrees is always even in an undirected graph.
 */


package com.algo.UndirectedGraph;
import java.util.List;

public class Eulerian {
	private boolean isEulerian;
	private boolean hasEulerianTour;
	
	public Eulerian(UndirectedGraph G) {
		
	}
	
	public boolean isEulerian() {
		return false;
	}
	
	public List<Integer> getEulerianPath() {
		return null;
	}
}
