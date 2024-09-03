import java.util.*;
public class Dijkstras_Algorithm
{
    public static class KeyValue implements Comparable<KeyValue>
    {
        private Integer coordinate;
        private Integer weight;

        public KeyValue(Integer coordinate, Integer weight)
        {
            this.coordinate = coordinate;
            this.weight = weight;
        }

        public Integer getCoordinate() {
            return coordinate;
        }
        public Integer getWeight() {
            return weight;
        }
        @Override
        public int compareTo(KeyValue o) {
            return Integer.compare(getWeight(),o.getWeight());
        }
    }
    Stack<Integer> path=new Stack<>();
    int dijkstraShortestPath(Map<Integer,List<SSR.Edge>> graph,int src,int des)
    {
        boolean[] visited=new boolean[graph.size()];
        Arrays.fill(visited,false);
        Queue<KeyValue> nodes=new PriorityQueue<>();
        int[] distance=new int[graph.size()];
        int[] prev=new int[graph.size()];
        Arrays.fill(prev,0);
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        nodes.add(new KeyValue(src,0));
        while(!nodes.isEmpty())
        {
            KeyValue currentKey =nodes.poll();
            if(visited[currentKey.coordinate]||distance[currentKey.coordinate]!=currentKey.weight)continue;
            visited[currentKey.coordinate]=true;
            List<SSR.Edge> toNodes=graph.get(currentKey.coordinate);
            for(SSR.Edge e : toNodes)
            {
                if(distance[currentKey.coordinate]+e.weight<distance[e.to])
                {
                    distance[e.to] = distance[currentKey.coordinate] + e.weight;
                    nodes.add(new KeyValue(e.to,distance[e.to]));
                    prev[e.to]= currentKey.coordinate;
                }
            }
        }
        if(distance[des]!=Integer.MAX_VALUE)
        {
            int from = des;
            while (true) {
                path.push(from);
                if (from == src) break;
                from = prev[from];
            }
        }
        return distance[des];
    }
    public static void main(String[] args)
    {
        int[][] g= {{0,5,1,0,0,0},
                    {0,0,2,3,20,0},
                    {0,3,0,0,12,0},
                    {0,0,3,0,2,6},
                    {0,0,0,0,0,1},
                    {0,0,0,0,0,0}};
        SSR obj=new SSR();
        Map<Integer,List<SSR.Edge>> graph=obj.matrixToAdjList(g);
        Dijkstras_Algorithm obj1=new Dijkstras_Algorithm();
        int distance=obj1.dijkstraShortestPath(graph,0,5);
        System.out.println("The Shortest path takes : "+distance+" steps.");
        System.out.println("The path to the shortest path is : ");
        while (!obj1.path.isEmpty())
            System.out.print(obj1.path.pop()+" , ");
        System.out.println();
    }
}