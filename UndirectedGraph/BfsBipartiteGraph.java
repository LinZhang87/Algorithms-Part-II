package com.algo.UndirectedGraph;
import edu.princeton.cs.algs4.Queue;

public class BfsBipartiteGraph {
	private boolean[] marked;
	private boolean[] color;
	private boolean isBipartite = true;
	
	public BfsBipartiteGraph(UndirectedGraph G) {
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++) {
			bfs(G, s);
		}
	}
	private void bfs(UndirectedGraph G, int v) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(v);
		marked[v] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.dequeue();
			for(int w : G.adj(curr)) {
				if(!marked[w]) {
					color[w] = !color[v];
					marked[w] = true;
					queue.enqueue(w);
				}
				else if(color[v] == color[w]) {
					isBipartite = false;
					return;
				}
			}
		}
	}
	public boolean isBipartite() {
		return isBipartite;
	}
}
