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
  private static b d = null;
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private Context c;
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    long l = com.tencent.feedback.proguard.a.c();
    t.a(paramContext).a(new d(paramContext, paramContext.getFilesDir().getAbsolutePath() + "/eup", l - 604800L, 10, "tomb_", ".txt"));
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    if (10000L < 0L)
    {
      paramLong = 0L;
      com.tencent.feedback.common.e.b("to find!", new Object[0]);
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      paramLong /= 500L;
    }
    for (;;)
    {
      com.tencent.feedback.common.e.b("waiting!", new Object[0]);
      Object localObject = paramContext.getProcessesInErrorState();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
            if (localProcessErrorStateInfo.condition == 2)
            {
              com.tencent.feedback.common.e.b("found!", new Object[0]);
              return localProcessErrorStateInfo;
              paramLong = 10000L;
              break;
            }
          }
        }
      }
      try
      {
        Thread.sleep(500L);
        if (0L < paramLong) {
          continue;
        }
        com.tencent.feedback.common.e.b("end!", new Object[0]);
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (!com.tencent.feedback.common.e.a(localInterruptedException)) {
            localInterruptedException.printStackTrace();
          }
        }
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
    if ((paramContext == null) || (parama == null) || (paramc == null) || (paramCrashStrategyBean == null))
    {
      com.tencent.feedback.common.e.d("args error %s %s %s %s ", new Object[] { paramContext, parama, paramc, paramCrashStrategyBean });
      return true;
    }
    if ((parama.b == null) || (parama.b.get("main") == null))
    {
      com.tencent.feedback.common.e.d("error can't get stacks of anr %s ,drop this anr error", new Object[] { parama.b });
      return false;
    }
    for (;;)
    {
      try
      {
        String str2 = (String)parama.b.get("main");
        int i = str2.indexOf("\n");
        if (i > 0)
        {
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
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        com.tencent.feedback.common.e.d("recordANR error %s", new Object[] { paramContext.getClass().getName() + ":" + paramContext.getMessage() });
        return false;
      }
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
    //   3: invokestatic 295	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 299	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 299	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   22: invokeinterface 302 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 304
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 57	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 306	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 309	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 312	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 309	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 312	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 315	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 318	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 309	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 321	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 323
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 326
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 48	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 275	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 280	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 282
    //   158: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 327	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 329	java/io/BufferedWriter
    //   187: dup
    //   188: new 331	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 334	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 337	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 299	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   205: ldc 168
    //   207: invokeinterface 174 2 0
    //   212: checkcast 339	[Ljava/lang/String;
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +77 -> 296
    //   222: aload 4
    //   224: arraylength
    //   225: iconst_3
    //   226: if_icmplt +70 -> 296
    //   229: aload 4
    //   231: iconst_0
    //   232: aaload
    //   233: astore_0
    //   234: aload 4
    //   236: iconst_1
    //   237: aaload
    //   238: astore_2
    //   239: aload 4
    //   241: iconst_2
    //   242: aaload
    //   243: astore 4
    //   245: aload_1
    //   246: new 48	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 341
    //   253: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 4
    //   258: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 344
    //   264: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 180
    //   273: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_2
    //   277: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 346
    //   283: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 349	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   292: aload_1
    //   293: invokevirtual 352	java/io/BufferedWriter:flush	()V
    //   296: aload_3
    //   297: getfield 299	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   300: invokeinterface 356 1 0
    //   305: invokeinterface 359 1 0
    //   310: astore_0
    //   311: aload_0
    //   312: invokeinterface 122 1 0
    //   317: ifeq +237 -> 554
    //   320: aload_0
    //   321: invokeinterface 126 1 0
    //   326: checkcast 361	java/util/Map$Entry
    //   329: astore_2
    //   330: aload_2
    //   331: invokeinterface 364 1 0
    //   336: checkcast 178	java/lang/String
    //   339: ldc 168
    //   341: invokevirtual 368	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   344: ifne -33 -> 311
    //   347: aload_2
    //   348: invokeinterface 371 1 0
    //   353: ifnull -42 -> 311
    //   356: aload_2
    //   357: invokeinterface 371 1 0
    //   362: checkcast 339	[Ljava/lang/String;
    //   365: arraylength
    //   366: iconst_3
    //   367: if_icmplt -56 -> 311
    //   370: aload_2
    //   371: invokeinterface 371 1 0
    //   376: checkcast 339	[Ljava/lang/String;
    //   379: iconst_0
    //   380: aaload
    //   381: astore_3
    //   382: aload_2
    //   383: invokeinterface 371 1 0
    //   388: checkcast 339	[Ljava/lang/String;
    //   391: iconst_1
    //   392: aaload
    //   393: astore 4
    //   395: aload_2
    //   396: invokeinterface 371 1 0
    //   401: checkcast 339	[Ljava/lang/String;
    //   404: iconst_2
    //   405: aaload
    //   406: astore 5
    //   408: aload_1
    //   409: new 48	java/lang/StringBuilder
    //   412: dup
    //   413: ldc_w 373
    //   416: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: aload_2
    //   420: invokeinterface 364 1 0
    //   425: checkcast 178	java/lang/String
    //   428: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 375
    //   434: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 5
    //   439: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 344
    //   445: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_3
    //   449: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 180
    //   454: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 4
    //   459: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 346
    //   465: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokevirtual 349	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   474: aload_1
    //   475: invokevirtual 352	java/io/BufferedWriter:flush	()V
    //   478: goto -167 -> 311
    //   481: astore_2
    //   482: aload_1
    //   483: astore_0
    //   484: aload_2
    //   485: astore_1
    //   486: aload_1
    //   487: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   490: ifne +7 -> 497
    //   493: aload_1
    //   494: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   497: ldc_w 378
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: new 48	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   513: aload_1
    //   514: invokevirtual 275	java/lang/Object:getClass	()Ljava/lang/Class;
    //   517: invokevirtual 280	java/lang/Class:getName	()Ljava/lang/String;
    //   520: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc_w 282
    //   526: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: invokevirtual 379	java/io/IOException:getMessage	()Ljava/lang/String;
    //   533: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: aastore
    //   540: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   543: pop
    //   544: aload_0
    //   545: ifnull +7 -> 552
    //   548: aload_0
    //   549: invokevirtual 382	java/io/BufferedWriter:close	()V
    //   552: iconst_0
    //   553: ireturn
    //   554: aload_1
    //   555: invokevirtual 382	java/io/BufferedWriter:close	()V
    //   558: iconst_1
    //   559: ireturn
    //   560: astore_0
    //   561: aload_0
    //   562: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   565: ifne -7 -> 558
    //   568: aload_0
    //   569: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   572: goto -14 -> 558
    //   575: astore_0
    //   576: aload_0
    //   577: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   580: ifne -28 -> 552
    //   583: aload_0
    //   584: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   587: goto -35 -> 552
    //   590: astore_0
    //   591: aconst_null
    //   592: astore_1
    //   593: aload_1
    //   594: ifnull +7 -> 601
    //   597: aload_1
    //   598: invokevirtual 382	java/io/BufferedWriter:close	()V
    //   601: aload_0
    //   602: athrow
    //   603: astore_1
    //   604: aload_1
    //   605: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   608: ifne -7 -> 601
    //   611: aload_1
    //   612: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   615: goto -14 -> 601
    //   618: astore_0
    //   619: goto -26 -> 593
    //   622: astore_2
    //   623: aload_0
    //   624: astore_1
    //   625: aload_2
    //   626: astore_0
    //   627: goto -34 -> 593
    //   630: astore_1
    //   631: goto -145 -> 486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	paramString1	String
    //   0	634	1	paramString2	String
    //   0	634	2	paramString3	String
    //   6	443	3	localObject1	Object
    //   215	243	4	localObject2	Object
    //   406	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	81	117	java/lang/Exception
    //   81	86	117	java/lang/Exception
    //   201	217	481	java/io/IOException
    //   222	229	481	java/io/IOException
    //   245	296	481	java/io/IOException
    //   296	311	481	java/io/IOException
    //   311	478	481	java/io/IOException
    //   554	558	560	java/io/IOException
    //   548	552	575	java/io/IOException
    //   184	201	590	finally
    //   597	601	603	java/io/IOException
    //   201	217	618	finally
    //   222	229	618	finally
    //   245	296	618	finally
    //   296	311	618	finally
    //   311	478	618	finally
    //   486	497	622	finally
    //   497	544	622	finally
    //   184	201	630	java/io/IOException
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 384	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 386
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 34	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   40: invokestatic 392	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnonnull +28 -> 75
    //   50: ldc_w 394
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: iconst_0
    //   66: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   69: return
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    //   75: invokestatic 400	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   78: astore 8
    //   80: aload 8
    //   82: ifnull +12 -> 94
    //   85: invokestatic 406	com/tencent/feedback/eup/f:l	()Lcom/tencent/feedback/eup/f;
    //   88: invokevirtual 408	com/tencent/feedback/eup/f:a	()Z
    //   91: ifne +23 -> 114
    //   94: ldc_w 410
    //   97: iconst_0
    //   98: anewarray 4	java/lang/Object
    //   101: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   109: iconst_0
    //   110: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   113: return
    //   114: ldc_w 412
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_1
    //   126: iconst_0
    //   127: invokestatic 415	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   130: astore 9
    //   132: aload 9
    //   134: ifnull +623 -> 757
    //   137: aload 9
    //   139: getfield 416	com/tencent/feedback/anr/f:c	J
    //   142: lstore_3
    //   143: lload_3
    //   144: lstore 5
    //   146: lload_3
    //   147: ldc2_w 29
    //   150: lcmp
    //   151: ifne +26 -> 177
    //   154: ldc_w 418
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 420	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   164: pop
    //   165: new 422	java/util/Date
    //   168: dup
    //   169: invokespecial 423	java/util/Date:<init>	()V
    //   172: invokevirtual 426	java/util/Date:getTime	()J
    //   175: lstore 5
    //   177: lload 5
    //   179: aload_0
    //   180: getfield 32	com/tencent/feedback/anr/b:b	J
    //   183: lsub
    //   184: invokestatic 432	java/lang/Math:abs	(J)J
    //   187: ldc2_w 86
    //   190: lcmp
    //   191: ifge +32 -> 223
    //   194: ldc_w 434
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: sipush 10000
    //   206: invokestatic 261	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: aastore
    //   210: invokestatic 420	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   213: pop
    //   214: aload_0
    //   215: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   218: iconst_0
    //   219: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   222: return
    //   223: aload_0
    //   224: lload 5
    //   226: putfield 32	com/tencent/feedback/anr/b:b	J
    //   229: aload_0
    //   230: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   233: iconst_1
    //   234: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   237: invokestatic 436	com/tencent/feedback/proguard/a:b	()Ljava/util/Map;
    //   240: astore 10
    //   242: aload 10
    //   244: ifnull +13 -> 257
    //   247: aload 10
    //   249: invokeinterface 302 1 0
    //   254: ifgt +49 -> 303
    //   257: ldc_w 438
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 420	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   267: pop
    //   268: aload_0
    //   269: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   272: iconst_0
    //   273: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   276: return
    //   277: astore_1
    //   278: aload_1
    //   279: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   282: pop
    //   283: ldc_w 440
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   293: pop
    //   294: aload_0
    //   295: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   298: iconst_0
    //   299: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   302: return
    //   303: aload_0
    //   304: getfield 34	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   307: ldc2_w 86
    //   310: invokestatic 442	com/tencent/feedback/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   313: astore 11
    //   315: aload 11
    //   317: ifnonnull +23 -> 340
    //   320: ldc_w 444
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   330: pop
    //   331: aload_0
    //   332: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   335: iconst_0
    //   336: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   339: return
    //   340: aload 11
    //   342: getfield 447	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   345: invokestatic 452	android/os/Process:myPid	()I
    //   348: if_icmpeq +31 -> 379
    //   351: ldc_w 454
    //   354: iconst_1
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload 11
    //   362: getfield 457	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   365: aastore
    //   366: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   369: pop
    //   370: aload_0
    //   371: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   374: iconst_0
    //   375: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   378: return
    //   379: ldc_w 459
    //   382: iconst_0
    //   383: anewarray 4	java/lang/Object
    //   386: invokestatic 461	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   389: pop
    //   390: new 57	java/io/File
    //   393: dup
    //   394: aload_0
    //   395: getfield 34	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   398: invokevirtual 55	android/content/Context:getFilesDir	()Ljava/io/File;
    //   401: new 48	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 463
    //   408: invokespecial 342	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: lload 5
    //   413: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   422: astore 12
    //   424: new 163	com/tencent/feedback/anr/a
    //   427: dup
    //   428: invokespecial 470	com/tencent/feedback/anr/a:<init>	()V
    //   431: astore 9
    //   433: aload 9
    //   435: lload 5
    //   437: putfield 213	com/tencent/feedback/anr/a:c	J
    //   440: aload 9
    //   442: aload 12
    //   444: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   447: putfield 235	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   450: aload 9
    //   452: aload 11
    //   454: getfield 457	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   457: putfield 206	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   460: aload 9
    //   462: aload 11
    //   464: getfield 473	android/app/ActivityManager$ProcessErrorStateInfo:shortMsg	Ljava/lang/String;
    //   467: putfield 211	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   470: aload 9
    //   472: aload 11
    //   474: getfield 476	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   477: putfield 216	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   480: aload 9
    //   482: aload 10
    //   484: putfield 166	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   487: aload 9
    //   489: getfield 213	com/tencent/feedback/anr/a:c	J
    //   492: lstore_3
    //   493: aload 9
    //   495: getfield 235	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   498: astore 10
    //   500: aload 9
    //   502: getfield 206	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   505: astore 11
    //   507: aload 9
    //   509: getfield 211	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   512: astore 12
    //   514: aload 9
    //   516: getfield 216	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   519: astore 13
    //   521: aload 9
    //   523: getfield 166	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   526: ifnonnull +87 -> 613
    //   529: iconst_0
    //   530: istore_2
    //   531: ldc_w 478
    //   534: bipush 6
    //   536: anewarray 4	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: lload_3
    //   542: invokestatic 483	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: aload 10
    //   550: aastore
    //   551: dup
    //   552: iconst_2
    //   553: aload 11
    //   555: aastore
    //   556: dup
    //   557: iconst_3
    //   558: aload 12
    //   560: aastore
    //   561: dup
    //   562: iconst_4
    //   563: aload 13
    //   565: aastore
    //   566: dup
    //   567: iconst_5
    //   568: iload_2
    //   569: invokestatic 261	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   572: aastore
    //   573: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   576: pop
    //   577: aload_0
    //   578: getfield 34	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   581: aload 9
    //   583: aload 7
    //   585: aload 8
    //   587: invokestatic 485	com/tencent/feedback/anr/b:a	(Landroid/content/Context;Lcom/tencent/feedback/anr/a;Lcom/tencent/feedback/common/c;Lcom/tencent/feedback/eup/CrashStrategyBean;)Z
    //   590: ifne +37 -> 627
    //   593: ldc_w 487
    //   596: iconst_0
    //   597: anewarray 4	java/lang/Object
    //   600: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   603: pop
    //   604: aload_0
    //   605: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   608: iconst_0
    //   609: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   612: return
    //   613: aload 9
    //   615: getfield 166	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   618: invokeinterface 302 1 0
    //   623: istore_2
    //   624: goto -93 -> 531
    //   627: aload_0
    //   628: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   631: iconst_3
    //   632: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   635: aload_1
    //   636: aload 9
    //   638: getfield 235	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   641: aload 9
    //   643: getfield 206	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   646: invokestatic 489	com/tencent/feedback/anr/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   649: ifne +27 -> 676
    //   652: ldc_w 491
    //   655: iconst_1
    //   656: anewarray 4	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: aload_1
    //   662: aastore
    //   663: invokestatic 420	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   666: pop
    //   667: aload_0
    //   668: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   671: iconst_0
    //   672: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   675: return
    //   676: ldc_w 493
    //   679: iconst_1
    //   680: anewarray 4	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: aload 9
    //   687: getfield 235	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   690: aastore
    //   691: invokestatic 461	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   694: pop
    //   695: aload_0
    //   696: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   699: iconst_0
    //   700: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   703: return
    //   704: astore_1
    //   705: aload_1
    //   706: invokestatic 145	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   709: ifne +7 -> 716
    //   712: aload_1
    //   713: invokevirtual 269	java/lang/Throwable:printStackTrace	()V
    //   716: ldc_w 495
    //   719: iconst_1
    //   720: anewarray 4	java/lang/Object
    //   723: dup
    //   724: iconst_0
    //   725: aload_1
    //   726: invokevirtual 275	java/lang/Object:getClass	()Ljava/lang/Class;
    //   729: invokevirtual 496	java/lang/Class:toString	()Ljava/lang/String;
    //   732: aastore
    //   733: invokestatic 161	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   736: pop
    //   737: aload_0
    //   738: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   741: iconst_0
    //   742: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   745: return
    //   746: astore_1
    //   747: aload_0
    //   748: getfield 28	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   751: iconst_0
    //   752: invokevirtual 389	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   755: aload_1
    //   756: athrow
    //   757: ldc2_w 29
    //   760: lstore_3
    //   761: goto -618 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	b
    //   0	764	1	paramString	String
    //   530	94	2	i	int
    //   142	619	3	l1	long
    //   144	292	5	l2	long
    //   43	541	7	localc	com.tencent.feedback.common.c
    //   78	508	8	localCrashStrategyBean	CrashStrategyBean
    //   130	556	9	localObject1	Object
    //   240	309	10	localObject2	Object
    //   313	241	11	localObject3	Object
    //   422	137	12	localObject4	Object
    //   519	45	13	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	70	finally
    //   26	36	70	finally
    //   237	242	277	java/lang/Throwable
    //   36	45	704	java/lang/Throwable
    //   50	61	704	java/lang/Throwable
    //   75	80	704	java/lang/Throwable
    //   85	94	704	java/lang/Throwable
    //   94	105	704	java/lang/Throwable
    //   114	132	704	java/lang/Throwable
    //   137	143	704	java/lang/Throwable
    //   154	177	704	java/lang/Throwable
    //   177	214	704	java/lang/Throwable
    //   223	237	704	java/lang/Throwable
    //   247	257	704	java/lang/Throwable
    //   257	268	704	java/lang/Throwable
    //   278	294	704	java/lang/Throwable
    //   303	315	704	java/lang/Throwable
    //   320	331	704	java/lang/Throwable
    //   340	370	704	java/lang/Throwable
    //   379	529	704	java/lang/Throwable
    //   531	604	704	java/lang/Throwable
    //   613	624	704	java/lang/Throwable
    //   627	667	704	java/lang/Throwable
    //   676	695	704	java/lang/Throwable
    //   36	45	746	finally
    //   50	61	746	finally
    //   75	80	746	finally
    //   85	94	746	finally
    //   94	105	746	finally
    //   114	132	746	finally
    //   137	143	746	finally
    //   154	177	746	finally
    //   177	214	746	finally
    //   223	237	746	finally
    //   237	242	746	finally
    //   247	257	746	finally
    //   257	268	746	finally
    //   278	294	746	finally
    //   303	315	746	finally
    //   320	331	746	finally
    //   340	370	746	finally
    //   379	529	746	finally
    //   531	604	746	finally
    //   613	624	746	finally
    //   627	667	746	finally
    //   676	695	746	finally
    //   705	716	746	finally
    //   716	737	746	finally
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