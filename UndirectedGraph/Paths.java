package com.algo.UndirectedGraph;

public interface Paths {
	public boolean hasPathTo(int v);	// is there a path from s to v?
	public Iterable<Integer> pathTo(int v);	//path from s to v; null if no such path
}
