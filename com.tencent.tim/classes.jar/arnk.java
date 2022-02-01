import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

class arnk
{
  private static String LOG_TAG = arni.E(arni.hi);
  private static String cAO = "";
  
  static
  {
    cAO = arni.E(arni.hh);
    LOG_TAG = "TXVA";
  }
  
  /* Error */
  public static int ag(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: getstatic 13	arnk:cAO	Ljava/lang/String;
    //   7: invokestatic 41	arnk:b	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   10: astore 14
    //   12: aload 14
    //   14: ifnonnull +33 -> 47
    //   17: sipush 129
    //   20: istore_2
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 43	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: iconst_0
    //   34: ifeq +11 -> 45
    //   37: new 43	java/lang/NullPointerException
    //   40: dup
    //   41: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   44: athrow
    //   45: iload_2
    //   46: ireturn
    //   47: aload_0
    //   48: ifnull +21 -> 69
    //   51: iload_3
    //   52: istore_2
    //   53: ldc 11
    //   55: aload_0
    //   56: invokevirtual 52	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: istore 7
    //   64: iload 7
    //   66: ifeq +34 -> 100
    //   69: bipush 17
    //   71: istore_2
    //   72: iconst_0
    //   73: ifeq +11 -> 84
    //   76: new 43	java/lang/NullPointerException
    //   79: dup
    //   80: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   83: athrow
    //   84: iconst_0
    //   85: ifeq -40 -> 45
    //   88: new 43	java/lang/NullPointerException
    //   91: dup
    //   92: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   95: athrow
    //   96: astore_0
    //   97: bipush 17
    //   99: ireturn
    //   100: iload_3
    //   101: istore_2
    //   102: new 58	java/io/File
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   110: astore 8
    //   112: aload 8
    //   114: ifnull +17 -> 131
    //   117: iload_3
    //   118: istore_2
    //   119: aload 8
    //   121: invokevirtual 65	java/io/File:exists	()Z
    //   124: istore 7
    //   126: iload 7
    //   128: ifne +32 -> 160
    //   131: iconst_3
    //   132: istore_2
    //   133: iconst_0
    //   134: ifeq +11 -> 145
    //   137: new 43	java/lang/NullPointerException
    //   140: dup
    //   141: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   144: athrow
    //   145: iconst_0
    //   146: ifeq -101 -> 45
    //   149: new 43	java/lang/NullPointerException
    //   152: dup
    //   153: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   156: athrow
    //   157: astore_0
    //   158: iconst_3
    //   159: ireturn
    //   160: bipush 33
    //   162: istore_2
    //   163: aload_0
    //   164: invokestatic 71	arnj:z	(Ljava/lang/String;)Ljava/util/Map;
    //   167: astore 13
    //   169: aload 13
    //   171: ifnonnull +36 -> 207
    //   174: sipush 142
    //   177: istore_2
    //   178: iconst_0
    //   179: ifeq +11 -> 190
    //   182: new 43	java/lang/NullPointerException
    //   185: dup
    //   186: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   189: athrow
    //   190: iconst_0
    //   191: ifeq -146 -> 45
    //   194: new 43	java/lang/NullPointerException
    //   197: dup
    //   198: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   201: athrow
    //   202: astore_0
    //   203: sipush 142
    //   206: ireturn
    //   207: bipush 34
    //   209: istore_3
    //   210: iload_3
    //   211: istore_2
    //   212: new 73	java/util/jar/JarFile
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 74	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   220: astore 8
    //   222: iload_3
    //   223: istore_2
    //   224: aload 8
    //   226: aload_1
    //   227: invokevirtual 78	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   230: astore_0
    //   231: aload_0
    //   232: ifnonnull +68 -> 300
    //   235: iconst_5
    //   236: istore_2
    //   237: aconst_null
    //   238: astore 10
    //   240: aload 10
    //   242: ifnull +8 -> 250
    //   245: aload 10
    //   247: invokevirtual 83	java/io/DataInputStream:close	()V
    //   250: iload_2
    //   251: istore_3
    //   252: aload 8
    //   254: ifnull +10 -> 264
    //   257: aload 8
    //   259: invokevirtual 84	java/util/jar/JarFile:close	()V
    //   262: iload_2
    //   263: istore_3
    //   264: iload_3
    //   265: istore_2
    //   266: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -224 -> 45
    //   272: getstatic 27	arnk:LOG_TAG	Ljava/lang/String;
    //   275: iconst_2
    //   276: new 91	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   283: ldc 94
    //   285: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_3
    //   289: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: iload_3
    //   299: ireturn
    //   300: bipush 36
    //   302: istore_2
    //   303: new 80	java/io/DataInputStream
    //   306: dup
    //   307: aload 8
    //   309: aload_0
    //   310: invokevirtual 112	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   313: invokespecial 115	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   316: astore 10
    //   318: bipush 37
    //   320: istore_3
    //   321: aload 8
    //   323: astore 9
    //   325: aload 10
    //   327: astore_0
    //   328: iload_3
    //   329: istore_2
    //   330: aload 10
    //   332: astore_1
    //   333: aload 10
    //   335: invokevirtual 119	java/io/DataInputStream:readInt	()I
    //   338: ldc 120
    //   340: if_icmpeq +10 -> 350
    //   343: sipush 132
    //   346: istore_2
    //   347: goto -107 -> 240
    //   350: aload 8
    //   352: astore 9
    //   354: aload 10
    //   356: astore_0
    //   357: iload_3
    //   358: istore_2
    //   359: aload 10
    //   361: astore_1
    //   362: aload 10
    //   364: invokevirtual 119	java/io/DataInputStream:readInt	()I
    //   367: istore 4
    //   369: iload 4
    //   371: sipush 128
    //   374: if_icmplt +619 -> 993
    //   377: iload 4
    //   379: sipush 256
    //   382: if_icmple +6 -> 388
    //   385: goto +608 -> 993
    //   388: aload 8
    //   390: astore 9
    //   392: aload 10
    //   394: astore_0
    //   395: iload_3
    //   396: istore_2
    //   397: aload 10
    //   399: astore_1
    //   400: aload 10
    //   402: invokevirtual 119	java/io/DataInputStream:readInt	()I
    //   405: ldc 121
    //   407: if_icmpeq +10 -> 417
    //   410: sipush 134
    //   413: istore_2
    //   414: goto -174 -> 240
    //   417: aload 8
    //   419: astore 9
    //   421: aload 10
    //   423: astore_0
    //   424: iload_3
    //   425: istore_2
    //   426: aload 10
    //   428: astore_1
    //   429: aload 10
    //   431: invokevirtual 119	java/io/DataInputStream:readInt	()I
    //   434: istore 5
    //   436: aload 8
    //   438: astore 9
    //   440: aload 10
    //   442: astore_0
    //   443: iload_3
    //   444: istore_2
    //   445: aload 10
    //   447: astore_1
    //   448: aload 10
    //   450: invokevirtual 119	java/io/DataInputStream:readInt	()I
    //   453: istore 6
    //   455: iload 6
    //   457: ifgt +10 -> 467
    //   460: sipush 135
    //   463: istore_2
    //   464: goto -224 -> 240
    //   467: bipush 38
    //   469: istore_2
    //   470: aload 8
    //   472: astore 9
    //   474: aload 10
    //   476: astore_0
    //   477: aload 10
    //   479: astore_1
    //   480: aload 10
    //   482: invokevirtual 124	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   485: astore 15
    //   487: bipush 39
    //   489: istore_3
    //   490: aload 8
    //   492: astore 9
    //   494: aload 10
    //   496: astore_0
    //   497: iload_3
    //   498: istore_2
    //   499: aload 10
    //   501: astore_1
    //   502: iload 4
    //   504: newarray byte
    //   506: astore 16
    //   508: aload 8
    //   510: astore 9
    //   512: aload 10
    //   514: astore_0
    //   515: iload_3
    //   516: istore_2
    //   517: aload 10
    //   519: astore_1
    //   520: aload 10
    //   522: aload 16
    //   524: invokevirtual 128	java/io/DataInputStream:read	([B)I
    //   527: pop
    //   528: aload 8
    //   530: astore 9
    //   532: aload 10
    //   534: astore_0
    //   535: iload_3
    //   536: istore_2
    //   537: aload 10
    //   539: astore_1
    //   540: aload 10
    //   542: invokevirtual 83	java/io/DataInputStream:close	()V
    //   545: aconst_null
    //   546: astore 12
    //   548: aconst_null
    //   549: astore 11
    //   551: aconst_null
    //   552: astore 10
    //   554: bipush 40
    //   556: istore_2
    //   557: aload 8
    //   559: astore 9
    //   561: aload 12
    //   563: astore_0
    //   564: aload 11
    //   566: astore_1
    //   567: aload 15
    //   569: ldc 130
    //   571: invokevirtual 134	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   574: aload 16
    //   576: aload 14
    //   578: invokestatic 137	arnk:b	([B[BLjava/security/PublicKey;)Z
    //   581: ifne +10 -> 591
    //   584: sipush 137
    //   587: istore_2
    //   588: goto -348 -> 240
    //   591: bipush 41
    //   593: istore 4
    //   595: aload 8
    //   597: astore 9
    //   599: aload 12
    //   601: astore_0
    //   602: iload 4
    //   604: istore_2
    //   605: aload 11
    //   607: astore_1
    //   608: new 91	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   615: astore 14
    //   617: iconst_0
    //   618: istore_3
    //   619: aload 8
    //   621: astore 9
    //   623: aload 12
    //   625: astore_0
    //   626: iload 4
    //   628: istore_2
    //   629: aload 11
    //   631: astore_1
    //   632: iload_3
    //   633: aload 15
    //   635: invokevirtual 140	java/lang/String:length	()I
    //   638: if_icmpge +39 -> 677
    //   641: aload 8
    //   643: astore 9
    //   645: aload 12
    //   647: astore_0
    //   648: iload 4
    //   650: istore_2
    //   651: aload 11
    //   653: astore_1
    //   654: aload 14
    //   656: aload 15
    //   658: iload_3
    //   659: invokevirtual 144	java/lang/String:charAt	(I)C
    //   662: iload 5
    //   664: ixor
    //   665: i2c
    //   666: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: iload_3
    //   671: iconst_1
    //   672: iadd
    //   673: istore_3
    //   674: goto -55 -> 619
    //   677: aload 8
    //   679: astore 9
    //   681: aload 12
    //   683: astore_0
    //   684: iload 4
    //   686: istore_2
    //   687: aload 11
    //   689: astore_1
    //   690: aload 14
    //   692: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: ldc 149
    //   697: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   700: astore 14
    //   702: aload 8
    //   704: astore 9
    //   706: aload 12
    //   708: astore_0
    //   709: iload 4
    //   711: istore_2
    //   712: aload 11
    //   714: astore_1
    //   715: aload 14
    //   717: arraylength
    //   718: iload 6
    //   720: if_icmpeq +10 -> 730
    //   723: sipush 135
    //   726: istore_2
    //   727: goto -487 -> 240
    //   730: bipush 42
    //   732: istore 5
    //   734: aload 8
    //   736: astore 9
    //   738: aload 12
    //   740: astore_0
    //   741: iload 5
    //   743: istore_2
    //   744: aload 11
    //   746: astore_1
    //   747: aload 14
    //   749: arraylength
    //   750: istore 6
    //   752: iconst_0
    //   753: istore_3
    //   754: iload_3
    //   755: iload 6
    //   757: if_icmpge +115 -> 872
    //   760: aload 8
    //   762: astore 9
    //   764: aload 12
    //   766: astore_0
    //   767: iload 5
    //   769: istore_2
    //   770: aload 11
    //   772: astore_1
    //   773: aload 14
    //   775: iload_3
    //   776: aaload
    //   777: ldc 155
    //   779: invokevirtual 153	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   782: astore 15
    //   784: aload 8
    //   786: astore 9
    //   788: aload 12
    //   790: astore_0
    //   791: iload 5
    //   793: istore_2
    //   794: aload 11
    //   796: astore_1
    //   797: aload 15
    //   799: arraylength
    //   800: iconst_2
    //   801: if_icmpeq +6 -> 807
    //   804: goto +196 -> 1000
    //   807: aload 8
    //   809: astore 9
    //   811: aload 12
    //   813: astore_0
    //   814: iload 5
    //   816: istore_2
    //   817: aload 11
    //   819: astore_1
    //   820: aload 13
    //   822: aload 15
    //   824: iconst_0
    //   825: aaload
    //   826: aload 15
    //   828: iconst_1
    //   829: aaload
    //   830: invokestatic 159	arnj:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   833: istore 4
    //   835: iload 4
    //   837: ifeq +163 -> 1000
    //   840: iconst_0
    //   841: ifeq +11 -> 852
    //   844: new 43	java/lang/NullPointerException
    //   847: dup
    //   848: invokespecial 46	java/lang/NullPointerException:<init>	()V
    //   851: athrow
    //   852: iload 4
    //   854: istore_2
    //   855: aload 8
    //   857: ifnull -812 -> 45
    //   860: aload 8
    //   862: invokevirtual 84	java/util/jar/JarFile:close	()V
    //   865: iload 4
    //   867: ireturn
    //   868: astore_0
    //   869: iload 4
    //   871: ireturn
    //   872: iconst_0
    //   873: istore_2
    //   874: goto -634 -> 240
    //   877: astore 10
    //   879: aconst_null
    //   880: astore 8
    //   882: aconst_null
    //   883: astore_1
    //   884: aload 8
    //   886: astore 9
    //   888: aload_1
    //   889: astore_0
    //   890: aload 10
    //   892: invokevirtual 162	java/lang/Throwable:printStackTrace	()V
    //   895: aload_1
    //   896: ifnull +7 -> 903
    //   899: aload_1
    //   900: invokevirtual 83	java/io/DataInputStream:close	()V
    //   903: iload_2
    //   904: istore_3
    //   905: aload 8
    //   907: ifnull -643 -> 264
    //   910: aload 8
    //   912: invokevirtual 84	java/util/jar/JarFile:close	()V
    //   915: iload_2
    //   916: istore_3
    //   917: goto -653 -> 264
    //   920: astore_0
    //   921: iload_2
    //   922: istore_3
    //   923: goto -659 -> 264
    //   926: astore_1
    //   927: aconst_null
    //   928: astore 8
    //   930: aconst_null
    //   931: astore_0
    //   932: aload_0
    //   933: ifnull +7 -> 940
    //   936: aload_0
    //   937: invokevirtual 83	java/io/DataInputStream:close	()V
    //   940: aload 8
    //   942: ifnull +8 -> 950
    //   945: aload 8
    //   947: invokevirtual 84	java/util/jar/JarFile:close	()V
    //   950: aload_1
    //   951: athrow
    //   952: astore_0
    //   953: goto -3 -> 950
    //   956: astore_1
    //   957: aconst_null
    //   958: astore_0
    //   959: goto -27 -> 932
    //   962: astore_1
    //   963: aload 9
    //   965: astore 8
    //   967: goto -35 -> 932
    //   970: astore 10
    //   972: aconst_null
    //   973: astore_1
    //   974: goto -90 -> 884
    //   977: astore 10
    //   979: goto -95 -> 884
    //   982: astore_0
    //   983: iload_2
    //   984: istore_3
    //   985: goto -721 -> 264
    //   988: astore_0
    //   989: sipush 129
    //   992: ireturn
    //   993: sipush 133
    //   996: istore_2
    //   997: goto -757 -> 240
    //   1000: iload_3
    //   1001: iconst_1
    //   1002: iadd
    //   1003: istore_3
    //   1004: goto -250 -> 754
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	paramString1	String
    //   0	1007	1	paramString2	String
    //   3	994	2	i	int
    //   1	1003	3	j	int
    //   367	503	4	k	int
    //   434	381	5	m	int
    //   453	305	6	n	int
    //   62	65	7	bool	boolean
    //   110	856	8	localObject1	Object
    //   323	641	9	localObject2	Object
    //   238	315	10	localDataInputStream	java.io.DataInputStream
    //   877	14	10	localThrowable1	java.lang.Throwable
    //   970	1	10	localThrowable2	java.lang.Throwable
    //   977	1	10	localThrowable3	java.lang.Throwable
    //   549	269	11	localObject3	Object
    //   546	266	12	localObject4	Object
    //   167	654	13	localMap	java.util.Map
    //   10	764	14	localObject5	Object
    //   485	342	15	localObject6	Object
    //   506	69	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   76	84	96	java/io/IOException
    //   88	96	96	java/io/IOException
    //   137	145	157	java/io/IOException
    //   149	157	157	java/io/IOException
    //   182	190	202	java/io/IOException
    //   194	202	202	java/io/IOException
    //   844	852	868	java/io/IOException
    //   860	865	868	java/io/IOException
    //   4	12	877	java/lang/Throwable
    //   53	64	877	java/lang/Throwable
    //   102	112	877	java/lang/Throwable
    //   119	126	877	java/lang/Throwable
    //   163	169	877	java/lang/Throwable
    //   212	222	877	java/lang/Throwable
    //   899	903	920	java/io/IOException
    //   910	915	920	java/io/IOException
    //   4	12	926	finally
    //   53	64	926	finally
    //   102	112	926	finally
    //   119	126	926	finally
    //   163	169	926	finally
    //   212	222	926	finally
    //   936	940	952	java/io/IOException
    //   945	950	952	java/io/IOException
    //   224	231	956	finally
    //   303	318	956	finally
    //   333	343	962	finally
    //   362	369	962	finally
    //   400	410	962	finally
    //   429	436	962	finally
    //   448	455	962	finally
    //   480	487	962	finally
    //   502	508	962	finally
    //   520	528	962	finally
    //   540	545	962	finally
    //   567	584	962	finally
    //   608	617	962	finally
    //   632	641	962	finally
    //   654	670	962	finally
    //   690	702	962	finally
    //   715	723	962	finally
    //   747	752	962	finally
    //   773	784	962	finally
    //   797	804	962	finally
    //   820	835	962	finally
    //   890	895	962	finally
    //   224	231	970	java/lang/Throwable
    //   303	318	970	java/lang/Throwable
    //   333	343	977	java/lang/Throwable
    //   362	369	977	java/lang/Throwable
    //   400	410	977	java/lang/Throwable
    //   429	436	977	java/lang/Throwable
    //   448	455	977	java/lang/Throwable
    //   480	487	977	java/lang/Throwable
    //   502	508	977	java/lang/Throwable
    //   520	528	977	java/lang/Throwable
    //   540	545	977	java/lang/Throwable
    //   567	584	977	java/lang/Throwable
    //   608	617	977	java/lang/Throwable
    //   632	641	977	java/lang/Throwable
    //   654	670	977	java/lang/Throwable
    //   690	702	977	java/lang/Throwable
    //   715	723	977	java/lang/Throwable
    //   747	752	977	java/lang/Throwable
    //   773	784	977	java/lang/Throwable
    //   797	804	977	java/lang/Throwable
    //   820	835	977	java/lang/Throwable
    //   245	250	982	java/io/IOException
    //   257	262	982	java/io/IOException
    //   25	33	988	java/io/IOException
    //   37	45	988	java/io/IOException
  }
  
  private static PublicKey b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = cAO;
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(arnj.KEY_TYPE).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance(arnj.cAN);
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnk
 * JD-Core Version:    0.7.0.1
 */