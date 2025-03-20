class Leetcode_CommomMax
{
   public int maxPoints(int[][] points)
   {
       if(points.length==1||points.length==2)
         return points.length;
        int max=0,c,i,j,k,m0,m;
        //Checking for the maximum points connected by tilted and perpendicular lines 
        for(i=0;i<points.length-2;i++)
        {
            for(j=i+1;j<points.length-1;j++)
            { 
                c=2;  
                if(points[j][0]!=points[i][0])
                {
                    m0=(points[j][1]-points[i][1])/(points[j][0]-points[i][0]);
                
                    for(k=j+1;k<points.length;k++)
                    {
                        if(points[k][0]>points[j][0])
                        {
                          m=(points[k][1]-points[j][1])/(points[k][0]-points[j][0]);
                          if(m0==m)
                           c++;
                        }
                    }
                    if(c>max)
                       max=c;
                }
            }
        }
        //Checking for the maximum points connected by a parallel line
        c=0;
        for(i=0;i<points.length-1;i++)
        {
             for(j=i+1;j<points.length;j++)
             {
                  if(points[i][0]==points[j][0])
                    c++;
             }
             if(c>max)
               max=c;
        }
        return max;
   }
}