package com.tencent.token;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Gooseberry;
import com.tencent.turingfd.sdk.qps.Peach;
import com.tencent.turingfd.sdk.qps.Pistachio;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class afn
{
  public static afn a = new afn();
  public static Map<Integer, Integer> b;
  public Map<Integer, Integer> c = new ConcurrentHashMap();
  public Map<Integer, Integer> d = new HashMap();
  public Map<Integer, Integer> e = new HashMap();
  public Object f = new Object();
  public afk g;
  public afu h;
  public Peach i;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(0));
    b.put(Integer.valueOf(6), Integer.valueOf(0));
    b.put(Integer.valueOf(3), Integer.valueOf(0));
    b.put(Integer.valueOf(32), Integer.valueOf(0));
    b.put(Integer.valueOf(17), Integer.valueOf(0));
    b.put(Integer.valueOf(40), Integer.valueOf(0));
    b.put(Integer.valueOf(43), Integer.valueOf(0));
    b.put(Integer.valueOf(19), Integer.valueOf(0));
    b.put(Integer.valueOf(36), Integer.valueOf(0));
    b.put(Integer.valueOf(114), Integer.valueOf(0));
    b.put(Integer.valueOf(10001), Integer.valueOf(0));
    b.put(Integer.valueOf(45), Integer.valueOf(0));
    b.put(Integer.valueOf(120), Integer.valueOf(0));
    b.put(Integer.valueOf(121), Integer.valueOf(0));
    b.put(Integer.valueOf(10002), Integer.valueOf(0));
    b.put(Integer.valueOf(10003), Integer.valueOf(0));
    b.put(Integer.valueOf(122), Integer.valueOf(0));
    int j = agb.a;
    if (j == 105668)
    {
      b.put(Integer.valueOf(18), Integer.valueOf(0));
      return;
    }
    if (j == 105928)
    {
      b.put(Integer.valueOf(18), Integer.valueOf(0));
      return;
    }
    if (j == 108168) {
      b.put(Integer.valueOf(18), Integer.valueOf(0));
    }
  }
  
  private void a(Context paramContext)
  {
    try
    {
      for (;;)
      {
        synchronized (this.f)
        {
          this.c.clear();
          this.c.putAll(b);
          Object localObject2 = Pistachio.b;
          ((Pistachio)localObject2).c(paramContext);
          HashMap localHashMap = new HashMap();
          localObject2 = ((Pistachio)localObject2).c;
          paramContext = localHashMap;
          if (localObject2 != null)
          {
            paramContext = ((Gooseberry)localObject2).i;
            if (paramContext != null) {
              break label304;
            }
            paramContext = localHashMap;
          }
          this.c.putAll(paramContext);
          paramContext = this.d.keySet().iterator();
          int j;
          if (paramContext.hasNext())
          {
            j = ((Integer)paramContext.next()).intValue();
            if (a(j)) {
              this.c.put(Integer.valueOf(j), this.d.get(Integer.valueOf(j)));
            }
          }
          else
          {
            paramContext = this.e.keySet().iterator();
            if (paramContext.hasNext())
            {
              j = ((Integer)paramContext.next()).intValue();
              if (a(j)) {
                this.c.put(Integer.valueOf(j), this.e.get(Integer.valueOf(j)));
              }
            }
            else
            {
              if (a(17))
              {
                this.c.put(Integer.valueOf(40), Integer.valueOf(0));
                this.c.put(Integer.valueOf(43), Integer.valueOf(0));
              }
              return;
            }
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  private boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 78	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   5: astore 12
    //   7: aload 12
    //   9: aload_1
    //   10: invokevirtual 80	com/tencent/turingfd/sdk/qps/Pistachio:c	(Landroid/content/Context;)V
    //   13: aload 12
    //   15: getfield 83	com/tencent/turingfd/sdk/qps/Pistachio:c	Lcom/tencent/turingfd/sdk/qps/Gooseberry;
    //   18: astore 12
    //   20: aload 12
    //   22: ifnonnull +6 -> 28
    //   25: goto +676 -> 701
    //   28: aload 12
    //   30: getfield 123	com/tencent/turingfd/sdk/qps/Gooseberry:j	J
    //   33: lstore 9
    //   35: lload 9
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +662 -> 701
    //   42: goto +3 -> 45
    //   45: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   48: lload 4
    //   50: lsub
    //   51: invokestatic 135	java/lang/Math:abs	(J)J
    //   54: lstore 4
    //   56: lload 4
    //   58: lload 9
    //   60: ldc2_w 136
    //   63: lmul
    //   64: lcmp
    //   65: ifgt +7 -> 72
    //   68: aload_0
    //   69: monitorexit
    //   70: iconst_0
    //   71: ireturn
    //   72: iconst_0
    //   73: newarray byte
    //   75: astore 12
    //   77: new 29	java/util/HashMap
    //   80: dup
    //   81: invokespecial 30	java/util/HashMap:<init>	()V
    //   84: astore 13
    //   86: new 139	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   93: astore 14
    //   95: aload 14
    //   97: getstatic 49	com/tencent/token/agb:a	I
    //   100: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 13
    //   106: ldc 146
    //   108: aload 14
    //   110: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload 13
    //   119: ldc 153
    //   121: aload_3
    //   122: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload 13
    //   128: ldc 155
    //   130: getstatic 78	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   133: aload_1
    //   134: invokevirtual 158	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;)Ljava/lang/String;
    //   137: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 13
    //   143: ldc 160
    //   145: aload 6
    //   147: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload 13
    //   153: ldc 162
    //   155: aload 7
    //   157: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: new 164	android/util/SparseArray
    //   164: dup
    //   165: invokespecial 165	android/util/SparseArray:<init>	()V
    //   168: aload_1
    //   169: aload 13
    //   171: iload_2
    //   172: invokestatic 170	com/tencent/turingfd/sdk/qps/TNative$aa:e	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   175: astore 6
    //   177: aload 12
    //   179: astore_3
    //   180: aload 6
    //   182: invokestatic 175	com/tencent/token/ahr:a	(Landroid/util/SparseArray;)I
    //   185: ifne +9 -> 194
    //   188: aload 6
    //   190: invokestatic 178	com/tencent/token/ahr:b	(Landroid/util/SparseArray;)[B
    //   193: astore_3
    //   194: aload_3
    //   195: arraylength
    //   196: istore 8
    //   198: iconst_1
    //   199: istore 11
    //   201: iload 8
    //   203: ifne +6 -> 209
    //   206: goto +459 -> 665
    //   209: aload_0
    //   210: getfield 180	com/tencent/token/afn:g	Lcom/tencent/token/afk;
    //   213: checkcast 182	com/tencent/token/aex
    //   216: getfield 185	com/tencent/token/aex:a	Lcom/tencent/token/afc;
    //   219: astore 6
    //   221: aload 6
    //   223: getfield 189	com/tencent/token/afc:e	Lcom/tencent/token/afu;
    //   226: getfield 195	com/tencent/token/afu:s	Z
    //   229: ifne +10 -> 239
    //   232: iconst_0
    //   233: newarray byte
    //   235: astore_3
    //   236: goto +29 -> 265
    //   239: aload 6
    //   241: aload_3
    //   242: invokevirtual 198	com/tencent/token/afc:a	([B)Lcom/tencent/token/afg;
    //   245: astore_3
    //   246: aload_3
    //   247: getfield 202	com/tencent/token/afg:b	I
    //   250: ifeq +10 -> 260
    //   253: iconst_0
    //   254: newarray byte
    //   256: astore_3
    //   257: goto +8 -> 265
    //   260: aload_3
    //   261: getfield 205	com/tencent/token/afg:c	[B
    //   264: astore_3
    //   265: iload_2
    //   266: iconst_1
    //   267: if_icmpne +24 -> 291
    //   270: new 164	android/util/SparseArray
    //   273: dup
    //   274: invokespecial 165	android/util/SparseArray:<init>	()V
    //   277: aload_3
    //   278: iload_2
    //   279: invokestatic 208	com/tencent/turingfd/sdk/qps/TNative$aa:f	(Landroid/util/SparseArray;[BI)Landroid/util/SparseArray;
    //   282: astore_3
    //   283: aload_3
    //   284: invokestatic 178	com/tencent/token/ahr:b	(Landroid/util/SparseArray;)[B
    //   287: astore_3
    //   288: goto +14 -> 302
    //   291: iload_2
    //   292: ifne +6 -> 298
    //   295: goto +7 -> 302
    //   298: iconst_0
    //   299: newarray byte
    //   301: astore_3
    //   302: new 210	com/tencent/turingfd/sdk/qps/Grape
    //   305: dup
    //   306: invokespecial 211	com/tencent/turingfd/sdk/qps/Grape:<init>	()V
    //   309: astore 6
    //   311: aload 6
    //   313: new 213	com/tencent/token/afb
    //   316: dup
    //   317: aload_3
    //   318: invokespecial 216	com/tencent/token/afb:<init>	([B)V
    //   321: invokevirtual 219	com/tencent/turingfd/sdk/qps/Grape:a	(Lcom/tencent/token/afb;)V
    //   324: aload 6
    //   326: getfield 221	com/tencent/turingfd/sdk/qps/Grape:c	I
    //   329: istore_2
    //   330: iload_2
    //   331: iflt +183 -> 514
    //   334: iload_2
    //   335: iconst_1
    //   336: if_icmpne +14 -> 350
    //   339: new 85	com/tencent/turingfd/sdk/qps/Gooseberry
    //   342: dup
    //   343: invokespecial 222	com/tencent/turingfd/sdk/qps/Gooseberry:<init>	()V
    //   346: astore_3
    //   347: goto +169 -> 516
    //   350: aload 6
    //   352: getfield 224	com/tencent/turingfd/sdk/qps/Grape:d	Lcom/tencent/turingfd/sdk/qps/Gooseberry;
    //   355: astore 6
    //   357: aload 6
    //   359: ifnonnull +14 -> 373
    //   362: new 85	com/tencent/turingfd/sdk/qps/Gooseberry
    //   365: dup
    //   366: invokespecial 222	com/tencent/turingfd/sdk/qps/Gooseberry:<init>	()V
    //   369: astore_3
    //   370: goto +146 -> 516
    //   373: new 139	java/lang/StringBuilder
    //   376: dup
    //   377: ldc 226
    //   379: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: getstatic 49	com/tencent/token/agb:a	I
    //   385: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: new 139	java/lang/StringBuilder
    //   392: dup
    //   393: ldc 231
    //   395: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   398: astore_3
    //   399: aload_3
    //   400: aload 6
    //   402: getfield 233	com/tencent/turingfd/sdk/qps/Gooseberry:e	J
    //   405: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_3
    //   410: ldc 238
    //   412: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_3
    //   417: aload 6
    //   419: getfield 243	com/tencent/turingfd/sdk/qps/Gooseberry:g	J
    //   422: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 6
    //   428: getfield 87	com/tencent/turingfd/sdk/qps/Gooseberry:i	Ljava/util/Map;
    //   431: invokeinterface 91 1 0
    //   436: invokeinterface 97 1 0
    //   441: astore_3
    //   442: aload_3
    //   443: invokeinterface 103 1 0
    //   448: ifeq +13 -> 461
    //   451: aload_3
    //   452: invokeinterface 107 1 0
    //   457: pop
    //   458: goto -16 -> 442
    //   461: aload 6
    //   463: getfield 246	com/tencent/turingfd/sdk/qps/Gooseberry:k	Ljava/util/Map;
    //   466: astore 7
    //   468: aload 6
    //   470: astore_3
    //   471: aload 7
    //   473: ifnull +43 -> 516
    //   476: aload 7
    //   478: invokeinterface 91 1 0
    //   483: invokeinterface 97 1 0
    //   488: astore 7
    //   490: aload 6
    //   492: astore_3
    //   493: aload 7
    //   495: invokeinterface 103 1 0
    //   500: ifeq +16 -> 516
    //   503: aload 7
    //   505: invokeinterface 107 1 0
    //   510: pop
    //   511: goto -21 -> 490
    //   514: aconst_null
    //   515: astore_3
    //   516: aload_3
    //   517: ifnull +148 -> 665
    //   520: aload_3
    //   521: getfield 87	com/tencent/turingfd/sdk/qps/Gooseberry:i	Ljava/util/Map;
    //   524: astore 7
    //   526: getstatic 78	com/tencent/turingfd/sdk/qps/Pistachio:b	Lcom/tencent/turingfd/sdk/qps/Pistachio;
    //   529: astore 6
    //   531: aload 7
    //   533: ifnull +106 -> 639
    //   536: aload 7
    //   538: invokeinterface 249 1 0
    //   543: ifeq +96 -> 639
    //   546: aload 6
    //   548: invokevirtual 253	java/lang/Object:getClass	()Ljava/lang/Class;
    //   551: pop
    //   552: new 255	com/tencent/token/afd
    //   555: dup
    //   556: invokespecial 256	com/tencent/token/afd:<init>	()V
    //   559: astore 7
    //   561: aload_3
    //   562: aload 7
    //   564: invokevirtual 259	com/tencent/turingfd/sdk/qps/Gooseberry:a	(Lcom/tencent/token/afd;)V
    //   567: aload 7
    //   569: getfield 262	com/tencent/token/afd:a	Ljava/nio/ByteBuffer;
    //   572: invokevirtual 267	java/nio/ByteBuffer:position	()I
    //   575: newarray byte
    //   577: astore_3
    //   578: aload 7
    //   580: getfield 262	com/tencent/token/afd:a	Ljava/nio/ByteBuffer;
    //   583: invokevirtual 271	java/nio/ByteBuffer:array	()[B
    //   586: iconst_0
    //   587: aload_3
    //   588: iconst_0
    //   589: aload 7
    //   591: getfield 262	com/tencent/token/afd:a	Ljava/nio/ByteBuffer;
    //   594: invokevirtual 267	java/nio/ByteBuffer:position	()I
    //   597: invokestatic 275	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   600: aload 6
    //   602: aload_1
    //   603: invokevirtual 158	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;)Ljava/lang/String;
    //   606: astore_1
    //   607: new 277	java/io/BufferedOutputStream
    //   610: dup
    //   611: new 279	java/io/FileOutputStream
    //   614: dup
    //   615: aload_1
    //   616: invokespecial 280	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   619: invokespecial 283	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   622: astore_1
    //   623: aload_1
    //   624: aload_3
    //   625: invokevirtual 286	java/io/BufferedOutputStream:write	([B)V
    //   628: aload_1
    //   629: invokevirtual 289	java/io/BufferedOutputStream:flush	()V
    //   632: aload_1
    //   633: invokestatic 294	com/tencent/token/acy:a	(Ljava/io/Closeable;)V
    //   636: goto +32 -> 668
    //   639: aload 6
    //   641: invokevirtual 253	java/lang/Object:getClass	()Ljava/lang/Class;
    //   644: pop
    //   645: new 296	java/io/File
    //   648: dup
    //   649: aload 6
    //   651: aload_1
    //   652: invokevirtual 158	com/tencent/turingfd/sdk/qps/Pistachio:a	(Landroid/content/Context;)Ljava/lang/String;
    //   655: invokespecial 297	java/io/File:<init>	(Ljava/lang/String;)V
    //   658: invokevirtual 300	java/io/File:delete	()Z
    //   661: pop
    //   662: goto +6 -> 668
    //   665: iconst_0
    //   666: istore 11
    //   668: aload_0
    //   669: monitorexit
    //   670: iload 11
    //   672: ireturn
    //   673: astore_1
    //   674: aload_0
    //   675: monitorexit
    //   676: aload_1
    //   677: athrow
    //   678: astore_3
    //   679: aload 12
    //   681: astore_3
    //   682: goto -488 -> 194
    //   685: astore_3
    //   686: goto -172 -> 514
    //   689: astore_1
    //   690: goto +19 -> 709
    //   693: astore_3
    //   694: goto -62 -> 632
    //   697: astore_1
    //   698: goto -30 -> 668
    //   701: ldc2_w 301
    //   704: lstore 9
    //   706: goto -661 -> 45
    //   709: aconst_null
    //   710: astore_1
    //   711: goto -79 -> 632
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	afn
    //   0	714	1	paramContext	Context
    //   0	714	2	paramInt	int
    //   0	714	3	paramString1	String
    //   0	714	4	paramLong	long
    //   0	714	6	paramString2	String
    //   0	714	7	paramString3	String
    //   196	6	8	j	int
    //   33	672	9	l	long
    //   199	472	11	bool	boolean
    //   5	675	12	localObject	Object
    //   84	86	13	localHashMap	HashMap
    //   93	16	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	20	673	finally
    //   28	35	673	finally
    //   45	56	673	finally
    //   72	161	673	finally
    //   180	194	673	finally
    //   194	198	673	finally
    //   209	236	673	finally
    //   239	257	673	finally
    //   260	265	673	finally
    //   283	288	673	finally
    //   520	531	673	finally
    //   536	607	673	finally
    //   632	636	673	finally
    //   639	645	673	finally
    //   161	177	678	finally
    //   270	283	685	finally
    //   302	330	685	finally
    //   339	347	685	finally
    //   350	357	685	finally
    //   362	370	685	finally
    //   373	442	685	finally
    //   442	458	685	finally
    //   461	468	685	finally
    //   476	490	685	finally
    //   493	511	685	finally
    //   607	623	689	finally
    //   623	632	693	finally
    //   645	662	697	finally
  }
  
  private void b(Context paramContext)
  {
    try
    {
      Object localObject1 = this.h.c;
      if (localObject1 != null)
      {
        localObject1 = ((aem)localObject1).d();
      }
      else
      {
        if (acx.c == null) {
          acx.c = Build.MODEL;
        }
        localObject1 = acx.c;
      }
      aew localaew = afc.a.a(paramContext);
      afn localafn = a;
      int j = agm.f;
      Object localObject2 = this.h;
      boolean bool = TextUtils.isEmpty(((afu)localObject2).n);
      if (bool) {
        localObject2 = "";
      } else {
        localObject2 = ((afu)localObject2).n;
      }
      if (localafn.a(paramContext, j, (String)localObject2, this.i.a(paramContext, "501"), localaew.b, (String)localObject1))
      {
        localObject1 = this.i;
        localObject1.getClass();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((Peach)localObject1).a(paramContext, "501", ((StringBuilder)localObject2).toString(), true);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final long a(Context paramContext, afm paramafm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 361	com/tencent/token/afn:b	(Landroid/content/Context;)V
    //   11: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   14: lstore 5
    //   16: lload 5
    //   18: lload_3
    //   19: lsub
    //   20: lstore_3
    //   21: aload_2
    //   22: invokeinterface 366 1 0
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 61	com/tencent/token/afn:d	Ljava/util/Map;
    //   32: aload_2
    //   33: invokeinterface 73 2 0
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 368	com/tencent/token/afn:a	(Landroid/content/Context;)V
    //   43: goto +5 -> 48
    //   46: lconst_0
    //   47: lstore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: lload_3
    //   51: lreturn
    //   52: astore_1
    //   53: goto -7 -> 46
    //   56: astore_1
    //   57: goto -9 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	afn
    //   0	60	1	paramContext	Context
    //   0	60	2	paramafm	afm
    //   5	46	3	l1	long
    //   14	3	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	16	52	finally
    //   21	43	56	finally
  }
  
  public final String a()
  {
    Object localObject2 = new HashSet();
    synchronized (this.f)
    {
      Object localObject4 = this.c.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject4).next();
        if (((Integer)this.c.get(localInteger)).intValue() == 0) {
          ((HashSet)localObject2).add(localInteger);
        }
      }
      ??? = ((HashSet)localObject2).iterator();
      localObject2 = new StringBuilder();
      while (((Iterator)???).hasNext())
      {
        int j = ((Integer)((Iterator)???).next()).intValue();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(j);
        ((StringBuilder)localObject2).append(((StringBuilder)localObject4).toString());
        if (((Iterator)???).hasNext()) {
          ((StringBuilder)localObject2).append(",");
        }
      }
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public final boolean a(int paramInt)
  {
    if (!this.c.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    Object localObject1 = this.c.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      return true;
    }
    try
    {
      paramInt = ((Integer)localObject1).intValue();
      return paramInt != 0;
    }
    finally {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afn
 * JD-Core Version:    0.7.0.1
 */