package com.tencent.mobileqq.msf.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class p
  extends Thread
{
  p(o paramo, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if ((n.c) && (n.i().compareAndSet(false, true))) {
      try
      {
        n.b(MsfSdkUtils.getProcessName(n.h()));
        try
        {
          n.c(n.h().getPackageName());
          n.c(Process.myPid());
          Log.d("appMemory", "QLog init retry ");
          n.a(System.currentTimeMillis());
          n.m.setName("logWriteThread");
          n.m.start();
          n.j().removeCallbacks(n.j);
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
        n.i().set(false);
        localException2.printStackTrace();
        j = n.k().get();
        Log.d("appMemory", "QLog init post retry " + j + " times, interval " + n.l()[j]);
        n.j().removeCallbacks(n.j);
        n.j().postDelayed(n.j, n.l()[j] * 60000);
        j += 1;
        if (j >= n.l().length) {}
        for (;;)
        {
          n.k().set(i);
          return;
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.p
 * JD-Core Version:    0.7.0.1
 */