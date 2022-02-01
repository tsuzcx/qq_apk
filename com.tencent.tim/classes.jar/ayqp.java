public class ayqp
  extends ayqr<ayqb, ayqb>
{
  private final String aBd;
  
  public ayqp()
  {
    this(null);
  }
  
  public ayqp(String paramString)
  {
    this.aBd = paramString;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, ayqb paramayqb)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 30	ayqb:aAT	Ljava/lang/String;
    //   4: astore 12
    //   6: aload 12
    //   8: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +18 -> 29
    //   14: aload_0
    //   15: new 38	com/tencent/biz/qqstory/base/ErrorMessage
    //   18: dup
    //   19: iconst_m1
    //   20: ldc 40
    //   22: invokespecial 43	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   25: invokespecial 47	ayqr:notifyError	(Ljava/lang/Error;)V
    //   28: return
    //   29: aload_0
    //   30: getfield 17	ayqp:aBd	Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore 7
    //   37: aload_1
    //   38: ifnonnull +18 -> 56
    //   41: aload_2
    //   42: getfield 51	ayqb:businessId	I
    //   45: aload_2
    //   46: getfield 54	ayqb:aAU	Ljava/lang/String;
    //   49: ldc 56
    //   51: invokestatic 62	ayqu:f	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 7
    //   56: aload_2
    //   57: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   60: getfield 71	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   63: astore 10
    //   65: aload_2
    //   66: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   69: getfield 74	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   72: astore 9
    //   74: aload_2
    //   75: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   78: ldc 76
    //   80: aconst_null
    //   81: invokevirtual 80	com/tencent/biz/qqstory/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 11
    //   86: aload_2
    //   87: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   90: ldc 82
    //   92: aconst_null
    //   93: invokevirtual 80	com/tencent/biz/qqstory/database/PublishVideoEntry:getStringExtra	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 8
    //   98: aload 10
    //   100: ifnonnull +98 -> 198
    //   103: aload 9
    //   105: ifnonnull +93 -> 198
    //   108: aload 11
    //   110: ifnonnull +88 -> 198
    //   113: aload 8
    //   115: ifnonnull +83 -> 198
    //   118: ldc 84
    //   120: ldc 86
    //   122: aload 7
    //   124: invokestatic 92	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   127: new 94	java/io/File
    //   130: dup
    //   131: aload 12
    //   133: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: new 94	java/io/File
    //   139: dup
    //   140: aload 7
    //   142: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: invokestatic 101	rox:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   148: ifeq +24 -> 172
    //   151: aload_2
    //   152: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   155: aload 7
    //   157: putfield 104	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   160: iconst_1
    //   161: istore_3
    //   162: iload_3
    //   163: ifeq +662 -> 825
    //   166: aload_0
    //   167: aload_2
    //   168: invokespecial 108	ayqr:notifyResult	(Ljava/lang/Object;)V
    //   171: return
    //   172: ldc 84
    //   174: ldc 110
    //   176: iconst_2
    //   177: anewarray 112	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload 12
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: aload 7
    //   189: aastore
    //   190: invokestatic 116	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: iconst_0
    //   194: istore_3
    //   195: goto -33 -> 162
    //   198: aconst_null
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 6
    //   204: new 118	java/io/BufferedInputStream
    //   207: dup
    //   208: new 120	java/io/FileInputStream
    //   211: dup
    //   212: aload 12
    //   214: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   217: invokespecial 124	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   220: astore_1
    //   221: aload_1
    //   222: astore 5
    //   224: aload_1
    //   225: invokestatic 130	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   228: astore 6
    //   230: aload_1
    //   231: ifnull +646 -> 877
    //   234: aload_1
    //   235: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   238: aload 6
    //   240: astore_1
    //   241: aload_1
    //   242: ifnonnull +152 -> 394
    //   245: aload_0
    //   246: new 38	com/tencent/biz/qqstory/base/ErrorMessage
    //   249: dup
    //   250: iconst_m1
    //   251: ldc 134
    //   253: invokestatic 140	acfp:m	(I)Ljava/lang/String;
    //   256: invokespecial 43	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   259: invokespecial 47	ayqr:notifyError	(Ljava/lang/Error;)V
    //   262: return
    //   263: astore_1
    //   264: ldc 84
    //   266: ldc 142
    //   268: aload_1
    //   269: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 6
    //   274: astore_1
    //   275: goto -34 -> 241
    //   278: astore 6
    //   280: aconst_null
    //   281: astore_1
    //   282: aload_1
    //   283: astore 5
    //   285: ldc 84
    //   287: ldc 147
    //   289: aload 6
    //   291: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_1
    //   295: ifnull +577 -> 872
    //   298: aload_1
    //   299: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   302: aconst_null
    //   303: astore_1
    //   304: goto -63 -> 241
    //   307: astore_1
    //   308: ldc 84
    //   310: ldc 142
    //   312: aload_1
    //   313: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aconst_null
    //   317: astore_1
    //   318: goto -77 -> 241
    //   321: astore 5
    //   323: aload 6
    //   325: astore_1
    //   326: aload 5
    //   328: astore 6
    //   330: aload_1
    //   331: astore 5
    //   333: ldc 84
    //   335: ldc 149
    //   337: aload 6
    //   339: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   342: aload_1
    //   343: ifnull +529 -> 872
    //   346: aload_1
    //   347: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   350: aconst_null
    //   351: astore_1
    //   352: goto -111 -> 241
    //   355: astore_1
    //   356: ldc 84
    //   358: ldc 142
    //   360: aload_1
    //   361: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   364: aconst_null
    //   365: astore_1
    //   366: goto -125 -> 241
    //   369: astore_1
    //   370: aload 5
    //   372: ifnull +8 -> 380
    //   375: aload 5
    //   377: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   380: aload_1
    //   381: athrow
    //   382: astore_2
    //   383: ldc 84
    //   385: ldc 142
    //   387: aload_2
    //   388: invokestatic 145	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: goto -11 -> 380
    //   394: aconst_null
    //   395: astore 6
    //   397: aload 6
    //   399: astore 5
    //   401: aload 11
    //   403: ifnull +10 -> 413
    //   406: aload 11
    //   408: invokestatic 155	rop:u	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   411: astore 5
    //   413: aload 5
    //   415: astore 6
    //   417: aload 5
    //   419: ifnonnull +464 -> 883
    //   422: aload 5
    //   424: astore 6
    //   426: aload 10
    //   428: ifnull +455 -> 883
    //   431: aload 10
    //   433: aconst_null
    //   434: invokestatic 158	rop:a	(Ljava/lang/String;Lrop$a;)Landroid/graphics/Bitmap;
    //   437: astore 6
    //   439: aload 6
    //   441: astore 5
    //   443: ldc 84
    //   445: ldc 160
    //   447: iconst_1
    //   448: anewarray 112	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload 10
    //   455: aastore
    //   456: invokestatic 116	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   459: aload 6
    //   461: astore 5
    //   463: aload 5
    //   465: ifnonnull +230 -> 695
    //   468: aload 9
    //   470: ifnull +225 -> 695
    //   473: aload 9
    //   475: invokestatic 163	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   478: astore 6
    //   480: aload 6
    //   482: ifnull +220 -> 702
    //   485: aload_1
    //   486: aload 6
    //   488: invokestatic 167	rop:c	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   491: astore 5
    //   493: aload 6
    //   495: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   498: aload_1
    //   499: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   502: aload 5
    //   504: astore_1
    //   505: aload_1
    //   506: astore 5
    //   508: aload_1
    //   509: ifnull +51 -> 560
    //   512: aload_1
    //   513: astore 5
    //   515: aload 8
    //   517: ifnull +43 -> 560
    //   520: aload 8
    //   522: invokestatic 163	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   525: astore 6
    //   527: aload 6
    //   529: ifnull +340 -> 869
    //   532: aload_1
    //   533: aload 6
    //   535: invokestatic 167	rop:c	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   538: astore 5
    //   540: aload 5
    //   542: ifnull +327 -> 869
    //   545: aload_1
    //   546: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   549: aload 6
    //   551: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   554: aload 5
    //   556: astore_1
    //   557: aload_1
    //   558: astore 5
    //   560: aload 5
    //   562: ifnonnull +186 -> 748
    //   565: iconst_0
    //   566: istore_3
    //   567: goto -405 -> 162
    //   570: astore 5
    //   572: ldc 84
    //   574: new 174	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   581: ldc 177
    //   583: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 9
    //   588: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc 183
    //   593: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: aload 5
    //   601: invokestatic 190	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   604: aload 6
    //   606: astore 5
    //   608: goto -195 -> 413
    //   611: astore 5
    //   613: aconst_null
    //   614: astore_1
    //   615: ldc 84
    //   617: new 174	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   624: ldc 192
    //   626: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 5
    //   631: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 198	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: goto -135 -> 505
    //   643: astore 6
    //   645: ldc 84
    //   647: ldc 200
    //   649: aload 6
    //   651: invokestatic 190	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   654: aload 5
    //   656: astore 6
    //   658: goto +225 -> 883
    //   661: astore 6
    //   663: ldc 84
    //   665: new 174	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   672: ldc 177
    //   674: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 9
    //   679: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 183
    //   684: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: aload 6
    //   692: invokestatic 190	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   695: aload 5
    //   697: astore 6
    //   699: goto -219 -> 480
    //   702: aload_1
    //   703: astore 5
    //   705: goto -203 -> 502
    //   708: astore 5
    //   710: ldc 84
    //   712: new 174	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   719: ldc 177
    //   721: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 8
    //   726: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc 183
    //   731: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: aload 5
    //   739: invokestatic 190	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   742: aload_1
    //   743: astore 5
    //   745: goto -185 -> 560
    //   748: getstatic 205	plr:atc	Ljava/lang/String;
    //   751: invokestatic 209	rox:checkDirAndCreate	(Ljava/lang/String;)Z
    //   754: pop
    //   755: aload 5
    //   757: aload 7
    //   759: invokestatic 213	rop:d	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   762: istore 4
    //   764: aload 5
    //   766: invokevirtual 172	android/graphics/Bitmap:recycle	()V
    //   769: iload 4
    //   771: ifeq +42 -> 813
    //   774: aload_2
    //   775: getfield 66	ayqb:g	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   778: aload 7
    //   780: putfield 104	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   783: ldc 84
    //   785: new 174	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   792: ldc 215
    //   794: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload 7
    //   799: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 217	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iconst_1
    //   809: istore_3
    //   810: goto -648 -> 162
    //   813: iconst_0
    //   814: istore_3
    //   815: ldc 84
    //   817: ldc 219
    //   819: invokestatic 221	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: goto -660 -> 162
    //   825: aload_0
    //   826: new 38	com/tencent/biz/qqstory/base/ErrorMessage
    //   829: dup
    //   830: iconst_m1
    //   831: ldc 222
    //   833: invokestatic 140	acfp:m	(I)Ljava/lang/String;
    //   836: invokespecial 43	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   839: invokespecial 47	ayqr:notifyError	(Ljava/lang/Error;)V
    //   842: return
    //   843: astore 6
    //   845: aload 5
    //   847: astore_1
    //   848: aload 6
    //   850: astore 5
    //   852: goto -237 -> 615
    //   855: astore_1
    //   856: goto -486 -> 370
    //   859: astore 6
    //   861: goto -531 -> 330
    //   864: astore 6
    //   866: goto -584 -> 282
    //   869: goto -312 -> 557
    //   872: aconst_null
    //   873: astore_1
    //   874: goto -633 -> 241
    //   877: aload 6
    //   879: astore_1
    //   880: goto -639 -> 241
    //   883: aload 6
    //   885: astore 5
    //   887: goto -424 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	ayqp
    //   0	890	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	890	2	paramayqb	ayqb
    //   161	654	3	i	int
    //   762	8	4	bool	boolean
    //   199	85	5	localJobContext1	com.tribe.async.async.JobContext
    //   321	6	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   331	230	5	localObject1	java.lang.Object
    //   570	30	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   606	1	5	localObject2	java.lang.Object
    //   611	85	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   703	1	5	localJobContext2	com.tribe.async.async.JobContext
    //   708	30	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   743	143	5	localObject3	java.lang.Object
    //   202	71	6	localBitmap	android.graphics.Bitmap
    //   278	46	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   328	277	6	localObject4	java.lang.Object
    //   643	7	6	localIOException	java.io.IOException
    //   656	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   661	30	6	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   697	1	6	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   843	6	6	localOutOfMemoryError8	java.lang.OutOfMemoryError
    //   859	1	6	localOutOfMemoryError9	java.lang.OutOfMemoryError
    //   864	20	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   35	763	7	localObject5	java.lang.Object
    //   96	629	8	str1	String
    //   72	606	9	str2	String
    //   63	391	10	str3	String
    //   84	323	11	str4	String
    //   4	209	12	str5	String
    // Exception table:
    //   from	to	target	type
    //   234	238	263	java/io/IOException
    //   204	221	278	java/io/FileNotFoundException
    //   298	302	307	java/io/IOException
    //   204	221	321	java/lang/OutOfMemoryError
    //   346	350	355	java/io/IOException
    //   204	221	369	finally
    //   333	342	369	finally
    //   375	380	382	java/io/IOException
    //   406	413	570	java/lang/OutOfMemoryError
    //   431	439	611	java/lang/OutOfMemoryError
    //   443	459	611	java/lang/OutOfMemoryError
    //   485	493	611	java/lang/OutOfMemoryError
    //   572	604	611	java/lang/OutOfMemoryError
    //   645	654	611	java/lang/OutOfMemoryError
    //   663	695	611	java/lang/OutOfMemoryError
    //   431	439	643	java/io/IOException
    //   443	459	643	java/io/IOException
    //   473	480	661	java/lang/OutOfMemoryError
    //   520	527	708	java/lang/OutOfMemoryError
    //   532	540	708	java/lang/OutOfMemoryError
    //   545	554	708	java/lang/OutOfMemoryError
    //   493	502	843	java/lang/OutOfMemoryError
    //   224	230	855	finally
    //   285	294	855	finally
    //   224	230	859	java/lang/OutOfMemoryError
    //   224	230	864	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqp
 * JD-Core Version:    0.7.0.1
 */