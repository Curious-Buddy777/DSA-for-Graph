import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Practice_JAVA
{
    int[] reverse_Array(int[] input_array)
    {
        int t,i=0,l=input_array.length-1;
        for(i=0;i<l/2;i++)
        {
            t=input_array[i];
            input_array[i]=input_array[l-i];
            input_array[l-i]=t;
        }
        return input_array;
    }
//    This will convert an array of String Literals to
//    a List containing Lists of different anagram words
//    together at a Single List.
    List<List<String>> groupAnagram(String[] words)
    {
        List<List<String>> answer=new ArrayList<>();
        List<char[]> set=new ArrayList<>();
        int i,l,j,f;
        for (String w:words)
        {
            char[] n=w.toCharArray();
            System.out.print(w+" , ");
            n=alphaBet(n);
            l=set.size();
            f=0;
            for(i=0;i<l;i++)
            {
                if(Arrays.equals(n,set.get(i)))
                {
                    List<String> m1=new ArrayList<>();
                    System.out.println(w+"'s anagram already present at index "+i);
                    m1=answer.get(i);
                    System.out.print("");
                    m1.add(w);

                    f=1;
                }
            }
            if(f==0)
            {
                List<String> m1=new ArrayList<>();
                System.out.println("Entering as new category");
                set.add(n);
                m1.add(w);
                answer.add(m1);
            }
        }
        return answer;
    }
    char[] alphaBet(char[] word)
    {
        int i,j;
        for(i=0;i< word.length-1;i++)
        {
            for(j=i+1;j< word.length;j++)
            {
                if((int)word[i]>(int) word[j])
                {
                    word[i]=(char)((int)word[i]^(int)word[j]);
                    word[j]=(char)((int)word[i]^(int)word[j]);
                    word[i]=(char)((int)word[i]^(int)word[j]);
                }
            }
        }
        return word;
    }
    public static void main(String[] args)
    {
        Practice_JAVA obj=new Practice_JAVA();
        String[] s={"bat","eat","tea","tan","ate","nat"};
        List<List<String>>ans= obj.groupAnagram(s);
        for(List<String> a : ans)
        {
            for(String b : a)
            {
                System.out.print(b+" , ");
            }
            System.out.println();
        }

    }
}
