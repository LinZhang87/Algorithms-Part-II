package com.algo.UnionFind;

public class QuickFindUF {
	private int[] id;
	private int count;
	public QuickFindUF(int N) {
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
		return id[p];
	}
	//O(n) union
	public void union(int p, int q) {
		if(id[p] != id[q]) {
			for(int i = 0; i < id.length; i++) {
				if(id[i] == q) {
					id[i] = p;
				}
			}
			count--;
		}
	}
}
