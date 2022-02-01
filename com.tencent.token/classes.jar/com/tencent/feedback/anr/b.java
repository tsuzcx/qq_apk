package com.tencent.feedback.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.feedback.eup.jni.d;
import com.tencent.feedback.proguard.t;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static b d;
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private Context c;
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    long l = com.tencent.feedback.proguard.a.c();
    t localt = t.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/eup");
    localt.a(new d(paramContext, localStringBuilder.toString(), l - 604800L, 10, "tomb_", ".txt"));
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    com.tencent.feedback.common.e.b("to find!", new Object[0]);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    for (;;)
    {
      com.tencent.feedback.common.e.b("waiting!", new Object[0]);
      Object localObject = paramContext.getProcessesInErrorState();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
          if (localProcessErrorStateInfo.condition == 2)
          {
            com.tencent.feedback.common.e.b("found!", new Object[0]);
            return localProcessErrorStateInfo;
          }
        }
      }
      try
      {
        Thread.sleep(500L);
      }
      catch (InterruptedException localInterruptedException) {}
      if (!com.tencent.feedback.common.e.a(localInterruptedException)) {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new b(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private static boolean a(Context paramContext, a parama, com.tencent.feedback.common.c paramc, CrashStrategyBean paramCrashStrategyBean)
  {
    if ((paramContext != null) && (parama != null) && (paramc != null) && (paramCrashStrategyBean != null)) {
      if ((parama.b == null) || (parama.b.get("main") == null)) {}
    }
    for (;;)
    {
      try
      {
        String str2 = (String)parama.b.get("main");
        int i = str2.indexOf("\n");
        if (i <= 0) {
          break label364;
        }
        str1 = str2.substring(0, i);
        paramc = com.tencent.feedback.eup.b.a(paramContext, paramc.g(), paramc.h(), paramc.j(), paramc.x(), parama.a, "main", str1, "ANR_RQD_EXCEPTION", parama.f, str2, parama.c, parama.e, null);
        paramc.C().putAll(parama.b);
        paramc.a((byte)3);
        paramc.h(parama.d);
        boolean bool = com.tencent.feedback.eup.c.a(paramContext).a(paramc, paramCrashStrategyBean);
        com.tencent.feedback.common.e.b("sha1:%s %d", new Object[] { paramc.o(), Integer.valueOf(paramc.m()) });
        com.tencent.feedback.common.e.b("handle anr %b", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        parama = new StringBuilder();
        parama.append(paramContext.getClass().getName());
        parama.append(":");
        parama.append(paramContext.getMessage());
        com.tencent.feedback.common.e.d("recordANR error %s", new Object[] { parama.toString() });
        return false;
      }
      paramContext = new StringBuilder();
      paramContext.append(parama.b);
      com.tencent.feedback.common.e.d("error can't get stacks of anr %s ,drop this anr error", new Object[] { paramContext.toString() });
      return false;
      com.tencent.feedback.common.e.d("args error %s %s %s %s ", new Object[] { String.valueOf(paramContext), String.valueOf(parama), String.valueOf(paramc), String.valueOf(paramCrashStrategyBean) });
      return true;
      label364:
      String str1 = "unknown";
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 294	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +700 -> 708
    //   11: aload_3
    //   12: getfield 298	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   15: ifnull +693 -> 708
    //   18: aload_3
    //   19: getfield 298	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   22: invokeinterface 301 1 0
    //   27: ifgt +6 -> 33
    //   30: goto +678 -> 708
    //   33: new 53	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 306	java/io/File:exists	()Z
    //   48: ifne +29 -> 77
    //   51: aload 4
    //   53: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   56: invokevirtual 306	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 4
    //   64: invokevirtual 309	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 312	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload 4
    //   73: invokevirtual 315	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 4
    //   79: invokevirtual 306	java/io/File:exists	()Z
    //   82: ifeq +536 -> 618
    //   85: aload 4
    //   87: invokevirtual 318	java/io/File:canWrite	()Z
    //   90: ifne +6 -> 96
    //   93: goto +525 -> 618
    //   96: aconst_null
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_0
    //   100: new 320	java/io/BufferedWriter
    //   103: dup
    //   104: new 322	java/io/FileWriter
    //   107: dup
    //   108: aload 4
    //   110: iconst_0
    //   111: invokespecial 325	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   114: invokespecial 328	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   117: astore_1
    //   118: aload_3
    //   119: getfield 298	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   122: ldc 157
    //   124: invokeinterface 163 2 0
    //   129: checkcast 330	[Ljava/lang/String;
    //   132: astore 4
    //   134: aload 4
    //   136: ifnull +99 -> 235
    //   139: aload 4
    //   141: arraylength
    //   142: iconst_3
    //   143: if_icmplt +92 -> 235
    //   146: aload 4
    //   148: iconst_0
    //   149: aaload
    //   150: astore_0
    //   151: aload 4
    //   153: iconst_1
    //   154: aaload
    //   155: astore_2
    //   156: aload 4
    //   158: iconst_2
    //   159: aaload
    //   160: astore 4
    //   162: new 44	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 332
    //   169: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: astore 5
    //   174: aload 5
    //   176: aload 4
    //   178: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 5
    //   184: ldc_w 335
    //   187: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 5
    //   193: aload_0
    //   194: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 5
    //   200: ldc 167
    //   202: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 5
    //   208: aload_2
    //   209: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 5
    //   215: ldc_w 337
    //   218: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: aload 5
    //   225: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 340	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   231: aload_1
    //   232: invokevirtual 343	java/io/BufferedWriter:flush	()V
    //   235: aload_3
    //   236: getfield 298	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   239: invokeinterface 347 1 0
    //   244: invokeinterface 350 1 0
    //   249: astore_0
    //   250: aload_0
    //   251: invokeinterface 116 1 0
    //   256: ifeq +192 -> 448
    //   259: aload_0
    //   260: invokeinterface 120 1 0
    //   265: checkcast 352	java/util/Map$Entry
    //   268: astore_2
    //   269: aload_2
    //   270: invokeinterface 355 1 0
    //   275: checkcast 165	java/lang/String
    //   278: ldc 157
    //   280: invokevirtual 359	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifne -33 -> 250
    //   286: aload_2
    //   287: invokeinterface 362 1 0
    //   292: ifnull -42 -> 250
    //   295: aload_2
    //   296: invokeinterface 362 1 0
    //   301: checkcast 330	[Ljava/lang/String;
    //   304: arraylength
    //   305: iconst_3
    //   306: if_icmplt -56 -> 250
    //   309: aload_2
    //   310: invokeinterface 362 1 0
    //   315: checkcast 330	[Ljava/lang/String;
    //   318: iconst_0
    //   319: aaload
    //   320: astore_3
    //   321: aload_2
    //   322: invokeinterface 362 1 0
    //   327: checkcast 330	[Ljava/lang/String;
    //   330: iconst_1
    //   331: aaload
    //   332: astore 4
    //   334: aload_2
    //   335: invokeinterface 362 1 0
    //   340: checkcast 330	[Ljava/lang/String;
    //   343: iconst_2
    //   344: aaload
    //   345: astore 5
    //   347: new 44	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 364
    //   354: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: astore 6
    //   359: aload 6
    //   361: aload_2
    //   362: invokeinterface 355 1 0
    //   367: checkcast 165	java/lang/String
    //   370: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 6
    //   376: ldc_w 366
    //   379: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 6
    //   385: aload 5
    //   387: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 6
    //   393: ldc_w 335
    //   396: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 6
    //   402: aload_3
    //   403: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 6
    //   409: ldc 167
    //   411: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 6
    //   417: aload 4
    //   419: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 6
    //   425: ldc_w 337
    //   428: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: aload 6
    //   435: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 340	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   441: aload_1
    //   442: invokevirtual 343	java/io/BufferedWriter:flush	()V
    //   445: goto -195 -> 250
    //   448: aload_1
    //   449: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   452: iconst_1
    //   453: ireturn
    //   454: astore_0
    //   455: aload_0
    //   456: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   459: ifne +7 -> 466
    //   462: aload_0
    //   463: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   466: iconst_1
    //   467: ireturn
    //   468: astore_0
    //   469: goto +124 -> 593
    //   472: astore_2
    //   473: goto +16 -> 489
    //   476: astore_2
    //   477: aload_0
    //   478: astore_1
    //   479: aload_2
    //   480: astore_0
    //   481: goto +112 -> 593
    //   484: astore_0
    //   485: aload_2
    //   486: astore_1
    //   487: aload_0
    //   488: astore_2
    //   489: aload_1
    //   490: astore_0
    //   491: aload_2
    //   492: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   495: ifne +9 -> 504
    //   498: aload_1
    //   499: astore_0
    //   500: aload_2
    //   501: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   504: aload_1
    //   505: astore_0
    //   506: new 44	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   513: astore_3
    //   514: aload_1
    //   515: astore_0
    //   516: aload_3
    //   517: aload_2
    //   518: invokevirtual 260	java/lang/Object:getClass	()Ljava/lang/Class;
    //   521: invokevirtual 265	java/lang/Class:getName	()Ljava/lang/String;
    //   524: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_1
    //   529: astore_0
    //   530: aload_3
    //   531: ldc_w 267
    //   534: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_1
    //   539: astore_0
    //   540: aload_3
    //   541: aload_2
    //   542: invokevirtual 371	java/io/IOException:getMessage	()Ljava/lang/String;
    //   545: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload_1
    //   550: astore_0
    //   551: ldc_w 373
    //   554: iconst_1
    //   555: anewarray 4	java/lang/Object
    //   558: dup
    //   559: iconst_0
    //   560: aload_3
    //   561: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: aastore
    //   565: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   568: pop
    //   569: aload_1
    //   570: ifnull +21 -> 591
    //   573: aload_1
    //   574: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   577: iconst_0
    //   578: ireturn
    //   579: astore_0
    //   580: aload_0
    //   581: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   584: ifne +7 -> 591
    //   587: aload_0
    //   588: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   591: iconst_0
    //   592: ireturn
    //   593: aload_1
    //   594: ifnull +22 -> 616
    //   597: aload_1
    //   598: invokevirtual 369	java/io/BufferedWriter:close	()V
    //   601: goto +15 -> 616
    //   604: astore_1
    //   605: aload_1
    //   606: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   609: ifne +7 -> 616
    //   612: aload_1
    //   613: invokevirtual 370	java/io/IOException:printStackTrace	()V
    //   616: aload_0
    //   617: athrow
    //   618: ldc_w 375
    //   621: iconst_1
    //   622: anewarray 4	java/lang/Object
    //   625: dup
    //   626: iconst_0
    //   627: aload_1
    //   628: aastore
    //   629: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   632: pop
    //   633: iconst_0
    //   634: ireturn
    //   635: astore_0
    //   636: aload_0
    //   637: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   640: ifne +7 -> 647
    //   643: aload_0
    //   644: invokevirtual 376	java/lang/Exception:printStackTrace	()V
    //   647: new 44	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   654: astore_2
    //   655: aload_2
    //   656: aload_0
    //   657: invokevirtual 260	java/lang/Object:getClass	()Ljava/lang/Class;
    //   660: invokevirtual 265	java/lang/Class:getName	()Ljava/lang/String;
    //   663: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload_2
    //   668: ldc_w 267
    //   671: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload_2
    //   676: aload_0
    //   677: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   680: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: ldc_w 379
    //   687: iconst_2
    //   688: anewarray 4	java/lang/Object
    //   691: dup
    //   692: iconst_0
    //   693: aload_2
    //   694: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: aastore
    //   698: dup
    //   699: iconst_1
    //   700: aload_1
    //   701: aastore
    //   702: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   705: pop
    //   706: iconst_0
    //   707: ireturn
    //   708: ldc_w 381
    //   711: iconst_1
    //   712: anewarray 4	java/lang/Object
    //   715: dup
    //   716: iconst_0
    //   717: aload_2
    //   718: aastore
    //   719: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   722: pop
    //   723: iconst_0
    //   724: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	paramString1	String
    //   0	725	1	paramString2	String
    //   0	725	2	paramString3	String
    //   6	555	3	localObject1	Object
    //   41	377	4	localObject2	Object
    //   172	214	5	localObject3	Object
    //   357	77	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   448	452	454	java/io/IOException
    //   118	134	468	finally
    //   139	146	468	finally
    //   162	235	468	finally
    //   235	250	468	finally
    //   250	445	468	finally
    //   118	134	472	java/io/IOException
    //   139	146	472	java/io/IOException
    //   162	235	472	java/io/IOException
    //   235	250	472	java/io/IOException
    //   250	445	472	java/io/IOException
    //   100	118	476	finally
    //   491	498	476	finally
    //   500	504	476	finally
    //   506	514	476	finally
    //   516	528	476	finally
    //   530	538	476	finally
    //   540	549	476	finally
    //   551	569	476	finally
    //   100	118	484	java/io/IOException
    //   573	577	579	java/io/IOException
    //   597	601	604	java/io/IOException
    //   43	71	635	java/lang/Exception
    //   71	77	635	java/lang/Exception
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 383	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 385
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   40: invokestatic 391	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnonnull +23 -> 70
    //   50: ldc_w 393
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: iconst_0
    //   66: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   69: return
    //   70: invokestatic 399	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   73: astore 8
    //   75: aload 8
    //   77: ifnull +562 -> 639
    //   80: invokestatic 405	com/tencent/feedback/eup/f:l	()Lcom/tencent/feedback/eup/f;
    //   83: invokevirtual 407	com/tencent/feedback/eup/f:a	()Z
    //   86: ifne +6 -> 92
    //   89: goto +550 -> 639
    //   92: ldc_w 409
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   102: pop
    //   103: aload_1
    //   104: iconst_0
    //   105: invokestatic 412	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   108: astore 9
    //   110: aload 9
    //   112: ifnull +596 -> 708
    //   115: aload 9
    //   117: getfield 413	com/tencent/feedback/anr/f:c	J
    //   120: lstore_3
    //   121: goto +3 -> 124
    //   124: lload_3
    //   125: lstore 5
    //   127: lload_3
    //   128: ldc2_w 27
    //   131: lcmp
    //   132: ifne +26 -> 158
    //   135: ldc_w 415
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 417	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: new 419	java/util/Date
    //   149: dup
    //   150: invokespecial 420	java/util/Date:<init>	()V
    //   153: invokevirtual 423	java/util/Date:getTime	()J
    //   156: lstore 5
    //   158: lload 5
    //   160: aload_0
    //   161: getfield 30	com/tencent/feedback/anr/b:b	J
    //   164: lsub
    //   165: invokestatic 429	java/lang/Math:abs	(J)J
    //   168: ldc2_w 430
    //   171: lcmp
    //   172: ifge +26 -> 198
    //   175: ldc_w 433
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: sipush 10000
    //   187: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 417	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -134 -> 61
    //   198: aload_0
    //   199: lload 5
    //   201: putfield 30	com/tencent/feedback/anr/b:b	J
    //   204: aload_0
    //   205: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   208: iconst_1
    //   209: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   212: invokestatic 435	com/tencent/feedback/proguard/a:b	()Ljava/util/Map;
    //   215: astore 10
    //   217: aload 10
    //   219: ifnull +386 -> 605
    //   222: aload 10
    //   224: invokeinterface 301 1 0
    //   229: ifgt +6 -> 235
    //   232: goto +373 -> 605
    //   235: aload_0
    //   236: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   239: ldc2_w 430
    //   242: invokestatic 437	com/tencent/feedback/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   245: astore 11
    //   247: aload 11
    //   249: ifnonnull +17 -> 266
    //   252: ldc_w 439
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -202 -> 61
    //   266: aload 11
    //   268: getfield 442	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   271: invokestatic 447	android/os/Process:myPid	()I
    //   274: if_icmpeq +25 -> 299
    //   277: ldc_w 449
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 11
    //   288: getfield 452	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   291: aastore
    //   292: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -235 -> 61
    //   299: ldc_w 454
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 456	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   309: pop
    //   310: new 53	java/io/File
    //   313: dup
    //   314: aload_0
    //   315: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   318: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
    //   321: ldc_w 458
    //   324: lload 5
    //   326: invokestatic 461	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   329: invokevirtual 465	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   332: invokespecial 468	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   335: astore 12
    //   337: new 152	com/tencent/feedback/anr/a
    //   340: dup
    //   341: invokespecial 469	com/tencent/feedback/anr/a:<init>	()V
    //   344: astore 9
    //   346: aload 9
    //   348: lload 5
    //   350: putfield 200	com/tencent/feedback/anr/a:c	J
    //   353: aload 9
    //   355: aload 12
    //   357: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   360: putfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   363: aload 9
    //   365: aload 11
    //   367: getfield 452	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   370: putfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   373: aload 9
    //   375: aload 11
    //   377: getfield 472	android/app/ActivityManager$ProcessErrorStateInfo:shortMsg	Ljava/lang/String;
    //   380: putfield 198	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   383: aload 9
    //   385: aload 11
    //   387: getfield 475	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   390: putfield 203	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   393: aload 9
    //   395: aload 10
    //   397: putfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   400: aload 9
    //   402: getfield 200	com/tencent/feedback/anr/a:c	J
    //   405: lstore_3
    //   406: aload 9
    //   408: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   411: astore 10
    //   413: aload 9
    //   415: getfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   418: astore 11
    //   420: aload 9
    //   422: getfield 198	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   425: astore 12
    //   427: aload 9
    //   429: getfield 203	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   432: astore 13
    //   434: aload 9
    //   436: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   439: ifnonnull +8 -> 447
    //   442: iconst_0
    //   443: istore_2
    //   444: goto +14 -> 458
    //   447: aload 9
    //   449: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   452: invokeinterface 301 1 0
    //   457: istore_2
    //   458: ldc_w 477
    //   461: bipush 6
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: lload_3
    //   469: invokestatic 482	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: aastore
    //   473: dup
    //   474: iconst_1
    //   475: aload 10
    //   477: aastore
    //   478: dup
    //   479: iconst_2
    //   480: aload 11
    //   482: aastore
    //   483: dup
    //   484: iconst_3
    //   485: aload 12
    //   487: aastore
    //   488: dup
    //   489: iconst_4
    //   490: aload 13
    //   492: aastore
    //   493: dup
    //   494: iconst_5
    //   495: iload_2
    //   496: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   503: pop
    //   504: aload_0
    //   505: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   508: aload 9
    //   510: aload 7
    //   512: aload 8
    //   514: invokestatic 484	com/tencent/feedback/anr/b:a	(Landroid/content/Context;Lcom/tencent/feedback/anr/a;Lcom/tencent/feedback/common/c;Lcom/tencent/feedback/eup/CrashStrategyBean;)Z
    //   517: ifne +17 -> 534
    //   520: ldc_w 486
    //   523: iconst_0
    //   524: anewarray 4	java/lang/Object
    //   527: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   530: pop
    //   531: goto -470 -> 61
    //   534: aload_0
    //   535: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   538: iconst_3
    //   539: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   542: aload_1
    //   543: aload 9
    //   545: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   548: aload 9
    //   550: getfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   553: invokestatic 488	com/tencent/feedback/anr/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   556: ifne +21 -> 577
    //   559: ldc_w 490
    //   562: iconst_1
    //   563: anewarray 4	java/lang/Object
    //   566: dup
    //   567: iconst_0
    //   568: aload_1
    //   569: aastore
    //   570: invokestatic 417	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   573: pop
    //   574: goto -513 -> 61
    //   577: ldc_w 492
    //   580: iconst_1
    //   581: anewarray 4	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload 9
    //   588: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 456	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   595: pop
    //   596: aload_0
    //   597: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   600: iconst_0
    //   601: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   604: return
    //   605: ldc_w 494
    //   608: iconst_0
    //   609: anewarray 4	java/lang/Object
    //   612: invokestatic 417	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   615: pop
    //   616: goto -555 -> 61
    //   619: astore_1
    //   620: aload_1
    //   621: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   624: pop
    //   625: ldc_w 496
    //   628: iconst_0
    //   629: anewarray 4	java/lang/Object
    //   632: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   635: pop
    //   636: goto -575 -> 61
    //   639: ldc_w 498
    //   642: iconst_0
    //   643: anewarray 4	java/lang/Object
    //   646: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   649: pop
    //   650: goto -589 -> 61
    //   653: astore_1
    //   654: goto +39 -> 693
    //   657: astore_1
    //   658: aload_1
    //   659: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   662: ifne +7 -> 669
    //   665: aload_1
    //   666: invokevirtual 256	java/lang/Throwable:printStackTrace	()V
    //   669: ldc_w 500
    //   672: iconst_1
    //   673: anewarray 4	java/lang/Object
    //   676: dup
    //   677: iconst_0
    //   678: aload_1
    //   679: invokevirtual 260	java/lang/Object:getClass	()Ljava/lang/Class;
    //   682: invokevirtual 501	java/lang/Class:toString	()Ljava/lang/String;
    //   685: aastore
    //   686: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   689: pop
    //   690: goto -94 -> 596
    //   693: aload_0
    //   694: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   697: iconst_0
    //   698: invokevirtual 388	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   701: aload_1
    //   702: athrow
    //   703: astore_1
    //   704: aload_0
    //   705: monitorexit
    //   706: aload_1
    //   707: athrow
    //   708: ldc2_w 27
    //   711: lstore_3
    //   712: goto -588 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	b
    //   0	715	1	paramString	String
    //   443	53	2	i	int
    //   120	592	3	l1	long
    //   125	224	5	l2	long
    //   43	468	7	localc	com.tencent.feedback.common.c
    //   73	440	8	localCrashStrategyBean	CrashStrategyBean
    //   108	479	9	localObject1	Object
    //   215	261	10	localObject2	Object
    //   245	236	11	localObject3	Object
    //   335	151	12	localObject4	Object
    //   432	59	13	str	String
    // Exception table:
    //   from	to	target	type
    //   212	217	619	java/lang/Throwable
    //   36	45	653	finally
    //   50	61	653	finally
    //   70	75	653	finally
    //   80	89	653	finally
    //   92	110	653	finally
    //   115	121	653	finally
    //   135	158	653	finally
    //   158	195	653	finally
    //   198	212	653	finally
    //   212	217	653	finally
    //   222	232	653	finally
    //   235	247	653	finally
    //   252	263	653	finally
    //   266	296	653	finally
    //   299	442	653	finally
    //   447	458	653	finally
    //   458	531	653	finally
    //   534	574	653	finally
    //   577	596	653	finally
    //   605	616	653	finally
    //   620	636	653	finally
    //   639	650	653	finally
    //   658	669	653	finally
    //   669	690	653	finally
    //   36	45	657	java/lang/Throwable
    //   50	61	657	java/lang/Throwable
    //   70	75	657	java/lang/Throwable
    //   80	89	657	java/lang/Throwable
    //   92	110	657	java/lang/Throwable
    //   115	121	657	java/lang/Throwable
    //   135	158	657	java/lang/Throwable
    //   158	195	657	java/lang/Throwable
    //   198	212	657	java/lang/Throwable
    //   222	232	657	java/lang/Throwable
    //   235	247	657	java/lang/Throwable
    //   252	263	657	java/lang/Throwable
    //   266	296	657	java/lang/Throwable
    //   299	442	657	java/lang/Throwable
    //   447	458	657	java/lang/Throwable
    //   458	531	657	java/lang/Throwable
    //   534	574	657	java/lang/Throwable
    //   577	596	657	java/lang/Throwable
    //   605	616	657	java/lang/Throwable
    //   620	636	657	java/lang/Throwable
    //   639	650	657	java/lang/Throwable
    //   2	25	703	finally
    //   26	36	703	finally
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.b
 * JD-Core Version:    0.7.0.1
 */