import java.util.*;
public class BinarySearchTree
{
    //To search for doublet in a graph
    public static void main(String[] args)
    {
        int[] a={1,4,3,5,6,7,2,9};
        int i,j,s=10,f=0;
        for(i=0;i<a.length-1;i++)
        {
            for (j=i+1;j<a.length;j++)
            {
                if((a[i]+a[j])==s)
                {
                    System.out.println("The doublet is : ("+a[i]+","+a[j]+")");
                    f=1;
                    break;
                }
            }
        }
        if(f==0)
            System.out.println("Element not found .");
    }
}