import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class BridgesInAGraph {
    List<List<Integer>> bridges=new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> graph) {
        if(graph.size()<3)return graph;
        boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);
        List<Integer>[] adjGraph=new List[n];
        for(int i=0;i<n;i++)
            adjGraph[i]=new ArrayList<>();

        for(List<Integer> edges : graph)
        {
            int a=edges.get(0),b=edges.get(1);
            adjGraph[a].add(b);
            adjGraph[b].add(a);
        }
        depthFirstSearch(-1,0,adjGraph,visited,1,new int[n],new int[n]);
        return bridges;
    }
    void depthFirstSearch(int backPointer, int frontPoint, List<Integer>[] graph, boolean[] visited, int step, int[] low,int[] discoveryTime)
    {
        low[frontPoint]=discoveryTime[frontPoint]=step++;
        visited[frontPoint]=true;
        for(Integer next: graph[frontPoint])
        {
            if(next==backPointer)continue;
            if(!visited[next]){
                depthFirstSearch(frontPoint,next,graph,visited,step,low,discoveryTime);
                low[frontPoint]=Math.min(low[frontPoint],low[next]);
                if(low[next]>discoveryTime[frontPoint])bridges.add(Arrays.asList(frontPoint,next));
            }
            else
            {
                low[frontPoint]=Math.min(low[frontPoint],discoveryTime[next]);
            }
        }
    }
}