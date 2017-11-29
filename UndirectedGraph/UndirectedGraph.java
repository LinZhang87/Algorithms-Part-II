package com.algo.UndirectedGraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class UndirectedGraph {
	private final int V;	//number of vertices
	private int E;	//number of edges
	private Bag<Integer>[] adj;	//adjacency lists
	public UndirectedGraph(int V) {
		this.V = V;
		this.E = 0;
		for(int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	public UndirectedGraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++) {
			//add an edge
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public void addEdge(int v, int w) {
		adj[v].add(w);	//add w to v's list
		adj[w].add(v);	//add v to w's list
		E++;
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
 }
