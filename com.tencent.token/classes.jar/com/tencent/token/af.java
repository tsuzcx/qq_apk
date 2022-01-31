package com.tencent.token;

import com.tencent.halley.common.c;
import com.tencent.halley.downloader.c.d.a;
import com.tencent.halley.downloader.c.d.a.a;
import com.tencent.halley.downloader.c.d.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class af
  implements l, u, Runnable
{
  public ad a;
  public a b;
  private boolean c = true;
  private b d;
  private long e = -1L;
  private u f;
  private ae g;
  private Map h = null;
  private int i = 0;
  private String j = "";
  private boolean k = false;
  private boolean l = false;
  private long m = 0L;
  private m n;
  private Object o = new Object();
  private ai p = new ai();
  private String q;
  private boolean r = true;
  
  public af(b paramb, boolean paramBoolean1, long paramLong, u paramu, ae paramae, Map paramMap, boolean paramBoolean2)
  {
    this.d = paramb;
    this.c = paramBoolean1;
    this.e = paramLong;
    this.p.a = paramBoolean1;
    this.f = paramu;
    this.g = paramae;
    this.h = paramMap;
    this.r = paramBoolean2;
  }
  
  private void a(i parami)
  {
    if (parami != null)
    {
      parami = parami.n();
      if ((parami != null) && (parami.size() > 0))
      {
        parami = parami.iterator();
        while (parami.hasNext())
        {
          String str = (String)parami.next();
          this.d.a(o.a, str, a.a.e);
          c.a("SectionTransport", "add header schedule url...apn:" + o.a + ",type:" + a.a.e + ",url:" + str);
        }
      }
    }
  }
  
  public final boolean a()
  {
    if (this.k) {
      return true;
    }
    if (this.f != null) {
      return this.f.a();
    }
    c.d("SectionTransport", "cancelChecker is null");
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      c.a("DownloadTest", "is direct:" + this.c + ",onReceiveData...len:" + paramInt + ",section:" + this.a);
    }
    if (this.g != null)
    {
      if (this.a.f + paramInt < this.a.g) {
        break label192;
      }
      paramInt = (int)(this.a.g - this.a.f);
    }
    label192:
    for (int i1 = 0;; i1 = 1)
    {
      paramBoolean = this.g.a(this, this.a.f, paramArrayOfByte, paramInt, paramBoolean) & i1;
      if (!paramBoolean) {
        c.a("DownloadTest", "is direct:" + this.c + ",stop read data...len:" + paramInt + ",section:" + this.a);
      }
      this.m += paramInt;
      return paramBoolean;
      c.d("SectionTransport", "listener in Ant is null.");
      return true;
    }
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.i;
  }
  
  public final String d()
  {
    return this.j;
  }
  
  public final void e()
  {
    try
    {
      this.k = true;
      if (this.n != null) {
        this.n.r();
      }
      synchronized (this.o)
      {
        this.o.notifyAll();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final boolean f()
  {
    return this.l;
  }
  
  public final String g()
  {
    if (this.p != null) {
      return this.p.a();
    }
    return "";
  }
  
  public final String h()
  {
    if (this.p != null) {
      return this.p.toString();
    }
    return "";
  }
  
  public final String i()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.c) {}
    for (int i1 = 0;; i1 = 1)
    {
      localStringBuilder1.append(i1).append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(this.q).append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(this.i).append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(";");
      return localStringBuilder1.toString();
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   4: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   7: putfield 227	com/tencent/token/ai:b	J
    //   10: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   13: lstore 6
    //   15: iconst_1
    //   16: istore_3
    //   17: iconst_0
    //   18: istore 13
    //   20: lconst_0
    //   21: lstore 4
    //   23: iconst_0
    //   24: istore_1
    //   25: aload_0
    //   26: invokevirtual 233	com/tencent/token/af:a	()Z
    //   29: ifne +461 -> 490
    //   32: aload_0
    //   33: getfield 48	com/tencent/token/af:c	Z
    //   36: ifne +90 -> 126
    //   39: aload_0
    //   40: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   43: invokevirtual 234	com/tencent/halley/downloader/c/d/b:a	()Z
    //   46: ifeq +80 -> 126
    //   49: invokestatic 236	com/tencent/token/o:b	()V
    //   52: getstatic 116	com/tencent/token/o:a	Ljava/lang/String;
    //   55: astore 14
    //   57: aload_0
    //   58: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   61: aload 14
    //   63: invokevirtual 239	com/tencent/halley/downloader/c/d/b:a	(Ljava/lang/String;)Z
    //   66: ifeq +60 -> 126
    //   69: aload_0
    //   70: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   73: getfield 241	com/tencent/halley/downloader/c/d/b:a	Lcom/tencent/halley/downloader/c/d/a;
    //   76: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   79: bipush 10
    //   81: aload_0
    //   82: getfield 52	com/tencent/token/af:e	J
    //   85: iconst_1
    //   86: invokestatic 249	com/tencent/halley/a:a	(Ljava/lang/String;IJZ)Ljava/util/List;
    //   89: astore 16
    //   91: aload 16
    //   93: ifnull +33 -> 126
    //   96: invokestatic 236	com/tencent/token/o:b	()V
    //   99: getstatic 116	com/tencent/token/o:a	Ljava/lang/String;
    //   102: astore 15
    //   104: aload 15
    //   106: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifne +17 -> 126
    //   112: aload 15
    //   114: aload 14
    //   116: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: istore 12
    //   121: iload 12
    //   123: ifne +439 -> 562
    //   126: aload_0
    //   127: invokevirtual 233	com/tencent/token/af:a	()Z
    //   130: ifne +360 -> 490
    //   133: aload_0
    //   134: getfield 48	com/tencent/token/af:c	Z
    //   137: ifne +10 -> 147
    //   140: aload_0
    //   141: getfield 75	com/tencent/token/af:r	Z
    //   144: ifeq +346 -> 490
    //   147: iload_1
    //   148: ifle +24 -> 172
    //   151: aload_0
    //   152: getfield 68	com/tencent/token/af:o	Ljava/lang/Object;
    //   155: astore 14
    //   157: aload 14
    //   159: monitorenter
    //   160: aload_0
    //   161: getfield 68	com/tencent/token/af:o	Ljava/lang/Object;
    //   164: iload_1
    //   165: i2l
    //   166: invokevirtual 263	java/lang/Object:wait	(J)V
    //   169: aload 14
    //   171: monitorexit
    //   172: aload_0
    //   173: invokevirtual 233	com/tencent/token/af:a	()Z
    //   176: ifne +314 -> 490
    //   179: lload 4
    //   181: lconst_0
    //   182: lcmp
    //   183: ifne +2442 -> 2625
    //   186: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   189: lstore 4
    //   191: iload_3
    //   192: ifeq +535 -> 727
    //   195: aload_0
    //   196: getfield 56	com/tencent/token/af:i	I
    //   199: sipush 404
    //   202: if_icmpeq +12 -> 214
    //   205: aload_0
    //   206: getfield 56	com/tencent/token/af:i	I
    //   209: bipush 246
    //   211: if_icmpne +510 -> 721
    //   214: iconst_1
    //   215: istore 12
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   222: getstatic 116	com/tencent/token/o:a	Ljava/lang/String;
    //   225: aload_0
    //   226: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   229: aload_0
    //   230: getfield 48	com/tencent/token/af:c	Z
    //   233: iload 12
    //   235: invokevirtual 268	com/tencent/halley/downloader/c/d/b:a	(Ljava/lang/String;Lcom/tencent/halley/downloader/c/d/a;ZZ)Lcom/tencent/halley/downloader/c/d/a;
    //   238: putfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   241: ldc 128
    //   243: new 130	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 270
    //   250: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield 48	com/tencent/token/af:c	Z
    //   257: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   260: ldc_w 272
    //   263: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_0
    //   267: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   270: getfield 274	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   273: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   276: ldc_w 276
    //   279: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload 12
    //   284: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   287: ldc 146
    //   289: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   296: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   299: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 155	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   313: aload_0
    //   314: invokeinterface 279 2 0
    //   319: putfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   322: ldc 164
    //   324: new 130	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 270
    //   331: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: getfield 48	com/tencent/token/af:c	Z
    //   338: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   341: ldc_w 281
    //   344: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   351: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 283	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_0
    //   361: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   364: ifnull +126 -> 490
    //   367: iload 13
    //   369: istore 12
    //   371: iload 13
    //   373: ifeq +16 -> 389
    //   376: iload 13
    //   378: istore 12
    //   380: invokestatic 285	com/tencent/token/o:d	()Z
    //   383: ifne +6 -> 389
    //   386: iconst_0
    //   387: istore 12
    //   389: iconst_m1
    //   390: istore_1
    //   391: iload 12
    //   393: ifeq +7 -> 400
    //   396: invokestatic 289	com/tencent/token/h:f	()I
    //   399: istore_1
    //   400: aload_0
    //   401: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   404: iload_1
    //   405: aload_0
    //   406: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   409: invokeinterface 290 1 0
    //   414: invokevirtual 293	com/tencent/token/ad:a	(IZ)Lcom/tencent/token/j;
    //   417: astore 15
    //   419: new 295	com/tencent/token/n
    //   422: dup
    //   423: aload_0
    //   424: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   427: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   430: aload_0
    //   431: getfield 54	com/tencent/token/af:h	Ljava/util/Map;
    //   434: aload 15
    //   436: iload 12
    //   438: aload_0
    //   439: invokespecial 298	com/tencent/token/n:<init>	(Ljava/lang/String;Ljava/util/Map;Lcom/tencent/token/j;ZLcom/tencent/token/u;)V
    //   442: astore 14
    //   444: aload_0
    //   445: aload 14
    //   447: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   450: aload_0
    //   451: invokevirtual 233	com/tencent/token/af:a	()Z
    //   454: istore 13
    //   456: iload 13
    //   458: ifeq +431 -> 889
    //   461: aload_0
    //   462: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   465: aload_0
    //   466: invokeinterface 301 2 0
    //   471: aload_0
    //   472: aconst_null
    //   473: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   476: aload_0
    //   477: aload 14
    //   479: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   482: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   485: aload 14
    //   487: invokevirtual 305	com/tencent/token/n:q	()V
    //   490: ldc 128
    //   492: new 130	java/lang/StringBuilder
    //   495: dup
    //   496: ldc_w 307
    //   499: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   502: aload_0
    //   503: getfield 56	com/tencent/token/af:i	I
    //   506: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: ldc_w 309
    //   512: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   519: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 311	com/tencent/halley/common/c:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: iconst_1
    //   530: putfield 64	com/tencent/token/af:l	Z
    //   533: aload_0
    //   534: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   537: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   540: aload_0
    //   541: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   544: getfield 227	com/tencent/token/ai:b	J
    //   547: lsub
    //   548: putfield 313	com/tencent/token/ai:c	J
    //   551: aload_0
    //   552: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   555: aload_0
    //   556: invokeinterface 315 2 0
    //   561: return
    //   562: aload_0
    //   563: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   566: aload 15
    //   568: invokevirtual 317	com/tencent/halley/downloader/c/d/b:c	(Ljava/lang/String;)V
    //   571: aload 16
    //   573: invokeinterface 100 1 0
    //   578: astore 16
    //   580: aload 16
    //   582: invokeinterface 106 1 0
    //   587: ifeq -461 -> 126
    //   590: aload 16
    //   592: invokeinterface 110 1 0
    //   597: checkcast 112	java/lang/String
    //   600: astore 17
    //   602: aload 17
    //   604: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   607: ifne -27 -> 580
    //   610: getstatic 319	com/tencent/halley/downloader/c/d/a$a:f	Lcom/tencent/halley/downloader/c/d/a$a;
    //   613: astore 14
    //   615: aload 17
    //   617: invokevirtual 322	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   620: ldc_w 324
    //   623: invokevirtual 327	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   626: ifeq +8 -> 634
    //   629: getstatic 329	com/tencent/halley/downloader/c/d/a$a:j	Lcom/tencent/halley/downloader/c/d/a$a;
    //   632: astore 14
    //   634: aload_0
    //   635: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   638: aload 15
    //   640: aload 17
    //   642: aload 14
    //   644: invokevirtual 126	com/tencent/halley/downloader/c/d/b:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/halley/downloader/c/d/a$a;)V
    //   647: ldc 128
    //   649: new 130	java/lang/StringBuilder
    //   652: dup
    //   653: ldc_w 331
    //   656: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   659: aload 15
    //   661: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc 141
    //   666: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload 14
    //   671: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   674: ldc 146
    //   676: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 17
    //   681: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 155	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: goto -110 -> 580
    //   693: astore 14
    //   695: aload 14
    //   697: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   700: goto -574 -> 126
    //   703: astore 15
    //   705: aload 15
    //   707: invokevirtual 335	java/lang/InterruptedException:printStackTrace	()V
    //   710: goto -541 -> 169
    //   713: astore 15
    //   715: aload 14
    //   717: monitorexit
    //   718: aload 15
    //   720: athrow
    //   721: iconst_0
    //   722: istore 12
    //   724: goto -507 -> 217
    //   727: aload_0
    //   728: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   731: getfield 274	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   734: getstatic 336	com/tencent/halley/downloader/c/d/a$a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   737: if_acmpeq +16 -> 753
    //   740: aload_0
    //   741: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   744: getfield 274	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   747: getstatic 338	com/tencent/halley/downloader/c/d/a$a:a	Lcom/tencent/halley/downloader/c/d/a$a;
    //   750: if_acmpne +80 -> 830
    //   753: aload_0
    //   754: aload_0
    //   755: getfield 77	com/tencent/token/af:d	Lcom/tencent/halley/downloader/c/d/b;
    //   758: getstatic 116	com/tencent/token/o:a	Ljava/lang/String;
    //   761: aload_0
    //   762: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   765: invokevirtual 341	com/tencent/halley/downloader/c/d/b:a	(Ljava/lang/String;Lcom/tencent/halley/downloader/c/d/a;)Lcom/tencent/halley/downloader/c/d/a;
    //   768: putfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   771: ldc 128
    //   773: new 130	java/lang/StringBuilder
    //   776: dup
    //   777: ldc_w 270
    //   780: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   783: aload_0
    //   784: getfield 48	com/tencent/token/af:c	Z
    //   787: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: ldc_w 343
    //   793: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_0
    //   797: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   800: getfield 274	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   803: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   806: ldc 146
    //   808: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: aload_0
    //   812: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   815: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   818: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokestatic 155	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: goto -519 -> 308
    //   830: ldc 128
    //   832: new 130	java/lang/StringBuilder
    //   835: dup
    //   836: ldc_w 270
    //   839: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   842: aload_0
    //   843: getfield 48	com/tencent/token/af:c	Z
    //   846: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   849: ldc_w 345
    //   852: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_0
    //   856: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   859: getfield 274	com/tencent/halley/downloader/c/d/a:b	Lcom/tencent/halley/downloader/c/d/a$a;
    //   862: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   865: ldc 146
    //   867: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: aload_0
    //   871: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   874: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   877: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 155	com/tencent/halley/common/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: goto -578 -> 308
    //   889: aload_0
    //   890: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   893: astore 16
    //   895: aload 16
    //   897: getfield 347	com/tencent/token/ai:d	I
    //   900: istore_1
    //   901: aload 16
    //   903: iload_1
    //   904: iconst_1
    //   905: iadd
    //   906: putfield 347	com/tencent/token/ai:d	I
    //   909: new 349	com/tencent/token/aj
    //   912: dup
    //   913: iload_1
    //   914: aload_0
    //   915: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   918: invokespecial 352	com/tencent/token/aj:<init>	(ILcom/tencent/halley/downloader/c/d/a;)V
    //   921: astore 16
    //   923: aload 16
    //   925: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   928: lload 6
    //   930: lsub
    //   931: putfield 353	com/tencent/token/aj:c	J
    //   934: aload 16
    //   936: iload 12
    //   938: putfield 354	com/tencent/token/aj:a	Z
    //   941: aload 16
    //   943: aload_0
    //   944: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   947: invokevirtual 355	com/tencent/token/ad:toString	()Ljava/lang/String;
    //   950: putfield 357	com/tencent/token/aj:b	Ljava/lang/String;
    //   953: aload 16
    //   955: aload 15
    //   957: invokevirtual 360	com/tencent/token/j:toString	()Ljava/lang/String;
    //   960: putfield 362	com/tencent/token/aj:f	Ljava/lang/String;
    //   963: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   966: lstore 8
    //   968: aload 14
    //   970: invokevirtual 364	com/tencent/token/n:p	()V
    //   973: aload_0
    //   974: invokevirtual 233	com/tencent/token/af:a	()Z
    //   977: istore 13
    //   979: iload 13
    //   981: ifeq +35 -> 1016
    //   984: aload_0
    //   985: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   988: aload_0
    //   989: invokeinterface 301 2 0
    //   994: aload_0
    //   995: aconst_null
    //   996: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   999: aload_0
    //   1000: aload 14
    //   1002: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1005: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1008: aload 14
    //   1010: invokevirtual 305	com/tencent/token/n:q	()V
    //   1013: goto -523 -> 490
    //   1016: aload_0
    //   1017: aload 14
    //   1019: invokevirtual 366	com/tencent/token/n:a	()I
    //   1022: putfield 56	com/tencent/token/af:i	I
    //   1025: aload_0
    //   1026: aload 14
    //   1028: invokevirtual 368	com/tencent/token/n:b	()Ljava/lang/String;
    //   1031: putfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   1034: aload 16
    //   1036: aload_0
    //   1037: getfield 56	com/tencent/token/af:i	I
    //   1040: putfield 370	com/tencent/token/aj:e	I
    //   1043: aload 16
    //   1045: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   1048: lload 6
    //   1050: lsub
    //   1051: putfield 372	com/tencent/token/aj:d	J
    //   1054: aload 16
    //   1056: aload 14
    //   1058: invokevirtual 374	com/tencent/token/n:g	()Ljava/lang/String;
    //   1061: putfield 376	com/tencent/token/aj:g	Ljava/lang/String;
    //   1064: aload 16
    //   1066: aload 14
    //   1068: invokevirtual 378	com/tencent/token/n:i	()Ljava/lang/String;
    //   1071: putfield 380	com/tencent/token/aj:i	Ljava/lang/String;
    //   1074: aload 16
    //   1076: aload 14
    //   1078: invokevirtual 382	com/tencent/token/n:j	()Ljava/lang/String;
    //   1081: putfield 383	com/tencent/token/aj:j	Ljava/lang/String;
    //   1084: aload 16
    //   1086: aload 14
    //   1088: invokevirtual 385	com/tencent/token/n:c	()J
    //   1091: putfield 387	com/tencent/token/aj:h	J
    //   1094: aload 16
    //   1096: aload 14
    //   1098: invokevirtual 389	com/tencent/token/n:h	()Ljava/lang/String;
    //   1101: putfield 391	com/tencent/token/aj:k	Ljava/lang/String;
    //   1104: aload 16
    //   1106: aload 14
    //   1108: invokevirtual 393	com/tencent/token/n:k	()Ljava/lang/String;
    //   1111: putfield 395	com/tencent/token/aj:l	Ljava/lang/String;
    //   1114: aload 16
    //   1116: aload 14
    //   1118: invokevirtual 397	com/tencent/token/n:l	()Ljava/lang/String;
    //   1121: putfield 399	com/tencent/token/aj:m	Ljava/lang/String;
    //   1124: aload 16
    //   1126: aload 14
    //   1128: iconst_0
    //   1129: invokevirtual 402	com/tencent/token/n:a	(Z)Ljava/lang/String;
    //   1132: putfield 404	com/tencent/token/aj:r	Ljava/lang/String;
    //   1135: aload 16
    //   1137: aload 14
    //   1139: invokevirtual 406	com/tencent/token/n:f	()Ljava/lang/String;
    //   1142: putfield 409	com/tencent/token/aj:s	Ljava/lang/String;
    //   1145: aload_0
    //   1146: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   1149: aload 16
    //   1151: invokevirtual 412	com/tencent/token/ai:a	(Lcom/tencent/token/aj;)V
    //   1154: aload_0
    //   1155: getfield 56	com/tencent/token/af:i	I
    //   1158: bipush 203
    //   1160: if_icmpne +1454 -> 2614
    //   1163: aload_0
    //   1164: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1167: invokeinterface 290 1 0
    //   1172: ifne +1442 -> 2614
    //   1175: new 295	com/tencent/token/n
    //   1178: dup
    //   1179: aload_0
    //   1180: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   1183: getfield 244	com/tencent/halley/downloader/c/d/a:a	Ljava/lang/String;
    //   1186: aload_0
    //   1187: getfield 54	com/tencent/token/af:h	Ljava/util/Map;
    //   1190: aconst_null
    //   1191: iload 12
    //   1193: aload_0
    //   1194: invokespecial 298	com/tencent/token/n:<init>	(Ljava/lang/String;Ljava/util/Map;Lcom/tencent/token/j;ZLcom/tencent/token/u;)V
    //   1197: astore 16
    //   1199: aload_0
    //   1200: aload 16
    //   1202: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1205: aload_0
    //   1206: invokevirtual 233	com/tencent/token/af:a	()Z
    //   1209: istore 13
    //   1211: iload 13
    //   1213: ifeq +35 -> 1248
    //   1216: aload_0
    //   1217: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1220: aload_0
    //   1221: invokeinterface 301 2 0
    //   1226: aload_0
    //   1227: aconst_null
    //   1228: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1231: aload_0
    //   1232: aload 16
    //   1234: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1237: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1240: aload 16
    //   1242: invokevirtual 305	com/tencent/token/n:q	()V
    //   1245: goto -755 -> 490
    //   1248: aload_0
    //   1249: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   1252: astore 14
    //   1254: aload 14
    //   1256: getfield 347	com/tencent/token/ai:d	I
    //   1259: istore_1
    //   1260: aload 14
    //   1262: iload_1
    //   1263: iconst_1
    //   1264: iadd
    //   1265: putfield 347	com/tencent/token/ai:d	I
    //   1268: new 349	com/tencent/token/aj
    //   1271: dup
    //   1272: iload_1
    //   1273: aload_0
    //   1274: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   1277: invokespecial 352	com/tencent/token/aj:<init>	(ILcom/tencent/halley/downloader/c/d/a;)V
    //   1280: astore 14
    //   1282: aload 14
    //   1284: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   1287: lload 6
    //   1289: lsub
    //   1290: putfield 353	com/tencent/token/aj:c	J
    //   1293: aload 14
    //   1295: iload 12
    //   1297: putfield 354	com/tencent/token/aj:a	Z
    //   1300: aload 14
    //   1302: aload_0
    //   1303: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   1306: invokevirtual 355	com/tencent/token/ad:toString	()Ljava/lang/String;
    //   1309: putfield 357	com/tencent/token/aj:b	Ljava/lang/String;
    //   1312: aload 14
    //   1314: ldc 58
    //   1316: putfield 362	com/tencent/token/aj:f	Ljava/lang/String;
    //   1319: aload 16
    //   1321: invokevirtual 364	com/tencent/token/n:p	()V
    //   1324: aload_0
    //   1325: invokevirtual 233	com/tencent/token/af:a	()Z
    //   1328: istore 13
    //   1330: iload 13
    //   1332: ifeq +35 -> 1367
    //   1335: aload_0
    //   1336: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1339: aload_0
    //   1340: invokeinterface 301 2 0
    //   1345: aload_0
    //   1346: aconst_null
    //   1347: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1350: aload_0
    //   1351: aload 16
    //   1353: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1356: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1359: aload 16
    //   1361: invokevirtual 305	com/tencent/token/n:q	()V
    //   1364: goto -874 -> 490
    //   1367: aload_0
    //   1368: aload 16
    //   1370: invokevirtual 366	com/tencent/token/n:a	()I
    //   1373: putfield 56	com/tencent/token/af:i	I
    //   1376: aload_0
    //   1377: aload 16
    //   1379: invokevirtual 368	com/tencent/token/n:b	()Ljava/lang/String;
    //   1382: putfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   1385: aload 14
    //   1387: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   1390: lload 6
    //   1392: lsub
    //   1393: putfield 372	com/tencent/token/aj:d	J
    //   1396: aload 14
    //   1398: aload 16
    //   1400: invokevirtual 374	com/tencent/token/n:g	()Ljava/lang/String;
    //   1403: putfield 376	com/tencent/token/aj:g	Ljava/lang/String;
    //   1406: aload 14
    //   1408: aload 16
    //   1410: invokevirtual 378	com/tencent/token/n:i	()Ljava/lang/String;
    //   1413: putfield 380	com/tencent/token/aj:i	Ljava/lang/String;
    //   1416: aload 14
    //   1418: aload 16
    //   1420: invokevirtual 382	com/tencent/token/n:j	()Ljava/lang/String;
    //   1423: putfield 383	com/tencent/token/aj:j	Ljava/lang/String;
    //   1426: aload 14
    //   1428: aload 16
    //   1430: invokevirtual 385	com/tencent/token/n:c	()J
    //   1433: putfield 387	com/tencent/token/aj:h	J
    //   1436: aload 14
    //   1438: aload 16
    //   1440: invokevirtual 389	com/tencent/token/n:h	()Ljava/lang/String;
    //   1443: putfield 391	com/tencent/token/aj:k	Ljava/lang/String;
    //   1446: aload 14
    //   1448: aload 16
    //   1450: invokevirtual 393	com/tencent/token/n:k	()Ljava/lang/String;
    //   1453: putfield 395	com/tencent/token/aj:l	Ljava/lang/String;
    //   1456: aload 14
    //   1458: aload 16
    //   1460: invokevirtual 397	com/tencent/token/n:l	()Ljava/lang/String;
    //   1463: putfield 399	com/tencent/token/aj:m	Ljava/lang/String;
    //   1466: aload 14
    //   1468: aload 16
    //   1470: iconst_0
    //   1471: invokevirtual 402	com/tencent/token/n:a	(Z)Ljava/lang/String;
    //   1474: putfield 404	com/tencent/token/aj:r	Ljava/lang/String;
    //   1477: aload 14
    //   1479: aload 16
    //   1481: invokevirtual 406	com/tencent/token/n:f	()Ljava/lang/String;
    //   1484: putfield 409	com/tencent/token/aj:s	Ljava/lang/String;
    //   1487: aload_0
    //   1488: getfield 73	com/tencent/token/af:p	Lcom/tencent/token/ai;
    //   1491: aload 14
    //   1493: invokevirtual 412	com/tencent/token/ai:a	(Lcom/tencent/token/aj;)V
    //   1496: aload 16
    //   1498: astore 15
    //   1500: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   1503: lstore 10
    //   1505: ldc 128
    //   1507: new 130	java/lang/StringBuilder
    //   1510: dup
    //   1511: ldc_w 270
    //   1514: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1517: aload_0
    //   1518: getfield 48	com/tencent/token/af:c	Z
    //   1521: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1524: ldc_w 414
    //   1527: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload_0
    //   1531: getfield 56	com/tencent/token/af:i	I
    //   1534: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1537: ldc_w 309
    //   1540: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload_0
    //   1544: getfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   1547: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokestatic 283	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1556: aload_0
    //   1557: getfield 56	com/tencent/token/af:i	I
    //   1560: ifeq +151 -> 1711
    //   1563: aload_0
    //   1564: getfield 56	com/tencent/token/af:i	I
    //   1567: istore_1
    //   1568: iload_1
    //   1569: bipush 245
    //   1571: if_icmpne +35 -> 1606
    //   1574: aload_0
    //   1575: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1578: aload_0
    //   1579: invokeinterface 301 2 0
    //   1584: aload_0
    //   1585: aconst_null
    //   1586: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1589: aload_0
    //   1590: aload 15
    //   1592: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1595: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1598: aload 15
    //   1600: invokevirtual 305	com/tencent/token/n:q	()V
    //   1603: goto -1113 -> 490
    //   1606: aload_0
    //   1607: getfield 56	com/tencent/token/af:i	I
    //   1610: bipush 197
    //   1612: if_icmpne +68 -> 1680
    //   1615: iconst_1
    //   1616: istore 12
    //   1618: iconst_0
    //   1619: istore_3
    //   1620: goto +1008 -> 2628
    //   1623: iload_2
    //   1624: ifeq +760 -> 2384
    //   1627: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   1630: lstore 8
    //   1632: invokestatic 416	com/tencent/token/h:i	()I
    //   1635: pop
    //   1636: lload 8
    //   1638: lload 4
    //   1640: lsub
    //   1641: ldc2_w 417
    //   1644: lcmp
    //   1645: ifle +523 -> 2168
    //   1648: aload_0
    //   1649: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1652: aload_0
    //   1653: invokeinterface 301 2 0
    //   1658: aload_0
    //   1659: aconst_null
    //   1660: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1663: aload_0
    //   1664: aload 15
    //   1666: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1669: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1672: aload 15
    //   1674: invokevirtual 305	com/tencent/token/n:q	()V
    //   1677: goto -1187 -> 490
    //   1680: iconst_1
    //   1681: istore_3
    //   1682: goto +946 -> 2628
    //   1685: aload_0
    //   1686: getfield 56	com/tencent/token/af:i	I
    //   1689: istore_1
    //   1690: iload_1
    //   1691: bipush 240
    //   1693: if_icmpeq +954 -> 2647
    //   1696: iload_1
    //   1697: bipush 241
    //   1699: if_icmpeq +948 -> 2647
    //   1702: iload_1
    //   1703: bipush 204
    //   1705: if_icmpne +957 -> 2662
    //   1708: goto +939 -> 2647
    //   1711: aload_0
    //   1712: aload 15
    //   1714: invokespecial 420	com/tencent/token/af:a	(Lcom/tencent/token/i;)V
    //   1717: aload_0
    //   1718: invokevirtual 233	com/tencent/token/af:a	()Z
    //   1721: istore 13
    //   1723: iload 13
    //   1725: ifeq +35 -> 1760
    //   1728: aload_0
    //   1729: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1732: aload_0
    //   1733: invokeinterface 301 2 0
    //   1738: aload_0
    //   1739: aconst_null
    //   1740: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1743: aload_0
    //   1744: aload 15
    //   1746: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1749: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1752: aload 15
    //   1754: invokevirtual 305	com/tencent/token/n:q	()V
    //   1757: goto -1267 -> 490
    //   1760: aload_0
    //   1761: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1764: aload_0
    //   1765: aload_0
    //   1766: getfield 265	com/tencent/token/af:b	Lcom/tencent/halley/downloader/c/d/a;
    //   1769: aload 15
    //   1771: invokevirtual 422	com/tencent/token/n:e	()Ljava/lang/String;
    //   1774: aload 15
    //   1776: invokevirtual 385	com/tencent/token/n:c	()J
    //   1779: aload 15
    //   1781: invokevirtual 424	com/tencent/token/n:o	()Z
    //   1784: aload 15
    //   1786: invokevirtual 393	com/tencent/token/n:k	()Ljava/lang/String;
    //   1789: aload 15
    //   1791: invokevirtual 397	com/tencent/token/n:l	()Ljava/lang/String;
    //   1794: aload 15
    //   1796: invokevirtual 389	com/tencent/token/n:h	()Ljava/lang/String;
    //   1799: aload 15
    //   1801: invokevirtual 426	com/tencent/token/n:m	()Ljava/lang/String;
    //   1804: invokeinterface 429 11 0
    //   1809: astore 16
    //   1811: ldc 128
    //   1813: new 130	java/lang/StringBuilder
    //   1816: dup
    //   1817: ldc_w 270
    //   1820: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1823: aload_0
    //   1824: getfield 48	com/tencent/token/af:c	Z
    //   1827: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1830: ldc_w 431
    //   1833: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: aload 16
    //   1838: getfield 435	com/tencent/halley/common/g:a	I
    //   1841: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1844: ldc 210
    //   1846: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: aload 16
    //   1851: getfield 436	com/tencent/halley/common/g:b	Ljava/lang/String;
    //   1854: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: invokestatic 283	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1863: aload_0
    //   1864: invokevirtual 233	com/tencent/token/af:a	()Z
    //   1867: istore 13
    //   1869: iload 13
    //   1871: ifeq +35 -> 1906
    //   1874: aload_0
    //   1875: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1878: aload_0
    //   1879: invokeinterface 301 2 0
    //   1884: aload_0
    //   1885: aconst_null
    //   1886: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1889: aload_0
    //   1890: aload 15
    //   1892: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1895: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1898: aload 15
    //   1900: invokevirtual 305	com/tencent/token/n:q	()V
    //   1903: goto -1413 -> 490
    //   1906: aload 14
    //   1908: aload 16
    //   1910: getfield 435	com/tencent/halley/common/g:a	I
    //   1913: putfield 438	com/tencent/token/aj:n	I
    //   1916: aload 16
    //   1918: getfield 435	com/tencent/halley/common/g:a	I
    //   1921: ifne +210 -> 2131
    //   1924: aload_0
    //   1925: invokevirtual 233	com/tencent/token/af:a	()Z
    //   1928: istore 13
    //   1930: iload 13
    //   1932: ifeq +35 -> 1967
    //   1935: aload_0
    //   1936: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   1939: aload_0
    //   1940: invokeinterface 301 2 0
    //   1945: aload_0
    //   1946: aconst_null
    //   1947: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   1950: aload_0
    //   1951: aload 15
    //   1953: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   1956: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   1959: aload 15
    //   1961: invokevirtual 305	com/tencent/token/n:q	()V
    //   1964: goto -1474 -> 490
    //   1967: ldc 128
    //   1969: new 130	java/lang/StringBuilder
    //   1972: dup
    //   1973: ldc_w 270
    //   1976: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1979: aload_0
    //   1980: getfield 48	com/tencent/token/af:c	Z
    //   1983: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1986: ldc_w 440
    //   1989: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: aload_0
    //   1993: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   1996: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1999: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2002: invokestatic 283	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2005: aload 15
    //   2007: aload_0
    //   2008: invokevirtual 443	com/tencent/token/n:a	(Lcom/tencent/token/l;)V
    //   2011: aload_0
    //   2012: aload 15
    //   2014: invokevirtual 366	com/tencent/token/n:a	()I
    //   2017: putfield 56	com/tencent/token/af:i	I
    //   2020: aload_0
    //   2021: aload 15
    //   2023: invokevirtual 368	com/tencent/token/n:b	()Ljava/lang/String;
    //   2026: putfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   2029: ldc 128
    //   2031: new 130	java/lang/StringBuilder
    //   2034: dup
    //   2035: ldc_w 270
    //   2038: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2041: aload_0
    //   2042: getfield 48	com/tencent/token/af:c	Z
    //   2045: invokevirtual 169	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2048: ldc_w 445
    //   2051: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: aload_0
    //   2055: getfield 56	com/tencent/token/af:i	I
    //   2058: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2061: ldc_w 447
    //   2064: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2067: aload_0
    //   2068: getfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   2071: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2074: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2077: invokestatic 283	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2080: aload 14
    //   2082: aload_0
    //   2083: getfield 56	com/tencent/token/af:i	I
    //   2086: putfield 449	com/tencent/token/aj:o	I
    //   2089: aload 14
    //   2091: aload_0
    //   2092: getfield 178	com/tencent/token/af:a	Lcom/tencent/token/ad;
    //   2095: invokevirtual 355	com/tencent/token/ad:toString	()Ljava/lang/String;
    //   2098: putfield 451	com/tencent/token/aj:p	Ljava/lang/String;
    //   2101: aload 14
    //   2103: invokestatic 232	android/os/SystemClock:elapsedRealtime	()J
    //   2106: lload 6
    //   2108: lsub
    //   2109: putfield 453	com/tencent/token/aj:q	J
    //   2112: aload_0
    //   2113: getfield 56	com/tencent/token/af:i	I
    //   2116: ifeq +560 -> 2676
    //   2119: iconst_1
    //   2120: istore_3
    //   2121: iconst_0
    //   2122: istore_1
    //   2123: lconst_0
    //   2124: lstore 4
    //   2126: iconst_0
    //   2127: istore_2
    //   2128: goto -505 -> 1623
    //   2131: aload 16
    //   2133: getfield 435	com/tencent/halley/common/g:a	I
    //   2136: ifge +552 -> 2688
    //   2139: aload_0
    //   2140: aload 16
    //   2142: getfield 435	com/tencent/halley/common/g:a	I
    //   2145: putfield 56	com/tencent/token/af:i	I
    //   2148: aload_0
    //   2149: aload 16
    //   2151: getfield 436	com/tencent/halley/common/g:b	Ljava/lang/String;
    //   2154: putfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   2157: iconst_1
    //   2158: istore_3
    //   2159: iconst_1
    //   2160: istore_2
    //   2161: sipush 1000
    //   2164: istore_1
    //   2165: goto -542 -> 1623
    //   2168: aload_0
    //   2169: getfield 56	com/tencent/token/af:i	I
    //   2172: istore_2
    //   2173: iload_2
    //   2174: bipush 240
    //   2176: if_icmpeq +523 -> 2699
    //   2179: iload_2
    //   2180: bipush 241
    //   2182: if_icmpeq +517 -> 2699
    //   2185: iload_2
    //   2186: bipush 204
    //   2188: if_icmpne +58 -> 2246
    //   2191: goto +508 -> 2699
    //   2194: iload_2
    //   2195: ifeq +56 -> 2251
    //   2198: invokestatic 455	com/tencent/token/h:j	()I
    //   2201: pop
    //   2202: lload 8
    //   2204: lload 4
    //   2206: lsub
    //   2207: ldc2_w 456
    //   2210: lcmp
    //   2211: ifle +40 -> 2251
    //   2214: aload_0
    //   2215: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2218: aload_0
    //   2219: invokeinterface 301 2 0
    //   2224: aload_0
    //   2225: aconst_null
    //   2226: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2229: aload_0
    //   2230: aload 15
    //   2232: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2235: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2238: aload 15
    //   2240: invokevirtual 305	com/tencent/token/n:q	()V
    //   2243: goto -1753 -> 490
    //   2246: iconst_0
    //   2247: istore_2
    //   2248: goto -54 -> 2194
    //   2251: aload_0
    //   2252: getfield 56	com/tencent/token/af:i	I
    //   2255: istore_2
    //   2256: iload_2
    //   2257: bipush 246
    //   2259: if_icmpeq +445 -> 2704
    //   2262: iload_2
    //   2263: bipush 213
    //   2265: if_icmpne +58 -> 2323
    //   2268: goto +436 -> 2704
    //   2271: iload_2
    //   2272: ifeq +56 -> 2328
    //   2275: invokestatic 416	com/tencent/token/h:i	()I
    //   2278: pop
    //   2279: lload 8
    //   2281: lload 4
    //   2283: lsub
    //   2284: ldc2_w 458
    //   2287: lcmp
    //   2288: ifle +40 -> 2328
    //   2291: aload_0
    //   2292: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2295: aload_0
    //   2296: invokeinterface 301 2 0
    //   2301: aload_0
    //   2302: aconst_null
    //   2303: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2306: aload_0
    //   2307: aload 15
    //   2309: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2312: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2315: aload 15
    //   2317: invokevirtual 305	com/tencent/token/n:q	()V
    //   2320: goto -1830 -> 490
    //   2323: iconst_0
    //   2324: istore_2
    //   2325: goto -54 -> 2271
    //   2328: aload_0
    //   2329: getfield 56	com/tencent/token/af:i	I
    //   2332: bipush 241
    //   2334: if_icmpne +50 -> 2384
    //   2337: invokestatic 461	com/tencent/token/h:k	()I
    //   2340: istore_2
    //   2341: lload 8
    //   2343: lload 4
    //   2345: lsub
    //   2346: iload_2
    //   2347: i2l
    //   2348: lcmp
    //   2349: ifle +35 -> 2384
    //   2352: aload_0
    //   2353: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2356: aload_0
    //   2357: invokeinterface 301 2 0
    //   2362: aload_0
    //   2363: aconst_null
    //   2364: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2367: aload_0
    //   2368: aload 15
    //   2370: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2373: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2376: aload 15
    //   2378: invokevirtual 305	com/tencent/token/n:q	()V
    //   2381: goto -1891 -> 490
    //   2384: aload_0
    //   2385: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2388: aload_0
    //   2389: invokeinterface 301 2 0
    //   2394: aload_0
    //   2395: aconst_null
    //   2396: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2399: aload_0
    //   2400: aload 15
    //   2402: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2405: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2408: aload 15
    //   2410: invokevirtual 305	com/tencent/token/n:q	()V
    //   2413: iload 12
    //   2415: istore 13
    //   2417: goto -2392 -> 25
    //   2420: astore 15
    //   2422: aconst_null
    //   2423: astore 14
    //   2425: aload 15
    //   2427: invokevirtual 462	java/lang/Throwable:printStackTrace	()V
    //   2430: aload_0
    //   2431: bipush 195
    //   2433: putfield 56	com/tencent/token/af:i	I
    //   2436: aload_0
    //   2437: new 130	java/lang/StringBuilder
    //   2440: dup
    //   2441: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   2444: aload 15
    //   2446: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2449: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2452: putfield 60	com/tencent/token/af:j	Ljava/lang/String;
    //   2455: aload_0
    //   2456: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2459: aload_0
    //   2460: invokeinterface 301 2 0
    //   2465: aload_0
    //   2466: aconst_null
    //   2467: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2470: aload 14
    //   2472: ifnull -1982 -> 490
    //   2475: aload_0
    //   2476: aload 14
    //   2478: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2481: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2484: aload 14
    //   2486: invokevirtual 305	com/tencent/token/n:q	()V
    //   2489: goto -1999 -> 490
    //   2492: astore 14
    //   2494: aconst_null
    //   2495: astore 15
    //   2497: aload_0
    //   2498: getfield 83	com/tencent/token/af:g	Lcom/tencent/token/ae;
    //   2501: aload_0
    //   2502: invokeinterface 301 2 0
    //   2507: aload_0
    //   2508: aconst_null
    //   2509: putfield 197	com/tencent/token/af:n	Lcom/tencent/token/m;
    //   2512: aload 15
    //   2514: ifnull +17 -> 2531
    //   2517: aload_0
    //   2518: aload 15
    //   2520: invokevirtual 303	com/tencent/token/n:d	()Ljava/lang/String;
    //   2523: putfield 212	com/tencent/token/af:q	Ljava/lang/String;
    //   2526: aload 15
    //   2528: invokevirtual 305	com/tencent/token/n:q	()V
    //   2531: aload 14
    //   2533: athrow
    //   2534: astore 14
    //   2536: aload 14
    //   2538: invokevirtual 462	java/lang/Throwable:printStackTrace	()V
    //   2541: return
    //   2542: astore 16
    //   2544: aload 14
    //   2546: astore 15
    //   2548: aload 16
    //   2550: astore 14
    //   2552: goto -55 -> 2497
    //   2555: astore 14
    //   2557: aload 16
    //   2559: astore 15
    //   2561: goto -64 -> 2497
    //   2564: astore 14
    //   2566: goto -69 -> 2497
    //   2569: astore 16
    //   2571: aload 14
    //   2573: astore 15
    //   2575: aload 16
    //   2577: astore 14
    //   2579: goto -82 -> 2497
    //   2582: astore 15
    //   2584: goto -159 -> 2425
    //   2587: astore 15
    //   2589: aload 16
    //   2591: astore 14
    //   2593: goto -168 -> 2425
    //   2596: astore 16
    //   2598: aload 15
    //   2600: astore 14
    //   2602: aload 16
    //   2604: astore 15
    //   2606: goto -181 -> 2425
    //   2609: astore 14
    //   2611: goto -2251 -> 360
    //   2614: aload 14
    //   2616: astore 15
    //   2618: aload 16
    //   2620: astore 14
    //   2622: goto -1122 -> 1500
    //   2625: goto -2434 -> 191
    //   2628: lload 10
    //   2630: lload 8
    //   2632: lsub
    //   2633: ldc2_w 463
    //   2636: lcmp
    //   2637: ifle -952 -> 1685
    //   2640: iconst_1
    //   2641: istore_2
    //   2642: iconst_0
    //   2643: istore_1
    //   2644: goto -1021 -> 1623
    //   2647: iconst_1
    //   2648: istore_1
    //   2649: iload_1
    //   2650: ifeq +17 -> 2667
    //   2653: iconst_1
    //   2654: istore_2
    //   2655: sipush 3000
    //   2658: istore_1
    //   2659: goto -1036 -> 1623
    //   2662: iconst_0
    //   2663: istore_1
    //   2664: goto -15 -> 2649
    //   2667: iconst_1
    //   2668: istore_2
    //   2669: sipush 1000
    //   2672: istore_1
    //   2673: goto -1050 -> 1623
    //   2676: iconst_0
    //   2677: istore_3
    //   2678: iconst_0
    //   2679: istore_1
    //   2680: lconst_0
    //   2681: lstore 4
    //   2683: iconst_0
    //   2684: istore_2
    //   2685: goto -1062 -> 1623
    //   2688: iconst_0
    //   2689: istore_3
    //   2690: iconst_1
    //   2691: istore_2
    //   2692: sipush 1000
    //   2695: istore_1
    //   2696: goto -1073 -> 1623
    //   2699: iconst_1
    //   2700: istore_2
    //   2701: goto -507 -> 2194
    //   2704: iconst_1
    //   2705: istore_2
    //   2706: goto -435 -> 2271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2709	0	this	af
    //   24	2672	1	i1	int
    //   1623	1083	2	i2	int
    //   16	2674	3	i3	int
    //   21	2661	4	l1	long
    //   13	2094	6	l2	long
    //   966	1665	8	l3	long
    //   1503	1126	10	l4	long
    //   119	2295	12	bool1	boolean
    //   18	2398	13	bool2	boolean
    //   55	615	14	localObject1	Object
    //   693	445	14	localException1	java.lang.Exception
    //   1252	1233	14	localObject2	Object
    //   2492	40	14	localObject3	Object
    //   2534	11	14	localThrowable1	Throwable
    //   2550	1	14	localObject4	Object
    //   2555	1	14	localObject5	Object
    //   2564	8	14	localObject6	Object
    //   2577	24	14	localObject7	Object
    //   2609	6	14	localException2	java.lang.Exception
    //   2620	1	14	localObject8	Object
    //   102	558	15	localObject9	Object
    //   703	3	15	localInterruptedException	java.lang.InterruptedException
    //   713	243	15	localObject10	Object
    //   1498	911	15	localObject11	Object
    //   2420	25	15	localThrowable2	Throwable
    //   2495	79	15	localObject12	Object
    //   2582	1	15	localThrowable3	Throwable
    //   2587	12	15	localThrowable4	Throwable
    //   2604	13	15	localObject13	Object
    //   89	2061	16	localObject14	Object
    //   2542	16	16	localObject15	Object
    //   2569	21	16	localObject16	Object
    //   2596	23	16	localThrowable5	Throwable
    //   600	80	17	str	String
    // Exception table:
    //   from	to	target	type
    //   32	91	693	java/lang/Exception
    //   96	121	693	java/lang/Exception
    //   562	580	693	java/lang/Exception
    //   580	615	693	java/lang/Exception
    //   615	634	693	java/lang/Exception
    //   634	690	693	java/lang/Exception
    //   160	169	703	java/lang/InterruptedException
    //   160	169	713	finally
    //   169	172	713	finally
    //   705	710	713	finally
    //   380	386	2420	java/lang/Throwable
    //   396	400	2420	java/lang/Throwable
    //   400	444	2420	java/lang/Throwable
    //   380	386	2492	finally
    //   396	400	2492	finally
    //   400	444	2492	finally
    //   551	561	2534	java/lang/Throwable
    //   444	456	2542	finally
    //   889	979	2542	finally
    //   1016	1199	2542	finally
    //   1199	1211	2555	finally
    //   1248	1330	2555	finally
    //   1367	1496	2555	finally
    //   1500	1568	2564	finally
    //   1606	1615	2564	finally
    //   1627	1636	2564	finally
    //   1685	1690	2564	finally
    //   1711	1723	2564	finally
    //   1760	1869	2564	finally
    //   1906	1930	2564	finally
    //   1967	2119	2564	finally
    //   2131	2157	2564	finally
    //   2168	2173	2564	finally
    //   2198	2202	2564	finally
    //   2251	2256	2564	finally
    //   2275	2279	2564	finally
    //   2328	2341	2564	finally
    //   2425	2455	2569	finally
    //   444	456	2582	java/lang/Throwable
    //   889	979	2582	java/lang/Throwable
    //   1016	1199	2582	java/lang/Throwable
    //   1199	1211	2587	java/lang/Throwable
    //   1248	1330	2587	java/lang/Throwable
    //   1367	1496	2587	java/lang/Throwable
    //   1500	1568	2596	java/lang/Throwable
    //   1606	1615	2596	java/lang/Throwable
    //   1627	1636	2596	java/lang/Throwable
    //   1685	1690	2596	java/lang/Throwable
    //   1711	1723	2596	java/lang/Throwable
    //   1760	1869	2596	java/lang/Throwable
    //   1906	1930	2596	java/lang/Throwable
    //   1967	2119	2596	java/lang/Throwable
    //   2131	2157	2596	java/lang/Throwable
    //   2168	2173	2596	java/lang/Throwable
    //   2198	2202	2596	java/lang/Throwable
    //   2251	2256	2596	java/lang/Throwable
    //   2275	2279	2596	java/lang/Throwable
    //   2328	2341	2596	java/lang/Throwable
    //   322	360	2609	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.af
 * JD-Core Version:    0.7.0.1
 */