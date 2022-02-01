package com.tencent.token;

public final class aio
  implements ahw
{
  final aim a;
  final ajt b;
  aig c;
  final aip d;
  final boolean e;
  private boolean f;
  
  private aio(aim paramaim, aip paramaip, boolean paramBoolean)
  {
    this.a = paramaim;
    this.d = paramaip;
    this.e = paramBoolean;
    this.b = new ajt(paramaim, paramBoolean);
  }
  
  public static aio a(aim paramaim, aip paramaip, boolean paramBoolean)
  {
    paramaip = new aio(paramaim, paramaip, paramBoolean);
    paramaip.c = paramaim.i.a();
    return paramaip;
  }
  
  final String a()
  {
    aij.a locala = this.d.a.c("/...");
    locala.b = aij.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    locala.c = aij.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
    return locala.b().toString();
  }
  
  public final void a(ahx paramahx)
  {
    try
    {
      if (!this.f)
      {
        this.f = true;
        Object localObject = akr.c().a("response.body().close()");
        this.b.a = localObject;
        this.a.c.a(new a(paramahx));
        return;
      }
      throw new IllegalStateException("Already Executed");
    }
    finally {}
  }
  
  final class a
    extends aiw
  {
    private final ahx c;
    
    a(ahx paramahx)
    {
      super(new Object[] { aio.this.a() });
      this.c = paramahx;
    }
    
    final String a()
    {
      return aio.this.d.a.b;
    }
    
    /* Error */
    public final void b()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   6: astore 4
      //   8: new 47	java/util/ArrayList
      //   11: dup
      //   12: invokespecial 49	java/util/ArrayList:<init>	()V
      //   15: astore 5
      //   17: aload 5
      //   19: aload 4
      //   21: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   24: getfield 58	com/tencent/token/aim:g	Ljava/util/List;
      //   27: invokeinterface 64 2 0
      //   32: pop
      //   33: aload 5
      //   35: aload 4
      //   37: getfield 67	com/tencent/token/aio:b	Lcom/tencent/token/ajt;
      //   40: invokeinterface 71 2 0
      //   45: pop
      //   46: aload 5
      //   48: new 73	com/tencent/token/ajk
      //   51: dup
      //   52: aload 4
      //   54: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   57: getfield 77	com/tencent/token/aim:k	Lcom/tencent/token/aid;
      //   60: invokespecial 80	com/tencent/token/ajk:<init>	(Lcom/tencent/token/aid;)V
      //   63: invokeinterface 71 2 0
      //   68: pop
      //   69: aload 4
      //   71: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   74: astore_3
      //   75: aload_3
      //   76: getfield 84	com/tencent/token/aim:l	Lcom/tencent/token/ahu;
      //   79: ifnull +14 -> 93
      //   82: aload_3
      //   83: getfield 84	com/tencent/token/aim:l	Lcom/tencent/token/ahu;
      //   86: getfield 89	com/tencent/token/ahu:a	Lcom/tencent/token/ajc;
      //   89: astore_3
      //   90: goto +8 -> 98
      //   93: aload_3
      //   94: getfield 92	com/tencent/token/aim:m	Lcom/tencent/token/ajc;
      //   97: astore_3
      //   98: aload 5
      //   100: new 94	com/tencent/token/aiy
      //   103: dup
      //   104: aload_3
      //   105: invokespecial 97	com/tencent/token/aiy:<init>	(Lcom/tencent/token/ajc;)V
      //   108: invokeinterface 71 2 0
      //   113: pop
      //   114: aload 5
      //   116: new 99	com/tencent/token/ajd
      //   119: dup
      //   120: aload 4
      //   122: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   125: invokespecial 102	com/tencent/token/ajd:<init>	(Lcom/tencent/token/aim;)V
      //   128: invokeinterface 71 2 0
      //   133: pop
      //   134: aload 4
      //   136: getfield 106	com/tencent/token/aio:e	Z
      //   139: ifne +19 -> 158
      //   142: aload 5
      //   144: aload 4
      //   146: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   149: getfield 109	com/tencent/token/aim:h	Ljava/util/List;
      //   152: invokeinterface 64 2 0
      //   157: pop
      //   158: aload 5
      //   160: new 111	com/tencent/token/ajl
      //   163: dup
      //   164: aload 4
      //   166: getfield 106	com/tencent/token/aio:e	Z
      //   169: invokespecial 114	com/tencent/token/ajl:<init>	(Z)V
      //   172: invokeinterface 71 2 0
      //   177: pop
      //   178: new 116	com/tencent/token/ajq
      //   181: dup
      //   182: aload 5
      //   184: aconst_null
      //   185: aconst_null
      //   186: aconst_null
      //   187: iconst_0
      //   188: aload 4
      //   190: getfield 31	com/tencent/token/aio:d	Lcom/tencent/token/aip;
      //   193: aload 4
      //   195: aload 4
      //   197: getfield 119	com/tencent/token/aio:c	Lcom/tencent/token/aig;
      //   200: aload 4
      //   202: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   205: getfield 123	com/tencent/token/aim:z	I
      //   208: aload 4
      //   210: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   213: getfield 126	com/tencent/token/aim:A	I
      //   216: aload 4
      //   218: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   221: getfield 129	com/tencent/token/aim:B	I
      //   224: invokespecial 132	com/tencent/token/ajq:<init>	(Ljava/util/List;Lcom/tencent/token/ajj;Lcom/tencent/token/ajm;Lcom/tencent/token/ajf;ILcom/tencent/token/aip;Lcom/tencent/token/ahw;Lcom/tencent/token/aig;III)V
      //   227: aload 4
      //   229: getfield 31	com/tencent/token/aio:d	Lcom/tencent/token/aip;
      //   232: invokeinterface 137 2 0
      //   237: astore_3
      //   238: aload_0
      //   239: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   242: getfield 67	com/tencent/token/aio:b	Lcom/tencent/token/ajt;
      //   245: getfield 141	com/tencent/token/ajt:b	Z
      //   248: istore_2
      //   249: iload_2
      //   250: ifeq +27 -> 277
      //   253: aload_0
      //   254: getfield 26	com/tencent/token/aio$a:c	Lcom/tencent/token/ahx;
      //   257: astore_3
      //   258: new 45	java/io/IOException
      //   261: dup
      //   262: ldc 143
      //   264: invokespecial 146	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   267: pop
      //   268: aload_3
      //   269: invokeinterface 150 1 0
      //   274: goto +13 -> 287
      //   277: aload_0
      //   278: getfield 26	com/tencent/token/aio$a:c	Lcom/tencent/token/ahx;
      //   281: aload_3
      //   282: invokeinterface 153 2 0
      //   287: aload_0
      //   288: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   291: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   294: getfield 156	com/tencent/token/aim:c	Lcom/tencent/token/aie;
      //   297: astore_3
      //   298: aload_3
      //   299: aload_0
      //   300: invokevirtual 161	com/tencent/token/aie:b	(Lcom/tencent/token/aio$a;)V
      //   303: return
      //   304: astore_3
      //   305: iconst_1
      //   306: istore_1
      //   307: goto +8 -> 315
      //   310: astore_3
      //   311: goto +164 -> 475
      //   314: astore_3
      //   315: iload_1
      //   316: ifeq +128 -> 444
      //   319: invokestatic 166	com/tencent/token/akr:c	()Lcom/tencent/token/akr;
      //   322: astore 5
      //   324: new 168	java/lang/StringBuilder
      //   327: dup
      //   328: ldc 170
      //   330: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   333: astore 6
      //   335: aload_0
      //   336: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   339: astore 7
      //   341: new 168	java/lang/StringBuilder
      //   344: dup
      //   345: invokespecial 172	java/lang/StringBuilder:<init>	()V
      //   348: astore 8
      //   350: aload 7
      //   352: getfield 67	com/tencent/token/aio:b	Lcom/tencent/token/ajt;
      //   355: getfield 141	com/tencent/token/ajt:b	Z
      //   358: ifeq +133 -> 491
      //   361: ldc 174
      //   363: astore 4
      //   365: goto +3 -> 368
      //   368: aload 8
      //   370: aload 4
      //   372: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: pop
      //   376: aload 7
      //   378: getfield 106	com/tencent/token/aio:e	Z
      //   381: ifeq +117 -> 498
      //   384: ldc 180
      //   386: astore 4
      //   388: goto +3 -> 391
      //   391: aload 8
      //   393: aload 4
      //   395: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   398: pop
      //   399: aload 8
      //   401: ldc 182
      //   403: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   406: pop
      //   407: aload 8
      //   409: aload 7
      //   411: invokevirtual 21	com/tencent/token/aio:a	()Ljava/lang/String;
      //   414: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: pop
      //   418: aload 6
      //   420: aload 8
      //   422: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   425: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   428: pop
      //   429: aload 5
      //   431: iconst_4
      //   432: aload 6
      //   434: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   437: aload_3
      //   438: invokevirtual 188	com/tencent/token/akr:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   441: goto +20 -> 461
      //   444: aload_0
      //   445: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   448: invokestatic 191	com/tencent/token/aio:a	(Lcom/tencent/token/aio;)Lcom/tencent/token/aig;
      //   451: pop
      //   452: aload_0
      //   453: getfield 26	com/tencent/token/aio$a:c	Lcom/tencent/token/ahx;
      //   456: invokeinterface 150 1 0
      //   461: aload_0
      //   462: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   465: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   468: getfield 156	com/tencent/token/aim:c	Lcom/tencent/token/aie;
      //   471: astore_3
      //   472: goto -174 -> 298
      //   475: aload_0
      //   476: getfield 14	com/tencent/token/aio$a:a	Lcom/tencent/token/aio;
      //   479: getfield 52	com/tencent/token/aio:a	Lcom/tencent/token/aim;
      //   482: getfield 156	com/tencent/token/aim:c	Lcom/tencent/token/aie;
      //   485: aload_0
      //   486: invokevirtual 161	com/tencent/token/aie:b	(Lcom/tencent/token/aio$a;)V
      //   489: aload_3
      //   490: athrow
      //   491: ldc 193
      //   493: astore 4
      //   495: goto -127 -> 368
      //   498: ldc 195
      //   500: astore 4
      //   502: goto -111 -> 391
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	505	0	this	a
      //   1	315	1	i	int
      //   248	2	2	bool	boolean
      //   74	225	3	localObject1	Object
      //   304	1	3	localIOException1	java.io.IOException
      //   310	1	3	localObject2	Object
      //   314	124	3	localIOException2	java.io.IOException
      //   471	19	3	localaie	aie
      //   6	495	4	localObject3	Object
      //   15	415	5	localObject4	Object
      //   333	100	6	localStringBuilder1	java.lang.StringBuilder
      //   339	71	7	localaio	aio
      //   348	73	8	localStringBuilder2	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   253	274	304	java/io/IOException
      //   277	287	304	java/io/IOException
      //   2	90	310	finally
      //   93	98	310	finally
      //   98	158	310	finally
      //   158	249	310	finally
      //   253	274	310	finally
      //   277	287	310	finally
      //   319	361	310	finally
      //   368	384	310	finally
      //   391	441	310	finally
      //   444	461	310	finally
      //   2	90	314	java/io/IOException
      //   93	98	314	java/io/IOException
      //   98	158	314	java/io/IOException
      //   158	249	314	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aio
 * JD-Core Version:    0.7.0.1
 */