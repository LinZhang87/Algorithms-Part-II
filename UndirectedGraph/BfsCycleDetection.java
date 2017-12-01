package com.algo.UndirectedGraph;
import edu.princeton.cs.algs4.Queue;

public class BfsCycleDetection {
	private boolean hasCycle = false;
	private boolean[] marked;	
	public BfsCycleDetection(UndirectedGraph G) {
		marked = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++) {
			if(!marked[s]) {
				bfs(G, s);				
			}
		}
	}
	private void bfs(UndirectedGraph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		Queue<Integer> upStream = new Queue<Integer>();
		queue.enqueue(s);
		upStream.enqueue(null);
		marked[s] = true;
		while(!queue.isEmpty()) {
			int currVertex = queue.dequeue();
			int parent = upStream.dequeue();
			for(int w : G.adj(currVertex)) {
				if(!marked[w]) {
					queue.enqueue(w);
					upStream.enqueue(currVertex);
					marked[w] = true;
				}
				else if(w != parent) {
					hasCycle = true;
				}
			}
		}
	}
	public boolean hasCycle() {
		return hasCycle;
	}
}
