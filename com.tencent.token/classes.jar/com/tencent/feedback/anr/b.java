package com.tencent.feedback.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import com.tencent.feedback.common.e;
import com.tencent.feedback.eup.jni.d;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.t;
import java.io.File;
import java.util.Iterator;
import java.util.List;
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
    long l = a.c();
    t localt = t.a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/eup");
    localt.a(new d(paramContext, localStringBuilder.toString(), l - 604800L, 10, "tomb_", ".txt"));
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    e.b("to find!", new Object[0]);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    for (;;)
    {
      e.b("waiting!", new Object[0]);
      Object localObject = paramContext.getProcessesInErrorState();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
          if (localProcessErrorStateInfo.condition == 2)
          {
            e.b("found!", new Object[0]);
            return localProcessErrorStateInfo;
          }
        }
      }
      try
      {
        Thread.sleep(500L);
      }
      catch (InterruptedException localInterruptedException) {}
      if (!e.a(localInterruptedException)) {
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
  
  /* Error */
  private static boolean a(Context paramContext, a parama, com.tencent.feedback.common.c paramc, com.tencent.feedback.eup.CrashStrategyBean paramCrashStrategyBean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +366 -> 367
    //   4: aload_1
    //   5: ifnull +362 -> 367
    //   8: aload_2
    //   9: ifnull +358 -> 367
    //   12: aload_3
    //   13: ifnonnull +6 -> 19
    //   16: goto +351 -> 367
    //   19: aload_1
    //   20: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   23: ifnull +307 -> 330
    //   26: aload_1
    //   27: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   30: ldc 157
    //   32: invokeinterface 163 2 0
    //   37: ifnonnull +6 -> 43
    //   40: goto +290 -> 330
    //   43: aload_1
    //   44: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   47: ldc 157
    //   49: invokeinterface 163 2 0
    //   54: checkcast 165	java/lang/String
    //   57: astore 11
    //   59: aload 11
    //   61: ldc 167
    //   63: invokevirtual 171	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: istore 4
    //   68: iload 4
    //   70: ifle +412 -> 482
    //   73: aload 11
    //   75: iconst_0
    //   76: iload 4
    //   78: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
    //   81: astore 10
    //   83: goto +3 -> 86
    //   86: aload_2
    //   87: invokevirtual 180	com/tencent/feedback/common/c:g	()Ljava/lang/String;
    //   90: astore 12
    //   92: aload_2
    //   93: invokevirtual 183	com/tencent/feedback/common/c:h	()Ljava/lang/String;
    //   96: astore 13
    //   98: aload_2
    //   99: invokevirtual 186	com/tencent/feedback/common/c:j	()J
    //   102: lstore 5
    //   104: aload_2
    //   105: invokevirtual 190	com/tencent/feedback/common/c:x	()Ljava/util/Map;
    //   108: astore_2
    //   109: aload_1
    //   110: getfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   113: astore 14
    //   115: aload_1
    //   116: getfield 196	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   119: astore 15
    //   121: aload_1
    //   122: getfield 198	com/tencent/feedback/anr/a:c	J
    //   125: lstore 7
    //   127: aload_1
    //   128: getfield 201	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   131: astore 16
    //   133: aload_0
    //   134: aload 12
    //   136: aload 13
    //   138: lload 5
    //   140: aload_2
    //   141: aload 14
    //   143: ldc 157
    //   145: aload 10
    //   147: ldc 203
    //   149: aload 15
    //   151: aload 11
    //   153: lload 7
    //   155: aload 16
    //   157: aconst_null
    //   158: invokestatic 208	com/tencent/feedback/eup/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;[B)Lcom/tencent/feedback/eup/e;
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual 213	com/tencent/feedback/eup/e:C	()Ljava/util/Map;
    //   166: aload_1
    //   167: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   170: invokeinterface 217 2 0
    //   175: aload_2
    //   176: iconst_3
    //   177: invokevirtual 220	com/tencent/feedback/eup/e:a	(B)V
    //   180: aload_2
    //   181: aload_1
    //   182: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   185: invokevirtual 225	com/tencent/feedback/eup/e:h	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: invokestatic 230	com/tencent/feedback/eup/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/eup/c;
    //   192: aload_2
    //   193: aload_3
    //   194: invokevirtual 233	com/tencent/feedback/eup/c:a	(Lcom/tencent/feedback/eup/e;Lcom/tencent/feedback/eup/CrashStrategyBean;)Z
    //   197: istore 9
    //   199: aload_2
    //   200: invokevirtual 236	com/tencent/feedback/eup/e:o	()Ljava/lang/String;
    //   203: astore_0
    //   204: aload_2
    //   205: invokevirtual 240	com/tencent/feedback/eup/e:m	()I
    //   208: istore 4
    //   210: ldc 242
    //   212: iconst_2
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_0
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: iload 4
    //   224: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: aastore
    //   228: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   231: pop
    //   232: ldc 250
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: iload 9
    //   242: invokestatic 255	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   245: aastore
    //   246: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   249: pop
    //   250: iload 9
    //   252: ireturn
    //   253: astore_0
    //   254: goto +8 -> 262
    //   257: astore_0
    //   258: goto +4 -> 262
    //   261: astore_0
    //   262: aload_0
    //   263: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   266: ifne +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 256	java/lang/Throwable:printStackTrace	()V
    //   273: new 44	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   280: astore_1
    //   281: aload_1
    //   282: aload_0
    //   283: invokevirtual 260	java/lang/Object:getClass	()Ljava/lang/Class;
    //   286: invokevirtual 265	java/lang/Class:getName	()Ljava/lang/String;
    //   289: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: ldc_w 267
    //   297: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_1
    //   302: aload_0
    //   303: invokevirtual 270	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: ldc_w 272
    //   313: iconst_1
    //   314: anewarray 4	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: aload_1
    //   320: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aastore
    //   324: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   327: pop
    //   328: iconst_0
    //   329: ireturn
    //   330: new 44	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   337: astore_0
    //   338: aload_0
    //   339: aload_1
    //   340: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   343: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: ldc_w 279
    //   350: iconst_1
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload_0
    //   357: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: aastore
    //   361: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: iconst_0
    //   366: ireturn
    //   367: new 44	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   374: astore 10
    //   376: aload 10
    //   378: aload_0
    //   379: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 10
    //   385: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: astore_0
    //   389: new 44	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   396: astore 10
    //   398: aload 10
    //   400: aload_1
    //   401: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 10
    //   407: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: astore_1
    //   411: new 44	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   418: astore 10
    //   420: aload 10
    //   422: aload_2
    //   423: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 10
    //   429: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: astore_2
    //   433: new 44	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   440: astore 10
    //   442: aload 10
    //   444: aload_3
    //   445: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: ldc_w 281
    //   452: iconst_4
    //   453: anewarray 4	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload_0
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: aload_1
    //   463: aastore
    //   464: dup
    //   465: iconst_2
    //   466: aload_2
    //   467: aastore
    //   468: dup
    //   469: iconst_3
    //   470: aload 10
    //   472: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: aastore
    //   476: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   479: pop
    //   480: iconst_1
    //   481: ireturn
    //   482: ldc_w 283
    //   485: astore 10
    //   487: goto -401 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	paramContext	Context
    //   0	490	1	parama	a
    //   0	490	2	paramc	com.tencent.feedback.common.c
    //   0	490	3	paramCrashStrategyBean	com.tencent.feedback.eup.CrashStrategyBean
    //   66	157	4	i	int
    //   102	37	5	l1	long
    //   125	29	7	l2	long
    //   197	54	9	bool	boolean
    //   81	405	10	localObject	Object
    //   57	95	11	str1	java.lang.String
    //   90	45	12	str2	java.lang.String
    //   96	41	13	str3	java.lang.String
    //   113	29	14	str4	java.lang.String
    //   119	31	15	str5	java.lang.String
    //   131	25	16	str6	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   210	250	253	java/lang/Throwable
    //   133	210	257	java/lang/Throwable
    //   43	68	261	java/lang/Throwable
    //   73	83	261	java/lang/Throwable
    //   86	133	261	java/lang/Throwable
  }
  
  /* Error */
  private static boolean a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 291	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +700 -> 708
    //   11: aload_3
    //   12: getfield 295	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   15: ifnull +693 -> 708
    //   18: aload_3
    //   19: getfield 295	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   22: invokeinterface 298 1 0
    //   27: ifgt +6 -> 33
    //   30: goto +678 -> 708
    //   33: new 53	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 300	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 303	java/io/File:exists	()Z
    //   48: ifne +29 -> 77
    //   51: aload 4
    //   53: invokevirtual 306	java/io/File:getParentFile	()Ljava/io/File;
    //   56: invokevirtual 303	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 4
    //   64: invokevirtual 306	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 309	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload 4
    //   73: invokevirtual 312	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 4
    //   79: invokevirtual 303	java/io/File:exists	()Z
    //   82: ifeq +536 -> 618
    //   85: aload 4
    //   87: invokevirtual 315	java/io/File:canWrite	()Z
    //   90: ifne +6 -> 96
    //   93: goto +525 -> 618
    //   96: aconst_null
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_0
    //   100: new 317	java/io/BufferedWriter
    //   103: dup
    //   104: new 319	java/io/FileWriter
    //   107: dup
    //   108: aload 4
    //   110: iconst_0
    //   111: invokespecial 322	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   114: invokespecial 325	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   117: astore_1
    //   118: aload_3
    //   119: getfield 295	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   122: ldc 157
    //   124: invokeinterface 163 2 0
    //   129: checkcast 327	[Ljava/lang/String;
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
    //   166: ldc_w 329
    //   169: invokespecial 330	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: astore 5
    //   174: aload 5
    //   176: aload 4
    //   178: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 5
    //   184: ldc_w 332
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
    //   215: ldc_w 334
    //   218: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: aload 5
    //   225: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 337	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   231: aload_1
    //   232: invokevirtual 340	java/io/BufferedWriter:flush	()V
    //   235: aload_3
    //   236: getfield 295	com/tencent/feedback/anr/f:d	Ljava/util/Map;
    //   239: invokeinterface 344 1 0
    //   244: invokeinterface 347 1 0
    //   249: astore_0
    //   250: aload_0
    //   251: invokeinterface 116 1 0
    //   256: ifeq +192 -> 448
    //   259: aload_0
    //   260: invokeinterface 120 1 0
    //   265: checkcast 349	java/util/Map$Entry
    //   268: astore_2
    //   269: aload_2
    //   270: invokeinterface 352 1 0
    //   275: checkcast 165	java/lang/String
    //   278: ldc 157
    //   280: invokevirtual 356	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifne -33 -> 250
    //   286: aload_2
    //   287: invokeinterface 359 1 0
    //   292: ifnull -42 -> 250
    //   295: aload_2
    //   296: invokeinterface 359 1 0
    //   301: checkcast 327	[Ljava/lang/String;
    //   304: arraylength
    //   305: iconst_3
    //   306: if_icmplt -56 -> 250
    //   309: aload_2
    //   310: invokeinterface 359 1 0
    //   315: checkcast 327	[Ljava/lang/String;
    //   318: iconst_0
    //   319: aaload
    //   320: astore_3
    //   321: aload_2
    //   322: invokeinterface 359 1 0
    //   327: checkcast 327	[Ljava/lang/String;
    //   330: iconst_1
    //   331: aaload
    //   332: astore 4
    //   334: aload_2
    //   335: invokeinterface 359 1 0
    //   340: checkcast 327	[Ljava/lang/String;
    //   343: iconst_2
    //   344: aaload
    //   345: astore 5
    //   347: new 44	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 361
    //   354: invokespecial 330	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: astore 6
    //   359: aload 6
    //   361: aload_2
    //   362: invokeinterface 352 1 0
    //   367: checkcast 165	java/lang/String
    //   370: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 6
    //   376: ldc_w 363
    //   379: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 6
    //   385: aload 5
    //   387: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 6
    //   393: ldc_w 332
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
    //   425: ldc_w 334
    //   428: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: aload 6
    //   435: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 337	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   441: aload_1
    //   442: invokevirtual 340	java/io/BufferedWriter:flush	()V
    //   445: goto -195 -> 250
    //   448: aload_1
    //   449: invokevirtual 366	java/io/BufferedWriter:close	()V
    //   452: iconst_1
    //   453: ireturn
    //   454: astore_0
    //   455: aload_0
    //   456: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   459: ifne +7 -> 466
    //   462: aload_0
    //   463: invokevirtual 367	java/io/IOException:printStackTrace	()V
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
    //   501: invokevirtual 367	java/io/IOException:printStackTrace	()V
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
    //   542: invokevirtual 368	java/io/IOException:getMessage	()Ljava/lang/String;
    //   545: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload_1
    //   550: astore_0
    //   551: ldc_w 370
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
    //   574: invokevirtual 366	java/io/BufferedWriter:close	()V
    //   577: iconst_0
    //   578: ireturn
    //   579: astore_0
    //   580: aload_0
    //   581: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   584: ifne +7 -> 591
    //   587: aload_0
    //   588: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   591: iconst_0
    //   592: ireturn
    //   593: aload_1
    //   594: ifnull +22 -> 616
    //   597: aload_1
    //   598: invokevirtual 366	java/io/BufferedWriter:close	()V
    //   601: goto +15 -> 616
    //   604: astore_1
    //   605: aload_1
    //   606: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   609: ifne +7 -> 616
    //   612: aload_1
    //   613: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   616: aload_0
    //   617: athrow
    //   618: ldc_w 372
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
    //   644: invokevirtual 373	java/lang/Exception:printStackTrace	()V
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
    //   677: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   680: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: ldc_w 376
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
    //   708: ldc_w 378
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
    //   0	725	0	paramString1	java.lang.String
    //   0	725	1	paramString2	java.lang.String
    //   0	725	2	paramString3	java.lang.String
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
  public final void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 380	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 382
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
    //   31: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   40: invokestatic 388	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnonnull +23 -> 70
    //   50: ldc_w 390
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   65: iconst_0
    //   66: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   69: return
    //   70: invokestatic 396	com/tencent/feedback/eup/CrashReport:getCrashRuntimeStrategy	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   73: astore 8
    //   75: aload 8
    //   77: ifnull +580 -> 657
    //   80: invokestatic 402	com/tencent/feedback/eup/f:l	()Lcom/tencent/feedback/eup/f;
    //   83: invokevirtual 404	com/tencent/feedback/eup/f:a	()Z
    //   86: ifne +6 -> 92
    //   89: goto +568 -> 657
    //   92: ldc_w 406
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   102: pop
    //   103: aload_1
    //   104: iconst_0
    //   105: invokestatic 409	com/tencent/feedback/anr/a:a	(Ljava/lang/String;Z)Lcom/tencent/feedback/anr/f;
    //   108: astore 9
    //   110: aload 9
    //   112: ifnull +614 -> 726
    //   115: aload 9
    //   117: getfield 410	com/tencent/feedback/anr/f:c	J
    //   120: lstore_3
    //   121: goto +3 -> 124
    //   124: lload_3
    //   125: lstore 5
    //   127: lload_3
    //   128: ldc2_w 27
    //   131: lcmp
    //   132: ifne +26 -> 158
    //   135: ldc_w 412
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: new 416	java/util/Date
    //   149: dup
    //   150: invokespecial 417	java/util/Date:<init>	()V
    //   153: invokevirtual 420	java/util/Date:getTime	()J
    //   156: lstore 5
    //   158: lload 5
    //   160: aload_0
    //   161: getfield 30	com/tencent/feedback/anr/b:b	J
    //   164: lsub
    //   165: invokestatic 426	java/lang/Math:abs	(J)J
    //   168: ldc2_w 427
    //   171: lcmp
    //   172: ifge +26 -> 198
    //   175: ldc_w 430
    //   178: iconst_1
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: sipush 10000
    //   187: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -134 -> 61
    //   198: aload_0
    //   199: lload 5
    //   201: putfield 30	com/tencent/feedback/anr/b:b	J
    //   204: aload_0
    //   205: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   208: iconst_1
    //   209: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   212: invokestatic 432	com/tencent/feedback/proguard/a:b	()Ljava/util/Map;
    //   215: astore 10
    //   217: aload 10
    //   219: ifnull +404 -> 623
    //   222: aload 10
    //   224: invokeinterface 298 1 0
    //   229: ifgt +6 -> 235
    //   232: goto +391 -> 623
    //   235: aload_0
    //   236: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   239: ldc2_w 427
    //   242: invokestatic 434	com/tencent/feedback/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   245: astore 11
    //   247: aload 11
    //   249: ifnonnull +17 -> 266
    //   252: ldc_w 436
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -202 -> 61
    //   266: aload 11
    //   268: getfield 439	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   271: invokestatic 444	android/os/Process:myPid	()I
    //   274: if_icmpeq +25 -> 299
    //   277: ldc_w 446
    //   280: iconst_1
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: aload 11
    //   288: getfield 449	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   291: aastore
    //   292: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   295: pop
    //   296: goto -235 -> 61
    //   299: ldc_w 451
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 453	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   309: pop
    //   310: aload_0
    //   311: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   314: invokevirtual 51	android/content/Context:getFilesDir	()Ljava/io/File;
    //   317: astore 9
    //   319: new 44	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 455
    //   326: invokespecial 330	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: astore 12
    //   331: aload 12
    //   333: lload 5
    //   335: invokevirtual 458	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: new 53	java/io/File
    //   342: dup
    //   343: aload 9
    //   345: aload 12
    //   347: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokespecial 461	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   353: astore 12
    //   355: new 152	com/tencent/feedback/anr/a
    //   358: dup
    //   359: invokespecial 462	com/tencent/feedback/anr/a:<init>	()V
    //   362: astore 9
    //   364: aload 9
    //   366: lload 5
    //   368: putfield 198	com/tencent/feedback/anr/a:c	J
    //   371: aload 9
    //   373: aload 12
    //   375: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   378: putfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   381: aload 9
    //   383: aload 11
    //   385: getfield 449	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   388: putfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   391: aload 9
    //   393: aload 11
    //   395: getfield 465	android/app/ActivityManager$ProcessErrorStateInfo:shortMsg	Ljava/lang/String;
    //   398: putfield 196	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   401: aload 9
    //   403: aload 11
    //   405: getfield 468	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   408: putfield 201	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   411: aload 9
    //   413: aload 10
    //   415: putfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   418: aload 9
    //   420: getfield 198	com/tencent/feedback/anr/a:c	J
    //   423: lstore_3
    //   424: aload 9
    //   426: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   429: astore 10
    //   431: aload 9
    //   433: getfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   436: astore 11
    //   438: aload 9
    //   440: getfield 196	com/tencent/feedback/anr/a:f	Ljava/lang/String;
    //   443: astore 12
    //   445: aload 9
    //   447: getfield 201	com/tencent/feedback/anr/a:e	Ljava/lang/String;
    //   450: astore 13
    //   452: aload 9
    //   454: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   457: ifnonnull +8 -> 465
    //   460: iconst_0
    //   461: istore_2
    //   462: goto +14 -> 476
    //   465: aload 9
    //   467: getfield 155	com/tencent/feedback/anr/a:b	Ljava/util/Map;
    //   470: invokeinterface 298 1 0
    //   475: istore_2
    //   476: ldc_w 470
    //   479: bipush 6
    //   481: anewarray 4	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: lload_3
    //   487: invokestatic 475	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: aload 10
    //   495: aastore
    //   496: dup
    //   497: iconst_2
    //   498: aload 11
    //   500: aastore
    //   501: dup
    //   502: iconst_3
    //   503: aload 12
    //   505: aastore
    //   506: dup
    //   507: iconst_4
    //   508: aload 13
    //   510: aastore
    //   511: dup
    //   512: iconst_5
    //   513: iload_2
    //   514: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: invokestatic 90	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   521: pop
    //   522: aload_0
    //   523: getfield 32	com/tencent/feedback/anr/b:c	Landroid/content/Context;
    //   526: aload 9
    //   528: aload 7
    //   530: aload 8
    //   532: invokestatic 477	com/tencent/feedback/anr/b:a	(Landroid/content/Context;Lcom/tencent/feedback/anr/a;Lcom/tencent/feedback/common/c;Lcom/tencent/feedback/eup/CrashStrategyBean;)Z
    //   535: ifne +17 -> 552
    //   538: ldc_w 479
    //   541: iconst_0
    //   542: anewarray 4	java/lang/Object
    //   545: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   548: pop
    //   549: goto -488 -> 61
    //   552: aload_0
    //   553: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   556: iconst_3
    //   557: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   560: aload_1
    //   561: aload 9
    //   563: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   566: aload 9
    //   568: getfield 193	com/tencent/feedback/anr/a:a	Ljava/lang/String;
    //   571: invokestatic 481	com/tencent/feedback/anr/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   574: ifne +21 -> 595
    //   577: ldc_w 483
    //   580: iconst_1
    //   581: anewarray 4	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload_1
    //   587: aastore
    //   588: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   591: pop
    //   592: goto -531 -> 61
    //   595: ldc_w 485
    //   598: iconst_1
    //   599: anewarray 4	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload 9
    //   606: getfield 222	com/tencent/feedback/anr/a:d	Ljava/lang/String;
    //   609: aastore
    //   610: invokestatic 453	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   613: pop
    //   614: aload_0
    //   615: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   618: iconst_0
    //   619: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   622: return
    //   623: ldc_w 487
    //   626: iconst_0
    //   627: anewarray 4	java/lang/Object
    //   630: invokestatic 414	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   633: pop
    //   634: goto -573 -> 61
    //   637: astore_1
    //   638: aload_1
    //   639: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   642: pop
    //   643: ldc_w 489
    //   646: iconst_0
    //   647: anewarray 4	java/lang/Object
    //   650: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   653: pop
    //   654: goto -593 -> 61
    //   657: ldc_w 491
    //   660: iconst_0
    //   661: anewarray 4	java/lang/Object
    //   664: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   667: pop
    //   668: goto -607 -> 61
    //   671: astore_1
    //   672: goto +39 -> 711
    //   675: astore_1
    //   676: aload_1
    //   677: invokestatic 139	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   680: ifne +7 -> 687
    //   683: aload_1
    //   684: invokevirtual 256	java/lang/Throwable:printStackTrace	()V
    //   687: ldc_w 493
    //   690: iconst_1
    //   691: anewarray 4	java/lang/Object
    //   694: dup
    //   695: iconst_0
    //   696: aload_1
    //   697: invokevirtual 260	java/lang/Object:getClass	()Ljava/lang/Class;
    //   700: invokevirtual 494	java/lang/Class:toString	()Ljava/lang/String;
    //   703: aastore
    //   704: invokestatic 274	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   707: pop
    //   708: goto -94 -> 614
    //   711: aload_0
    //   712: getfield 26	com/tencent/feedback/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   715: iconst_0
    //   716: invokevirtual 385	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   719: aload_1
    //   720: athrow
    //   721: astore_1
    //   722: aload_0
    //   723: monitorexit
    //   724: aload_1
    //   725: athrow
    //   726: ldc2_w 27
    //   729: lstore_3
    //   730: goto -606 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	b
    //   0	733	1	paramString	java.lang.String
    //   461	53	2	i	int
    //   120	610	3	l1	long
    //   125	242	5	l2	long
    //   43	486	7	localc	com.tencent.feedback.common.c
    //   73	458	8	localCrashStrategyBean	com.tencent.feedback.eup.CrashStrategyBean
    //   108	497	9	localObject1	Object
    //   215	279	10	localObject2	Object
    //   245	254	11	localObject3	Object
    //   329	175	12	localObject4	Object
    //   450	59	13	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   212	217	637	java/lang/Throwable
    //   36	45	671	finally
    //   50	61	671	finally
    //   70	75	671	finally
    //   80	89	671	finally
    //   92	110	671	finally
    //   115	121	671	finally
    //   135	158	671	finally
    //   158	195	671	finally
    //   198	212	671	finally
    //   212	217	671	finally
    //   222	232	671	finally
    //   235	247	671	finally
    //   252	263	671	finally
    //   266	296	671	finally
    //   299	460	671	finally
    //   465	476	671	finally
    //   476	549	671	finally
    //   552	592	671	finally
    //   595	614	671	finally
    //   623	634	671	finally
    //   638	654	671	finally
    //   657	668	671	finally
    //   676	687	671	finally
    //   687	708	671	finally
    //   36	45	675	java/lang/Throwable
    //   50	61	675	java/lang/Throwable
    //   70	75	675	java/lang/Throwable
    //   80	89	675	java/lang/Throwable
    //   92	110	675	java/lang/Throwable
    //   115	121	675	java/lang/Throwable
    //   135	158	675	java/lang/Throwable
    //   158	195	675	java/lang/Throwable
    //   198	212	675	java/lang/Throwable
    //   222	232	675	java/lang/Throwable
    //   235	247	675	java/lang/Throwable
    //   252	263	675	java/lang/Throwable
    //   266	296	675	java/lang/Throwable
    //   299	460	675	java/lang/Throwable
    //   465	476	675	java/lang/Throwable
    //   476	549	675	java/lang/Throwable
    //   552	592	675	java/lang/Throwable
    //   595	614	675	java/lang/Throwable
    //   623	634	675	java/lang/Throwable
    //   638	654	675	java/lang/Throwable
    //   657	668	675	java/lang/Throwable
    //   2	25	721	finally
    //   26	36	721	finally
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