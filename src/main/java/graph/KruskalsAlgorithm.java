package graph;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {

    public static void main(String[] args) {
        int v = 8;

        // Step 1: Create a list of edges
        ArrayList<Edge> edges = new ArrayList<>();

        // Add edges (u, v, weight)
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 1));
        edges.add(new Edge(1, 7, 1));
        edges.add(new Edge(2, 4, 1));
        edges.add(new Edge(2, 5, 1));
        edges.add(new Edge(3, 6, 1));

        // Step 2: Sort edges by weight
        Collections.sort(edges);

        // Step 3: Initialize DSU
        DSU dsu = new DSU(v);

        int mstWeight = 0;
        ArrayList<Edge> mstEdges = new ArrayList<>();

        // Step 4: Kruskal's main logic
        for (Edge e : edges) {
            if (dsu.find(e.u) != dsu.find(e.v)) {
                dsu.union(e.u, e.v);
                mstWeight += e.weight;
                mstEdges.add(e);
            }
        }

        // Output the MST
        System.out.println("Edges in MST:");
        for (Edge e : mstEdges) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }

    // Edge class
    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight; // Ascending order
        }
    }

    // Disjoint Set Union (Union-Find) with path compression
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
