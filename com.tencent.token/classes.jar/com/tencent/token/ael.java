package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Ginkgo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ael
{
  public static ael a = new ael();
  public static Map<Integer, Integer> b;
  public Map<Integer, Integer> c = new HashMap();
  public Map<Integer, Integer> d = new HashMap();
  public Map<Integer, Integer> e = new HashMap();
  public aei f;
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(0));
    b.put(Integer.valueOf(19), Integer.valueOf(0));
    b.put(Integer.valueOf(10001), Integer.valueOf(0));
    b.put(Integer.valueOf(17), Integer.valueOf(0));
    b.put(Integer.valueOf(43), Integer.valueOf(0));
    b.put(Integer.valueOf(36), Integer.valueOf(0));
    b.put(Integer.valueOf(45), Integer.valueOf(0));
    b.put(Integer.valueOf(114), Integer.valueOf(0));
    b.put(Integer.valueOf(10002), Integer.valueOf(0));
    b.put(Integer.valueOf(10003), Integer.valueOf(0));
    int i = agh.a;
    if (i == 108098)
    {
      b.put(Integer.valueOf(10002), Integer.valueOf(0));
      return;
    }
    if (i == 105668)
    {
      b.put(Integer.valueOf(18), Integer.valueOf(0));
      return;
    }
    if (i == 105928)
    {
      b.put(Integer.valueOf(36), Integer.valueOf(0));
      b.put(Integer.valueOf(18), Integer.valueOf(0));
      return;
    }
    if (i == 108168)
    {
      b.put(Integer.valueOf(36), Integer.valueOf(0));
      b.put(Integer.valueOf(18), Integer.valueOf(0));
      b.put(Integer.valueOf(2), Integer.valueOf(0));
      return;
    }
    if (i == 108388) {
      b.put(Integer.valueOf(40), Integer.valueOf(0));
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.d.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public final void a(Context paramContext)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        this.c.clear();
        this.c.putAll(b);
        aek.b.getClass();
        localObject = aek.b;
        paramContext = aek.b(paramContext);
        localObject = new HashMap();
        if (paramContext != null)
        {
          Map localMap = paramContext.i;
          paramContext = localMap;
          if (localMap != null)
          {
            this.c.putAll(paramContext);
            paramContext = this.d.keySet().iterator();
            int i;
            if (paramContext.hasNext())
            {
              i = ((Integer)paramContext.next()).intValue();
              if (!a(i)) {
                continue;
              }
              this.c.put(Integer.valueOf(i), (Integer)this.d.get(Integer.valueOf(i)));
              continue;
            }
            paramContext = this.e.keySet().iterator();
            if (paramContext.hasNext())
            {
              i = ((Integer)paramContext.next()).intValue();
              if (!a(i)) {
                continue;
              }
              this.c.put(Integer.valueOf(i), (Integer)this.e.get(Integer.valueOf(i)));
              continue;
            }
            if (a(17))
            {
              this.c.put(Integer.valueOf(40), Integer.valueOf(0));
              this.c.put(Integer.valueOf(43), Integer.valueOf(0));
            }
            paramContext = this.c.keySet().iterator();
            if (paramContext.hasNext())
            {
              paramContext.next();
              continue;
            }
            return;
          }
        }
      }
      finally {}
      paramContext = (Context)localObject;
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
  
  /* Error */
  public final boolean a(Context paramContext, java.lang.String paramString1, long paramLong, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 70	com/tencent/token/aek:b	Lcom/tencent/token/aek;
    //   5: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: pop
    //   9: getstatic 70	com/tencent/token/aek:b	Lcom/tencent/token/aek;
    //   12: astore 10
    //   14: aload_1
    //   15: invokestatic 77	com/tencent/token/aek:b	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/qps/Ginkgo;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnonnull +6 -> 28
    //   25: goto +504 -> 529
    //   28: aload 10
    //   30: getfield 122	com/tencent/turingfd/sdk/qps/Ginkgo:j	J
    //   33: lstore 7
    //   35: lload 7
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +490 -> 529
    //   42: goto +3 -> 45
    //   45: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   48: lload_3
    //   49: lsub
    //   50: invokestatic 134	java/lang/Math:abs	(J)J
    //   53: lstore_3
    //   54: lload_3
    //   55: lload 7
    //   57: ldc2_w 135
    //   60: lmul
    //   61: lcmp
    //   62: ifgt +7 -> 69
    //   65: aload_0
    //   66: monitorexit
    //   67: iconst_0
    //   68: ireturn
    //   69: iconst_0
    //   70: newarray byte
    //   72: astore 10
    //   74: new 23	java/util/HashMap
    //   77: dup
    //   78: invokespecial 24	java/util/HashMap:<init>	()V
    //   81: astore 11
    //   83: new 138	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   90: astore 12
    //   92: aload 12
    //   94: getstatic 43	com/tencent/token/agh:a	I
    //   97: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 11
    //   103: ldc 145
    //   105: aload 12
    //   107: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload 11
    //   116: ldc 152
    //   118: aload_2
    //   119: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: getstatic 70	com/tencent/token/aek:b	Lcom/tencent/token/aek;
    //   126: astore_2
    //   127: aload 11
    //   129: ldc 154
    //   131: aload_1
    //   132: invokestatic 157	com/tencent/token/aek:a	(Landroid/content/Context;)Ljava/lang/String;
    //   135: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: pop
    //   139: aload 11
    //   141: ldc 159
    //   143: aload 5
    //   145: invokevirtual 150	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: pop
    //   149: new 161	android/util/SparseArray
    //   152: dup
    //   153: invokespecial 162	android/util/SparseArray:<init>	()V
    //   156: aload_1
    //   157: aload 11
    //   159: iconst_0
    //   160: invokestatic 167	com/tencent/turingfd/sdk/qps/TNative$aa:e	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   163: astore 5
    //   165: aload 10
    //   167: astore_2
    //   168: aload 5
    //   170: invokestatic 172	com/tencent/token/agn:a	(Landroid/util/SparseArray;)I
    //   173: ifne +9 -> 182
    //   176: aload 5
    //   178: invokestatic 175	com/tencent/token/agn:b	(Landroid/util/SparseArray;)[B
    //   181: astore_2
    //   182: aload_2
    //   183: arraylength
    //   184: istore 6
    //   186: iconst_1
    //   187: istore 9
    //   189: iload 6
    //   191: ifne +6 -> 197
    //   194: goto +307 -> 501
    //   197: aload_0
    //   198: getfield 177	com/tencent/token/ael:f	Lcom/tencent/token/aei;
    //   201: checkcast 179	com/tencent/token/adw
    //   204: getfield 182	com/tencent/token/adw:a	Lcom/tencent/token/aec;
    //   207: astore 5
    //   209: aload 5
    //   211: getfield 187	com/tencent/token/aec:d	Lcom/tencent/token/agr;
    //   214: getfield 193	com/tencent/token/agr:q	Z
    //   217: ifne +10 -> 227
    //   220: iconst_0
    //   221: newarray byte
    //   223: astore_2
    //   224: goto +36 -> 260
    //   227: aload 5
    //   229: iconst_4
    //   230: aload_2
    //   231: sipush 8119
    //   234: sipush 18119
    //   237: invokevirtual 196	com/tencent/token/aec:a	(I[BII)Lcom/tencent/token/aee;
    //   240: astore_2
    //   241: aload_2
    //   242: getfield 200	com/tencent/token/aee:b	I
    //   245: ifeq +10 -> 255
    //   248: iconst_0
    //   249: newarray byte
    //   251: astore_2
    //   252: goto +8 -> 260
    //   255: aload_2
    //   256: getfield 203	com/tencent/token/aee:c	[B
    //   259: astore_2
    //   260: new 205	com/tencent/turingfd/sdk/qps/Gooseberry
    //   263: dup
    //   264: invokespecial 206	com/tencent/turingfd/sdk/qps/Gooseberry:<init>	()V
    //   267: astore 5
    //   269: aload 5
    //   271: new 208	com/tencent/token/agd
    //   274: dup
    //   275: aload_2
    //   276: invokespecial 211	com/tencent/token/agd:<init>	([B)V
    //   279: invokevirtual 214	com/tencent/turingfd/sdk/qps/Gooseberry:a	(Lcom/tencent/token/agd;)V
    //   282: aload 5
    //   284: getfield 216	com/tencent/turingfd/sdk/qps/Gooseberry:c	I
    //   287: istore 6
    //   289: iload 6
    //   291: iflt +131 -> 422
    //   294: iload 6
    //   296: iconst_1
    //   297: if_icmpne +14 -> 311
    //   300: new 79	com/tencent/turingfd/sdk/qps/Ginkgo
    //   303: dup
    //   304: invokespecial 217	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   307: astore_2
    //   308: goto +116 -> 424
    //   311: aload 5
    //   313: getfield 220	com/tencent/turingfd/sdk/qps/Gooseberry:d	Lcom/tencent/turingfd/sdk/qps/Ginkgo;
    //   316: astore 5
    //   318: aload 5
    //   320: ifnonnull +14 -> 334
    //   323: new 79	com/tencent/turingfd/sdk/qps/Ginkgo
    //   326: dup
    //   327: invokespecial 217	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   330: astore_2
    //   331: goto +93 -> 424
    //   334: aload 5
    //   336: getfield 82	com/tencent/turingfd/sdk/qps/Ginkgo:i	Ljava/util/Map;
    //   339: invokeinterface 86 1 0
    //   344: invokeinterface 92 1 0
    //   349: astore_2
    //   350: aload_2
    //   351: invokeinterface 98 1 0
    //   356: ifeq +13 -> 369
    //   359: aload_2
    //   360: invokeinterface 102 1 0
    //   365: pop
    //   366: goto -16 -> 350
    //   369: aload 5
    //   371: getfield 223	com/tencent/turingfd/sdk/qps/Ginkgo:k	Ljava/util/Map;
    //   374: astore 10
    //   376: aload 5
    //   378: astore_2
    //   379: aload 10
    //   381: ifnull +43 -> 424
    //   384: aload 10
    //   386: invokeinterface 86 1 0
    //   391: invokeinterface 92 1 0
    //   396: astore 10
    //   398: aload 5
    //   400: astore_2
    //   401: aload 10
    //   403: invokeinterface 98 1 0
    //   408: ifeq +16 -> 424
    //   411: aload 10
    //   413: invokeinterface 102 1 0
    //   418: pop
    //   419: goto -21 -> 398
    //   422: aconst_null
    //   423: astore_2
    //   424: aload_2
    //   425: ifnull +76 -> 501
    //   428: aload_2
    //   429: getfield 82	com/tencent/turingfd/sdk/qps/Ginkgo:i	Ljava/util/Map;
    //   432: astore 5
    //   434: getstatic 70	com/tencent/token/aek:b	Lcom/tencent/token/aek;
    //   437: astore 10
    //   439: aload 5
    //   441: ifnull +36 -> 477
    //   444: aload 5
    //   446: invokeinterface 226 1 0
    //   451: ifeq +26 -> 477
    //   454: aload 10
    //   456: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   459: pop
    //   460: aload_2
    //   461: invokevirtual 231	com/tencent/turingfd/sdk/qps/final:a	()[B
    //   464: astore_2
    //   465: aload_1
    //   466: invokestatic 157	com/tencent/token/aek:a	(Landroid/content/Context;)Ljava/lang/String;
    //   469: aload_2
    //   470: invokestatic 236	com/tencent/token/adg:a	(Ljava/lang/String;[B)Z
    //   473: pop
    //   474: goto +30 -> 504
    //   477: aload 10
    //   479: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   482: pop
    //   483: new 238	java/io/File
    //   486: dup
    //   487: aload_1
    //   488: invokestatic 157	com/tencent/token/aek:a	(Landroid/content/Context;)Ljava/lang/String;
    //   491: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;)V
    //   494: invokevirtual 244	java/io/File:delete	()Z
    //   497: pop
    //   498: goto +6 -> 504
    //   501: iconst_0
    //   502: istore 9
    //   504: aload_0
    //   505: monitorexit
    //   506: iload 9
    //   508: ireturn
    //   509: astore_1
    //   510: aload_0
    //   511: monitorexit
    //   512: aload_1
    //   513: athrow
    //   514: astore_2
    //   515: aload 10
    //   517: astore_2
    //   518: goto -336 -> 182
    //   521: astore_2
    //   522: goto -100 -> 422
    //   525: astore_1
    //   526: goto -22 -> 504
    //   529: ldc2_w 245
    //   532: lstore 7
    //   534: goto -489 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	ael
    //   0	537	1	paramContext	Context
    //   0	537	2	paramString1	java.lang.String
    //   0	537	3	paramLong	long
    //   0	537	5	paramString2	java.lang.String
    //   184	114	6	i	int
    //   33	500	7	l	long
    //   187	320	9	bool	boolean
    //   12	504	10	localObject	Object
    //   81	77	11	localHashMap	HashMap
    //   90	16	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	20	509	finally
    //   28	35	509	finally
    //   45	54	509	finally
    //   69	149	509	finally
    //   168	182	509	finally
    //   182	186	509	finally
    //   197	224	509	finally
    //   227	252	509	finally
    //   255	260	509	finally
    //   428	439	509	finally
    //   444	474	509	finally
    //   477	483	509	finally
    //   149	165	514	finally
    //   260	289	521	finally
    //   300	308	521	finally
    //   311	318	521	finally
    //   323	331	521	finally
    //   334	350	521	finally
    //   350	366	521	finally
    //   369	376	521	finally
    //   384	398	521	finally
    //   401	419	521	finally
    //   483	498	525	finally
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.e.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ael
 * JD-Core Version:    0.7.0.1
 */