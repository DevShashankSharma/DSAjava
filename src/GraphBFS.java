import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GraphBFS {
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

    // Time Complexity = O(V+E)       V --> no. of vertex        E --> no. of edge
    public static void BFS(ArrayList<Edge> graph[] , int V){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i=0 ; i<graph[curr].size() ; i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // Time Complexity = O(V+E)       V --> no. of vertex        E --> no. of edge
    // when graph is divided into sub part then we can not access each vertex through one start;
    // for ex -->  1->2->3   4->5
    public static void subPartBFS(ArrayList<Edge> graph[] , int V , boolean visited[] , int start){
        Queue<Integer> q = new LinkedList<>(); 
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i=0 ; i<graph[curr].size() ; i++){
                    q.add(graph[curr].get(i).dest);
                }
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
        BFS(graph, V);
        System.out.println();


        boolean Visited[] = new boolean[V];
        for(int i=0 ; i<V ; i++){
            if(Visited[i] == false){
                subPartBFS(graph, V, Visited, i);
            }  
        }
        System.out.println();
    }
}
