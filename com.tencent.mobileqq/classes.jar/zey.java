public class zey
  extends zez<zem, zem>
{
  private final String a;
  
  public zey()
  {
    this(null);
  }
  
  public zey(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, zem paramzem)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_2
    //   4: getfield 27	zem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore 5
    //   9: aload 5
    //   11: invokestatic 33	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +18 -> 32
    //   17: aload_0
    //   18: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   21: dup
    //   22: iconst_m1
    //   23: ldc 37
    //   25: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   28: invokespecial 44	zez:notifyError	(Ljava/lang/Error;)V
    //   31: return
    //   32: aload_0
    //   33: getfield 17	zey:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: astore_1
    //   37: aload_1
    //   38: astore 7
    //   40: aload_1
    //   41: ifnonnull +18 -> 59
    //   44: aload_2
    //   45: getfield 47	zem:jdField_a_of_type_Int	I
    //   48: aload_2
    //   49: getfield 50	zem:b	Ljava/lang/String;
    //   52: ldc 52
    //   54: invokestatic 57	zfc:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 7
    //   59: aload_2
    //   60: getfield 60	zem:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   63: getfield 65	com/tencent/biz/qqstory/database/PublishVideoEntry:doodleRawPath	Ljava/lang/String;
    //   66: astore 10
    //   68: aload_2
    //   69: getfield 60	zem:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   72: getfield 68	com/tencent/biz/qqstory/database/PublishVideoEntry:doodlePath	Ljava/lang/String;
    //   75: astore 9
    //   77: aload 10
    //   79: ifnonnull +116 -> 195
    //   82: aload 9
    //   84: ifnonnull +111 -> 195
    //   87: ldc 70
    //   89: ldc 72
    //   91: aload 7
    //   93: invokestatic 77	yqp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   96: new 79	java/io/File
    //   99: dup
    //   100: aload 5
    //   102: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: new 79	java/io/File
    //   108: dup
    //   109: aload 7
    //   111: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokestatic 85	zkr:a	(Ljava/io/File;Ljava/io/File;)Z
    //   117: ifeq +52 -> 169
    //   120: aload_2
    //   121: getfield 60	zem:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   124: aload 7
    //   126: putfield 88	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   129: iconst_1
    //   130: istore_3
    //   131: iload_3
    //   132: ifeq +510 -> 642
    //   135: new 79	java/io/File
    //   138: dup
    //   139: aload_2
    //   140: getfield 60	zem:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   143: getfield 88	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   146: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: new 79	java/io/File
    //   152: dup
    //   153: getstatic 91	com/tencent/biz/qqstory/takevideo/QQStoryTakeVideoCloseAnimationActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 85	zkr:a	(Ljava/io/File;Ljava/io/File;)Z
    //   162: pop
    //   163: aload_0
    //   164: aload_2
    //   165: invokespecial 95	zez:notifyResult	(Ljava/lang/Object;)V
    //   168: return
    //   169: ldc 70
    //   171: ldc 97
    //   173: iconst_2
    //   174: anewarray 99	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 5
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 7
    //   186: aastore
    //   187: invokestatic 103	yqp:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: iconst_0
    //   191: istore_3
    //   192: goto -61 -> 131
    //   195: new 105	java/io/BufferedInputStream
    //   198: dup
    //   199: new 107	java/io/FileInputStream
    //   202: dup
    //   203: aload 5
    //   205: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   208: invokespecial 111	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   211: astore 5
    //   213: aload 5
    //   215: astore_1
    //   216: aload 5
    //   218: invokestatic 117	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   221: astore 6
    //   223: aload 5
    //   225: ifnull +477 -> 702
    //   228: aload 5
    //   230: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   233: aload 6
    //   235: astore_1
    //   236: aload_1
    //   237: ifnonnull +153 -> 390
    //   240: aload_0
    //   241: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   244: dup
    //   245: iconst_m1
    //   246: ldc 121
    //   248: invokestatic 126	anni:a	(I)Ljava/lang/String;
    //   251: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   254: invokespecial 44	zez:notifyError	(Ljava/lang/Error;)V
    //   257: return
    //   258: astore_1
    //   259: ldc 70
    //   261: ldc 128
    //   263: aload_1
    //   264: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload 6
    //   269: astore_1
    //   270: goto -34 -> 236
    //   273: astore 6
    //   275: aconst_null
    //   276: astore 5
    //   278: aload 5
    //   280: astore_1
    //   281: ldc 70
    //   283: ldc 133
    //   285: aload 6
    //   287: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: aload 5
    //   292: ifnull +405 -> 697
    //   295: aload 5
    //   297: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   300: aconst_null
    //   301: astore_1
    //   302: goto -66 -> 236
    //   305: astore_1
    //   306: ldc 70
    //   308: ldc 128
    //   310: aload_1
    //   311: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -80 -> 236
    //   319: astore 6
    //   321: aconst_null
    //   322: astore 5
    //   324: aload 5
    //   326: astore_1
    //   327: ldc 70
    //   329: ldc 135
    //   331: aload 6
    //   333: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: aload 5
    //   338: ifnull +359 -> 697
    //   341: aload 5
    //   343: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   346: aconst_null
    //   347: astore_1
    //   348: goto -112 -> 236
    //   351: astore_1
    //   352: ldc 70
    //   354: ldc 128
    //   356: aload_1
    //   357: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: aconst_null
    //   361: astore_1
    //   362: goto -126 -> 236
    //   365: astore_2
    //   366: aconst_null
    //   367: astore_1
    //   368: aload_1
    //   369: ifnull +7 -> 376
    //   372: aload_1
    //   373: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   376: aload_2
    //   377: athrow
    //   378: astore_1
    //   379: ldc 70
    //   381: ldc 128
    //   383: aload_1
    //   384: invokestatic 131	yqp:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   387: goto -11 -> 376
    //   390: aload 10
    //   392: ifnull +299 -> 691
    //   395: aload 10
    //   397: aconst_null
    //   398: invokestatic 140	zkh:a	(Ljava/lang/String;Lzki;)Landroid/graphics/Bitmap;
    //   401: astore 5
    //   403: ldc 70
    //   405: ldc 142
    //   407: iconst_1
    //   408: anewarray 99	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload 10
    //   415: aastore
    //   416: invokestatic 103	yqp:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload 5
    //   421: ifnonnull +100 -> 521
    //   424: aload 9
    //   426: ifnull +95 -> 521
    //   429: aload 9
    //   431: invokestatic 146	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   434: astore 6
    //   436: aload 6
    //   438: ifnull +90 -> 528
    //   441: aload_1
    //   442: aload 6
    //   444: invokestatic 149	zkh:b	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   447: astore 5
    //   449: aload 6
    //   451: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   454: aload_1
    //   455: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   458: aload 5
    //   460: astore_1
    //   461: aload_1
    //   462: ifnonnull +105 -> 567
    //   465: iconst_0
    //   466: istore_3
    //   467: goto -336 -> 131
    //   470: astore 6
    //   472: aconst_null
    //   473: astore 5
    //   475: ldc 70
    //   477: ldc 156
    //   479: aload 6
    //   481: invokestatic 159	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   484: goto -65 -> 419
    //   487: astore 6
    //   489: ldc 70
    //   491: new 161	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   498: ldc 164
    //   500: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 9
    //   505: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc 170
    //   510: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: aload 6
    //   518: invokestatic 159	yqp:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   521: aload 5
    //   523: astore 6
    //   525: goto -89 -> 436
    //   528: aload_1
    //   529: astore 5
    //   531: goto -73 -> 458
    //   534: astore 5
    //   536: aload 8
    //   538: astore_1
    //   539: ldc 70
    //   541: new 161	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   548: ldc 176
    //   550: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 5
    //   555: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 183	yqp:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: goto -103 -> 461
    //   567: getstatic 187	wes:e	Ljava/lang/String;
    //   570: invokestatic 190	zkr:a	(Ljava/lang/String;)Z
    //   573: pop
    //   574: aload_1
    //   575: aload 7
    //   577: invokestatic 193	zkh:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   580: istore 4
    //   582: aload_1
    //   583: invokevirtual 154	android/graphics/Bitmap:recycle	()V
    //   586: iload 4
    //   588: ifeq +42 -> 630
    //   591: aload_2
    //   592: getfield 60	zem:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   595: aload 7
    //   597: putfield 88	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   600: ldc 70
    //   602: new 161	java/lang/StringBuilder
    //   605: dup
    //   606: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   609: ldc 195
    //   611: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload 7
    //   616: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 197	yqp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: iconst_1
    //   626: istore_3
    //   627: goto -496 -> 131
    //   630: ldc 70
    //   632: ldc 199
    //   634: invokestatic 201	yqp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   637: iconst_0
    //   638: istore_3
    //   639: goto -508 -> 131
    //   642: aload_0
    //   643: new 35	com/tencent/biz/qqstory/base/ErrorMessage
    //   646: dup
    //   647: iconst_m1
    //   648: ldc 202
    //   650: invokestatic 126	anni:a	(I)Ljava/lang/String;
    //   653: invokespecial 40	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   656: invokespecial 44	zez:notifyError	(Ljava/lang/Error;)V
    //   659: return
    //   660: astore 6
    //   662: aload 5
    //   664: astore_1
    //   665: aload 6
    //   667: astore 5
    //   669: goto -130 -> 539
    //   672: astore 6
    //   674: goto -199 -> 475
    //   677: astore_2
    //   678: goto -310 -> 368
    //   681: astore 6
    //   683: goto -359 -> 324
    //   686: astore 6
    //   688: goto -410 -> 278
    //   691: aconst_null
    //   692: astore 5
    //   694: goto -275 -> 419
    //   697: aconst_null
    //   698: astore_1
    //   699: goto -463 -> 236
    //   702: aload 6
    //   704: astore_1
    //   705: goto -469 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	zey
    //   0	708	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	708	2	paramzem	zem
    //   130	509	3	i	int
    //   580	7	4	bool	boolean
    //   7	523	5	localObject1	java.lang.Object
    //   534	129	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   667	26	5	localObject2	java.lang.Object
    //   221	47	6	localBitmap1	android.graphics.Bitmap
    //   273	13	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   319	13	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   434	16	6	localBitmap2	android.graphics.Bitmap
    //   470	10	6	localIOException1	java.io.IOException
    //   487	30	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   523	1	6	localObject3	java.lang.Object
    //   660	6	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   672	1	6	localIOException2	java.io.IOException
    //   681	1	6	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   686	17	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   38	577	7	localObject4	java.lang.Object
    //   1	536	8	localObject5	java.lang.Object
    //   75	429	9	str1	String
    //   66	348	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   228	233	258	java/io/IOException
    //   195	213	273	java/io/FileNotFoundException
    //   295	300	305	java/io/IOException
    //   195	213	319	java/lang/OutOfMemoryError
    //   341	346	351	java/io/IOException
    //   195	213	365	finally
    //   372	376	378	java/io/IOException
    //   395	403	470	java/io/IOException
    //   429	436	487	java/lang/OutOfMemoryError
    //   395	403	534	java/lang/OutOfMemoryError
    //   403	419	534	java/lang/OutOfMemoryError
    //   441	449	534	java/lang/OutOfMemoryError
    //   475	484	534	java/lang/OutOfMemoryError
    //   489	521	534	java/lang/OutOfMemoryError
    //   449	458	660	java/lang/OutOfMemoryError
    //   403	419	672	java/io/IOException
    //   216	223	677	finally
    //   281	290	677	finally
    //   327	336	677	finally
    //   216	223	681	java/lang/OutOfMemoryError
    //   216	223	686	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zey
 * JD-Core Version:    0.7.0.1
 */