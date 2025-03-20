import java.util.Scanner;
class Leetcode_Find_Median
{
    public static double findMedianSortedArrays(int[] nums1,int[] nums2)
    {
        int m,n,p=0,t;
        m=nums1.length;
        n=nums2.length;
        int a[]=new int[m+n];
        //Merging two array into one
        for(int i=0;i<(m+n);i++)
        {
            if(i<m)
            {
                 a[i]=nums1[i];
            }
            else
                 a[i]=nums2[i-m];
        }
        //Sorting the merged array
        for(int i=0;i<(m+n)-1;i++)
        {
            for(int j=i+1;j<(m+n);j++)
            {
               if(a[i]>a[j])
               {
                     t=a[i];
                     a[i]=a[j];
                     a[j]=t;
               }
            }
        }
        
        return ((m+n)%2==0)?(double)(a[(m+n)/2]+a[(m+n)/2-1])/2:a[((m+n))/2];
    }
}