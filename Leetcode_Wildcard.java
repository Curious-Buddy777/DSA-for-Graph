class Leetcode_Wildcard
{
    public boolean isMatch(String s,String p)
    {
      int i,j,c=0,f=0,star=0;    String s1="";
      for(i=0;i<p.length();i++)
      {
          if((int)p.charAt(i)==42)
             star=1;
          else if((int)p.charAt(i)==63)
          {
             c++; continue;  
          }
           else if(Character.isLetter(p.charAt(i)))
          {
            for(j=0;j<s.length();j++)
            {
               if(p.charAt(i)!=s.charAt(j))
               {
                   s1=s1+s.charAt(j);
               }
               else
               {
                  f=1;
                  s1=s1+s.substring(++j);
                  break;
               }
            }
            if(f==0)
              return false;
            else
            {
               s=s1; f=0;s1="";
            }
          }
      }
      c=s.length()-c;
      return (c==0)?true:(c>0&&star==1)?true:false;
    }
}