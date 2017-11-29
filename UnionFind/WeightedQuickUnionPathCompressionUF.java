package com.algo.UnionFind;

//optimal union find implementation, both find and union operations
//are nearly amortized O(1) 
public class WeightedQuickUnionPathCompressionUF {
	private int[] id;
	private int[] size;
	private int count;
	public WeightedQuickUnionPathCompressionUF(int N) {
		count = N;
		id = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		if(id[p] == p) {
			return p;
		}
		return id[p] = find(id[p]);
	}
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if(pId != qId) {
			if(size[pId] < size[qId]) {
				id[pId] = qId;
				size[qId] += size[pId];
			}
			else {
				id[qId] = pId;			
				size[pId] += size[qId];
			}
			count--;
		}
	}
	//Return the number of vertices of the connected component that contains p
	public int componentSize(int p) {
		return size[find(p)];
	}
}
