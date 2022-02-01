package com.tencent.halley.downloader.c;

import android.os.Handler;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.token.lo;
import com.tencent.token.lv;
import com.tencent.token.mm;
import com.tencent.token.mr;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
{
  public mr a;
  public volatile DownloaderTaskStatus b = DownloaderTaskStatus.PENDING;
  public Vector c = new Vector();
  public Vector d = new Vector();
  public int e = 0;
  public volatile boolean f = false;
  private LinkedBlockingQueue g = new LinkedBlockingQueue();
  
  public b(mr parammr)
  {
    this.a = parammr;
  }
  
  private void b(DownloaderTaskStatus paramDownloaderTaskStatus)
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
  
  public final void a()
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
  
  public final void a(DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("updateTaskStatus:");
      localStringBuilder.append(paramDownloaderTaskStatus.name());
      lo.b("StatusInformer", localStringBuilder.toString());
      b(paramDownloaderTaskStatus);
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
        mm localmm = new mm(this, parama);
        lv.h().post(localmm);
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
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 42	com/tencent/halley/downloader/c/b:f	Z
    //   7: aload_0
    //   8: getfield 47	com/tencent/halley/downloader/c/b:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   11: invokevirtual 152	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   14: checkcast 6	com/tencent/halley/downloader/c/b$a
    //   17: astore 8
    //   19: getstatic 154	com/tencent/halley/downloader/c/b$1:b	[I
    //   22: aload 8
    //   24: invokevirtual 155	com/tencent/halley/downloader/c/b$a:ordinal	()I
    //   27: iaload
    //   28: istore_1
    //   29: iload_1
    //   30: tableswitch	default:+46 -> 76, 1:+662->692, 2:+605->635, 3:+548->578, 4:+471->501, 5:+368->398, 6:+285->315, 7:+54->84, 8:+49->79
    //   77: iconst_m1
    //   78: imul
    //   79: iconst_1
    //   80: istore_1
    //   81: goto +613 -> 694
    //   84: invokestatic 161	android/os/SystemClock:elapsedRealtime	()J
    //   87: lstore_3
    //   88: aload_0
    //   89: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   92: astore 9
    //   94: aload 9
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   101: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   104: astore 10
    //   106: aload 10
    //   108: invokeinterface 171 1 0
    //   113: ifeq +34 -> 147
    //   116: aload 10
    //   118: invokeinterface 174 1 0
    //   123: checkcast 176	com/tencent/token/ma
    //   126: astore 11
    //   128: aload 11
    //   130: ifnull -24 -> 106
    //   133: aload 11
    //   135: aload_0
    //   136: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   139: invokeinterface 180 2 0
    //   144: goto -38 -> 106
    //   147: aload 9
    //   149: monitorexit
    //   150: invokestatic 161	android/os/SystemClock:elapsedRealtime	()J
    //   153: lstore 5
    //   155: aload_0
    //   156: lload 5
    //   158: lload_3
    //   159: lsub
    //   160: l2i
    //   161: putfield 40	com/tencent/halley/downloader/c/b:e	I
    //   164: aload_0
    //   165: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   168: astore 9
    //   170: aload 9
    //   172: getfield 185	com/tencent/token/mr:M	Z
    //   175: ifeq +54 -> 229
    //   178: new 187	java/io/File
    //   181: dup
    //   182: aload 9
    //   184: getfield 191	com/tencent/token/mr:j	Ljava/lang/String;
    //   187: aload 9
    //   189: getfield 194	com/tencent/token/mr:l	Ljava/lang/String;
    //   192: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: astore 10
    //   197: aload 10
    //   199: invokevirtual 199	java/io/File:exists	()Z
    //   202: istore 7
    //   204: iload 7
    //   206: ifeq +23 -> 229
    //   209: aload 9
    //   211: aload 10
    //   213: invokestatic 204	com/tencent/token/ls:a	(Ljava/io/File;)Ljava/lang/String;
    //   216: putfield 207	com/tencent/token/mr:N	Ljava/lang/String;
    //   219: goto +10 -> 229
    //   222: astore 9
    //   224: aload 9
    //   226: invokevirtual 208	java/lang/Throwable:printStackTrace	()V
    //   229: invokestatic 161	android/os/SystemClock:elapsedRealtime	()J
    //   232: lload 5
    //   234: lsub
    //   235: lstore_3
    //   236: new 96	java/lang/StringBuilder
    //   239: dup
    //   240: ldc 210
    //   242: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: astore 9
    //   247: aload 9
    //   249: lload_3
    //   250: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 9
    //   256: ldc 215
    //   258: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 9
    //   264: aload_0
    //   265: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   268: invokevirtual 217	com/tencent/token/mr:e	()J
    //   271: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: ldc 111
    //   277: aload 9
    //   279: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 219	com/tencent/token/lo:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   289: lload_3
    //   290: l2i
    //   291: putfield 222	com/tencent/token/mr:O	I
    //   294: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   297: aload_0
    //   298: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   301: invokevirtual 228	com/tencent/token/me:i	(Lcom/tencent/token/lz;)V
    //   304: goto -225 -> 79
    //   307: astore 10
    //   309: aload 9
    //   311: monitorexit
    //   312: aload 10
    //   314: athrow
    //   315: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   318: aload_0
    //   319: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   322: invokevirtual 230	com/tencent/token/me:h	(Lcom/tencent/token/lz;)V
    //   325: aload_0
    //   326: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   329: astore 9
    //   331: aload 9
    //   333: monitorenter
    //   334: aload_0
    //   335: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   338: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   341: astore 10
    //   343: aload 10
    //   345: invokeinterface 171 1 0
    //   350: ifeq +34 -> 384
    //   353: aload 10
    //   355: invokeinterface 174 1 0
    //   360: checkcast 176	com/tencent/token/ma
    //   363: astore 11
    //   365: aload 11
    //   367: ifnull -24 -> 343
    //   370: aload 11
    //   372: aload_0
    //   373: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   376: invokeinterface 231 2 0
    //   381: goto -38 -> 343
    //   384: aload 9
    //   386: monitorexit
    //   387: goto +83 -> 470
    //   390: astore 10
    //   392: aload 9
    //   394: monitorexit
    //   395: aload 10
    //   397: athrow
    //   398: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   401: aload_0
    //   402: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   405: invokevirtual 233	com/tencent/token/me:g	(Lcom/tencent/token/lz;)V
    //   408: aload_0
    //   409: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   412: astore 9
    //   414: aload 9
    //   416: monitorenter
    //   417: aload_0
    //   418: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   421: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   424: astore 10
    //   426: aload 10
    //   428: invokeinterface 171 1 0
    //   433: ifeq +34 -> 467
    //   436: aload 10
    //   438: invokeinterface 174 1 0
    //   443: checkcast 176	com/tencent/token/ma
    //   446: astore 11
    //   448: aload 11
    //   450: ifnull -24 -> 426
    //   453: aload 11
    //   455: aload_0
    //   456: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   459: invokeinterface 234 2 0
    //   464: goto -38 -> 426
    //   467: aload 9
    //   469: monitorexit
    //   470: iconst_1
    //   471: istore_1
    //   472: goto +222 -> 694
    //   475: astore 10
    //   477: aload 9
    //   479: monitorexit
    //   480: aload 10
    //   482: athrow
    //   483: astore 9
    //   485: iload_2
    //   486: istore_1
    //   487: goto +282 -> 769
    //   490: astore 10
    //   492: iconst_1
    //   493: istore_1
    //   494: aload 8
    //   496: astore 9
    //   498: goto +242 -> 740
    //   501: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   504: pop
    //   505: aload_0
    //   506: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   509: astore 9
    //   511: aload 9
    //   513: monitorenter
    //   514: aload_0
    //   515: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   518: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   521: astore 10
    //   523: aload 10
    //   525: invokeinterface 171 1 0
    //   530: ifeq +34 -> 564
    //   533: aload 10
    //   535: invokeinterface 174 1 0
    //   540: checkcast 176	com/tencent/token/ma
    //   543: astore 11
    //   545: aload 11
    //   547: ifnull -24 -> 523
    //   550: aload 11
    //   552: aload_0
    //   553: getfield 49	com/tencent/halley/downloader/c/b:a	Lcom/tencent/token/mr;
    //   556: invokeinterface 236 2 0
    //   561: goto -38 -> 523
    //   564: aload 9
    //   566: monitorexit
    //   567: goto +125 -> 692
    //   570: astore 10
    //   572: aload 9
    //   574: monitorexit
    //   575: aload 10
    //   577: athrow
    //   578: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   581: pop
    //   582: aload_0
    //   583: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   586: astore 9
    //   588: aload 9
    //   590: monitorenter
    //   591: aload_0
    //   592: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   595: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   598: astore 10
    //   600: aload 10
    //   602: invokeinterface 171 1 0
    //   607: ifeq +14 -> 621
    //   610: aload 10
    //   612: invokeinterface 174 1 0
    //   617: pop
    //   618: goto -18 -> 600
    //   621: aload 9
    //   623: monitorexit
    //   624: goto +68 -> 692
    //   627: astore 10
    //   629: aload 9
    //   631: monitorexit
    //   632: aload 10
    //   634: athrow
    //   635: invokestatic 227	com/tencent/token/me:b	()Lcom/tencent/token/me;
    //   638: pop
    //   639: aload_0
    //   640: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   643: astore 9
    //   645: aload 9
    //   647: monitorenter
    //   648: aload_0
    //   649: getfield 36	com/tencent/halley/downloader/c/b:c	Ljava/util/Vector;
    //   652: invokevirtual 165	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   655: astore 10
    //   657: aload 10
    //   659: invokeinterface 171 1 0
    //   664: ifeq +14 -> 678
    //   667: aload 10
    //   669: invokeinterface 174 1 0
    //   674: pop
    //   675: goto -18 -> 657
    //   678: aload 9
    //   680: monitorexit
    //   681: goto +11 -> 692
    //   684: astore 10
    //   686: aload 9
    //   688: monitorexit
    //   689: aload 10
    //   691: athrow
    //   692: iconst_0
    //   693: istore_1
    //   694: iload_1
    //   695: ifeq -688 -> 7
    //   698: goto +75 -> 773
    //   701: astore 9
    //   703: goto +21 -> 724
    //   706: astore 10
    //   708: aload 8
    //   710: astore 9
    //   712: aload 10
    //   714: astore 8
    //   716: goto +18 -> 734
    //   719: astore 9
    //   721: aconst_null
    //   722: astore 8
    //   724: iconst_0
    //   725: istore_1
    //   726: goto +43 -> 769
    //   729: astore 8
    //   731: aconst_null
    //   732: astore 9
    //   734: iconst_0
    //   735: istore_1
    //   736: aload 8
    //   738: astore 10
    //   740: aload 10
    //   742: invokevirtual 146	java/lang/InterruptedException:printStackTrace	()V
    //   745: iload_1
    //   746: ifeq -739 -> 7
    //   749: aload 9
    //   751: invokestatic 242	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   754: astore 8
    //   756: goto +24 -> 780
    //   759: astore 10
    //   761: aload 9
    //   763: astore 8
    //   765: aload 10
    //   767: astore 9
    //   769: iload_1
    //   770: ifeq +24 -> 794
    //   773: aload 8
    //   775: invokestatic 242	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   778: astore 8
    //   780: ldc 244
    //   782: aload 8
    //   784: invokevirtual 248	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   787: pop
    //   788: aload_0
    //   789: iconst_0
    //   790: putfield 42	com/tencent/halley/downloader/c/b:f	Z
    //   793: return
    //   794: aload 9
    //   796: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	this	b
    //   28	742	1	i	int
    //   1	485	2	j	int
    //   87	203	3	l1	long
    //   153	80	5	l2	long
    //   202	3	7	bool	boolean
    //   17	706	8	localObject1	Object
    //   729	8	8	localInterruptedException1	InterruptedException
    //   754	29	8	localObject2	Object
    //   92	118	9	localObject3	Object
    //   222	3	9	localThrowable	java.lang.Throwable
    //   245	233	9	localObject4	Object
    //   483	1	9	localObject5	Object
    //   496	191	9	localObject6	Object
    //   701	1	9	localObject7	Object
    //   710	1	9	localObject8	Object
    //   719	1	9	localObject9	Object
    //   732	63	9	localObject10	Object
    //   104	108	10	localObject11	Object
    //   307	6	10	localObject12	Object
    //   341	13	10	localIterator1	java.util.Iterator
    //   390	6	10	localObject13	Object
    //   424	13	10	localIterator2	java.util.Iterator
    //   475	6	10	localObject14	Object
    //   490	1	10	localInterruptedException2	InterruptedException
    //   521	13	10	localIterator3	java.util.Iterator
    //   570	6	10	localObject15	Object
    //   598	13	10	localIterator4	java.util.Iterator
    //   627	6	10	localObject16	Object
    //   655	13	10	localIterator5	java.util.Iterator
    //   684	6	10	localObject17	Object
    //   706	7	10	localInterruptedException3	InterruptedException
    //   738	3	10	localInterruptedException4	InterruptedException
    //   759	7	10	localObject18	Object
    //   126	425	11	localma	com.tencent.token.ma
    // Exception table:
    //   from	to	target	type
    //   209	219	222	java/lang/Throwable
    //   97	106	307	finally
    //   106	128	307	finally
    //   133	144	307	finally
    //   147	150	307	finally
    //   334	343	390	finally
    //   343	365	390	finally
    //   370	381	390	finally
    //   384	387	390	finally
    //   417	426	475	finally
    //   426	448	475	finally
    //   453	464	475	finally
    //   467	470	475	finally
    //   84	97	483	finally
    //   150	204	483	finally
    //   209	219	483	finally
    //   224	229	483	finally
    //   229	304	483	finally
    //   309	315	483	finally
    //   315	334	483	finally
    //   392	398	483	finally
    //   398	417	483	finally
    //   477	483	483	finally
    //   84	97	490	java/lang/InterruptedException
    //   150	204	490	java/lang/InterruptedException
    //   209	219	490	java/lang/InterruptedException
    //   224	229	490	java/lang/InterruptedException
    //   229	304	490	java/lang/InterruptedException
    //   309	315	490	java/lang/InterruptedException
    //   315	334	490	java/lang/InterruptedException
    //   392	398	490	java/lang/InterruptedException
    //   398	417	490	java/lang/InterruptedException
    //   477	483	490	java/lang/InterruptedException
    //   514	523	570	finally
    //   523	545	570	finally
    //   550	561	570	finally
    //   564	567	570	finally
    //   591	600	627	finally
    //   600	618	627	finally
    //   621	624	627	finally
    //   648	657	684	finally
    //   657	675	684	finally
    //   678	681	684	finally
    //   19	29	701	finally
    //   501	514	701	finally
    //   572	578	701	finally
    //   578	591	701	finally
    //   629	635	701	finally
    //   635	648	701	finally
    //   686	692	701	finally
    //   19	29	706	java/lang/InterruptedException
    //   501	514	706	java/lang/InterruptedException
    //   572	578	706	java/lang/InterruptedException
    //   578	591	706	java/lang/InterruptedException
    //   629	635	706	java/lang/InterruptedException
    //   635	648	706	java/lang/InterruptedException
    //   686	692	706	java/lang/InterruptedException
    //   7	19	719	finally
    //   7	19	729	java/lang/InterruptedException
    //   740	745	759	finally
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