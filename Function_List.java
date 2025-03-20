import java.util.Scanner;
public class Function_List
{
     
    static String remove_dublicate(String n)
    {
       int l,j,i;  char ch;
       String s="",s1="";
       l=n.length();
       for(i=0;i<n.length();i++)
       {
           s=s+n.charAt(i);
           if(i!=l)
           {
              for(j=i+1;j<n.length();j++)
             {
                 if(n.charAt(i)!=n.charAt(j))
                   s=s+n.charAt(j);
             }
             s1=s1+n.charAt(i);
              n=s;
              s=""; 
              
           }
       }
       return s1;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        String s;
        System.out.println("Enter the word to remove dublicate characteristics");
        s=in.nextLine();
        System.out.println("The word after removing the dublicate characters are "+remove_dublicate(s));
    }
}