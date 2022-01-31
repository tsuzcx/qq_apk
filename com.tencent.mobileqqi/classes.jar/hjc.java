class hjc
  implements Runnable
{
  hjc(hjb paramhjb, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4: invokestatic 31	hjb:a	(Lhjb;)Ljava/util/HashMap;
    //   7: astore 32
    //   9: aload 32
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   16: invokestatic 31	hjb:a	(Lhjb;)Ljava/util/HashMap;
    //   19: aload_0
    //   20: getfield 15	hjc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokevirtual 37	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 39	com/tencent/mobileqq/vip/DownloadTask
    //   29: astore 40
    //   31: aload 32
    //   33: monitorexit
    //   34: aload 40
    //   36: ifnonnull +12 -> 48
    //   39: return
    //   40: astore 33
    //   42: aload 32
    //   44: monitorexit
    //   45: aload 33
    //   47: athrow
    //   48: aload 40
    //   50: getfield 43	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   53: iconst_1
    //   54: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   57: aload 40
    //   59: invokevirtual 52	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   62: astore 41
    //   64: aload 41
    //   66: ifnull +11 -> 77
    //   69: aload 41
    //   71: aload 40
    //   73: invokevirtual 57	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/mobileqq/vip/DownloadTask;)Z
    //   76: pop
    //   77: aload_0
    //   78: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   81: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   84: getfield 66	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Int	I
    //   87: ifle +58 -> 145
    //   90: aload_0
    //   91: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   94: invokestatic 31	hjb:a	(Lhjb;)Ljava/util/HashMap;
    //   97: invokevirtual 70	java/util/HashMap:size	()I
    //   100: aload_0
    //   101: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   104: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   107: getfield 66	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Int	I
    //   110: if_icmple +35 -> 145
    //   113: aload 41
    //   115: ifnull +20 -> 135
    //   118: aload 40
    //   120: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   123: bipush 253
    //   125: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   128: aload 41
    //   130: aload 40
    //   132: invokevirtual 81	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   135: aload_0
    //   136: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   139: aload 40
    //   141: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   144: return
    //   145: aload_0
    //   146: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   149: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   152: getfield 87	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_Boolean	Z
    //   155: ifeq +113 -> 268
    //   158: aload_0
    //   159: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   162: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   165: aload_0
    //   166: getfield 15	hjc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: invokevirtual 93	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: ifnonnull +57 -> 229
    //   175: iconst_0
    //   176: istore_1
    //   177: iload_1
    //   178: ifle +90 -> 268
    //   181: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   184: ldc2_w 100
    //   187: ldiv
    //   188: l2i
    //   189: iload_1
    //   190: sipush 600
    //   193: iadd
    //   194: if_icmpge +59 -> 253
    //   197: aload 41
    //   199: ifnull +20 -> 219
    //   202: aload 40
    //   204: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   207: bipush 252
    //   209: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   212: aload 41
    //   214: aload 40
    //   216: invokevirtual 81	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   219: aload_0
    //   220: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   223: aload 40
    //   225: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   228: return
    //   229: aload_0
    //   230: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   233: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   236: aload_0
    //   237: getfield 15	hjc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 93	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: checkcast 103	java/lang/Integer
    //   246: invokevirtual 106	java/lang/Integer:intValue	()I
    //   249: istore_1
    //   250: goto -73 -> 177
    //   253: aload_0
    //   254: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   257: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   260: aload_0
    //   261: getfield 15	hjc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   264: invokevirtual 109	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: pop
    //   268: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   277: iconst_2
    //   278: new 118	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   285: ldc 121
    //   287: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 40
    //   292: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload 40
    //   303: getfield 138	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   306: invokevirtual 140	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   309: ifeq +25 -> 334
    //   312: aload 41
    //   314: ifnull +10 -> 324
    //   317: aload 41
    //   319: aload 40
    //   321: invokevirtual 142	com/tencent/mobileqq/vip/DownloadListener:b	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   324: aload_0
    //   325: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   328: aload 40
    //   330: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   333: return
    //   334: aload 40
    //   336: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   339: invokevirtual 144	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   342: iconst_2
    //   343: if_icmpne +4762 -> 5105
    //   346: new 4	java/lang/Object
    //   349: dup
    //   350: invokespecial 18	java/lang/Object:<init>	()V
    //   353: astore 42
    //   355: lconst_0
    //   356: lstore 8
    //   358: lconst_0
    //   359: lstore 18
    //   361: lconst_0
    //   362: lstore 22
    //   364: lload 22
    //   366: lstore 16
    //   368: lload 18
    //   370: lstore 20
    //   372: lload 8
    //   374: lstore 10
    //   376: new 146	com/tencent/mobileqq/emoticon/DownloadInfo
    //   379: dup
    //   380: aload 40
    //   382: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   385: aconst_null
    //   386: iconst_0
    //   387: invokespecial 150	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   390: astore 39
    //   392: lload 22
    //   394: lstore 14
    //   396: lload 18
    //   398: lstore 12
    //   400: lload 8
    //   402: lstore 6
    //   404: lload 22
    //   406: lstore 16
    //   408: lload 18
    //   410: lstore 20
    //   412: lload 8
    //   414: lstore 10
    //   416: getstatic 155	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   419: invokevirtual 161	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   422: astore 43
    //   424: aload 43
    //   426: ifnonnull +733 -> 1159
    //   429: lload 22
    //   431: lstore 14
    //   433: lload 18
    //   435: lstore 12
    //   437: lload 8
    //   439: lstore 6
    //   441: lload 22
    //   443: lstore 16
    //   445: lload 18
    //   447: lstore 20
    //   449: lload 8
    //   451: lstore 10
    //   453: new 163	java/lang/Exception
    //   456: dup
    //   457: new 118	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   464: ldc 165
    //   466: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 40
    //   471: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokespecial 168	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   483: athrow
    //   484: astore 33
    //   486: lload 6
    //   488: lstore 10
    //   490: aconst_null
    //   491: astore 35
    //   493: aconst_null
    //   494: astore 34
    //   496: aconst_null
    //   497: astore 32
    //   499: lconst_0
    //   500: lstore 8
    //   502: iconst_0
    //   503: istore 28
    //   505: iconst_0
    //   506: istore_1
    //   507: lload 12
    //   509: lstore 6
    //   511: lload 14
    //   513: lstore 12
    //   515: lload 10
    //   517: lstore 20
    //   519: lload 6
    //   521: lstore 18
    //   523: lload 12
    //   525: lstore 14
    //   527: lload 8
    //   529: lstore 16
    //   531: aload 35
    //   533: astore 36
    //   535: aload 34
    //   537: astore 38
    //   539: aload 32
    //   541: astore 37
    //   543: aload 39
    //   545: getfield 169	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   548: ifeq +80 -> 628
    //   551: lload 10
    //   553: lstore 20
    //   555: lload 6
    //   557: lstore 18
    //   559: lload 12
    //   561: lstore 14
    //   563: lload 8
    //   565: lstore 16
    //   567: aload 35
    //   569: astore 36
    //   571: aload 34
    //   573: astore 38
    //   575: aload 32
    //   577: astore 37
    //   579: invokestatic 174	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   582: astore 42
    //   584: aload 42
    //   586: ifnull +42 -> 628
    //   589: lload 10
    //   591: lstore 20
    //   593: lload 6
    //   595: lstore 18
    //   597: lload 12
    //   599: lstore 14
    //   601: lload 8
    //   603: lstore 16
    //   605: aload 35
    //   607: astore 36
    //   609: aload 34
    //   611: astore 38
    //   613: aload 32
    //   615: astore 37
    //   617: aload 42
    //   619: iconst_5
    //   620: aload 39
    //   622: getfield 176	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   625: invokevirtual 179	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   628: iconst_0
    //   629: istore_2
    //   630: lload 10
    //   632: lstore 20
    //   634: lload 6
    //   636: lstore 18
    //   638: lload 12
    //   640: lstore 14
    //   642: lload 8
    //   644: lstore 16
    //   646: aload 35
    //   648: astore 36
    //   650: aload 34
    //   652: astore 38
    //   654: aload 32
    //   656: astore 37
    //   658: aload 33
    //   660: instanceof 181
    //   663: ifne +4443 -> 5106
    //   666: lload 10
    //   668: lstore 20
    //   670: lload 6
    //   672: lstore 18
    //   674: lload 12
    //   676: lstore 14
    //   678: lload 8
    //   680: lstore 16
    //   682: aload 35
    //   684: astore 36
    //   686: aload 34
    //   688: astore 38
    //   690: aload 32
    //   692: astore 37
    //   694: aload 33
    //   696: instanceof 183
    //   699: ifne +4407 -> 5106
    //   702: lload 10
    //   704: lstore 20
    //   706: lload 6
    //   708: lstore 18
    //   710: lload 12
    //   712: lstore 14
    //   714: lload 8
    //   716: lstore 16
    //   718: aload 35
    //   720: astore 36
    //   722: aload 34
    //   724: astore 38
    //   726: aload 32
    //   728: astore 37
    //   730: aload 33
    //   732: instanceof 185
    //   735: ifeq +6 -> 741
    //   738: goto +4368 -> 5106
    //   741: iload_1
    //   742: ifne +51 -> 793
    //   745: iload_2
    //   746: ifeq +47 -> 793
    //   749: iload 28
    //   751: ifeq +3677 -> 4428
    //   754: lload 10
    //   756: lstore 20
    //   758: lload 6
    //   760: lstore 18
    //   762: lload 12
    //   764: lstore 14
    //   766: lload 8
    //   768: lstore 16
    //   770: aload 35
    //   772: astore 36
    //   774: aload 34
    //   776: astore 38
    //   778: aload 32
    //   780: astore 37
    //   782: aload_0
    //   783: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   786: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   789: iconst_1
    //   790: putfield 187	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Boolean	Z
    //   793: lload 10
    //   795: lstore 20
    //   797: lload 6
    //   799: lstore 18
    //   801: lload 12
    //   803: lstore 14
    //   805: lload 8
    //   807: lstore 16
    //   809: aload 35
    //   811: astore 36
    //   813: aload 34
    //   815: astore 38
    //   817: aload 32
    //   819: astore 37
    //   821: aload 39
    //   823: getfield 169	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   826: ifeq +3644 -> 4470
    //   829: lload 10
    //   831: lstore 20
    //   833: lload 6
    //   835: lstore 18
    //   837: lload 12
    //   839: lstore 14
    //   841: lload 8
    //   843: lstore 16
    //   845: aload 35
    //   847: astore 36
    //   849: aload 34
    //   851: astore 38
    //   853: aload 32
    //   855: astore 37
    //   857: aload_0
    //   858: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   861: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   864: iconst_0
    //   865: putfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   868: lload 10
    //   870: lstore 20
    //   872: lload 6
    //   874: lstore 18
    //   876: lload 12
    //   878: lstore 14
    //   880: lload 8
    //   882: lstore 16
    //   884: aload 35
    //   886: astore 36
    //   888: aload 34
    //   890: astore 38
    //   892: aload 32
    //   894: astore 37
    //   896: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   899: ifeq +63 -> 962
    //   902: lload 10
    //   904: lstore 20
    //   906: lload 6
    //   908: lstore 18
    //   910: lload 12
    //   912: lstore 14
    //   914: lload 8
    //   916: lstore 16
    //   918: aload 35
    //   920: astore 36
    //   922: aload 34
    //   924: astore 38
    //   926: aload 32
    //   928: astore 37
    //   930: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   933: iconst_2
    //   934: new 118	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   941: ldc 191
    //   943: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload 40
    //   948: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   951: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: aload 33
    //   959: invokestatic 195	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   962: aload 41
    //   964: ifnull +75 -> 1039
    //   967: lload 10
    //   969: lstore 20
    //   971: lload 6
    //   973: lstore 18
    //   975: lload 12
    //   977: lstore 14
    //   979: lload 8
    //   981: lstore 16
    //   983: aload 35
    //   985: astore 36
    //   987: aload 34
    //   989: astore 38
    //   991: aload 32
    //   993: astore 37
    //   995: aload 40
    //   997: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1000: iconst_m1
    //   1001: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1004: lload 10
    //   1006: lstore 20
    //   1008: lload 6
    //   1010: lstore 18
    //   1012: lload 12
    //   1014: lstore 14
    //   1016: lload 8
    //   1018: lstore 16
    //   1020: aload 35
    //   1022: astore 36
    //   1024: aload 34
    //   1026: astore 38
    //   1028: aload 32
    //   1030: astore 37
    //   1032: aload 41
    //   1034: aload 40
    //   1036: invokevirtual 81	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1039: aload 32
    //   1041: ifnull +10 -> 1051
    //   1044: aload 32
    //   1046: invokeinterface 200 1 0
    //   1051: aload 34
    //   1053: ifnull +8 -> 1061
    //   1056: aload 34
    //   1058: invokevirtual 205	java/io/InputStream:close	()V
    //   1061: aload 35
    //   1063: ifnull +8 -> 1071
    //   1066: aload 35
    //   1068: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   1071: lload 10
    //   1073: lconst_0
    //   1074: lcmp
    //   1075: ifeq +38 -> 1113
    //   1078: lload 6
    //   1080: lconst_0
    //   1081: lcmp
    //   1082: ifeq +31 -> 1113
    //   1085: lload 10
    //   1087: lload 6
    //   1089: lcmp
    //   1090: ifne +3422 -> 4512
    //   1093: aload 40
    //   1095: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1098: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   1101: invokestatic 218	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   1104: aload 40
    //   1106: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1109: invokevirtual 221	java/io/File:delete	()Z
    //   1112: pop
    //   1113: aload_0
    //   1114: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1117: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1120: ifnull +29 -> 1149
    //   1123: aload 41
    //   1125: ifnull +24 -> 1149
    //   1128: lload 8
    //   1130: lconst_0
    //   1131: lcmp
    //   1132: ifle +17 -> 1149
    //   1135: aload 41
    //   1137: aload_0
    //   1138: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1141: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1144: lload 8
    //   1146: invokevirtual 227	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   1149: aload_0
    //   1150: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1153: aload 40
    //   1155: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1158: return
    //   1159: lload 22
    //   1161: lstore 14
    //   1163: lload 18
    //   1165: lstore 12
    //   1167: lload 8
    //   1169: lstore 6
    //   1171: lload 22
    //   1173: lstore 16
    //   1175: lload 18
    //   1177: lstore 20
    //   1179: lload 8
    //   1181: lstore 10
    //   1183: new 229	java/net/URL
    //   1186: dup
    //   1187: aload 40
    //   1189: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1192: invokespecial 230	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1195: pop
    //   1196: lload 22
    //   1198: lstore 14
    //   1200: lload 18
    //   1202: lstore 12
    //   1204: lload 8
    //   1206: lstore 6
    //   1208: lload 22
    //   1210: lstore 16
    //   1212: lload 18
    //   1214: lstore 20
    //   1216: lload 8
    //   1218: lstore 10
    //   1220: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   1223: lstore 26
    //   1225: lload 22
    //   1227: lstore 14
    //   1229: lload 18
    //   1231: lstore 12
    //   1233: lload 8
    //   1235: lstore 6
    //   1237: lload 22
    //   1239: lstore 16
    //   1241: lload 18
    //   1243: lstore 20
    //   1245: lload 8
    //   1247: lstore 10
    //   1249: new 232	org/apache/http/client/methods/HttpGet
    //   1252: dup
    //   1253: aload 40
    //   1255: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1258: invokespecial 233	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1261: astore 44
    //   1263: lload 22
    //   1265: lstore 14
    //   1267: lload 18
    //   1269: lstore 12
    //   1271: lload 8
    //   1273: lstore 6
    //   1275: lload 22
    //   1277: lstore 16
    //   1279: lload 18
    //   1281: lstore 20
    //   1283: lload 8
    //   1285: lstore 10
    //   1287: new 235	org/apache/http/params/BasicHttpParams
    //   1290: dup
    //   1291: invokespecial 236	org/apache/http/params/BasicHttpParams:<init>	()V
    //   1294: astore 45
    //   1296: lload 22
    //   1298: lstore 14
    //   1300: lload 18
    //   1302: lstore 12
    //   1304: lload 8
    //   1306: lstore 6
    //   1308: lload 22
    //   1310: lstore 16
    //   1312: lload 18
    //   1314: lstore 20
    //   1316: lload 8
    //   1318: lstore 10
    //   1320: aload 45
    //   1322: ldc 238
    //   1324: ldc 239
    //   1326: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1329: invokeinterface 249 3 0
    //   1334: pop
    //   1335: lload 22
    //   1337: lstore 14
    //   1339: lload 18
    //   1341: lstore 12
    //   1343: lload 8
    //   1345: lstore 6
    //   1347: lload 22
    //   1349: lstore 16
    //   1351: lload 18
    //   1353: lstore 20
    //   1355: lload 8
    //   1357: lstore 10
    //   1359: aload 45
    //   1361: ldc 251
    //   1363: ldc 239
    //   1365: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: invokeinterface 249 3 0
    //   1373: pop
    //   1374: lload 22
    //   1376: lstore 14
    //   1378: lload 18
    //   1380: lstore 12
    //   1382: lload 8
    //   1384: lstore 6
    //   1386: lload 22
    //   1388: lstore 16
    //   1390: lload 18
    //   1392: lstore 20
    //   1394: lload 8
    //   1396: lstore 10
    //   1398: aload 45
    //   1400: ldc 253
    //   1402: ldc 255
    //   1404: invokeinterface 249 3 0
    //   1409: pop
    //   1410: lload 22
    //   1412: lstore 14
    //   1414: lload 18
    //   1416: lstore 12
    //   1418: lload 8
    //   1420: lstore 6
    //   1422: lload 22
    //   1424: lstore 16
    //   1426: lload 18
    //   1428: lstore 20
    //   1430: lload 8
    //   1432: lstore 10
    //   1434: aload 40
    //   1436: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1439: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   1442: invokestatic 258	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)[J
    //   1445: astore 32
    //   1447: aload 32
    //   1449: iconst_0
    //   1450: laload
    //   1451: lstore 6
    //   1453: aload 32
    //   1455: iconst_1
    //   1456: laload
    //   1457: lstore 18
    //   1459: aload 32
    //   1461: iconst_2
    //   1462: laload
    //   1463: lstore 22
    //   1465: lload 6
    //   1467: lstore 8
    //   1469: lload 6
    //   1471: lconst_1
    //   1472: lcmp
    //   1473: ifge +325 -> 1798
    //   1476: lconst_0
    //   1477: lstore 24
    //   1479: lload 22
    //   1481: lstore 14
    //   1483: lload 18
    //   1485: lstore 12
    //   1487: lload 24
    //   1489: lstore 6
    //   1491: lload 22
    //   1493: lstore 16
    //   1495: lload 18
    //   1497: lstore 20
    //   1499: lload 24
    //   1501: lstore 10
    //   1503: aload 40
    //   1505: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1508: invokevirtual 262	java/io/File:getParentFile	()Ljava/io/File;
    //   1511: astore 32
    //   1513: lload 24
    //   1515: lstore 8
    //   1517: aload 32
    //   1519: ifnull +279 -> 1798
    //   1522: lload 22
    //   1524: lstore 14
    //   1526: lload 18
    //   1528: lstore 12
    //   1530: lload 24
    //   1532: lstore 6
    //   1534: lload 22
    //   1536: lstore 16
    //   1538: lload 18
    //   1540: lstore 20
    //   1542: lload 24
    //   1544: lstore 10
    //   1546: lload 24
    //   1548: lstore 8
    //   1550: aload 32
    //   1552: invokevirtual 265	java/io/File:exists	()Z
    //   1555: ifne +243 -> 1798
    //   1558: lload 22
    //   1560: lstore 14
    //   1562: lload 18
    //   1564: lstore 12
    //   1566: lload 24
    //   1568: lstore 6
    //   1570: lload 22
    //   1572: lstore 16
    //   1574: lload 18
    //   1576: lstore 20
    //   1578: lload 24
    //   1580: lstore 10
    //   1582: lload 24
    //   1584: lstore 8
    //   1586: aload 32
    //   1588: invokevirtual 268	java/io/File:mkdirs	()Z
    //   1591: ifne +207 -> 1798
    //   1594: lload 22
    //   1596: lstore 14
    //   1598: lload 18
    //   1600: lstore 12
    //   1602: lload 24
    //   1604: lstore 6
    //   1606: lload 22
    //   1608: lstore 16
    //   1610: lload 18
    //   1612: lstore 20
    //   1614: lload 24
    //   1616: lstore 10
    //   1618: new 163	java/lang/Exception
    //   1621: dup
    //   1622: new 118	java/lang/StringBuilder
    //   1625: dup
    //   1626: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   1629: ldc_w 270
    //   1632: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1635: aload 32
    //   1637: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1640: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1646: invokespecial 168	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1649: athrow
    //   1650: astore 35
    //   1652: aconst_null
    //   1653: astore 33
    //   1655: aconst_null
    //   1656: astore 32
    //   1658: aconst_null
    //   1659: astore 34
    //   1661: lload 20
    //   1663: lstore 6
    //   1665: lload 16
    //   1667: lstore 14
    //   1669: lconst_0
    //   1670: lstore 8
    //   1672: lload 10
    //   1674: lstore 12
    //   1676: aload 33
    //   1678: ifnull +10 -> 1688
    //   1681: aload 33
    //   1683: invokeinterface 200 1 0
    //   1688: aload 32
    //   1690: ifnull +8 -> 1698
    //   1693: aload 32
    //   1695: invokevirtual 205	java/io/InputStream:close	()V
    //   1698: aload 34
    //   1700: ifnull +8 -> 1708
    //   1703: aload 34
    //   1705: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   1708: lload 12
    //   1710: lconst_0
    //   1711: lcmp
    //   1712: ifeq +38 -> 1750
    //   1715: lload 6
    //   1717: lconst_0
    //   1718: lcmp
    //   1719: ifeq +31 -> 1750
    //   1722: lload 12
    //   1724: lload 6
    //   1726: lcmp
    //   1727: ifne +2805 -> 4532
    //   1730: aload 40
    //   1732: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1735: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   1738: invokestatic 218	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   1741: aload 40
    //   1743: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1746: invokevirtual 221	java/io/File:delete	()Z
    //   1749: pop
    //   1750: aload_0
    //   1751: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1754: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1757: ifnull +29 -> 1786
    //   1760: aload 41
    //   1762: ifnull +24 -> 1786
    //   1765: lload 8
    //   1767: lconst_0
    //   1768: lcmp
    //   1769: ifle +17 -> 1786
    //   1772: aload 41
    //   1774: aload_0
    //   1775: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1778: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1781: lload 8
    //   1783: invokevirtual 227	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   1786: aload_0
    //   1787: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   1790: aload 40
    //   1792: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1795: aload 35
    //   1797: athrow
    //   1798: lload 22
    //   1800: lstore 14
    //   1802: lload 18
    //   1804: lstore 12
    //   1806: lload 8
    //   1808: lstore 6
    //   1810: lload 22
    //   1812: lstore 16
    //   1814: lload 18
    //   1816: lstore 20
    //   1818: lload 8
    //   1820: lstore 10
    //   1822: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1825: ifeq +77 -> 1902
    //   1828: lload 22
    //   1830: lstore 14
    //   1832: lload 18
    //   1834: lstore 12
    //   1836: lload 8
    //   1838: lstore 6
    //   1840: lload 22
    //   1842: lstore 16
    //   1844: lload 18
    //   1846: lstore 20
    //   1848: lload 8
    //   1850: lstore 10
    //   1852: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1855: iconst_2
    //   1856: new 118	java/lang/StringBuilder
    //   1859: dup
    //   1860: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   1863: ldc_w 275
    //   1866: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: lload 8
    //   1871: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1874: ldc_w 280
    //   1877: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: lload 18
    //   1882: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1885: ldc_w 282
    //   1888: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1891: lload 22
    //   1893: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1896: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1899: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1902: iconst_0
    //   1903: istore_1
    //   1904: iconst_m1
    //   1905: istore 4
    //   1907: iconst_0
    //   1908: istore 30
    //   1910: aconst_null
    //   1911: astore 33
    //   1913: iconst_0
    //   1914: istore 29
    //   1916: aconst_null
    //   1917: astore 32
    //   1919: aconst_null
    //   1920: astore 34
    //   1922: sipush 2048
    //   1925: istore_2
    //   1926: lconst_0
    //   1927: lstore 6
    //   1929: lload 22
    //   1931: lstore 14
    //   1933: lload 18
    //   1935: lstore 10
    //   1937: aload 33
    //   1939: astore 36
    //   1941: iload 29
    //   1943: istore 31
    //   1945: aload 44
    //   1947: ldc_w 284
    //   1950: new 118	java/lang/StringBuilder
    //   1953: dup
    //   1954: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   1957: ldc_w 286
    //   1960: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: lload 8
    //   1965: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1968: ldc_w 288
    //   1971: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1974: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1977: invokevirtual 292	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: aload 33
    //   1982: astore 36
    //   1984: iload 29
    //   1986: istore 31
    //   1988: aload 39
    //   1990: invokevirtual 294	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   1993: aload 33
    //   1995: astore 36
    //   1997: iload 29
    //   1999: istore 31
    //   2001: getstatic 295	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2004: ifeq +74 -> 2078
    //   2007: aload 33
    //   2009: astore 36
    //   2011: iload 29
    //   2013: istore 31
    //   2015: aload_0
    //   2016: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2019: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2022: getfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   2025: ifeq +53 -> 2078
    //   2028: aload 33
    //   2030: astore 36
    //   2032: iload 29
    //   2034: istore 31
    //   2036: aload 39
    //   2038: invokestatic 300	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   2041: aload 33
    //   2043: astore 36
    //   2045: iload 29
    //   2047: istore 31
    //   2049: aload 39
    //   2051: getfield 169	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2054: ifeq +24 -> 2078
    //   2057: aload 33
    //   2059: astore 36
    //   2061: iload 29
    //   2063: istore 31
    //   2065: aload 44
    //   2067: ldc_w 302
    //   2070: aload 39
    //   2072: getfield 304	com/tencent/mobileqq/emoticon/DownloadInfo:d	Ljava/lang/String;
    //   2075: invokevirtual 292	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2078: aload 33
    //   2080: astore 36
    //   2082: iload 29
    //   2084: istore 31
    //   2086: aload 43
    //   2088: invokevirtual 309	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   2091: invokestatic 315	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   2094: astore 38
    //   2096: aload 33
    //   2098: astore 36
    //   2100: iload 29
    //   2102: istore 31
    //   2104: aload 38
    //   2106: aload_0
    //   2107: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2110: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2113: getfield 316	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2116: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2119: ifne +42 -> 2161
    //   2122: aload 33
    //   2124: astore 36
    //   2126: iload 29
    //   2128: istore 31
    //   2130: aload_0
    //   2131: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2134: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2137: iconst_0
    //   2138: putfield 187	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Boolean	Z
    //   2141: aload 33
    //   2143: astore 36
    //   2145: iload 29
    //   2147: istore 31
    //   2149: aload_0
    //   2150: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2153: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2156: aload 38
    //   2158: putfield 316	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2161: aconst_null
    //   2162: astore 35
    //   2164: iconst_0
    //   2165: istore 5
    //   2167: iconst_0
    //   2168: istore_3
    //   2169: aload 33
    //   2171: astore 36
    //   2173: iload 29
    //   2175: istore 31
    //   2177: aload 43
    //   2179: invokestatic 327	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   2182: ifeq +2991 -> 5173
    //   2185: iload 29
    //   2187: istore 28
    //   2189: aload 33
    //   2191: astore 36
    //   2193: iload 29
    //   2195: istore 31
    //   2197: aload_0
    //   2198: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2201: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2204: getfield 187	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Boolean	Z
    //   2207: ifne +101 -> 2308
    //   2210: aload 33
    //   2212: astore 36
    //   2214: iload 29
    //   2216: istore 31
    //   2218: invokestatic 332	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   2221: astore 37
    //   2223: aload 33
    //   2225: astore 36
    //   2227: iload 29
    //   2229: istore 31
    //   2231: invokestatic 335	android/net/Proxy:getDefaultPort	()I
    //   2234: istore 5
    //   2236: iload 5
    //   2238: istore_3
    //   2239: iload 29
    //   2241: istore 28
    //   2243: aload 37
    //   2245: astore 35
    //   2247: aload 37
    //   2249: ifnull +59 -> 2308
    //   2252: iload 5
    //   2254: istore_3
    //   2255: iload 29
    //   2257: istore 28
    //   2259: aload 37
    //   2261: astore 35
    //   2263: iload 5
    //   2265: ifle +43 -> 2308
    //   2268: aload 33
    //   2270: astore 36
    //   2272: iload 29
    //   2274: istore 31
    //   2276: aload 45
    //   2278: ldc_w 337
    //   2281: new 339	org/apache/http/HttpHost
    //   2284: dup
    //   2285: aload 37
    //   2287: iload 5
    //   2289: invokespecial 342	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   2292: invokeinterface 249 3 0
    //   2297: pop
    //   2298: iconst_1
    //   2299: istore 28
    //   2301: aload 37
    //   2303: astore 35
    //   2305: iload 5
    //   2307: istore_3
    //   2308: aload 33
    //   2310: astore 36
    //   2312: iload 28
    //   2314: istore 31
    //   2316: aload 38
    //   2318: getstatic 343	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   2321: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2324: ifne +41 -> 2365
    //   2327: aload 33
    //   2329: astore 36
    //   2331: iload 28
    //   2333: istore 31
    //   2335: aload 38
    //   2337: getstatic 345	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   2340: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2343: ifne +22 -> 2365
    //   2346: aload 33
    //   2348: astore 36
    //   2350: iload 28
    //   2352: istore 31
    //   2354: aload 38
    //   2356: getstatic 348	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   2359: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2362: ifeq +2692 -> 5054
    //   2365: aload 33
    //   2367: astore 36
    //   2369: iload 28
    //   2371: istore 31
    //   2373: aload 44
    //   2375: ldc_w 350
    //   2378: aload 39
    //   2380: getfield 304	com/tencent/mobileqq/emoticon/DownloadInfo:d	Ljava/lang/String;
    //   2383: invokevirtual 292	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2386: iload_3
    //   2387: istore 5
    //   2389: aload 33
    //   2391: astore 36
    //   2393: iload_1
    //   2394: istore_3
    //   2395: aload 45
    //   2397: ldc_w 352
    //   2400: iload_2
    //   2401: invokeinterface 356 3 0
    //   2406: pop
    //   2407: aload 33
    //   2409: astore 36
    //   2411: iload_1
    //   2412: istore_3
    //   2413: aload 44
    //   2415: aload 45
    //   2417: invokevirtual 360	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   2420: aload 33
    //   2422: astore 36
    //   2424: iload_1
    //   2425: istore_3
    //   2426: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2429: ifeq +122 -> 2551
    //   2432: aload 33
    //   2434: astore 36
    //   2436: iload_1
    //   2437: istore_3
    //   2438: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2441: iconst_2
    //   2442: new 118	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2449: ldc_w 362
    //   2452: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: aload_0
    //   2456: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2459: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2462: getfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   2465: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2468: ldc_w 367
    //   2471: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: aload_0
    //   2475: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   2478: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2481: getfield 187	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Boolean	Z
    //   2484: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2487: ldc_w 369
    //   2490: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2493: iload 28
    //   2495: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2498: ldc_w 371
    //   2501: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2504: aload 38
    //   2506: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: ldc_w 373
    //   2512: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2515: aload 35
    //   2517: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: ldc_w 375
    //   2523: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: iload 5
    //   2528: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2531: ldc_w 380
    //   2534: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: aload 39
    //   2539: getfield 176	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   2542: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2545: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2548: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2551: iconst_0
    //   2552: istore_3
    //   2553: aload 33
    //   2555: astore 36
    //   2557: getstatic 383	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   2560: aload 44
    //   2562: invokevirtual 389	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   2565: astore 37
    //   2567: iconst_1
    //   2568: istore_1
    //   2569: aload 33
    //   2571: astore 36
    //   2573: aload 33
    //   2575: astore 35
    //   2577: aload 37
    //   2579: invokeinterface 395 1 0
    //   2584: invokeinterface 400 1 0
    //   2589: istore_3
    //   2590: aload 33
    //   2592: astore 36
    //   2594: aload 33
    //   2596: astore 35
    //   2598: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2601: ifeq +2510 -> 5111
    //   2604: aload 33
    //   2606: astore 36
    //   2608: aload 33
    //   2610: astore 35
    //   2612: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2615: iconst_2
    //   2616: new 118	java/lang/StringBuilder
    //   2619: dup
    //   2620: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2623: ldc_w 402
    //   2626: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2629: iload_3
    //   2630: invokevirtual 378	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2633: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2636: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2639: goto +2472 -> 5111
    //   2642: aload 33
    //   2644: astore 36
    //   2646: aload 33
    //   2648: astore 35
    //   2650: aload 37
    //   2652: invokeinterface 406 1 0
    //   2657: astore 33
    //   2659: aload 33
    //   2661: astore 36
    //   2663: aload 33
    //   2665: astore 35
    //   2667: aload 33
    //   2669: invokeinterface 409 1 0
    //   2674: lstore 22
    //   2676: lload 22
    //   2678: lconst_1
    //   2679: lcmp
    //   2680: ifge +43 -> 2723
    //   2683: aload 33
    //   2685: astore 36
    //   2687: aload 33
    //   2689: astore 35
    //   2691: new 163	java/lang/Exception
    //   2694: dup
    //   2695: new 118	java/lang/StringBuilder
    //   2698: dup
    //   2699: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2702: ldc_w 411
    //   2705: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2708: aload 40
    //   2710: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2713: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2719: invokespecial 168	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2722: athrow
    //   2723: lconst_0
    //   2724: lstore 16
    //   2726: aload 33
    //   2728: astore 36
    //   2730: aload 33
    //   2732: astore 35
    //   2734: aload 37
    //   2736: ldc_w 413
    //   2739: invokeinterface 417 2 0
    //   2744: ifeq +31 -> 2775
    //   2747: aload 33
    //   2749: astore 36
    //   2751: aload 33
    //   2753: astore 35
    //   2755: aload 37
    //   2757: ldc_w 413
    //   2760: invokeinterface 421 2 0
    //   2765: invokeinterface 426 1 0
    //   2770: invokestatic 432	java/util/Date:parse	(Ljava/lang/String;)J
    //   2773: lstore 16
    //   2775: lload 8
    //   2777: lconst_0
    //   2778: lcmp
    //   2779: ifne +720 -> 3499
    //   2782: lload 16
    //   2784: lstore 14
    //   2786: lload 22
    //   2788: lstore 10
    //   2790: lload 8
    //   2792: lstore 12
    //   2794: lload 10
    //   2796: lstore 8
    //   2798: lload 12
    //   2800: lstore 18
    //   2802: lload 12
    //   2804: lstore 20
    //   2806: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2809: ifeq +83 -> 2892
    //   2812: lload 12
    //   2814: lstore 18
    //   2816: lload 12
    //   2818: lstore 20
    //   2820: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2823: iconst_2
    //   2824: new 118	java/lang/StringBuilder
    //   2827: dup
    //   2828: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   2831: ldc_w 434
    //   2834: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2837: lload 22
    //   2839: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2842: ldc_w 436
    //   2845: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2848: lload 12
    //   2850: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2853: ldc_w 280
    //   2856: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2859: lload 8
    //   2861: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2864: ldc_w 282
    //   2867: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2870: lload 14
    //   2872: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2875: ldc_w 438
    //   2878: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: lload 16
    //   2883: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2886: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2889: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2892: lload 14
    //   2894: lconst_0
    //   2895: lcmp
    //   2896: ifeq +631 -> 3527
    //   2899: lload 14
    //   2901: lload 16
    //   2903: lcmp
    //   2904: ifeq +623 -> 3527
    //   2907: lload 12
    //   2909: lstore 18
    //   2911: lload 12
    //   2913: lstore 20
    //   2915: aload 40
    //   2917: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2920: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   2923: invokestatic 218	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   2926: lconst_0
    //   2927: lstore 10
    //   2929: lload 10
    //   2931: lstore 18
    //   2933: lload 10
    //   2935: lstore 20
    //   2937: aload 40
    //   2939: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2942: invokevirtual 265	java/io/File:exists	()Z
    //   2945: ifeq +2025 -> 4970
    //   2948: lload 10
    //   2950: lstore 18
    //   2952: lload 10
    //   2954: lstore 20
    //   2956: aload 40
    //   2958: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2961: invokevirtual 221	java/io/File:delete	()Z
    //   2964: pop
    //   2965: aload 34
    //   2967: astore 35
    //   2969: aload 32
    //   2971: astore 34
    //   2973: aload 33
    //   2975: astore 32
    //   2977: iconst_0
    //   2978: istore 29
    //   2980: lload 8
    //   2982: lstore 16
    //   2984: lload 6
    //   2986: lstore 8
    //   2988: lload 14
    //   2990: lstore 12
    //   2992: lload 16
    //   2994: lstore 6
    //   2996: iload 4
    //   2998: iconst_1
    //   2999: iadd
    //   3000: istore 4
    //   3002: lload 10
    //   3004: lstore 20
    //   3006: lload 6
    //   3008: lstore 18
    //   3010: lload 12
    //   3012: lstore 14
    //   3014: lload 8
    //   3016: lstore 16
    //   3018: aload 35
    //   3020: astore 36
    //   3022: aload 34
    //   3024: astore 38
    //   3026: aload 32
    //   3028: astore 37
    //   3030: aload 40
    //   3032: getfield 138	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3035: invokevirtual 140	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3038: ifne +1277 -> 4315
    //   3041: iload 29
    //   3043: ifne +1272 -> 4315
    //   3046: lload 10
    //   3048: lstore 20
    //   3050: lload 6
    //   3052: lstore 18
    //   3054: lload 12
    //   3056: lstore 14
    //   3058: lload 8
    //   3060: lstore 16
    //   3062: aload 35
    //   3064: astore 36
    //   3066: aload 34
    //   3068: astore 38
    //   3070: aload 32
    //   3072: astore 37
    //   3074: aload 39
    //   3076: getfield 169	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   3079: ifeq +948 -> 4027
    //   3082: lload 10
    //   3084: lstore 20
    //   3086: lload 6
    //   3088: lstore 18
    //   3090: lload 12
    //   3092: lstore 14
    //   3094: lload 8
    //   3096: lstore 16
    //   3098: aload 35
    //   3100: astore 36
    //   3102: aload 34
    //   3104: astore 38
    //   3106: aload 32
    //   3108: astore 37
    //   3110: aload_0
    //   3111: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   3114: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   3117: iconst_0
    //   3118: putfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   3121: lload 10
    //   3123: lstore 20
    //   3125: lload 6
    //   3127: lstore 18
    //   3129: lload 12
    //   3131: lstore 14
    //   3133: lload 8
    //   3135: lstore 16
    //   3137: aload 35
    //   3139: astore 36
    //   3141: aload 34
    //   3143: astore 38
    //   3145: aload 32
    //   3147: astore 37
    //   3149: invokestatic 174	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3152: iconst_5
    //   3153: aload 39
    //   3155: getfield 176	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3158: invokevirtual 179	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3161: lload 10
    //   3163: lstore 20
    //   3165: lload 6
    //   3167: lstore 18
    //   3169: lload 12
    //   3171: lstore 14
    //   3173: lload 8
    //   3175: lstore 16
    //   3177: aload 35
    //   3179: astore 36
    //   3181: aload 34
    //   3183: astore 38
    //   3185: aload 32
    //   3187: astore 37
    //   3189: aload 39
    //   3191: getfield 176	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3194: aload 40
    //   3196: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3199: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   3202: iconst_m1
    //   3203: aload_0
    //   3204: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   3207: getfield 441	hjb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3210: invokestatic 444	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3213: lload 10
    //   3215: lstore 20
    //   3217: lload 6
    //   3219: lstore 18
    //   3221: lload 12
    //   3223: lstore 14
    //   3225: lload 8
    //   3227: lstore 16
    //   3229: aload 35
    //   3231: astore 36
    //   3233: aload 34
    //   3235: astore 38
    //   3237: aload 32
    //   3239: astore 37
    //   3241: iload 4
    //   3243: aload 40
    //   3245: getfield 447	com/tencent/mobileqq/vip/DownloadTask:l	I
    //   3248: if_icmpge +862 -> 4110
    //   3251: lload 10
    //   3253: lstore 20
    //   3255: lload 6
    //   3257: lstore 18
    //   3259: lload 12
    //   3261: lstore 14
    //   3263: lload 8
    //   3265: lstore 16
    //   3267: aload 35
    //   3269: astore 36
    //   3271: aload 34
    //   3273: astore 38
    //   3275: aload 32
    //   3277: astore 37
    //   3279: aload 42
    //   3281: monitorenter
    //   3282: aload 42
    //   3284: ldc2_w 448
    //   3287: invokevirtual 453	java/lang/Object:wait	(J)V
    //   3290: aload 42
    //   3292: monitorexit
    //   3293: iload 29
    //   3295: ifne +84 -> 3379
    //   3298: lload 10
    //   3300: lstore 20
    //   3302: lload 6
    //   3304: lstore 18
    //   3306: lload 12
    //   3308: lstore 14
    //   3310: lload 8
    //   3312: lstore 16
    //   3314: aload 35
    //   3316: astore 36
    //   3318: aload 34
    //   3320: astore 38
    //   3322: aload 32
    //   3324: astore 37
    //   3326: iload 4
    //   3328: aload 40
    //   3330: getfield 447	com/tencent/mobileqq/vip/DownloadTask:l	I
    //   3333: if_icmpge +46 -> 3379
    //   3336: lload 10
    //   3338: lstore 20
    //   3340: lload 6
    //   3342: lstore 18
    //   3344: lload 12
    //   3346: lstore 14
    //   3348: lload 8
    //   3350: lstore 16
    //   3352: aload 35
    //   3354: astore 36
    //   3356: aload 34
    //   3358: astore 38
    //   3360: aload 32
    //   3362: astore 37
    //   3364: aload 40
    //   3366: getfield 138	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3369: invokevirtual 140	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3372: istore 30
    //   3374: iload 30
    //   3376: ifeq +1684 -> 5060
    //   3379: aload 32
    //   3381: ifnull +10 -> 3391
    //   3384: aload 32
    //   3386: invokeinterface 200 1 0
    //   3391: aload 34
    //   3393: ifnull +8 -> 3401
    //   3396: aload 34
    //   3398: invokevirtual 205	java/io/InputStream:close	()V
    //   3401: aload 35
    //   3403: ifnull +8 -> 3411
    //   3406: aload 35
    //   3408: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   3411: lload 10
    //   3413: lconst_0
    //   3414: lcmp
    //   3415: ifeq +38 -> 3453
    //   3418: lload 6
    //   3420: lconst_0
    //   3421: lcmp
    //   3422: ifeq +31 -> 3453
    //   3425: lload 10
    //   3427: lload 6
    //   3429: lcmp
    //   3430: ifne +978 -> 4408
    //   3433: aload 40
    //   3435: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3438: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   3441: invokestatic 218	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   3444: aload 40
    //   3446: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3449: invokevirtual 221	java/io/File:delete	()Z
    //   3452: pop
    //   3453: aload_0
    //   3454: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   3457: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3460: ifnull +29 -> 3489
    //   3463: aload 41
    //   3465: ifnull +24 -> 3489
    //   3468: lload 8
    //   3470: lconst_0
    //   3471: lcmp
    //   3472: ifle +17 -> 3489
    //   3475: aload 41
    //   3477: aload_0
    //   3478: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   3481: getfield 224	hjb:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3484: lload 8
    //   3486: invokevirtual 227	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   3489: aload_0
    //   3490: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   3493: aload 40
    //   3495: invokestatic 84	hjb:a	(Lhjb;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3498: return
    //   3499: lload 10
    //   3501: lconst_0
    //   3502: lcmp
    //   3503: ifeq +14 -> 3517
    //   3506: lload 10
    //   3508: lload 8
    //   3510: lload 22
    //   3512: ladd
    //   3513: lcmp
    //   3514: ifeq +1490 -> 5004
    //   3517: lload 22
    //   3519: lstore 8
    //   3521: lconst_0
    //   3522: lstore 12
    //   3524: goto -726 -> 2798
    //   3527: lload 12
    //   3529: lstore 18
    //   3531: lload 12
    //   3533: lstore 20
    //   3535: new 207	java/io/RandomAccessFile
    //   3538: dup
    //   3539: aload 40
    //   3541: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3544: ldc_w 455
    //   3547: invokespecial 458	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3550: astore 35
    //   3552: aload 35
    //   3554: lload 8
    //   3556: invokevirtual 461	java/io/RandomAccessFile:setLength	(J)V
    //   3559: aload 35
    //   3561: lload 12
    //   3563: invokevirtual 464	java/io/RandomAccessFile:seek	(J)V
    //   3566: aload 33
    //   3568: invokeinterface 468 1 0
    //   3573: astore 34
    //   3575: iload_2
    //   3576: newarray byte
    //   3578: astore 32
    //   3580: lload 6
    //   3582: lstore 10
    //   3584: lload 12
    //   3586: lstore 6
    //   3588: lload 10
    //   3590: lstore 16
    //   3592: lload 6
    //   3594: lstore 12
    //   3596: lload 10
    //   3598: lstore 24
    //   3600: lload 6
    //   3602: lstore 18
    //   3604: aload 40
    //   3606: getfield 138	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3609: invokevirtual 140	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3612: ifne +171 -> 3783
    //   3615: lload 6
    //   3617: lload 8
    //   3619: lcmp
    //   3620: ifge +163 -> 3783
    //   3623: lload 10
    //   3625: lstore 16
    //   3627: lload 6
    //   3629: lstore 12
    //   3631: lload 10
    //   3633: lstore 24
    //   3635: lload 6
    //   3637: lstore 18
    //   3639: aload 34
    //   3641: aload 32
    //   3643: invokevirtual 472	java/io/InputStream:read	([B)I
    //   3646: istore_3
    //   3647: lload 10
    //   3649: iload_3
    //   3650: i2l
    //   3651: ladd
    //   3652: lstore 20
    //   3654: lload 6
    //   3656: iload_3
    //   3657: i2l
    //   3658: ladd
    //   3659: lstore 22
    //   3661: lload 20
    //   3663: lstore 16
    //   3665: lload 22
    //   3667: lstore 12
    //   3669: lload 20
    //   3671: lstore 24
    //   3673: lload 22
    //   3675: lstore 18
    //   3677: aload 35
    //   3679: aload 32
    //   3681: iconst_0
    //   3682: iload_3
    //   3683: invokevirtual 476	java/io/RandomAccessFile:write	([BII)V
    //   3686: lload 20
    //   3688: lstore 10
    //   3690: lload 22
    //   3692: lstore 6
    //   3694: aload 41
    //   3696: ifnull -108 -> 3588
    //   3699: lload 20
    //   3701: lstore 16
    //   3703: lload 22
    //   3705: lstore 12
    //   3707: lload 20
    //   3709: lstore 24
    //   3711: lload 22
    //   3713: lstore 18
    //   3715: aload 40
    //   3717: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3720: iconst_2
    //   3721: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   3724: lload 20
    //   3726: lstore 16
    //   3728: lload 22
    //   3730: lstore 12
    //   3732: lload 20
    //   3734: lstore 24
    //   3736: lload 22
    //   3738: lstore 18
    //   3740: aload 40
    //   3742: lload 8
    //   3744: lload 22
    //   3746: invokevirtual 479	com/tencent/mobileqq/vip/DownloadTask:a	(JJ)V
    //   3749: lload 20
    //   3751: lstore 16
    //   3753: lload 22
    //   3755: lstore 12
    //   3757: lload 20
    //   3759: lstore 24
    //   3761: lload 22
    //   3763: lstore 18
    //   3765: aload 41
    //   3767: aload 40
    //   3769: invokevirtual 481	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3772: lload 20
    //   3774: lstore 10
    //   3776: lload 22
    //   3778: lstore 6
    //   3780: goto -192 -> 3588
    //   3783: lload 6
    //   3785: lload 8
    //   3787: lcmp
    //   3788: ifne +233 -> 4021
    //   3791: aload 41
    //   3793: ifnull +1422 -> 5215
    //   3796: lload 10
    //   3798: lstore 16
    //   3800: lload 6
    //   3802: lstore 12
    //   3804: lload 10
    //   3806: lstore 24
    //   3808: lload 6
    //   3810: lstore 18
    //   3812: aload 40
    //   3814: ldc_w 482
    //   3817: putfield 485	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Float	F
    //   3820: lload 10
    //   3822: lstore 16
    //   3824: lload 6
    //   3826: lstore 12
    //   3828: lload 10
    //   3830: lstore 24
    //   3832: lload 6
    //   3834: lstore 18
    //   3836: aload 40
    //   3838: getfield 73	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3841: iconst_3
    //   3842: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   3845: lload 10
    //   3847: lstore 16
    //   3849: lload 6
    //   3851: lstore 12
    //   3853: lload 10
    //   3855: lstore 24
    //   3857: lload 6
    //   3859: lstore 18
    //   3861: aload 41
    //   3863: aload 40
    //   3865: invokevirtual 81	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3868: goto +1347 -> 5215
    //   3871: lload 10
    //   3873: lstore 16
    //   3875: lload 6
    //   3877: lstore 12
    //   3879: lload 10
    //   3881: lstore 24
    //   3883: lload 6
    //   3885: lstore 18
    //   3887: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3890: ifeq +76 -> 3966
    //   3893: lload 10
    //   3895: lstore 16
    //   3897: lload 6
    //   3899: lstore 12
    //   3901: lload 10
    //   3903: lstore 24
    //   3905: lload 6
    //   3907: lstore 18
    //   3909: getstatic 116	hjb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3912: iconst_2
    //   3913: new 118	java/lang/StringBuilder
    //   3916: dup
    //   3917: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   3920: ldc_w 487
    //   3923: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3926: iload 29
    //   3928: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3931: ldc_w 489
    //   3934: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3937: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   3940: lload 26
    //   3942: lsub
    //   3943: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3946: ldc_w 491
    //   3949: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3952: aload 40
    //   3954: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3957: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3960: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3963: invokestatic 494	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3966: lload 10
    //   3968: lstore 16
    //   3970: lload 6
    //   3972: lstore 12
    //   3974: lload 10
    //   3976: lstore 24
    //   3978: lload 6
    //   3980: lstore 18
    //   3982: aload 40
    //   3984: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3987: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   3990: invokevirtual 498	java/io/File:setLastModified	(J)Z
    //   3993: pop
    //   3994: aload 33
    //   3996: astore 32
    //   3998: lload 10
    //   4000: lstore 16
    //   4002: lload 6
    //   4004: lstore 10
    //   4006: lload 8
    //   4008: lstore 6
    //   4010: lload 14
    //   4012: lstore 12
    //   4014: lload 16
    //   4016: lstore 8
    //   4018: goto -1022 -> 2996
    //   4021: iconst_0
    //   4022: istore 29
    //   4024: goto -153 -> 3871
    //   4027: lload 10
    //   4029: lstore 20
    //   4031: lload 6
    //   4033: lstore 18
    //   4035: lload 12
    //   4037: lstore 14
    //   4039: lload 8
    //   4041: lstore 16
    //   4043: aload 35
    //   4045: astore 36
    //   4047: aload 34
    //   4049: astore 38
    //   4051: aload 32
    //   4053: astore 37
    //   4055: aload_0
    //   4056: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4059: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4062: iconst_1
    //   4063: putfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   4066: goto -853 -> 3213
    //   4069: astore 33
    //   4071: goto -3556 -> 515
    //   4074: astore 33
    //   4076: aload 42
    //   4078: monitorexit
    //   4079: lload 10
    //   4081: lstore 20
    //   4083: lload 6
    //   4085: lstore 18
    //   4087: lload 12
    //   4089: lstore 14
    //   4091: lload 8
    //   4093: lstore 16
    //   4095: aload 35
    //   4097: astore 36
    //   4099: aload 34
    //   4101: astore 38
    //   4103: aload 32
    //   4105: astore 37
    //   4107: aload 33
    //   4109: athrow
    //   4110: lload 10
    //   4112: lstore 20
    //   4114: lload 6
    //   4116: lstore 18
    //   4118: lload 12
    //   4120: lstore 14
    //   4122: lload 8
    //   4124: lstore 16
    //   4126: aload 35
    //   4128: astore 36
    //   4130: aload 34
    //   4132: astore 38
    //   4134: aload 32
    //   4136: astore 37
    //   4138: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   4141: ldc2_w 100
    //   4144: ldiv
    //   4145: l2i
    //   4146: istore_2
    //   4147: lload 10
    //   4149: lstore 20
    //   4151: lload 6
    //   4153: lstore 18
    //   4155: lload 12
    //   4157: lstore 14
    //   4159: lload 8
    //   4161: lstore 16
    //   4163: aload 35
    //   4165: astore 36
    //   4167: aload 34
    //   4169: astore 38
    //   4171: aload 32
    //   4173: astore 37
    //   4175: aload_0
    //   4176: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4179: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4182: getfield 87	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_Boolean	Z
    //   4185: ifeq +51 -> 4236
    //   4188: lload 10
    //   4190: lstore 20
    //   4192: lload 6
    //   4194: lstore 18
    //   4196: lload 12
    //   4198: lstore 14
    //   4200: lload 8
    //   4202: lstore 16
    //   4204: aload 35
    //   4206: astore 36
    //   4208: aload 34
    //   4210: astore 38
    //   4212: aload 32
    //   4214: astore 37
    //   4216: aload_0
    //   4217: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4220: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4223: aload 40
    //   4225: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4228: iload_2
    //   4229: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4232: invokevirtual 502	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4235: pop
    //   4236: lload 10
    //   4238: lstore 20
    //   4240: lload 6
    //   4242: lstore 18
    //   4244: lload 12
    //   4246: lstore 14
    //   4248: lload 8
    //   4250: lstore 16
    //   4252: aload 35
    //   4254: astore 36
    //   4256: aload 34
    //   4258: astore 38
    //   4260: aload 32
    //   4262: astore 37
    //   4264: new 163	java/lang/Exception
    //   4267: dup
    //   4268: new 118	java/lang/StringBuilder
    //   4271: dup
    //   4272: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   4275: ldc_w 504
    //   4278: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4281: aload 40
    //   4283: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4286: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4289: ldc_w 506
    //   4292: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4295: aload_0
    //   4296: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4299: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4302: getfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   4305: invokevirtual 365	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4308: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4311: invokespecial 168	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4314: athrow
    //   4315: lload 10
    //   4317: lstore 20
    //   4319: lload 6
    //   4321: lstore 18
    //   4323: lload 12
    //   4325: lstore 14
    //   4327: lload 8
    //   4329: lstore 16
    //   4331: aload 35
    //   4333: astore 36
    //   4335: aload 34
    //   4337: astore 38
    //   4339: aload 32
    //   4341: astore 37
    //   4343: aload_0
    //   4344: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4347: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4350: aload 40
    //   4352: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4355: invokevirtual 509	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   4358: ifeq -1065 -> 3293
    //   4361: lload 10
    //   4363: lstore 20
    //   4365: lload 6
    //   4367: lstore 18
    //   4369: lload 12
    //   4371: lstore 14
    //   4373: lload 8
    //   4375: lstore 16
    //   4377: aload 35
    //   4379: astore 36
    //   4381: aload 34
    //   4383: astore 38
    //   4385: aload 32
    //   4387: astore 37
    //   4389: aload_0
    //   4390: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4393: invokestatic 90	hjb:a	(Lhjb;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4396: aload 40
    //   4398: getfield 147	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4401: invokevirtual 109	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4404: pop
    //   4405: goto -1112 -> 3293
    //   4408: aload 40
    //   4410: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4413: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   4416: lload 10
    //   4418: lload 6
    //   4420: lload 12
    //   4422: invokestatic 512	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4425: goto -972 -> 3453
    //   4428: lload 10
    //   4430: lstore 20
    //   4432: lload 6
    //   4434: lstore 18
    //   4436: lload 12
    //   4438: lstore 14
    //   4440: lload 8
    //   4442: lstore 16
    //   4444: aload 35
    //   4446: astore 36
    //   4448: aload 34
    //   4450: astore 38
    //   4452: aload 32
    //   4454: astore 37
    //   4456: aload_0
    //   4457: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4460: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4463: iconst_0
    //   4464: putfield 187	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_c_of_type_Boolean	Z
    //   4467: goto -3674 -> 793
    //   4470: lload 10
    //   4472: lstore 20
    //   4474: lload 6
    //   4476: lstore 18
    //   4478: lload 12
    //   4480: lstore 14
    //   4482: lload 8
    //   4484: lstore 16
    //   4486: aload 35
    //   4488: astore 36
    //   4490: aload 34
    //   4492: astore 38
    //   4494: aload 32
    //   4496: astore 37
    //   4498: aload_0
    //   4499: getfield 13	hjc:jdField_a_of_type_Hjb	Lhjb;
    //   4502: invokestatic 60	hjb:a	(Lhjb;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4505: iconst_1
    //   4506: putfield 189	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   4509: goto -3641 -> 868
    //   4512: aload 40
    //   4514: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4517: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   4520: lload 10
    //   4522: lload 6
    //   4524: lload 12
    //   4526: invokestatic 512	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4529: goto -3416 -> 1113
    //   4532: aload 40
    //   4534: getfield 211	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4537: invokevirtual 216	java/io/File:getName	()Ljava/lang/String;
    //   4540: lload 12
    //   4542: lload 6
    //   4544: lload 14
    //   4546: invokestatic 512	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4549: goto -2799 -> 1750
    //   4552: astore 33
    //   4554: goto -1264 -> 3290
    //   4557: astore 32
    //   4559: goto -2851 -> 1708
    //   4562: astore 32
    //   4564: aload 35
    //   4566: astore 36
    //   4568: aload 34
    //   4570: astore 37
    //   4572: lload 8
    //   4574: lstore 6
    //   4576: lload 16
    //   4578: lstore 8
    //   4580: aload 32
    //   4582: astore 35
    //   4584: aload 36
    //   4586: astore 34
    //   4588: aload 37
    //   4590: astore 32
    //   4592: goto -2916 -> 1676
    //   4595: astore 35
    //   4597: lload 8
    //   4599: lstore 12
    //   4601: lload 6
    //   4603: lstore 8
    //   4605: lload 10
    //   4607: lstore 6
    //   4609: aload 36
    //   4611: astore 33
    //   4613: goto -2937 -> 1676
    //   4616: astore 35
    //   4618: lload 8
    //   4620: lstore 10
    //   4622: lload 6
    //   4624: lstore 8
    //   4626: lload 18
    //   4628: lstore 12
    //   4630: lload 10
    //   4632: lstore 6
    //   4634: goto -2958 -> 1676
    //   4637: astore 34
    //   4639: aload 35
    //   4641: astore 36
    //   4643: lload 6
    //   4645: lstore 10
    //   4647: lload 8
    //   4649: lstore 6
    //   4651: aload 34
    //   4653: astore 35
    //   4655: lload 10
    //   4657: lstore 8
    //   4659: aload 36
    //   4661: astore 34
    //   4663: goto -2987 -> 1676
    //   4666: astore 32
    //   4668: aload 35
    //   4670: astore 36
    //   4672: aload 34
    //   4674: astore 37
    //   4676: lload 8
    //   4678: lstore 10
    //   4680: lload 6
    //   4682: lstore 8
    //   4684: lload 10
    //   4686: lstore 6
    //   4688: aload 32
    //   4690: astore 35
    //   4692: aload 36
    //   4694: astore 34
    //   4696: aload 37
    //   4698: astore 32
    //   4700: goto -3024 -> 1676
    //   4703: astore 32
    //   4705: goto -3634 -> 1071
    //   4708: astore 33
    //   4710: aconst_null
    //   4711: astore 39
    //   4713: lconst_0
    //   4714: lstore 10
    //   4716: aconst_null
    //   4717: astore 35
    //   4719: aconst_null
    //   4720: astore 34
    //   4722: aconst_null
    //   4723: astore 32
    //   4725: lconst_0
    //   4726: lstore 8
    //   4728: lconst_0
    //   4729: lstore 12
    //   4731: iconst_0
    //   4732: istore 28
    //   4734: iconst_0
    //   4735: istore_1
    //   4736: lconst_0
    //   4737: lstore 6
    //   4739: goto -4224 -> 515
    //   4742: astore 35
    //   4744: iload 31
    //   4746: istore 28
    //   4748: lload 8
    //   4750: lstore 12
    //   4752: aload 33
    //   4754: astore 36
    //   4756: lload 10
    //   4758: lstore 16
    //   4760: lload 6
    //   4762: lstore 8
    //   4764: aload 35
    //   4766: astore 33
    //   4768: lload 12
    //   4770: lstore 10
    //   4772: lload 16
    //   4774: lstore 6
    //   4776: lload 14
    //   4778: lstore 12
    //   4780: aload 34
    //   4782: astore 35
    //   4784: aload 32
    //   4786: astore 34
    //   4788: aload 36
    //   4790: astore 32
    //   4792: goto -4277 -> 515
    //   4795: astore 35
    //   4797: iload_3
    //   4798: istore_1
    //   4799: lload 8
    //   4801: lstore 12
    //   4803: aload 33
    //   4805: astore 36
    //   4807: lload 10
    //   4809: lstore 16
    //   4811: lload 6
    //   4813: lstore 8
    //   4815: aload 35
    //   4817: astore 33
    //   4819: lload 12
    //   4821: lstore 10
    //   4823: lload 16
    //   4825: lstore 6
    //   4827: lload 14
    //   4829: lstore 12
    //   4831: aload 34
    //   4833: astore 35
    //   4835: aload 32
    //   4837: astore 34
    //   4839: aload 36
    //   4841: astore 32
    //   4843: goto -4328 -> 515
    //   4846: astore 35
    //   4848: aload 33
    //   4850: astore 36
    //   4852: lload 6
    //   4854: lstore 16
    //   4856: lload 8
    //   4858: lstore 6
    //   4860: aload 35
    //   4862: astore 33
    //   4864: lload 20
    //   4866: lstore 10
    //   4868: lload 14
    //   4870: lstore 12
    //   4872: lload 16
    //   4874: lstore 8
    //   4876: aload 34
    //   4878: astore 35
    //   4880: aload 32
    //   4882: astore 34
    //   4884: aload 36
    //   4886: astore 32
    //   4888: goto -4373 -> 515
    //   4891: astore 34
    //   4893: aload 33
    //   4895: astore 36
    //   4897: lload 8
    //   4899: lstore 16
    //   4901: lload 6
    //   4903: lstore 8
    //   4905: aload 34
    //   4907: astore 33
    //   4909: lload 12
    //   4911: lstore 10
    //   4913: lload 16
    //   4915: lstore 6
    //   4917: lload 14
    //   4919: lstore 12
    //   4921: aload 32
    //   4923: astore 34
    //   4925: aload 36
    //   4927: astore 32
    //   4929: goto -4414 -> 515
    //   4932: astore 36
    //   4934: aload 33
    //   4936: astore 32
    //   4938: lload 6
    //   4940: lstore 16
    //   4942: lload 8
    //   4944: lstore 6
    //   4946: aload 36
    //   4948: astore 33
    //   4950: lload 12
    //   4952: lstore 10
    //   4954: lload 14
    //   4956: lstore 12
    //   4958: lload 16
    //   4960: lstore 8
    //   4962: goto -4447 -> 515
    //   4965: astore 32
    //   4967: goto -1556 -> 3411
    //   4970: iconst_0
    //   4971: istore 29
    //   4973: lload 8
    //   4975: lstore 12
    //   4977: lload 6
    //   4979: lstore 8
    //   4981: lload 12
    //   4983: lstore 6
    //   4985: lload 14
    //   4987: lstore 12
    //   4989: aload 34
    //   4991: astore 35
    //   4993: aload 32
    //   4995: astore 34
    //   4997: aload 33
    //   4999: astore 32
    //   5001: goto -2005 -> 2996
    //   5004: lload 8
    //   5006: lstore 12
    //   5008: lload 10
    //   5010: lstore 8
    //   5012: goto -2214 -> 2798
    //   5015: lload 8
    //   5017: lstore 12
    //   5019: iload 30
    //   5021: istore 29
    //   5023: lload 6
    //   5025: lstore 8
    //   5027: lload 10
    //   5029: lstore 6
    //   5031: lload 12
    //   5033: lstore 10
    //   5035: lload 14
    //   5037: lstore 12
    //   5039: aload 34
    //   5041: astore 35
    //   5043: aload 32
    //   5045: astore 34
    //   5047: aload 33
    //   5049: astore 32
    //   5051: goto -2055 -> 2996
    //   5054: iload_3
    //   5055: istore 5
    //   5057: goto -2668 -> 2389
    //   5060: aload 32
    //   5062: astore 33
    //   5064: iload 29
    //   5066: istore 30
    //   5068: aload 34
    //   5070: astore 32
    //   5072: lload 10
    //   5074: lstore 16
    //   5076: iconst_1
    //   5077: istore_1
    //   5078: lload 6
    //   5080: lstore 10
    //   5082: iload 28
    //   5084: istore 29
    //   5086: lload 8
    //   5088: lstore 6
    //   5090: lload 12
    //   5092: lstore 14
    //   5094: lload 16
    //   5096: lstore 8
    //   5098: aload 35
    //   5100: astore 34
    //   5102: goto -3165 -> 1937
    //   5105: return
    //   5106: iconst_1
    //   5107: istore_2
    //   5108: goto -4367 -> 741
    //   5111: sipush 200
    //   5114: iload_3
    //   5115: if_icmpeq -2473 -> 2642
    //   5118: sipush 206
    //   5121: iload_3
    //   5122: if_icmpne -107 -> 5015
    //   5125: goto -2483 -> 2642
    //   5128: astore 33
    //   5130: lload 8
    //   5132: lstore 12
    //   5134: aload 35
    //   5136: astore 36
    //   5138: lload 10
    //   5140: lstore 16
    //   5142: lload 6
    //   5144: lstore 8
    //   5146: lload 12
    //   5148: lstore 10
    //   5150: lload 16
    //   5152: lstore 6
    //   5154: lload 14
    //   5156: lstore 12
    //   5158: aload 34
    //   5160: astore 35
    //   5162: aload 32
    //   5164: astore 34
    //   5166: aload 36
    //   5168: astore 32
    //   5170: goto -4655 -> 515
    //   5173: sipush 4096
    //   5176: istore_2
    //   5177: iconst_0
    //   5178: istore 28
    //   5180: aconst_null
    //   5181: astore 35
    //   5183: goto -2794 -> 2389
    //   5186: astore 36
    //   5188: aload 33
    //   5190: astore 32
    //   5192: lload 18
    //   5194: lstore 10
    //   5196: lload 8
    //   5198: lstore 6
    //   5200: aload 36
    //   5202: astore 33
    //   5204: lload 14
    //   5206: lstore 12
    //   5208: lload 24
    //   5210: lstore 8
    //   5212: goto -4697 -> 515
    //   5215: iconst_1
    //   5216: istore 29
    //   5218: goto -1347 -> 3871
    //   5221: astore 35
    //   5223: aload 38
    //   5225: astore 32
    //   5227: aload 37
    //   5229: astore 33
    //   5231: aload 36
    //   5233: astore 34
    //   5235: lload 20
    //   5237: lstore 12
    //   5239: lload 18
    //   5241: lstore 6
    //   5243: lload 16
    //   5245: lstore 8
    //   5247: goto -3571 -> 1676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5250	0	this	hjc
    //   176	4902	1	i	int
    //   629	4548	2	j	int
    //   2168	2955	3	k	int
    //   1905	1429	4	m	int
    //   2165	2891	5	n	int
    //   402	4840	6	l1	long
    //   356	4890	8	l2	long
    //   374	4821	10	l3	long
    //   398	4840	12	l4	long
    //   394	4811	14	l5	long
    //   366	4878	16	l6	long
    //   359	4881	18	l7	long
    //   370	4866	20	l8	long
    //   362	3415	22	l9	long
    //   1477	3732	24	l10	long
    //   1223	2718	26	l11	long
    //   503	4676	28	bool1	boolean
    //   1914	3303	29	bool2	boolean
    //   1908	3159	30	bool3	boolean
    //   1943	2802	31	bool4	boolean
    //   7	4488	32	localObject1	Object
    //   4557	1	32	localIOException1	java.io.IOException
    //   4562	19	32	localObject2	Object
    //   4590	1	32	localObject3	Object
    //   4666	23	32	localObject4	Object
    //   4698	1	32	localObject5	Object
    //   4703	1	32	localIOException2	java.io.IOException
    //   4723	214	32	localObject6	Object
    //   4965	29	32	localIOException3	java.io.IOException
    //   4999	227	32	localObject7	Object
    //   40	6	33	localObject8	Object
    //   484	474	33	localThrowable1	java.lang.Throwable
    //   1653	2342	33	localHttpEntity	org.apache.http.HttpEntity
    //   4069	1	33	localThrowable2	java.lang.Throwable
    //   4074	34	33	localObject9	Object
    //   4552	1	33	localInterruptedException	java.lang.InterruptedException
    //   4611	1	33	localObject10	Object
    //   4708	45	33	localThrowable3	java.lang.Throwable
    //   4766	297	33	localObject11	Object
    //   5128	61	33	localThrowable4	java.lang.Throwable
    //   5202	28	33	localObject12	Object
    //   494	4093	34	localObject13	Object
    //   4637	15	34	localObject14	Object
    //   4661	222	34	localObject15	Object
    //   4891	15	34	localThrowable5	java.lang.Throwable
    //   4923	311	34	localObject16	Object
    //   491	576	35	localObject17	Object
    //   1650	146	35	localObject18	Object
    //   2162	2421	35	localObject19	Object
    //   4595	1	35	localObject20	Object
    //   4616	24	35	localObject21	Object
    //   4653	65	35	localObject22	Object
    //   4742	23	35	localThrowable6	java.lang.Throwable
    //   4782	1	35	localObject23	Object
    //   4795	21	35	localThrowable7	java.lang.Throwable
    //   4833	1	35	localObject24	Object
    //   4846	15	35	localThrowable8	java.lang.Throwable
    //   4878	304	35	localObject25	Object
    //   5221	1	35	localObject26	Object
    //   533	4393	36	localObject27	Object
    //   4932	15	36	localThrowable9	java.lang.Throwable
    //   5136	31	36	localObject28	Object
    //   5186	46	36	localThrowable10	java.lang.Throwable
    //   541	4687	37	localObject29	Object
    //   537	4687	38	localObject30	Object
    //   390	4322	39	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   29	4504	40	localDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   62	3800	41	localDownloadListener	com.tencent.mobileqq.vip.DownloadListener
    //   353	3724	42	localObject31	Object
    //   422	1756	43	localNetworkInfo	android.net.NetworkInfo
    //   1261	1300	44	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1294	1122	45	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   12	34	40	finally
    //   42	45	40	finally
    //   416	424	484	java/lang/Throwable
    //   453	484	484	java/lang/Throwable
    //   1183	1196	484	java/lang/Throwable
    //   1220	1225	484	java/lang/Throwable
    //   1249	1263	484	java/lang/Throwable
    //   1287	1296	484	java/lang/Throwable
    //   1320	1335	484	java/lang/Throwable
    //   1359	1374	484	java/lang/Throwable
    //   1398	1410	484	java/lang/Throwable
    //   1434	1447	484	java/lang/Throwable
    //   1503	1513	484	java/lang/Throwable
    //   1550	1558	484	java/lang/Throwable
    //   1586	1594	484	java/lang/Throwable
    //   1618	1650	484	java/lang/Throwable
    //   1822	1828	484	java/lang/Throwable
    //   1852	1902	484	java/lang/Throwable
    //   376	392	1650	finally
    //   416	424	1650	finally
    //   453	484	1650	finally
    //   1183	1196	1650	finally
    //   1220	1225	1650	finally
    //   1249	1263	1650	finally
    //   1287	1296	1650	finally
    //   1320	1335	1650	finally
    //   1359	1374	1650	finally
    //   1398	1410	1650	finally
    //   1434	1447	1650	finally
    //   1503	1513	1650	finally
    //   1550	1558	1650	finally
    //   1586	1594	1650	finally
    //   1618	1650	1650	finally
    //   1822	1828	1650	finally
    //   1852	1902	1650	finally
    //   3030	3041	4069	java/lang/Throwable
    //   3074	3082	4069	java/lang/Throwable
    //   3110	3121	4069	java/lang/Throwable
    //   3149	3161	4069	java/lang/Throwable
    //   3189	3213	4069	java/lang/Throwable
    //   3241	3251	4069	java/lang/Throwable
    //   3279	3282	4069	java/lang/Throwable
    //   3326	3336	4069	java/lang/Throwable
    //   3364	3374	4069	java/lang/Throwable
    //   4055	4066	4069	java/lang/Throwable
    //   4107	4110	4069	java/lang/Throwable
    //   4138	4147	4069	java/lang/Throwable
    //   4175	4188	4069	java/lang/Throwable
    //   4216	4236	4069	java/lang/Throwable
    //   4264	4315	4069	java/lang/Throwable
    //   4343	4361	4069	java/lang/Throwable
    //   4389	4405	4069	java/lang/Throwable
    //   3282	3290	4074	finally
    //   3290	3293	4074	finally
    //   4076	4079	4074	finally
    //   3282	3290	4552	java/lang/InterruptedException
    //   1681	1688	4557	java/io/IOException
    //   1693	1698	4557	java/io/IOException
    //   1703	1708	4557	java/io/IOException
    //   3604	3615	4562	finally
    //   3639	3647	4562	finally
    //   3677	3686	4562	finally
    //   3715	3724	4562	finally
    //   3740	3749	4562	finally
    //   3765	3772	4562	finally
    //   3812	3820	4562	finally
    //   3836	3845	4562	finally
    //   3861	3868	4562	finally
    //   3887	3893	4562	finally
    //   3909	3966	4562	finally
    //   3982	3994	4562	finally
    //   1945	1980	4595	finally
    //   1988	1993	4595	finally
    //   2001	2007	4595	finally
    //   2015	2028	4595	finally
    //   2036	2041	4595	finally
    //   2049	2057	4595	finally
    //   2065	2078	4595	finally
    //   2086	2096	4595	finally
    //   2104	2122	4595	finally
    //   2130	2141	4595	finally
    //   2149	2161	4595	finally
    //   2177	2185	4595	finally
    //   2197	2210	4595	finally
    //   2218	2223	4595	finally
    //   2231	2236	4595	finally
    //   2276	2298	4595	finally
    //   2316	2327	4595	finally
    //   2335	2346	4595	finally
    //   2354	2365	4595	finally
    //   2373	2386	4595	finally
    //   2395	2407	4595	finally
    //   2413	2420	4595	finally
    //   2426	2432	4595	finally
    //   2438	2551	4595	finally
    //   2557	2567	4595	finally
    //   2577	2590	4595	finally
    //   2598	2604	4595	finally
    //   2612	2639	4595	finally
    //   2650	2659	4595	finally
    //   2667	2676	4595	finally
    //   2691	2723	4595	finally
    //   2734	2747	4595	finally
    //   2755	2775	4595	finally
    //   2806	2812	4616	finally
    //   2820	2892	4616	finally
    //   2915	2926	4616	finally
    //   2937	2948	4616	finally
    //   2956	2965	4616	finally
    //   3535	3552	4616	finally
    //   3552	3575	4637	finally
    //   3575	3580	4666	finally
    //   1044	1051	4703	java/io/IOException
    //   1056	1061	4703	java/io/IOException
    //   1066	1071	4703	java/io/IOException
    //   376	392	4708	java/lang/Throwable
    //   1945	1980	4742	java/lang/Throwable
    //   1988	1993	4742	java/lang/Throwable
    //   2001	2007	4742	java/lang/Throwable
    //   2015	2028	4742	java/lang/Throwable
    //   2036	2041	4742	java/lang/Throwable
    //   2049	2057	4742	java/lang/Throwable
    //   2065	2078	4742	java/lang/Throwable
    //   2086	2096	4742	java/lang/Throwable
    //   2104	2122	4742	java/lang/Throwable
    //   2130	2141	4742	java/lang/Throwable
    //   2149	2161	4742	java/lang/Throwable
    //   2177	2185	4742	java/lang/Throwable
    //   2197	2210	4742	java/lang/Throwable
    //   2218	2223	4742	java/lang/Throwable
    //   2231	2236	4742	java/lang/Throwable
    //   2276	2298	4742	java/lang/Throwable
    //   2316	2327	4742	java/lang/Throwable
    //   2335	2346	4742	java/lang/Throwable
    //   2354	2365	4742	java/lang/Throwable
    //   2373	2386	4742	java/lang/Throwable
    //   2395	2407	4795	java/lang/Throwable
    //   2413	2420	4795	java/lang/Throwable
    //   2426	2432	4795	java/lang/Throwable
    //   2438	2551	4795	java/lang/Throwable
    //   2557	2567	4795	java/lang/Throwable
    //   2806	2812	4846	java/lang/Throwable
    //   2820	2892	4846	java/lang/Throwable
    //   2915	2926	4846	java/lang/Throwable
    //   2937	2948	4846	java/lang/Throwable
    //   2956	2965	4846	java/lang/Throwable
    //   3535	3552	4846	java/lang/Throwable
    //   3552	3575	4891	java/lang/Throwable
    //   3575	3580	4932	java/lang/Throwable
    //   3384	3391	4965	java/io/IOException
    //   3396	3401	4965	java/io/IOException
    //   3406	3411	4965	java/io/IOException
    //   2577	2590	5128	java/lang/Throwable
    //   2598	2604	5128	java/lang/Throwable
    //   2612	2639	5128	java/lang/Throwable
    //   2650	2659	5128	java/lang/Throwable
    //   2667	2676	5128	java/lang/Throwable
    //   2691	2723	5128	java/lang/Throwable
    //   2734	2747	5128	java/lang/Throwable
    //   2755	2775	5128	java/lang/Throwable
    //   3604	3615	5186	java/lang/Throwable
    //   3639	3647	5186	java/lang/Throwable
    //   3677	3686	5186	java/lang/Throwable
    //   3715	3724	5186	java/lang/Throwable
    //   3740	3749	5186	java/lang/Throwable
    //   3765	3772	5186	java/lang/Throwable
    //   3812	3820	5186	java/lang/Throwable
    //   3836	3845	5186	java/lang/Throwable
    //   3861	3868	5186	java/lang/Throwable
    //   3887	3893	5186	java/lang/Throwable
    //   3909	3966	5186	java/lang/Throwable
    //   3982	3994	5186	java/lang/Throwable
    //   543	551	5221	finally
    //   579	584	5221	finally
    //   617	628	5221	finally
    //   658	666	5221	finally
    //   694	702	5221	finally
    //   730	738	5221	finally
    //   782	793	5221	finally
    //   821	829	5221	finally
    //   857	868	5221	finally
    //   896	902	5221	finally
    //   930	962	5221	finally
    //   995	1004	5221	finally
    //   1032	1039	5221	finally
    //   3030	3041	5221	finally
    //   3074	3082	5221	finally
    //   3110	3121	5221	finally
    //   3149	3161	5221	finally
    //   3189	3213	5221	finally
    //   3241	3251	5221	finally
    //   3279	3282	5221	finally
    //   3326	3336	5221	finally
    //   3364	3374	5221	finally
    //   4055	4066	5221	finally
    //   4107	4110	5221	finally
    //   4138	4147	5221	finally
    //   4175	4188	5221	finally
    //   4216	4236	5221	finally
    //   4264	4315	5221	finally
    //   4343	4361	5221	finally
    //   4389	4405	5221	finally
    //   4456	4467	5221	finally
    //   4498	4509	5221	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hjc
 * JD-Core Version:    0.7.0.1
 */