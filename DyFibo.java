import java.util.Scanner;
public class DyFibo
{
    public static void main(String[] args)
    {
         Scanner in=new Scanner(System.in);
         int n,i,l=0,t,s=0,p,c=0;
         System.out.println("Enter the number");
         n=in.nextInt();
         System.out.println("Enter the element to be searched");
         p=in.nextInt();
         t=n;
         while(t!=0)
         {
            t=t/10; l++;
         }
         c=l;
         int a[]=new int[l];
          //Inserting each digit into array rooms
         for(i=l-1;i>=0;i--)
         {
             a[i]=n%10;  n=n/10;
         }
         if(p>c)
         {
            while(true)
            {
               //Finding th sums of the elements
               for(i=l-1;i>=0;i--)
               {
                   s=s+a[i];         
               }
               //Replacing the elements of the array
               for(i=1;i<=l-1;i++)
               { 
                  a[i-1]=a[i];
               }
               a[l-1]=s;
               s=0;
               c++;
               if(p==c)
               {
                  break; 
               }
               
               
            }
            System.out.println("The n-th term of the fibbionachhi series is "+a[l-1]);
         }
         else
            System.out.println("The "+p+" th element of the fibionachi series is "+a[p]);
    }
}