import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazePath
{
    int steps_count = 0, in, column, Nodes_In_A_Level=0,sum=0;
    char[][] dung_Maze =
            {{ '.', '.', '.', '#', '.', '.' },
            { '.', '.', '.', '.', '#', '.' },
            { '.', '#', '.', '.', '.', '.' },
            { '.', '#', '.', '.', '.', '.' },
            { '.', '.', '#', '#', '.', '.' },
            { '#', '.', '#', 'E', '.', '#' } };
    boolean[][] visited = new boolean[6][6];
    int[] dr = { -1, +1, 0, 0 };
    int[] dc = { 0, 0, +1, -1 };
    List<Integer> rCoor=new ArrayList<>();
    List<Integer> cCoor=new ArrayList<>();
    boolean isValid(int r, int c)
    {
        //Checks if the passed coordinate is True or False
        if (r >= 0 && c >= 0 && r < dung_Maze.length && c < dung_Maze[0].length)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    void neighbours(int r, int c)
    {
        //This Calculates all the possible boxes for the next Step
        MazePath t = new MazePath();
        int i;
        //System.out.println("Pushing the neighbours of ("+r+","+c+")");
        for (i = 0; i < 4; i++) {
            if (t.isValid(r + dr[i], c + dc[i])&&
                    (visited[r + dr[i]][c + dc[i]]==Boolean.FALSE)&&
                    (dung_Maze[r + dr[i]][c + dc[i]]!='#')) {
                rCoor.add(r+dr[i]);
                cCoor.add(c+dc[i]);
                Nodes_In_A_Level+=1;
                visited[r + dr[i]][c + dc[i]]=Boolean.TRUE;
                //System.out.print("("+(r+dr[i])+","+(c+dc[i])+")");
            }
        }
        //System.out.println("/n");
    }
    void Steps_Count(int row, int col)
    {
        //Storing how many coordinates in a level
        int limit,flag=0;
        //Creating a matrix all false marked
        for(boolean[] inr:visited)
        {
            Arrays.fill(inr,Boolean.FALSE);
        }
        //Marking the Starting Box True
        visited[row][col] = Boolean.TRUE;
        neighbours(row, col);
        //limit=Nodes_In_A_Level;
        while (!rCoor.isEmpty())
        {
            limit =Nodes_In_A_Level;
            Nodes_In_A_Level=0;
            //sum=0;
            steps_count++;
            System.out.println("This Loop will iterate "+(limit)+" times. ");
            for(in=0; in< limit; in++)
            {
                //Nodes_In_A_Level =0;
                int r = rCoor.get(0);
                rCoor.remove(0);
                int c = cCoor.get(0);
                cCoor.remove(0);
                neighbours(r,c);
                //sum+=Nodes_In_A_Level;
                System.out.print("Child of a Node =("+r+","+c+") is : "+Nodes_In_A_Level+" ( in="+in+")");
                if (dung_Maze[r][c] == 'E') {
                    return;
                }
            }
            System.out.println();
            //System.out.println("sum="+sum);

        }
    }
    public static void main(String[] args)
    {
        MazePath t = new MazePath();
        t.Steps_Count(0, 0);
        System.out.println("The no. of steps are : " + t.steps_count);
    }
}
