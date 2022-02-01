package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.b;
import com.tencent.feedback.common.c;
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
  
  public static y a(Context paramContext, b paramb, com.tencent.feedback.upload.e parame)
  {
    for (;;)
    {
      Context localContext;
      try
      {
        if (a == null)
        {
          if (paramContext != null)
          {
            localContext = paramContext.getApplicationContext();
            if (localContext != null) {
              break label56;
            }
          }
          a = new y(paramContext, paramb, parame);
        }
        else
        {
          paramContext = a;
          return paramContext;
        }
      }
      finally {}
      label56:
      paramContext = localContext;
    }
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
          if (b(this.h) >= this.g)
          {
            com.tencent.feedback.common.e.b("rqdp{ state max upload}", new Object[0]);
            localObject1 = g();
            if (localObject1 != null) {
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
            }
          }
          return true;
        }
      }
      return false;
    }
    finally {}
  }
  
  public final boolean a(long paramLong)
  {
    try
    {
      if (this.c != null)
      {
        if (!this.e)
        {
          this.f = 60000L;
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
          if (paramLong > l2)
          {
            b localb = this.c;
            Runnable local1 = new Runnable()
            {
              public final void run()
              {
                long l2 = y.this.f();
                long l1 = new Date().getTime();
                l2 -= l1;
                b localb = y.this.g();
                if (localb != null)
                {
                  if (l2 > 0L)
                  {
                    localb.a(this, l2 + 1000L);
                    return;
                  }
                  com.tencent.feedback.common.e.b("rqdp{  next day to upload}", new Object[0]);
                  y.this.d();
                  l2 = y.this.e();
                  y.this.b(l2);
                  l1 = l2 - l1;
                  localb.a(this, l1);
                  com.tencent.feedback.common.e.b("rqdp{ next day %d}", new Object[] { Long.valueOf(l1) });
                }
              }
            };
            paramLong -= l2;
            localb.a(local1, paramLong);
            com.tencent.feedback.common.e.b("rqdp{ next day %d}", new Object[] { Long.valueOf(paramLong) });
          }
        }
        else if (60000L != this.f)
        {
          this.f = 60000L;
        }
        return true;
      }
      return false;
    }
    finally {}
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
  
  /* Error */
  public final long e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 185	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   5: astore_3
    //   6: aload_3
    //   7: bipush 11
    //   9: iconst_0
    //   10: invokevirtual 189	java/util/Calendar:set	(II)V
    //   13: aload_3
    //   14: bipush 12
    //   16: iconst_0
    //   17: invokevirtual 189	java/util/Calendar:set	(II)V
    //   20: aload_3
    //   21: bipush 13
    //   23: iconst_0
    //   24: invokevirtual 189	java/util/Calendar:set	(II)V
    //   27: aload_3
    //   28: bipush 6
    //   30: iconst_1
    //   31: invokevirtual 192	java/util/Calendar:add	(II)V
    //   34: aload_3
    //   35: invokevirtual 195	java/util/Calendar:getTime	()Ljava/util/Date;
    //   38: invokevirtual 119	java/util/Date:getTime	()J
    //   41: lstore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: lload_1
    //   45: lreturn
    //   46: astore_3
    //   47: goto +34 -> 81
    //   50: astore_3
    //   51: aload_3
    //   52: invokestatic 198	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   55: ifne +7 -> 62
    //   58: aload_3
    //   59: invokevirtual 201	java/lang/Throwable:printStackTrace	()V
    //   62: new 115	java/util/Date
    //   65: dup
    //   66: invokespecial 116	java/util/Date:<init>	()V
    //   69: invokevirtual 119	java/util/Date:getTime	()J
    //   72: lstore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: lload_1
    //   76: ldc2_w 202
    //   79: ladd
    //   80: lreturn
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	y
    //   41	35	1	l	long
    //   5	30	3	localCalendar	java.util.Calendar
    //   46	1	3	localObject	Object
    //   50	34	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	42	46	finally
    //   51	62	46	finally
    //   62	73	46	finally
    //   2	42	50	java/lang/Throwable
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