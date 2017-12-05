/*
 * Eulerian path and tour for undirected graph 
 * Eulerian Path is a path in graph that visits every edge exactly once.
 * Eulerian Tour is an eulerian path which starts and ends on the same vertex.
 * 
 * Eulerian Cycle
 * An undirected graph has eulerian cycle if the following two conditions are true.
 * 1. all vertices with non-zero degree are connected.
 * 2. all vertices have even degree.
 * 
 * Eulerian Path
 * An undirected graph has eulerian path if the following two conditions are true.
 * 1. all vertices with non-zero degree are connected.
 * 2. if zero or two vertices have odd degree and all other vertices have even degree. Note
 * that only one vertex with odd degree is not possible in an undirected graph because the sum
 * of all degrees is always even in an undirected graph.
 * 
 * Fleury's Algorithm for getting Eulerian Path or Tour
 * 1. Check if the given graph is eulerian.
 * 2. If not, return null; else if there are 2 vertices with odd degree, then pick one of them
 * 	  as the start vertex; if there are 0 vertices with odd degree, start anywhere.
 * 3. Follow edges one at a time. If you have a choice between a bridge and a non-bridge, always choose 
 *    the non-bridge.
 * 4. Stop when you run out of edges.
 * The idea is, “don’t burn bridges“ so that we can come back to a vertex and traverse remaining edges.
 * 
 * Runtime: 
 * Reference: http://www.geeksforgeeks.org/fleurys-algorithm-for-printing-eulerian-path/
 */


package com.algo.UndirectedGraph;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import edu.princeton.cs.algs4.Queue;

public class Eulerian {
	private boolean isEulerian;
	private boolean hasEulerianTour;
	private Set<Integer> visited;
	private int pathStartVertex = -1;
	private int tourStartVertex = -1;
	private class Edge {
		int v1;
		int v2;
		Edge(int v1, int v2) {
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	public Eulerian(UndirectedGraph2 G) {
		visited = new HashSet<Integer>();
		int ret = checkEulerian(G);
		isEulerian = (ret != 0 ? true: false);
		hasEulerianTour = (ret == 2 ? true: false);
	}
	private void dfs(UndirectedGraph2 G, int s) {
		visited.add(s);
		for(int w : G.adj(s)) {
			if(!visited.contains(w)) {
				dfs(G, w);
			}
		}
	}
	private boolean isConnected(UndirectedGraph2 G) {
		int s = 0;
		int count = 0;
		for(int v : G.getAllVertices()) {
			if(G.adj(v).size() != 0) {
				s = v;
				break;
			}
			count++;
		}
		//all vertices have 0 degree
		if(count == G.V()) {
			return true;
		}
		dfs(G, s);
		for(int v : G.getAllVertices()) {
			if(G.adj(v).size() != 0 && !visited.contains(v)) {
				return false;
			}
		}
		return true;
	}
	private int checkEulerian(UndirectedGraph2 G) {
		//check if all non-zero degree vertices are connected 
		if(!isConnected(G)) {
			return 0;
		}
		//count vertices with odd degree
		int odd = 0;	
		for(int v : G.getAllVertices()) {
			if(G.adj(v).size() % 2 != 0) {
				if(pathStartVertex == -1) {
					pathStartVertex = v;					
				}
				odd++;
			}
			else if(G.adj(v).size() != 0 && tourStartVertex == -1) {
				tourStartVertex = v;
			}
		}
		if(odd > 2) {
			pathStartVertex = -1;
			tourStartVertex = -1;
			return 0;
		}
		return odd == 2 ? 1 : 2;
	}
	
	public boolean isEulerian() {
		return isEulerian;
	}
	public boolean hasEulerianTour() {
		return hasEulerianTour;
	}
	private int bfsCount(UndirectedGraph2 G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.enqueue(s);
		visited.add(s);
		
		while(!queue.isEmpty()) {
			int curr = queue.dequeue();
			for(int w : G.adj(curr)) {
				if(!visited.contains(w)) {
					queue.enqueue(w);
					visited.add(w);
				}
			}
		}
		return visited.size();
	}
	private boolean isValidPath(UndirectedGraph2 G, int v, int w) {
		if(G.adj(v).size() == 1) {
			return true;
		}
		int count1 = bfsCount(G, v);
		G.removeEdge(v, w);
		int count2 = bfsCount(G, v);
		G.addEdge(v, w);
		return count1 > count2 ? false : true;
	}
	private void getEulerianPathHelper(UndirectedGraph2 G, List<Edge> path, int v) {
		if(G.E() == 0) {
			return;
		}
		for(int w : G.adj(v)) {
			if(isValidPath(G, v, w)) {
				path.add(new Edge(v, w));
				G.removeEdge(v, w);
				getEulerianPathHelper(G, path, w);
			}
		}
	}
	public List<Edge> getEulerianPath(UndirectedGraph2 G) {
		if(!isEulerian() || (hasEulerianTour() && tourStartVertex == -1)) {
			return null;
		}
		int startVertex = hasEulerianTour ? tourStartVertex : pathStartVertex;
		List<Edge> path = new ArrayList<Edge>();
		getEulerianPathHelper(G, path, startVertex);
		return path;
	}
}
