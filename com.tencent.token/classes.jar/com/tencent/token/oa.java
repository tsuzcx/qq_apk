package com.tencent.token;

import android.content.Context;

public class oa
{
  public static String a = "nonetwork";
  public static String b = "";
  private static final String c = "oa";
  private static String d = "cmwap";
  private static String e = "3gwap";
  private static String f = "uniwap";
  private static String g = "ctwap";
  private static String h = "wifi";
  private static Context i;
  private static volatile boolean j = true;
  private static String k = "";
  private static String l = "";
  private static volatile int m = 0;
  private static int n = 0;
  private static volatile boolean o = false;
  private static String p = "";
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        switch (m)
        {
        case 4: 
          localObject1 = new StringBuilder("4Gapn_");
          ((StringBuilder)localObject1).append(b);
          localObject1 = ((StringBuilder)localObject1).toString();
          break;
        case 2: 
        case 3: 
          localObject1 = new StringBuilder("apn_");
          ((StringBuilder)localObject1).append(b);
          break;
        case 1: 
          localObject1 = new StringBuilder("ssid_");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(l);
          continue;
          return localObject1;
        }
      }
      finally {}
      String str = "unknown";
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      i = paramContext;
      b();
      g();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a(Integer paramInteger)
  {
    try
    {
      if ((paramInteger.intValue() != 1) && (paramInteger.intValue() != 2))
      {
        int i1 = paramInteger.intValue();
        if (i1 != 3) {
          return false;
        }
      }
      return true;
    }
    finally
    {
      paramInteger = finally;
      throw paramInteger;
    }
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 95	com/tencent/token/oa:c	Ljava/lang/String;
    //   6: ldc 97
    //   8: invokestatic 102	com/tencent/token/li:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: getstatic 82	com/tencent/token/oa:i	Landroid/content/Context;
    //   14: ldc 104
    //   16: invokevirtual 110	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast 112	android/net/ConnectivityManager
    //   22: invokevirtual 116	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +35 -> 62
    //   30: ldc 11
    //   32: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   35: iconst_0
    //   36: putstatic 51	com/tencent/token/oa:m	I
    //   39: iconst_0
    //   40: putstatic 118	com/tencent/token/oa:o	Z
    //   43: ldc 11
    //   45: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   48: iconst_0
    //   49: putstatic 122	com/tencent/token/oa:j	Z
    //   52: getstatic 124	com/tencent/token/oa:a	Ljava/lang/String;
    //   55: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: aload_1
    //   63: invokevirtual 130	android/net/NetworkInfo:isAvailable	()Z
    //   66: ifeq +17 -> 83
    //   69: aload_1
    //   70: invokevirtual 133	android/net/NetworkInfo:isConnected	()Z
    //   73: ifeq +10 -> 83
    //   76: iconst_1
    //   77: putstatic 122	com/tencent/token/oa:j	Z
    //   80: goto +13 -> 93
    //   83: iconst_0
    //   84: putstatic 122	com/tencent/token/oa:j	Z
    //   87: getstatic 124	com/tencent/token/oa:a	Ljava/lang/String;
    //   90: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   93: aload_1
    //   94: invokevirtual 136	android/net/NetworkInfo:getType	()I
    //   97: istore_0
    //   98: iload_0
    //   99: iconst_1
    //   100: if_icmpne +55 -> 155
    //   103: iconst_1
    //   104: putstatic 51	com/tencent/token/oa:m	I
    //   107: iconst_0
    //   108: putstatic 118	com/tencent/token/oa:o	Z
    //   111: ldc 11
    //   113: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   116: getstatic 82	com/tencent/token/oa:i	Landroid/content/Context;
    //   119: ldc 29
    //   121: invokevirtual 110	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   124: checkcast 138	android/net/wifi/WifiManager
    //   127: invokevirtual 142	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 147	android/net/wifi/WifiInfo:getSSID	()Ljava/lang/String;
    //   135: putstatic 73	com/tencent/token/oa:k	Ljava/lang/String;
    //   138: aload_1
    //   139: invokevirtual 150	android/net/wifi/WifiInfo:getBSSID	()Ljava/lang/String;
    //   142: putstatic 75	com/tencent/token/oa:l	Ljava/lang/String;
    //   145: getstatic 152	com/tencent/token/oa:h	Ljava/lang/String;
    //   148: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   151: ldc 2
    //   153: monitorexit
    //   154: return
    //   155: aload_1
    //   156: invokevirtual 155	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   159: astore_2
    //   160: aload_2
    //   161: ifnonnull +25 -> 186
    //   164: ldc 11
    //   166: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   169: iconst_0
    //   170: putstatic 51	com/tencent/token/oa:m	I
    //   173: iconst_0
    //   174: putstatic 118	com/tencent/token/oa:o	Z
    //   177: ldc 11
    //   179: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   182: ldc 2
    //   184: monitorexit
    //   185: return
    //   186: aload_2
    //   187: invokevirtual 160	java/lang/String:trim	()Ljava/lang/String;
    //   190: invokevirtual 163	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   193: putstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   196: iload_0
    //   197: ifne +50 -> 247
    //   200: aload_1
    //   201: invokevirtual 166	android/net/NetworkInfo:getSubtype	()I
    //   204: istore_0
    //   205: iload_0
    //   206: iconst_1
    //   207: if_icmpeq +36 -> 243
    //   210: iload_0
    //   211: iconst_2
    //   212: if_icmpeq +31 -> 243
    //   215: iload_0
    //   216: iconst_4
    //   217: if_icmpne +6 -> 223
    //   220: goto +23 -> 243
    //   223: iload_0
    //   224: bipush 13
    //   226: if_icmpne +10 -> 236
    //   229: iconst_4
    //   230: putstatic 51	com/tencent/token/oa:m	I
    //   233: goto +14 -> 247
    //   236: iconst_3
    //   237: putstatic 51	com/tencent/token/oa:m	I
    //   240: goto +7 -> 247
    //   243: iconst_2
    //   244: putstatic 51	com/tencent/token/oa:m	I
    //   247: invokestatic 169	com/tencent/token/oa:h	()Ljava/lang/Integer;
    //   250: invokevirtual 93	java/lang/Integer:intValue	()I
    //   253: putstatic 171	com/tencent/token/oa:n	I
    //   256: getstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   259: getstatic 173	com/tencent/token/oa:e	Ljava/lang/String;
    //   262: invokevirtual 177	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +16 -> 281
    //   268: iconst_1
    //   269: putstatic 118	com/tencent/token/oa:o	Z
    //   272: ldc 179
    //   274: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   277: ldc 2
    //   279: monitorexit
    //   280: return
    //   281: getstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   284: getstatic 181	com/tencent/token/oa:d	Ljava/lang/String;
    //   287: invokevirtual 177	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +16 -> 306
    //   293: iconst_1
    //   294: putstatic 118	com/tencent/token/oa:o	Z
    //   297: ldc 179
    //   299: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   302: ldc 2
    //   304: monitorexit
    //   305: return
    //   306: getstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   309: getstatic 183	com/tencent/token/oa:f	Ljava/lang/String;
    //   312: invokevirtual 177	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   315: ifeq +16 -> 331
    //   318: iconst_1
    //   319: putstatic 118	com/tencent/token/oa:o	Z
    //   322: ldc 179
    //   324: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   327: ldc 2
    //   329: monitorexit
    //   330: return
    //   331: getstatic 60	com/tencent/token/oa:b	Ljava/lang/String;
    //   334: getstatic 185	com/tencent/token/oa:g	Ljava/lang/String;
    //   337: invokevirtual 177	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   340: ifeq +16 -> 356
    //   343: iconst_1
    //   344: putstatic 118	com/tencent/token/oa:o	Z
    //   347: ldc 187
    //   349: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   352: ldc 2
    //   354: monitorexit
    //   355: return
    //   356: iconst_0
    //   357: putstatic 118	com/tencent/token/oa:o	Z
    //   360: ldc 11
    //   362: putstatic 120	com/tencent/token/oa:p	Ljava/lang/String;
    //   365: ldc 2
    //   367: monitorexit
    //   368: return
    //   369: astore_1
    //   370: goto +12 -> 382
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 190	java/lang/Throwable:printStackTrace	()V
    //   378: ldc 2
    //   380: monitorexit
    //   381: return
    //   382: ldc 2
    //   384: monitorexit
    //   385: aload_1
    //   386: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   97	130	0	i1	int
    //   25	176	1	localObject1	Object
    //   369	1	1	localObject2	Object
    //   373	13	1	localThrowable	Throwable
    //   159	28	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	26	369	finally
    //   30	58	369	finally
    //   62	80	369	finally
    //   83	93	369	finally
    //   93	98	369	finally
    //   103	151	369	finally
    //   155	160	369	finally
    //   164	182	369	finally
    //   186	196	369	finally
    //   200	205	369	finally
    //   229	233	369	finally
    //   236	240	369	finally
    //   243	247	369	finally
    //   247	277	369	finally
    //   281	302	369	finally
    //   306	327	369	finally
    //   331	352	369	finally
    //   356	365	369	finally
    //   374	378	369	finally
    //   3	26	373	java/lang/Throwable
    //   30	58	373	java/lang/Throwable
    //   62	80	373	java/lang/Throwable
    //   83	93	373	java/lang/Throwable
    //   93	98	373	java/lang/Throwable
    //   103	151	373	java/lang/Throwable
    //   155	160	373	java/lang/Throwable
    //   164	182	373	java/lang/Throwable
    //   186	196	373	java/lang/Throwable
    //   200	205	373	java/lang/Throwable
    //   229	233	373	java/lang/Throwable
    //   236	240	373	java/lang/Throwable
    //   243	247	373	java/lang/Throwable
    //   247	277	373	java/lang/Throwable
    //   281	302	373	java/lang/Throwable
    //   306	327	373	java/lang/Throwable
    //   331	352	373	java/lang/Throwable
    //   356	365	373	java/lang/Throwable
  }
  
  public static boolean c()
  {
    return m == 1;
  }
  
  public static int d()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int e()
  {
    try
    {
      int i1 = n;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean f()
  {
    return j;
  }
  
  private static void g()
  {
    try
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder("showApnInfo... Apn:");
      localStringBuilder.append(b);
      localStringBuilder.append(",sIsNetworkOk:");
      localStringBuilder.append(j);
      localStringBuilder.append(",sNetType:");
      localStringBuilder.append(m);
      localStringBuilder.append(",sIsProxy:");
      localStringBuilder.append(o);
      localStringBuilder.append(",sProxyAddress:");
      localStringBuilder.append(p);
      li.b(str, localStringBuilder.toString());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static Integer h()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oa
 * JD-Core Version:    0.7.0.1
 */