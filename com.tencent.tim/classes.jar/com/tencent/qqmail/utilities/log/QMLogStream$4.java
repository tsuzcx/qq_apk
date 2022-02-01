package com.tencent.qqmail.utilities.log;

final class QMLogStream$4
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 22	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   6: invokestatic 28	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isNetworkConnected	(Landroid/content/Context;)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: new 30	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 31	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: new 33	java/io/File
    //   25: dup
    //   26: invokestatic 39	com/tencent/qqmail/utilities/log/QMLogStream:access$700	()Ljava/lang/String;
    //   29: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 8
    //   34: aload 8
    //   36: invokevirtual 46	java/io/File:exists	()Z
    //   39: ifeq -27 -> 12
    //   42: new 48	java/io/BufferedReader
    //   45: dup
    //   46: new 50	java/io/FileReader
    //   49: dup
    //   50: aload 8
    //   52: invokespecial 53	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   55: invokespecial 56	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   58: astore 6
    //   60: iconst_m1
    //   61: istore_2
    //   62: iconst_0
    //   63: istore_1
    //   64: aload 6
    //   66: astore 5
    //   68: aload 6
    //   70: invokevirtual 59	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 9
    //   75: iload_1
    //   76: istore_3
    //   77: aload 9
    //   79: ifnull +61 -> 140
    //   82: aload 6
    //   84: astore 5
    //   86: aload 9
    //   88: invokevirtual 65	java/lang/String:length	()I
    //   91: ifle -27 -> 64
    //   94: aload 6
    //   96: astore 5
    //   98: aload 9
    //   100: invokestatic 68	com/tencent/qqmail/utilities/log/QMLogStream:access$800	()Ljava/lang/String;
    //   103: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +8 -> 114
    //   109: iload_1
    //   110: istore_2
    //   111: goto -47 -> 64
    //   114: aload 6
    //   116: astore 5
    //   118: aload 7
    //   120: aload 9
    //   122: invokeinterface 77 2 0
    //   127: pop
    //   128: iload_1
    //   129: iconst_1
    //   130: iadd
    //   131: istore_3
    //   132: iload_3
    //   133: istore_1
    //   134: iload_3
    //   135: bipush 100
    //   137: if_icmple -73 -> 64
    //   140: aload 6
    //   142: astore 5
    //   144: aload 6
    //   146: invokevirtual 80	java/io/BufferedReader:close	()V
    //   149: aload 6
    //   151: invokevirtual 80	java/io/BufferedReader:close	()V
    //   154: iload_3
    //   155: ifne +73 -> 228
    //   158: iconst_5
    //   159: ldc 82
    //   161: ldc 84
    //   163: invokestatic 90	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   166: return
    //   167: astore 7
    //   169: aconst_null
    //   170: astore 6
    //   172: aload 6
    //   174: astore 5
    //   176: bipush 6
    //   178: ldc 82
    //   180: new 92	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   187: ldc 95
    //   189: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 7
    //   194: invokevirtual 102	java/lang/Exception:toString	()Ljava/lang/String;
    //   197: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 90	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   206: aload 6
    //   208: invokevirtual 80	java/io/BufferedReader:close	()V
    //   211: return
    //   212: astore 5
    //   214: return
    //   215: astore 6
    //   217: aconst_null
    //   218: astore 5
    //   220: aload 5
    //   222: invokevirtual 80	java/io/BufferedReader:close	()V
    //   225: aload 6
    //   227: athrow
    //   228: invokestatic 22	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   231: invokevirtual 107	com/tencent/qqmail/QMApplicationContext:getVid	()J
    //   234: lconst_0
    //   235: lcmp
    //   236: ifeq +464 -> 700
    //   239: invokestatic 22	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   242: invokevirtual 110	com/tencent/qqmail/QMApplicationContext:getVidPwd	()Ljava/lang/String;
    //   245: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +452 -> 700
    //   251: invokestatic 22	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   254: invokevirtual 107	com/tencent/qqmail/QMApplicationContext:getVid	()J
    //   257: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   260: astore 5
    //   262: invokestatic 125	com/tencent/qqmail/protocol/CloudProtocolHelper:getDeviceId	()Ljava/lang/String;
    //   265: astore 6
    //   267: iconst_0
    //   268: istore_1
    //   269: iload_1
    //   270: aload 7
    //   272: invokeinterface 128 1 0
    //   277: if_icmpge +144 -> 421
    //   280: iload_1
    //   281: iload_2
    //   282: if_icmpge +73 -> 355
    //   285: aload 7
    //   287: iload_1
    //   288: new 92	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   295: ldc 130
    //   297: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 132
    //   307: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 6
    //   312: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 134
    //   317: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 7
    //   322: iload_1
    //   323: invokeinterface 138 2 0
    //   328: checkcast 61	java/lang/String
    //   331: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc 140
    //   336: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokeinterface 144 3 0
    //   347: pop
    //   348: iload_1
    //   349: iconst_1
    //   350: iadd
    //   351: istore_1
    //   352: goto -83 -> 269
    //   355: aload 7
    //   357: iload_1
    //   358: new 92	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   365: ldc 130
    //   367: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 5
    //   372: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc 132
    //   377: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 6
    //   382: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 134
    //   387: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 7
    //   392: iload_1
    //   393: invokeinterface 138 2 0
    //   398: checkcast 61	java/lang/String
    //   401: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 146
    //   406: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokeinterface 144 3 0
    //   417: pop
    //   418: goto -70 -> 348
    //   421: new 92	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   428: astore 5
    //   430: iconst_0
    //   431: istore_1
    //   432: iload_1
    //   433: aload 7
    //   435: invokeinterface 128 1 0
    //   440: if_icmpge +42 -> 482
    //   443: aload 5
    //   445: ldc 148
    //   447: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: iload_1
    //   453: invokeinterface 138 2 0
    //   458: checkcast 61	java/lang/String
    //   461: ldc 150
    //   463: invokestatic 156	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   466: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 134
    //   471: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: iload_1
    //   476: iconst_1
    //   477: iadd
    //   478: istore_1
    //   479: goto -47 -> 432
    //   482: iconst_0
    //   483: istore_1
    //   484: iload_1
    //   485: ifeq +212 -> 697
    //   488: new 92	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   495: astore 5
    //   497: iload 4
    //   499: istore_1
    //   500: iload_1
    //   501: aload 7
    //   503: invokeinterface 128 1 0
    //   508: if_icmpge +74 -> 582
    //   511: aload 5
    //   513: ldc 148
    //   515: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 7
    //   520: iload_1
    //   521: invokeinterface 138 2 0
    //   526: checkcast 61	java/lang/String
    //   529: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc 134
    //   534: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: iload_1
    //   539: iconst_1
    //   540: iadd
    //   541: istore_1
    //   542: goto -42 -> 500
    //   545: astore 6
    //   547: bipush 6
    //   549: ldc 82
    //   551: new 92	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   558: ldc 158
    //   560: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 6
    //   565: invokevirtual 159	java/io/UnsupportedEncodingException:toString	()Ljava/lang/String;
    //   568: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 90	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   577: iconst_1
    //   578: istore_1
    //   579: goto -95 -> 484
    //   582: aload 5
    //   584: ldc 161
    //   586: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 5
    //   592: invokestatic 166	com/tencent/qqmail/marcos/AppConfig:getCodeVersion	()Ljava/lang/String;
    //   595: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: new 168	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest
    //   602: dup
    //   603: ldc 170
    //   605: getstatic 176	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod:QMHttpMethod_POST	Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   608: invokespecial 179	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:<init>	(Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;)V
    //   611: astore 6
    //   613: aload 6
    //   615: aload 5
    //   617: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 182	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setRequestParams	(Ljava/lang/String;)V
    //   623: new 184	com/tencent/qqmail/utilities/qmnetwork/QMCallback
    //   626: dup
    //   627: invokespecial 185	com/tencent/qqmail/utilities/qmnetwork/QMCallback:<init>	()V
    //   630: astore 5
    //   632: aload 5
    //   634: new 187	com/tencent/qqmail/utilities/log/QMLogStream$4$1
    //   637: dup
    //   638: aload_0
    //   639: aload 7
    //   641: invokespecial 190	com/tencent/qqmail/utilities/log/QMLogStream$4$1:<init>	(Lcom/tencent/qqmail/utilities/log/QMLogStream$4;Ljava/util/List;)V
    //   644: invokevirtual 194	com/tencent/qqmail/utilities/qmnetwork/QMCallback:setOnError	(Lcom/tencent/qqmail/utilities/qmnetwork/QMCallback$IErrorCallback;)V
    //   647: aload 5
    //   649: new 196	com/tencent/qqmail/utilities/log/QMLogStream$4$2
    //   652: dup
    //   653: aload_0
    //   654: aload 7
    //   656: aload 8
    //   658: invokespecial 199	com/tencent/qqmail/utilities/log/QMLogStream$4$2:<init>	(Lcom/tencent/qqmail/utilities/log/QMLogStream$4;Ljava/util/List;Ljava/io/File;)V
    //   661: invokevirtual 203	com/tencent/qqmail/utilities/qmnetwork/QMCallback:setOnSuccess	(Lcom/tencent/qqmail/utilities/qmnetwork/QMCallback$ISuccessCallback;)V
    //   664: aload 6
    //   666: aload 5
    //   668: invokevirtual 207	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setRequestCallback	(Lcom/tencent/qqmail/utilities/qmnetwork/QMCallback;)V
    //   671: aload 6
    //   673: invokestatic 213	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:send	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   676: return
    //   677: astore 5
    //   679: goto -525 -> 154
    //   682: astore 5
    //   684: goto -459 -> 225
    //   687: astore 6
    //   689: goto -469 -> 220
    //   692: astore 7
    //   694: goto -522 -> 172
    //   697: goto -115 -> 582
    //   700: ldc 215
    //   702: astore 5
    //   704: goto -442 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	4
    //   63	516	1	i	int
    //   61	222	2	j	int
    //   76	79	3	k	int
    //   1	497	4	m	int
    //   66	109	5	localBufferedReader1	java.io.BufferedReader
    //   212	1	5	localException1	java.lang.Exception
    //   218	449	5	localObject1	Object
    //   677	1	5	localException2	java.lang.Exception
    //   682	1	5	localException3	java.lang.Exception
    //   702	1	5	str1	java.lang.String
    //   58	149	6	localBufferedReader2	java.io.BufferedReader
    //   215	11	6	localObject2	Object
    //   265	116	6	str2	java.lang.String
    //   545	19	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   611	61	6	localQMNetworkRequest	com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest
    //   687	1	6	localObject3	Object
    //   20	99	7	localArrayList	java.util.ArrayList
    //   167	488	7	localException4	java.lang.Exception
    //   692	1	7	localException5	java.lang.Exception
    //   32	625	8	localFile	java.io.File
    //   73	48	9	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   42	60	167	java/lang/Exception
    //   206	211	212	java/lang/Exception
    //   42	60	215	finally
    //   432	475	545	java/io/UnsupportedEncodingException
    //   149	154	677	java/lang/Exception
    //   220	225	682	java/lang/Exception
    //   68	75	687	finally
    //   86	94	687	finally
    //   98	109	687	finally
    //   118	128	687	finally
    //   144	149	687	finally
    //   176	206	687	finally
    //   68	75	692	java/lang/Exception
    //   86	94	692	java/lang/Exception
    //   98	109	692	java/lang/Exception
    //   118	128	692	java/lang/Exception
    //   144	149	692	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.4
 * JD-Core Version:    0.7.0.1
 */