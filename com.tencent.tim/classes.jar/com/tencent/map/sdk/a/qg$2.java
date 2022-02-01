package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Set;

final class qg$2
  implements Runnable
{
  qg$2(qg paramqg, boolean paramBoolean, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    for (;;)
    {
      qf localqf;
      try
      {
        Iterator localIterator = this.d.c.iterator();
        if (localIterator.hasNext())
        {
          localqf = (qf)localIterator.next();
          if (this.a)
          {
            localqf.a(this.b);
            localqf.a(this.b, this.c);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (this.c == null) {
        localqf.b(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.qg.2
 * JD-Core Version:    0.7.0.1
 */