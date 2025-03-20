class Leetcode__Wildcard_Recursion
{
  public boolean isMatch(String s,String p)
  {
    return (Match(s,p,0)==true||Match(s,p,1)==true)?true:false;
  }
   public boolean Match(String s,String p,int n)
   {
       boolean flag=true;
      if(p.length()==1)
      {
         if((int)p.charAt(0)==63)
             flag=(s.length()==1)?true:false;
         else if((int)p.charAt(0)==42)
             flag=true;
         else if(Character.isLetter(p.charAt(0))&&s.length()==1&&s.charAt(0)==p.charAt(0))
             flag=true;
             
         else flag=false;
      }
      else if(s.length()==1)
      {
         if(p.length()>1)
         {
             int c=0;
             for(int i=0;i<p.length();i++)
             {
                 if(Character.isLetter(p.charAt(i))||(int)p.charAt(i)==63)
                   c++;
                 if(c>1)
                    flag=false;
             }
             flag=true;
         }
         else if(p.length()==1)
         {
             if((int)p.charAt(0)==63||p.charAt(0)==s.charAt(0)||(int)p.charAt(0)==42)
                 flag=true;
             else flag=false;
         }
         else  flag=false;
      }
      else if(p.length()==0)   flag=false;
      else if(s.length()==0)
      {
          int c=0;
             for(int i=0;i<p.length();i++)
             {
                 if(Character.isLetter(p.charAt(i))||(int)p.charAt(i)==63)
                   c++;
                 if(c>0)
                    flag=false;
             }
             flag=true;             
      }
      else if((int)p.charAt(0)==63||p.charAt(0)==s.charAt(0))
         return Match(s.substring(1),p.substring(1),n);
      if((int)p.charAt(0)==42)
      {
         if(n==0)
           return (p.charAt(1)==s.charAt(0))?Match(s.substring(1),p.substring(1),n):Match(s.substring(1),p,n);
         if(n==1)
           return (p.charAt(1)==s.charAt(1))?Match(s.substring(1),p.substring(1),n):Match(s.substring(1),p,n);
      }
    return flag;
  }
}