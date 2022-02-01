package com.tencent.feedback.upload;

import android.content.Context;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.O;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.t;
import com.tencent.feedback.proguard.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements e
{
  private static f a;
  private List<d> b = new ArrayList(2);
  private List<UploadHandleListener> c = new ArrayList(5);
  private c d;
  private Context e = null;
  private boolean f = true;
  private int g = 0;
  
  private f(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
    }
    this.e = paramContext;
    this.f = paramBoolean;
    this.d = c.a(this.e);
  }
  
  private int a()
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
  
  private O a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        com.tencent.feedback.proguard.d locald = new com.tencent.feedback.proguard.d();
        locald.e();
        locald.a("utf-8");
        locald.a(paramArrayOfByte);
        paramArrayOfByte = locald.b("detail", new O());
        if (!O.class.isInstance(paramArrayOfByte)) {
          break label174;
        }
        com.tencent.feedback.common.e.b("rqdp{  covert to ResponsePackage}", new Object[0]);
        paramArrayOfByte = (O)O.class.cast(paramArrayOfByte);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.c != null) && (paramArrayOfByte.c.length > 0))
        {
          com.tencent.feedback.common.e.b("resp buf %d", new Object[] { Integer.valueOf(paramArrayOfByte.c.length) });
          paramArrayOfByte.c = a.b(paramArrayOfByte.c, 2, 1, t.a(this.e).b().e());
          if (paramArrayOfByte.c == null)
          {
            com.tencent.feedback.common.e.d("resp sbuffer error!", new Object[0]);
            return null;
          }
        }
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        if (!com.tencent.feedback.common.e.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
      }
      return null;
      label174:
      paramArrayOfByte = null;
    }
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new f(paramContext, true);
        com.tencent.feedback.common.e.b("rqdp{  create uphandler up:true}", new Object[0]);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static f a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (a == null)
      {
        a = new f(paramContext, paramBoolean);
        com.tencent.feedback.common.e.b("rqdp{  create uphandler up:}%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (a.e() != paramBoolean)
      {
        a.a(paramBoolean);
        com.tencent.feedback.common.e.b("rqdp{  change uphandler up:}%b", new Object[] { Boolean.valueOf(paramBoolean) });
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt)
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
  
  private void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    UploadHandleListener[] arrayOfUploadHandleListener = b();
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
  
  private static void a(List<d> paramList, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramList != null)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        if (locald != null) {
          try
          {
            com.tencent.feedback.common.e.b("rqdp{  key:}%d rqdp{  handler: }%s", new Object[] { Integer.valueOf(paramInt), locald.getClass().toString() });
            locald.a(paramInt, paramArrayOfByte, true);
          }
          catch (Throwable localThrowable)
          {
            if (!com.tencent.feedback.common.e.a(localThrowable)) {
              localThrowable.printStackTrace();
            }
            com.tencent.feedback.common.e.d("rqdp{  handle error key:}%d", new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
      return;
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
  
  private static byte[] b(AbstractUploadDatas paramAbstractUploadDatas)
  {
    if (paramAbstractUploadDatas != null) {
      try
      {
        paramAbstractUploadDatas = paramAbstractUploadDatas.a();
        if (paramAbstractUploadDatas != null)
        {
          com.tencent.feedback.common.e.b("rqdp{  [pid:}%s rqdp{  \nbid:}%s_%s rqdp{  \nsv:}%s \n]", new Object[] { paramAbstractUploadDatas.c, paramAbstractUploadDatas.c, paramAbstractUploadDatas.d, paramAbstractUploadDatas.f });
          com.tencent.feedback.proguard.d locald = new com.tencent.feedback.proguard.d();
          locald.e();
          locald.a("utf-8");
          locald.a(1);
          locald.c("RqdServer");
          locald.d("sync");
          locald.a("detail", paramAbstractUploadDatas);
          paramAbstractUploadDatas = locald.a();
          return paramAbstractUploadDatas;
        }
      }
      catch (Throwable paramAbstractUploadDatas)
      {
        if (!com.tencent.feedback.common.e.a(paramAbstractUploadDatas)) {
          paramAbstractUploadDatas.printStackTrace();
        }
        AbstractUploadDatas.d();
      }
    }
    return null;
  }
  
  private UploadHandleListener[] b()
  {
    try
    {
      if ((this.c != null) && (this.c.size() > 0))
      {
        UploadHandleListener[] arrayOfUploadHandleListener = (UploadHandleListener[])this.c.toArray(new UploadHandleListener[0]);
        return arrayOfUploadHandleListener;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private c c()
  {
    try
    {
      c localc = this.d;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private List<d> d()
  {
    try
    {
      if ((this.b != null) && (this.b.size() > 0))
      {
        ArrayList localArrayList = new ArrayList(this.b);
        return localArrayList;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean e()
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
  public final void a(AbstractUploadDatas paramAbstractUploadDatas)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 155	com/tencent/feedback/upload/f:e	()Z
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_0
    //   10: istore 5
    //   12: iload 7
    //   14: ifne +46 -> 60
    //   17: aload_1
    //   18: getfield 256	com/tencent/feedback/upload/AbstractUploadDatas:b	I
    //   21: sipush 1111
    //   24: if_icmpeq +25 -> 49
    //   27: ldc_w 258
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: aload_1
    //   37: invokevirtual 260	com/tencent/feedback/upload/AbstractUploadDatas:b	()I
    //   40: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   47: pop
    //   48: return
    //   49: ldc_w 262
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload_0
    //   61: getfield 39	com/tencent/feedback/upload/f:e	Landroid/content/Context;
    //   64: invokestatic 267	com/tencent/feedback/common/g:b	(Landroid/content/Context;)Z
    //   67: ifne +15 -> 82
    //   70: ldc_w 269
    //   73: iconst_0
    //   74: anewarray 4	java/lang/Object
    //   77: invokestatic 271	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   80: pop
    //   81: return
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 39	com/tencent/feedback/upload/f:e	Landroid/content/Context;
    //   87: invokestatic 276	com/tencent/feedback/common/f:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/f;
    //   90: invokevirtual 279	com/tencent/feedback/upload/f:a	(Lcom/tencent/feedback/upload/UploadHandleListener;)Z
    //   93: pop
    //   94: aload_1
    //   95: ifnonnull +15 -> 110
    //   98: ldc_w 281
    //   101: iconst_0
    //   102: anewarray 4	java/lang/Object
    //   105: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   108: pop
    //   109: return
    //   110: aload_1
    //   111: invokevirtual 260	com/tencent/feedback/upload/AbstractUploadDatas:b	()I
    //   114: istore_3
    //   115: aload_0
    //   116: invokespecial 164	com/tencent/feedback/upload/f:b	()[Lcom/tencent/feedback/upload/UploadHandleListener;
    //   119: astore 12
    //   121: aload 12
    //   123: ifnull +33 -> 156
    //   126: aload 12
    //   128: arraylength
    //   129: istore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: iload_2
    //   134: iload 4
    //   136: if_icmpge +20 -> 156
    //   139: aload 12
    //   141: iload_2
    //   142: aaload
    //   143: iload_3
    //   144: invokeinterface 284 2 0
    //   149: iload_2
    //   150: iconst_1
    //   151: iadd
    //   152: istore_2
    //   153: goto -20 -> 133
    //   156: aload_1
    //   157: invokevirtual 286	com/tencent/feedback/upload/AbstractUploadDatas:c	()Ljava/lang/String;
    //   160: astore 12
    //   162: aload 12
    //   164: ifnonnull +27 -> 191
    //   167: ldc_w 288
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   177: pop
    //   178: aload_0
    //   179: iload_3
    //   180: iconst_m1
    //   181: lconst_0
    //   182: lconst_0
    //   183: iconst_0
    //   184: ldc_w 290
    //   187: invokespecial 292	com/tencent/feedback/upload/f:a	(IIJJZLjava/lang/String;)V
    //   190: return
    //   191: ldc_w 294
    //   194: iconst_3
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: iload_3
    //   201: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: aload 12
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: aload_1
    //   213: invokevirtual 193	java/lang/Object:getClass	()Ljava/lang/Class;
    //   216: invokevirtual 196	java/lang/Class:toString	()Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   223: pop
    //   224: aload_1
    //   225: invokestatic 296	com/tencent/feedback/upload/f:b	(Lcom/tencent/feedback/upload/AbstractUploadDatas;)[B
    //   228: astore 13
    //   230: aload 13
    //   232: ifnonnull +27 -> 259
    //   235: ldc_w 298
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   245: pop
    //   246: aload_0
    //   247: iload_3
    //   248: iconst_m1
    //   249: lconst_0
    //   250: lconst_0
    //   251: iconst_0
    //   252: ldc_w 300
    //   255: invokespecial 292	com/tencent/feedback/upload/f:a	(IIJJZLjava/lang/String;)V
    //   258: return
    //   259: aload_0
    //   260: invokespecial 302	com/tencent/feedback/upload/f:c	()Lcom/tencent/feedback/upload/c;
    //   263: astore 14
    //   265: aload 14
    //   267: ifnonnull +27 -> 294
    //   270: ldc_w 304
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload_0
    //   282: iload_3
    //   283: iconst_m1
    //   284: lconst_0
    //   285: lconst_0
    //   286: iconst_0
    //   287: ldc_w 306
    //   290: invokespecial 292	com/tencent/feedback/upload/f:a	(IIJJZLjava/lang/String;)V
    //   293: return
    //   294: aload_0
    //   295: getfield 39	com/tencent/feedback/upload/f:e	Landroid/content/Context;
    //   298: invokestatic 311	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   301: astore 16
    //   303: new 313	java/util/HashMap
    //   306: dup
    //   307: invokespecial 314	java/util/HashMap:<init>	()V
    //   310: astore 15
    //   312: aload 15
    //   314: ldc_w 316
    //   317: aload 16
    //   319: invokevirtual 318	com/tencent/feedback/common/c:b	()Ljava/lang/String;
    //   322: invokeinterface 324 3 0
    //   327: pop
    //   328: aload 15
    //   330: ldc_w 326
    //   333: aload 16
    //   335: invokevirtual 318	com/tencent/feedback/common/c:b	()Ljava/lang/String;
    //   338: invokeinterface 324 3 0
    //   343: pop
    //   344: aload 15
    //   346: ldc_w 328
    //   349: aload 16
    //   351: invokevirtual 331	com/tencent/feedback/common/c:B	()Ljava/lang/String;
    //   354: invokeinterface 324 3 0
    //   359: pop
    //   360: new 333	com/tencent/feedback/upload/b
    //   363: dup
    //   364: invokespecial 334	com/tencent/feedback/upload/b:<init>	()V
    //   367: astore 16
    //   369: aload 14
    //   371: aload 12
    //   373: aload 13
    //   375: aload 16
    //   377: aload 15
    //   379: invokevirtual 337	com/tencent/feedback/upload/c:a	(Ljava/lang/String;[BLcom/tencent/feedback/upload/b;Ljava/util/Map;)[B
    //   382: astore 12
    //   384: aload 12
    //   386: ifnonnull +34 -> 420
    //   389: aload_0
    //   390: aload_0
    //   391: invokespecial 339	com/tencent/feedback/upload/f:a	()I
    //   394: iconst_1
    //   395: iadd
    //   396: invokespecial 340	com/tencent/feedback/upload/f:a	(I)V
    //   399: goto +26 -> 425
    //   402: astore 12
    //   404: lconst_0
    //   405: lstore 8
    //   407: lload 8
    //   409: lstore 10
    //   411: iconst_m1
    //   412: istore_2
    //   413: iload 6
    //   415: istore 5
    //   417: goto +394 -> 811
    //   420: aload_0
    //   421: iconst_0
    //   422: invokespecial 340	com/tencent/feedback/upload/f:a	(I)V
    //   425: aload 16
    //   427: invokevirtual 343	com/tencent/feedback/upload/b:a	()J
    //   430: lstore 8
    //   432: aload 16
    //   434: invokevirtual 345	com/tencent/feedback/upload/b:b	()J
    //   437: lstore 10
    //   439: aload_0
    //   440: aload 12
    //   442: invokespecial 347	com/tencent/feedback/upload/f:a	([B)Lcom/tencent/feedback/proguard/O;
    //   445: astore 12
    //   447: aload 12
    //   449: ifnull +86 -> 535
    //   452: aload 12
    //   454: getfield 348	com/tencent/feedback/proguard/O:b	I
    //   457: istore_2
    //   458: aload 12
    //   460: getfield 350	com/tencent/feedback/proguard/O:a	B
    //   463: istore 4
    //   465: iload 4
    //   467: ifne +9 -> 476
    //   470: iconst_1
    //   471: istore 5
    //   473: goto +6 -> 479
    //   476: iconst_0
    //   477: istore 5
    //   479: ldc_w 352
    //   482: iconst_3
    //   483: anewarray 4	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: iload 5
    //   490: invokestatic 152	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: iload_3
    //   497: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_2
    //   503: iload_2
    //   504: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   511: pop
    //   512: goto +28 -> 540
    //   515: astore 12
    //   517: goto +371 -> 888
    //   520: astore 12
    //   522: goto +5 -> 527
    //   525: astore 12
    //   527: goto +284 -> 811
    //   530: astore 12
    //   532: goto -121 -> 411
    //   535: iconst_0
    //   536: istore 5
    //   538: iconst_m1
    //   539: istore_2
    //   540: aload_1
    //   541: ifnull +202 -> 743
    //   544: aload 12
    //   546: ifnonnull +6 -> 552
    //   549: goto +194 -> 743
    //   552: aload_0
    //   553: getfield 39	com/tencent/feedback/upload/f:e	Landroid/content/Context;
    //   556: invokestatic 311	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   559: astore 13
    //   561: aload 13
    //   563: ifnull +68 -> 631
    //   566: aload 13
    //   568: aload 12
    //   570: getfield 353	com/tencent/feedback/proguard/O:d	Ljava/lang/String;
    //   573: invokevirtual 354	com/tencent/feedback/common/c:c	(Ljava/lang/String;)V
    //   576: new 356	java/util/Date
    //   579: dup
    //   580: invokespecial 357	java/util/Date:<init>	()V
    //   583: astore 14
    //   585: aload 13
    //   587: aload 12
    //   589: getfield 360	com/tencent/feedback/proguard/O:e	J
    //   592: aload 14
    //   594: invokevirtual 363	java/util/Date:getTime	()J
    //   597: lsub
    //   598: invokevirtual 366	com/tencent/feedback/common/c:a	(J)V
    //   601: ldc_w 368
    //   604: iconst_2
    //   605: anewarray 4	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: aload 13
    //   612: invokevirtual 371	com/tencent/feedback/common/c:i	()Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload 13
    //   620: invokevirtual 374	com/tencent/feedback/common/c:j	()J
    //   623: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   626: aastore
    //   627: invokestatic 381	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   630: pop
    //   631: aload 12
    //   633: getfield 101	com/tencent/feedback/proguard/O:c	[B
    //   636: astore 13
    //   638: aload 13
    //   640: ifnonnull +17 -> 657
    //   643: ldc_w 383
    //   646: iconst_0
    //   647: anewarray 4	java/lang/Object
    //   650: invokestatic 271	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   653: pop
    //   654: goto +89 -> 743
    //   657: aload_0
    //   658: invokespecial 385	com/tencent/feedback/upload/f:d	()Ljava/util/List;
    //   661: astore 14
    //   663: aload 14
    //   665: ifnull +54 -> 719
    //   668: aload 14
    //   670: invokeinterface 241 1 0
    //   675: ifgt +6 -> 681
    //   678: goto +41 -> 719
    //   681: aload 12
    //   683: getfield 348	com/tencent/feedback/proguard/O:b	I
    //   686: istore 4
    //   688: iload 4
    //   690: ifne +17 -> 707
    //   693: ldc_w 387
    //   696: iconst_0
    //   697: anewarray 4	java/lang/Object
    //   700: invokestatic 381	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   703: pop
    //   704: goto +39 -> 743
    //   707: aload 14
    //   709: iload 4
    //   711: aload 13
    //   713: invokestatic 389	com/tencent/feedback/upload/f:a	(Ljava/util/List;I[B)V
    //   716: goto +27 -> 743
    //   719: ldc_w 391
    //   722: iconst_0
    //   723: anewarray 4	java/lang/Object
    //   726: invokestatic 94	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   729: pop
    //   730: goto +13 -> 743
    //   733: astore 12
    //   735: goto +153 -> 888
    //   738: astore 12
    //   740: goto +33 -> 773
    //   743: iload 5
    //   745: istore 7
    //   747: iload 7
    //   749: istore 6
    //   751: aload_0
    //   752: iload_3
    //   753: iload_2
    //   754: lload 8
    //   756: lload 10
    //   758: iload 5
    //   760: aconst_null
    //   761: invokespecial 292	com/tencent/feedback/upload/f:a	(IIJJZLjava/lang/String;)V
    //   764: aload_1
    //   765: iload 7
    //   767: invokevirtual 394	com/tencent/feedback/upload/AbstractUploadDatas:done	(Z)V
    //   770: return
    //   771: astore 12
    //   773: goto +38 -> 811
    //   776: astore 12
    //   778: goto +28 -> 806
    //   781: astore 12
    //   783: lconst_0
    //   784: lstore 10
    //   786: goto +20 -> 806
    //   789: astore 12
    //   791: iconst_0
    //   792: istore 5
    //   794: goto +94 -> 888
    //   797: astore 12
    //   799: lconst_0
    //   800: lstore 8
    //   802: lload 8
    //   804: lstore 10
    //   806: iconst_m1
    //   807: istore_2
    //   808: iconst_0
    //   809: istore 5
    //   811: iload 5
    //   813: istore 6
    //   815: aload 12
    //   817: invokestatic 134	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   820: ifne +12 -> 832
    //   823: iload 5
    //   825: istore 6
    //   827: aload 12
    //   829: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   832: iload 5
    //   834: istore 6
    //   836: aload_0
    //   837: iload_3
    //   838: iload_2
    //   839: lload 8
    //   841: lload 10
    //   843: iconst_0
    //   844: aload 12
    //   846: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   849: invokespecial 292	com/tencent/feedback/upload/f:a	(IIJJZLjava/lang/String;)V
    //   852: iload 5
    //   854: istore 6
    //   856: ldc_w 397
    //   859: iconst_1
    //   860: anewarray 4	java/lang/Object
    //   863: dup
    //   864: iconst_0
    //   865: aload 12
    //   867: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   870: aastore
    //   871: invokestatic 131	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   874: pop
    //   875: aload_1
    //   876: iload 5
    //   878: invokevirtual 394	com/tencent/feedback/upload/AbstractUploadDatas:done	(Z)V
    //   881: return
    //   882: astore 12
    //   884: iload 6
    //   886: istore 5
    //   888: aload_1
    //   889: iload 5
    //   891: invokevirtual 394	com/tencent/feedback/upload/AbstractUploadDatas:done	(Z)V
    //   894: aload 12
    //   896: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	897	0	this	f
    //   0	897	1	paramAbstractUploadDatas	AbstractUploadDatas
    //   132	707	2	i	int
    //   114	724	3	j	int
    //   129	581	4	k	int
    //   10	880	5	bool1	boolean
    //   7	878	6	bool2	boolean
    //   4	762	7	bool3	boolean
    //   405	435	8	l1	long
    //   409	433	10	l2	long
    //   119	266	12	localObject1	Object
    //   402	39	12	localThrowable1	Throwable
    //   445	14	12	localO	O
    //   515	1	12	localObject2	Object
    //   520	1	12	localThrowable2	Throwable
    //   525	1	12	localThrowable3	Throwable
    //   530	152	12	localThrowable4	Throwable
    //   733	1	12	localObject3	Object
    //   738	1	12	localThrowable5	Throwable
    //   771	1	12	localThrowable6	Throwable
    //   776	1	12	localThrowable7	Throwable
    //   781	1	12	localThrowable8	Throwable
    //   789	1	12	localObject4	Object
    //   797	69	12	localThrowable9	Throwable
    //   882	13	12	localObject5	Object
    //   228	484	13	localObject6	Object
    //   263	445	14	localObject7	Object
    //   310	68	15	localHashMap	java.util.HashMap
    //   301	132	16	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   389	399	402	java/lang/Throwable
    //   479	512	515	finally
    //   479	512	520	java/lang/Throwable
    //   458	465	525	java/lang/Throwable
    //   452	458	530	java/lang/Throwable
    //   552	561	733	finally
    //   566	631	733	finally
    //   631	638	733	finally
    //   643	654	733	finally
    //   657	663	733	finally
    //   668	678	733	finally
    //   681	688	733	finally
    //   693	704	733	finally
    //   707	716	733	finally
    //   719	730	733	finally
    //   552	561	738	java/lang/Throwable
    //   566	631	738	java/lang/Throwable
    //   631	638	738	java/lang/Throwable
    //   643	654	738	java/lang/Throwable
    //   657	663	738	java/lang/Throwable
    //   668	678	738	java/lang/Throwable
    //   681	688	738	java/lang/Throwable
    //   693	704	738	java/lang/Throwable
    //   707	716	738	java/lang/Throwable
    //   719	730	738	java/lang/Throwable
    //   751	764	771	java/lang/Throwable
    //   439	447	776	java/lang/Throwable
    //   432	439	781	java/lang/Throwable
    //   360	384	789	finally
    //   389	399	789	finally
    //   420	425	789	finally
    //   425	432	789	finally
    //   432	439	789	finally
    //   439	447	789	finally
    //   452	458	789	finally
    //   458	465	789	finally
    //   360	384	797	java/lang/Throwable
    //   420	425	797	java/lang/Throwable
    //   425	432	797	java/lang/Throwable
    //   751	764	882	finally
    //   815	823	882	finally
    //   827	832	882	finally
    //   836	852	882	finally
    //   856	875	882	finally
  }
  
  public final boolean a(UploadHandleListener paramUploadHandleListener)
  {
    if (paramUploadHandleListener == null) {
      return false;
    }
    try
    {
      if (!this.c.contains(paramUploadHandleListener)) {
        this.c.add(paramUploadHandleListener);
      }
      return true;
    }
    finally
    {
      paramUploadHandleListener = finally;
      throw paramUploadHandleListener;
    }
  }
  
  public final boolean a(d paramd)
  {
    if (paramd == null) {
      return false;
    }
    try
    {
      if (!this.b.contains(paramd)) {
        this.b.add(paramd);
      }
      return true;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.f
 * JD-Core Version:    0.7.0.1
 */