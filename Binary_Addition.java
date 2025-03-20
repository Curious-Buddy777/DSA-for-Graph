import java.util.Scanner;
public class Binary_Addition
{
    
   public static void main(String[] args)
  {
      Scanner in=new Scanner(System.in);
      int a,b,r1,r2,c=0,s=0,p=1;
      int bin[]={0,1,10,11};
      System.out.println("Enter the first number");
      a=in.nextInt();
      System.out.println("Enter the second number");
      b=in.nextInt();
      System.out.println("Calculating........");
      while(a!=0||b!=0)
      {
        r1=a%10; a=a/10;
        r2=b%10; b=b/10;
        s=s+(bin[r1+r2+c]%10)*p;
        c=bin[r1+r2+c]/10;
        p=p*10;
      }
      s=p*((a>b)?a:b)+s;
      System.out.println("The sum of two numbers are "+s);
  }
}