import java.util.*;
class DSA_Testing
{
    public List<List<Integer>> findWinners(int[][] matches)
    {
        if(matches.length==0)return new ArrayList<>();
        Map<Integer,Integer> l=new HashMap<>();
        Set<Integer> w=new HashSet<>();
        Set<Integer> lh=new HashSet<>();
        //Finding a list of all winners
        for(int[] a : matches)
        {
            w.add(a[0]);
            if(l.containsKey(a[1])) {
                l.put(a[1],l.get(a[1])+1);
                System.out.println("Removing the element :"+a[1]);
            }
            else {
                System.out.println("Adding element : "+a[1]);
                l.put(a[1],1);
            }
            lh.add(a[1]);
        }
        //Now Updating the list
        for(Integer a : lh)
        {
            if(w.contains(a))w.remove(a);
        }

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        List<Integer> w1=new ArrayList<>(w);
        for(Integer k : l.keySet())
            if(l.get(k)==1)l1.add(k);
        Collections.sort(l1);
        Collections.sort(w1);
        ans.add(w1);ans.add(l1);
        return ans;
    }
    public static void main(String[] args)
    {
        DSA_Testing obj=new DSA_Testing();

        System.out.println("The answer : "+obj.findWinners(new int[][] {{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{6,8}}));


    }
}