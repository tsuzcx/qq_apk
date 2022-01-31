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
  
  private h(Context paramContext, boolean paramBoolean)
  {
    this.e = paramContext.getApplicationContext();
    this.f = paramBoolean;
    this.d = e.a(this.e);
  }
  
  private static c a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = com.tencent.beacon.a.e.b(1, paramArrayOfByte);
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
        a.a(paramBoolean);
        com.tencent.beacon.d.a.h(" change uphandler up: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = c();
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
  
  private void a(boolean paramBoolean)
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
          com.tencent.beacon.b.a.a(this.e).b(paramArrayOfByte.a);
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
          localObject = com.tencent.beacon.a.e.a(1, locald.a());
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
  private UploadHandleListener[] c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 43	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   13: invokeinterface 245 1 0
    //   18: ifle +24 -> 42
    //   21: aload_0
    //   22: getfield 43	com/tencent/beacon/upload/h:c	Ljava/util/List;
    //   25: iconst_0
    //   26: anewarray 125	com/tencent/beacon/upload/UploadHandleListener
    //   29: invokeinterface 249 2 0
    //   34: checkcast 251	[Lcom/tencent/beacon/upload/UploadHandleListener;
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
  
  private e d()
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
  private SparseArray<f> e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 38	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   13: invokevirtual 254	android/util/SparseArray:size	()I
    //   16: ifle +23 -> 39
    //   19: new 256	com/tencent/beacon/d/c
    //   22: dup
    //   23: invokespecial 257	com/tencent/beacon/d/c:<init>	()V
    //   26: pop
    //   27: aload_0
    //   28: getfield 38	com/tencent/beacon/upload/h:b	Landroid/util/SparseArray;
    //   31: invokestatic 260	com/tencent/beacon/d/c:a	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
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
    //   1: invokevirtual 114	com/tencent/beacon/upload/h:b	()Z
    //   4: ifne +69 -> 73
    //   7: aload_1
    //   8: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   11: iconst_2
    //   12: if_icmpne +23 -> 35
    //   15: ldc_w 266
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_1
    //   26: invokevirtual 213	com/tencent/beacon/upload/a:a	()Lcom/tencent/beacon/c/a/b;
    //   29: pop
    //   30: aload_1
    //   31: iconst_0
    //   32: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   35: aload_1
    //   36: getfield 269	com/tencent/beacon/upload/a:b	I
    //   39: ifeq +24 -> 63
    //   42: ldc_w 271
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   55: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aastore
    //   59: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: return
    //   63: ldc_w 273
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: aload_0
    //   74: getfield 45	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   77: invokestatic 278	com/tencent/beacon/d/b:b	(Landroid/content/Context;)Z
    //   80: ifne +27 -> 107
    //   83: ldc_w 280
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 144	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   97: iconst_2
    //   98: if_icmpne -36 -> 62
    //   101: aload_1
    //   102: iconst_0
    //   103: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   106: return
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 45	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   112: invokestatic 285	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   115: invokevirtual 288	com/tencent/beacon/upload/h:a	(Lcom/tencent/beacon/upload/UploadHandleListener;)Z
    //   118: pop
    //   119: aload_1
    //   120: ifnonnull +14 -> 134
    //   123: ldc_w 290
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 205	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: return
    //   134: aload_1
    //   135: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   138: istore 5
    //   140: lconst_0
    //   141: lstore 13
    //   143: lconst_0
    //   144: lstore 11
    //   146: iconst_0
    //   147: istore 19
    //   149: iconst_0
    //   150: istore 15
    //   152: iconst_0
    //   153: istore 18
    //   155: iconst_m1
    //   156: istore 4
    //   158: aload_0
    //   159: invokespecial 123	com/tencent/beacon/upload/h:c	()[Lcom/tencent/beacon/upload/UploadHandleListener;
    //   162: astore 20
    //   164: aload 20
    //   166: ifnull +32 -> 198
    //   169: aload 20
    //   171: arraylength
    //   172: istore_3
    //   173: iconst_0
    //   174: istore_2
    //   175: iload_2
    //   176: iload_3
    //   177: if_icmpge +21 -> 198
    //   180: aload 20
    //   182: iload_2
    //   183: aaload
    //   184: iload 5
    //   186: invokeinterface 293 2 0
    //   191: iload_2
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: goto -20 -> 175
    //   198: aload_1
    //   199: invokevirtual 295	com/tencent/beacon/upload/a:d	()Ljava/lang/String;
    //   202: astore 23
    //   204: aload 23
    //   206: ifnull +17 -> 223
    //   209: ldc_w 297
    //   212: aload 23
    //   214: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   217: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifeq +40 -> 260
    //   223: ldc_w 308
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 205	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: aload_1
    //   234: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   237: iconst_2
    //   238: if_icmpne +8 -> 246
    //   241: aload_1
    //   242: iconst_0
    //   243: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   246: aload_0
    //   247: iload 5
    //   249: iconst_m1
    //   250: lconst_0
    //   251: lconst_0
    //   252: iconst_0
    //   253: ldc_w 310
    //   256: invokespecial 312	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   259: return
    //   260: ldc_w 314
    //   263: iconst_3
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: iload 5
    //   271: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: aastore
    //   275: dup
    //   276: iconst_1
    //   277: aload 23
    //   279: aastore
    //   280: dup
    //   281: iconst_2
    //   282: aload_1
    //   283: invokevirtual 192	java/lang/Object:getClass	()Ljava/lang/Class;
    //   286: invokevirtual 198	java/lang/Class:toString	()Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_1
    //   294: invokestatic 316	com/tencent/beacon/upload/h:b	(Lcom/tencent/beacon/upload/a;)[B
    //   297: astore 24
    //   299: aload 24
    //   301: ifnonnull +27 -> 328
    //   304: ldc_w 318
    //   307: iconst_0
    //   308: anewarray 4	java/lang/Object
    //   311: invokestatic 205	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   314: aload_0
    //   315: iload 5
    //   317: iconst_m1
    //   318: lconst_0
    //   319: lconst_0
    //   320: iconst_0
    //   321: ldc_w 320
    //   324: invokespecial 312	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   327: return
    //   328: aload_0
    //   329: invokespecial 322	com/tencent/beacon/upload/h:d	()Lcom/tencent/beacon/upload/e;
    //   332: astore 25
    //   334: aload 25
    //   336: ifnonnull +27 -> 363
    //   339: ldc_w 324
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 205	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: iload 5
    //   352: iconst_m1
    //   353: lconst_0
    //   354: lconst_0
    //   355: iconst_0
    //   356: ldc_w 326
    //   359: invokespecial 312	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   362: return
    //   363: iload 4
    //   365: istore_2
    //   366: lload 13
    //   368: lstore 7
    //   370: lload 11
    //   372: lstore 9
    //   374: iload 18
    //   376: istore 16
    //   378: iload 19
    //   380: istore 17
    //   382: new 328	com/tencent/beacon/upload/d
    //   385: dup
    //   386: invokespecial 329	com/tencent/beacon/upload/d:<init>	()V
    //   389: astore 22
    //   391: iload 4
    //   393: istore_2
    //   394: lload 13
    //   396: lstore 7
    //   398: lload 11
    //   400: lstore 9
    //   402: iload 18
    //   404: istore 16
    //   406: iload 19
    //   408: istore 17
    //   410: aload 25
    //   412: aload 23
    //   414: aload 24
    //   416: aload 22
    //   418: invokevirtual 332	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;)[B
    //   421: astore 21
    //   423: aload 21
    //   425: ifnonnull +342 -> 767
    //   428: aload 21
    //   430: astore 20
    //   432: iload 5
    //   434: bipush 100
    //   436: if_icmpne +70 -> 506
    //   439: aload 21
    //   441: astore 20
    //   443: iload 4
    //   445: istore_2
    //   446: lload 13
    //   448: lstore 7
    //   450: lload 11
    //   452: lstore 9
    //   454: iload 18
    //   456: istore 16
    //   458: iload 19
    //   460: istore 17
    //   462: ldc_w 334
    //   465: aload 23
    //   467: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   470: ifne +36 -> 506
    //   473: iload 4
    //   475: istore_2
    //   476: lload 13
    //   478: lstore 7
    //   480: lload 11
    //   482: lstore 9
    //   484: iload 18
    //   486: istore 16
    //   488: iload 19
    //   490: istore 17
    //   492: aload 25
    //   494: ldc_w 334
    //   497: aload 24
    //   499: aload 22
    //   501: invokevirtual 332	com/tencent/beacon/upload/e:a	(Ljava/lang/String;[BLcom/tencent/beacon/upload/d;)[B
    //   504: astore 20
    //   506: iload 4
    //   508: istore_2
    //   509: lload 13
    //   511: lstore 7
    //   513: lload 11
    //   515: lstore 9
    //   517: iload 18
    //   519: istore 16
    //   521: iload 19
    //   523: istore 17
    //   525: aload_0
    //   526: aload_0
    //   527: invokevirtual 336	com/tencent/beacon/upload/h:a	()I
    //   530: iconst_1
    //   531: iadd
    //   532: invokevirtual 337	com/tencent/beacon/upload/h:a	(I)V
    //   535: iload 4
    //   537: istore_2
    //   538: lload 13
    //   540: lstore 7
    //   542: lload 11
    //   544: lstore 9
    //   546: iload 18
    //   548: istore 16
    //   550: iload 19
    //   552: istore 17
    //   554: aload 22
    //   556: invokevirtual 340	com/tencent/beacon/upload/d:a	()J
    //   559: lstore 13
    //   561: iload 4
    //   563: istore_2
    //   564: lload 13
    //   566: lstore 7
    //   568: lload 11
    //   570: lstore 9
    //   572: iload 18
    //   574: istore 16
    //   576: iload 19
    //   578: istore 17
    //   580: aload 22
    //   582: invokevirtual 342	com/tencent/beacon/upload/d:b	()J
    //   585: lstore 11
    //   587: iload 4
    //   589: istore_2
    //   590: lload 13
    //   592: lstore 7
    //   594: lload 11
    //   596: lstore 9
    //   598: iload 18
    //   600: istore 16
    //   602: iload 19
    //   604: istore 17
    //   606: aload 20
    //   608: invokestatic 344	com/tencent/beacon/upload/h:a	([B)Lcom/tencent/beacon/c/a/c;
    //   611: astore 20
    //   613: iload 4
    //   615: istore_3
    //   616: aload 20
    //   618: ifnull +1304 -> 1922
    //   621: iload 4
    //   623: istore_2
    //   624: lload 13
    //   626: lstore 7
    //   628: lload 11
    //   630: lstore 9
    //   632: iload 18
    //   634: istore 16
    //   636: iload 19
    //   638: istore 17
    //   640: aload 20
    //   642: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   645: istore_3
    //   646: iload_3
    //   647: istore_2
    //   648: lload 13
    //   650: lstore 7
    //   652: lload 11
    //   654: lstore 9
    //   656: iload 18
    //   658: istore 16
    //   660: iload 19
    //   662: istore 17
    //   664: aload 20
    //   666: getfield 348	com/tencent/beacon/c/a/c:a	B
    //   669: ifne +178 -> 847
    //   672: iconst_1
    //   673: istore 15
    //   675: iload_3
    //   676: istore_2
    //   677: lload 13
    //   679: lstore 7
    //   681: lload 11
    //   683: lstore 9
    //   685: iload 15
    //   687: istore 16
    //   689: iload 15
    //   691: istore 17
    //   693: ldc_w 350
    //   696: iconst_2
    //   697: anewarray 4	java/lang/Object
    //   700: dup
    //   701: iconst_0
    //   702: aload 20
    //   704: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   707: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   710: aastore
    //   711: dup
    //   712: iconst_1
    //   713: aload 20
    //   715: getfield 348	com/tencent/beacon/c/a/c:a	B
    //   718: invokestatic 355	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   721: aastore
    //   722: invokestatic 86	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: goto +1197 -> 1922
    //   728: iload_3
    //   729: istore_2
    //   730: lload 13
    //   732: lstore 7
    //   734: lload 11
    //   736: lstore 9
    //   738: iload 15
    //   740: istore 16
    //   742: iload 15
    //   744: istore 17
    //   746: aload_0
    //   747: iload 5
    //   749: iload_3
    //   750: lload 13
    //   752: lload 11
    //   754: iload 15
    //   756: aconst_null
    //   757: invokespecial 312	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   760: aload_1
    //   761: iload 15
    //   763: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   766: return
    //   767: iload 4
    //   769: istore_2
    //   770: lload 13
    //   772: lstore 7
    //   774: lload 11
    //   776: lstore 9
    //   778: iload 18
    //   780: istore 16
    //   782: iload 19
    //   784: istore 17
    //   786: aload_0
    //   787: iconst_0
    //   788: invokevirtual 337	com/tencent/beacon/upload/h:a	(I)V
    //   791: aload 21
    //   793: astore 20
    //   795: goto -260 -> 535
    //   798: astore 20
    //   800: aload 20
    //   802: invokevirtual 94	java/lang/Throwable:printStackTrace	()V
    //   805: aload_0
    //   806: iload 5
    //   808: iload_2
    //   809: lload 7
    //   811: lload 9
    //   813: iconst_0
    //   814: aload 20
    //   816: invokevirtual 356	java/lang/Throwable:toString	()Ljava/lang/String;
    //   819: invokespecial 312	com/tencent/beacon/upload/h:a	(IIJJZLjava/lang/String;)V
    //   822: ldc_w 358
    //   825: iconst_1
    //   826: anewarray 4	java/lang/Object
    //   829: dup
    //   830: iconst_0
    //   831: aload 20
    //   833: invokevirtual 356	java/lang/Throwable:toString	()Ljava/lang/String;
    //   836: aastore
    //   837: invokestatic 205	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   840: aload_1
    //   841: iload 16
    //   843: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   846: return
    //   847: iconst_0
    //   848: istore 15
    //   850: goto -175 -> 675
    //   853: iload_3
    //   854: istore_2
    //   855: lload 13
    //   857: lstore 7
    //   859: lload 11
    //   861: lstore 9
    //   863: iload 15
    //   865: istore 16
    //   867: iload 15
    //   869: istore 17
    //   871: invokestatic 364	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   874: astore 21
    //   876: aload 21
    //   878: ifnull +168 -> 1046
    //   881: iload_3
    //   882: istore_2
    //   883: lload 13
    //   885: lstore 7
    //   887: lload 11
    //   889: lstore 9
    //   891: iload 15
    //   893: istore 16
    //   895: iload 15
    //   897: istore 17
    //   899: aload 20
    //   901: getfield 365	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   904: ifnull +34 -> 938
    //   907: iload_3
    //   908: istore_2
    //   909: lload 13
    //   911: lstore 7
    //   913: lload 11
    //   915: lstore 9
    //   917: iload 15
    //   919: istore 16
    //   921: iload 15
    //   923: istore 17
    //   925: aload 21
    //   927: aload 20
    //   929: getfield 365	com/tencent/beacon/c/a/c:d	Ljava/lang/String;
    //   932: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   935: invokevirtual 366	com/tencent/beacon/a/d:a	(Ljava/lang/String;)V
    //   938: iload_3
    //   939: istore_2
    //   940: lload 13
    //   942: lstore 7
    //   944: lload 11
    //   946: lstore 9
    //   948: iload 15
    //   950: istore 16
    //   952: iload 15
    //   954: istore 17
    //   956: new 368	java/util/Date
    //   959: dup
    //   960: invokespecial 369	java/util/Date:<init>	()V
    //   963: astore 22
    //   965: iload_3
    //   966: istore_2
    //   967: lload 13
    //   969: lstore 7
    //   971: lload 11
    //   973: lstore 9
    //   975: iload 15
    //   977: istore 16
    //   979: iload 15
    //   981: istore 17
    //   983: aload 21
    //   985: aload 20
    //   987: getfield 372	com/tencent/beacon/c/a/c:g	J
    //   990: aload 22
    //   992: invokevirtual 375	java/util/Date:getTime	()J
    //   995: lsub
    //   996: invokevirtual 378	com/tencent/beacon/a/d:a	(J)V
    //   999: iload_3
    //   1000: istore_2
    //   1001: lload 13
    //   1003: lstore 7
    //   1005: lload 11
    //   1007: lstore 9
    //   1009: iload 15
    //   1011: istore 16
    //   1013: iload 15
    //   1015: istore 17
    //   1017: ldc_w 380
    //   1020: iconst_2
    //   1021: anewarray 4	java/lang/Object
    //   1024: dup
    //   1025: iconst_0
    //   1026: aload 21
    //   1028: invokevirtual 382	com/tencent/beacon/a/d:g	()Ljava/lang/String;
    //   1031: aastore
    //   1032: dup
    //   1033: iconst_1
    //   1034: aload 21
    //   1036: invokevirtual 384	com/tencent/beacon/a/d:h	()J
    //   1039: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1042: aastore
    //   1043: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1046: iload_3
    //   1047: istore_2
    //   1048: lload 13
    //   1050: lstore 7
    //   1052: lload 11
    //   1054: lstore 9
    //   1056: iload 15
    //   1058: istore 16
    //   1060: iload 15
    //   1062: istore 17
    //   1064: aload 20
    //   1066: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   1069: bipush 101
    //   1071: if_icmpeq +59 -> 1130
    //   1074: iload_3
    //   1075: istore_2
    //   1076: lload 13
    //   1078: lstore 7
    //   1080: lload 11
    //   1082: lstore 9
    //   1084: iload 15
    //   1086: istore 16
    //   1088: iload 15
    //   1090: istore 17
    //   1092: aload 20
    //   1094: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   1097: bipush 103
    //   1099: if_icmpeq +31 -> 1130
    //   1102: iload_3
    //   1103: istore_2
    //   1104: lload 13
    //   1106: lstore 7
    //   1108: lload 11
    //   1110: lstore 9
    //   1112: iload 15
    //   1114: istore 16
    //   1116: iload 15
    //   1118: istore 17
    //   1120: aload 20
    //   1122: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   1125: bipush 105
    //   1127: if_icmpne +270 -> 1397
    //   1130: iload_3
    //   1131: istore_2
    //   1132: lload 13
    //   1134: lstore 7
    //   1136: lload 11
    //   1138: lstore 9
    //   1140: iload 15
    //   1142: istore 16
    //   1144: iload 15
    //   1146: istore 17
    //   1148: aload_0
    //   1149: getfield 45	com/tencent/beacon/upload/h:e	Landroid/content/Context;
    //   1152: invokestatic 394	com/tencent/beacon/a/b/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/c;
    //   1155: invokevirtual 397	com/tencent/beacon/a/b/c:b	()Lcom/tencent/beacon/a/b/e;
    //   1158: astore 21
    //   1160: aload 21
    //   1162: ifnull +235 -> 1397
    //   1165: iload_3
    //   1166: istore_2
    //   1167: lload 13
    //   1169: lstore 7
    //   1171: lload 11
    //   1173: lstore 9
    //   1175: iload 15
    //   1177: istore 16
    //   1179: iload 15
    //   1181: istore 17
    //   1183: aload 21
    //   1185: invokevirtual 402	com/tencent/beacon/a/b/e:g	()B
    //   1188: aload 20
    //   1190: getfield 404	com/tencent/beacon/c/a/c:f	B
    //   1193: if_icmpeq +31 -> 1224
    //   1196: iload_3
    //   1197: istore_2
    //   1198: lload 13
    //   1200: lstore 7
    //   1202: lload 11
    //   1204: lstore 9
    //   1206: iload 15
    //   1208: istore 16
    //   1210: iload 15
    //   1212: istore 17
    //   1214: aload 21
    //   1216: aload 20
    //   1218: getfield 404	com/tencent/beacon/c/a/c:f	B
    //   1221: invokevirtual 407	com/tencent/beacon/a/b/e:b	(B)V
    //   1224: iload_3
    //   1225: istore_2
    //   1226: lload 13
    //   1228: lstore 7
    //   1230: lload 11
    //   1232: lstore 9
    //   1234: iload 15
    //   1236: istore 16
    //   1238: iload 15
    //   1240: istore 17
    //   1242: aload 21
    //   1244: invokevirtual 409	com/tencent/beacon/a/b/e:f	()B
    //   1247: aload 20
    //   1249: getfield 411	com/tencent/beacon/c/a/c:e	B
    //   1252: if_icmpeq +31 -> 1283
    //   1255: iload_3
    //   1256: istore_2
    //   1257: lload 13
    //   1259: lstore 7
    //   1261: lload 11
    //   1263: lstore 9
    //   1265: iload 15
    //   1267: istore 16
    //   1269: iload 15
    //   1271: istore 17
    //   1273: aload 21
    //   1275: aload 20
    //   1277: getfield 411	com/tencent/beacon/c/a/c:e	B
    //   1280: invokevirtual 413	com/tencent/beacon/a/b/e:a	(B)V
    //   1283: iload_3
    //   1284: istore_2
    //   1285: lload 13
    //   1287: lstore 7
    //   1289: lload 11
    //   1291: lstore 9
    //   1293: iload 15
    //   1295: istore 16
    //   1297: iload 15
    //   1299: istore 17
    //   1301: aload 21
    //   1303: invokevirtual 415	com/tencent/beacon/a/b/e:h	()Ljava/lang/String;
    //   1306: ifnull +63 -> 1369
    //   1309: iload_3
    //   1310: istore_2
    //   1311: lload 13
    //   1313: lstore 7
    //   1315: lload 11
    //   1317: lstore 9
    //   1319: iload 15
    //   1321: istore 16
    //   1323: iload 15
    //   1325: istore 17
    //   1327: aload 20
    //   1329: getfield 417	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1332: ifnull +65 -> 1397
    //   1335: iload_3
    //   1336: istore_2
    //   1337: lload 13
    //   1339: lstore 7
    //   1341: lload 11
    //   1343: lstore 9
    //   1345: iload 15
    //   1347: istore 16
    //   1349: iload 15
    //   1351: istore 17
    //   1353: aload 21
    //   1355: invokevirtual 415	com/tencent/beacon/a/b/e:h	()Ljava/lang/String;
    //   1358: aload 20
    //   1360: getfield 417	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1363: invokevirtual 306	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1366: ifne +31 -> 1397
    //   1369: iload_3
    //   1370: istore_2
    //   1371: lload 13
    //   1373: lstore 7
    //   1375: lload 11
    //   1377: lstore 9
    //   1379: iload 15
    //   1381: istore 16
    //   1383: iload 15
    //   1385: istore 17
    //   1387: aload 21
    //   1389: aload 20
    //   1391: getfield 417	com/tencent/beacon/c/a/c:h	Ljava/lang/String;
    //   1394: invokevirtual 418	com/tencent/beacon/a/b/e:b	(Ljava/lang/String;)V
    //   1397: iload_3
    //   1398: istore_2
    //   1399: lload 13
    //   1401: lstore 7
    //   1403: lload 11
    //   1405: lstore 9
    //   1407: iload 15
    //   1409: istore 16
    //   1411: iload 15
    //   1413: istore 17
    //   1415: aload 20
    //   1417: getfield 421	com/tencent/beacon/c/a/c:c	[B
    //   1420: astore 21
    //   1422: aload 21
    //   1424: ifnonnull +45 -> 1469
    //   1427: iload_3
    //   1428: istore_2
    //   1429: lload 13
    //   1431: lstore 7
    //   1433: lload 11
    //   1435: lstore 9
    //   1437: iload 15
    //   1439: istore 16
    //   1441: iload 15
    //   1443: istore 17
    //   1445: ldc_w 423
    //   1448: iconst_0
    //   1449: anewarray 4	java/lang/Object
    //   1452: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1455: goto -727 -> 728
    //   1458: astore 20
    //   1460: aload_1
    //   1461: iload 17
    //   1463: invokevirtual 267	com/tencent/beacon/upload/a:a	(Z)V
    //   1466: aload 20
    //   1468: athrow
    //   1469: iload_3
    //   1470: istore_2
    //   1471: lload 13
    //   1473: lstore 7
    //   1475: lload 11
    //   1477: lstore 9
    //   1479: iload 15
    //   1481: istore 16
    //   1483: iload 15
    //   1485: istore 17
    //   1487: aload 21
    //   1489: aload 20
    //   1491: getfield 404	com/tencent/beacon/c/a/c:f	B
    //   1494: aload 20
    //   1496: getfield 411	com/tencent/beacon/c/a/c:e	B
    //   1499: aload 20
    //   1501: getfield 426	com/tencent/beacon/c/a/c:i	Ljava/lang/String;
    //   1504: invokestatic 429	com/tencent/beacon/b/a:b	([BIILjava/lang/String;)[B
    //   1507: astore 21
    //   1509: iload_3
    //   1510: istore_2
    //   1511: lload 13
    //   1513: lstore 7
    //   1515: lload 11
    //   1517: lstore 9
    //   1519: iload 15
    //   1521: istore 16
    //   1523: iload 15
    //   1525: istore 17
    //   1527: aload_0
    //   1528: invokespecial 431	com/tencent/beacon/upload/h:e	()Landroid/util/SparseArray;
    //   1531: astore 22
    //   1533: aload 22
    //   1535: ifnull +29 -> 1564
    //   1538: iload_3
    //   1539: istore_2
    //   1540: lload 13
    //   1542: lstore 7
    //   1544: lload 11
    //   1546: lstore 9
    //   1548: iload 15
    //   1550: istore 16
    //   1552: iload 15
    //   1554: istore 17
    //   1556: aload 22
    //   1558: invokevirtual 254	android/util/SparseArray:size	()I
    //   1561: ifgt +34 -> 1595
    //   1564: iload_3
    //   1565: istore_2
    //   1566: lload 13
    //   1568: lstore 7
    //   1570: lload 11
    //   1572: lstore 9
    //   1574: iload 15
    //   1576: istore 16
    //   1578: iload 15
    //   1580: istore 17
    //   1582: ldc_w 433
    //   1585: iconst_0
    //   1586: anewarray 4	java/lang/Object
    //   1589: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1592: goto -864 -> 728
    //   1595: iload_3
    //   1596: istore_2
    //   1597: lload 13
    //   1599: lstore 7
    //   1601: lload 11
    //   1603: lstore 9
    //   1605: iload 15
    //   1607: istore 16
    //   1609: iload 15
    //   1611: istore 17
    //   1613: aload_1
    //   1614: invokevirtual 264	com/tencent/beacon/upload/a:c	()I
    //   1617: istore 4
    //   1619: iload_3
    //   1620: istore_2
    //   1621: lload 13
    //   1623: lstore 7
    //   1625: lload 11
    //   1627: lstore 9
    //   1629: iload 15
    //   1631: istore 16
    //   1633: iload 15
    //   1635: istore 17
    //   1637: aload 20
    //   1639: getfield 345	com/tencent/beacon/c/a/c:b	I
    //   1642: istore 6
    //   1644: iload 6
    //   1646: ifne +288 -> 1934
    //   1649: iload_3
    //   1650: istore_2
    //   1651: lload 13
    //   1653: lstore 7
    //   1655: lload 11
    //   1657: lstore 9
    //   1659: iload 15
    //   1661: istore 16
    //   1663: iload 15
    //   1665: istore 17
    //   1667: ldc_w 435
    //   1670: iconst_0
    //   1671: anewarray 4	java/lang/Object
    //   1674: invokestatic 102	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1677: goto -949 -> 728
    //   1680: iload_3
    //   1681: istore_2
    //   1682: lload 13
    //   1684: lstore 7
    //   1686: lload 11
    //   1688: lstore 9
    //   1690: iload 15
    //   1692: istore 16
    //   1694: iload 15
    //   1696: istore 17
    //   1698: ldc_w 437
    //   1701: iconst_1
    //   1702: anewarray 4	java/lang/Object
    //   1705: dup
    //   1706: iconst_0
    //   1707: iload 4
    //   1709: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1712: aastore
    //   1713: invokestatic 144	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1716: goto -988 -> 728
    //   1719: iload 6
    //   1721: bipush 101
    //   1723: if_icmpeq +158 -> 1881
    //   1726: iload_3
    //   1727: istore_2
    //   1728: lload 13
    //   1730: lstore 7
    //   1732: lload 11
    //   1734: lstore 9
    //   1736: iload 15
    //   1738: istore 16
    //   1740: iload 15
    //   1742: istore 17
    //   1744: ldc_w 439
    //   1747: iconst_2
    //   1748: anewarray 4	java/lang/Object
    //   1751: dup
    //   1752: iconst_0
    //   1753: iload 4
    //   1755: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1758: aastore
    //   1759: dup
    //   1760: iconst_1
    //   1761: iload 6
    //   1763: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1766: aastore
    //   1767: invokestatic 144	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1770: goto -1042 -> 728
    //   1773: iload 6
    //   1775: bipush 105
    //   1777: if_icmpeq +104 -> 1881
    //   1780: iload_3
    //   1781: istore_2
    //   1782: lload 13
    //   1784: lstore 7
    //   1786: lload 11
    //   1788: lstore 9
    //   1790: iload 15
    //   1792: istore 16
    //   1794: iload 15
    //   1796: istore 17
    //   1798: ldc_w 439
    //   1801: iconst_2
    //   1802: anewarray 4	java/lang/Object
    //   1805: dup
    //   1806: iconst_0
    //   1807: iload 4
    //   1809: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1812: aastore
    //   1813: dup
    //   1814: iconst_1
    //   1815: iload 6
    //   1817: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1820: aastore
    //   1821: invokestatic 144	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1824: goto -1096 -> 728
    //   1827: iload 6
    //   1829: bipush 103
    //   1831: if_icmpeq +50 -> 1881
    //   1834: iload_3
    //   1835: istore_2
    //   1836: lload 13
    //   1838: lstore 7
    //   1840: lload 11
    //   1842: lstore 9
    //   1844: iload 15
    //   1846: istore 16
    //   1848: iload 15
    //   1850: istore 17
    //   1852: ldc_w 441
    //   1855: iconst_2
    //   1856: anewarray 4	java/lang/Object
    //   1859: dup
    //   1860: iconst_0
    //   1861: iload 4
    //   1863: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1866: aastore
    //   1867: dup
    //   1868: iconst_1
    //   1869: iload 6
    //   1871: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1874: aastore
    //   1875: invokestatic 144	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1878: goto -1150 -> 728
    //   1881: iload_3
    //   1882: istore_2
    //   1883: lload 13
    //   1885: lstore 7
    //   1887: lload 11
    //   1889: lstore 9
    //   1891: iload 15
    //   1893: istore 16
    //   1895: iload 15
    //   1897: istore 17
    //   1899: aload_0
    //   1900: aload 22
    //   1902: iload 6
    //   1904: aload 21
    //   1906: invokespecial 443	com/tencent/beacon/upload/h:a	(Landroid/util/SparseArray;I[B)Z
    //   1909: pop
    //   1910: goto -1182 -> 728
    //   1913: astore 20
    //   1915: iload 16
    //   1917: istore 17
    //   1919: goto -459 -> 1460
    //   1922: aload_1
    //   1923: ifnull -1195 -> 728
    //   1926: aload 20
    //   1928: ifnonnull -1075 -> 853
    //   1931: goto -1203 -> 728
    //   1934: iload 4
    //   1936: lookupswitch	default:+36->1972, 4:+-163->1773, 100:+-217->1719, 102:+-109->1827
    //   1973: impdep1
    //   1974: <illegal opcode>
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1975	0	this	h
    //   0	1975	1	parama	a
    //   174	1709	2	i	int
    //   172	1710	3	j	int
    //   156	1779	4	k	int
    //   138	669	5	m	int
    //   1642	261	6	n	int
    //   368	1518	7	l1	long
    //   372	1518	9	l2	long
    //   144	1744	11	l3	long
    //   141	1743	13	l4	long
    //   150	1746	15	bool1	boolean
    //   376	1540	16	bool2	boolean
    //   380	1538	17	bool3	boolean
    //   153	626	18	bool4	boolean
    //   147	636	19	bool5	boolean
    //   162	632	20	localObject1	Object
    //   798	618	20	localThrowable	Throwable
    //   1458	180	20	localObject2	Object
    //   1913	14	20	localObject3	Object
    //   421	1484	21	localObject4	Object
    //   389	1512	22	localObject5	Object
    //   202	264	23	str	String
    //   297	201	24	arrayOfByte	byte[]
    //   332	161	25	locale	e
    // Exception table:
    //   from	to	target	type
    //   382	391	798	java/lang/Throwable
    //   410	423	798	java/lang/Throwable
    //   462	473	798	java/lang/Throwable
    //   492	506	798	java/lang/Throwable
    //   525	535	798	java/lang/Throwable
    //   554	561	798	java/lang/Throwable
    //   580	587	798	java/lang/Throwable
    //   606	613	798	java/lang/Throwable
    //   640	646	798	java/lang/Throwable
    //   664	672	798	java/lang/Throwable
    //   693	725	798	java/lang/Throwable
    //   746	760	798	java/lang/Throwable
    //   786	791	798	java/lang/Throwable
    //   871	876	798	java/lang/Throwable
    //   899	907	798	java/lang/Throwable
    //   925	938	798	java/lang/Throwable
    //   956	965	798	java/lang/Throwable
    //   983	999	798	java/lang/Throwable
    //   1017	1046	798	java/lang/Throwable
    //   1064	1074	798	java/lang/Throwable
    //   1092	1102	798	java/lang/Throwable
    //   1120	1130	798	java/lang/Throwable
    //   1148	1160	798	java/lang/Throwable
    //   1183	1196	798	java/lang/Throwable
    //   1214	1224	798	java/lang/Throwable
    //   1242	1255	798	java/lang/Throwable
    //   1273	1283	798	java/lang/Throwable
    //   1301	1309	798	java/lang/Throwable
    //   1327	1335	798	java/lang/Throwable
    //   1353	1369	798	java/lang/Throwable
    //   1387	1397	798	java/lang/Throwable
    //   1415	1422	798	java/lang/Throwable
    //   1445	1455	798	java/lang/Throwable
    //   1487	1509	798	java/lang/Throwable
    //   1527	1533	798	java/lang/Throwable
    //   1556	1564	798	java/lang/Throwable
    //   1582	1592	798	java/lang/Throwable
    //   1613	1619	798	java/lang/Throwable
    //   1637	1644	798	java/lang/Throwable
    //   1667	1677	798	java/lang/Throwable
    //   1698	1716	798	java/lang/Throwable
    //   1744	1770	798	java/lang/Throwable
    //   1798	1824	798	java/lang/Throwable
    //   1852	1878	798	java/lang/Throwable
    //   1899	1910	798	java/lang/Throwable
    //   382	391	1458	finally
    //   410	423	1458	finally
    //   462	473	1458	finally
    //   492	506	1458	finally
    //   525	535	1458	finally
    //   554	561	1458	finally
    //   580	587	1458	finally
    //   606	613	1458	finally
    //   640	646	1458	finally
    //   664	672	1458	finally
    //   693	725	1458	finally
    //   746	760	1458	finally
    //   786	791	1458	finally
    //   871	876	1458	finally
    //   899	907	1458	finally
    //   925	938	1458	finally
    //   956	965	1458	finally
    //   983	999	1458	finally
    //   1017	1046	1458	finally
    //   1064	1074	1458	finally
    //   1092	1102	1458	finally
    //   1120	1130	1458	finally
    //   1148	1160	1458	finally
    //   1183	1196	1458	finally
    //   1214	1224	1458	finally
    //   1242	1255	1458	finally
    //   1273	1283	1458	finally
    //   1301	1309	1458	finally
    //   1327	1335	1458	finally
    //   1353	1369	1458	finally
    //   1387	1397	1458	finally
    //   1415	1422	1458	finally
    //   1445	1455	1458	finally
    //   1487	1509	1458	finally
    //   1527	1533	1458	finally
    //   1556	1564	1458	finally
    //   1582	1592	1458	finally
    //   1613	1619	1458	finally
    //   1637	1644	1458	finally
    //   1667	1677	1458	finally
    //   1698	1716	1458	finally
    //   1744	1770	1458	finally
    //   1798	1824	1458	finally
    //   1852	1878	1458	finally
    //   1899	1910	1458	finally
    //   800	840	1913	finally
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.h
 * JD-Core Version:    0.7.0.1
 */