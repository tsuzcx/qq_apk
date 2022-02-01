package com.tencent.map.sdk.a;

public final class jx
{
  private static int a = jy.a;
  private static int b = 1000;
  private static int c = jy.b;
  private static int d = 0;
  private static volatile boolean e = false;
  private static int f = 0;
  private static String g = null;
  private static String h = null;
  private static int[] i = new int[0];
  private static byte[] j = new byte[0];
  
  public static int a()
  {
    synchronized (j)
    {
      int k = b;
      return k;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    synchronized (j)
    {
      a = paramInt1;
      b = paramInt2;
      c = paramInt3;
      d = paramInt4;
      g = paramString1;
      i = paramArrayOfInt;
      h = paramString2;
      return;
    }
  }
  
  /* Error */
  public static void a(android.content.Context arg0)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokestatic 59	com/tencent/map/sdk/a/gf:a	(Landroid/content/Context;)Lcom/tencent/map/sdk/a/gf;
    //   11: astore 11
    //   13: aload 11
    //   15: ldc 61
    //   17: invokevirtual 64	com/tencent/map/sdk/a/gf:b	(Ljava/lang/String;)I
    //   20: istore_2
    //   21: aload 11
    //   23: ldc 66
    //   25: invokevirtual 64	com/tencent/map/sdk/a/gf:b	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: aload 11
    //   31: ldc 68
    //   33: invokevirtual 64	com/tencent/map/sdk/a/gf:b	(Ljava/lang/String;)I
    //   36: istore 4
    //   38: aload 11
    //   40: ldc 70
    //   42: invokevirtual 64	com/tencent/map/sdk/a/gf:b	(Ljava/lang/String;)I
    //   45: istore 5
    //   47: aload 11
    //   49: ldc 72
    //   51: invokevirtual 64	com/tencent/map/sdk/a/gf:b	(Ljava/lang/String;)I
    //   54: istore 6
    //   56: aload 11
    //   58: ldc 74
    //   60: invokevirtual 77	com/tencent/map/sdk/a/gf:c	(Ljava/lang/String;)Z
    //   63: istore 7
    //   65: aload 11
    //   67: ldc 79
    //   69: invokevirtual 82	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: iconst_0
    //   75: newarray int
    //   77: astore 8
    //   79: aload 8
    //   81: astore_0
    //   82: new 84	org/json/JSONArray
    //   85: dup
    //   86: aload 11
    //   88: ldc 86
    //   90: invokevirtual 82	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokespecial 89	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   96: astore 12
    //   98: aload 8
    //   100: astore_0
    //   101: aload 12
    //   103: invokevirtual 92	org/json/JSONArray:length	()I
    //   106: newarray int
    //   108: astore 9
    //   110: aload 9
    //   112: astore_0
    //   113: aload 9
    //   115: astore 8
    //   117: iload_1
    //   118: aload 9
    //   120: arraylength
    //   121: if_icmpge +28 -> 149
    //   124: aload 9
    //   126: astore_0
    //   127: aload 9
    //   129: iload_1
    //   130: aload 12
    //   132: iload_1
    //   133: invokevirtual 96	org/json/JSONArray:getInt	(I)I
    //   136: iastore
    //   137: iload_1
    //   138: iconst_1
    //   139: iadd
    //   140: istore_1
    //   141: goto -31 -> 110
    //   144: astore 8
    //   146: aload_0
    //   147: astore 8
    //   149: aload 11
    //   151: ldc 98
    //   153: invokevirtual 82	com/tencent/map/sdk/a/gf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 9
    //   158: getstatic 45	com/tencent/map/sdk/a/jx:j	[B
    //   161: astore_0
    //   162: aload_0
    //   163: monitorenter
    //   164: iload_3
    //   165: putstatic 28	com/tencent/map/sdk/a/jx:b	I
    //   168: iload 4
    //   170: putstatic 26	com/tencent/map/sdk/a/jx:a	I
    //   173: iload 5
    //   175: putstatic 31	com/tencent/map/sdk/a/jx:c	I
    //   178: iload 6
    //   180: putstatic 33	com/tencent/map/sdk/a/jx:d	I
    //   183: iload 7
    //   185: putstatic 35	com/tencent/map/sdk/a/jx:e	Z
    //   188: aload 10
    //   190: putstatic 39	com/tencent/map/sdk/a/jx:g	Ljava/lang/String;
    //   193: aload 8
    //   195: putstatic 43	com/tencent/map/sdk/a/jx:i	[I
    //   198: aload 9
    //   200: putstatic 41	com/tencent/map/sdk/a/jx:h	Ljava/lang/String;
    //   203: iload_2
    //   204: putstatic 37	com/tencent/map/sdk/a/jx:f	I
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: astore 8
    //   212: aload_0
    //   213: monitorexit
    //   214: aload 8
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	140	1	k	int
    //   20	184	2	m	int
    //   28	137	3	n	int
    //   36	133	4	i1	int
    //   45	129	5	i2	int
    //   54	125	6	i3	int
    //   63	121	7	bool	boolean
    //   77	39	8	localObject1	Object
    //   144	1	8	localException	java.lang.Exception
    //   147	47	8	localContext	android.content.Context
    //   210	5	8	localObject2	Object
    //   108	91	9	localObject3	Object
    //   72	117	10	str	String
    //   11	139	11	localgf	gf
    //   96	35	12	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   82	98	144	java/lang/Exception
    //   101	110	144	java/lang/Exception
    //   117	124	144	java/lang/Exception
    //   127	137	144	java/lang/Exception
    //   164	209	210	finally
    //   212	214	210	finally
  }
  
  public static void a(boolean paramBoolean)
  {
    synchronized (j)
    {
      e = paramBoolean;
      return;
    }
  }
  
  public static int b()
  {
    synchronized (j)
    {
      int k = a;
      return k;
    }
  }
  
  public static int c()
  {
    synchronized (j)
    {
      int k = c;
      return k;
    }
  }
  
  public static boolean d()
  {
    synchronized (j)
    {
      boolean bool = e;
      return bool;
    }
  }
  
  public static String e()
  {
    synchronized (j)
    {
      String str = g;
      return str;
    }
  }
  
  public static int f()
  {
    synchronized (j)
    {
      int k = d;
      return k;
    }
  }
  
  public static String g()
  {
    synchronized (j)
    {
      String str = h;
      return str;
    }
  }
  
  public static int[] h()
  {
    synchronized (j)
    {
      int[] arrayOfInt = i;
      return arrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jx
 * JD-Core Version:    0.7.0.1
 */