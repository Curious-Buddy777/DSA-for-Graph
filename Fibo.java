 import java.util.Scanner;
public class Fibo
{
    static int t,m;
    static int armstrong(int n,int a)
    {
      if(n<10)
        return n*n*n-a;
      return (n%10)*(n%10)*(n%10)+armstrong(n/10,a);
    }
    static int[] bubble(int a[],int i,int j,int l)
    {
      System.out.println("i="+i+",j="+j);
      System.out.println("The array before conversion:");
      for(m=0;m<l;m++)
      {
          System.out.print(a[m]+" ,"); 
      }
      System.out.println();
      if((i+j)==l+l-2)
         return a;
      if(a[i]<a[j])
      {
         t=a[i];
         a[i]=a[j];
         a[j]=t;
      }
      System.out.println("The array after conversion:");
      for(m=0;m<l;m++)
      {
          System.out.print(a[m]+" ,"); 
      }
      System.out.println();
      j++;
      return bubble(a,(j==l)?i+1:i,(j==l)?0:j,l); 
    }
    //Recursion using Recursion technique
    int recfibo(int n)
    {
      if(n==1)
        return 0;
      else if(n==2)
        return 1;
      return recfibo(n-1);
    }
    //Linear search using recursion technique
    int linn(int a,int arr[],int l)
    {
       if(arr[l]==a)
        return 1;
       else if(l==0&&arr[l]!=a)
         return 0;
       return linn(a,arr,l-1);
    }
    //Bubble sort method
    static int[] bubble_Sort(int a[])
    {
       int i,j,l,t;
       for(i=0;i<a.length-1;i++)
       {
            for(j=i+1;j<a.length;j++)
            {
               if(a[i]>a[j])
               {
                  t=a[i];
                  a[i]=a[j];
                  a[j]=t;
               }
            }
       }
       return a;
    }
    
   public static void main(String args[])
   {
        Scanner in=new Scanner(System.in);
        int n,p,i;
        System.out.println("Enter 1 for array and 2 for bubble sort 3 for armstrong number");
        n=in.nextInt();
        
        if(n==1)
        {
           
          System.out.println("Enter the dimension of array");
          n=in.nextInt();
          int a[]=new int[n];  
          System.out.println("Enter the elements of the array");
          for(i=0;i<n;i++)
          {
             a[i]=in.nextInt();
          }
          bubble_Sort(a);
          for(i=0;i<n;i++)
          {
             System.out.print(a[i]+", ");
          }
       }
       else if(n==2)
       {
           System.out.println("Enter the lendth of the array");
           n=in.nextInt();
           int a[]=new int[n];
           System.out.println("Enter the elements of the array");
         for(i=0;i<n;i++)
         {
             a[i]=in.nextInt();      
         }
           a=bubble(a,0,1,n);
         for(i=0;i<n;i++)
         {
             System.out.print(a[i]+" , ");   
         }
       }
       else if(n==3)
       {
          System.out.println("Enter the number");
          n=in.nextInt();
          System.out.println((armstrong(n,n)==0)?"Armstrong Number":"Not an Armstrong Number");
       }
    }
   }
