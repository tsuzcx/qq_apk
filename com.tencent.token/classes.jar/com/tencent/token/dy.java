package com.tencent.token;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class dy
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
    int i1;
    int i2;
    int k;
    int m;
    int j;
    int i;
    if ((paramWriter != null) && (paramArrayOfChar != null))
    {
      if (paramArrayOfChar.length == 0) {
        return;
      }
      int n = paramArrayOfChar.length;
      try
      {
        Iterator localIterator = iterator();
        i1 = n;
        i2 = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          k = str.length();
          m = 0;
          j = i2;
          i = i1;
          break label161;
          label73:
          i1 = m + i2;
          str.getChars(m, i1, paramArrayOfChar, j);
          i -= i2;
          j += i2;
          k -= i2;
          if (i != 0) {
            break label192;
          }
          paramWriter.write(paramArrayOfChar, 0, n);
          i = n;
          m = i1;
          j = 0;
          break label161;
        }
        if (i2 > 0) {
          paramWriter.write(paramArrayOfChar, 0, i2);
        }
        paramWriter.flush();
        return;
      }
      catch (Exception paramWriter)
      {
        paramWriter.printStackTrace();
        return;
      }
    }
    else
    {
      return;
    }
    for (;;)
    {
      label161:
      i2 = j;
      i1 = i;
      if (k <= 0) {
        break;
      }
      if (i > k)
      {
        i2 = k;
        break label73;
      }
      i2 = i;
      break label73;
      label192:
      m = i1;
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
 * Qualified Name:     com.tencent.token.dy
 * JD-Core Version:    0.7.0.1
 */