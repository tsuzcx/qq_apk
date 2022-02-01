package com.tencent.tpns.baseapi.base.logger;

import java.util.List;

final class TBaseLogger$2
  implements Runnable
{
  TBaseLogger$2(TBaseLogger.WriteFileCallback paramWriteFileCallback, List paramList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_3
    //   6: astore_1
    //   7: invokestatic 28	com/tencent/tpns/baseapi/base/logger/TBaseLogger:a	()Ljava/lang/String;
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_2
    //   14: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +55 -> 72
    //   20: aload_3
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 14	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:a	Lcom/tencent/tpns/baseapi/base/logger/TBaseLogger$WriteFileCallback;
    //   26: ifnull +14 -> 40
    //   29: aload_3
    //   30: astore_1
    //   31: aload_0
    //   32: getfield 14	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:a	Lcom/tencent/tpns/baseapi/base/logger/TBaseLogger$WriteFileCallback;
    //   35: invokeinterface 39 1 0
    //   40: aload_0
    //   41: getfield 16	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:b	Ljava/util/List;
    //   44: invokeinterface 44 1 0
    //   49: iconst_0
    //   50: ifeq +11 -> 61
    //   53: new 46	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 47	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: return
    //   62: astore_1
    //   63: ldc 49
    //   65: ldc 51
    //   67: aload_1
    //   68: invokestatic 55	com/tencent/tpns/baseapi/base/logger/TBaseLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: return
    //   72: aload_3
    //   73: astore_1
    //   74: new 57	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   81: aload_2
    //   82: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: getstatic 68	java/io/File:separator	Ljava/lang/String;
    //   88: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 70
    //   93: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: getstatic 68	java/io/File:separator	Ljava/lang/String;
    //   99: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 72
    //   104: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 6
    //   112: aload_3
    //   113: astore_1
    //   114: invokestatic 77	com/tencent/tpns/baseapi/base/logger/TBaseLogger:b	()Ljava/lang/String;
    //   117: astore 4
    //   119: aload 4
    //   121: astore_2
    //   122: aload_3
    //   123: astore_1
    //   124: aload 4
    //   126: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +37 -> 166
    //   132: aload_3
    //   133: astore_1
    //   134: new 57	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   141: aload 6
    //   143: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 79
    //   148: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokestatic 84	com/tencent/tpns/baseapi/base/logger/LogUtil:getTodayDateTimeForFilename	()Ljava/lang/String;
    //   154: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 86
    //   159: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_2
    //   166: aload_3
    //   167: astore_1
    //   168: new 64	java/io/File
    //   171: dup
    //   172: aload_2
    //   173: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore 4
    //   178: aload_3
    //   179: astore_1
    //   180: aload 4
    //   182: invokevirtual 93	java/io/File:getParentFile	()Ljava/io/File;
    //   185: invokevirtual 97	java/io/File:mkdirs	()Z
    //   188: pop
    //   189: aload_3
    //   190: astore_1
    //   191: aload 4
    //   193: invokevirtual 100	java/io/File:exists	()Z
    //   196: ifeq +426 -> 622
    //   199: aload_3
    //   200: astore_1
    //   201: aload 4
    //   203: invokevirtual 104	java/io/File:length	()J
    //   206: ldc2_w 105
    //   209: lcmp
    //   210: ifle +412 -> 622
    //   213: aload_3
    //   214: astore_1
    //   215: ldc 49
    //   217: new 57	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   224: ldc 108
    //   226: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 4
    //   231: invokevirtual 104	java/io/File:length	()J
    //   234: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: ldc 113
    //   239: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 114
    //   244: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 121	com/tencent/tpns/baseapi/base/logger/TBaseLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_3
    //   254: astore_1
    //   255: new 57	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   262: aload 6
    //   264: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 79
    //   269: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokestatic 84	com/tencent/tpns/baseapi/base/logger/LogUtil:getTodayDateTimeForFilename	()Ljava/lang/String;
    //   275: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 86
    //   280: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: aload_3
    //   288: astore_1
    //   289: new 64	java/io/File
    //   292: dup
    //   293: aload_2
    //   294: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: astore 4
    //   299: aload_3
    //   300: astore_1
    //   301: ldc 49
    //   303: new 57	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   310: ldc 123
    //   312: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_2
    //   316: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 121	com/tencent/tpns/baseapi/base/logger/TBaseLogger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_3
    //   326: astore_1
    //   327: new 125	java/io/BufferedWriter
    //   330: dup
    //   331: new 127	java/io/FileWriter
    //   334: dup
    //   335: aload_2
    //   336: iconst_1
    //   337: invokespecial 130	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   340: invokespecial 133	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   343: astore_3
    //   344: aload 4
    //   346: invokevirtual 104	java/io/File:length	()J
    //   349: lconst_0
    //   350: lcmp
    //   351: ifne +63 -> 414
    //   354: invokestatic 137	com/tencent/tpns/baseapi/base/logger/TBaseLogger:c	()Lcom/tencent/tpns/baseapi/base/logger/DeviceInfo;
    //   357: ifnonnull +23 -> 380
    //   360: invokestatic 141	com/tencent/tpns/baseapi/base/logger/TBaseLogger:d	()Landroid/content/Context;
    //   363: ifnull +17 -> 380
    //   366: new 143	com/tencent/tpns/baseapi/base/logger/DeviceInfo
    //   369: dup
    //   370: invokestatic 141	com/tencent/tpns/baseapi/base/logger/TBaseLogger:d	()Landroid/content/Context;
    //   373: invokespecial 146	com/tencent/tpns/baseapi/base/logger/DeviceInfo:<init>	(Landroid/content/Context;)V
    //   376: invokestatic 149	com/tencent/tpns/baseapi/base/logger/TBaseLogger:a	(Lcom/tencent/tpns/baseapi/base/logger/DeviceInfo;)Lcom/tencent/tpns/baseapi/base/logger/DeviceInfo;
    //   379: pop
    //   380: invokestatic 137	com/tencent/tpns/baseapi/base/logger/TBaseLogger:c	()Lcom/tencent/tpns/baseapi/base/logger/DeviceInfo;
    //   383: ifnull +31 -> 414
    //   386: aload_3
    //   387: new 57	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   394: invokestatic 137	com/tencent/tpns/baseapi/base/logger/TBaseLogger:c	()Lcom/tencent/tpns/baseapi/base/logger/DeviceInfo;
    //   397: invokevirtual 150	com/tencent/tpns/baseapi/base/logger/DeviceInfo:toString	()Ljava/lang/String;
    //   400: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc 152
    //   405: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokevirtual 155	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   414: aload_0
    //   415: getfield 16	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:b	Ljava/util/List;
    //   418: invokeinterface 159 1 0
    //   423: astore 4
    //   425: aload 4
    //   427: invokeinterface 164 1 0
    //   432: ifeq +89 -> 521
    //   435: aload 4
    //   437: invokeinterface 168 1 0
    //   442: checkcast 170	java/lang/String
    //   445: astore_1
    //   446: aload_3
    //   447: new 57	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   454: aload_1
    //   455: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 152
    //   460: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokevirtual 155	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   469: goto -44 -> 425
    //   472: astore_1
    //   473: aload_3
    //   474: astore_2
    //   475: aload_1
    //   476: astore_3
    //   477: aload_2
    //   478: astore_1
    //   479: ldc 49
    //   481: ldc 172
    //   483: aload_3
    //   484: invokestatic 175	com/tencent/tpns/baseapi/base/logger/TBaseLogger:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   487: aload_0
    //   488: getfield 16	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:b	Ljava/util/List;
    //   491: invokeinterface 44 1 0
    //   496: aload_2
    //   497: ifnull +7 -> 504
    //   500: aload_2
    //   501: invokevirtual 178	java/io/BufferedWriter:close	()V
    //   504: aload_0
    //   505: getfield 14	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:a	Lcom/tencent/tpns/baseapi/base/logger/TBaseLogger$WriteFileCallback;
    //   508: ifnull +98 -> 606
    //   511: aload_0
    //   512: getfield 14	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:a	Lcom/tencent/tpns/baseapi/base/logger/TBaseLogger$WriteFileCallback;
    //   515: invokeinterface 39 1 0
    //   520: return
    //   521: aload_2
    //   522: invokestatic 181	com/tencent/tpns/baseapi/base/logger/TBaseLogger:a	(Ljava/lang/String;)Ljava/lang/String;
    //   525: pop
    //   526: aload_0
    //   527: getfield 16	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:b	Ljava/util/List;
    //   530: invokeinterface 44 1 0
    //   535: aload_3
    //   536: ifnull -32 -> 504
    //   539: aload_3
    //   540: invokevirtual 178	java/io/BufferedWriter:close	()V
    //   543: goto -39 -> 504
    //   546: astore_1
    //   547: ldc 49
    //   549: ldc 51
    //   551: aload_1
    //   552: invokestatic 55	com/tencent/tpns/baseapi/base/logger/TBaseLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   555: goto -51 -> 504
    //   558: astore_1
    //   559: ldc 49
    //   561: ldc 51
    //   563: aload_1
    //   564: invokestatic 55	com/tencent/tpns/baseapi/base/logger/TBaseLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   567: goto -63 -> 504
    //   570: astore_2
    //   571: aload_1
    //   572: astore_3
    //   573: aload_2
    //   574: astore_1
    //   575: aload_0
    //   576: getfield 16	com/tencent/tpns/baseapi/base/logger/TBaseLogger$2:b	Ljava/util/List;
    //   579: invokeinterface 44 1 0
    //   584: aload_3
    //   585: ifnull +7 -> 592
    //   588: aload_3
    //   589: invokevirtual 178	java/io/BufferedWriter:close	()V
    //   592: aload_1
    //   593: athrow
    //   594: astore_2
    //   595: ldc 49
    //   597: ldc 51
    //   599: aload_2
    //   600: invokestatic 55	com/tencent/tpns/baseapi/base/logger/TBaseLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   603: goto -11 -> 592
    //   606: iconst_0
    //   607: invokestatic 185	com/tencent/tpns/baseapi/base/logger/TBaseLogger:removeOldDebugLogFiles	(I)V
    //   610: return
    //   611: astore_1
    //   612: goto -37 -> 575
    //   615: astore_3
    //   616: aload 5
    //   618: astore_2
    //   619: goto -142 -> 477
    //   622: goto -323 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	2
    //   6	25	1	localObject1	Object
    //   62	6	1	localThrowable1	java.lang.Throwable
    //   73	382	1	localObject2	Object
    //   472	4	1	localThrowable2	java.lang.Throwable
    //   478	1	1	localObject3	Object
    //   546	6	1	localThrowable3	java.lang.Throwable
    //   558	14	1	localThrowable4	java.lang.Throwable
    //   574	19	1	localObject4	Object
    //   611	1	1	localObject5	Object
    //   10	512	2	localObject6	Object
    //   570	4	2	localObject7	Object
    //   594	6	2	localThrowable5	java.lang.Throwable
    //   618	1	2	localObject8	Object
    //   1	588	3	localObject9	Object
    //   615	1	3	localThrowable6	java.lang.Throwable
    //   117	319	4	localObject10	Object
    //   3	614	5	localObject11	Object
    //   110	153	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   40	49	62	java/lang/Throwable
    //   53	61	62	java/lang/Throwable
    //   344	380	472	java/lang/Throwable
    //   380	414	472	java/lang/Throwable
    //   414	425	472	java/lang/Throwable
    //   425	469	472	java/lang/Throwable
    //   521	526	472	java/lang/Throwable
    //   526	535	546	java/lang/Throwable
    //   539	543	546	java/lang/Throwable
    //   487	496	558	java/lang/Throwable
    //   500	504	558	java/lang/Throwable
    //   7	11	570	finally
    //   13	20	570	finally
    //   22	29	570	finally
    //   31	40	570	finally
    //   74	112	570	finally
    //   114	119	570	finally
    //   124	132	570	finally
    //   134	166	570	finally
    //   168	178	570	finally
    //   180	189	570	finally
    //   191	199	570	finally
    //   201	213	570	finally
    //   215	253	570	finally
    //   255	287	570	finally
    //   289	299	570	finally
    //   301	325	570	finally
    //   327	344	570	finally
    //   479	487	570	finally
    //   575	584	594	java/lang/Throwable
    //   588	592	594	java/lang/Throwable
    //   344	380	611	finally
    //   380	414	611	finally
    //   414	425	611	finally
    //   425	469	611	finally
    //   521	526	611	finally
    //   7	11	615	java/lang/Throwable
    //   13	20	615	java/lang/Throwable
    //   22	29	615	java/lang/Throwable
    //   31	40	615	java/lang/Throwable
    //   74	112	615	java/lang/Throwable
    //   114	119	615	java/lang/Throwable
    //   124	132	615	java/lang/Throwable
    //   134	166	615	java/lang/Throwable
    //   168	178	615	java/lang/Throwable
    //   180	189	615	java/lang/Throwable
    //   191	199	615	java/lang/Throwable
    //   201	213	615	java/lang/Throwable
    //   215	253	615	java/lang/Throwable
    //   255	287	615	java/lang/Throwable
    //   289	299	615	java/lang/Throwable
    //   301	325	615	java/lang/Throwable
    //   327	344	615	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.TBaseLogger.2
 * JD-Core Version:    0.7.0.1
 */