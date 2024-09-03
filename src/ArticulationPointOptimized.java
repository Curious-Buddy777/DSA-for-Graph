import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPointOptimized {
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
            int steps=0;int[] discoveryTime=new int[n];Arrays.fill(discoveryTime,NO_RANK);
            depthFirstSearch(adjList,0,steps,discoveryTime);
        }
        private final int NO_RANK=-2;
        int depthFirstSearch(List<Integer>[] graph,int current,int steps,int[] discoveryTime)
        {
            if(discoveryTime[current]!=NO_RANK)return discoveryTime[current];
            int children=0;
            int minRank=steps=discoveryTime[current];
            for(final int next : graph[current])
            {
                if(discoveryTime[next]+1==discoveryTime[current])continue;
                int nextRank=depthFirstSearch(graph,next,steps+1,discoveryTime);
                nextRank=Math.min(nextRank,minRank);
                if(discoveryTime[current]<=nextRank&&current!=0)articulationPoint[current]=true;
                children++;
            }
            if(children>1&&current==0)articulationPoint[current]=true;
            discoveryTime[current]= graph.length;
            return minRank;
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
