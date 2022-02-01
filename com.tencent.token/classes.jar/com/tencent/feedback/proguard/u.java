package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.b;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.g;
import com.tencent.feedback.upload.d;
import java.util.Date;

public final class u
  implements Runnable
{
  private static long a;
  private Context b = null;
  
  public u(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      a = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    com.tencent.feedback.upload.e locale1 = t.a();
    Object localObject = y.a(this.b, b.b(), locale1);
    boolean bool = ((y)localObject).b();
    if (!bool) {
      ((y)localObject).a(60000L);
    }
    if (new Date().getTime() < paramLong2 + paramLong1)
    {
      com.tencent.feedback.common.e.a("lastUpdate:%d ,return not query", new Object[] { Long.valueOf(paramLong1) });
      return;
    }
    int i = 0;
    com.tencent.feedback.upload.e locale2;
    while (locale1 == null)
    {
      i += 1;
      if (i >= 5) {
        break;
      }
      com.tencent.feedback.common.e.b("rqdp{  wait uphandler:} %d", new Object[] { Integer.valueOf(200) });
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException1)
      {
        if (!com.tencent.feedback.common.e.a(localInterruptedException1)) {
          localInterruptedException1.printStackTrace();
        }
      }
      locale2 = t.a();
    }
    if ((locale2 != null) && (g.b(this.b)))
    {
      if ((!bool) && (((y)localObject).b(c.a(this.b).E()) <= 0))
      {
        com.tencent.feedback.common.e.b("rqdp{  wait lanch record:} %d", new Object[] { Integer.valueOf(500) });
        try
        {
          Thread.sleep(500L);
        }
        catch (InterruptedException localInterruptedException2)
        {
          if (!com.tencent.feedback.common.e.a(localInterruptedException2)) {
            localInterruptedException2.printStackTrace();
          }
        }
      }
      localObject = A.a(this.b, (y)localObject, (byte)2);
      if (localObject != null) {
        com.tencent.feedback.common.e.c("create uPkg fail!", new Object[0]);
      }
      locale2.a(new v(this.b, 1111, 540, (S)localObject));
      return;
    }
    com.tencent.feedback.common.e.a("rqdp{  no uphandler or offline ,not query!!}", new Object[0]);
  }
  
  private long b()
  {
    z localz = a.a(this.b, 510);
    if ((localz != null) && (localz.b() == 510) && (localz.c() != null)) {
      try
      {
        d locald = t.a(this.b).c();
        if (locald != null)
        {
          locald.a(510, localz.c(), false);
          com.tencent.feedback.common.e.b("rqdp{  common strategy setted by history}", new Object[0]);
        }
        long l = localz.d();
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (!com.tencent.feedback.common.e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
      }
    }
    return -1L;
  }
  
  private void c()
  {
    ??? = c.a(this.b).k();
    int i = 0;
    com.tencent.feedback.common.e.a("rqdp{  AppFirstRun } %s", new Object[] { ??? });
    com.tencent.feedback.common.e.a("rqdp{  clear ao count} %d", new Object[] { Integer.valueOf(l.a(this.b, null, -1L, 9223372036854775807L, -1, -1)) });
    synchronized (t.a(this.b))
    {
      s[] arrayOfs = ((t)???).d();
      t.a(this.b).a(true);
      if (arrayOfs != null)
      {
        int j = arrayOfs.length;
        while (i < j)
        {
          arrayOfs[i].f();
          i += 1;
        }
      }
      return;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 195	com/tencent/feedback/proguard/u:b	()J
    //   4: lstore 5
    //   6: aload_0
    //   7: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   10: invokestatic 151	com/tencent/feedback/proguard/t:a	(Landroid/content/Context;)Lcom/tencent/feedback/proguard/t;
    //   13: astore 14
    //   15: aload 14
    //   17: invokevirtual 198	com/tencent/feedback/proguard/t:b	()Lcom/tencent/feedback/proguard/w;
    //   20: astore 12
    //   22: aload 12
    //   24: ifnonnull +10 -> 34
    //   27: ldc2_w 166
    //   30: lstore_3
    //   31: goto +18 -> 49
    //   34: aload 12
    //   36: invokevirtual 202	com/tencent/feedback/proguard/w:c	()I
    //   39: sipush 3600
    //   42: imul
    //   43: sipush 1000
    //   46: imul
    //   47: i2l
    //   48: lstore_3
    //   49: aload 14
    //   51: invokevirtual 205	com/tencent/feedback/proguard/t:e	()I
    //   54: ifne +771 -> 825
    //   57: ldc 207
    //   59: iconst_0
    //   60: anewarray 4	java/lang/Object
    //   63: invokestatic 68	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   66: pop
    //   67: aload 14
    //   69: iconst_1
    //   70: invokevirtual 210	com/tencent/feedback/proguard/t:a	(I)V
    //   73: aload_0
    //   74: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   77: astore 12
    //   79: aload 12
    //   81: aload 12
    //   83: invokestatic 100	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   86: invokevirtual 212	com/tencent/feedback/common/c:b	()Ljava/lang/String;
    //   89: invokestatic 217	com/tencent/feedback/common/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 15
    //   94: aload 15
    //   96: ifnull +632 -> 728
    //   99: aload 15
    //   101: invokevirtual 222	java/lang/String:trim	()Ljava/lang/String;
    //   104: invokevirtual 225	java/lang/String:length	()I
    //   107: ifne +6 -> 113
    //   110: goto +618 -> 728
    //   113: new 227	java/io/File
    //   116: dup
    //   117: aload 15
    //   119: invokespecial 230	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore 12
    //   124: aload 12
    //   126: invokevirtual 233	java/io/File:exists	()Z
    //   129: ifeq +579 -> 708
    //   132: aload 12
    //   134: invokevirtual 236	java/io/File:canRead	()Z
    //   137: ifne +6 -> 143
    //   140: goto +568 -> 708
    //   143: aload 12
    //   145: invokevirtual 239	java/io/File:lastModified	()J
    //   148: lstore 7
    //   150: aload 12
    //   152: invokevirtual 241	java/io/File:length	()J
    //   155: lstore 9
    //   157: aload_0
    //   158: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   161: invokestatic 100	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   164: invokevirtual 244	com/tencent/feedback/common/c:B	()Ljava/lang/String;
    //   167: astore 16
    //   169: aload_0
    //   170: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   173: aload 15
    //   175: iconst_0
    //   176: bipush 10
    //   178: invokestatic 247	com/tencent/feedback/proguard/l:a	(Landroid/content/Context;Ljava/lang/String;II)Ljava/util/List;
    //   181: astore 17
    //   183: aconst_null
    //   184: astore 13
    //   186: aload 13
    //   188: astore 12
    //   190: aload 17
    //   192: ifnull +30 -> 222
    //   195: aload 13
    //   197: astore 12
    //   199: aload 17
    //   201: invokeinterface 252 1 0
    //   206: ifle +16 -> 222
    //   209: aload 17
    //   211: iconst_0
    //   212: invokeinterface 256 2 0
    //   217: checkcast 258	com/tencent/feedback/proguard/o
    //   220: astore 12
    //   222: aload_0
    //   223: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   226: invokestatic 100	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   229: astore 13
    //   231: aload 12
    //   233: ifnonnull +115 -> 348
    //   236: new 260	java/util/ArrayList
    //   239: dup
    //   240: invokespecial 261	java/util/ArrayList:<init>	()V
    //   243: astore 12
    //   245: new 258	com/tencent/feedback/proguard/o
    //   248: dup
    //   249: invokespecial 262	com/tencent/feedback/proguard/o:<init>	()V
    //   252: astore 17
    //   254: aload 17
    //   256: iconst_0
    //   257: invokevirtual 263	com/tencent/feedback/proguard/o:a	(I)V
    //   260: aload 17
    //   262: aload 15
    //   264: invokevirtual 265	com/tencent/feedback/proguard/o:a	(Ljava/lang/String;)V
    //   267: aload 17
    //   269: aload 13
    //   271: invokevirtual 268	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   274: invokevirtual 270	com/tencent/feedback/proguard/o:b	(Ljava/lang/String;)V
    //   277: aload 17
    //   279: aload 16
    //   281: invokevirtual 272	com/tencent/feedback/proguard/o:c	(Ljava/lang/String;)V
    //   284: aload 17
    //   286: lload 7
    //   288: invokevirtual 274	com/tencent/feedback/proguard/o:b	(J)V
    //   291: aload 17
    //   293: lload 9
    //   295: invokevirtual 276	com/tencent/feedback/proguard/o:c	(J)V
    //   298: aload 12
    //   300: aload 17
    //   302: invokeinterface 280 2 0
    //   307: pop
    //   308: aload_0
    //   309: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   312: aload 12
    //   314: invokestatic 283	com/tencent/feedback/proguard/l:c	(Landroid/content/Context;Ljava/util/List;)I
    //   317: pop
    //   318: iconst_1
    //   319: anewarray 4	java/lang/Object
    //   322: astore 12
    //   324: aload 12
    //   326: iconst_0
    //   327: aload 17
    //   329: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   332: aastore
    //   333: ldc_w 287
    //   336: aload 12
    //   338: invokestatic 68	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   341: pop
    //   342: iconst_1
    //   343: istore 11
    //   345: goto +411 -> 756
    //   348: aload 13
    //   350: invokevirtual 290	com/tencent/feedback/common/c:m	()Z
    //   353: ifeq +132 -> 485
    //   356: aload 13
    //   358: invokevirtual 268	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   361: aload 12
    //   363: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   366: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifeq +6 -> 375
    //   372: goto +381 -> 753
    //   375: aload_0
    //   376: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   379: aload 17
    //   381: invokestatic 295	com/tencent/feedback/proguard/l:d	(Landroid/content/Context;Ljava/util/List;)I
    //   384: pop
    //   385: new 260	java/util/ArrayList
    //   388: dup
    //   389: invokespecial 261	java/util/ArrayList:<init>	()V
    //   392: astore 12
    //   394: new 258	com/tencent/feedback/proguard/o
    //   397: dup
    //   398: invokespecial 262	com/tencent/feedback/proguard/o:<init>	()V
    //   401: astore 17
    //   403: aload 17
    //   405: iconst_0
    //   406: invokevirtual 263	com/tencent/feedback/proguard/o:a	(I)V
    //   409: aload 17
    //   411: aload 15
    //   413: invokevirtual 265	com/tencent/feedback/proguard/o:a	(Ljava/lang/String;)V
    //   416: aload 17
    //   418: aload 13
    //   420: invokevirtual 268	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   423: invokevirtual 270	com/tencent/feedback/proguard/o:b	(Ljava/lang/String;)V
    //   426: aload 17
    //   428: aload 16
    //   430: invokevirtual 272	com/tencent/feedback/proguard/o:c	(Ljava/lang/String;)V
    //   433: aload 17
    //   435: lload 7
    //   437: invokevirtual 274	com/tencent/feedback/proguard/o:b	(J)V
    //   440: aload 17
    //   442: lload 9
    //   444: invokevirtual 276	com/tencent/feedback/proguard/o:c	(J)V
    //   447: aload 12
    //   449: aload 17
    //   451: invokeinterface 280 2 0
    //   456: pop
    //   457: aload_0
    //   458: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   461: aload 12
    //   463: invokestatic 283	com/tencent/feedback/proguard/l:c	(Landroid/content/Context;Ljava/util/List;)I
    //   466: pop
    //   467: iconst_1
    //   468: anewarray 4	java/lang/Object
    //   471: astore 12
    //   473: aload 12
    //   475: iconst_0
    //   476: aload 17
    //   478: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   481: aastore
    //   482: goto -149 -> 333
    //   485: aload 12
    //   487: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   490: ifnull +56 -> 546
    //   493: aload 16
    //   495: aload 12
    //   497: invokevirtual 297	com/tencent/feedback/proguard/o:f	()Ljava/lang/String;
    //   500: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifeq +43 -> 546
    //   506: lload 7
    //   508: aload 12
    //   510: invokevirtual 298	com/tencent/feedback/proguard/o:b	()J
    //   513: lcmp
    //   514: ifne +32 -> 546
    //   517: lload 9
    //   519: aload 12
    //   521: invokevirtual 300	com/tencent/feedback/proguard/o:c	()J
    //   524: lcmp
    //   525: ifne +21 -> 546
    //   528: aload_0
    //   529: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   532: invokestatic 100	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   535: aload 12
    //   537: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   540: invokevirtual 302	com/tencent/feedback/common/c:d	(Ljava/lang/String;)V
    //   543: goto -171 -> 372
    //   546: aload_0
    //   547: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   550: invokestatic 100	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   553: invokevirtual 268	com/tencent/feedback/common/c:l	()Ljava/lang/String;
    //   556: astore 13
    //   558: aload 13
    //   560: ifnonnull +17 -> 577
    //   563: ldc_w 304
    //   566: iconst_0
    //   567: anewarray 4	java/lang/Object
    //   570: invokestatic 306	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   573: pop
    //   574: goto -202 -> 372
    //   577: aload 13
    //   579: aload 12
    //   581: invokevirtual 285	com/tencent/feedback/proguard/o:d	()Ljava/lang/String;
    //   584: invokevirtual 293	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: istore 11
    //   589: aload_0
    //   590: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   593: aload 17
    //   595: invokestatic 295	com/tencent/feedback/proguard/l:d	(Landroid/content/Context;Ljava/util/List;)I
    //   598: pop
    //   599: new 260	java/util/ArrayList
    //   602: dup
    //   603: invokespecial 261	java/util/ArrayList:<init>	()V
    //   606: astore 12
    //   608: new 258	com/tencent/feedback/proguard/o
    //   611: dup
    //   612: invokespecial 262	com/tencent/feedback/proguard/o:<init>	()V
    //   615: astore 17
    //   617: aload 17
    //   619: iconst_0
    //   620: invokevirtual 263	com/tencent/feedback/proguard/o:a	(I)V
    //   623: aload 17
    //   625: aload 15
    //   627: invokevirtual 265	com/tencent/feedback/proguard/o:a	(Ljava/lang/String;)V
    //   630: aload 17
    //   632: aload 13
    //   634: invokevirtual 270	com/tencent/feedback/proguard/o:b	(Ljava/lang/String;)V
    //   637: aload 17
    //   639: aload 16
    //   641: invokevirtual 272	com/tencent/feedback/proguard/o:c	(Ljava/lang/String;)V
    //   644: aload 17
    //   646: lload 7
    //   648: invokevirtual 274	com/tencent/feedback/proguard/o:b	(J)V
    //   651: aload 17
    //   653: lload 9
    //   655: invokevirtual 276	com/tencent/feedback/proguard/o:c	(J)V
    //   658: aload 12
    //   660: aload 17
    //   662: invokeinterface 280 2 0
    //   667: pop
    //   668: aload_0
    //   669: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   672: aload 12
    //   674: invokestatic 283	com/tencent/feedback/proguard/l:c	(Landroid/content/Context;Ljava/util/List;)I
    //   677: pop
    //   678: ldc_w 308
    //   681: iconst_2
    //   682: anewarray 4	java/lang/Object
    //   685: dup
    //   686: iconst_0
    //   687: iload 11
    //   689: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   692: aastore
    //   693: dup
    //   694: iconst_1
    //   695: aload 17
    //   697: invokevirtual 316	com/tencent/feedback/proguard/o:toString	()Ljava/lang/String;
    //   700: aastore
    //   701: invokestatic 68	com/tencent/feedback/common/e:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   704: pop
    //   705: goto +51 -> 756
    //   708: ldc_w 318
    //   711: astore 12
    //   713: iconst_1
    //   714: anewarray 4	java/lang/Object
    //   717: astore 13
    //   719: aload 13
    //   721: iconst_0
    //   722: aload 15
    //   724: aastore
    //   725: goto +20 -> 745
    //   728: ldc_w 320
    //   731: astore 12
    //   733: iconst_1
    //   734: anewarray 4	java/lang/Object
    //   737: astore 13
    //   739: aload 13
    //   741: iconst_0
    //   742: aload 15
    //   744: aastore
    //   745: aload 12
    //   747: aload 13
    //   749: invokestatic 306	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   752: pop
    //   753: iconst_0
    //   754: istore 11
    //   756: iload 11
    //   758: ifeq +10 -> 768
    //   761: aload_0
    //   762: invokespecial 322	com/tencent/feedback/proguard/u:c	()V
    //   765: goto +60 -> 825
    //   768: invokestatic 324	com/tencent/feedback/proguard/u:a	()J
    //   771: lstore 7
    //   773: lload 7
    //   775: lconst_0
    //   776: lcmp
    //   777: ifle +48 -> 825
    //   780: ldc_w 326
    //   783: iconst_1
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: lload 7
    //   791: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   794: aastore
    //   795: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   798: pop
    //   799: lload 7
    //   801: invokestatic 84	java/lang/Thread:sleep	(J)V
    //   804: goto +21 -> 825
    //   807: astore 12
    //   809: aload 12
    //   811: invokestatic 87	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   814: ifne +11 -> 825
    //   817: aload 12
    //   819: invokevirtual 90	java/lang/InterruptedException:printStackTrace	()V
    //   822: goto +3 -> 825
    //   825: ldc_w 328
    //   828: iconst_0
    //   829: anewarray 4	java/lang/Object
    //   832: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   835: pop
    //   836: aload 14
    //   838: monitorenter
    //   839: aload 14
    //   841: invokevirtual 184	com/tencent/feedback/proguard/t:d	()[Lcom/tencent/feedback/proguard/s;
    //   844: astore 12
    //   846: aload 14
    //   848: iconst_2
    //   849: invokevirtual 210	com/tencent/feedback/proguard/t:a	(I)V
    //   852: aload 14
    //   854: monitorexit
    //   855: aload 12
    //   857: ifnull +41 -> 898
    //   860: ldc_w 330
    //   863: iconst_0
    //   864: anewarray 4	java/lang/Object
    //   867: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   870: pop
    //   871: aload 12
    //   873: arraylength
    //   874: istore_2
    //   875: iconst_0
    //   876: istore_1
    //   877: iload_1
    //   878: iload_2
    //   879: if_icmpge +19 -> 898
    //   882: aload 12
    //   884: iload_1
    //   885: aaload
    //   886: invokeinterface 332 1 0
    //   891: iload_1
    //   892: iconst_1
    //   893: iadd
    //   894: istore_1
    //   895: goto -18 -> 877
    //   898: aload_0
    //   899: lload 5
    //   901: lload_3
    //   902: invokespecial 334	com/tencent/feedback/proguard/u:a	(JJ)V
    //   905: ldc_w 336
    //   908: iconst_0
    //   909: anewarray 4	java/lang/Object
    //   912: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   915: pop
    //   916: aload 14
    //   918: monitorenter
    //   919: aload 14
    //   921: invokevirtual 184	com/tencent/feedback/proguard/t:d	()[Lcom/tencent/feedback/proguard/s;
    //   924: astore 12
    //   926: aload 14
    //   928: iconst_3
    //   929: invokevirtual 210	com/tencent/feedback/proguard/t:a	(I)V
    //   932: aload 14
    //   934: monitorexit
    //   935: aload 12
    //   937: ifnull +41 -> 978
    //   940: ldc_w 338
    //   943: iconst_0
    //   944: anewarray 4	java/lang/Object
    //   947: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   950: pop
    //   951: aload 12
    //   953: arraylength
    //   954: istore_2
    //   955: iconst_0
    //   956: istore_1
    //   957: iload_1
    //   958: iload_2
    //   959: if_icmpge +19 -> 978
    //   962: aload 12
    //   964: iload_1
    //   965: aaload
    //   966: invokeinterface 340 1 0
    //   971: iload_1
    //   972: iconst_1
    //   973: iadd
    //   974: istore_1
    //   975: goto -18 -> 957
    //   978: lload_3
    //   979: lconst_0
    //   980: lcmp
    //   981: ifgt +22 -> 1003
    //   984: ldc_w 342
    //   987: iconst_1
    //   988: anewarray 4	java/lang/Object
    //   991: dup
    //   992: iconst_0
    //   993: lload_3
    //   994: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   997: aastore
    //   998: invokestatic 121	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1001: pop
    //   1002: return
    //   1003: lload_3
    //   1004: lconst_0
    //   1005: lcmp
    //   1006: ifle +42 -> 1048
    //   1009: invokestatic 36	com/tencent/feedback/common/b:b	()Lcom/tencent/feedback/common/b;
    //   1012: aload_0
    //   1013: lload_3
    //   1014: invokevirtual 345	com/tencent/feedback/common/b:a	(Ljava/lang/Runnable;J)Z
    //   1017: pop
    //   1018: ldc_w 347
    //   1021: iconst_1
    //   1022: anewarray 4	java/lang/Object
    //   1025: dup
    //   1026: iconst_0
    //   1027: lload_3
    //   1028: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1031: aastore
    //   1032: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1035: pop
    //   1036: aload_0
    //   1037: getfield 19	com/tencent/feedback/proguard/u:b	Landroid/content/Context;
    //   1040: invokestatic 151	com/tencent/feedback/proguard/t:a	(Landroid/content/Context;)Lcom/tencent/feedback/proguard/t;
    //   1043: iconst_4
    //   1044: invokevirtual 210	com/tencent/feedback/proguard/t:a	(I)V
    //   1047: return
    //   1048: ldc_w 349
    //   1051: iconst_0
    //   1052: anewarray 4	java/lang/Object
    //   1055: invokestatic 77	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1058: pop
    //   1059: return
    //   1060: astore 12
    //   1062: aload 14
    //   1064: monitorexit
    //   1065: aload 12
    //   1067: athrow
    //   1068: astore 12
    //   1070: aload 14
    //   1072: monitorexit
    //   1073: aload 12
    //   1075: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1076	0	this	u
    //   876	99	1	i	int
    //   874	86	2	j	int
    //   30	998	3	l1	long
    //   4	896	5	l2	long
    //   148	652	7	l3	long
    //   155	499	9	l4	long
    //   343	414	11	bool	boolean
    //   20	726	12	localObject1	Object
    //   807	11	12	localInterruptedException	InterruptedException
    //   844	119	12	arrayOfs	s[]
    //   1060	6	12	localObject2	Object
    //   1068	6	12	localObject3	Object
    //   184	564	13	localObject4	Object
    //   13	1058	14	localt	t
    //   92	651	15	str1	java.lang.String
    //   167	473	16	str2	java.lang.String
    //   181	515	17	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   799	804	807	java/lang/InterruptedException
    //   919	935	1060	finally
    //   839	855	1068	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.u
 * JD-Core Version:    0.7.0.1
 */