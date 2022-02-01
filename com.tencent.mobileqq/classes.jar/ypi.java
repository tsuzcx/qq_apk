import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;

public class ypi
  extends ynw
{
  private double jdField_a_of_type_Double;
  public int a;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  private double b;
  
  /* Error */
  private int a(PublishParam paramPublishParam)
  {
    // Byte code:
    //   0: new 25	bddw
    //   3: dup
    //   4: invokespecial 26	bddw:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: new 28	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: getfield 34	com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   20: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 41	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 45	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   29: astore 10
    //   31: aload_1
    //   32: getfield 48	com/tencent/biz/qqstory/takevideo/publish/PublishParam:c	Ljava/lang/String;
    //   35: astore 13
    //   37: aload_1
    //   38: getfield 34	com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   41: astore_1
    //   42: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +29 -> 74
    //   48: ldc 56
    //   50: iconst_2
    //   51: new 58	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   58: ldc 61
    //   60: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 10
    //   65: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   77: lstore 7
    //   79: aload_0
    //   80: new 80	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo
    //   83: dup
    //   84: invokespecial 81	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:<init>	()V
    //   87: putfield 83	ypi:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   90: aload_1
    //   91: invokestatic 89	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   94: ifne +23 -> 117
    //   97: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +11 -> 111
    //   103: ldc 56
    //   105: iconst_2
    //   106: ldc 91
    //   108: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: sipush -300
    //   114: istore_2
    //   115: iload_2
    //   116: ireturn
    //   117: aload 13
    //   119: invokestatic 89	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   122: ifne +21 -> 143
    //   125: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +11 -> 139
    //   131: ldc 56
    //   133: iconst_2
    //   134: ldc 93
    //   136: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: sipush -301
    //   142: ireturn
    //   143: aload_1
    //   144: aload 9
    //   146: invokestatic 98	bddv:a	(Ljava/lang/String;Lbddw;)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifeq +38 -> 189
    //   154: iload_3
    //   155: istore_2
    //   156: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq -44 -> 115
    //   162: ldc 56
    //   164: iconst_2
    //   165: new 58	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   172: ldc 100
    //   174: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload_3
    //   178: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload_3
    //   188: ireturn
    //   189: aload 9
    //   191: getfield 106	bddw:a	[I
    //   194: iconst_3
    //   195: iaload
    //   196: sipush 500
    //   199: iadd
    //   200: sipush 1000
    //   203: idiv
    //   204: istore 5
    //   206: aload 9
    //   208: getfield 106	bddw:a	[I
    //   211: iconst_2
    //   212: iaload
    //   213: istore 6
    //   215: aload 9
    //   217: getfield 106	bddw:a	[I
    //   220: iconst_0
    //   221: iaload
    //   222: istore 4
    //   224: aload 9
    //   226: getfield 106	bddw:a	[I
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
    //   251: getfield 106	bddw:a	[I
    //   254: iconst_0
    //   255: iaload
    //   256: istore_3
    //   257: iload_2
    //   258: istore 4
    //   260: aload 13
    //   262: aload_0
    //   263: getfield 18	ypi:jdField_a_of_type_Double	D
    //   266: aload_0
    //   267: getfield 108	ypi:b	D
    //   270: invokestatic 113	bheg:a	(Ljava/lang/String;DD)Z
    //   273: pop
    //   274: new 28	java/io/File
    //   277: dup
    //   278: aload 13
    //   280: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore_1
    //   284: new 115	java/io/FileInputStream
    //   287: dup
    //   288: aload 13
    //   290: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   293: astore 10
    //   295: aload 10
    //   297: astore 9
    //   299: aload 10
    //   301: aload_1
    //   302: invokevirtual 119	java/io/File:length	()J
    //   305: invokestatic 125	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   308: astore_1
    //   309: aload 10
    //   311: astore 9
    //   313: aload_1
    //   314: invokestatic 131	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
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
    //   337: invokevirtual 134	java/io/FileInputStream:close	()V
    //   340: aload_1
    //   341: astore 9
    //   343: aload 12
    //   345: astore 11
    //   347: aload 11
    //   349: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   352: ifeq +124 -> 476
    //   355: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +11 -> 369
    //   361: ldc 56
    //   363: iconst_2
    //   364: ldc 142
    //   366: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: sipush -302
    //   372: ireturn
    //   373: astore 9
    //   375: aload 9
    //   377: invokevirtual 145	java/io/IOException:printStackTrace	()V
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
    //   403: invokevirtual 146	java/io/FileNotFoundException:printStackTrace	()V
    //   406: aload 12
    //   408: astore 11
    //   410: aload_1
    //   411: astore 9
    //   413: aload 10
    //   415: ifnull -68 -> 347
    //   418: aload 10
    //   420: invokevirtual 134	java/io/FileInputStream:close	()V
    //   423: aload 12
    //   425: astore 11
    //   427: aload_1
    //   428: astore 9
    //   430: goto -83 -> 347
    //   433: astore 9
    //   435: aload 9
    //   437: invokevirtual 145	java/io/IOException:printStackTrace	()V
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
    //   461: invokevirtual 134	java/io/FileInputStream:close	()V
    //   464: aload_1
    //   465: athrow
    //   466: astore 9
    //   468: aload 9
    //   470: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   473: goto -9 -> 464
    //   476: aload 11
    //   478: ldc 148
    //   480: invokestatic 154	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   483: astore_1
    //   484: aload 13
    //   486: aload_1
    //   487: invokestatic 158	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   490: ifeq +86 -> 576
    //   493: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +38 -> 534
    //   499: ldc 56
    //   501: iconst_2
    //   502: new 58	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   509: ldc 160
    //   511: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   517: lload 7
    //   519: lsub
    //   520: l2d
    //   521: ldc2_w 161
    //   524: ddiv
    //   525: invokevirtual 165	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   528: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aload_0
    //   535: getfield 83	ypi:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   538: aload_1
    //   539: putfield 168	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:path	Ljava/lang/String;
    //   542: aload_0
    //   543: getfield 83	ypi:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   546: aload 9
    //   548: putfield 172	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:thumbMd5	[B
    //   551: aload_0
    //   552: getfield 83	ypi:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   555: iload 4
    //   557: putfield 175	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:width	I
    //   560: aload_0
    //   561: getfield 83	ypi:jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   564: iload_3
    //   565: putfield 178	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:hight	I
    //   568: aload_0
    //   569: iload 5
    //   571: putfield 180	ypi:jdField_a_of_type_Int	I
    //   574: iconst_0
    //   575: ireturn
    //   576: aload_1
    //   577: invokestatic 89	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   580: ifne +64 -> 644
    //   583: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +38 -> 624
    //   589: ldc 56
    //   591: iconst_2
    //   592: new 58	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   599: ldc 182
    //   601: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: aload 13
    //   606: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: ldc 184
    //   611: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_1
    //   615: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 72	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	650	0	this	ypi
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
  private void b()
  {
    // Byte code:
    //   0: invokestatic 219	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 224	com/tencent/mobileqq/shortvideo/VideoEnvironment:supportSubmitCallback	()Z
    //   8: ifeq +234 -> 242
    //   11: ldc 226
    //   13: iconst_0
    //   14: invokestatic 232	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   17: new 234	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3
    //   20: dup
    //   21: aload_0
    //   22: aload 10
    //   24: invokespecial 237	com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3:<init>	(Lypi;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   27: invokevirtual 242	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   30: invokestatic 224	com/tencent/mobileqq/shortvideo/VideoEnvironment:supportSubmitCallback	()Z
    //   33: ifeq +208 -> 241
    //   36: lconst_0
    //   37: lstore 6
    //   39: aload 10
    //   41: getfield 245	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore 9
    //   46: aload 9
    //   48: monitorenter
    //   49: aload 10
    //   51: getfield 245	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   54: invokevirtual 250	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   57: istore 8
    //   59: lload 6
    //   61: lstore 4
    //   63: iload 8
    //   65: ifne +103 -> 168
    //   68: lload 6
    //   70: lstore_2
    //   71: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +14 -> 88
    //   77: lload 6
    //   79: lstore_2
    //   80: ldc 56
    //   82: iconst_2
    //   83: ldc 252
    //   85: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: lload 6
    //   90: lstore_2
    //   91: invokestatic 260	android/os/SystemClock:elapsedRealtime	()J
    //   94: lstore 4
    //   96: lload 6
    //   98: lstore_2
    //   99: aload 10
    //   101: getfield 245	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   104: ldc2_w 261
    //   107: invokevirtual 268	java/lang/Object:wait	(J)V
    //   110: lload 6
    //   112: lstore_2
    //   113: invokestatic 260	android/os/SystemClock:elapsedRealtime	()J
    //   116: lload 4
    //   118: lsub
    //   119: lstore 6
    //   121: lload 6
    //   123: lstore 4
    //   125: lload 6
    //   127: lstore_2
    //   128: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +37 -> 168
    //   134: lload 6
    //   136: lstore_2
    //   137: ldc 56
    //   139: iconst_2
    //   140: new 58	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 270
    //   150: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload 6
    //   155: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: lload 6
    //   166: lstore 4
    //   168: aload 9
    //   170: monitorexit
    //   171: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 56
    //   179: iconst_2
    //   180: ldc_w 275
    //   183: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: lload 4
    //   188: ldc2_w 276
    //   191: lcmp
    //   192: ifge +49 -> 241
    //   195: bipush 30
    //   197: lload 4
    //   199: l2i
    //   200: isub
    //   201: istore_1
    //   202: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +29 -> 234
    //   208: ldc 56
    //   210: iconst_2
    //   211: new 58	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 279
    //   221: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload_1
    //   225: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload_1
    //   235: i2l
    //   236: lstore_2
    //   237: lload_2
    //   238: invokestatic 284	java/lang/Thread:sleep	(J)V
    //   241: return
    //   242: invokestatic 289	bdbv:a	()Lbdbv;
    //   245: invokevirtual 292	bdbv:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   248: invokevirtual 298	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   251: pop
    //   252: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -225 -> 30
    //   258: ldc 56
    //   260: iconst_2
    //   261: ldc_w 300
    //   264: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: goto -237 -> 30
    //   270: astore 9
    //   272: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +12 -> 287
    //   278: ldc 56
    //   280: iconst_2
    //   281: ldc_w 302
    //   284: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 9
    //   289: invokevirtual 303	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   292: goto -262 -> 30
    //   295: astore 10
    //   297: lload_2
    //   298: lstore 4
    //   300: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -135 -> 168
    //   306: ldc 56
    //   308: iconst_2
    //   309: ldc_w 305
    //   312: aload 10
    //   314: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: lload_2
    //   318: lstore 4
    //   320: goto -152 -> 168
    //   323: astore 10
    //   325: aload 9
    //   327: monitorexit
    //   328: aload 10
    //   330: athrow
    //   331: astore 9
    //   333: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -95 -> 241
    //   339: ldc 56
    //   341: iconst_2
    //   342: ldc_w 311
    //   345: aload 9
    //   347: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   350: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	ypi
    //   201	34	1	i	int
    //   70	248	2	l1	long
    //   61	258	4	l2	long
    //   37	128	6	l3	long
    //   57	7	8	bool	boolean
    //   44	125	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   270	56	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   331	15	9	localInterruptedException1	java.lang.InterruptedException
    //   3	97	10	localRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   295	18	10	localInterruptedException2	java.lang.InterruptedException
    //   323	6	10	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   242	267	270	java/lang/UnsatisfiedLinkError
    //   71	77	295	java/lang/InterruptedException
    //   80	88	295	java/lang/InterruptedException
    //   91	96	295	java/lang/InterruptedException
    //   99	110	295	java/lang/InterruptedException
    //   113	121	295	java/lang/InterruptedException
    //   128	134	295	java/lang/InterruptedException
    //   137	164	295	java/lang/InterruptedException
    //   49	59	323	finally
    //   71	77	323	finally
    //   80	88	323	finally
    //   91	96	323	finally
    //   99	110	323	finally
    //   113	121	323	finally
    //   128	134	323	finally
    //   137	164	323	finally
    //   168	171	323	finally
    //   300	317	323	finally
    //   325	328	323	finally
    //   237	241	331	java/lang/InterruptedException
  }
  
  protected SimpleObserver<yya> a(yya paramyya)
  {
    return new ypj(this, paramyya);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(EncodeVideoTask.ResultListener paramResultListener)
  {
    if (paramResultListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = paramResultListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypi
 * JD-Core Version:    0.7.0.1
 */