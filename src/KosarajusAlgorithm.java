import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgorithm {
    //The List to store the strongly connected components
    List<List<Integer>> answer = new ArrayList<>();
    Stack<Integer> order=new Stack<>();
    private void dfs(List<Integer>[] graph,int current,boolean[] visited)
    {
        visited[current]=true;
        for(int i=0;i<graph[current].size();i++)
            if (!visited[graph[current].get(i)])
                dfs(graph, graph[current].get(i), visited);
        order.push(current);
    }
    private void kosaRaju(List<List<Integer>> graph,int v)
    {
        boolean[] visited=new boolean[v];Arrays.fill(visited,false);
        List<Integer>[] transpose=new List[v];
        List<Integer>[] adjList=new List[v];
        //Initializing the array
        for(int i=0;i<v;i++) {
            transpose[i] = new ArrayList<>();
            adjList[i]=new ArrayList<>();
        }
        System.out.println();
        //Creating the original and transpose of a graph
        for(List<Integer> row : graph) {
            transpose[row.get(1)].add(row.get(0));
            adjList[row.get(0)].add(row.get(1));
        }
        //Find the topological sorting
        for(int i=0;i<v;i++)
            if(!visited[i])
                dfs(adjList,i,visited);
        Arrays.fill(visited,false);
        int index=0,i;
        while(!order.isEmpty())
        {
            i=order.pop();
            if(!visited[i])
            {
                answer.add(index,new ArrayList<>());
                reversedfs(transpose,i,visited,index++);
            }
        }
    }
    private void reversedfs(List<Integer>[] graph,int current,boolean[] visited,int index)
    {
        visited[current]=true;
        answer.get(index).add(current);
        for(int i=0;i<graph[current].size();i++)
            if (!visited[graph[current].get(i)])
                reversedfs(graph, graph[current].get(i), visited, index);
    }
    public static void main(String[] args) {
        List<List<Integer>> graph=new ArrayList<>();
        graph.add(Arrays.asList(2,1));
        graph.add(Arrays.asList(1,0));
        graph.add(Arrays.asList(0,2));
        graph.add(Arrays.asList(0,3));
        graph.add(Arrays.asList(3,4));
        KosarajusAlgorithm obj=new KosarajusAlgorithm();
        obj.kosaRaju(graph,5);
        System.out.println("The List of connected components are : "+obj.answer);
    }
}
