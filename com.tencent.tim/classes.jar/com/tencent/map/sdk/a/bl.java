package com.tencent.map.sdk.a;

import android.os.SystemClock;

final class bl
  implements Runnable
{
  bl(bk parambk, be parambe, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    try
    {
      bh localbh = this.a.a();
      this.a.l = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localbh.a == 0)
      {
        int i = localbh.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      bk.a(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.bl
 * JD-Core Version:    0.7.0.1
 */