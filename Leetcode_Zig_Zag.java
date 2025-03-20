import java.util.Scanner;
public class Leetcode_Zig_Zag
{
    public static String convert(String s,int numrows)
    {
        if(numrows==1)
           return s;
        else if(numrows==2)
       {
                            
       }
        String a[]=new String[numrows];
        int i=0,p=0,l,d=1;    String n="";
        for(i=0;i<numrows;i++)
        {
            a[i]="";
        }
        l=s.length();
        i=0;
        while(i<=(l-1))
        {
            if(p==(numrows-1))
            {
                d=-1;
            }
            else if(p==0)
            {
                d=1;
            }
            
               a[p]=a[p]+s.charAt(i++);
                p=p+d;
            
        }
        for(i=0;i<numrows;i++)
        {
             n=n+a[i];
        }
        return n;
    }
    public static void main(String args[])
    {
         Scanner in=new Scanner(System.in);
         String n=convert(in.nextLine(),in.nextInt());
         System.out.println(n);
    }
}