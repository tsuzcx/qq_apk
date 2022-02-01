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
        switch (b.1.a[paramDownloaderTaskStatus.ordinal()])
        {
        case 7: 
          paramDownloaderTaskStatus = a.h;
          break;
        case 6: 
          paramDownloaderTaskStatus = a.e;
          break;
        case 5: 
          paramDownloaderTaskStatus = a.f;
          break;
        case 4: 
          paramDownloaderTaskStatus = a.g;
          break;
        case 3: 
          paramDownloaderTaskStatus = a.d;
          break;
        case 2: 
          paramDownloaderTaskStatus = a.b;
          break;
        case 1: 
          paramDownloaderTaskStatus = a.a;
          a(paramDownloaderTaskStatus);
          return;
        }
      }
      finally {}
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
      StringBuilder localStringBuilder = new StringBuilder("updateTaskStatus:");
      localStringBuilder.append(paramDownloaderTaskStatus.name());
      com.tencent.halley.common.b.b("StatusInformer", localStringBuilder.toString());
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
    if (parama != null)
    {
      if ((parama != null) && (parama != a.h))
      {
        c localc = new c(this, parama);
        f.h().post(localc);
      }
      if (parama != null) {
        try
        {
          this.g.put(parama);
          return;
        }
        catch (InterruptedException parama)
        {
          parama.printStackTrace();
        }
      }
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
    //   4: putfield 42	com/tencent/halley/downloader/c/b:f	Z
    //   7: aload_0
    //   8: getfield 47	com/tencent/halley/downloader/c/b:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   11: invokevirtual 164	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   14: checkcast 6	com/tencent/halley/downloader/c/b$a
    //   17: astore 7
    //   19: getstatic 166	com/tencent/halley/downloader/c/b$1:b	[I
    //   22: aload 7
    //   24: invokevirtual 167	com/tencent/halley/downloader/c/b$a:ordinal	()I
    //   27: iaload
    //   28: istore_1
    //   29: iload_1
    //   30: tableswitch	default:+46 -> 76, 1:+656->686, 2:+573->603, 3:+490->520, 4:+407->437, 5:+310->340, 6:+227->257, 7:+54->84, 8:+49->79
    //   77: iconst_m1
    //   78: fadd
    //   79: iconst_1
    //   80: istore_1
    //   81: goto +607 -> 688
    //   84: invokestatic 173	android/os/SystemClock:elapsedRealtime	()J
    //   87: lstore_3
    //   88: aload_0
    //   89: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   92: astore 8
    //   94: aload 8
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   101: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   104: astore 9
    //   106: aload 9
    //   108: invokeinterface 183 1 0
    //   113: ifeq +34 -> 147
    //   116: aload 9
    //   118: invokeinterface 186 1 0
    //   123: checkcast 188	com/tencent/halley/downloader/c
    //   126: astore 10
    //   128: aload 10
    //   130: ifnull -24 -> 106
    //   133: aload 10
    //   135: aload_0
    //   136: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   139: invokeinterface 192 2 0
    //   144: goto -38 -> 106
    //   147: aload 8
    //   149: monitorexit
    //   150: invokestatic 173	android/os/SystemClock:elapsedRealtime	()J
    //   153: lstore 5
    //   155: aload_0
    //   156: lload 5
    //   158: lload_3
    //   159: lsub
    //   160: l2i
    //   161: putfield 40	com/tencent/halley/downloader/c/b:e	I
    //   164: aload_0
    //   165: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   168: invokevirtual 197	com/tencent/halley/downloader/c/e:N	()V
    //   171: invokestatic 173	android/os/SystemClock:elapsedRealtime	()J
    //   174: lload 5
    //   176: lsub
    //   177: lstore_3
    //   178: new 97	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 199
    //   184: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: astore 8
    //   189: aload 8
    //   191: lload_3
    //   192: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 8
    //   198: ldc 204
    //   200: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 8
    //   206: aload_0
    //   207: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   210: invokevirtual 207	com/tencent/halley/downloader/c/e:a_	()J
    //   213: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: ldc 112
    //   219: aload 8
    //   221: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 209	com/tencent/halley/common/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   231: lload_3
    //   232: l2i
    //   233: putfield 212	com/tencent/halley/downloader/c/e:E	I
    //   236: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   239: aload_0
    //   240: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   243: invokevirtual 218	com/tencent/token/x:m	(Lcom/tencent/halley/downloader/b;)V
    //   246: goto -167 -> 79
    //   249: astore 9
    //   251: aload 8
    //   253: monitorexit
    //   254: aload 9
    //   256: athrow
    //   257: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   260: aload_0
    //   261: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   264: invokevirtual 221	com/tencent/token/x:l	(Lcom/tencent/halley/downloader/b;)V
    //   267: aload_0
    //   268: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   271: astore 8
    //   273: aload 8
    //   275: monitorenter
    //   276: aload_0
    //   277: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   280: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   283: astore 9
    //   285: aload 9
    //   287: invokeinterface 183 1 0
    //   292: ifeq +34 -> 326
    //   295: aload 9
    //   297: invokeinterface 186 1 0
    //   302: checkcast 188	com/tencent/halley/downloader/c
    //   305: astore 10
    //   307: aload 10
    //   309: ifnull -24 -> 285
    //   312: aload 10
    //   314: aload_0
    //   315: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   318: invokeinterface 222 2 0
    //   323: goto -38 -> 285
    //   326: aload 8
    //   328: monitorexit
    //   329: goto -250 -> 79
    //   332: astore 9
    //   334: aload 8
    //   336: monitorexit
    //   337: aload 9
    //   339: athrow
    //   340: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   343: aload_0
    //   344: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   347: invokevirtual 225	com/tencent/token/x:k	(Lcom/tencent/halley/downloader/b;)V
    //   350: aload_0
    //   351: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   354: astore 8
    //   356: aload 8
    //   358: monitorenter
    //   359: aload_0
    //   360: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   363: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   366: astore 9
    //   368: aload 9
    //   370: invokeinterface 183 1 0
    //   375: ifeq +34 -> 409
    //   378: aload 9
    //   380: invokeinterface 186 1 0
    //   385: checkcast 188	com/tencent/halley/downloader/c
    //   388: astore 10
    //   390: aload 10
    //   392: ifnull -24 -> 368
    //   395: aload 10
    //   397: aload_0
    //   398: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   401: invokeinterface 226 2 0
    //   406: goto -38 -> 368
    //   409: aload 8
    //   411: monitorexit
    //   412: goto -333 -> 79
    //   415: astore 9
    //   417: aload 8
    //   419: monitorexit
    //   420: aload 9
    //   422: athrow
    //   423: astore 8
    //   425: iload_2
    //   426: istore_1
    //   427: goto +339 -> 766
    //   430: astore 8
    //   432: iconst_1
    //   433: istore_1
    //   434: goto +299 -> 733
    //   437: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   440: aload_0
    //   441: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   444: invokevirtual 229	com/tencent/token/x:j	(Lcom/tencent/halley/downloader/b;)V
    //   447: aload_0
    //   448: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   451: astore 8
    //   453: aload 8
    //   455: monitorenter
    //   456: aload_0
    //   457: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   460: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   463: astore 9
    //   465: aload 9
    //   467: invokeinterface 183 1 0
    //   472: ifeq +34 -> 506
    //   475: aload 9
    //   477: invokeinterface 186 1 0
    //   482: checkcast 188	com/tencent/halley/downloader/c
    //   485: astore 10
    //   487: aload 10
    //   489: ifnull -24 -> 465
    //   492: aload 10
    //   494: aload_0
    //   495: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   498: invokeinterface 230 2 0
    //   503: goto -38 -> 465
    //   506: aload 8
    //   508: monitorexit
    //   509: goto +177 -> 686
    //   512: astore 9
    //   514: aload 8
    //   516: monitorexit
    //   517: aload 9
    //   519: athrow
    //   520: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   523: aload_0
    //   524: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   527: invokevirtual 233	com/tencent/token/x:i	(Lcom/tencent/halley/downloader/b;)V
    //   530: aload_0
    //   531: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   534: astore 8
    //   536: aload 8
    //   538: monitorenter
    //   539: aload_0
    //   540: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   543: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   546: astore 9
    //   548: aload 9
    //   550: invokeinterface 183 1 0
    //   555: ifeq +34 -> 589
    //   558: aload 9
    //   560: invokeinterface 186 1 0
    //   565: checkcast 188	com/tencent/halley/downloader/c
    //   568: astore 10
    //   570: aload 10
    //   572: ifnull -24 -> 548
    //   575: aload 10
    //   577: aload_0
    //   578: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   581: invokeinterface 234 2 0
    //   586: goto -38 -> 548
    //   589: aload 8
    //   591: monitorexit
    //   592: goto +94 -> 686
    //   595: astore 9
    //   597: aload 8
    //   599: monitorexit
    //   600: aload 9
    //   602: athrow
    //   603: invokestatic 217	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   606: aload_0
    //   607: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   610: invokevirtual 236	com/tencent/token/x:h	(Lcom/tencent/halley/downloader/b;)V
    //   613: aload_0
    //   614: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   617: astore 8
    //   619: aload 8
    //   621: monitorenter
    //   622: aload_0
    //   623: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   626: invokevirtual 177	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   629: astore 9
    //   631: aload 9
    //   633: invokeinterface 183 1 0
    //   638: ifeq +34 -> 672
    //   641: aload 9
    //   643: invokeinterface 186 1 0
    //   648: checkcast 188	com/tencent/halley/downloader/c
    //   651: astore 10
    //   653: aload 10
    //   655: ifnull -24 -> 631
    //   658: aload 10
    //   660: aload_0
    //   661: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/halley/downloader/c/e;
    //   664: invokeinterface 237 2 0
    //   669: goto -38 -> 631
    //   672: aload 8
    //   674: monitorexit
    //   675: goto +11 -> 686
    //   678: astore 9
    //   680: aload 8
    //   682: monitorexit
    //   683: aload 9
    //   685: athrow
    //   686: iconst_0
    //   687: istore_1
    //   688: iload_1
    //   689: ifeq -682 -> 7
    //   692: new 97	java/lang/StringBuilder
    //   695: dup
    //   696: ldc 239
    //   698: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   701: astore 8
    //   703: goto +78 -> 781
    //   706: astore 8
    //   708: goto +13 -> 721
    //   711: astore 8
    //   713: goto +18 -> 731
    //   716: astore 8
    //   718: aconst_null
    //   719: astore 7
    //   721: iconst_0
    //   722: istore_1
    //   723: goto +43 -> 766
    //   726: astore 8
    //   728: aconst_null
    //   729: astore 7
    //   731: iconst_0
    //   732: istore_1
    //   733: aload 8
    //   735: invokevirtual 147	java/lang/InterruptedException:printStackTrace	()V
    //   738: iload_1
    //   739: ifeq -732 -> 7
    //   742: new 97	java/lang/StringBuilder
    //   745: dup
    //   746: ldc 239
    //   748: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   751: astore 8
    //   753: aload 8
    //   755: aload 7
    //   757: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: goto +28 -> 789
    //   764: astore 8
    //   766: iload_1
    //   767: ifeq +39 -> 806
    //   770: new 97	java/lang/StringBuilder
    //   773: dup
    //   774: ldc 239
    //   776: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: astore 8
    //   781: aload 8
    //   783: aload 7
    //   785: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: ldc 244
    //   791: aload 8
    //   793: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 250	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   799: pop
    //   800: aload_0
    //   801: iconst_0
    //   802: putfield 42	com/tencent/halley/downloader/c/b:f	Z
    //   805: return
    //   806: aload 8
    //   808: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	b
    //   28	739	1	i	int
    //   1	425	2	j	int
    //   87	145	3	l1	long
    //   153	22	5	l2	long
    //   17	767	7	locala	a
    //   92	326	8	localObject1	Object
    //   423	1	8	localObject2	Object
    //   430	1	8	localInterruptedException1	InterruptedException
    //   451	251	8	localObject3	Object
    //   706	1	8	localObject4	Object
    //   711	1	8	localInterruptedException2	InterruptedException
    //   716	1	8	localObject5	Object
    //   726	8	8	localInterruptedException3	InterruptedException
    //   751	3	8	localStringBuilder1	StringBuilder
    //   764	1	8	localObject6	Object
    //   779	28	8	localStringBuilder2	StringBuilder
    //   104	13	9	localIterator1	java.util.Iterator
    //   249	6	9	localObject7	Object
    //   283	13	9	localIterator2	java.util.Iterator
    //   332	6	9	localObject8	Object
    //   366	13	9	localIterator3	java.util.Iterator
    //   415	6	9	localObject9	Object
    //   463	13	9	localIterator4	java.util.Iterator
    //   512	6	9	localObject10	Object
    //   546	13	9	localIterator5	java.util.Iterator
    //   595	6	9	localObject11	Object
    //   629	13	9	localIterator6	java.util.Iterator
    //   678	6	9	localObject12	Object
    //   126	533	10	localc	com.tencent.halley.downloader.c
    // Exception table:
    //   from	to	target	type
    //   97	106	249	finally
    //   106	128	249	finally
    //   133	144	249	finally
    //   147	150	249	finally
    //   276	285	332	finally
    //   285	307	332	finally
    //   312	323	332	finally
    //   326	329	332	finally
    //   359	368	415	finally
    //   368	390	415	finally
    //   395	406	415	finally
    //   409	412	415	finally
    //   84	97	423	finally
    //   150	246	423	finally
    //   251	257	423	finally
    //   257	276	423	finally
    //   334	340	423	finally
    //   340	359	423	finally
    //   417	423	423	finally
    //   84	97	430	java/lang/InterruptedException
    //   150	246	430	java/lang/InterruptedException
    //   251	257	430	java/lang/InterruptedException
    //   257	276	430	java/lang/InterruptedException
    //   334	340	430	java/lang/InterruptedException
    //   340	359	430	java/lang/InterruptedException
    //   417	423	430	java/lang/InterruptedException
    //   456	465	512	finally
    //   465	487	512	finally
    //   492	503	512	finally
    //   506	509	512	finally
    //   539	548	595	finally
    //   548	570	595	finally
    //   575	586	595	finally
    //   589	592	595	finally
    //   622	631	678	finally
    //   631	653	678	finally
    //   658	669	678	finally
    //   672	675	678	finally
    //   19	29	706	finally
    //   437	456	706	finally
    //   514	520	706	finally
    //   520	539	706	finally
    //   597	603	706	finally
    //   603	622	706	finally
    //   680	686	706	finally
    //   19	29	711	java/lang/InterruptedException
    //   437	456	711	java/lang/InterruptedException
    //   514	520	711	java/lang/InterruptedException
    //   520	539	711	java/lang/InterruptedException
    //   597	603	711	java/lang/InterruptedException
    //   603	622	711	java/lang/InterruptedException
    //   680	686	711	java/lang/InterruptedException
    //   7	19	716	finally
    //   7	19	726	java/lang/InterruptedException
    //   733	738	764	finally
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