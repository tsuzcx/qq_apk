package com.tencent.beacon.upload;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.c.a.b;
import com.tencent.beacon.c.a.c;
import com.tencent.beacon.e.d;
import java.util.ArrayList;
import java.util.List;

public final class h
  implements g
{
  private static h a = null;
  private SparseArray<f> b = new SparseArray(5);
  private List<UploadHandleListener> c = new ArrayList(5);
  private e d;
  private Context e = null;
  private boolean f = true;
  private int g = 0;
  private boolean h = true;
  
  private h(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {
      localContext = paramContext.getApplicationContext();
    }
    if (localContext != null) {}
    for (this.e = localContext;; this.e = paramContext)
    {
      this.f = paramBoolean;
      this.d = e.a(this.e);
      return;
    }
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = com.tencent.beacon.a.g.b(2, paramArrayOfByte);
        paramArrayOfByte = new d();
        paramArrayOfByte.a((byte[])localObject);
        localObject = new c();
        com.tencent.beacon.d.a.b(" covert to ResponsePackage ", new Object[0]);
        paramArrayOfByte = (c)paramArrayOfByte.b("detail", localObject);
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static h a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext, true);
        com.tencent.beacon.d.a.h(" create uphandler up:true", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static h a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new h(paramContext, paramBoolean);
        com.tencent.beacon.d.a.h(" create uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.b() != paramBoolean)
      {
        a.b(paramBoolean);
        com.tencent.beacon.d.a.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = d();
    if (arrayOfUploadHandleListener != null)
    {
      int j = arrayOfUploadHandleListener.length;
      int i = 0;
      while (i < j)
      {
        arrayOfUploadHandleListener[i].onUploadEnd(paramInt1, paramInt2, paramLong1, paramLong2, paramBoolean, paramString);
        i += 1;
      }
    }
  }
  
  private boolean a(SparseArray<f> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramSparseArray == null) || (paramArrayOfByte == null)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      paramSparseArray = (f)paramSparseArray.get(paramInt);
      if (paramSparseArray == null)
      {
        com.tencent.beacon.d.a.c(" no handler key:%d", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      break;
    case 103: 
      try
      {
        com.tencent.beacon.d.a.a(" process CMD_RESPONSE_GEN_QIMEI", new Object[0]);
        paramSparseArray = new com.tencent.beacon.e.a(paramArrayOfByte);
        paramArrayOfByte = new com.tencent.beacon.c.c.a();
        paramArrayOfByte.a(paramSparseArray);
        if (paramArrayOfByte.a != null)
        {
          com.tencent.beacon.b.a.a(this.e).a(paramArrayOfByte.a);
          com.tencent.beacon.a.a.a(this.e, "QIMEI_DENGTA", paramArrayOfByte.a);
        }
        com.tencent.beacon.d.a.h(" Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s ", new Object[] { paramArrayOfByte.a, paramArrayOfByte.b, paramArrayOfByte.d, paramArrayOfByte.e, paramArrayOfByte.c });
      }
      catch (Throwable paramSparseArray)
      {
        for (;;)
        {
          paramSparseArray.printStackTrace();
        }
      }
      return true;
    }
    try
    {
      com.tencent.beacon.d.a.b(" key:%d  handler: %s", new Object[] { Integer.valueOf(paramInt), paramSparseArray.getClass().toString() });
      paramSparseArray.a(paramInt, paramArrayOfByte, true);
      return true;
    }
    catch (Throwable paramSparseArray)
    {
      paramSparseArray.printStackTrace();
      com.tencent.beacon.d.a.d(" handle error key:%d", new Object[] { Integer.valueOf(paramInt) });
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.f = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static byte[] b(a parama)
  {
    if (parama != null) {
      try
      {
        Object localObject = parama.a();
        if (localObject != null)
        {
          com.tencent.beacon.d.a.b(" RequestPackage info appkey:%s sdkid:%s appVersion:%s cmd: %d", new Object[] { ((b)localObject).b, ((b)localObject).d, ((b)localObject).c, Integer.valueOf(((b)localObject).f) });
          d locald = new d();
          locald.a(1);
          locald.b("test");
          locald.a("test");
          locald.a("detail", localObject);
          localObject = com.tencent.beacon.a.g.a(2, locald.a());
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        parama.b();
      }
    }
    return null;
  }
  
  /* Error */
  private UploadHandleListener[] d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   13: invokeinterface 247 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 44	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 127	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 251 2 0
    //   34: checkcast 253	[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	h
    //   37	7	1	arrayOfUploadHandleListener	UploadHandleListener[]
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  private e e()
  {
    try
    {
      e locale = this.d;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private SparseArray<f> f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   13: invokevirtual 256	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 258	com/tencent/beacon/d/c
    //   22: dup
    //   23: invokespecial 259	com/tencent/beacon/d/c:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 39	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   31: invokestatic 262	com/tencent/beacon/d/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aconst_null
    //   40: astore_1
    //   41: goto -6 -> 35
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	h
    //   34	7	1	localSparseArray	SparseArray
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	44	finally
  }
  
  public final int a()
  {
    try
    {
      int i = this.g;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      this.g = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 116	com/tencent/beacon/upload/h:b	()Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 268	com/tencent/beacon/upload/h:c	()Z
    //   11: ifne +69 -> 80
    //   14: aload_1
    //   15: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   18: iconst_2
    //   19: if_icmpne +23 -> 42
    //   22: ldc_w 272
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload_1
    //   33: invokevirtual 215	com/tencent/beacon/upload/a:a	()Lcom/tencent/beacon/c/a/b;
    //   36: pop
    //   37: aload_1
    //   38: iconst_0
    //   39: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   42: aload_1
    //   43: getfield 276	com/tencent/beacon/upload/a:b	I
    //   46: ifeq +24 -> 70
    //   49: ldc_w 278
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_1
    //   59: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   62: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: return
    //   70: ldc_w 280
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_0
    //   81: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   84: invokestatic 285	com/tencent/beacon/d/b:b	(Landroid/content/Context;)Z
    //   87: ifne +27 -> 114
    //   90: ldc_w 287
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload_1
    //   101: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   104: iconst_2
    //   105: if_icmpne -36 -> 69
    //   108: aload_1
    //   109: iconst_0
    //   110: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   113: return
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   119: invokestatic 292	com/tencent/beacon/a/h:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/h;
    //   122: invokevirtual 295	com/tencent/beacon/upload/h:a	(Lcom/tencent/beacon/upload/UploadHandleListener;)Z
    //   125: pop
    //   126: aload_1
    //   127: ifnonnull +14 -> 141
    //   130: ldc_w 297
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: return
    //   141: aload_1
    //   142: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   145: istore 5
    //   147: lconst_0
    //   148: lstore 14
    //   150: lconst_0
    //   151: lstore 12
    //   153: iconst_0
    //   154: istore 20
    //   156: iconst_0
    //   157: istore 16
    //   159: iconst_0
    //   160: istore 19
    //   162: iconst_m1
    //   163: istore 4
    //   165: aload_1
    //   166: invokevirtual 299	com/tencent/beacon/upload/a:d	()Ljava/lang/String;
    //   169: astore 24
    //   171: aload 24
    //   173: ifnull +17 -> 190
    //   176: ldc_w 301
    //   179: aload 24
    //   181: invokevirtual 306	java/lang/String:trim	()Ljava/lang/String;
    //   184: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +40 -> 227
    //   190: ldc_w 312
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_1
    //   201: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   204: iconst_2
    //   205: if_icmpne +8 -> 213
    //   208: aload_1
    //   209: iconst_0
    //   210: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   213: aload_0
    //   214: iload 5
    //   216: iconst_m1
    //   217: lconst_0
    //   218: lconst_0
    //   219: iconst_0
    //   220: ldc_w 314
    //   223: invokespecial 316	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   226: return
    //   227: ldc_w 318
    //   230: iconst_3
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: iload 5
    //   238: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload 24
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aload_1
    //   250: invokevirtual 194	java/lang/Object:getClass	()Ljava/lang/Class;
    //   253: invokevirtual 200	java/lang/Class:toString	()Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_1
    //   261: invokestatic 320	com/tencent/beacon/upload/h:b	(Lcom/tencent/beacon/upload/a;)[B
    //   264: astore 25
    //   266: aload 25
    //   268: ifnonnull +27 -> 295
    //   271: ldc_w 322
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: aload_0
    //   282: iload 5
    //   284: iconst_m1
    //   285: lconst_0
    //   286: lconst_0
    //   287: iconst_0
    //   288: ldc_w 324
    //   291: invokespecial 316	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   294: return
    //   295: aload_0
    //   296: invokespecial 326	com/tencent/beacon/upload/h:e	()Lcom/tencent/beacon/upload/e;
    //   299: astore 26
    //   301: aload 26
    //   303: ifnonnull +27 -> 330
    //   306: ldc_w 328
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload_0
    //   317: iload 5
    //   319: iconst_m1
    //   320: lconst_0
    //   321: lconst_0
    //   322: iconst_0
    //   323: ldc_w 330
    //   326: invokespecial 316	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   329: return
    //   330: iload 4
    //   332: istore_2
    //   333: lload 14
    //   335: lstore 8
    //   337: lload 12
    //   339: lstore 10
    //   341: iload 19
    //   343: istore 17
    //   345: iload 20
    //   347: istore 18
    //   349: new 332	com/tencent/beacon/upload/d
    //   352: dup
    //   353: invokespecial 333	com/tencent/beacon/upload/d:<init>	()V
    //   356: astore 23
    //   358: iload 4
    //   360: istore_2
    //   361: lload 14
    //   363: lstore 8
    //   365: lload 12
    //   367: lstore 10
    //   369: iload 19
    //   371: istore 17
    //   373: iload 20
    //   375: istore 18
    //   377: aload 26
    //   379: aload 24
    //   381: aload 25
    //   383: aload 23
    //   385: aload_1
    //   386: invokevirtual 336	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;Lcom/tencent/beacon/upload/a;)[B
    //   389: astore 22
    //   391: aload 22
    //   393: ifnonnull +343 -> 736
    //   396: aload 22
    //   398: astore 21
    //   400: iload 5
    //   402: bipush 100
    //   404: if_icmpne +71 -> 475
    //   407: aload 22
    //   409: astore 21
    //   411: iload 4
    //   413: istore_2
    //   414: lload 14
    //   416: lstore 8
    //   418: lload 12
    //   420: lstore 10
    //   422: iload 19
    //   424: istore 17
    //   426: iload 20
    //   428: istore 18
    //   430: ldc_w 338
    //   433: aload 24
    //   435: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifne +37 -> 475
    //   441: iload 4
    //   443: istore_2
    //   444: lload 14
    //   446: lstore 8
    //   448: lload 12
    //   450: lstore 10
    //   452: iload 19
    //   454: istore 17
    //   456: iload 20
    //   458: istore 18
    //   460: aload 26
    //   462: ldc_w 338
    //   465: aload 25
    //   467: aload 23
    //   469: aload_1
    //   470: invokevirtual 336	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;Lcom/tencent/beacon/upload/a;)[B
    //   473: astore 21
    //   475: iload 4
    //   477: istore_2
    //   478: lload 14
    //   480: lstore 8
    //   482: lload 12
    //   484: lstore 10
    //   486: iload 19
    //   488: istore 17
    //   490: iload 20
    //   492: istore 18
    //   494: aload_0
    //   495: aload_0
    //   496: invokevirtual 340	com/tencent/beacon/upload/h:a	()I
    //   499: iconst_1
    //   500: iadd
    //   501: invokevirtual 341	com/tencent/beacon/upload/h:a	(I)V
    //   504: iload 4
    //   506: istore_2
    //   507: lload 14
    //   509: lstore 8
    //   511: lload 12
    //   513: lstore 10
    //   515: iload 19
    //   517: istore 17
    //   519: iload 20
    //   521: istore 18
    //   523: aload 23
    //   525: invokevirtual 344	com/tencent/beacon/upload/d:a	()J
    //   528: lstore 14
    //   530: iload 4
    //   532: istore_2
    //   533: lload 14
    //   535: lstore 8
    //   537: lload 12
    //   539: lstore 10
    //   541: iload 19
    //   543: istore 17
    //   545: iload 20
    //   547: istore 18
    //   549: aload 23
    //   551: invokevirtual 346	com/tencent/beacon/upload/d:b	()J
    //   554: lstore 12
    //   556: iload 4
    //   558: istore_2
    //   559: lload 14
    //   561: lstore 8
    //   563: lload 12
    //   565: lstore 10
    //   567: iload 19
    //   569: istore 17
    //   571: iload 20
    //   573: istore 18
    //   575: aload 21
    //   577: invokestatic 348	com/tencent/beacon/upload/h:a	([B)Lcom/tencent/beacon/c/a/c;
    //   580: astore 21
    //   582: iload 4
    //   584: istore_3
    //   585: aload 21
    //   587: ifnull +1507 -> 2094
    //   590: iload 4
    //   592: istore_2
    //   593: lload 14
    //   595: lstore 8
    //   597: lload 12
    //   599: lstore 10
    //   601: iload 19
    //   603: istore 17
    //   605: iload 20
    //   607: istore 18
    //   609: aload 21
    //   611: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   614: istore_3
    //   615: iload_3
    //   616: istore_2
    //   617: lload 14
    //   619: lstore 8
    //   621: lload 12
    //   623: lstore 10
    //   625: iload 19
    //   627: istore 17
    //   629: iload 20
    //   631: istore 18
    //   633: aload 21
    //   635: getfield 352	com/tencent/beacon/c/a/c:a	B
    //   638: ifne +178 -> 816
    //   641: iconst_1
    //   642: istore 16
    //   644: iload_3
    //   645: istore_2
    //   646: lload 14
    //   648: lstore 8
    //   650: lload 12
    //   652: lstore 10
    //   654: iload 16
    //   656: istore 17
    //   658: iload 16
    //   660: istore 18
    //   662: ldc_w 354
    //   665: iconst_2
    //   666: anewarray 4	java/lang/Object
    //   669: dup
    //   670: iconst_0
    //   671: aload 21
    //   673: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   676: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: aastore
    //   680: dup
    //   681: iconst_1
    //   682: aload 21
    //   684: getfield 352	com/tencent/beacon/c/a/c:a	B
    //   687: invokestatic 359	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   690: aastore
    //   691: invokestatic 89	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   694: goto +1400 -> 2094
    //   697: iload_3
    //   698: istore_2
    //   699: lload 14
    //   701: lstore 8
    //   703: lload 12
    //   705: lstore 10
    //   707: iload 16
    //   709: istore 17
    //   711: iload 16
    //   713: istore 18
    //   715: aload_0
    //   716: iload 5
    //   718: iload_3
    //   719: lload 14
    //   721: lload 12
    //   723: iload 16
    //   725: aconst_null
    //   726: invokespecial 316	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   729: aload_1
    //   730: iload 16
    //   732: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   735: return
    //   736: iload 4
    //   738: istore_2
    //   739: lload 14
    //   741: lstore 8
    //   743: lload 12
    //   745: lstore 10
    //   747: iload 19
    //   749: istore 17
    //   751: iload 20
    //   753: istore 18
    //   755: aload_0
    //   756: iconst_0
    //   757: invokevirtual 341	com/tencent/beacon/upload/h:a	(I)V
    //   760: aload 22
    //   762: astore 21
    //   764: goto -260 -> 504
    //   767: astore 21
    //   769: aload 21
    //   771: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   774: aload_0
    //   775: iload 5
    //   777: iload_2
    //   778: lload 8
    //   780: lload 10
    //   782: iconst_0
    //   783: aload 21
    //   785: invokevirtual 360	java/lang/Throwable:toString	()Ljava/lang/String;
    //   788: invokespecial 316	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   791: ldc_w 362
    //   794: iconst_1
    //   795: anewarray 4	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 21
    //   802: invokevirtual 360	java/lang/Throwable:toString	()Ljava/lang/String;
    //   805: aastore
    //   806: invokestatic 207	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   809: aload_1
    //   810: iload 17
    //   812: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   815: return
    //   816: iconst_0
    //   817: istore 16
    //   819: goto -175 -> 644
    //   822: iload_3
    //   823: istore_2
    //   824: lload 14
    //   826: lstore 8
    //   828: lload 12
    //   830: lstore 10
    //   832: iload 16
    //   834: istore 17
    //   836: iload 16
    //   838: istore 18
    //   840: invokestatic 368	com/tencent/beacon/a/e:m	()Lcom/tencent/beacon/a/e;
    //   843: astore 22
    //   845: aload 22
    //   847: ifnull +168 -> 1015
    //   850: iload_3
    //   851: istore_2
    //   852: lload 14
    //   854: lstore 8
    //   856: lload 12
    //   858: lstore 10
    //   860: iload 16
    //   862: istore 17
    //   864: iload 16
    //   866: istore 18
    //   868: aload 21
    //   870: getfield 369	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   873: ifnull +34 -> 907
    //   876: iload_3
    //   877: istore_2
    //   878: lload 14
    //   880: lstore 8
    //   882: lload 12
    //   884: lstore 10
    //   886: iload 16
    //   888: istore 17
    //   890: iload 16
    //   892: istore 18
    //   894: aload 22
    //   896: aload 21
    //   898: getfield 369	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   901: invokevirtual 306	java/lang/String:trim	()Ljava/lang/String;
    //   904: invokevirtual 370	com/tencent/beacon/a/e:a	(Ljava/lang/String;)V
    //   907: iload_3
    //   908: istore_2
    //   909: lload 14
    //   911: lstore 8
    //   913: lload 12
    //   915: lstore 10
    //   917: iload 16
    //   919: istore 17
    //   921: iload 16
    //   923: istore 18
    //   925: new 372	java/util/Date
    //   928: dup
    //   929: invokespecial 373	java/util/Date:<init>	()V
    //   932: astore 23
    //   934: iload_3
    //   935: istore_2
    //   936: lload 14
    //   938: lstore 8
    //   940: lload 12
    //   942: lstore 10
    //   944: iload 16
    //   946: istore 17
    //   948: iload 16
    //   950: istore 18
    //   952: aload 22
    //   954: aload 21
    //   956: getfield 376	com/tencent/beacon/c/a/c:g	J
    //   959: aload 23
    //   961: invokevirtual 379	java/util/Date:getTime	()J
    //   964: lsub
    //   965: invokevirtual 382	com/tencent/beacon/a/e:a	(J)V
    //   968: iload_3
    //   969: istore_2
    //   970: lload 14
    //   972: lstore 8
    //   974: lload 12
    //   976: lstore 10
    //   978: iload 16
    //   980: istore 17
    //   982: iload 16
    //   984: istore 18
    //   986: ldc_w 384
    //   989: iconst_2
    //   990: anewarray 4	java/lang/Object
    //   993: dup
    //   994: iconst_0
    //   995: aload 22
    //   997: invokevirtual 386	com/tencent/beacon/a/e:g	()Ljava/lang/String;
    //   1000: aastore
    //   1001: dup
    //   1002: iconst_1
    //   1003: aload 22
    //   1005: invokevirtual 388	com/tencent/beacon/a/e:h	()J
    //   1008: invokestatic 393	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1011: aastore
    //   1012: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1015: iload_3
    //   1016: istore_2
    //   1017: lload 14
    //   1019: lstore 8
    //   1021: lload 12
    //   1023: lstore 10
    //   1025: iload 16
    //   1027: istore 17
    //   1029: iload 16
    //   1031: istore 18
    //   1033: aload 21
    //   1035: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   1038: bipush 101
    //   1040: if_icmpeq +59 -> 1099
    //   1043: iload_3
    //   1044: istore_2
    //   1045: lload 14
    //   1047: lstore 8
    //   1049: lload 12
    //   1051: lstore 10
    //   1053: iload 16
    //   1055: istore 17
    //   1057: iload 16
    //   1059: istore 18
    //   1061: aload 21
    //   1063: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   1066: bipush 103
    //   1068: if_icmpeq +31 -> 1099
    //   1071: iload_3
    //   1072: istore_2
    //   1073: lload 14
    //   1075: lstore 8
    //   1077: lload 12
    //   1079: lstore 10
    //   1081: iload 16
    //   1083: istore 17
    //   1085: iload 16
    //   1087: istore 18
    //   1089: aload 21
    //   1091: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   1094: bipush 105
    //   1096: if_icmpne +270 -> 1366
    //   1099: iload_3
    //   1100: istore_2
    //   1101: lload 14
    //   1103: lstore 8
    //   1105: lload 12
    //   1107: lstore 10
    //   1109: iload 16
    //   1111: istore 17
    //   1113: iload 16
    //   1115: istore 18
    //   1117: aload_0
    //   1118: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1121: invokestatic 398	com/tencent/beacon/a/b/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/c;
    //   1124: invokevirtual 401	com/tencent/beacon/a/b/c:b	()Lcom/tencent/beacon/a/b/e;
    //   1127: astore 22
    //   1129: aload 22
    //   1131: ifnull +235 -> 1366
    //   1134: iload_3
    //   1135: istore_2
    //   1136: lload 14
    //   1138: lstore 8
    //   1140: lload 12
    //   1142: lstore 10
    //   1144: iload 16
    //   1146: istore 17
    //   1148: iload 16
    //   1150: istore 18
    //   1152: aload 22
    //   1154: invokevirtual 407	com/tencent/beacon/a/b/e:j	()B
    //   1157: aload 21
    //   1159: getfield 409	com/tencent/beacon/c/a/c:f	B
    //   1162: if_icmpeq +31 -> 1193
    //   1165: iload_3
    //   1166: istore_2
    //   1167: lload 14
    //   1169: lstore 8
    //   1171: lload 12
    //   1173: lstore 10
    //   1175: iload 16
    //   1177: istore 17
    //   1179: iload 16
    //   1181: istore 18
    //   1183: aload 22
    //   1185: aload 21
    //   1187: getfield 409	com/tencent/beacon/c/a/c:f	B
    //   1190: invokevirtual 412	com/tencent/beacon/a/b/e:b	(B)V
    //   1193: iload_3
    //   1194: istore_2
    //   1195: lload 14
    //   1197: lstore 8
    //   1199: lload 12
    //   1201: lstore 10
    //   1203: iload 16
    //   1205: istore 17
    //   1207: iload 16
    //   1209: istore 18
    //   1211: aload 22
    //   1213: invokevirtual 415	com/tencent/beacon/a/b/e:i	()B
    //   1216: aload 21
    //   1218: getfield 417	com/tencent/beacon/c/a/c:e	B
    //   1221: if_icmpeq +31 -> 1252
    //   1224: iload_3
    //   1225: istore_2
    //   1226: lload 14
    //   1228: lstore 8
    //   1230: lload 12
    //   1232: lstore 10
    //   1234: iload 16
    //   1236: istore 17
    //   1238: iload 16
    //   1240: istore 18
    //   1242: aload 22
    //   1244: aload 21
    //   1246: getfield 417	com/tencent/beacon/c/a/c:e	B
    //   1249: invokevirtual 419	com/tencent/beacon/a/b/e:a	(B)V
    //   1252: iload_3
    //   1253: istore_2
    //   1254: lload 14
    //   1256: lstore 8
    //   1258: lload 12
    //   1260: lstore 10
    //   1262: iload 16
    //   1264: istore 17
    //   1266: iload 16
    //   1268: istore 18
    //   1270: aload 22
    //   1272: invokevirtual 422	com/tencent/beacon/a/b/e:k	()Ljava/lang/String;
    //   1275: ifnull +63 -> 1338
    //   1278: iload_3
    //   1279: istore_2
    //   1280: lload 14
    //   1282: lstore 8
    //   1284: lload 12
    //   1286: lstore 10
    //   1288: iload 16
    //   1290: istore 17
    //   1292: iload 16
    //   1294: istore 18
    //   1296: aload 21
    //   1298: getfield 424	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1301: ifnull +65 -> 1366
    //   1304: iload_3
    //   1305: istore_2
    //   1306: lload 14
    //   1308: lstore 8
    //   1310: lload 12
    //   1312: lstore 10
    //   1314: iload 16
    //   1316: istore 17
    //   1318: iload 16
    //   1320: istore 18
    //   1322: aload 22
    //   1324: invokevirtual 422	com/tencent/beacon/a/b/e:k	()Ljava/lang/String;
    //   1327: aload 21
    //   1329: getfield 424	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1332: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1335: ifne +31 -> 1366
    //   1338: iload_3
    //   1339: istore_2
    //   1340: lload 14
    //   1342: lstore 8
    //   1344: lload 12
    //   1346: lstore 10
    //   1348: iload 16
    //   1350: istore 17
    //   1352: iload 16
    //   1354: istore 18
    //   1356: aload 22
    //   1358: aload 21
    //   1360: getfield 424	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1363: invokevirtual 425	com/tencent/beacon/a/b/e:b	(Ljava/lang/String;)V
    //   1366: iload_3
    //   1367: istore_2
    //   1368: lload 14
    //   1370: lstore 8
    //   1372: lload 12
    //   1374: lstore 10
    //   1376: iload 16
    //   1378: istore 17
    //   1380: iload 16
    //   1382: istore 18
    //   1384: aload 21
    //   1386: getfield 428	com/tencent/beacon/c/a/c:c	[B
    //   1389: astore 22
    //   1391: aload 22
    //   1393: ifnonnull +45 -> 1438
    //   1396: iload_3
    //   1397: istore_2
    //   1398: lload 14
    //   1400: lstore 8
    //   1402: lload 12
    //   1404: lstore 10
    //   1406: iload 16
    //   1408: istore 17
    //   1410: iload 16
    //   1412: istore 18
    //   1414: ldc_w 430
    //   1417: iconst_0
    //   1418: anewarray 4	java/lang/Object
    //   1421: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1424: goto -727 -> 697
    //   1427: astore 21
    //   1429: aload_1
    //   1430: iload 18
    //   1432: invokevirtual 274	com/tencent/beacon/upload/a:a	(Z)V
    //   1435: aload 21
    //   1437: athrow
    //   1438: iload_3
    //   1439: istore_2
    //   1440: lload 14
    //   1442: lstore 8
    //   1444: lload 12
    //   1446: lstore 10
    //   1448: iload 16
    //   1450: istore 17
    //   1452: iload 16
    //   1454: istore 18
    //   1456: aload 22
    //   1458: aload 21
    //   1460: getfield 409	com/tencent/beacon/c/a/c:f	B
    //   1463: aload 21
    //   1465: getfield 417	com/tencent/beacon/c/a/c:e	B
    //   1468: aload 21
    //   1470: getfield 432	com/tencent/beacon/c/a/c:i	Ljava/lang/String;
    //   1473: invokestatic 435	com/tencent/beacon/b/a:b	([BIILjava/lang/String;)[B
    //   1476: astore 22
    //   1478: iload_3
    //   1479: istore_2
    //   1480: lload 14
    //   1482: lstore 8
    //   1484: lload 12
    //   1486: lstore 10
    //   1488: iload 16
    //   1490: istore 17
    //   1492: iload 16
    //   1494: istore 18
    //   1496: aload_0
    //   1497: invokespecial 437	com/tencent/beacon/upload/h:f	()Landroid/util/SparseArray;
    //   1500: astore 23
    //   1502: aload 23
    //   1504: ifnull +29 -> 1533
    //   1507: iload_3
    //   1508: istore_2
    //   1509: lload 14
    //   1511: lstore 8
    //   1513: lload 12
    //   1515: lstore 10
    //   1517: iload 16
    //   1519: istore 17
    //   1521: iload 16
    //   1523: istore 18
    //   1525: aload 23
    //   1527: invokevirtual 256	android/util/SparseArray:size	()I
    //   1530: ifgt +34 -> 1564
    //   1533: iload_3
    //   1534: istore_2
    //   1535: lload 14
    //   1537: lstore 8
    //   1539: lload 12
    //   1541: lstore 10
    //   1543: iload 16
    //   1545: istore 17
    //   1547: iload 16
    //   1549: istore 18
    //   1551: ldc_w 439
    //   1554: iconst_0
    //   1555: anewarray 4	java/lang/Object
    //   1558: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1561: goto -864 -> 697
    //   1564: iload_3
    //   1565: istore_2
    //   1566: lload 14
    //   1568: lstore 8
    //   1570: lload 12
    //   1572: lstore 10
    //   1574: iload 16
    //   1576: istore 17
    //   1578: iload 16
    //   1580: istore 18
    //   1582: aload_1
    //   1583: invokevirtual 270	com/tencent/beacon/upload/a:c	()I
    //   1586: istore 4
    //   1588: iload_3
    //   1589: istore_2
    //   1590: lload 14
    //   1592: lstore 8
    //   1594: lload 12
    //   1596: lstore 10
    //   1598: iload 16
    //   1600: istore 17
    //   1602: iload 16
    //   1604: istore 18
    //   1606: aload 21
    //   1608: getfield 349	com/tencent/beacon/c/a/c:b	I
    //   1611: istore 6
    //   1613: iload_3
    //   1614: istore_2
    //   1615: lload 14
    //   1617: lstore 8
    //   1619: lload 12
    //   1621: lstore 10
    //   1623: iload 16
    //   1625: istore 17
    //   1627: iload 16
    //   1629: istore 18
    //   1631: aload 21
    //   1633: getfield 352	com/tencent/beacon/c/a/c:a	B
    //   1636: istore 7
    //   1638: iload 7
    //   1640: ifne +171 -> 1811
    //   1643: iload 4
    //   1645: ifle +166 -> 1811
    //   1648: iload 4
    //   1650: iconst_5
    //   1651: if_icmpgt +160 -> 1811
    //   1654: iload_3
    //   1655: istore_2
    //   1656: lload 14
    //   1658: lstore 8
    //   1660: lload 12
    //   1662: lstore 10
    //   1664: iload 16
    //   1666: istore 17
    //   1668: iload 16
    //   1670: istore 18
    //   1672: ldc_w 301
    //   1675: aload_0
    //   1676: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1679: ldc 173
    //   1681: ldc_w 301
    //   1684: invokestatic 442	com/tencent/beacon/a/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1687: invokevirtual 310	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1690: ifeq +121 -> 1811
    //   1693: iload_3
    //   1694: istore_2
    //   1695: lload 14
    //   1697: lstore 8
    //   1699: lload 12
    //   1701: lstore 10
    //   1703: iload 16
    //   1705: istore 17
    //   1707: iload 16
    //   1709: istore 18
    //   1711: invokestatic 444	com/tencent/beacon/a/b/e:a	()Lcom/tencent/beacon/a/b/e;
    //   1714: invokevirtual 446	com/tencent/beacon/a/b/e:h	()Z
    //   1717: ifne +94 -> 1811
    //   1720: iload_3
    //   1721: istore_2
    //   1722: lload 14
    //   1724: lstore 8
    //   1726: lload 12
    //   1728: lstore 10
    //   1730: iload 16
    //   1732: istore 17
    //   1734: iload 16
    //   1736: istore 18
    //   1738: new 448	com/tencent/beacon/upload/c
    //   1741: dup
    //   1742: aload_0
    //   1743: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1746: invokespecial 451	com/tencent/beacon/upload/c:<init>	(Landroid/content/Context;)V
    //   1749: astore 21
    //   1751: iload_3
    //   1752: istore_2
    //   1753: lload 14
    //   1755: lstore 8
    //   1757: lload 12
    //   1759: lstore 10
    //   1761: iload 16
    //   1763: istore 17
    //   1765: iload 16
    //   1767: istore 18
    //   1769: invokestatic 454	com/tencent/beacon/a/b/c:a	()Lcom/tencent/beacon/upload/g;
    //   1772: aload 21
    //   1774: invokeinterface 456 2 0
    //   1779: iload_3
    //   1780: istore_2
    //   1781: lload 14
    //   1783: lstore 8
    //   1785: lload 12
    //   1787: lstore 10
    //   1789: iload 16
    //   1791: istore 17
    //   1793: iload 16
    //   1795: istore 18
    //   1797: aload_0
    //   1798: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1801: ldc_w 458
    //   1804: invokestatic 459	com/tencent/beacon/b/a:g	()Ljava/lang/String;
    //   1807: invokestatic 178	com/tencent/beacon/a/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   1810: pop
    //   1811: iload 6
    //   1813: ifne +293 -> 2106
    //   1816: iload_3
    //   1817: istore_2
    //   1818: lload 14
    //   1820: lstore 8
    //   1822: lload 12
    //   1824: lstore 10
    //   1826: iload 16
    //   1828: istore 17
    //   1830: iload 16
    //   1832: istore 18
    //   1834: ldc_w 461
    //   1837: iconst_0
    //   1838: anewarray 4	java/lang/Object
    //   1841: invokestatic 104	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1844: goto -1147 -> 697
    //   1847: iload_3
    //   1848: istore_2
    //   1849: lload 14
    //   1851: lstore 8
    //   1853: lload 12
    //   1855: lstore 10
    //   1857: iload 16
    //   1859: istore 17
    //   1861: iload 16
    //   1863: istore 18
    //   1865: ldc_w 463
    //   1868: iconst_1
    //   1869: anewarray 4	java/lang/Object
    //   1872: dup
    //   1873: iconst_0
    //   1874: iload 4
    //   1876: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1879: aastore
    //   1880: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1883: goto -1186 -> 697
    //   1886: iload 6
    //   1888: bipush 101
    //   1890: if_icmpeq +158 -> 2048
    //   1893: iload_3
    //   1894: istore_2
    //   1895: lload 14
    //   1897: lstore 8
    //   1899: lload 12
    //   1901: lstore 10
    //   1903: iload 16
    //   1905: istore 17
    //   1907: iload 16
    //   1909: istore 18
    //   1911: ldc_w 465
    //   1914: iconst_2
    //   1915: anewarray 4	java/lang/Object
    //   1918: dup
    //   1919: iconst_0
    //   1920: iload 4
    //   1922: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1925: aastore
    //   1926: dup
    //   1927: iconst_1
    //   1928: iload 6
    //   1930: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1933: aastore
    //   1934: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1937: goto -1240 -> 697
    //   1940: iload 6
    //   1942: bipush 105
    //   1944: if_icmpeq +104 -> 2048
    //   1947: iload_3
    //   1948: istore_2
    //   1949: lload 14
    //   1951: lstore 8
    //   1953: lload 12
    //   1955: lstore 10
    //   1957: iload 16
    //   1959: istore 17
    //   1961: iload 16
    //   1963: istore 18
    //   1965: ldc_w 465
    //   1968: iconst_2
    //   1969: anewarray 4	java/lang/Object
    //   1972: dup
    //   1973: iconst_0
    //   1974: iload 4
    //   1976: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1979: aastore
    //   1980: dup
    //   1981: iconst_1
    //   1982: iload 6
    //   1984: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1987: aastore
    //   1988: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1991: goto -1294 -> 697
    //   1994: iload 6
    //   1996: bipush 103
    //   1998: if_icmpeq +50 -> 2048
    //   2001: iload_3
    //   2002: istore_2
    //   2003: lload 14
    //   2005: lstore 8
    //   2007: lload 12
    //   2009: lstore 10
    //   2011: iload 16
    //   2013: istore 17
    //   2015: iload 16
    //   2017: istore 18
    //   2019: ldc_w 467
    //   2022: iconst_2
    //   2023: anewarray 4	java/lang/Object
    //   2026: dup
    //   2027: iconst_0
    //   2028: iload 4
    //   2030: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2033: aastore
    //   2034: dup
    //   2035: iconst_1
    //   2036: iload 6
    //   2038: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2041: aastore
    //   2042: invokestatic 146	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2045: goto -1348 -> 697
    //   2048: iload_3
    //   2049: istore_2
    //   2050: lload 14
    //   2052: lstore 8
    //   2054: lload 12
    //   2056: lstore 10
    //   2058: iload 16
    //   2060: istore 17
    //   2062: iload 16
    //   2064: istore 18
    //   2066: aload_0
    //   2067: aload 23
    //   2069: iload 6
    //   2071: aload 22
    //   2073: invokespecial 469	com/tencent/beacon/upload/h:a	(Landroid/util/SparseArray;I[B)Z
    //   2076: pop
    //   2077: goto -1380 -> 697
    //   2080: astore 21
    //   2082: iload 17
    //   2084: istore 18
    //   2086: goto -657 -> 1429
    //   2089: astore 21
    //   2091: goto -280 -> 1811
    //   2094: aload_1
    //   2095: ifnull -1398 -> 697
    //   2098: aload 21
    //   2100: ifnonnull -1278 -> 822
    //   2103: goto -1406 -> 697
    //   2106: iload 4
    //   2108: lookupswitch	default:+36->2144, 4:+-168->1940, 100:+-222->1886, 102:+-114->1994
    //   2145: impdep1
    //   2146: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2147	0	this	h
    //   0	2147	1	parama	a
    //   332	1718	2	i	int
    //   584	1465	3	j	int
    //   163	1944	4	k	int
    //   145	631	5	m	int
    //   1611	459	6	n	int
    //   1636	3	7	i1	int
    //   335	1718	8	l1	long
    //   339	1718	10	l2	long
    //   151	1904	12	l3	long
    //   148	1903	14	l4	long
    //   157	1906	16	bool1	boolean
    //   343	1740	17	bool2	boolean
    //   347	1738	18	bool3	boolean
    //   160	588	19	bool4	boolean
    //   154	598	20	bool5	boolean
    //   398	365	21	localObject1	Object
    //   767	618	21	localThrowable	Throwable
    //   1427	205	21	localObject2	Object
    //   1749	24	21	localc	c
    //   2080	1	21	localObject3	Object
    //   2089	10	21	localException	java.lang.Exception
    //   389	1683	22	localObject4	Object
    //   356	1712	23	localObject5	Object
    //   169	265	24	str	String
    //   264	202	25	arrayOfByte	byte[]
    //   299	162	26	locale	e
    // Exception table:
    //   from	to	target	type
    //   349	358	767	java/lang/Throwable
    //   377	391	767	java/lang/Throwable
    //   430	441	767	java/lang/Throwable
    //   460	475	767	java/lang/Throwable
    //   494	504	767	java/lang/Throwable
    //   523	530	767	java/lang/Throwable
    //   549	556	767	java/lang/Throwable
    //   575	582	767	java/lang/Throwable
    //   609	615	767	java/lang/Throwable
    //   633	641	767	java/lang/Throwable
    //   662	694	767	java/lang/Throwable
    //   715	729	767	java/lang/Throwable
    //   755	760	767	java/lang/Throwable
    //   840	845	767	java/lang/Throwable
    //   868	876	767	java/lang/Throwable
    //   894	907	767	java/lang/Throwable
    //   925	934	767	java/lang/Throwable
    //   952	968	767	java/lang/Throwable
    //   986	1015	767	java/lang/Throwable
    //   1033	1043	767	java/lang/Throwable
    //   1061	1071	767	java/lang/Throwable
    //   1089	1099	767	java/lang/Throwable
    //   1117	1129	767	java/lang/Throwable
    //   1152	1165	767	java/lang/Throwable
    //   1183	1193	767	java/lang/Throwable
    //   1211	1224	767	java/lang/Throwable
    //   1242	1252	767	java/lang/Throwable
    //   1270	1278	767	java/lang/Throwable
    //   1296	1304	767	java/lang/Throwable
    //   1322	1338	767	java/lang/Throwable
    //   1356	1366	767	java/lang/Throwable
    //   1384	1391	767	java/lang/Throwable
    //   1414	1424	767	java/lang/Throwable
    //   1456	1478	767	java/lang/Throwable
    //   1496	1502	767	java/lang/Throwable
    //   1525	1533	767	java/lang/Throwable
    //   1551	1561	767	java/lang/Throwable
    //   1582	1588	767	java/lang/Throwable
    //   1606	1613	767	java/lang/Throwable
    //   1631	1638	767	java/lang/Throwable
    //   1672	1693	767	java/lang/Throwable
    //   1711	1720	767	java/lang/Throwable
    //   1738	1751	767	java/lang/Throwable
    //   1769	1779	767	java/lang/Throwable
    //   1797	1811	767	java/lang/Throwable
    //   1834	1844	767	java/lang/Throwable
    //   1865	1883	767	java/lang/Throwable
    //   1911	1937	767	java/lang/Throwable
    //   1965	1991	767	java/lang/Throwable
    //   2019	2045	767	java/lang/Throwable
    //   2066	2077	767	java/lang/Throwable
    //   349	358	1427	finally
    //   377	391	1427	finally
    //   430	441	1427	finally
    //   460	475	1427	finally
    //   494	504	1427	finally
    //   523	530	1427	finally
    //   549	556	1427	finally
    //   575	582	1427	finally
    //   609	615	1427	finally
    //   633	641	1427	finally
    //   662	694	1427	finally
    //   715	729	1427	finally
    //   755	760	1427	finally
    //   840	845	1427	finally
    //   868	876	1427	finally
    //   894	907	1427	finally
    //   925	934	1427	finally
    //   952	968	1427	finally
    //   986	1015	1427	finally
    //   1033	1043	1427	finally
    //   1061	1071	1427	finally
    //   1089	1099	1427	finally
    //   1117	1129	1427	finally
    //   1152	1165	1427	finally
    //   1183	1193	1427	finally
    //   1211	1224	1427	finally
    //   1242	1252	1427	finally
    //   1270	1278	1427	finally
    //   1296	1304	1427	finally
    //   1322	1338	1427	finally
    //   1356	1366	1427	finally
    //   1384	1391	1427	finally
    //   1414	1424	1427	finally
    //   1456	1478	1427	finally
    //   1496	1502	1427	finally
    //   1525	1533	1427	finally
    //   1551	1561	1427	finally
    //   1582	1588	1427	finally
    //   1606	1613	1427	finally
    //   1631	1638	1427	finally
    //   1672	1693	1427	finally
    //   1711	1720	1427	finally
    //   1738	1751	1427	finally
    //   1769	1779	1427	finally
    //   1797	1811	1427	finally
    //   1834	1844	1427	finally
    //   1865	1883	1427	finally
    //   1911	1937	1427	finally
    //   1965	1991	1427	finally
    //   2019	2045	1427	finally
    //   2066	2077	1427	finally
    //   769	809	2080	finally
    //   1672	1693	2089	java/lang/Exception
    //   1711	1720	2089	java/lang/Exception
    //   1738	1751	2089	java/lang/Exception
    //   1769	1779	2089	java/lang/Exception
    //   1797	1811	2089	java/lang/Exception
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.b.append(paramInt, paramf);
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    boolean bool;
    if (paramUploadHandleListener == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        if (!this.c.contains(paramUploadHandleListener)) {
          this.c.add(paramUploadHandleListener);
        }
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   6: invokestatic 482	com/tencent/beacon/d/b:a	(Landroid/content/Context;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 52	com/tencent/beacon/upload/h:h	Z
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	h
    //   9	16	1	bool	boolean
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   20	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.h
 * JD-Core Version:    0.7.0.1
 */