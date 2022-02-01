package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.base.Gooseberry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class adq
{
  public static adq a = new adq();
  public static Map<Integer, Integer> b;
  public Map<Integer, Integer> c = new HashMap();
  public Map<Integer, Integer> d = new HashMap();
  public Map<Integer, Integer> e = new HashMap();
  public adn f;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put(Integer.valueOf(Gooseberry.Wj.value), Integer.valueOf(0));
    b.put(Integer.valueOf(10001), Integer.valueOf(0));
    b.put(Integer.valueOf(Gooseberry.Uj.value), Integer.valueOf(0));
    b.put(Integer.valueOf(Gooseberry.qk.value), Integer.valueOf(0));
  }
  
  public static String b(Context paramContext)
  {
    adp localadp = adp.a;
    return adp.b(paramContext);
  }
  
  public final String a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.c.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.c.get(localObject3)).intValue() == 0) {
        ((Set)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    localObject2 = new StringBuilder();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      if (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(",");
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      this.c.clear();
      Object localObject = b.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      this.c.putAll(b);
      localObject = adp.a;
      paramContext = adp.a(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
      this.c.putAll(paramContext);
      paramContext = this.d.keySet().iterator();
      int i;
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (a(i)) {
          this.c.put(Integer.valueOf(i), this.d.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.e.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (a(i)) {
          this.c.put(Integer.valueOf(i), this.e.get(Integer.valueOf(i)));
        }
      }
      if (a(Gooseberry.Uj.value))
      {
        this.c.put(Integer.valueOf(Gooseberry.nk.value), Integer.valueOf(0));
        this.c.put(Integer.valueOf(Gooseberry.qk.value), Integer.valueOf(0));
      }
      paramContext = this.c.keySet().iterator();
      while (paramContext.hasNext()) {
        paramContext.next();
      }
      return;
    }
    finally {}
  }
  
  public final boolean a(int paramInt)
  {
    if (!this.c.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
  
  /* Error */
  public final boolean a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 68	com/tencent/token/adp:a	Lcom/tencent/token/adp;
    //   5: astore 8
    //   7: aload_1
    //   8: invokestatic 148	com/tencent/token/adp:c	(Landroid/content/Context;)J
    //   11: lstore 6
    //   13: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   16: lload_3
    //   17: lsub
    //   18: invokestatic 160	java/lang/Math:abs	(J)J
    //   21: lstore_3
    //   22: lload_3
    //   23: lload 6
    //   25: ldc2_w 161
    //   28: lmul
    //   29: lcmp
    //   30: ifgt +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: iconst_0
    //   38: newarray byte
    //   40: astore 8
    //   42: new 23	java/util/HashMap
    //   45: dup
    //   46: invokespecial 24	java/util/HashMap:<init>	()V
    //   49: astore 9
    //   51: ldc 164
    //   53: invokestatic 168	com/tencent/token/aev:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: astore 10
    //   58: aload 10
    //   60: getstatic 172	com/tencent/token/afi:a	I
    //   63: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: ldc 174
    //   71: aload 10
    //   73: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 175	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 9
    //   82: ldc 177
    //   84: aload_2
    //   85: invokevirtual 175	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: getstatic 68	com/tencent/token/adp:a	Lcom/tencent/token/adp;
    //   92: astore_2
    //   93: aload 9
    //   95: ldc 179
    //   97: aload_1
    //   98: invokestatic 181	com/tencent/token/adp:d	(Landroid/content/Context;)Ljava/lang/String;
    //   101: invokevirtual 175	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload 9
    //   107: ldc 183
    //   109: aload 5
    //   111: invokevirtual 175	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: new 185	android/util/SparseArray
    //   118: dup
    //   119: invokespecial 186	android/util/SparseArray:<init>	()V
    //   122: aload_1
    //   123: aload 9
    //   125: iconst_0
    //   126: invokestatic 191	com/tencent/turingfd/sdk/base/TuringDIDService$aa:e	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   129: astore 5
    //   131: aload 8
    //   133: astore_2
    //   134: aload 5
    //   136: invokestatic 196	com/tencent/token/aez:a	(Landroid/util/SparseArray;)I
    //   139: ifne +9 -> 148
    //   142: aload 5
    //   144: invokestatic 199	com/tencent/token/aez:b	(Landroid/util/SparseArray;)[B
    //   147: astore_2
    //   148: aload_2
    //   149: arraylength
    //   150: ifeq +314 -> 464
    //   153: aload_0
    //   154: getfield 201	com/tencent/token/adq:f	Lcom/tencent/token/adn;
    //   157: checkcast 203	com/tencent/token/adc
    //   160: getfield 206	com/tencent/token/adc:a	Lcom/tencent/token/adf;
    //   163: aload_2
    //   164: invokestatic 211	com/tencent/token/adf:a	(Lcom/tencent/token/adf;[B)Lcom/tencent/token/adi;
    //   167: astore_2
    //   168: aload_2
    //   169: getfield 215	com/tencent/token/adi:b	I
    //   172: ifeq +10 -> 182
    //   175: iconst_0
    //   176: newarray byte
    //   178: astore_2
    //   179: goto +8 -> 187
    //   182: aload_2
    //   183: getfield 218	com/tencent/token/adi:c	[B
    //   186: astore_2
    //   187: new 220	com/tencent/turingfd/sdk/base/Kiwifruit
    //   190: dup
    //   191: invokespecial 221	com/tencent/turingfd/sdk/base/Kiwifruit:<init>	()V
    //   194: astore 5
    //   196: new 223	com/tencent/token/afl
    //   199: dup
    //   200: aload_2
    //   201: invokespecial 226	com/tencent/token/afl:<init>	([B)V
    //   204: astore_2
    //   205: aload 5
    //   207: aload_2
    //   208: aload 5
    //   210: getfield 229	com/tencent/turingfd/sdk/base/Kiwifruit:ld	I
    //   213: iconst_0
    //   214: iconst_1
    //   215: invokevirtual 232	com/tencent/token/afl:a	(IIZ)I
    //   218: putfield 229	com/tencent/turingfd/sdk/base/Kiwifruit:ld	I
    //   221: aload 5
    //   223: aload_2
    //   224: getstatic 236	com/tencent/turingfd/sdk/base/Kiwifruit:kd	Lcom/tencent/turingfd/sdk/base/Hickory;
    //   227: iconst_1
    //   228: iconst_0
    //   229: invokevirtual 239	com/tencent/token/afl:a	(Lcom/tencent/turingfd/sdk/base/break;IZ)Lcom/tencent/turingfd/sdk/base/break;
    //   232: checkcast 241	com/tencent/turingfd/sdk/base/Hickory
    //   235: putfield 244	com/tencent/turingfd/sdk/base/Kiwifruit:md	Lcom/tencent/turingfd/sdk/base/Hickory;
    //   238: aload 5
    //   240: aload_2
    //   241: aload 5
    //   243: getfield 248	com/tencent/turingfd/sdk/base/Kiwifruit:Jb	J
    //   246: iconst_2
    //   247: iconst_1
    //   248: invokevirtual 251	com/tencent/token/afl:a	(JIZ)J
    //   251: putfield 248	com/tencent/turingfd/sdk/base/Kiwifruit:Jb	J
    //   254: aload 5
    //   256: getfield 229	com/tencent/turingfd/sdk/base/Kiwifruit:ld	I
    //   259: iflt +134 -> 393
    //   262: aload 5
    //   264: getfield 229	com/tencent/turingfd/sdk/base/Kiwifruit:ld	I
    //   267: iconst_1
    //   268: if_icmpne +14 -> 282
    //   271: new 241	com/tencent/turingfd/sdk/base/Hickory
    //   274: dup
    //   275: invokespecial 252	com/tencent/turingfd/sdk/base/Hickory:<init>	()V
    //   278: astore_2
    //   279: goto +116 -> 395
    //   282: aload 5
    //   284: getfield 244	com/tencent/turingfd/sdk/base/Kiwifruit:md	Lcom/tencent/turingfd/sdk/base/Hickory;
    //   287: astore 5
    //   289: aload 5
    //   291: ifnonnull +14 -> 305
    //   294: new 241	com/tencent/turingfd/sdk/base/Hickory
    //   297: dup
    //   298: invokespecial 252	com/tencent/turingfd/sdk/base/Hickory:<init>	()V
    //   301: astore_2
    //   302: goto +93 -> 395
    //   305: aload 5
    //   307: getfield 255	com/tencent/turingfd/sdk/base/Hickory:gd	Ljava/util/Map;
    //   310: invokeinterface 78 1 0
    //   315: invokeinterface 84 1 0
    //   320: astore_2
    //   321: aload_2
    //   322: invokeinterface 90 1 0
    //   327: ifeq +13 -> 340
    //   330: aload_2
    //   331: invokeinterface 94 1 0
    //   336: pop
    //   337: goto -16 -> 321
    //   340: aload 5
    //   342: getfield 258	com/tencent/turingfd/sdk/base/Hickory:jd	Ljava/util/Map;
    //   345: astore 8
    //   347: aload 5
    //   349: astore_2
    //   350: aload 8
    //   352: ifnull +43 -> 395
    //   355: aload 8
    //   357: invokeinterface 78 1 0
    //   362: invokeinterface 84 1 0
    //   367: astore 8
    //   369: aload 5
    //   371: astore_2
    //   372: aload 8
    //   374: invokeinterface 90 1 0
    //   379: ifeq +16 -> 395
    //   382: aload 8
    //   384: invokeinterface 94 1 0
    //   389: pop
    //   390: goto -21 -> 369
    //   393: aconst_null
    //   394: astore_2
    //   395: aload_2
    //   396: ifnonnull +6 -> 402
    //   399: goto +65 -> 464
    //   402: aload_2
    //   403: getfield 255	com/tencent/turingfd/sdk/base/Hickory:gd	Ljava/util/Map;
    //   406: astore 5
    //   408: getstatic 68	com/tencent/token/adp:a	Lcom/tencent/token/adp;
    //   411: astore 8
    //   413: aload 5
    //   415: ifnull +30 -> 445
    //   418: aload 5
    //   420: invokeinterface 261 1 0
    //   425: ifeq +20 -> 445
    //   428: aload_2
    //   429: invokevirtual 266	com/tencent/turingfd/sdk/base/break:a	()[B
    //   432: astore_2
    //   433: aload_1
    //   434: invokestatic 181	com/tencent/token/adp:d	(Landroid/content/Context;)Ljava/lang/String;
    //   437: aload_2
    //   438: invokestatic 269	com/tencent/token/aez:a	(Ljava/lang/String;[B)Z
    //   441: pop
    //   442: goto +18 -> 460
    //   445: new 271	java/io/File
    //   448: dup
    //   449: aload_1
    //   450: invokestatic 181	com/tencent/token/adp:d	(Landroid/content/Context;)Ljava/lang/String;
    //   453: invokespecial 274	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: invokevirtual 277	java/io/File:delete	()Z
    //   459: pop
    //   460: aload_0
    //   461: monitorexit
    //   462: iconst_1
    //   463: ireturn
    //   464: aload_0
    //   465: monitorexit
    //   466: iconst_0
    //   467: ireturn
    //   468: astore_1
    //   469: aload_0
    //   470: monitorexit
    //   471: aload_1
    //   472: athrow
    //   473: astore_2
    //   474: aload 8
    //   476: astore_2
    //   477: goto -329 -> 148
    //   480: astore_2
    //   481: goto -88 -> 393
    //   484: astore_1
    //   485: goto -25 -> 460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	adq
    //   0	488	1	paramContext	Context
    //   0	488	2	paramString1	String
    //   0	488	3	paramLong	long
    //   0	488	5	paramString2	String
    //   11	13	6	l	long
    //   5	470	8	localObject	Object
    //   49	75	9	localHashMap	HashMap
    //   56	16	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	22	468	finally
    //   37	115	468	finally
    //   115	131	468	finally
    //   134	148	468	finally
    //   148	179	468	finally
    //   182	187	468	finally
    //   187	279	468	finally
    //   282	289	468	finally
    //   294	302	468	finally
    //   305	321	468	finally
    //   321	337	468	finally
    //   340	347	468	finally
    //   355	369	468	finally
    //   372	390	468	finally
    //   402	413	468	finally
    //   418	442	468	finally
    //   445	460	468	finally
    //   115	131	473	java/lang/Throwable
    //   187	279	480	java/lang/Throwable
    //   282	289	480	java/lang/Throwable
    //   294	302	480	java/lang/Throwable
    //   305	321	480	java/lang/Throwable
    //   321	337	480	java/lang/Throwable
    //   340	347	480	java/lang/Throwable
    //   355	369	480	java/lang/Throwable
    //   372	390	480	java/lang/Throwable
    //   445	460	484	java/lang/Throwable
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.e.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adq
 * JD-Core Version:    0.7.0.1
 */