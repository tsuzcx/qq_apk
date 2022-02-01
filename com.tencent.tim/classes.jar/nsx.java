import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class nsx
{
  private String anE;
  private final int bcl;
  private final Map<Character, Integer> eQ;
  private final char[] k;
  
  nsx(String paramString)
  {
    if (paramString.contains(Character.toString('\000'))) {
      throw new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    }
    this.anE = paramString;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    this.bcl = m;
    this.eQ = new HashMap(m);
    int i = 0;
    while (i < m)
    {
      this.eQ.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.k = new char[m * 2 + 1];
    this.k[0] = '\000';
    i = j;
    while (i < m)
    {
      this.k[(i + 1)] = paramString[i];
      this.k[(m + 1 + i)] = paramString[i];
      i += 1;
    }
  }
  
  private int b(char paramChar)
  {
    if (paramChar == 0) {
      return 0;
    }
    if (this.eQ.containsKey(Character.valueOf(paramChar))) {
      return ((Integer)this.eQ.get(Character.valueOf(paramChar))).intValue() + 1;
    }
    return -1;
  }
  
  nsx.a a(char paramChar1, char paramChar2, int paramInt)
  {
    int j = b(paramChar1);
    int m = b(paramChar2);
    if ((j < 0) || (m < 0)) {
      return null;
    }
    int i;
    switch (paramInt)
    {
    default: 
      i = j;
      paramInt = m;
    }
    for (;;)
    {
      return new nsx.a(i, paramInt);
      if (paramChar2 == 0)
      {
        paramInt = this.k.length;
        i = j;
      }
      else
      {
        paramInt = m;
        i = j;
        if (m < j)
        {
          paramInt = m + this.bcl;
          i = j;
          continue;
          paramInt = m;
          i = j;
          if (j < m)
          {
            i = j + this.bcl;
            paramInt = m;
            continue;
            paramInt = m;
            i = j;
            if (paramChar1 != 0)
            {
              paramInt = m;
              i = j;
              if (paramChar2 != 0) {
                if (m < j)
                {
                  paramInt = m;
                  i = j;
                  if (this.bcl - j + m < j - m)
                  {
                    paramInt = m + this.bcl;
                    i = j;
                  }
                }
                else
                {
                  paramInt = m;
                  i = j;
                  if (j < m)
                  {
                    paramInt = m;
                    i = j;
                    if (this.bcl - m + j < m - j)
                    {
                      i = j + this.bcl;
                      paramInt = m;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  char[] b()
  {
    return this.k;
  }
  
  String kK()
  {
    return this.anE;
  }
  
  Set<Character> s()
  {
    return this.eQ.keySet();
  }
  
  class a
  {
    final int endIndex;
    final int startIndex;
    
    public a(int paramInt1, int paramInt2)
    {
      this.startIndex = paramInt1;
      this.endIndex = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsx
 * JD-Core Version:    0.7.0.1
 */