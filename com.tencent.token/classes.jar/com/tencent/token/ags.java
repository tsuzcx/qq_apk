package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ags
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static final Object c = new Object();
  public static AtomicBoolean d = new AtomicBoolean(false);
  
  static
  {
    new AtomicBoolean(false);
  }
  
  public static int a()
  {
    if (!a.get()) {
      return -10001;
    }
    if (agh.a == 0) {
      return -10018;
    }
    if (!b.get()) {
      return -10002;
    }
    return 0;
  }
  
  /* Error */
  public static void a(agr paramagr)
  {
    // Byte code:
    //   0: getstatic 45	com/tencent/token/aec:a	Lcom/tencent/token/aec;
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: putfield 48	com/tencent/token/aec:d	Lcom/tencent/token/agr;
    //   9: aload_2
    //   10: getfield 52	com/tencent/token/aec:f	Z
    //   13: ifne +163 -> 176
    //   16: aload_2
    //   17: iconst_1
    //   18: putfield 52	com/tencent/token/aec:f	Z
    //   21: aload_0
    //   22: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   25: invokestatic 62	com/tencent/token/agn:a	(Landroid/content/Context;)Z
    //   28: pop
    //   29: getstatic 67	com/tencent/token/ael:a	Lcom/tencent/token/ael;
    //   32: new 69	com/tencent/token/adw
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 72	com/tencent/token/adw:<init>	(Lcom/tencent/token/aec;)V
    //   40: putfield 75	com/tencent/token/ael:f	Lcom/tencent/token/aei;
    //   43: new 77	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 79
    //   49: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: astore_3
    //   53: aload_3
    //   54: getstatic 39	com/tencent/token/agh:a	I
    //   57: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: ldc 88
    //   64: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: new 93	android/os/HandlerThread
    //   71: dup
    //   72: aload_3
    //   73: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: bipush 248
    //   78: invokespecial 100	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   81: astore_3
    //   82: aload_3
    //   83: invokevirtual 103	android/os/HandlerThread:start	()V
    //   86: aload_2
    //   87: new 105	com/tencent/token/aec$a
    //   90: dup
    //   91: aload_2
    //   92: aload_3
    //   93: invokevirtual 109	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   96: aload_0
    //   97: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   100: invokespecial 112	com/tencent/token/aec$a:<init>	(Lcom/tencent/token/aec;Landroid/os/Looper;Landroid/content/Context;)V
    //   103: putfield 116	com/tencent/token/aec:e	Landroid/os/Handler;
    //   106: aload_2
    //   107: new 118	com/tencent/token/aef
    //   110: dup
    //   111: aload_2
    //   112: getfield 116	com/tencent/token/aec:e	Landroid/os/Handler;
    //   115: invokespecial 121	com/tencent/token/aef:<init>	(Landroid/os/Handler;)V
    //   118: putfield 125	com/tencent/token/aec:g	Lcom/tencent/token/aef;
    //   121: aload_0
    //   122: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   125: astore_3
    //   126: getstatic 130	com/tencent/token/aey:a	Ljava/util/Map;
    //   129: getstatic 133	com/tencent/token/aey:c	Ljava/lang/String;
    //   132: invokeinterface 139 2 0
    //   137: ifeq +28 -> 165
    //   140: new 141	com/tencent/token/aex
    //   143: dup
    //   144: getstatic 130	com/tencent/token/aey:a	Ljava/util/Map;
    //   147: getstatic 133	com/tencent/token/aey:c	Ljava/lang/String;
    //   150: invokeinterface 144 2 0
    //   155: checkcast 146	com/tencent/token/aey$a
    //   158: aload_3
    //   159: invokespecial 149	com/tencent/token/aex:<init>	(Lcom/tencent/token/aey$a;Landroid/content/Context;)V
    //   162: invokevirtual 152	java/lang/Thread:start	()V
    //   165: new 154	com/tencent/token/adx
    //   168: dup
    //   169: aload_2
    //   170: invokespecial 155	com/tencent/token/adx:<init>	(Lcom/tencent/token/aec;)V
    //   173: invokevirtual 152	java/lang/Thread:start	()V
    //   176: ldc 157
    //   178: monitorenter
    //   179: aload_0
    //   180: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   183: invokestatic 62	com/tencent/token/agn:a	(Landroid/content/Context;)Z
    //   186: pop
    //   187: aload_0
    //   188: putstatic 159	com/tencent/token/adz:e	Lcom/tencent/token/agr;
    //   191: aload_0
    //   192: putstatic 163	com/tencent/token/afk:b	Lcom/tencent/token/agr;
    //   195: new 165	com/tencent/turingfd/sdk/qps/Cumquat
    //   198: dup
    //   199: invokespecial 166	com/tencent/turingfd/sdk/qps/Cumquat:<init>	()V
    //   202: astore_2
    //   203: new 168	com/tencent/turingfd/sdk/qps/Dew
    //   206: dup
    //   207: invokespecial 169	com/tencent/turingfd/sdk/qps/Dew:<init>	()V
    //   210: astore_3
    //   211: aload_2
    //   212: aconst_null
    //   213: putfield 170	com/tencent/turingfd/sdk/qps/Cumquat:c	Ljava/lang/String;
    //   216: aload_3
    //   217: aload_0
    //   218: getfield 173	com/tencent/token/agr:i	Ljava/lang/String;
    //   221: putfield 174	com/tencent/turingfd/sdk/qps/Dew:c	Ljava/lang/String;
    //   224: aload_3
    //   225: aload_0
    //   226: getfield 177	com/tencent/token/agr:h	Ljava/lang/String;
    //   229: putfield 179	com/tencent/turingfd/sdk/qps/Dew:a	Ljava/lang/String;
    //   232: aload_3
    //   233: aload_0
    //   234: getfield 182	com/tencent/token/agr:k	Ljava/lang/String;
    //   237: putfield 184	com/tencent/turingfd/sdk/qps/Dew:d	Ljava/lang/String;
    //   240: aload_3
    //   241: aload_0
    //   242: getfield 187	com/tencent/token/agr:j	I
    //   245: putfield 189	com/tencent/turingfd/sdk/qps/Dew:b	I
    //   248: aload_3
    //   249: ldc 191
    //   251: putfield 193	com/tencent/turingfd/sdk/qps/Dew:e	Ljava/lang/String;
    //   254: aload_2
    //   255: aload_3
    //   256: putfield 196	com/tencent/turingfd/sdk/qps/Cumquat:d	Lcom/tencent/turingfd/sdk/qps/Dew;
    //   259: aload_2
    //   260: putstatic 199	com/tencent/token/adz:f	Lcom/tencent/turingfd/sdk/qps/Cumquat;
    //   263: getstatic 201	com/tencent/token/adz:d	Z
    //   266: istore_1
    //   267: iload_1
    //   268: ifeq +9 -> 277
    //   271: ldc 157
    //   273: monitorexit
    //   274: goto +186 -> 460
    //   277: iconst_1
    //   278: putstatic 201	com/tencent/token/adz:d	Z
    //   281: new 203	com/tencent/token/adu
    //   284: dup
    //   285: aload_0
    //   286: invokespecial 205	com/tencent/token/adu:<init>	(Lcom/tencent/token/agr;)V
    //   289: invokevirtual 152	java/lang/Thread:start	()V
    //   292: aload_0
    //   293: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   296: astore_2
    //   297: getstatic 208	com/tencent/token/adz:h	Lcom/tencent/token/acd;
    //   300: astore_3
    //   301: getstatic 211	com/tencent/token/adz:i	Lcom/tencent/token/acg;
    //   304: astore 4
    //   306: ldc 213
    //   308: monitorenter
    //   309: getstatic 216	com/tencent/token/aer:a	Ljava/util/List;
    //   312: aload_3
    //   313: invokeinterface 221 2 0
    //   318: pop
    //   319: aload 4
    //   321: putstatic 223	com/tencent/token/aer:b	Lcom/tencent/token/acg;
    //   324: aload_2
    //   325: invokevirtual 229	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   328: astore_2
    //   329: getstatic 231	com/tencent/token/aer:e	Lcom/tencent/token/acg;
    //   332: putstatic 234	com/tencent/token/ach:e	Lcom/tencent/token/acg;
    //   335: getstatic 236	com/tencent/token/ach:a	Z
    //   338: ifne +81 -> 419
    //   341: iconst_1
    //   342: putstatic 236	com/tencent/token/ach:a	Z
    //   345: ldc 233
    //   347: monitorenter
    //   348: new 93	android/os/HandlerThread
    //   351: dup
    //   352: ldc 238
    //   354: invokespecial 239	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 103	android/os/HandlerThread:start	()V
    //   362: new 241	com/tencent/token/ach$d
    //   365: dup
    //   366: aload_3
    //   367: invokevirtual 109	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   370: invokespecial 244	com/tencent/token/ach$d:<init>	(Landroid/os/Looper;)V
    //   373: putstatic 246	com/tencent/token/ach:b	Landroid/os/Handler;
    //   376: ldc 233
    //   378: monitorexit
    //   379: aload_2
    //   380: checkcast 248	android/app/Application
    //   383: astore_2
    //   384: ldc 233
    //   386: monitorenter
    //   387: getstatic 251	com/tencent/token/ach:h	Lcom/tencent/token/acm;
    //   390: astore_3
    //   391: aload_2
    //   392: aload_3
    //   393: invokevirtual 255	android/app/Application:unregisterActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   396: aload_2
    //   397: aload_3
    //   398: invokevirtual 258	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   401: ldc 233
    //   403: monitorexit
    //   404: goto +15 -> 419
    //   407: astore_0
    //   408: ldc 233
    //   410: monitorexit
    //   411: aload_0
    //   412: athrow
    //   413: astore_0
    //   414: ldc 233
    //   416: monitorexit
    //   417: aload_0
    //   418: athrow
    //   419: ldc 213
    //   421: monitorexit
    //   422: iconst_1
    //   423: putstatic 259	com/tencent/token/ach:f	Z
    //   426: ldc 157
    //   428: monitorenter
    //   429: getstatic 262	com/tencent/token/adz:b	Lcom/tencent/token/aeq;
    //   432: astore_2
    //   433: aload_2
    //   434: ifnull +20 -> 454
    //   437: aload_2
    //   438: invokevirtual 266	com/tencent/token/aeq:a	()Z
    //   441: ifeq +13 -> 454
    //   444: new 268	com/tencent/token/aem
    //   447: dup
    //   448: invokespecial 269	com/tencent/token/aem:<init>	()V
    //   451: invokevirtual 152	java/lang/Thread:start	()V
    //   454: ldc 157
    //   456: monitorexit
    //   457: ldc 157
    //   459: monitorexit
    //   460: getstatic 274	com/tencent/turingfd/sdk/qps/Peach:a	Lcom/tencent/turingfd/sdk/qps/Peach;
    //   463: astore_2
    //   464: new 276	com/tencent/token/aen
    //   467: dup
    //   468: aload_0
    //   469: getfield 57	com/tencent/token/agr:c	Landroid/content/Context;
    //   472: invokespecial 279	com/tencent/token/aen:<init>	(Landroid/content/Context;)V
    //   475: invokevirtual 152	java/lang/Thread:start	()V
    //   478: return
    //   479: astore_0
    //   480: ldc 157
    //   482: monitorexit
    //   483: aload_0
    //   484: athrow
    //   485: astore_0
    //   486: ldc 213
    //   488: monitorexit
    //   489: aload_0
    //   490: athrow
    //   491: astore_0
    //   492: ldc 157
    //   494: monitorexit
    //   495: aload_0
    //   496: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	paramagr	agr
    //   266	2	1	bool	boolean
    //   3	461	2	localObject1	Object
    //   52	346	3	localObject2	Object
    //   304	16	4	localacg	acg
    // Exception table:
    //   from	to	target	type
    //   387	401	407	finally
    //   348	376	413	finally
    //   429	433	479	finally
    //   437	454	479	finally
    //   309	348	485	finally
    //   376	384	485	finally
    //   384	387	485	finally
    //   401	404	485	finally
    //   408	413	485	finally
    //   414	419	485	finally
    //   179	267	491	finally
    //   277	309	491	finally
    //   419	429	491	finally
    //   454	457	491	finally
    //   480	485	491	finally
    //   486	491	491	finally
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(Locale.getDefault(), "TuringFD v%d", new Object[] { Integer.valueOf(61) }));
    localStringBuilder.append(" (C649EE4DD811C079");
    localStringBuilder.append(", qps");
    localStringBuilder.append(", d23ecf4");
    Object localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("mm");
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject);
    }
    localStringBuilder.append(", ");
    localObject = new StringBuilder();
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("s");
    if (((StringBuilder)localObject).toString().length() > 0) {
      ((StringBuilder)localObject).append(";");
    }
    ((StringBuilder)localObject).append("f");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localStringBuilder.append(String.format(Locale.getDefault(), ", compiled %s)", new Object[] { "2021_06_30_11_46_05" }));
    return localStringBuilder.toString();
  }
  
  public static void b(agr paramagr)
  {
    if (paramagr.q)
    {
      paramagr = acy.a();
      Object localObject1 = new ace("https://mazu.m.qq.com");
      try
      {
        boolean bool = paramagr.c.compareAndSet(false, true);
        if (!bool) {
          return;
        }
        HandlerThread localHandlerThread = new HandlerThread("TuringFdShark");
        localHandlerThread.start();
        localObject1 = new acy.b(localHandlerThread.getLooper(), (abx)localObject1);
        paramagr.b = ((acy.b)localObject1);
        Message.obtain((Handler)localObject1, 1).sendToTarget();
        return;
      }
      finally {}
    }
  }
  
  public static int c(agr paramagr)
  {
    if (a.get()) {
      return 0;
    }
    boolean bool2 = paramagr.f;
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramagr.g);
      paramagr = paramagr.g;
    }
    try
    {
      if (TextUtils.isEmpty(paramagr)) {
        System.loadLibrary("turingqps");
      } else {
        System.load(paramagr);
      }
    }
    finally
    {
      label58:
      break label58;
    }
    bool1 = false;
    a.set(bool1);
    break label77;
    a.set(true);
    label77:
    if (a.get()) {
      return 0;
    }
    return -10001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ags
 * JD-Core Version:    0.7.0.1
 */