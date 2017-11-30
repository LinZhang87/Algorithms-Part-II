package com.algo.UndirectedGraph;

import java.util.Stack;
import edu.princeton.cs.algs4.Queue;

public class BfsPaths implements Paths {
	private boolean marked[];
	private int edgeTo[];
	private final int sourceVertex;
	
	public BfsPaths(UndirectedGraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		sourceVertex = s;
		bfs(G, s);
	}
	private void bfs(UndirectedGraph G, int v) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(v);
		marked[v] = true;
		while(!queue.isEmpty()) {
			int curr = queue.dequeue();
			for(int w : G.adj(curr)) {
				if(!marked[w]) {
					marked[w] = true;
					edgeTo[w] = curr;
					queue.enqueue(w);
				}
			}
		}
	}
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v) {
		if(!marked[v]) {
			return null;			
		}
		Stack<Integer> path = new Stack<Integer>();
		int curr = v;
		while(curr != sourceVertex) {
			path.push(curr);
			curr = edgeTo[curr];
		}
		path.push(sourceVertex);
		return path;
	}
}
