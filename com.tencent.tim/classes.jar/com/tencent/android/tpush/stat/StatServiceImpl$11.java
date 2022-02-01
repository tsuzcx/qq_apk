package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.android.tpush.stat.event.e;

final class StatServiceImpl$11
  implements Runnable
{
  StatServiceImpl$11(Context paramContext, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    try
    {
      StatServiceImpl.a(new e(this.a, this.b, this.c, this.d));
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.d().b(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.11
 * JD-Core Version:    0.7.0.1
 */