package com.algo.UndirectedGraph;

public class DfsConnectedComponents implements ConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;		//number of different connected components 
	
	public DfsConnectedComponents(UndirectedGraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}
	private void dfs(UndirectedGraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	public int count() {
		return count;
	}
	public int id(int v) {
		return id[v];
	}
}
