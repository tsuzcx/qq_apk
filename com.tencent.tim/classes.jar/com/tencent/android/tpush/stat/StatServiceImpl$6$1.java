package com.tencent.android.tpush.stat;

import java.util.Iterator;
import java.util.List;

class StatServiceImpl$6$1
  implements Runnable
{
  StatServiceImpl$6$1(StatServiceImpl.6 param6) {}
  
  public void run()
  {
    try
    {
      if ((!StatServiceImpl.j()) || (!StatServiceImpl.n())) {
        break label83;
      }
      StatServiceImpl.d().b("went background");
      Iterator localIterator = StatServiceImpl.m().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        try
        {
          localc.b();
        }
        catch (Throwable localThrowable2)
        {
          StatServiceImpl.d().b(localThrowable2);
        }
      }
      StatServiceImpl.b(false);
    }
    catch (Throwable localThrowable1)
    {
      StatServiceImpl.d().b(localThrowable1);
      return;
    }
    return;
    label83:
    StatServiceImpl.d().b("still foreground");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.6.1
 * JD-Core Version:    0.7.0.1
 */