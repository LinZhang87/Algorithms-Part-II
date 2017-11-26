package com.algo.UnionFind;

public class QuickUnionUF {
	private int[] id;
	private int count;
	public QuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	//O(1) find
	public int find(int p) {
		while(p != id[p]) {
			p = id[p];
		}
		return p;
	}
	//improvement upon quick find, worst case runtime is still O(n)
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		if(pId != qId) {
			id[qId] = pId;
			count--;
		}
	}	
}
