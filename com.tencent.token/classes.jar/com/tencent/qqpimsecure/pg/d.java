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
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length <= 0) {
        return false;
      }
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (g.a().b(new int[] { k })[0] == 2) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
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
    b localb = this.a;
    if (localb != null) {
      b.a(localb, true);
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("manual-auto-back-thread start, thread id:");
      ((StringBuilder)localObject1).append(Thread.currentThread().getId());
      bn.b("AutoBackHelper", ((StringBuilder)localObject1).toString());
      long l = System.currentTimeMillis();
      for (;;)
      {
        if ((!this.a) && (System.currentTimeMillis() - l < 60000L))
        {
          localObject1 = g.a().a(this.b);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("permissions:");
          ((StringBuilder)localObject2).append(Arrays.toString(this.b));
          bn.c("AutoBackHelper", ((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("result:");
          ((StringBuilder)localObject2).append(Arrays.toString((int[])localObject1));
          bn.c("AutoBackHelper", ((StringBuilder)localObject2).toString());
          int i;
          if (localObject1 == null)
          {
            i = 0;
          }
          else
          {
            int j = localObject1.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label190;
              }
              if (localObject1[i] != 0) {
                break;
              }
              i += 1;
            }
            label190:
            i = 1;
          }
          if ((i != 0) && (!this.a))
          {
            bn.b("AutoBackHelper", "manual-auto-back-thread all permissions be granted");
            localObject1 = this.c;
            if (localObject1 != null)
            {
              localObject1 = (Activity)((WeakReference)localObject1).get();
              if (localObject1 != null)
              {
                localObject2 = (ActivityManager)((Activity)localObject1).getSystemService("activity");
                if (localObject2 != null) {
                  ((ActivityManager)localObject2).moveTaskToFront(((Activity)localObject1).getTaskId(), 0);
                }
                return;
              }
            }
            bn.b("AutoBackHelper", "activity was recycled!!!");
          }
        }
        try
        {
          Thread.sleep(500L);
        }
        catch (Throwable localThrowable) {}
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("manual-auto-back-thread stop, thread id:");
        ((StringBuilder)localObject1).append(Thread.currentThread().getId());
        bn.b("AutoBackHelper", ((StringBuilder)localObject1).toString());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.d
 * JD-Core Version:    0.7.0.1
 */