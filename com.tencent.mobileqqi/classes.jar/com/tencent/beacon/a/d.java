package com.tencent.beacon.a;

import android.content.Context;

public final class d
{
  private static d n = null;
  private Context a = null;
  private String b = "";
  private String c = "";
  private byte d = -1;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = "";
  private String l = "";
  private String m = "";
  
  private void a(byte paramByte)
  {
    try
    {
      this.d = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +189 -> 193
    //   7: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   10: ifnonnull +13 -> 23
    //   13: new 2	com/tencent/beacon/a/d
    //   16: dup
    //   17: invokespecial 62	com/tencent/beacon/a/d:<init>	()V
    //   20: putstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   23: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: ldc 64
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 69	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   41: aload_0
    //   42: putfield 33	com/tencent/beacon/a/d:a	Landroid/content/Context;
    //   45: aload_0
    //   46: invokestatic 74	com/tencent/beacon/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/e;
    //   49: pop
    //   50: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   53: invokestatic 77	com/tencent/beacon/a/e:a	()Ljava/lang/String;
    //   56: putfield 37	com/tencent/beacon/a/d:b	Ljava/lang/String;
    //   59: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   62: astore_2
    //   63: new 79	java/lang/StringBuffer
    //   66: dup
    //   67: invokespecial 80	java/lang/StringBuffer:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 82
    //   74: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_3
    //   79: invokestatic 88	com/tencent/beacon/a/e:b	()Ljava/lang/String;
    //   82: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: aload_3
    //   87: ldc 90
    //   89: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: aload_3
    //   94: invokestatic 92	com/tencent/beacon/a/e:c	()Ljava/lang/String;
    //   97: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   100: pop
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 95	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   106: putfield 39	com/tencent/beacon/a/d:c	Ljava/lang/String;
    //   109: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   112: iconst_1
    //   113: invokespecial 97	com/tencent/beacon/a/d:a	(B)V
    //   116: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   119: aload_0
    //   120: invokestatic 102	com/tencent/beacon/a/a:e	(Landroid/content/Context;)Ljava/lang/String;
    //   123: invokespecial 105	com/tencent/beacon/a/d:d	(Ljava/lang/String;)V
    //   126: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   129: aload_0
    //   130: invokestatic 107	com/tencent/beacon/a/a:f	(Landroid/content/Context;)Ljava/lang/String;
    //   133: invokespecial 109	com/tencent/beacon/a/d:e	(Ljava/lang/String;)V
    //   136: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   139: ldc 111
    //   141: invokespecial 113	com/tencent/beacon/a/d:f	(Ljava/lang/String;)V
    //   144: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   147: ldc 115
    //   149: invokespecial 117	com/tencent/beacon/a/d:g	(Ljava/lang/String;)V
    //   152: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   155: ldc 119
    //   157: invokevirtual 121	com/tencent/beacon/a/d:a	(Ljava/lang/String;)V
    //   160: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   163: aload_0
    //   164: invokestatic 123	com/tencent/beacon/a/e:b	(Landroid/content/Context;)Ljava/lang/String;
    //   167: invokespecial 125	com/tencent/beacon/a/d:h	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokestatic 127	com/tencent/beacon/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   174: astore_0
    //   175: ldc 35
    //   177: aload_0
    //   178: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifne +16 -> 197
    //   184: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   187: aload_0
    //   188: invokevirtual 135	com/tencent/beacon/a/d:c	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: monitorexit
    //   193: ldc 2
    //   195: monitorexit
    //   196: return
    //   197: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   200: getstatic 27	com/tencent/beacon/a/d:n	Lcom/tencent/beacon/a/d;
    //   203: invokespecial 137	com/tencent/beacon/a/d:n	()Ljava/lang/String;
    //   206: invokevirtual 135	com/tencent/beacon/a/d:c	(Ljava/lang/String;)V
    //   209: goto -18 -> 191
    //   212: astore_0
    //   213: aload_1
    //   214: monitorexit
    //   215: aload_0
    //   216: athrow
    //   217: astore_0
    //   218: ldc 2
    //   220: monitorexit
    //   221: aload_0
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramContext	Context
    //   62	40	2	locald2	d
    //   70	33	3	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	191	212	finally
    //   191	193	212	finally
    //   197	209	212	finally
    //   7	23	217	finally
    //   23	29	217	finally
    //   213	217	217	finally
  }
  
  private void d(String paramString)
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
  
  private void e(String paramString)
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
  
  private void f(String paramString)
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
  
  private void g(String paramString)
  {
    try
    {
      this.h = paramString;
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
      this.k = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static d m()
  {
    try
    {
      d locald = n;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String n()
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
  
  public final String a()
  {
    return this.b;
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
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
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
  
  public final byte c()
  {
    try
    {
      byte b1 = this.d;
      return b1;
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
      this.l = paramString;
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
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String e()
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
  
  public final String f()
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
  
  public final String g()
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
  
  public final long h()
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
  
  public final String j()
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
  
  public final String k()
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
  
  public final Context l()
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
    localStringBuffer.append("model:").append(this.b).append(" | ");
    localStringBuffer.append("OS:").append(this.c).append(" | ");
    localStringBuffer.append("plat:").append(this.d).append(" | ");
    localStringBuffer.append("APD:").append(this.e).append(" , ");
    localStringBuffer.append(this.f).append(" | ");
    localStringBuffer.append("SPD:").append(this.g).append(" , ");
    localStringBuffer.append(this.h).append(" | ");
    localStringBuffer.append("GIP:").append(this.i).append(" | ");
    localStringBuffer.append("IM:").append(this.k).append(" | ");
    localStringBuffer.append("@").append(super.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.d
 * JD-Core Version:    0.7.0.1
 */