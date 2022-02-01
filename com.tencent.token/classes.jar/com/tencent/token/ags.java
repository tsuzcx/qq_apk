package com.tencent.token;

import android.os.Process;

public final class ags
{
  public static final String a = afz.a(afz.b);
  public static final String b = afz.a(afz.c);
  public static final String c = afz.a(afz.d);
  public static final String d = afz.a(afz.e);
  public static final String e = afz.a(afz.f);
  public static long f = 0L;
  public static final String[] g = { "^/data/user/\\d+$", "^/data/data$" };
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 58	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: new 69	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 70	java/util/ArrayList:<init>	()V
    //   20: astore 11
    //   22: aload_0
    //   23: invokevirtual 76	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   26: invokevirtual 80	android/content/Context:getFilesDir	()Ljava/io/File;
    //   29: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnonnull +18 -> 54
    //   39: new 6	com/tencent/token/ags$a
    //   42: dup
    //   43: iconst_0
    //   44: ldc 87
    //   46: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   49: astore 6
    //   51: goto +238 -> 289
    //   54: aload 6
    //   56: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore 7
    //   61: aload 7
    //   63: ifnonnull +18 -> 81
    //   66: new 6	com/tencent/token/ags$a
    //   69: dup
    //   70: iconst_0
    //   71: ldc 87
    //   73: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   76: astore 6
    //   78: goto +211 -> 289
    //   81: getstatic 54	com/tencent/token/ags:g	[Ljava/lang/String;
    //   84: astore 8
    //   86: aload 8
    //   88: arraylength
    //   89: istore_2
    //   90: iconst_0
    //   91: istore_1
    //   92: iload_1
    //   93: iload_2
    //   94: if_icmpge +37 -> 131
    //   97: aload 8
    //   99: iload_1
    //   100: aaload
    //   101: invokestatic 96	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   104: aload 7
    //   106: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   109: invokevirtual 104	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   112: invokevirtual 110	java/util/regex/Matcher:find	()Z
    //   115: ifeq +9 -> 124
    //   118: iconst_0
    //   119: istore 5
    //   121: goto +13 -> 134
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: goto -36 -> 92
    //   131: iconst_1
    //   132: istore 5
    //   134: aload 6
    //   136: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: astore 8
    //   141: aload_0
    //   142: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   145: astore 7
    //   147: aload 8
    //   149: ldc 115
    //   151: bipush 6
    //   153: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   156: astore 9
    //   158: aload 8
    //   160: ldc 121
    //   162: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   165: ifeq +29 -> 194
    //   168: aload 9
    //   170: arraylength
    //   171: iconst_4
    //   172: if_icmplt +22 -> 194
    //   175: aload 9
    //   177: iconst_3
    //   178: aaload
    //   179: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +12 -> 194
    //   185: aload 9
    //   187: iconst_3
    //   188: aaload
    //   189: astore 6
    //   191: goto +48 -> 239
    //   194: aload 7
    //   196: astore 6
    //   198: aload 8
    //   200: ldc 133
    //   202: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   205: ifeq +34 -> 239
    //   208: aload 7
    //   210: astore 6
    //   212: aload 9
    //   214: arraylength
    //   215: iconst_5
    //   216: if_icmplt +23 -> 239
    //   219: aload 7
    //   221: astore 6
    //   223: aload 9
    //   225: iconst_4
    //   226: aaload
    //   227: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifne +9 -> 239
    //   233: aload 9
    //   235: iconst_4
    //   236: aaload
    //   237: astore 6
    //   239: iload 5
    //   241: ifeq +35 -> 276
    //   244: aload 6
    //   246: aload_0
    //   247: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   250: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +23 -> 276
    //   256: new 6	com/tencent/token/ags$a
    //   259: dup
    //   260: iload 5
    //   262: aload_0
    //   263: aload 6
    //   265: invokestatic 140	com/tencent/token/ags:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   268: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   271: astore 6
    //   273: goto +16 -> 289
    //   276: new 6	com/tencent/token/ags$a
    //   279: dup
    //   280: iload 5
    //   282: ldc 87
    //   284: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   287: astore 6
    //   289: aload 6
    //   291: getfield 143	com/tencent/token/ags$a:a	Z
    //   294: ifeq +88 -> 382
    //   297: aload 6
    //   299: getfield 144	com/tencent/token/ags$a:b	Ljava/lang/String;
    //   302: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +77 -> 382
    //   308: iconst_0
    //   309: iconst_1
    //   310: iconst_0
    //   311: invokestatic 149	com/tencent/token/ahr:a	(IZI)I
    //   314: istore_1
    //   315: new 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   318: dup
    //   319: invokespecial 152	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   322: astore 7
    //   324: new 58	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   331: astore 8
    //   333: aload 8
    //   335: getstatic 28	com/tencent/token/ags:a	Ljava/lang/String;
    //   338: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 8
    //   344: getstatic 36	com/tencent/token/ags:c	Ljava/lang/String;
    //   347: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 7
    //   353: aload 8
    //   355: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: putfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   361: aload 7
    //   363: aload 6
    //   365: getfield 144	com/tencent/token/ags$a:b	Ljava/lang/String;
    //   368: putfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   371: aload 11
    //   373: aload 7
    //   375: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   378: pop
    //   379: goto +10 -> 389
    //   382: iconst_0
    //   383: iconst_0
    //   384: iconst_0
    //   385: invokestatic 149	com/tencent/token/ahr:a	(IZI)I
    //   388: istore_1
    //   389: aload_0
    //   390: invokevirtual 76	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   393: astore 12
    //   395: aload 12
    //   397: ifnonnull +18 -> 415
    //   400: new 6	com/tencent/token/ags$a
    //   403: dup
    //   404: iconst_0
    //   405: ldc 87
    //   407: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   410: astore 6
    //   412: goto +449 -> 861
    //   415: new 166	java/io/FileReader
    //   418: dup
    //   419: ldc 168
    //   421: invokespecial 171	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   424: astore 7
    //   426: new 173	java/io/BufferedReader
    //   429: dup
    //   430: aload 7
    //   432: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   435: astore 8
    //   437: aload 8
    //   439: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +214 -> 660
    //   449: aload 6
    //   451: bipush 47
    //   453: invokevirtual 183	java/lang/String:indexOf	(I)I
    //   456: istore_2
    //   457: iload_2
    //   458: iconst_m1
    //   459: if_icmpeq +198 -> 657
    //   462: aload 6
    //   464: iload_2
    //   465: invokevirtual 187	java/lang/String:substring	(I)Ljava/lang/String;
    //   468: invokevirtual 190	java/lang/String:trim	()Ljava/lang/String;
    //   471: astore 6
    //   473: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   476: bipush 23
    //   478: if_icmpge +124 -> 602
    //   481: aload 6
    //   483: ldc 198
    //   485: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   488: ifeq +1279 -> 1767
    //   491: aload 6
    //   493: ldc 200
    //   495: invokevirtual 203	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   498: ifeq +1266 -> 1764
    //   501: aload 6
    //   503: bipush 47
    //   505: invokevirtual 206	java/lang/String:lastIndexOf	(I)I
    //   508: istore_2
    //   509: iload_2
    //   510: iconst_m1
    //   511: if_icmpeq +1250 -> 1761
    //   514: aload 6
    //   516: iload_2
    //   517: aload 6
    //   519: invokevirtual 210	java/lang/String:length	()I
    //   522: bipush 12
    //   524: isub
    //   525: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   528: bipush 64
    //   530: bipush 47
    //   532: invokevirtual 217	java/lang/String:replace	(CC)Ljava/lang/String;
    //   535: astore 6
    //   537: aload 6
    //   539: ldc 219
    //   541: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   544: ifeq +1214 -> 1758
    //   547: new 82	java/io/File
    //   550: dup
    //   551: aload 6
    //   553: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   556: astore 6
    //   558: ldc 222
    //   560: aload 6
    //   562: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   565: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: ifeq +24 -> 592
    //   571: aload 6
    //   573: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
    //   576: ifnull +84 -> 660
    //   579: aload 6
    //   581: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
    //   584: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   587: astore 6
    //   589: goto +119 -> 708
    //   592: aload 6
    //   594: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   597: astore 6
    //   599: goto +109 -> 708
    //   602: aload 6
    //   604: ldc 219
    //   606: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   609: ifeq +45 -> 654
    //   612: aload 6
    //   614: ldc 227
    //   616: invokevirtual 203	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   619: ifeq +32 -> 651
    //   622: aload 6
    //   624: ldc 115
    //   626: invokevirtual 230	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   629: astore 6
    //   631: aload 6
    //   633: arraylength
    //   634: bipush 7
    //   636: if_icmplt +12 -> 648
    //   639: aload 6
    //   641: iconst_3
    //   642: aaload
    //   643: astore 6
    //   645: goto +63 -> 708
    //   648: goto -211 -> 437
    //   651: goto -214 -> 437
    //   654: goto -217 -> 437
    //   657: goto -220 -> 437
    //   660: aconst_null
    //   661: astore 6
    //   663: goto +45 -> 708
    //   666: astore 9
    //   668: aload 8
    //   670: astore 6
    //   672: goto +20 -> 692
    //   675: astore 8
    //   677: goto +8 -> 685
    //   680: astore 8
    //   682: aconst_null
    //   683: astore 7
    //   685: aconst_null
    //   686: astore 6
    //   688: aload 8
    //   690: astore 9
    //   692: aload 9
    //   694: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   697: aconst_null
    //   698: astore 9
    //   700: aload 6
    //   702: astore 8
    //   704: aload 9
    //   706: astore 6
    //   708: aload 7
    //   710: invokestatic 238	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   713: aload 8
    //   715: invokestatic 238	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   718: aload 12
    //   720: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   723: astore 7
    //   725: aload 6
    //   727: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   730: ifne +86 -> 816
    //   733: aload 6
    //   735: ldc 240
    //   737: invokevirtual 243	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   740: istore_2
    //   741: iload_2
    //   742: iconst_m1
    //   743: if_icmpeq +73 -> 816
    //   746: aload 6
    //   748: iconst_0
    //   749: iload_2
    //   750: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   753: astore 6
    //   755: aload 6
    //   757: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: ifne +56 -> 816
    //   763: new 82	java/io/File
    //   766: dup
    //   767: ldc 121
    //   769: aload 6
    //   771: invokestatic 247	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   774: invokevirtual 251	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   777: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   780: astore 8
    //   782: aload 8
    //   784: invokevirtual 254	java/io/File:exists	()Z
    //   787: ifeq +11 -> 798
    //   790: aload 8
    //   792: invokevirtual 257	java/io/File:canWrite	()Z
    //   795: ifne +7 -> 802
    //   798: aload 7
    //   800: astore 6
    //   802: aload 7
    //   804: aload 6
    //   806: invokestatic 260	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   809: iconst_1
    //   810: ixor
    //   811: istore 5
    //   813: goto +10 -> 823
    //   816: iconst_0
    //   817: istore 5
    //   819: aload 7
    //   821: astore 6
    //   823: iload 5
    //   825: ifeq +23 -> 848
    //   828: new 6	com/tencent/token/ags$a
    //   831: dup
    //   832: iload 5
    //   834: aload_0
    //   835: aload 6
    //   837: invokestatic 140	com/tencent/token/ags:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   840: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   843: astore 6
    //   845: goto +16 -> 861
    //   848: new 6	com/tencent/token/ags$a
    //   851: dup
    //   852: iload 5
    //   854: ldc 87
    //   856: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   859: astore 6
    //   861: iload_1
    //   862: aload 6
    //   864: getfield 143	com/tencent/token/ags$a:a	Z
    //   867: iconst_1
    //   868: invokestatic 149	com/tencent/token/ahr:a	(IZI)I
    //   871: istore_1
    //   872: aload 6
    //   874: getfield 143	com/tencent/token/ags$a:a	Z
    //   877: ifeq +67 -> 944
    //   880: new 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   883: dup
    //   884: invokespecial 152	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   887: astore 7
    //   889: new 58	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   896: astore 8
    //   898: aload 8
    //   900: getstatic 28	com/tencent/token/ags:a	Ljava/lang/String;
    //   903: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload 8
    //   909: getstatic 40	com/tencent/token/ags:d	Ljava/lang/String;
    //   912: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: pop
    //   916: aload 7
    //   918: aload 8
    //   920: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: putfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   926: aload 7
    //   928: aload 6
    //   930: getfield 144	com/tencent/token/ags$a:b	Ljava/lang/String;
    //   933: putfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   936: aload 11
    //   938: aload 7
    //   940: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   943: pop
    //   944: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   947: bipush 17
    //   949: if_icmpge +18 -> 967
    //   952: new 6	com/tencent/token/ags$a
    //   955: dup
    //   956: iconst_0
    //   957: ldc 87
    //   959: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   962: astore 6
    //   964: goto +371 -> 1335
    //   967: new 58	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   974: astore 7
    //   976: getstatic 265	android/os/Build:BRAND	Ljava/lang/String;
    //   979: astore 6
    //   981: ldc_w 267
    //   984: aload 6
    //   986: invokevirtual 270	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   989: ifeq +147 -> 1136
    //   992: ldc_w 272
    //   995: invokestatic 278	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   998: astore 6
    //   1000: aload_0
    //   1001: invokevirtual 282	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1004: ldc_w 284
    //   1007: invokevirtual 288	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1010: astore 8
    //   1012: aload 8
    //   1014: iconst_1
    //   1015: invokevirtual 294	java/lang/reflect/Field:setAccessible	(Z)V
    //   1018: aload_0
    //   1019: aload 8
    //   1021: aload_0
    //   1022: invokevirtual 298	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1025: checkcast 48	java/lang/String
    //   1028: invokevirtual 302	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1031: astore 8
    //   1033: aload 8
    //   1035: ifnull +47 -> 1082
    //   1038: aload 6
    //   1040: ldc_w 304
    //   1043: iconst_0
    //   1044: anewarray 274	java/lang/Class
    //   1047: invokevirtual 308	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1050: astore 6
    //   1052: aload 6
    //   1054: ifnull +28 -> 1082
    //   1057: aload 6
    //   1059: iconst_1
    //   1060: invokevirtual 311	java/lang/reflect/Method:setAccessible	(Z)V
    //   1063: aload 6
    //   1065: aload 8
    //   1067: iconst_0
    //   1068: anewarray 4	java/lang/Object
    //   1071: invokevirtual 315	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1074: checkcast 48	java/lang/String
    //   1077: astore 6
    //   1079: goto +7 -> 1086
    //   1082: ldc 87
    //   1084: astore 6
    //   1086: new 48	java/lang/String
    //   1089: dup
    //   1090: ldc_w 317
    //   1093: iconst_0
    //   1094: invokestatic 323	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1097: invokespecial 326	java/lang/String:<init>	([B)V
    //   1100: astore 8
    //   1102: aload 6
    //   1104: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1107: ifne +209 -> 1316
    //   1110: aload 8
    //   1112: aload 6
    //   1114: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1117: istore 5
    //   1119: iload 5
    //   1121: ifeq +195 -> 1316
    //   1124: aload 7
    //   1126: ldc_w 328
    //   1129: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: pop
    //   1133: goto +171 -> 1304
    //   1136: ldc_w 330
    //   1139: aload 6
    //   1141: invokevirtual 270	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1144: ifeq +24 -> 1168
    //   1147: invokestatic 332	com/tencent/token/ags:a	()Z
    //   1150: ifeq +166 -> 1316
    //   1153: aload 7
    //   1155: ldc_w 334
    //   1158: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1161: pop
    //   1162: iconst_1
    //   1163: istore 5
    //   1165: goto +154 -> 1319
    //   1168: ldc_w 336
    //   1171: aload 6
    //   1173: invokevirtual 270	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1176: ifeq +24 -> 1200
    //   1179: invokestatic 332	com/tencent/token/ags:a	()Z
    //   1182: ifeq +134 -> 1316
    //   1185: aload 7
    //   1187: ldc_w 338
    //   1190: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: pop
    //   1194: iconst_1
    //   1195: istore 5
    //   1197: goto +122 -> 1319
    //   1200: ldc_w 340
    //   1203: aload 6
    //   1205: invokevirtual 270	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1208: ifeq +108 -> 1316
    //   1211: invokestatic 332	com/tencent/token/ags:a	()Z
    //   1214: ifeq +18 -> 1232
    //   1217: aload 7
    //   1219: ldc_w 342
    //   1222: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: iconst_1
    //   1227: istore 5
    //   1229: goto +90 -> 1319
    //   1232: new 48	java/lang/String
    //   1235: dup
    //   1236: ldc_w 344
    //   1239: invokestatic 349	com/tencent/token/acy:b	(Ljava/lang/String;)[B
    //   1242: invokespecial 326	java/lang/String:<init>	([B)V
    //   1245: astore 6
    //   1247: new 58	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1254: astore 8
    //   1256: aload 8
    //   1258: aload_0
    //   1259: invokevirtual 76	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1262: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1265: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: aload 8
    //   1271: ldc_w 351
    //   1274: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 6
    //   1280: aload 8
    //   1282: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1285: invokevirtual 354	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1288: istore 5
    //   1290: iload 5
    //   1292: ifeq +24 -> 1316
    //   1295: aload 7
    //   1297: ldc_w 356
    //   1300: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: pop
    //   1304: iconst_1
    //   1305: istore 5
    //   1307: goto +12 -> 1319
    //   1310: iconst_0
    //   1311: istore 5
    //   1313: goto +6 -> 1319
    //   1316: iconst_0
    //   1317: istore 5
    //   1319: new 6	com/tencent/token/ags$a
    //   1322: dup
    //   1323: iload 5
    //   1325: aload 7
    //   1327: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1330: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   1333: astore 6
    //   1335: iload_1
    //   1336: aload 6
    //   1338: getfield 143	com/tencent/token/ags$a:a	Z
    //   1341: iconst_2
    //   1342: invokestatic 149	com/tencent/token/ahr:a	(IZI)I
    //   1345: istore_2
    //   1346: aload 6
    //   1348: getfield 143	com/tencent/token/ags$a:a	Z
    //   1351: ifeq +67 -> 1418
    //   1354: new 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   1357: dup
    //   1358: invokespecial 152	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   1361: astore 7
    //   1363: new 58	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1370: astore 8
    //   1372: aload 8
    //   1374: getstatic 28	com/tencent/token/ags:a	Ljava/lang/String;
    //   1377: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: pop
    //   1381: aload 8
    //   1383: getstatic 44	com/tencent/token/ags:e	Ljava/lang/String;
    //   1386: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 7
    //   1392: aload 8
    //   1394: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: putfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   1400: aload 7
    //   1402: aload 6
    //   1404: getfield 144	com/tencent/token/ags$a:b	Ljava/lang/String;
    //   1407: putfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   1410: aload 11
    //   1412: aload 7
    //   1414: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1417: pop
    //   1418: new 358	android/util/SparseArray
    //   1421: dup
    //   1422: invokespecial 359	android/util/SparseArray:<init>	()V
    //   1425: pop
    //   1426: new 358	android/util/SparseArray
    //   1429: dup
    //   1430: invokespecial 359	android/util/SparseArray:<init>	()V
    //   1433: aload_0
    //   1434: sipush 206
    //   1437: invokestatic 364	com/tencent/turingfd/sdk/qps/TNative$aa:d	(Landroid/util/SparseArray;Landroid/content/Context;I)Landroid/util/SparseArray;
    //   1440: sipush 206
    //   1443: ldc 48
    //   1445: invokestatic 367	com/tencent/token/ahr:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1448: checkcast 48	java/lang/String
    //   1451: astore 7
    //   1453: aload 7
    //   1455: astore_0
    //   1456: aload 7
    //   1458: ifnonnull +6 -> 1464
    //   1461: ldc 87
    //   1463: astore_0
    //   1464: aload_0
    //   1465: invokestatic 372	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1468: istore_1
    //   1469: goto +5 -> 1474
    //   1472: iconst_0
    //   1473: istore_1
    //   1474: iload_1
    //   1475: ifle +17 -> 1492
    //   1478: new 6	com/tencent/token/ags$a
    //   1481: dup
    //   1482: iconst_1
    //   1483: ldc 87
    //   1485: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   1488: astore_0
    //   1489: goto +14 -> 1503
    //   1492: new 6	com/tencent/token/ags$a
    //   1495: dup
    //   1496: iconst_0
    //   1497: ldc 87
    //   1499: invokespecial 90	com/tencent/token/ags$a:<init>	(ZLjava/lang/String;)V
    //   1502: astore_0
    //   1503: iload_2
    //   1504: aload_0
    //   1505: getfield 143	com/tencent/token/ags$a:a	Z
    //   1508: iconst_4
    //   1509: invokestatic 149	com/tencent/token/ahr:a	(IZI)I
    //   1512: istore_1
    //   1513: aload_0
    //   1514: getfield 143	com/tencent/token/ags$a:a	Z
    //   1517: ifeq +63 -> 1580
    //   1520: new 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   1523: dup
    //   1524: invokespecial 152	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   1527: astore_0
    //   1528: new 58	java/lang/StringBuilder
    //   1531: dup
    //   1532: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1535: astore 7
    //   1537: aload 7
    //   1539: getstatic 28	com/tencent/token/ags:a	Ljava/lang/String;
    //   1542: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: pop
    //   1546: aload 7
    //   1548: ldc_w 374
    //   1551: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: pop
    //   1555: aload_0
    //   1556: aload 7
    //   1558: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: putfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   1564: aload_0
    //   1565: aload 6
    //   1567: getfield 144	com/tencent/token/ags$a:b	Ljava/lang/String;
    //   1570: putfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   1573: aload 11
    //   1575: aload_0
    //   1576: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1579: pop
    //   1580: iload_1
    //   1581: ifle +62 -> 1643
    //   1584: new 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   1587: dup
    //   1588: invokespecial 152	com/tencent/turingfd/sdk/qps/Ginkgo:<init>	()V
    //   1591: astore_0
    //   1592: new 58	java/lang/StringBuilder
    //   1595: dup
    //   1596: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   1599: astore 6
    //   1601: aload 6
    //   1603: getstatic 28	com/tencent/token/ags:a	Ljava/lang/String;
    //   1606: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1609: pop
    //   1610: aload 6
    //   1612: getstatic 32	com/tencent/token/ags:b	Ljava/lang/String;
    //   1615: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: pop
    //   1619: aload_0
    //   1620: aload 6
    //   1622: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1625: putfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   1628: aload_0
    //   1629: iload_1
    //   1630: invokestatic 376	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1633: putfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   1636: aload 11
    //   1638: aload_0
    //   1639: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1642: pop
    //   1643: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   1646: lload_3
    //   1647: lsub
    //   1648: putstatic 46	com/tencent/token/ags:f	J
    //   1651: aload 11
    //   1653: invokevirtual 380	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1656: astore_0
    //   1657: aload_0
    //   1658: invokeinterface 385 1 0
    //   1663: ifeq +57 -> 1720
    //   1666: aload_0
    //   1667: invokeinterface 389 1 0
    //   1672: checkcast 151	com/tencent/turingfd/sdk/qps/Ginkgo
    //   1675: astore 6
    //   1677: aload 10
    //   1679: aload 6
    //   1681: getfield 160	com/tencent/turingfd/sdk/qps/Ginkgo:a	Ljava/lang/String;
    //   1684: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload 10
    //   1690: ldc_w 391
    //   1693: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: pop
    //   1697: aload 10
    //   1699: aload 6
    //   1701: getfield 161	com/tencent/turingfd/sdk/qps/Ginkgo:b	Ljava/lang/String;
    //   1704: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload 10
    //   1710: ldc_w 393
    //   1713: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: pop
    //   1717: goto -60 -> 1657
    //   1720: aload 10
    //   1722: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1725: areturn
    //   1726: astore_0
    //   1727: aload 7
    //   1729: invokestatic 238	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   1732: aload 6
    //   1734: invokestatic 238	com/tencent/token/ahr:a	(Ljava/io/Closeable;)V
    //   1737: aload_0
    //   1738: athrow
    //   1739: astore 6
    //   1741: goto -659 -> 1082
    //   1744: astore 6
    //   1746: goto -436 -> 1310
    //   1749: astore 6
    //   1751: goto -447 -> 1304
    //   1754: astore_0
    //   1755: goto -283 -> 1472
    //   1758: goto -1321 -> 437
    //   1761: goto -1324 -> 437
    //   1764: goto -1327 -> 437
    //   1767: goto -1330 -> 437
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1770	0	paramContext	android.content.Context
    //   91	1539	1	i	int
    //   89	1415	2	j	int
    //   12	1635	3	l	long
    //   119	1205	5	bool	boolean
    //   32	1701	6	localObject1	Object
    //   1739	1	6	localObject2	Object
    //   1744	1	6	localObject3	Object
    //   1749	1	6	localObject4	Object
    //   59	1669	7	localObject5	Object
    //   84	585	8	localObject6	Object
    //   675	1	8	localObject7	Object
    //   680	9	8	localObject8	Object
    //   702	691	8	localObject9	Object
    //   156	78	9	arrayOfString	String[]
    //   666	1	9	localObject10	Object
    //   690	15	9	localObject11	Object
    //   7	1714	10	localStringBuilder	java.lang.StringBuilder
    //   20	1632	11	localArrayList	java.util.ArrayList
    //   393	326	12	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   437	444	666	finally
    //   449	457	666	finally
    //   462	509	666	finally
    //   514	558	666	finally
    //   558	589	666	finally
    //   592	599	666	finally
    //   602	639	666	finally
    //   426	437	675	finally
    //   415	426	680	finally
    //   692	697	1726	finally
    //   992	1033	1739	finally
    //   1038	1052	1739	finally
    //   1057	1079	1739	finally
    //   1086	1119	1744	finally
    //   1232	1290	1744	finally
    //   1124	1133	1749	finally
    //   1295	1304	1749	finally
    //   1426	1453	1754	finally
    //   1464	1469	1754	finally
  }
  
  /* Error */
  private static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 58	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 6
    //   18: ldc_w 397
    //   21: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 401	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: iconst_0
    //   33: invokevirtual 407	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   36: getfield 412	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   39: astore_0
    //   40: goto +6 -> 46
    //   43: ldc 87
    //   45: astore_0
    //   46: aload 6
    //   48: new 82	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokestatic 417	com/tencent/token/ade:a	(Ljava/io/File;)Ljava/util/List;
    //   59: checkcast 69	java/util/ArrayList
    //   62: iconst_0
    //   63: invokevirtual 420	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   66: checkcast 48	java/lang/String
    //   69: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 6
    //   75: ldc_w 397
    //   78: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: ldc2_w 421
    //   85: lstore 4
    //   87: lload 4
    //   89: lstore_2
    //   90: aload_0
    //   91: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +27 -> 121
    //   97: new 82	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_0
    //   106: lload 4
    //   108: lstore_2
    //   109: aload_0
    //   110: invokevirtual 254	java/io/File:exists	()Z
    //   113: ifeq +8 -> 121
    //   116: aload_0
    //   117: invokevirtual 424	java/io/File:length	()J
    //   120: lstore_2
    //   121: aload 6
    //   123: lload_2
    //   124: invokevirtual 427	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 6
    //   130: ldc_w 397
    //   133: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: invokestatic 432	android/os/Process:myUid	()I
    //   142: invokevirtual 435	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: areturn
    //   152: astore_0
    //   153: goto -110 -> 43
    //   156: astore_1
    //   157: goto -84 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	android.content.Context
    //   0	160	1	paramString	String
    //   89	35	2	l1	long
    //   85	22	4	l2	long
    //   7	140	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	40	152	android/content/pm/PackageManager$NameNotFoundException
    //   46	73	156	finally
  }
  
  private static boolean a()
  {
    try
    {
      int i = Process.myUid() / 100000;
      if (999 == i) {
        return true;
      }
    }
    finally
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public static final class a
  {
    public final boolean a;
    public final String b;
    
    public a(boolean paramBoolean, String paramString)
    {
      this.a = paramBoolean;
      this.b = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ags
 * JD-Core Version:    0.7.0.1
 */