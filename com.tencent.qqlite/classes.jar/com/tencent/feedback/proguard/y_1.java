package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.b;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.f;
import java.util.Calendar;
import java.util.Date;

public final class y
  implements Runnable
{
  private static y a;
  private Context b;
  private b c;
  private f d;
  private boolean e = false;
  private long f = 60000L;
  private int g = 10;
  private boolean h = true;
  private final String i;
  private int j = 0;
  private long k = 0L;
  
  private y(Context paramContext, b paramb, f paramf)
  {
    this.b = paramContext;
    this.c = paramb;
    this.d = paramf;
    this.i = com.tencent.feedback.common.a.h(this.b);
    this.k = d();
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
  
  public static y a(Context paramContext, b paramb, f paramf)
  {
    try
    {
      if (a == null) {
        a = new y(paramContext.getApplicationContext(), paramb, paramf);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 87	com/tencent/feedback/common/c:p	()Lcom/tencent/feedback/common/c;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +76 -> 85
    //   12: new 89	com/tencent/feedback/proguard/q
    //   15: dup
    //   16: invokespecial 90	com/tencent/feedback/proguard/q:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: iload_1
    //   24: invokevirtual 93	com/tencent/feedback/proguard/q:a	(I)V
    //   27: aload 4
    //   29: new 95	java/util/Date
    //   32: dup
    //   33: invokespecial 96	java/util/Date:<init>	()V
    //   36: invokevirtual 99	java/util/Date:getTime	()J
    //   39: invokevirtual 102	com/tencent/feedback/proguard/q:a	(J)V
    //   42: aload 4
    //   44: aload_0
    //   45: getfield 63	com/tencent/feedback/proguard/y:i	Ljava/lang/String;
    //   48: invokevirtual 105	com/tencent/feedback/proguard/q:a	(Ljava/lang/String;)V
    //   51: aload 4
    //   53: aload_3
    //   54: invokevirtual 108	com/tencent/feedback/common/c:g	()Ljava/lang/String;
    //   57: invokevirtual 110	com/tencent/feedback/proguard/q:b	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 52	com/tencent/feedback/proguard/y:b	Landroid/content/Context;
    //   64: iconst_1
    //   65: anewarray 89	com/tencent/feedback/proguard/q
    //   68: dup
    //   69: iconst_0
    //   70: aload 4
    //   72: aastore
    //   73: invokestatic 115	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;[Lcom/tencent/feedback/proguard/q;)I
    //   76: istore_1
    //   77: iload_1
    //   78: ifle +7 -> 85
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -6 -> 81
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	y
    //   0	95	1	paramInt	int
    //   1	86	2	bool	boolean
    //   7	47	3	localc	com.tencent.feedback.common.c
    //   90	4	3	localObject	Object
    //   19	52	4	localq	q
    // Exception table:
    //   from	to	target	type
    //   4	8	90	finally
    //   12	77	90	finally
  }
  
  private int b(String paramString)
  {
    try
    {
      int m = a.b(this.b, paramString);
      return m;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(int paramInt)
  {
    try
    {
      this.j = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean h()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!a(2))
        {
          e.c("rqdp{ resume record fail}", new Object[0]);
          return bool;
        }
        e.e("rqdp{ resume state record true}", new Object[0]);
        if (b(this.i) >= this.g)
        {
          e.e("rqdp{ state max upload}", new Object[0]);
          b localb = f();
          if (localb != null) {
            if (0L <= 0L) {
              localb.a(new Runnable()
              {
                public final void run()
                {
                  f localf = y.this.g();
                  if (localf != null) {
                    localf.a(new A(y.a(y.this), y.a(), this.a));
                  }
                }
              });
            } else if (0L > 0L) {
              localb.a(new Runnable()
              {
                public final void run()
                {
                  f localf = y.this.g();
                  if (localf != null) {
                    localf.a(new A(y.a(y.this), y.a(), this.a));
                  }
                }
              }, 0L);
            }
          }
        }
      }
      finally {}
      bool = true;
    }
  }
  
  private boolean i()
  {
    try
    {
      boolean bool = a(1);
      e.e("rqdp{ launch state record %b}", new Object[] { Boolean.valueOf(bool) });
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
      int m = this.j;
      return m;
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
      int m = a.b(this.b, paramArrayOfq);
      return m;
    }
    finally
    {
      paramArrayOfq = finally;
      throw paramArrayOfq;
    }
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 54	com/tencent/feedback/proguard/y:c	Lcom/tencent/feedback/common/b;
    //   9: ifnull +138 -> 147
    //   12: ldc2_w 39
    //   15: ldc2_w 166
    //   18: lcmp
    //   19: ifle +133 -> 152
    //   22: ldc2_w 39
    //   25: lstore_1
    //   26: aload_0
    //   27: getfield 38	com/tencent/feedback/proguard/y:e	Z
    //   30: ifne +129 -> 159
    //   33: aload_0
    //   34: lload_1
    //   35: putfield 42	com/tencent/feedback/proguard/y:f	J
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 38	com/tencent/feedback/proguard/y:e	Z
    //   43: aload_0
    //   44: getfield 54	com/tencent/feedback/proguard/y:c	Lcom/tencent/feedback/common/b;
    //   47: bipush 19
    //   49: aload_0
    //   50: lconst_0
    //   51: aload_0
    //   52: getfield 42	com/tencent/feedback/proguard/y:f	J
    //   55: invokevirtual 170	com/tencent/feedback/common/b:a	(ILjava/lang/Runnable;JJ)Z
    //   58: pop
    //   59: aload_0
    //   60: invokevirtual 172	com/tencent/feedback/proguard/y:e	()J
    //   63: lstore_3
    //   64: new 95	java/util/Date
    //   67: dup
    //   68: invokespecial 96	java/util/Date:<init>	()V
    //   71: invokevirtual 99	java/util/Date:getTime	()J
    //   74: lstore 5
    //   76: lload_3
    //   77: lstore_1
    //   78: lload_3
    //   79: lload 5
    //   81: lcmp
    //   82: ifgt +16 -> 98
    //   85: aload_0
    //   86: aload_0
    //   87: invokevirtual 66	com/tencent/feedback/proguard/y:d	()J
    //   90: invokevirtual 174	com/tencent/feedback/proguard/y:b	(J)V
    //   93: aload_0
    //   94: invokevirtual 172	com/tencent/feedback/proguard/y:e	()J
    //   97: lstore_1
    //   98: lload_1
    //   99: lload 5
    //   101: lcmp
    //   102: ifle +42 -> 144
    //   105: aload_0
    //   106: getfield 54	com/tencent/feedback/proguard/y:c	Lcom/tencent/feedback/common/b;
    //   109: new 8	com/tencent/feedback/proguard/y$1
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 177	com/tencent/feedback/proguard/y$1:<init>	(Lcom/tencent/feedback/proguard/y;)V
    //   117: lload_1
    //   118: lload 5
    //   120: lsub
    //   121: invokevirtual 152	com/tencent/feedback/common/b:a	(Ljava/lang/Runnable;J)Z
    //   124: pop
    //   125: ldc 179
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: lload_1
    //   134: lload 5
    //   136: lsub
    //   137: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: aastore
    //   141: invokestatic 186	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: iconst_1
    //   145: istore 7
    //   147: aload_0
    //   148: monitorexit
    //   149: iload 7
    //   151: ireturn
    //   152: ldc2_w 166
    //   155: lstore_1
    //   156: goto -130 -> 26
    //   159: lload_1
    //   160: aload_0
    //   161: getfield 42	com/tencent/feedback/proguard/y:f	J
    //   164: lcmp
    //   165: ifeq -21 -> 144
    //   168: aload_0
    //   169: lload_1
    //   170: putfield 42	com/tencent/feedback/proguard/y:f	J
    //   173: aload_0
    //   174: getfield 54	com/tencent/feedback/proguard/y:c	Lcom/tencent/feedback/common/b;
    //   177: bipush 19
    //   179: iconst_1
    //   180: invokevirtual 189	com/tencent/feedback/common/b:a	(IZ)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 54	com/tencent/feedback/proguard/y:c	Lcom/tencent/feedback/common/b;
    //   188: bipush 19
    //   190: aload_0
    //   191: lconst_0
    //   192: aload_0
    //   193: getfield 42	com/tencent/feedback/proguard/y:f	J
    //   196: invokevirtual 170	com/tencent/feedback/common/b:a	(ILjava/lang/Runnable;JJ)Z
    //   199: pop
    //   200: goto -56 -> 144
    //   203: astore 8
    //   205: aload_0
    //   206: monitorexit
    //   207: aload 8
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	y
    //   0	210	1	paramLong	long
    //   63	16	3	l1	long
    //   74	61	5	l2	long
    //   1	149	7	bool	boolean
    //   203	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	12	203	finally
    //   26	76	203	finally
    //   85	98	203	finally
    //   105	144	203	finally
    //   159	200	203	finally
  }
  
  public final q[] a(String paramString)
  {
    try
    {
      paramString = a.a(this.b, paramString);
      return paramString;
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
      this.k = paramLong;
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
      boolean bool = a(3);
      e.e("rqdp{ next day state record %b}", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long d()
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
        localThrowable.printStackTrace();
        long l = new Date().getTime();
        l += 86400000L;
      }
    }
    finally {}
  }
  
  public final long e()
  {
    try
    {
      long l = this.k;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final b f()
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
  
  public final f g()
  {
    try
    {
      f localf = this.d;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void run()
  {
    int m = j() + 1;
    b(m);
    if (m == 1)
    {
      this.h = com.tencent.feedback.common.a.b(this.b, this.i);
      i();
      return;
    }
    boolean bool = com.tencent.feedback.common.a.b(this.b, this.i);
    for (;;)
    {
      try
      {
        if (bool != this.h)
        {
          this.h = bool;
          if (bool)
          {
            m = 1;
            if (m == 0) {
              break;
            }
            e.b("process:%s is resumed!", new Object[] { this.i });
            h();
            return;
          }
        }
      }
      finally {}
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.y
 * JD-Core Version:    0.7.0.1
 */