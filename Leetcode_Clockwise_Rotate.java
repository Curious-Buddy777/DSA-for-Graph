class Leetcode_Clockwise_Rotate
{
   public void rotate(int[][] matrix)
   {
       int i,j,t;
       //Transpose of a matrix
       for(i=0;i<matrix.length;i++)
       {
            for(j=0;j<matrix.length;j++)
            {
                 t=matrix[i][j];   matrix[i][j]=matrix[j][i];   matrix[j][i]=t;
            }
       }
       //Mirroring the matrix
       int m=matrix.length;
       int end=m-1;
       for(i=0;i<m;i++)
       {
           for(j=0;j<m/2;j++)
           {
                t=matrix[i][j];
                matrix[i][j]=matrix[i][end];
                matrix[i][end]=t;
           }
           end--;
       }
       for(i=0;i<m;i++)
       {
          for(j=0;j<m;j++)
          {
              System.out.print(matrix[i][j]+" ");  
          }
          System.out.println();
       }
   }
}