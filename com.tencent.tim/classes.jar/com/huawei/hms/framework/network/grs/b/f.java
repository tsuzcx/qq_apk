package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import java.util.concurrent.Callable;

public class f
  extends b
  implements Callable<d>
{
  private static final String b = f.class.getSimpleName();
  
  public f(String paramString1, int paramInt, a parama, Context paramContext, String paramString2)
  {
    super(paramString1, paramInt, parama, paramContext, paramString2);
  }
  
  /* Error */
  public d g()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: getstatic 19	com/huawei/hms/framework/network/grs/b/f:b	Ljava/lang/String;
    //   6: ldc 34
    //   8: invokestatic 40	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   11: invokestatic 46	android/os/SystemClock:elapsedRealtime	()J
    //   14: lstore 6
    //   16: lload 4
    //   18: lstore_2
    //   19: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   22: lstore 4
    //   24: lload 4
    //   26: lstore_2
    //   27: aload_0
    //   28: invokevirtual 54	com/huawei/hms/framework/network/grs/b/f:a	()Ljava/lang/String;
    //   31: aload_0
    //   32: invokevirtual 58	com/huawei/hms/framework/network/grs/b/f:d	()Landroid/content/Context;
    //   35: aload_0
    //   36: invokevirtual 61	com/huawei/hms/framework/network/grs/b/f:e	()Ljava/lang/String;
    //   39: invokestatic 66	com/huawei/hms/framework/network/grs/c/a/a:a	(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   42: astore 14
    //   44: aload 14
    //   46: ifnonnull +16 -> 62
    //   49: lload 4
    //   51: lstore_2
    //   52: getstatic 19	com/huawei/hms/framework/network/grs/b/f:b	Ljava/lang/String;
    //   55: ldc 68
    //   57: invokestatic 71	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   60: aconst_null
    //   61: areturn
    //   62: lload 4
    //   64: lstore_2
    //   65: aload 14
    //   67: ldc 73
    //   69: invokevirtual 79	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   72: lload 4
    //   74: lstore_2
    //   75: aload 14
    //   77: invokevirtual 82	javax/net/ssl/HttpsURLConnection:connect	()V
    //   80: lload 4
    //   82: lstore_2
    //   83: aload 14
    //   85: invokevirtual 86	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   88: istore_1
    //   89: iload_1
    //   90: sipush 200
    //   93: if_icmpne +243 -> 336
    //   96: aload 14
    //   98: invokevirtual 90	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   101: astore 13
    //   103: aload 13
    //   105: invokestatic 96	com/huawei/hms/framework/common/IoUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   108: astore 12
    //   110: lload 4
    //   112: lstore_2
    //   113: aload 13
    //   115: invokestatic 100	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   118: lload 4
    //   120: lstore_2
    //   121: aload 14
    //   123: invokevirtual 104	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   126: astore 13
    //   128: lload 4
    //   130: lstore_2
    //   131: aload 14
    //   133: invokevirtual 107	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   136: lload 4
    //   138: lstore_2
    //   139: invokestatic 46	android/os/SystemClock:elapsedRealtime	()J
    //   142: lstore 10
    //   144: lload 4
    //   146: lstore_2
    //   147: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   150: lstore 8
    //   152: lload 4
    //   154: lstore_2
    //   155: aload_0
    //   156: new 109	com/huawei/hms/framework/network/grs/b/d
    //   159: dup
    //   160: iload_1
    //   161: aload 13
    //   163: aload 12
    //   165: lload 10
    //   167: lload 6
    //   169: lsub
    //   170: invokespecial 112	com/huawei/hms/framework/network/grs/b/d:<init>	(ILjava/util/Map;[BJ)V
    //   173: putfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   176: lload 8
    //   178: lstore_2
    //   179: lload 4
    //   181: lstore 6
    //   183: lload_2
    //   184: lstore 4
    //   186: aload_0
    //   187: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   190: aload_0
    //   191: invokevirtual 54	com/huawei/hms/framework/network/grs/b/f:a	()Ljava/lang/String;
    //   194: invokevirtual 117	com/huawei/hms/framework/network/grs/b/d:a	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   201: aload_0
    //   202: invokevirtual 120	com/huawei/hms/framework/network/grs/b/f:c	()I
    //   205: invokevirtual 123	com/huawei/hms/framework/network/grs/b/d:a	(I)V
    //   208: aload_0
    //   209: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   212: lload 6
    //   214: invokevirtual 126	com/huawei/hms/framework/network/grs/b/d:a	(J)V
    //   217: aload_0
    //   218: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   221: lload 4
    //   223: invokevirtual 128	com/huawei/hms/framework/network/grs/b/d:b	(J)V
    //   226: aload_0
    //   227: invokevirtual 131	com/huawei/hms/framework/network/grs/b/f:b	()Lcom/huawei/hms/framework/network/grs/b/a;
    //   230: ifnull +16 -> 246
    //   233: aload_0
    //   234: invokevirtual 131	com/huawei/hms/framework/network/grs/b/f:b	()Lcom/huawei/hms/framework/network/grs/b/a;
    //   237: aload_0
    //   238: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   241: invokeinterface 136 2 0
    //   246: aload_0
    //   247: getfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   250: areturn
    //   251: astore 12
    //   253: aconst_null
    //   254: astore 13
    //   256: lload 4
    //   258: lstore_2
    //   259: aload 13
    //   261: invokestatic 100	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   264: lload 4
    //   266: lstore_2
    //   267: aload 12
    //   269: athrow
    //   270: astore 12
    //   272: lload 6
    //   274: lstore 4
    //   276: invokestatic 46	android/os/SystemClock:elapsedRealtime	()J
    //   279: lstore 8
    //   281: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   284: lstore 6
    //   286: getstatic 19	com/huawei/hms/framework/network/grs/b/f:b	Ljava/lang/String;
    //   289: ldc 138
    //   291: aload 12
    //   293: invokestatic 141	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload_0
    //   297: new 109	com/huawei/hms/framework/network/grs/b/d
    //   300: dup
    //   301: aload 12
    //   303: lload 8
    //   305: lload 4
    //   307: lsub
    //   308: invokespecial 144	com/huawei/hms/framework/network/grs/b/d:<init>	(Ljava/lang/Exception;J)V
    //   311: putfield 115	com/huawei/hms/framework/network/grs/b/f:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   314: lload 6
    //   316: lstore 4
    //   318: lload_2
    //   319: lstore 6
    //   321: goto -135 -> 186
    //   324: astore 12
    //   326: lconst_0
    //   327: lstore_2
    //   328: goto -52 -> 276
    //   331: astore 12
    //   333: goto -77 -> 256
    //   336: aconst_null
    //   337: astore 12
    //   339: goto -221 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	f
    //   88	73	1	i	int
    //   18	310	2	l1	long
    //   1	316	4	l2	long
    //   14	306	6	l3	long
    //   150	154	8	l4	long
    //   142	24	10	l5	long
    //   108	56	12	arrayOfByte	byte[]
    //   251	17	12	localObject1	java.lang.Object
    //   270	32	12	localIOException1	java.io.IOException
    //   324	1	12	localIOException2	java.io.IOException
    //   331	1	12	localObject2	java.lang.Object
    //   337	1	12	localObject3	java.lang.Object
    //   101	159	13	localObject4	java.lang.Object
    //   42	90	14	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   96	103	251	finally
    //   19	24	270	java/io/IOException
    //   27	44	270	java/io/IOException
    //   52	60	270	java/io/IOException
    //   65	72	270	java/io/IOException
    //   75	80	270	java/io/IOException
    //   83	89	270	java/io/IOException
    //   113	118	270	java/io/IOException
    //   121	128	270	java/io/IOException
    //   131	136	270	java/io/IOException
    //   139	144	270	java/io/IOException
    //   147	152	270	java/io/IOException
    //   155	176	270	java/io/IOException
    //   259	264	270	java/io/IOException
    //   267	270	270	java/io/IOException
    //   11	16	324	java/io/IOException
    //   103	110	331	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.f
 * JD-Core Version:    0.7.0.1
 */