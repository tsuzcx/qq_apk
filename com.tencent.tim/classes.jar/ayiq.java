import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class ayiq
  extends aygz
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
    //   0: new 30	azbt$a
    //   3: dup
    //   4: invokespecial 31	azbt$a:<init>	()V
    //   7: astore 9
    //   9: new 33	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 39	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:videoFilePath	Ljava/lang/String;
    //   17: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 46	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 50	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: astore 10
    //   28: aload_1
    //   29: getfield 53	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:thumbPath	Ljava/lang/String;
    //   32: astore 11
    //   34: aload_1
    //   35: getfield 39	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:videoFilePath	Ljava/lang/String;
    //   38: astore_1
    //   39: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +29 -> 71
    //   45: ldc 61
    //   47: iconst_2
    //   48: new 63	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   55: ldc 66
    //   57: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload 10
    //   62: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   74: lstore 7
    //   76: aload_0
    //   77: new 85	aaza$d
    //   80: dup
    //   81: invokespecial 86	aaza$d:<init>	()V
    //   84: putfield 88	ayiq:jdField_a_of_type_Aaza$d	Laaza$d;
    //   87: aload_1
    //   88: invokestatic 94	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   91: ifne +23 -> 114
    //   94: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +11 -> 108
    //   100: ldc 61
    //   102: iconst_2
    //   103: ldc 96
    //   105: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: sipush -300
    //   111: istore_2
    //   112: iload_2
    //   113: ireturn
    //   114: aload 11
    //   116: invokestatic 94	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   119: ifne +21 -> 140
    //   122: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +11 -> 136
    //   128: ldc 61
    //   130: iconst_2
    //   131: ldc 98
    //   133: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: sipush -301
    //   139: ireturn
    //   140: aload_1
    //   141: aload 9
    //   143: invokestatic 103	azbt:a	(Ljava/lang/String;Lazbt$a;)I
    //   146: istore_3
    //   147: iload_3
    //   148: ifeq +38 -> 186
    //   151: iload_3
    //   152: istore_2
    //   153: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -44 -> 112
    //   159: ldc 61
    //   161: iconst_2
    //   162: new 63	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   169: ldc 105
    //   171: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_3
    //   175: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload_3
    //   185: ireturn
    //   186: aload 9
    //   188: getfield 112	azbt$a:mMetaData	[I
    //   191: iconst_3
    //   192: iaload
    //   193: sipush 500
    //   196: iadd
    //   197: sipush 1000
    //   200: idiv
    //   201: istore 5
    //   203: aload 9
    //   205: getfield 112	azbt$a:mMetaData	[I
    //   208: iconst_2
    //   209: iaload
    //   210: istore 6
    //   212: aload 9
    //   214: getfield 112	azbt$a:mMetaData	[I
    //   217: iconst_0
    //   218: iaload
    //   219: istore 4
    //   221: aload 9
    //   223: getfield 112	azbt$a:mMetaData	[I
    //   226: iconst_1
    //   227: iaload
    //   228: istore_2
    //   229: iload 6
    //   231: bipush 90
    //   233: if_icmpeq +13 -> 246
    //   236: iload_2
    //   237: istore_3
    //   238: iload 6
    //   240: sipush 270
    //   243: if_icmpne +14 -> 257
    //   246: aload 9
    //   248: getfield 112	azbt$a:mMetaData	[I
    //   251: iconst_0
    //   252: iaload
    //   253: istore_3
    //   254: iload_2
    //   255: istore 4
    //   257: aload 11
    //   259: aload_0
    //   260: getfield 20	ayiq:bo	D
    //   263: aload_0
    //   264: getfield 114	ayiq:bp	D
    //   267: invokestatic 119	aqhu:a	(Ljava/lang/String;DD)Z
    //   270: pop
    //   271: new 33	java/io/File
    //   274: dup
    //   275: aload 11
    //   277: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: astore_1
    //   281: new 121	java/io/FileInputStream
    //   284: dup
    //   285: aload 11
    //   287: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   290: astore 9
    //   292: aload 9
    //   294: aload_1
    //   295: invokevirtual 125	java/io/File:length	()J
    //   298: invokestatic 131	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   301: astore_1
    //   302: aload_1
    //   303: invokestatic 137	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   306: astore 10
    //   308: aload 9
    //   310: ifnull +8 -> 318
    //   313: aload 9
    //   315: invokevirtual 140	java/io/FileInputStream:close	()V
    //   318: aload 10
    //   320: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +43 -> 366
    //   326: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +11 -> 340
    //   332: ldc 61
    //   334: iconst_2
    //   335: ldc 148
    //   337: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: sipush -302
    //   343: ireturn
    //   344: astore_1
    //   345: aconst_null
    //   346: astore 9
    //   348: aconst_null
    //   349: astore_1
    //   350: aconst_null
    //   351: astore 10
    //   353: goto -45 -> 308
    //   356: astore 9
    //   358: aload 9
    //   360: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   363: goto -45 -> 318
    //   366: aload 10
    //   368: ldc 153
    //   370: invokestatic 159	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   373: astore 9
    //   375: aload 11
    //   377: aload 9
    //   379: invokestatic 163	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   382: ifeq +86 -> 468
    //   385: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +38 -> 426
    //   391: ldc 61
    //   393: iconst_2
    //   394: new 63	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   401: ldc 165
    //   403: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokestatic 83	java/lang/System:currentTimeMillis	()J
    //   409: lload 7
    //   411: lsub
    //   412: l2d
    //   413: ldc2_w 166
    //   416: ddiv
    //   417: invokevirtual 170	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   420: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: getfield 88	ayiq:jdField_a_of_type_Aaza$d	Laaza$d;
    //   430: aload 9
    //   432: putfield 173	aaza$d:path	Ljava/lang/String;
    //   435: aload_0
    //   436: getfield 88	ayiq:jdField_a_of_type_Aaza$d	Laaza$d;
    //   439: aload_1
    //   440: putfield 177	aaza$d:cG	[B
    //   443: aload_0
    //   444: getfield 88	ayiq:jdField_a_of_type_Aaza$d	Laaza$d;
    //   447: iload 4
    //   449: putfield 180	aaza$d:width	I
    //   452: aload_0
    //   453: getfield 88	ayiq:jdField_a_of_type_Aaza$d	Laaza$d;
    //   456: iload_3
    //   457: putfield 183	aaza$d:cmM	I
    //   460: aload_0
    //   461: iload 5
    //   463: putfield 185	ayiq:bqC	I
    //   466: iconst_0
    //   467: ireturn
    //   468: aload 9
    //   470: invokestatic 94	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   473: ifne +60 -> 533
    //   476: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +39 -> 518
    //   482: ldc 61
    //   484: iconst_2
    //   485: new 63	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   492: ldc 187
    //   494: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 11
    //   499: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc 189
    //   504: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 9
    //   509: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: sipush -301
    //   521: ireturn
    //   522: astore_1
    //   523: aconst_null
    //   524: astore_1
    //   525: goto -175 -> 350
    //   528: astore 10
    //   530: goto -180 -> 350
    //   533: aload 11
    //   535: astore 9
    //   537: goto -152 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	ayiq
    //   0	540	1	paramPublishParam	PublishParam
    //   111	144	2	i	int
    //   146	311	3	j	int
    //   219	229	4	k	int
    //   201	261	5	m	int
    //   210	34	6	n	int
    //   74	336	7	l	long
    //   7	340	9	localObject1	java.lang.Object
    //   356	3	9	localIOException	java.io.IOException
    //   373	163	9	localObject2	java.lang.Object
    //   26	341	10	str1	java.lang.String
    //   528	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   32	502	11	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   281	292	344	java/io/FileNotFoundException
    //   313	318	356	java/io/IOException
    //   292	302	522	java/io/FileNotFoundException
    //   302	308	528	java/io/FileNotFoundException
  }
  
  private void a(Activity paramActivity, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam)
  {
    ThreadManager.post(new EditWebVideoPartManager.2(this, paramEditSource, paramPublishParam, paramActivity), 5, null, true);
  }
  
  /* Error */
  private void btz()
  {
    // Byte code:
    //   0: invokestatic 223	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 228	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   8: ifeq +235 -> 243
    //   11: ldc 230
    //   13: iconst_0
    //   14: invokestatic 236	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   17: new 238	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3
    //   20: dup
    //   21: aload_0
    //   22: aload 10
    //   24: invokespecial 241	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3:<init>	(Layiq;Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   27: invokevirtual 246	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   30: invokestatic 228	com/tencent/mobileqq/shortvideo/VideoEnvironment:awS	()Z
    //   33: ifeq +209 -> 242
    //   36: lconst_0
    //   37: lstore 6
    //   39: aload 10
    //   41: getfield 250	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore 9
    //   46: aload 9
    //   48: monitorenter
    //   49: aload 10
    //   51: getfield 250	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   54: invokevirtual 255	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   57: istore 8
    //   59: lload 6
    //   61: lstore 4
    //   63: iload 8
    //   65: ifne +104 -> 169
    //   68: lload 6
    //   70: lstore_2
    //   71: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +15 -> 89
    //   77: lload 6
    //   79: lstore_2
    //   80: ldc 61
    //   82: iconst_2
    //   83: ldc_w 257
    //   86: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: lload 6
    //   91: lstore_2
    //   92: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   95: lstore 4
    //   97: lload 6
    //   99: lstore_2
    //   100: aload 10
    //   102: getfield 250	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:cb	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   105: ldc2_w 266
    //   108: invokevirtual 273	java/lang/Object:wait	(J)V
    //   111: lload 6
    //   113: lstore_2
    //   114: invokestatic 265	android/os/SystemClock:elapsedRealtime	()J
    //   117: lload 4
    //   119: lsub
    //   120: lstore 6
    //   122: lload 6
    //   124: lstore 4
    //   126: lload 6
    //   128: lstore_2
    //   129: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +37 -> 169
    //   135: lload 6
    //   137: lstore_2
    //   138: ldc 61
    //   140: iconst_2
    //   141: new 63	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 275
    //   151: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: lload 6
    //   156: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   159: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: lload 6
    //   167: lstore 4
    //   169: aload 9
    //   171: monitorexit
    //   172: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 61
    //   180: iconst_2
    //   181: ldc_w 280
    //   184: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: lload 4
    //   189: ldc2_w 281
    //   192: lcmp
    //   193: ifge +49 -> 242
    //   196: bipush 30
    //   198: lload 4
    //   200: l2i
    //   201: isub
    //   202: istore_1
    //   203: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 61
    //   211: iconst_2
    //   212: new 63	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 284
    //   222: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload_1
    //   226: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: iload_1
    //   236: i2l
    //   237: lstore_2
    //   238: lload_2
    //   239: invokestatic 289	java/lang/Thread:sleep	(J)V
    //   242: return
    //   243: invokestatic 294	azbb:a	()Lazbb;
    //   246: invokevirtual 297	azbb:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   249: invokevirtual 303	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   252: pop
    //   253: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq -226 -> 30
    //   259: ldc 61
    //   261: iconst_2
    //   262: ldc_w 305
    //   265: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: goto -238 -> 30
    //   271: astore 9
    //   273: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +12 -> 288
    //   279: ldc 61
    //   281: iconst_2
    //   282: ldc_w 307
    //   285: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload 9
    //   290: invokevirtual 308	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   293: goto -263 -> 30
    //   296: astore 10
    //   298: lload_2
    //   299: lstore 4
    //   301: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq -135 -> 169
    //   307: ldc 61
    //   309: iconst_2
    //   310: ldc_w 310
    //   313: aload 10
    //   315: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: lload_2
    //   319: lstore 4
    //   321: goto -152 -> 169
    //   324: astore 10
    //   326: aload 9
    //   328: monitorexit
    //   329: aload 10
    //   331: athrow
    //   332: astore 9
    //   334: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq -95 -> 242
    //   340: ldc 61
    //   342: iconst_2
    //   343: ldc_w 316
    //   346: aload 9
    //   348: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	ayiq
    //   202	34	1	i	int
    //   70	249	2	l1	long
    //   61	259	4	l2	long
    //   37	129	6	l3	long
    //   57	7	8	bool	boolean
    //   44	126	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   271	56	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   332	15	9	localInterruptedException1	java.lang.InterruptedException
    //   3	98	10	localRMVideoStateMgr	dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
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
  
  protected SimpleObserver<ayqb> a()
  {
    return new ayir(this);
  }
  
  public void a(aaza.c paramc)
  {
    if (paramc != null) {
      this.jdField_a_of_type_Aaza$c = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayiq
 * JD-Core Version:    0.7.0.1
 */