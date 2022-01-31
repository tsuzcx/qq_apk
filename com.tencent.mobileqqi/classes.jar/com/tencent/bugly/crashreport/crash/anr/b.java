package com.tencent.bugly.crashreport.crash.anr;

import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final w e;
  private final com.tencent.bugly.crashreport.common.strategy.a f;
  private final String g;
  private final com.tencent.bugly.crashreport.crash.b h;
  private FileObserver i;
  private boolean j = true;
  
  public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb)
  {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
  }
  
  private CrashDetailBean a(a parama)
  {
    localCrashDetailBean = new CrashDetailBean();
    try
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.f();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.j();
      localCrashDetailBean.F = this.d.o();
      localCrashDetailBean.G = this.d.n();
      localCrashDetailBean.H = this.d.p();
      localCrashDetailBean.w = z.a(this.c, c.e, c.h);
      localCrashDetailBean.b = 3;
      localCrashDetailBean.e = this.d.g();
      localCrashDetailBean.f = this.d.l;
      localCrashDetailBean.g = this.d.v();
      localCrashDetailBean.m = this.d.f();
      localCrashDetailBean.n = "ANR_EXCEPTION";
      localCrashDetailBean.o = parama.f;
      localCrashDetailBean.q = parama.g;
      localCrashDetailBean.O = new HashMap();
      localCrashDetailBean.O.put("BUGLY_CR_01", parama.e);
      int k = -1;
      if (localCrashDetailBean.q != null) {
        k = localCrashDetailBean.q.indexOf("\n");
      }
      if (k > 0) {}
      for (String str = localCrashDetailBean.q.substring(0, k);; str = "GET_FAIL")
      {
        localCrashDetailBean.p = str;
        localCrashDetailBean.r = parama.c;
        if (localCrashDetailBean.q != null) {
          localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
        }
        localCrashDetailBean.z = parama.b;
        localCrashDetailBean.A = parama.a;
        localCrashDetailBean.B = "main(1)";
        localCrashDetailBean.I = this.d.x();
        localCrashDetailBean.h = this.d.u();
        localCrashDetailBean.i = this.d.I();
        localCrashDetailBean.v = parama.d;
        localCrashDetailBean.L = this.d.p;
        localCrashDetailBean.M = this.d.a;
        localCrashDetailBean.N = this.d.a();
        localCrashDetailBean.P = this.d.G();
        localCrashDetailBean.Q = this.d.H();
        localCrashDetailBean.R = this.d.A();
        localCrashDetailBean.S = this.d.F();
        this.h.c(localCrashDetailBean);
        localCrashDetailBean.y = y.a();
        return localCrashDetailBean;
      }
      return localCrashDetailBean;
    }
    catch (Throwable parama)
    {
      if (!x.a(parama)) {
        parama.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 316	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 323 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 325
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 63	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 334	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 334	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 341	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 344	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 334	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 347	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 349
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 352
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 354	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 364	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 370
    //   158: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 373	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 378	java/io/BufferedWriter
    //   187: dup
    //   188: new 380	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 383	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 386	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   205: ldc_w 388
    //   208: invokeinterface 392 2 0
    //   213: checkcast 394	[Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +77 -> 297
    //   223: aload 4
    //   225: arraylength
    //   226: iconst_3
    //   227: if_icmplt +70 -> 297
    //   230: aload 4
    //   232: iconst_0
    //   233: aaload
    //   234: astore_0
    //   235: aload 4
    //   237: iconst_1
    //   238: aaload
    //   239: astore_2
    //   240: aload 4
    //   242: iconst_2
    //   243: aaload
    //   244: astore 4
    //   246: aload_1
    //   247: new 354	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 396
    //   254: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 4
    //   259: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 399
    //   265: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 186
    //   274: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 401
    //   284: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 404	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   293: aload_1
    //   294: invokevirtual 407	java/io/BufferedWriter:flush	()V
    //   297: aload_3
    //   298: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   301: invokeinterface 411 1 0
    //   306: invokeinterface 417 1 0
    //   311: astore_0
    //   312: aload_0
    //   313: invokeinterface 422 1 0
    //   318: ifeq +238 -> 556
    //   321: aload_0
    //   322: invokeinterface 426 1 0
    //   327: checkcast 428	java/util/Map$Entry
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 431 1 0
    //   337: checkcast 188	java/lang/String
    //   340: ldc_w 388
    //   343: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifne -34 -> 312
    //   349: aload_2
    //   350: invokeinterface 438 1 0
    //   355: ifnull -43 -> 312
    //   358: aload_2
    //   359: invokeinterface 438 1 0
    //   364: checkcast 394	[Ljava/lang/String;
    //   367: arraylength
    //   368: iconst_3
    //   369: if_icmplt -57 -> 312
    //   372: aload_2
    //   373: invokeinterface 438 1 0
    //   378: checkcast 394	[Ljava/lang/String;
    //   381: iconst_0
    //   382: aaload
    //   383: astore_3
    //   384: aload_2
    //   385: invokeinterface 438 1 0
    //   390: checkcast 394	[Ljava/lang/String;
    //   393: iconst_1
    //   394: aaload
    //   395: astore 4
    //   397: aload_2
    //   398: invokeinterface 438 1 0
    //   403: checkcast 394	[Ljava/lang/String;
    //   406: iconst_2
    //   407: aaload
    //   408: astore 5
    //   410: aload_1
    //   411: new 354	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 440
    //   418: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload_2
    //   422: invokeinterface 431 1 0
    //   427: checkcast 188	java/lang/String
    //   430: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 442
    //   436: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 5
    //   441: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 399
    //   447: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 186
    //   456: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 4
    //   461: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 401
    //   467: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 404	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   476: aload_1
    //   477: invokevirtual 407	java/io/BufferedWriter:flush	()V
    //   480: goto -168 -> 312
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: aload_2
    //   487: astore_1
    //   488: aload_1
    //   489: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   492: ifne +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   499: ldc_w 445
    //   502: iconst_1
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: new 354	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   515: aload_1
    //   516: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   519: invokevirtual 364	java/lang/Class:getName	()Ljava/lang/String;
    //   522: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 370
    //   528: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: aastore
    //   542: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   545: pop
    //   546: aload_0
    //   547: ifnull +7 -> 554
    //   550: aload_0
    //   551: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   554: iconst_0
    //   555: ireturn
    //   556: aload_1
    //   557: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   560: iconst_1
    //   561: ireturn
    //   562: astore_0
    //   563: aload_0
    //   564: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   567: ifne -7 -> 560
    //   570: aload_0
    //   571: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   574: goto -14 -> 560
    //   577: astore_0
    //   578: aload_0
    //   579: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   582: ifne -28 -> 554
    //   585: aload_0
    //   586: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   589: goto -35 -> 554
    //   592: astore_0
    //   593: aconst_null
    //   594: astore_1
    //   595: aload_1
    //   596: ifnull +7 -> 603
    //   599: aload_1
    //   600: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   603: aload_0
    //   604: athrow
    //   605: astore_1
    //   606: aload_1
    //   607: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   610: ifne -7 -> 603
    //   613: aload_1
    //   614: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   617: goto -14 -> 603
    //   620: astore_0
    //   621: goto -26 -> 595
    //   624: astore_2
    //   625: aload_0
    //   626: astore_1
    //   627: aload_2
    //   628: astore_0
    //   629: goto -34 -> 595
    //   632: astore_1
    //   633: goto -145 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramString1	String
    //   0	636	1	paramString2	String
    //   0	636	2	paramString3	String
    //   6	445	3	localObject1	Object
    //   216	244	4	localObject2	Object
    //   408	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	81	117	java/lang/Exception
    //   81	86	117	java/lang/Exception
    //   201	218	483	java/io/IOException
    //   223	230	483	java/io/IOException
    //   246	297	483	java/io/IOException
    //   297	312	483	java/io/IOException
    //   312	480	483	java/io/IOException
    //   556	560	562	java/io/IOException
    //   550	554	577	java/io/IOException
    //   184	201	592	finally
    //   599	603	605	java/io/IOException
    //   201	218	620	finally
    //   223	230	620	finally
    //   246	297	620	finally
    //   297	312	620	finally
    //   312	480	620	finally
    //   488	499	624	finally
    //   499	546	624	finally
    //   184	201	632	java/io/IOException
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        c();
        return;
      }
      finally {}
      d();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 456	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 458
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 6	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 462
    //   32: bipush 8
    //   34: invokespecial 465	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 472	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 474
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 73	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   62: new 8	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 479	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 484	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: goto -54 -> 20
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 486
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne -78 -> 20
    //   101: aload_1
    //   102: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   105: goto -85 -> 20
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	b
    //   77	25	1	localThrowable	Throwable
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	74	77	java/lang/Throwable
    //   2	20	108	finally
    //   23	40	108	finally
    //   40	74	108	finally
    //   78	105	108	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.j != paramBoolean)
      {
        x.a("user change anr %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.j = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 456	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 496
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 499	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 501
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 503
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne -45 -> 20
    //   68: aload_1
    //   69: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   72: goto -52 -> 20
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   49	20	1	localThrowable	Throwable
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	java/lang/Throwable
    //   2	20	75	finally
    //   23	46	75	finally
    //   50	72	75	finally
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
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
    //   0	27	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localFileObserver	FileObserver
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    boolean bool = true;
    if (paramStrategyBean == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramStrategyBean.j != e()) {
          x.d("server anr changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.j) });
        }
        if ((paramStrategyBean.j) && (f()))
        {
          if (bool == e()) {
            break;
          }
          x.a("anr changed to %b", new Object[] { Boolean.valueOf(bool) });
          b(bool);
          break;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 517	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 519
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 526
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: ldc2_w 41
    //   50: lstore_3
    //   51: aload_1
    //   52: iconst_0
    //   53: invokestatic 530	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +9 -> 69
    //   63: aload 7
    //   65: getfield 531	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   68: lstore_3
    //   69: lload_3
    //   70: lstore 5
    //   72: lload_3
    //   73: ldc2_w 41
    //   76: lcmp
    //   77: ifne +19 -> 96
    //   80: ldc_w 533
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   90: pop
    //   91: invokestatic 538	java/lang/System:currentTimeMillis	()J
    //   94: lstore 5
    //   96: lload 5
    //   98: aload_0
    //   99: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   102: lsub
    //   103: invokestatic 544	java/lang/Math:abs	(J)J
    //   106: ldc2_w 545
    //   109: lcmp
    //   110: ifge +37 -> 147
    //   113: ldc_w 548
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: sipush 10000
    //   125: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_0
    //   134: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   137: iconst_0
    //   138: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   141: return
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: aload_0
    //   148: lload 5
    //   150: putfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   153: aload_0
    //   154: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   157: iconst_1
    //   158: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   161: getstatic 555	com/tencent/bugly/crashreport/crash/c:f	I
    //   164: iconst_0
    //   165: invokestatic 558	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   168: astore 8
    //   170: aload 8
    //   172: ifnull +13 -> 185
    //   175: aload 8
    //   177: invokeinterface 323 1 0
    //   182: ifgt +49 -> 231
    //   185: ldc_w 560
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   195: pop
    //   196: aload_0
    //   197: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   200: iconst_0
    //   201: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   204: return
    //   205: astore_1
    //   206: aload_1
    //   207: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   210: pop
    //   211: ldc_w 562
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   221: pop
    //   222: aload_0
    //   223: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   226: iconst_0
    //   227: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   230: return
    //   231: aload_0
    //   232: getfield 53	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   235: astore 7
    //   237: ldc2_w 545
    //   240: lconst_0
    //   241: lcmp
    //   242: ifge +136 -> 378
    //   245: lconst_0
    //   246: lstore_3
    //   247: ldc_w 564
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   257: pop
    //   258: aload 7
    //   260: ldc_w 566
    //   263: invokevirtual 570	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   266: checkcast 572	android/app/ActivityManager
    //   269: astore 9
    //   271: lload_3
    //   272: ldc2_w 573
    //   275: ldiv
    //   276: lstore_3
    //   277: iconst_0
    //   278: istore_2
    //   279: ldc_w 576
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   289: pop
    //   290: aload 9
    //   292: invokevirtual 580	android/app/ActivityManager:getProcessesInErrorState	()Ljava/util/List;
    //   295: astore 7
    //   297: aload 7
    //   299: ifnull +86 -> 385
    //   302: aload 7
    //   304: invokeinterface 583 1 0
    //   309: astore 10
    //   311: aload 10
    //   313: invokeinterface 422 1 0
    //   318: ifeq +67 -> 385
    //   321: aload 10
    //   323: invokeinterface 426 1 0
    //   328: checkcast 585	android/app/ActivityManager$ProcessErrorStateInfo
    //   331: astore 7
    //   333: aload 7
    //   335: getfield 588	android/app/ActivityManager$ProcessErrorStateInfo:condition	I
    //   338: iconst_2
    //   339: if_icmpne -28 -> 311
    //   342: ldc_w 590
    //   345: iconst_0
    //   346: anewarray 4	java/lang/Object
    //   349: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   352: pop
    //   353: aload 7
    //   355: ifnonnull +60 -> 415
    //   358: ldc_w 592
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   368: pop
    //   369: aload_0
    //   370: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   373: iconst_0
    //   374: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   377: return
    //   378: ldc2_w 545
    //   381: lstore_3
    //   382: goto -135 -> 247
    //   385: ldc2_w 573
    //   388: invokestatic 595	com/tencent/bugly/proguard/z:b	(J)V
    //   391: iload_2
    //   392: i2l
    //   393: lload_3
    //   394: lcmp
    //   395: iflt +678 -> 1073
    //   398: ldc_w 597
    //   401: iconst_0
    //   402: anewarray 4	java/lang/Object
    //   405: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   408: pop
    //   409: aconst_null
    //   410: astore 7
    //   412: goto -59 -> 353
    //   415: aload 7
    //   417: getfield 600	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   420: invokestatic 605	android/os/Process:myPid	()I
    //   423: if_icmpeq +31 -> 454
    //   426: ldc_w 607
    //   429: iconst_1
    //   430: anewarray 4	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload 7
    //   437: getfield 610	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   440: aastore
    //   441: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   444: pop
    //   445: aload_0
    //   446: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   449: iconst_0
    //   450: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   453: return
    //   454: ldc_w 612
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   464: pop
    //   465: new 63	java/io/File
    //   468: dup
    //   469: aload_0
    //   470: getfield 53	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   473: invokevirtual 615	android/content/Context:getFilesDir	()Ljava/io/File;
    //   476: new 354	java/lang/StringBuilder
    //   479: dup
    //   480: ldc_w 617
    //   483: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   486: lload 5
    //   488: invokevirtual 620	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: ldc_w 622
    //   494: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokespecial 625	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   503: astore 10
    //   505: new 161	com/tencent/bugly/crashreport/crash/anr/a
    //   508: dup
    //   509: invokespecial 626	com/tencent/bugly/crashreport/crash/anr/a:<init>	()V
    //   512: astore 9
    //   514: aload 9
    //   516: lload 5
    //   518: putfield 200	com/tencent/bugly/crashreport/crash/anr/a:c	J
    //   521: aload 9
    //   523: aload 10
    //   525: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   528: putfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   531: aload 9
    //   533: aload 7
    //   535: getfield 610	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   538: putfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   541: aload 9
    //   543: aload 7
    //   545: getfield 629	android/app/ActivityManager$ProcessErrorStateInfo:shortMsg	Ljava/lang/String;
    //   548: putfield 162	com/tencent/bugly/crashreport/crash/anr/a:f	Ljava/lang/String;
    //   551: aload 9
    //   553: aload 7
    //   555: getfield 632	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   558: putfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   561: aload 9
    //   563: aload 8
    //   565: putfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   568: aload 8
    //   570: ifnull +112 -> 682
    //   573: aload 8
    //   575: invokeinterface 635 1 0
    //   580: invokeinterface 417 1 0
    //   585: astore 7
    //   587: aload 7
    //   589: invokeinterface 422 1 0
    //   594: ifeq +88 -> 682
    //   597: aload 7
    //   599: invokeinterface 426 1 0
    //   604: checkcast 188	java/lang/String
    //   607: astore 10
    //   609: aload 10
    //   611: ldc_w 637
    //   614: invokevirtual 641	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   617: ifeq -30 -> 587
    //   620: aload 9
    //   622: aload 8
    //   624: aload 10
    //   626: invokeinterface 392 2 0
    //   631: checkcast 188	java/lang/String
    //   634: putfield 165	com/tencent/bugly/crashreport/crash/anr/a:g	Ljava/lang/String;
    //   637: goto -50 -> 587
    //   640: astore_1
    //   641: aload_1
    //   642: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   645: ifne +7 -> 652
    //   648: aload_1
    //   649: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   652: ldc_w 643
    //   655: iconst_1
    //   656: anewarray 4	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: aload_1
    //   662: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   665: invokevirtual 644	java/lang/Class:toString	()Ljava/lang/String;
    //   668: aastore
    //   669: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   672: pop
    //   673: aload_0
    //   674: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   677: iconst_0
    //   678: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   681: return
    //   682: aload 9
    //   684: getfield 200	com/tencent/bugly/crashreport/crash/anr/a:c	J
    //   687: lstore_3
    //   688: aload 9
    //   690: getfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   693: astore 7
    //   695: aload 9
    //   697: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   700: astore 8
    //   702: aload 9
    //   704: getfield 162	com/tencent/bugly/crashreport/crash/anr/a:f	Ljava/lang/String;
    //   707: astore 10
    //   709: aload 9
    //   711: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   714: astore 11
    //   716: aload 9
    //   718: getfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   721: ifnonnull +104 -> 825
    //   724: iconst_0
    //   725: istore_2
    //   726: ldc_w 646
    //   729: bipush 6
    //   731: anewarray 4	java/lang/Object
    //   734: dup
    //   735: iconst_0
    //   736: lload_3
    //   737: invokestatic 651	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   740: aastore
    //   741: dup
    //   742: iconst_1
    //   743: aload 7
    //   745: aastore
    //   746: dup
    //   747: iconst_2
    //   748: aload 8
    //   750: aastore
    //   751: dup
    //   752: iconst_3
    //   753: aload 10
    //   755: aastore
    //   756: dup
    //   757: iconst_4
    //   758: aload 11
    //   760: aastore
    //   761: dup
    //   762: iconst_5
    //   763: iload_2
    //   764: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: aastore
    //   768: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   771: pop
    //   772: aload_0
    //   773: getfield 75	com/tencent/bugly/crashreport/crash/anr/b:f	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   776: invokevirtual 655	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   779: ifne +60 -> 839
    //   782: ldc_w 657
    //   785: iconst_0
    //   786: anewarray 4	java/lang/Object
    //   789: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   792: pop
    //   793: ldc_w 659
    //   796: invokestatic 661	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   799: aload 9
    //   801: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   804: ldc_w 388
    //   807: aload 9
    //   809: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   812: aconst_null
    //   813: invokestatic 664	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   816: aload_0
    //   817: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   820: iconst_0
    //   821: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   824: return
    //   825: aload 9
    //   827: getfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   830: invokeinterface 323 1 0
    //   835: istore_2
    //   836: goto -110 -> 726
    //   839: aload_0
    //   840: getfield 75	com/tencent/bugly/crashreport/crash/anr/b:f	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   843: invokevirtual 667	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   846: getfield 507	com/tencent/bugly/crashreport/common/strategy/StrategyBean:j	Z
    //   849: ifne +28 -> 877
    //   852: ldc_w 669
    //   855: iconst_0
    //   856: anewarray 4	java/lang/Object
    //   859: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   862: pop
    //   863: goto -47 -> 816
    //   866: astore_1
    //   867: aload_0
    //   868: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   871: iconst_0
    //   872: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   875: aload_1
    //   876: athrow
    //   877: ldc_w 671
    //   880: iconst_0
    //   881: anewarray 4	java/lang/Object
    //   884: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   887: pop
    //   888: aload_0
    //   889: aload 9
    //   891: invokespecial 673	com/tencent/bugly/crashreport/crash/anr/b:a	(Lcom/tencent/bugly/crashreport/crash/anr/a;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   894: astore 7
    //   896: aload 7
    //   898: ifnonnull +17 -> 915
    //   901: ldc_w 675
    //   904: iconst_0
    //   905: anewarray 4	java/lang/Object
    //   908: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   911: pop
    //   912: goto -96 -> 816
    //   915: invokestatic 678	com/tencent/bugly/crashreport/crash/c:a	()Lcom/tencent/bugly/crashreport/crash/c;
    //   918: aload 7
    //   920: invokevirtual 680	com/tencent/bugly/crashreport/crash/c:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   923: aload 7
    //   925: getfield 681	com/tencent/bugly/crashreport/crash/CrashDetailBean:a	J
    //   928: lconst_0
    //   929: lcmp
    //   930: iflt +129 -> 1059
    //   933: ldc_w 683
    //   936: iconst_0
    //   937: anewarray 4	java/lang/Object
    //   940: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   943: pop
    //   944: aload_1
    //   945: ifnull +53 -> 998
    //   948: new 63	java/io/File
    //   951: dup
    //   952: aload_1
    //   953: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   956: invokevirtual 334	java/io/File:exists	()Z
    //   959: ifeq +39 -> 998
    //   962: aload_0
    //   963: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   966: iconst_3
    //   967: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   970: aload_1
    //   971: aload 9
    //   973: getfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   976: aload 9
    //   978: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   981: invokestatic 685	com/tencent/bugly/crashreport/crash/anr/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   984: ifeq +14 -> 998
    //   987: ldc_w 687
    //   990: iconst_0
    //   991: anewarray 4	java/lang/Object
    //   994: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   997: pop
    //   998: ldc_w 659
    //   1001: invokestatic 661	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   1004: aload 9
    //   1006: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   1009: ldc_w 388
    //   1012: aload 9
    //   1014: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   1017: aload 7
    //   1019: invokestatic 664	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1022: aload_0
    //   1023: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1026: aload 7
    //   1028: invokevirtual 690	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   1031: ifne +16 -> 1047
    //   1034: aload_0
    //   1035: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1038: aload 7
    //   1040: ldc2_w 691
    //   1043: iconst_1
    //   1044: invokevirtual 695	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1047: aload_0
    //   1048: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1051: aload 7
    //   1053: invokevirtual 697	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1056: goto -240 -> 816
    //   1059: ldc_w 699
    //   1062: iconst_0
    //   1063: anewarray 4	java/lang/Object
    //   1066: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1069: pop
    //   1070: goto -126 -> 944
    //   1073: iload_2
    //   1074: iconst_1
    //   1075: iadd
    //   1076: istore_2
    //   1077: goto -798 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1080	0	this	b
    //   0	1080	1	paramString	String
    //   278	799	2	k	int
    //   50	687	3	l1	long
    //   70	447	5	l2	long
    //   56	996	7	localObject1	Object
    //   168	581	8	localObject2	Object
    //   269	744	9	localObject3	Object
    //   309	445	10	localObject4	Object
    //   714	45	11	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	142	finally
    //   26	36	142	finally
    //   161	170	205	java/lang/Throwable
    //   36	47	640	java/lang/Throwable
    //   51	58	640	java/lang/Throwable
    //   63	69	640	java/lang/Throwable
    //   80	96	640	java/lang/Throwable
    //   96	133	640	java/lang/Throwable
    //   147	161	640	java/lang/Throwable
    //   175	185	640	java/lang/Throwable
    //   185	196	640	java/lang/Throwable
    //   206	222	640	java/lang/Throwable
    //   231	237	640	java/lang/Throwable
    //   247	277	640	java/lang/Throwable
    //   279	297	640	java/lang/Throwable
    //   302	311	640	java/lang/Throwable
    //   311	353	640	java/lang/Throwable
    //   358	369	640	java/lang/Throwable
    //   385	391	640	java/lang/Throwable
    //   398	409	640	java/lang/Throwable
    //   415	445	640	java/lang/Throwable
    //   454	568	640	java/lang/Throwable
    //   573	587	640	java/lang/Throwable
    //   587	637	640	java/lang/Throwable
    //   682	724	640	java/lang/Throwable
    //   726	816	640	java/lang/Throwable
    //   825	836	640	java/lang/Throwable
    //   839	863	640	java/lang/Throwable
    //   877	896	640	java/lang/Throwable
    //   901	912	640	java/lang/Throwable
    //   915	944	640	java/lang/Throwable
    //   948	998	640	java/lang/Throwable
    //   998	1047	640	java/lang/Throwable
    //   1047	1056	640	java/lang/Throwable
    //   1059	1070	640	java/lang/Throwable
    //   36	47	866	finally
    //   51	58	866	finally
    //   63	69	866	finally
    //   80	96	866	finally
    //   96	133	866	finally
    //   147	161	866	finally
    //   161	170	866	finally
    //   175	185	866	finally
    //   185	196	866	finally
    //   206	222	866	finally
    //   231	237	866	finally
    //   247	277	866	finally
    //   279	297	866	finally
    //   302	311	866	finally
    //   311	353	866	finally
    //   358	369	866	finally
    //   385	391	866	finally
    //   398	409	866	finally
    //   415	445	866	finally
    //   454	568	866	finally
    //   573	587	866	finally
    //   587	637	866	finally
    //   641	652	866	finally
    //   652	673	866	finally
    //   682	724	866	finally
    //   726	816	866	finally
    //   825	836	866	finally
    //   839	863	866	finally
    //   877	896	866	finally
    //   901	912	866	finally
    //   915	944	866	finally
    //   948	998	866	finally
    //   998	1047	866	finally
    //   1047	1056	866	finally
    //   1059	1070	866	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = f();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((!bool) || (!locala.c().g)) {
        break label68;
      }
    }
    label68:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean != e())
      {
        x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
        b(paramBoolean);
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
  
  protected final void b()
  {
    long l1 = z.b();
    long l2 = c.g;
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0)) {}
    }
    else
    {
      return;
    }
    int i1 = "bugly_trace_".length();
    int i2 = localObject1.length;
    int k = 0;
    Object localObject2;
    String str;
    int n;
    for (int m = 0;; m = n)
    {
      if (k >= i2) {
        break label190;
      }
      localObject2 = localObject1[k];
      str = localObject2.getName();
      n = m;
      if (str.startsWith("bugly_trace_")) {}
      try
      {
        n = str.indexOf(".txt");
        if (n <= 0) {
          break;
        }
        long l3 = Long.parseLong(str.substring(i1, n));
        if (l3 < l1 - l2) {
          break;
        }
        n = m;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          x.e("tomb format error delete %s", new Object[] { str });
          n = m;
          if (localObject2.delete()) {
            n = m + 1;
          }
        }
      }
      k += 1;
    }
    label190:
    x.c("clean tombs %d", new Object[] { Integer.valueOf(m) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b
 * JD-Core Version:    0.7.0.1
 */