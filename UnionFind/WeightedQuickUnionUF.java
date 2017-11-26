package com.algo.UnionFind;

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] size;
	private int count;
	public WeightedQuickUnionUF(int N) {
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
	//O(logN) find
	public int find(int p) {
		while(p != id[p]) {
			p = id[p];
		}
		return p;
	}
	//O(logN) union
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
}
