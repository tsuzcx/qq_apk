public class txm
{
  public long ER;
  public swx a;
  public String aJT;
  private String aJU;
  public boolean aNO;
  public boolean aQA;
  public boolean aQB;
  public boolean aQy;
  public boolean aQz;
  public int bDb;
  public long clearTime;
  public float oN;
  public float oO;
  public float oP;
  public float oQ;
  
  /* Error */
  public txm()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 33
    //   7: putfield 35	txm:aJT	Ljava/lang/String;
    //   10: aload_0
    //   11: bipush 15
    //   13: putfield 37	txm:bDb	I
    //   16: aload_0
    //   17: ldc2_w 38
    //   20: putfield 41	txm:clearTime	J
    //   23: aload_0
    //   24: ldc 42
    //   26: putfield 44	txm:oO	F
    //   29: aload_0
    //   30: ldc 42
    //   32: putfield 46	txm:oP	F
    //   35: aload_0
    //   36: ldc 48
    //   38: putfield 50	txm:aJU	Ljava/lang/String;
    //   41: aload_0
    //   42: iconst_1
    //   43: putfield 52	txm:aQA	Z
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 54	txm:aQB	Z
    //   51: aload_0
    //   52: ldc 55
    //   54: putfield 57	txm:oQ	F
    //   57: aload_0
    //   58: ldc2_w 58
    //   61: putfield 61	txm:ER	J
    //   64: invokestatic 67	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   67: astore 4
    //   69: invokestatic 72	com/tencent/mfsdk/MagnifierSDK:a	()Lcom/tencent/mfsdk/MagnifierSDK;
    //   72: invokevirtual 75	com/tencent/mfsdk/MagnifierSDK:a	()Ltxj;
    //   75: invokeinterface 81 1 0
    //   80: astore 5
    //   82: aload_0
    //   83: new 83	swx
    //   86: dup
    //   87: ldc 85
    //   89: invokespecial 88	swx:<init>	(Ljava/lang/String;)V
    //   92: putfield 90	txm:a	Lswx;
    //   95: aload_0
    //   96: getfield 90	txm:a	Lswx;
    //   99: iconst_1
    //   100: putfield 92	swx:aNO	Z
    //   103: invokestatic 98	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   106: ldc 100
    //   108: iconst_4
    //   109: invokevirtual 104	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   112: astore 6
    //   114: aload 6
    //   116: aload_0
    //   117: getfield 50	txm:aJU	Ljava/lang/String;
    //   120: iconst_m1
    //   121: invokeinterface 110 3 0
    //   126: istore_2
    //   127: iload_2
    //   128: istore_1
    //   129: iload_2
    //   130: iconst_m1
    //   131: if_icmpne +55 -> 186
    //   134: new 112	java/util/Random
    //   137: dup
    //   138: invokespecial 113	java/util/Random:<init>	()V
    //   141: sipush 1000
    //   144: invokevirtual 117	java/util/Random:nextInt	(I)I
    //   147: istore_1
    //   148: aload 6
    //   150: invokeinterface 121 1 0
    //   155: astore 6
    //   157: aload 6
    //   159: aload_0
    //   160: getfield 50	txm:aJU	Ljava/lang/String;
    //   163: iload_1
    //   164: invokeinterface 127 3 0
    //   169: pop
    //   170: getstatic 132	android/os/Build$VERSION:SDK_INT	I
    //   173: bipush 9
    //   175: if_icmpge +63 -> 238
    //   178: aload 6
    //   180: invokeinterface 136 1 0
    //   185: pop
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 138	txm:aQy	Z
    //   191: iload_1
    //   192: iconst_2
    //   193: irem
    //   194: ifne +8 -> 202
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 138	txm:aQy	Z
    //   202: ldc 139
    //   204: f2d
    //   205: invokestatic 145	java/lang/Math:random	()D
    //   208: dcmpl
    //   209: iflt +39 -> 248
    //   212: iconst_1
    //   213: istore_3
    //   214: aload_0
    //   215: iload_3
    //   216: putfield 147	txm:aQz	Z
    //   219: aload 5
    //   221: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne +13 -> 237
    //   227: aload 5
    //   229: ldc 155
    //   231: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +19 -> 253
    //   237: return
    //   238: aload 6
    //   240: invokeinterface 164 1 0
    //   245: goto -59 -> 186
    //   248: iconst_0
    //   249: istore_3
    //   250: goto -36 -> 214
    //   253: aload 5
    //   255: ldc 166
    //   257: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   260: astore 5
    //   262: aload 5
    //   264: arraylength
    //   265: iconst_1
    //   266: if_icmple +613 -> 879
    //   269: aload 5
    //   271: aload 4
    //   273: getfield 173	com/tencent/mobileqq/app/DeviceProfileManager:cuV	I
    //   276: aload 5
    //   278: arraylength
    //   279: irem
    //   280: aaload
    //   281: astore 4
    //   283: aload 4
    //   285: ldc 175
    //   287: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   290: astore 4
    //   292: aload 4
    //   294: arraylength
    //   295: bipush 7
    //   297: if_icmplt -60 -> 237
    //   300: aload 4
    //   302: iconst_1
    //   303: aaload
    //   304: ldc 177
    //   306: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   309: astore 5
    //   311: aload 5
    //   313: iconst_0
    //   314: aaload
    //   315: ldc 179
    //   317: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   320: ifeq +47 -> 367
    //   323: aload_0
    //   324: iconst_1
    //   325: putfield 180	txm:aNO	Z
    //   328: aload_0
    //   329: aload 5
    //   331: iconst_1
    //   332: aaload
    //   333: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   336: putfield 37	txm:bDb	I
    //   339: aload_0
    //   340: getfield 37	txm:bDb	I
    //   343: bipush 50
    //   345: if_icmple +9 -> 354
    //   348: aload_0
    //   349: bipush 50
    //   351: putfield 37	txm:bDb	I
    //   354: aload_0
    //   355: getfield 37	txm:bDb	I
    //   358: iconst_1
    //   359: if_icmpge +8 -> 367
    //   362: aload_0
    //   363: iconst_1
    //   364: putfield 37	txm:bDb	I
    //   367: aload_0
    //   368: aload 4
    //   370: iconst_2
    //   371: aaload
    //   372: putfield 35	txm:aJT	Ljava/lang/String;
    //   375: aload_0
    //   376: aload 4
    //   378: iconst_4
    //   379: aaload
    //   380: invokestatic 192	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   383: invokevirtual 196	java/lang/Float:floatValue	()F
    //   386: putfield 198	txm:oN	F
    //   389: aload_0
    //   390: getfield 198	txm:oN	F
    //   393: fconst_1
    //   394: fcmpl
    //   395: ifle +8 -> 403
    //   398: aload_0
    //   399: fconst_1
    //   400: putfield 198	txm:oN	F
    //   403: aload_0
    //   404: aload 4
    //   406: bipush 6
    //   408: aaload
    //   409: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   412: putfield 44	txm:oO	F
    //   415: aload 4
    //   417: arraylength
    //   418: istore_1
    //   419: iload_1
    //   420: bipush 9
    //   422: if_icmplt +316 -> 738
    //   425: aload 4
    //   427: bipush 8
    //   429: aaload
    //   430: ldc 177
    //   432: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   435: astore 5
    //   437: aload 5
    //   439: arraylength
    //   440: iconst_5
    //   441: if_icmplt +297 -> 738
    //   444: aload_0
    //   445: getfield 90	txm:a	Lswx;
    //   448: ifnonnull +461 -> 909
    //   451: aload_0
    //   452: new 83	swx
    //   455: dup
    //   456: aload_0
    //   457: getfield 35	txm:aJT	Ljava/lang/String;
    //   460: invokespecial 88	swx:<init>	(Ljava/lang/String;)V
    //   463: putfield 90	txm:a	Lswx;
    //   466: aload 5
    //   468: iconst_0
    //   469: aaload
    //   470: ldc 179
    //   472: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   475: ifeq +458 -> 933
    //   478: aload_0
    //   479: getfield 90	txm:a	Lswx;
    //   482: iconst_1
    //   483: putfield 92	swx:aNO	Z
    //   486: aload_0
    //   487: getfield 90	txm:a	Lswx;
    //   490: aload 5
    //   492: iconst_1
    //   493: aaload
    //   494: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   497: putfield 205	swx:bzO	I
    //   500: aload 5
    //   502: iconst_2
    //   503: aaload
    //   504: ldc 207
    //   506: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   509: astore 6
    //   511: aload 6
    //   513: arraylength
    //   514: iconst_4
    //   515: if_icmplt +53 -> 568
    //   518: new 209	swx$a
    //   521: dup
    //   522: aload 6
    //   524: iconst_0
    //   525: aaload
    //   526: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   529: aload 6
    //   531: iconst_1
    //   532: aaload
    //   533: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   536: aload 6
    //   538: iconst_2
    //   539: aaload
    //   540: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   543: aload 6
    //   545: iconst_3
    //   546: aaload
    //   547: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   550: invokespecial 212	swx$a:<init>	(IIFF)V
    //   553: astore 6
    //   555: aload_0
    //   556: getfield 90	txm:a	Lswx;
    //   559: getfield 216	swx:bk	Landroid/util/SparseArray;
    //   562: iconst_1
    //   563: aload 6
    //   565: invokevirtual 222	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   568: aload 5
    //   570: iconst_3
    //   571: aaload
    //   572: ldc 207
    //   574: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   577: astore 6
    //   579: aload 6
    //   581: arraylength
    //   582: iconst_4
    //   583: if_icmplt +53 -> 636
    //   586: new 209	swx$a
    //   589: dup
    //   590: aload 6
    //   592: iconst_0
    //   593: aaload
    //   594: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   597: aload 6
    //   599: iconst_1
    //   600: aaload
    //   601: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   604: aload 6
    //   606: iconst_2
    //   607: aaload
    //   608: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   611: aload 6
    //   613: iconst_3
    //   614: aaload
    //   615: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   618: invokespecial 212	swx$a:<init>	(IIFF)V
    //   621: astore 6
    //   623: aload_0
    //   624: getfield 90	txm:a	Lswx;
    //   627: getfield 216	swx:bk	Landroid/util/SparseArray;
    //   630: iconst_2
    //   631: aload 6
    //   633: invokevirtual 222	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   636: aload 5
    //   638: iconst_4
    //   639: aaload
    //   640: ldc 207
    //   642: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   645: astore 5
    //   647: aload 5
    //   649: arraylength
    //   650: iconst_4
    //   651: if_icmplt +53 -> 704
    //   654: new 209	swx$a
    //   657: dup
    //   658: aload 5
    //   660: iconst_0
    //   661: aaload
    //   662: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   665: aload 5
    //   667: iconst_1
    //   668: aaload
    //   669: invokestatic 186	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   672: aload 5
    //   674: iconst_2
    //   675: aaload
    //   676: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   679: aload 5
    //   681: iconst_3
    //   682: aaload
    //   683: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   686: invokespecial 212	swx$a:<init>	(IIFF)V
    //   689: astore 5
    //   691: aload_0
    //   692: getfield 90	txm:a	Lswx;
    //   695: getfield 216	swx:bk	Landroid/util/SparseArray;
    //   698: iconst_3
    //   699: aload 5
    //   701: invokevirtual 222	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   704: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq +31 -> 738
    //   710: ldc 229
    //   712: iconst_2
    //   713: new 231	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   720: ldc 234
    //   722: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_0
    //   726: getfield 90	txm:a	Lswx;
    //   729: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload 4
    //   740: arraylength
    //   741: bipush 10
    //   743: if_icmplt +21 -> 764
    //   746: ldc 179
    //   748: aload 4
    //   750: bipush 9
    //   752: aaload
    //   753: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   756: ifeq +277 -> 1033
    //   759: aload_0
    //   760: iconst_1
    //   761: putfield 54	txm:aQB	Z
    //   764: aload 4
    //   766: arraylength
    //   767: bipush 11
    //   769: if_icmplt +44 -> 813
    //   772: aload 4
    //   774: bipush 10
    //   776: aaload
    //   777: ldc 177
    //   779: invokevirtual 170	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   782: astore 5
    //   784: aload 5
    //   786: arraylength
    //   787: iconst_2
    //   788: if_icmplt +25 -> 813
    //   791: aload_0
    //   792: aload 5
    //   794: iconst_0
    //   795: aaload
    //   796: invokestatic 202	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   799: putfield 57	txm:oQ	F
    //   802: aload_0
    //   803: aload 5
    //   805: iconst_1
    //   806: aaload
    //   807: invokestatic 258	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   810: putfield 61	txm:ER	J
    //   813: aload 4
    //   815: arraylength
    //   816: bipush 12
    //   818: if_icmplt +21 -> 839
    //   821: ldc 179
    //   823: aload 4
    //   825: bipush 11
    //   827: aaload
    //   828: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   831: ifeq +210 -> 1041
    //   834: aload_0
    //   835: iconst_1
    //   836: putfield 52	txm:aQA	Z
    //   839: aload_0
    //   840: getfield 54	txm:aQB	Z
    //   843: ifeq +206 -> 1049
    //   846: aload_0
    //   847: getfield 52	txm:aQA	Z
    //   850: ifne -613 -> 237
    //   853: aload_0
    //   854: iconst_1
    //   855: putfield 138	txm:aQy	Z
    //   858: return
    //   859: astore 4
    //   861: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   864: ifeq -627 -> 237
    //   867: ldc 229
    //   869: iconst_2
    //   870: ldc_w 260
    //   873: aload 4
    //   875: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   878: return
    //   879: aload 5
    //   881: iconst_0
    //   882: aaload
    //   883: astore 4
    //   885: goto -602 -> 283
    //   888: astore 5
    //   890: aload_0
    //   891: fconst_0
    //   892: putfield 198	txm:oN	F
    //   895: goto -492 -> 403
    //   898: astore 5
    //   900: aload_0
    //   901: ldc 139
    //   903: putfield 44	txm:oO	F
    //   906: goto -491 -> 415
    //   909: aload_0
    //   910: getfield 90	txm:a	Lswx;
    //   913: aload_0
    //   914: getfield 35	txm:aJT	Ljava/lang/String;
    //   917: putfield 266	swx:aHI	Ljava/lang/String;
    //   920: goto -454 -> 466
    //   923: astore 5
    //   925: aload 5
    //   927: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   930: goto -192 -> 738
    //   933: aload 5
    //   935: iconst_0
    //   936: aaload
    //   937: ldc 155
    //   939: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   942: ifeq +14 -> 956
    //   945: aload_0
    //   946: getfield 90	txm:a	Lswx;
    //   949: iconst_0
    //   950: putfield 92	swx:aNO	Z
    //   953: goto -467 -> 486
    //   956: getstatic 272	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   959: iconst_1
    //   960: if_icmpne +14 -> 974
    //   963: aload_0
    //   964: getfield 90	txm:a	Lswx;
    //   967: iconst_1
    //   968: putfield 92	swx:aNO	Z
    //   971: goto -485 -> 486
    //   974: aload 5
    //   976: iconst_0
    //   977: aaload
    //   978: ldc_w 274
    //   981: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   984: ifeq +14 -> 998
    //   987: aload_0
    //   988: getfield 90	txm:a	Lswx;
    //   991: iconst_1
    //   992: putfield 92	swx:aNO	Z
    //   995: goto -509 -> 486
    //   998: aload 5
    //   1000: iconst_0
    //   1001: aaload
    //   1002: ldc_w 276
    //   1005: invokevirtual 161	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1008: ifeq +14 -> 1022
    //   1011: aload_0
    //   1012: getfield 90	txm:a	Lswx;
    //   1015: iconst_0
    //   1016: putfield 92	swx:aNO	Z
    //   1019: goto -533 -> 486
    //   1022: aload_0
    //   1023: getfield 90	txm:a	Lswx;
    //   1026: iconst_1
    //   1027: putfield 92	swx:aNO	Z
    //   1030: goto -544 -> 486
    //   1033: aload_0
    //   1034: iconst_0
    //   1035: putfield 54	txm:aQB	Z
    //   1038: goto -274 -> 764
    //   1041: aload_0
    //   1042: iconst_0
    //   1043: putfield 52	txm:aQA	Z
    //   1046: goto -207 -> 839
    //   1049: aload_0
    //   1050: iconst_0
    //   1051: putfield 138	txm:aQy	Z
    //   1054: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1055	0	this	txm
    //   128	295	1	i	int
    //   126	6	2	j	int
    //   213	37	3	bool	boolean
    //   67	757	4	localObject1	Object
    //   859	15	4	localException1	java.lang.Exception
    //   883	1	4	localObject2	Object
    //   80	800	5	localObject3	Object
    //   888	1	5	localException2	java.lang.Exception
    //   898	1	5	localException3	java.lang.Exception
    //   923	76	5	localException4	java.lang.Exception
    //   112	520	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   283	354	859	java/lang/Exception
    //   354	367	859	java/lang/Exception
    //   367	375	859	java/lang/Exception
    //   415	419	859	java/lang/Exception
    //   738	764	859	java/lang/Exception
    //   764	813	859	java/lang/Exception
    //   813	839	859	java/lang/Exception
    //   839	858	859	java/lang/Exception
    //   890	895	859	java/lang/Exception
    //   900	906	859	java/lang/Exception
    //   925	930	859	java/lang/Exception
    //   1033	1038	859	java/lang/Exception
    //   1041	1046	859	java/lang/Exception
    //   1049	1054	859	java/lang/Exception
    //   375	403	888	java/lang/Exception
    //   403	415	898	java/lang/Exception
    //   425	466	923	java/lang/Exception
    //   466	486	923	java/lang/Exception
    //   486	568	923	java/lang/Exception
    //   568	636	923	java/lang/Exception
    //   636	704	923	java/lang/Exception
    //   704	738	923	java/lang/Exception
    //   909	920	923	java/lang/Exception
    //   933	953	923	java/lang/Exception
    //   956	971	923	java/lang/Exception
    //   974	995	923	java/lang/Exception
    //   998	1019	923	java/lang/Exception
    //   1022	1030	923	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txm
 * JD-Core Version:    0.7.0.1
 */