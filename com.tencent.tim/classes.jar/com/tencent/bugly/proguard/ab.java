package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

public final class ab
  extends Thread
{
  private boolean a = false;
  private boolean b = false;
  private List<aa> c = new ArrayList();
  private List<ac> d = new ArrayList();
  private ArrayList<aa> e = new ArrayList();
  
  private void a(Handler paramHandler, long paramLong)
  {
    if (paramHandler == null)
    {
      x.e("addThread handler should not be null", new Object[0]);
      return;
    }
    String str = paramHandler.getLooper().getThread().getName();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.c.size())
        {
          if (!((aa)this.c.get(i)).d().equals(paramHandler.getLooper().getThread().getName())) {
            break label120;
          }
          x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        x.b(localException);
        this.c.add(new aa(paramHandler, str, 5000L));
        return;
      }
      label120:
      i += 1;
    }
  }
  
  private int e()
  {
    int i = 0;
    j = 0;
    try
    {
      while (i < this.c.size())
      {
        int k = Math.max(j, ((aa)this.c.get(i)).c());
        j = k;
        i += 1;
      }
      return j;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
  }
  
  public final void a()
  {
    a(new Handler(Looper.getMainLooper()), 5000L);
  }
  
  public final void a(ac paramac)
  {
    if (this.d.contains(paramac))
    {
      x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
      return;
    }
    this.d.add(paramac);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = true;
  }
  
  public final void b()
  {
    int i = 0;
    try
    {
      while (i < this.c.size())
      {
        if (((aa)this.c.get(i)).d().equals(Looper.getMainLooper().getThread().getName()))
        {
          x.c("remove handler::%s", new Object[] { this.c.get(i) });
          this.c.remove(i);
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
  }
  
  public final void b(ac paramac)
  {
    this.d.remove(paramac);
  }
  
  public final boolean c()
  {
    this.a = true;
    if (!isAlive()) {
      return false;
    }
    try
    {
      interrupt();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return true;
  }
  
  public final boolean d()
  {
    if (isAlive()) {
      return false;
    }
    try
    {
      start();
      return true;
    }
    catch (Exception localException)
    {
      x.b(localException);
    }
    return false;
  }
  
  public final void run()
  {
    int i;
    if (!this.a) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.c.size())
        {
          ((aa)this.c.get(i)).a();
          i += 1;
          continue;
        }
        long l2 = SystemClock.uptimeMillis();
        long l1 = 2000L;
        if ((l1 > 0L) && (!isInterrupted()))
        {
          sleep(l1);
          l1 = 2000L - (SystemClock.uptimeMillis() - l2);
          continue;
        }
        i = e();
        if ((i == 0) || (i == 1)) {
          break;
        }
        this.e.clear();
        i = 0;
        if (i < this.c.size())
        {
          localObject = (aa)this.c.get(i);
          if (!((aa)localObject).b()) {
            break label371;
          }
          this.e.add(localObject);
          ((aa)localObject).a(9223372036854775807L);
          break label371;
        }
        Object localObject = NativeCrashHandler.getInstance();
        if ((localObject != null) && (((NativeCrashHandler)localObject).isEnableCatchAnrTrace()))
        {
          ((NativeCrashHandler)localObject).dumpAnrNativeStack();
          x.c("jni mannual dump anr trace", new Object[0]);
          break label378;
          if (this.b) {
            break label383;
          }
          x.c("do not enable anr continue check", new Object[0]);
          sleep(2000L);
          int j = i + 1;
          i = j;
          if (j != 15) {
            continue;
          }
          this.e.clear();
          break label383;
          if (i >= this.e.size()) {
            break;
          }
          localObject = (aa)this.e.get(i);
          j = 0;
          if (j >= this.d.size()) {
            continue;
          }
          x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
          ((ac)this.d.get(j)).a((aa)localObject);
          this.b = false;
          j += 1;
          continue;
        }
        x.c("do not enable jni mannual dump anr trace", new Object[0]);
      }
      catch (Exception localException)
      {
        x.b(localException);
        break;
        i += 1;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        x.b(localOutOfMemoryError);
      }
      break;
      return;
      label371:
      i += 1;
      continue;
      label378:
      i = 0;
      continue;
      label383:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ab
 * JD-Core Version:    0.7.0.1
 */