package com.tencent.mobileqq.msf.core.c;

class g
  implements Runnable
{
  g(f paramf) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   6: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   9: invokevirtual 35	java/util/concurrent/ConcurrentHashMap:size	()I
    //   12: ifle +406 -> 418
    //   15: aload_0
    //   16: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   19: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: invokevirtual 39	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   25: invokeinterface 45 1 0
    //   30: astore 7
    //   32: aload 7
    //   34: invokeinterface 51 1 0
    //   39: ifeq -37 -> 2
    //   42: aload 7
    //   44: invokeinterface 55 1 0
    //   49: checkcast 57	java/util/Map$Entry
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull -24 -> 32
    //   59: aload 6
    //   61: invokeinterface 60 1 0
    //   66: ifnull -34 -> 32
    //   69: aload 6
    //   71: invokeinterface 63 1 0
    //   76: ifnull -44 -> 32
    //   79: ldc 65
    //   81: invokestatic 71	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   84: invokevirtual 77	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq -57 -> 32
    //   92: new 79	java/io/File
    //   95: dup
    //   96: getstatic 83	com/tencent/mobileqq/msf/core/c/f:w	Ljava/lang/String;
    //   99: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull -74 -> 32
    //   109: aload 4
    //   111: invokevirtual 89	java/io/File:exists	()Z
    //   114: ifne +11 -> 125
    //   117: aload 4
    //   119: invokevirtual 92	java/io/File:mkdirs	()Z
    //   122: ifeq -90 -> 32
    //   125: aload 6
    //   127: invokeinterface 60 1 0
    //   132: checkcast 73	java/lang/String
    //   135: ldc 94
    //   137: invokevirtual 98	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   140: ifeq +72 -> 212
    //   143: new 79	java/io/File
    //   146: dup
    //   147: getstatic 83	com/tencent/mobileqq/msf/core/c/f:w	Ljava/lang/String;
    //   150: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 102	java/io/File:listFiles	()[Ljava/io/File;
    //   156: astore 4
    //   158: aload 4
    //   160: ifnull +52 -> 212
    //   163: aload 4
    //   165: arraylength
    //   166: bipush 100
    //   168: if_icmple +44 -> 212
    //   171: iconst_0
    //   172: istore_1
    //   173: iload_1
    //   174: aload 4
    //   176: arraylength
    //   177: if_icmpge +35 -> 212
    //   180: aload 4
    //   182: iload_1
    //   183: aaload
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +17 -> 205
    //   191: aload 5
    //   193: invokevirtual 105	java/io/File:isFile	()Z
    //   196: ifeq +9 -> 205
    //   199: aload 5
    //   201: invokevirtual 108	java/io/File:delete	()Z
    //   204: pop
    //   205: iload_1
    //   206: iconst_1
    //   207: iadd
    //   208: istore_1
    //   209: goto -36 -> 173
    //   212: new 79	java/io/File
    //   215: dup
    //   216: new 110	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   223: getstatic 83	com/tencent/mobileqq/msf/core/c/f:w	Ljava/lang/String;
    //   226: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 6
    //   231: invokeinterface 60 1 0
    //   236: checkcast 73	java/lang/String
    //   239: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore 8
    //   250: aconst_null
    //   251: astore 5
    //   253: aload 8
    //   255: ifnull -223 -> 32
    //   258: new 120	java/io/FileOutputStream
    //   261: dup
    //   262: aload 8
    //   264: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore 4
    //   269: aload 4
    //   271: aload 6
    //   273: invokeinterface 63 1 0
    //   278: checkcast 125	[B
    //   281: invokevirtual 129	java/io/FileOutputStream:write	([B)V
    //   284: aload 4
    //   286: invokevirtual 132	java/io/FileOutputStream:flush	()V
    //   289: aload 4
    //   291: ifnull +8 -> 299
    //   294: aload 4
    //   296: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   299: iconst_1
    //   300: istore_1
    //   301: iload_1
    //   302: ifne +9 -> 311
    //   305: aload 8
    //   307: invokevirtual 108	java/io/File:delete	()Z
    //   310: pop
    //   311: aload_0
    //   312: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   315: getfield 139	com/tencent/mobileqq/msf/core/c/f:y	Ljava/lang/Object;
    //   318: astore 4
    //   320: aload 4
    //   322: monitorenter
    //   323: aload_0
    //   324: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   327: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   330: aload 6
    //   332: invokeinterface 60 1 0
    //   337: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: aload 4
    //   343: monitorexit
    //   344: goto -312 -> 32
    //   347: astore 5
    //   349: aload 4
    //   351: monitorexit
    //   352: aload 5
    //   354: athrow
    //   355: astore 5
    //   357: aconst_null
    //   358: astore 4
    //   360: aload 4
    //   362: ifnull +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   370: iconst_1
    //   371: istore_1
    //   372: iload_1
    //   373: ifne +9 -> 382
    //   376: aload 8
    //   378: invokevirtual 108	java/io/File:delete	()Z
    //   381: pop
    //   382: aload_0
    //   383: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   386: getfield 139	com/tencent/mobileqq/msf/core/c/f:y	Ljava/lang/Object;
    //   389: astore 4
    //   391: aload 4
    //   393: monitorenter
    //   394: aload_0
    //   395: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   398: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   401: aload 6
    //   403: invokeinterface 60 1 0
    //   408: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   411: pop
    //   412: aload 4
    //   414: monitorexit
    //   415: aload 5
    //   417: athrow
    //   418: ldc2_w 144
    //   421: invokestatic 151	java/lang/Thread:sleep	(J)V
    //   424: goto -422 -> 2
    //   427: astore 4
    //   429: goto -427 -> 2
    //   432: astore 4
    //   434: aload 5
    //   436: astore 4
    //   438: aload 4
    //   440: ifnull +8 -> 448
    //   443: aload 4
    //   445: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   448: aload 8
    //   450: invokevirtual 108	java/io/File:delete	()Z
    //   453: pop
    //   454: aload_0
    //   455: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   458: getfield 139	com/tencent/mobileqq/msf/core/c/f:y	Ljava/lang/Object;
    //   461: astore 4
    //   463: aload 4
    //   465: monitorenter
    //   466: aload_0
    //   467: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   470: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   473: aload 6
    //   475: invokeinterface 60 1 0
    //   480: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   483: pop
    //   484: aload 4
    //   486: monitorexit
    //   487: goto -455 -> 32
    //   490: astore 5
    //   492: aload 4
    //   494: monitorexit
    //   495: aload 5
    //   497: athrow
    //   498: astore 4
    //   500: goto -52 -> 448
    //   503: astore 4
    //   505: aconst_null
    //   506: astore 4
    //   508: aload 4
    //   510: ifnull +8 -> 518
    //   513: aload 4
    //   515: invokevirtual 135	java/io/FileOutputStream:close	()V
    //   518: aload 8
    //   520: invokevirtual 108	java/io/File:delete	()Z
    //   523: pop
    //   524: aload_0
    //   525: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   528: getfield 139	com/tencent/mobileqq/msf/core/c/f:y	Ljava/lang/Object;
    //   531: astore 4
    //   533: aload 4
    //   535: monitorenter
    //   536: aload_0
    //   537: getfield 12	com/tencent/mobileqq/msf/core/c/g:a	Lcom/tencent/mobileqq/msf/core/c/f;
    //   540: getfield 29	com/tencent/mobileqq/msf/core/c/f:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   543: aload 6
    //   545: invokeinterface 60 1 0
    //   550: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   553: pop
    //   554: aload 4
    //   556: monitorexit
    //   557: goto -525 -> 32
    //   560: astore 5
    //   562: aload 4
    //   564: monitorexit
    //   565: aload 5
    //   567: athrow
    //   568: astore 4
    //   570: goto -52 -> 518
    //   573: astore 4
    //   575: iload_2
    //   576: istore_1
    //   577: goto -205 -> 372
    //   580: astore 5
    //   582: aload 4
    //   584: monitorexit
    //   585: aload 5
    //   587: athrow
    //   588: astore 4
    //   590: iconst_0
    //   591: istore_1
    //   592: goto -291 -> 301
    //   595: astore 5
    //   597: goto -237 -> 360
    //   600: astore 5
    //   602: goto -94 -> 508
    //   605: astore 5
    //   607: goto -169 -> 438
    //   610: astore 4
    //   612: goto -520 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	g
    //   172	420	1	i	int
    //   1	575	2	j	int
    //   87	2	3	bool	boolean
    //   102	311	4	localObject1	Object
    //   427	1	4	localException1	java.lang.Exception
    //   432	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   498	1	4	localIOException1	java.io.IOException
    //   503	1	4	localIOException2	java.io.IOException
    //   568	1	4	localIOException3	java.io.IOException
    //   573	10	4	localIOException4	java.io.IOException
    //   588	1	4	localIOException5	java.io.IOException
    //   610	1	4	localException2	java.lang.Exception
    //   184	68	5	localObject4	Object
    //   347	6	5	localObject5	Object
    //   355	80	5	localObject6	Object
    //   490	6	5	localObject7	Object
    //   560	6	5	localObject8	Object
    //   580	6	5	localObject9	Object
    //   595	1	5	localObject10	Object
    //   600	1	5	localIOException6	java.io.IOException
    //   605	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   52	492	6	localEntry	java.util.Map.Entry
    //   30	13	7	localIterator	java.util.Iterator
    //   248	271	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   323	344	347	finally
    //   349	352	347	finally
    //   258	269	355	finally
    //   418	424	427	java/lang/Exception
    //   258	269	432	java/io/FileNotFoundException
    //   466	487	490	finally
    //   492	495	490	finally
    //   443	448	498	java/io/IOException
    //   258	269	503	java/io/IOException
    //   536	557	560	finally
    //   562	565	560	finally
    //   513	518	568	java/io/IOException
    //   365	370	573	java/io/IOException
    //   394	415	580	finally
    //   582	585	580	finally
    //   294	299	588	java/io/IOException
    //   269	289	595	finally
    //   269	289	600	java/io/IOException
    //   269	289	605	java/io/FileNotFoundException
    //   79	88	610	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.g
 * JD-Core Version:    0.7.0.1
 */