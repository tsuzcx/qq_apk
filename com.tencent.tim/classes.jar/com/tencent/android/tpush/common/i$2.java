package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;

final class i$2
  implements Runnable
{
  i$2(Context paramContext) {}
  
  public void run()
  {
    if (i.c(this.a) != 1) {}
    try
    {
      TLogger.v("Util", "Action2 -> start Local Service()");
      b.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("Util", "CommonWorkingThread StartService", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.i.2
 * JD-Core Version:    0.7.0.1
 */