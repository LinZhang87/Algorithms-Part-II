package com.algo.UndirectedGraph;
import com.algo.UnionFind.WeightedQuickUnionPathCompressionUF;

public class UnionFindSearch implements Search{
	private WeightedQuickUnionPathCompressionUF uf;
	private int sourceVertex;
	
	public UnionFindSearch(UndirectedGraph G, int s) {
		sourceVertex = s;
		uf = new WeightedQuickUnionPathCompressionUF(G.V());
		for(int v = 0; v < G.V(); v++) {
			for(Integer neighbor : G.adj(v)) {
				uf.union(v, neighbor);
			}
		}
	}
	public boolean marked(int v) {
		return uf.connected(sourceVertex, v);
	}
	//Return the number of vertices that are connected to source vertex s
	//s is not considered to be connected with itself, hence -1
	public int count() {
		return uf.componentSize(sourceVertex) - 1;
	}
}
