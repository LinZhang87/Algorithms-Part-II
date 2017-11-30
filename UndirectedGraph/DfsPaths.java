package com.algo.UndirectedGraph;

import java.util.Stack;

public class DfsPaths implements Paths {
	private boolean[] marked;
	private int[] edgeTo;	//last vertex on known path to this vertex
	private final int sourceVertex;
	
	public DfsPaths(UndirectedGraph G, int s) {
		sourceVertex = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G, s);
	}
	private void dfs(UndirectedGraph G, int v) {
		marked[v] = true;
		for(Integer w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
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
