package com.tencent.qqpimsecure.pg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import com.tencent.qqpimsecure.taiji.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class d
{
  private b a;
  
  public static d a()
  {
    return a.a();
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      int k = paramArrayOfInt[i];
      if (g.a().b(new int[] { k })[0] == 2) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  public void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (!a(paramArrayOfInt)) {
      return;
    }
    b();
    this.a = new b(paramArrayOfInt, paramActivity, null);
    c.a().d().addUrgentTask(this.a, "manual-auto-back-thread");
  }
  
  public void b()
  {
    if (this.a != null) {
      b.a(this.a, true);
    }
  }
  
  private static class a
  {
    private static final d a = new d(null);
  }
  
  private static class b
    implements Runnable
  {
    private volatile boolean a = false;
    private int[] b;
    private WeakReference<Activity> c;
    
    private b(int[] paramArrayOfInt, Activity paramActivity)
    {
      this.b = paramArrayOfInt;
      if (paramActivity != null) {
        this.c = new WeakReference(paramActivity);
      }
    }
    
    @TargetApi(11)
    public void run()
    {
      bn.b("AutoBackHelper", "manual-auto-back-thread start, thread id:" + Thread.currentThread().getId());
      long l = System.currentTimeMillis();
      for (;;)
      {
        if ((!this.a) && (System.currentTimeMillis() - l < 60000L))
        {
          int k = 1;
          Object localObject = g.a().a(this.b);
          bn.c("AutoBackHelper", "permissions:" + Arrays.toString(this.b));
          bn.c("AutoBackHelper", "result:" + Arrays.toString((int[])localObject));
          int i;
          if (localObject == null)
          {
            i = 0;
            if ((i == 0) || (this.a)) {
              break label275;
            }
            bn.b("AutoBackHelper", "manual-auto-back-thread all permissions be granted");
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
          bn.b("AutoBackHelper", "activity was recycled!!!");
        }
        else
        {
          bn.b("AutoBackHelper", "manual-auto-back-thread stop, thread id:" + Thread.currentThread().getId());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.d
 * JD-Core Version:    0.7.0.1
 */