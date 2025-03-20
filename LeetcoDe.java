import java.util.*;
public class LeetcoDe
{
    public boolean dub(int nums[])
    {
        boolean f=false;
        int i,j;
        for(i=0;i<nums.length-1;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                   f=true; break;
                }
            }
        }
        return f;
    }
}