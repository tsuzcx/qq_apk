package com.tencent.token;

import android.content.Context;

public final class afu
  extends adk
{
  public afu(afk paramafk, int paramInt, aet paramaet, Context paramContext, String paramString) {}
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: getstatic 35	com/tencent/token/afy:a	Lcom/tencent/token/agi;
    //   3: invokevirtual 40	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   6: checkcast 32	com/tencent/token/afy
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 18	com/tencent/token/afu:e	Lcom/tencent/token/afk;
    //   15: getfield 44	com/tencent/token/afk:e	Landroid/content/Context;
    //   18: astore 6
    //   20: aload_0
    //   21: getfield 20	com/tencent/token/afu:a	I
    //   24: istore_3
    //   25: aload 7
    //   27: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   30: pop
    //   31: new 52	java/util/LinkedHashMap
    //   34: dup
    //   35: invokespecial 53	java/util/LinkedHashMap:<init>	()V
    //   38: astore 11
    //   40: aload 6
    //   42: ldc 55
    //   44: iconst_0
    //   45: invokevirtual 61	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +222 -> 274
    //   55: new 63	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   62: astore 7
    //   64: aload 7
    //   66: aload 6
    //   68: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 7
    //   77: getstatic 77	java/io/File:separator	Ljava/lang/String;
    //   80: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 7
    //   86: ldc 79
    //   88: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: new 66	java/io/File
    //   95: dup
    //   96: aload 7
    //   98: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore 6
    //   106: aload 6
    //   108: invokevirtual 89	java/io/File:exists	()Z
    //   111: ifeq +163 -> 274
    //   114: aload 6
    //   116: invokevirtual 93	java/io/File:listFiles	()[Ljava/io/File;
    //   119: astore 6
    //   121: aload 6
    //   123: ifnull +151 -> 274
    //   126: aload 6
    //   128: new 95	com/tencent/token/afz
    //   131: dup
    //   132: invokespecial 96	com/tencent/token/afz:<init>	()V
    //   135: invokestatic 102	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   138: aload 6
    //   140: arraylength
    //   141: istore 4
    //   143: iconst_0
    //   144: istore_1
    //   145: iload_1
    //   146: iload 4
    //   148: if_icmpge +126 -> 274
    //   151: aload 6
    //   153: iload_1
    //   154: aaload
    //   155: astore 7
    //   157: aload 7
    //   159: invokevirtual 105	java/io/File:getName	()Ljava/lang/String;
    //   162: ldc 107
    //   164: invokevirtual 113	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   167: astore 8
    //   169: aload 8
    //   171: ifnull +3381 -> 3552
    //   174: aload 8
    //   176: arraylength
    //   177: iconst_2
    //   178: if_icmpeq +6 -> 184
    //   181: goto +3371 -> 3552
    //   184: aload 8
    //   186: iconst_0
    //   187: aaload
    //   188: invokestatic 119	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   191: invokevirtual 123	java/lang/Integer:intValue	()I
    //   194: sipush 1000
    //   197: idiv
    //   198: istore_2
    //   199: goto +3355 -> 3554
    //   202: aload 7
    //   204: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   207: invokestatic 128	com/tencent/token/adg:a	(Ljava/lang/String;)[B
    //   210: invokestatic 133	com/tencent/token/agn:b	()[B
    //   213: invokestatic 136	com/tencent/token/agn:b	([B[B)[B
    //   216: invokestatic 139	com/tencent/token/agn:b	([B)[B
    //   219: astore 8
    //   221: new 141	com/tencent/turingfd/sdk/qps/Codlin
    //   224: dup
    //   225: invokespecial 142	com/tencent/turingfd/sdk/qps/Codlin:<init>	()V
    //   228: astore 9
    //   230: aload 9
    //   232: new 144	com/tencent/token/agd
    //   235: dup
    //   236: aload 8
    //   238: invokespecial 147	com/tencent/token/agd:<init>	([B)V
    //   241: invokevirtual 150	com/tencent/turingfd/sdk/qps/Codlin:a	(Lcom/tencent/token/agd;)V
    //   244: aload 11
    //   246: aload 7
    //   248: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   251: aload 9
    //   253: invokeinterface 156 3 0
    //   258: pop
    //   259: goto +8 -> 267
    //   262: aload 7
    //   264: invokevirtual 159	java/io/File:deleteOnExit	()V
    //   267: iload_1
    //   268: iconst_1
    //   269: iadd
    //   270: istore_1
    //   271: goto -126 -> 145
    //   274: aload 11
    //   276: invokeinterface 162 1 0
    //   281: istore_1
    //   282: aconst_null
    //   283: astore 9
    //   285: aload 9
    //   287: astore 7
    //   289: iload_1
    //   290: ifeq +434 -> 724
    //   293: new 164	java/util/ArrayList
    //   296: dup
    //   297: invokespecial 165	java/util/ArrayList:<init>	()V
    //   300: astore 12
    //   302: aload 11
    //   304: invokevirtual 169	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   307: invokeinterface 175 1 0
    //   312: astore 13
    //   314: aconst_null
    //   315: astore 6
    //   317: aload 13
    //   319: invokeinterface 180 1 0
    //   324: ifeq +319 -> 643
    //   327: aload 13
    //   329: invokeinterface 183 1 0
    //   334: checkcast 109	java/lang/String
    //   337: astore 8
    //   339: aload 11
    //   341: aload 8
    //   343: invokevirtual 187	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   346: checkcast 141	com/tencent/turingfd/sdk/qps/Codlin
    //   349: astore 7
    //   351: aload 7
    //   353: ifnull -36 -> 317
    //   356: aload 7
    //   358: getfield 190	com/tencent/turingfd/sdk/qps/Codlin:p	I
    //   361: ifne -44 -> 317
    //   364: aload 12
    //   366: aload 8
    //   368: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload 6
    //   374: ifnonnull +10 -> 384
    //   377: aload 7
    //   379: astore 6
    //   381: goto -64 -> 317
    //   384: aload 6
    //   386: getfield 198	com/tencent/turingfd/sdk/qps/Codlin:l	Ljava/util/ArrayList;
    //   389: astore 8
    //   391: aload 8
    //   393: ifnull +114 -> 507
    //   396: aload 8
    //   398: invokevirtual 199	java/util/ArrayList:size	()I
    //   401: ifeq +106 -> 507
    //   404: aload 8
    //   406: invokevirtual 200	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   409: astore 8
    //   411: iconst_0
    //   412: istore_1
    //   413: iload_1
    //   414: istore_2
    //   415: aload 8
    //   417: invokeinterface 180 1 0
    //   422: ifeq +87 -> 509
    //   425: aload 8
    //   427: invokeinterface 183 1 0
    //   432: checkcast 202	com/tencent/turingfd/sdk/qps/Filbert
    //   435: getfield 204	com/tencent/turingfd/sdk/qps/Filbert:d	Ljava/util/ArrayList;
    //   438: astore 10
    //   440: aload 10
    //   442: ifnull -29 -> 413
    //   445: aload 10
    //   447: invokevirtual 200	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   450: astore 10
    //   452: iload_1
    //   453: istore_2
    //   454: iload_2
    //   455: istore_1
    //   456: aload 10
    //   458: invokeinterface 180 1 0
    //   463: ifeq -50 -> 413
    //   466: aload 10
    //   468: invokeinterface 183 1 0
    //   473: checkcast 206	com/tencent/turingfd/sdk/qps/Foxnut
    //   476: getfield 209	com/tencent/turingfd/sdk/qps/Foxnut:c	Ljava/util/Map;
    //   479: astore 14
    //   481: aload 14
    //   483: ifnull -29 -> 454
    //   486: aload 14
    //   488: iconst_0
    //   489: invokestatic 212	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: invokeinterface 215 2 0
    //   497: ifeq -43 -> 454
    //   500: iload_2
    //   501: iconst_1
    //   502: iadd
    //   503: istore_2
    //   504: goto -50 -> 454
    //   507: iconst_0
    //   508: istore_2
    //   509: iload_2
    //   510: bipush 120
    //   512: if_icmpge -195 -> 317
    //   515: aload 6
    //   517: getfield 198	com/tencent/turingfd/sdk/qps/Codlin:l	Ljava/util/ArrayList;
    //   520: aload 7
    //   522: getfield 198	com/tencent/turingfd/sdk/qps/Codlin:l	Ljava/util/ArrayList;
    //   525: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   528: pop
    //   529: aload 6
    //   531: getfield 223	com/tencent/turingfd/sdk/qps/Codlin:F	Lcom/tencent/turingfd/sdk/qps/Coconut;
    //   534: astore 8
    //   536: aload 7
    //   538: getfield 223	com/tencent/turingfd/sdk/qps/Codlin:F	Lcom/tencent/turingfd/sdk/qps/Coconut;
    //   541: astore 10
    //   543: aload 8
    //   545: astore 7
    //   547: aload 8
    //   549: ifnonnull +12 -> 561
    //   552: new 225	com/tencent/turingfd/sdk/qps/Coconut
    //   555: dup
    //   556: invokespecial 226	com/tencent/turingfd/sdk/qps/Coconut:<init>	()V
    //   559: astore 7
    //   561: aload 7
    //   563: getfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   566: ifnonnull +15 -> 581
    //   569: aload 7
    //   571: new 164	java/util/ArrayList
    //   574: dup
    //   575: invokespecial 165	java/util/ArrayList:<init>	()V
    //   578: putfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   581: aload 10
    //   583: astore 8
    //   585: aload 10
    //   587: ifnonnull +12 -> 599
    //   590: new 225	com/tencent/turingfd/sdk/qps/Coconut
    //   593: dup
    //   594: invokespecial 226	com/tencent/turingfd/sdk/qps/Coconut:<init>	()V
    //   597: astore 8
    //   599: aload 8
    //   601: getfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   604: ifnonnull +15 -> 619
    //   607: aload 8
    //   609: new 164	java/util/ArrayList
    //   612: dup
    //   613: invokespecial 165	java/util/ArrayList:<init>	()V
    //   616: putfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   619: aload 7
    //   621: getfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   624: aload 8
    //   626: getfield 228	com/tencent/turingfd/sdk/qps/Coconut:c	Ljava/util/ArrayList;
    //   629: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   632: pop
    //   633: aload 6
    //   635: aload 7
    //   637: putfield 223	com/tencent/turingfd/sdk/qps/Codlin:F	Lcom/tencent/turingfd/sdk/qps/Coconut;
    //   640: goto -323 -> 317
    //   643: aload 6
    //   645: ifnull +48 -> 693
    //   648: aload 6
    //   650: getfield 198	com/tencent/turingfd/sdk/qps/Codlin:l	Ljava/util/ArrayList;
    //   653: new 230	com/tencent/token/aga
    //   656: dup
    //   657: invokespecial 231	com/tencent/token/aga:<init>	()V
    //   660: invokestatic 236	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   663: new 238	com/tencent/token/afy$b
    //   666: dup
    //   667: invokespecial 239	com/tencent/token/afy$b:<init>	()V
    //   670: astore 7
    //   672: aload 7
    //   674: aload 6
    //   676: putfield 242	com/tencent/token/afy$b:a	Lcom/tencent/turingfd/sdk/qps/Codlin;
    //   679: aload 7
    //   681: aload 12
    //   683: putfield 245	com/tencent/token/afy$b:b	Ljava/util/List;
    //   686: aload 7
    //   688: astore 6
    //   690: goto +6 -> 696
    //   693: aconst_null
    //   694: astore 6
    //   696: aload 9
    //   698: astore 7
    //   700: aload 6
    //   702: ifnull +22 -> 724
    //   705: new 247	com/tencent/token/afh
    //   708: dup
    //   709: aload 6
    //   711: getfield 242	com/tencent/token/afy$b:a	Lcom/tencent/turingfd/sdk/qps/Codlin;
    //   714: aload 6
    //   716: getfield 245	com/tencent/token/afy$b:b	Ljava/util/List;
    //   719: invokespecial 250	com/tencent/token/afh:<init>	(Lcom/tencent/turingfd/sdk/qps/Codlin;Ljava/util/List;)V
    //   722: astore 7
    //   724: aload 7
    //   726: ifnonnull +15 -> 741
    //   729: aload_0
    //   730: getfield 22	com/tencent/token/afu:b	Lcom/tencent/token/aet;
    //   733: checkcast 252	com/tencent/token/aej
    //   736: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   739: pop
    //   740: return
    //   741: aload 7
    //   743: getfield 253	com/tencent/token/afh:a	Lcom/tencent/turingfd/sdk/qps/Codlin;
    //   746: astore 10
    //   748: aload_0
    //   749: getfield 18	com/tencent/token/afu:e	Lcom/tencent/token/afk;
    //   752: astore 6
    //   754: aload_0
    //   755: getfield 24	com/tencent/token/afu:c	Landroid/content/Context;
    //   758: astore 11
    //   760: aload_0
    //   761: getfield 26	com/tencent/token/afu:d	Ljava/lang/String;
    //   764: astore 8
    //   766: aload 6
    //   768: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   771: pop
    //   772: aload 10
    //   774: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   777: putfield 263	com/tencent/turingfd/sdk/qps/Codlin:j	J
    //   780: aload 10
    //   782: aload 8
    //   784: putfield 266	com/tencent/turingfd/sdk/qps/Codlin:k	Ljava/lang/String;
    //   787: aload 11
    //   789: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   792: astore 6
    //   794: aload 11
    //   796: invokevirtual 273	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   799: aload 6
    //   801: bipush 64
    //   803: invokevirtual 279	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   806: astore 6
    //   808: aload 6
    //   810: getfield 284	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   813: astore 8
    //   815: aload 6
    //   817: getfield 287	android/content/pm/PackageInfo:versionCode	I
    //   820: istore_1
    //   821: goto +5 -> 826
    //   824: iconst_0
    //   825: istore_1
    //   826: aload 10
    //   828: iload_1
    //   829: putfield 290	com/tencent/turingfd/sdk/qps/Codlin:m	I
    //   832: aload 10
    //   834: ldc_w 292
    //   837: putfield 295	com/tencent/turingfd/sdk/qps/Codlin:n	Ljava/lang/String;
    //   840: aload 10
    //   842: getstatic 298	com/tencent/token/agh:a	I
    //   845: putfield 301	com/tencent/turingfd/sdk/qps/Codlin:o	I
    //   848: aload 10
    //   850: iconst_0
    //   851: putfield 190	com/tencent/turingfd/sdk/qps/Codlin:p	I
    //   854: aload 11
    //   856: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   859: astore 8
    //   861: aload 8
    //   863: astore 6
    //   865: aload 8
    //   867: ifnonnull +8 -> 875
    //   870: ldc_w 303
    //   873: astore 6
    //   875: aload 10
    //   877: aload 6
    //   879: putfield 306	com/tencent/turingfd/sdk/qps/Codlin:q	Ljava/lang/String;
    //   882: ldc_w 303
    //   885: astore 8
    //   887: getstatic 309	com/tencent/token/afk:b	Lcom/tencent/token/agr;
    //   890: astore 6
    //   892: aload 6
    //   894: getfield 314	com/tencent/token/agr:b	Lcom/tencent/token/adp;
    //   897: astore 12
    //   899: aload 6
    //   901: getfield 317	com/tencent/token/agr:a	Lcom/tencent/token/agk;
    //   904: astore 6
    //   906: aload 6
    //   908: ifnull +240 -> 1148
    //   911: aload 6
    //   913: checkcast 319	com/tencent/token/afx$b
    //   916: getfield 322	com/tencent/token/afx$b:a	Lcom/tencent/token/adq;
    //   919: invokeinterface 326 1 0
    //   924: ifeq +69 -> 993
    //   927: aload 12
    //   929: ifnonnull +34 -> 963
    //   932: aload 11
    //   934: invokestatic 331	com/tencent/token/adf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   937: astore 9
    //   939: aload 9
    //   941: astore 6
    //   943: aload 9
    //   945: ifnonnull +8 -> 953
    //   948: ldc_w 303
    //   951: astore 6
    //   953: aload 10
    //   955: aload 6
    //   957: putfield 334	com/tencent/turingfd/sdk/qps/Codlin:r	Ljava/lang/String;
    //   960: goto +33 -> 993
    //   963: aload 12
    //   965: invokeinterface 338 1 0
    //   970: astore 9
    //   972: aload 9
    //   974: astore 6
    //   976: aload 9
    //   978: ifnonnull +8 -> 986
    //   981: ldc_w 303
    //   984: astore 6
    //   986: aload 10
    //   988: aload 6
    //   990: putfield 334	com/tencent/turingfd/sdk/qps/Codlin:r	Ljava/lang/String;
    //   993: getstatic 309	com/tencent/token/afk:b	Lcom/tencent/token/agr;
    //   996: getfield 317	com/tencent/token/agr:a	Lcom/tencent/token/agk;
    //   999: checkcast 319	com/tencent/token/afx$b
    //   1002: getfield 322	com/tencent/token/afx$b:a	Lcom/tencent/token/adq;
    //   1005: invokeinterface 326 1 0
    //   1010: ifeq +69 -> 1079
    //   1013: aload 12
    //   1015: ifnonnull +34 -> 1049
    //   1018: aload 11
    //   1020: invokestatic 340	com/tencent/token/adf:b	(Landroid/content/Context;)Ljava/lang/String;
    //   1023: astore 9
    //   1025: aload 9
    //   1027: astore 6
    //   1029: aload 9
    //   1031: ifnonnull +8 -> 1039
    //   1034: ldc_w 303
    //   1037: astore 6
    //   1039: aload 10
    //   1041: aload 6
    //   1043: putfield 343	com/tencent/turingfd/sdk/qps/Codlin:s	Ljava/lang/String;
    //   1046: goto +33 -> 1079
    //   1049: aload 12
    //   1051: invokeinterface 345 1 0
    //   1056: astore 9
    //   1058: aload 9
    //   1060: astore 6
    //   1062: aload 9
    //   1064: ifnonnull +8 -> 1072
    //   1067: ldc_w 303
    //   1070: astore 6
    //   1072: aload 10
    //   1074: aload 6
    //   1076: putfield 343	com/tencent/turingfd/sdk/qps/Codlin:s	Ljava/lang/String;
    //   1079: aload 8
    //   1081: astore 6
    //   1083: getstatic 309	com/tencent/token/afk:b	Lcom/tencent/token/agr;
    //   1086: getfield 317	com/tencent/token/agr:a	Lcom/tencent/token/agk;
    //   1089: checkcast 319	com/tencent/token/afx$b
    //   1092: getfield 322	com/tencent/token/afx$b:a	Lcom/tencent/token/adq;
    //   1095: invokeinterface 326 1 0
    //   1100: ifeq +125 -> 1225
    //   1103: aload 12
    //   1105: ifnonnull +22 -> 1127
    //   1108: aload 11
    //   1110: invokestatic 347	com/tencent/token/adf:c	(Landroid/content/Context;)Ljava/lang/String;
    //   1113: astore 8
    //   1115: aload 8
    //   1117: astore 6
    //   1119: aload 8
    //   1121: ifnonnull +104 -> 1225
    //   1124: goto +96 -> 1220
    //   1127: aload 12
    //   1129: invokeinterface 349 1 0
    //   1134: astore 8
    //   1136: aload 8
    //   1138: astore 6
    //   1140: aload 8
    //   1142: ifnonnull +83 -> 1225
    //   1145: goto +75 -> 1220
    //   1148: aload 11
    //   1150: invokestatic 331	com/tencent/token/adf:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1153: astore 8
    //   1155: aload 8
    //   1157: astore 6
    //   1159: aload 8
    //   1161: ifnonnull +8 -> 1169
    //   1164: ldc_w 303
    //   1167: astore 6
    //   1169: aload 10
    //   1171: aload 6
    //   1173: putfield 334	com/tencent/turingfd/sdk/qps/Codlin:r	Ljava/lang/String;
    //   1176: aload 11
    //   1178: invokestatic 340	com/tencent/token/adf:b	(Landroid/content/Context;)Ljava/lang/String;
    //   1181: astore 8
    //   1183: aload 8
    //   1185: astore 6
    //   1187: aload 8
    //   1189: ifnonnull +8 -> 1197
    //   1192: ldc_w 303
    //   1195: astore 6
    //   1197: aload 10
    //   1199: aload 6
    //   1201: putfield 343	com/tencent/turingfd/sdk/qps/Codlin:s	Ljava/lang/String;
    //   1204: aload 11
    //   1206: invokestatic 347	com/tencent/token/adf:c	(Landroid/content/Context;)Ljava/lang/String;
    //   1209: astore 8
    //   1211: aload 8
    //   1213: astore 6
    //   1215: aload 8
    //   1217: ifnonnull +8 -> 1225
    //   1220: ldc_w 303
    //   1223: astore 6
    //   1225: getstatic 354	android/os/Build:BRAND	Ljava/lang/String;
    //   1228: astore 9
    //   1230: aload 9
    //   1232: astore 8
    //   1234: aload 9
    //   1236: ifnonnull +8 -> 1244
    //   1239: ldc_w 303
    //   1242: astore 8
    //   1244: aload 10
    //   1246: aload 8
    //   1248: putfield 357	com/tencent/turingfd/sdk/qps/Codlin:t	Ljava/lang/String;
    //   1251: aload 12
    //   1253: ifnonnull +32 -> 1285
    //   1256: getstatic 360	android/os/Build:MODEL	Ljava/lang/String;
    //   1259: astore 9
    //   1261: aload 9
    //   1263: astore 8
    //   1265: aload 9
    //   1267: ifnonnull +8 -> 1275
    //   1270: ldc_w 303
    //   1273: astore 8
    //   1275: aload 10
    //   1277: aload 8
    //   1279: putfield 363	com/tencent/turingfd/sdk/qps/Codlin:u	Ljava/lang/String;
    //   1282: goto +33 -> 1315
    //   1285: aload 12
    //   1287: invokeinterface 365 1 0
    //   1292: astore 9
    //   1294: aload 9
    //   1296: astore 8
    //   1298: aload 9
    //   1300: ifnonnull +8 -> 1308
    //   1303: ldc_w 303
    //   1306: astore 8
    //   1308: aload 10
    //   1310: aload 8
    //   1312: putfield 343	com/tencent/turingfd/sdk/qps/Codlin:s	Ljava/lang/String;
    //   1315: getstatic 368	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   1318: astore 9
    //   1320: aload 9
    //   1322: astore 8
    //   1324: aload 9
    //   1326: ifnonnull +8 -> 1334
    //   1329: ldc_w 303
    //   1332: astore 8
    //   1334: aload 10
    //   1336: aload 8
    //   1338: putfield 371	com/tencent/turingfd/sdk/qps/Codlin:v	Ljava/lang/String;
    //   1341: aload 10
    //   1343: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   1346: putfield 379	com/tencent/turingfd/sdk/qps/Codlin:x	I
    //   1349: aload 10
    //   1351: iconst_2
    //   1352: putfield 382	com/tencent/turingfd/sdk/qps/Codlin:z	I
    //   1355: getstatic 384	com/tencent/token/afk:c	I
    //   1358: istore_1
    //   1359: iconst_1
    //   1360: istore 4
    //   1362: iload_1
    //   1363: iconst_m1
    //   1364: if_icmpne +73 -> 1437
    //   1367: aload 11
    //   1369: ldc_w 386
    //   1372: invokevirtual 390	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1375: checkcast 392	android/hardware/SensorManager
    //   1378: astore 8
    //   1380: aload 8
    //   1382: ifnull +55 -> 1437
    //   1385: iconst_0
    //   1386: istore_1
    //   1387: iconst_1
    //   1388: istore_2
    //   1389: getstatic 395	com/tencent/token/afk:d	[I
    //   1392: astore 9
    //   1394: iload_1
    //   1395: aload 9
    //   1397: arraylength
    //   1398: if_icmpge +35 -> 1433
    //   1401: aload 8
    //   1403: aload 9
    //   1405: iload_1
    //   1406: iaload
    //   1407: invokevirtual 399	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1410: ifnonnull +8 -> 1418
    //   1413: iconst_0
    //   1414: istore_3
    //   1415: goto +5 -> 1420
    //   1418: iconst_1
    //   1419: istore_3
    //   1420: iload_2
    //   1421: iload_3
    //   1422: iload_1
    //   1423: ishl
    //   1424: ior
    //   1425: istore_2
    //   1426: iload_1
    //   1427: iconst_1
    //   1428: iadd
    //   1429: istore_1
    //   1430: goto -41 -> 1389
    //   1433: iload_2
    //   1434: putstatic 384	com/tencent/token/afk:c	I
    //   1437: aload 10
    //   1439: getstatic 384	com/tencent/token/afk:c	I
    //   1442: putfield 402	com/tencent/turingfd/sdk/qps/Codlin:w	I
    //   1445: new 63	java/lang/StringBuilder
    //   1448: dup
    //   1449: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1452: astore 12
    //   1454: iconst_1
    //   1455: invokestatic 405	com/tencent/token/adf:a	(Z)Ljava/lang/String;
    //   1458: astore 9
    //   1460: aload 9
    //   1462: astore 8
    //   1464: aload 9
    //   1466: ifnonnull +8 -> 1474
    //   1469: ldc_w 303
    //   1472: astore 8
    //   1474: aload 12
    //   1476: aload 8
    //   1478: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: aload 12
    //   1484: ldc 107
    //   1486: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: iconst_0
    //   1491: invokestatic 405	com/tencent/token/adf:a	(Z)Ljava/lang/String;
    //   1494: astore 9
    //   1496: aload 9
    //   1498: astore 8
    //   1500: aload 9
    //   1502: ifnonnull +8 -> 1510
    //   1505: ldc_w 303
    //   1508: astore 8
    //   1510: aload 12
    //   1512: aload 8
    //   1514: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: pop
    //   1518: aload 12
    //   1520: ldc 107
    //   1522: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 12
    //   1528: aload 6
    //   1530: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload 10
    //   1536: aload 12
    //   1538: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1541: putfield 408	com/tencent/turingfd/sdk/qps/Codlin:B	Ljava/lang/String;
    //   1544: aload 10
    //   1546: bipush 61
    //   1548: putfield 411	com/tencent/turingfd/sdk/qps/Codlin:C	I
    //   1551: ldc_w 413
    //   1554: monitorenter
    //   1555: getstatic 416	com/tencent/token/adv:b	Lcom/tencent/turingfd/sdk/qps/Date;
    //   1558: ifnonnull +8 -> 1566
    //   1561: aload 11
    //   1563: invokestatic 419	com/tencent/token/adv:a	(Landroid/content/Context;)V
    //   1566: getstatic 416	com/tencent/token/adv:b	Lcom/tencent/turingfd/sdk/qps/Date;
    //   1569: astore 6
    //   1571: ldc_w 413
    //   1574: monitorexit
    //   1575: aload 10
    //   1577: aload 6
    //   1579: putfield 422	com/tencent/turingfd/sdk/qps/Codlin:E	Lcom/tencent/turingfd/sdk/qps/Date;
    //   1582: ldc_w 413
    //   1585: monitorenter
    //   1586: getstatic 423	com/tencent/token/adv:a	I
    //   1589: ifne +8 -> 1597
    //   1592: aload 11
    //   1594: invokestatic 419	com/tencent/token/adv:a	(Landroid/content/Context;)V
    //   1597: getstatic 423	com/tencent/token/adv:a	I
    //   1600: istore_1
    //   1601: ldc_w 413
    //   1604: monitorexit
    //   1605: aload 10
    //   1607: iload_1
    //   1608: putfield 426	com/tencent/turingfd/sdk/qps/Codlin:G	I
    //   1611: aload 10
    //   1613: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   1616: ifnonnull +15 -> 1631
    //   1619: aload 10
    //   1621: new 164	java/util/ArrayList
    //   1624: dup
    //   1625: invokespecial 165	java/util/ArrayList:<init>	()V
    //   1628: putfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   1631: aload 10
    //   1633: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   1636: aload 11
    //   1638: invokestatic 434	com/tencent/token/agq:a	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   1641: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1644: pop
    //   1645: aload 10
    //   1647: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   1650: astore 6
    //   1652: new 164	java/util/ArrayList
    //   1655: dup
    //   1656: invokespecial 165	java/util/ArrayList:<init>	()V
    //   1659: astore 8
    //   1661: new 164	java/util/ArrayList
    //   1664: dup
    //   1665: invokespecial 165	java/util/ArrayList:<init>	()V
    //   1668: astore 9
    //   1670: aload 11
    //   1672: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1675: astore 12
    //   1677: aload 12
    //   1679: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1682: ifne +140 -> 1822
    //   1685: getstatic 442	com/tencent/token/agq:b	Ljava/util/Map;
    //   1688: aload 12
    //   1690: invokeinterface 443 2 0
    //   1695: astore 13
    //   1697: aload 13
    //   1699: ifnull +123 -> 1822
    //   1702: aload 13
    //   1704: checkcast 115	java/lang/Integer
    //   1707: invokevirtual 123	java/lang/Integer:intValue	()I
    //   1710: getstatic 298	com/tencent/token/agh:a	I
    //   1713: if_icmpeq +109 -> 1822
    //   1716: aload 11
    //   1718: aload 12
    //   1720: invokestatic 448	com/tencent/token/adj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1723: astore 13
    //   1725: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   1728: dup
    //   1729: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   1732: astore 14
    //   1734: new 63	java/lang/StringBuilder
    //   1737: dup
    //   1738: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1741: astore 15
    //   1743: aload 15
    //   1745: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   1748: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: aload 15
    //   1754: getstatic 456	com/tencent/token/ago:d	Ljava/lang/String;
    //   1757: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: pop
    //   1761: aload 14
    //   1763: aload 15
    //   1765: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   1771: new 63	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1778: astore 15
    //   1780: aload 15
    //   1782: aload 12
    //   1784: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: aload 15
    //   1790: ldc 107
    //   1792: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1795: pop
    //   1796: aload 15
    //   1798: aload 13
    //   1800: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: pop
    //   1804: aload 14
    //   1806: aload 15
    //   1808: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1811: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   1814: aload 9
    //   1816: aload 14
    //   1818: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1821: pop
    //   1822: aload 8
    //   1824: aload 9
    //   1826: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1829: pop
    //   1830: new 164	java/util/ArrayList
    //   1833: dup
    //   1834: invokespecial 165	java/util/ArrayList:<init>	()V
    //   1837: astore 9
    //   1839: aload 11
    //   1841: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1844: astore 12
    //   1846: aload 12
    //   1848: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1851: ifne +195 -> 2046
    //   1854: getstatic 462	com/tencent/token/agq:a	Ljava/util/Map;
    //   1857: aload 12
    //   1859: invokeinterface 443 2 0
    //   1864: checkcast 171	java/util/Set
    //   1867: astore 14
    //   1869: aload 14
    //   1871: ifnull +175 -> 2046
    //   1874: aload 14
    //   1876: invokeinterface 463 1 0
    //   1881: ifeq +165 -> 2046
    //   1884: aload 11
    //   1886: aload 12
    //   1888: invokestatic 448	com/tencent/token/adj:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1891: astore 13
    //   1893: aload 13
    //   1895: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1898: ifne +148 -> 2046
    //   1901: aload 14
    //   1903: invokeinterface 175 1 0
    //   1908: astore 14
    //   1910: aload 14
    //   1912: invokeinterface 180 1 0
    //   1917: ifeq +26 -> 1943
    //   1920: aload 14
    //   1922: invokeinterface 183 1 0
    //   1927: checkcast 109	java/lang/String
    //   1930: aload 13
    //   1932: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1935: ifeq -25 -> 1910
    //   1938: iconst_1
    //   1939: istore_1
    //   1940: goto +5 -> 1945
    //   1943: iconst_0
    //   1944: istore_1
    //   1945: iload_1
    //   1946: ifne +100 -> 2046
    //   1949: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   1952: dup
    //   1953: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   1956: astore 14
    //   1958: new 63	java/lang/StringBuilder
    //   1961: dup
    //   1962: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1965: astore 15
    //   1967: aload 15
    //   1969: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   1972: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: pop
    //   1976: aload 15
    //   1978: getstatic 456	com/tencent/token/ago:d	Ljava/lang/String;
    //   1981: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload 14
    //   1987: aload 15
    //   1989: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   1995: new 63	java/lang/StringBuilder
    //   1998: dup
    //   1999: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2002: astore 15
    //   2004: aload 15
    //   2006: aload 12
    //   2008: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: pop
    //   2012: aload 15
    //   2014: ldc 107
    //   2016: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: pop
    //   2020: aload 15
    //   2022: aload 13
    //   2024: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: pop
    //   2028: aload 14
    //   2030: aload 15
    //   2032: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2035: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2038: aload 9
    //   2040: aload 14
    //   2042: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2045: pop
    //   2046: aload 8
    //   2048: aload 9
    //   2050: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2053: pop
    //   2054: aload 6
    //   2056: aload 8
    //   2058: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2061: pop
    //   2062: aload 10
    //   2064: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2067: aload 11
    //   2069: invokestatic 469	com/tencent/token/agt:a	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   2072: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2075: pop
    //   2076: aload 10
    //   2078: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2081: astore 9
    //   2083: getstatic 473	com/tencent/token/agj:a	Ljava/util/ArrayList;
    //   2086: astore 8
    //   2088: aload 8
    //   2090: astore 6
    //   2092: aload 8
    //   2094: ifnonnull +10 -> 2104
    //   2097: aload 11
    //   2099: invokestatic 474	com/tencent/token/agj:a	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   2102: astore 6
    //   2104: aload 9
    //   2106: aload 6
    //   2108: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2111: pop
    //   2112: aload 10
    //   2114: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2117: astore 6
    //   2119: new 164	java/util/ArrayList
    //   2122: dup
    //   2123: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2126: astore 8
    //   2128: aload 11
    //   2130: invokestatic 476	com/tencent/token/agn:d	(Landroid/content/Context;)Ljava/lang/String;
    //   2133: astore 9
    //   2135: aload 9
    //   2137: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2140: ifne +64 -> 2204
    //   2143: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2146: dup
    //   2147: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2150: astore 12
    //   2152: new 63	java/lang/StringBuilder
    //   2155: dup
    //   2156: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2159: astore 13
    //   2161: aload 13
    //   2163: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   2166: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2169: pop
    //   2170: aload 13
    //   2172: getstatic 479	com/tencent/token/ago:f	Ljava/lang/String;
    //   2175: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: pop
    //   2179: aload 12
    //   2181: aload 13
    //   2183: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2186: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   2189: aload 12
    //   2191: aload 9
    //   2193: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2196: aload 8
    //   2198: aload 12
    //   2200: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2203: pop
    //   2204: aload 6
    //   2206: aload 8
    //   2208: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2211: pop
    //   2212: aload 10
    //   2214: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2217: invokestatic 484	com/tencent/token/agm:a	()Ljava/util/List;
    //   2220: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2223: pop
    //   2224: aload 10
    //   2226: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2229: astore 6
    //   2231: new 164	java/util/ArrayList
    //   2234: dup
    //   2235: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2238: astore 8
    //   2240: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   2243: bipush 14
    //   2245: if_icmplt +266 -> 2511
    //   2248: new 486	java/util/HashSet
    //   2251: dup
    //   2252: invokespecial 487	java/util/HashSet:<init>	()V
    //   2255: astore 9
    //   2257: aload 11
    //   2259: ldc_w 489
    //   2262: invokevirtual 390	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2265: checkcast 491	android/view/accessibility/AccessibilityManager
    //   2268: iconst_m1
    //   2269: invokevirtual 495	android/view/accessibility/AccessibilityManager:getEnabledAccessibilityServiceList	(I)Ljava/util/List;
    //   2272: astore 12
    //   2274: aload 12
    //   2276: invokeinterface 498 1 0
    //   2281: astore 12
    //   2283: iconst_0
    //   2284: istore_1
    //   2285: aload 12
    //   2287: invokeinterface 180 1 0
    //   2292: ifeq +79 -> 2371
    //   2295: aload 12
    //   2297: invokeinterface 183 1 0
    //   2302: checkcast 500	android/accessibilityservice/AccessibilityServiceInfo
    //   2305: astore 13
    //   2307: aload 13
    //   2309: invokevirtual 503	android/accessibilityservice/AccessibilityServiceInfo:getId	()Ljava/lang/String;
    //   2312: invokevirtual 506	java/lang/String:getBytes	()[B
    //   2315: invokestatic 509	com/tencent/token/agn:c	([B)Ljava/lang/String;
    //   2318: invokevirtual 512	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   2321: astore 14
    //   2323: getstatic 516	com/tencent/token/agb:b	Lcom/tencent/token/agi;
    //   2326: invokevirtual 40	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   2329: checkcast 514	com/tencent/token/agb
    //   2332: getfield 519	com/tencent/token/agb:c	Ljava/util/Set;
    //   2335: aload 14
    //   2337: invokeinterface 522 2 0
    //   2342: ifne -57 -> 2285
    //   2345: aload 9
    //   2347: aload 13
    //   2349: invokevirtual 503	android/accessibilityservice/AccessibilityServiceInfo:getId	()Ljava/lang/String;
    //   2352: invokevirtual 523	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   2355: pop
    //   2356: iload_1
    //   2357: iconst_5
    //   2358: if_icmplt +6 -> 2364
    //   2361: goto +10 -> 2371
    //   2364: iload_1
    //   2365: iconst_1
    //   2366: iadd
    //   2367: istore_1
    //   2368: goto -83 -> 2285
    //   2371: new 63	java/lang/StringBuilder
    //   2374: dup
    //   2375: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2378: astore 12
    //   2380: aload 9
    //   2382: invokevirtual 524	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   2385: astore 9
    //   2387: aload 9
    //   2389: invokeinterface 180 1 0
    //   2394: ifeq +30 -> 2424
    //   2397: aload 12
    //   2399: aload 9
    //   2401: invokeinterface 183 1 0
    //   2406: checkcast 109	java/lang/String
    //   2409: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: pop
    //   2413: aload 12
    //   2415: ldc 107
    //   2417: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: pop
    //   2421: goto -34 -> 2387
    //   2424: aload 12
    //   2426: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2429: astore 9
    //   2431: aload 9
    //   2433: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2436: ifne +75 -> 2511
    //   2439: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2442: dup
    //   2443: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2446: astore 12
    //   2448: new 63	java/lang/StringBuilder
    //   2451: dup
    //   2452: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2455: astore 13
    //   2457: aload 13
    //   2459: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   2462: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: pop
    //   2466: aload 13
    //   2468: getstatic 526	com/tencent/token/ago:j	Ljava/lang/String;
    //   2471: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2474: pop
    //   2475: aload 12
    //   2477: aload 13
    //   2479: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2482: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   2485: aload 12
    //   2487: aload 9
    //   2489: iconst_0
    //   2490: aload 9
    //   2492: invokevirtual 529	java/lang/String:length	()I
    //   2495: iconst_1
    //   2496: isub
    //   2497: invokevirtual 533	java/lang/String:substring	(II)Ljava/lang/String;
    //   2500: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2503: aload 8
    //   2505: aload 12
    //   2507: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2510: pop
    //   2511: aload 6
    //   2513: aload 8
    //   2515: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2518: pop
    //   2519: aload 10
    //   2521: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2524: astore 6
    //   2526: new 164	java/util/ArrayList
    //   2529: dup
    //   2530: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2533: astore 8
    //   2535: aload 11
    //   2537: invokevirtual 537	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2540: ldc_w 539
    //   2543: iconst_0
    //   2544: invokestatic 545	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   2547: ifeq +9 -> 2556
    //   2550: iload 4
    //   2552: istore_1
    //   2553: goto +5 -> 2558
    //   2556: iconst_0
    //   2557: istore_1
    //   2558: iload_1
    //   2559: ifeq +65 -> 2624
    //   2562: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2565: dup
    //   2566: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2569: astore 9
    //   2571: new 63	java/lang/StringBuilder
    //   2574: dup
    //   2575: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2578: astore 12
    //   2580: aload 12
    //   2582: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   2585: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2588: pop
    //   2589: aload 12
    //   2591: getstatic 546	com/tencent/token/ago:k	Ljava/lang/String;
    //   2594: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: pop
    //   2598: aload 9
    //   2600: aload 12
    //   2602: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2605: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   2608: aload 9
    //   2610: ldc_w 548
    //   2613: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2616: aload 8
    //   2618: aload 9
    //   2620: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2623: pop
    //   2624: aload 6
    //   2626: aload 8
    //   2628: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2631: pop
    //   2632: aload 10
    //   2634: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2637: astore 6
    //   2639: new 164	java/util/ArrayList
    //   2642: dup
    //   2643: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2646: astore 8
    //   2648: aload 11
    //   2650: invokestatic 553	com/tencent/token/agf:a	(Landroid/content/Context;)I
    //   2653: istore_1
    //   2654: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2657: dup
    //   2658: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2661: astore 9
    //   2663: new 63	java/lang/StringBuilder
    //   2666: dup
    //   2667: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2670: astore 13
    //   2672: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   2675: astore 12
    //   2677: aload 13
    //   2679: aload 12
    //   2681: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2684: pop
    //   2685: aload 13
    //   2687: getstatic 555	com/tencent/token/ago:m	Ljava/lang/String;
    //   2690: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: pop
    //   2694: aload 9
    //   2696: aload 13
    //   2698: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2701: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   2704: aload 9
    //   2706: iload_1
    //   2707: invokestatic 558	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2710: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2713: aload 8
    //   2715: aload 9
    //   2717: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2720: pop
    //   2721: aload 6
    //   2723: aload 8
    //   2725: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2728: pop
    //   2729: aload 10
    //   2731: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2734: astore 6
    //   2736: getstatic 561	com/tencent/token/adc:a	Lcom/tencent/token/agi;
    //   2739: invokevirtual 40	com/tencent/token/agi:b	()Ljava/lang/Object;
    //   2742: checkcast 560	com/tencent/token/adc
    //   2745: astore 13
    //   2747: aload 13
    //   2749: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2752: pop
    //   2753: new 164	java/util/ArrayList
    //   2756: dup
    //   2757: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2760: astore 8
    //   2762: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2765: dup
    //   2766: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2769: astore 9
    //   2771: new 63	java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2778: astore 14
    //   2780: aload 14
    //   2782: aload 12
    //   2784: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2787: pop
    //   2788: aload 14
    //   2790: ldc_w 563
    //   2793: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: pop
    //   2797: aload 9
    //   2799: aload 14
    //   2801: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2804: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   2807: new 63	java/lang/StringBuilder
    //   2810: dup
    //   2811: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2814: astore 12
    //   2816: aload 13
    //   2818: getfield 566	com/tencent/token/adc:b	Ljava/lang/Object;
    //   2821: astore 13
    //   2823: aload 13
    //   2825: monitorenter
    //   2826: aload 11
    //   2828: invokestatic 567	com/tencent/token/adc:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2831: astore 14
    //   2833: aload 14
    //   2835: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2838: ifne +22 -> 2860
    //   2841: new 109	java/lang/String
    //   2844: dup
    //   2845: aload 14
    //   2847: invokestatic 128	com/tencent/token/adg:a	(Ljava/lang/String;)[B
    //   2850: invokespecial 568	java/lang/String:<init>	([B)V
    //   2853: invokestatic 572	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2856: istore_1
    //   2857: goto +5 -> 2862
    //   2860: iconst_0
    //   2861: istore_1
    //   2862: aload 11
    //   2864: invokestatic 567	com/tencent/token/adc:a	(Landroid/content/Context;)Ljava/lang/String;
    //   2867: astore 14
    //   2869: aload 14
    //   2871: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2874: ifne +15 -> 2889
    //   2877: aload 14
    //   2879: ldc_w 574
    //   2882: invokevirtual 506	java/lang/String:getBytes	()[B
    //   2885: invokestatic 577	com/tencent/token/adg:a	(Ljava/lang/String;[B)Z
    //   2888: pop
    //   2889: aload 13
    //   2891: monitorexit
    //   2892: aload 12
    //   2894: iload_1
    //   2895: invokevirtual 580	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2898: pop
    //   2899: aload 9
    //   2901: aload 12
    //   2903: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2906: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   2909: aload 8
    //   2911: aload 9
    //   2913: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2916: pop
    //   2917: aload 6
    //   2919: aload 8
    //   2921: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   2924: pop
    //   2925: getstatic 309	com/tencent/token/afk:b	Lcom/tencent/token/agr;
    //   2928: getfield 317	com/tencent/token/agr:a	Lcom/tencent/token/agk;
    //   2931: astore 6
    //   2933: aload 6
    //   2935: ifnull +218 -> 3153
    //   2938: aload 6
    //   2940: checkcast 319	com/tencent/token/afx$b
    //   2943: getfield 322	com/tencent/token/afx$b:a	Lcom/tencent/token/adq;
    //   2946: invokeinterface 326 1 0
    //   2951: ifeq +202 -> 3153
    //   2954: aload 10
    //   2956: getfield 429	com/tencent/turingfd/sdk/qps/Codlin:H	Ljava/util/ArrayList;
    //   2959: astore 8
    //   2961: new 164	java/util/ArrayList
    //   2964: dup
    //   2965: invokespecial 165	java/util/ArrayList:<init>	()V
    //   2968: astore 9
    //   2970: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   2973: dup
    //   2974: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   2977: astore 13
    //   2979: new 63	java/lang/StringBuilder
    //   2982: dup
    //   2983: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2986: astore 6
    //   2988: getstatic 455	com/tencent/token/ago:c	Ljava/lang/String;
    //   2991: astore 12
    //   2993: aload 6
    //   2995: aload 12
    //   2997: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3000: pop
    //   3001: aload 6
    //   3003: ldc_w 582
    //   3006: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3009: pop
    //   3010: aload 13
    //   3012: aload 6
    //   3014: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3017: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   3020: invokestatic 584	com/tencent/token/agn:c	()Z
    //   3023: ifeq +11 -> 3034
    //   3026: ldc_w 548
    //   3029: astore 6
    //   3031: goto +8 -> 3039
    //   3034: ldc_w 574
    //   3037: astore 6
    //   3039: aload 13
    //   3041: aload 6
    //   3043: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   3046: aload 9
    //   3048: aload 13
    //   3050: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3053: pop
    //   3054: new 450	com/tencent/turingfd/sdk/qps/Damson
    //   3057: dup
    //   3058: invokespecial 451	com/tencent/turingfd/sdk/qps/Damson:<init>	()V
    //   3061: astore 13
    //   3063: new 63	java/lang/StringBuilder
    //   3066: dup
    //   3067: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   3070: astore 6
    //   3072: aload 6
    //   3074: aload 12
    //   3076: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: pop
    //   3080: aload 6
    //   3082: ldc_w 586
    //   3085: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3088: pop
    //   3089: aload 13
    //   3091: aload 6
    //   3093: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3096: putfield 458	com/tencent/turingfd/sdk/qps/Damson:a	Ljava/lang/String;
    //   3099: aload 11
    //   3101: invokestatic 589	com/tencent/token/agn:c	(Landroid/content/Context;)Z
    //   3104: istore 5
    //   3106: goto +6 -> 3112
    //   3109: iconst_0
    //   3110: istore 5
    //   3112: iload 5
    //   3114: ifeq +11 -> 3125
    //   3117: ldc_w 548
    //   3120: astore 6
    //   3122: goto +8 -> 3130
    //   3125: ldc_w 574
    //   3128: astore 6
    //   3130: aload 13
    //   3132: aload 6
    //   3134: putfield 460	com/tencent/turingfd/sdk/qps/Damson:b	Ljava/lang/String;
    //   3137: aload 9
    //   3139: aload 13
    //   3141: invokevirtual 194	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3144: pop
    //   3145: aload 8
    //   3147: aload 9
    //   3149: invokevirtual 219	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   3152: pop
    //   3153: getstatic 593	com/tencent/token/acc:a	Ljava/lang/Object;
    //   3156: astore 6
    //   3158: aload 11
    //   3160: ldc 55
    //   3162: iconst_0
    //   3163: invokevirtual 61	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   3166: astore 6
    //   3168: aload 6
    //   3170: ifnull +125 -> 3295
    //   3173: new 63	java/lang/StringBuilder
    //   3176: dup
    //   3177: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   3180: astore 8
    //   3182: aload 8
    //   3184: aload 6
    //   3186: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3189: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3192: pop
    //   3193: getstatic 77	java/io/File:separator	Ljava/lang/String;
    //   3196: astore 6
    //   3198: aload 8
    //   3200: aload 6
    //   3202: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: pop
    //   3206: aload 8
    //   3208: ldc_w 595
    //   3211: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3214: pop
    //   3215: new 66	java/io/File
    //   3218: dup
    //   3219: aload 8
    //   3221: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3224: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   3227: astore 8
    //   3229: aload 8
    //   3231: invokevirtual 89	java/io/File:exists	()Z
    //   3234: ifne +14 -> 3248
    //   3237: aload 8
    //   3239: invokevirtual 598	java/io/File:mkdirs	()Z
    //   3242: ifne +6 -> 3248
    //   3245: goto +50 -> 3295
    //   3248: new 63	java/lang/StringBuilder
    //   3251: dup
    //   3252: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   3255: astore 9
    //   3257: aload 9
    //   3259: aload 8
    //   3261: invokevirtual 70	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3264: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3267: pop
    //   3268: aload 9
    //   3270: aload 6
    //   3272: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3275: pop
    //   3276: aload 9
    //   3278: ldc_w 574
    //   3281: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: pop
    //   3285: aload 9
    //   3287: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3290: astore 6
    //   3292: goto +8 -> 3300
    //   3295: ldc_w 303
    //   3298: astore 6
    //   3300: aload 6
    //   3302: invokestatic 440	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3305: ifeq +11 -> 3316
    //   3308: getstatic 601	com/tencent/token/acc:b	Lcom/tencent/turingfd/sdk/qps/Guava;
    //   3311: astore 6
    //   3313: goto +88 -> 3401
    //   3316: getstatic 593	com/tencent/token/acc:a	Ljava/lang/Object;
    //   3319: astore 8
    //   3321: aload 8
    //   3323: monitorenter
    //   3324: aload 6
    //   3326: invokestatic 603	com/tencent/token/adg:b	(Ljava/lang/String;)[B
    //   3329: astore 6
    //   3331: aload 8
    //   3333: monitorexit
    //   3334: new 109	java/lang/String
    //   3337: dup
    //   3338: aload 6
    //   3340: invokestatic 133	com/tencent/token/agn:b	()[B
    //   3343: invokestatic 136	com/tencent/token/agn:b	([B[B)[B
    //   3346: invokestatic 139	com/tencent/token/agn:b	([B)[B
    //   3349: invokespecial 568	java/lang/String:<init>	([B)V
    //   3352: ldc 107
    //   3354: invokevirtual 113	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3357: astore 8
    //   3359: new 605	com/tencent/turingfd/sdk/qps/Guava
    //   3362: dup
    //   3363: invokespecial 606	com/tencent/turingfd/sdk/qps/Guava:<init>	()V
    //   3366: astore 6
    //   3368: aload 6
    //   3370: new 164	java/util/ArrayList
    //   3373: dup
    //   3374: aload 8
    //   3376: invokestatic 610	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   3379: invokespecial 613	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   3382: putfield 614	com/tencent/turingfd/sdk/qps/Guava:c	Ljava/util/ArrayList;
    //   3385: goto +16 -> 3401
    //   3388: astore 6
    //   3390: aload 8
    //   3392: monitorexit
    //   3393: aload 6
    //   3395: athrow
    //   3396: getstatic 601	com/tencent/token/acc:b	Lcom/tencent/turingfd/sdk/qps/Guava;
    //   3399: astore 6
    //   3401: aload 10
    //   3403: aload 6
    //   3405: putfield 617	com/tencent/turingfd/sdk/qps/Codlin:K	Lcom/tencent/turingfd/sdk/qps/Guava;
    //   3408: aload_0
    //   3409: getfield 22	com/tencent/token/afu:b	Lcom/tencent/token/aet;
    //   3412: aload 10
    //   3414: invokestatic 620	com/tencent/token/afk:a	(Lcom/tencent/token/aet;Lcom/tencent/turingfd/sdk/qps/Codlin;)Z
    //   3417: ifne +4 -> 3421
    //   3420: return
    //   3421: aload_0
    //   3422: getfield 18	com/tencent/token/afu:e	Lcom/tencent/token/afk;
    //   3425: astore 6
    //   3427: aload 7
    //   3429: getfield 621	com/tencent/token/afh:b	Ljava/util/List;
    //   3432: astore 7
    //   3434: aload 6
    //   3436: invokevirtual 50	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3439: pop
    //   3440: aload 7
    //   3442: invokeinterface 624 1 0
    //   3447: astore 6
    //   3449: aload 6
    //   3451: invokeinterface 180 1 0
    //   3456: ifeq +34 -> 3490
    //   3459: aload 6
    //   3461: invokeinterface 183 1 0
    //   3466: checkcast 109	java/lang/String
    //   3469: astore 7
    //   3471: new 66	java/io/File
    //   3474: dup
    //   3475: aload 7
    //   3477: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   3480: invokevirtual 627	java/io/File:delete	()Z
    //   3483: pop
    //   3484: goto -35 -> 3449
    //   3487: goto -38 -> 3449
    //   3490: return
    //   3491: astore 6
    //   3493: aload 13
    //   3495: monitorexit
    //   3496: aload 6
    //   3498: athrow
    //   3499: astore 6
    //   3501: ldc_w 413
    //   3504: monitorexit
    //   3505: aload 6
    //   3507: athrow
    //   3508: astore 6
    //   3510: ldc_w 413
    //   3513: monitorexit
    //   3514: aload 6
    //   3516: athrow
    //   3517: astore 8
    //   3519: goto -3257 -> 262
    //   3522: astore 6
    //   3524: goto -2700 -> 824
    //   3527: astore 12
    //   3529: goto -1158 -> 2371
    //   3532: astore 14
    //   3534: goto -674 -> 2860
    //   3537: astore 6
    //   3539: goto -430 -> 3109
    //   3542: astore 6
    //   3544: goto -148 -> 3396
    //   3547: astore 7
    //   3549: goto -62 -> 3487
    //   3552: iconst_m1
    //   3553: istore_2
    //   3554: iload_3
    //   3555: iload_2
    //   3556: if_icmpeq -3354 -> 202
    //   3559: iload_3
    //   3560: iconst_m1
    //   3561: if_icmpne -3294 -> 267
    //   3564: goto -3362 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3567	0	this	afu
    //   144	2751	1	i	int
    //   198	3359	2	j	int
    //   24	3538	3	k	int
    //   141	2410	4	m	int
    //   3104	9	5	bool	boolean
    //   18	3351	6	localObject1	java.lang.Object
    //   3388	6	6	localObject2	java.lang.Object
    //   3399	61	6	localObject3	java.lang.Object
    //   3491	6	6	localObject4	java.lang.Object
    //   3499	7	6	localObject5	java.lang.Object
    //   3508	7	6	localObject6	java.lang.Object
    //   3522	1	6	localObject7	java.lang.Object
    //   3537	1	6	localObject8	java.lang.Object
    //   3542	1	6	localObject9	java.lang.Object
    //   9	3467	7	localObject10	java.lang.Object
    //   3547	1	7	localObject11	java.lang.Object
    //   167	3224	8	localObject12	java.lang.Object
    //   3517	1	8	localObject13	java.lang.Object
    //   228	3058	9	localObject14	java.lang.Object
    //   438	2975	10	localObject15	java.lang.Object
    //   38	3121	11	localObject16	java.lang.Object
    //   300	2775	12	localObject17	java.lang.Object
    //   3527	1	12	localObject18	java.lang.Object
    //   312	3182	13	localObject19	java.lang.Object
    //   479	2399	14	localObject20	java.lang.Object
    //   3532	1	14	localObject21	java.lang.Object
    //   1741	290	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3324	3334	3388	finally
    //   3390	3393	3388	finally
    //   2862	2889	3491	finally
    //   2889	2892	3491	finally
    //   3493	3496	3491	finally
    //   1586	1597	3499	finally
    //   1597	1601	3499	finally
    //   1555	1566	3508	finally
    //   1566	1571	3508	finally
    //   157	169	3517	finally
    //   174	181	3517	finally
    //   184	199	3517	finally
    //   202	259	3517	finally
    //   794	821	3522	finally
    //   2257	2274	3527	finally
    //   2826	2857	3532	finally
    //   3099	3106	3537	finally
    //   3316	3324	3542	finally
    //   3334	3385	3542	finally
    //   3393	3396	3542	finally
    //   3471	3484	3547	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afu
 * JD-Core Version:    0.7.0.1
 */