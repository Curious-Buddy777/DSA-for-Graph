import java.util.Stack;

public class TopologicalSort
{
    Stack<int[]> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    char[] order={'A','B','C','D','E','F'};
    void topSort(int[][] graph)
    {
        int r=0,c=0,i,l= graph.length;
        graph[0][0]=5;
        while(r!= l)
        {
            //System.out.print("Now At Node :"+order[r]+" \n");
            for(i=c;i< l;i++)
            {
                if(graph[r][i]==1)
                {
                    //System.out.print("Next Node :"+order[i]+" \n");
                    stack1.push(new int[]{r,i});
                    r=i;
                    i=0;
                }
            }
            if(!stack1.isEmpty())
            {
                //System.out.print("Iteration complete  At Node :"+order[r]+" \n");
                if(graph[r][r]!=5)
                {
                    graph[r][r]=5;
                    stack2.push(r);
                }
                int[] Coordinate =stack1.pop();
                r= Coordinate[0]; c= Coordinate[1]+1;
                //System.out.print("Backtracking to Node :"+order[r]+" \n");
            }
            else
            {
                stack2.push(r);
                for(i=r+1;i<l;i++)
                {
                    if(graph[i][i]!=5)
                    {
                        r=i;
                        break;
                    }
                }
                if(i==l)
                    break;
            }
        }
        //System.out.print("Outside the Loop...\n");
    }
    public static void main(String[] args)
    {
        TopologicalSort obj=new TopologicalSort();
        int[][] graph={
                {0,1,1,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,1},
                {0,1,0,0,0,0},
                {0,0,0,0,1,0}
        };
        obj.topSort(graph);
        for(int i=0;i< graph.length;i++)
        {
            int a=obj.stack2.pop();
            System.out.print(obj.order[a]+" , ");
        }
    }
}