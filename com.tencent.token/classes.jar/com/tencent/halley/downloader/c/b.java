package com.tencent.halley.downloader.c;

import android.os.Handler;
import com.tencent.halley.common.f;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  private e a;
  private volatile DownloaderTaskStatus b = DownloaderTaskStatus.PENDING;
  private Vector c = new Vector();
  private Vector d = new Vector();
  private int e = 0;
  private volatile boolean f = false;
  private LinkedBlockingQueue g = new LinkedBlockingQueue();
  
  public b(e parame)
  {
    this.a = parame;
  }
  
  private void a(DownloaderTaskStatus paramDownloaderTaskStatus, boolean paramBoolean)
  {
    for (;;)
    {
      DownloaderTaskStatus localDownloaderTaskStatus;
      try
      {
        if ((this.b == DownloaderTaskStatus.COMPLETE) || (this.b == DownloaderTaskStatus.FAILED) || (this.b == DownloaderTaskStatus.PAUSED) || (this.b == DownloaderTaskStatus.DELETED))
        {
          localDownloaderTaskStatus = DownloaderTaskStatus.PENDING;
          if (paramDownloaderTaskStatus != localDownloaderTaskStatus) {
            return;
          }
        }
        this.b = paramDownloaderTaskStatus;
        localDownloaderTaskStatus = null;
        switch (1.a[paramDownloaderTaskStatus.ordinal()])
        {
        case 1: 
          a(paramDownloaderTaskStatus);
          continue;
          paramDownloaderTaskStatus = a.a;
        }
      }
      finally {}
      continue;
      paramDownloaderTaskStatus = a.b;
      continue;
      paramDownloaderTaskStatus = a.d;
      continue;
      paramDownloaderTaskStatus = a.g;
      continue;
      paramDownloaderTaskStatus = a.f;
      continue;
      paramDownloaderTaskStatus = a.e;
      continue;
      paramDownloaderTaskStatus = a.h;
      continue;
      paramDownloaderTaskStatus = localDownloaderTaskStatus;
    }
  }
  
  public final DownloaderTaskStatus a()
  {
    return this.b;
  }
  
  public final void a(DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    try
    {
      com.tencent.halley.common.b.b("StatusInformer", "updateTaskStatus:" + paramDownloaderTaskStatus.name());
      a(paramDownloaderTaskStatus, true);
      return;
    }
    finally
    {
      paramDownloaderTaskStatus = finally;
      throw paramDownloaderTaskStatus;
    }
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      if ((parama != null) && (parama != a.h)) {
        break label28;
      }
    }
    for (;;)
    {
      if (parama != null) {}
      try
      {
        this.g.put(parama);
        return;
      }
      catch (InterruptedException parama)
      {
        label28:
        c localc;
        parama.printStackTrace();
      }
      localc = new c(this, parama);
      f.h().post(localc);
    }
  }
  
  public final void a(com.tencent.halley.downloader.c paramc)
  {
    if (paramc == null) {
      return;
    }
    try
    {
      synchronized (this.c)
      {
        if (!this.c.contains(paramc)) {
          this.c.add(paramc);
        }
        synchronized (this.d)
        {
          if (!this.d.contains(paramc)) {
            this.d.add(paramc);
          }
          return;
        }
      }
      return;
    }
    catch (Throwable paramc) {}
  }
  
  public final void b()
  {
    try
    {
      this.g.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 44	com/tencent/halley/downloader/c/b:f	Z
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore 9
    //   13: aload_0
    //   14: getfield 49	com/tencent/halley/downloader/c/b:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   17: invokevirtual 164	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   20: checkcast 8	com/tencent/halley/downloader/c/b$a
    //   23: astore 7
    //   25: getstatic 166	com/tencent/halley/downloader/c/b$1:b	[I
    //   28: aload 7
    //   30: invokevirtual 167	com/tencent/halley/downloader/c/b$a:ordinal	()I
    //   33: iaload
    //   34: istore_1
    //   35: iload_1
    //   36: tableswitch	default:+48 -> 84, 1:+83->119, 2:+88->124, 3:+212->248, 4:+331->367, 5:+416->452, 6:+508->544, 7:+600->636, 8:+762->798
    //   85: istore_1
    //   86: iload_1
    //   87: ifeq -80 -> 7
    //   90: ldc 169
    //   92: new 99	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 171
    //   98: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload 7
    //   103: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 180	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: aload_0
    //   114: iconst_0
    //   115: putfield 44	com/tencent/halley/downloader/c/b:f	Z
    //   118: return
    //   119: iconst_0
    //   120: istore_1
    //   121: goto -35 -> 86
    //   124: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   127: aload_0
    //   128: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   131: invokevirtual 188	com/tencent/token/x:h	(Lcom/tencent/halley/downloader/b;)V
    //   134: aload_0
    //   135: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   138: astore 8
    //   140: aload 8
    //   142: monitorenter
    //   143: aload_0
    //   144: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   147: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   150: astore 9
    //   152: aload 9
    //   154: invokeinterface 198 1 0
    //   159: ifeq +81 -> 240
    //   162: aload 9
    //   164: invokeinterface 201 1 0
    //   169: checkcast 203	com/tencent/halley/downloader/c
    //   172: astore 10
    //   174: aload 10
    //   176: ifnull -24 -> 152
    //   179: aload 10
    //   181: aload_0
    //   182: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   185: invokeinterface 204 2 0
    //   190: goto -38 -> 152
    //   193: astore 9
    //   195: aload 8
    //   197: monitorexit
    //   198: aload 9
    //   200: athrow
    //   201: astore 8
    //   203: iconst_0
    //   204: istore_1
    //   205: aload 8
    //   207: invokevirtual 147	java/lang/InterruptedException:printStackTrace	()V
    //   210: iload_1
    //   211: ifeq -204 -> 7
    //   214: ldc 169
    //   216: new 99	java/lang/StringBuilder
    //   219: dup
    //   220: ldc 171
    //   222: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   225: aload 7
    //   227: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 180	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   236: pop
    //   237: goto -124 -> 113
    //   240: aload 8
    //   242: monitorexit
    //   243: iconst_0
    //   244: istore_1
    //   245: goto -159 -> 86
    //   248: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   251: aload_0
    //   252: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   255: invokevirtual 207	com/tencent/token/x:i	(Lcom/tencent/halley/downloader/b;)V
    //   258: aload_0
    //   259: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   262: astore 8
    //   264: aload 8
    //   266: monitorenter
    //   267: aload_0
    //   268: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   271: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   274: astore 9
    //   276: aload 9
    //   278: invokeinterface 198 1 0
    //   283: ifeq +76 -> 359
    //   286: aload 9
    //   288: invokeinterface 201 1 0
    //   293: checkcast 203	com/tencent/halley/downloader/c
    //   296: astore 10
    //   298: aload 10
    //   300: ifnull -24 -> 276
    //   303: aload 10
    //   305: aload_0
    //   306: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   309: invokeinterface 208 2 0
    //   314: goto -38 -> 276
    //   317: astore 9
    //   319: aload 8
    //   321: monitorexit
    //   322: aload 9
    //   324: athrow
    //   325: astore 8
    //   327: iconst_0
    //   328: istore_1
    //   329: iload_1
    //   330: ifeq +473 -> 803
    //   333: ldc 169
    //   335: new 99	java/lang/StringBuilder
    //   338: dup
    //   339: ldc 171
    //   341: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: aload 7
    //   346: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 180	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: goto -243 -> 113
    //   359: aload 8
    //   361: monitorexit
    //   362: iconst_0
    //   363: istore_1
    //   364: goto -278 -> 86
    //   367: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   370: aload_0
    //   371: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   374: invokevirtual 211	com/tencent/token/x:j	(Lcom/tencent/halley/downloader/b;)V
    //   377: aload_0
    //   378: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   381: astore 8
    //   383: aload 8
    //   385: monitorenter
    //   386: aload_0
    //   387: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   390: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   393: astore 9
    //   395: aload 9
    //   397: invokeinterface 198 1 0
    //   402: ifeq +42 -> 444
    //   405: aload 9
    //   407: invokeinterface 201 1 0
    //   412: checkcast 203	com/tencent/halley/downloader/c
    //   415: astore 10
    //   417: aload 10
    //   419: ifnull -24 -> 395
    //   422: aload 10
    //   424: aload_0
    //   425: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   428: invokeinterface 212 2 0
    //   433: goto -38 -> 395
    //   436: astore 9
    //   438: aload 8
    //   440: monitorexit
    //   441: aload 9
    //   443: athrow
    //   444: aload 8
    //   446: monitorexit
    //   447: iconst_0
    //   448: istore_1
    //   449: goto -363 -> 86
    //   452: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   455: aload_0
    //   456: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   459: invokevirtual 215	com/tencent/token/x:k	(Lcom/tencent/halley/downloader/b;)V
    //   462: aload_0
    //   463: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   466: astore 8
    //   468: aload 8
    //   470: monitorenter
    //   471: aload_0
    //   472: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   475: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   478: astore 9
    //   480: aload 9
    //   482: invokeinterface 198 1 0
    //   487: ifeq +49 -> 536
    //   490: aload 9
    //   492: invokeinterface 201 1 0
    //   497: checkcast 203	com/tencent/halley/downloader/c
    //   500: astore 10
    //   502: aload 10
    //   504: ifnull -24 -> 480
    //   507: aload 10
    //   509: aload_0
    //   510: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   513: invokeinterface 216 2 0
    //   518: goto -38 -> 480
    //   521: astore 9
    //   523: aload 8
    //   525: monitorexit
    //   526: aload 9
    //   528: athrow
    //   529: astore 8
    //   531: iconst_1
    //   532: istore_1
    //   533: goto -328 -> 205
    //   536: aload 8
    //   538: monitorexit
    //   539: iconst_1
    //   540: istore_1
    //   541: goto -455 -> 86
    //   544: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   547: aload_0
    //   548: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   551: invokevirtual 219	com/tencent/token/x:l	(Lcom/tencent/halley/downloader/b;)V
    //   554: aload_0
    //   555: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   558: astore 8
    //   560: aload 8
    //   562: monitorenter
    //   563: aload_0
    //   564: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   567: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   570: astore 9
    //   572: aload 9
    //   574: invokeinterface 198 1 0
    //   579: ifeq +49 -> 628
    //   582: aload 9
    //   584: invokeinterface 201 1 0
    //   589: checkcast 203	com/tencent/halley/downloader/c
    //   592: astore 10
    //   594: aload 10
    //   596: ifnull -24 -> 572
    //   599: aload 10
    //   601: aload_0
    //   602: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   605: invokeinterface 220 2 0
    //   610: goto -38 -> 572
    //   613: astore 9
    //   615: aload 8
    //   617: monitorexit
    //   618: aload 9
    //   620: athrow
    //   621: astore 8
    //   623: iload_2
    //   624: istore_1
    //   625: goto -296 -> 329
    //   628: aload 8
    //   630: monitorexit
    //   631: iconst_1
    //   632: istore_1
    //   633: goto -547 -> 86
    //   636: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   639: lstore_3
    //   640: aload_0
    //   641: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   644: astore 8
    //   646: aload 8
    //   648: monitorenter
    //   649: aload_0
    //   650: getfield 38	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   653: invokevirtual 192	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   656: astore 9
    //   658: aload 9
    //   660: invokeinterface 198 1 0
    //   665: ifeq +42 -> 707
    //   668: aload 9
    //   670: invokeinterface 201 1 0
    //   675: checkcast 203	com/tencent/halley/downloader/c
    //   678: astore 10
    //   680: aload 10
    //   682: ifnull -24 -> 658
    //   685: aload 10
    //   687: aload_0
    //   688: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   691: invokeinterface 229 2 0
    //   696: goto -38 -> 658
    //   699: astore 9
    //   701: aload 8
    //   703: monitorexit
    //   704: aload 9
    //   706: athrow
    //   707: aload 8
    //   709: monitorexit
    //   710: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   713: lstore 5
    //   715: aload_0
    //   716: lload 5
    //   718: lload_3
    //   719: lsub
    //   720: l2i
    //   721: putfield 42	com/tencent/halley/downloader/c/b:e	I
    //   724: aload_0
    //   725: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   728: invokevirtual 234	com/tencent/halley/downloader/c/e:N	()V
    //   731: invokestatic 226	android/os/SystemClock:elapsedRealtime	()J
    //   734: lload 5
    //   736: lsub
    //   737: lstore_3
    //   738: ldc 97
    //   740: new 99	java/lang/StringBuilder
    //   743: dup
    //   744: ldc 236
    //   746: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   749: lload_3
    //   750: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   753: ldc 241
    //   755: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_0
    //   759: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   762: invokevirtual 244	com/tencent/halley/downloader/c/e:a_	()J
    //   765: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   768: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 246	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: aload_0
    //   775: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   778: lload_3
    //   779: l2i
    //   780: putfield 249	com/tencent/halley/downloader/c/e:E	I
    //   783: invokestatic 185	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   786: aload_0
    //   787: getfield 51	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   790: invokevirtual 250	com/tencent/token/x:m	(Lcom/tencent/halley/downloader/b;)V
    //   793: iconst_1
    //   794: istore_1
    //   795: goto -709 -> 86
    //   798: iconst_1
    //   799: istore_1
    //   800: goto -714 -> 86
    //   803: aload 8
    //   805: athrow
    //   806: astore 8
    //   808: iconst_0
    //   809: istore_1
    //   810: aload 10
    //   812: astore 7
    //   814: goto -485 -> 329
    //   817: astore 8
    //   819: goto -490 -> 329
    //   822: astore 8
    //   824: iconst_0
    //   825: istore_1
    //   826: aload 9
    //   828: astore 7
    //   830: goto -625 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	b
    //   34	792	1	i	int
    //   1	623	2	j	int
    //   639	140	3	l1	long
    //   713	22	5	l2	long
    //   23	806	7	localObject1	Object
    //   138	58	8	localVector1	Vector
    //   201	40	8	localInterruptedException1	InterruptedException
    //   325	35	8	localObject2	Object
    //   529	8	8	localInterruptedException2	InterruptedException
    //   621	8	8	localObject3	Object
    //   806	1	8	localObject4	Object
    //   817	1	8	localObject5	Object
    //   822	1	8	localInterruptedException3	InterruptedException
    //   11	152	9	localIterator1	java.util.Iterator
    //   193	6	9	localObject6	Object
    //   274	13	9	localIterator2	java.util.Iterator
    //   317	6	9	localObject7	Object
    //   393	13	9	localIterator3	java.util.Iterator
    //   436	6	9	localObject8	Object
    //   478	13	9	localIterator4	java.util.Iterator
    //   521	6	9	localObject9	Object
    //   570	13	9	localIterator5	java.util.Iterator
    //   613	6	9	localObject10	Object
    //   656	13	9	localIterator6	java.util.Iterator
    //   699	128	9	localObject11	Object
    //   8	803	10	localc	com.tencent.halley.downloader.c
    // Exception table:
    //   from	to	target	type
    //   143	152	193	finally
    //   152	174	193	finally
    //   179	190	193	finally
    //   240	243	193	finally
    //   25	35	201	java/lang/InterruptedException
    //   124	143	201	java/lang/InterruptedException
    //   195	201	201	java/lang/InterruptedException
    //   248	267	201	java/lang/InterruptedException
    //   319	325	201	java/lang/InterruptedException
    //   367	386	201	java/lang/InterruptedException
    //   438	444	201	java/lang/InterruptedException
    //   267	276	317	finally
    //   276	298	317	finally
    //   303	314	317	finally
    //   359	362	317	finally
    //   25	35	325	finally
    //   124	143	325	finally
    //   195	201	325	finally
    //   248	267	325	finally
    //   319	325	325	finally
    //   367	386	325	finally
    //   438	444	325	finally
    //   386	395	436	finally
    //   395	417	436	finally
    //   422	433	436	finally
    //   444	447	436	finally
    //   471	480	521	finally
    //   480	502	521	finally
    //   507	518	521	finally
    //   536	539	521	finally
    //   452	471	529	java/lang/InterruptedException
    //   523	529	529	java/lang/InterruptedException
    //   544	563	529	java/lang/InterruptedException
    //   615	621	529	java/lang/InterruptedException
    //   636	649	529	java/lang/InterruptedException
    //   701	707	529	java/lang/InterruptedException
    //   710	793	529	java/lang/InterruptedException
    //   563	572	613	finally
    //   572	594	613	finally
    //   599	610	613	finally
    //   628	631	613	finally
    //   452	471	621	finally
    //   523	529	621	finally
    //   544	563	621	finally
    //   615	621	621	finally
    //   636	649	621	finally
    //   701	707	621	finally
    //   710	793	621	finally
    //   649	658	699	finally
    //   658	680	699	finally
    //   685	696	699	finally
    //   707	710	699	finally
    //   13	25	806	finally
    //   205	210	817	finally
    //   13	25	822	java/lang/InterruptedException
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public static enum a
  {
    public static a[] a()
    {
      return (a[])i.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.c.b
 * JD-Core Version:    0.7.0.1
 */