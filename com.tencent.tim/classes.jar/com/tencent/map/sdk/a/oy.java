package com.tencent.map.sdk.a;

import java.security.MessageDigest;

public final class oy
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final ot<String, String> b = new ot(1000);
  private final ow.f<ow.h<MessageDigest>> c = ow.a(10, new oy.1(this));
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/map/sdk/a/oy:b	Lcom/tencent/map/sdk/a/ot;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 43	com/tencent/map/sdk/a/oy:b	Lcom/tencent/map/sdk/a/ot;
    //   13: aload_1
    //   14: invokevirtual 59	com/tencent/map/sdk/a/ot:b	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 61	java/lang/String
    //   20: astore 4
    //   22: aload 5
    //   24: monitorexit
    //   25: aload 4
    //   27: ifnonnull +205 -> 232
    //   30: aload_0
    //   31: getfield 55	com/tencent/map/sdk/a/oy:c	Lcom/tencent/map/sdk/a/ow$f;
    //   34: invokeinterface 66 1 0
    //   39: checkcast 68	com/tencent/map/sdk/a/ow$h
    //   42: astore 5
    //   44: aload 5
    //   46: getfield 71	com/tencent/map/sdk/a/ow$h:a	Ljava/lang/Object;
    //   49: checkcast 73	java/security/MessageDigest
    //   52: aload_1
    //   53: invokevirtual 77	java/lang/String:getBytes	()[B
    //   56: invokevirtual 81	java/security/MessageDigest:update	([B)V
    //   59: aload 5
    //   61: getfield 71	com/tencent/map/sdk/a/ow$h:a	Ljava/lang/Object;
    //   64: checkcast 73	java/security/MessageDigest
    //   67: invokevirtual 84	java/security/MessageDigest:digest	()[B
    //   70: astore 4
    //   72: aload 4
    //   74: ifnull +131 -> 205
    //   77: aload 4
    //   79: arraylength
    //   80: ifeq +125 -> 205
    //   83: aload 4
    //   85: arraylength
    //   86: iconst_2
    //   87: imul
    //   88: newarray char
    //   90: astore 6
    //   92: iconst_0
    //   93: istore_2
    //   94: iload_2
    //   95: aload 4
    //   97: arraylength
    //   98: if_icmpge +58 -> 156
    //   101: aload 4
    //   103: iload_2
    //   104: baload
    //   105: istore_3
    //   106: aload 6
    //   108: iload_2
    //   109: iconst_2
    //   110: imul
    //   111: iconst_1
    //   112: iadd
    //   113: getstatic 32	com/tencent/map/sdk/a/oy:a	[C
    //   116: iload_3
    //   117: bipush 15
    //   119: iand
    //   120: caload
    //   121: castore
    //   122: iload_3
    //   123: iconst_4
    //   124: iushr
    //   125: i2b
    //   126: istore_3
    //   127: aload 6
    //   129: iload_2
    //   130: iconst_2
    //   131: imul
    //   132: iconst_0
    //   133: iadd
    //   134: getstatic 32	com/tencent/map/sdk/a/oy:a	[C
    //   137: iload_3
    //   138: bipush 15
    //   140: iand
    //   141: caload
    //   142: castore
    //   143: iload_2
    //   144: iconst_1
    //   145: iadd
    //   146: istore_2
    //   147: goto -53 -> 94
    //   150: astore_1
    //   151: aload 5
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    //   156: new 61	java/lang/String
    //   159: dup
    //   160: aload 6
    //   162: invokespecial 87	java/lang/String:<init>	([C)V
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 55	com/tencent/map/sdk/a/oy:c	Lcom/tencent/map/sdk/a/ow$f;
    //   171: aload 5
    //   173: invokeinterface 90 2 0
    //   178: pop
    //   179: aload_0
    //   180: getfield 43	com/tencent/map/sdk/a/oy:b	Lcom/tencent/map/sdk/a/ot;
    //   183: astore 5
    //   185: aload 5
    //   187: monitorenter
    //   188: aload_0
    //   189: getfield 43	com/tencent/map/sdk/a/oy:b	Lcom/tencent/map/sdk/a/ot;
    //   192: aload_1
    //   193: aload 4
    //   195: invokevirtual 93	com/tencent/map/sdk/a/ot:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: aload 5
    //   201: monitorexit
    //   202: aload 4
    //   204: areturn
    //   205: aconst_null
    //   206: astore 4
    //   208: goto -41 -> 167
    //   211: astore_1
    //   212: aload_0
    //   213: getfield 55	com/tencent/map/sdk/a/oy:c	Lcom/tencent/map/sdk/a/ow$f;
    //   216: aload 5
    //   218: invokeinterface 90 2 0
    //   223: pop
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: aload 5
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    //   232: goto -53 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	oy
    //   0	235	1	paramString	String
    //   93	54	2	i	int
    //   105	36	3	j	int
    //   20	187	4	localObject1	Object
    //   90	71	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   9	25	150	finally
    //   151	154	150	finally
    //   44	72	211	finally
    //   77	92	211	finally
    //   94	101	211	finally
    //   106	122	211	finally
    //   127	143	211	finally
    //   156	167	211	finally
    //   188	202	226	finally
    //   227	230	226	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oy
 * JD-Core Version:    0.7.0.1
 */