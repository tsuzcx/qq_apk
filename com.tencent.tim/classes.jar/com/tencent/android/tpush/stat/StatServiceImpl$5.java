package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.a;
import java.util.ArrayList;
import java.util.List;

final class StatServiceImpl$5
  implements Runnable
{
  StatServiceImpl$5(double paramDouble, Context paramContext, long paramLong) {}
  
  public void run()
  {
    try
    {
      StatServiceImpl.d().b("trackBackground duration:" + this.a);
      if (this.a <= 0.0D) {}
      for (double d = 0.1D;; d = this.a)
      {
        a locala = new a(StatServiceImpl.getContext(this.b), StatServiceImpl.b(this.b, this.c), d, this.c);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(locala);
        StatServiceImpl.a(localArrayList);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */