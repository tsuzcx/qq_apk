package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Peach;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class afc
{
  public static afc a = new afc();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public static int[] c = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public static String d = null;
  public afu e;
  public Handler f;
  public boolean g = false;
  public Peach h;
  public final Object i = new Object();
  public final AtomicReference<aew> j = new AtomicReference(null);
  public final AtomicReference<Boolean> k = new AtomicReference(Boolean.FALSE);
  
  /* Error */
  public static void a(afc paramafc)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 84	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: pop
    //   5: ldc 86
    //   7: monitorenter
    //   8: getstatic 89	com/tencent/token/ahr:a	Landroid/content/Context;
    //   11: astore 9
    //   13: ldc 86
    //   15: monitorexit
    //   16: aload 9
    //   18: aload_0
    //   19: getfield 91	com/tencent/token/afc:h	Lcom/tencent/turingfd/sdk/qps/Peach;
    //   22: invokestatic 96	com/tencent/token/afs:a	(Landroid/content/Context;Lcom/tencent/turingfd/sdk/qps/Peach;)V
    //   25: aload_0
    //   26: getfield 98	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   29: getfield 103	com/tencent/token/afu:v	J
    //   32: invokestatic 109	java/lang/Thread:sleep	(J)V
    //   35: getstatic 114	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   38: aload 9
    //   40: new 116	com/tencent/token/aez
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 118	com/tencent/token/aez:<init>	(Lcom/tencent/token/afc;)V
    //   48: invokevirtual 121	com/tencent/token/afn:a	(Landroid/content/Context;Lcom/tencent/token/afm;)J
    //   51: pop2
    //   52: getstatic 114	com/tencent/token/afn:a	Lcom/tencent/token/afn;
    //   55: astore 10
    //   57: aload 10
    //   59: bipush 41
    //   61: invokevirtual 124	com/tencent/token/afn:a	(I)Z
    //   64: ifeq +43 -> 107
    //   67: getstatic 129	com/tencent/token/afx:a	Ljava/util/Map;
    //   70: getstatic 131	com/tencent/token/afx:c	Ljava/lang/String;
    //   73: invokeinterface 137 2 0
    //   78: ifeq +29 -> 107
    //   81: new 139	com/tencent/token/afv
    //   84: dup
    //   85: getstatic 129	com/tencent/token/afx:a	Ljava/util/Map;
    //   88: getstatic 131	com/tencent/token/afx:c	Ljava/lang/String;
    //   91: invokeinterface 143 2 0
    //   96: checkcast 145	com/tencent/token/afx$a
    //   99: aload 9
    //   101: invokespecial 148	com/tencent/token/afv:<init>	(Lcom/tencent/token/afx$a;Landroid/content/Context;)V
    //   104: invokevirtual 151	java/lang/Thread:start	()V
    //   107: aload 10
    //   109: bipush 39
    //   111: invokevirtual 124	com/tencent/token/afn:a	(I)Z
    //   114: istore 4
    //   116: iconst_1
    //   117: istore_2
    //   118: iload 4
    //   120: ifeq +310 -> 430
    //   123: new 153	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   130: astore 11
    //   132: new 156	java/lang/String
    //   135: dup
    //   136: ldc 158
    //   138: invokestatic 163	com/tencent/token/acy:b	(Ljava/lang/String;)[B
    //   141: invokespecial 166	java/lang/String:<init>	([B)V
    //   144: ldc 168
    //   146: invokevirtual 172	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   149: astore 12
    //   151: new 174	java/util/HashSet
    //   154: dup
    //   155: invokespecial 175	java/util/HashSet:<init>	()V
    //   158: astore 13
    //   160: aload 12
    //   162: arraylength
    //   163: istore_3
    //   164: iconst_0
    //   165: istore_1
    //   166: iload_1
    //   167: iload_3
    //   168: if_icmpge +195 -> 363
    //   171: aload 12
    //   173: iload_1
    //   174: aaload
    //   175: ldc 177
    //   177: invokevirtual 172	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   180: astore 7
    //   182: aload 7
    //   184: arraylength
    //   185: iconst_2
    //   186: if_icmplt +170 -> 356
    //   189: aload 7
    //   191: aload 7
    //   193: arraylength
    //   194: iconst_1
    //   195: isub
    //   196: aaload
    //   197: invokevirtual 181	java/lang/String:trim	()Ljava/lang/String;
    //   200: astore 14
    //   202: aconst_null
    //   203: astore 7
    //   205: new 183	java/io/File
    //   208: dup
    //   209: aload 14
    //   211: invokespecial 186	java/io/File:<init>	(Ljava/lang/String;)V
    //   214: astore 8
    //   216: aload 8
    //   218: invokevirtual 190	java/io/File:exists	()Z
    //   221: ifeq +135 -> 356
    //   224: aload 8
    //   226: invokevirtual 193	java/io/File:getName	()Ljava/lang/String;
    //   229: astore 8
    //   231: aload 8
    //   233: astore 7
    //   235: aload 7
    //   237: ifnull +119 -> 356
    //   240: aload 7
    //   242: ldc 195
    //   244: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +109 -> 356
    //   250: aload 7
    //   252: ldc 201
    //   254: invokevirtual 205	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   257: ifeq +99 -> 356
    //   260: aload 7
    //   262: ldc 207
    //   264: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   267: ifne +89 -> 356
    //   270: ldc 209
    //   272: aload 14
    //   274: invokestatic 215	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   277: ifne +79 -> 356
    //   280: aload 13
    //   282: aload 14
    //   284: invokevirtual 217	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   287: ifne +69 -> 356
    //   290: aload 13
    //   292: aload 14
    //   294: invokevirtual 220	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   297: pop
    //   298: aload 9
    //   300: aload 14
    //   302: invokestatic 223	com/tencent/token/ahr:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 7
    //   307: aload 7
    //   309: ifnull +47 -> 356
    //   312: aload 7
    //   314: ldc 225
    //   316: invokestatic 215	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   319: ifne +37 -> 356
    //   322: aload 7
    //   324: ldc 227
    //   326: invokestatic 215	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   329: ifne +27 -> 356
    //   332: aload 11
    //   334: invokevirtual 231	java/lang/StringBuilder:length	()I
    //   337: ifle +11 -> 348
    //   340: aload 11
    //   342: ldc 233
    //   344: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 11
    //   350: aload 7
    //   352: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: iload_1
    //   357: iconst_1
    //   358: iadd
    //   359: istore_1
    //   360: goto -194 -> 166
    //   363: aload 11
    //   365: ldc 239
    //   367: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: invokestatic 245	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   374: invokevirtual 84	java/lang/Object:getClass	()Ljava/lang/Class;
    //   377: invokevirtual 248	java/lang/Class:getName	()Ljava/lang/String;
    //   380: astore 7
    //   382: ldc 250
    //   384: aload 7
    //   386: invokestatic 215	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   389: ifne +11 -> 400
    //   392: aload 11
    //   394: aload 7
    //   396: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 11
    //   402: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: ldc 255
    //   407: ldc_w 257
    //   410: invokevirtual 261	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   413: astore 7
    //   415: aload_0
    //   416: getfield 91	com/tencent/token/afc:h	Lcom/tencent/turingfd/sdk/qps/Peach;
    //   419: aload 9
    //   421: ldc_w 263
    //   424: aload 7
    //   426: iconst_1
    //   427: invokevirtual 268	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   430: aload_0
    //   431: getfield 98	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   434: getfield 271	com/tencent/token/afu:s	Z
    //   437: ifeq +247 -> 684
    //   440: aload 10
    //   442: bipush 45
    //   444: invokevirtual 124	com/tencent/token/afn:a	(I)Z
    //   447: ifeq +237 -> 684
    //   450: aload_0
    //   451: getfield 91	com/tencent/token/afc:h	Lcom/tencent/turingfd/sdk/qps/Peach;
    //   454: astore 10
    //   456: getstatic 276	com/tencent/token/agi:b	I
    //   459: istore_1
    //   460: aload 10
    //   462: invokevirtual 84	java/lang/Object:getClass	()Ljava/lang/Class;
    //   465: pop
    //   466: aload 9
    //   468: ldc_w 278
    //   471: invokestatic 280	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   474: invokestatic 286	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   477: invokevirtual 290	java/lang/Long:longValue	()J
    //   480: lstore 5
    //   482: goto +6 -> 488
    //   485: lconst_0
    //   486: lstore 5
    //   488: lload 5
    //   490: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   493: lsub
    //   494: invokestatic 300	java/lang/Math:abs	(J)J
    //   497: getstatic 302	com/tencent/token/agi:a	J
    //   500: lcmp
    //   501: iflt +8 -> 509
    //   504: iconst_1
    //   505: istore_1
    //   506: goto +5 -> 511
    //   509: iconst_0
    //   510: istore_1
    //   511: iload_1
    //   512: ifeq +172 -> 684
    //   515: iload_2
    //   516: istore_1
    //   517: aload 9
    //   519: ldc_w 304
    //   522: invokestatic 280	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   525: invokestatic 307	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   528: ifne +40 -> 568
    //   531: lload 5
    //   533: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   536: lsub
    //   537: invokestatic 300	java/lang/Math:abs	(J)J
    //   540: getstatic 312	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   543: aload 9
    //   545: ldc_w 314
    //   548: getstatic 315	com/tencent/turingfd/sdk/qps/Pistachio:a	J
    //   551: ldc2_w 316
    //   554: invokevirtual 320	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;Ljava/lang/String;JJ)J
    //   557: lcmp
    //   558: iflt +8 -> 566
    //   561: iload_2
    //   562: istore_1
    //   563: goto +5 -> 568
    //   566: iconst_0
    //   567: istore_1
    //   568: iload_1
    //   569: ifeq +105 -> 674
    //   572: aload 9
    //   574: invokestatic 325	com/tencent/token/agl:b	(Landroid/content/Context;)Lcom/tencent/token/agh;
    //   577: astore 8
    //   579: aload 8
    //   581: astore 7
    //   583: aload 8
    //   585: getfield 329	com/tencent/token/agh:a	I
    //   588: ifeq +10 -> 598
    //   591: aload 9
    //   593: invokestatic 331	com/tencent/token/agl:a	(Landroid/content/Context;)Lcom/tencent/token/agh;
    //   596: astore 7
    //   598: aload 7
    //   600: getfield 329	com/tencent/token/agh:a	I
    //   603: ifne +71 -> 674
    //   606: aload 7
    //   608: getfield 332	com/tencent/token/agh:d	Ljava/lang/String;
    //   611: astore 8
    //   613: new 334	java/util/HashMap
    //   616: dup
    //   617: invokespecial 335	java/util/HashMap:<init>	()V
    //   620: astore 11
    //   622: aload 11
    //   624: ldc_w 304
    //   627: aload 8
    //   629: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   632: pop
    //   633: aload 9
    //   635: aload 11
    //   637: invokestatic 342	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   640: aload 7
    //   642: invokevirtual 343	com/tencent/token/agh:toString	()Ljava/lang/String;
    //   645: astore 7
    //   647: new 334	java/util/HashMap
    //   650: dup
    //   651: invokespecial 335	java/util/HashMap:<init>	()V
    //   654: astore 8
    //   656: aload 8
    //   658: ldc_w 345
    //   661: aload 7
    //   663: invokevirtual 339	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: pop
    //   667: aload 9
    //   669: aload 8
    //   671: invokestatic 342	com/tencent/turingfd/sdk/qps/Peach:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   674: aload 10
    //   676: aload 9
    //   678: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   681: invokevirtual 348	com/tencent/turingfd/sdk/qps/Peach:b	(Landroid/content/Context;J)V
    //   684: aload_0
    //   685: getfield 98	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   688: astore 7
    //   690: aload 7
    //   692: getfield 351	com/tencent/token/afu:o	Z
    //   695: ifeq +48 -> 743
    //   698: aload 7
    //   700: getfield 354	com/tencent/token/afu:b	Lcom/tencent/token/afq;
    //   703: astore 8
    //   705: aload 8
    //   707: astore 7
    //   709: aload 8
    //   711: ifnonnull +8 -> 719
    //   714: getstatic 356	com/tencent/token/afu:a	Lcom/tencent/token/afq;
    //   717: astore 7
    //   719: aload 7
    //   721: invokeinterface 360 1 0
    //   726: ifeq +17 -> 743
    //   729: aload_0
    //   730: aload_0
    //   731: getfield 98	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   734: getfield 362	com/tencent/token/afu:d	Landroid/content/Context;
    //   737: iconst_0
    //   738: iconst_0
    //   739: invokevirtual 365	com/tencent/token/afc:a	(Landroid/content/Context;ZI)Lcom/tencent/token/aew;
    //   742: pop
    //   743: return
    //   744: astore_0
    //   745: ldc 86
    //   747: monitorexit
    //   748: aload_0
    //   749: athrow
    //   750: astore 7
    //   752: goto -717 -> 35
    //   755: astore 7
    //   757: goto -394 -> 363
    //   760: astore 8
    //   762: goto -527 -> 235
    //   765: astore 7
    //   767: goto -282 -> 485
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	paramafc	afc
    //   165	404	1	m	int
    //   117	445	2	n	int
    //   163	6	3	i1	int
    //   114	5	4	bool	boolean
    //   480	52	5	l	long
    //   180	540	7	localObject1	Object
    //   750	1	7	localInterruptedException	InterruptedException
    //   755	1	7	localObject2	Object
    //   765	1	7	localObject3	Object
    //   214	496	8	localObject4	Object
    //   760	1	8	localObject5	Object
    //   11	666	9	localContext	Context
    //   55	620	10	localObject6	Object
    //   130	506	11	localObject7	Object
    //   149	23	12	arrayOfString	String[]
    //   158	133	13	localHashSet	java.util.HashSet
    //   200	101	14	str	String
    // Exception table:
    //   from	to	target	type
    //   8	13	744	finally
    //   25	35	750	java/lang/InterruptedException
    //   132	164	755	finally
    //   171	202	755	finally
    //   240	307	755	finally
    //   312	348	755	finally
    //   348	356	755	finally
    //   205	231	760	finally
    //   466	482	765	finally
  }
  
  private aew b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final int a(aew paramaew)
  {
    if (this.e.p) {
      return 2;
    }
    if ((paramaew.d == 0) && (!TextUtils.isEmpty(paramaew.b)))
    {
      long l2 = System.currentTimeMillis() / 1000L;
      if (l2 >= paramaew.c)
      {
        this.e.getClass();
        return 3;
      }
      paramaew = this.h;
      Context localContext;
      long l1;
      label99:
      try
      {
        localContext = ahr.a;
        paramaew.getClass();
        paramaew = Peach.b(localContext, "107");
      }
      finally {}
    }
    try
    {
      l1 = Long.valueOf(paramaew).longValue();
    }
    finally
    {
      break label99;
    }
    l1 = 0L;
    paramaew = this.h;
    try
    {
      localContext = ahr.a;
      if (Math.abs(l2 - paramaew.a(localContext, "108")) >= l1)
      {
        this.e.getClass();
        return 3;
      }
      return 1;
    }
    finally {}
    return 2;
  }
  
  public final aew a(Context paramContext)
  {
    synchronized (this.j)
    {
      aew localaew = (aew)this.j.get();
      Object localObject = localaew;
      if (localaew == null)
      {
        localObject = this.h;
        if (localObject != null) {
          paramContext = ((Peach)localObject).a(paramContext);
        } else {
          paramContext = aew.a(1);
        }
        this.j.set(paramContext);
        localObject = paramContext;
      }
      return localObject;
    }
  }
  
  public final aew a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    aew localaew = a(paramContext);
    if (this.e == null) {
      return aew.a(-10002);
    }
    int m = a(localaew);
    if (m == 1) {
      return localaew;
    }
    if (m == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a();
        return aew.a(-10008);
      }
      synchronized (this.i)
      {
        ??? = a(paramContext);
        if ((??? != localaew) && (a((aew)???) == 1)) {
          return ???;
        }
        synchronized (this.k)
        {
          if (!((Boolean)this.k.get()).booleanValue())
          {
            this.k.set(Boolean.TRUE);
            this.f.post(new afa(this, paramContext, paramInt));
          }
          try
          {
            localAtomicReference = this.k;
            if (!paramBoolean) {
              break label247;
            }
            l = this.e.t;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              AtomicReference localAtomicReference;
              continue;
              long l = 10000L;
            }
          }
          localAtomicReference.wait(l);
          paramContext = a(paramContext);
          if (paramContext != localaew) {
            return paramContext;
          }
          paramContext = aew.a(-10004);
          return paramContext;
        }
      }
    }
    else
    {
      if (m == 3) {
        a();
      }
      return localaew;
    }
  }
  
  public final aew a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final afg a(byte[] paramArrayOfByte)
  {
    this.e.getClass();
    acs localacs = new acs("https://tdid.m.qq.com?mc=2");
    try
    {
      System.currentTimeMillis();
      paramArrayOfByte = localacs.a(paramArrayOfByte);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.a == 0)) {
        paramArrayOfByte = new afg(0, paramArrayOfByte.b);
      } else {
        paramArrayOfByte = afg.a(paramArrayOfByte.a - 20000);
      }
    }
    finally
    {
      label71:
      break label71;
    }
    paramArrayOfByte = afg.a(-20000);
    if (paramArrayOfByte.b != 0) {}
    return paramArrayOfByte;
  }
  
  public final void a()
  {
    synchronized (this.k)
    {
      if (((Boolean)this.k.get()).booleanValue()) {
        return;
      }
      this.k.set(Boolean.TRUE);
      Message localMessage = Message.obtain(this.f, 2, Integer.valueOf(3));
      this.f.sendMessageDelayed(localMessage, 0L);
      return;
    }
  }
  
  /* Error */
  public final void a(aew paramaew, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/token/afc:j	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +13 -> 28
    //   18: aload_1
    //   19: getfield 380	com/tencent/token/aew:d	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 69	com/tencent/token/afc:j	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 405	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   36: aload_3
    //   37: monitorexit
    //   38: return
    //   39: aload_3
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: goto -5 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	afc
    //   0	47	1	paramaew	aew
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final class a
    implements afm
  {
    public a() {}
    
    public final Map<Integer, Integer> a()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  public final class b
    extends Handler
  {
    public Context a;
    
    public b(Looper paramLooper, Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public final void handleMessage(Message arg1)
    {
      System.currentTimeMillis();
      int i = ???.what;
      if (i != 1)
      {
        if (i == 2)
        {
          i = ((Integer)???.obj).intValue();
          ??? = afc.this.a(this.a, true, false, i);
          afc.this.a(???, false);
          synchronized (afc.this.k)
          {
            afc.this.k.set(Boolean.FALSE);
            afc.this.k.notifyAll();
            return;
          }
        }
      }
      else {
        afc.this.a(this.a, true, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afc
 * JD-Core Version:    0.7.0.1
 */