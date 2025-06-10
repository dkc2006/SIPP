package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Creation of a graph

//        [1,2]
        int m = 1, n = 2;
        adj.get(m).add(n); //Directed edge
//        adj.get(n).add(m); // undirected edge
        // [1,3]
        adj.get(1).add(3);
        // [1,7]
        adj.get(1).add(7);
        // [2,4]
        adj.get(2).add(4);
        // [2,5]
        adj.get(2).add(5);
        // [3,6]
        adj.get(3).add(6);

        // Logic of BFS

        int start = 1;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int nbr : adj.get(curr)) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
        System.out.println();
    }
}
