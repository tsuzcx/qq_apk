package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.b;
import com.tencent.feedback.common.c;
import java.util.Calendar;
import java.util.Date;

public final class y
  implements Runnable
{
  private static y a;
  private Context b;
  private b c;
  private com.tencent.feedback.upload.e d;
  private boolean e = false;
  private long f = 60000L;
  private int g = 10;
  private final String h;
  private int i = 0;
  private long j = 0L;
  
  private y(Context paramContext, b paramb, com.tencent.feedback.upload.e parame)
  {
    this.b = paramContext;
    this.c = paramb;
    this.d = parame;
    this.h = c.a(paramContext).E();
    this.j = e();
  }
  
  public static y a()
  {
    try
    {
      y localy = a;
      return localy;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static y a(Context paramContext, b paramb, com.tencent.feedback.upload.e parame)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 74	com/tencent/feedback/proguard/y:a	Lcom/tencent/feedback/proguard/y;
    //   6: ifnonnull +20 -> 26
    //   9: aload_0
    //   10: ifnonnull +25 -> 35
    //   13: new 2	com/tencent/feedback/proguard/y
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: invokespecial 77	com/tencent/feedback/proguard/y:<init>	(Landroid/content/Context;Lcom/tencent/feedback/common/b;Lcom/tencent/feedback/upload/e;)V
    //   23: putstatic 74	com/tencent/feedback/proguard/y:a	Lcom/tencent/feedback/proguard/y;
    //   26: getstatic 74	com/tencent/feedback/proguard/y:a	Lcom/tencent/feedback/proguard/y;
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 83	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -28 -> 13
    //   44: aload_3
    //   45: astore_0
    //   46: goto -33 -> 13
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramContext	Context
    //   0	55	1	paramb	b
    //   0	55	2	parame	com.tencent.feedback.upload.e
    //   39	6	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	9	49	finally
    //   13	26	49	finally
    //   26	30	49	finally
    //   35	40	49	finally
  }
  
  private void b(int paramInt)
  {
    try
    {
      this.i = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean i()
  {
    try
    {
      boolean bool = a(1);
      com.tencent.feedback.common.e.b("rqdp{ launch state record %b}", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int j()
  {
    try
    {
      int k = this.i;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int a(q[] paramArrayOfq)
  {
    try
    {
      int k = a.b(this.b, paramArrayOfq);
      return k;
    }
    finally
    {
      paramArrayOfq = finally;
      throw paramArrayOfq;
    }
  }
  
  protected final boolean a(int paramInt)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        Object localObject1 = c.a(this.b);
        if (localObject1 != null)
        {
          q localq = new q();
          localq.a(paramInt);
          localq.a(new Date().getTime());
          localq.a(this.h);
          localq.b(((c)localObject1).g());
          if (a.a(this.b, new q[] { localq }) > 0)
          {
            bool1 = bool2;
            if (b(this.h) >= this.g)
            {
              com.tencent.feedback.common.e.b("rqdp{ state max upload}", new Object[0]);
              localObject1 = g();
              bool1 = bool2;
              if (localObject1 != null)
              {
                if (0L > 0L) {
                  continue;
                }
                ((b)localObject1).a(new Runnable()
                {
                  public final void run()
                  {
                    com.tencent.feedback.upload.e locale = y.this.h();
                    if (locale != null) {
                      locale.a(new A(y.a(y.this), y.a(), this.a));
                    }
                  }
                });
                bool1 = bool2;
              }
            }
            return bool1;
            bool1 = bool2;
            if (0L <= 0L) {
              continue;
            }
            ((b)localObject1).a(new Runnable()
            {
              public final void run()
              {
                com.tencent.feedback.upload.e locale = y.this.h();
                if (locale != null) {
                  locale.a(new A(y.a(y.this), y.a(), this.a));
                }
              }
            }, 0L);
            bool1 = bool2;
            continue;
          }
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  public final boolean a(long paramLong)
  {
    paramLong = 60000L;
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          if (60000L > 30000L)
          {
            if (!this.e)
            {
              this.f = paramLong;
              this.e = true;
              this.c.a(this, 0L);
              long l1 = f();
              long l2 = new Date().getTime();
              paramLong = l1;
              if (l1 <= l2)
              {
                b(e());
                paramLong = f();
              }
              bool1 = bool2;
              if (paramLong > l2)
              {
                this.c.a(new Runnable()
                {
                  public final void run()
                  {
                    long l2 = y.this.f();
                    long l1 = new Date().getTime();
                    l2 -= l1;
                    b localb = y.this.g();
                    if (localb != null)
                    {
                      if (l2 > 0L) {
                        localb.a(this, l2 + 1000L);
                      }
                    }
                    else {
                      return;
                    }
                    com.tencent.feedback.common.e.b("rqdp{  next day to upload}", new Object[0]);
                    y.this.d();
                    l2 = y.this.e();
                    y.this.b(l2);
                    localb.a(this, l2 - l1);
                    com.tencent.feedback.common.e.b("rqdp{ next day %d}", new Object[] { Long.valueOf(l2 - l1) });
                  }
                }, paramLong - l2);
                com.tencent.feedback.common.e.b("rqdp{ next day %d}", new Object[] { Long.valueOf(paramLong - l2) });
                bool1 = bool2;
              }
              return bool1;
            }
          }
          else
          {
            paramLong = 30000L;
            continue;
          }
          bool1 = bool2;
          if (paramLong == this.f) {
            continue;
          }
          this.f = paramLong;
          bool1 = bool2;
          continue;
        }
        boolean bool1 = false;
      }
      finally {}
    }
  }
  
  public final q[] a(String paramString)
  {
    try
    {
      paramString = a.b(this.b, paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int b(String paramString)
  {
    try
    {
      int k = a.c(this.b, paramString);
      return k;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected final void b(long paramLong)
  {
    try
    {
      this.j = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = b.b().a(new Runnable()
      {
        public final void run()
        {
          com.tencent.feedback.common.e.b("rqdp{ login state record %b}", new Object[] { Boolean.valueOf(y.this.a(4)) });
        }
      });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = a(3);
      com.tencent.feedback.common.e.b("rqdp{ next day state record %b}", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long e()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.add(6, 1);
      l = localCalendar.getTime().getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (!com.tencent.feedback.common.e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        long l = new Date().getTime();
        l += 86400000L;
      }
    }
    finally {}
  }
  
  public final long f()
  {
    try
    {
      long l = this.j;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final b g()
  {
    try
    {
      b localb = this.c;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.feedback.upload.e h()
  {
    try
    {
      com.tencent.feedback.upload.e locale = this.d;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void run()
  {
    int k = j() + 1;
    b(k);
    if (k == 1)
    {
      com.tencent.feedback.common.a.b(this.b, this.h);
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.y
 * JD-Core Version:    0.7.0.1
 */