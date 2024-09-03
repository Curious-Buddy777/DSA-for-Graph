import java.util.*;
class Solution
{
        public List<Integer> findClosestElements(int[] arr, int k, int x)
        {
            List<Integer> answer=new ArrayList<>(k);
            int m=index(arr,x);
            int start=m,end=m,len=arr.length;k--;

            while(k!=0)
            {
                if(start==0)
                {
                    end+=k;
                    break;
                }
                else if(end==len-1)
                {
                    start-=k;
                    break;
                }
                else
                {
                    if(((x-arr[start-1])<(arr[end+1]-x))||((x-arr[start-1])==(arr[end+1]-x))) {
                        start--;
                    }
                    else if((x-arr[start-1])>(arr[end+1]-x))
                        end++;
                    k--;
                }
            }
            for(int i=start;i<=end;i++)
                answer.add(arr[i]);
            return answer;
        }
        int index(int[] arr,int x)
        {
            int s=0,l=arr.length-1,m;
            if(s==l)
                return s;
            while((l-s)!=1)
            {
                m=s+(l-s)/2;
                if(arr[m]==x)
                    return m;
                else if(arr[m]<x)
                    s=m;
                else
                    l=m;
            }
            if(((x-arr[s])<(arr[l]-x))||((x-arr[s])==(arr[l]-x)))
                return s;
            return l;

    }
    public String reverseWords(String s)
    {
       StringTokenizer input=new StringTokenizer(s);
       StringBuilder sen= new StringBuilder();
        String word="";
        while (input.hasMoreTokens())
           sen.insert(0, input.nextToken() + " ");
        return sen.toString().trim();
    }
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int j = 1;

        while(j < nums.length){
            System.out.println("Comparing "+nums[j]+" with :");
            for(int i = 0; i+j < nums.length; i++){
                System.out.print("="+(nums[i+j])+" , ");
                if(target == nums[i]+nums[i+j]) {
                    arr[0] = i;
                    arr[1] = i + j;
                    return arr;
                }
            }
            System.out.println();
            j++;
        }
        return arr;
    }
    public int findJudge(int n, int[][] trust)
    {
        int f=-1,i;
        if(n==1)
            f=1;
        else if(trust.length>=(n-1))
        {
            int[] a=new int[n];
            Arrays.fill(a,0);
            int[] tr=new int[n];
            Arrays.fill(tr,0);
            for(int[] p : trust)
            {
                tr[p[0]-1]=1;
                a[p[1]-1]++;
            }
            for(i=0;i<n;i++)
                if(tr[i]==0&&a[i]==(n-1)) f=i+1;
        }
        return f;
    }
    boolean isPrime(int n)
    {
        int c=0;
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Solution obj=new Solution();
        for(int i=1;i<10;i++)
        {
            System.out.print(" , ");
        }
    }
}