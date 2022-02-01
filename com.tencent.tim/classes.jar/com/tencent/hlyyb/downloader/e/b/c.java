package com.tencent.hlyyb.downloader.e.b;

import android.text.TextUtils;
import com.tencent.hlyyb.downloader.a.a.e;
import com.tencent.hlyyb.downloader.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
  implements com.tencent.hlyyb.downloader.a.a.d, com.tencent.hlyyb.downloader.a.b, com.tencent.hlyyb.downloader.b.d, Runnable
{
  private boolean A = false;
  private int B = 3;
  private boolean C = false;
  private volatile int D;
  private long E;
  private volatile boolean F = true;
  public a a;
  public com.tencent.hlyyb.downloader.e.d.a b;
  public volatile boolean c = false;
  private boolean d = true;
  private com.tencent.hlyyb.downloader.e.d.c e;
  private com.tencent.hlyyb.downloader.a.b f;
  private b g;
  private Map<String, String> h = null;
  private int i = 0;
  private String j = "";
  private boolean k = false;
  private boolean l = false;
  private e m;
  private Object n = new Object();
  private com.tencent.hlyyb.downloader.e.c.c o = new com.tencent.hlyyb.downloader.e.c.c();
  private String p;
  private boolean q = true;
  private List<com.tencent.hlyyb.downloader.b.c> r;
  private Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> s;
  private Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> t;
  private com.tencent.hlyyb.downloader.b.a u;
  private volatile boolean v = false;
  private AtomicInteger w;
  private AtomicInteger x;
  private boolean y = true;
  private boolean z = true;
  
  public c(com.tencent.hlyyb.downloader.e.d.c paramc, boolean paramBoolean1, com.tencent.hlyyb.downloader.a.b paramb, b paramb1, Map<String, String> paramMap, boolean paramBoolean2)
  {
    this.e = paramc;
    this.d = paramBoolean1;
    this.o.a = paramBoolean1;
    this.f = paramb;
    this.g = paramb1;
    this.h = paramMap;
    this.q = paramBoolean2;
  }
  
  private boolean b(com.tencent.hlyyb.downloader.e.d.a parama)
  {
    if (this.e.a() <= 0L) {}
    List localList;
    do
    {
      return false;
      localList = this.e.d();
    } while ((localList == null) || (localList.size() <= 0) || (TextUtils.isEmpty(this.e.c())) || (parama == null) || (this.s.get(parama) != null) || (!this.F) || (!this.q) || (!this.y));
    return true;
  }
  
  public final void a(com.tencent.hlyyb.downloader.e.d.a parama)
  {
    com.tencent.hlyyb.downloader.b.c localc = (com.tencent.hlyyb.downloader.b.c)this.s.get(parama);
    if ((localc != null) && (!localc.e)) {
      this.u.a(parama, localc);
    }
  }
  
  public final void a(List<com.tencent.hlyyb.downloader.b.c> paramList, Map<com.tencent.hlyyb.downloader.e.d.a, com.tencent.hlyyb.downloader.b.c> paramMap, Map<com.tencent.hlyyb.downloader.e.d.a, List<String>> paramMap1, com.tencent.hlyyb.downloader.b.a parama, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, long paramLong)
  {
    this.r = paramList;
    this.s = paramMap;
    this.t = paramMap1;
    this.u = parama;
    this.w = paramAtomicInteger1;
    this.x = paramAtomicInteger2;
    this.E = paramLong;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.F = false;
  }
  
  public final boolean a()
  {
    if (this.k) {}
    while (this.f == null) {
      return true;
    }
    return this.f.a();
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    int i2 = 0;
    com.tencent.hlyyb.downloader.b.c localc;
    if (b(this.b)) {
      localc = new com.tencent.hlyyb.downloader.b.c((i)this.f, this.e, this.b, this.r, this.s, this, false, this.x, this.w);
    }
    for (;;)
    {
      synchronized (this.r)
      {
        this.r.add(localc);
        this.s.put(this.b, localc);
        localc.h = this.E;
        localc.f = com.tencent.hlyyb.downloader.f.a.a().c(localc);
        if (this.d)
        {
          i1 = 0;
          localc.a(i1, this.D);
          ??? = (com.tencent.hlyyb.downloader.b.c)this.s.get(this.b);
          if ((??? == null) || (!((com.tencent.hlyyb.downloader.b.c)???).d) || (((com.tencent.hlyyb.downloader.b.c)???).e) || (!this.u.a(this.a, (com.tencent.hlyyb.downloader.b.c)???))) {
            break label226;
          }
          this.v = true;
          i1 = 1;
          if (i1 == 0) {
            break;
          }
          return false;
        }
      }
      i1 = 1;
      continue;
      label226:
      i1 = 0;
    }
    if (this.g != null)
    {
      if (this.a.f + paramInt < this.a.g) {
        break label309;
      }
      paramInt = (int)(this.a.g - this.a.f);
    }
    label309:
    for (int i1 = i2;; i1 = 1)
    {
      bool = i1 & this.g.a(this, this.a.f, paramArrayOfByte, paramInt, paramBoolean);
      return bool;
    }
  }
  
  public final com.tencent.hlyyb.downloader.e.d.a b()
  {
    Object localObject5;
    try
    {
      ArrayList localArrayList = new ArrayList();
      synchronized (this.r)
      {
        localObject5 = this.r.iterator();
        if (((Iterator)localObject5).hasNext()) {
          localArrayList.add(((com.tencent.hlyyb.downloader.b.c)((Iterator)localObject5).next()).b);
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      ??? = null;
      return ???;
    }
    ??? = this.e;
    boolean bool;
    if (this.w.get() >= this.B) {
      bool = true;
    }
    for (;;)
    {
      ??? = ((com.tencent.hlyyb.downloader.e.d.c)???).a((List)???, bool);
      ??? = ???;
      if (!b((com.tencent.hlyyb.downloader.e.d.a)???)) {
        break;
      }
      localObject5 = new com.tencent.hlyyb.downloader.b.c((i)this.f, this.e, (com.tencent.hlyyb.downloader.e.d.a)???, this.r, this.s, this, false, this.x, this.w);
      synchronized (this.r)
      {
        this.r.add(localObject5);
        this.s.put(???, localObject5);
        ((com.tencent.hlyyb.downloader.b.c)localObject5).h = this.E;
        ((com.tencent.hlyyb.downloader.b.c)localObject5).a = true;
        ((com.tencent.hlyyb.downloader.b.c)localObject5).f = com.tencent.hlyyb.downloader.f.a.a().c((Runnable)localObject5);
        return ???;
        bool = false;
      }
    }
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
    if (this.m != null) {
      this.m.s();
    }
  }
  
  public final void f()
  {
    try
    {
      this.k = true;
      if (this.m != null) {
        this.m.s();
      }
      synchronized (this.n)
      {
        this.n.notifyAll();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final boolean g()
  {
    return this.l;
  }
  
  public final String h()
  {
    if (this.o != null) {
      return this.o.a();
    }
    return "";
  }
  
  public final String i()
  {
    if (this.o != null) {
      return this.o.toString();
    }
    return "";
  }
  
  public final String j()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.d) {}
    for (int i1 = 0;; i1 = 1)
    {
      localStringBuilder1.append(i1).append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(",");
      localStringBuilder1.append(this.p).append(",");
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
  
  public final int k()
  {
    return this.D;
  }
  
  public final String l()
  {
    try
    {
      if (this.m != null)
      {
        String str = ((com.tencent.hlyyb.downloader.a.a.a)this.m).e();
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   4: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   7: putfield 310	com/tencent/hlyyb/downloader/e/c/c:b	J
    //   10: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   13: lstore 10
    //   15: iconst_0
    //   16: istore_2
    //   17: iconst_0
    //   18: istore 12
    //   20: lconst_0
    //   21: lstore 4
    //   23: iconst_1
    //   24: istore_1
    //   25: aload_0
    //   26: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   29: ifne +357 -> 386
    //   32: aload_0
    //   33: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   36: ifnull +350 -> 386
    //   39: aload_0
    //   40: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   43: invokeinterface 179 1 0
    //   48: istore 13
    //   50: iload 13
    //   52: ifne +673 -> 725
    //   55: aload_0
    //   56: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   59: ifne +55 -> 114
    //   62: aload_0
    //   63: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   66: sipush 15000
    //   69: invokevirtual 318	com/tencent/hlyyb/downloader/e/d/c:b	(I)V
    //   72: aload_0
    //   73: getfield 92	com/tencent/hlyyb/downloader/e/b/c:q	Z
    //   76: ifeq +38 -> 114
    //   79: aload_0
    //   80: getfield 100	com/tencent/hlyyb/downloader/e/b/c:z	Z
    //   83: ifeq +31 -> 114
    //   86: aload_0
    //   87: getfield 106	com/tencent/hlyyb/downloader/e/b/c:C	Z
    //   90: ifne +24 -> 114
    //   93: aload_0
    //   94: getfield 158	com/tencent/hlyyb/downloader/e/b/c:u	Lcom/tencent/hlyyb/downloader/b/a;
    //   97: aload_0
    //   98: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   101: invokevirtual 125	com/tencent/hlyyb/downloader/e/d/c:a	()J
    //   104: invokeinterface 321 3 0
    //   109: aload_0
    //   110: iconst_1
    //   111: putfield 106	com/tencent/hlyyb/downloader/e/b/c:C	Z
    //   114: aload_0
    //   115: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   118: ifne +294 -> 412
    //   121: aload_0
    //   122: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   125: ifnull +287 -> 412
    //   128: aload_0
    //   129: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   132: invokeinterface 179 1 0
    //   137: istore 13
    //   139: iload 13
    //   141: ifne +584 -> 725
    //   144: aload_0
    //   145: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   148: ifne +10 -> 158
    //   151: aload_0
    //   152: getfield 92	com/tencent/hlyyb/downloader/e/b/c:q	Z
    //   155: ifeq +570 -> 725
    //   158: iload_2
    //   159: ifle +24 -> 183
    //   162: aload_0
    //   163: getfield 85	com/tencent/hlyyb/downloader/e/b/c:n	Ljava/lang/Object;
    //   166: astore 15
    //   168: aload 15
    //   170: monitorenter
    //   171: aload_0
    //   172: getfield 85	com/tencent/hlyyb/downloader/e/b/c:n	Ljava/lang/Object;
    //   175: iload_2
    //   176: i2l
    //   177: invokevirtual 324	java/lang/Object:wait	(J)V
    //   180: aload 15
    //   182: monitorexit
    //   183: aload_0
    //   184: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   187: ifne +249 -> 436
    //   190: aload_0
    //   191: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   194: ifnull +242 -> 436
    //   197: aload_0
    //   198: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   201: invokeinterface 179 1 0
    //   206: istore 13
    //   208: iload 13
    //   210: ifne +515 -> 725
    //   213: lload 4
    //   215: lconst_0
    //   216: lcmp
    //   217: ifne +2744 -> 2961
    //   220: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   223: lstore 4
    //   225: iconst_0
    //   226: istore 13
    //   228: aload_0
    //   229: getfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   232: ifeq +2726 -> 2958
    //   235: iconst_1
    //   236: istore_1
    //   237: iconst_1
    //   238: istore 13
    //   240: aload_0
    //   241: iconst_0
    //   242: putfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   245: iload_1
    //   246: ifeq +202 -> 448
    //   249: aload_0
    //   250: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   253: sipush 404
    //   256: if_icmpeq +35 -> 291
    //   259: aload_0
    //   260: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   263: bipush 246
    //   265: if_icmpeq +26 -> 291
    //   268: aload_0
    //   269: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   272: bipush 245
    //   274: if_icmpeq +17 -> 291
    //   277: aload_0
    //   278: getfield 170	com/tencent/hlyyb/downloader/e/b/c:w	Ljava/util/concurrent/atomic/AtomicInteger;
    //   281: invokevirtual 259	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   284: aload_0
    //   285: getfield 104	com/tencent/hlyyb/downloader/e/b/c:B	I
    //   288: if_icmplt +154 -> 442
    //   291: iconst_1
    //   292: istore 14
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   299: invokestatic 328	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   302: aload_0
    //   303: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   306: aload_0
    //   307: getfield 71	com/tencent/hlyyb/downloader/e/b/c:d	Z
    //   310: iconst_0
    //   311: iload 13
    //   313: iload 14
    //   315: invokevirtual 331	com/tencent/hlyyb/downloader/e/d/c:a	(Ljava/lang/String;Lcom/tencent/hlyyb/downloader/e/d/a;ZZZZ)Lcom/tencent/hlyyb/downloader/e/d/a;
    //   318: putfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   321: aload_0
    //   322: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   325: iconst_1
    //   326: putfield 335	com/tencent/hlyyb/downloader/e/d/a:f	Z
    //   329: aload_0
    //   330: getfield 145	com/tencent/hlyyb/downloader/e/b/c:s	Ljava/util/Map;
    //   333: aload_0
    //   334: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   337: invokeinterface 151 2 0
    //   342: checkcast 154	com/tencent/hlyyb/downloader/b/c
    //   345: astore 15
    //   347: aload 15
    //   349: ifnull +168 -> 517
    //   352: aload 15
    //   354: getfield 336	com/tencent/hlyyb/downloader/b/c:c	Z
    //   357: ifeq +160 -> 517
    //   360: aload_0
    //   361: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   364: invokevirtual 338	com/tencent/hlyyb/downloader/e/d/c:e	()I
    //   367: ifle +150 -> 517
    //   370: aload 15
    //   372: getfield 156	com/tencent/hlyyb/downloader/b/c:e	Z
    //   375: ifne +142 -> 517
    //   378: aload_0
    //   379: iconst_1
    //   380: putfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   383: goto -358 -> 25
    //   386: iconst_1
    //   387: istore 13
    //   389: goto -339 -> 50
    //   392: astore 15
    //   394: aload 15
    //   396: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   399: goto -285 -> 114
    //   402: astore 15
    //   404: aload 15
    //   406: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   409: goto -295 -> 114
    //   412: iconst_1
    //   413: istore 13
    //   415: goto -276 -> 139
    //   418: astore 16
    //   420: aload 16
    //   422: invokevirtual 340	java/lang/InterruptedException:printStackTrace	()V
    //   425: goto -245 -> 180
    //   428: astore 16
    //   430: aload 15
    //   432: monitorexit
    //   433: aload 16
    //   435: athrow
    //   436: iconst_1
    //   437: istore 13
    //   439: goto -231 -> 208
    //   442: iconst_0
    //   443: istore 14
    //   445: goto -151 -> 294
    //   448: aload_0
    //   449: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   452: getfield 342	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   455: getstatic 345	com/tencent/hlyyb/downloader/e/d/b:b	I
    //   458: if_icmpeq +29 -> 487
    //   461: aload_0
    //   462: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   465: getfield 342	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   468: getstatic 347	com/tencent/hlyyb/downloader/e/d/b:a	I
    //   471: if_icmpeq +16 -> 487
    //   474: aload_0
    //   475: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   478: getfield 342	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   481: getstatic 349	com/tencent/hlyyb/downloader/e/d/b:g	I
    //   484: if_icmpne -163 -> 321
    //   487: aload_0
    //   488: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   491: aload_0
    //   492: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   495: getfield 342	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   498: invokevirtual 352	com/tencent/hlyyb/downloader/e/d/c:a	(I)Lcom/tencent/hlyyb/downloader/e/d/a;
    //   501: astore 15
    //   503: aload 15
    //   505: ifnull -184 -> 321
    //   508: aload_0
    //   509: aload 15
    //   511: putfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   514: goto -193 -> 321
    //   517: aload_0
    //   518: aload_0
    //   519: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   522: aload_0
    //   523: invokeinterface 355 2 0
    //   528: putfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   531: aload_0
    //   532: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   535: ifnull +190 -> 725
    //   538: iload 12
    //   540: ifeq +2415 -> 2955
    //   543: invokestatic 357	com/tencent/hlyyb/common/a/a:i	()Z
    //   546: ifne +2409 -> 2955
    //   549: iconst_0
    //   550: istore 12
    //   552: goto +2412 -> 2964
    //   555: aload_0
    //   556: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   559: astore 15
    //   561: aload_0
    //   562: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   565: invokeinterface 358 1 0
    //   570: istore 13
    //   572: aload 15
    //   574: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   577: lstore 8
    //   579: lload 8
    //   581: lstore 6
    //   583: iload_1
    //   584: ifle +25 -> 609
    //   587: aload 15
    //   589: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   592: ldc2_w 359
    //   595: lcmp
    //   596: ifne +163 -> 759
    //   599: aload 15
    //   601: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   604: iload_1
    //   605: i2l
    //   606: ladd
    //   607: lstore 6
    //   609: new 362	com/tencent/hlyyb/downloader/a/a/b
    //   612: dup
    //   613: aload 15
    //   615: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   618: lload 6
    //   620: invokespecial 365	com/tencent/hlyyb/downloader/a/a/b:<init>	(JJ)V
    //   623: astore 16
    //   625: new 367	com/tencent/hlyyb/downloader/a/a/f
    //   628: dup
    //   629: aload_0
    //   630: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   633: aload_0
    //   634: getfield 73	com/tencent/hlyyb/downloader/e/b/c:h	Ljava/util/Map;
    //   637: aload 16
    //   639: iload 12
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   646: getfield 368	com/tencent/hlyyb/downloader/e/d/a:d	Z
    //   649: iconst_1
    //   650: invokespecial 371	com/tencent/hlyyb/downloader/a/a/f:<init>	(Lcom/tencent/hlyyb/downloader/e/d/a;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/a/a/b;ZLcom/tencent/hlyyb/downloader/a/b;ZI)V
    //   653: astore 15
    //   655: aload_0
    //   656: aload 15
    //   658: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   661: aload_0
    //   662: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   665: ifne +149 -> 814
    //   668: aload_0
    //   669: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   672: ifnull +142 -> 814
    //   675: aload_0
    //   676: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   679: invokeinterface 179 1 0
    //   684: istore 13
    //   686: iload 13
    //   688: ifeq +132 -> 820
    //   691: aload_0
    //   692: iconst_0
    //   693: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   696: aload_0
    //   697: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   700: aload_0
    //   701: invokeinterface 374 2 0
    //   706: aload_0
    //   707: aconst_null
    //   708: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   711: aload_0
    //   712: aload 15
    //   714: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   717: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   720: aload 15
    //   722: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   725: aload_0
    //   726: iconst_1
    //   727: putfield 83	com/tencent/hlyyb/downloader/e/b/c:l	Z
    //   730: aload_0
    //   731: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   734: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   737: aload_0
    //   738: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   741: getfield 310	com/tencent/hlyyb/downloader/e/c/c:b	J
    //   744: lsub
    //   745: putfield 380	com/tencent/hlyyb/downloader/e/c/c:c	J
    //   748: aload_0
    //   749: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   752: aload_0
    //   753: invokeinterface 382 2 0
    //   758: return
    //   759: iload_1
    //   760: i2l
    //   761: lstore 6
    //   763: lload 6
    //   765: aload 15
    //   767: getfield 227	com/tencent/hlyyb/downloader/e/b/a:g	J
    //   770: aload 15
    //   772: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   775: lsub
    //   776: lcmp
    //   777: ifge +20 -> 797
    //   780: aload 15
    //   782: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   785: lstore 6
    //   787: lload 6
    //   789: iload_1
    //   790: i2l
    //   791: ladd
    //   792: lstore 6
    //   794: goto -185 -> 609
    //   797: lload 8
    //   799: lstore 6
    //   801: iload 13
    //   803: ifne -194 -> 609
    //   806: ldc2_w 359
    //   809: lstore 6
    //   811: goto -202 -> 609
    //   814: iconst_1
    //   815: istore 13
    //   817: goto -131 -> 686
    //   820: aload_0
    //   821: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   824: astore 17
    //   826: aload 17
    //   828: getfield 384	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   831: istore_1
    //   832: aload 17
    //   834: iload_1
    //   835: iconst_1
    //   836: iadd
    //   837: putfield 384	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   840: aload_0
    //   841: iload_1
    //   842: putfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   845: new 386	com/tencent/hlyyb/downloader/e/c/d
    //   848: dup
    //   849: aload_0
    //   850: getfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   853: aload_0
    //   854: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   857: invokespecial 389	com/tencent/hlyyb/downloader/e/c/d:<init>	(ILcom/tencent/hlyyb/downloader/e/d/a;)V
    //   860: astore 17
    //   862: aload 17
    //   864: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   867: lload 10
    //   869: lsub
    //   870: putfield 390	com/tencent/hlyyb/downloader/e/c/d:c	J
    //   873: aload 17
    //   875: iload 12
    //   877: putfield 391	com/tencent/hlyyb/downloader/e/c/d:a	Z
    //   880: aload 17
    //   882: aload_0
    //   883: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   886: invokevirtual 392	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   889: putfield 394	com/tencent/hlyyb/downloader/e/c/d:b	Ljava/lang/String;
    //   892: aload 17
    //   894: aload 16
    //   896: invokevirtual 395	com/tencent/hlyyb/downloader/a/a/b:toString	()Ljava/lang/String;
    //   899: putfield 397	com/tencent/hlyyb/downloader/e/c/d:f	Ljava/lang/String;
    //   902: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   905: lstore 6
    //   907: aload 15
    //   909: invokevirtual 399	com/tencent/hlyyb/downloader/a/a/f:p	()V
    //   912: aload_0
    //   913: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   916: ifne +63 -> 979
    //   919: aload_0
    //   920: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   923: ifnull +56 -> 979
    //   926: aload_0
    //   927: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   930: invokeinterface 179 1 0
    //   935: istore 13
    //   937: iload 13
    //   939: ifeq +46 -> 985
    //   942: aload_0
    //   943: iconst_0
    //   944: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   947: aload_0
    //   948: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   951: aload_0
    //   952: invokeinterface 374 2 0
    //   957: aload_0
    //   958: aconst_null
    //   959: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   962: aload_0
    //   963: aload 15
    //   965: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   968: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   971: aload 15
    //   973: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   976: goto -251 -> 725
    //   979: iconst_1
    //   980: istore 13
    //   982: goto -45 -> 937
    //   985: aload_0
    //   986: aload 15
    //   988: invokevirtual 401	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   991: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   994: aload_0
    //   995: aload 15
    //   997: invokevirtual 402	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   1000: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   1003: aload 17
    //   1005: aload_0
    //   1006: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1009: putfield 404	com/tencent/hlyyb/downloader/e/c/d:e	I
    //   1012: aload 17
    //   1014: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1017: lload 10
    //   1019: lsub
    //   1020: putfield 406	com/tencent/hlyyb/downloader/e/c/d:d	J
    //   1023: aload 17
    //   1025: aload 15
    //   1027: invokevirtual 408	com/tencent/hlyyb/downloader/a/a/f:g	()Ljava/lang/String;
    //   1030: putfield 410	com/tencent/hlyyb/downloader/e/c/d:g	Ljava/lang/String;
    //   1033: aload 17
    //   1035: aload 15
    //   1037: invokevirtual 412	com/tencent/hlyyb/downloader/a/a/f:i	()Ljava/lang/String;
    //   1040: putfield 414	com/tencent/hlyyb/downloader/e/c/d:i	Ljava/lang/String;
    //   1043: aload 17
    //   1045: aload 15
    //   1047: invokevirtual 416	com/tencent/hlyyb/downloader/a/a/f:j	()Ljava/lang/String;
    //   1050: putfield 417	com/tencent/hlyyb/downloader/e/c/d:j	Ljava/lang/String;
    //   1053: aload 17
    //   1055: aload 15
    //   1057: invokevirtual 419	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   1060: putfield 420	com/tencent/hlyyb/downloader/e/c/d:h	J
    //   1063: aload 17
    //   1065: aload 15
    //   1067: invokevirtual 422	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   1070: putfield 424	com/tencent/hlyyb/downloader/e/c/d:k	Ljava/lang/String;
    //   1073: aload 17
    //   1075: aload 15
    //   1077: invokevirtual 426	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   1080: putfield 428	com/tencent/hlyyb/downloader/e/c/d:l	Ljava/lang/String;
    //   1083: aload 17
    //   1085: aload 15
    //   1087: invokevirtual 430	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   1090: putfield 432	com/tencent/hlyyb/downloader/e/c/d:m	Ljava/lang/String;
    //   1093: aload 17
    //   1095: aload 15
    //   1097: iconst_0
    //   1098: invokevirtual 435	com/tencent/hlyyb/downloader/a/a/f:a	(Z)Ljava/lang/String;
    //   1101: putfield 437	com/tencent/hlyyb/downloader/e/c/d:r	Ljava/lang/String;
    //   1104: aload 17
    //   1106: aload 15
    //   1108: invokevirtual 439	com/tencent/hlyyb/downloader/a/a/f:f	()Ljava/lang/String;
    //   1111: putfield 441	com/tencent/hlyyb/downloader/e/c/d:s	Ljava/lang/String;
    //   1114: aload_0
    //   1115: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1118: aload 17
    //   1120: invokevirtual 444	com/tencent/hlyyb/downloader/e/c/c:a	(Lcom/tencent/hlyyb/downloader/e/c/d;)V
    //   1123: aload_0
    //   1124: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1127: bipush 203
    //   1129: if_icmpne +1810 -> 2939
    //   1132: aload_0
    //   1133: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1136: invokeinterface 358 1 0
    //   1141: ifne +1798 -> 2939
    //   1144: new 367	com/tencent/hlyyb/downloader/a/a/f
    //   1147: dup
    //   1148: aload_0
    //   1149: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1152: aload_0
    //   1153: getfield 73	com/tencent/hlyyb/downloader/e/b/c:h	Ljava/util/Map;
    //   1156: aconst_null
    //   1157: iload 12
    //   1159: aload_0
    //   1160: aload_0
    //   1161: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1164: getfield 368	com/tencent/hlyyb/downloader/e/d/a:d	Z
    //   1167: iconst_1
    //   1168: invokespecial 371	com/tencent/hlyyb/downloader/a/a/f:<init>	(Lcom/tencent/hlyyb/downloader/e/d/a;Ljava/util/Map;Lcom/tencent/hlyyb/downloader/a/a/b;ZLcom/tencent/hlyyb/downloader/a/b;ZI)V
    //   1171: astore 17
    //   1173: aload_0
    //   1174: aload 17
    //   1176: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1179: aload_0
    //   1180: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1183: ifne +63 -> 1246
    //   1186: aload_0
    //   1187: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1190: ifnull +56 -> 1246
    //   1193: aload_0
    //   1194: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1197: invokeinterface 179 1 0
    //   1202: istore 13
    //   1204: iload 13
    //   1206: ifeq +46 -> 1252
    //   1209: aload_0
    //   1210: iconst_0
    //   1211: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1214: aload_0
    //   1215: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1218: aload_0
    //   1219: invokeinterface 374 2 0
    //   1224: aload_0
    //   1225: aconst_null
    //   1226: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1229: aload_0
    //   1230: aload 17
    //   1232: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1235: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1238: aload 17
    //   1240: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1243: goto -518 -> 725
    //   1246: iconst_1
    //   1247: istore 13
    //   1249: goto -45 -> 1204
    //   1252: aload_0
    //   1253: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1256: astore 15
    //   1258: aload 15
    //   1260: getfield 384	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   1263: istore_1
    //   1264: aload 15
    //   1266: iload_1
    //   1267: iconst_1
    //   1268: iadd
    //   1269: putfield 384	com/tencent/hlyyb/downloader/e/c/c:d	I
    //   1272: aload_0
    //   1273: iload_1
    //   1274: putfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   1277: new 386	com/tencent/hlyyb/downloader/e/c/d
    //   1280: dup
    //   1281: aload_0
    //   1282: getfield 212	com/tencent/hlyyb/downloader/e/b/c:D	I
    //   1285: aload_0
    //   1286: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1289: invokespecial 389	com/tencent/hlyyb/downloader/e/c/d:<init>	(ILcom/tencent/hlyyb/downloader/e/d/a;)V
    //   1292: astore 15
    //   1294: aload 15
    //   1296: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1299: lload 10
    //   1301: lsub
    //   1302: putfield 390	com/tencent/hlyyb/downloader/e/c/d:c	J
    //   1305: aload 15
    //   1307: iload 12
    //   1309: putfield 391	com/tencent/hlyyb/downloader/e/c/d:a	Z
    //   1312: aload 15
    //   1314: aload_0
    //   1315: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   1318: invokevirtual 392	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   1321: putfield 394	com/tencent/hlyyb/downloader/e/c/d:b	Ljava/lang/String;
    //   1324: aload 15
    //   1326: ldc 77
    //   1328: putfield 397	com/tencent/hlyyb/downloader/e/c/d:f	Ljava/lang/String;
    //   1331: aload 17
    //   1333: invokevirtual 399	com/tencent/hlyyb/downloader/a/a/f:p	()V
    //   1336: aload_0
    //   1337: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1340: ifne +63 -> 1403
    //   1343: aload_0
    //   1344: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1347: ifnull +56 -> 1403
    //   1350: aload_0
    //   1351: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1354: invokeinterface 179 1 0
    //   1359: istore 13
    //   1361: iload 13
    //   1363: ifeq +46 -> 1409
    //   1366: aload_0
    //   1367: iconst_0
    //   1368: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1371: aload_0
    //   1372: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1375: aload_0
    //   1376: invokeinterface 374 2 0
    //   1381: aload_0
    //   1382: aconst_null
    //   1383: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1386: aload_0
    //   1387: aload 17
    //   1389: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1392: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1395: aload 17
    //   1397: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1400: goto -675 -> 725
    //   1403: iconst_1
    //   1404: istore 13
    //   1406: goto -45 -> 1361
    //   1409: aload_0
    //   1410: aload 17
    //   1412: invokevirtual 401	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   1415: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1418: aload_0
    //   1419: aload 17
    //   1421: invokevirtual 402	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   1424: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   1427: aload 15
    //   1429: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1432: lload 10
    //   1434: lsub
    //   1435: putfield 406	com/tencent/hlyyb/downloader/e/c/d:d	J
    //   1438: aload 15
    //   1440: aload 17
    //   1442: invokevirtual 408	com/tencent/hlyyb/downloader/a/a/f:g	()Ljava/lang/String;
    //   1445: putfield 410	com/tencent/hlyyb/downloader/e/c/d:g	Ljava/lang/String;
    //   1448: aload 15
    //   1450: aload 17
    //   1452: invokevirtual 412	com/tencent/hlyyb/downloader/a/a/f:i	()Ljava/lang/String;
    //   1455: putfield 414	com/tencent/hlyyb/downloader/e/c/d:i	Ljava/lang/String;
    //   1458: aload 15
    //   1460: aload 17
    //   1462: invokevirtual 416	com/tencent/hlyyb/downloader/a/a/f:j	()Ljava/lang/String;
    //   1465: putfield 417	com/tencent/hlyyb/downloader/e/c/d:j	Ljava/lang/String;
    //   1468: aload 15
    //   1470: aload 17
    //   1472: invokevirtual 419	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   1475: putfield 420	com/tencent/hlyyb/downloader/e/c/d:h	J
    //   1478: aload 15
    //   1480: aload 17
    //   1482: invokevirtual 422	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   1485: putfield 424	com/tencent/hlyyb/downloader/e/c/d:k	Ljava/lang/String;
    //   1488: aload 15
    //   1490: aload 17
    //   1492: invokevirtual 426	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   1495: putfield 428	com/tencent/hlyyb/downloader/e/c/d:l	Ljava/lang/String;
    //   1498: aload 15
    //   1500: aload 17
    //   1502: invokevirtual 430	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   1505: putfield 432	com/tencent/hlyyb/downloader/e/c/d:m	Ljava/lang/String;
    //   1508: aload 15
    //   1510: aload 17
    //   1512: iconst_0
    //   1513: invokevirtual 435	com/tencent/hlyyb/downloader/a/a/f:a	(Z)Ljava/lang/String;
    //   1516: putfield 437	com/tencent/hlyyb/downloader/e/c/d:r	Ljava/lang/String;
    //   1519: aload 15
    //   1521: aload 17
    //   1523: invokevirtual 439	com/tencent/hlyyb/downloader/a/a/f:f	()Ljava/lang/String;
    //   1526: putfield 441	com/tencent/hlyyb/downloader/e/c/d:s	Ljava/lang/String;
    //   1529: aload_0
    //   1530: getfield 90	com/tencent/hlyyb/downloader/e/b/c:o	Lcom/tencent/hlyyb/downloader/e/c/c;
    //   1533: aload 15
    //   1535: invokevirtual 444	com/tencent/hlyyb/downloader/e/c/c:a	(Lcom/tencent/hlyyb/downloader/e/c/d;)V
    //   1538: aload 17
    //   1540: astore 16
    //   1542: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1545: lstore 8
    //   1547: aload_0
    //   1548: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1551: ifeq +109 -> 1660
    //   1554: aload_0
    //   1555: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1558: bipush 197
    //   1560: if_icmpne +69 -> 1629
    //   1563: iconst_1
    //   1564: istore 12
    //   1566: iconst_0
    //   1567: istore_3
    //   1568: goto +1408 -> 2976
    //   1571: iload_2
    //   1572: ifeq +1209 -> 2781
    //   1575: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   1578: lstore 6
    //   1580: lload 6
    //   1582: lload 4
    //   1584: lsub
    //   1585: ldc2_w 445
    //   1588: lcmp
    //   1589: ifle +789 -> 2378
    //   1592: aload_0
    //   1593: iconst_0
    //   1594: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1597: aload_0
    //   1598: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1601: aload_0
    //   1602: invokeinterface 374 2 0
    //   1607: aload_0
    //   1608: aconst_null
    //   1609: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1612: aload_0
    //   1613: aload 16
    //   1615: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1618: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1621: aload 16
    //   1623: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1626: goto -901 -> 725
    //   1629: iconst_1
    //   1630: istore_3
    //   1631: goto +1345 -> 2976
    //   1634: aload_0
    //   1635: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1638: istore_1
    //   1639: iload_1
    //   1640: bipush 240
    //   1642: if_icmpeq +1353 -> 2995
    //   1645: iload_1
    //   1646: bipush 241
    //   1648: if_icmpeq +1347 -> 2995
    //   1651: iload_1
    //   1652: bipush 179
    //   1654: if_icmpne +1356 -> 3010
    //   1657: goto +1338 -> 2995
    //   1660: aload_0
    //   1661: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   1664: iconst_0
    //   1665: invokevirtual 449	com/tencent/hlyyb/downloader/e/d/c:a	(Z)Z
    //   1668: ifeq +164 -> 1832
    //   1671: aload 16
    //   1673: invokevirtual 451	com/tencent/hlyyb/downloader/a/a/a:n	()Ljava/util/List;
    //   1676: astore 17
    //   1678: aload 17
    //   1680: ifnull +152 -> 1832
    //   1683: aload 17
    //   1685: invokeinterface 134 1 0
    //   1690: ifle +142 -> 1832
    //   1693: aload 17
    //   1695: invokeinterface 242 1 0
    //   1700: astore 17
    //   1702: aload 17
    //   1704: invokeinterface 247 1 0
    //   1709: ifeq +115 -> 1824
    //   1712: aload 17
    //   1714: invokeinterface 251 1 0
    //   1719: checkcast 453	java/lang/String
    //   1722: astore 18
    //   1724: aload_0
    //   1725: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   1728: invokestatic 328	com/tencent/hlyyb/common/a/a:b	()Ljava/lang/String;
    //   1731: aload 18
    //   1733: getstatic 454	com/tencent/hlyyb/downloader/e/d/b:e	I
    //   1736: invokevirtual 457	com/tencent/hlyyb/downloader/e/d/c:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1739: goto -37 -> 1702
    //   1742: astore 17
    //   1744: aload 16
    //   1746: astore 15
    //   1748: aload 17
    //   1750: astore 16
    //   1752: aload 16
    //   1754: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   1757: aload_0
    //   1758: bipush 195
    //   1760: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   1763: aload_0
    //   1764: new 281	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   1771: aload 16
    //   1773: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1776: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1779: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   1782: aload_0
    //   1783: iconst_0
    //   1784: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1787: aload_0
    //   1788: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1791: aload_0
    //   1792: invokeinterface 374 2 0
    //   1797: aload_0
    //   1798: aconst_null
    //   1799: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1802: aload 15
    //   1804: ifnull -1079 -> 725
    //   1807: aload_0
    //   1808: aload 15
    //   1810: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1813: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1816: aload 15
    //   1818: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1821: goto -1096 -> 725
    //   1824: aload_0
    //   1825: getfield 110	com/tencent/hlyyb/downloader/e/b/c:e	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   1828: iconst_0
    //   1829: invokevirtual 462	com/tencent/hlyyb/downloader/e/d/c:b	(Z)V
    //   1832: aload_0
    //   1833: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1836: ifne +63 -> 1899
    //   1839: aload_0
    //   1840: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1843: ifnull +56 -> 1899
    //   1846: aload_0
    //   1847: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1850: invokeinterface 179 1 0
    //   1855: istore 13
    //   1857: iload 13
    //   1859: ifeq +46 -> 1905
    //   1862: aload_0
    //   1863: iconst_0
    //   1864: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1867: aload_0
    //   1868: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1871: aload_0
    //   1872: invokeinterface 374 2 0
    //   1877: aload_0
    //   1878: aconst_null
    //   1879: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   1882: aload_0
    //   1883: aload 16
    //   1885: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   1888: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   1891: aload 16
    //   1893: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   1896: goto -1171 -> 725
    //   1899: iconst_1
    //   1900: istore 13
    //   1902: goto -45 -> 1857
    //   1905: aload_0
    //   1906: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1909: aload_0
    //   1910: aload_0
    //   1911: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   1914: aload 16
    //   1916: invokevirtual 463	com/tencent/hlyyb/downloader/a/a/f:e	()Ljava/lang/String;
    //   1919: aload 16
    //   1921: invokevirtual 419	com/tencent/hlyyb/downloader/a/a/f:c	()J
    //   1924: aload 16
    //   1926: invokevirtual 465	com/tencent/hlyyb/downloader/a/a/f:o	()Z
    //   1929: aload 16
    //   1931: invokevirtual 426	com/tencent/hlyyb/downloader/a/a/f:k	()Ljava/lang/String;
    //   1934: aload 16
    //   1936: invokevirtual 430	com/tencent/hlyyb/downloader/a/a/f:l	()Ljava/lang/String;
    //   1939: aload 16
    //   1941: invokevirtual 422	com/tencent/hlyyb/downloader/a/a/f:h	()Ljava/lang/String;
    //   1944: aload 16
    //   1946: invokevirtual 467	com/tencent/hlyyb/downloader/a/a/f:m	()Ljava/lang/String;
    //   1949: invokeinterface 470 11 0
    //   1954: astore 17
    //   1956: aload_0
    //   1957: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   1960: ifne +63 -> 2023
    //   1963: aload_0
    //   1964: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1967: ifnull +56 -> 2023
    //   1970: aload_0
    //   1971: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   1974: invokeinterface 179 1 0
    //   1979: istore 13
    //   1981: iload 13
    //   1983: ifeq +46 -> 2029
    //   1986: aload_0
    //   1987: iconst_0
    //   1988: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   1991: aload_0
    //   1992: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   1995: aload_0
    //   1996: invokeinterface 374 2 0
    //   2001: aload_0
    //   2002: aconst_null
    //   2003: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2006: aload_0
    //   2007: aload 16
    //   2009: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2012: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2015: aload 16
    //   2017: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2020: goto -1295 -> 725
    //   2023: iconst_1
    //   2024: istore 13
    //   2026: goto -45 -> 1981
    //   2029: aload 15
    //   2031: aload 17
    //   2033: getfield 473	com/tencent/hlyyb/common/a/f:a	I
    //   2036: putfield 475	com/tencent/hlyyb/downloader/e/c/d:n	I
    //   2039: aload 17
    //   2041: getfield 473	com/tencent/hlyyb/common/a/f:a	I
    //   2044: ifne +297 -> 2341
    //   2047: aload_0
    //   2048: getfield 81	com/tencent/hlyyb/downloader/e/b/c:k	Z
    //   2051: ifne +63 -> 2114
    //   2054: aload_0
    //   2055: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2058: ifnull +56 -> 2114
    //   2061: aload_0
    //   2062: getfield 114	com/tencent/hlyyb/downloader/e/b/c:f	Lcom/tencent/hlyyb/downloader/a/b;
    //   2065: invokeinterface 179 1 0
    //   2070: istore 13
    //   2072: iload 13
    //   2074: ifeq +46 -> 2120
    //   2077: aload_0
    //   2078: iconst_0
    //   2079: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2082: aload_0
    //   2083: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2086: aload_0
    //   2087: invokeinterface 374 2 0
    //   2092: aload_0
    //   2093: aconst_null
    //   2094: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2097: aload_0
    //   2098: aload 16
    //   2100: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2103: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2106: aload 16
    //   2108: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2111: goto -1386 -> 725
    //   2114: iconst_1
    //   2115: istore 13
    //   2117: goto -45 -> 2072
    //   2120: aload_0
    //   2121: iconst_1
    //   2122: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2125: aload 16
    //   2127: aload_0
    //   2128: invokevirtual 478	com/tencent/hlyyb/downloader/a/a/f:a	(Lcom/tencent/hlyyb/downloader/a/a/d;)V
    //   2131: aload_0
    //   2132: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2135: astore 17
    //   2137: aload_0
    //   2138: iconst_0
    //   2139: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2142: aload 17
    //   2144: iconst_0
    //   2145: putfield 335	com/tencent/hlyyb/downloader/e/d/a:f	Z
    //   2148: aload_0
    //   2149: aload 16
    //   2151: invokevirtual 401	com/tencent/hlyyb/downloader/a/a/f:a	()I
    //   2154: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2157: aload_0
    //   2158: aload 16
    //   2160: invokevirtual 402	com/tencent/hlyyb/downloader/a/a/f:b	()Ljava/lang/String;
    //   2163: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   2166: aload 15
    //   2168: aload_0
    //   2169: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2172: putfield 480	com/tencent/hlyyb/downloader/e/c/d:o	I
    //   2175: aload 15
    //   2177: aload_0
    //   2178: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2181: invokevirtual 392	com/tencent/hlyyb/downloader/e/b/a:toString	()Ljava/lang/String;
    //   2184: putfield 481	com/tencent/hlyyb/downloader/e/c/d:p	Ljava/lang/String;
    //   2187: aload 15
    //   2189: invokestatic 315	android/os/SystemClock:elapsedRealtime	()J
    //   2192: lload 10
    //   2194: lsub
    //   2195: putfield 483	com/tencent/hlyyb/downloader/e/c/d:q	J
    //   2198: aload_0
    //   2199: getfield 96	com/tencent/hlyyb/downloader/e/b/c:v	Z
    //   2202: ifne +120 -> 2322
    //   2205: aload_0
    //   2206: getfield 168	com/tencent/hlyyb/downloader/e/b/c:t	Ljava/util/Map;
    //   2209: aload_0
    //   2210: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2213: invokeinterface 151 2 0
    //   2218: checkcast 130	java/util/List
    //   2221: astore 17
    //   2223: aload 17
    //   2225: astore 15
    //   2227: aload 17
    //   2229: ifnonnull +31 -> 2260
    //   2232: new 237	java/util/ArrayList
    //   2235: dup
    //   2236: invokespecial 238	java/util/ArrayList:<init>	()V
    //   2239: invokestatic 489	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   2242: astore 15
    //   2244: aload_0
    //   2245: getfield 168	com/tencent/hlyyb/downloader/e/b/c:t	Ljava/util/Map;
    //   2248: aload_0
    //   2249: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2252: aload 15
    //   2254: invokeinterface 197 3 0
    //   2259: pop
    //   2260: aload_0
    //   2261: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2264: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   2267: aload_0
    //   2268: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2271: getfield 490	com/tencent/hlyyb/downloader/e/b/a:d	J
    //   2274: lcmp
    //   2275: ifle +47 -> 2322
    //   2278: aload 15
    //   2280: new 281	java/lang/StringBuilder
    //   2283: dup
    //   2284: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   2287: aload_0
    //   2288: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2291: getfield 490	com/tencent/hlyyb/downloader/e/b/a:d	J
    //   2294: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2297: ldc_w 292
    //   2300: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: aload_0
    //   2304: getfield 218	com/tencent/hlyyb/downloader/e/b/c:a	Lcom/tencent/hlyyb/downloader/e/b/a;
    //   2307: getfield 225	com/tencent/hlyyb/downloader/e/b/a:f	J
    //   2310: invokevirtual 493	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2313: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2316: invokeinterface 193 2 0
    //   2321: pop
    //   2322: aload_0
    //   2323: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2326: ifeq +698 -> 3024
    //   2329: iconst_1
    //   2330: istore_3
    //   2331: iconst_0
    //   2332: istore_2
    //   2333: iconst_0
    //   2334: istore_1
    //   2335: lconst_0
    //   2336: lstore 4
    //   2338: goto -767 -> 1571
    //   2341: aload 17
    //   2343: getfield 473	com/tencent/hlyyb/common/a/f:a	I
    //   2346: ifge +690 -> 3036
    //   2349: aload_0
    //   2350: aload 17
    //   2352: getfield 473	com/tencent/hlyyb/common/a/f:a	I
    //   2355: putfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2358: aload_0
    //   2359: aload 17
    //   2361: getfield 494	com/tencent/hlyyb/common/a/f:b	Ljava/lang/String;
    //   2364: putfield 79	com/tencent/hlyyb/downloader/e/b/c:j	Ljava/lang/String;
    //   2367: iconst_1
    //   2368: istore_3
    //   2369: iconst_1
    //   2370: istore_2
    //   2371: sipush 1000
    //   2374: istore_1
    //   2375: goto -804 -> 1571
    //   2378: aload_0
    //   2379: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2382: istore_2
    //   2383: iload_2
    //   2384: bipush 240
    //   2386: if_icmpeq +15 -> 2401
    //   2389: iload_2
    //   2390: bipush 241
    //   2392: if_icmpeq +9 -> 2401
    //   2395: iload_2
    //   2396: bipush 179
    //   2398: if_icmpne +58 -> 2456
    //   2401: iconst_1
    //   2402: istore_2
    //   2403: iload_2
    //   2404: ifeq +57 -> 2461
    //   2407: lload 6
    //   2409: lload 4
    //   2411: lsub
    //   2412: ldc2_w 495
    //   2415: lcmp
    //   2416: ifle +45 -> 2461
    //   2419: aload_0
    //   2420: iconst_0
    //   2421: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2424: aload_0
    //   2425: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2428: aload_0
    //   2429: invokeinterface 374 2 0
    //   2434: aload_0
    //   2435: aconst_null
    //   2436: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2439: aload_0
    //   2440: aload 16
    //   2442: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2445: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2448: aload 16
    //   2450: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2453: goto -1728 -> 725
    //   2456: iconst_0
    //   2457: istore_2
    //   2458: goto -55 -> 2403
    //   2461: aload_0
    //   2462: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2465: istore_2
    //   2466: iload_2
    //   2467: lookupswitch	default:+105->2572, -76:+178->2645, -73:+178->2645, -71:+178->2645, -68:+178->2645, -56:+178->2645, -55:+178->2645, -54:+178->2645, -51:+178->2645, -44:+178->2645, -43:+178->2645, -11:+178->2645, -10:+178->2645
    //   2573: ifle +77 -> 2650
    //   2576: iload_2
    //   2577: sipush 200
    //   2580: if_icmpeq +70 -> 2650
    //   2583: iload_2
    //   2584: sipush 206
    //   2587: if_icmpeq +63 -> 2650
    //   2590: iconst_1
    //   2591: istore_2
    //   2592: iload_2
    //   2593: ifeq +62 -> 2655
    //   2596: lload 6
    //   2598: lload 4
    //   2600: lsub
    //   2601: ldc2_w 497
    //   2604: lcmp
    //   2605: ifle +50 -> 2655
    //   2608: aload_0
    //   2609: iconst_0
    //   2610: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2613: aload_0
    //   2614: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2617: aload_0
    //   2618: invokeinterface 374 2 0
    //   2623: aload_0
    //   2624: aconst_null
    //   2625: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2628: aload_0
    //   2629: aload 16
    //   2631: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2634: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2637: aload 16
    //   2639: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2642: goto -1917 -> 725
    //   2645: iconst_1
    //   2646: istore_2
    //   2647: goto -55 -> 2592
    //   2650: iconst_0
    //   2651: istore_2
    //   2652: goto -60 -> 2592
    //   2655: aload_0
    //   2656: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2659: bipush 241
    //   2661: if_icmpne +55 -> 2716
    //   2664: invokestatic 502	com/tencent/hlyyb/downloader/a/a:d	()I
    //   2667: istore_2
    //   2668: lload 6
    //   2670: lload 4
    //   2672: lsub
    //   2673: iload_2
    //   2674: i2l
    //   2675: lcmp
    //   2676: ifle +40 -> 2716
    //   2679: aload_0
    //   2680: iconst_0
    //   2681: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2684: aload_0
    //   2685: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2688: aload_0
    //   2689: invokeinterface 374 2 0
    //   2694: aload_0
    //   2695: aconst_null
    //   2696: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2699: aload_0
    //   2700: aload 16
    //   2702: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2705: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2708: aload 16
    //   2710: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2713: goto -1988 -> 725
    //   2716: aload_0
    //   2717: getfield 75	com/tencent/hlyyb/downloader/e/b/c:i	I
    //   2720: bipush 205
    //   2722: if_icmpne +59 -> 2781
    //   2725: aload_0
    //   2726: getfield 182	com/tencent/hlyyb/downloader/e/b/c:b	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   2729: getfield 342	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   2732: getstatic 345	com/tencent/hlyyb/downloader/e/d/b:b	I
    //   2735: if_icmpne +46 -> 2781
    //   2738: ldc2_w 503
    //   2741: invokestatic 507	android/os/SystemClock:sleep	(J)V
    //   2744: aload_0
    //   2745: iconst_0
    //   2746: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2749: aload_0
    //   2750: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2753: aload_0
    //   2754: invokeinterface 374 2 0
    //   2759: aload_0
    //   2760: aconst_null
    //   2761: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2764: aload_0
    //   2765: aload 16
    //   2767: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2770: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2773: aload 16
    //   2775: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2778: goto -2053 -> 725
    //   2781: aload_0
    //   2782: iconst_0
    //   2783: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2786: aload_0
    //   2787: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2790: aload_0
    //   2791: invokeinterface 374 2 0
    //   2796: aload_0
    //   2797: aconst_null
    //   2798: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2801: aload_0
    //   2802: aload 16
    //   2804: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2807: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2810: aload 16
    //   2812: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2815: iload_1
    //   2816: istore_2
    //   2817: iload_3
    //   2818: istore_1
    //   2819: goto -2794 -> 25
    //   2822: astore 15
    //   2824: aconst_null
    //   2825: astore 16
    //   2827: aload_0
    //   2828: iconst_0
    //   2829: putfield 94	com/tencent/hlyyb/downloader/e/b/c:c	Z
    //   2832: aload_0
    //   2833: getfield 116	com/tencent/hlyyb/downloader/e/b/c:g	Lcom/tencent/hlyyb/downloader/e/b/b;
    //   2836: aload_0
    //   2837: invokeinterface 374 2 0
    //   2842: aload_0
    //   2843: aconst_null
    //   2844: putfield 265	com/tencent/hlyyb/downloader/e/b/c:m	Lcom/tencent/hlyyb/downloader/a/a/e;
    //   2847: aload 16
    //   2849: ifnull +17 -> 2866
    //   2852: aload_0
    //   2853: aload 16
    //   2855: invokevirtual 376	com/tencent/hlyyb/downloader/a/a/f:d	()Ljava/lang/String;
    //   2858: putfield 294	com/tencent/hlyyb/downloader/e/b/c:p	Ljava/lang/String;
    //   2861: aload 16
    //   2863: invokevirtual 378	com/tencent/hlyyb/downloader/a/a/f:r	()V
    //   2866: aload 15
    //   2868: athrow
    //   2869: astore 15
    //   2871: aload 15
    //   2873: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   2876: return
    //   2877: astore 17
    //   2879: aload 15
    //   2881: astore 16
    //   2883: aload 17
    //   2885: astore 15
    //   2887: goto -60 -> 2827
    //   2890: astore 15
    //   2892: aload 17
    //   2894: astore 16
    //   2896: goto -69 -> 2827
    //   2899: astore 15
    //   2901: goto -74 -> 2827
    //   2904: astore 17
    //   2906: aload 15
    //   2908: astore 16
    //   2910: aload 17
    //   2912: astore 15
    //   2914: goto -87 -> 2827
    //   2917: astore 16
    //   2919: aconst_null
    //   2920: astore 15
    //   2922: goto -1170 -> 1752
    //   2925: astore 16
    //   2927: goto -1175 -> 1752
    //   2930: astore 16
    //   2932: aload 17
    //   2934: astore 15
    //   2936: goto -1184 -> 1752
    //   2939: aload 15
    //   2941: astore 16
    //   2943: aload 17
    //   2945: astore 15
    //   2947: goto -1405 -> 1542
    //   2950: iconst_m1
    //   2951: istore_1
    //   2952: goto -2397 -> 555
    //   2955: goto +9 -> 2964
    //   2958: goto -2713 -> 245
    //   2961: goto -2736 -> 225
    //   2964: iload 12
    //   2966: ifeq -16 -> 2950
    //   2969: ldc_w 508
    //   2972: istore_1
    //   2973: goto -2418 -> 555
    //   2976: lload 8
    //   2978: lload 6
    //   2980: lsub
    //   2981: ldc2_w 497
    //   2984: lcmp
    //   2985: ifle -1351 -> 1634
    //   2988: iconst_0
    //   2989: istore_1
    //   2990: iconst_1
    //   2991: istore_2
    //   2992: goto -1421 -> 1571
    //   2995: iconst_1
    //   2996: istore_1
    //   2997: iload_1
    //   2998: ifeq +17 -> 3015
    //   3001: sipush 3000
    //   3004: istore_1
    //   3005: iconst_1
    //   3006: istore_2
    //   3007: goto -1436 -> 1571
    //   3010: iconst_0
    //   3011: istore_1
    //   3012: goto -15 -> 2997
    //   3015: sipush 1000
    //   3018: istore_1
    //   3019: iconst_1
    //   3020: istore_2
    //   3021: goto -1450 -> 1571
    //   3024: iconst_0
    //   3025: istore_3
    //   3026: iconst_0
    //   3027: istore_2
    //   3028: iconst_0
    //   3029: istore_1
    //   3030: lconst_0
    //   3031: lstore 4
    //   3033: goto -1462 -> 1571
    //   3036: iconst_0
    //   3037: istore_3
    //   3038: iconst_1
    //   3039: istore_2
    //   3040: sipush 1000
    //   3043: istore_1
    //   3044: goto -1473 -> 1571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3047	0	this	c
    //   24	3020	1	i1	int
    //   16	3024	2	i2	int
    //   1567	1471	3	i3	int
    //   21	3011	4	l1	long
    //   581	2398	6	l2	long
    //   577	2400	8	l3	long
    //   13	2180	10	l4	long
    //   18	2947	12	bool1	boolean
    //   48	2068	13	bool2	boolean
    //   292	152	14	bool3	boolean
    //   166	205	15	localObject1	Object
    //   392	3	15	localException	Exception
    //   402	29	15	localThrowable1	Throwable
    //   501	1778	15	localObject2	Object
    //   2822	45	15	localObject3	Object
    //   2869	11	15	localThrowable2	Throwable
    //   2885	1	15	localObject4	Object
    //   2890	1	15	localObject5	Object
    //   2899	8	15	localObject6	Object
    //   2912	34	15	localObject7	Object
    //   418	3	16	localInterruptedException	java.lang.InterruptedException
    //   428	6	16	localObject8	Object
    //   623	2286	16	localObject9	Object
    //   2917	1	16	localThrowable3	Throwable
    //   2925	1	16	localThrowable4	Throwable
    //   2930	1	16	localThrowable5	Throwable
    //   2941	1	16	localObject10	Object
    //   824	889	17	localObject11	Object
    //   1742	7	17	localThrowable6	Throwable
    //   1954	406	17	localObject12	Object
    //   2877	16	17	localObject13	Object
    //   2904	40	17	localObject14	Object
    //   1722	10	18	str	String
    // Exception table:
    //   from	to	target	type
    //   72	114	392	java/lang/Exception
    //   55	72	402	java/lang/Throwable
    //   72	114	402	java/lang/Throwable
    //   394	399	402	java/lang/Throwable
    //   171	180	418	java/lang/InterruptedException
    //   171	180	428	finally
    //   180	183	428	finally
    //   420	425	428	finally
    //   430	433	428	finally
    //   1542	1563	1742	java/lang/Throwable
    //   1575	1580	1742	java/lang/Throwable
    //   1634	1639	1742	java/lang/Throwable
    //   1660	1678	1742	java/lang/Throwable
    //   1683	1702	1742	java/lang/Throwable
    //   1702	1739	1742	java/lang/Throwable
    //   1824	1832	1742	java/lang/Throwable
    //   1832	1857	1742	java/lang/Throwable
    //   1905	1981	1742	java/lang/Throwable
    //   2029	2072	1742	java/lang/Throwable
    //   2120	2223	1742	java/lang/Throwable
    //   2232	2260	1742	java/lang/Throwable
    //   2260	2322	1742	java/lang/Throwable
    //   2322	2329	1742	java/lang/Throwable
    //   2341	2367	1742	java/lang/Throwable
    //   2378	2383	1742	java/lang/Throwable
    //   2461	2466	1742	java/lang/Throwable
    //   2655	2668	1742	java/lang/Throwable
    //   2716	2744	1742	java/lang/Throwable
    //   543	549	2822	finally
    //   555	579	2822	finally
    //   587	609	2822	finally
    //   609	655	2822	finally
    //   763	787	2822	finally
    //   748	758	2869	java/lang/Throwable
    //   655	686	2877	finally
    //   820	937	2877	finally
    //   985	1173	2877	finally
    //   1173	1204	2890	finally
    //   1252	1361	2890	finally
    //   1409	1538	2890	finally
    //   1542	1563	2899	finally
    //   1575	1580	2899	finally
    //   1634	1639	2899	finally
    //   1660	1678	2899	finally
    //   1683	1702	2899	finally
    //   1702	1739	2899	finally
    //   1824	1832	2899	finally
    //   1832	1857	2899	finally
    //   1905	1981	2899	finally
    //   2029	2072	2899	finally
    //   2120	2223	2899	finally
    //   2232	2260	2899	finally
    //   2260	2322	2899	finally
    //   2322	2329	2899	finally
    //   2341	2367	2899	finally
    //   2378	2383	2899	finally
    //   2461	2466	2899	finally
    //   2655	2668	2899	finally
    //   2716	2744	2899	finally
    //   1752	1782	2904	finally
    //   543	549	2917	java/lang/Throwable
    //   555	579	2917	java/lang/Throwable
    //   587	609	2917	java/lang/Throwable
    //   609	655	2917	java/lang/Throwable
    //   763	787	2917	java/lang/Throwable
    //   655	686	2925	java/lang/Throwable
    //   820	937	2925	java/lang/Throwable
    //   985	1173	2925	java/lang/Throwable
    //   1173	1204	2930	java/lang/Throwable
    //   1252	1361	2930	java/lang/Throwable
    //   1409	1538	2930	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.b.c
 * JD-Core Version:    0.7.0.1
 */