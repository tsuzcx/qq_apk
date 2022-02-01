package com.tencent.token;

public final class ace
  implements abx
{
  public ace(String paramString) {}
  
  /* Error */
  public final abx.a a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/token/ace:a	Ljava/lang/String;
    //   4: astore 6
    //   6: ldc 37
    //   8: monitorenter
    //   9: getstatic 40	com/tencent/token/agn:a	Landroid/content/Context;
    //   12: astore 5
    //   14: ldc 37
    //   16: monitorexit
    //   17: iconst_1
    //   18: istore_3
    //   19: aload 5
    //   21: ldc 42
    //   23: invokevirtual 48	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: checkcast 50	android/net/ConnectivityManager
    //   29: invokevirtual 54	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   32: astore 7
    //   34: aload 7
    //   36: ifnull +102 -> 138
    //   39: aload 7
    //   41: invokevirtual 60	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   44: getstatic 66	android/net/NetworkInfo$State:CONNECTING	Landroid/net/NetworkInfo$State;
    //   47: if_acmpeq +14 -> 61
    //   50: aload 7
    //   52: invokevirtual 60	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   55: getstatic 69	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   58: if_acmpne +80 -> 138
    //   61: aload 7
    //   63: invokevirtual 73	android/net/NetworkInfo:getType	()I
    //   66: iconst_1
    //   67: if_icmpne +11 -> 78
    //   70: getstatic 78	com/tencent/turingfd/sdk/qps/Bootes$do:a	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   73: astore 5
    //   75: goto +119 -> 194
    //   78: aload 7
    //   80: invokevirtual 73	android/net/NetworkInfo:getType	()I
    //   83: ifne +47 -> 130
    //   86: aload 5
    //   88: invokestatic 83	com/tencent/turingfd/sdk/qps/Bootes:a	(Landroid/content/Context;)Ljava/lang/String;
    //   91: astore 7
    //   93: aload 7
    //   95: ifnull +27 -> 122
    //   98: aload 7
    //   100: invokevirtual 88	java/lang/String:length	()I
    //   103: ifle +19 -> 122
    //   106: aload 5
    //   108: invokestatic 92	com/tencent/turingfd/sdk/qps/Bootes:b	(Landroid/content/Context;)I
    //   111: ifle +11 -> 122
    //   114: getstatic 94	com/tencent/turingfd/sdk/qps/Bootes$do:b	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   117: astore 5
    //   119: goto +75 -> 194
    //   122: getstatic 97	com/tencent/turingfd/sdk/qps/Bootes$do:c	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   125: astore 5
    //   127: goto +67 -> 194
    //   130: getstatic 97	com/tencent/turingfd/sdk/qps/Bootes$do:c	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   133: astore 5
    //   135: goto +59 -> 194
    //   138: getstatic 100	com/tencent/turingfd/sdk/qps/Bootes$do:d	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   141: astore 5
    //   143: goto +51 -> 194
    //   146: astore 5
    //   148: aload 5
    //   150: invokevirtual 106	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   153: astore 5
    //   155: aload 5
    //   157: ifnull +18 -> 175
    //   160: aload 5
    //   162: ldc 108
    //   164: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   167: ifeq +8 -> 175
    //   170: iconst_1
    //   171: istore_2
    //   172: goto +5 -> 177
    //   175: iconst_0
    //   176: istore_2
    //   177: iload_2
    //   178: ifeq +11 -> 189
    //   181: getstatic 78	com/tencent/turingfd/sdk/qps/Bootes$do:a	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   184: astore 5
    //   186: goto +8 -> 194
    //   189: getstatic 100	com/tencent/turingfd/sdk/qps/Bootes$do:d	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   192: astore 5
    //   194: getstatic 100	com/tencent/turingfd/sdk/qps/Bootes$do:d	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   197: astore 8
    //   199: aconst_null
    //   200: astore 7
    //   202: aload 5
    //   204: aload 8
    //   206: if_acmpne +13 -> 219
    //   209: aconst_null
    //   210: astore 5
    //   212: sipush -1052
    //   215: istore_2
    //   216: goto +220 -> 436
    //   219: new 114	java/net/URL
    //   222: dup
    //   223: aload 6
    //   225: invokespecial 116	java/net/URL:<init>	(Ljava/lang/String;)V
    //   228: astore 6
    //   230: aload 5
    //   232: getstatic 94	com/tencent/turingfd/sdk/qps/Bootes$do:b	Lcom/tencent/turingfd/sdk/qps/Bootes$do;
    //   235: if_acmpne +41 -> 276
    //   238: aload 6
    //   240: new 118	java/net/Proxy
    //   243: dup
    //   244: getstatic 124	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   247: invokestatic 127	com/tencent/token/agn:a	()Landroid/content/Context;
    //   250: invokestatic 83	com/tencent/turingfd/sdk/qps/Bootes:a	(Landroid/content/Context;)Ljava/lang/String;
    //   253: invokestatic 127	com/tencent/token/agn:a	()Landroid/content/Context;
    //   256: invokestatic 92	com/tencent/turingfd/sdk/qps/Bootes:b	(Landroid/content/Context;)I
    //   259: invokestatic 133	java/net/InetSocketAddress:createUnresolved	(Ljava/lang/String;I)Ljava/net/InetSocketAddress;
    //   262: invokespecial 136	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   265: invokevirtual 140	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   268: checkcast 142	java/net/HttpURLConnection
    //   271: astore 5
    //   273: goto +13 -> 286
    //   276: aload 6
    //   278: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   281: checkcast 142	java/net/HttpURLConnection
    //   284: astore 5
    //   286: aload 5
    //   288: sipush 15000
    //   291: invokevirtual 149	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   294: aload 5
    //   296: sipush 15000
    //   299: invokevirtual 152	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   302: iconst_0
    //   303: istore_2
    //   304: goto +132 -> 436
    //   307: astore 6
    //   309: goto +33 -> 342
    //   312: astore 6
    //   314: goto +45 -> 359
    //   317: astore 6
    //   319: goto +57 -> 376
    //   322: astore 6
    //   324: goto +69 -> 393
    //   327: astore 6
    //   329: goto +81 -> 410
    //   332: astore 6
    //   334: goto +93 -> 427
    //   337: astore 6
    //   339: aconst_null
    //   340: astore 5
    //   342: sipush -1000
    //   345: istore_2
    //   346: aload 6
    //   348: invokevirtual 155	java/lang/Throwable:printStackTrace	()V
    //   351: goto +85 -> 436
    //   354: astore 6
    //   356: aconst_null
    //   357: astore 5
    //   359: sipush -1056
    //   362: istore_2
    //   363: aload 6
    //   365: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   368: goto +68 -> 436
    //   371: astore 6
    //   373: aconst_null
    //   374: astore 5
    //   376: sipush -1059
    //   379: istore_2
    //   380: aload 6
    //   382: invokevirtual 157	java/lang/UnsupportedOperationException:printStackTrace	()V
    //   385: goto +51 -> 436
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 5
    //   393: sipush -1058
    //   396: istore_2
    //   397: aload 6
    //   399: invokevirtual 158	java/lang/SecurityException:printStackTrace	()V
    //   402: goto +34 -> 436
    //   405: astore 6
    //   407: aconst_null
    //   408: astore 5
    //   410: sipush -1057
    //   413: istore_2
    //   414: aload 6
    //   416: invokevirtual 159	java/lang/IllegalArgumentException:printStackTrace	()V
    //   419: goto +17 -> 436
    //   422: astore 6
    //   424: aconst_null
    //   425: astore 5
    //   427: sipush -1053
    //   430: istore_2
    //   431: aload 6
    //   433: invokevirtual 160	java/net/MalformedURLException:printStackTrace	()V
    //   436: iload_2
    //   437: ifne +284 -> 721
    //   440: aload_1
    //   441: arraylength
    //   442: istore_2
    //   443: aload 5
    //   445: iconst_1
    //   446: invokevirtual 164	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   449: aload 5
    //   451: iconst_1
    //   452: invokevirtual 167	java/net/HttpURLConnection:setDoInput	(Z)V
    //   455: aload 5
    //   457: iconst_0
    //   458: invokevirtual 170	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   461: aload 5
    //   463: ldc 172
    //   465: invokevirtual 175	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   468: aload 5
    //   470: ldc 177
    //   472: ldc 179
    //   474: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 5
    //   479: ldc 185
    //   481: ldc 179
    //   483: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload 5
    //   488: iconst_0
    //   489: invokevirtual 188	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   492: aload 5
    //   494: ldc 190
    //   496: ldc 192
    //   498: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: aload 5
    //   503: ldc 194
    //   505: ldc 196
    //   507: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 5
    //   512: ldc 198
    //   514: ldc 200
    //   516: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: aload 5
    //   521: ldc 202
    //   523: ldc 204
    //   525: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload 5
    //   530: ldc 206
    //   532: iload_2
    //   533: invokestatic 210	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   536: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: getstatic 215	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   542: ifnull +20 -> 562
    //   545: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   548: bipush 13
    //   550: if_icmple +12 -> 562
    //   553: aload 5
    //   555: ldc 221
    //   557: ldc 223
    //   559: invokevirtual 183	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload 5
    //   564: invokevirtual 227	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   567: astore 6
    //   569: aload 6
    //   571: aload_1
    //   572: invokevirtual 233	java/io/OutputStream:write	([B)V
    //   575: aload 6
    //   577: invokevirtual 236	java/io/OutputStream:flush	()V
    //   580: aload 6
    //   582: invokevirtual 238	java/io/OutputStream:close	()V
    //   585: aload 5
    //   587: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   590: istore_2
    //   591: iload_2
    //   592: sipush 200
    //   595: if_icmpne +14 -> 609
    //   598: iconst_0
    //   599: istore 4
    //   601: iload_3
    //   602: istore_2
    //   603: iload 4
    //   605: istore_3
    //   606: goto +123 -> 729
    //   609: iload_2
    //   610: iconst_m1
    //   611: if_icmpne +12 -> 623
    //   614: iconst_0
    //   615: istore_2
    //   616: sipush -2000
    //   619: istore_3
    //   620: goto +109 -> 729
    //   623: sipush -2000
    //   626: iload_2
    //   627: isub
    //   628: istore_3
    //   629: iconst_0
    //   630: istore_2
    //   631: goto +98 -> 729
    //   634: astore_1
    //   635: aload_1
    //   636: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   639: iconst_0
    //   640: istore_2
    //   641: sipush -2000
    //   644: istore_3
    //   645: goto +84 -> 729
    //   648: astore_1
    //   649: sipush -2056
    //   652: istore_3
    //   653: new 244	java/lang/StringBuilder
    //   656: dup
    //   657: ldc 246
    //   659: invokespecial 247	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   662: aload_1
    //   663: invokevirtual 248	java/io/IOException:getMessage	()Ljava/lang/String;
    //   666: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload_1
    //   671: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   674: iconst_0
    //   675: istore_2
    //   676: goto +53 -> 729
    //   679: astore_1
    //   680: sipush -2051
    //   683: istore_3
    //   684: aload_1
    //   685: invokevirtual 253	java/net/ProtocolException:printStackTrace	()V
    //   688: iconst_0
    //   689: istore_2
    //   690: goto +39 -> 729
    //   693: astore_1
    //   694: sipush -2061
    //   697: istore_3
    //   698: aload_1
    //   699: invokevirtual 254	java/lang/IllegalStateException:printStackTrace	()V
    //   702: iconst_0
    //   703: istore_2
    //   704: goto +25 -> 729
    //   707: astore_1
    //   708: sipush -2060
    //   711: istore_3
    //   712: aload_1
    //   713: invokevirtual 255	java/lang/IllegalAccessError:printStackTrace	()V
    //   716: iconst_0
    //   717: istore_2
    //   718: goto +11 -> 729
    //   721: iconst_0
    //   722: istore 4
    //   724: iload_2
    //   725: istore_3
    //   726: iload 4
    //   728: istore_2
    //   729: iload_3
    //   730: ifeq +11 -> 741
    //   733: iload_3
    //   734: iconst_0
    //   735: newarray byte
    //   737: invokestatic 260	com/tencent/token/abx$a:a	(I[B)Lcom/tencent/token/abx$a;
    //   740: areturn
    //   741: new 262	java/util/concurrent/atomic/AtomicReference
    //   744: dup
    //   745: invokespecial 263	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   748: astore 6
    //   750: sipush -4000
    //   753: istore_3
    //   754: iload_3
    //   755: istore 4
    //   757: aload 5
    //   759: ifnull +102 -> 861
    //   762: iload_3
    //   763: istore 4
    //   765: iload_2
    //   766: ifeq +95 -> 861
    //   769: aload 5
    //   771: invokevirtual 267	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   774: astore_1
    //   775: new 269	java/io/ByteArrayOutputStream
    //   778: dup
    //   779: invokespecial 270	java/io/ByteArrayOutputStream:<init>	()V
    //   782: astore 8
    //   784: aload_1
    //   785: invokevirtual 275	java/io/InputStream:read	()I
    //   788: istore_2
    //   789: iload_2
    //   790: iconst_m1
    //   791: if_icmpeq +12 -> 803
    //   794: aload 8
    //   796: iload_2
    //   797: invokevirtual 277	java/io/ByteArrayOutputStream:write	(I)V
    //   800: goto -16 -> 784
    //   803: aload 8
    //   805: invokevirtual 281	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   808: astore_1
    //   809: iconst_0
    //   810: istore_2
    //   811: goto +28 -> 839
    //   814: astore_1
    //   815: aload_1
    //   816: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   819: iload_3
    //   820: istore_2
    //   821: aload 7
    //   823: astore_1
    //   824: goto +15 -> 839
    //   827: astore_1
    //   828: aload_1
    //   829: invokevirtual 156	java/io/IOException:printStackTrace	()V
    //   832: sipush -4056
    //   835: istore_2
    //   836: aload 7
    //   838: astore_1
    //   839: aload 6
    //   841: aload_1
    //   842: invokevirtual 285	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   845: iload_2
    //   846: istore 4
    //   848: aload 5
    //   850: ifnull +11 -> 861
    //   853: aload 5
    //   855: invokevirtual 288	java/net/HttpURLConnection:disconnect	()V
    //   858: iload_2
    //   859: istore 4
    //   861: iload 4
    //   863: ifeq +12 -> 875
    //   866: iload 4
    //   868: iconst_0
    //   869: newarray byte
    //   871: invokestatic 260	com/tencent/token/abx$a:a	(I[B)Lcom/tencent/token/abx$a;
    //   874: areturn
    //   875: iload 4
    //   877: aload 6
    //   879: invokevirtual 292	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   882: checkcast 294	[B
    //   885: invokestatic 260	com/tencent/token/abx$a:a	(I[B)Lcom/tencent/token/abx$a;
    //   888: areturn
    //   889: astore_1
    //   890: ldc 37
    //   892: monitorexit
    //   893: aload_1
    //   894: athrow
    //   895: astore 6
    //   897: goto -335 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	900	0	this	ace
    //   0	900	1	paramArrayOfByte	byte[]
    //   171	688	2	i	int
    //   18	802	3	j	int
    //   599	277	4	k	int
    //   12	130	5	localObject1	Object
    //   146	3	5	localObject2	Object
    //   153	701	5	localObject3	Object
    //   4	273	6	localObject4	Object
    //   307	1	6	localObject5	Object
    //   312	1	6	localIOException1	java.io.IOException
    //   317	1	6	localUnsupportedOperationException1	java.lang.UnsupportedOperationException
    //   322	1	6	localSecurityException1	java.lang.SecurityException
    //   327	1	6	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   332	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   337	10	6	localObject6	Object
    //   354	10	6	localIOException2	java.io.IOException
    //   371	10	6	localUnsupportedOperationException2	java.lang.UnsupportedOperationException
    //   388	10	6	localSecurityException2	java.lang.SecurityException
    //   405	10	6	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   422	10	6	localMalformedURLException2	java.net.MalformedURLException
    //   567	311	6	localObject7	Object
    //   895	1	6	localException	java.lang.Exception
    //   32	805	7	localObject8	Object
    //   197	607	8	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   19	34	146	finally
    //   286	302	307	finally
    //   286	302	312	java/io/IOException
    //   286	302	317	java/lang/UnsupportedOperationException
    //   286	302	322	java/lang/SecurityException
    //   286	302	327	java/lang/IllegalArgumentException
    //   286	302	332	java/net/MalformedURLException
    //   219	273	337	finally
    //   276	286	337	finally
    //   219	273	354	java/io/IOException
    //   276	286	354	java/io/IOException
    //   219	273	371	java/lang/UnsupportedOperationException
    //   276	286	371	java/lang/UnsupportedOperationException
    //   219	273	388	java/lang/SecurityException
    //   276	286	388	java/lang/SecurityException
    //   219	273	405	java/lang/IllegalArgumentException
    //   276	286	405	java/lang/IllegalArgumentException
    //   219	273	422	java/net/MalformedURLException
    //   276	286	422	java/net/MalformedURLException
    //   440	528	634	java/lang/Exception
    //   528	539	634	java/lang/Exception
    //   562	591	634	java/lang/Exception
    //   440	528	648	java/io/IOException
    //   528	539	648	java/io/IOException
    //   562	591	648	java/io/IOException
    //   440	528	679	java/net/ProtocolException
    //   528	539	679	java/net/ProtocolException
    //   562	591	679	java/net/ProtocolException
    //   440	528	693	java/lang/IllegalStateException
    //   528	539	693	java/lang/IllegalStateException
    //   562	591	693	java/lang/IllegalStateException
    //   440	528	707	java/lang/IllegalAccessError
    //   528	539	707	java/lang/IllegalAccessError
    //   539	562	707	java/lang/IllegalAccessError
    //   562	591	707	java/lang/IllegalAccessError
    //   769	784	814	java/lang/Exception
    //   784	789	814	java/lang/Exception
    //   794	800	814	java/lang/Exception
    //   803	809	814	java/lang/Exception
    //   769	784	827	java/io/IOException
    //   784	789	827	java/io/IOException
    //   794	800	827	java/io/IOException
    //   803	809	827	java/io/IOException
    //   9	14	889	finally
    //   539	562	895	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ace
 * JD-Core Version:    0.7.0.1
 */