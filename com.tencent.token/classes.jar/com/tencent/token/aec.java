package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.turingfd.sdk.qps.TNative.aa;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class aec
{
  public static aec a = new aec();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public static int[] c = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public agr d;
  public Handler e;
  public boolean f = false;
  public aef g;
  public final Object h = new Object();
  public final AtomicReference<adt> i = new AtomicReference(null);
  public final AtomicReference<Boolean> j = new AtomicReference(Boolean.FALSE);
  
  private int a(adt paramadt)
  {
    if (this.d.o) {
      return 2;
    }
    if ((paramadt.d == 0) && (!TextUtils.isEmpty(paramadt.b)))
    {
      long l2 = System.currentTimeMillis() / 1000L;
      if (l2 >= paramadt.c)
      {
        this.d.getClass();
        return 3;
      }
      paramadt = this.g;
      long l1;
      label98:
      try
      {
        Context localContext = agn.a;
        paramadt.getClass();
        paramadt = aef.a(localContext, "107");
      }
      finally {}
    }
    try
    {
      l1 = Long.valueOf(paramadt).longValue();
    }
    finally
    {
      break label98;
    }
    l1 = 0L;
    try
    {
      paramadt = agn.a;
      if (Math.abs(l2 - aef.b(paramadt, "108")) >= l1)
      {
        this.d.getClass();
        return 3;
      }
      return 1;
    }
    finally {}
    return 2;
  }
  
  private long a(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private adt a(Context paramContext)
  {
    synchronized (this.i)
    {
      adt localadt = (adt)this.i.get();
      Object localObject = localadt;
      if (localadt == null)
      {
        if (this.g != null) {
          paramContext = aef.a(paramContext);
        } else {
          paramContext = adt.a(1);
        }
        this.i.set(paramContext);
        localObject = paramContext;
      }
      return localObject;
    }
  }
  
  private adt a(Context paramContext, byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject6 = TNative.aa.b(new SparseArray(), paramArrayOfByte, 0);
      int k = agn.a((SparseArray)localObject6);
      if (k != 0) {
        return adt.a(k);
      }
      Object localObject2 = (Integer)agn.a((SparseArray)localObject6, 102, Integer.class);
      if (localObject2 == null) {
        return adt.a(-30000);
      }
      if (((Integer)localObject2).intValue() < 0) {
        return adt.a(((Integer)localObject2).intValue() - 30000);
      }
      Object localObject1 = (String)agn.a((SparseArray)localObject6, 101, String.class);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 == null) {
        paramArrayOfByte = "";
      }
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        return adt.a(((Integer)localObject2).intValue() - 10010);
      }
      localObject2 = (String)agn.a((SparseArray)localObject6, 104, String.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      Object localObject3 = (String)agn.a((SparseArray)localObject6, 105, String.class);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      Object localObject4 = (String)agn.a((SparseArray)localObject6, 106, String.class);
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      Object localObject7 = (Integer)agn.a((SparseArray)localObject6, 107, Integer.class);
      localObject4 = (String)agn.a((SparseArray)localObject6, 108, String.class);
      Object localObject5 = localObject4;
      if (localObject4 == null) {
        localObject5 = "";
      }
      localObject4 = (String)agn.a((SparseArray)localObject6, 150, String.class);
      localObject6 = localObject4;
      if (localObject4 == null) {
        localObject6 = "";
      }
      if (localObject7 != null)
      {
        localObject4 = localObject7;
        if (((Integer)localObject7).intValue() >= 3600) {}
      }
      else
      {
        localObject4 = Integer.valueOf(3600);
      }
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((Integer)localObject4).intValue();
      localObject7 = new adt.a();
      ((adt.a)localObject7).b = (l1 + l2);
      ((adt.a)localObject7).a = paramArrayOfByte;
      ((adt.a)localObject7).d = ((String)localObject1);
      ((adt.a)localObject7).e = ((String)localObject2);
      ((adt.a)localObject7).f = ((String)localObject3);
      ((adt.a)localObject7).g = ((String)localObject5);
      ((adt.a)localObject7).h = new aeg((String)localObject6);
      paramArrayOfByte = new adt((adt.a)localObject7);
      localObject1 = this.g;
      localObject1.getClass();
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("101", paramArrayOfByte.b);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramArrayOfByte.c);
      ((HashMap)localObject2).put("102", ((StringBuilder)localObject3).toString());
      if (!TextUtils.isEmpty(paramArrayOfByte.e)) {
        ((HashMap)localObject2).put("104", paramArrayOfByte.e);
      }
      if (!TextUtils.isEmpty(paramArrayOfByte.f)) {
        ((HashMap)localObject2).put("105", paramArrayOfByte.f);
      }
      if (!TextUtils.isEmpty(paramArrayOfByte.g)) {
        ((HashMap)localObject2).put("106", paramArrayOfByte.g);
      }
      if (!TextUtils.isEmpty(paramArrayOfByte.h)) {
        ((HashMap)localObject2).put("110", paramArrayOfByte.h);
      }
      localObject3 = paramArrayOfByte.i;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((aeg)localObject3).a))) {
        ((HashMap)localObject2).put("111", ((aeg)localObject3).a);
      }
      ((aef)localObject1).a(paramContext, (Map)localObject2, true);
      localObject1 = this.g;
      l1 = ((Integer)localObject4).intValue();
      localObject1.getClass();
      ((aef)localObject1).a(paramContext, "107", String.valueOf(l1), true);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(System.currentTimeMillis() / 1000L);
      ((aef)localObject1).a(paramContext, "108", ((StringBuilder)localObject2).toString(), true);
      return paramArrayOfByte;
    }
    finally
    {
      label662:
      break label662;
    }
    return adt.a(-10007);
  }
  
  private void a()
  {
    a(3, 0L);
  }
  
  private void a(int paramInt, long paramLong)
  {
    synchronized (this.j)
    {
      if (((Boolean)this.j.get()).booleanValue()) {
        return;
      }
      this.j.set(Boolean.TRUE);
      Message localMessage = Message.obtain(this.e, 2, Integer.valueOf(paramInt));
      this.e.sendMessageDelayed(localMessage, paramLong);
      return;
    }
  }
  
  /* Error */
  public static void a(aec paramaec)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: pop
    //   5: ldc 111
    //   7: monitorenter
    //   8: getstatic 114	com/tencent/token/agn:a	Landroid/content/Context;
    //   11: astore 8
    //   13: ldc 111
    //   15: monitorexit
    //   16: aload 8
    //   18: aload_0
    //   19: getfield 109	com/tencent/token/aec:g	Lcom/tencent/token/aef;
    //   22: invokestatic 295	com/tencent/token/aev:a	(Landroid/content/Context;Lcom/tencent/token/aef;)V
    //   25: aload_0
    //   26: getfield 74	com/tencent/token/aec:d	Lcom/tencent/token/agr;
    //   29: getfield 298	com/tencent/token/agr:t	J
    //   32: invokestatic 304	java/lang/Thread:sleep	(J)V
    //   35: iconst_1
    //   36: istore_2
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_1
    //   41: invokespecial 306	com/tencent/token/aec:a	(Landroid/content/Context;Z)J
    //   44: pop2
    //   45: getstatic 311	com/tencent/token/ael:a	Lcom/tencent/token/ael;
    //   48: bipush 39
    //   50: invokevirtual 314	com/tencent/token/ael:a	(I)Z
    //   53: ifeq +322 -> 375
    //   56: new 225	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   63: astore 9
    //   65: new 186	java/lang/String
    //   68: dup
    //   69: ldc_w 316
    //   72: invokestatic 321	com/tencent/token/adg:b	(Ljava/lang/String;)[B
    //   75: invokespecial 324	java/lang/String:<init>	([B)V
    //   78: ldc_w 326
    //   81: invokevirtual 330	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   84: astore 10
    //   86: new 332	java/util/HashSet
    //   89: dup
    //   90: invokespecial 333	java/util/HashSet:<init>	()V
    //   93: astore 11
    //   95: aload 10
    //   97: arraylength
    //   98: istore_3
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: iload_3
    //   103: if_icmpge +203 -> 306
    //   106: aload 10
    //   108: iload_1
    //   109: aaload
    //   110: ldc_w 335
    //   113: invokevirtual 330	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: arraylength
    //   121: iconst_2
    //   122: if_icmplt +177 -> 299
    //   125: aload 6
    //   127: aload 6
    //   129: arraylength
    //   130: iconst_1
    //   131: isub
    //   132: aaload
    //   133: invokevirtual 338	java/lang/String:trim	()Ljava/lang/String;
    //   136: astore 12
    //   138: aconst_null
    //   139: astore 6
    //   141: new 340	java/io/File
    //   144: dup
    //   145: aload 12
    //   147: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore 7
    //   152: aload 7
    //   154: invokevirtual 344	java/io/File:exists	()Z
    //   157: ifeq +142 -> 299
    //   160: aload 7
    //   162: invokevirtual 347	java/io/File:getName	()Ljava/lang/String;
    //   165: astore 7
    //   167: aload 7
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +126 -> 299
    //   176: aload 6
    //   178: ldc_w 349
    //   181: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   184: ifeq +115 -> 299
    //   187: aload 6
    //   189: ldc_w 354
    //   192: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   195: ifeq +104 -> 299
    //   198: aload 6
    //   200: ldc_w 360
    //   203: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   206: ifne +93 -> 299
    //   209: ldc_w 362
    //   212: aload 12
    //   214: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   217: ifne +82 -> 299
    //   220: aload 11
    //   222: aload 12
    //   224: invokevirtual 369	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   227: ifne +72 -> 299
    //   230: aload 11
    //   232: aload 12
    //   234: invokevirtual 372	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: aload 8
    //   240: aload 12
    //   242: invokestatic 373	com/tencent/token/agn:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   245: astore 6
    //   247: aload 6
    //   249: ifnull +50 -> 299
    //   252: aload 6
    //   254: ldc_w 375
    //   257: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   260: ifne +39 -> 299
    //   263: aload 6
    //   265: ldc_w 377
    //   268: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   271: ifne +28 -> 299
    //   274: aload 9
    //   276: invokevirtual 380	java/lang/StringBuilder:length	()I
    //   279: ifle +12 -> 291
    //   282: aload 9
    //   284: ldc_w 382
    //   287: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 9
    //   293: aload 6
    //   295: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: iload_1
    //   300: iconst_1
    //   301: iadd
    //   302: istore_1
    //   303: goto -202 -> 101
    //   306: aload 9
    //   308: ldc_w 387
    //   311: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: invokestatic 393	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   318: invokevirtual 107	java/lang/Object:getClass	()Ljava/lang/Class;
    //   321: invokevirtual 396	java/lang/Class:getName	()Ljava/lang/String;
    //   324: astore 6
    //   326: ldc_w 398
    //   329: aload 6
    //   331: invokestatic 366	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   334: ifne +11 -> 345
    //   337: aload 9
    //   339: aload 6
    //   341: invokevirtual 385	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 9
    //   347: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: ldc_w 400
    //   353: ldc 188
    //   355: invokevirtual 404	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   358: astore 6
    //   360: aload_0
    //   361: getfield 109	com/tencent/token/aec:g	Lcom/tencent/token/aef;
    //   364: aload 8
    //   366: ldc_w 406
    //   369: aload 6
    //   371: iconst_1
    //   372: invokevirtual 263	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    //   375: aload_0
    //   376: getfield 74	com/tencent/token/aec:d	Lcom/tencent/token/agr;
    //   379: getfield 409	com/tencent/token/agr:q	Z
    //   382: ifeq +218 -> 600
    //   385: aload_0
    //   386: getfield 109	com/tencent/token/aec:g	Lcom/tencent/token/aef;
    //   389: astore 6
    //   391: getstatic 413	com/tencent/token/afn:b	I
    //   394: istore_1
    //   395: getstatic 311	com/tencent/token/ael:a	Lcom/tencent/token/ael;
    //   398: bipush 45
    //   400: invokevirtual 314	com/tencent/token/ael:a	(I)Z
    //   403: ifeq +197 -> 600
    //   406: aload 6
    //   408: invokevirtual 107	java/lang/Object:getClass	()Ljava/lang/Class;
    //   411: pop
    //   412: aload 8
    //   414: ldc_w 415
    //   417: invokestatic 121	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   420: invokestatic 127	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   423: invokevirtual 130	java/lang/Long:longValue	()J
    //   426: lstore 4
    //   428: goto +6 -> 434
    //   431: lconst_0
    //   432: lstore 4
    //   434: lload 4
    //   436: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   439: lsub
    //   440: invokestatic 140	java/lang/Math:abs	(J)J
    //   443: getstatic 417	com/tencent/token/afn:a	J
    //   446: lcmp
    //   447: iflt +8 -> 455
    //   450: iconst_1
    //   451: istore_1
    //   452: goto +5 -> 457
    //   455: iconst_0
    //   456: istore_1
    //   457: iload_1
    //   458: ifeq +142 -> 600
    //   461: iload_2
    //   462: istore_1
    //   463: aload 8
    //   465: ldc_w 419
    //   468: invokestatic 121	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   471: invokestatic 93	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifne +48 -> 522
    //   477: lload 4
    //   479: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   482: lsub
    //   483: invokestatic 140	java/lang/Math:abs	(J)J
    //   486: lstore 4
    //   488: getstatic 424	com/tencent/token/aek:b	Lcom/tencent/token/aek;
    //   491: invokevirtual 107	java/lang/Object:getClass	()Ljava/lang/Class;
    //   494: pop
    //   495: lload 4
    //   497: aload 8
    //   499: ldc_w 426
    //   502: getstatic 427	com/tencent/token/aek:a	J
    //   505: ldc2_w 428
    //   508: invokestatic 432	com/tencent/token/aek:a	(Landroid/content/Context;Ljava/lang/String;JJ)J
    //   511: lcmp
    //   512: iflt +8 -> 520
    //   515: iload_2
    //   516: istore_1
    //   517: goto +5 -> 522
    //   520: iconst_0
    //   521: istore_1
    //   522: iload_1
    //   523: ifeq +69 -> 592
    //   526: aload 8
    //   528: invokestatic 437	com/tencent/token/afp:a	(Landroid/content/Context;)Lcom/tencent/token/afl;
    //   531: astore 7
    //   533: aload 7
    //   535: astore 6
    //   537: aload 7
    //   539: getfield 441	com/tencent/token/afl:a	I
    //   542: ifeq +8 -> 550
    //   545: invokestatic 444	com/tencent/token/afp:a	()Lcom/tencent/token/afl;
    //   548: astore 6
    //   550: aload 6
    //   552: getfield 441	com/tencent/token/afl:a	I
    //   555: ifne +37 -> 592
    //   558: aload 6
    //   560: getfield 445	com/tencent/token/afl:d	Ljava/lang/String;
    //   563: astore 6
    //   565: new 216	java/util/HashMap
    //   568: dup
    //   569: invokespecial 217	java/util/HashMap:<init>	()V
    //   572: astore 7
    //   574: aload 7
    //   576: ldc_w 419
    //   579: aload 6
    //   581: invokevirtual 223	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   584: pop
    //   585: aload 8
    //   587: aload 7
    //   589: invokestatic 448	com/tencent/token/aef:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   592: aload 8
    //   594: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   597: invokestatic 451	com/tencent/token/aef:c	(Landroid/content/Context;J)V
    //   600: aload_0
    //   601: getfield 74	com/tencent/token/aec:d	Lcom/tencent/token/agr;
    //   604: astore 6
    //   606: aload 6
    //   608: getfield 454	com/tencent/token/agr:n	Z
    //   611: ifeq +15 -> 626
    //   614: aload_0
    //   615: aload 6
    //   617: getfield 456	com/tencent/token/agr:c	Landroid/content/Context;
    //   620: iconst_0
    //   621: iconst_0
    //   622: invokevirtual 459	com/tencent/token/aec:a	(Landroid/content/Context;ZI)Lcom/tencent/token/adt;
    //   625: pop
    //   626: return
    //   627: astore_0
    //   628: ldc 111
    //   630: monitorexit
    //   631: aload_0
    //   632: athrow
    //   633: astore 6
    //   635: goto -600 -> 35
    //   638: astore 6
    //   640: goto -334 -> 306
    //   643: astore 7
    //   645: goto -474 -> 171
    //   648: astore 6
    //   650: goto -219 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	paramaec	aec
    //   100	423	1	k	int
    //   36	480	2	m	int
    //   98	6	3	n	int
    //   426	70	4	l	long
    //   116	500	6	localObject1	Object
    //   633	1	6	localInterruptedException	InterruptedException
    //   638	1	6	localObject2	Object
    //   648	1	6	localObject3	Object
    //   150	438	7	localObject4	Object
    //   643	1	7	localObject5	Object
    //   11	582	8	localContext	Context
    //   63	283	9	localStringBuilder	StringBuilder
    //   84	23	10	arrayOfString	String[]
    //   93	138	11	localHashSet	java.util.HashSet
    //   136	105	12	str	String
    // Exception table:
    //   from	to	target	type
    //   8	13	627	finally
    //   25	35	633	java/lang/InterruptedException
    //   65	99	638	finally
    //   106	138	638	finally
    //   176	247	638	finally
    //   252	291	638	finally
    //   291	299	638	finally
    //   141	167	643	finally
    //   412	428	648	finally
  }
  
  private adt b(Context paramContext, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final adt a(Context paramContext, boolean paramBoolean, int paramInt)
  {
    adt localadt = a(paramContext);
    if (this.d == null) {
      return adt.a(-10002);
    }
    int k = a(localadt);
    if (k == 1) {
      return localadt;
    }
    if (k == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a(3, 0L);
        return adt.a(-10008);
      }
      synchronized (this.h)
      {
        ??? = a(paramContext);
        if ((??? != localadt) && (a((adt)???) == 1)) {
          paramContext = (Context)???;
        }
        synchronized (this.j)
        {
          if (!((Boolean)this.j.get()).booleanValue())
          {
            this.j.set(Boolean.TRUE);
            this.e.post(new ady(this, paramContext, paramInt));
          }
          try
          {
            localAtomicReference = this.j;
            if (!paramBoolean) {
              break label269;
            }
            l = this.d.r;
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
          if (paramContext != localadt) {
            break label222;
          }
          paramContext = adt.a(-10004);
          label222:
          if (paramContext.d == 0) {
            a(4, 3000L);
          }
          return paramContext;
        }
      }
    }
    else
    {
      if (k == 3) {
        a();
      }
      return localadt;
    }
  }
  
  public final adt a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final aee a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    acy localacy = acy.a();
    long l = this.d.r;
    try
    {
      paramArrayOfByte = localacy.a(paramInt2, paramInt3, paramInt1, null, null, paramArrayOfByte, l);
      paramInt1 = paramArrayOfByte.a;
      if (paramInt1 != 0) {
        paramArrayOfByte = new aee(paramInt1 - 40000, aee.a);
      } else {
        paramArrayOfByte = new aee(0, paramArrayOfByte.b);
      }
      if (paramArrayOfByte.b != 0) {}
      return paramArrayOfByte;
    }
    finally {}
  }
  
  /* Error */
  public final void a(adt paramadt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/tencent/token/aec:i	Ljava/util/concurrent/atomic/AtomicReference;
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
    //   19: getfield 84	com/tencent/token/adt:d	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 63	com/tencent/token/aec:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 163	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
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
    //   0	47	0	this	aec
    //   0	47	1	paramadt	adt
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
    extends Handler
  {
    public Context a;
    
    public a(Looper paramLooper, Context paramContext)
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
          ??? = aec.this.a(this.a, true, false, i);
          aec.this.a(???, false);
          synchronized (aec.this.j)
          {
            aec.this.j.set(Boolean.FALSE);
            aec.this.j.notifyAll();
            return;
          }
        }
      }
      else {
        aec.this.a(this.a, true, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aec
 * JD-Core Version:    0.7.0.1
 */