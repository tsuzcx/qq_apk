package dov.com.qq.im.ae.play;

import axig;

public class UrlConHttpClient$1
  implements Runnable
{
  public UrlConHttpClient$1(axig paramaxig, String paramString1, int paramInt, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 36	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: getfield 19	dov/com/qq/im/ae/play/UrlConHttpClient$1:val$url	Ljava/lang/String;
    //   8: invokespecial 39	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 43	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 45	java/net/HttpURLConnection
    //   17: astore_2
    //   18: aload_2
    //   19: sipush 3000
    //   22: invokevirtual 49	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   25: aload_2
    //   26: sipush 3000
    //   29: invokevirtual 52	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   32: sipush -255
    //   35: invokestatic 57	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   38: aload_2
    //   39: ldc 59
    //   41: ldc 61
    //   43: invokevirtual 65	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_2
    //   47: ldc 67
    //   49: invokevirtual 70	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   52: aload_2
    //   53: invokevirtual 73	java/net/HttpURLConnection:connect	()V
    //   56: aload_2
    //   57: invokevirtual 77	java/net/HttpURLConnection:getResponseCode	()I
    //   60: istore_1
    //   61: iload_1
    //   62: sipush 200
    //   65: if_icmpne +209 -> 274
    //   68: aload_2
    //   69: invokevirtual 81	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   72: astore 4
    //   74: new 83	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 84	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_3
    //   82: sipush 1024
    //   85: newarray byte
    //   87: astore 5
    //   89: aload 4
    //   91: aload 5
    //   93: invokevirtual 90	java/io/InputStream:read	([B)I
    //   96: istore_1
    //   97: iconst_m1
    //   98: iload_1
    //   99: if_icmpeq +40 -> 139
    //   102: aload_3
    //   103: aload 5
    //   105: iconst_0
    //   106: iload_1
    //   107: invokevirtual 94	java/io/ByteArrayOutputStream:write	([BII)V
    //   110: aload_3
    //   111: invokevirtual 97	java/io/ByteArrayOutputStream:flush	()V
    //   114: goto -25 -> 89
    //   117: astore_2
    //   118: aload_0
    //   119: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   122: aload_0
    //   123: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   126: ldc 99
    //   128: aload_0
    //   129: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   132: invokestatic 105	axig:a	(Laxig;ILjava/lang/String;Ljava/lang/String;)V
    //   135: invokestatic 108	android/net/TrafficStats:clearThreadStatsTag	()V
    //   138: return
    //   139: aload 4
    //   141: invokevirtual 111	java/io/InputStream:close	()V
    //   144: aload_3
    //   145: invokevirtual 115	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   148: astore 4
    //   150: aload_3
    //   151: invokevirtual 116	java/io/ByteArrayOutputStream:close	()V
    //   154: invokestatic 119	axig:access$000	()Ljava/lang/String;
    //   157: new 121	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   164: ldc 124
    //   166: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 4
    //   171: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 134	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_0
    //   181: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   184: invokestatic 137	axig:a	(Laxig;)Lcom/tencent/ttpic/openapi/offlineset/utils/IResponseListener;
    //   187: ifnull +31 -> 218
    //   190: aload 4
    //   192: ifnull +34 -> 226
    //   195: aload_0
    //   196: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   199: invokestatic 137	axig:a	(Laxig;)Lcom/tencent/ttpic/openapi/offlineset/utils/IResponseListener;
    //   202: aload_0
    //   203: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   206: iconst_0
    //   207: aload 4
    //   209: aload_0
    //   210: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   213: invokeinterface 143 5 0
    //   218: aload_2
    //   219: invokevirtual 146	java/net/HttpURLConnection:disconnect	()V
    //   222: invokestatic 108	android/net/TrafficStats:clearThreadStatsTag	()V
    //   225: return
    //   226: aload_0
    //   227: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   230: invokestatic 137	axig:a	(Laxig;)Lcom/tencent/ttpic/openapi/offlineset/utils/IResponseListener;
    //   233: aload_0
    //   234: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   237: iconst_1
    //   238: ldc 148
    //   240: aload_0
    //   241: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   244: invokeinterface 143 5 0
    //   249: goto -31 -> 218
    //   252: astore_2
    //   253: aload_0
    //   254: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   257: aload_0
    //   258: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   261: ldc 150
    //   263: aload_0
    //   264: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   267: invokestatic 105	axig:a	(Laxig;ILjava/lang/String;Ljava/lang/String;)V
    //   270: invokestatic 108	android/net/TrafficStats:clearThreadStatsTag	()V
    //   273: return
    //   274: iload_1
    //   275: sipush 301
    //   278: if_icmpne +66 -> 344
    //   281: aload_0
    //   282: getfield 19	dov/com/qq/im/ae/play/UrlConHttpClient$1:val$url	Ljava/lang/String;
    //   285: ldc 152
    //   287: invokevirtual 158	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   290: ifeq +54 -> 344
    //   293: aload_0
    //   294: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   297: aload_0
    //   298: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   301: aload_0
    //   302: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   305: aload_0
    //   306: getfield 19	dov/com/qq/im/ae/play/UrlConHttpClient$1:val$url	Ljava/lang/String;
    //   309: ldc 152
    //   311: ldc 160
    //   313: invokevirtual 164	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   316: invokevirtual 168	axig:get	(ILjava/lang/String;Ljava/lang/String;)V
    //   319: goto -97 -> 222
    //   322: astore_2
    //   323: aload_0
    //   324: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   327: aload_0
    //   328: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   331: ldc 170
    //   333: aload_0
    //   334: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   337: invokestatic 105	axig:a	(Laxig;ILjava/lang/String;Ljava/lang/String;)V
    //   340: invokestatic 108	android/net/TrafficStats:clearThreadStatsTag	()V
    //   343: return
    //   344: invokestatic 119	axig:access$000	()Ljava/lang/String;
    //   347: new 121	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   354: iload_1
    //   355: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: ldc 175
    //   360: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: getfield 19	dov/com/qq/im/ae/play/UrlConHttpClient$1:val$url	Ljava/lang/String;
    //   367: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 178	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload_0
    //   377: getfield 17	dov/com/qq/im/ae/play/UrlConHttpClient$1:this$0	Laxig;
    //   380: aload_0
    //   381: getfield 21	dov/com/qq/im/ae/play/UrlConHttpClient$1:eFf	I
    //   384: new 121	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   391: iload_1
    //   392: invokevirtual 173	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc 175
    //   397: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_0
    //   401: getfield 19	dov/com/qq/im/ae/play/UrlConHttpClient$1:val$url	Ljava/lang/String;
    //   404: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: aload_0
    //   411: getfield 23	dov/com/qq/im/ae/play/UrlConHttpClient$1:cUG	Ljava/lang/String;
    //   414: invokestatic 105	axig:a	(Laxig;ILjava/lang/String;Ljava/lang/String;)V
    //   417: goto -195 -> 222
    //   420: astore_2
    //   421: invokestatic 108	android/net/TrafficStats:clearThreadStatsTag	()V
    //   424: aload_2
    //   425: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	1
    //   60	332	1	i	int
    //   17	52	2	localHttpURLConnection	java.net.HttpURLConnection
    //   117	102	2	localMalformedURLException	java.net.MalformedURLException
    //   252	1	2	localIOException	java.io.IOException
    //   322	1	2	localException	java.lang.Exception
    //   420	5	2	localObject1	Object
    //   81	70	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   72	136	4	localObject2	Object
    //   87	17	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	61	117	java/net/MalformedURLException
    //   68	89	117	java/net/MalformedURLException
    //   89	97	117	java/net/MalformedURLException
    //   102	114	117	java/net/MalformedURLException
    //   139	190	117	java/net/MalformedURLException
    //   195	218	117	java/net/MalformedURLException
    //   218	222	117	java/net/MalformedURLException
    //   226	249	117	java/net/MalformedURLException
    //   281	319	117	java/net/MalformedURLException
    //   344	417	117	java/net/MalformedURLException
    //   0	61	252	java/io/IOException
    //   68	89	252	java/io/IOException
    //   89	97	252	java/io/IOException
    //   102	114	252	java/io/IOException
    //   139	190	252	java/io/IOException
    //   195	218	252	java/io/IOException
    //   218	222	252	java/io/IOException
    //   226	249	252	java/io/IOException
    //   281	319	252	java/io/IOException
    //   344	417	252	java/io/IOException
    //   0	61	322	java/lang/Exception
    //   68	89	322	java/lang/Exception
    //   89	97	322	java/lang/Exception
    //   102	114	322	java/lang/Exception
    //   139	190	322	java/lang/Exception
    //   195	218	322	java/lang/Exception
    //   218	222	322	java/lang/Exception
    //   226	249	322	java/lang/Exception
    //   281	319	322	java/lang/Exception
    //   344	417	322	java/lang/Exception
    //   0	61	420	finally
    //   68	89	420	finally
    //   89	97	420	finally
    //   102	114	420	finally
    //   118	135	420	finally
    //   139	190	420	finally
    //   195	218	420	finally
    //   218	222	420	finally
    //   226	249	420	finally
    //   253	270	420	finally
    //   281	319	420	finally
    //   323	340	420	finally
    //   344	417	420	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.UrlConHttpClient.1
 * JD-Core Version:    0.7.0.1
 */