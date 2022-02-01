package com.tencent.feedback.common;

import android.content.Context;
import com.tencent.feedback.proguard.o;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static c E = null;
  private boolean A = true;
  private String B = null;
  private List<o> C;
  private Boolean D = null;
  private final long F;
  private int G = -1;
  private int H = -1;
  private Map<String, String> I = new HashMap();
  private Map<String, String> J = new HashMap();
  private final Context a;
  private final byte b;
  private String c;
  private String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private String j = "10000";
  private String k = "unknown";
  private long l = 0L;
  private String m = "";
  private String n = null;
  private String o = null;
  private String p = null;
  private String q = null;
  private String r = null;
  private String s = null;
  private String t = null;
  private long u = -1L;
  private long v = -1L;
  private long w = -1L;
  private String x = null;
  private String y = null;
  private Map<String, PlugInInfo> z = null;
  
  private c(Context paramContext)
  {
    e.b("rqdp{  init cominfo}", new Object[0]);
    Object localObject;
    if (paramContext == null) {
      localObject = paramContext;
    }
    for (;;)
    {
      this.a = ((Context)localObject);
      d.a(this.a);
      this.b = 1;
      this.c = a.b(paramContext);
      this.d = a.c(paramContext);
      this.e = "1.9.9";
      this.f = d.l();
      this.g = d.a();
      this.h = ("Android " + d.b() + ",level " + d.c());
      new StringBuilder().append(this.g).append(";").append(this.h).toString();
      this.F = new Date().getTime();
      this.i = a.i(this.a);
      return;
      Context localContext = paramContext.getApplicationContext();
      localObject = localContext;
      if (localContext == null) {
        localObject = paramContext;
      }
    }
  }
  
  private boolean O()
  {
    try
    {
      boolean bool = this.A;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (E == null) {
        E = new c(paramContext);
      }
      paramContext = E;
      return paramContext;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.A = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final List<o> A()
  {
    try
    {
      List localList = this.C;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String B()
  {
    try
    {
      String str = this.d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean C()
  {
    try
    {
      if (this.D == null) {
        this.D = Boolean.valueOf(h.a(this.a).a());
      }
      boolean bool = this.D.booleanValue();
      return bool;
    }
    finally {}
  }
  
  public final long D()
  {
    return this.F;
  }
  
  public final String E()
  {
    return this.i;
  }
  
  public final int F()
  {
    try
    {
      int i1 = this.G;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int G()
  {
    try
    {
      int i1 = this.H;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Map<String, String> H()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/tencent/feedback/common/c:I	Ljava/util/Map;
    //   6: invokeinterface 236 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifgt +9 -> 22
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: new 113	java/util/HashMap
    //   25: dup
    //   26: aload_0
    //   27: getfield 116	com/tencent/feedback/common/c:I	Ljava/util/Map;
    //   30: invokespecial 239	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   33: astore_2
    //   34: goto -16 -> 18
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	c
    //   11	2	1	i1	int
    //   17	17	2	localObject1	Object
    //   37	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	37	finally
    //   22	34	37	finally
  }
  
  public final int I()
  {
    try
    {
      int i1 = this.I.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Set<String> J()
  {
    try
    {
      Set localSet = this.I.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Map<String, String> K()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/feedback/common/c:J	Ljava/util/Map;
    //   6: invokeinterface 236 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifgt +9 -> 22
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: new 113	java/util/HashMap
    //   25: dup
    //   26: aload_0
    //   27: getfield 118	com/tencent/feedback/common/c:J	Ljava/util/Map;
    //   30: invokespecial 239	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   33: astore_2
    //   34: goto -16 -> 18
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	c
    //   11	2	1	i1	int
    //   17	17	2	localObject1	Object
    //   37	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	37	finally
    //   22	34	37	finally
  }
  
  public final int L()
  {
    try
    {
      int i1 = this.J.size();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Set<String> M()
  {
    try
    {
      Set localSet = this.J.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean N()
  {
    try
    {
      boolean bool = a.j(this.a);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final byte a()
  {
    return 1;
  }
  
  public final void a(int paramInt)
  {
    try
    {
      int i1 = this.G;
      if (i1 != paramInt)
      {
        this.G = paramInt;
        e.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.G) });
      }
      return;
    }
    finally {}
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.l = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +24 -> 27
    //   6: aload_1
    //   7: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 272	java/lang/String:length	()I
    //   13: ifeq +14 -> 27
    //   16: aload_1
    //   17: ldc 61
    //   19: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: istore_2
    //   23: iload_2
    //   24: ifeq +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: aload_1
    //   32: putfield 63	com/tencent/feedback/common/c:j	Ljava/lang/String;
    //   35: goto -8 -> 27
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	c
    //   0	43	1	paramString	String
    //   22	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	23	38	finally
    //   30	35	38	finally
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int i2 = 0;
    if (paramString1 != null) {}
    for (;;)
    {
      int i1;
      try
      {
        if (paramString1.trim().length() > 0)
        {
          i1 = 0;
          if (i1 == 0)
          {
            if ((paramString2 != null) && (paramString2.trim().length() > 0))
            {
              i1 = i2;
              break label123;
            }
          }
          else {
            e.c("key&value should not be empty %s %s", new Object[] { paramString1, paramString2 });
          }
        }
        else
        {
          i1 = 1;
          continue;
        }
        i1 = 1;
      }
      finally {}
      this.I.put(paramString1, paramString2);
      continue;
      label123:
      if (i1 == 0) {}
    }
  }
  
  public final void a(List<o> paramList)
  {
    try
    {
      this.C = paramList;
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.D = Boolean.valueOf(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (this.z == null) {
          this.z = new HashMap();
        }
        this.z.put(paramString1, new PlugInInfo(paramString1, paramString2, paramString3));
        e.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final String b()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.m = paramString;
      if (paramString != null) {
        b(false);
      }
      return;
    }
    finally {}
  }
  
  public final String c()
  {
    return this.e;
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
  {
    return this.f;
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.p = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.q = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String f()
  {
    return this.h;
  }
  
  /* Error */
  public final void f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 301 2 0
    //   28: pop
    //   29: goto -14 -> 15
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	c
    //   0	37	1	paramString	String
    //   10	2	2	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   6	11	32	finally
    //   18	29	32	finally
  }
  
  public final String g()
  {
    try
    {
      String str = this.j;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void g(String paramString)
  {
    this.B = paramString;
  }
  
  /* Error */
  public final String h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/feedback/common/c:m	Ljava/lang/String;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 73	com/tencent/feedback/common/c:m	Ljava/lang/String;
    //   13: invokevirtual 272	java/lang/String:length	()I
    //   16: ifne +12 -> 28
    //   19: aload_0
    //   20: invokevirtual 303	com/tencent/feedback/common/c:o	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield 73	com/tencent/feedback/common/c:m	Ljava/lang/String;
    //   32: astore_1
    //   33: goto -9 -> 24
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	c
    //   23	10	1	str	String
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	36	finally
    //   19	24	36	finally
    //   28	33	36	finally
  }
  
  public final void h(String paramString)
  {
    try
    {
      this.d = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String i()
  {
    try
    {
      String str = this.k;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void i(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final long j()
  {
    try
    {
      long l1 = this.l;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String j(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +51 -> 56
    //   8: aload_1
    //   9: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 272	java/lang/String:length	()I
    //   15: ifle +41 -> 56
    //   18: iload_2
    //   19: ifeq +42 -> 61
    //   22: ldc_w 306
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: new 160	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 281	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -40 -> 18
    //   61: aload_0
    //   62: getfield 116	com/tencent/feedback/common/c:I	Ljava/util/Map;
    //   65: aload_1
    //   66: invokeinterface 301 2 0
    //   71: checkcast 266	java/lang/String
    //   74: astore_1
    //   75: goto -23 -> 52
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	c
    //   0	83	1	paramString	String
    //   1	57	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   8	18	78	finally
    //   22	50	78	finally
    //   61	75	78	finally
  }
  
  public final String k()
  {
    try
    {
      if (this.n == null) {
        this.n = a.d(this.a);
      }
      String str = this.n;
      return str;
    }
    finally {}
  }
  
  /* Error */
  public final String k(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +51 -> 56
    //   8: aload_1
    //   9: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 272	java/lang/String:length	()I
    //   15: ifle +41 -> 56
    //   18: iload_2
    //   19: ifeq +42 -> 61
    //   22: ldc_w 306
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: new 160	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 281	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -40 -> 18
    //   61: aload_0
    //   62: getfield 116	com/tencent/feedback/common/c:I	Ljava/util/Map;
    //   65: aload_1
    //   66: invokeinterface 311 2 0
    //   71: checkcast 266	java/lang/String
    //   74: astore_1
    //   75: goto -23 -> 52
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	c
    //   0	83	1	paramString	String
    //   1	57	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   8	18	78	finally
    //   22	50	78	finally
    //   61	75	78	finally
  }
  
  public final String l()
  {
    try
    {
      if (this.p == null) {
        this.p = a.h(this.a);
      }
      String str = this.p;
      return str;
    }
    finally {}
  }
  
  /* Error */
  public final String l(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +51 -> 56
    //   8: aload_1
    //   9: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   12: invokevirtual 272	java/lang/String:length	()I
    //   15: ifle +41 -> 56
    //   18: iload_2
    //   19: ifeq +42 -> 61
    //   22: ldc_w 306
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: new 160	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   38: aload_1
    //   39: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 281	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -40 -> 18
    //   61: aload_0
    //   62: getfield 118	com/tencent/feedback/common/c:J	Ljava/util/Map;
    //   65: aload_1
    //   66: invokeinterface 311 2 0
    //   71: checkcast 266	java/lang/String
    //   74: astore_1
    //   75: goto -23 -> 52
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	c
    //   0	83	1	paramString	String
    //   1	57	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   8	18	78	finally
    //   22	50	78	finally
    //   61	75	78	finally
  }
  
  /* Error */
  public final boolean m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	com/tencent/feedback/common/c:p	Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	c
    //   12	7	1	bool	boolean
    //   6	2	2	str	String
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final String n()
  {
    try
    {
      if (this.q == null)
      {
        this.q = a.a(this.a);
        if ((this.q == null) || (this.q.equals(""))) {
          this.q = this.c;
        }
      }
      String str = this.q;
      return str;
    }
    finally {}
  }
  
  /* Error */
  public final String o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 317	com/tencent/feedback/common/c:O	()Z
    //   6: ifne +10 -> 16
    //   9: ldc 71
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 77	com/tencent/feedback/common/c:o	Ljava/lang/String;
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   27: invokestatic 132	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   30: pop
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   36: invokestatic 318	com/tencent/feedback/common/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   39: putfield 77	com/tencent/feedback/common/c:o	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 77	com/tencent/feedback/common/c:o	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -35 -> 12
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	c
    //   11	36	1	str	String
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   16	42	50	finally
    //   42	47	50	finally
  }
  
  /* Error */
  public final String p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 317	com/tencent/feedback/common/c:O	()Z
    //   6: ifne +10 -> 16
    //   9: ldc 71
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 83	com/tencent/feedback/common/c:r	Ljava/lang/String;
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   27: invokestatic 132	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   30: pop
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   36: invokestatic 320	com/tencent/feedback/common/d:e	(Landroid/content/Context;)Ljava/lang/String;
    //   39: putfield 83	com/tencent/feedback/common/c:r	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 83	com/tencent/feedback/common/c:r	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -35 -> 12
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	c
    //   11	36	1	str	String
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   16	42	50	finally
    //   42	47	50	finally
  }
  
  /* Error */
  public final String q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 317	com/tencent/feedback/common/c:O	()Z
    //   6: ifne +10 -> 16
    //   9: ldc 71
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 85	com/tencent/feedback/common/c:s	Ljava/lang/String;
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   27: invokestatic 132	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   30: pop
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   36: invokestatic 321	com/tencent/feedback/common/d:c	(Landroid/content/Context;)Ljava/lang/String;
    //   39: putfield 85	com/tencent/feedback/common/c:s	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 85	com/tencent/feedback/common/c:s	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -35 -> 12
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	c
    //   11	36	1	str	String
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   16	42	50	finally
    //   42	47	50	finally
  }
  
  /* Error */
  public final String r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 317	com/tencent/feedback/common/c:O	()Z
    //   6: ifne +10 -> 16
    //   9: ldc 71
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 87	com/tencent/feedback/common/c:t	Ljava/lang/String;
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   27: invokestatic 132	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   30: pop
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 127	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   36: invokestatic 322	com/tencent/feedback/common/d:d	(Landroid/content/Context;)Ljava/lang/String;
    //   39: putfield 87	com/tencent/feedback/common/c:t	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 87	com/tencent/feedback/common/c:t	Ljava/lang/String;
    //   46: astore_1
    //   47: goto -35 -> 12
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	c
    //   11	36	1	str	String
    //   50	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	50	finally
    //   16	42	50	finally
    //   42	47	50	finally
  }
  
  public final long s()
  {
    try
    {
      if (this.u <= 0L)
      {
        d.a(this.a);
        this.u = d.e();
      }
      long l1 = this.u;
      return l1;
    }
    finally {}
  }
  
  public final long t()
  {
    try
    {
      if (this.v <= 0L)
      {
        d.a(this.a);
        this.v = d.g();
      }
      long l1 = this.v;
      return l1;
    }
    finally {}
  }
  
  public final long u()
  {
    try
    {
      if (this.w <= 0L) {
        this.w = d.a(this.a).i();
      }
      long l1 = this.w;
      return l1;
    }
    finally {}
  }
  
  public final String v()
  {
    try
    {
      if (this.x == null)
      {
        d.a(this.a);
        this.x = d.d();
      }
      String str = this.x;
      return str;
    }
    finally {}
  }
  
  public final String w()
  {
    try
    {
      if (this.y == null) {
        this.y = d.a(this.a).m();
      }
      String str = this.y;
      return str;
    }
    finally {}
  }
  
  public final Map<String, PlugInInfo> x()
  {
    try
    {
      Map localMap = this.z;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Map<String, PlugInInfo> y()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   13: invokeinterface 236 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 113	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   37: invokeinterface 236 1 0
    //   42: invokespecial 335	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 101	com/tencent/feedback/common/c:z	Ljava/util/Map;
    //   51: invokeinterface 338 2 0
    //   56: goto -31 -> 25
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	c
    //   18	2	1	i1	int
    //   24	23	2	localObject1	Object
    //   59	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	59	finally
    //   29	56	59	finally
  }
  
  public final String z()
  {
    if (this.B == null)
    {
      d.a(this.a);
      this.B = d.k();
    }
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.c
 * JD-Core Version:    0.7.0.1
 */