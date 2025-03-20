import java.util.Scanner;
public class Common_Letter_Remover 
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int a,i,l,j,l1,f=0;
        String s,str="";
        char ch;
        System.out.println("Enter the String to remove Unnecessary Characters");
        s=in.nextLine();
        l=s.length();
        for(i=0;i<l-1;i++)
        {
             l1=str.length();  f=0;
             for(j=0;j<l1;j++)
             {
                  if(str.charAt(j)==s.charAt(i))
                  {
                       f=1;  break;       
                  }
             }
             if(f==0)
                str=str+s.charAt(i);
        }
        System.out.println("The number after removing the unnecessary characters are : "+str);
    }
}