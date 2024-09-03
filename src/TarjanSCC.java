import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
class TarjanSCC{
    Stack<Integer> ssc=new Stack<>();
    List<List<Integer>> answer=new ArrayList<>();
    boolean[] visited,onStack;
    int index=0;
    int[] rank,lowest;
    private void tarjanInitializer(List<List<Integer>> graph,int n){
        List<Integer>[] adjList=new List[n];
        lowest=new int[n];
        rank=new int[n];
        visited=new boolean[n];onStack=new boolean[n];
        Arrays.fill(visited,false);Arrays.fill(onStack,false);
        for(int i=0;i<n;i++)
            adjList[i]=new ArrayList<>();
        for(List<Integer> x : graph) {
            int a=x.get(0),b=x.get(1);
            adjList[a].add(b);
        }
        int steps=0;
        dfs(adjList,steps,0);
    }
    private void dfs(List<Integer>[] graph,int steps,int current){
        rank[current]=lowest[current]=steps++;
        visited[current]=true;
        ssc.push(current);
        onStack[current]=true;
        for(int next : graph[current]){
            if(!visited[next]){
                //System.out.println("Going to node : "+next+" with low value of node : "+current+" as "+lowest[current]);
                dfs(graph, steps, next);
                //System.out.println("Comparing min value of "+current+" node values, i.e. "+lowest[current]+" with the lowest of "+next+" node :"+lowest[next]);
                lowest[current]=Math.min(lowest[current],lowest[next]);
                //System.out.println("New min value of node "+current+" is : "+lowest[current]);
            }
            else if(onStack[next]){
                    lowest[current] = Math.min(lowest[current], rank[next]);
                    //System.out.println("Comparing min value of "+current+" node values, i.e. "+lowest[current]+" with the rank of "+next+" node :"+rank[next]);
                }
        }
        if(lowest[current]==rank[current]){
            int v=(int)ssc.pop();onStack[v]=false;
            answer.add(index,new ArrayList<>());
            List<Integer> s=new ArrayList<>();
            //System.out.println("Starting the popping of stack : "+current+" with "+v);
            while(v!=current){
                answer.get(index).add(v);
                v=(int)ssc.pop();
                onStack[v]=false;
                //System.out.print("Popped : "+v+", ");
            }
            answer.get(index++).add(v);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> g=new ArrayList<>();
        g.add(Arrays.asList(0,1));
        g.add(Arrays.asList(6,0));
        g.add(Arrays.asList(1,6));
        g.add(Arrays.asList(6,2));
        g.add(Arrays.asList(1,2));
        g.add(Arrays.asList(2,3));
        g.add(Arrays.asList(3,2));
        g.add(Arrays.asList(1,4));
        g.add(Arrays.asList(3,4));
        g.add(Arrays.asList(3,5));
        g.add(Arrays.asList(4,5));
        g.add(Arrays.asList(5,4));
        g.add(Arrays.asList(1,7));
        TarjanSCC obj=new TarjanSCC();
        obj.tarjanInitializer(g,8);
        System.out.println(obj.answer);
        System.out.println("The ranks are :");
        for(int r : obj.rank)
            System.out.print(r+" , ");
    }
}