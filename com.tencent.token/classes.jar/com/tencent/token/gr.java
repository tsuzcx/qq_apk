package com.tencent.token;

import java.util.Vector;

public final class gr
{
  private static String j = "10.0.0.172";
  private static int k = 80;
  private int a = 0;
  private Vector b = new Vector();
  private gs[] c = new gs[4];
  private final int d = 4;
  private final int e = 20;
  private volatile boolean f = false;
  private boolean g = false;
  private volatile boolean h = false;
  private int[] i = new int[0];
  
  public gr()
  {
    while (m < 4)
    {
      this.c[m] = new gs(this);
      this.c[m].setPriority(1);
      m += 1;
    }
  }
  
  /* Error */
  private void a(gt paramgt, gs paramgs, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 78	com/tencent/token/gt:b	()Lcom/tencent/token/gu;
    //   4: astore 25
    //   6: aconst_null
    //   7: astore 20
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 21
    //   15: aconst_null
    //   16: astore 23
    //   18: aconst_null
    //   19: astore 22
    //   21: aconst_null
    //   22: astore 18
    //   24: aconst_null
    //   25: astore 17
    //   27: aconst_null
    //   28: astore 24
    //   30: aconst_null
    //   31: astore 16
    //   33: aload_1
    //   34: invokevirtual 81	com/tencent/token/gt:a	()Ljava/lang/String;
    //   37: astore 15
    //   39: iconst_0
    //   40: istore 4
    //   42: aconst_null
    //   43: astore 8
    //   45: aconst_null
    //   46: astore 9
    //   48: aload 24
    //   50: astore 14
    //   52: aload 9
    //   54: astore 13
    //   56: aload 23
    //   58: astore 12
    //   60: aload 8
    //   62: astore 11
    //   64: new 83	java/net/URL
    //   67: dup
    //   68: aload 15
    //   70: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 24
    //   77: astore 14
    //   79: aload 9
    //   81: astore 13
    //   83: aload 23
    //   85: astore 12
    //   87: aload 8
    //   89: astore 11
    //   91: invokestatic 91	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   94: astore 10
    //   96: aload 10
    //   98: ifnull +1356 -> 1454
    //   101: aload 24
    //   103: astore 14
    //   105: aload 9
    //   107: astore 13
    //   109: aload 23
    //   111: astore 12
    //   113: aload 8
    //   115: astore 11
    //   117: aload 10
    //   119: ldc 93
    //   121: invokevirtual 99	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   124: checkcast 101	android/net/ConnectivityManager
    //   127: invokevirtual 105	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   130: astore 10
    //   132: aload 10
    //   134: ifnull +1269 -> 1403
    //   137: aload 24
    //   139: astore 14
    //   141: aload 9
    //   143: astore 13
    //   145: aload 23
    //   147: astore 12
    //   149: aload 8
    //   151: astore 11
    //   153: aload 10
    //   155: invokevirtual 111	android/net/NetworkInfo:getType	()I
    //   158: ifne +1245 -> 1403
    //   161: aload 24
    //   163: astore 14
    //   165: aload 9
    //   167: astore 13
    //   169: aload 23
    //   171: astore 12
    //   173: aload 8
    //   175: astore 11
    //   177: invokestatic 116	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   180: astore 26
    //   182: aload 24
    //   184: astore 14
    //   186: aload 9
    //   188: astore 13
    //   190: aload 23
    //   192: astore 12
    //   194: aload 8
    //   196: astore 11
    //   198: invokestatic 119	android/net/Proxy:getDefaultPort	()I
    //   201: istore 5
    //   203: aload 24
    //   205: astore 14
    //   207: aload 9
    //   209: astore 13
    //   211: aload 23
    //   213: astore 12
    //   215: aload 8
    //   217: astore 11
    //   219: new 121	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   226: ldc 124
    //   228: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload 26
    //   233: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc 130
    //   238: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: iload 5
    //   243: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   252: aload 24
    //   254: astore 14
    //   256: aload 9
    //   258: astore 13
    //   260: aload 23
    //   262: astore 12
    //   264: aload 8
    //   266: astore 11
    //   268: aload 10
    //   270: invokevirtual 143	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   273: astore 27
    //   275: aload 26
    //   277: ifnull +976 -> 1253
    //   280: iconst_m1
    //   281: iload 5
    //   283: if_icmpeq +970 -> 1253
    //   286: aload 27
    //   288: ifnull +965 -> 1253
    //   291: aload 24
    //   293: astore 14
    //   295: aload 9
    //   297: astore 13
    //   299: aload 23
    //   301: astore 12
    //   303: aload 8
    //   305: astore 11
    //   307: aload 27
    //   309: invokestatic 149	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   312: invokevirtual 155	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   315: ldc 157
    //   317: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   320: ifne +67 -> 387
    //   323: aload 24
    //   325: astore 14
    //   327: aload 9
    //   329: astore 13
    //   331: aload 23
    //   333: astore 12
    //   335: aload 8
    //   337: astore 11
    //   339: aload 27
    //   341: invokestatic 149	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   344: invokevirtual 155	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   347: ldc 163
    //   349: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifne +35 -> 387
    //   355: aload 24
    //   357: astore 14
    //   359: aload 9
    //   361: astore 13
    //   363: aload 23
    //   365: astore 12
    //   367: aload 8
    //   369: astore 11
    //   371: aload 27
    //   373: invokestatic 149	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   376: invokevirtual 155	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   379: ldc 165
    //   381: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   384: ifeq +869 -> 1253
    //   387: aload 24
    //   389: astore 14
    //   391: aload 9
    //   393: astore 13
    //   395: aload 23
    //   397: astore 12
    //   399: aload 8
    //   401: astore 11
    //   403: aload 15
    //   405: invokestatic 170	com/tencent/token/utils/s:f	(Ljava/lang/String;)Ljava/lang/String;
    //   408: astore 27
    //   410: aload 24
    //   412: astore 14
    //   414: aload 9
    //   416: astore 13
    //   418: aload 23
    //   420: astore 12
    //   422: aload 8
    //   424: astore 11
    //   426: aload 15
    //   428: invokestatic 172	com/tencent/token/utils/s:g	(Ljava/lang/String;)Ljava/lang/String;
    //   431: astore 26
    //   433: aload 27
    //   435: ifnull +43 -> 478
    //   438: aload 26
    //   440: ifnull +38 -> 478
    //   443: aload 24
    //   445: astore 14
    //   447: aload 9
    //   449: astore 13
    //   451: aload 23
    //   453: astore 12
    //   455: aload 8
    //   457: astore 11
    //   459: aload 15
    //   461: invokevirtual 175	java/lang/String:length	()I
    //   464: aload 27
    //   466: invokevirtual 175	java/lang/String:length	()I
    //   469: aload 26
    //   471: invokevirtual 175	java/lang/String:length	()I
    //   474: iadd
    //   475: if_icmpgt +424 -> 899
    //   478: aload 24
    //   480: astore 14
    //   482: aload 9
    //   484: astore 13
    //   486: aload 23
    //   488: astore 12
    //   490: aload 8
    //   492: astore 11
    //   494: aload 7
    //   496: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   499: checkcast 181	java/net/HttpURLConnection
    //   502: astore 7
    //   504: aload 24
    //   506: astore 14
    //   508: aload 9
    //   510: astore 13
    //   512: aload 23
    //   514: astore 12
    //   516: aload 8
    //   518: astore 11
    //   520: new 121	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   527: ldc 183
    //   529: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 10
    //   534: invokevirtual 143	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   537: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   546: aload 24
    //   548: astore 14
    //   550: aload 9
    //   552: astore 13
    //   554: aload 23
    //   556: astore 12
    //   558: aload 8
    //   560: astore 11
    //   562: aload 7
    //   564: sipush 20000
    //   567: invokevirtual 186	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   570: aload 24
    //   572: astore 14
    //   574: aload 9
    //   576: astore 13
    //   578: aload 23
    //   580: astore 12
    //   582: aload 8
    //   584: astore 11
    //   586: aload 7
    //   588: sipush 30000
    //   591: invokevirtual 189	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   594: aload 24
    //   596: astore 14
    //   598: aload 9
    //   600: astore 13
    //   602: aload 23
    //   604: astore 12
    //   606: aload 8
    //   608: astore 11
    //   610: aload 7
    //   612: aload_1
    //   613: invokevirtual 191	com/tencent/token/gt:e	()Ljava/lang/String;
    //   616: invokevirtual 194	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   619: aload 24
    //   621: astore 14
    //   623: aload 9
    //   625: astore 13
    //   627: aload 23
    //   629: astore 12
    //   631: aload 8
    //   633: astore 11
    //   635: aload_1
    //   636: getfield 197	com/tencent/token/gt:a	Ljava/util/Hashtable;
    //   639: invokevirtual 203	java/util/Hashtable:keys	()Ljava/util/Enumeration;
    //   642: astore 10
    //   644: aload 24
    //   646: astore 14
    //   648: aload 9
    //   650: astore 13
    //   652: aload 23
    //   654: astore 12
    //   656: aload 8
    //   658: astore 11
    //   660: aload 10
    //   662: invokeinterface 209 1 0
    //   667: ifeq +838 -> 1505
    //   670: aload 24
    //   672: astore 14
    //   674: aload 9
    //   676: astore 13
    //   678: aload 23
    //   680: astore 12
    //   682: aload 8
    //   684: astore 11
    //   686: aload 10
    //   688: invokeinterface 213 1 0
    //   693: checkcast 151	java/lang/String
    //   696: astore 26
    //   698: aload 24
    //   700: astore 14
    //   702: aload 9
    //   704: astore 13
    //   706: aload 23
    //   708: astore 12
    //   710: aload 8
    //   712: astore 11
    //   714: aload 7
    //   716: aload 26
    //   718: aload_1
    //   719: getfield 197	com/tencent/token/gt:a	Ljava/util/Hashtable;
    //   722: aload 26
    //   724: invokevirtual 217	java/util/Hashtable:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   727: checkcast 151	java/lang/String
    //   730: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: goto -89 -> 644
    //   736: astore 10
    //   738: aconst_null
    //   739: astore_2
    //   740: aload 9
    //   742: astore 7
    //   744: aconst_null
    //   745: astore 11
    //   747: aload 8
    //   749: astore 9
    //   751: aload 11
    //   753: astore 8
    //   755: new 121	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   762: aload 10
    //   764: invokevirtual 222	java/lang/Exception:toString	()Ljava/lang/String;
    //   767: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: ldc 224
    //   772: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 10
    //   777: invokevirtual 227	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   780: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: astore 10
    //   788: aload_2
    //   789: ifnull +7 -> 796
    //   792: aload_2
    //   793: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   796: aload 8
    //   798: ifnull +8 -> 806
    //   801: aload 8
    //   803: invokevirtual 235	java/io/InputStream:close	()V
    //   806: aload 7
    //   808: ifnull +8 -> 816
    //   811: aload 7
    //   813: invokevirtual 238	java/io/OutputStream:close	()V
    //   816: aload 9
    //   818: ifnull +2066 -> 2884
    //   821: aload 9
    //   823: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   826: aload 10
    //   828: astore_2
    //   829: aconst_null
    //   830: astore 8
    //   832: iconst_1
    //   833: istore 4
    //   835: iload 4
    //   837: ifeq +1765 -> 2602
    //   840: aload 25
    //   842: invokeinterface 245 1 0
    //   847: new 121	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   854: ldc 247
    //   856: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload_2
    //   860: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   869: aload_1
    //   870: invokevirtual 249	com/tencent/token/gt:d	()I
    //   873: iconst_1
    //   874: if_icmpne +24 -> 898
    //   877: aload_0
    //   878: iconst_1
    //   879: putfield 46	com/tencent/token/gr:h	Z
    //   882: aload_0
    //   883: getfield 48	com/tencent/token/gr:i	[I
    //   886: astore_1
    //   887: aload_1
    //   888: monitorenter
    //   889: aload_0
    //   890: getfield 48	com/tencent/token/gr:i	[I
    //   893: invokevirtual 252	java/lang/Object:notifyAll	()V
    //   896: aload_1
    //   897: monitorexit
    //   898: return
    //   899: aload 24
    //   901: astore 14
    //   903: aload 9
    //   905: astore 13
    //   907: aload 23
    //   909: astore 12
    //   911: aload 8
    //   913: astore 11
    //   915: new 121	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   922: ldc 254
    //   924: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: invokestatic 116	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   930: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: ldc_w 256
    //   936: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokestatic 119	android/net/Proxy:getDefaultPort	()I
    //   942: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   945: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   951: aload 24
    //   953: astore 14
    //   955: aload 9
    //   957: astore 13
    //   959: aload 23
    //   961: astore 12
    //   963: aload 8
    //   965: astore 11
    //   967: new 121	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   974: aload 27
    //   976: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokestatic 116	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   982: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload 15
    //   987: aload 27
    //   989: invokevirtual 175	java/lang/String:length	()I
    //   992: aload 26
    //   994: invokevirtual 175	java/lang/String:length	()I
    //   997: iadd
    //   998: invokevirtual 260	java/lang/String:substring	(I)Ljava/lang/String;
    //   1001: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: astore 7
    //   1009: aload 24
    //   1011: astore 14
    //   1013: aload 9
    //   1015: astore 13
    //   1017: aload 23
    //   1019: astore 12
    //   1021: aload 8
    //   1023: astore 11
    //   1025: new 121	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1032: ldc_w 262
    //   1035: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload 7
    //   1040: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1049: aload 24
    //   1051: astore 14
    //   1053: aload 9
    //   1055: astore 13
    //   1057: aload 23
    //   1059: astore 12
    //   1061: aload 8
    //   1063: astore 11
    //   1065: new 83	java/net/URL
    //   1068: dup
    //   1069: aload 7
    //   1071: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1074: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1077: checkcast 181	java/net/HttpURLConnection
    //   1080: astore 7
    //   1082: aload 24
    //   1084: astore 14
    //   1086: aload 9
    //   1088: astore 13
    //   1090: aload 23
    //   1092: astore 12
    //   1094: aload 8
    //   1096: astore 11
    //   1098: aload 7
    //   1100: ldc_w 264
    //   1103: aload 26
    //   1105: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1108: aload 24
    //   1110: astore 14
    //   1112: aload 9
    //   1114: astore 13
    //   1116: aload 23
    //   1118: astore 12
    //   1120: aload 8
    //   1122: astore 11
    //   1124: aload 7
    //   1126: ldc_w 266
    //   1129: invokestatic 116	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1132: invokevirtual 221	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1135: goto -631 -> 504
    //   1138: astore 7
    //   1140: aload 8
    //   1142: astore_2
    //   1143: aload 18
    //   1145: astore 10
    //   1147: aload 9
    //   1149: astore 8
    //   1151: aload 16
    //   1153: astore 15
    //   1155: aload 15
    //   1157: astore 14
    //   1159: aload 8
    //   1161: astore 13
    //   1163: aload 10
    //   1165: astore 12
    //   1167: aload_2
    //   1168: astore 11
    //   1170: new 121	java/lang/StringBuilder
    //   1173: dup
    //   1174: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1177: aload 7
    //   1179: invokevirtual 267	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1182: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: ldc 224
    //   1187: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: aload 7
    //   1192: invokevirtual 268	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1195: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: astore 7
    //   1203: aload 15
    //   1205: ifnull +8 -> 1213
    //   1208: aload 15
    //   1210: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   1213: aload 10
    //   1215: ifnull +8 -> 1223
    //   1218: aload 10
    //   1220: invokevirtual 235	java/io/InputStream:close	()V
    //   1223: aload 8
    //   1225: ifnull +8 -> 1233
    //   1228: aload 8
    //   1230: invokevirtual 238	java/io/OutputStream:close	()V
    //   1233: aload_2
    //   1234: ifnull +1638 -> 2872
    //   1237: aload_2
    //   1238: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   1241: aconst_null
    //   1242: astore 8
    //   1244: iconst_1
    //   1245: istore 4
    //   1247: aload 7
    //   1249: astore_2
    //   1250: goto -415 -> 835
    //   1253: aload 26
    //   1255: ifnull +119 -> 1374
    //   1258: iconst_m1
    //   1259: iload 5
    //   1261: if_icmpeq +113 -> 1374
    //   1264: aload 27
    //   1266: ifnull +108 -> 1374
    //   1269: aload 24
    //   1271: astore 14
    //   1273: aload 9
    //   1275: astore 13
    //   1277: aload 23
    //   1279: astore 12
    //   1281: aload 8
    //   1283: astore 11
    //   1285: aload 27
    //   1287: invokestatic 149	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1290: invokevirtual 155	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   1293: ldc_w 270
    //   1296: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1299: ifeq +75 -> 1374
    //   1302: aload 24
    //   1304: astore 14
    //   1306: aload 9
    //   1308: astore 13
    //   1310: aload 23
    //   1312: astore 12
    //   1314: aload 8
    //   1316: astore 11
    //   1318: new 272	java/net/InetSocketAddress
    //   1321: dup
    //   1322: invokestatic 116	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   1325: invokestatic 119	android/net/Proxy:getDefaultPort	()I
    //   1328: invokespecial 275	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   1331: astore 26
    //   1333: aload 24
    //   1335: astore 14
    //   1337: aload 9
    //   1339: astore 13
    //   1341: aload 23
    //   1343: astore 12
    //   1345: aload 8
    //   1347: astore 11
    //   1349: aload 7
    //   1351: new 277	java/net/Proxy
    //   1354: dup
    //   1355: getstatic 283	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   1358: aload 26
    //   1360: invokespecial 286	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   1363: invokevirtual 289	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1366: checkcast 181	java/net/HttpURLConnection
    //   1369: astore 7
    //   1371: goto -867 -> 504
    //   1374: aload 24
    //   1376: astore 14
    //   1378: aload 9
    //   1380: astore 13
    //   1382: aload 23
    //   1384: astore 12
    //   1386: aload 8
    //   1388: astore 11
    //   1390: aload 7
    //   1392: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1395: checkcast 181	java/net/HttpURLConnection
    //   1398: astore 7
    //   1400: goto -896 -> 504
    //   1403: aload 24
    //   1405: astore 14
    //   1407: aload 9
    //   1409: astore 13
    //   1411: aload 23
    //   1413: astore 12
    //   1415: aload 8
    //   1417: astore 11
    //   1419: aload 7
    //   1421: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1424: checkcast 181	java/net/HttpURLConnection
    //   1427: astore 7
    //   1429: aload 24
    //   1431: astore 14
    //   1433: aload 9
    //   1435: astore 13
    //   1437: aload 23
    //   1439: astore 12
    //   1441: aload 8
    //   1443: astore 11
    //   1445: ldc_w 291
    //   1448: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1451: goto -905 -> 546
    //   1454: aload 24
    //   1456: astore 14
    //   1458: aload 9
    //   1460: astore 13
    //   1462: aload 23
    //   1464: astore 12
    //   1466: aload 8
    //   1468: astore 11
    //   1470: aload 7
    //   1472: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1475: checkcast 181	java/net/HttpURLConnection
    //   1478: astore 7
    //   1480: aload 24
    //   1482: astore 14
    //   1484: aload 9
    //   1486: astore 13
    //   1488: aload 23
    //   1490: astore 12
    //   1492: aload 8
    //   1494: astore 11
    //   1496: ldc_w 293
    //   1499: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1502: goto -956 -> 546
    //   1505: aload 9
    //   1507: astore 13
    //   1509: aload 21
    //   1511: astore 10
    //   1513: aload 9
    //   1515: astore 11
    //   1517: aload 9
    //   1519: astore 14
    //   1521: aload 22
    //   1523: astore 12
    //   1525: aload_1
    //   1526: invokevirtual 296	com/tencent/token/gt:c	()[B
    //   1529: astore 26
    //   1531: aload 9
    //   1533: astore 8
    //   1535: aload 26
    //   1537: ifnull +106 -> 1643
    //   1540: aload 9
    //   1542: astore 8
    //   1544: aload 9
    //   1546: astore 13
    //   1548: aload 21
    //   1550: astore 10
    //   1552: aload 9
    //   1554: astore 11
    //   1556: aload 9
    //   1558: astore 14
    //   1560: aload 22
    //   1562: astore 12
    //   1564: aload 26
    //   1566: arraylength
    //   1567: ifeq +76 -> 1643
    //   1570: aload 9
    //   1572: astore 13
    //   1574: aload 21
    //   1576: astore 10
    //   1578: aload 9
    //   1580: astore 11
    //   1582: aload 9
    //   1584: astore 14
    //   1586: aload 22
    //   1588: astore 12
    //   1590: aload 7
    //   1592: iconst_1
    //   1593: invokevirtual 300	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   1596: aload 9
    //   1598: astore 13
    //   1600: aload 21
    //   1602: astore 10
    //   1604: aload 9
    //   1606: astore 11
    //   1608: aload 9
    //   1610: astore 14
    //   1612: aload 22
    //   1614: astore 12
    //   1616: aload 7
    //   1618: invokevirtual 304	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   1621: astore 8
    //   1623: aload 8
    //   1625: aload 26
    //   1627: invokevirtual 308	java/io/OutputStream:write	([B)V
    //   1630: aload 8
    //   1632: invokevirtual 311	java/io/OutputStream:flush	()V
    //   1635: aload 8
    //   1637: invokevirtual 238	java/io/OutputStream:close	()V
    //   1640: aconst_null
    //   1641: astore 8
    //   1643: aload 8
    //   1645: astore 13
    //   1647: aload 21
    //   1649: astore 10
    //   1651: aload 8
    //   1653: astore 11
    //   1655: aload 8
    //   1657: astore 14
    //   1659: aload 22
    //   1661: astore 12
    //   1663: new 121	java/lang/StringBuilder
    //   1666: dup
    //   1667: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1670: ldc_w 313
    //   1673: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: aload_1
    //   1677: invokevirtual 81	com/tencent/token/gt:a	()Ljava/lang/String;
    //   1680: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1689: aload 8
    //   1691: astore 13
    //   1693: aload 21
    //   1695: astore 10
    //   1697: aload 8
    //   1699: astore 11
    //   1701: aload 8
    //   1703: astore 14
    //   1705: aload 22
    //   1707: astore 12
    //   1709: aload 7
    //   1711: invokevirtual 316	java/net/HttpURLConnection:getResponseCode	()I
    //   1714: istore 6
    //   1716: iconst_m1
    //   1717: iload 6
    //   1719: if_icmpne +1195 -> 2914
    //   1722: aload 15
    //   1724: ifnull +1190 -> 2914
    //   1727: aload 8
    //   1729: astore 13
    //   1731: aload 21
    //   1733: astore 10
    //   1735: aload 8
    //   1737: astore 11
    //   1739: aload 7
    //   1741: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   1744: aload 8
    //   1746: astore 13
    //   1748: aload 21
    //   1750: astore 10
    //   1752: aload 8
    //   1754: astore 11
    //   1756: ldc2_w 317
    //   1759: invokestatic 324	java/lang/Thread:sleep	(J)V
    //   1762: aload 8
    //   1764: astore 13
    //   1766: aload 21
    //   1768: astore 10
    //   1770: aload 8
    //   1772: astore 11
    //   1774: new 121	java/lang/StringBuilder
    //   1777: dup
    //   1778: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1781: ldc_w 326
    //   1784: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: iload 6
    //   1789: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1792: ldc_w 328
    //   1795: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: iconst_0
    //   1799: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1802: ldc_w 330
    //   1805: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: bipush 100
    //   1810: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1813: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1816: invokestatic 140	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   1819: iload 4
    //   1821: iconst_1
    //   1822: iadd
    //   1823: istore 4
    //   1825: aload 8
    //   1827: astore 9
    //   1829: aload 7
    //   1831: astore 8
    //   1833: goto -1785 -> 48
    //   1836: astore_2
    //   1837: aload 8
    //   1839: astore 13
    //   1841: aload 21
    //   1843: astore 10
    //   1845: aload 8
    //   1847: astore 11
    //   1849: aload 8
    //   1851: astore 14
    //   1853: aload 22
    //   1855: astore 12
    //   1857: aload_2
    //   1858: athrow
    //   1859: iload 4
    //   1861: iconst_3
    //   1862: if_icmpge +1095 -> 2957
    //   1865: aload 8
    //   1867: astore 13
    //   1869: aload 21
    //   1871: astore 10
    //   1873: aload 8
    //   1875: astore 11
    //   1877: aload 8
    //   1879: astore 14
    //   1881: aload 22
    //   1883: astore 12
    //   1885: aload 7
    //   1887: ldc_w 332
    //   1890: invokevirtual 335	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1893: astore 15
    //   1895: aload 15
    //   1897: ifnull +55 -> 1952
    //   1900: aload 8
    //   1902: astore 13
    //   1904: aload 21
    //   1906: astore 10
    //   1908: aload 8
    //   1910: astore 11
    //   1912: aload 7
    //   1914: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   1917: aload 8
    //   1919: astore 13
    //   1921: aload 21
    //   1923: astore 10
    //   1925: aload 8
    //   1927: astore 11
    //   1929: ldc2_w 317
    //   1932: invokestatic 324	java/lang/Thread:sleep	(J)V
    //   1935: iload 4
    //   1937: iconst_1
    //   1938: iadd
    //   1939: istore 4
    //   1941: aload 8
    //   1943: astore 9
    //   1945: aload 7
    //   1947: astore 8
    //   1949: goto -1901 -> 48
    //   1952: aload 8
    //   1954: astore 13
    //   1956: aload 21
    //   1958: astore 10
    //   1960: aload 8
    //   1962: astore 11
    //   1964: aload 8
    //   1966: astore 14
    //   1968: aload 22
    //   1970: astore 12
    //   1972: new 73	java/io/IOException
    //   1975: dup
    //   1976: ldc_w 337
    //   1979: invokespecial 338	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1982: athrow
    //   1983: aload 8
    //   1985: astore 13
    //   1987: aload 21
    //   1989: astore 10
    //   1991: aload 8
    //   1993: astore 11
    //   1995: aload 8
    //   1997: astore 14
    //   1999: aload 22
    //   2001: astore 12
    //   2003: aload 7
    //   2005: invokevirtual 341	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2008: astore 9
    //   2010: aload 8
    //   2012: astore 13
    //   2014: aload 21
    //   2016: astore 10
    //   2018: aload 8
    //   2020: astore 11
    //   2022: aload 8
    //   2024: astore 14
    //   2026: aload 22
    //   2028: astore 12
    //   2030: aload_1
    //   2031: aload 9
    //   2033: putfield 343	com/tencent/token/gt:b	Ljava/lang/String;
    //   2036: aload 9
    //   2038: ifnonnull +143 -> 2181
    //   2041: ldc_w 345
    //   2044: astore 9
    //   2046: iload_3
    //   2047: ifne +164 -> 2211
    //   2050: aload 8
    //   2052: astore 13
    //   2054: aload 21
    //   2056: astore 10
    //   2058: aload 8
    //   2060: astore 11
    //   2062: aload 8
    //   2064: astore 14
    //   2066: aload 22
    //   2068: astore 12
    //   2070: aload_1
    //   2071: getfield 347	com/tencent/token/gt:e	Z
    //   2074: ifeq +137 -> 2211
    //   2077: aload 8
    //   2079: astore 13
    //   2081: aload 21
    //   2083: astore 10
    //   2085: aload 8
    //   2087: astore 11
    //   2089: aload 8
    //   2091: astore 14
    //   2093: aload 22
    //   2095: astore 12
    //   2097: aload 9
    //   2099: ldc_w 349
    //   2102: invokevirtual 353	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2105: iconst_m1
    //   2106: if_icmpne +35 -> 2141
    //   2109: aload 8
    //   2111: astore 13
    //   2113: aload 21
    //   2115: astore 10
    //   2117: aload 8
    //   2119: astore 11
    //   2121: aload 8
    //   2123: astore 14
    //   2125: aload 22
    //   2127: astore 12
    //   2129: aload 9
    //   2131: ldc_w 355
    //   2134: invokevirtual 353	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2137: iconst_m1
    //   2138: if_icmpeq +73 -> 2211
    //   2141: aload 8
    //   2143: astore 13
    //   2145: aload 21
    //   2147: astore 10
    //   2149: aload 8
    //   2151: astore 11
    //   2153: aload 8
    //   2155: astore 14
    //   2157: aload 22
    //   2159: astore 12
    //   2161: aload_0
    //   2162: aload_1
    //   2163: aload_2
    //   2164: iconst_1
    //   2165: invokespecial 67	com/tencent/token/gr:a	(Lcom/tencent/token/gt;Lcom/tencent/token/gs;Z)V
    //   2168: aload 7
    //   2170: ifnull -1272 -> 898
    //   2173: aload 7
    //   2175: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   2178: return
    //   2179: astore_1
    //   2180: return
    //   2181: aload 8
    //   2183: astore 13
    //   2185: aload 21
    //   2187: astore 10
    //   2189: aload 8
    //   2191: astore 11
    //   2193: aload 8
    //   2195: astore 14
    //   2197: aload 22
    //   2199: astore 12
    //   2201: aload 9
    //   2203: invokevirtual 357	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2206: astore 9
    //   2208: goto -162 -> 2046
    //   2211: aload 8
    //   2213: astore 13
    //   2215: aload 21
    //   2217: astore 10
    //   2219: aload 8
    //   2221: astore 11
    //   2223: aload 8
    //   2225: astore 14
    //   2227: aload 22
    //   2229: astore 12
    //   2231: aload_1
    //   2232: aload 7
    //   2234: invokevirtual 360	java/net/HttpURLConnection:getContentLength	()I
    //   2237: i2l
    //   2238: putfield 363	com/tencent/token/gt:c	J
    //   2241: aload 8
    //   2243: astore 13
    //   2245: aload 21
    //   2247: astore 10
    //   2249: aload 8
    //   2251: astore 11
    //   2253: aload 8
    //   2255: astore 14
    //   2257: aload 22
    //   2259: astore 12
    //   2261: aload 7
    //   2263: invokevirtual 367	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2266: astore 9
    //   2268: aload 8
    //   2270: astore 13
    //   2272: aload 9
    //   2274: astore 10
    //   2276: aload 8
    //   2278: astore 14
    //   2280: aload 9
    //   2282: astore 12
    //   2284: new 229	java/io/ByteArrayOutputStream
    //   2287: dup
    //   2288: invokespecial 368	java/io/ByteArrayOutputStream:<init>	()V
    //   2291: astore 11
    //   2293: aload 9
    //   2295: invokevirtual 371	java/io/InputStream:read	()I
    //   2298: istore 4
    //   2300: iload 4
    //   2302: iconst_m1
    //   2303: if_icmpeq +48 -> 2351
    //   2306: aload_0
    //   2307: getfield 42	com/tencent/token/gr:f	Z
    //   2310: ifeq +10 -> 2320
    //   2313: aload_2
    //   2314: getfield 373	com/tencent/token/gs:b	Z
    //   2317: ifeq +14 -> 2331
    //   2320: new 73	java/io/IOException
    //   2323: dup
    //   2324: ldc_w 375
    //   2327: invokespecial 338	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2330: athrow
    //   2331: aload 11
    //   2333: iload 4
    //   2335: invokevirtual 377	java/io/ByteArrayOutputStream:write	(I)V
    //   2338: aload_1
    //   2339: aload_1
    //   2340: getfield 379	com/tencent/token/gt:d	J
    //   2343: lconst_1
    //   2344: ladd
    //   2345: putfield 379	com/tencent/token/gt:d	J
    //   2348: goto -55 -> 2293
    //   2351: aload 11
    //   2353: invokevirtual 380	java/io/ByteArrayOutputStream:flush	()V
    //   2356: aload 11
    //   2358: invokevirtual 383	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2361: astore 10
    //   2363: iconst_0
    //   2364: istore 5
    //   2366: aload 11
    //   2368: astore 8
    //   2370: ldc_w 345
    //   2373: astore 11
    //   2375: aload 9
    //   2377: astore_2
    //   2378: aload 11
    //   2380: astore 9
    //   2382: aload 8
    //   2384: ifnull +8 -> 2392
    //   2387: aload 8
    //   2389: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   2392: aload_2
    //   2393: ifnull +7 -> 2400
    //   2396: aload_2
    //   2397: invokevirtual 235	java/io/InputStream:close	()V
    //   2400: iload 5
    //   2402: istore 4
    //   2404: aload 9
    //   2406: astore_2
    //   2407: aload 10
    //   2409: astore 8
    //   2411: aload 7
    //   2413: ifnull -1578 -> 835
    //   2416: aload 7
    //   2418: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   2421: iload 5
    //   2423: istore 4
    //   2425: aload 9
    //   2427: astore_2
    //   2428: aload 10
    //   2430: astore 8
    //   2432: goto -1597 -> 835
    //   2435: astore_2
    //   2436: iload 5
    //   2438: istore 4
    //   2440: aload 9
    //   2442: astore_2
    //   2443: aload 10
    //   2445: astore 8
    //   2447: goto -1612 -> 835
    //   2450: iconst_1
    //   2451: istore 5
    //   2453: aload 8
    //   2455: astore 13
    //   2457: aload 21
    //   2459: astore 10
    //   2461: aload 8
    //   2463: astore 11
    //   2465: aload 8
    //   2467: astore 14
    //   2469: aload 22
    //   2471: astore 12
    //   2473: new 121	java/lang/StringBuilder
    //   2476: dup
    //   2477: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2480: ldc_w 385
    //   2483: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2486: iload 6
    //   2488: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2491: ldc_w 387
    //   2494: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: aload 7
    //   2499: invokevirtual 390	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   2502: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2508: astore 9
    //   2510: aconst_null
    //   2511: astore 8
    //   2513: aconst_null
    //   2514: astore 10
    //   2516: aload 20
    //   2518: astore_2
    //   2519: goto -137 -> 2382
    //   2522: astore_2
    //   2523: aload 10
    //   2525: astore_2
    //   2526: aconst_null
    //   2527: astore 8
    //   2529: iconst_1
    //   2530: istore 4
    //   2532: goto -1697 -> 835
    //   2535: astore_2
    //   2536: aconst_null
    //   2537: astore 8
    //   2539: iconst_1
    //   2540: istore 4
    //   2542: aload 7
    //   2544: astore_2
    //   2545: goto -1710 -> 835
    //   2548: astore_1
    //   2549: aconst_null
    //   2550: astore_2
    //   2551: aconst_null
    //   2552: astore 8
    //   2554: aload 19
    //   2556: astore 9
    //   2558: aload 17
    //   2560: astore 7
    //   2562: aload 7
    //   2564: ifnull +8 -> 2572
    //   2567: aload 7
    //   2569: invokevirtual 232	java/io/ByteArrayOutputStream:close	()V
    //   2572: aload 9
    //   2574: ifnull +8 -> 2582
    //   2577: aload 9
    //   2579: invokevirtual 235	java/io/InputStream:close	()V
    //   2582: aload 8
    //   2584: ifnull +8 -> 2592
    //   2587: aload 8
    //   2589: invokevirtual 238	java/io/OutputStream:close	()V
    //   2592: aload_2
    //   2593: ifnull +7 -> 2600
    //   2596: aload_2
    //   2597: invokevirtual 241	java/net/HttpURLConnection:disconnect	()V
    //   2600: aload_1
    //   2601: athrow
    //   2602: aload 25
    //   2604: aload 8
    //   2606: invokeinterface 392 2 0
    //   2611: goto -1742 -> 869
    //   2614: astore_2
    //   2615: goto -1746 -> 869
    //   2618: astore_2
    //   2619: aload_1
    //   2620: monitorexit
    //   2621: aload_2
    //   2622: athrow
    //   2623: astore 8
    //   2625: goto -233 -> 2392
    //   2628: astore_2
    //   2629: goto -229 -> 2400
    //   2632: astore_2
    //   2633: goto -1837 -> 796
    //   2636: astore_2
    //   2637: goto -1831 -> 806
    //   2640: astore_2
    //   2641: goto -1825 -> 816
    //   2644: astore 9
    //   2646: goto -1433 -> 1213
    //   2649: astore 9
    //   2651: goto -1428 -> 1223
    //   2654: astore 8
    //   2656: goto -1423 -> 1233
    //   2659: astore 7
    //   2661: goto -89 -> 2572
    //   2664: astore 7
    //   2666: goto -84 -> 2582
    //   2669: astore 7
    //   2671: goto -79 -> 2592
    //   2674: astore_2
    //   2675: goto -75 -> 2600
    //   2678: astore_2
    //   2679: goto -1810 -> 869
    //   2682: astore_1
    //   2683: aload 7
    //   2685: astore_2
    //   2686: aload 17
    //   2688: astore 7
    //   2690: aload 13
    //   2692: astore 8
    //   2694: aload 10
    //   2696: astore 9
    //   2698: goto -136 -> 2562
    //   2701: astore_1
    //   2702: aload 7
    //   2704: astore_2
    //   2705: aload 17
    //   2707: astore 7
    //   2709: aload 19
    //   2711: astore 9
    //   2713: goto -151 -> 2562
    //   2716: astore_1
    //   2717: aload 14
    //   2719: astore 7
    //   2721: aload 13
    //   2723: astore 8
    //   2725: aload 12
    //   2727: astore 9
    //   2729: aload 11
    //   2731: astore_2
    //   2732: goto -170 -> 2562
    //   2735: astore_1
    //   2736: aload 7
    //   2738: astore_2
    //   2739: aload 11
    //   2741: astore 7
    //   2743: goto -181 -> 2562
    //   2746: astore_1
    //   2747: aload 9
    //   2749: astore 10
    //   2751: aload 8
    //   2753: astore 9
    //   2755: aload 7
    //   2757: astore 8
    //   2759: aload_2
    //   2760: astore 7
    //   2762: aload 10
    //   2764: astore_2
    //   2765: goto -203 -> 2562
    //   2768: astore 7
    //   2770: aconst_null
    //   2771: astore_2
    //   2772: aconst_null
    //   2773: astore 8
    //   2775: aload 16
    //   2777: astore 15
    //   2779: aload 18
    //   2781: astore 10
    //   2783: goto -1628 -> 1155
    //   2786: astore 9
    //   2788: aload 7
    //   2790: astore_2
    //   2791: aload 9
    //   2793: astore 7
    //   2795: aload 16
    //   2797: astore 15
    //   2799: aload 18
    //   2801: astore 10
    //   2803: goto -1648 -> 1155
    //   2806: astore 10
    //   2808: aconst_null
    //   2809: astore 7
    //   2811: aconst_null
    //   2812: astore_2
    //   2813: aconst_null
    //   2814: astore 9
    //   2816: aconst_null
    //   2817: astore 8
    //   2819: goto -2064 -> 755
    //   2822: astore 10
    //   2824: aconst_null
    //   2825: astore 11
    //   2827: aload 7
    //   2829: astore 9
    //   2831: aload 8
    //   2833: astore 7
    //   2835: aconst_null
    //   2836: astore_2
    //   2837: aload 11
    //   2839: astore 8
    //   2841: goto -2086 -> 755
    //   2844: astore 10
    //   2846: aconst_null
    //   2847: astore_2
    //   2848: aload 7
    //   2850: astore 11
    //   2852: aload 8
    //   2854: astore 7
    //   2856: aload 9
    //   2858: astore 8
    //   2860: aload 11
    //   2862: astore 9
    //   2864: goto -2109 -> 755
    //   2867: astore 9
    //   2869: goto -934 -> 1935
    //   2872: aconst_null
    //   2873: astore 8
    //   2875: iconst_1
    //   2876: istore 4
    //   2878: aload 7
    //   2880: astore_2
    //   2881: goto -2046 -> 835
    //   2884: aload 10
    //   2886: astore_2
    //   2887: aconst_null
    //   2888: astore 8
    //   2890: iconst_1
    //   2891: istore 4
    //   2893: goto -2058 -> 835
    //   2896: astore 10
    //   2898: aconst_null
    //   2899: astore_2
    //   2900: aconst_null
    //   2901: astore 8
    //   2903: aload 7
    //   2905: astore 9
    //   2907: aload 11
    //   2909: astore 7
    //   2911: goto -2156 -> 755
    //   2914: iload 6
    //   2916: sipush 302
    //   2919: if_icmpeq -1060 -> 1859
    //   2922: iload 6
    //   2924: sipush 301
    //   2927: if_icmpne +30 -> 2957
    //   2930: goto -1071 -> 1859
    //   2933: astore 8
    //   2935: aload 7
    //   2937: astore_2
    //   2938: aload 8
    //   2940: astore 7
    //   2942: aload 16
    //   2944: astore 15
    //   2946: aload 14
    //   2948: astore 8
    //   2950: aload 12
    //   2952: astore 10
    //   2954: goto -1799 -> 1155
    //   2957: iload 6
    //   2959: sipush 200
    //   2962: if_icmpeq -979 -> 1983
    //   2965: iload 6
    //   2967: sipush 206
    //   2970: if_icmpeq -987 -> 1983
    //   2973: iload 6
    //   2975: iconst_m1
    //   2976: if_icmpne -526 -> 2450
    //   2979: goto -996 -> 1983
    //   2982: astore 10
    //   2984: aload 7
    //   2986: astore 12
    //   2988: aload 11
    //   2990: astore_2
    //   2991: aload 8
    //   2993: astore 7
    //   2995: aload 9
    //   2997: astore 8
    //   2999: aload 12
    //   3001: astore 9
    //   3003: goto -2248 -> 755
    //   3006: astore 10
    //   3008: aload 7
    //   3010: astore_2
    //   3011: aload 10
    //   3013: astore 7
    //   3015: aload 11
    //   3017: astore 15
    //   3019: aload 9
    //   3021: astore 10
    //   3023: goto -1868 -> 1155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3026	0	this	gr
    //   0	3026	1	paramgt	gt
    //   0	3026	2	paramgs	gs
    //   0	3026	3	paramBoolean	boolean
    //   40	2852	4	m	int
    //   201	2251	5	n	int
    //   1714	1263	6	i1	int
    //   73	1052	7	localObject1	Object
    //   1138	53	7	localThrowable1	java.lang.Throwable
    //   1201	1367	7	localObject2	Object
    //   2659	1	7	localIOException1	java.io.IOException
    //   2664	1	7	localIOException2	java.io.IOException
    //   2669	15	7	localException1	java.lang.Exception
    //   2688	73	7	localObject3	Object
    //   2768	21	7	localThrowable2	java.lang.Throwable
    //   2793	221	7	localObject4	Object
    //   43	2562	8	localObject5	Object
    //   2623	1	8	localIOException3	java.io.IOException
    //   2654	1	8	localException2	java.lang.Exception
    //   2692	210	8	localObject6	Object
    //   2933	6	8	localThrowable3	java.lang.Throwable
    //   2948	50	8	localObject7	Object
    //   46	2532	9	localObject8	Object
    //   2644	1	9	localIOException4	java.io.IOException
    //   2649	1	9	localIOException5	java.io.IOException
    //   2696	58	9	localObject9	Object
    //   2786	6	9	localThrowable4	java.lang.Throwable
    //   2814	49	9	localObject10	Object
    //   2867	1	9	localThrowable5	java.lang.Throwable
    //   2905	115	9	localObject11	Object
    //   94	593	10	localObject12	Object
    //   736	40	10	localException3	java.lang.Exception
    //   786	2016	10	localObject13	Object
    //   2806	1	10	localException4	java.lang.Exception
    //   2822	1	10	localException5	java.lang.Exception
    //   2844	41	10	localException6	java.lang.Exception
    //   2896	1	10	localException7	java.lang.Exception
    //   2952	1	10	localObject14	Object
    //   2982	1	10	localException8	java.lang.Exception
    //   3006	6	10	localThrowable6	java.lang.Throwable
    //   3021	1	10	localObject15	Object
    //   62	2954	11	localObject16	Object
    //   58	2942	12	localObject17	Object
    //   54	2668	13	localObject18	Object
    //   50	2897	14	localObject19	Object
    //   37	2981	15	localObject20	Object
    //   31	2912	16	localObject21	Object
    //   25	2681	17	localObject22	Object
    //   22	2778	18	localObject23	Object
    //   10	2700	19	localObject24	Object
    //   7	2510	20	localObject25	Object
    //   13	2445	21	localObject26	Object
    //   19	2451	22	localObject27	Object
    //   16	1473	23	localObject28	Object
    //   28	1453	24	localObject29	Object
    //   4	2599	25	localgu	gu
    //   180	1446	26	localObject30	Object
    //   273	1013	27	str	String
    // Exception table:
    //   from	to	target	type
    //   64	75	736	java/lang/Exception
    //   91	96	736	java/lang/Exception
    //   117	132	736	java/lang/Exception
    //   153	161	736	java/lang/Exception
    //   177	182	736	java/lang/Exception
    //   198	203	736	java/lang/Exception
    //   219	252	736	java/lang/Exception
    //   268	275	736	java/lang/Exception
    //   307	323	736	java/lang/Exception
    //   339	355	736	java/lang/Exception
    //   371	387	736	java/lang/Exception
    //   403	410	736	java/lang/Exception
    //   426	433	736	java/lang/Exception
    //   459	478	736	java/lang/Exception
    //   494	504	736	java/lang/Exception
    //   520	546	736	java/lang/Exception
    //   562	570	736	java/lang/Exception
    //   586	594	736	java/lang/Exception
    //   610	619	736	java/lang/Exception
    //   635	644	736	java/lang/Exception
    //   660	670	736	java/lang/Exception
    //   686	698	736	java/lang/Exception
    //   714	733	736	java/lang/Exception
    //   915	951	736	java/lang/Exception
    //   967	1009	736	java/lang/Exception
    //   1025	1049	736	java/lang/Exception
    //   1065	1082	736	java/lang/Exception
    //   1098	1108	736	java/lang/Exception
    //   1124	1135	736	java/lang/Exception
    //   1285	1302	736	java/lang/Exception
    //   1318	1333	736	java/lang/Exception
    //   1349	1371	736	java/lang/Exception
    //   1390	1400	736	java/lang/Exception
    //   1419	1429	736	java/lang/Exception
    //   1445	1451	736	java/lang/Exception
    //   1470	1480	736	java/lang/Exception
    //   1496	1502	736	java/lang/Exception
    //   64	75	1138	java/lang/Throwable
    //   91	96	1138	java/lang/Throwable
    //   117	132	1138	java/lang/Throwable
    //   153	161	1138	java/lang/Throwable
    //   177	182	1138	java/lang/Throwable
    //   198	203	1138	java/lang/Throwable
    //   219	252	1138	java/lang/Throwable
    //   268	275	1138	java/lang/Throwable
    //   307	323	1138	java/lang/Throwable
    //   339	355	1138	java/lang/Throwable
    //   371	387	1138	java/lang/Throwable
    //   403	410	1138	java/lang/Throwable
    //   426	433	1138	java/lang/Throwable
    //   459	478	1138	java/lang/Throwable
    //   494	504	1138	java/lang/Throwable
    //   520	546	1138	java/lang/Throwable
    //   562	570	1138	java/lang/Throwable
    //   586	594	1138	java/lang/Throwable
    //   610	619	1138	java/lang/Throwable
    //   635	644	1138	java/lang/Throwable
    //   660	670	1138	java/lang/Throwable
    //   686	698	1138	java/lang/Throwable
    //   714	733	1138	java/lang/Throwable
    //   915	951	1138	java/lang/Throwable
    //   967	1009	1138	java/lang/Throwable
    //   1025	1049	1138	java/lang/Throwable
    //   1065	1082	1138	java/lang/Throwable
    //   1098	1108	1138	java/lang/Throwable
    //   1124	1135	1138	java/lang/Throwable
    //   1285	1302	1138	java/lang/Throwable
    //   1318	1333	1138	java/lang/Throwable
    //   1349	1371	1138	java/lang/Throwable
    //   1390	1400	1138	java/lang/Throwable
    //   1419	1429	1138	java/lang/Throwable
    //   1445	1451	1138	java/lang/Throwable
    //   1470	1480	1138	java/lang/Throwable
    //   1496	1502	1138	java/lang/Throwable
    //   1739	1744	1836	java/lang/Throwable
    //   1756	1762	1836	java/lang/Throwable
    //   1774	1819	1836	java/lang/Throwable
    //   2173	2178	2179	java/lang/Exception
    //   2416	2421	2435	java/lang/Exception
    //   821	826	2522	java/lang/Exception
    //   1237	1241	2535	java/lang/Exception
    //   33	39	2548	finally
    //   2602	2611	2614	java/lang/Throwable
    //   889	898	2618	finally
    //   2387	2392	2623	java/io/IOException
    //   2396	2400	2628	java/io/IOException
    //   792	796	2632	java/io/IOException
    //   801	806	2636	java/io/IOException
    //   811	816	2640	java/lang/Exception
    //   1208	1213	2644	java/io/IOException
    //   1218	1223	2649	java/io/IOException
    //   1228	1233	2654	java/lang/Exception
    //   2567	2572	2659	java/io/IOException
    //   2577	2582	2664	java/io/IOException
    //   2587	2592	2669	java/lang/Exception
    //   2596	2600	2674	java/lang/Exception
    //   840	869	2678	java/lang/Throwable
    //   1525	1531	2682	finally
    //   1564	1570	2682	finally
    //   1590	1596	2682	finally
    //   1616	1623	2682	finally
    //   1663	1689	2682	finally
    //   1709	1716	2682	finally
    //   1739	1744	2682	finally
    //   1756	1762	2682	finally
    //   1774	1819	2682	finally
    //   1857	1859	2682	finally
    //   1885	1895	2682	finally
    //   1912	1917	2682	finally
    //   1929	1935	2682	finally
    //   1972	1983	2682	finally
    //   2003	2010	2682	finally
    //   2030	2036	2682	finally
    //   2070	2077	2682	finally
    //   2097	2109	2682	finally
    //   2129	2141	2682	finally
    //   2161	2168	2682	finally
    //   2201	2208	2682	finally
    //   2231	2241	2682	finally
    //   2261	2268	2682	finally
    //   2284	2293	2682	finally
    //   2473	2510	2682	finally
    //   1623	1640	2701	finally
    //   64	75	2716	finally
    //   91	96	2716	finally
    //   117	132	2716	finally
    //   153	161	2716	finally
    //   177	182	2716	finally
    //   198	203	2716	finally
    //   219	252	2716	finally
    //   268	275	2716	finally
    //   307	323	2716	finally
    //   339	355	2716	finally
    //   371	387	2716	finally
    //   403	410	2716	finally
    //   426	433	2716	finally
    //   459	478	2716	finally
    //   494	504	2716	finally
    //   520	546	2716	finally
    //   562	570	2716	finally
    //   586	594	2716	finally
    //   610	619	2716	finally
    //   635	644	2716	finally
    //   660	670	2716	finally
    //   686	698	2716	finally
    //   714	733	2716	finally
    //   915	951	2716	finally
    //   967	1009	2716	finally
    //   1025	1049	2716	finally
    //   1065	1082	2716	finally
    //   1098	1108	2716	finally
    //   1124	1135	2716	finally
    //   1170	1203	2716	finally
    //   1285	1302	2716	finally
    //   1318	1333	2716	finally
    //   1349	1371	2716	finally
    //   1390	1400	2716	finally
    //   1419	1429	2716	finally
    //   1445	1451	2716	finally
    //   1470	1480	2716	finally
    //   1496	1502	2716	finally
    //   2293	2300	2735	finally
    //   2306	2320	2735	finally
    //   2320	2331	2735	finally
    //   2331	2348	2735	finally
    //   2351	2363	2735	finally
    //   755	788	2746	finally
    //   33	39	2768	java/lang/Throwable
    //   1623	1640	2786	java/lang/Throwable
    //   33	39	2806	java/lang/Exception
    //   1623	1640	2822	java/lang/Exception
    //   2284	2293	2844	java/lang/Exception
    //   1912	1917	2867	java/lang/Throwable
    //   1929	1935	2867	java/lang/Throwable
    //   1525	1531	2896	java/lang/Exception
    //   1564	1570	2896	java/lang/Exception
    //   1590	1596	2896	java/lang/Exception
    //   1616	1623	2896	java/lang/Exception
    //   1663	1689	2896	java/lang/Exception
    //   1709	1716	2896	java/lang/Exception
    //   1739	1744	2896	java/lang/Exception
    //   1756	1762	2896	java/lang/Exception
    //   1774	1819	2896	java/lang/Exception
    //   1857	1859	2896	java/lang/Exception
    //   1885	1895	2896	java/lang/Exception
    //   1912	1917	2896	java/lang/Exception
    //   1929	1935	2896	java/lang/Exception
    //   1972	1983	2896	java/lang/Exception
    //   2003	2010	2896	java/lang/Exception
    //   2030	2036	2896	java/lang/Exception
    //   2070	2077	2896	java/lang/Exception
    //   2097	2109	2896	java/lang/Exception
    //   2129	2141	2896	java/lang/Exception
    //   2161	2168	2896	java/lang/Exception
    //   2201	2208	2896	java/lang/Exception
    //   2231	2241	2896	java/lang/Exception
    //   2261	2268	2896	java/lang/Exception
    //   2473	2510	2896	java/lang/Exception
    //   1525	1531	2933	java/lang/Throwable
    //   1564	1570	2933	java/lang/Throwable
    //   1590	1596	2933	java/lang/Throwable
    //   1616	1623	2933	java/lang/Throwable
    //   1663	1689	2933	java/lang/Throwable
    //   1709	1716	2933	java/lang/Throwable
    //   1857	1859	2933	java/lang/Throwable
    //   1885	1895	2933	java/lang/Throwable
    //   1972	1983	2933	java/lang/Throwable
    //   2003	2010	2933	java/lang/Throwable
    //   2030	2036	2933	java/lang/Throwable
    //   2070	2077	2933	java/lang/Throwable
    //   2097	2109	2933	java/lang/Throwable
    //   2129	2141	2933	java/lang/Throwable
    //   2161	2168	2933	java/lang/Throwable
    //   2201	2208	2933	java/lang/Throwable
    //   2231	2241	2933	java/lang/Throwable
    //   2261	2268	2933	java/lang/Throwable
    //   2284	2293	2933	java/lang/Throwable
    //   2473	2510	2933	java/lang/Throwable
    //   2293	2300	2982	java/lang/Exception
    //   2306	2320	2982	java/lang/Exception
    //   2320	2331	2982	java/lang/Exception
    //   2331	2348	2982	java/lang/Exception
    //   2351	2363	2982	java/lang/Exception
    //   2293	2300	3006	java/lang/Throwable
    //   2306	2320	3006	java/lang/Throwable
    //   2320	2331	3006	java/lang/Throwable
    //   2331	2348	3006	java/lang/Throwable
    //   2351	2363	3006	java/lang/Throwable
  }
  
  public final int a(gt paramgt)
  {
    synchronized (this.i)
    {
      if ((!this.g) && (this.b.size() < this.e))
      {
        int m = this.a + 1;
        this.a = m;
        paramgt.a(m);
        this.b.addElement(paramgt);
        this.i.notifyAll();
        m = this.a;
        return m;
      }
      return -1;
    }
  }
  
  public final void a()
  {
    if ((this.g) || (this.f)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    this.f = true;
    int m = 0;
    while (m < this.d)
    {
      this.c[m].start();
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gr
 * JD-Core Version:    0.7.0.1
 */