import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class ShortestDistance
{
    Queue<int[]> queue=new LinkedList<>();
    int[] dr={+1,-1,0,0};
    int[] dc={0,0,+1,-1};
    boolean[][] visited=new boolean[6][6];
//    boolean[][] path(int r,int c,char[][] d,boolean[][] v)
//    {
//        v[r][c]=Boolean.TRUE;
//        if(d[r][c]=='E')
//            return v;
//        int i,branch=neighbours(r,c,d);
//        for(i=0;i<branch;i++)
//        {
//            int[] a=queue.poll();
//            return path(a[0],a[1],d,v);
//
//        }
//    }
    int steps_Count(int row,int col,char[][] dung_Maze)
    {
        int[] coor;
        int limit,i,steps_count=0,flag=-1,sum;
        visited[row][col]=Boolean.TRUE;
        sum=neighbours(row,col,dung_Maze);
        while(!queue.isEmpty())
        {
            limit=sum;
            sum=0;
            steps_count++;
            for(i=0;i<limit;i++)
            {
                coor=queue.poll();
                sum+=neighbours(coor[0] ,coor[1],dung_Maze);
                if(dung_Maze[coor[0]][coor[1]]=='E')
                {
                    flag=1;
                    break;
                }
            }
            if (flag==1)
            {
                break;
            }
        }
        return steps_count;
    }
    boolean isValid(int r,int c,char[][] d)
    {
        if(r>=0&&c>=0&&r<d.length&&c<d[0].length)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    int neighbours(int r,int c,char[][] d)
    {
        int i,subchild=0;
        for(i=0;i<4;i++)
        {
            if(isValid(r+dr[i], c+dc[i], d)&&
                    (d[r+dr[i]][c+dc[i]]!='#')&&
                    (visited[r+dr[i]][c+dc[i]]==Boolean.FALSE))
            {
                queue.add(new int[]{r+dr[i],c+dc[i]});
                visited[r+dr[i]][c+dc[i]]=Boolean.TRUE;
                subchild+=1;
            }
        }
        return subchild;
    }
    
    public static void main(String[] args)
    {
        ShortestDistance obj=new ShortestDistance();
        char[][] dung_Maze =
                      { { '.', '.', '.', '#', '.', '.' },
                        { '.', '.', '.', '.', '#', '.' },
                        { '.', '#', '.', '.', '.', '.' },
                        { '.', '#', '.', '.', '.', '.' },
                        { '.', '.', '#', '#', '.', '.' },
                        { '#', '.', '#', 'E', '.', '#' } };
        for(boolean[] row: obj.visited)
        {
            Arrays.fill(row,Boolean.FALSE);
        }
        int e=obj.steps_Count(4,5,dung_Maze);
        System.out.println("The Number of steps : "+e);
    }
}
