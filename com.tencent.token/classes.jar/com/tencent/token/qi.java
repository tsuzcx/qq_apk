package com.tencent.token;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class qi
{
  private b a;
  
  private void a()
  {
    b localb = this.a;
    if (localb != null) {
      b.a(localb);
    }
  }
  
  private static boolean a(int[] paramArrayOfInt)
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
        if (ql.a.a().b(new int[] { k })[0] == 2) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public final void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (!a(paramArrayOfInt)) {
      return;
    }
    a();
    this.a = new b(paramArrayOfInt, paramActivity, (byte)0);
    qp.a.a().a().b(this.a, "manual-auto-back-thread");
  }
  
  public static final class a
  {
    private static final qi a = new qi((byte)0);
  }
  
  static final class b
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
    public final void run()
    {
      new StringBuilder("manual-auto-back-thread start, thread id:").append(Thread.currentThread().getId());
      aoc.b();
      long l = System.currentTimeMillis();
      while ((!this.a) && (System.currentTimeMillis() - l < 60000L))
      {
        Object localObject = ql.a.a().a(this.b);
        new StringBuilder("permissions:").append(Arrays.toString(this.b));
        aoc.c();
        new StringBuilder("result:").append(Arrays.toString((int[])localObject));
        aoc.c();
        int i;
        if (localObject == null)
        {
          i = 0;
        }
        else
        {
          int j = localObject.length;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label139;
            }
            if (localObject[i] != 0) {
              break;
            }
            i += 1;
          }
          label139:
          i = 1;
        }
        if ((i != 0) && (!this.a))
        {
          aoc.b();
          localObject = this.c;
          if (localObject != null)
          {
            localObject = (Activity)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ActivityManager localActivityManager = (ActivityManager)((Activity)localObject).getSystemService("activity");
              if (localActivityManager != null) {
                localActivityManager.moveTaskToFront(((Activity)localObject).getTaskId(), 0);
              }
              return;
            }
          }
          aoc.b();
          break;
        }
        try
        {
          Thread.sleep(500L);
        }
        catch (Throwable localThrowable)
        {
          label225:
          break label225;
        }
      }
      new StringBuilder("manual-auto-back-thread stop, thread id:").append(Thread.currentThread().getId());
      aoc.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qi
 * JD-Core Version:    0.7.0.1
 */