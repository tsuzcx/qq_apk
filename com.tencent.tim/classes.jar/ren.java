import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;

public class ren
  extends rdc
{
  private aaza.c jdField_a_of_type_Aaza$c;
  private aaza.d jdField_a_of_type_Aaza$d;
  private double bo;
  private double bp;
  public int bqC;
  
  /* Error */
  private int a(PublishParam paramPublishParam)
  {
    // Byte code:
    //   0: new 27	ankk$a
    //   3: dup
    //   4: invokespecial 28	ankk$a:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: new 30	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: getfield 36	com/tencent/biz/qqstory/takevideo/publish/PublishParam:videoFilePath	Ljava/lang/String;
    //   20: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 43	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 47	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: astore 10
    //   31: aload_1
    //   32: getfield 50	com/tencent/biz/qqstory/takevideo/publish/PublishParam:thumbPath	Ljava/lang/String;
    //   35: astore 13
    //   37: aload_1
    //   38: getfield 36	com/tencent/biz/qqstory/takevideo/publish/PublishParam:videoFilePath	Ljava/lang/String;
    //   41: astore_1
    //   42: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +29 -> 74
    //   48: ldc 58
    //   50: iconst_2
    //   51: new 60	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   58: ldc 63
    //   60: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 10
    //   65: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   77: lstore 7
    //   79: aload_0
    //   80: new 82	aaza$d
    //   83: dup
    //   84: invokespecial 83	aaza$d:<init>	()V
    //   87: putfield 85	ren:jdField_a_of_type_Aaza$d	Laaza$d;
    //   90: aload_1
    //   91: invokestatic 91	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   94: ifne +23 -> 117
    //   97: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +11 -> 111
    //   103: ldc 58
    //   105: iconst_2
    //   106: ldc 93
    //   108: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: sipush -300
    //   114: istore_2
    //   115: iload_2
    //   116: ireturn
    //   117: aload 13
    //   119: invokestatic 91	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   122: ifne +21 -> 143
    //   125: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +11 -> 139
    //   131: ldc 58
    //   133: iconst_2
    //   134: ldc 95
    //   136: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: sipush -301
    //   142: ireturn
    //   143: aload_1
    //   144: aload 9
    //   146: invokestatic 100	ankk:a	(Ljava/lang/String;Lankk$a;)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifeq +38 -> 189
    //   154: iload_3
    //   155: istore_2
    //   156: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq -44 -> 115
    //   162: ldc 58
    //   164: iconst_2
    //   165: new 60	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   172: ldc 102
    //   174: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_3
    //   178: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload_3
    //   188: ireturn
    //   189: aload 9
    //   191: getfield 109	ankk$a:mMetaData	[I
    //   194: iconst_3
    //   195: iaload
    //   196: sipush 500
    //   199: iadd
    //   200: sipush 1000
    //   203: idiv
    //   204: istore 5
    //   206: aload 9
    //   208: getfield 109	ankk$a:mMetaData	[I
    //   211: iconst_2
    //   212: iaload
    //   213: istore 6
    //   215: aload 9
    //   217: getfield 109	ankk$a:mMetaData	[I
    //   220: iconst_0
    //   221: iaload
    //   222: istore 4
    //   224: aload 9
    //   226: getfield 109	ankk$a:mMetaData	[I
    //   229: iconst_1
    //   230: iaload
    //   231: istore_2
    //   232: iload 6
    //   234: bipush 90
    //   236: if_icmpeq +13 -> 249
    //   239: iload_2
    //   240: istore_3
    //   241: iload 6
    //   243: sipush 270
    //   246: if_icmpne +14 -> 260
    //   249: aload 9
    //   251: getfield 109	ankk$a:mMetaData	[I
    //   254: iconst_0
    //   255: iaload
    //   256: istore_3
    //   257: iload_2
    //   258: istore 4
    //   260: aload 13
    //   262: aload_0
    //   263: getfield 20	ren:bo	D
    //   266: aload_0
    //   267: getfield 111	ren:bp	D
    //   270: invokestatic 116	aqhu:a	(Ljava/lang/String;DD)Z
    //   273: pop
    //   274: new 30	java/io/File
    //   277: dup
    //   278: aload 13
    //   280: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore_1
    //   284: new 118	java/io/FileInputStream
    //   287: dup
    //   288: aload 13
    //   290: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   293: astore 10
    //   295: aload 10
    //   297: astore 9
    //   299: aload 10
    //   301: aload_1
    //   302: invokevirtual 122	java/io/File:length	()J
    //   305: invokestatic 128	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   308: astore_1
    //   309: aload 10
    //   311: astore 9
    //   313: aload_1
    //   314: invokestatic 134	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   317: astore 11
    //   319: aload 11
    //   321: astore 12
    //   323: aload 12
    //   325: astore 11
    //   327: aload_1
    //   328: astore 9
    //   330: aload 10
    //   332: ifnull +15 -> 347
    //   335: aload 10
    //   337: invokevirtual 137	java/io/FileInputStream:close	()V
    //   340: aload_1
    //   341: astore 9
    //   343: aload 12
    //   345: astore 11
    //   347: aload 11
    //   349: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +124 -> 476
    //   355: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +11 -> 369
    //   361: ldc 58
    //   363: iconst_2
    //   364: ldc 145
    //   366: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: sipush -302
    //   372: ireturn
    //   373: astore 9
    //   375: aload 9
    //   377: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   380: aload 12
    //   382: astore 11
    //   384: aload_1
    //   385: astore 9
    //   387: goto -40 -> 347
    //   390: astore 11
    //   392: aconst_null
    //   393: astore 10
    //   395: aconst_null
    //   396: astore_1
    //   397: aload 10
    //   399: astore 9
    //   401: aload 11
    //   403: invokevirtual 149	java/io/FileNotFoundException:printStackTrace	()V
    //   406: aload 12
    //   408: astore 11
    //   410: aload_1
    //   411: astore 9
    //   413: aload 10
    //   415: ifnull -68 -> 347
    //   418: aload 10
    //   420: invokevirtual 137	java/io/FileInputStream:close	()V
    //   423: aload 12
    //   425: astore 11
    //   427: aload_1
    //   428: astore 9
    //   430: goto -83 -> 347
    //   433: astore 9
    //   435: aload 9
    //   437: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   440: aload 12
    //   442: astore 11
    //   444: aload_1
    //   445: astore 9
    //   447: goto -100 -> 347
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 9
    //   454: aload 9
    //   456: ifnull +8 -> 464
    //   459: aload 9
    //   461: invokevirtual 137	java/io/FileInputStream:close	()V
    //   464: aload_1
    //   465: athrow
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   473: goto -9 -> 464
    //   476: aload 11
    //   478: ldc 151
    //   480: invokestatic 157	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   483: astore_1
    //   484: aload 13
    //   486: aload_1
    //   487: invokestatic 161	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   490: ifeq +86 -> 576
    //   493: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +38 -> 534
    //   499: ldc 58
    //   501: iconst_2
    //   502: new 60	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   509: ldc 163
    //   511: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   517: lload 7
    //   519: lsub
    //   520: l2d
    //   521: ldc2_w 164
    //   524: ddiv
    //   525: invokevirtual 168	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   528: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_0
    //   535: getfield 85	ren:jdField_a_of_type_Aaza$d	Laaza$d;
    //   538: aload_1
    //   539: putfield 171	aaza$d:path	Ljava/lang/String;
    //   542: aload_0
    //   543: getfield 85	ren:jdField_a_of_type_Aaza$d	Laaza$d;
    //   546: aload 9
    //   548: putfield 175	aaza$d:cG	[B
    //   551: aload_0
    //   552: getfield 85	ren:jdField_a_of_type_Aaza$d	Laaza$d;
    //   555: iload 4
    //   557: putfield 178	aaza$d:width	I
    //   560: aload_0
    //   561: getfield 85	ren:jdField_a_of_type_Aaza$d	Laaza$d;
    //   564: iload_3
    //   565: putfield 181	aaza$d:cmM	I
    //   568: aload_0
    //   569: iload 5
    //   571: putfield 183	ren:bqC	I
    //   574: iconst_0
    //   575: ireturn
    //   576: aload_1
    //   577: invokestatic 91	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   580: ifne +64 -> 644
    //   583: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +38 -> 624
    //   589: ldc 58
    //   591: iconst_2
    //   592: new 60	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   599: ldc 185
    //   601: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 13
    //   606: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: ldc 187
    //   611: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_1
    //   615: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: sipush -301
    //   627: ireturn
    //   628: astore_1
    //   629: goto -175 -> 454
    //   632: astore 11
    //   634: aconst_null
    //   635: astore_1
    //   636: goto -239 -> 397
    //   639: astore 11
    //   641: goto -244 -> 397
    //   644: aload 13
    //   646: astore_1
    //   647: goto -154 -> 493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	ren
    //   0	650	1	paramPublishParam	PublishParam
    //   114	144	2	i	int
    //   149	416	3	j	int
    //   222	334	4	k	int
    //   204	366	5	m	int
    //   213	34	6	n	int
    //   77	441	7	l	long
    //   7	335	9	localObject1	java.lang.Object
    //   373	3	9	localIOException1	java.io.IOException
    //   385	44	9	localObject2	java.lang.Object
    //   433	3	9	localIOException2	java.io.IOException
    //   445	15	9	localPublishParam	PublishParam
    //   466	81	9	localIOException3	java.io.IOException
    //   29	390	10	localObject3	java.lang.Object
    //   317	66	11	localObject4	java.lang.Object
    //   390	12	11	localFileNotFoundException1	java.io.FileNotFoundException
    //   408	69	11	localObject5	java.lang.Object
    //   632	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   639	1	11	localFileNotFoundException3	java.io.FileNotFoundException
    //   10	431	12	localObject6	java.lang.Object
    //   35	610	13	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   335	340	373	java/io/IOException
    //   284	295	390	java/io/FileNotFoundException
    //   418	423	433	java/io/IOException
    //   284	295	450	finally
    //   459	464	466	java/io/IOException
    //   299	309	628	finally
    //   313	319	628	finally
    //   401	406	628	finally
    //   299	309	632	java/io/FileNotFoundException
    //   313	319	639	java/io/FileNotFoundException
  }
  
  private void a(Activity paramActivity, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam)
  {
    ThreadManager.post(new EditWebVideoPartManager.2(this, paramEditSource, paramPublishParam, paramActivity), 5, null, true);
  }
  
  /* Error */
  private void btz()
  {
    // Byte code:
    //   0: invokestatic 224	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 229	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   8: ifeq +235 -> 243
    //   11: ldc 231
    //   13: iconst_0
    //   14: invokestatic 237	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   17: new 239	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3
    //   20: dup
    //   21: aload_0
    //   22: aload 10
    //   24: invokespecial 242	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3:<init>	(Lren;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   27: invokevirtual 247	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   30: invokestatic 229	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   33: ifeq +209 -> 242
    //   36: lconst_0
    //   37: lstore 6
    //   39: aload 10
    //   41: getfield 251	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore 9
    //   46: aload 9
    //   48: monitorenter
    //   49: aload 10
    //   51: getfield 251	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   54: invokevirtual 256	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   57: istore 8
    //   59: lload 6
    //   61: lstore 4
    //   63: iload 8
    //   65: ifne +104 -> 169
    //   68: lload 6
    //   70: lstore_2
    //   71: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +15 -> 89
    //   77: lload 6
    //   79: lstore_2
    //   80: ldc 58
    //   82: iconst_2
    //   83: ldc_w 258
    //   86: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: lload 6
    //   91: lstore_2
    //   92: invokestatic 266	android/os/SystemClock:elapsedRealtime	()J
    //   95: lstore 4
    //   97: lload 6
    //   99: lstore_2
    //   100: aload 10
    //   102: getfield 251	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   105: ldc2_w 267
    //   108: invokevirtual 274	java/lang/Object:wait	(J)V
    //   111: lload 6
    //   113: lstore_2
    //   114: invokestatic 266	android/os/SystemClock:elapsedRealtime	()J
    //   117: lload 4
    //   119: lsub
    //   120: lstore 6
    //   122: lload 6
    //   124: lstore 4
    //   126: lload 6
    //   128: lstore_2
    //   129: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +37 -> 169
    //   135: lload 6
    //   137: lstore_2
    //   138: ldc 58
    //   140: iconst_2
    //   141: new 60	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 276
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: lload 6
    //   156: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: lload 6
    //   167: lstore 4
    //   169: aload 9
    //   171: monitorexit
    //   172: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 58
    //   180: iconst_2
    //   181: ldc_w 281
    //   184: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: lload 4
    //   189: ldc2_w 282
    //   192: lcmp
    //   193: ifge +49 -> 242
    //   196: bipush 30
    //   198: lload 4
    //   200: l2i
    //   201: isub
    //   202: istore_1
    //   203: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 58
    //   211: iconst_2
    //   212: new 60	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 285
    //   222: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload_1
    //   226: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iload_1
    //   236: i2l
    //   237: lstore_2
    //   238: lload_2
    //   239: invokestatic 290	java/lang/Thread:sleep	(J)V
    //   242: return
    //   243: invokestatic 295	aniu:a	()Laniu;
    //   246: invokevirtual 298	aniu:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   249: invokevirtual 304	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   252: pop
    //   253: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -226 -> 30
    //   259: ldc 58
    //   261: iconst_2
    //   262: ldc_w 306
    //   265: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: goto -238 -> 30
    //   271: astore 9
    //   273: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +12 -> 288
    //   279: ldc 58
    //   281: iconst_2
    //   282: ldc_w 308
    //   285: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload 9
    //   290: invokevirtual 309	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   293: goto -263 -> 30
    //   296: astore 10
    //   298: lload_2
    //   299: lstore 4
    //   301: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq -135 -> 169
    //   307: ldc 58
    //   309: iconst_2
    //   310: ldc_w 311
    //   313: aload 10
    //   315: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: lload_2
    //   319: lstore 4
    //   321: goto -152 -> 169
    //   324: astore 10
    //   326: aload 9
    //   328: monitorexit
    //   329: aload 10
    //   331: athrow
    //   332: astore 9
    //   334: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq -95 -> 242
    //   340: ldc 58
    //   342: iconst_2
    //   343: ldc_w 317
    //   346: aload 9
    //   348: invokestatic 315	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	ren
    //   202	34	1	i	int
    //   70	249	2	l1	long
    //   61	259	4	l2	long
    //   37	129	6	l3	long
    //   57	7	8	bool	boolean
    //   44	126	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   271	56	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   332	15	9	localInterruptedException1	java.lang.InterruptedException
    //   3	98	10	localRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   296	18	10	localInterruptedException2	java.lang.InterruptedException
    //   324	6	10	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   243	268	271	java/lang/UnsatisfiedLinkError
    //   71	77	296	java/lang/InterruptedException
    //   80	89	296	java/lang/InterruptedException
    //   92	97	296	java/lang/InterruptedException
    //   100	111	296	java/lang/InterruptedException
    //   114	122	296	java/lang/InterruptedException
    //   129	135	296	java/lang/InterruptedException
    //   138	165	296	java/lang/InterruptedException
    //   49	59	324	finally
    //   71	77	324	finally
    //   80	89	324	finally
    //   92	97	324	finally
    //   100	111	324	finally
    //   114	122	324	finally
    //   129	135	324	finally
    //   138	165	324	finally
    //   169	172	324	finally
    //   301	318	324	finally
    //   326	329	324	finally
    //   238	242	332	java/lang/InterruptedException
  }
  
  protected SimpleObserver<rkm> a(rkm paramrkm)
  {
    return new reo(this, paramrkm);
  }
  
  public void a(aaza.c paramc)
  {
    if (paramc != null) {
      this.jdField_a_of_type_Aaza$c = paramc;
    }
  }
  
  public void bsn()
  {
    super.bsn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ren
 * JD-Core Version:    0.7.0.1
 */