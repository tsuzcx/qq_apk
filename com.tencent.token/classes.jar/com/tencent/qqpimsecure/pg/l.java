package com.tencent.qqpimsecure.pg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import taiji.cl;

class l
  implements Runnable
{
  private volatile boolean a = false;
  private int[] b;
  private WeakReference c;
  
  private l(int[] paramArrayOfInt, Activity paramActivity)
  {
    this.b = paramArrayOfInt;
    if (paramActivity != null) {
      this.c = new WeakReference(paramActivity);
    }
  }
  
  @TargetApi(11)
  public void run()
  {
    cl.b("AutoBackHelper", "manual-auto-back-thread start, thread id:" + Thread.currentThread().getId());
    long l = System.currentTimeMillis();
    for (;;)
    {
      if ((!this.a) && (System.currentTimeMillis() - l < 60000L))
      {
        int k = 1;
        Object localObject = r.a().a(this.b);
        cl.c("AutoBackHelper", "permissions:" + Arrays.toString(this.b));
        cl.c("AutoBackHelper", "result:" + Arrays.toString((int[])localObject));
        int i;
        if (localObject == null)
        {
          i = 0;
          if ((i == 0) || (this.a)) {
            break label275;
          }
          cl.b("AutoBackHelper", "manual-auto-back-thread all permissions be granted");
          if (this.c != null)
          {
            localObject = (Activity)this.c.get();
            if (localObject != null)
            {
              ActivityManager localActivityManager = (ActivityManager)((Activity)localObject).getSystemService("activity");
              if (localActivityManager != null) {
                localActivityManager.moveTaskToFront(((Activity)localObject).getTaskId(), 0);
              }
            }
          }
        }
        else
        {
          int m = localObject.length;
          int j = 0;
          for (;;)
          {
            i = k;
            if (j >= m) {
              break;
            }
            if (localObject[j] != 0)
            {
              i = 0;
              break;
            }
            j += 1;
          }
        }
        cl.b("AutoBackHelper", "activity was recycled!!!");
      }
      else
      {
        cl.b("AutoBackHelper", "manual-auto-back-thread stop, thread id:" + Thread.currentThread().getId());
        return;
      }
      try
      {
        label275:
        Thread.sleep(500L);
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.l
 * JD-Core Version:    0.7.0.1
 */