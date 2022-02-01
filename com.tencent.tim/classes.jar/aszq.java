import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class aszq
{
  /* Error */
  public static int ag(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: ldc 12
    //   6: invokestatic 16	aszq:b	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   9: astore 14
    //   11: aload 14
    //   13: ifnonnull +33 -> 46
    //   16: sipush 129
    //   19: istore_2
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 18	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 18	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: iload_2
    //   45: ireturn
    //   46: aload_0
    //   47: ifnull +21 -> 68
    //   50: iload_3
    //   51: istore_2
    //   52: ldc 24
    //   54: aload_0
    //   55: invokevirtual 30	java/lang/String:trim	()Ljava/lang/String;
    //   58: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: istore 7
    //   63: iload 7
    //   65: ifeq +34 -> 99
    //   68: bipush 17
    //   70: istore_2
    //   71: iconst_0
    //   72: ifeq +11 -> 83
    //   75: new 18	java/lang/NullPointerException
    //   78: dup
    //   79: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   82: athrow
    //   83: iconst_0
    //   84: ifeq -40 -> 44
    //   87: new 18	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: astore_0
    //   96: bipush 17
    //   98: ireturn
    //   99: iload_3
    //   100: istore_2
    //   101: new 36	java/io/File
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 8
    //   111: aload 8
    //   113: ifnull +17 -> 130
    //   116: iload_3
    //   117: istore_2
    //   118: aload 8
    //   120: invokevirtual 43	java/io/File:exists	()Z
    //   123: istore 7
    //   125: iload 7
    //   127: ifne +32 -> 159
    //   130: iconst_3
    //   131: istore_2
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 18	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iconst_0
    //   145: ifeq -101 -> 44
    //   148: new 18	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: astore_0
    //   157: iconst_3
    //   158: ireturn
    //   159: bipush 33
    //   161: istore_2
    //   162: aload_0
    //   163: invokestatic 49	aszp:z	(Ljava/lang/String;)Ljava/util/Map;
    //   166: astore 13
    //   168: aload 13
    //   170: ifnonnull +36 -> 206
    //   173: sipush 142
    //   176: istore_2
    //   177: iconst_0
    //   178: ifeq +11 -> 189
    //   181: new 18	java/lang/NullPointerException
    //   184: dup
    //   185: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   188: athrow
    //   189: iconst_0
    //   190: ifeq -146 -> 44
    //   193: new 18	java/lang/NullPointerException
    //   196: dup
    //   197: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   200: athrow
    //   201: astore_0
    //   202: sipush 142
    //   205: ireturn
    //   206: bipush 34
    //   208: istore_3
    //   209: iload_3
    //   210: istore_2
    //   211: new 51	java/util/jar/JarFile
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 52	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   219: astore 8
    //   221: iload_3
    //   222: istore_2
    //   223: aload 8
    //   225: aload_1
    //   226: invokevirtual 56	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   229: astore_0
    //   230: aload_0
    //   231: ifnonnull +67 -> 298
    //   234: iconst_5
    //   235: istore_2
    //   236: aconst_null
    //   237: astore 10
    //   239: aload 10
    //   241: ifnull +8 -> 249
    //   244: aload 10
    //   246: invokevirtual 61	java/io/DataInputStream:close	()V
    //   249: iload_2
    //   250: istore_3
    //   251: aload 8
    //   253: ifnull +10 -> 263
    //   256: aload 8
    //   258: invokevirtual 62	java/util/jar/JarFile:close	()V
    //   261: iload_2
    //   262: istore_3
    //   263: iload_3
    //   264: istore_2
    //   265: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq -224 -> 44
    //   271: ldc 69
    //   273: iconst_2
    //   274: new 71	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   281: ldc 74
    //   283: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload_3
    //   287: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 88	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: iload_3
    //   297: ireturn
    //   298: bipush 36
    //   300: istore_2
    //   301: new 58	java/io/DataInputStream
    //   304: dup
    //   305: aload 8
    //   307: aload_0
    //   308: invokevirtual 92	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   311: invokespecial 95	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   314: astore 10
    //   316: bipush 37
    //   318: istore_3
    //   319: aload 8
    //   321: astore 9
    //   323: aload 10
    //   325: astore_0
    //   326: iload_3
    //   327: istore_2
    //   328: aload 10
    //   330: astore_1
    //   331: aload 10
    //   333: invokevirtual 99	java/io/DataInputStream:readInt	()I
    //   336: ldc 100
    //   338: if_icmpeq +10 -> 348
    //   341: sipush 132
    //   344: istore_2
    //   345: goto -106 -> 239
    //   348: aload 8
    //   350: astore 9
    //   352: aload 10
    //   354: astore_0
    //   355: iload_3
    //   356: istore_2
    //   357: aload 10
    //   359: astore_1
    //   360: aload 10
    //   362: invokevirtual 99	java/io/DataInputStream:readInt	()I
    //   365: istore 4
    //   367: iload 4
    //   369: sipush 128
    //   372: if_icmplt +631 -> 1003
    //   375: iload 4
    //   377: sipush 256
    //   380: if_icmple +6 -> 386
    //   383: goto +620 -> 1003
    //   386: aload 8
    //   388: astore 9
    //   390: aload 10
    //   392: astore_0
    //   393: iload_3
    //   394: istore_2
    //   395: aload 10
    //   397: astore_1
    //   398: aload 10
    //   400: invokevirtual 99	java/io/DataInputStream:readInt	()I
    //   403: ldc 101
    //   405: if_icmpeq +10 -> 415
    //   408: sipush 134
    //   411: istore_2
    //   412: goto -173 -> 239
    //   415: aload 8
    //   417: astore 9
    //   419: aload 10
    //   421: astore_0
    //   422: iload_3
    //   423: istore_2
    //   424: aload 10
    //   426: astore_1
    //   427: aload 10
    //   429: invokevirtual 99	java/io/DataInputStream:readInt	()I
    //   432: istore 5
    //   434: aload 8
    //   436: astore 9
    //   438: aload 10
    //   440: astore_0
    //   441: iload_3
    //   442: istore_2
    //   443: aload 10
    //   445: astore_1
    //   446: aload 10
    //   448: invokevirtual 99	java/io/DataInputStream:readInt	()I
    //   451: istore 6
    //   453: iload 6
    //   455: ifgt +10 -> 465
    //   458: sipush 135
    //   461: istore_2
    //   462: goto -223 -> 239
    //   465: bipush 38
    //   467: istore_2
    //   468: aload 8
    //   470: astore 9
    //   472: aload 10
    //   474: astore_0
    //   475: aload 10
    //   477: astore_1
    //   478: aload 10
    //   480: invokevirtual 104	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   483: astore 15
    //   485: bipush 39
    //   487: istore_3
    //   488: aload 8
    //   490: astore 9
    //   492: aload 10
    //   494: astore_0
    //   495: iload_3
    //   496: istore_2
    //   497: aload 10
    //   499: astore_1
    //   500: iload 4
    //   502: newarray byte
    //   504: astore 16
    //   506: aload 8
    //   508: astore 9
    //   510: aload 10
    //   512: astore_0
    //   513: iload_3
    //   514: istore_2
    //   515: aload 10
    //   517: astore_1
    //   518: aload 10
    //   520: aload 16
    //   522: invokevirtual 108	java/io/DataInputStream:read	([B)I
    //   525: pop
    //   526: aload 8
    //   528: astore 9
    //   530: aload 10
    //   532: astore_0
    //   533: iload_3
    //   534: istore_2
    //   535: aload 10
    //   537: astore_1
    //   538: aload 10
    //   540: invokevirtual 61	java/io/DataInputStream:close	()V
    //   543: aconst_null
    //   544: astore 11
    //   546: aconst_null
    //   547: astore 10
    //   549: aconst_null
    //   550: astore 12
    //   552: bipush 40
    //   554: istore_2
    //   555: aload 8
    //   557: astore 9
    //   559: aload 11
    //   561: astore_0
    //   562: aload 10
    //   564: astore_1
    //   565: aload 15
    //   567: ldc 110
    //   569: invokevirtual 114	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   572: aload 16
    //   574: aload 14
    //   576: invokestatic 117	aszq:b	([B[BLjava/security/PublicKey;)Z
    //   579: ifne +14 -> 593
    //   582: sipush 137
    //   585: istore_2
    //   586: aload 12
    //   588: astore 10
    //   590: goto -351 -> 239
    //   593: bipush 41
    //   595: istore 4
    //   597: aload 8
    //   599: astore 9
    //   601: aload 11
    //   603: astore_0
    //   604: iload 4
    //   606: istore_2
    //   607: aload 10
    //   609: astore_1
    //   610: new 71	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   617: astore 14
    //   619: iconst_0
    //   620: istore_3
    //   621: aload 8
    //   623: astore 9
    //   625: aload 11
    //   627: astore_0
    //   628: iload 4
    //   630: istore_2
    //   631: aload 10
    //   633: astore_1
    //   634: iload_3
    //   635: aload 15
    //   637: invokevirtual 120	java/lang/String:length	()I
    //   640: if_icmpge +39 -> 679
    //   643: aload 8
    //   645: astore 9
    //   647: aload 11
    //   649: astore_0
    //   650: iload 4
    //   652: istore_2
    //   653: aload 10
    //   655: astore_1
    //   656: aload 14
    //   658: aload 15
    //   660: iload_3
    //   661: invokevirtual 124	java/lang/String:charAt	(I)C
    //   664: iload 5
    //   666: ixor
    //   667: i2c
    //   668: invokevirtual 127	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: iload_3
    //   673: iconst_1
    //   674: iadd
    //   675: istore_3
    //   676: goto -55 -> 621
    //   679: aload 8
    //   681: astore 9
    //   683: aload 11
    //   685: astore_0
    //   686: iload 4
    //   688: istore_2
    //   689: aload 10
    //   691: astore_1
    //   692: aload 14
    //   694: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: ldc 129
    //   699: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   702: astore 14
    //   704: aload 8
    //   706: astore 9
    //   708: aload 11
    //   710: astore_0
    //   711: iload 4
    //   713: istore_2
    //   714: aload 10
    //   716: astore_1
    //   717: aload 14
    //   719: arraylength
    //   720: iload 6
    //   722: if_icmpeq +14 -> 736
    //   725: sipush 135
    //   728: istore_2
    //   729: aload 12
    //   731: astore 10
    //   733: goto -494 -> 239
    //   736: bipush 42
    //   738: istore 5
    //   740: aload 8
    //   742: astore 9
    //   744: aload 11
    //   746: astore_0
    //   747: iload 5
    //   749: istore_2
    //   750: aload 10
    //   752: astore_1
    //   753: aload 14
    //   755: arraylength
    //   756: istore 6
    //   758: iconst_0
    //   759: istore_3
    //   760: iload_3
    //   761: iload 6
    //   763: if_icmpge +115 -> 878
    //   766: aload 8
    //   768: astore 9
    //   770: aload 11
    //   772: astore_0
    //   773: iload 5
    //   775: istore_2
    //   776: aload 10
    //   778: astore_1
    //   779: aload 14
    //   781: iload_3
    //   782: aaload
    //   783: ldc 135
    //   785: invokevirtual 133	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   788: astore 15
    //   790: aload 8
    //   792: astore 9
    //   794: aload 11
    //   796: astore_0
    //   797: iload 5
    //   799: istore_2
    //   800: aload 10
    //   802: astore_1
    //   803: aload 15
    //   805: arraylength
    //   806: iconst_2
    //   807: if_icmpeq +6 -> 813
    //   810: goto +200 -> 1010
    //   813: aload 8
    //   815: astore 9
    //   817: aload 11
    //   819: astore_0
    //   820: iload 5
    //   822: istore_2
    //   823: aload 10
    //   825: astore_1
    //   826: aload 13
    //   828: aload 15
    //   830: iconst_0
    //   831: aaload
    //   832: aload 15
    //   834: iconst_1
    //   835: aaload
    //   836: invokestatic 139	aszp:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   839: istore 4
    //   841: iload 4
    //   843: ifeq +167 -> 1010
    //   846: iconst_0
    //   847: ifeq +11 -> 858
    //   850: new 18	java/lang/NullPointerException
    //   853: dup
    //   854: invokespecial 22	java/lang/NullPointerException:<init>	()V
    //   857: athrow
    //   858: iload 4
    //   860: istore_2
    //   861: aload 8
    //   863: ifnull -819 -> 44
    //   866: aload 8
    //   868: invokevirtual 62	java/util/jar/JarFile:close	()V
    //   871: iload 4
    //   873: ireturn
    //   874: astore_0
    //   875: iload 4
    //   877: ireturn
    //   878: iconst_0
    //   879: istore_2
    //   880: aload 12
    //   882: astore 10
    //   884: goto -645 -> 239
    //   887: astore 10
    //   889: aconst_null
    //   890: astore 8
    //   892: aconst_null
    //   893: astore_1
    //   894: aload 8
    //   896: astore 9
    //   898: aload_1
    //   899: astore_0
    //   900: aload 10
    //   902: invokevirtual 142	java/lang/Throwable:printStackTrace	()V
    //   905: aload_1
    //   906: ifnull +7 -> 913
    //   909: aload_1
    //   910: invokevirtual 61	java/io/DataInputStream:close	()V
    //   913: iload_2
    //   914: istore_3
    //   915: aload 8
    //   917: ifnull -654 -> 263
    //   920: aload 8
    //   922: invokevirtual 62	java/util/jar/JarFile:close	()V
    //   925: iload_2
    //   926: istore_3
    //   927: goto -664 -> 263
    //   930: astore_0
    //   931: iload_2
    //   932: istore_3
    //   933: goto -670 -> 263
    //   936: astore_1
    //   937: aconst_null
    //   938: astore 8
    //   940: aconst_null
    //   941: astore_0
    //   942: aload_0
    //   943: ifnull +7 -> 950
    //   946: aload_0
    //   947: invokevirtual 61	java/io/DataInputStream:close	()V
    //   950: aload 8
    //   952: ifnull +8 -> 960
    //   955: aload 8
    //   957: invokevirtual 62	java/util/jar/JarFile:close	()V
    //   960: aload_1
    //   961: athrow
    //   962: astore_0
    //   963: goto -3 -> 960
    //   966: astore_1
    //   967: aconst_null
    //   968: astore_0
    //   969: goto -27 -> 942
    //   972: astore_1
    //   973: aload 9
    //   975: astore 8
    //   977: goto -35 -> 942
    //   980: astore 10
    //   982: aconst_null
    //   983: astore_1
    //   984: goto -90 -> 894
    //   987: astore 10
    //   989: goto -95 -> 894
    //   992: astore_0
    //   993: iload_2
    //   994: istore_3
    //   995: goto -732 -> 263
    //   998: astore_0
    //   999: sipush 129
    //   1002: ireturn
    //   1003: sipush 133
    //   1006: istore_2
    //   1007: goto -768 -> 239
    //   1010: iload_3
    //   1011: iconst_1
    //   1012: iadd
    //   1013: istore_3
    //   1014: goto -254 -> 760
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1017	0	paramString1	String
    //   0	1017	1	paramString2	String
    //   3	1004	2	i	int
    //   1	1013	3	j	int
    //   365	511	4	k	int
    //   432	389	5	m	int
    //   451	313	6	n	int
    //   61	65	7	bool	boolean
    //   109	867	8	localObject1	Object
    //   321	653	9	localObject2	Object
    //   237	646	10	localObject3	Object
    //   887	14	10	localThrowable1	java.lang.Throwable
    //   980	1	10	localThrowable2	java.lang.Throwable
    //   987	1	10	localThrowable3	java.lang.Throwable
    //   544	274	11	localObject4	Object
    //   550	331	12	localObject5	Object
    //   166	661	13	localMap	java.util.Map
    //   9	771	14	localObject6	Object
    //   483	350	15	localObject7	Object
    //   504	69	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   75	83	95	java/io/IOException
    //   87	95	95	java/io/IOException
    //   136	144	156	java/io/IOException
    //   148	156	156	java/io/IOException
    //   181	189	201	java/io/IOException
    //   193	201	201	java/io/IOException
    //   850	858	874	java/io/IOException
    //   866	871	874	java/io/IOException
    //   4	11	887	java/lang/Throwable
    //   52	63	887	java/lang/Throwable
    //   101	111	887	java/lang/Throwable
    //   118	125	887	java/lang/Throwable
    //   162	168	887	java/lang/Throwable
    //   211	221	887	java/lang/Throwable
    //   909	913	930	java/io/IOException
    //   920	925	930	java/io/IOException
    //   4	11	936	finally
    //   52	63	936	finally
    //   101	111	936	finally
    //   118	125	936	finally
    //   162	168	936	finally
    //   211	221	936	finally
    //   946	950	962	java/io/IOException
    //   955	960	962	java/io/IOException
    //   223	230	966	finally
    //   301	316	966	finally
    //   331	341	972	finally
    //   360	367	972	finally
    //   398	408	972	finally
    //   427	434	972	finally
    //   446	453	972	finally
    //   478	485	972	finally
    //   500	506	972	finally
    //   518	526	972	finally
    //   538	543	972	finally
    //   565	582	972	finally
    //   610	619	972	finally
    //   634	643	972	finally
    //   656	672	972	finally
    //   692	704	972	finally
    //   717	725	972	finally
    //   753	758	972	finally
    //   779	790	972	finally
    //   803	810	972	finally
    //   826	841	972	finally
    //   900	905	972	finally
    //   223	230	980	java/lang/Throwable
    //   301	316	980	java/lang/Throwable
    //   331	341	987	java/lang/Throwable
    //   360	367	987	java/lang/Throwable
    //   398	408	987	java/lang/Throwable
    //   427	434	987	java/lang/Throwable
    //   446	453	987	java/lang/Throwable
    //   478	485	987	java/lang/Throwable
    //   500	506	987	java/lang/Throwable
    //   518	526	987	java/lang/Throwable
    //   538	543	987	java/lang/Throwable
    //   565	582	987	java/lang/Throwable
    //   610	619	987	java/lang/Throwable
    //   634	643	987	java/lang/Throwable
    //   656	672	987	java/lang/Throwable
    //   692	704	987	java/lang/Throwable
    //   717	725	987	java/lang/Throwable
    //   753	758	987	java/lang/Throwable
    //   779	790	987	java/lang/Throwable
    //   803	810	987	java/lang/Throwable
    //   826	841	987	java/lang/Throwable
    //   244	249	992	java/io/IOException
    //   256	261	992	java/io/IOException
    //   24	32	998	java/io/IOException
    //   36	44	998	java/io/IOException
  }
  
  private static PublicKey b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOEXXbretliROuhm/THXQOZ33e1bIvgPNnGFqrmALpZFXZ51u1CWJMBNXBX0us9jBHUlWSn5Pmz+kPLe7VHh1PrmzrSTxBH6dJq3iRclhyDFTc6txsOm92p/yaSwOaK/OP50YzAYcBT3lhjhQ5mvTUSzFN3gZLfr89sjuix+40dwIDAQAB";
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
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
      Signature localSignature = Signature.getInstance("MD5withRSA");
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
 * Qualified Name:     aszq
 * JD-Core Version:    0.7.0.1
 */