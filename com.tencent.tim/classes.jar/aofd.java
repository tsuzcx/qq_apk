import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class aofd
{
  public static final String INDEX_FILE = aqul.getSDKPrivatePath(acbn.blX + "emojiindex");
  public static final String ckz = aqul.getSDKPrivatePath(acbn.blX + "emojis");
  
  /* Error */
  public static boolean F(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 56	java/io/File:exists	()Z
    //   4: ifne +19 -> 23
    //   7: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 63
    //   15: iconst_2
    //   16: ldc 65
    //   18: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: ireturn
    //   23: new 52	java/io/File
    //   26: dup
    //   27: getstatic 19	acbn:blX	Ljava/lang/String;
    //   30: invokestatic 35	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 56	java/io/File:exists	()Z
    //   43: ifne +9 -> 52
    //   46: aload 5
    //   48: invokevirtual 75	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: invokestatic 81	android/os/SystemClock:uptimeMillis	()J
    //   55: lstore_3
    //   56: aconst_null
    //   57: astore 9
    //   59: aconst_null
    //   60: astore 7
    //   62: aconst_null
    //   63: astore 10
    //   65: aconst_null
    //   66: astore 8
    //   68: new 83	com/tencent/commonsdk/zip/QZipInputStream
    //   71: dup
    //   72: new 85	java/io/BufferedInputStream
    //   75: dup
    //   76: new 87	java/io/FileInputStream
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   84: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 94	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   90: astore 6
    //   92: new 96	java/io/BufferedOutputStream
    //   95: dup
    //   96: new 98	java/io/FileOutputStream
    //   99: dup
    //   100: getstatic 41	aofd:ckz	Ljava/lang/String;
    //   103: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   106: invokespecial 102	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   109: astore 5
    //   111: aload 10
    //   113: astore 7
    //   115: new 104	java/util/HashMap
    //   118: dup
    //   119: aload_0
    //   120: invokevirtual 107	java/io/File:length	()J
    //   123: l2i
    //   124: sipush 1024
    //   127: idiv
    //   128: invokespecial 110	java/util/HashMap:<init>	(I)V
    //   131: astore 12
    //   133: aload 10
    //   135: astore 7
    //   137: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   140: sipush 512
    //   143: invokevirtual 120	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   146: astore_0
    //   147: iconst_0
    //   148: istore_1
    //   149: aload_0
    //   150: astore 7
    //   152: aload 6
    //   154: invokevirtual 124	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   157: astore 10
    //   159: aload 10
    //   161: ifnull +159 -> 320
    //   164: aload_0
    //   165: astore 7
    //   167: aload 10
    //   169: invokevirtual 129	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   172: astore 9
    //   174: aload 9
    //   176: astore 8
    //   178: aload_0
    //   179: astore 7
    //   181: aload 9
    //   183: ldc 131
    //   185: invokevirtual 137	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +25 -> 213
    //   191: aload_0
    //   192: astore 7
    //   194: aload 9
    //   196: aload 9
    //   198: bipush 47
    //   200: invokevirtual 141	java/lang/String:lastIndexOf	(I)I
    //   203: iconst_1
    //   204: iadd
    //   205: invokevirtual 145	java/lang/String:substring	(I)Ljava/lang/String;
    //   208: invokevirtual 148	java/lang/String:trim	()Ljava/lang/String;
    //   211: astore 8
    //   213: aload 8
    //   215: ifnull -66 -> 149
    //   218: aload_0
    //   219: astore 7
    //   221: aload 8
    //   223: ldc 150
    //   225: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifne -79 -> 149
    //   231: aload_0
    //   232: astore 7
    //   234: aload 12
    //   236: aload 8
    //   238: iload_1
    //   239: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: invokeinterface 166 3 0
    //   247: pop
    //   248: aload_0
    //   249: astore 7
    //   251: aload 10
    //   253: invokevirtual 169	java/util/zip/ZipEntry:getSize	()J
    //   256: l2i
    //   257: istore_2
    //   258: iload_2
    //   259: iconst_1
    //   260: if_icmplt -111 -> 149
    //   263: aload_0
    //   264: astore 7
    //   266: aload 5
    //   268: iload_2
    //   269: invokestatic 173	aofd:b	(Ljava/io/OutputStream;I)V
    //   272: iload_1
    //   273: iconst_4
    //   274: iadd
    //   275: istore_1
    //   276: aload_0
    //   277: astore 7
    //   279: aload 6
    //   281: aload_0
    //   282: invokevirtual 177	com/tencent/commonsdk/zip/QZipInputStream:read	([B)I
    //   285: istore_2
    //   286: iload_2
    //   287: iconst_m1
    //   288: if_icmpeq +21 -> 309
    //   291: aload_0
    //   292: astore 7
    //   294: aload 5
    //   296: aload_0
    //   297: iconst_0
    //   298: iload_2
    //   299: invokevirtual 181	java/io/BufferedOutputStream:write	([BII)V
    //   302: iload_1
    //   303: iload_2
    //   304: iadd
    //   305: istore_1
    //   306: goto -30 -> 276
    //   309: aload_0
    //   310: astore 7
    //   312: aload 5
    //   314: invokevirtual 184	java/io/BufferedOutputStream:flush	()V
    //   317: goto -168 -> 149
    //   320: aload_0
    //   321: astore 7
    //   323: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   326: aload_0
    //   327: invokevirtual 188	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   330: aconst_null
    //   331: astore 8
    //   333: aconst_null
    //   334: astore 11
    //   336: aconst_null
    //   337: astore 7
    //   339: aload 5
    //   341: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   344: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +11 -> 358
    //   350: ldc 63
    //   352: iconst_2
    //   353: ldc 193
    //   355: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: new 96	java/io/BufferedOutputStream
    //   361: dup
    //   362: new 98	java/io/FileOutputStream
    //   365: dup
    //   366: getstatic 37	aofd:INDEX_FILE	Ljava/lang/String;
    //   369: invokespecial 99	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   372: invokespecial 102	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   375: astore_0
    //   376: aload 11
    //   378: astore 10
    //   380: aload_0
    //   381: astore 9
    //   383: aload 6
    //   385: astore 8
    //   387: aload 12
    //   389: invokeinterface 197 1 0
    //   394: invokeinterface 203 1 0
    //   399: astore 5
    //   401: aload 11
    //   403: astore 10
    //   405: aload_0
    //   406: astore 9
    //   408: aload 6
    //   410: astore 8
    //   412: aload 5
    //   414: invokeinterface 208 1 0
    //   419: ifeq +581 -> 1000
    //   422: aload 11
    //   424: astore 10
    //   426: aload_0
    //   427: astore 9
    //   429: aload 6
    //   431: astore 8
    //   433: aload 5
    //   435: invokeinterface 212 1 0
    //   440: checkcast 133	java/lang/String
    //   443: astore 13
    //   445: aload 11
    //   447: astore 10
    //   449: aload_0
    //   450: astore 9
    //   452: aload 6
    //   454: astore 8
    //   456: aload 13
    //   458: ldc 214
    //   460: invokevirtual 137	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   463: ifne +237 -> 700
    //   466: aload 11
    //   468: astore 10
    //   470: aload_0
    //   471: astore 9
    //   473: aload 6
    //   475: astore 8
    //   477: aload 13
    //   479: iconst_2
    //   480: aload 13
    //   482: invokevirtual 217	java/lang/String:length	()I
    //   485: iconst_4
    //   486: isub
    //   487: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   490: astore 14
    //   492: aload 11
    //   494: astore 10
    //   496: aload_0
    //   497: astore 9
    //   499: aload 6
    //   501: astore 8
    //   503: aload 12
    //   505: aload 13
    //   507: invokeinterface 224 2 0
    //   512: checkcast 156	java/lang/Integer
    //   515: invokevirtual 227	java/lang/Integer:intValue	()I
    //   518: istore_1
    //   519: aload 11
    //   521: astore 10
    //   523: aload_0
    //   524: astore 9
    //   526: aload 6
    //   528: astore 8
    //   530: aload 14
    //   532: bipush 16
    //   534: invokestatic 231	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   537: istore_2
    //   538: aload 11
    //   540: astore 10
    //   542: aload_0
    //   543: astore 9
    //   545: aload 6
    //   547: astore 8
    //   549: aload_0
    //   550: iconst_1
    //   551: invokevirtual 233	java/io/BufferedOutputStream:write	(I)V
    //   554: aload 11
    //   556: astore 10
    //   558: aload_0
    //   559: astore 9
    //   561: aload 6
    //   563: astore 8
    //   565: aload_0
    //   566: iload_2
    //   567: invokestatic 173	aofd:b	(Ljava/io/OutputStream;I)V
    //   570: aload 11
    //   572: astore 10
    //   574: aload_0
    //   575: astore 9
    //   577: aload 6
    //   579: astore 8
    //   581: aload_0
    //   582: iload_1
    //   583: invokestatic 173	aofd:b	(Ljava/io/OutputStream;I)V
    //   586: goto -185 -> 401
    //   589: astore 14
    //   591: aload 11
    //   593: astore 10
    //   595: aload_0
    //   596: astore 9
    //   598: aload 6
    //   600: astore 8
    //   602: ldc 63
    //   604: iconst_1
    //   605: invokestatic 238	wja:b	()Ljava/lang/StringBuilder;
    //   608: ldc 240
    //   610: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload 13
    //   615: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: aload 14
    //   623: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   626: goto -225 -> 401
    //   629: astore 8
    //   631: aconst_null
    //   632: astore 5
    //   634: aload_0
    //   635: astore 7
    //   637: aload 6
    //   639: astore_0
    //   640: aload 8
    //   642: astore 6
    //   644: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +13 -> 660
    //   650: ldc 63
    //   652: iconst_2
    //   653: ldc 246
    //   655: aload 6
    //   657: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   660: aload_0
    //   661: ifnull +7 -> 668
    //   664: aload_0
    //   665: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   668: aload 7
    //   670: ifnull +8 -> 678
    //   673: aload 7
    //   675: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   678: aload 5
    //   680: ifnull -659 -> 21
    //   683: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   686: aload 5
    //   688: invokevirtual 188	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   691: iconst_0
    //   692: ireturn
    //   693: astore_0
    //   694: aload_0
    //   695: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   698: iconst_0
    //   699: ireturn
    //   700: aload 11
    //   702: astore 10
    //   704: aload_0
    //   705: astore 9
    //   707: aload 6
    //   709: astore 8
    //   711: aload 13
    //   713: iconst_0
    //   714: aload 13
    //   716: invokevirtual 217	java/lang/String:length	()I
    //   719: iconst_4
    //   720: isub
    //   721: invokevirtual 220	java/lang/String:substring	(II)Ljava/lang/String;
    //   724: ldc 214
    //   726: invokevirtual 254	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   729: astore 14
    //   731: aload 11
    //   733: astore 10
    //   735: aload_0
    //   736: astore 9
    //   738: aload 6
    //   740: astore 8
    //   742: aload 12
    //   744: aload 13
    //   746: invokeinterface 224 2 0
    //   751: checkcast 156	java/lang/Integer
    //   754: invokevirtual 227	java/lang/Integer:intValue	()I
    //   757: istore_2
    //   758: aload 14
    //   760: ifnull -359 -> 401
    //   763: aload 11
    //   765: astore 10
    //   767: aload_0
    //   768: astore 9
    //   770: aload 6
    //   772: astore 8
    //   774: aload 14
    //   776: arraylength
    //   777: newarray int
    //   779: astore 15
    //   781: iconst_0
    //   782: istore_1
    //   783: aload 11
    //   785: astore 10
    //   787: aload_0
    //   788: astore 9
    //   790: aload 6
    //   792: astore 8
    //   794: iload_1
    //   795: aload 14
    //   797: arraylength
    //   798: if_icmpge +38 -> 836
    //   801: aload 11
    //   803: astore 10
    //   805: aload_0
    //   806: astore 9
    //   808: aload 6
    //   810: astore 8
    //   812: aload 15
    //   814: iload_1
    //   815: aload 14
    //   817: iload_1
    //   818: aaload
    //   819: iconst_2
    //   820: invokevirtual 145	java/lang/String:substring	(I)Ljava/lang/String;
    //   823: bipush 16
    //   825: invokestatic 231	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   828: iastore
    //   829: iload_1
    //   830: iconst_1
    //   831: iadd
    //   832: istore_1
    //   833: goto -50 -> 783
    //   836: aload 11
    //   838: astore 10
    //   840: aload_0
    //   841: astore 9
    //   843: aload 6
    //   845: astore 8
    //   847: aload_0
    //   848: aload 14
    //   850: arraylength
    //   851: invokevirtual 233	java/io/BufferedOutputStream:write	(I)V
    //   854: iconst_0
    //   855: istore_1
    //   856: aload 11
    //   858: astore 10
    //   860: aload_0
    //   861: astore 9
    //   863: aload 6
    //   865: astore 8
    //   867: iload_1
    //   868: aload 15
    //   870: arraylength
    //   871: if_icmpge +29 -> 900
    //   874: aload 11
    //   876: astore 10
    //   878: aload_0
    //   879: astore 9
    //   881: aload 6
    //   883: astore 8
    //   885: aload_0
    //   886: aload 15
    //   888: iload_1
    //   889: iaload
    //   890: invokestatic 173	aofd:b	(Ljava/io/OutputStream;I)V
    //   893: iload_1
    //   894: iconst_1
    //   895: iadd
    //   896: istore_1
    //   897: goto -41 -> 856
    //   900: aload 11
    //   902: astore 10
    //   904: aload_0
    //   905: astore 9
    //   907: aload 6
    //   909: astore 8
    //   911: aload_0
    //   912: iload_2
    //   913: invokestatic 173	aofd:b	(Ljava/io/OutputStream;I)V
    //   916: goto -515 -> 401
    //   919: astore 5
    //   921: aload 7
    //   923: astore 10
    //   925: aload_0
    //   926: astore 9
    //   928: aload 6
    //   930: astore 8
    //   932: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +25 -> 960
    //   938: aload 7
    //   940: astore 10
    //   942: aload_0
    //   943: astore 9
    //   945: aload 6
    //   947: astore 8
    //   949: ldc 63
    //   951: iconst_2
    //   952: ldc_w 256
    //   955: aload 5
    //   957: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   960: aload 6
    //   962: ifnull +8 -> 970
    //   965: aload 6
    //   967: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   970: aload_0
    //   971: ifnull +7 -> 978
    //   974: aload_0
    //   975: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   978: aload 7
    //   980: ifnull -959 -> 21
    //   983: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   986: aload 7
    //   988: invokevirtual 188	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   991: iconst_0
    //   992: ireturn
    //   993: astore_0
    //   994: aload_0
    //   995: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   998: iconst_0
    //   999: ireturn
    //   1000: aload 11
    //   1002: astore 10
    //   1004: aload_0
    //   1005: astore 9
    //   1007: aload 6
    //   1009: astore 8
    //   1011: aload_0
    //   1012: invokevirtual 184	java/io/BufferedOutputStream:flush	()V
    //   1015: aload 11
    //   1017: astore 10
    //   1019: aload_0
    //   1020: astore 9
    //   1022: aload 6
    //   1024: astore 8
    //   1026: invokestatic 262	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1029: astore 12
    //   1031: aload 11
    //   1033: astore 10
    //   1035: aload_0
    //   1036: astore 9
    //   1038: aload 6
    //   1040: astore 8
    //   1042: getstatic 268	android/os/Build$VERSION:SDK_INT	I
    //   1045: bipush 24
    //   1047: if_icmplt +342 -> 1389
    //   1050: aload 11
    //   1052: astore 10
    //   1054: aload_0
    //   1055: astore 9
    //   1057: aload 6
    //   1059: astore 8
    //   1061: aload 12
    //   1063: invokestatic 274	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   1066: astore 5
    //   1068: aload 11
    //   1070: astore 10
    //   1072: aload_0
    //   1073: astore 9
    //   1075: aload 6
    //   1077: astore 8
    //   1079: aload 12
    //   1081: aload 5
    //   1083: iconst_4
    //   1084: invokevirtual 280	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1087: invokeinterface 286 1 0
    //   1092: ldc_w 288
    //   1095: iconst_1
    //   1096: invokeinterface 294 3 0
    //   1101: invokeinterface 297 1 0
    //   1106: pop
    //   1107: aload 11
    //   1109: astore 10
    //   1111: aload_0
    //   1112: astore 9
    //   1114: aload 6
    //   1116: astore 8
    //   1118: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1121: ifeq +23 -> 1144
    //   1124: aload 11
    //   1126: astore 10
    //   1128: aload_0
    //   1129: astore 9
    //   1131: aload 6
    //   1133: astore 8
    //   1135: ldc 63
    //   1137: iconst_2
    //   1138: ldc_w 299
    //   1141: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: aload 11
    //   1146: astore 10
    //   1148: aload_0
    //   1149: astore 9
    //   1151: aload 6
    //   1153: astore 8
    //   1155: new 52	java/io/File
    //   1158: dup
    //   1159: getstatic 37	aofd:INDEX_FILE	Ljava/lang/String;
    //   1162: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   1165: astore 5
    //   1167: aload 11
    //   1169: astore 10
    //   1171: aload_0
    //   1172: astore 9
    //   1174: aload 6
    //   1176: astore 8
    //   1178: new 52	java/io/File
    //   1181: dup
    //   1182: getstatic 41	aofd:ckz	Ljava/lang/String;
    //   1185: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   1188: astore 12
    //   1190: aload 11
    //   1192: astore 10
    //   1194: aload_0
    //   1195: astore 9
    //   1197: aload 6
    //   1199: astore 8
    //   1201: aload 5
    //   1203: invokevirtual 56	java/io/File:exists	()Z
    //   1206: ifeq +40 -> 1246
    //   1209: aload 11
    //   1211: astore 10
    //   1213: aload_0
    //   1214: astore 9
    //   1216: aload 6
    //   1218: astore 8
    //   1220: aload 12
    //   1222: invokevirtual 56	java/io/File:exists	()Z
    //   1225: ifeq +21 -> 1246
    //   1228: aload 11
    //   1230: astore 10
    //   1232: aload_0
    //   1233: astore 9
    //   1235: aload 6
    //   1237: astore 8
    //   1239: aload 5
    //   1241: aload 12
    //   1243: invokestatic 305	aoff:g	(Ljava/io/File;Ljava/io/File;)V
    //   1246: aload 11
    //   1248: astore 10
    //   1250: aload_0
    //   1251: astore 9
    //   1253: aload 6
    //   1255: astore 8
    //   1257: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +62 -> 1322
    //   1263: aload 11
    //   1265: astore 10
    //   1267: aload_0
    //   1268: astore 9
    //   1270: aload 6
    //   1272: astore 8
    //   1274: ldc 63
    //   1276: iconst_2
    //   1277: new 11	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1284: ldc_w 307
    //   1287: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: getstatic 311	aoff:ah	Landroid/util/SparseIntArray;
    //   1293: invokevirtual 316	android/util/SparseIntArray:size	()I
    //   1296: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1299: ldc_w 321
    //   1302: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: getstatic 325	aoff:nu	Ljava/util/Map;
    //   1308: invokeinterface 326 1 0
    //   1313: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1316: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1322: aload 6
    //   1324: ifnull +8 -> 1332
    //   1327: aload 6
    //   1329: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1332: aload_0
    //   1333: ifnull +7 -> 1340
    //   1336: aload_0
    //   1337: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   1340: iconst_0
    //   1341: ifeq +10 -> 1351
    //   1344: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1347: aconst_null
    //   1348: invokevirtual 188	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1351: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1354: ifeq +33 -> 1387
    //   1357: ldc 63
    //   1359: iconst_2
    //   1360: new 11	java/lang/StringBuilder
    //   1363: dup
    //   1364: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1367: ldc_w 328
    //   1370: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: invokestatic 81	android/os/SystemClock:uptimeMillis	()J
    //   1376: lload_3
    //   1377: lsub
    //   1378: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1381: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1384: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1387: iconst_1
    //   1388: ireturn
    //   1389: aload 11
    //   1391: astore 10
    //   1393: aload_0
    //   1394: astore 9
    //   1396: aload 6
    //   1398: astore 8
    //   1400: new 11	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   1407: aload 12
    //   1409: invokevirtual 334	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1412: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: ldc_w 336
    //   1418: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: astore 5
    //   1426: goto -358 -> 1068
    //   1429: astore_0
    //   1430: aload_0
    //   1431: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   1434: goto -83 -> 1351
    //   1437: astore_0
    //   1438: aconst_null
    //   1439: astore 7
    //   1441: aconst_null
    //   1442: astore 6
    //   1444: aconst_null
    //   1445: astore 5
    //   1447: aload 6
    //   1449: ifnull +8 -> 1457
    //   1452: aload 6
    //   1454: invokevirtual 247	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   1457: aload 7
    //   1459: ifnull +8 -> 1467
    //   1462: aload 7
    //   1464: invokevirtual 191	java/io/BufferedOutputStream:close	()V
    //   1467: aload 5
    //   1469: ifnull +11 -> 1480
    //   1472: invokestatic 116	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1475: aload 5
    //   1477: invokevirtual 188	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   1480: aload_0
    //   1481: athrow
    //   1482: astore 5
    //   1484: aload 5
    //   1486: invokevirtual 250	java/io/IOException:printStackTrace	()V
    //   1489: goto -9 -> 1480
    //   1492: astore_0
    //   1493: aconst_null
    //   1494: astore 7
    //   1496: aconst_null
    //   1497: astore 5
    //   1499: goto -52 -> 1447
    //   1502: astore_0
    //   1503: aconst_null
    //   1504: astore 8
    //   1506: aload 5
    //   1508: astore 7
    //   1510: aload 8
    //   1512: astore 5
    //   1514: goto -67 -> 1447
    //   1517: astore 9
    //   1519: aload_0
    //   1520: astore 7
    //   1522: aload 5
    //   1524: astore 8
    //   1526: aload 9
    //   1528: astore_0
    //   1529: aload 7
    //   1531: astore 5
    //   1533: aload 8
    //   1535: astore 7
    //   1537: goto -90 -> 1447
    //   1540: astore_0
    //   1541: aload 5
    //   1543: astore 7
    //   1545: aload 8
    //   1547: astore 5
    //   1549: goto -102 -> 1447
    //   1552: astore_0
    //   1553: aload 10
    //   1555: astore 5
    //   1557: aload 9
    //   1559: astore 7
    //   1561: aload 8
    //   1563: astore 6
    //   1565: goto -118 -> 1447
    //   1568: astore 8
    //   1570: aload_0
    //   1571: astore 6
    //   1573: aload 8
    //   1575: astore_0
    //   1576: goto -129 -> 1447
    //   1579: astore 5
    //   1581: aconst_null
    //   1582: astore_0
    //   1583: aconst_null
    //   1584: astore 6
    //   1586: aconst_null
    //   1587: astore 7
    //   1589: goto -668 -> 921
    //   1592: astore 5
    //   1594: aconst_null
    //   1595: astore_0
    //   1596: aconst_null
    //   1597: astore 7
    //   1599: goto -678 -> 921
    //   1602: astore 8
    //   1604: aconst_null
    //   1605: astore 7
    //   1607: aload 5
    //   1609: astore_0
    //   1610: aload 8
    //   1612: astore 5
    //   1614: goto -693 -> 921
    //   1617: astore 7
    //   1619: aload 5
    //   1621: astore 8
    //   1623: aload 7
    //   1625: astore 5
    //   1627: aload_0
    //   1628: astore 7
    //   1630: aload 8
    //   1632: astore_0
    //   1633: goto -712 -> 921
    //   1636: astore 8
    //   1638: aload 5
    //   1640: astore_0
    //   1641: aload 8
    //   1643: astore 5
    //   1645: goto -724 -> 921
    //   1648: astore 6
    //   1650: aload 8
    //   1652: astore 5
    //   1654: aload 9
    //   1656: astore_0
    //   1657: goto -1013 -> 644
    //   1660: astore 5
    //   1662: aload 6
    //   1664: astore_0
    //   1665: aload 5
    //   1667: astore 6
    //   1669: aload 8
    //   1671: astore 5
    //   1673: goto -1029 -> 644
    //   1676: astore 9
    //   1678: aload 5
    //   1680: astore_0
    //   1681: aload 6
    //   1683: astore 8
    //   1685: aload 9
    //   1687: astore 6
    //   1689: aload 7
    //   1691: astore 5
    //   1693: aload_0
    //   1694: astore 7
    //   1696: aload 8
    //   1698: astore_0
    //   1699: goto -1055 -> 644
    //   1702: astore 9
    //   1704: aconst_null
    //   1705: astore 8
    //   1707: aload 5
    //   1709: astore 7
    //   1711: aload 6
    //   1713: astore_0
    //   1714: aload 9
    //   1716: astore 6
    //   1718: aload 8
    //   1720: astore 5
    //   1722: goto -1078 -> 644
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1725	0	paramFile	java.io.File
    //   148	749	1	i	int
    //   257	656	2	j	int
    //   55	1322	3	l	long
    //   36	651	5	localObject1	Object
    //   919	37	5	localIOException1	IOException
    //   1066	410	5	localObject2	Object
    //   1482	3	5	localIOException2	IOException
    //   1497	59	5	localObject3	Object
    //   1579	1	5	localIOException3	IOException
    //   1592	16	5	localIOException4	IOException
    //   1612	41	5	localObject4	Object
    //   1660	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   1671	50	5	localObject5	Object
    //   90	1495	6	localObject6	Object
    //   1648	15	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1667	50	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   60	1546	7	localObject7	Object
    //   1617	7	7	localIOException5	IOException
    //   1628	82	7	localObject8	Object
    //   66	535	8	localObject9	Object
    //   629	12	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   709	853	8	localObject10	Object
    //   1568	6	8	localObject11	Object
    //   1602	9	8	localIOException6	IOException
    //   1621	10	8	localObject12	Object
    //   1636	34	8	localIOException7	IOException
    //   1683	36	8	localObject13	Object
    //   57	1338	9	localObject14	Object
    //   1517	138	9	localObject15	Object
    //   1676	10	9	localFileNotFoundException5	java.io.FileNotFoundException
    //   1702	13	9	localFileNotFoundException6	java.io.FileNotFoundException
    //   63	1491	10	localObject16	Object
    //   334	1056	11	localObject17	Object
    //   131	1277	12	localObject18	Object
    //   443	302	13	str1	String
    //   490	41	14	str2	String
    //   589	33	14	localException	java.lang.Exception
    //   729	120	14	arrayOfString	String[]
    //   779	108	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   456	466	589	java/lang/Exception
    //   477	492	589	java/lang/Exception
    //   503	519	589	java/lang/Exception
    //   530	538	589	java/lang/Exception
    //   549	554	589	java/lang/Exception
    //   565	570	589	java/lang/Exception
    //   581	586	589	java/lang/Exception
    //   711	731	589	java/lang/Exception
    //   742	758	589	java/lang/Exception
    //   774	781	589	java/lang/Exception
    //   794	801	589	java/lang/Exception
    //   812	829	589	java/lang/Exception
    //   847	854	589	java/lang/Exception
    //   867	874	589	java/lang/Exception
    //   885	893	589	java/lang/Exception
    //   911	916	589	java/lang/Exception
    //   387	401	629	java/io/FileNotFoundException
    //   412	422	629	java/io/FileNotFoundException
    //   433	445	629	java/io/FileNotFoundException
    //   456	466	629	java/io/FileNotFoundException
    //   477	492	629	java/io/FileNotFoundException
    //   503	519	629	java/io/FileNotFoundException
    //   530	538	629	java/io/FileNotFoundException
    //   549	554	629	java/io/FileNotFoundException
    //   565	570	629	java/io/FileNotFoundException
    //   581	586	629	java/io/FileNotFoundException
    //   602	626	629	java/io/FileNotFoundException
    //   711	731	629	java/io/FileNotFoundException
    //   742	758	629	java/io/FileNotFoundException
    //   774	781	629	java/io/FileNotFoundException
    //   794	801	629	java/io/FileNotFoundException
    //   812	829	629	java/io/FileNotFoundException
    //   847	854	629	java/io/FileNotFoundException
    //   867	874	629	java/io/FileNotFoundException
    //   885	893	629	java/io/FileNotFoundException
    //   911	916	629	java/io/FileNotFoundException
    //   1011	1015	629	java/io/FileNotFoundException
    //   1026	1031	629	java/io/FileNotFoundException
    //   1042	1050	629	java/io/FileNotFoundException
    //   1061	1068	629	java/io/FileNotFoundException
    //   1079	1107	629	java/io/FileNotFoundException
    //   1118	1124	629	java/io/FileNotFoundException
    //   1135	1144	629	java/io/FileNotFoundException
    //   1155	1167	629	java/io/FileNotFoundException
    //   1178	1190	629	java/io/FileNotFoundException
    //   1201	1209	629	java/io/FileNotFoundException
    //   1220	1228	629	java/io/FileNotFoundException
    //   1239	1246	629	java/io/FileNotFoundException
    //   1257	1263	629	java/io/FileNotFoundException
    //   1274	1322	629	java/io/FileNotFoundException
    //   1400	1426	629	java/io/FileNotFoundException
    //   664	668	693	java/io/IOException
    //   673	678	693	java/io/IOException
    //   683	691	693	java/io/IOException
    //   387	401	919	java/io/IOException
    //   412	422	919	java/io/IOException
    //   433	445	919	java/io/IOException
    //   456	466	919	java/io/IOException
    //   477	492	919	java/io/IOException
    //   503	519	919	java/io/IOException
    //   530	538	919	java/io/IOException
    //   549	554	919	java/io/IOException
    //   565	570	919	java/io/IOException
    //   581	586	919	java/io/IOException
    //   602	626	919	java/io/IOException
    //   711	731	919	java/io/IOException
    //   742	758	919	java/io/IOException
    //   774	781	919	java/io/IOException
    //   794	801	919	java/io/IOException
    //   812	829	919	java/io/IOException
    //   847	854	919	java/io/IOException
    //   867	874	919	java/io/IOException
    //   885	893	919	java/io/IOException
    //   911	916	919	java/io/IOException
    //   1011	1015	919	java/io/IOException
    //   1026	1031	919	java/io/IOException
    //   1042	1050	919	java/io/IOException
    //   1061	1068	919	java/io/IOException
    //   1079	1107	919	java/io/IOException
    //   1118	1124	919	java/io/IOException
    //   1135	1144	919	java/io/IOException
    //   1155	1167	919	java/io/IOException
    //   1178	1190	919	java/io/IOException
    //   1201	1209	919	java/io/IOException
    //   1220	1228	919	java/io/IOException
    //   1239	1246	919	java/io/IOException
    //   1257	1263	919	java/io/IOException
    //   1274	1322	919	java/io/IOException
    //   1400	1426	919	java/io/IOException
    //   965	970	993	java/io/IOException
    //   974	978	993	java/io/IOException
    //   983	991	993	java/io/IOException
    //   1327	1332	1429	java/io/IOException
    //   1336	1340	1429	java/io/IOException
    //   1344	1351	1429	java/io/IOException
    //   68	92	1437	finally
    //   1452	1457	1482	java/io/IOException
    //   1462	1467	1482	java/io/IOException
    //   1472	1480	1482	java/io/IOException
    //   92	111	1492	finally
    //   115	133	1502	finally
    //   137	147	1502	finally
    //   152	159	1517	finally
    //   167	174	1517	finally
    //   181	191	1517	finally
    //   194	213	1517	finally
    //   221	231	1517	finally
    //   234	248	1517	finally
    //   251	258	1517	finally
    //   266	272	1517	finally
    //   279	286	1517	finally
    //   294	302	1517	finally
    //   312	317	1517	finally
    //   323	330	1517	finally
    //   339	358	1540	finally
    //   358	376	1540	finally
    //   387	401	1552	finally
    //   412	422	1552	finally
    //   433	445	1552	finally
    //   456	466	1552	finally
    //   477	492	1552	finally
    //   503	519	1552	finally
    //   530	538	1552	finally
    //   549	554	1552	finally
    //   565	570	1552	finally
    //   581	586	1552	finally
    //   602	626	1552	finally
    //   711	731	1552	finally
    //   742	758	1552	finally
    //   774	781	1552	finally
    //   794	801	1552	finally
    //   812	829	1552	finally
    //   847	854	1552	finally
    //   867	874	1552	finally
    //   885	893	1552	finally
    //   911	916	1552	finally
    //   932	938	1552	finally
    //   949	960	1552	finally
    //   1011	1015	1552	finally
    //   1026	1031	1552	finally
    //   1042	1050	1552	finally
    //   1061	1068	1552	finally
    //   1079	1107	1552	finally
    //   1118	1124	1552	finally
    //   1135	1144	1552	finally
    //   1155	1167	1552	finally
    //   1178	1190	1552	finally
    //   1201	1209	1552	finally
    //   1220	1228	1552	finally
    //   1239	1246	1552	finally
    //   1257	1263	1552	finally
    //   1274	1322	1552	finally
    //   1400	1426	1552	finally
    //   644	660	1568	finally
    //   68	92	1579	java/io/IOException
    //   92	111	1592	java/io/IOException
    //   115	133	1602	java/io/IOException
    //   137	147	1602	java/io/IOException
    //   152	159	1617	java/io/IOException
    //   167	174	1617	java/io/IOException
    //   181	191	1617	java/io/IOException
    //   194	213	1617	java/io/IOException
    //   221	231	1617	java/io/IOException
    //   234	248	1617	java/io/IOException
    //   251	258	1617	java/io/IOException
    //   266	272	1617	java/io/IOException
    //   279	286	1617	java/io/IOException
    //   294	302	1617	java/io/IOException
    //   312	317	1617	java/io/IOException
    //   323	330	1617	java/io/IOException
    //   339	358	1636	java/io/IOException
    //   358	376	1636	java/io/IOException
    //   68	92	1648	java/io/FileNotFoundException
    //   92	111	1660	java/io/FileNotFoundException
    //   115	133	1676	java/io/FileNotFoundException
    //   137	147	1676	java/io/FileNotFoundException
    //   152	159	1676	java/io/FileNotFoundException
    //   167	174	1676	java/io/FileNotFoundException
    //   181	191	1676	java/io/FileNotFoundException
    //   194	213	1676	java/io/FileNotFoundException
    //   221	231	1676	java/io/FileNotFoundException
    //   234	248	1676	java/io/FileNotFoundException
    //   251	258	1676	java/io/FileNotFoundException
    //   266	272	1676	java/io/FileNotFoundException
    //   279	286	1676	java/io/FileNotFoundException
    //   294	302	1676	java/io/FileNotFoundException
    //   312	317	1676	java/io/FileNotFoundException
    //   323	330	1676	java/io/FileNotFoundException
    //   339	358	1702	java/io/FileNotFoundException
    //   358	376	1702	java/io/FileNotFoundException
  }
  
  public static final int b(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= paramInputStream.read() << i * 8;
      i += 1;
    }
    return j;
  }
  
  public static final void b(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    int i = 0;
    while (i < 4)
    {
      paramOutputStream.write(paramInt >> i * 8 & 0xFF);
      i += 1;
    }
  }
  
  public static final int bytesToInt(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    if (i < 4)
    {
      int k = paramArrayOfByte[i];
      if (k >= 0) {}
      for (;;)
      {
        j |= k << i * 8;
        i += 1;
        break;
        k += 256;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofd
 * JD-Core Version:    0.7.0.1
 */