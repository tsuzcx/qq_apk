package com.tencent.token;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class dw
  implements Iterable<String>
{
  private ConcurrentLinkedQueue<String> a = null;
  private AtomicInteger b = null;
  
  public int a()
  {
    return this.b.get();
  }
  
  public int a(String paramString)
  {
    int i = paramString.length();
    this.a.add(paramString);
    return this.b.addAndGet(i);
  }
  
  public void a(Writer paramWriter, char[] paramArrayOfChar)
  {
    if ((paramWriter == null) || (paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {
      return;
    }
    int n = paramArrayOfChar.length;
    for (;;)
    {
      int j;
      int k;
      int i1;
      int i2;
      try
      {
        Iterator localIterator = iterator();
        j = 0;
        i = n;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          k = str.length();
          m = 0;
          break label169;
          str.getChars(m, m + i1, paramArrayOfChar, j);
          i2 = i - i1;
          k -= i1;
          i = i1 + m;
          if (i2 == 0)
          {
            paramWriter.write(paramArrayOfChar, 0, n);
            i1 = 0;
            j = n;
            m = i;
            i = j;
            j = i1;
            break label169;
          }
        }
        else
        {
          if (j > 0) {
            paramWriter.write(paramArrayOfChar, 0, j);
          }
          paramWriter.flush();
          return;
        }
      }
      catch (Exception paramWriter)
      {
        paramWriter.printStackTrace();
        return;
      }
      j += i1;
      int m = i;
      int i = i2;
      label169:
      if (k > 0) {
        if (i > k) {
          i1 = k;
        } else {
          i1 = i;
        }
      }
    }
  }
  
  public void b()
  {
    this.a.clear();
    this.b.set(0);
  }
  
  public Iterator<String> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dw
 * JD-Core Version:    0.7.0.1
 */