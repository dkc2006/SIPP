package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        int v = 8;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Creation of a graph

        // [1,2]
        // Source, Destination, Weight......
        int m = 1, n = 2, w = 1;
        adj.get(m).add(new Pair(n, w)); // Directed weighted edge
        // adj.get(n).add(new Pair(m, w)); // undirected edge

        // [1,3]
        adj.get(1).add(new Pair(3, 1));
        // [1,7]
        adj.get(1).add(new Pair(7, 1));
        // [2,4]
        adj.get(2).add(new Pair(4, 1));
        // [2,5]
        adj.get(2).add(new Pair(5, 1));
        // [3,6]
        adj.get(3).add(new Pair(6, 1));

        // Logic of Dijkstra's Algorithm
        int start = 1;
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.weight;

            for (Pair nbr : adj.get(u)) {
                int vNode = nbr.node;
                int wt = nbr.weight;
                if (dist[u] + wt < dist[vNode]) {
                    dist[vNode] = dist[u] + wt;
                    pq.add(new Pair(vNode, dist[vNode]));
                }
            }
        }

        // Print the shortest distances from start node
        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Node " + i + ": INF");
            } else {
                System.out.println("Node " + i + ": " + dist[i]);
            }
        }
    }

    // Pair class banayi gyi hai weight ke liye + Comparable for PriorityQueue
    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight; // Ascending order by weight
        }
    }
}
