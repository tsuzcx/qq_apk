package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;

final class p
  implements Runnable
{
  p(Context paramContext, int paramInt) {}
  
  public void run()
  {
    try
    {
      StatServiceImpl.flushDataToDB(this.a);
      af.a(this.a).a(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.p
 * JD-Core Version:    0.7.0.1
 */