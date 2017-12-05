package com.algo.UndirectedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UndirectedGraph2 {
	private int V;
	private int E;
	private HashMap<Integer, Set<Integer>> vertices;
	public UndirectedGraph2() {
		V = 0;
		E = 0;
		vertices = new HashMap<>();
	}
	public void addVertex(int v) {
		if(!vertices.containsKey(v)) {
			vertices.put(v, new HashSet<Integer>());
			V++;
		}
	}
	public void addEdge(int v, int w) {
		addVertex(v);
		addVertex(w);
		if(vertices.get(v).add(w)) {
			vertices.get(w).add(v);
			E++;			
		}
	}
	public void removeVertex(int v) {
		if(vertices.containsKey(v)) {
			for(int w : vertices.get(v)) {
				removeEdge(w, v);
			}
			vertices.remove(v);
			V--;
		}
	}
	public void removeEdge(int v, int w) {
		if(vertices.containsKey(v) && vertices.containsKey(w)) {
			if(vertices.get(v).remove(w)) {
				vertices.get(w).remove(v);
				E--;
			}
		}
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
	public Set<Integer> adj(int v) {
		return new HashSet<Integer>(vertices.get(v));
	}
	public Set<Integer> getAllVertices() {
		return new HashSet<Integer>(vertices.keySet());
	}
}
