package com.algo.UndirectedGraph;

public interface Search {
	public boolean marked(int v);	//is v connected to source vertex s
	public int count();	// how many vertices are connected to s
}
