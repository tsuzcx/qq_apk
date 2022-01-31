class hje
  implements Runnable
{
  hje(hjd paramhjd) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	hje:a	Lhjd;
    //   4: invokestatic 28	hjd:a	(Lhjd;)Ljava/util/LinkedList;
    //   7: astore 32
    //   9: aload 32
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 12	hje:a	Lhjd;
    //   16: invokestatic 28	hjd:a	(Lhjd;)Ljava/util/LinkedList;
    //   19: invokevirtual 34	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   22: checkcast 36	com/tencent/mobileqq/vip/DownloadTask
    //   25: astore 40
    //   27: aload 32
    //   29: monitorexit
    //   30: aload 40
    //   32: ifnonnull +19 -> 51
    //   35: aload_0
    //   36: getfield 12	hje:a	Lhjd;
    //   39: invokestatic 38	hjd:a	(Lhjd;)V
    //   42: return
    //   43: astore 33
    //   45: aload 32
    //   47: monitorexit
    //   48: aload 33
    //   50: athrow
    //   51: aload 40
    //   53: getfield 42	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   56: iconst_1
    //   57: invokevirtual 48	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   60: aload 40
    //   62: invokevirtual 51	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   65: astore 41
    //   67: aload 41
    //   69: ifnull +11 -> 80
    //   72: aload 41
    //   74: aload 40
    //   76: invokevirtual 56	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/mobileqq/vip/DownloadTask;)Z
    //   79: pop
    //   80: aload_0
    //   81: getfield 12	hje:a	Lhjd;
    //   84: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   87: getfield 64	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_Boolean	Z
    //   90: ifeq +123 -> 213
    //   93: aload_0
    //   94: getfield 12	hje:a	Lhjd;
    //   97: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   100: aload 40
    //   102: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: ifnonnull +64 -> 172
    //   111: iconst_0
    //   112: istore_1
    //   113: iload_1
    //   114: ifle +99 -> 213
    //   117: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   120: ldc2_w 83
    //   123: ldiv
    //   124: l2i
    //   125: iload_1
    //   126: sipush 600
    //   129: iadd
    //   130: if_icmpge +67 -> 197
    //   133: aload 41
    //   135: ifnull +20 -> 155
    //   138: aload 40
    //   140: getfield 87	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   143: bipush 252
    //   145: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   148: aload 41
    //   150: aload 40
    //   152: invokevirtual 96	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   155: aload_0
    //   156: getfield 12	hje:a	Lhjd;
    //   159: aload 40
    //   161: invokestatic 99	hjd:a	(Lhjd;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   164: aload_0
    //   165: getfield 12	hje:a	Lhjd;
    //   168: invokestatic 38	hjd:a	(Lhjd;)V
    //   171: return
    //   172: aload_0
    //   173: getfield 12	hje:a	Lhjd;
    //   176: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   179: aload 40
    //   181: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 101	java/lang/Integer
    //   190: invokevirtual 105	java/lang/Integer:intValue	()I
    //   193: istore_1
    //   194: goto -81 -> 113
    //   197: aload_0
    //   198: getfield 12	hje:a	Lhjd;
    //   201: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   204: aload 40
    //   206: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   209: invokevirtual 108	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +30 -> 246
    //   219: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: iconst_2
    //   223: new 117	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   230: ldc 120
    //   232: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 40
    //   237: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload 40
    //   248: getfield 137	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   251: invokevirtual 139	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   254: ifeq +32 -> 286
    //   257: aload 41
    //   259: ifnull +10 -> 269
    //   262: aload 41
    //   264: aload 40
    //   266: invokevirtual 141	com/tencent/mobileqq/vip/DownloadListener:b	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   269: aload_0
    //   270: getfield 12	hje:a	Lhjd;
    //   273: aload 40
    //   275: invokestatic 99	hjd:a	(Lhjd;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   278: aload_0
    //   279: getfield 12	hje:a	Lhjd;
    //   282: invokestatic 38	hjd:a	(Lhjd;)V
    //   285: return
    //   286: aload 40
    //   288: getfield 87	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   291: invokevirtual 143	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   294: iconst_2
    //   295: if_icmpne -253 -> 42
    //   298: new 4	java/lang/Object
    //   301: dup
    //   302: invokespecial 15	java/lang/Object:<init>	()V
    //   305: astore 42
    //   307: lconst_0
    //   308: lstore 8
    //   310: lconst_0
    //   311: lstore 18
    //   313: lconst_0
    //   314: lstore 22
    //   316: lload 22
    //   318: lstore 16
    //   320: lload 18
    //   322: lstore 20
    //   324: lload 8
    //   326: lstore 10
    //   328: new 145	com/tencent/mobileqq/emoticon/DownloadInfo
    //   331: dup
    //   332: aload 40
    //   334: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   337: aconst_null
    //   338: iconst_0
    //   339: invokespecial 148	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   342: astore 39
    //   344: lload 22
    //   346: lstore 14
    //   348: lload 18
    //   350: lstore 12
    //   352: lload 8
    //   354: lstore 6
    //   356: lload 22
    //   358: lstore 16
    //   360: lload 18
    //   362: lstore 20
    //   364: lload 8
    //   366: lstore 10
    //   368: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   371: lstore 26
    //   373: lload 22
    //   375: lstore 14
    //   377: lload 18
    //   379: lstore 12
    //   381: lload 8
    //   383: lstore 6
    //   385: lload 22
    //   387: lstore 16
    //   389: lload 18
    //   391: lstore 20
    //   393: lload 8
    //   395: lstore 10
    //   397: new 150	org/apache/http/client/methods/HttpGet
    //   400: dup
    //   401: aload 40
    //   403: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   406: invokespecial 153	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   409: astore 43
    //   411: lload 22
    //   413: lstore 14
    //   415: lload 18
    //   417: lstore 12
    //   419: lload 8
    //   421: lstore 6
    //   423: lload 22
    //   425: lstore 16
    //   427: lload 18
    //   429: lstore 20
    //   431: lload 8
    //   433: lstore 10
    //   435: new 155	org/apache/http/params/BasicHttpParams
    //   438: dup
    //   439: invokespecial 156	org/apache/http/params/BasicHttpParams:<init>	()V
    //   442: astore 44
    //   444: lload 22
    //   446: lstore 14
    //   448: lload 18
    //   450: lstore 12
    //   452: lload 8
    //   454: lstore 6
    //   456: lload 22
    //   458: lstore 16
    //   460: lload 18
    //   462: lstore 20
    //   464: lload 8
    //   466: lstore 10
    //   468: aload 44
    //   470: ldc 158
    //   472: ldc 159
    //   474: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: invokeinterface 169 3 0
    //   482: pop
    //   483: lload 22
    //   485: lstore 14
    //   487: lload 18
    //   489: lstore 12
    //   491: lload 8
    //   493: lstore 6
    //   495: lload 22
    //   497: lstore 16
    //   499: lload 18
    //   501: lstore 20
    //   503: lload 8
    //   505: lstore 10
    //   507: aload 44
    //   509: ldc 171
    //   511: ldc 159
    //   513: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   516: invokeinterface 169 3 0
    //   521: pop
    //   522: lload 22
    //   524: lstore 14
    //   526: lload 18
    //   528: lstore 12
    //   530: lload 8
    //   532: lstore 6
    //   534: lload 22
    //   536: lstore 16
    //   538: lload 18
    //   540: lstore 20
    //   542: lload 8
    //   544: lstore 10
    //   546: aload 44
    //   548: ldc 173
    //   550: ldc 175
    //   552: invokeinterface 169 3 0
    //   557: pop
    //   558: lload 22
    //   560: lstore 14
    //   562: lload 18
    //   564: lstore 12
    //   566: lload 8
    //   568: lstore 6
    //   570: lload 22
    //   572: lstore 16
    //   574: lload 18
    //   576: lstore 20
    //   578: lload 8
    //   580: lstore 10
    //   582: aload 40
    //   584: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   587: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   590: invokestatic 188	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)[J
    //   593: astore 32
    //   595: aload 32
    //   597: iconst_0
    //   598: laload
    //   599: lstore 6
    //   601: aload 32
    //   603: iconst_1
    //   604: laload
    //   605: lstore 18
    //   607: aload 32
    //   609: iconst_2
    //   610: laload
    //   611: lstore 22
    //   613: lload 6
    //   615: lstore 8
    //   617: lload 6
    //   619: lconst_1
    //   620: lcmp
    //   621: ifge +858 -> 1479
    //   624: lconst_0
    //   625: lstore 24
    //   627: lload 22
    //   629: lstore 14
    //   631: lload 18
    //   633: lstore 12
    //   635: lload 24
    //   637: lstore 6
    //   639: lload 22
    //   641: lstore 16
    //   643: lload 18
    //   645: lstore 20
    //   647: lload 24
    //   649: lstore 10
    //   651: aload 40
    //   653: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   656: invokevirtual 192	java/io/File:getParentFile	()Ljava/io/File;
    //   659: astore 32
    //   661: lload 24
    //   663: lstore 8
    //   665: aload 32
    //   667: ifnull +812 -> 1479
    //   670: lload 22
    //   672: lstore 14
    //   674: lload 18
    //   676: lstore 12
    //   678: lload 24
    //   680: lstore 6
    //   682: lload 24
    //   684: lstore 8
    //   686: lload 22
    //   688: lstore 16
    //   690: lload 18
    //   692: lstore 20
    //   694: lload 24
    //   696: lstore 10
    //   698: aload 32
    //   700: invokevirtual 195	java/io/File:exists	()Z
    //   703: ifne +776 -> 1479
    //   706: lload 22
    //   708: lstore 14
    //   710: lload 18
    //   712: lstore 12
    //   714: lload 24
    //   716: lstore 6
    //   718: lload 24
    //   720: lstore 8
    //   722: lload 22
    //   724: lstore 16
    //   726: lload 18
    //   728: lstore 20
    //   730: lload 24
    //   732: lstore 10
    //   734: aload 32
    //   736: invokevirtual 198	java/io/File:mkdirs	()Z
    //   739: ifne +740 -> 1479
    //   742: lload 22
    //   744: lstore 14
    //   746: lload 18
    //   748: lstore 12
    //   750: lload 24
    //   752: lstore 6
    //   754: lload 22
    //   756: lstore 16
    //   758: lload 18
    //   760: lstore 20
    //   762: lload 24
    //   764: lstore 10
    //   766: new 200	java/lang/Exception
    //   769: dup
    //   770: new 117	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   777: ldc 202
    //   779: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload 32
    //   784: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   787: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokespecial 206	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   796: athrow
    //   797: astore 33
    //   799: lload 6
    //   801: lstore 10
    //   803: aconst_null
    //   804: astore 35
    //   806: aconst_null
    //   807: astore 34
    //   809: aconst_null
    //   810: astore 32
    //   812: lconst_0
    //   813: lstore 8
    //   815: iconst_0
    //   816: istore 28
    //   818: iconst_0
    //   819: istore_1
    //   820: lload 12
    //   822: lstore 6
    //   824: lload 14
    //   826: lstore 12
    //   828: lload 10
    //   830: lstore 16
    //   832: lload 6
    //   834: lstore 18
    //   836: lload 12
    //   838: lstore 14
    //   840: lload 8
    //   842: lstore 20
    //   844: aload 35
    //   846: astore 36
    //   848: aload 34
    //   850: astore 38
    //   852: aload 32
    //   854: astore 37
    //   856: aload 39
    //   858: getfield 207	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   861: ifeq +80 -> 941
    //   864: lload 10
    //   866: lstore 16
    //   868: lload 6
    //   870: lstore 18
    //   872: lload 12
    //   874: lstore 14
    //   876: lload 8
    //   878: lstore 20
    //   880: aload 35
    //   882: astore 36
    //   884: aload 34
    //   886: astore 38
    //   888: aload 32
    //   890: astore 37
    //   892: invokestatic 212	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   895: astore 42
    //   897: aload 42
    //   899: ifnull +42 -> 941
    //   902: lload 10
    //   904: lstore 16
    //   906: lload 6
    //   908: lstore 18
    //   910: lload 12
    //   912: lstore 14
    //   914: lload 8
    //   916: lstore 20
    //   918: aload 35
    //   920: astore 36
    //   922: aload 34
    //   924: astore 38
    //   926: aload 32
    //   928: astore 37
    //   930: aload 42
    //   932: iconst_5
    //   933: aload 39
    //   935: getfield 214	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   938: invokevirtual 217	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   941: iconst_0
    //   942: istore_2
    //   943: lload 10
    //   945: lstore 16
    //   947: lload 6
    //   949: lstore 18
    //   951: lload 12
    //   953: lstore 14
    //   955: lload 8
    //   957: lstore 20
    //   959: aload 35
    //   961: astore 36
    //   963: aload 34
    //   965: astore 38
    //   967: aload 32
    //   969: astore 37
    //   971: aload 33
    //   973: instanceof 219
    //   976: ifne +4009 -> 4985
    //   979: lload 10
    //   981: lstore 16
    //   983: lload 6
    //   985: lstore 18
    //   987: lload 12
    //   989: lstore 14
    //   991: lload 8
    //   993: lstore 20
    //   995: aload 35
    //   997: astore 36
    //   999: aload 34
    //   1001: astore 38
    //   1003: aload 32
    //   1005: astore 37
    //   1007: aload 33
    //   1009: instanceof 221
    //   1012: ifne +3973 -> 4985
    //   1015: lload 10
    //   1017: lstore 16
    //   1019: lload 6
    //   1021: lstore 18
    //   1023: lload 12
    //   1025: lstore 14
    //   1027: lload 8
    //   1029: lstore 20
    //   1031: aload 35
    //   1033: astore 36
    //   1035: aload 34
    //   1037: astore 38
    //   1039: aload 32
    //   1041: astore 37
    //   1043: aload 33
    //   1045: instanceof 223
    //   1048: ifeq +6 -> 1054
    //   1051: goto +3934 -> 4985
    //   1054: iload_1
    //   1055: ifne +51 -> 1106
    //   1058: iload_2
    //   1059: ifeq +47 -> 1106
    //   1062: iload 28
    //   1064: ifeq +3268 -> 4332
    //   1067: lload 10
    //   1069: lstore 16
    //   1071: lload 6
    //   1073: lstore 18
    //   1075: lload 12
    //   1077: lstore 14
    //   1079: lload 8
    //   1081: lstore 20
    //   1083: aload 35
    //   1085: astore 36
    //   1087: aload 34
    //   1089: astore 38
    //   1091: aload 32
    //   1093: astore 37
    //   1095: aload_0
    //   1096: getfield 12	hje:a	Lhjd;
    //   1099: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1102: iconst_1
    //   1103: putfield 225	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:c	Z
    //   1106: lload 10
    //   1108: lstore 16
    //   1110: lload 6
    //   1112: lstore 18
    //   1114: lload 12
    //   1116: lstore 14
    //   1118: lload 8
    //   1120: lstore 20
    //   1122: aload 35
    //   1124: astore 36
    //   1126: aload 34
    //   1128: astore 38
    //   1130: aload 32
    //   1132: astore 37
    //   1134: aload 39
    //   1136: getfield 207	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1139: ifeq +3235 -> 4374
    //   1142: lload 10
    //   1144: lstore 16
    //   1146: lload 6
    //   1148: lstore 18
    //   1150: lload 12
    //   1152: lstore 14
    //   1154: lload 8
    //   1156: lstore 20
    //   1158: aload 35
    //   1160: astore 36
    //   1162: aload 34
    //   1164: astore 38
    //   1166: aload 32
    //   1168: astore 37
    //   1170: aload_0
    //   1171: getfield 12	hje:a	Lhjd;
    //   1174: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1177: iconst_0
    //   1178: putfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   1181: lload 10
    //   1183: lstore 16
    //   1185: lload 6
    //   1187: lstore 18
    //   1189: lload 12
    //   1191: lstore 14
    //   1193: lload 8
    //   1195: lstore 20
    //   1197: aload 35
    //   1199: astore 36
    //   1201: aload 34
    //   1203: astore 38
    //   1205: aload 32
    //   1207: astore 37
    //   1209: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1212: ifeq +63 -> 1275
    //   1215: lload 10
    //   1217: lstore 16
    //   1219: lload 6
    //   1221: lstore 18
    //   1223: lload 12
    //   1225: lstore 14
    //   1227: lload 8
    //   1229: lstore 20
    //   1231: aload 35
    //   1233: astore 36
    //   1235: aload 34
    //   1237: astore 38
    //   1239: aload 32
    //   1241: astore 37
    //   1243: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1246: iconst_2
    //   1247: new 117	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1254: ldc 229
    //   1256: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload 40
    //   1261: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1264: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aload 33
    //   1272: invokestatic 233	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1275: aload 41
    //   1277: ifnull +75 -> 1352
    //   1280: lload 10
    //   1282: lstore 16
    //   1284: lload 6
    //   1286: lstore 18
    //   1288: lload 12
    //   1290: lstore 14
    //   1292: lload 8
    //   1294: lstore 20
    //   1296: aload 35
    //   1298: astore 36
    //   1300: aload 34
    //   1302: astore 38
    //   1304: aload 32
    //   1306: astore 37
    //   1308: aload 40
    //   1310: getfield 87	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1313: iconst_m1
    //   1314: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1317: lload 10
    //   1319: lstore 16
    //   1321: lload 6
    //   1323: lstore 18
    //   1325: lload 12
    //   1327: lstore 14
    //   1329: lload 8
    //   1331: lstore 20
    //   1333: aload 35
    //   1335: astore 36
    //   1337: aload 34
    //   1339: astore 38
    //   1341: aload 32
    //   1343: astore 37
    //   1345: aload 41
    //   1347: aload 40
    //   1349: invokevirtual 96	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1352: aload 32
    //   1354: ifnull +10 -> 1364
    //   1357: aload 32
    //   1359: invokeinterface 238 1 0
    //   1364: aload 34
    //   1366: ifnull +8 -> 1374
    //   1369: aload 34
    //   1371: invokevirtual 243	java/io/InputStream:close	()V
    //   1374: aload 35
    //   1376: ifnull +8 -> 1384
    //   1379: aload 35
    //   1381: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   1384: lload 10
    //   1386: lconst_0
    //   1387: lcmp
    //   1388: ifeq +38 -> 1426
    //   1391: lload 6
    //   1393: lconst_0
    //   1394: lcmp
    //   1395: ifeq +31 -> 1426
    //   1398: lload 10
    //   1400: lload 6
    //   1402: lcmp
    //   1403: ifne +3013 -> 4416
    //   1406: aload 40
    //   1408: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1411: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   1414: invokestatic 248	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   1417: aload 40
    //   1419: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1422: invokevirtual 251	java/io/File:delete	()Z
    //   1425: pop
    //   1426: aload_0
    //   1427: getfield 12	hje:a	Lhjd;
    //   1430: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1433: ifnull +29 -> 1462
    //   1436: aload 41
    //   1438: ifnull +24 -> 1462
    //   1441: lload 8
    //   1443: lconst_0
    //   1444: lcmp
    //   1445: ifle +17 -> 1462
    //   1448: aload 41
    //   1450: aload_0
    //   1451: getfield 12	hje:a	Lhjd;
    //   1454: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   1457: lload 8
    //   1459: invokevirtual 257	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   1462: aload_0
    //   1463: getfield 12	hje:a	Lhjd;
    //   1466: aload 40
    //   1468: invokestatic 99	hjd:a	(Lhjd;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   1471: aload_0
    //   1472: getfield 12	hje:a	Lhjd;
    //   1475: invokestatic 38	hjd:a	(Lhjd;)V
    //   1478: return
    //   1479: lload 22
    //   1481: lstore 14
    //   1483: lload 18
    //   1485: lstore 12
    //   1487: lload 8
    //   1489: lstore 6
    //   1491: lload 22
    //   1493: lstore 16
    //   1495: lload 18
    //   1497: lstore 20
    //   1499: lload 8
    //   1501: lstore 10
    //   1503: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1506: ifeq +77 -> 1583
    //   1509: lload 22
    //   1511: lstore 14
    //   1513: lload 18
    //   1515: lstore 12
    //   1517: lload 8
    //   1519: lstore 6
    //   1521: lload 22
    //   1523: lstore 16
    //   1525: lload 18
    //   1527: lstore 20
    //   1529: lload 8
    //   1531: lstore 10
    //   1533: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1536: iconst_2
    //   1537: new 117	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1544: ldc_w 259
    //   1547: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: lload 8
    //   1552: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1555: ldc_w 264
    //   1558: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: lload 18
    //   1563: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1566: ldc_w 266
    //   1569: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: lload 22
    //   1574: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1577: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1580: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1583: iconst_0
    //   1584: istore_1
    //   1585: iconst_m1
    //   1586: istore 4
    //   1588: iconst_0
    //   1589: istore 30
    //   1591: aconst_null
    //   1592: astore 33
    //   1594: iconst_0
    //   1595: istore 29
    //   1597: aconst_null
    //   1598: astore 32
    //   1600: aconst_null
    //   1601: astore 34
    //   1603: sipush 2048
    //   1606: istore_2
    //   1607: lconst_0
    //   1608: lstore 6
    //   1610: lload 22
    //   1612: lstore 14
    //   1614: lload 18
    //   1616: lstore 10
    //   1618: aload 33
    //   1620: astore 36
    //   1622: iload 29
    //   1624: istore 31
    //   1626: getstatic 269	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1629: invokevirtual 275	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   1632: astore 37
    //   1634: aload 37
    //   1636: ifnonnull +43 -> 1679
    //   1639: aload 33
    //   1641: astore 36
    //   1643: iload 29
    //   1645: istore 31
    //   1647: new 200	java/lang/Exception
    //   1650: dup
    //   1651: new 117	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1658: ldc_w 277
    //   1661: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: aload 40
    //   1666: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1669: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: invokespecial 206	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1678: athrow
    //   1679: aload 33
    //   1681: astore 36
    //   1683: iload 29
    //   1685: istore 31
    //   1687: aload 43
    //   1689: ldc_w 279
    //   1692: new 117	java/lang/StringBuilder
    //   1695: dup
    //   1696: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   1699: ldc_w 281
    //   1702: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: lload 8
    //   1707: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1710: ldc_w 283
    //   1713: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1719: invokevirtual 287	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1722: aload 33
    //   1724: astore 36
    //   1726: iload 29
    //   1728: istore 31
    //   1730: aload 39
    //   1732: invokevirtual 289	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   1735: aload 33
    //   1737: astore 36
    //   1739: iload 29
    //   1741: istore 31
    //   1743: getstatic 290	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   1746: ifeq +74 -> 1820
    //   1749: aload 33
    //   1751: astore 36
    //   1753: iload 29
    //   1755: istore 31
    //   1757: aload_0
    //   1758: getfield 12	hje:a	Lhjd;
    //   1761: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1764: getfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   1767: ifeq +53 -> 1820
    //   1770: aload 33
    //   1772: astore 36
    //   1774: iload 29
    //   1776: istore 31
    //   1778: aload 39
    //   1780: invokestatic 295	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   1783: aload 33
    //   1785: astore 36
    //   1787: iload 29
    //   1789: istore 31
    //   1791: aload 39
    //   1793: getfield 207	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   1796: ifeq +24 -> 1820
    //   1799: aload 33
    //   1801: astore 36
    //   1803: iload 29
    //   1805: istore 31
    //   1807: aload 43
    //   1809: ldc_w 297
    //   1812: aload 39
    //   1814: getfield 299	com/tencent/mobileqq/emoticon/DownloadInfo:d	Ljava/lang/String;
    //   1817: invokevirtual 287	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1820: aload 33
    //   1822: astore 36
    //   1824: iload 29
    //   1826: istore 31
    //   1828: aload 37
    //   1830: invokevirtual 304	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   1833: invokestatic 310	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   1836: astore 38
    //   1838: aload 33
    //   1840: astore 36
    //   1842: iload 29
    //   1844: istore 31
    //   1846: aload 38
    //   1848: aload_0
    //   1849: getfield 12	hje:a	Lhjd;
    //   1852: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1855: getfield 311	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1858: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1861: ifne +42 -> 1903
    //   1864: aload 33
    //   1866: astore 36
    //   1868: iload 29
    //   1870: istore 31
    //   1872: aload_0
    //   1873: getfield 12	hje:a	Lhjd;
    //   1876: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1879: iconst_0
    //   1880: putfield 225	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:c	Z
    //   1883: aload 33
    //   1885: astore 36
    //   1887: iload 29
    //   1889: istore 31
    //   1891: aload_0
    //   1892: getfield 12	hje:a	Lhjd;
    //   1895: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1898: aload 38
    //   1900: putfield 311	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1903: aconst_null
    //   1904: astore 35
    //   1906: iconst_0
    //   1907: istore 5
    //   1909: iconst_0
    //   1910: istore_3
    //   1911: aload 33
    //   1913: astore 36
    //   1915: iload 29
    //   1917: istore 31
    //   1919: aload 37
    //   1921: invokestatic 322	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1924: ifeq +3181 -> 5105
    //   1927: iload 29
    //   1929: istore 28
    //   1931: aload 33
    //   1933: astore 36
    //   1935: iload 29
    //   1937: istore 31
    //   1939: aload_0
    //   1940: getfield 12	hje:a	Lhjd;
    //   1943: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   1946: getfield 225	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:c	Z
    //   1949: ifne +101 -> 2050
    //   1952: aload 33
    //   1954: astore 36
    //   1956: iload 29
    //   1958: istore 31
    //   1960: invokestatic 327	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1963: astore 37
    //   1965: aload 33
    //   1967: astore 36
    //   1969: iload 29
    //   1971: istore 31
    //   1973: invokestatic 330	android/net/Proxy:getDefaultPort	()I
    //   1976: istore 5
    //   1978: iload 5
    //   1980: istore_3
    //   1981: iload 29
    //   1983: istore 28
    //   1985: aload 37
    //   1987: astore 35
    //   1989: aload 37
    //   1991: ifnull +59 -> 2050
    //   1994: iload 5
    //   1996: istore_3
    //   1997: iload 29
    //   1999: istore 28
    //   2001: aload 37
    //   2003: astore 35
    //   2005: iload 5
    //   2007: ifle +43 -> 2050
    //   2010: aload 33
    //   2012: astore 36
    //   2014: iload 29
    //   2016: istore 31
    //   2018: aload 44
    //   2020: ldc_w 332
    //   2023: new 334	org/apache/http/HttpHost
    //   2026: dup
    //   2027: aload 37
    //   2029: iload 5
    //   2031: invokespecial 337	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   2034: invokeinterface 169 3 0
    //   2039: pop
    //   2040: iconst_1
    //   2041: istore 28
    //   2043: aload 37
    //   2045: astore 35
    //   2047: iload 5
    //   2049: istore_3
    //   2050: aload 33
    //   2052: astore 36
    //   2054: iload 28
    //   2056: istore 31
    //   2058: aload 38
    //   2060: getstatic 338	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   2063: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2066: ifne +41 -> 2107
    //   2069: aload 33
    //   2071: astore 36
    //   2073: iload 28
    //   2075: istore 31
    //   2077: aload 38
    //   2079: getstatic 340	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   2082: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2085: ifne +22 -> 2107
    //   2088: aload 33
    //   2090: astore 36
    //   2092: iload 28
    //   2094: istore 31
    //   2096: aload 38
    //   2098: getstatic 343	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   2101: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2104: ifeq +2830 -> 4934
    //   2107: aload 33
    //   2109: astore 36
    //   2111: iload 28
    //   2113: istore 31
    //   2115: aload 43
    //   2117: ldc_w 345
    //   2120: aload 39
    //   2122: getfield 299	com/tencent/mobileqq/emoticon/DownloadInfo:d	Ljava/lang/String;
    //   2125: invokevirtual 287	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2128: iload_3
    //   2129: istore 5
    //   2131: aload 33
    //   2133: astore 36
    //   2135: iload_1
    //   2136: istore_3
    //   2137: aload 44
    //   2139: ldc_w 347
    //   2142: iload_2
    //   2143: invokeinterface 351 3 0
    //   2148: pop
    //   2149: aload 33
    //   2151: astore 36
    //   2153: iload_1
    //   2154: istore_3
    //   2155: aload 43
    //   2157: aload 44
    //   2159: invokevirtual 355	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   2162: aload 33
    //   2164: astore 36
    //   2166: iload_1
    //   2167: istore_3
    //   2168: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2171: ifeq +122 -> 2293
    //   2174: aload 33
    //   2176: astore 36
    //   2178: iload_1
    //   2179: istore_3
    //   2180: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2183: iconst_2
    //   2184: new 117	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2191: ldc_w 357
    //   2194: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: aload_0
    //   2198: getfield 12	hje:a	Lhjd;
    //   2201: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2204: getfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   2207: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2210: ldc_w 362
    //   2213: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2216: aload_0
    //   2217: getfield 12	hje:a	Lhjd;
    //   2220: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2223: getfield 225	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:c	Z
    //   2226: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2229: ldc_w 364
    //   2232: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: iload 28
    //   2237: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2240: ldc_w 366
    //   2243: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: aload 38
    //   2248: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: ldc_w 368
    //   2254: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2257: aload 35
    //   2259: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: ldc_w 370
    //   2265: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: iload 5
    //   2270: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2273: ldc_w 375
    //   2276: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2279: aload 39
    //   2281: getfield 214	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   2284: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2290: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2293: iconst_0
    //   2294: istore_3
    //   2295: aload 33
    //   2297: astore 36
    //   2299: getstatic 378	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   2302: aload 43
    //   2304: invokevirtual 384	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   2307: astore 37
    //   2309: iconst_1
    //   2310: istore_1
    //   2311: aload 33
    //   2313: astore 36
    //   2315: aload 33
    //   2317: astore 35
    //   2319: aload 37
    //   2321: invokeinterface 390 1 0
    //   2326: invokeinterface 395 1 0
    //   2331: istore_3
    //   2332: aload 33
    //   2334: astore 36
    //   2336: aload 33
    //   2338: astore 35
    //   2340: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2343: ifeq +2700 -> 5043
    //   2346: aload 33
    //   2348: astore 36
    //   2350: aload 33
    //   2352: astore 35
    //   2354: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2357: iconst_2
    //   2358: new 117	java/lang/StringBuilder
    //   2361: dup
    //   2362: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2365: ldc_w 397
    //   2368: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: iload_3
    //   2372: invokevirtual 373	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2381: goto +2662 -> 5043
    //   2384: aload 33
    //   2386: astore 36
    //   2388: aload 33
    //   2390: astore 35
    //   2392: aload 37
    //   2394: invokeinterface 401 1 0
    //   2399: astore 33
    //   2401: aload 33
    //   2403: astore 36
    //   2405: aload 33
    //   2407: astore 35
    //   2409: aload 33
    //   2411: invokeinterface 404 1 0
    //   2416: lstore 22
    //   2418: lload 22
    //   2420: lconst_1
    //   2421: lcmp
    //   2422: ifge +43 -> 2465
    //   2425: aload 33
    //   2427: astore 36
    //   2429: aload 33
    //   2431: astore 35
    //   2433: new 200	java/lang/Exception
    //   2436: dup
    //   2437: new 117	java/lang/StringBuilder
    //   2440: dup
    //   2441: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2444: ldc_w 406
    //   2447: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2450: aload 40
    //   2452: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2455: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2458: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2461: invokespecial 206	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2464: athrow
    //   2465: lconst_0
    //   2466: lstore 16
    //   2468: aload 33
    //   2470: astore 36
    //   2472: aload 33
    //   2474: astore 35
    //   2476: aload 37
    //   2478: ldc_w 408
    //   2481: invokeinterface 412 2 0
    //   2486: ifeq +31 -> 2517
    //   2489: aload 33
    //   2491: astore 36
    //   2493: aload 33
    //   2495: astore 35
    //   2497: aload 37
    //   2499: ldc_w 408
    //   2502: invokeinterface 416 2 0
    //   2507: invokeinterface 421 1 0
    //   2512: invokestatic 427	java/util/Date:parse	(Ljava/lang/String;)J
    //   2515: lstore 16
    //   2517: lload 8
    //   2519: lconst_0
    //   2520: lcmp
    //   2521: ifne +727 -> 3248
    //   2524: lload 16
    //   2526: lstore 14
    //   2528: lload 22
    //   2530: lstore 10
    //   2532: lload 8
    //   2534: lstore 12
    //   2536: lload 10
    //   2538: lstore 8
    //   2540: lload 12
    //   2542: lstore 18
    //   2544: lload 12
    //   2546: lstore 20
    //   2548: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2551: ifeq +83 -> 2634
    //   2554: lload 12
    //   2556: lstore 18
    //   2558: lload 12
    //   2560: lstore 20
    //   2562: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2565: iconst_2
    //   2566: new 117	java/lang/StringBuilder
    //   2569: dup
    //   2570: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   2573: ldc_w 429
    //   2576: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: lload 22
    //   2581: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2584: ldc_w 431
    //   2587: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2590: lload 12
    //   2592: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2595: ldc_w 264
    //   2598: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2601: lload 8
    //   2603: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2606: ldc_w 266
    //   2609: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: lload 14
    //   2614: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2617: ldc_w 433
    //   2620: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2623: lload 16
    //   2625: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2628: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2631: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2634: lload 14
    //   2636: lconst_0
    //   2637: lcmp
    //   2638: ifeq +638 -> 3276
    //   2641: lload 14
    //   2643: lload 16
    //   2645: lcmp
    //   2646: ifeq +630 -> 3276
    //   2649: lload 12
    //   2651: lstore 18
    //   2653: lload 12
    //   2655: lstore 20
    //   2657: aload 40
    //   2659: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2662: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   2665: invokestatic 248	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   2668: lconst_0
    //   2669: lstore 10
    //   2671: lload 10
    //   2673: lstore 18
    //   2675: lload 10
    //   2677: lstore 20
    //   2679: aload 40
    //   2681: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2684: invokevirtual 195	java/io/File:exists	()Z
    //   2687: ifeq +2163 -> 4850
    //   2690: lload 10
    //   2692: lstore 18
    //   2694: lload 10
    //   2696: lstore 20
    //   2698: aload 40
    //   2700: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2703: invokevirtual 251	java/io/File:delete	()Z
    //   2706: pop
    //   2707: aload 34
    //   2709: astore 35
    //   2711: aload 32
    //   2713: astore 34
    //   2715: aload 33
    //   2717: astore 32
    //   2719: iconst_0
    //   2720: istore 29
    //   2722: lload 8
    //   2724: lstore 16
    //   2726: lload 6
    //   2728: lstore 8
    //   2730: lload 14
    //   2732: lstore 12
    //   2734: lload 16
    //   2736: lstore 6
    //   2738: iload 4
    //   2740: iconst_1
    //   2741: iadd
    //   2742: istore 4
    //   2744: lload 10
    //   2746: lstore 16
    //   2748: lload 6
    //   2750: lstore 18
    //   2752: lload 12
    //   2754: lstore 14
    //   2756: lload 8
    //   2758: lstore 20
    //   2760: aload 35
    //   2762: astore 36
    //   2764: aload 34
    //   2766: astore 38
    //   2768: aload 32
    //   2770: astore 37
    //   2772: aload 40
    //   2774: getfield 137	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2777: invokevirtual 139	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2780: ifne +1439 -> 4219
    //   2783: iload 29
    //   2785: ifne +1434 -> 4219
    //   2788: lload 10
    //   2790: lstore 16
    //   2792: lload 6
    //   2794: lstore 18
    //   2796: lload 12
    //   2798: lstore 14
    //   2800: lload 8
    //   2802: lstore 20
    //   2804: aload 35
    //   2806: astore 36
    //   2808: aload 34
    //   2810: astore 38
    //   2812: aload 32
    //   2814: astore 37
    //   2816: aload 39
    //   2818: getfield 207	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2821: ifeq +955 -> 3776
    //   2824: lload 10
    //   2826: lstore 16
    //   2828: lload 6
    //   2830: lstore 18
    //   2832: lload 12
    //   2834: lstore 14
    //   2836: lload 8
    //   2838: lstore 20
    //   2840: aload 35
    //   2842: astore 36
    //   2844: aload 34
    //   2846: astore 38
    //   2848: aload 32
    //   2850: astore 37
    //   2852: aload_0
    //   2853: getfield 12	hje:a	Lhjd;
    //   2856: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   2859: iconst_0
    //   2860: putfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   2863: lload 10
    //   2865: lstore 16
    //   2867: lload 6
    //   2869: lstore 18
    //   2871: lload 12
    //   2873: lstore 14
    //   2875: lload 8
    //   2877: lstore 20
    //   2879: aload 35
    //   2881: astore 36
    //   2883: aload 34
    //   2885: astore 38
    //   2887: aload 32
    //   2889: astore 37
    //   2891: invokestatic 212	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   2894: iconst_5
    //   2895: aload 39
    //   2897: getfield 214	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   2900: invokevirtual 217	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   2903: lload 10
    //   2905: lstore 16
    //   2907: lload 6
    //   2909: lstore 18
    //   2911: lload 12
    //   2913: lstore 14
    //   2915: lload 8
    //   2917: lstore 20
    //   2919: aload 35
    //   2921: astore 36
    //   2923: aload 34
    //   2925: astore 38
    //   2927: aload 32
    //   2929: astore 37
    //   2931: aload 39
    //   2933: getfield 214	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   2936: aload 40
    //   2938: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   2941: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   2944: iconst_m1
    //   2945: aload_0
    //   2946: getfield 12	hje:a	Lhjd;
    //   2949: getfield 436	hjd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2952: invokestatic 439	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2955: lload 10
    //   2957: lstore 16
    //   2959: lload 6
    //   2961: lstore 18
    //   2963: lload 12
    //   2965: lstore 14
    //   2967: lload 8
    //   2969: lstore 20
    //   2971: aload 35
    //   2973: astore 36
    //   2975: aload 34
    //   2977: astore 38
    //   2979: aload 32
    //   2981: astore 37
    //   2983: iload 4
    //   2985: aload 40
    //   2987: getfield 443	com/tencent/mobileqq/vip/DownloadTask:l	I
    //   2990: if_icmpge +1024 -> 4014
    //   2993: lload 10
    //   2995: lstore 16
    //   2997: lload 6
    //   2999: lstore 18
    //   3001: lload 12
    //   3003: lstore 14
    //   3005: lload 8
    //   3007: lstore 20
    //   3009: aload 35
    //   3011: astore 36
    //   3013: aload 34
    //   3015: astore 38
    //   3017: aload 32
    //   3019: astore 37
    //   3021: aload 42
    //   3023: monitorenter
    //   3024: aload 42
    //   3026: ldc2_w 444
    //   3029: invokevirtual 449	java/lang/Object:wait	(J)V
    //   3032: aload 42
    //   3034: monitorexit
    //   3035: iload 29
    //   3037: ifne +84 -> 3121
    //   3040: lload 10
    //   3042: lstore 16
    //   3044: lload 6
    //   3046: lstore 18
    //   3048: lload 12
    //   3050: lstore 14
    //   3052: lload 8
    //   3054: lstore 20
    //   3056: aload 35
    //   3058: astore 36
    //   3060: aload 34
    //   3062: astore 38
    //   3064: aload 32
    //   3066: astore 37
    //   3068: iload 4
    //   3070: aload 40
    //   3072: getfield 443	com/tencent/mobileqq/vip/DownloadTask:l	I
    //   3075: if_icmpge +46 -> 3121
    //   3078: lload 10
    //   3080: lstore 16
    //   3082: lload 6
    //   3084: lstore 18
    //   3086: lload 12
    //   3088: lstore 14
    //   3090: lload 8
    //   3092: lstore 20
    //   3094: aload 35
    //   3096: astore 36
    //   3098: aload 34
    //   3100: astore 38
    //   3102: aload 32
    //   3104: astore 37
    //   3106: aload 40
    //   3108: getfield 137	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3111: invokevirtual 139	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3114: istore 30
    //   3116: iload 30
    //   3118: ifeq +1822 -> 4940
    //   3121: aload 32
    //   3123: ifnull +10 -> 3133
    //   3126: aload 32
    //   3128: invokeinterface 238 1 0
    //   3133: aload 34
    //   3135: ifnull +8 -> 3143
    //   3138: aload 34
    //   3140: invokevirtual 243	java/io/InputStream:close	()V
    //   3143: aload 35
    //   3145: ifnull +8 -> 3153
    //   3148: aload 35
    //   3150: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   3153: lload 10
    //   3155: lconst_0
    //   3156: lcmp
    //   3157: ifeq +38 -> 3195
    //   3160: lload 6
    //   3162: lconst_0
    //   3163: lcmp
    //   3164: ifeq +31 -> 3195
    //   3167: lload 10
    //   3169: lload 6
    //   3171: lcmp
    //   3172: ifne +1140 -> 4312
    //   3175: aload 40
    //   3177: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3180: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   3183: invokestatic 248	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   3186: aload 40
    //   3188: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3191: invokevirtual 251	java/io/File:delete	()Z
    //   3194: pop
    //   3195: aload_0
    //   3196: getfield 12	hje:a	Lhjd;
    //   3199: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3202: ifnull +29 -> 3231
    //   3205: aload 41
    //   3207: ifnull +24 -> 3231
    //   3210: lload 8
    //   3212: lconst_0
    //   3213: lcmp
    //   3214: ifle +17 -> 3231
    //   3217: aload 41
    //   3219: aload_0
    //   3220: getfield 12	hje:a	Lhjd;
    //   3223: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3226: lload 8
    //   3228: invokevirtual 257	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   3231: aload_0
    //   3232: getfield 12	hje:a	Lhjd;
    //   3235: aload 40
    //   3237: invokestatic 99	hjd:a	(Lhjd;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3240: aload_0
    //   3241: getfield 12	hje:a	Lhjd;
    //   3244: invokestatic 38	hjd:a	(Lhjd;)V
    //   3247: return
    //   3248: lload 10
    //   3250: lconst_0
    //   3251: lcmp
    //   3252: ifeq +14 -> 3266
    //   3255: lload 10
    //   3257: lload 8
    //   3259: lload 22
    //   3261: ladd
    //   3262: lcmp
    //   3263: ifeq +1621 -> 4884
    //   3266: lload 22
    //   3268: lstore 8
    //   3270: lconst_0
    //   3271: lstore 12
    //   3273: goto -733 -> 2540
    //   3276: lload 12
    //   3278: lstore 18
    //   3280: lload 12
    //   3282: lstore 20
    //   3284: new 245	java/io/RandomAccessFile
    //   3287: dup
    //   3288: aload 40
    //   3290: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3293: ldc_w 451
    //   3296: invokespecial 454	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3299: astore 35
    //   3301: aload 35
    //   3303: lload 8
    //   3305: invokevirtual 457	java/io/RandomAccessFile:setLength	(J)V
    //   3308: aload 35
    //   3310: lload 12
    //   3312: invokevirtual 460	java/io/RandomAccessFile:seek	(J)V
    //   3315: aload 33
    //   3317: invokeinterface 464 1 0
    //   3322: astore 34
    //   3324: iload_2
    //   3325: newarray byte
    //   3327: astore 32
    //   3329: lload 6
    //   3331: lstore 10
    //   3333: lload 12
    //   3335: lstore 6
    //   3337: lload 10
    //   3339: lstore 16
    //   3341: lload 6
    //   3343: lstore 12
    //   3345: lload 10
    //   3347: lstore 24
    //   3349: lload 6
    //   3351: lstore 18
    //   3353: aload 40
    //   3355: getfield 137	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3358: invokevirtual 139	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3361: ifne +171 -> 3532
    //   3364: lload 6
    //   3366: lload 8
    //   3368: lcmp
    //   3369: ifge +163 -> 3532
    //   3372: lload 10
    //   3374: lstore 16
    //   3376: lload 6
    //   3378: lstore 12
    //   3380: lload 10
    //   3382: lstore 24
    //   3384: lload 6
    //   3386: lstore 18
    //   3388: aload 34
    //   3390: aload 32
    //   3392: invokevirtual 468	java/io/InputStream:read	([B)I
    //   3395: istore_3
    //   3396: lload 10
    //   3398: iload_3
    //   3399: i2l
    //   3400: ladd
    //   3401: lstore 20
    //   3403: lload 6
    //   3405: iload_3
    //   3406: i2l
    //   3407: ladd
    //   3408: lstore 22
    //   3410: lload 20
    //   3412: lstore 16
    //   3414: lload 22
    //   3416: lstore 12
    //   3418: lload 20
    //   3420: lstore 24
    //   3422: lload 22
    //   3424: lstore 18
    //   3426: aload 35
    //   3428: aload 32
    //   3430: iconst_0
    //   3431: iload_3
    //   3432: invokevirtual 472	java/io/RandomAccessFile:write	([BII)V
    //   3435: lload 20
    //   3437: lstore 10
    //   3439: lload 22
    //   3441: lstore 6
    //   3443: aload 41
    //   3445: ifnull -108 -> 3337
    //   3448: lload 20
    //   3450: lstore 16
    //   3452: lload 22
    //   3454: lstore 12
    //   3456: lload 20
    //   3458: lstore 24
    //   3460: lload 22
    //   3462: lstore 18
    //   3464: aload 40
    //   3466: getfield 87	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3469: iconst_2
    //   3470: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   3473: lload 20
    //   3475: lstore 16
    //   3477: lload 22
    //   3479: lstore 12
    //   3481: lload 20
    //   3483: lstore 24
    //   3485: lload 22
    //   3487: lstore 18
    //   3489: aload 40
    //   3491: lload 8
    //   3493: lload 22
    //   3495: invokevirtual 475	com/tencent/mobileqq/vip/DownloadTask:a	(JJ)V
    //   3498: lload 20
    //   3500: lstore 16
    //   3502: lload 22
    //   3504: lstore 12
    //   3506: lload 20
    //   3508: lstore 24
    //   3510: lload 22
    //   3512: lstore 18
    //   3514: aload 41
    //   3516: aload 40
    //   3518: invokevirtual 477	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3521: lload 20
    //   3523: lstore 10
    //   3525: lload 22
    //   3527: lstore 6
    //   3529: goto -192 -> 3337
    //   3532: lload 6
    //   3534: lload 8
    //   3536: lcmp
    //   3537: ifne +233 -> 3770
    //   3540: aload 41
    //   3542: ifnull +1605 -> 5147
    //   3545: lload 10
    //   3547: lstore 16
    //   3549: lload 6
    //   3551: lstore 12
    //   3553: lload 10
    //   3555: lstore 24
    //   3557: lload 6
    //   3559: lstore 18
    //   3561: aload 40
    //   3563: ldc_w 478
    //   3566: putfield 481	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Float	F
    //   3569: lload 10
    //   3571: lstore 16
    //   3573: lload 6
    //   3575: lstore 12
    //   3577: lload 10
    //   3579: lstore 24
    //   3581: lload 6
    //   3583: lstore 18
    //   3585: aload 40
    //   3587: getfield 87	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3590: iconst_3
    //   3591: invokevirtual 92	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   3594: lload 10
    //   3596: lstore 16
    //   3598: lload 6
    //   3600: lstore 12
    //   3602: lload 10
    //   3604: lstore 24
    //   3606: lload 6
    //   3608: lstore 18
    //   3610: aload 41
    //   3612: aload 40
    //   3614: invokevirtual 96	com/tencent/mobileqq/vip/DownloadListener:c	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   3617: goto +1530 -> 5147
    //   3620: lload 10
    //   3622: lstore 16
    //   3624: lload 6
    //   3626: lstore 12
    //   3628: lload 10
    //   3630: lstore 24
    //   3632: lload 6
    //   3634: lstore 18
    //   3636: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3639: ifeq +76 -> 3715
    //   3642: lload 10
    //   3644: lstore 16
    //   3646: lload 6
    //   3648: lstore 12
    //   3650: lload 10
    //   3652: lstore 24
    //   3654: lload 6
    //   3656: lstore 18
    //   3658: getstatic 115	hjd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3661: iconst_2
    //   3662: new 117	java/lang/StringBuilder
    //   3665: dup
    //   3666: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   3669: ldc_w 483
    //   3672: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3675: iload 29
    //   3677: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3680: ldc_w 485
    //   3683: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3686: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   3689: lload 26
    //   3691: lsub
    //   3692: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3695: ldc_w 487
    //   3698: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: aload 40
    //   3703: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3706: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3709: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3712: invokestatic 490	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3715: lload 10
    //   3717: lstore 16
    //   3719: lload 6
    //   3721: lstore 12
    //   3723: lload 10
    //   3725: lstore 24
    //   3727: lload 6
    //   3729: lstore 18
    //   3731: aload 40
    //   3733: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3736: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   3739: invokevirtual 494	java/io/File:setLastModified	(J)Z
    //   3742: pop
    //   3743: aload 33
    //   3745: astore 32
    //   3747: lload 10
    //   3749: lstore 16
    //   3751: lload 6
    //   3753: lstore 10
    //   3755: lload 8
    //   3757: lstore 6
    //   3759: lload 14
    //   3761: lstore 12
    //   3763: lload 16
    //   3765: lstore 8
    //   3767: goto -1029 -> 2738
    //   3770: iconst_0
    //   3771: istore 29
    //   3773: goto -153 -> 3620
    //   3776: lload 10
    //   3778: lstore 16
    //   3780: lload 6
    //   3782: lstore 18
    //   3784: lload 12
    //   3786: lstore 14
    //   3788: lload 8
    //   3790: lstore 20
    //   3792: aload 35
    //   3794: astore 36
    //   3796: aload 34
    //   3798: astore 38
    //   3800: aload 32
    //   3802: astore 37
    //   3804: aload_0
    //   3805: getfield 12	hje:a	Lhjd;
    //   3808: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   3811: iconst_1
    //   3812: putfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   3815: goto -860 -> 2955
    //   3818: astore 33
    //   3820: goto -2992 -> 828
    //   3823: astore 33
    //   3825: aload 42
    //   3827: monitorexit
    //   3828: lload 10
    //   3830: lstore 16
    //   3832: lload 6
    //   3834: lstore 18
    //   3836: lload 12
    //   3838: lstore 14
    //   3840: lload 8
    //   3842: lstore 20
    //   3844: aload 35
    //   3846: astore 36
    //   3848: aload 34
    //   3850: astore 38
    //   3852: aload 32
    //   3854: astore 37
    //   3856: aload 33
    //   3858: athrow
    //   3859: astore 35
    //   3861: aload 38
    //   3863: astore 32
    //   3865: aload 37
    //   3867: astore 33
    //   3869: aload 36
    //   3871: astore 34
    //   3873: lload 20
    //   3875: lstore 8
    //   3877: lload 18
    //   3879: lstore 6
    //   3881: lload 16
    //   3883: lstore 12
    //   3885: aload 33
    //   3887: ifnull +10 -> 3897
    //   3890: aload 33
    //   3892: invokeinterface 238 1 0
    //   3897: aload 32
    //   3899: ifnull +8 -> 3907
    //   3902: aload 32
    //   3904: invokevirtual 243	java/io/InputStream:close	()V
    //   3907: aload 34
    //   3909: ifnull +8 -> 3917
    //   3912: aload 34
    //   3914: invokevirtual 246	java/io/RandomAccessFile:close	()V
    //   3917: lload 12
    //   3919: lconst_0
    //   3920: lcmp
    //   3921: ifeq +38 -> 3959
    //   3924: lload 6
    //   3926: lconst_0
    //   3927: lcmp
    //   3928: ifeq +31 -> 3959
    //   3931: lload 12
    //   3933: lload 6
    //   3935: lcmp
    //   3936: ifne +500 -> 4436
    //   3939: aload 40
    //   3941: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3944: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   3947: invokestatic 248	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;)V
    //   3950: aload 40
    //   3952: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3955: invokevirtual 251	java/io/File:delete	()Z
    //   3958: pop
    //   3959: aload_0
    //   3960: getfield 12	hje:a	Lhjd;
    //   3963: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3966: ifnull +29 -> 3995
    //   3969: aload 41
    //   3971: ifnull +24 -> 3995
    //   3974: lload 8
    //   3976: lconst_0
    //   3977: lcmp
    //   3978: ifle +17 -> 3995
    //   3981: aload 41
    //   3983: aload_0
    //   3984: getfield 12	hje:a	Lhjd;
    //   3987: getfield 254	hjd:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3990: lload 8
    //   3992: invokevirtual 257	com/tencent/mobileqq/vip/DownloadListener:a	(Lcom/tencent/common/app/AppInterface;J)V
    //   3995: aload_0
    //   3996: getfield 12	hje:a	Lhjd;
    //   3999: aload 40
    //   4001: invokestatic 99	hjd:a	(Lhjd;Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   4004: aload_0
    //   4005: getfield 12	hje:a	Lhjd;
    //   4008: invokestatic 38	hjd:a	(Lhjd;)V
    //   4011: aload 35
    //   4013: athrow
    //   4014: lload 10
    //   4016: lstore 16
    //   4018: lload 6
    //   4020: lstore 18
    //   4022: lload 12
    //   4024: lstore 14
    //   4026: lload 8
    //   4028: lstore 20
    //   4030: aload 35
    //   4032: astore 36
    //   4034: aload 34
    //   4036: astore 38
    //   4038: aload 32
    //   4040: astore 37
    //   4042: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   4045: ldc2_w 83
    //   4048: ldiv
    //   4049: l2i
    //   4050: istore_2
    //   4051: lload 10
    //   4053: lstore 16
    //   4055: lload 6
    //   4057: lstore 18
    //   4059: lload 12
    //   4061: lstore 14
    //   4063: lload 8
    //   4065: lstore 20
    //   4067: aload 35
    //   4069: astore 36
    //   4071: aload 34
    //   4073: astore 38
    //   4075: aload 32
    //   4077: astore 37
    //   4079: aload_0
    //   4080: getfield 12	hje:a	Lhjd;
    //   4083: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4086: getfield 64	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:jdField_a_of_type_Boolean	Z
    //   4089: ifeq +51 -> 4140
    //   4092: lload 10
    //   4094: lstore 16
    //   4096: lload 6
    //   4098: lstore 18
    //   4100: lload 12
    //   4102: lstore 14
    //   4104: lload 8
    //   4106: lstore 20
    //   4108: aload 35
    //   4110: astore 36
    //   4112: aload 34
    //   4114: astore 38
    //   4116: aload 32
    //   4118: astore 37
    //   4120: aload_0
    //   4121: getfield 12	hje:a	Lhjd;
    //   4124: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4127: aload 40
    //   4129: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4132: iload_2
    //   4133: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4136: invokevirtual 498	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4139: pop
    //   4140: lload 10
    //   4142: lstore 16
    //   4144: lload 6
    //   4146: lstore 18
    //   4148: lload 12
    //   4150: lstore 14
    //   4152: lload 8
    //   4154: lstore 20
    //   4156: aload 35
    //   4158: astore 36
    //   4160: aload 34
    //   4162: astore 38
    //   4164: aload 32
    //   4166: astore 37
    //   4168: new 200	java/lang/Exception
    //   4171: dup
    //   4172: new 117	java/lang/StringBuilder
    //   4175: dup
    //   4176: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   4179: ldc_w 500
    //   4182: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: aload 40
    //   4187: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4190: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4193: ldc_w 502
    //   4196: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4199: aload_0
    //   4200: getfield 12	hje:a	Lhjd;
    //   4203: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4206: getfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   4209: invokevirtual 360	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4212: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4215: invokespecial 206	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4218: athrow
    //   4219: lload 10
    //   4221: lstore 16
    //   4223: lload 6
    //   4225: lstore 18
    //   4227: lload 12
    //   4229: lstore 14
    //   4231: lload 8
    //   4233: lstore 20
    //   4235: aload 35
    //   4237: astore 36
    //   4239: aload 34
    //   4241: astore 38
    //   4243: aload 32
    //   4245: astore 37
    //   4247: aload_0
    //   4248: getfield 12	hje:a	Lhjd;
    //   4251: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4254: aload 40
    //   4256: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4259: invokevirtual 505	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   4262: ifeq -1227 -> 3035
    //   4265: lload 10
    //   4267: lstore 16
    //   4269: lload 6
    //   4271: lstore 18
    //   4273: lload 12
    //   4275: lstore 14
    //   4277: lload 8
    //   4279: lstore 20
    //   4281: aload 35
    //   4283: astore 36
    //   4285: aload 34
    //   4287: astore 38
    //   4289: aload 32
    //   4291: astore 37
    //   4293: aload_0
    //   4294: getfield 12	hje:a	Lhjd;
    //   4297: invokestatic 67	hjd:a	(Lhjd;)Ljava/util/concurrent/ConcurrentHashMap;
    //   4300: aload 40
    //   4302: getfield 70	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4305: invokevirtual 108	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4308: pop
    //   4309: goto -1274 -> 3035
    //   4312: aload 40
    //   4314: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4317: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   4320: lload 10
    //   4322: lload 6
    //   4324: lload 12
    //   4326: invokestatic 508	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4329: goto -1134 -> 3195
    //   4332: lload 10
    //   4334: lstore 16
    //   4336: lload 6
    //   4338: lstore 18
    //   4340: lload 12
    //   4342: lstore 14
    //   4344: lload 8
    //   4346: lstore 20
    //   4348: aload 35
    //   4350: astore 36
    //   4352: aload 34
    //   4354: astore 38
    //   4356: aload 32
    //   4358: astore 37
    //   4360: aload_0
    //   4361: getfield 12	hje:a	Lhjd;
    //   4364: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4367: iconst_0
    //   4368: putfield 225	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:c	Z
    //   4371: goto -3265 -> 1106
    //   4374: lload 10
    //   4376: lstore 16
    //   4378: lload 6
    //   4380: lstore 18
    //   4382: lload 12
    //   4384: lstore 14
    //   4386: lload 8
    //   4388: lstore 20
    //   4390: aload 35
    //   4392: astore 36
    //   4394: aload 34
    //   4396: astore 38
    //   4398: aload 32
    //   4400: astore 37
    //   4402: aload_0
    //   4403: getfield 12	hje:a	Lhjd;
    //   4406: invokestatic 59	hjd:a	(Lhjd;)Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;
    //   4409: iconst_1
    //   4410: putfield 227	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:d	Z
    //   4413: goto -3232 -> 1181
    //   4416: aload 40
    //   4418: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4421: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   4424: lload 10
    //   4426: lload 6
    //   4428: lload 12
    //   4430: invokestatic 508	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4433: goto -3007 -> 1426
    //   4436: aload 40
    //   4438: getfield 178	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   4441: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   4444: lload 12
    //   4446: lload 6
    //   4448: lload 14
    //   4450: invokestatic 508	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;JJJ)V
    //   4453: goto -494 -> 3959
    //   4456: astore 33
    //   4458: goto -1426 -> 3032
    //   4461: astore 32
    //   4463: goto -546 -> 3917
    //   4466: astore 35
    //   4468: aconst_null
    //   4469: astore 33
    //   4471: aconst_null
    //   4472: astore 32
    //   4474: aconst_null
    //   4475: astore 34
    //   4477: lload 20
    //   4479: lstore 6
    //   4481: lload 16
    //   4483: lstore 14
    //   4485: lconst_0
    //   4486: lstore 8
    //   4488: lload 10
    //   4490: lstore 12
    //   4492: goto -607 -> 3885
    //   4495: astore 32
    //   4497: aload 35
    //   4499: astore 36
    //   4501: aload 34
    //   4503: astore 37
    //   4505: lload 8
    //   4507: lstore 6
    //   4509: lload 16
    //   4511: lstore 8
    //   4513: aload 32
    //   4515: astore 35
    //   4517: aload 36
    //   4519: astore 34
    //   4521: aload 37
    //   4523: astore 32
    //   4525: goto -640 -> 3885
    //   4528: astore 35
    //   4530: lload 8
    //   4532: lstore 12
    //   4534: lload 6
    //   4536: lstore 8
    //   4538: lload 10
    //   4540: lstore 6
    //   4542: aload 36
    //   4544: astore 33
    //   4546: goto -661 -> 3885
    //   4549: astore 35
    //   4551: lload 8
    //   4553: lstore 10
    //   4555: lload 6
    //   4557: lstore 8
    //   4559: lload 18
    //   4561: lstore 12
    //   4563: lload 10
    //   4565: lstore 6
    //   4567: goto -682 -> 3885
    //   4570: astore 34
    //   4572: aload 35
    //   4574: astore 36
    //   4576: lload 6
    //   4578: lstore 10
    //   4580: lload 8
    //   4582: lstore 6
    //   4584: aload 34
    //   4586: astore 35
    //   4588: lload 10
    //   4590: lstore 8
    //   4592: aload 36
    //   4594: astore 34
    //   4596: goto -711 -> 3885
    //   4599: astore 32
    //   4601: aload 35
    //   4603: astore 36
    //   4605: aload 34
    //   4607: astore 37
    //   4609: lload 8
    //   4611: lstore 10
    //   4613: lload 6
    //   4615: lstore 8
    //   4617: lload 10
    //   4619: lstore 6
    //   4621: aload 32
    //   4623: astore 35
    //   4625: aload 36
    //   4627: astore 34
    //   4629: aload 37
    //   4631: astore 32
    //   4633: goto -748 -> 3885
    //   4636: astore 32
    //   4638: goto -3254 -> 1384
    //   4641: astore 33
    //   4643: aconst_null
    //   4644: astore 39
    //   4646: lconst_0
    //   4647: lstore 10
    //   4649: aconst_null
    //   4650: astore 35
    //   4652: aconst_null
    //   4653: astore 34
    //   4655: aconst_null
    //   4656: astore 32
    //   4658: lconst_0
    //   4659: lstore 8
    //   4661: lconst_0
    //   4662: lstore 12
    //   4664: iconst_0
    //   4665: istore 28
    //   4667: iconst_0
    //   4668: istore_1
    //   4669: lconst_0
    //   4670: lstore 6
    //   4672: goto -3844 -> 828
    //   4675: astore 35
    //   4677: iload_3
    //   4678: istore_1
    //   4679: lload 8
    //   4681: lstore 12
    //   4683: aload 33
    //   4685: astore 36
    //   4687: lload 10
    //   4689: lstore 16
    //   4691: lload 6
    //   4693: lstore 8
    //   4695: aload 35
    //   4697: astore 33
    //   4699: lload 12
    //   4701: lstore 10
    //   4703: lload 16
    //   4705: lstore 6
    //   4707: lload 14
    //   4709: lstore 12
    //   4711: aload 34
    //   4713: astore 35
    //   4715: aload 32
    //   4717: astore 34
    //   4719: aload 36
    //   4721: astore 32
    //   4723: goto -3895 -> 828
    //   4726: astore 35
    //   4728: aload 33
    //   4730: astore 36
    //   4732: lload 6
    //   4734: lstore 16
    //   4736: lload 8
    //   4738: lstore 6
    //   4740: aload 35
    //   4742: astore 33
    //   4744: lload 20
    //   4746: lstore 10
    //   4748: lload 14
    //   4750: lstore 12
    //   4752: lload 16
    //   4754: lstore 8
    //   4756: aload 34
    //   4758: astore 35
    //   4760: aload 32
    //   4762: astore 34
    //   4764: aload 36
    //   4766: astore 32
    //   4768: goto -3940 -> 828
    //   4771: astore 34
    //   4773: aload 33
    //   4775: astore 36
    //   4777: lload 8
    //   4779: lstore 16
    //   4781: lload 6
    //   4783: lstore 8
    //   4785: aload 34
    //   4787: astore 33
    //   4789: lload 12
    //   4791: lstore 10
    //   4793: lload 16
    //   4795: lstore 6
    //   4797: lload 14
    //   4799: lstore 12
    //   4801: aload 32
    //   4803: astore 34
    //   4805: aload 36
    //   4807: astore 32
    //   4809: goto -3981 -> 828
    //   4812: astore 36
    //   4814: aload 33
    //   4816: astore 32
    //   4818: lload 6
    //   4820: lstore 16
    //   4822: lload 8
    //   4824: lstore 6
    //   4826: aload 36
    //   4828: astore 33
    //   4830: lload 12
    //   4832: lstore 10
    //   4834: lload 14
    //   4836: lstore 12
    //   4838: lload 16
    //   4840: lstore 8
    //   4842: goto -4014 -> 828
    //   4845: astore 32
    //   4847: goto -1694 -> 3153
    //   4850: iconst_0
    //   4851: istore 29
    //   4853: lload 8
    //   4855: lstore 12
    //   4857: lload 6
    //   4859: lstore 8
    //   4861: lload 12
    //   4863: lstore 6
    //   4865: lload 14
    //   4867: lstore 12
    //   4869: aload 34
    //   4871: astore 35
    //   4873: aload 32
    //   4875: astore 34
    //   4877: aload 33
    //   4879: astore 32
    //   4881: goto -2143 -> 2738
    //   4884: lload 8
    //   4886: lstore 12
    //   4888: lload 10
    //   4890: lstore 8
    //   4892: goto -2352 -> 2540
    //   4895: lload 8
    //   4897: lstore 12
    //   4899: iload 30
    //   4901: istore 29
    //   4903: lload 6
    //   4905: lstore 8
    //   4907: lload 10
    //   4909: lstore 6
    //   4911: lload 12
    //   4913: lstore 10
    //   4915: lload 14
    //   4917: lstore 12
    //   4919: aload 34
    //   4921: astore 35
    //   4923: aload 32
    //   4925: astore 34
    //   4927: aload 33
    //   4929: astore 32
    //   4931: goto -2193 -> 2738
    //   4934: iload_3
    //   4935: istore 5
    //   4937: goto -2806 -> 2131
    //   4940: aload 32
    //   4942: astore 33
    //   4944: iload 29
    //   4946: istore 30
    //   4948: aload 34
    //   4950: astore 32
    //   4952: lload 10
    //   4954: lstore 16
    //   4956: iconst_1
    //   4957: istore_1
    //   4958: lload 6
    //   4960: lstore 10
    //   4962: iload 28
    //   4964: istore 29
    //   4966: lload 8
    //   4968: lstore 6
    //   4970: lload 12
    //   4972: lstore 14
    //   4974: lload 16
    //   4976: lstore 8
    //   4978: aload 35
    //   4980: astore 34
    //   4982: goto -3364 -> 1618
    //   4985: iconst_1
    //   4986: istore_2
    //   4987: goto -3933 -> 1054
    //   4990: astore 35
    //   4992: iload 31
    //   4994: istore 28
    //   4996: lload 8
    //   4998: lstore 12
    //   5000: aload 33
    //   5002: astore 36
    //   5004: lload 10
    //   5006: lstore 16
    //   5008: lload 6
    //   5010: lstore 8
    //   5012: aload 35
    //   5014: astore 33
    //   5016: lload 12
    //   5018: lstore 10
    //   5020: lload 16
    //   5022: lstore 6
    //   5024: lload 14
    //   5026: lstore 12
    //   5028: aload 34
    //   5030: astore 35
    //   5032: aload 32
    //   5034: astore 34
    //   5036: aload 36
    //   5038: astore 32
    //   5040: goto -4212 -> 828
    //   5043: sipush 200
    //   5046: iload_3
    //   5047: if_icmpeq -2663 -> 2384
    //   5050: sipush 206
    //   5053: iload_3
    //   5054: if_icmpne -159 -> 4895
    //   5057: goto -2673 -> 2384
    //   5060: astore 33
    //   5062: lload 8
    //   5064: lstore 12
    //   5066: aload 35
    //   5068: astore 36
    //   5070: lload 10
    //   5072: lstore 16
    //   5074: lload 6
    //   5076: lstore 8
    //   5078: lload 12
    //   5080: lstore 10
    //   5082: lload 16
    //   5084: lstore 6
    //   5086: lload 14
    //   5088: lstore 12
    //   5090: aload 34
    //   5092: astore 35
    //   5094: aload 32
    //   5096: astore 34
    //   5098: aload 36
    //   5100: astore 32
    //   5102: goto -4274 -> 828
    //   5105: sipush 4096
    //   5108: istore_2
    //   5109: iconst_0
    //   5110: istore 28
    //   5112: aconst_null
    //   5113: astore 35
    //   5115: goto -2984 -> 2131
    //   5118: astore 36
    //   5120: aload 33
    //   5122: astore 32
    //   5124: lload 18
    //   5126: lstore 10
    //   5128: lload 8
    //   5130: lstore 6
    //   5132: aload 36
    //   5134: astore 33
    //   5136: lload 14
    //   5138: lstore 12
    //   5140: lload 24
    //   5142: lstore 8
    //   5144: goto -4316 -> 828
    //   5147: iconst_1
    //   5148: istore 29
    //   5150: goto -1530 -> 3620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5153	0	this	hje
    //   112	4846	1	i	int
    //   942	4167	2	j	int
    //   1910	3145	3	k	int
    //   1586	1490	4	m	int
    //   1907	3029	5	n	int
    //   354	4777	6	l1	long
    //   308	4835	8	l2	long
    //   326	4801	10	l3	long
    //   350	4789	12	l4	long
    //   346	4791	14	l5	long
    //   318	4765	16	l6	long
    //   311	4814	18	l7	long
    //   322	4423	20	l8	long
    //   314	3212	22	l9	long
    //   625	4516	24	l10	long
    //   371	3319	26	l11	long
    //   816	4295	28	bool1	boolean
    //   1595	3554	29	bool2	boolean
    //   1589	3358	30	bool3	boolean
    //   1624	3369	31	bool4	boolean
    //   7	4392	32	localObject1	Object
    //   4461	1	32	localIOException1	java.io.IOException
    //   4472	1	32	localObject2	Object
    //   4495	19	32	localObject3	Object
    //   4523	1	32	localObject4	Object
    //   4599	23	32	localObject5	Object
    //   4631	1	32	localObject6	Object
    //   4636	1	32	localIOException2	java.io.IOException
    //   4656	161	32	localObject7	Object
    //   4845	29	32	localIOException3	java.io.IOException
    //   4879	244	32	localObject8	Object
    //   43	6	33	localObject9	Object
    //   797	474	33	localThrowable1	java.lang.Throwable
    //   1592	2152	33	localHttpEntity	org.apache.http.HttpEntity
    //   3818	1	33	localThrowable2	java.lang.Throwable
    //   3823	34	33	localObject10	Object
    //   3867	24	33	localObject11	Object
    //   4456	1	33	localInterruptedException	java.lang.InterruptedException
    //   4469	76	33	localObject12	Object
    //   4641	43	33	localThrowable3	java.lang.Throwable
    //   4697	318	33	localObject13	Object
    //   5060	61	33	localThrowable4	java.lang.Throwable
    //   5134	1	33	localObject14	Object
    //   807	3713	34	localObject15	Object
    //   4570	15	34	localObject16	Object
    //   4594	169	34	localObject17	Object
    //   4771	15	34	localThrowable5	java.lang.Throwable
    //   4803	294	34	localObject18	Object
    //   804	3041	35	localObject19	Object
    //   3859	532	35	localObject20	Object
    //   4466	32	35	localObject21	Object
    //   4515	1	35	localObject22	Object
    //   4528	1	35	localObject23	Object
    //   4549	24	35	localObject24	Object
    //   4586	65	35	localObject25	Object
    //   4675	21	35	localThrowable6	java.lang.Throwable
    //   4713	1	35	localObject26	Object
    //   4726	15	35	localThrowable7	java.lang.Throwable
    //   4758	221	35	localObject27	Object
    //   4990	23	35	localThrowable8	java.lang.Throwable
    //   5030	84	35	localObject28	Object
    //   846	3960	36	localObject29	Object
    //   4812	15	36	localThrowable9	java.lang.Throwable
    //   5002	97	36	localObject30	Object
    //   5118	15	36	localThrowable10	java.lang.Throwable
    //   854	3776	37	localObject31	Object
    //   850	3547	38	localObject32	Object
    //   342	4303	39	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   25	4412	40	localDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    //   65	3917	41	localDownloadListener	com.tencent.mobileqq.vip.DownloadListener
    //   305	3521	42	localObject33	Object
    //   409	1894	43	localHttpGet	org.apache.http.client.methods.HttpGet
    //   442	1716	44	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   12	30	43	finally
    //   45	48	43	finally
    //   368	373	797	java/lang/Throwable
    //   397	411	797	java/lang/Throwable
    //   435	444	797	java/lang/Throwable
    //   468	483	797	java/lang/Throwable
    //   507	522	797	java/lang/Throwable
    //   546	558	797	java/lang/Throwable
    //   582	595	797	java/lang/Throwable
    //   651	661	797	java/lang/Throwable
    //   698	706	797	java/lang/Throwable
    //   734	742	797	java/lang/Throwable
    //   766	797	797	java/lang/Throwable
    //   1503	1509	797	java/lang/Throwable
    //   1533	1583	797	java/lang/Throwable
    //   2772	2783	3818	java/lang/Throwable
    //   2816	2824	3818	java/lang/Throwable
    //   2852	2863	3818	java/lang/Throwable
    //   2891	2903	3818	java/lang/Throwable
    //   2931	2955	3818	java/lang/Throwable
    //   2983	2993	3818	java/lang/Throwable
    //   3021	3024	3818	java/lang/Throwable
    //   3068	3078	3818	java/lang/Throwable
    //   3106	3116	3818	java/lang/Throwable
    //   3804	3815	3818	java/lang/Throwable
    //   3856	3859	3818	java/lang/Throwable
    //   4042	4051	3818	java/lang/Throwable
    //   4079	4092	3818	java/lang/Throwable
    //   4120	4140	3818	java/lang/Throwable
    //   4168	4219	3818	java/lang/Throwable
    //   4247	4265	3818	java/lang/Throwable
    //   4293	4309	3818	java/lang/Throwable
    //   3024	3032	3823	finally
    //   3032	3035	3823	finally
    //   3825	3828	3823	finally
    //   856	864	3859	finally
    //   892	897	3859	finally
    //   930	941	3859	finally
    //   971	979	3859	finally
    //   1007	1015	3859	finally
    //   1043	1051	3859	finally
    //   1095	1106	3859	finally
    //   1134	1142	3859	finally
    //   1170	1181	3859	finally
    //   1209	1215	3859	finally
    //   1243	1275	3859	finally
    //   1308	1317	3859	finally
    //   1345	1352	3859	finally
    //   2772	2783	3859	finally
    //   2816	2824	3859	finally
    //   2852	2863	3859	finally
    //   2891	2903	3859	finally
    //   2931	2955	3859	finally
    //   2983	2993	3859	finally
    //   3021	3024	3859	finally
    //   3068	3078	3859	finally
    //   3106	3116	3859	finally
    //   3804	3815	3859	finally
    //   3856	3859	3859	finally
    //   4042	4051	3859	finally
    //   4079	4092	3859	finally
    //   4120	4140	3859	finally
    //   4168	4219	3859	finally
    //   4247	4265	3859	finally
    //   4293	4309	3859	finally
    //   4360	4371	3859	finally
    //   4402	4413	3859	finally
    //   3024	3032	4456	java/lang/InterruptedException
    //   3890	3897	4461	java/io/IOException
    //   3902	3907	4461	java/io/IOException
    //   3912	3917	4461	java/io/IOException
    //   328	344	4466	finally
    //   368	373	4466	finally
    //   397	411	4466	finally
    //   435	444	4466	finally
    //   468	483	4466	finally
    //   507	522	4466	finally
    //   546	558	4466	finally
    //   582	595	4466	finally
    //   651	661	4466	finally
    //   698	706	4466	finally
    //   734	742	4466	finally
    //   766	797	4466	finally
    //   1503	1509	4466	finally
    //   1533	1583	4466	finally
    //   3353	3364	4495	finally
    //   3388	3396	4495	finally
    //   3426	3435	4495	finally
    //   3464	3473	4495	finally
    //   3489	3498	4495	finally
    //   3514	3521	4495	finally
    //   3561	3569	4495	finally
    //   3585	3594	4495	finally
    //   3610	3617	4495	finally
    //   3636	3642	4495	finally
    //   3658	3715	4495	finally
    //   3731	3743	4495	finally
    //   1626	1634	4528	finally
    //   1647	1679	4528	finally
    //   1687	1722	4528	finally
    //   1730	1735	4528	finally
    //   1743	1749	4528	finally
    //   1757	1770	4528	finally
    //   1778	1783	4528	finally
    //   1791	1799	4528	finally
    //   1807	1820	4528	finally
    //   1828	1838	4528	finally
    //   1846	1864	4528	finally
    //   1872	1883	4528	finally
    //   1891	1903	4528	finally
    //   1919	1927	4528	finally
    //   1939	1952	4528	finally
    //   1960	1965	4528	finally
    //   1973	1978	4528	finally
    //   2018	2040	4528	finally
    //   2058	2069	4528	finally
    //   2077	2088	4528	finally
    //   2096	2107	4528	finally
    //   2115	2128	4528	finally
    //   2137	2149	4528	finally
    //   2155	2162	4528	finally
    //   2168	2174	4528	finally
    //   2180	2293	4528	finally
    //   2299	2309	4528	finally
    //   2319	2332	4528	finally
    //   2340	2346	4528	finally
    //   2354	2381	4528	finally
    //   2392	2401	4528	finally
    //   2409	2418	4528	finally
    //   2433	2465	4528	finally
    //   2476	2489	4528	finally
    //   2497	2517	4528	finally
    //   2548	2554	4549	finally
    //   2562	2634	4549	finally
    //   2657	2668	4549	finally
    //   2679	2690	4549	finally
    //   2698	2707	4549	finally
    //   3284	3301	4549	finally
    //   3301	3324	4570	finally
    //   3324	3329	4599	finally
    //   1357	1364	4636	java/io/IOException
    //   1369	1374	4636	java/io/IOException
    //   1379	1384	4636	java/io/IOException
    //   328	344	4641	java/lang/Throwable
    //   2137	2149	4675	java/lang/Throwable
    //   2155	2162	4675	java/lang/Throwable
    //   2168	2174	4675	java/lang/Throwable
    //   2180	2293	4675	java/lang/Throwable
    //   2299	2309	4675	java/lang/Throwable
    //   2548	2554	4726	java/lang/Throwable
    //   2562	2634	4726	java/lang/Throwable
    //   2657	2668	4726	java/lang/Throwable
    //   2679	2690	4726	java/lang/Throwable
    //   2698	2707	4726	java/lang/Throwable
    //   3284	3301	4726	java/lang/Throwable
    //   3301	3324	4771	java/lang/Throwable
    //   3324	3329	4812	java/lang/Throwable
    //   3126	3133	4845	java/io/IOException
    //   3138	3143	4845	java/io/IOException
    //   3148	3153	4845	java/io/IOException
    //   1626	1634	4990	java/lang/Throwable
    //   1647	1679	4990	java/lang/Throwable
    //   1687	1722	4990	java/lang/Throwable
    //   1730	1735	4990	java/lang/Throwable
    //   1743	1749	4990	java/lang/Throwable
    //   1757	1770	4990	java/lang/Throwable
    //   1778	1783	4990	java/lang/Throwable
    //   1791	1799	4990	java/lang/Throwable
    //   1807	1820	4990	java/lang/Throwable
    //   1828	1838	4990	java/lang/Throwable
    //   1846	1864	4990	java/lang/Throwable
    //   1872	1883	4990	java/lang/Throwable
    //   1891	1903	4990	java/lang/Throwable
    //   1919	1927	4990	java/lang/Throwable
    //   1939	1952	4990	java/lang/Throwable
    //   1960	1965	4990	java/lang/Throwable
    //   1973	1978	4990	java/lang/Throwable
    //   2018	2040	4990	java/lang/Throwable
    //   2058	2069	4990	java/lang/Throwable
    //   2077	2088	4990	java/lang/Throwable
    //   2096	2107	4990	java/lang/Throwable
    //   2115	2128	4990	java/lang/Throwable
    //   2319	2332	5060	java/lang/Throwable
    //   2340	2346	5060	java/lang/Throwable
    //   2354	2381	5060	java/lang/Throwable
    //   2392	2401	5060	java/lang/Throwable
    //   2409	2418	5060	java/lang/Throwable
    //   2433	2465	5060	java/lang/Throwable
    //   2476	2489	5060	java/lang/Throwable
    //   2497	2517	5060	java/lang/Throwable
    //   3353	3364	5118	java/lang/Throwable
    //   3388	3396	5118	java/lang/Throwable
    //   3426	3435	5118	java/lang/Throwable
    //   3464	3473	5118	java/lang/Throwable
    //   3489	3498	5118	java/lang/Throwable
    //   3514	3521	5118	java/lang/Throwable
    //   3561	3569	5118	java/lang/Throwable
    //   3585	3594	5118	java/lang/Throwable
    //   3610	3617	5118	java/lang/Throwable
    //   3636	3642	5118	java/lang/Throwable
    //   3658	3715	5118	java/lang/Throwable
    //   3731	3743	5118	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hje
 * JD-Core Version:    0.7.0.1
 */