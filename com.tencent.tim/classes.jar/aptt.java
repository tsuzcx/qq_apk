public class aptt
{
  /* Error */
  public static apaz.a a(android.os.Bundle paramBundle, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: invokestatic 16	java/lang/System:currentTimeMillis	()J
    //   9: lstore 6
    //   11: aload_0
    //   12: ldc 18
    //   14: invokevirtual 24	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 9
    //   19: aload_0
    //   20: ldc 26
    //   22: invokevirtual 24	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 10
    //   27: aload_0
    //   28: ldc 28
    //   30: invokevirtual 24	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_0
    //   34: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +52 -> 89
    //   40: ldc 36
    //   42: iconst_2
    //   43: new 38	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   50: ldc 44
    //   52: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 9
    //   57: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 50
    //   62: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 10
    //   67: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 52
    //   72: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload 10
    //   77: invokestatic 58	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   80: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload 10
    //   91: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 10
    //   99: invokestatic 79	aqhq:fileExists	(Ljava/lang/String;)Z
    //   102: ifne +39 -> 141
    //   105: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +29 -> 137
    //   111: ldc 36
    //   113: iconst_2
    //   114: new 38	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   121: ldc 81
    //   123: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 10
    //   128: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 84	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: areturn
    //   141: new 86	org/apache/http/client/methods/HttpPost
    //   144: dup
    //   145: ldc 88
    //   147: invokespecial 91	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   150: astore 11
    //   152: aload 11
    //   154: ldc 93
    //   156: ldc 95
    //   158: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 11
    //   163: ldc 101
    //   165: ldc 103
    //   167: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 11
    //   172: ldc 105
    //   174: ldc 107
    //   176: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 11
    //   181: ldc 109
    //   183: ldc 111
    //   185: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 11
    //   190: ldc 113
    //   192: ldc 115
    //   194: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: aload 11
    //   199: ldc 117
    //   201: new 38	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   208: ldc 119
    //   210: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 121
    //   219: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 99	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: new 123	java/util/ArrayList
    //   235: dup
    //   236: invokespecial 124	java/util/ArrayList:<init>	()V
    //   239: astore_1
    //   240: aload_1
    //   241: new 126	org/apache/http/message/BasicNameValuePair
    //   244: dup
    //   245: ldc 18
    //   247: aload 9
    //   249: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: invokeinterface 134 2 0
    //   257: pop
    //   258: aload_1
    //   259: new 126	org/apache/http/message/BasicNameValuePair
    //   262: dup
    //   263: ldc 136
    //   265: aload 10
    //   267: invokestatic 58	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   270: invokestatic 142	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   273: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: invokeinterface 134 2 0
    //   281: pop
    //   282: aload_1
    //   283: new 126	org/apache/http/message/BasicNameValuePair
    //   286: dup
    //   287: ldc 144
    //   289: aload 10
    //   291: invokestatic 150	ahav:x	(Ljava/lang/String;)[B
    //   294: invokestatic 156	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   297: invokevirtual 159	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   300: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: invokeinterface 134 2 0
    //   308: pop
    //   309: aload_1
    //   310: new 126	org/apache/http/message/BasicNameValuePair
    //   313: dup
    //   314: ldc 161
    //   316: aload 10
    //   318: invokestatic 164	ahav:t	(Ljava/lang/String;)[B
    //   321: invokestatic 156	aqhs:bytes2HexStr	([B)Ljava/lang/String;
    //   324: invokevirtual 159	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   327: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: invokeinterface 134 2 0
    //   335: pop
    //   336: aload_1
    //   337: new 126	org/apache/http/message/BasicNameValuePair
    //   340: dup
    //   341: ldc 166
    //   343: new 38	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   350: ldc 168
    //   352: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokestatic 174	apuh:eU	(Ljava/lang/String;)I
    //   359: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: invokeinterface 134 2 0
    //   373: pop
    //   374: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +33 -> 410
    //   380: ldc 36
    //   382: iconst_2
    //   383: new 38	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   390: ldc 179
    //   392: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokestatic 16	java/lang/System:currentTimeMillis	()J
    //   398: lload 6
    //   400: lsub
    //   401: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: aload_1
    //   411: new 126	org/apache/http/message/BasicNameValuePair
    //   414: dup
    //   415: ldc 181
    //   417: ldc 183
    //   419: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: invokeinterface 134 2 0
    //   427: pop
    //   428: aload_0
    //   429: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +20 -> 452
    //   435: aload_1
    //   436: new 126	org/apache/http/message/BasicNameValuePair
    //   439: dup
    //   440: ldc 28
    //   442: aload_0
    //   443: invokespecial 128	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: invokeinterface 134 2 0
    //   451: pop
    //   452: aload 11
    //   454: new 185	org/apache/http/client/entity/UrlEncodedFormEntity
    //   457: dup
    //   458: aload_1
    //   459: ldc 187
    //   461: invokespecial 190	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   464: invokevirtual 194	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   467: new 196	org/apache/http/impl/client/DefaultHttpClient
    //   470: dup
    //   471: invokespecial 197	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   474: aload 11
    //   476: invokevirtual 201	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   479: astore_0
    //   480: aload_0
    //   481: invokeinterface 207 1 0
    //   486: invokeinterface 213 1 0
    //   491: sipush 200
    //   494: if_icmpne +320 -> 814
    //   497: aload_0
    //   498: ldc 215
    //   500: invokeinterface 219 2 0
    //   505: astore_1
    //   506: aload_1
    //   507: arraylength
    //   508: istore 5
    //   510: iconst_0
    //   511: istore_3
    //   512: iload_3
    //   513: iload 5
    //   515: if_icmpge +25 -> 540
    //   518: aload_1
    //   519: iload_3
    //   520: aaload
    //   521: invokeinterface 224 1 0
    //   526: ldc 226
    //   528: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   531: ifeq +290 -> 821
    //   534: iconst_1
    //   535: istore 4
    //   537: goto +284 -> 821
    //   540: aload_0
    //   541: invokeinterface 233 1 0
    //   546: astore_0
    //   547: iload 4
    //   549: ifeq +171 -> 720
    //   552: new 235	java/util/zip/GZIPInputStream
    //   555: dup
    //   556: aload_0
    //   557: invokeinterface 241 1 0
    //   562: invokespecial 244	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   565: astore_0
    //   566: aload_0
    //   567: astore_1
    //   568: aload_0
    //   569: astore_2
    //   570: aload_0
    //   571: invokestatic 250	com/tencent/open/base/http/HttpBaseUtil:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   574: astore 8
    //   576: aload_0
    //   577: astore_1
    //   578: aload_0
    //   579: astore_2
    //   580: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +33 -> 616
    //   586: aload_0
    //   587: astore_1
    //   588: aload_0
    //   589: astore_2
    //   590: ldc 36
    //   592: iconst_2
    //   593: new 38	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   600: ldc 252
    //   602: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 8
    //   607: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload_0
    //   617: astore_1
    //   618: aload_0
    //   619: astore_2
    //   620: new 254	org/json/JSONObject
    //   623: dup
    //   624: aload 8
    //   626: invokespecial 255	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   629: astore 8
    //   631: aload_0
    //   632: astore_1
    //   633: aload_0
    //   634: astore_2
    //   635: aload 8
    //   637: ldc_w 257
    //   640: iconst_m1
    //   641: invokevirtual 261	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   644: ifne +163 -> 807
    //   647: aload_0
    //   648: astore_1
    //   649: aload_0
    //   650: astore_2
    //   651: new 263	apaz$a
    //   654: dup
    //   655: aload 8
    //   657: invokespecial 266	apaz$a:<init>	(Lorg/json/JSONObject;)V
    //   660: astore 8
    //   662: aload_0
    //   663: astore_2
    //   664: aload 8
    //   666: astore_1
    //   667: aload_1
    //   668: astore_0
    //   669: aload_2
    //   670: ifnull +9 -> 679
    //   673: aload_2
    //   674: invokevirtual 269	java/util/zip/GZIPInputStream:close	()V
    //   677: aload_1
    //   678: astore_0
    //   679: aload_0
    //   680: astore_1
    //   681: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   684: ifeq -545 -> 139
    //   687: ldc 36
    //   689: iconst_2
    //   690: new 38	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 271
    //   700: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokestatic 16	java/lang/System:currentTimeMillis	()J
    //   706: lload 6
    //   708: lsub
    //   709: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   712: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: aload_0
    //   719: areturn
    //   720: aload_0
    //   721: invokestatic 276	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   724: astore_0
    //   725: aload_0
    //   726: astore 8
    //   728: aconst_null
    //   729: astore_0
    //   730: goto -154 -> 576
    //   733: astore_0
    //   734: aconst_null
    //   735: astore_2
    //   736: aload_2
    //   737: astore_1
    //   738: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq +15 -> 756
    //   744: aload_2
    //   745: astore_1
    //   746: ldc 36
    //   748: iconst_2
    //   749: aload_0
    //   750: invokestatic 280	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   753: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aload_2
    //   757: ifnull +7 -> 764
    //   760: aload_2
    //   761: invokevirtual 269	java/util/zip/GZIPInputStream:close	()V
    //   764: aconst_null
    //   765: astore_0
    //   766: goto -87 -> 679
    //   769: astore_0
    //   770: aconst_null
    //   771: astore_0
    //   772: goto -93 -> 679
    //   775: astore_0
    //   776: aload 8
    //   778: astore_1
    //   779: aload_1
    //   780: ifnull +7 -> 787
    //   783: aload_1
    //   784: invokevirtual 269	java/util/zip/GZIPInputStream:close	()V
    //   787: aload_0
    //   788: athrow
    //   789: astore_0
    //   790: aload_1
    //   791: astore_0
    //   792: goto -113 -> 679
    //   795: astore_1
    //   796: goto -9 -> 787
    //   799: astore_0
    //   800: goto -21 -> 779
    //   803: astore_0
    //   804: goto -68 -> 736
    //   807: aconst_null
    //   808: astore_1
    //   809: aload_0
    //   810: astore_2
    //   811: goto -144 -> 667
    //   814: aconst_null
    //   815: astore_2
    //   816: aconst_null
    //   817: astore_1
    //   818: goto -151 -> 667
    //   821: iload_3
    //   822: iconst_1
    //   823: iadd
    //   824: istore_3
    //   825: goto -313 -> 512
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	paramBundle	android.os.Bundle
    //   0	828	1	paramString1	java.lang.String
    //   0	828	2	paramString2	java.lang.String
    //   511	314	3	i	int
    //   1	547	4	j	int
    //   508	8	5	k	int
    //   9	698	6	l	long
    //   4	773	8	localObject	Object
    //   17	231	9	str1	java.lang.String
    //   25	292	10	str2	java.lang.String
    //   150	325	11	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   452	510	733	java/lang/Exception
    //   518	534	733	java/lang/Exception
    //   540	547	733	java/lang/Exception
    //   552	566	733	java/lang/Exception
    //   720	725	733	java/lang/Exception
    //   760	764	769	java/io/IOException
    //   452	510	775	finally
    //   518	534	775	finally
    //   540	547	775	finally
    //   552	566	775	finally
    //   720	725	775	finally
    //   673	677	789	java/io/IOException
    //   783	787	795	java/io/IOException
    //   570	576	799	finally
    //   580	586	799	finally
    //   590	616	799	finally
    //   620	631	799	finally
    //   635	647	799	finally
    //   651	662	799	finally
    //   738	744	799	finally
    //   746	756	799	finally
    //   570	576	803	java/lang/Exception
    //   580	586	803	java/lang/Exception
    //   590	616	803	java/lang/Exception
    //   620	631	803	java/lang/Exception
    //   635	647	803	java/lang/Exception
    //   651	662	803	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptt
 * JD-Core Version:    0.7.0.1
 */