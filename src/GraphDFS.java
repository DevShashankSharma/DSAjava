import java.util.ArrayList; 

public class GraphDFS {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d , int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void create_Graph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[5].add(new Edge(6, 5, 1));
    }

    public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);

            if(vis[e.dest]==false){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;

        /*
              1 --- 3
             /      | \
           0        |   5 -- 6
             \      | /
              2 --- 4
        */
    
    
        ArrayList<Edge> graph[] = new ArrayList[V];
        create_Graph(graph);
        
        boolean Visited[] = new boolean[V];
        // for(int i=0 ; i<V ; i++){
        //     if(Visited[i] == false){
        //         dfs(graph, i, Visited);
        //     }  
        // }
        dfs(graph, 0, Visited);
        System.out.println();
    }
}
