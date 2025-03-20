class Leetcode_Merge_Intervals
{
   public int[][] merge(int[][] intervals)
   {
    if(intervals.length==1)
       return intervals;
                int i,j,c=0,num=0,past=intervals.length,now=0;
    while(past!=now)
    {
         for(i=0;i<intervals.length-1;i++)
        {
           if(intervals[i][0]!=-77&&intervals[i][1]!=-77)
           {
             for(j=0;j<intervals.length;j++)
             {
                 if(i==j)
                   j++;
                  if(intervals[i][1]==intervals[j][1]&&intervals[i][0]==intervals[j][0])
                  {
                         intervals[j][0]=-77;
                            intervals[j][1]=-77;
                  }
                   else if(intervals[i][1]==intervals[j][1])
                  {
                      
                            intervals[i][0]=(int)Math.min(intervals[i][0],intervals[j][0]);
                            intervals[j][0]=-77;
                            intervals[j][1]=-77; 
                        
                  }
                  
                  else if(intervals[i][0]==intervals[j][0])
                  {
                    
                          intervals[i][1]=(int)Math.max(intervals[i][1],intervals[j][1]);
                          intervals[j][0]=-77;
                          intervals[j][1]=-77; 
                      
                  }
                  else if(intervals[i][0]==intervals[j][1])
                  {
                      intervals[i][0]=intervals[j][0];
                      intervals[j][0]=-77;
                      intervals[j][1]=-77; 
                  }
                  else if(intervals[i][1]==intervals[j][0])
                  {
                      intervals[i][1]=intervals[j][1]; 
                      intervals[j][0]=-77;
                      intervals[j][1]=-77; 
                  }
                 else if(intervals[i][1]>intervals[j][0]&&intervals[i][0]<intervals[j][0])
                  {
                       intervals[i][0]=(int)Math.min(intervals[i][0],intervals[j][0]);
                       intervals[i][1]=(int)Math.max(intervals[i][1],intervals[j][1]);
                       intervals[j][0]=-77;
                       intervals[j][1]=-77; 
                  }
                  else if(intervals[j][1]>intervals[i][0]&&intervals[i][0]>intervals[j][0])
                  {
                       intervals[i][0]=(int)Math.min(intervals[i][0],intervals[j][0]);
                       intervals[i][1]=(int)Math.max(intervals[i][1],intervals[j][1]);
                       intervals[j][0]=-77;
                       intervals[j][1]=-77;
                  }
                 
             }
             
                 
                  
           }
           
        }
        past=now;  now=intervals.length;
    }
      for(i=0;i<intervals.length;i++)
     {
         if(intervals[i][0]!=-77&&intervals[i][1]!=-77)
         {
             c++;
         }
     }
     
     int a[][]=new int[c][2];
     for(i=0;i<intervals.length;i++)
     {
        if(intervals[i][0]!=-77&&intervals[i][1]!=-77)
         {
              a[num][0]=intervals[i][0];
              a[num++][1]=intervals[i][1];
         }
     }  
       return a;
   }
}