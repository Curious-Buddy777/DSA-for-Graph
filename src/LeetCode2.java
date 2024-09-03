import java.util.*;

import static java.util.Collection.*;

public class LeetCode2
{
    int l;
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        l=nums.length;
        reccur(0,new ArrayList<>(),nums);
        return ans;
    }
    public void reccur(int n,List<Integer> has,int[] nums)
    {
        if(n==l)
        {
            List<Integer> ou=new ArrayList<>(has);
            Collections.sort(ou);
            if(!ans.contains(ou))
                ans.add(0,new ArrayList<>(ou));
        }
        else
        {
            has.add(nums[n]);
            reccur(n+1,has,nums);
            has.remove(has.size()-1);
            reccur(n+1,has,nums);
        }
    }

    public static void main(String[] args)
    {
        int[] a={4,4,4,1,4};
        LeetCode2 obj=new LeetCode2();
        System.out.println(obj.subsetsWithDup(a));
    }
}
