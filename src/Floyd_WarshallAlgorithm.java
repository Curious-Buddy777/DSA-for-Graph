import java.util.Scanner;
public class Floyd_WarshallAlgorithm
{
    public void floydShortestPath(double[][] graph,int[][] next)
    {
        int l= graph.length;
        for(int i=l-1;i>=0;i--)
        {
            for(int j=0;j<l;j++)
            {
                for(int k=0;k<l;k++)
                {
                    if(graph[j][k]>graph[j][i]+graph[i][k])
                    {
                        graph[j][k]=graph[j][i]+graph[i][k];
                        next[j][k]=i;
                    }
                }
            }
        }
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l;j++)
            {
                for(int k=0;k<l;k++)
                {
                    if(graph[j][k]>graph[j][i]+graph[i][k])
                    {
                        graph[j][k]=Double.NEGATIVE_INFINITY;
                        next[j][k]=-1;
                    }
                }
            }
        }
    }
    void createGraph(double[][] g1,int[][] g2)
    {
        int l=g1.length;
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l;j++)
            {
                if(g1[i][j]==0&&i!=j)
                {
                    g1[i][j]=Double.POSITIVE_INFINITY;
                }
                g2[i][j]=j;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int start,end;
//        double[][] graph={
//                {0,5,1,0,0,0},
//                {0,0,2,3,20,0},
//                {0,3,0,0,12,0},
//                {0,0,3,0,2,6},
//                {0,0,0,0,0,1},
//                {0,0,0,0,0,0}};
        double[][] graph={{0,8,1,0},
                {0,0,0,0},
                {0,6,0,1},
                {0,1,0,0}};
        int[][] next=new int[4][4];
        Floyd_WarshallAlgorithm obj=new Floyd_WarshallAlgorithm();
        obj.createGraph(graph,next);
        System.out.print("Enter the Starting point : ");
        start=in.nextInt();
        System.out.print("Enter the ending number : ");
        end=in.nextInt();
        obj.floydShortestPath(graph,next);
        for(int at=start;at!=end;at=next[at][end])System.out.print(at+"->");
        System.out.println(end);
        System.out.print("The Shortest distance is : "+graph[0][1]);
    }
}
