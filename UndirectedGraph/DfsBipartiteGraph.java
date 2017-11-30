package com.algo.UndirectedGraph;

public class DfsBipartiteGraph {
	private boolean[] marked;
	private boolean[] color;
	private boolean isBipartite = true;
	
	public DfsBipartiteGraph(UndirectedGraph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				dfs(G, s);
			}
		}
	}
	private void dfs(UndirectedGraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				color[w] = !color[v];
				dfs(G, w);
			}
			else if(color[w] == color[v]) {
				isBipartite = false;
			}
		}
	}
	public boolean isBipartite() {
		return isBipartite;
	}
}
