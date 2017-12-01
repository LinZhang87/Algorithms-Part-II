package com.algo.UndirectedGraph;

public class DfsCycleDetection {
	private boolean hasCycle = false;
	private boolean[] marked;
	public DfsCycleDetection(UndirectedGraph G) {
		marked = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				dfs(G, s, s);
			}
		}
	}
	private void dfs(UndirectedGraph G, int v, int upStream) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w, v);
			}
			else if(w != upStream) {
				hasCycle = true;
				
			}
		}
	}
	public boolean hasCycle() {
		return hasCycle;
	}
}
