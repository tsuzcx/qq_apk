import java.util.List;

public class apzt
{
  public static apzt.a a(String paramString)
  {
    return a(new String[] { paramString });
  }
  
  /* Error */
  public static apzt.a a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 6	apzt$a
    //   3: dup
    //   4: invokespecial 22	apzt$a:<init>	()V
    //   7: astore 16
    //   9: aload_0
    //   10: ifnull +8 -> 18
    //   13: aload_0
    //   14: arraylength
    //   15: ifne +12 -> 27
    //   18: aload 16
    //   20: iconst_0
    //   21: putfield 26	apzt$a:success	Z
    //   24: aload 16
    //   26: areturn
    //   27: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +28 -> 58
    //   33: ldc 34
    //   35: iconst_2
    //   36: new 36	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   43: ldc 39
    //   45: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aconst_null
    //   59: astore 9
    //   61: aconst_null
    //   62: astore 14
    //   64: aconst_null
    //   65: astore 6
    //   67: aconst_null
    //   68: astore 13
    //   70: aconst_null
    //   71: astore 15
    //   73: aconst_null
    //   74: astore 12
    //   76: new 56	java/util/ArrayList
    //   79: dup
    //   80: invokespecial 57	java/util/ArrayList:<init>	()V
    //   83: astore 17
    //   85: invokestatic 63	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   88: ldc 65
    //   90: invokevirtual 69	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   93: astore 4
    //   95: new 71	java/io/DataOutputStream
    //   98: dup
    //   99: aload 4
    //   101: invokevirtual 77	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   104: invokespecial 80	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   107: astore 8
    //   109: aload 8
    //   111: astore 11
    //   113: aload 15
    //   115: astore 7
    //   117: aload 14
    //   119: astore 10
    //   121: aload 4
    //   123: astore 9
    //   125: aload_0
    //   126: arraylength
    //   127: istore_2
    //   128: iconst_0
    //   129: istore_1
    //   130: goto +952 -> 1082
    //   133: aload 8
    //   135: astore 11
    //   137: aload 15
    //   139: astore 7
    //   141: aload 14
    //   143: astore 10
    //   145: aload 4
    //   147: astore 9
    //   149: aload 8
    //   151: aload 5
    //   153: invokevirtual 84	java/lang/String:getBytes	()[B
    //   156: invokevirtual 88	java/io/DataOutputStream:write	([B)V
    //   159: aload 8
    //   161: astore 11
    //   163: aload 15
    //   165: astore 7
    //   167: aload 14
    //   169: astore 10
    //   171: aload 4
    //   173: astore 9
    //   175: aload 8
    //   177: ldc 90
    //   179: invokevirtual 94	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   182: aload 8
    //   184: astore 11
    //   186: aload 15
    //   188: astore 7
    //   190: aload 14
    //   192: astore 10
    //   194: aload 4
    //   196: astore 9
    //   198: aload 8
    //   200: invokevirtual 97	java/io/DataOutputStream:flush	()V
    //   203: goto +894 -> 1097
    //   206: astore 6
    //   208: iconst_m1
    //   209: istore_1
    //   210: aconst_null
    //   211: astore 7
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 9
    //   218: aload 4
    //   220: astore 5
    //   222: aload 9
    //   224: astore 4
    //   226: aload 6
    //   228: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   231: aload 8
    //   233: ifnull +8 -> 241
    //   236: aload 8
    //   238: invokevirtual 103	java/io/DataOutputStream:close	()V
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 106	java/io/BufferedReader:close	()V
    //   251: aload_0
    //   252: ifnull +7 -> 259
    //   255: aload_0
    //   256: invokevirtual 106	java/io/BufferedReader:close	()V
    //   259: iload_1
    //   260: istore_2
    //   261: aload 7
    //   263: astore_0
    //   264: aload 5
    //   266: ifnull +13 -> 279
    //   269: aload 5
    //   271: invokevirtual 109	java/lang/Process:destroy	()V
    //   274: aload 7
    //   276: astore_0
    //   277: iload_1
    //   278: istore_2
    //   279: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +32 -> 314
    //   285: ldc 34
    //   287: iconst_2
    //   288: getstatic 115	java/util/Locale:CHINA	Ljava/util/Locale;
    //   291: ldc 117
    //   293: iconst_2
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_0
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: iload_2
    //   304: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: invokestatic 127	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   311: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: iload_2
    //   315: ifne +488 -> 803
    //   318: iconst_1
    //   319: istore_3
    //   320: aload 16
    //   322: iload_3
    //   323: putfield 26	apzt$a:success	Z
    //   326: aload 16
    //   328: aload 17
    //   330: putfield 131	apzt$a:result	Ljava/util/List;
    //   333: aload_0
    //   334: ifnull +12 -> 346
    //   337: aload 16
    //   339: aload_0
    //   340: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: putfield 135	apzt$a:errMsg	Ljava/lang/String;
    //   346: aload 16
    //   348: areturn
    //   349: aload 8
    //   351: astore 11
    //   353: aload 15
    //   355: astore 7
    //   357: aload 14
    //   359: astore 10
    //   361: aload 4
    //   363: astore 9
    //   365: aload 8
    //   367: ldc 137
    //   369: invokevirtual 94	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   372: aload 8
    //   374: astore 11
    //   376: aload 15
    //   378: astore 7
    //   380: aload 14
    //   382: astore 10
    //   384: aload 4
    //   386: astore 9
    //   388: aload 8
    //   390: invokevirtual 97	java/io/DataOutputStream:flush	()V
    //   393: aload 8
    //   395: astore 11
    //   397: aload 15
    //   399: astore 7
    //   401: aload 14
    //   403: astore 10
    //   405: aload 4
    //   407: astore 9
    //   409: aload 4
    //   411: invokevirtual 141	java/lang/Process:waitFor	()I
    //   414: istore_1
    //   415: aload 8
    //   417: astore 11
    //   419: aload 15
    //   421: astore 7
    //   423: aload 14
    //   425: astore 10
    //   427: aload 4
    //   429: astore 9
    //   431: new 36	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   438: astore 5
    //   440: aload 8
    //   442: astore 11
    //   444: aload 15
    //   446: astore 7
    //   448: aload 14
    //   450: astore 10
    //   452: aload 4
    //   454: astore 9
    //   456: new 105	java/io/BufferedReader
    //   459: dup
    //   460: new 143	java/io/InputStreamReader
    //   463: dup
    //   464: aload 4
    //   466: invokevirtual 147	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   469: invokespecial 150	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   472: invokespecial 153	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   475: astore_0
    //   476: new 105	java/io/BufferedReader
    //   479: dup
    //   480: new 143	java/io/InputStreamReader
    //   483: dup
    //   484: aload 4
    //   486: invokevirtual 156	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   489: invokespecial 150	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   492: invokespecial 153	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   495: astore 9
    //   497: aload_0
    //   498: invokevirtual 159	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   501: astore 6
    //   503: aload 6
    //   505: ifnull +48 -> 553
    //   508: aload 17
    //   510: aload 6
    //   512: invokeinterface 165 2 0
    //   517: pop
    //   518: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -24 -> 497
    //   524: ldc 34
    //   526: iconst_2
    //   527: new 36	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   534: ldc 167
    //   536: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 6
    //   541: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: goto -53 -> 497
    //   553: aload 9
    //   555: invokevirtual 159	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   558: astore 6
    //   560: aload 6
    //   562: ifnull +99 -> 661
    //   565: aload 5
    //   567: aload 6
    //   569: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: goto -20 -> 553
    //   576: astore 7
    //   578: aload_0
    //   579: astore 6
    //   581: aload 9
    //   583: astore 12
    //   585: aload 7
    //   587: astore_0
    //   588: aload 8
    //   590: astore 11
    //   592: aload 12
    //   594: astore 7
    //   596: aload 6
    //   598: astore 10
    //   600: aload 4
    //   602: astore 9
    //   604: aload_0
    //   605: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   608: aload 8
    //   610: ifnull +8 -> 618
    //   613: aload 8
    //   615: invokevirtual 103	java/io/DataOutputStream:close	()V
    //   618: aload 6
    //   620: ifnull +8 -> 628
    //   623: aload 6
    //   625: invokevirtual 106	java/io/BufferedReader:close	()V
    //   628: aload 12
    //   630: ifnull +8 -> 638
    //   633: aload 12
    //   635: invokevirtual 106	java/io/BufferedReader:close	()V
    //   638: iload_1
    //   639: istore_2
    //   640: aload 5
    //   642: astore_0
    //   643: aload 4
    //   645: ifnull -366 -> 279
    //   648: aload 4
    //   650: invokevirtual 109	java/lang/Process:destroy	()V
    //   653: iload_1
    //   654: istore_2
    //   655: aload 5
    //   657: astore_0
    //   658: goto -379 -> 279
    //   661: aload 8
    //   663: ifnull +8 -> 671
    //   666: aload 8
    //   668: invokevirtual 103	java/io/DataOutputStream:close	()V
    //   671: aload_0
    //   672: ifnull +7 -> 679
    //   675: aload_0
    //   676: invokevirtual 106	java/io/BufferedReader:close	()V
    //   679: aload 9
    //   681: ifnull +8 -> 689
    //   684: aload 9
    //   686: invokevirtual 106	java/io/BufferedReader:close	()V
    //   689: iload_1
    //   690: istore_2
    //   691: aload 5
    //   693: astore_0
    //   694: aload 4
    //   696: ifnull -417 -> 279
    //   699: aload 4
    //   701: invokevirtual 109	java/lang/Process:destroy	()V
    //   704: iload_1
    //   705: istore_2
    //   706: aload 5
    //   708: astore_0
    //   709: goto -430 -> 279
    //   712: astore_0
    //   713: aload_0
    //   714: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   717: goto -28 -> 689
    //   720: astore_0
    //   721: aload_0
    //   722: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   725: goto -466 -> 259
    //   728: astore_0
    //   729: aload_0
    //   730: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   733: goto -95 -> 638
    //   736: astore_0
    //   737: aconst_null
    //   738: astore 4
    //   740: aconst_null
    //   741: astore 5
    //   743: aload 9
    //   745: astore 6
    //   747: aload 13
    //   749: astore 7
    //   751: aload 5
    //   753: ifnull +8 -> 761
    //   756: aload 5
    //   758: invokevirtual 103	java/io/DataOutputStream:close	()V
    //   761: aload 6
    //   763: ifnull +8 -> 771
    //   766: aload 6
    //   768: invokevirtual 106	java/io/BufferedReader:close	()V
    //   771: aload 7
    //   773: ifnull +8 -> 781
    //   776: aload 7
    //   778: invokevirtual 106	java/io/BufferedReader:close	()V
    //   781: aload 4
    //   783: ifnull +8 -> 791
    //   786: aload 4
    //   788: invokevirtual 109	java/lang/Process:destroy	()V
    //   791: aload_0
    //   792: athrow
    //   793: astore 5
    //   795: aload 5
    //   797: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   800: goto -19 -> 781
    //   803: iconst_0
    //   804: istore_3
    //   805: goto -485 -> 320
    //   808: astore_0
    //   809: aconst_null
    //   810: astore 5
    //   812: aload 13
    //   814: astore 7
    //   816: aload 9
    //   818: astore 6
    //   820: goto -69 -> 751
    //   823: astore_0
    //   824: aload 11
    //   826: astore 5
    //   828: aload 10
    //   830: astore 6
    //   832: aload 9
    //   834: astore 4
    //   836: goto -85 -> 751
    //   839: astore 5
    //   841: aload_0
    //   842: astore 6
    //   844: aload 5
    //   846: astore_0
    //   847: aload 8
    //   849: astore 5
    //   851: aload 13
    //   853: astore 7
    //   855: goto -104 -> 751
    //   858: astore 5
    //   860: aload 9
    //   862: astore 7
    //   864: aload_0
    //   865: astore 6
    //   867: aload 5
    //   869: astore_0
    //   870: aload 8
    //   872: astore 5
    //   874: goto -123 -> 751
    //   877: astore 6
    //   879: aload 5
    //   881: astore 9
    //   883: aload_0
    //   884: astore 7
    //   886: aload 6
    //   888: astore_0
    //   889: aload 8
    //   891: astore 5
    //   893: aload 4
    //   895: astore 6
    //   897: aload 9
    //   899: astore 4
    //   901: goto -150 -> 751
    //   904: astore_0
    //   905: aconst_null
    //   906: astore 4
    //   908: aconst_null
    //   909: astore 8
    //   911: iconst_m1
    //   912: istore_1
    //   913: aconst_null
    //   914: astore 5
    //   916: goto -328 -> 588
    //   919: astore_0
    //   920: aconst_null
    //   921: astore 8
    //   923: iconst_m1
    //   924: istore_1
    //   925: aconst_null
    //   926: astore 5
    //   928: goto -340 -> 588
    //   931: astore_0
    //   932: iconst_m1
    //   933: istore_1
    //   934: aconst_null
    //   935: astore 5
    //   937: goto -349 -> 588
    //   940: astore_0
    //   941: aconst_null
    //   942: astore 5
    //   944: goto -356 -> 588
    //   947: astore_0
    //   948: goto -360 -> 588
    //   951: astore 7
    //   953: aload_0
    //   954: astore 6
    //   956: aload 7
    //   958: astore_0
    //   959: goto -371 -> 588
    //   962: astore 6
    //   964: iconst_m1
    //   965: istore_1
    //   966: aconst_null
    //   967: astore 7
    //   969: aconst_null
    //   970: astore_0
    //   971: aconst_null
    //   972: astore 4
    //   974: aconst_null
    //   975: astore 5
    //   977: aconst_null
    //   978: astore 8
    //   980: goto -754 -> 226
    //   983: astore 6
    //   985: aconst_null
    //   986: astore 8
    //   988: iconst_m1
    //   989: istore_1
    //   990: aconst_null
    //   991: astore 7
    //   993: aconst_null
    //   994: astore_0
    //   995: aconst_null
    //   996: astore 9
    //   998: aload 4
    //   1000: astore 5
    //   1002: aload 9
    //   1004: astore 4
    //   1006: goto -780 -> 226
    //   1009: astore 6
    //   1011: aconst_null
    //   1012: astore 7
    //   1014: aconst_null
    //   1015: astore_0
    //   1016: aconst_null
    //   1017: astore 9
    //   1019: aload 4
    //   1021: astore 5
    //   1023: aload 9
    //   1025: astore 4
    //   1027: goto -801 -> 226
    //   1030: astore 6
    //   1032: aconst_null
    //   1033: astore_0
    //   1034: aconst_null
    //   1035: astore 10
    //   1037: aload 4
    //   1039: astore 9
    //   1041: aload 5
    //   1043: astore 7
    //   1045: aload 10
    //   1047: astore 4
    //   1049: aload 9
    //   1051: astore 5
    //   1053: goto -827 -> 226
    //   1056: astore 6
    //   1058: aconst_null
    //   1059: astore 10
    //   1061: aload 4
    //   1063: astore 9
    //   1065: aload_0
    //   1066: astore 4
    //   1068: aload 5
    //   1070: astore 7
    //   1072: aload 10
    //   1074: astore_0
    //   1075: aload 9
    //   1077: astore 5
    //   1079: goto -853 -> 226
    //   1082: iload_1
    //   1083: iload_2
    //   1084: if_icmpge -735 -> 349
    //   1087: aload_0
    //   1088: iload_1
    //   1089: aaload
    //   1090: astore 5
    //   1092: aload 5
    //   1094: ifnonnull -961 -> 133
    //   1097: iload_1
    //   1098: iconst_1
    //   1099: iadd
    //   1100: istore_1
    //   1101: goto -19 -> 1082
    //   1104: astore 6
    //   1106: aload_0
    //   1107: astore 10
    //   1109: aload 4
    //   1111: astore 11
    //   1113: aload 5
    //   1115: astore 7
    //   1117: aload 9
    //   1119: astore_0
    //   1120: aload 10
    //   1122: astore 4
    //   1124: aload 11
    //   1126: astore 5
    //   1128: goto -902 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1131	0	paramArrayOfString	String[]
    //   129	972	1	i	int
    //   127	958	2	j	int
    //   319	486	3	bool	boolean
    //   93	1030	4	localObject1	Object
    //   151	606	5	localObject2	Object
    //   793	3	5	localIOException1	java.io.IOException
    //   810	17	5	localObject3	Object
    //   839	6	5	localObject4	Object
    //   849	1	5	localDataOutputStream1	java.io.DataOutputStream
    //   858	10	5	localObject5	Object
    //   872	255	5	localObject6	Object
    //   65	1	6	localObject7	Object
    //   206	21	6	localIOException2	java.io.IOException
    //   501	365	6	localObject8	Object
    //   877	10	6	localObject9	Object
    //   895	60	6	localObject10	Object
    //   962	1	6	localIOException3	java.io.IOException
    //   983	1	6	localIOException4	java.io.IOException
    //   1009	1	6	localIOException5	java.io.IOException
    //   1030	1	6	localIOException6	java.io.IOException
    //   1056	1	6	localIOException7	java.io.IOException
    //   1104	1	6	localIOException8	java.io.IOException
    //   115	332	7	localObject11	Object
    //   576	10	7	localException1	java.lang.Exception
    //   594	291	7	localObject12	Object
    //   951	6	7	localException2	java.lang.Exception
    //   967	149	7	localObject13	Object
    //   107	880	8	localDataOutputStream2	java.io.DataOutputStream
    //   59	1059	9	localObject14	Object
    //   119	1002	10	localObject15	Object
    //   111	1014	11	localObject16	Object
    //   74	560	12	localObject17	Object
    //   68	784	13	localObject18	Object
    //   62	387	14	localObject19	Object
    //   71	374	15	localObject20	Object
    //   7	340	16	locala	apzt.a
    //   83	426	17	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   125	128	206	java/io/IOException
    //   149	159	206	java/io/IOException
    //   175	182	206	java/io/IOException
    //   198	203	206	java/io/IOException
    //   365	372	206	java/io/IOException
    //   388	393	206	java/io/IOException
    //   409	415	206	java/io/IOException
    //   497	503	576	java/lang/Exception
    //   508	550	576	java/lang/Exception
    //   553	560	576	java/lang/Exception
    //   565	573	576	java/lang/Exception
    //   666	671	712	java/io/IOException
    //   675	679	712	java/io/IOException
    //   684	689	712	java/io/IOException
    //   236	241	720	java/io/IOException
    //   246	251	720	java/io/IOException
    //   255	259	720	java/io/IOException
    //   613	618	728	java/io/IOException
    //   623	628	728	java/io/IOException
    //   633	638	728	java/io/IOException
    //   85	95	736	finally
    //   756	761	793	java/io/IOException
    //   766	771	793	java/io/IOException
    //   776	781	793	java/io/IOException
    //   95	109	808	finally
    //   125	128	823	finally
    //   149	159	823	finally
    //   175	182	823	finally
    //   198	203	823	finally
    //   365	372	823	finally
    //   388	393	823	finally
    //   409	415	823	finally
    //   431	440	823	finally
    //   456	476	823	finally
    //   604	608	823	finally
    //   476	497	839	finally
    //   497	503	858	finally
    //   508	550	858	finally
    //   553	560	858	finally
    //   565	573	858	finally
    //   226	231	877	finally
    //   85	95	904	java/lang/Exception
    //   95	109	919	java/lang/Exception
    //   125	128	931	java/lang/Exception
    //   149	159	931	java/lang/Exception
    //   175	182	931	java/lang/Exception
    //   198	203	931	java/lang/Exception
    //   365	372	931	java/lang/Exception
    //   388	393	931	java/lang/Exception
    //   409	415	931	java/lang/Exception
    //   431	440	940	java/lang/Exception
    //   456	476	947	java/lang/Exception
    //   476	497	951	java/lang/Exception
    //   85	95	962	java/io/IOException
    //   95	109	983	java/io/IOException
    //   431	440	1009	java/io/IOException
    //   456	476	1030	java/io/IOException
    //   476	497	1056	java/io/IOException
    //   497	503	1104	java/io/IOException
    //   508	550	1104	java/io/IOException
    //   553	560	1104	java/io/IOException
    //   565	573	1104	java/io/IOException
  }
  
  public static class a
  {
    public String errMsg;
    public List<String> result;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apzt
 * JD-Core Version:    0.7.0.1
 */