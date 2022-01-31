package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class q
  extends Thread
{
  q(p paramp, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((n.c) && (n.j().compareAndSet(false, true))) {
      try
      {
        n.b(MsfSdkUtils.getProcessName(n.i()));
        try
        {
          n.c(n.i().getPackageName());
          n.c(Process.myPid());
          Log.d("appMemory", "QLog init retry ");
          n.a(System.currentTimeMillis());
          n.m.setName("logWriteThread");
          n.m.start();
          n.k().removeCallbacks(n.j);
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            n.c("unknow");
          }
        }
        int j;
        return;
      }
      catch (Exception localException2)
      {
        n.j().set(false);
        localException2.printStackTrace();
        j = n.l().get();
        Log.d("appMemory", "QLog init post retry " + j + " times, interval " + n.m()[j]);
        n.k().removeCallbacks(n.j);
        n.k().postDelayed(n.j, n.m()[j] * 60000);
        j += 1;
        if (j >= n.m().length) {}
        for (;;)
        {
          n.l().set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */