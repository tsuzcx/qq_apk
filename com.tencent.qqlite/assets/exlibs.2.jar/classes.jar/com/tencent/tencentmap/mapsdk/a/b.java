package com.tencent.tencentmap.mapsdk.a;

import android.net.Proxy;
import com.tencent.mapsdk.net.NetContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class b
{
  private static int a = 0;
  private static boolean b;
  
  /* Error */
  private static com.tencent.mapsdk.net.NetResponse a(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 7
    //   5: aload 7
    //   7: astore 5
    //   9: new 18	com/tencent/mapsdk/net/NetResponse
    //   12: dup
    //   13: invokespecial 21	com/tencent/mapsdk/net/NetResponse:<init>	()V
    //   16: astore 9
    //   18: aload 7
    //   20: astore 5
    //   22: aload_0
    //   23: invokevirtual 27	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   26: astore 10
    //   28: ldc 29
    //   30: astore 8
    //   32: aload 8
    //   34: astore 6
    //   36: aload 10
    //   38: ifnull +27 -> 65
    //   41: aload 7
    //   43: astore 5
    //   45: aload 10
    //   47: ldc 31
    //   49: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   52: astore 6
    //   54: aload 7
    //   56: astore 5
    //   58: aload 6
    //   60: arraylength
    //   61: istore_3
    //   62: goto +274 -> 336
    //   65: aload 7
    //   67: astore 5
    //   69: aload 9
    //   71: aload 6
    //   73: putfield 41	com/tencent/mapsdk/net/NetResponse:charset	Ljava/lang/String;
    //   76: iload_1
    //   77: ifeq +31 -> 108
    //   80: aload 7
    //   82: astore 5
    //   84: aload 10
    //   86: invokestatic 47	com/tencent/mapsdk/net/NetContext:isWAPFeePage	(Ljava/lang/String;)Z
    //   89: ifeq +19 -> 108
    //   92: aload 7
    //   94: astore 5
    //   96: aload_0
    //   97: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   100: aload 7
    //   102: astore 5
    //   104: aload_0
    //   105: invokevirtual 53	java/net/HttpURLConnection:connect	()V
    //   108: aload 7
    //   110: astore 5
    //   112: aload_0
    //   113: invokevirtual 57	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +114 -> 232
    //   121: aload_0
    //   122: astore 5
    //   124: aload 9
    //   126: iconst_0
    //   127: newarray byte
    //   129: putfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   132: iconst_0
    //   133: istore_2
    //   134: aload_0
    //   135: astore 5
    //   137: sipush 1024
    //   140: newarray byte
    //   142: astore 6
    //   144: aload_0
    //   145: astore 5
    //   147: aload_0
    //   148: aload 6
    //   150: invokevirtual 67	java/io/InputStream:read	([B)I
    //   153: istore 4
    //   155: iload_2
    //   156: istore_3
    //   157: iload 4
    //   159: ifle +66 -> 225
    //   162: iload_2
    //   163: iload 4
    //   165: iadd
    //   166: istore_3
    //   167: aload_0
    //   168: astore 5
    //   170: iload_3
    //   171: newarray byte
    //   173: astore 7
    //   175: aload_0
    //   176: astore 5
    //   178: aload 9
    //   180: getfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   183: iconst_0
    //   184: aload 7
    //   186: iconst_0
    //   187: aload 9
    //   189: getfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   192: arraylength
    //   193: invokestatic 73	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   196: aload_0
    //   197: astore 5
    //   199: aload 6
    //   201: iconst_0
    //   202: aload 7
    //   204: aload 9
    //   206: getfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   209: arraylength
    //   210: iload 4
    //   212: invokestatic 73	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   215: aload_0
    //   216: astore 5
    //   218: aload 9
    //   220: aload 7
    //   222: putfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   225: iload_3
    //   226: istore_2
    //   227: iload 4
    //   229: ifgt -85 -> 144
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 76	java/io/InputStream:close	()V
    //   240: aload 9
    //   242: areturn
    //   243: aload 6
    //   245: iload_2
    //   246: aaload
    //   247: astore 11
    //   249: aload 7
    //   251: astore 5
    //   253: aload 11
    //   255: ldc 77
    //   257: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   260: ifeq +47 -> 307
    //   263: aload 7
    //   265: astore 5
    //   267: aload 11
    //   269: ldc 83
    //   271: invokevirtual 37	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   274: astore 11
    //   276: aload 8
    //   278: astore 6
    //   280: aload 7
    //   282: astore 5
    //   284: aload 11
    //   286: arraylength
    //   287: iconst_1
    //   288: if_icmple -223 -> 65
    //   291: aload 7
    //   293: astore 5
    //   295: aload 11
    //   297: iconst_1
    //   298: aaload
    //   299: invokevirtual 86	java/lang/String:trim	()Ljava/lang/String;
    //   302: astore 6
    //   304: goto -239 -> 65
    //   307: iload_2
    //   308: iconst_1
    //   309: iadd
    //   310: istore_2
    //   311: goto +25 -> 336
    //   314: astore_0
    //   315: aload 5
    //   317: ifnull +8 -> 325
    //   320: aload 5
    //   322: invokevirtual 76	java/io/InputStream:close	()V
    //   325: aload_0
    //   326: athrow
    //   327: astore_0
    //   328: aload 9
    //   330: areturn
    //   331: astore 5
    //   333: goto -8 -> 325
    //   336: iload_2
    //   337: iload_3
    //   338: if_icmplt -95 -> 243
    //   341: aload 8
    //   343: astore 6
    //   345: goto -280 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramHttpURLConnection	HttpURLConnection
    //   0	348	1	paramBoolean	boolean
    //   1	338	2	i	int
    //   61	278	3	j	int
    //   153	75	4	k	int
    //   7	314	5	localObject1	Object
    //   331	1	5	localIOException	IOException
    //   34	310	6	localObject2	Object
    //   3	289	7	arrayOfByte	byte[]
    //   30	312	8	str1	String
    //   16	313	9	localNetResponse	com.tencent.mapsdk.net.NetResponse
    //   26	59	10	str2	String
    //   247	49	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   9	18	314	finally
    //   22	28	314	finally
    //   45	54	314	finally
    //   58	62	314	finally
    //   69	76	314	finally
    //   84	92	314	finally
    //   96	100	314	finally
    //   104	108	314	finally
    //   112	117	314	finally
    //   124	132	314	finally
    //   137	144	314	finally
    //   147	155	314	finally
    //   170	175	314	finally
    //   178	196	314	finally
    //   199	215	314	finally
    //   218	225	314	finally
    //   253	263	314	finally
    //   267	276	314	finally
    //   284	291	314	finally
    //   295	304	314	finally
    //   236	240	327	java/io/IOException
    //   320	325	331	java/io/IOException
  }
  
  /* Error */
  public static com.tencent.mapsdk.net.NetResponse a(boolean paramBoolean, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: invokestatic 96	com/tencent/mapsdk/net/NetContext:isNetAvailable	()Z
    //   9: ifne +11 -> 20
    //   12: new 98	com/tencent/tencentmap/mapsdk/a/c
    //   15: dup
    //   16: invokespecial 99	com/tencent/tencentmap/mapsdk/a/c:<init>	()V
    //   19: athrow
    //   20: aconst_null
    //   21: astore 7
    //   23: aconst_null
    //   24: astore 10
    //   26: aconst_null
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 11
    //   32: aload 11
    //   34: astore 8
    //   36: aload_1
    //   37: iconst_1
    //   38: invokestatic 102	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   41: astore_1
    //   42: aload_1
    //   43: astore 9
    //   45: aload_1
    //   46: astore 7
    //   48: aload 11
    //   50: astore 8
    //   52: aload_1
    //   53: astore 10
    //   55: aconst_null
    //   56: invokestatic 106	com/tencent/tencentmap/mapsdk/a/d:a	(Ljava/lang/String;)Z
    //   59: ifeq +434 -> 493
    //   62: aload_1
    //   63: astore 9
    //   65: aload_1
    //   66: astore 7
    //   68: aload 11
    //   70: astore 8
    //   72: aload_1
    //   73: astore 10
    //   75: aload_1
    //   76: invokevirtual 110	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   79: invokevirtual 115	java/net/URL:getHost	()Ljava/lang/String;
    //   82: invokestatic 106	com/tencent/tencentmap/mapsdk/a/d:a	(Ljava/lang/String;)Z
    //   85: ifeq +3 -> 88
    //   88: iload_0
    //   89: ifeq +475 -> 564
    //   92: aload_1
    //   93: astore 9
    //   95: aload_1
    //   96: astore 7
    //   98: aload 11
    //   100: astore 8
    //   102: aload_1
    //   103: astore 10
    //   105: aload_1
    //   106: ldc 117
    //   108: invokevirtual 121	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   111: aload_1
    //   112: astore 9
    //   114: aload_1
    //   115: astore 7
    //   117: aload 11
    //   119: astore 8
    //   121: aload_1
    //   122: astore 10
    //   124: aload_1
    //   125: invokestatic 126	com/tencent/mapsdk/net/a:a	()I
    //   128: invokevirtual 130	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   131: aload_1
    //   132: astore 9
    //   134: aload_1
    //   135: astore 7
    //   137: aload 11
    //   139: astore 8
    //   141: aload_1
    //   142: astore 10
    //   144: aload_1
    //   145: invokestatic 132	com/tencent/mapsdk/net/a:b	()I
    //   148: invokevirtual 135	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   151: aload_1
    //   152: astore 9
    //   154: aload_1
    //   155: astore 7
    //   157: aload 11
    //   159: astore 8
    //   161: aload_1
    //   162: astore 10
    //   164: aload_1
    //   165: ldc 137
    //   167: aload_2
    //   168: invokevirtual 141	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: astore 9
    //   174: aload_1
    //   175: astore 7
    //   177: aload 11
    //   179: astore 8
    //   181: aload_1
    //   182: astore 10
    //   184: aload_1
    //   185: iconst_1
    //   186: invokevirtual 145	java/net/HttpURLConnection:setDoInput	(Z)V
    //   189: iload_0
    //   190: ifeq +6 -> 196
    //   193: iconst_0
    //   194: istore 6
    //   196: aload_1
    //   197: astore 9
    //   199: aload_1
    //   200: astore 7
    //   202: aload 11
    //   204: astore 8
    //   206: aload_1
    //   207: astore 10
    //   209: aload_1
    //   210: iload 6
    //   212: invokevirtual 148	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   215: aload_1
    //   216: astore 9
    //   218: aload_1
    //   219: astore 7
    //   221: aload 11
    //   223: astore 8
    //   225: aload_1
    //   226: astore 10
    //   228: aload_1
    //   229: iconst_0
    //   230: invokevirtual 151	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   233: aload_1
    //   234: astore 9
    //   236: aload_1
    //   237: astore 7
    //   239: aload 11
    //   241: astore 8
    //   243: aload_1
    //   244: astore 10
    //   246: aload_1
    //   247: invokestatic 154	com/tencent/mapsdk/net/a:a	(Ljava/net/HttpURLConnection;)V
    //   250: aload_1
    //   251: astore 9
    //   253: aload_1
    //   254: astore 7
    //   256: aload 11
    //   258: astore 8
    //   260: aload_1
    //   261: astore 10
    //   263: aload_1
    //   264: invokevirtual 53	java/net/HttpURLConnection:connect	()V
    //   267: aload_1
    //   268: astore 9
    //   270: aload_1
    //   271: astore 7
    //   273: aload 11
    //   275: astore 8
    //   277: aload_1
    //   278: astore 10
    //   280: invokestatic 157	com/tencent/mapsdk/net/a:c	()V
    //   283: iload_0
    //   284: ifne +63 -> 347
    //   287: aload_3
    //   288: ifnull +59 -> 347
    //   291: aload_1
    //   292: astore 9
    //   294: aload_1
    //   295: astore 7
    //   297: aload 11
    //   299: astore 8
    //   301: aload_1
    //   302: astore 10
    //   304: aload_3
    //   305: arraylength
    //   306: ifeq +41 -> 347
    //   309: aload_1
    //   310: astore 9
    //   312: aload_1
    //   313: astore 7
    //   315: aload 11
    //   317: astore 8
    //   319: aload_1
    //   320: astore 10
    //   322: new 159	java/io/DataOutputStream
    //   325: dup
    //   326: aload_1
    //   327: invokevirtual 163	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   330: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   333: astore_2
    //   334: aload_2
    //   335: aload_3
    //   336: invokevirtual 170	java/io/DataOutputStream:write	([B)V
    //   339: aload_2
    //   340: invokevirtual 173	java/io/DataOutputStream:flush	()V
    //   343: aload_2
    //   344: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   347: aconst_null
    //   348: astore_2
    //   349: aload_1
    //   350: astore 9
    //   352: aload_1
    //   353: astore 7
    //   355: aload_2
    //   356: astore 8
    //   358: aload_1
    //   359: astore 10
    //   361: aload_1
    //   362: invokevirtual 177	java/net/HttpURLConnection:getResponseCode	()I
    //   365: istore 4
    //   367: iload 4
    //   369: sipush 200
    //   372: if_icmpeq +11 -> 383
    //   375: iload 4
    //   377: sipush 206
    //   380: if_icmpne +230 -> 610
    //   383: aload_1
    //   384: astore 9
    //   386: aload_1
    //   387: astore 7
    //   389: aload_2
    //   390: astore 8
    //   392: aload_1
    //   393: astore 10
    //   395: invokestatic 180	com/tencent/mapsdk/net/a:d	()V
    //   398: aload_1
    //   399: astore 9
    //   401: aload_1
    //   402: astore 7
    //   404: aload_2
    //   405: astore 8
    //   407: aload_1
    //   408: astore 10
    //   410: aload_1
    //   411: iload_0
    //   412: invokestatic 182	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/net/HttpURLConnection;Z)Lcom/tencent/mapsdk/net/NetResponse;
    //   415: astore_3
    //   416: iload 5
    //   418: istore 4
    //   420: aload_3
    //   421: ifnull +45 -> 466
    //   424: iload 5
    //   426: istore 4
    //   428: aload_1
    //   429: astore 9
    //   431: aload_1
    //   432: astore 7
    //   434: aload_2
    //   435: astore 8
    //   437: aload_1
    //   438: astore 10
    //   440: aload_3
    //   441: getfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   444: ifnull +22 -> 466
    //   447: aload_1
    //   448: astore 9
    //   450: aload_1
    //   451: astore 7
    //   453: aload_2
    //   454: astore 8
    //   456: aload_1
    //   457: astore 10
    //   459: aload_3
    //   460: getfield 61	com/tencent/mapsdk/net/NetResponse:data	[B
    //   463: arraylength
    //   464: istore 4
    //   466: aload_1
    //   467: astore 9
    //   469: aload_1
    //   470: astore 7
    //   472: aload_2
    //   473: astore 8
    //   475: aload_1
    //   476: astore 10
    //   478: iload 4
    //   480: invokestatic 184	com/tencent/mapsdk/net/a:a	(I)V
    //   483: aload_1
    //   484: ifnull +7 -> 491
    //   487: aload_1
    //   488: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   491: aload_3
    //   492: areturn
    //   493: aload_1
    //   494: astore 9
    //   496: aload_1
    //   497: astore 7
    //   499: aload 11
    //   501: astore 8
    //   503: aload_1
    //   504: astore 10
    //   506: aload_1
    //   507: ldc 186
    //   509: aconst_null
    //   510: invokevirtual 141	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: goto -425 -> 88
    //   516: aconst_null
    //   517: astore_2
    //   518: astore_3
    //   519: aload 9
    //   521: astore_1
    //   522: aload_1
    //   523: astore 7
    //   525: aload_2
    //   526: astore 8
    //   528: iconst_1
    //   529: invokestatic 188	com/tencent/mapsdk/net/a:a	(Z)V
    //   532: aload_1
    //   533: astore 7
    //   535: aload_2
    //   536: astore 8
    //   538: aload_3
    //   539: athrow
    //   540: astore_2
    //   541: aload 7
    //   543: astore_1
    //   544: aload 8
    //   546: ifnull +8 -> 554
    //   549: aload 8
    //   551: invokevirtual 174	java/io/DataOutputStream:close	()V
    //   554: aload_1
    //   555: ifnull +7 -> 562
    //   558: aload_1
    //   559: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   562: aload_2
    //   563: athrow
    //   564: aload_1
    //   565: astore 9
    //   567: aload_1
    //   568: astore 7
    //   570: aload 11
    //   572: astore 8
    //   574: aload_1
    //   575: astore 10
    //   577: aload_1
    //   578: ldc 190
    //   580: invokevirtual 121	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   583: goto -472 -> 111
    //   586: aconst_null
    //   587: astore_2
    //   588: astore_3
    //   589: aload 10
    //   591: astore_1
    //   592: aload_1
    //   593: astore 7
    //   595: aload_2
    //   596: astore 8
    //   598: iconst_0
    //   599: invokestatic 188	com/tencent/mapsdk/net/a:a	(Z)V
    //   602: aload_1
    //   603: astore 7
    //   605: aload_2
    //   606: astore 8
    //   608: aload_3
    //   609: athrow
    //   610: iload 4
    //   612: sipush 202
    //   615: if_icmpeq +75 -> 690
    //   618: iload 4
    //   620: sipush 201
    //   623: if_icmpeq +67 -> 690
    //   626: iload 4
    //   628: sipush 204
    //   631: if_icmpeq +59 -> 690
    //   634: iload 4
    //   636: sipush 205
    //   639: if_icmpeq +51 -> 690
    //   642: iload 4
    //   644: sipush 304
    //   647: if_icmpeq +43 -> 690
    //   650: iload 4
    //   652: sipush 305
    //   655: if_icmpeq +35 -> 690
    //   658: iload 4
    //   660: sipush 408
    //   663: if_icmpeq +27 -> 690
    //   666: iload 4
    //   668: sipush 502
    //   671: if_icmpeq +19 -> 690
    //   674: iload 4
    //   676: sipush 504
    //   679: if_icmpeq +11 -> 690
    //   682: iload 4
    //   684: sipush 503
    //   687: if_icmpne +25 -> 712
    //   690: aload_1
    //   691: astore 9
    //   693: aload_1
    //   694: astore 7
    //   696: aload_2
    //   697: astore 8
    //   699: aload_1
    //   700: astore 10
    //   702: new 16	java/io/IOException
    //   705: dup
    //   706: ldc 192
    //   708: invokespecial 194	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   711: athrow
    //   712: aload_1
    //   713: astore 9
    //   715: aload_1
    //   716: astore 7
    //   718: aload_2
    //   719: astore 8
    //   721: aload_1
    //   722: astore 10
    //   724: new 92	com/tencent/tencentmap/mapsdk/a/a
    //   727: dup
    //   728: new 196	java/lang/StringBuilder
    //   731: dup
    //   732: ldc 198
    //   734: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   737: iload 4
    //   739: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokespecial 207	com/tencent/tencentmap/mapsdk/a/a:<init>	(Ljava/lang/String;)V
    //   748: athrow
    //   749: astore_3
    //   750: aload_2
    //   751: astore 8
    //   753: aload_3
    //   754: astore_2
    //   755: goto -211 -> 544
    //   758: astore_3
    //   759: goto -167 -> 592
    //   762: astore_3
    //   763: goto -241 -> 522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	paramBoolean	boolean
    //   0	766	1	paramString1	String
    //   0	766	2	paramString2	String
    //   0	766	3	paramArrayOfByte	byte[]
    //   365	373	4	i	int
    //   4	421	5	j	int
    //   1	210	6	bool	boolean
    //   21	696	7	str1	String
    //   34	718	8	localObject1	Object
    //   27	687	9	str2	String
    //   24	699	10	str3	String
    //   30	541	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	516	com/tencent/tencentmap/mapsdk/a/a
    //   55	62	516	com/tencent/tencentmap/mapsdk/a/a
    //   75	88	516	com/tencent/tencentmap/mapsdk/a/a
    //   105	111	516	com/tencent/tencentmap/mapsdk/a/a
    //   124	131	516	com/tencent/tencentmap/mapsdk/a/a
    //   144	151	516	com/tencent/tencentmap/mapsdk/a/a
    //   164	171	516	com/tencent/tencentmap/mapsdk/a/a
    //   184	189	516	com/tencent/tencentmap/mapsdk/a/a
    //   209	215	516	com/tencent/tencentmap/mapsdk/a/a
    //   228	233	516	com/tencent/tencentmap/mapsdk/a/a
    //   246	250	516	com/tencent/tencentmap/mapsdk/a/a
    //   263	267	516	com/tencent/tencentmap/mapsdk/a/a
    //   280	283	516	com/tencent/tencentmap/mapsdk/a/a
    //   304	309	516	com/tencent/tencentmap/mapsdk/a/a
    //   322	334	516	com/tencent/tencentmap/mapsdk/a/a
    //   361	367	516	com/tencent/tencentmap/mapsdk/a/a
    //   395	398	516	com/tencent/tencentmap/mapsdk/a/a
    //   410	416	516	com/tencent/tencentmap/mapsdk/a/a
    //   440	447	516	com/tencent/tencentmap/mapsdk/a/a
    //   459	466	516	com/tencent/tencentmap/mapsdk/a/a
    //   478	483	516	com/tencent/tencentmap/mapsdk/a/a
    //   506	513	516	com/tencent/tencentmap/mapsdk/a/a
    //   577	583	516	com/tencent/tencentmap/mapsdk/a/a
    //   702	712	516	com/tencent/tencentmap/mapsdk/a/a
    //   724	749	516	com/tencent/tencentmap/mapsdk/a/a
    //   36	42	540	finally
    //   55	62	540	finally
    //   75	88	540	finally
    //   105	111	540	finally
    //   124	131	540	finally
    //   144	151	540	finally
    //   164	171	540	finally
    //   184	189	540	finally
    //   209	215	540	finally
    //   228	233	540	finally
    //   246	250	540	finally
    //   263	267	540	finally
    //   280	283	540	finally
    //   304	309	540	finally
    //   322	334	540	finally
    //   361	367	540	finally
    //   395	398	540	finally
    //   410	416	540	finally
    //   440	447	540	finally
    //   459	466	540	finally
    //   478	483	540	finally
    //   506	513	540	finally
    //   528	532	540	finally
    //   538	540	540	finally
    //   577	583	540	finally
    //   598	602	540	finally
    //   608	610	540	finally
    //   702	712	540	finally
    //   724	749	540	finally
    //   36	42	586	java/lang/Exception
    //   55	62	586	java/lang/Exception
    //   75	88	586	java/lang/Exception
    //   105	111	586	java/lang/Exception
    //   124	131	586	java/lang/Exception
    //   144	151	586	java/lang/Exception
    //   164	171	586	java/lang/Exception
    //   184	189	586	java/lang/Exception
    //   209	215	586	java/lang/Exception
    //   228	233	586	java/lang/Exception
    //   246	250	586	java/lang/Exception
    //   263	267	586	java/lang/Exception
    //   280	283	586	java/lang/Exception
    //   304	309	586	java/lang/Exception
    //   322	334	586	java/lang/Exception
    //   361	367	586	java/lang/Exception
    //   395	398	586	java/lang/Exception
    //   410	416	586	java/lang/Exception
    //   440	447	586	java/lang/Exception
    //   459	466	586	java/lang/Exception
    //   478	483	586	java/lang/Exception
    //   506	513	586	java/lang/Exception
    //   577	583	586	java/lang/Exception
    //   702	712	586	java/lang/Exception
    //   724	749	586	java/lang/Exception
    //   334	347	749	finally
    //   334	347	758	java/lang/Exception
    //   334	347	762	com/tencent/tencentmap/mapsdk/a/a
  }
  
  public static InputStream a(String paramString1, String paramString2)
    throws IllegalStateException, IOException
  {
    paramString1 = a(paramString1, false);
    paramString1.setRequestMethod("GET");
    paramString1.setConnectTimeout(15000);
    paramString1.setReadTimeout(45000);
    paramString1.setRequestProperty("User-Agent", paramString2);
    if (!d.a(null)) {
      paramString1.setRequestProperty("Host", null);
    }
    paramString1.setDoInput(true);
    paramString1.setDoOutput(false);
    paramString1.setUseCaches(false);
    paramString1.connect();
    int i = paramString1.getResponseCode();
    if ((i != 200) && (i != 206))
    {
      paramString1.disconnect();
      throw new IOException("net error");
    }
    if (NetContext.isWAPFeePage(paramString1.getContentType()))
    {
      paramString1.disconnect();
      paramString1.connect();
    }
    return paramString1.getInputStream();
  }
  
  /* Error */
  public static HttpURLConnection a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 112	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 216	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore 6
    //   13: iload_1
    //   14: invokestatic 220	com/tencent/mapsdk/net/NetContext:isPorxyPrefer	(Z)Z
    //   17: ifne +28 -> 45
    //   20: aload 6
    //   22: invokevirtual 224	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 23	java/net/HttpURLConnection
    //   28: astore_0
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 227	java/net/MalformedURLException:printStackTrace	()V
    //   36: aconst_null
    //   37: areturn
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 228	java/io/IOException:printStackTrace	()V
    //   43: aconst_null
    //   44: areturn
    //   45: getstatic 12	com/tencent/tencentmap/mapsdk/a/b:a	I
    //   48: ifne +160 -> 208
    //   51: getstatic 230	com/tencent/tencentmap/mapsdk/a/b:b	Z
    //   54: ifne +154 -> 208
    //   57: iconst_1
    //   58: putstatic 230	com/tencent/tencentmap/mapsdk/a/b:b	Z
    //   61: new 112	java/net/URL
    //   64: dup
    //   65: ldc 232
    //   67: invokespecial 216	java/net/URL:<init>	(Ljava/lang/String;)V
    //   70: astore 4
    //   72: invokestatic 237	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   75: astore 7
    //   77: invokestatic 240	android/net/Proxy:getDefaultPort	()I
    //   80: istore_3
    //   81: iload_3
    //   82: istore_2
    //   83: iload_3
    //   84: iconst_m1
    //   85: if_icmpne +6 -> 91
    //   88: bipush 80
    //   90: istore_2
    //   91: new 242	java/net/InetSocketAddress
    //   94: dup
    //   95: aload 7
    //   97: iload_2
    //   98: invokespecial 245	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   101: astore 7
    //   103: new 247	java/net/Proxy
    //   106: dup
    //   107: getstatic 253	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   110: aload 7
    //   112: invokespecial 256	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   115: astore 7
    //   117: aload 4
    //   119: aload 7
    //   121: invokevirtual 259	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   124: checkcast 23	java/net/HttpURLConnection
    //   127: astore 4
    //   129: aload 4
    //   131: ldc 117
    //   133: invokevirtual 121	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   136: aload 4
    //   138: sipush 15000
    //   141: invokevirtual 130	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   144: aload 4
    //   146: ldc 211
    //   148: invokevirtual 135	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   151: aload 4
    //   153: ldc 137
    //   155: ldc_w 261
    //   158: invokevirtual 141	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 4
    //   163: iconst_1
    //   164: invokevirtual 145	java/net/HttpURLConnection:setDoInput	(Z)V
    //   167: aload 4
    //   169: iconst_0
    //   170: invokevirtual 148	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   173: aload 4
    //   175: iconst_0
    //   176: invokevirtual 151	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   179: aload 4
    //   181: invokestatic 264	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/net/HttpURLConnection;)Z
    //   184: istore_1
    //   185: aload 4
    //   187: invokevirtual 53	java/net/HttpURLConnection:connect	()V
    //   190: iload_1
    //   191: ifeq +96 -> 287
    //   194: iconst_1
    //   195: invokestatic 265	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   208: getstatic 12	com/tencent/tencentmap/mapsdk/a/b:a	I
    //   211: tableswitch	default:+156 -> 367, 2:+124->335
    //   229: nop
    //   230: <illegal opcode>
    //   231: astore_0
    //   232: invokestatic 240	android/net/Proxy:getDefaultPort	()I
    //   235: istore_3
    //   236: iload_3
    //   237: istore_2
    //   238: iload_3
    //   239: iconst_m1
    //   240: if_icmpne +6 -> 246
    //   243: bipush 80
    //   245: istore_2
    //   246: new 242	java/net/InetSocketAddress
    //   249: dup
    //   250: aload_0
    //   251: iload_2
    //   252: invokespecial 245	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   255: astore_0
    //   256: aload 6
    //   258: new 247	java/net/Proxy
    //   261: dup
    //   262: getstatic 253	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   265: aload_0
    //   266: invokespecial 256	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   269: invokevirtual 259	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   272: checkcast 23	java/net/HttpURLConnection
    //   275: astore_0
    //   276: aload_0
    //   277: areturn
    //   278: astore 4
    //   280: iconst_0
    //   281: putstatic 230	com/tencent/tencentmap/mapsdk/a/b:b	Z
    //   284: goto -76 -> 208
    //   287: iconst_2
    //   288: invokestatic 265	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   291: goto -93 -> 198
    //   294: astore 5
    //   296: aload 5
    //   298: invokevirtual 266	java/lang/Exception:printStackTrace	()V
    //   301: iconst_2
    //   302: invokestatic 265	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   305: aload 4
    //   307: ifnull -99 -> 208
    //   310: aload 4
    //   312: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   315: goto -107 -> 208
    //   318: astore_0
    //   319: aload 5
    //   321: astore 4
    //   323: aload 4
    //   325: ifnull +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 50	java/net/HttpURLConnection:disconnect	()V
    //   333: aload_0
    //   334: athrow
    //   335: aload 6
    //   337: aload_0
    //   338: invokestatic 269	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   341: astore_0
    //   342: aload_0
    //   343: areturn
    //   344: astore_0
    //   345: aload_0
    //   346: invokevirtual 228	java/io/IOException:printStackTrace	()V
    //   349: aconst_null
    //   350: areturn
    //   351: astore_0
    //   352: goto -29 -> 323
    //   355: astore_0
    //   356: goto -33 -> 323
    //   359: astore 5
    //   361: aconst_null
    //   362: astore 4
    //   364: goto -68 -> 296
    //   367: goto -139 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString	String
    //   0	370	1	paramBoolean	boolean
    //   82	170	2	i	int
    //   80	161	3	j	int
    //   70	134	4	localObject1	Object
    //   278	33	4	localMalformedURLException	MalformedURLException
    //   321	42	4	localException1	java.lang.Exception
    //   1	1	5	localObject2	Object
    //   294	26	5	localException2	java.lang.Exception
    //   359	1	5	localException3	java.lang.Exception
    //   11	325	6	localURL	URL
    //   75	45	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	31	java/net/MalformedURLException
    //   20	29	38	java/io/IOException
    //   61	72	278	java/net/MalformedURLException
    //   129	190	294	java/lang/Exception
    //   194	198	294	java/lang/Exception
    //   287	291	294	java/lang/Exception
    //   117	129	318	finally
    //   208	228	344	java/io/IOException
    //   228	236	344	java/io/IOException
    //   246	276	344	java/io/IOException
    //   335	342	344	java/io/IOException
    //   129	190	351	finally
    //   194	198	351	finally
    //   287	291	351	finally
    //   296	305	355	finally
    //   117	129	359	java/lang/Exception
  }
  
  private static HttpURLConnection a(URL paramURL, String paramString)
    throws IOException
  {
    String str2 = Proxy.getDefaultHost();
    int j = Proxy.getDefaultPort();
    int i = j;
    if (j == -1) {
      i = 80;
    }
    String str1 = paramURL.getHost();
    int k = paramURL.getPort();
    j = k;
    if (k == -1) {
      j = 80;
    }
    if (paramString.indexOf(str1 + ":" + j) != -1) {}
    for (paramURL = paramString.replaceFirst(str1 + ":" + j, str2 + ":" + i);; paramURL = paramString.replaceFirst(str1, str2 + ":" + i)) {
      try
      {
        paramURL = new URL(paramURL);
        paramURL = (HttpURLConnection)paramURL.openConnection();
        paramURL.setRequestProperty("X-Online-Host", str1 + ":" + j);
        return paramURL;
      }
      catch (MalformedURLException paramURL) {}
    }
    return null;
  }
  
  private static void a(int paramInt)
  {
    if (a == paramInt) {
      return;
    }
    a = paramInt;
  }
  
  /* Error */
  private static boolean a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 57	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6: astore 4
    //   8: aload 4
    //   10: astore_3
    //   11: aload_0
    //   12: invokevirtual 27	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   15: ldc_w 293
    //   18: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +17 -> 40
    //   26: aload 4
    //   28: ifnull +8 -> 36
    //   31: aload 4
    //   33: invokevirtual 76	java/io/InputStream:close	()V
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: ireturn
    //   40: aload 4
    //   42: astore_3
    //   43: new 299	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: invokespecial 300	java/io/ByteArrayOutputStream:<init>	()V
    //   50: astore_0
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: invokevirtual 303	java/io/InputStream:available	()I
    //   59: ifgt +41 -> 100
    //   62: aload 4
    //   64: astore_3
    //   65: new 33	java/lang/String
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: invokespecial 309	java/lang/String:<init>	([B)V
    //   76: invokevirtual 86	java/lang/String:trim	()Ljava/lang/String;
    //   79: ldc_w 311
    //   82: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: istore_2
    //   86: iload_2
    //   87: istore_1
    //   88: aload 4
    //   90: ifnull -52 -> 38
    //   93: aload 4
    //   95: invokevirtual 76	java/io/InputStream:close	()V
    //   98: iload_2
    //   99: ireturn
    //   100: aload 4
    //   102: astore_3
    //   103: aload_0
    //   104: aload 4
    //   106: invokevirtual 313	java/io/InputStream:read	()I
    //   109: invokevirtual 315	java/io/ByteArrayOutputStream:write	(I)V
    //   112: goto -61 -> 51
    //   115: astore_0
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 76	java/io/InputStream:close	()V
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramHttpURLConnection	HttpURLConnection
    //   21	67	1	bool1	boolean
    //   85	14	2	bool2	boolean
    //   1	120	3	localObject	Object
    //   6	99	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   2	8	115	finally
    //   11	22	115	finally
    //   43	51	115	finally
    //   54	62	115	finally
    //   65	86	115	finally
    //   103	112	115	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.b
 * JD-Core Version:    0.7.0.1
 */