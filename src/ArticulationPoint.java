import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint
{
    boolean[] articulationPoint;
    void getAP(int n, List<List<Integer>> graph)
    {
        articulationPoint=new boolean[n];
        List<Integer>[] adjList=new List[n];
        for(int i=0;i<n;i++)
            adjList[i]=new ArrayList<>();
        for(List<Integer> row : graph)
        {
            int a=row.get(0),b=row.get(1);
            adjList[a].add(b);
            adjList[b].add(a);
        }
        int steps=0;int[] discoveryTime=new int[n];int[] lowestDT=new int[n];boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);
        depthFirstSearch(adjList,-1,0,steps,discoveryTime,lowestDT,visited);
    }
    void depthFirstSearch(List<Integer>[] graph,int parent,int current,int steps,int[] discoveryTime,int[] lowestDT,boolean[] visited)
    {
        int children=0;
        visited[current]=true;
        discoveryTime[current]=lowestDT[current]=++steps;
        for(Integer next : graph[current])
        {
            if(next==parent)continue;
            if(!visited[next])
            {
                depthFirstSearch(graph,current,next,steps,discoveryTime,lowestDT,visited);
                lowestDT[current]=Math.min(lowestDT[current],lowestDT[next]);children++;
                if(discoveryTime[current]<=lowestDT[next]&&parent!=-1)articulationPoint[current]=true;
            }
            else lowestDT[current]=Math.min(lowestDT[current],discoveryTime[next]);
        }
        if(parent==-1&&children>1)articulationPoint[current]=true;
    }
    public static void main(String[] args) {
        List<List<Integer>> edges=new ArrayList<>(5);
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(0,5));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,1));
        edges.add(Arrays.asList(2,3));
        edges.add(Arrays.asList(2,4));
        edges.add(Arrays.asList(3,4));
        ArticulationPoint obj=new ArticulationPoint();
        obj.getAP(6,edges);
        for(int i=0;i<6;i++)
           System.out.println(obj.articulationPoint[i]);
    }
}
