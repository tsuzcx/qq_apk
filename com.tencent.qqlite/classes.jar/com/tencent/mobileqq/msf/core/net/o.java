package com.tencent.mobileqq.msf.core.net;

class o
  extends Thread
{
  o(h paramh) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   4: iconst_0
    //   5: putfield 23	com/tencent/mobileqq/msf/core/net/h:z	I
    //   8: aload_0
    //   9: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   12: iconst_0
    //   13: putfield 27	com/tencent/mobileqq/msf/core/net/h:A	Z
    //   16: ldc 29
    //   18: invokevirtual 35	java/lang/String:getBytes	()[B
    //   21: astore 7
    //   23: sipush 128
    //   26: newarray byte
    //   28: astore 9
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore 8
    //   36: aload 6
    //   38: astore 5
    //   40: new 37	java/net/URL
    //   43: dup
    //   44: ldc 39
    //   46: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: astore 10
    //   51: aload 6
    //   53: astore 5
    //   55: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   58: lstore_3
    //   59: aload 6
    //   61: astore 5
    //   63: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +15 -> 81
    //   69: aload 6
    //   71: astore 5
    //   73: ldc 56
    //   75: iconst_2
    //   76: ldc 58
    //   78: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload 6
    //   83: astore 5
    //   85: aload 10
    //   87: invokevirtual 66	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   90: checkcast 68	java/net/HttpURLConnection
    //   93: astore 6
    //   95: aload 6
    //   97: iconst_1
    //   98: invokevirtual 72	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   101: aload 6
    //   103: ldc 74
    //   105: invokevirtual 77	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 6
    //   110: sipush 10000
    //   113: invokevirtual 81	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   116: aload 6
    //   118: sipush 10000
    //   121: invokevirtual 84	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   124: aload 6
    //   126: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   129: aload 7
    //   131: invokevirtual 94	java/io/OutputStream:write	([B)V
    //   134: aload 6
    //   136: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   139: invokevirtual 97	java/io/OutputStream:flush	()V
    //   142: aload 6
    //   144: invokevirtual 88	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   147: invokevirtual 100	java/io/OutputStream:close	()V
    //   150: aload 6
    //   152: invokevirtual 104	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   155: aload 9
    //   157: invokevirtual 110	java/io/InputStream:read	([B)I
    //   160: istore_1
    //   161: aload 6
    //   163: invokevirtual 114	java/net/HttpURLConnection:getResponseCode	()I
    //   166: istore_2
    //   167: iload_2
    //   168: sipush 200
    //   171: if_icmpne +106 -> 277
    //   174: aload 10
    //   176: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   179: aload 6
    //   181: invokevirtual 122	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   184: invokevirtual 118	java/net/URL:getHost	()Ljava/lang/String;
    //   187: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +87 -> 277
    //   193: ldc 56
    //   195: iconst_1
    //   196: new 128	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   203: ldc 131
    //   205: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload_2
    //   209: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc 140
    //   214: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   220: lload_3
    //   221: lsub
    //   222: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc 145
    //   227: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_1
    //   231: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   244: iload_2
    //   245: putfield 23	com/tencent/mobileqq/msf/core/net/h:z	I
    //   248: aload_0
    //   249: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   252: iconst_1
    //   253: putfield 27	com/tencent/mobileqq/msf/core/net/h:A	Z
    //   256: aload 6
    //   258: ifnull +8 -> 266
    //   261: aload 6
    //   263: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   266: aload_0
    //   267: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   270: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   273: putfield 155	com/tencent/mobileqq/msf/core/net/h:C	J
    //   276: return
    //   277: new 128	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   284: ldc 157
    //   286: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload_2
    //   290: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: pop
    //   297: ldc 56
    //   299: iconst_1
    //   300: new 128	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   307: ldc 159
    //   309: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: iload_2
    //   313: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   316: ldc 145
    //   318: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload_1
    //   322: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: goto -75 -> 256
    //   334: astore 7
    //   336: aload 6
    //   338: astore 5
    //   340: aload 7
    //   342: invokevirtual 160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   345: astore 8
    //   347: aload 6
    //   349: astore 5
    //   351: aload_0
    //   352: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   355: iconst_0
    //   356: putfield 23	com/tencent/mobileqq/msf/core/net/h:z	I
    //   359: aload 6
    //   361: astore 5
    //   363: aload_0
    //   364: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   367: iconst_0
    //   368: putfield 27	com/tencent/mobileqq/msf/core/net/h:A	Z
    //   371: aload 6
    //   373: astore 5
    //   375: ldc 56
    //   377: iconst_1
    //   378: new 128	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   385: ldc 162
    //   387: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 8
    //   392: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: aload 7
    //   400: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload 6
    //   405: ifnull +8 -> 413
    //   408: aload 6
    //   410: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   413: aload_0
    //   414: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   417: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   420: putfield 155	com/tencent/mobileqq/msf/core/net/h:C	J
    //   423: return
    //   424: astore 7
    //   426: aload 5
    //   428: astore 6
    //   430: aload 7
    //   432: astore 5
    //   434: aload 6
    //   436: ifnull +8 -> 444
    //   439: aload 6
    //   441: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   444: aload_0
    //   445: getfield 10	com/tencent/mobileqq/msf/core/net/o:a	Lcom/tencent/mobileqq/msf/core/net/h;
    //   448: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   451: putfield 155	com/tencent/mobileqq/msf/core/net/h:C	J
    //   454: aload 5
    //   456: athrow
    //   457: astore 5
    //   459: goto -25 -> 434
    //   462: astore 7
    //   464: aload 8
    //   466: astore 6
    //   468: goto -132 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	o
    //   160	162	1	i	int
    //   166	147	2	j	int
    //   58	163	3	l	long
    //   38	417	5	localObject1	java.lang.Object
    //   457	1	5	localObject2	java.lang.Object
    //   31	436	6	localObject3	java.lang.Object
    //   21	109	7	arrayOfByte1	byte[]
    //   334	65	7	localThrowable1	java.lang.Throwable
    //   424	7	7	localObject4	java.lang.Object
    //   462	1	7	localThrowable2	java.lang.Throwable
    //   34	431	8	str	java.lang.String
    //   28	128	9	arrayOfByte2	byte[]
    //   49	126	10	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   95	167	334	java/lang/Throwable
    //   174	256	334	java/lang/Throwable
    //   277	331	334	java/lang/Throwable
    //   40	51	424	finally
    //   55	59	424	finally
    //   63	69	424	finally
    //   73	81	424	finally
    //   85	95	424	finally
    //   340	347	424	finally
    //   351	359	424	finally
    //   363	371	424	finally
    //   375	403	424	finally
    //   95	167	457	finally
    //   174	256	457	finally
    //   277	331	457	finally
    //   40	51	462	java/lang/Throwable
    //   55	59	462	java/lang/Throwable
    //   63	69	462	java/lang/Throwable
    //   73	81	462	java/lang/Throwable
    //   85	95	462	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.o
 * JD-Core Version:    0.7.0.1
 */