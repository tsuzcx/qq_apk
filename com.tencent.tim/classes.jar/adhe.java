import android.content.Context;
import com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter;
import com.tencent.qphone.base.util.QLog;

public class adhe
{
  public static int cFE;
  public static int cFF = 1;
  Context T = null;
  private boolean bNg;
  private boolean bNh;
  private int cFG;
  private int cFH;
  private int cFI;
  private int cFJ = 10;
  private int cFK = 170;
  private int cFL = 640;
  private int cFM = 480;
  private int cFN;
  public int cFO = -2147483648;
  public int cFP = -2147483648;
  private byte[] dh;
  private byte[] di;
  private byte[] dj;
  private byte[] dk;
  private int mImgHeight;
  private int mImgWidth;
  
  public adhe(int paramInt)
  {
    this.cFG = paramInt;
    if ((paramInt == cFE) && (aknv.a() != null))
    {
      this.cFJ = aknv.a().dnU;
      this.cFK = aknv.a().dnV;
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARCloudImageSelect", 2, "init args ocr bestImgThreshold:" + this.cFJ + ",sameSceneDiff:" + this.cFK);
      }
    }
  }
  
  public byte[] T()
  {
    return this.di;
  }
  
  /* Error */
  public boolean c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 110	adhe:mImgWidth	I
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 112	adhe:mImgHeight	I
    //   11: ifne +149 -> 160
    //   14: ldc 77
    //   16: iconst_1
    //   17: ldc 114
    //   19: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iload_2
    //   24: putfield 110	adhe:mImgWidth	I
    //   27: aload_0
    //   28: iload_3
    //   29: putfield 112	adhe:mImgHeight	I
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 110	adhe:mImgWidth	I
    //   37: aload_0
    //   38: getfield 112	adhe:mImgHeight	I
    //   41: imul
    //   42: putfield 119	adhe:cFH	I
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 110	adhe:mImgWidth	I
    //   50: aload_0
    //   51: getfield 112	adhe:mImgHeight	I
    //   54: imul
    //   55: iconst_3
    //   56: imul
    //   57: iconst_2
    //   58: idiv
    //   59: putfield 121	adhe:cFI	I
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 119	adhe:cFH	I
    //   67: newarray byte
    //   69: putfield 123	adhe:dh	[B
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 121	adhe:cFI	I
    //   77: newarray byte
    //   79: putfield 102	adhe:di	[B
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 119	adhe:cFH	I
    //   87: newarray byte
    //   89: putfield 125	adhe:dk	[B
    //   92: aload_0
    //   93: getfield 110	adhe:mImgWidth	I
    //   96: aload_0
    //   97: getfield 112	adhe:mImgHeight	I
    //   100: if_icmple +553 -> 653
    //   103: aload_0
    //   104: getfield 110	adhe:mImgWidth	I
    //   107: sipush 480
    //   110: if_icmplt +460 -> 570
    //   113: aload_0
    //   114: getfield 112	adhe:mImgHeight	I
    //   117: sipush 480
    //   120: if_icmplt +450 -> 570
    //   123: aload_0
    //   124: sipush 480
    //   127: putfield 46	adhe:cFL	I
    //   130: aload_0
    //   131: sipush 480
    //   134: putfield 48	adhe:cFM	I
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 46	adhe:cFL	I
    //   142: aload_0
    //   143: getfield 48	adhe:cFM	I
    //   146: imul
    //   147: putfield 127	adhe:cFN	I
    //   150: aload_0
    //   151: aload_0
    //   152: getfield 127	adhe:cFN	I
    //   155: newarray byte
    //   157: putfield 129	adhe:dj	[B
    //   160: aload_0
    //   161: getfield 110	adhe:mImgWidth	I
    //   164: iload_2
    //   165: if_icmpne +11 -> 176
    //   168: aload_0
    //   169: getfield 112	adhe:mImgHeight	I
    //   172: iload_3
    //   173: if_icmpeq +161 -> 334
    //   176: aload_0
    //   177: iload_2
    //   178: putfield 110	adhe:mImgWidth	I
    //   181: aload_0
    //   182: iload_3
    //   183: putfield 112	adhe:mImgHeight	I
    //   186: aload_0
    //   187: aload_0
    //   188: getfield 110	adhe:mImgWidth	I
    //   191: aload_0
    //   192: getfield 112	adhe:mImgHeight	I
    //   195: imul
    //   196: putfield 119	adhe:cFH	I
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 110	adhe:mImgWidth	I
    //   204: aload_0
    //   205: getfield 112	adhe:mImgHeight	I
    //   208: imul
    //   209: iconst_3
    //   210: imul
    //   211: iconst_2
    //   212: idiv
    //   213: putfield 121	adhe:cFI	I
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 119	adhe:cFH	I
    //   221: newarray byte
    //   223: putfield 123	adhe:dh	[B
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 121	adhe:cFI	I
    //   231: newarray byte
    //   233: putfield 102	adhe:di	[B
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 119	adhe:cFH	I
    //   241: newarray byte
    //   243: putfield 125	adhe:dk	[B
    //   246: aload_0
    //   247: getfield 110	adhe:mImgWidth	I
    //   250: aload_0
    //   251: getfield 112	adhe:mImgHeight	I
    //   254: if_icmple +474 -> 728
    //   257: aload_0
    //   258: getfield 110	adhe:mImgWidth	I
    //   261: sipush 480
    //   264: if_icmplt +445 -> 709
    //   267: aload_0
    //   268: getfield 112	adhe:mImgHeight	I
    //   271: sipush 480
    //   274: if_icmplt +435 -> 709
    //   277: aload_0
    //   278: sipush 480
    //   281: putfield 46	adhe:cFL	I
    //   284: aload_0
    //   285: sipush 480
    //   288: putfield 48	adhe:cFM	I
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 46	adhe:cFL	I
    //   296: aload_0
    //   297: getfield 48	adhe:cFM	I
    //   300: imul
    //   301: putfield 127	adhe:cFN	I
    //   304: aload_0
    //   305: aload_0
    //   306: getfield 127	adhe:cFN	I
    //   309: newarray byte
    //   311: putfield 129	adhe:dj	[B
    //   314: aload_0
    //   315: getfield 131	adhe:bNg	Z
    //   318: istore 5
    //   320: iload 5
    //   322: ifeq +12 -> 334
    //   325: invokestatic 137	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeUninit	()I
    //   328: pop
    //   329: aload_0
    //   330: iconst_0
    //   331: putfield 131	adhe:bNg	Z
    //   334: aload_0
    //   335: getfield 131	adhe:bNg	Z
    //   338: ifne +104 -> 442
    //   341: invokestatic 142	adfn:a	()Ladfn;
    //   344: invokevirtual 145	adfn:aee	()Z
    //   347: ifeq +471 -> 818
    //   350: iconst_1
    //   351: istore_2
    //   352: aload_0
    //   353: getfield 55	adhe:cFG	I
    //   356: getstatic 57	adhe:cFE	I
    //   359: if_icmpne +464 -> 823
    //   362: aload_0
    //   363: getfield 110	adhe:mImgWidth	I
    //   366: aload_0
    //   367: getfield 112	adhe:mImgHeight	I
    //   370: aload_0
    //   371: getfield 42	adhe:cFJ	I
    //   374: aload_0
    //   375: getfield 44	adhe:cFK	I
    //   378: aload_0
    //   379: getfield 121	adhe:cFI	I
    //   382: invokestatic 149	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeInitOcr	(IIIII)I
    //   385: pop
    //   386: iload_2
    //   387: iconst_1
    //   388: if_icmpne +496 -> 884
    //   391: aload_0
    //   392: iload_2
    //   393: invokestatic 153	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeSetNeonOpen	(I)I
    //   396: putfield 51	adhe:cFO	I
    //   399: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +35 -> 437
    //   405: ldc 77
    //   407: iconst_2
    //   408: ldc 155
    //   410: iconst_2
    //   411: anewarray 4	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: iconst_0
    //   417: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: dup
    //   422: iconst_1
    //   423: aload_0
    //   424: getfield 51	adhe:cFO	I
    //   427: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   434: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload_0
    //   438: iconst_1
    //   439: putfield 131	adhe:bNg	Z
    //   442: aload_0
    //   443: getfield 55	adhe:cFG	I
    //   446: getstatic 57	adhe:cFE	I
    //   449: if_icmpne +443 -> 892
    //   452: aload_1
    //   453: iconst_0
    //   454: aload_0
    //   455: getfield 123	adhe:dh	[B
    //   458: iconst_0
    //   459: aload_0
    //   460: getfield 119	adhe:cFH	I
    //   463: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   466: aload_1
    //   467: iconst_0
    //   468: aload_0
    //   469: getfield 102	adhe:di	[B
    //   472: iconst_0
    //   473: aload_0
    //   474: getfield 121	adhe:cFI	I
    //   477: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   480: lconst_0
    //   481: lstore 6
    //   483: getstatic 176	adfn:bMz	Z
    //   486: ifeq +8 -> 494
    //   489: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   492: lstore 6
    //   494: aload_0
    //   495: getfield 55	adhe:cFG	I
    //   498: getstatic 57	adhe:cFE	I
    //   501: if_icmpne +511 -> 1012
    //   504: aload_0
    //   505: aload_0
    //   506: getfield 123	adhe:dh	[B
    //   509: aload_0
    //   510: getfield 102	adhe:di	[B
    //   513: invokestatic 184	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeFilter	([B[B)Z
    //   516: putfield 186	adhe:bNh	Z
    //   519: aload_0
    //   520: getfield 186	adhe:bNh	Z
    //   523: ifeq +20 -> 543
    //   526: aload_0
    //   527: getfield 123	adhe:dh	[B
    //   530: iconst_0
    //   531: aload_0
    //   532: getfield 125	adhe:dk	[B
    //   535: iconst_0
    //   536: aload_0
    //   537: getfield 119	adhe:cFH	I
    //   540: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   543: getstatic 176	adfn:bMz	Z
    //   546: ifeq +19 -> 565
    //   549: invokestatic 142	adfn:a	()Ladfn;
    //   552: invokestatic 180	java/lang/System:currentTimeMillis	()J
    //   555: lload 6
    //   557: lsub
    //   558: aload_0
    //   559: getfield 51	adhe:cFO	I
    //   562: invokevirtual 190	adfn:aC	(JI)V
    //   565: aload_0
    //   566: getfield 186	adhe:bNh	Z
    //   569: ireturn
    //   570: aload_0
    //   571: aload_0
    //   572: getfield 110	adhe:mImgWidth	I
    //   575: putfield 46	adhe:cFL	I
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 112	adhe:mImgHeight	I
    //   583: putfield 48	adhe:cFM	I
    //   586: goto -449 -> 137
    //   589: astore_1
    //   590: ldc 77
    //   592: iconst_1
    //   593: new 79	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   600: ldc 192
    //   602: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_1
    //   606: invokevirtual 195	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   609: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: aload_0
    //   619: aconst_null
    //   620: putfield 123	adhe:dh	[B
    //   623: aload_0
    //   624: aconst_null
    //   625: putfield 102	adhe:di	[B
    //   628: aload_0
    //   629: aconst_null
    //   630: putfield 129	adhe:dj	[B
    //   633: aload_0
    //   634: iconst_0
    //   635: putfield 110	adhe:mImgWidth	I
    //   638: aload_0
    //   639: iconst_0
    //   640: putfield 112	adhe:mImgHeight	I
    //   643: aload_0
    //   644: aconst_null
    //   645: putfield 125	adhe:dk	[B
    //   648: invokestatic 198	java/lang/System:gc	()V
    //   651: iconst_0
    //   652: ireturn
    //   653: aload_0
    //   654: getfield 110	adhe:mImgWidth	I
    //   657: sipush 480
    //   660: if_icmplt +30 -> 690
    //   663: aload_0
    //   664: getfield 112	adhe:mImgHeight	I
    //   667: sipush 480
    //   670: if_icmplt +20 -> 690
    //   673: aload_0
    //   674: sipush 480
    //   677: putfield 46	adhe:cFL	I
    //   680: aload_0
    //   681: sipush 480
    //   684: putfield 48	adhe:cFM	I
    //   687: goto -550 -> 137
    //   690: aload_0
    //   691: aload_0
    //   692: getfield 110	adhe:mImgWidth	I
    //   695: putfield 46	adhe:cFL	I
    //   698: aload_0
    //   699: aload_0
    //   700: getfield 112	adhe:mImgHeight	I
    //   703: putfield 48	adhe:cFM	I
    //   706: goto -569 -> 137
    //   709: aload_0
    //   710: aload_0
    //   711: getfield 110	adhe:mImgWidth	I
    //   714: putfield 46	adhe:cFL	I
    //   717: aload_0
    //   718: aload_0
    //   719: getfield 112	adhe:mImgHeight	I
    //   722: putfield 48	adhe:cFM	I
    //   725: goto -434 -> 291
    //   728: aload_0
    //   729: getfield 110	adhe:mImgWidth	I
    //   732: sipush 480
    //   735: if_icmplt +30 -> 765
    //   738: aload_0
    //   739: getfield 112	adhe:mImgHeight	I
    //   742: sipush 480
    //   745: if_icmplt +20 -> 765
    //   748: aload_0
    //   749: sipush 480
    //   752: putfield 46	adhe:cFL	I
    //   755: aload_0
    //   756: sipush 480
    //   759: putfield 48	adhe:cFM	I
    //   762: goto -471 -> 291
    //   765: aload_0
    //   766: aload_0
    //   767: getfield 110	adhe:mImgWidth	I
    //   770: putfield 46	adhe:cFL	I
    //   773: aload_0
    //   774: aload_0
    //   775: getfield 112	adhe:mImgHeight	I
    //   778: putfield 48	adhe:cFM	I
    //   781: goto -490 -> 291
    //   784: astore 8
    //   786: ldc 77
    //   788: iconst_1
    //   789: new 79	java/lang/StringBuilder
    //   792: dup
    //   793: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   796: ldc 200
    //   798: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 8
    //   803: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   806: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: goto -486 -> 329
    //   818: iconst_0
    //   819: istore_2
    //   820: goto -468 -> 352
    //   823: aload_0
    //   824: getfield 46	adhe:cFL	I
    //   827: aload_0
    //   828: getfield 48	adhe:cFM	I
    //   831: aload_0
    //   832: getfield 42	adhe:cFJ	I
    //   835: aload_0
    //   836: getfield 44	adhe:cFK	I
    //   839: aload_0
    //   840: getfield 121	adhe:cFI	I
    //   843: invokestatic 204	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeInit	(IIIII)I
    //   846: pop
    //   847: goto -461 -> 386
    //   850: astore 8
    //   852: ldc 77
    //   854: iconst_1
    //   855: new 79	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   862: ldc 206
    //   864: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 8
    //   869: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   872: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   881: goto -444 -> 437
    //   884: aload_0
    //   885: iconst_0
    //   886: putfield 51	adhe:cFO	I
    //   889: goto -490 -> 399
    //   892: aload_0
    //   893: getfield 110	adhe:mImgWidth	I
    //   896: aload_0
    //   897: getfield 46	adhe:cFL	I
    //   900: if_icmpne +14 -> 914
    //   903: aload_0
    //   904: getfield 112	adhe:mImgHeight	I
    //   907: aload_0
    //   908: getfield 48	adhe:cFM	I
    //   911: if_icmpeq +84 -> 995
    //   914: aload_0
    //   915: getfield 110	adhe:mImgWidth	I
    //   918: aload_0
    //   919: getfield 46	adhe:cFL	I
    //   922: isub
    //   923: iconst_2
    //   924: idiv
    //   925: istore_3
    //   926: aload_0
    //   927: getfield 46	adhe:cFL	I
    //   930: istore_2
    //   931: aload_0
    //   932: getfield 112	adhe:mImgHeight	I
    //   935: aload_0
    //   936: getfield 48	adhe:cFM	I
    //   939: isub
    //   940: iconst_2
    //   941: idiv
    //   942: istore 4
    //   944: aload_0
    //   945: getfield 48	adhe:cFM	I
    //   948: istore_2
    //   949: iconst_0
    //   950: istore_2
    //   951: iload_2
    //   952: aload_0
    //   953: getfield 48	adhe:cFM	I
    //   956: if_icmpge -490 -> 466
    //   959: aload_1
    //   960: iload_2
    //   961: iload 4
    //   963: iadd
    //   964: aload_0
    //   965: getfield 110	adhe:mImgWidth	I
    //   968: imul
    //   969: iload_3
    //   970: iadd
    //   971: aload_0
    //   972: getfield 129	adhe:dj	[B
    //   975: aload_0
    //   976: getfield 46	adhe:cFL	I
    //   979: iload_2
    //   980: imul
    //   981: aload_0
    //   982: getfield 46	adhe:cFL	I
    //   985: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   988: iload_2
    //   989: iconst_1
    //   990: iadd
    //   991: istore_2
    //   992: goto -41 -> 951
    //   995: aload_1
    //   996: iconst_0
    //   997: aload_0
    //   998: getfield 129	adhe:dj	[B
    //   1001: iconst_0
    //   1002: aload_0
    //   1003: getfield 127	adhe:cFN	I
    //   1006: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1009: goto -543 -> 466
    //   1012: aload_0
    //   1013: aload_0
    //   1014: getfield 129	adhe:dj	[B
    //   1017: aload_0
    //   1018: getfield 102	adhe:di	[B
    //   1021: invokestatic 184	com/tencent/mobileqq/ar/arcloud/ARCloudImageFilter:nativeFilter	([B[B)Z
    //   1024: putfield 186	adhe:bNh	Z
    //   1027: aload_0
    //   1028: getfield 186	adhe:bNh	Z
    //   1031: ifeq -488 -> 543
    //   1034: aload_0
    //   1035: getfield 129	adhe:dj	[B
    //   1038: iconst_0
    //   1039: aload_0
    //   1040: getfield 125	adhe:dk	[B
    //   1043: iconst_0
    //   1044: aload_0
    //   1045: getfield 127	adhe:cFN	I
    //   1048: invokestatic 173	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1051: goto -508 -> 543
    //   1054: astore_1
    //   1055: ldc 77
    //   1057: iconst_1
    //   1058: new 79	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1065: ldc 208
    //   1067: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_1
    //   1071: invokevirtual 201	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1074: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 117	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: goto -518 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1086	0	this	adhe
    //   0	1086	1	paramArrayOfByte	byte[]
    //   0	1086	2	paramInt1	int
    //   0	1086	3	paramInt2	int
    //   942	22	4	i	int
    //   318	3	5	bool	boolean
    //   481	75	6	l	long
    //   784	18	8	localException1	Exception
    //   850	18	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	589	java/lang/OutOfMemoryError
    //   14	137	589	java/lang/OutOfMemoryError
    //   137	160	589	java/lang/OutOfMemoryError
    //   160	176	589	java/lang/OutOfMemoryError
    //   176	291	589	java/lang/OutOfMemoryError
    //   291	320	589	java/lang/OutOfMemoryError
    //   325	329	589	java/lang/OutOfMemoryError
    //   329	334	589	java/lang/OutOfMemoryError
    //   570	586	589	java/lang/OutOfMemoryError
    //   653	687	589	java/lang/OutOfMemoryError
    //   690	706	589	java/lang/OutOfMemoryError
    //   709	725	589	java/lang/OutOfMemoryError
    //   728	762	589	java/lang/OutOfMemoryError
    //   765	781	589	java/lang/OutOfMemoryError
    //   786	815	589	java/lang/OutOfMemoryError
    //   325	329	784	java/lang/Exception
    //   352	386	850	java/lang/Exception
    //   391	399	850	java/lang/Exception
    //   399	437	850	java/lang/Exception
    //   823	847	850	java/lang/Exception
    //   884	889	850	java/lang/Exception
    //   483	494	1054	java/lang/Exception
    //   494	543	1054	java/lang/Exception
    //   543	565	1054	java/lang/Exception
    //   1012	1051	1054	java/lang/Exception
  }
  
  public void init(Context paramContext)
  {
    this.T = paramContext;
  }
  
  public boolean j(byte[] paramArrayOfByte)
  {
    if (!this.bNh) {
      return false;
    }
    if (this.cFG == cFE) {
      System.arraycopy(paramArrayOfByte, 0, this.dh, 0, this.cFH);
    }
    try
    {
      if (this.cFG == cFE) {}
      for (bool = ARCloudImageFilter.nativeIsSameScene(this.dh, this.dk);; bool = ARCloudImageFilter.nativeIsSameScene(this.dj, this.dk))
      {
        return bool;
        if ((this.mImgWidth != this.cFL) || (this.mImgHeight != this.cFM))
        {
          int j = (this.mImgWidth - this.cFL) / 2;
          int i = this.cFL;
          int k = (this.mImgHeight - this.cFM) / 2;
          i = this.cFM;
          i = 0;
          while (i < this.cFM)
          {
            System.arraycopy(paramArrayOfByte, (i + k) * this.mImgWidth + j, this.dj, this.cFL * i, this.cFL);
            i += 1;
          }
        }
        System.arraycopy(paramArrayOfByte, 0, this.dj, 0, this.cFN);
        break;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        QLog.i("AREngine_ARCloudImageSelect", 1, "ARCloudImageFilter.nativeIsSameScene()" + paramArrayOfByte.getMessage());
        boolean bool = false;
      }
    }
  }
  
  public void uninit()
  {
    if (this.bNg)
    {
      ARCloudImageFilter.nativeUninit();
      this.bNg = false;
    }
    this.mImgWidth = 0;
    this.mImgHeight = 0;
    this.cFJ = 10;
    this.cFK = 170;
    this.dh = null;
    this.cFH = 0;
    this.di = null;
    this.cFI = 0;
    this.cFL = 0;
    this.cFM = 0;
    this.dj = null;
    this.cFN = 0;
    this.dk = null;
    this.bNh = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhe
 * JD-Core Version:    0.7.0.1
 */