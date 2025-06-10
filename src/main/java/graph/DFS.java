package graph;

import java.util.ArrayList;

public class DFS {
    static void dfs(int curr, ArrayList<ArrayList<Integer>> adj){
        System.out.print(curr +" ");
        for(int nbr:adj.get(curr)){
            dfs(nbr,adj);
        }
    }
    public static void main(String[] args) {
        int v = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        // Creation of a graph

//        [1,2]
        int m = 0, n = 2;
        adj.get(m).add(n); //Directed edge
//        adj.get(n).add(m); // undirected edge
        // [0,3]
        adj.get(0).add(3);
        // [0,4]
        adj.get(0).add(4);
        // [2,6]
        adj.get(2).add(6);
        // [2,5]
        adj.get(2).add(5);
        // [3,1]
        adj.get(3).add(1);

//        Logic of DFS
           int start =0;
           dfs(start,adj);

    }
}
