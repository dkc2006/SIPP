package graph;

import java.util.*;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        int v = 8;

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u, v, weight) – undirected
        addEdge(adj, 1, 4, 2);
        addEdge(adj, 1, 3, 1);
        addEdge(adj, 1, 2, 5);
        addEdge(adj, 2, 3, 3);
        addEdge(adj, 2, 4, 6);
        addEdge(adj, 2, 1, 5);

        // Step 2: Initialize visited array and priority queue
        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(); // Edge: (u, v, weight)
        pq.add(new Edge(1, -1, 0)); // Start from node 1, parent -1

        int mstWeight = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();

        // Step 3: Prim's main loop
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.u;

            if (visited[u]) continue;

            visited[u] = true;
            if (curr.v != -1) {
                mstEdges.add(curr);
                mstWeight += curr.weight;
            }

            for (Pair neighbor : adj.get(u)) {
                if (!visited[neighbor.vertex]) {
                    pq.add(new Edge(neighbor.vertex, u, neighbor.weight));
                }
            }
        }

        // Output the MST
        System.out.println("Edges in MST:");
        for (Edge e : mstEdges) {
            System.out.println(e.v + " - " + e.u + " : " + e.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w)); // undirected
    }

    // Edge class for MST result (u: current, v: parent, weight)
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Pair class for adjacency list (vertex, weight)
    static class Pair {
        int vertex, weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
