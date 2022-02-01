public class aulk
{
  /* Error */
  public static final java.lang.String a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +11 -> 15
    //   7: aload 5
    //   9: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: ldc 18
    //   17: iconst_1
    //   18: ldc 20
    //   20: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: sipush 142
    //   29: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   32: checkcast 34	aukr
    //   35: astore 14
    //   37: new 36	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   44: astore_0
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: new 50	anzp
    //   61: dup
    //   62: invokespecial 51	anzp:<init>	()V
    //   65: astore 13
    //   67: ldc 53
    //   69: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   72: astore 15
    //   74: aload 15
    //   76: aconst_null
    //   77: iconst_1
    //   78: anewarray 61	javax/net/ssl/TrustManager
    //   81: dup
    //   82: iconst_0
    //   83: aload 13
    //   85: aastore
    //   86: aconst_null
    //   87: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   90: new 67	anzr
    //   93: dup
    //   94: aload 15
    //   96: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   99: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   102: astore 15
    //   104: aload 15
    //   106: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   109: new 81	java/net/URL
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   120: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   123: astore 13
    //   125: aload 13
    //   127: aload 15
    //   129: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   132: aload 13
    //   134: sipush 5000
    //   137: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   140: aload 13
    //   142: sipush 30000
    //   145: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   148: aload 13
    //   150: iconst_1
    //   151: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   154: aload 13
    //   156: iconst_1
    //   157: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   160: aload 13
    //   162: iconst_0
    //   163: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   166: aload 13
    //   168: ldc 110
    //   170: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload 13
    //   175: ldc 115
    //   177: ldc 117
    //   179: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 13
    //   184: ldc 123
    //   186: new 36	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 125
    //   192: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: ldc 128
    //   197: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   203: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   214: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 128
    //   219: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   225: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 128
    //   230: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 144
    //   235: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 128
    //   240: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 146
    //   245: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 148
    //   250: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 13
    //   261: ldc 150
    //   263: ldc 152
    //   265: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 13
    //   270: ldc 154
    //   272: new 36	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   279: ldc 156
    //   281: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 158
    //   286: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: new 160	java/util/HashMap
    //   298: dup
    //   299: invokespecial 161	java/util/HashMap:<init>	()V
    //   302: astore 15
    //   304: aload 15
    //   306: ldc 115
    //   308: ldc 163
    //   310: invokeinterface 169 3 0
    //   315: pop
    //   316: aload 15
    //   318: ldc 171
    //   320: aload_3
    //   321: invokeinterface 169 3 0
    //   326: pop
    //   327: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   330: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   333: iconst_2
    //   334: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   337: checkcast 189	mqq/manager/TicketManager
    //   340: astore_0
    //   341: aload_0
    //   342: aload 5
    //   344: invokeinterface 193 2 0
    //   349: pop
    //   350: aload_1
    //   351: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +669 -> 1023
    //   357: aload_0
    //   358: aload 5
    //   360: ldc 195
    //   362: invokeinterface 199 3 0
    //   367: astore_0
    //   368: aload_0
    //   369: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +154 -> 526
    //   375: ldc 18
    //   377: iconst_1
    //   378: ldc 201
    //   380: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +18 -> 406
    //   391: aload 15
    //   393: ldc 208
    //   395: aload_0
    //   396: aload_1
    //   397: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokeinterface 169 3 0
    //   405: pop
    //   406: aload 15
    //   408: invokeinterface 215 1 0
    //   413: invokeinterface 221 1 0
    //   418: astore_0
    //   419: aload_0
    //   420: invokeinterface 227 1 0
    //   425: ifeq +141 -> 566
    //   428: aload_0
    //   429: invokeinterface 231 1 0
    //   434: checkcast 233	java/util/Map$Entry
    //   437: astore_1
    //   438: aload 13
    //   440: aload_1
    //   441: invokeinterface 236 1 0
    //   446: checkcast 238	java/lang/String
    //   449: aload_1
    //   450: invokeinterface 241 1 0
    //   455: checkcast 238	java/lang/String
    //   458: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -42 -> 419
    //   464: astore_1
    //   465: aload 13
    //   467: astore_0
    //   468: ldc 243
    //   470: iconst_1
    //   471: new 36	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   478: ldc 245
    //   480: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   487: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 14
    //   498: iconst_1
    //   499: iconst_1
    //   500: iconst_2
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: ldc 251
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: aload_3
    //   512: aastore
    //   513: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   516: aload_0
    //   517: ifnull +7 -> 524
    //   520: aload_0
    //   521: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   524: aconst_null
    //   525: areturn
    //   526: aload 15
    //   528: ldc_w 260
    //   531: new 36	java/lang/StringBuilder
    //   534: dup
    //   535: aload 4
    //   537: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokeinterface 169 3 0
    //   548: pop
    //   549: goto -143 -> 406
    //   552: astore_0
    //   553: aload 13
    //   555: astore_1
    //   556: aload_1
    //   557: ifnull +7 -> 564
    //   560: aload_1
    //   561: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   564: aload_0
    //   565: athrow
    //   566: aload 13
    //   568: invokevirtual 263	javax/net/ssl/HttpsURLConnection:connect	()V
    //   571: aload 13
    //   573: invokevirtual 267	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   576: istore 7
    //   578: invokestatic 271	aulk:hg	()J
    //   581: lstore 9
    //   583: iload 7
    //   585: i2l
    //   586: lload 9
    //   588: lcmp
    //   589: ifle +37 -> 626
    //   592: aload 14
    //   594: iconst_1
    //   595: iconst_1
    //   596: iconst_2
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: ldc_w 273
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: aload_3
    //   609: aastore
    //   610: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   613: aload 13
    //   615: ifnull -91 -> 524
    //   618: aload 13
    //   620: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   623: goto -99 -> 524
    //   626: aload 13
    //   628: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   631: astore 4
    //   633: new 279	java/io/ByteArrayOutputStream
    //   636: dup
    //   637: invokespecial 280	java/io/ByteArrayOutputStream:<init>	()V
    //   640: astore 5
    //   642: iconst_0
    //   643: istore 6
    //   645: sipush 10240
    //   648: newarray byte
    //   650: astore_0
    //   651: lconst_0
    //   652: lstore 9
    //   654: aload 4
    //   656: aload_0
    //   657: invokevirtual 286	java/io/InputStream:read	([B)I
    //   660: istore 8
    //   662: iload 8
    //   664: iconst_m1
    //   665: if_icmpeq +68 -> 733
    //   668: iload 6
    //   670: iload 8
    //   672: iadd
    //   673: istore 6
    //   675: aload 5
    //   677: aload_0
    //   678: iconst_0
    //   679: iload 8
    //   681: invokevirtual 290	java/io/ByteArrayOutputStream:write	([BII)V
    //   684: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   687: lstore 11
    //   689: lload 11
    //   691: lload 9
    //   693: lsub
    //   694: ldc2_w 296
    //   697: lcmp
    //   698: iflt +322 -> 1020
    //   701: aload 14
    //   703: iconst_4
    //   704: iconst_1
    //   705: iconst_1
    //   706: anewarray 4	java/lang/Object
    //   709: dup
    //   710: iconst_0
    //   711: iload 6
    //   713: bipush 100
    //   715: imul
    //   716: iload 7
    //   718: idiv
    //   719: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   722: aastore
    //   723: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   726: lload 11
    //   728: lstore 9
    //   730: goto +298 -> 1028
    //   733: aload 5
    //   735: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   738: aload 5
    //   740: invokevirtual 310	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   743: astore 15
    //   745: new 36	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   752: getstatic 315	acbn:bmg	Ljava/lang/String;
    //   755: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_2
    //   759: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 320	audx:kW	(Ljava/lang/String;)Ljava/lang/String;
    //   768: astore_2
    //   769: new 322	java/io/FileOutputStream
    //   772: dup
    //   773: new 324	java/io/File
    //   776: dup
    //   777: aload_2
    //   778: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   781: invokespecial 328	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   784: astore_1
    //   785: aload_1
    //   786: astore_0
    //   787: aload_1
    //   788: aload 15
    //   790: invokevirtual 331	java/io/FileOutputStream:write	([B)V
    //   793: iload 6
    //   795: iload 7
    //   797: if_icmplt +55 -> 852
    //   800: aload_1
    //   801: astore_0
    //   802: aload 14
    //   804: iconst_3
    //   805: iconst_1
    //   806: iconst_2
    //   807: anewarray 4	java/lang/Object
    //   810: dup
    //   811: iconst_0
    //   812: aload_2
    //   813: aastore
    //   814: dup
    //   815: iconst_1
    //   816: aload_3
    //   817: aastore
    //   818: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   821: aload 5
    //   823: ifnull +8 -> 831
    //   826: aload 5
    //   828: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   831: aload_1
    //   832: ifnull +7 -> 839
    //   835: aload_1
    //   836: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   839: aload 4
    //   841: ifnull -228 -> 613
    //   844: aload 4
    //   846: invokevirtual 333	java/io/InputStream:close	()V
    //   849: goto -236 -> 613
    //   852: aload_1
    //   853: astore_0
    //   854: aload 14
    //   856: iconst_1
    //   857: iconst_1
    //   858: iconst_2
    //   859: anewarray 4	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: ldc 251
    //   866: aastore
    //   867: dup
    //   868: iconst_1
    //   869: aload_3
    //   870: aastore
    //   871: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   874: goto -53 -> 821
    //   877: astore_2
    //   878: aload_1
    //   879: astore_0
    //   880: ldc 243
    //   882: iconst_1
    //   883: new 36	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   890: ldc_w 335
    //   893: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload_2
    //   897: invokevirtual 336	java/io/IOException:toString	()Ljava/lang/String;
    //   900: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   906: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   909: aload_1
    //   910: astore_0
    //   911: aload 14
    //   913: iconst_1
    //   914: iconst_1
    //   915: iconst_2
    //   916: anewarray 4	java/lang/Object
    //   919: dup
    //   920: iconst_0
    //   921: ldc 251
    //   923: aastore
    //   924: dup
    //   925: iconst_1
    //   926: aload_3
    //   927: aastore
    //   928: invokevirtual 255	aukr:notifyUI	(IZLjava/lang/Object;)V
    //   931: aload 5
    //   933: ifnull +8 -> 941
    //   936: aload 5
    //   938: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   941: aload_1
    //   942: ifnull +7 -> 949
    //   945: aload_1
    //   946: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   949: aload 4
    //   951: ifnull -338 -> 613
    //   954: aload 4
    //   956: invokevirtual 333	java/io/InputStream:close	()V
    //   959: goto -346 -> 613
    //   962: aload 5
    //   964: ifnull +8 -> 972
    //   967: aload 5
    //   969: invokevirtual 306	java/io/ByteArrayOutputStream:close	()V
    //   972: aload_0
    //   973: ifnull +7 -> 980
    //   976: aload_0
    //   977: invokevirtual 332	java/io/FileOutputStream:close	()V
    //   980: aload 4
    //   982: ifnull +8 -> 990
    //   985: aload 4
    //   987: invokevirtual 333	java/io/InputStream:close	()V
    //   990: aload_1
    //   991: athrow
    //   992: astore_0
    //   993: aconst_null
    //   994: astore_1
    //   995: goto -439 -> 556
    //   998: astore_2
    //   999: aload_0
    //   1000: astore_1
    //   1001: aload_2
    //   1002: astore_0
    //   1003: goto -447 -> 556
    //   1006: astore_1
    //   1007: goto -539 -> 468
    //   1010: astore_1
    //   1011: goto -49 -> 962
    //   1014: astore_2
    //   1015: aconst_null
    //   1016: astore_1
    //   1017: goto -139 -> 878
    //   1020: goto +8 -> 1028
    //   1023: aconst_null
    //   1024: astore_0
    //   1025: goto -657 -> 368
    //   1028: goto -374 -> 654
    //   1031: astore_1
    //   1032: aconst_null
    //   1033: astore_0
    //   1034: goto -72 -> 962
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1037	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1037	1	paramString1	java.lang.String
    //   0	1037	2	paramString2	java.lang.String
    //   0	1037	3	paramString3	java.lang.String
    //   0	1037	4	paramString4	java.lang.String
    //   0	1037	5	paramString5	java.lang.String
    //   643	155	6	i	int
    //   576	222	7	j	int
    //   660	20	8	k	int
    //   581	148	9	l1	long
    //   687	40	11	l2	long
    //   65	562	13	localObject1	Object
    //   35	877	14	localaukr	aukr
    //   72	717	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   125	368	464	java/lang/Exception
    //   368	387	464	java/lang/Exception
    //   391	406	464	java/lang/Exception
    //   406	419	464	java/lang/Exception
    //   419	461	464	java/lang/Exception
    //   526	549	464	java/lang/Exception
    //   566	583	464	java/lang/Exception
    //   592	613	464	java/lang/Exception
    //   626	642	464	java/lang/Exception
    //   826	831	464	java/lang/Exception
    //   835	839	464	java/lang/Exception
    //   844	849	464	java/lang/Exception
    //   936	941	464	java/lang/Exception
    //   945	949	464	java/lang/Exception
    //   954	959	464	java/lang/Exception
    //   967	972	464	java/lang/Exception
    //   976	980	464	java/lang/Exception
    //   985	990	464	java/lang/Exception
    //   990	992	464	java/lang/Exception
    //   125	368	552	finally
    //   368	387	552	finally
    //   391	406	552	finally
    //   406	419	552	finally
    //   419	461	552	finally
    //   526	549	552	finally
    //   566	583	552	finally
    //   592	613	552	finally
    //   626	642	552	finally
    //   826	831	552	finally
    //   835	839	552	finally
    //   844	849	552	finally
    //   936	941	552	finally
    //   945	949	552	finally
    //   954	959	552	finally
    //   967	972	552	finally
    //   976	980	552	finally
    //   985	990	552	finally
    //   990	992	552	finally
    //   787	793	877	java/io/IOException
    //   802	821	877	java/io/IOException
    //   854	874	877	java/io/IOException
    //   58	125	992	finally
    //   468	516	998	finally
    //   58	125	1006	java/lang/Exception
    //   787	793	1010	finally
    //   802	821	1010	finally
    //   854	874	1010	finally
    //   880	909	1010	finally
    //   911	931	1010	finally
    //   645	651	1014	java/io/IOException
    //   654	662	1014	java/io/IOException
    //   675	689	1014	java/io/IOException
    //   701	726	1014	java/io/IOException
    //   733	785	1014	java/io/IOException
    //   645	651	1031	finally
    //   654	662	1031	finally
    //   675	689	1031	finally
    //   701	726	1031	finally
    //   733	785	1031	finally
  }
  
  /* Error */
  public static final java.lang.String a(com.tencent.tim.teamwork.TeamWorkFileImportInfo paramTeamWorkFileImportInfo, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 345	com/tencent/tim/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   10: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +16 -> 36
    //   23: ldc 18
    //   25: iconst_1
    //   26: ldc_w 347
    //   29: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_3
    //   35: areturn
    //   36: new 36	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   43: astore_3
    //   44: new 324	java/io/File
    //   47: dup
    //   48: aload_0
    //   49: getfield 345	com/tencent/tim/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   52: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 350	com/tencent/tim/teamwork/TeamWorkFileImportInfo:folderId	Ljava/lang/String;
    //   61: astore 4
    //   63: aload 7
    //   65: ifnull +587 -> 652
    //   68: aload 7
    //   70: invokevirtual 353	java/io/File:exists	()Z
    //   73: ifeq +579 -> 652
    //   76: aload_3
    //   77: ldc_w 355
    //   80: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: getstatic 360	auko:cjA	Ljava/lang/String;
    //   90: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +16 -> 115
    //   102: aload_3
    //   103: ldc_w 362
    //   106: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_3
    //   116: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 8
    //   121: aload 6
    //   123: astore 4
    //   125: new 50	anzp
    //   128: dup
    //   129: invokespecial 51	anzp:<init>	()V
    //   132: astore 9
    //   134: aload 6
    //   136: astore 4
    //   138: ldc 53
    //   140: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   143: astore_3
    //   144: aload 6
    //   146: astore 4
    //   148: aload_3
    //   149: aconst_null
    //   150: iconst_1
    //   151: anewarray 61	javax/net/ssl/TrustManager
    //   154: dup
    //   155: iconst_0
    //   156: aload 9
    //   158: aastore
    //   159: aconst_null
    //   160: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   163: aload 6
    //   165: astore 4
    //   167: new 67	anzr
    //   170: dup
    //   171: aload_3
    //   172: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   175: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   178: astore 9
    //   180: aload 6
    //   182: astore 4
    //   184: aload 9
    //   186: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   189: aload 6
    //   191: astore 4
    //   193: new 81	java/net/URL
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   202: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   205: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   208: astore_3
    //   209: aload_3
    //   210: aload 9
    //   212: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   215: aload_3
    //   216: sipush 5000
    //   219: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   222: aload_3
    //   223: sipush 30000
    //   226: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   229: aload_3
    //   230: iconst_1
    //   231: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   234: aload_3
    //   235: iconst_1
    //   236: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   239: aload_3
    //   240: iconst_0
    //   241: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   244: aload_3
    //   245: ldc_w 364
    //   248: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   251: aload_3
    //   252: ldc 115
    //   254: ldc 117
    //   256: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_3
    //   260: ldc 123
    //   262: new 36	java/lang/StringBuilder
    //   265: dup
    //   266: ldc 125
    //   268: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: ldc 128
    //   273: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   279: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc 128
    //   284: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   290: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 128
    //   295: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   301: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 128
    //   306: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 144
    //   311: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc 128
    //   316: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc 146
    //   321: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 148
    //   326: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload_3
    //   336: ldc 150
    //   338: ldc 152
    //   340: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload_3
    //   344: ldc 154
    //   346: new 36	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   353: ldc 156
    //   355: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc 158
    //   360: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: new 160	java/util/HashMap
    //   372: dup
    //   373: invokespecial 161	java/util/HashMap:<init>	()V
    //   376: astore 9
    //   378: aload 9
    //   380: ldc 115
    //   382: ldc 163
    //   384: invokeinterface 169 3 0
    //   389: pop
    //   390: aload 9
    //   392: ldc 171
    //   394: aload 8
    //   396: invokeinterface 169 3 0
    //   401: pop
    //   402: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   405: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   408: iconst_2
    //   409: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   412: checkcast 189	mqq/manager/TicketManager
    //   415: astore 4
    //   417: aload 4
    //   419: aload_1
    //   420: invokeinterface 193 2 0
    //   425: astore 10
    //   427: aload 8
    //   429: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +799 -> 1231
    //   435: aload 4
    //   437: aload_1
    //   438: ldc 195
    //   440: invokeinterface 199 3 0
    //   445: astore 4
    //   447: aload 7
    //   449: ifnull +777 -> 1226
    //   452: aload 7
    //   454: invokevirtual 353	java/io/File:exists	()Z
    //   457: ifeq +769 -> 1226
    //   460: aload_0
    //   461: getfield 345	com/tencent/tim/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   464: invokestatic 367	aulk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_0
    //   468: aload 4
    //   470: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   473: ifeq +190 -> 663
    //   476: ldc 18
    //   478: iconst_1
    //   479: ldc_w 369
    //   482: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   488: astore_0
    //   489: aload_0
    //   490: ifnull +20 -> 510
    //   493: aload 9
    //   495: ldc_w 260
    //   498: aload_0
    //   499: aload 8
    //   501: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   504: invokeinterface 169 3 0
    //   509: pop
    //   510: aload 9
    //   512: invokeinterface 215 1 0
    //   517: invokeinterface 221 1 0
    //   522: astore_1
    //   523: aload_1
    //   524: invokeinterface 227 1 0
    //   529: ifeq +242 -> 771
    //   532: aload_1
    //   533: invokeinterface 231 1 0
    //   538: checkcast 233	java/util/Map$Entry
    //   541: astore_0
    //   542: aload_3
    //   543: aload_0
    //   544: invokeinterface 236 1 0
    //   549: checkcast 238	java/lang/String
    //   552: aload_0
    //   553: invokeinterface 241 1 0
    //   558: checkcast 238	java/lang/String
    //   561: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: goto -41 -> 523
    //   567: astore 4
    //   569: aconst_null
    //   570: astore_0
    //   571: aload_3
    //   572: astore_1
    //   573: aload 4
    //   575: astore_3
    //   576: aload_1
    //   577: astore 4
    //   579: ldc 243
    //   581: iconst_1
    //   582: new 36	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 371
    //   592: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_3
    //   596: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   599: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: astore_3
    //   610: aload_1
    //   611: ifnull -577 -> 34
    //   614: aload_1
    //   615: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   618: aload_0
    //   619: areturn
    //   620: astore_0
    //   621: ldc 18
    //   623: iconst_1
    //   624: new 36	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 373
    //   634: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_0
    //   638: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   641: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: aconst_null
    //   651: areturn
    //   652: ldc 18
    //   654: iconst_1
    //   655: ldc_w 375
    //   658: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: aconst_null
    //   662: areturn
    //   663: new 36	java/lang/StringBuilder
    //   666: dup
    //   667: new 36	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 377
    //   677: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 4
    //   682: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 379
    //   688: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload_1
    //   692: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 381
    //   698: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 10
    //   703: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   712: astore_1
    //   713: aload_0
    //   714: ifnull +28 -> 742
    //   717: aload_1
    //   718: new 36	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 383
    //   728: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_0
    //   732: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload 9
    //   744: ldc_w 260
    //   747: aload_1
    //   748: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokeinterface 169 3 0
    //   756: pop
    //   757: goto -247 -> 510
    //   760: astore_0
    //   761: aload_3
    //   762: ifnull +7 -> 769
    //   765: aload_3
    //   766: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   769: aload_0
    //   770: athrow
    //   771: new 385	java/io/DataOutputStream
    //   774: dup
    //   775: aload_3
    //   776: invokevirtual 389	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   779: invokespecial 392	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   782: astore_1
    //   783: new 394	java/lang/StringBuffer
    //   786: dup
    //   787: invokespecial 395	java/lang/StringBuffer:<init>	()V
    //   790: astore_0
    //   791: aload_0
    //   792: ldc_w 397
    //   795: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   798: ldc_w 402
    //   801: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   804: ldc 158
    //   806: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   809: ldc_w 397
    //   812: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   815: pop
    //   816: aload_0
    //   817: ldc_w 404
    //   820: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   823: ldc_w 406
    //   826: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   829: ldc_w 408
    //   832: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   835: aload 7
    //   837: invokevirtual 411	java/io/File:getName	()Ljava/lang/String;
    //   840: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   843: ldc_w 413
    //   846: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   849: pop
    //   850: aload_0
    //   851: new 36	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   858: ldc_w 415
    //   861: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: ldc_w 417
    //   867: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc_w 419
    //   873: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   879: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   882: pop
    //   883: aload_1
    //   884: aload_0
    //   885: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   888: invokevirtual 423	java/lang/String:getBytes	()[B
    //   891: invokevirtual 426	java/io/OutputStream:write	([B)V
    //   894: new 428	java/io/BufferedInputStream
    //   897: dup
    //   898: new 428	java/io/BufferedInputStream
    //   901: dup
    //   902: new 430	java/io/FileInputStream
    //   905: dup
    //   906: aload 7
    //   908: invokespecial 431	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   911: invokespecial 434	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   914: invokespecial 434	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   917: astore_0
    //   918: sipush 3072
    //   921: newarray byte
    //   923: astore 4
    //   925: aload_0
    //   926: aload 4
    //   928: invokevirtual 435	java/io/BufferedInputStream:read	([B)I
    //   931: istore_2
    //   932: iload_2
    //   933: iconst_m1
    //   934: if_icmpeq +94 -> 1028
    //   937: aload_1
    //   938: aload 4
    //   940: iconst_0
    //   941: iload_2
    //   942: invokevirtual 436	java/io/OutputStream:write	([BII)V
    //   945: goto -20 -> 925
    //   948: astore 4
    //   950: ldc 18
    //   952: iconst_1
    //   953: new 36	java/lang/StringBuilder
    //   956: dup
    //   957: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   960: ldc_w 438
    //   963: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload 7
    //   968: invokevirtual 441	java/io/File:length	()J
    //   971: invokevirtual 444	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   974: ldc_w 446
    //   977: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload 7
    //   982: invokevirtual 449	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   985: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: aload_1
    //   995: invokevirtual 452	java/io/OutputStream:flush	()V
    //   998: aload_1
    //   999: invokevirtual 453	java/io/OutputStream:close	()V
    //   1002: aload_3
    //   1003: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1006: aload 6
    //   1008: astore 4
    //   1010: aload_0
    //   1011: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   1014: iconst_0
    //   1015: ifeq +11 -> 1026
    //   1018: new 456	java/lang/NullPointerException
    //   1021: dup
    //   1022: invokespecial 457	java/lang/NullPointerException:<init>	()V
    //   1025: athrow
    //   1026: aconst_null
    //   1027: areturn
    //   1028: aload_0
    //   1029: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   1032: aload_1
    //   1033: new 36	java/lang/StringBuilder
    //   1036: dup
    //   1037: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1040: ldc_w 459
    //   1043: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: ldc 158
    //   1048: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: ldc_w 461
    //   1054: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokevirtual 423	java/lang/String:getBytes	()[B
    //   1063: invokevirtual 426	java/io/OutputStream:write	([B)V
    //   1066: aload_1
    //   1067: invokevirtual 452	java/io/OutputStream:flush	()V
    //   1070: aload_1
    //   1071: invokevirtual 453	java/io/OutputStream:close	()V
    //   1074: new 394	java/lang/StringBuffer
    //   1077: dup
    //   1078: invokespecial 395	java/lang/StringBuffer:<init>	()V
    //   1081: astore 4
    //   1083: aload_3
    //   1084: invokevirtual 464	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1087: istore_2
    //   1088: iload_2
    //   1089: sipush 200
    //   1092: if_icmpeq +35 -> 1127
    //   1095: ldc 18
    //   1097: iconst_1
    //   1098: new 36	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1105: ldc_w 466
    //   1108: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: iload_2
    //   1112: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1115: ldc_w 471
    //   1118: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 474	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1127: new 476	java/io/BufferedReader
    //   1130: dup
    //   1131: new 478	java/io/InputStreamReader
    //   1134: dup
    //   1135: aload_3
    //   1136: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1139: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1142: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1145: astore_1
    //   1146: aload_1
    //   1147: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1150: astore_0
    //   1151: aload_0
    //   1152: ifnull +26 -> 1178
    //   1155: aload 4
    //   1157: aload_0
    //   1158: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1161: ldc_w 487
    //   1164: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1167: pop
    //   1168: goto -22 -> 1146
    //   1171: astore_1
    //   1172: aload_0
    //   1173: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   1176: aload_1
    //   1177: athrow
    //   1178: aload 4
    //   1180: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1183: astore_0
    //   1184: aload_1
    //   1185: invokevirtual 488	java/io/BufferedReader:close	()V
    //   1188: aload_3
    //   1189: ifnull +35 -> 1224
    //   1192: aload_3
    //   1193: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1196: aload_0
    //   1197: areturn
    //   1198: astore_0
    //   1199: aload 4
    //   1201: astore_3
    //   1202: goto -441 -> 761
    //   1205: astore_3
    //   1206: aconst_null
    //   1207: astore_0
    //   1208: aload 5
    //   1210: astore_1
    //   1211: goto -635 -> 576
    //   1214: astore 4
    //   1216: aload_3
    //   1217: astore_1
    //   1218: aload 4
    //   1220: astore_3
    //   1221: goto -645 -> 576
    //   1224: aload_0
    //   1225: areturn
    //   1226: aconst_null
    //   1227: astore_0
    //   1228: goto -760 -> 468
    //   1231: aconst_null
    //   1232: astore 4
    //   1234: goto -787 -> 447
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1237	0	paramTeamWorkFileImportInfo	com.tencent.tim.teamwork.TeamWorkFileImportInfo
    //   0	1237	1	paramString	java.lang.String
    //   931	181	2	i	int
    //   33	1169	3	localObject1	Object
    //   1205	12	3	localException1	java.lang.Exception
    //   1220	1	3	localObject2	Object
    //   61	408	4	localObject3	Object
    //   567	7	4	localException2	java.lang.Exception
    //   577	362	4	localObject4	Object
    //   948	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1008	192	4	localObject5	Object
    //   1214	5	4	localException3	java.lang.Exception
    //   1232	1	4	localObject6	Object
    //   4	1205	5	localObject7	Object
    //   1	1006	6	localObject8	Object
    //   55	926	7	localFile	java.io.File
    //   119	381	8	str1	java.lang.String
    //   132	611	9	localObject9	Object
    //   425	277	10	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   209	447	567	java/lang/Exception
    //   452	468	567	java/lang/Exception
    //   468	489	567	java/lang/Exception
    //   493	510	567	java/lang/Exception
    //   510	523	567	java/lang/Exception
    //   523	564	567	java/lang/Exception
    //   663	713	567	java/lang/Exception
    //   717	742	567	java/lang/Exception
    //   742	757	567	java/lang/Exception
    //   771	925	567	java/lang/Exception
    //   1028	1088	567	java/lang/Exception
    //   1095	1127	567	java/lang/Exception
    //   1127	1146	567	java/lang/Exception
    //   1146	1151	567	java/lang/Exception
    //   1155	1168	567	java/lang/Exception
    //   1172	1178	567	java/lang/Exception
    //   1178	1184	567	java/lang/Exception
    //   76	115	620	java/lang/Exception
    //   209	447	760	finally
    //   452	468	760	finally
    //   468	489	760	finally
    //   493	510	760	finally
    //   510	523	760	finally
    //   523	564	760	finally
    //   663	713	760	finally
    //   717	742	760	finally
    //   742	757	760	finally
    //   771	925	760	finally
    //   1028	1088	760	finally
    //   1095	1127	760	finally
    //   1127	1146	760	finally
    //   1146	1151	760	finally
    //   1155	1168	760	finally
    //   1172	1178	760	finally
    //   1178	1184	760	finally
    //   1184	1188	760	finally
    //   925	932	948	java/lang/OutOfMemoryError
    //   937	945	948	java/lang/OutOfMemoryError
    //   925	932	1171	finally
    //   937	945	1171	finally
    //   950	1006	1171	finally
    //   125	134	1198	finally
    //   138	144	1198	finally
    //   148	163	1198	finally
    //   167	180	1198	finally
    //   184	189	1198	finally
    //   193	209	1198	finally
    //   579	608	1198	finally
    //   1010	1014	1198	finally
    //   125	134	1205	java/lang/Exception
    //   138	144	1205	java/lang/Exception
    //   148	163	1205	java/lang/Exception
    //   167	180	1205	java/lang/Exception
    //   184	189	1205	java/lang/Exception
    //   193	209	1205	java/lang/Exception
    //   1010	1014	1205	java/lang/Exception
    //   1184	1188	1214	java/lang/Exception
  }
  
  /* Error */
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3, java.lang.String paramString4, java.lang.String paramString5, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_2
    //   7: invokevirtual 490	java/lang/String:toString	()Ljava/lang/String;
    //   10: astore 10
    //   12: aload 9
    //   14: astore 7
    //   16: new 50	anzp
    //   19: dup
    //   20: invokespecial 51	anzp:<init>	()V
    //   23: astore_2
    //   24: aload 9
    //   26: astore 7
    //   28: ldc 53
    //   30: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   33: astore 11
    //   35: aload 9
    //   37: astore 7
    //   39: aload 11
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 61	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: aload 9
    //   56: astore 7
    //   58: new 67	anzr
    //   61: dup
    //   62: aload 11
    //   64: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: astore 11
    //   72: aload 9
    //   74: astore 7
    //   76: aload 11
    //   78: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 9
    //   83: astore 7
    //   85: new 81	java/net/URL
    //   88: dup
    //   89: aload 10
    //   91: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   100: astore_2
    //   101: aload_2
    //   102: aload 11
    //   104: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload_2
    //   108: sipush 5000
    //   111: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   114: aload_2
    //   115: sipush 30000
    //   118: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   126: aload_2
    //   127: iconst_1
    //   128: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   131: aload_2
    //   132: iconst_0
    //   133: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   136: aload_2
    //   137: ldc_w 364
    //   140: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: ldc 115
    //   146: ldc 117
    //   148: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ldc 123
    //   154: new 36	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 125
    //   160: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: ldc 128
    //   165: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   171: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 128
    //   176: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   182: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 128
    //   187: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   193: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 128
    //   198: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 144
    //   203: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 146
    //   213: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 148
    //   218: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: iload 5
    //   229: ifeq +253 -> 482
    //   232: aload_2
    //   233: ldc 154
    //   235: ldc_w 492
    //   238: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: ldc 150
    //   244: ldc 152
    //   246: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w 494
    //   253: ldc_w 496
    //   256: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: new 160	java/util/HashMap
    //   262: dup
    //   263: invokespecial 161	java/util/HashMap:<init>	()V
    //   266: astore 7
    //   268: aload 7
    //   270: ldc 115
    //   272: ldc 163
    //   274: invokeinterface 169 3 0
    //   279: pop
    //   280: aload 7
    //   282: ldc 171
    //   284: aload 10
    //   286: invokeinterface 169 3 0
    //   291: pop
    //   292: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   295: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   298: iconst_2
    //   299: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   302: checkcast 189	mqq/manager/TicketManager
    //   305: astore 9
    //   307: aload 9
    //   309: aload_1
    //   310: invokeinterface 193 2 0
    //   315: astore 8
    //   317: aload 10
    //   319: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   322: ifne +511 -> 833
    //   325: aload 9
    //   327: aload_1
    //   328: aload_3
    //   329: invokeinterface 199 3 0
    //   334: astore_3
    //   335: aload_3
    //   336: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifeq +166 -> 505
    //   342: ldc 18
    //   344: iconst_1
    //   345: ldc_w 498
    //   348: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   354: astore_1
    //   355: aload_1
    //   356: ifnull +20 -> 376
    //   359: aload 7
    //   361: ldc_w 260
    //   364: aload_1
    //   365: aload 10
    //   367: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokeinterface 169 3 0
    //   375: pop
    //   376: aload 7
    //   378: invokeinterface 215 1 0
    //   383: invokeinterface 221 1 0
    //   388: astore_1
    //   389: aload_1
    //   390: invokeinterface 227 1 0
    //   395: ifeq +249 -> 644
    //   398: aload_1
    //   399: invokeinterface 231 1 0
    //   404: checkcast 233	java/util/Map$Entry
    //   407: astore_3
    //   408: aload_2
    //   409: aload_3
    //   410: invokeinterface 236 1 0
    //   415: checkcast 238	java/lang/String
    //   418: aload_3
    //   419: invokeinterface 241 1 0
    //   424: checkcast 238	java/lang/String
    //   427: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -41 -> 389
    //   433: astore_3
    //   434: aconst_null
    //   435: astore_1
    //   436: aload_2
    //   437: astore_0
    //   438: aload_3
    //   439: astore_2
    //   440: aload_0
    //   441: astore 7
    //   443: ldc 18
    //   445: iconst_1
    //   446: new 36	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 500
    //   456: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_2
    //   460: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   463: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: aload_0
    //   473: ifnull +7 -> 480
    //   476: aload_0
    //   477: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   480: aload_1
    //   481: areturn
    //   482: aload_2
    //   483: ldc 154
    //   485: ldc_w 502
    //   488: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: goto -250 -> 241
    //   494: astore_0
    //   495: aload_2
    //   496: ifnull +7 -> 503
    //   499: aload_2
    //   500: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   503: aload_0
    //   504: athrow
    //   505: new 36	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 377
    //   515: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_3
    //   519: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc_w 379
    //   525: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_1
    //   529: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 381
    //   535: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 8
    //   540: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: astore_1
    //   544: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   547: ldc_w 504
    //   550: iconst_0
    //   551: invokevirtual 508	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   554: ldc_w 510
    //   557: iconst_1
    //   558: invokeinterface 516 3 0
    //   563: ifeq +43 -> 606
    //   566: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   569: ldc_w 504
    //   572: iconst_0
    //   573: invokevirtual 508	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   576: ldc_w 518
    //   579: ldc_w 520
    //   582: invokeinterface 523 3 0
    //   587: astore_3
    //   588: aload_1
    //   589: ldc_w 525
    //   592: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_3
    //   596: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 527
    //   602: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 4
    //   608: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   611: ifne +15 -> 626
    //   614: aload_1
    //   615: bipush 59
    //   617: invokevirtual 530	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   620: aload 4
    //   622: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 7
    //   628: ldc_w 260
    //   631: aload_1
    //   632: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokeinterface 169 3 0
    //   640: pop
    //   641: goto -265 -> 376
    //   644: new 385	java/io/DataOutputStream
    //   647: dup
    //   648: aload_2
    //   649: invokevirtual 389	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   652: invokespecial 392	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   655: astore_1
    //   656: aload_1
    //   657: aload_0
    //   658: ldc_w 496
    //   661: invokevirtual 533	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   664: invokevirtual 426	java/io/OutputStream:write	([B)V
    //   667: aload_1
    //   668: invokevirtual 452	java/io/OutputStream:flush	()V
    //   671: aload_1
    //   672: invokevirtual 453	java/io/OutputStream:close	()V
    //   675: new 394	java/lang/StringBuffer
    //   678: dup
    //   679: invokespecial 395	java/lang/StringBuffer:<init>	()V
    //   682: astore_1
    //   683: aload_2
    //   684: invokevirtual 464	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   687: istore 6
    //   689: iload 6
    //   691: sipush 200
    //   694: if_icmpeq +36 -> 730
    //   697: ldc 18
    //   699: iconst_1
    //   700: new 36	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 535
    //   710: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: iload 6
    //   715: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: ldc_w 471
    //   721: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 474	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: new 476	java/io/BufferedReader
    //   733: dup
    //   734: new 478	java/io/InputStreamReader
    //   737: dup
    //   738: aload_2
    //   739: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   742: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   745: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   748: astore_0
    //   749: aload_0
    //   750: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   753: astore_3
    //   754: aload_3
    //   755: ifnull +33 -> 788
    //   758: aload_1
    //   759: aload_3
    //   760: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   763: ldc_w 487
    //   766: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   769: pop
    //   770: goto -21 -> 749
    //   773: astore_0
    //   774: aload_1
    //   775: invokevirtual 453	java/io/OutputStream:close	()V
    //   778: aload_2
    //   779: ifnull +7 -> 786
    //   782: aload_2
    //   783: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   786: aconst_null
    //   787: areturn
    //   788: aload_1
    //   789: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   792: astore_1
    //   793: aload_0
    //   794: invokevirtual 488	java/io/BufferedReader:close	()V
    //   797: aload_2
    //   798: ifnull +33 -> 831
    //   801: aload_2
    //   802: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   805: aload_1
    //   806: areturn
    //   807: astore_0
    //   808: aload 7
    //   810: astore_2
    //   811: goto -316 -> 495
    //   814: astore_2
    //   815: aconst_null
    //   816: astore_1
    //   817: aload 8
    //   819: astore_0
    //   820: goto -380 -> 440
    //   823: astore_3
    //   824: aload_2
    //   825: astore_0
    //   826: aload_3
    //   827: astore_2
    //   828: goto -388 -> 440
    //   831: aload_1
    //   832: areturn
    //   833: aconst_null
    //   834: astore_3
    //   835: goto -500 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	paramString1	java.lang.String
    //   0	838	1	paramString2	java.lang.String
    //   0	838	2	paramString3	java.lang.String
    //   0	838	3	paramString4	java.lang.String
    //   0	838	4	paramString5	java.lang.String
    //   0	838	5	paramBoolean	boolean
    //   687	27	6	i	int
    //   14	795	7	localObject1	Object
    //   4	814	8	str1	java.lang.String
    //   1	325	9	localTicketManager	mqq.manager.TicketManager
    //   10	356	10	str2	java.lang.String
    //   33	70	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   101	227	433	java/lang/Exception
    //   232	241	433	java/lang/Exception
    //   241	335	433	java/lang/Exception
    //   335	355	433	java/lang/Exception
    //   359	376	433	java/lang/Exception
    //   376	389	433	java/lang/Exception
    //   389	430	433	java/lang/Exception
    //   482	491	433	java/lang/Exception
    //   505	606	433	java/lang/Exception
    //   606	626	433	java/lang/Exception
    //   626	641	433	java/lang/Exception
    //   644	656	433	java/lang/Exception
    //   675	689	433	java/lang/Exception
    //   697	730	433	java/lang/Exception
    //   730	749	433	java/lang/Exception
    //   749	754	433	java/lang/Exception
    //   758	770	433	java/lang/Exception
    //   774	778	433	java/lang/Exception
    //   788	793	433	java/lang/Exception
    //   101	227	494	finally
    //   232	241	494	finally
    //   241	335	494	finally
    //   335	355	494	finally
    //   359	376	494	finally
    //   376	389	494	finally
    //   389	430	494	finally
    //   482	491	494	finally
    //   505	606	494	finally
    //   606	626	494	finally
    //   626	641	494	finally
    //   644	656	494	finally
    //   656	675	494	finally
    //   675	689	494	finally
    //   697	730	494	finally
    //   730	749	494	finally
    //   749	754	494	finally
    //   758	770	494	finally
    //   774	778	494	finally
    //   788	793	494	finally
    //   793	797	494	finally
    //   656	675	773	java/lang/Exception
    //   16	24	807	finally
    //   28	35	807	finally
    //   39	54	807	finally
    //   58	72	807	finally
    //   76	81	807	finally
    //   85	101	807	finally
    //   443	472	807	finally
    //   16	24	814	java/lang/Exception
    //   28	35	814	java/lang/Exception
    //   39	54	814	java/lang/Exception
    //   58	72	814	java/lang/Exception
    //   76	81	814	java/lang/Exception
    //   85	101	814	java/lang/Exception
    //   793	797	823	java/lang/Exception
  }
  
  /* Error */
  public static final java.lang.String a(org.json.JSONObject paramJSONObject, com.tencent.tim.teamwork.TeamWorkFileImportInfo paramTeamWorkFileImportInfo, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +16 -> 30
    //   17: ldc 18
    //   19: iconst_1
    //   20: ldc_w 538
    //   23: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: new 36	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 355
    //   44: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 541	auko:cjB	Ljava/lang/String;
    //   54: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: getfield 350	com/tencent/tim/teamwork/TeamWorkFileImportInfo:folderId	Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +16 -> 83
    //   70: aload 4
    //   72: ldc_w 362
    //   75: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 7
    //   90: aload 6
    //   92: astore 4
    //   94: new 50	anzp
    //   97: dup
    //   98: invokespecial 51	anzp:<init>	()V
    //   101: astore_1
    //   102: aload 6
    //   104: astore 4
    //   106: ldc 53
    //   108: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   111: astore 8
    //   113: aload 6
    //   115: astore 4
    //   117: aload 8
    //   119: aconst_null
    //   120: iconst_1
    //   121: anewarray 61	javax/net/ssl/TrustManager
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: aconst_null
    //   129: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   132: aload 6
    //   134: astore 4
    //   136: new 67	anzr
    //   139: dup
    //   140: aload 8
    //   142: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: astore 8
    //   150: aload 6
    //   152: astore 4
    //   154: aload 8
    //   156: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   159: aload 6
    //   161: astore 4
    //   163: new 81	java/net/URL
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   172: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   178: astore_1
    //   179: aload_1
    //   180: aload 8
    //   182: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   185: aload_1
    //   186: sipush 5000
    //   189: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   192: aload_1
    //   193: sipush 30000
    //   196: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   199: aload_1
    //   200: iconst_1
    //   201: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   204: aload_1
    //   205: iconst_1
    //   206: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   209: aload_1
    //   210: iconst_0
    //   211: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   214: aload_1
    //   215: ldc_w 364
    //   218: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: ldc 115
    //   224: ldc 117
    //   226: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 123
    //   232: new 36	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 125
    //   238: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: ldc 128
    //   243: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   249: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 128
    //   254: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   260: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 128
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   271: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 128
    //   276: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 144
    //   281: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 128
    //   286: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 146
    //   291: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 148
    //   296: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ldc 154
    //   308: ldc_w 492
    //   311: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_1
    //   315: ldc 150
    //   317: ldc 152
    //   319: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: ldc_w 494
    //   326: ldc_w 496
    //   329: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: new 160	java/util/HashMap
    //   335: dup
    //   336: invokespecial 161	java/util/HashMap:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc 115
    //   345: ldc 163
    //   347: invokeinterface 169 3 0
    //   352: pop
    //   353: aload 5
    //   355: ldc 171
    //   357: aload 7
    //   359: invokeinterface 169 3 0
    //   364: pop
    //   365: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   368: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   371: iconst_2
    //   372: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   375: checkcast 189	mqq/manager/TicketManager
    //   378: astore 4
    //   380: aload 4
    //   382: aload_2
    //   383: invokeinterface 193 2 0
    //   388: astore 6
    //   390: aload 7
    //   392: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +429 -> 824
    //   398: aload 4
    //   400: aload_2
    //   401: ldc 195
    //   403: invokeinterface 199 3 0
    //   408: astore 4
    //   410: aload 4
    //   412: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifeq +144 -> 559
    //   418: ldc 18
    //   420: iconst_1
    //   421: ldc_w 498
    //   424: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   430: astore_2
    //   431: aload_2
    //   432: ifnull +20 -> 452
    //   435: aload 5
    //   437: ldc_w 260
    //   440: aload_2
    //   441: aload 7
    //   443: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokeinterface 169 3 0
    //   451: pop
    //   452: aload 5
    //   454: invokeinterface 215 1 0
    //   459: invokeinterface 221 1 0
    //   464: astore_2
    //   465: aload_2
    //   466: invokeinterface 227 1 0
    //   471: ifeq +165 -> 636
    //   474: aload_2
    //   475: invokeinterface 231 1 0
    //   480: checkcast 233	java/util/Map$Entry
    //   483: astore 4
    //   485: aload_1
    //   486: aload 4
    //   488: invokeinterface 236 1 0
    //   493: checkcast 238	java/lang/String
    //   496: aload 4
    //   498: invokeinterface 241 1 0
    //   503: checkcast 238	java/lang/String
    //   506: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -44 -> 465
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_0
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 18
    //   520: iconst_1
    //   521: new 36	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 543
    //   531: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   538: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: astore_2
    //   549: aload_1
    //   550: ifnull -522 -> 28
    //   553: aload_1
    //   554: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   557: aload_0
    //   558: areturn
    //   559: aload 5
    //   561: ldc_w 260
    //   564: new 36	java/lang/StringBuilder
    //   567: dup
    //   568: new 36	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 377
    //   578: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 4
    //   583: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 379
    //   589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_2
    //   593: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 381
    //   599: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 6
    //   604: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokeinterface 169 3 0
    //   621: pop
    //   622: goto -170 -> 452
    //   625: astore_0
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   634: aload_0
    //   635: athrow
    //   636: new 385	java/io/DataOutputStream
    //   639: dup
    //   640: aload_1
    //   641: invokevirtual 389	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   644: invokespecial 392	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   647: astore_2
    //   648: aload_2
    //   649: aload_0
    //   650: invokevirtual 546	org/json/JSONObject:toString	()Ljava/lang/String;
    //   653: ldc_w 496
    //   656: invokevirtual 533	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   659: invokevirtual 426	java/io/OutputStream:write	([B)V
    //   662: aload_2
    //   663: invokevirtual 452	java/io/OutputStream:flush	()V
    //   666: aload_2
    //   667: invokevirtual 453	java/io/OutputStream:close	()V
    //   670: new 394	java/lang/StringBuffer
    //   673: dup
    //   674: invokespecial 395	java/lang/StringBuffer:<init>	()V
    //   677: astore_0
    //   678: aload_1
    //   679: invokevirtual 464	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   682: istore_3
    //   683: iload_3
    //   684: sipush 200
    //   687: if_icmpeq +35 -> 722
    //   690: ldc 18
    //   692: iconst_1
    //   693: new 36	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 548
    //   703: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: iload_3
    //   707: invokevirtual 469	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: ldc_w 471
    //   713: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 474	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: new 476	java/io/BufferedReader
    //   725: dup
    //   726: new 478	java/io/InputStreamReader
    //   729: dup
    //   730: aload_1
    //   731: invokevirtual 277	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   734: invokespecial 479	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   737: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   740: astore_2
    //   741: aload_2
    //   742: invokevirtual 485	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   745: astore 4
    //   747: aload 4
    //   749: ifnull +34 -> 783
    //   752: aload_0
    //   753: aload 4
    //   755: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   758: ldc_w 487
    //   761: invokevirtual 400	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: goto -24 -> 741
    //   768: astore_0
    //   769: aload_2
    //   770: invokevirtual 453	java/io/OutputStream:close	()V
    //   773: aload_1
    //   774: ifnull +7 -> 781
    //   777: aload_1
    //   778: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   781: aconst_null
    //   782: areturn
    //   783: aload_0
    //   784: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   787: astore_0
    //   788: aload_2
    //   789: invokevirtual 488	java/io/BufferedReader:close	()V
    //   792: aload_1
    //   793: ifnull +29 -> 822
    //   796: aload_1
    //   797: invokevirtual 258	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   800: aload_0
    //   801: areturn
    //   802: astore_0
    //   803: aload 4
    //   805: astore_1
    //   806: goto -180 -> 626
    //   809: astore_2
    //   810: aconst_null
    //   811: astore_0
    //   812: aload 5
    //   814: astore_1
    //   815: goto -300 -> 515
    //   818: astore_2
    //   819: goto -304 -> 515
    //   822: aload_0
    //   823: areturn
    //   824: aconst_null
    //   825: astore 4
    //   827: goto -417 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	paramJSONObject	org.json.JSONObject
    //   0	830	1	paramTeamWorkFileImportInfo	com.tencent.tim.teamwork.TeamWorkFileImportInfo
    //   0	830	2	paramString	java.lang.String
    //   682	25	3	i	int
    //   37	789	4	localObject1	Object
    //   4	809	5	localHashMap	java.util.HashMap
    //   1	602	6	str1	java.lang.String
    //   88	354	7	str2	java.lang.String
    //   111	70	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   179	410	512	java/lang/Exception
    //   410	431	512	java/lang/Exception
    //   435	452	512	java/lang/Exception
    //   452	465	512	java/lang/Exception
    //   465	509	512	java/lang/Exception
    //   559	622	512	java/lang/Exception
    //   636	648	512	java/lang/Exception
    //   670	683	512	java/lang/Exception
    //   690	722	512	java/lang/Exception
    //   722	741	512	java/lang/Exception
    //   741	747	512	java/lang/Exception
    //   752	765	512	java/lang/Exception
    //   769	773	512	java/lang/Exception
    //   783	788	512	java/lang/Exception
    //   179	410	625	finally
    //   410	431	625	finally
    //   435	452	625	finally
    //   452	465	625	finally
    //   465	509	625	finally
    //   559	622	625	finally
    //   636	648	625	finally
    //   648	670	625	finally
    //   670	683	625	finally
    //   690	722	625	finally
    //   722	741	625	finally
    //   741	747	625	finally
    //   752	765	625	finally
    //   769	773	625	finally
    //   783	788	625	finally
    //   788	792	625	finally
    //   648	670	768	java/lang/Exception
    //   94	102	802	finally
    //   106	113	802	finally
    //   117	132	802	finally
    //   136	150	802	finally
    //   154	159	802	finally
    //   163	179	802	finally
    //   518	547	802	finally
    //   94	102	809	java/lang/Exception
    //   106	113	809	java/lang/Exception
    //   117	132	809	java/lang/Exception
    //   136	150	809	java/lang/Exception
    //   154	159	809	java/lang/Exception
    //   163	179	809	java/lang/Exception
    //   788	792	818	java/lang/Exception
  }
  
  /* Error */
  public static final java.lang.String dU(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 324	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 325	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 353	java/io/File:exists	()Z
    //   18: ifeq +116 -> 134
    //   21: ldc_w 550
    //   24: invokestatic 555	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 5
    //   29: new 430	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 556	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore 7
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: aload 7
    //   56: invokevirtual 557	java/io/FileInputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: iconst_m1
    //   62: if_icmpeq +75 -> 137
    //   65: aload 4
    //   67: astore_0
    //   68: aload 5
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_1
    //   74: invokevirtual 560	java/security/MessageDigest:update	([BII)V
    //   77: goto -28 -> 49
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: ldc_w 562
    //   88: iconst_1
    //   89: new 36	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 564
    //   99: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: invokevirtual 565	java/io/FileInputStream:close	()V
    //   130: aload 6
    //   132: astore 5
    //   134: aload 5
    //   136: areturn
    //   137: aload 4
    //   139: astore_0
    //   140: aload 4
    //   142: invokevirtual 565	java/io/FileInputStream:close	()V
    //   145: aload 4
    //   147: astore_0
    //   148: new 36	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: invokevirtual 568	java/security/MessageDigest:digest	()[B
    //   165: astore 8
    //   167: aload 4
    //   169: astore_0
    //   170: aload 8
    //   172: arraylength
    //   173: istore_2
    //   174: iconst_0
    //   175: istore_1
    //   176: goto +195 -> 371
    //   179: aload 4
    //   181: astore_0
    //   182: aload 7
    //   184: aload 5
    //   186: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_0
    //   193: aload 7
    //   195: iload_3
    //   196: invokestatic 572	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   199: invokevirtual 575	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto +161 -> 371
    //   213: aload 4
    //   215: astore_0
    //   216: aload 7
    //   218: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: astore_0
    //   226: aload_0
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -97 -> 134
    //   234: aload 4
    //   236: invokevirtual 565	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore 4
    //   243: ldc_w 562
    //   246: iconst_1
    //   247: new 36	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 577
    //   257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 4
    //   262: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: ldc_w 562
    //   280: iconst_1
    //   281: new 36	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 577
    //   291: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 565	java/io/FileInputStream:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore_0
    //   325: ldc_w 562
    //   328: iconst_1
    //   329: new 36	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 577
    //   339: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -34 -> 321
    //   358: astore 4
    //   360: goto -47 -> 313
    //   363: astore 5
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -286 -> 82
    //   371: iload_1
    //   372: iload_2
    //   373: if_icmpge -160 -> 213
    //   376: aload 8
    //   378: iload_1
    //   379: baload
    //   380: sipush 255
    //   383: iand
    //   384: istore_3
    //   385: iload_3
    //   386: bipush 16
    //   388: if_icmpge +11 -> 399
    //   391: ldc_w 579
    //   394: astore 5
    //   396: goto -217 -> 179
    //   399: ldc_w 581
    //   402: astore 5
    //   404: goto -225 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramString	java.lang.String
    //   59	320	1	i	int
    //   173	201	2	j	int
    //   195	194	3	k	int
    //   37	198	4	localFileInputStream	java.io.FileInputStream
    //   241	20	4	localException1	java.lang.Exception
    //   309	13	4	localObject1	Object
    //   358	1	4	localObject2	Object
    //   366	1	4	localObject3	Object
    //   5	64	5	localObject4	Object
    //   80	23	5	localException2	java.lang.Exception
    //   118	110	5	localObject5	Object
    //   363	1	5	localException3	java.lang.Exception
    //   394	9	5	str	java.lang.String
    //   1	130	6	localObject6	Object
    //   47	170	7	localObject7	Object
    //   165	212	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	49	80	java/lang/Exception
    //   52	60	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   140	145	80	java/lang/Exception
    //   148	157	80	java/lang/Exception
    //   160	167	80	java/lang/Exception
    //   170	174	80	java/lang/Exception
    //   182	190	80	java/lang/Exception
    //   193	206	80	java/lang/Exception
    //   216	223	80	java/lang/Exception
    //   234	239	241	java/lang/Exception
    //   125	130	276	java/lang/Exception
    //   21	39	309	finally
    //   317	321	324	java/lang/Exception
    //   42	49	358	finally
    //   52	60	358	finally
    //   68	77	358	finally
    //   85	116	358	finally
    //   140	145	358	finally
    //   148	157	358	finally
    //   160	167	358	finally
    //   170	174	358	finally
    //   182	190	358	finally
    //   193	206	358	finally
    //   216	223	358	finally
    //   21	39	363	java/lang/Exception
  }
  
  private static long hg()
  {
    boolean bool = aqfo.isExistSDCard();
    long l1 = aqfo.getSDCardAvailableSize();
    long l2 = aqfo.getSystemAvailableSize();
    if ((bool) && (l1 != 0L)) {
      return Math.min(l1, l2) * 1024L;
    }
    return l2 * 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulk
 * JD-Core Version:    0.7.0.1
 */