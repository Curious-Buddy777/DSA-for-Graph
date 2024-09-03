import java.util.*;
public class SSR
{
    boolean[] visited;
    public static class Edge
    {
        int to,weight;
        Edge(int t,int w)
        {
            this.to=t;
            this.weight=w;
        }
    }
    Stack<Integer> topSort(Map<Integer,List<Edge>> graph)
    {
        int l= graph.size();
        visited=new boolean[l];
        Arrays.fill(visited,Boolean.FALSE);
        Stack<Integer> topo=new Stack<>();
        Set<Integer> klist=graph.keySet();
        for(Integer keys : klist)
        {
            if(!visited[keys])
            {
                dfs(graph,topo,keys,visited);
            }
        }
        return topo;
    }
    void dfs(Map<Integer,List<Edge>> graph,Stack<Integer> topo,int keys,boolean[] visited)
    {
        System.out.println("At the node : "+keys);
        visited[keys]=Boolean.TRUE;
        List<Edge> list=graph.get(keys);
        for(Edge e : list)
        {
            //System.out.println("Next node : "+e.to);
            if(!visited[e.to])
            {
                System.out.println("Next node : "+e.to);
                dfs(graph,topo,e.to,visited);
            }
        }
        topo.push(keys);
        System.out.println("Pushed "+keys+" into the stack.");
    }
    Map<Integer,List<Edge>> matrixToAdjList(int[][] graph)
    {
        int i,j,l= graph.length;
        Map<Integer,List<Edge>> newGraph=new HashMap<>(l);
        List<Edge> branches;
        for(i=0;i<l;i++)
        {
            branches=new ArrayList<>(l);
            for(j=0;j<l;j++)
                if(graph[i][j]!=0)
                    branches.add(new Edge(j,graph[i][j]));
            newGraph.put(i,branches);
        }
        return newGraph;
    }
    List<List<Edge>> adjListForFlight(int[][] flights,int n)
    {
        List<List<Edge>> graph=new ArrayList<>(n);
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for (int[] flight : flights)
            graph.get(flight[0]).add(new Edge(flight[1], flight[2]));
        return graph;
    }
    public int findCheapestPrice(int n,int[][] flights,int src,int des,int k)
    {
        //We need to create the viited array
        int sum=1,limit,step,i;
        List<List<Edge>> adjList=adjListForFlight(flights,n);
        int[] price=new int[n];
        Arrays.fill(price,-1);
        price[src]=0;
        Queue<Integer> nodes=new LinkedList<>();
        nodes.add(src);
        while(true)
        {
            limit=sum;
            sum=0;
            while(limit--!=0)
                sum+=subchild(adjList, nodes.poll(), nodes,price);
            if(k--==0)
                break;
        }
        for(int p:price)
            System.out.print(p+" , ");
        return price[des];
    }
    public int subchild(List<List<Edge>> adjList,int src,Queue<Integer> nodes,int[] price)
    {
        List<Edge> toNodes=adjList.get(src);
        for(Edge e : toNodes)
        {
            System.out.println("Current weight : "+(price[src]+e.weight));
            if(price[e.to]==-1||((price[src]+e.weight)<price[e.to]&&price[e.to]!=-1)) {
                price[e.to] = price[src] + e.weight;
                System.out.println("Updated price : "+price[e.to]);
            }
            System.out.println("pushing "+(e.to)+" into the Queue. ");
            nodes.add(e.to);
        }
        return toNodes.size();
    }
    public static void main(String[] args)
    {
//        int[][] gr= {{0,3,6,0,0,0,0,0},
//                     {0,0,4,4,11,0,0,0},
//                     {0,0,0,8,0,0,11,0},
//                     {0,0,0,0,-4,5,2,0},
//                     {0,0,0,0,0,0,0,9},
//                     {0,0,0,0,0,0,0,1},
//                     {0,0,0,0,0,0,0,2},
//                     {0,0,0,0,0,0,0,0}};
//        int[][] gr={
//                {0,1,1,0,0,0},
//                {0,0,0,0,0,0},
//                {0,0,0,1,1,0},
//                {0,0,0,0,0,1},
//                {0,1,0,0,0,0},
//                {0,0,0,0,1,0}
//        };
        SSR obj=new SSR();
        System.out.println("Answer : "+obj.findCheapestPrice(4,new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}},0,3,1));
    }
}