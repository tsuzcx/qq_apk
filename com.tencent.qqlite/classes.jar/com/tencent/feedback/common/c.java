package com.tencent.feedback.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c p = null;
  private Context a = null;
  private String b = "";
  private byte c = -1;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private Map<String, PlugInInfo> o = null;
  
  private void a(byte paramByte)
  {
    try
    {
      this.c = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +220 -> 224
    //   7: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   10: ifnonnull +13 -> 23
    //   13: new 2	com/tencent/feedback/common/c
    //   16: dup
    //   17: invokespecial 70	com/tencent/feedback/common/c:<init>	()V
    //   20: putstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   23: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   26: astore_3
    //   27: aload_3
    //   28: monitorenter
    //   29: ldc 72
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 77	com/tencent/feedback/common/e:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   41: aload_0
    //   42: putfield 37	com/tencent/feedback/common/c:a	Landroid/content/Context;
    //   45: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   48: astore 4
    //   50: aload_0
    //   51: invokestatic 82	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   54: pop
    //   55: new 84	java/lang/StringBuffer
    //   58: dup
    //   59: invokespecial 85	java/lang/StringBuffer:<init>	()V
    //   62: astore 5
    //   64: aload 5
    //   66: invokestatic 88	com/tencent/feedback/common/d:a	()Ljava/lang/String;
    //   69: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload 5
    //   75: ldc 94
    //   77: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   80: pop
    //   81: aload 5
    //   83: invokestatic 96	com/tencent/feedback/common/d:b	()Ljava/lang/String;
    //   86: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: aload 5
    //   92: ldc 98
    //   94: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   97: pop
    //   98: aload 5
    //   100: invokestatic 100	com/tencent/feedback/common/d:c	()Ljava/lang/String;
    //   103: invokevirtual 92	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: aload 4
    //   109: aload 5
    //   111: invokevirtual 103	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   114: invokespecial 106	com/tencent/feedback/common/c:e	(Ljava/lang/String;)V
    //   117: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   120: iconst_1
    //   121: invokespecial 108	com/tencent/feedback/common/c:a	(B)V
    //   124: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   127: aload_0
    //   128: invokestatic 113	com/tencent/feedback/common/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   131: invokespecial 115	com/tencent/feedback/common/c:f	(Ljava/lang/String;)V
    //   134: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   137: aload_0
    //   138: invokestatic 117	com/tencent/feedback/common/a:c	(Landroid/content/Context;)Ljava/lang/String;
    //   141: invokespecial 119	com/tencent/feedback/common/c:g	(Ljava/lang/String;)V
    //   144: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   147: ldc 121
    //   149: invokespecial 123	com/tencent/feedback/common/c:h	(Ljava/lang/String;)V
    //   152: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   155: ldc 125
    //   157: invokespecial 127	com/tencent/feedback/common/c:i	(Ljava/lang/String;)V
    //   160: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   163: aload_1
    //   164: invokevirtual 129	com/tencent/feedback/common/c:a	(Ljava/lang/String;)V
    //   167: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   170: aload_2
    //   171: invokevirtual 131	com/tencent/feedback/common/c:b	(Ljava/lang/String;)V
    //   174: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   177: aload_0
    //   178: invokestatic 133	com/tencent/feedback/common/a:d	(Landroid/content/Context;)Ljava/lang/String;
    //   181: invokevirtual 135	com/tencent/feedback/common/c:c	(Ljava/lang/String;)V
    //   184: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   187: astore_1
    //   188: aload_0
    //   189: invokestatic 82	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   192: pop
    //   193: aload_1
    //   194: aload_0
    //   195: invokestatic 136	com/tencent/feedback/common/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   198: invokespecial 138	com/tencent/feedback/common/c:j	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: invokestatic 140	com/tencent/feedback/common/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   205: astore_0
    //   206: ldc 39
    //   208: aload_0
    //   209: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifne +16 -> 228
    //   215: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   218: aload_0
    //   219: invokespecial 148	com/tencent/feedback/common/c:k	(Ljava/lang/String;)V
    //   222: aload_3
    //   223: monitorexit
    //   224: ldc 2
    //   226: monitorexit
    //   227: return
    //   228: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   231: getstatic 31	com/tencent/feedback/common/c:p	Lcom/tencent/feedback/common/c;
    //   234: invokevirtual 149	com/tencent/feedback/common/c:c	()Ljava/lang/String;
    //   237: invokespecial 148	com/tencent/feedback/common/c:k	(Ljava/lang/String;)V
    //   240: goto -18 -> 222
    //   243: astore_0
    //   244: aload_3
    //   245: monitorexit
    //   246: aload_0
    //   247: athrow
    //   248: astore_0
    //   249: ldc 2
    //   251: monitorexit
    //   252: aload_0
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramContext	Context
    //   0	254	1	paramString1	String
    //   0	254	2	paramString2	String
    //   48	60	4	localc2	c
    //   62	48	5	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	222	243	finally
    //   222	224	243	finally
    //   228	240	243	finally
    //   7	23	248	finally
    //   23	29	248	finally
    //   244	248	248	finally
  }
  
  private void e(String paramString)
  {
    try
    {
      this.b = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void f(String paramString)
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
  
  private void g(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void h(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void i(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void j(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void k(String paramString)
  {
    try
    {
      this.n = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static c p()
  {
    try
    {
      c localc = p;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(long paramLong)
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
  
  public final void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      this.h = str;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
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
        if (this.o == null) {
          this.o = new HashMap();
        }
        this.o.put(paramString1, new PlugInInfo(paramString1, paramString2, paramString3));
        e.a("add %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
      finally {}
    }
  }
  
  public final byte b()
  {
    try
    {
      byte b1 = this.c;
      return b1;
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
      this.i = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String c()
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
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_0
    //   7: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 184 2 0
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
  
  public final String e()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String h()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long i()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String j()
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
  
  public final String k()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String l()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String m()
  {
    try
    {
      String str = this.n;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Map<String, PlugInInfo> n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   13: invokeinterface 190 1 0
    //   18: istore_1
    //   19: iload_1
    //   20: ifgt +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: new 163	java/util/HashMap
    //   32: dup
    //   33: aload_0
    //   34: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   37: invokeinterface 190 1 0
    //   42: invokespecial 193	java/util/HashMap:<init>	(I)V
    //   45: astore_2
    //   46: aload_2
    //   47: aload_0
    //   48: getfield 67	com/tencent/feedback/common/c:o	Ljava/util/Map;
    //   51: invokeinterface 197 2 0
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
  
  public final Context o()
  {
    try
    {
      Context localContext = this.a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("OS:").append(this.b).append(" | ");
    localStringBuffer.append("plat:").append(this.c).append(" | ");
    localStringBuffer.append("APD:").append(this.d).append(" , ");
    localStringBuffer.append(this.e).append(" | ");
    localStringBuffer.append("SPD:").append(this.f).append(" , ");
    localStringBuffer.append(this.g).append(" | ");
    localStringBuffer.append("UD:").append(this.h).append(" | ");
    localStringBuffer.append("GIP:").append(this.i).append(" | ");
    localStringBuffer.append("UUID:").append(this.k).append(" | ");
    localStringBuffer.append("IM:").append(this.m).append(" | ");
    localStringBuffer.append("@").append(super.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.common.c
 * JD-Core Version:    0.7.0.1
 */