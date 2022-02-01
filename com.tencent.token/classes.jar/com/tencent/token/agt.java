package com.tencent.token;

import android.os.Process;

public final class agt
{
  public static final String a = agg.a(agg.b);
  public static final String b = agg.a(agg.c);
  public static final String c = agg.a(agg.d);
  public static final String d = agg.a(agg.e);
  public static final String e = agg.a(agg.f);
  public static long f = 0L;
  public static final String[] g = { "^/data/user/\\d+$", "^/data/data$" };
  
  /* Error */
  private static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 60	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 6
    //   18: ldc 69
    //   20: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_0
    //   25: invokevirtual 75	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   28: astore_0
    //   29: aload_0
    //   30: aload_1
    //   31: iconst_0
    //   32: invokevirtual 81	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   35: getfield 86	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   38: astore_0
    //   39: goto +6 -> 45
    //   42: ldc 88
    //   44: astore_0
    //   45: aload 6
    //   47: new 90	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: invokestatic 98	com/tencent/token/adj:a	(Ljava/io/File;)Ljava/util/List;
    //   58: checkcast 100	java/util/ArrayList
    //   61: iconst_0
    //   62: invokevirtual 104	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 48	java/lang/String
    //   68: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 6
    //   74: ldc 69
    //   76: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc2_w 105
    //   83: lstore 4
    //   85: lload 4
    //   87: lstore_2
    //   88: aload_0
    //   89: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +27 -> 119
    //   95: new 90	java/io/File
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore_0
    //   104: lload 4
    //   106: lstore_2
    //   107: aload_0
    //   108: invokevirtual 116	java/io/File:exists	()Z
    //   111: ifeq +8 -> 119
    //   114: aload_0
    //   115: invokevirtual 120	java/io/File:length	()J
    //   118: lstore_2
    //   119: aload 6
    //   121: lload_2
    //   122: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 6
    //   128: ldc 69
    //   130: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: invokestatic 129	android/os/Process:myUid	()I
    //   139: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 6
    //   145: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: areturn
    //   149: astore_0
    //   150: goto -108 -> 42
    //   153: astore_1
    //   154: goto -82 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	android.content.Context
    //   0	157	1	paramString	String
    //   87	35	2	l1	long
    //   83	22	4	l2	long
    //   7	137	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	39	149	android/content/pm/PackageManager$NameNotFoundException
    //   45	72	153	finally
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.turingfd.sdk.qps.Damson> a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 100	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 143	java/util/ArrayList:<init>	()V
    //   11: astore 10
    //   13: aload_0
    //   14: invokevirtual 147	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 151	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: invokevirtual 154	java/io/File:getParentFile	()Ljava/io/File;
    //   23: astore 6
    //   25: aload 6
    //   27: ifnonnull +18 -> 45
    //   30: new 6	com/tencent/token/agt$a
    //   33: dup
    //   34: iconst_0
    //   35: ldc 88
    //   37: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   40: astore 6
    //   42: goto +238 -> 280
    //   45: aload 6
    //   47: invokevirtual 154	java/io/File:getParentFile	()Ljava/io/File;
    //   50: astore 7
    //   52: aload 7
    //   54: ifnonnull +18 -> 72
    //   57: new 6	com/tencent/token/agt$a
    //   60: dup
    //   61: iconst_0
    //   62: ldc 88
    //   64: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   67: astore 6
    //   69: goto +211 -> 280
    //   72: getstatic 54	com/tencent/token/agt:g	[Ljava/lang/String;
    //   75: astore 8
    //   77: aload 8
    //   79: arraylength
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +37 -> 122
    //   88: aload 8
    //   90: iload_1
    //   91: aaload
    //   92: invokestatic 163	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   95: aload 7
    //   97: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 170	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   103: invokevirtual 175	java/util/regex/Matcher:find	()Z
    //   106: ifeq +9 -> 115
    //   109: iconst_0
    //   110: istore 5
    //   112: goto +13 -> 125
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -36 -> 83
    //   122: iconst_1
    //   123: istore 5
    //   125: aload 6
    //   127: invokevirtual 166	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   130: astore 8
    //   132: aload_0
    //   133: invokevirtual 178	android/content/Context:getPackageName	()Ljava/lang/String;
    //   136: astore 7
    //   138: aload 8
    //   140: ldc 180
    //   142: bipush 6
    //   144: invokevirtual 184	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   147: astore 9
    //   149: aload 8
    //   151: ldc 186
    //   153: invokevirtual 190	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   156: ifeq +29 -> 185
    //   159: aload 9
    //   161: arraylength
    //   162: iconst_4
    //   163: if_icmplt +22 -> 185
    //   166: aload 9
    //   168: iconst_3
    //   169: aaload
    //   170: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +12 -> 185
    //   176: aload 9
    //   178: iconst_3
    //   179: aaload
    //   180: astore 6
    //   182: goto +48 -> 230
    //   185: aload 7
    //   187: astore 6
    //   189: aload 8
    //   191: ldc 192
    //   193: invokevirtual 190	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   196: ifeq +34 -> 230
    //   199: aload 7
    //   201: astore 6
    //   203: aload 9
    //   205: arraylength
    //   206: iconst_5
    //   207: if_icmplt +23 -> 230
    //   210: aload 7
    //   212: astore 6
    //   214: aload 9
    //   216: iconst_4
    //   217: aaload
    //   218: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +9 -> 230
    //   224: aload 9
    //   226: iconst_4
    //   227: aaload
    //   228: astore 6
    //   230: iload 5
    //   232: ifeq +35 -> 267
    //   235: aload 6
    //   237: aload_0
    //   238: invokevirtual 178	android/content/Context:getPackageName	()Ljava/lang/String;
    //   241: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +23 -> 267
    //   247: new 6	com/tencent/token/agt$a
    //   250: dup
    //   251: iload 5
    //   253: aload_0
    //   254: aload 6
    //   256: invokestatic 198	com/tencent/token/agt:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   259: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   262: astore 6
    //   264: goto +16 -> 280
    //   267: new 6	com/tencent/token/agt$a
    //   270: dup
    //   271: iload 5
    //   273: ldc 88
    //   275: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   278: astore 6
    //   280: aload 6
    //   282: getfield 201	com/tencent/token/agt$a:a	Z
    //   285: ifeq +88 -> 373
    //   288: aload 6
    //   290: getfield 202	com/tencent/token/agt$a:b	Ljava/lang/String;
    //   293: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   296: ifne +77 -> 373
    //   299: iconst_0
    //   300: iconst_1
    //   301: iconst_0
    //   302: invokestatic 207	com/tencent/token/agn:a	(IZI)I
    //   305: istore_1
    //   306: new 209	com/tencent/turingfd/sdk/qps/Damson
    //   309: dup
    //   310: invokespecial 210	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   313: astore 7
    //   315: new 60	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   322: astore 8
    //   324: aload 8
    //   326: getstatic 28	com/tencent/token/agt:a	Ljava/lang/String;
    //   329: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 8
    //   335: getstatic 36	com/tencent/token/agt:c	Ljava/lang/String;
    //   338: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload 7
    //   344: aload 8
    //   346: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: putfield 211	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   352: aload 7
    //   354: aload 6
    //   356: getfield 202	com/tencent/token/agt$a:b	Ljava/lang/String;
    //   359: putfield 212	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   362: aload 10
    //   364: aload 7
    //   366: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   369: pop
    //   370: goto +10 -> 380
    //   373: iconst_0
    //   374: iconst_0
    //   375: iconst_0
    //   376: invokestatic 207	com/tencent/token/agn:a	(IZI)I
    //   379: istore_1
    //   380: aload_0
    //   381: invokevirtual 147	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   384: astore 11
    //   386: aload 11
    //   388: ifnonnull +18 -> 406
    //   391: new 6	com/tencent/token/agt$a
    //   394: dup
    //   395: iconst_0
    //   396: ldc 88
    //   398: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   401: astore 6
    //   403: goto +451 -> 854
    //   406: new 217	java/io/FileReader
    //   409: dup
    //   410: ldc 219
    //   412: invokespecial 220	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   415: astore 7
    //   417: new 222	java/io/BufferedReader
    //   420: dup
    //   421: aload 7
    //   423: invokespecial 225	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   426: astore 8
    //   428: aload 8
    //   430: invokevirtual 228	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   433: astore 6
    //   435: aload 6
    //   437: ifnull +215 -> 652
    //   440: aload 6
    //   442: bipush 47
    //   444: invokevirtual 232	java/lang/String:indexOf	(I)I
    //   447: istore_2
    //   448: iload_2
    //   449: iconst_m1
    //   450: if_icmpeq -22 -> 428
    //   453: aload 6
    //   455: iload_2
    //   456: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   459: invokevirtual 239	java/lang/String:trim	()Ljava/lang/String;
    //   462: astore 6
    //   464: getstatic 245	android/os/Build$VERSION:SDK_INT	I
    //   467: bipush 23
    //   469: if_icmpge +126 -> 595
    //   472: aload 6
    //   474: ldc 247
    //   476: invokevirtual 190	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   479: ifeq +1209 -> 1688
    //   482: aload 6
    //   484: ldc 249
    //   486: invokevirtual 252	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   489: ifeq +1196 -> 1685
    //   492: aload 6
    //   494: bipush 47
    //   496: invokevirtual 255	java/lang/String:lastIndexOf	(I)I
    //   499: istore_2
    //   500: iload_2
    //   501: iconst_m1
    //   502: if_icmpeq +1180 -> 1682
    //   505: aload 6
    //   507: iload_2
    //   508: aload 6
    //   510: invokevirtual 257	java/lang/String:length	()I
    //   513: bipush 12
    //   515: isub
    //   516: invokevirtual 260	java/lang/String:substring	(II)Ljava/lang/String;
    //   519: bipush 64
    //   521: bipush 47
    //   523: invokevirtual 264	java/lang/String:replace	(CC)Ljava/lang/String;
    //   526: astore 6
    //   528: aload 6
    //   530: ldc_w 266
    //   533: invokevirtual 190	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   536: ifeq +1143 -> 1679
    //   539: new 90	java/io/File
    //   542: dup
    //   543: aload 6
    //   545: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   548: astore 6
    //   550: ldc_w 268
    //   553: aload 6
    //   555: invokevirtual 271	java/io/File:getName	()Ljava/lang/String;
    //   558: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   561: ifeq +24 -> 585
    //   564: aload 6
    //   566: invokevirtual 154	java/io/File:getParentFile	()Ljava/io/File;
    //   569: ifnull +83 -> 652
    //   572: aload 6
    //   574: invokevirtual 154	java/io/File:getParentFile	()Ljava/io/File;
    //   577: invokevirtual 271	java/io/File:getName	()Ljava/lang/String;
    //   580: astore 6
    //   582: goto +118 -> 700
    //   585: aload 6
    //   587: invokevirtual 271	java/io/File:getName	()Ljava/lang/String;
    //   590: astore 6
    //   592: goto +108 -> 700
    //   595: aload 6
    //   597: ldc_w 266
    //   600: invokevirtual 190	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   603: ifeq +46 -> 649
    //   606: aload 6
    //   608: ldc_w 273
    //   611: invokevirtual 252	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   614: ifeq +32 -> 646
    //   617: aload 6
    //   619: ldc 180
    //   621: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   624: astore 6
    //   626: aload 6
    //   628: arraylength
    //   629: bipush 7
    //   631: if_icmplt +12 -> 643
    //   634: aload 6
    //   636: iconst_3
    //   637: aaload
    //   638: astore 6
    //   640: goto +60 -> 700
    //   643: goto -215 -> 428
    //   646: goto -218 -> 428
    //   649: goto -221 -> 428
    //   652: aconst_null
    //   653: astore 6
    //   655: goto +45 -> 700
    //   658: astore 9
    //   660: aload 8
    //   662: astore 6
    //   664: goto +20 -> 684
    //   667: astore 8
    //   669: goto +8 -> 677
    //   672: astore 8
    //   674: aconst_null
    //   675: astore 7
    //   677: aconst_null
    //   678: astore 6
    //   680: aload 8
    //   682: astore 9
    //   684: aload 9
    //   686: invokevirtual 281	java/lang/Throwable:printStackTrace	()V
    //   689: aconst_null
    //   690: astore 9
    //   692: aload 6
    //   694: astore 8
    //   696: aload 9
    //   698: astore 6
    //   700: aload 7
    //   702: invokestatic 284	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   705: aload 8
    //   707: invokestatic 284	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   710: aload 11
    //   712: invokevirtual 178	android/content/Context:getPackageName	()Ljava/lang/String;
    //   715: astore 7
    //   717: aload 6
    //   719: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifne +87 -> 809
    //   725: aload 6
    //   727: ldc_w 286
    //   730: invokevirtual 289	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   733: istore_2
    //   734: iload_2
    //   735: iconst_m1
    //   736: if_icmpeq +73 -> 809
    //   739: aload 6
    //   741: iconst_0
    //   742: iload_2
    //   743: invokevirtual 260	java/lang/String:substring	(II)Ljava/lang/String;
    //   746: astore 6
    //   748: aload 6
    //   750: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   753: ifne +56 -> 809
    //   756: new 90	java/io/File
    //   759: dup
    //   760: ldc 186
    //   762: aload 6
    //   764: invokestatic 293	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   767: invokevirtual 297	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   770: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   773: astore 8
    //   775: aload 8
    //   777: invokevirtual 116	java/io/File:exists	()Z
    //   780: ifeq +11 -> 791
    //   783: aload 8
    //   785: invokevirtual 300	java/io/File:canWrite	()Z
    //   788: ifne +7 -> 795
    //   791: aload 7
    //   793: astore 6
    //   795: aload 7
    //   797: aload 6
    //   799: invokestatic 303	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   802: iconst_1
    //   803: ixor
    //   804: istore 5
    //   806: goto +10 -> 816
    //   809: iconst_0
    //   810: istore 5
    //   812: aload 7
    //   814: astore 6
    //   816: iload 5
    //   818: ifeq +23 -> 841
    //   821: new 6	com/tencent/token/agt$a
    //   824: dup
    //   825: iload 5
    //   827: aload_0
    //   828: aload 6
    //   830: invokestatic 198	com/tencent/token/agt:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   833: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   836: astore 6
    //   838: goto +16 -> 854
    //   841: new 6	com/tencent/token/agt$a
    //   844: dup
    //   845: iload 5
    //   847: ldc 88
    //   849: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   852: astore 6
    //   854: iload_1
    //   855: aload 6
    //   857: getfield 201	com/tencent/token/agt$a:a	Z
    //   860: iconst_1
    //   861: invokestatic 207	com/tencent/token/agn:a	(IZI)I
    //   864: istore_1
    //   865: aload 6
    //   867: getfield 201	com/tencent/token/agt$a:a	Z
    //   870: ifeq +67 -> 937
    //   873: new 209	com/tencent/turingfd/sdk/qps/Damson
    //   876: dup
    //   877: invokespecial 210	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   880: astore 7
    //   882: new 60	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   889: astore 8
    //   891: aload 8
    //   893: getstatic 28	com/tencent/token/agt:a	Ljava/lang/String;
    //   896: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload 8
    //   902: getstatic 40	com/tencent/token/agt:d	Ljava/lang/String;
    //   905: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload 7
    //   911: aload 8
    //   913: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: putfield 211	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   919: aload 7
    //   921: aload 6
    //   923: getfield 202	com/tencent/token/agt$a:b	Ljava/lang/String;
    //   926: putfield 212	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   929: aload 10
    //   931: aload 7
    //   933: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   936: pop
    //   937: getstatic 245	android/os/Build$VERSION:SDK_INT	I
    //   940: bipush 17
    //   942: if_icmpge +18 -> 960
    //   945: new 6	com/tencent/token/agt$a
    //   948: dup
    //   949: iconst_0
    //   950: ldc 88
    //   952: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   955: astore 6
    //   957: goto +371 -> 1328
    //   960: new 60	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   967: astore 7
    //   969: getstatic 308	android/os/Build:BRAND	Ljava/lang/String;
    //   972: astore 6
    //   974: ldc_w 310
    //   977: aload 6
    //   979: invokevirtual 313	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   982: ifeq +147 -> 1129
    //   985: ldc_w 315
    //   988: invokestatic 321	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   991: astore 6
    //   993: aload_0
    //   994: invokevirtual 325	java/lang/Object:getClass	()Ljava/lang/Class;
    //   997: ldc_w 327
    //   1000: invokevirtual 331	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1003: astore 8
    //   1005: aload 8
    //   1007: iconst_1
    //   1008: invokevirtual 337	java/lang/reflect/Field:setAccessible	(Z)V
    //   1011: aload_0
    //   1012: aload 8
    //   1014: aload_0
    //   1015: invokevirtual 340	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1018: checkcast 48	java/lang/String
    //   1021: invokevirtual 344	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1024: astore 8
    //   1026: aload 8
    //   1028: ifnull +47 -> 1075
    //   1031: aload 6
    //   1033: ldc_w 346
    //   1036: iconst_0
    //   1037: anewarray 317	java/lang/Class
    //   1040: invokevirtual 350	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1043: astore 6
    //   1045: aload 6
    //   1047: ifnull +28 -> 1075
    //   1050: aload 6
    //   1052: iconst_1
    //   1053: invokevirtual 353	java/lang/reflect/Method:setAccessible	(Z)V
    //   1056: aload 6
    //   1058: aload 8
    //   1060: iconst_0
    //   1061: anewarray 4	java/lang/Object
    //   1064: invokevirtual 357	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1067: checkcast 48	java/lang/String
    //   1070: astore 6
    //   1072: goto +7 -> 1079
    //   1075: ldc 88
    //   1077: astore 6
    //   1079: new 48	java/lang/String
    //   1082: dup
    //   1083: ldc_w 359
    //   1086: iconst_0
    //   1087: invokestatic 365	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1090: invokespecial 368	java/lang/String:<init>	([B)V
    //   1093: astore 8
    //   1095: aload 6
    //   1097: invokestatic 112	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1100: ifne +209 -> 1309
    //   1103: aload 8
    //   1105: aload 6
    //   1107: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1110: istore 5
    //   1112: iload 5
    //   1114: ifeq +195 -> 1309
    //   1117: aload 7
    //   1119: ldc_w 370
    //   1122: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: goto +171 -> 1297
    //   1129: ldc_w 372
    //   1132: aload 6
    //   1134: invokevirtual 313	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1137: ifeq +24 -> 1161
    //   1140: invokestatic 374	com/tencent/token/agt:a	()Z
    //   1143: ifeq +166 -> 1309
    //   1146: aload 7
    //   1148: ldc_w 376
    //   1151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: pop
    //   1155: iconst_1
    //   1156: istore 5
    //   1158: goto +154 -> 1312
    //   1161: ldc_w 378
    //   1164: aload 6
    //   1166: invokevirtual 313	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1169: ifeq +24 -> 1193
    //   1172: invokestatic 374	com/tencent/token/agt:a	()Z
    //   1175: ifeq +134 -> 1309
    //   1178: aload 7
    //   1180: ldc_w 380
    //   1183: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: iconst_1
    //   1188: istore 5
    //   1190: goto +122 -> 1312
    //   1193: ldc_w 382
    //   1196: aload 6
    //   1198: invokevirtual 313	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1201: ifeq +108 -> 1309
    //   1204: invokestatic 374	com/tencent/token/agt:a	()Z
    //   1207: ifeq +18 -> 1225
    //   1210: aload 7
    //   1212: ldc_w 384
    //   1215: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: iconst_1
    //   1220: istore 5
    //   1222: goto +90 -> 1312
    //   1225: new 48	java/lang/String
    //   1228: dup
    //   1229: ldc_w 386
    //   1232: invokestatic 391	com/tencent/token/adg:b	(Ljava/lang/String;)[B
    //   1235: invokespecial 368	java/lang/String:<init>	([B)V
    //   1238: astore 6
    //   1240: new 60	java/lang/StringBuilder
    //   1243: dup
    //   1244: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1247: astore 8
    //   1249: aload 8
    //   1251: aload_0
    //   1252: invokevirtual 147	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1255: invokevirtual 178	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1258: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 8
    //   1264: ldc_w 393
    //   1267: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 6
    //   1273: aload 8
    //   1275: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokevirtual 396	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1281: istore 5
    //   1283: iload 5
    //   1285: ifeq +24 -> 1309
    //   1288: aload 7
    //   1290: ldc_w 398
    //   1293: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: iconst_1
    //   1298: istore 5
    //   1300: goto +12 -> 1312
    //   1303: iconst_0
    //   1304: istore 5
    //   1306: goto +6 -> 1312
    //   1309: iconst_0
    //   1310: istore 5
    //   1312: new 6	com/tencent/token/agt$a
    //   1315: dup
    //   1316: iload 5
    //   1318: aload 7
    //   1320: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1323: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   1326: astore 6
    //   1328: iload_1
    //   1329: aload 6
    //   1331: getfield 201	com/tencent/token/agt$a:a	Z
    //   1334: iconst_2
    //   1335: invokestatic 207	com/tencent/token/agn:a	(IZI)I
    //   1338: istore_2
    //   1339: aload 6
    //   1341: getfield 201	com/tencent/token/agt$a:a	Z
    //   1344: ifeq +67 -> 1411
    //   1347: new 209	com/tencent/turingfd/sdk/qps/Damson
    //   1350: dup
    //   1351: invokespecial 210	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   1354: astore 7
    //   1356: new 60	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1363: astore 8
    //   1365: aload 8
    //   1367: getstatic 28	com/tencent/token/agt:a	Ljava/lang/String;
    //   1370: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: aload 8
    //   1376: getstatic 44	com/tencent/token/agt:e	Ljava/lang/String;
    //   1379: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: pop
    //   1383: aload 7
    //   1385: aload 8
    //   1387: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: putfield 211	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   1393: aload 7
    //   1395: aload 6
    //   1397: getfield 202	com/tencent/token/agt$a:b	Ljava/lang/String;
    //   1400: putfield 212	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   1403: aload 10
    //   1405: aload 7
    //   1407: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1410: pop
    //   1411: new 400	android/util/SparseArray
    //   1414: dup
    //   1415: invokespecial 401	android/util/SparseArray:<init>	()V
    //   1418: pop
    //   1419: new 400	android/util/SparseArray
    //   1422: dup
    //   1423: invokespecial 401	android/util/SparseArray:<init>	()V
    //   1426: aload_0
    //   1427: sipush 206
    //   1430: invokestatic 406	com/tencent/turingfd/sdk/qps/TNative$aa:d	(Landroid/util/SparseArray;Landroid/content/Context;I)Landroid/util/SparseArray;
    //   1433: sipush 206
    //   1436: ldc 48
    //   1438: invokestatic 409	com/tencent/token/agn:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1441: checkcast 48	java/lang/String
    //   1444: astore 7
    //   1446: aload 7
    //   1448: astore_0
    //   1449: aload 7
    //   1451: ifnonnull +6 -> 1457
    //   1454: ldc 88
    //   1456: astore_0
    //   1457: aload_0
    //   1458: invokestatic 414	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1461: istore_1
    //   1462: goto +5 -> 1467
    //   1465: iconst_0
    //   1466: istore_1
    //   1467: iload_1
    //   1468: ifle +17 -> 1485
    //   1471: new 6	com/tencent/token/agt$a
    //   1474: dup
    //   1475: iconst_1
    //   1476: ldc 88
    //   1478: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   1481: astore_0
    //   1482: goto +14 -> 1496
    //   1485: new 6	com/tencent/token/agt$a
    //   1488: dup
    //   1489: iconst_0
    //   1490: ldc 88
    //   1492: invokespecial 157	com/tencent/token/agt$a:<init>	(ZLjava/lang/String;)V
    //   1495: astore_0
    //   1496: iload_2
    //   1497: aload_0
    //   1498: getfield 201	com/tencent/token/agt$a:a	Z
    //   1501: iconst_4
    //   1502: invokestatic 207	com/tencent/token/agn:a	(IZI)I
    //   1505: istore_1
    //   1506: aload_0
    //   1507: getfield 201	com/tencent/token/agt$a:a	Z
    //   1510: ifeq +63 -> 1573
    //   1513: new 209	com/tencent/turingfd/sdk/qps/Damson
    //   1516: dup
    //   1517: invokespecial 210	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   1520: astore_0
    //   1521: new 60	java/lang/StringBuilder
    //   1524: dup
    //   1525: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1528: astore 7
    //   1530: aload 7
    //   1532: getstatic 28	com/tencent/token/agt:a	Ljava/lang/String;
    //   1535: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: aload 7
    //   1541: ldc_w 416
    //   1544: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload_0
    //   1549: aload 7
    //   1551: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: putfield 211	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   1557: aload_0
    //   1558: aload 6
    //   1560: getfield 202	com/tencent/token/agt$a:b	Ljava/lang/String;
    //   1563: putfield 212	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   1566: aload 10
    //   1568: aload_0
    //   1569: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1572: pop
    //   1573: iload_1
    //   1574: ifle +62 -> 1636
    //   1577: new 209	com/tencent/turingfd/sdk/qps/Damson
    //   1580: dup
    //   1581: invokespecial 210	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   1584: astore_0
    //   1585: new 60	java/lang/StringBuilder
    //   1588: dup
    //   1589: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1592: astore 6
    //   1594: aload 6
    //   1596: getstatic 28	com/tencent/token/agt:a	Ljava/lang/String;
    //   1599: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload 6
    //   1605: getstatic 32	com/tencent/token/agt:b	Ljava/lang/String;
    //   1608: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: pop
    //   1612: aload_0
    //   1613: aload 6
    //   1615: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1618: putfield 211	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   1621: aload_0
    //   1622: iload_1
    //   1623: invokestatic 418	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1626: putfield 212	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   1629: aload 10
    //   1631: aload_0
    //   1632: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1635: pop
    //   1636: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   1639: lload_3
    //   1640: lsub
    //   1641: putstatic 46	com/tencent/token/agt:f	J
    //   1644: aload 10
    //   1646: areturn
    //   1647: astore_0
    //   1648: aload 7
    //   1650: invokestatic 284	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   1653: aload 6
    //   1655: invokestatic 284	com/tencent/token/agn:a	(Ljava/io/Closeable;)V
    //   1658: aload_0
    //   1659: athrow
    //   1660: astore 6
    //   1662: goto -587 -> 1075
    //   1665: astore 6
    //   1667: goto -364 -> 1303
    //   1670: astore 6
    //   1672: goto -375 -> 1297
    //   1675: astore_0
    //   1676: goto -211 -> 1465
    //   1679: goto -1251 -> 428
    //   1682: goto -1254 -> 428
    //   1685: goto -1257 -> 428
    //   1688: goto -1260 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1691	0	paramContext	android.content.Context
    //   82	1541	1	i	int
    //   80	1417	2	j	int
    //   3	1637	3	l	long
    //   110	1207	5	bool	boolean
    //   23	1631	6	localObject1	Object
    //   1660	1	6	localObject2	Object
    //   1665	1	6	localObject3	Object
    //   1670	1	6	localObject4	Object
    //   50	1599	7	localObject5	Object
    //   75	586	8	localObject6	Object
    //   667	1	8	localObject7	Object
    //   672	9	8	localObject8	Object
    //   694	692	8	localObject9	Object
    //   147	78	9	arrayOfString	String[]
    //   658	1	9	localObject10	Object
    //   682	15	9	localObject11	Object
    //   11	1634	10	localArrayList	java.util.ArrayList
    //   384	327	11	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   428	435	658	finally
    //   440	448	658	finally
    //   453	500	658	finally
    //   505	550	658	finally
    //   550	582	658	finally
    //   585	592	658	finally
    //   595	634	658	finally
    //   417	428	667	finally
    //   406	417	672	finally
    //   684	689	1647	finally
    //   985	1026	1660	finally
    //   1031	1045	1660	finally
    //   1050	1072	1660	finally
    //   1079	1112	1665	finally
    //   1225	1283	1665	finally
    //   1117	1126	1670	finally
    //   1288	1297	1670	finally
    //   1419	1446	1675	finally
    //   1457	1462	1675	finally
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
 * Qualified Name:     com.tencent.token.agt
 * JD-Core Version:    0.7.0.1
 */