/*
	Given an undirected graph and a number k, determine if the graph can be colored with at most k
	colors such that no two adjacent vertices of the graph are colored with the same color.
	This problem is NP-Complete
*/

package com.algo.UndirectedGraph;

public class GraphColoring {
	private int[] color;
	private boolean isKColorable;
	public GraphColoring(UndirectedGraph G, int k) {
		color = new int[G.V()];
		isKColorable = colorGraph(G, k, color, 0);
	}	
	private boolean colorGraph(UndirectedGraph G, int k, int[] color, int vertex) {
		//base case: if all vertices have been assigned a valid color, return true
		if(vertex == G.V()) {
			return true;
		}
		for(int c = 1; c <= k; c++) {
			if(isValidColor(G, c, color, vertex)) {
				color[vertex] = c;
				if(colorGraph(G, k, color, vertex + 1)) {
					return true;
				}
				//assigning color c does not lead to a solution, backtrack to uncolored 0
				color[vertex] = 0;
			}
		}
		return false;
	}
	private boolean isValidColor(UndirectedGraph G, int c, int[] color, int vertex) {
		for(int w : G.adj(vertex)) {
			if(color[w] == c) {
				return false;
			}
		}
		return true;
	}
	public boolean isKColorable() {
		return isKColorable;
	}
}
