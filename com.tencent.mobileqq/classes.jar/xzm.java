import com.tencent.biz.qqstory.database.PublishVideoEntry;

class xzm
  implements Runnable
{
  xzm(xzl paramxzl, PublishVideoEntry paramPublishVideoEntry, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: bipush 249
    //   5: istore_2
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_1
    //   10: aload_0
    //   11: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   14: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   17: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   20: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +21 -> 44
    //   26: aload_0
    //   27: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   30: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   33: aload_0
    //   34: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   37: getfield 50	com/tencent/biz/qqstory/database/PublishVideoEntry:thumbPath	Ljava/lang/String;
    //   40: invokestatic 53	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   43: pop
    //   44: aload_0
    //   45: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   48: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   51: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   54: ifnull +341 -> 395
    //   57: aload_0
    //   58: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   61: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   64: aload_0
    //   65: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   68: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   71: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   74: getfield 61	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokestatic 63	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   80: pop
    //   81: aload_0
    //   82: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   85: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   88: astore 7
    //   90: aload_0
    //   91: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   94: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   97: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   100: getfield 66	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   103: ifnonnull +274 -> 377
    //   106: aload_0
    //   107: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   110: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   113: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   116: invokestatic 74	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   119: astore 6
    //   121: aload 7
    //   123: aload 6
    //   125: invokestatic 77	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   128: pop
    //   129: aload_0
    //   130: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   133: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   136: aload_0
    //   137: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   140: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   143: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   146: getfield 80	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_Int	I
    //   149: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   152: pop
    //   153: aload_0
    //   154: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   157: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   160: aload_0
    //   161: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   164: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   167: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   170: getfield 85	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_b_of_type_Int	I
    //   173: invokestatic 87	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   176: pop
    //   177: aload_0
    //   178: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   181: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   184: aload_0
    //   185: getfield 18	xzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokestatic 90	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   191: pop
    //   192: invokestatic 95	com/tencent/mobileqq/utils/AudioHelper:a	()Z
    //   195: ifeq +11 -> 206
    //   198: aload_0
    //   199: getfield 18	xzm:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: invokestatic 100	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;)I
    //   205: pop
    //   206: aload_0
    //   207: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   210: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   213: invokestatic 102	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   216: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifne +981 -> 1200
    //   222: new 104	java/io/File
    //   225: dup
    //   226: aload_0
    //   227: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   230: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   233: invokestatic 102	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   236: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore 6
    //   241: iload_1
    //   242: istore_2
    //   243: aload 6
    //   245: invokevirtual 110	java/io/File:exists	()Z
    //   248: ifeq +85 -> 333
    //   251: new 112	java/io/FileInputStream
    //   254: dup
    //   255: aload_0
    //   256: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   259: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   262: invokestatic 102	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   265: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   268: astore 7
    //   270: aload 6
    //   272: invokevirtual 117	java/io/File:length	()J
    //   275: lstore 4
    //   277: aload_0
    //   278: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   281: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   284: aload 7
    //   286: lload 4
    //   288: invokestatic 123	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   291: invokestatic 125	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   294: pop
    //   295: aload_0
    //   296: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   299: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   302: aload_0
    //   303: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   306: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   309: invokestatic 128	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   312: invokestatic 132	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   315: invokestatic 135	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:d	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   318: pop
    //   319: iload_1
    //   320: istore_2
    //   321: aload 7
    //   323: ifnull +10 -> 333
    //   326: aload 7
    //   328: invokevirtual 138	java/io/FileInputStream:close	()V
    //   331: iload_1
    //   332: istore_2
    //   333: iload_2
    //   334: ifeq +872 -> 1206
    //   337: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +28 -> 368
    //   343: ldc 145
    //   345: iconst_2
    //   346: new 147	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   353: ldc 150
    //   355: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: iload_2
    //   359: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   372: iload_2
    //   373: invokevirtual 168	xzl:a	(I)V
    //   376: return
    //   377: aload_0
    //   378: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   381: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   384: invokestatic 56	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo;
    //   387: getfield 66	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ThumbInfo:jdField_a_of_type_ArrayOfByte	[B
    //   390: astore 6
    //   392: goto -271 -> 121
    //   395: aload_0
    //   396: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   399: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   402: aload_0
    //   403: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   406: getfield 171	com/tencent/biz/qqstory/database/PublishVideoEntry:videoWidth	I
    //   409: invokestatic 83	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   412: pop
    //   413: aload_0
    //   414: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   417: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   420: aload_0
    //   421: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   424: getfield 174	com/tencent/biz/qqstory/database/PublishVideoEntry:videoHeight	I
    //   427: invokestatic 87	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;I)I
    //   430: pop
    //   431: new 104	java/io/File
    //   434: dup
    //   435: aload_0
    //   436: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   439: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   442: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   445: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   448: astore 8
    //   450: aload 8
    //   452: invokevirtual 110	java/io/File:exists	()Z
    //   455: ifeq +616 -> 1071
    //   458: new 112	java/io/FileInputStream
    //   461: dup
    //   462: aload_0
    //   463: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   466: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   469: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   472: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   475: astore 7
    //   477: aload 7
    //   479: astore 6
    //   481: aload 8
    //   483: invokevirtual 117	java/io/File:length	()J
    //   486: lstore 4
    //   488: aload 7
    //   490: astore 6
    //   492: aload_0
    //   493: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   496: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   499: aload 7
    //   501: lload 4
    //   503: invokestatic 123	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   506: invokestatic 77	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;[B)[B
    //   509: pop
    //   510: aload 7
    //   512: astore 6
    //   514: aload_0
    //   515: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   518: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   521: aload_0
    //   522: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   525: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   528: invokestatic 176	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   531: invokestatic 132	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   534: invokestatic 63	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   537: pop
    //   538: aload 7
    //   540: ifnull +8 -> 548
    //   543: aload 7
    //   545: invokevirtual 138	java/io/FileInputStream:close	()V
    //   548: aload_0
    //   549: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   552: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   555: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   558: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   561: ifeq +33 -> 594
    //   564: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +11 -> 578
    //   570: ldc 145
    //   572: iconst_2
    //   573: ldc 178
    //   575: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: bipush 250
    //   580: istore_1
    //   581: goto -404 -> 177
    //   584: astore 6
    //   586: aload 6
    //   588: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   591: goto -43 -> 548
    //   594: aload_0
    //   595: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   598: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   601: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   604: ldc 186
    //   606: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   609: astore 6
    //   611: aload_0
    //   612: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   615: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   618: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   621: aload 6
    //   623: invokestatic 196	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   626: ifeq +21 -> 647
    //   629: aload_0
    //   630: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   633: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   636: aload 6
    //   638: invokestatic 53	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   641: pop
    //   642: iconst_0
    //   643: istore_1
    //   644: goto -63 -> 581
    //   647: aload 6
    //   649: invokestatic 199	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   652: ifne +952 -> 1604
    //   655: iload_2
    //   656: istore_1
    //   657: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   660: ifeq -79 -> 581
    //   663: ldc 145
    //   665: iconst_2
    //   666: new 147	java/lang/StringBuilder
    //   669: dup
    //   670: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   673: ldc 201
    //   675: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_0
    //   679: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   682: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   685: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   688: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc 203
    //   693: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 6
    //   698: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: iload_2
    //   708: istore_1
    //   709: goto -128 -> 581
    //   712: astore 8
    //   714: aconst_null
    //   715: astore 7
    //   717: aload 7
    //   719: astore 6
    //   721: aload 8
    //   723: invokevirtual 204	java/io/FileNotFoundException:printStackTrace	()V
    //   726: aload 7
    //   728: ifnull +8 -> 736
    //   731: aload 7
    //   733: invokevirtual 138	java/io/FileInputStream:close	()V
    //   736: aload_0
    //   737: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   740: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   743: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   746: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   749: ifeq +33 -> 782
    //   752: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   755: ifeq +11 -> 766
    //   758: ldc 145
    //   760: iconst_2
    //   761: ldc 178
    //   763: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: bipush 250
    //   768: istore_1
    //   769: goto -188 -> 581
    //   772: astore 6
    //   774: aload 6
    //   776: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   779: goto -43 -> 736
    //   782: aload_0
    //   783: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   786: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   789: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   792: ldc 186
    //   794: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   797: astore 6
    //   799: aload_0
    //   800: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   803: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   806: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   809: aload 6
    //   811: invokestatic 196	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   814: ifeq +21 -> 835
    //   817: aload_0
    //   818: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   821: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   824: aload 6
    //   826: invokestatic 53	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   829: pop
    //   830: iload_3
    //   831: istore_1
    //   832: goto -251 -> 581
    //   835: iload_3
    //   836: istore_1
    //   837: aload 6
    //   839: invokestatic 199	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   842: ifne -10 -> 832
    //   845: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   848: ifeq +47 -> 895
    //   851: ldc 145
    //   853: iconst_2
    //   854: new 147	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   861: ldc 201
    //   863: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_0
    //   867: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   870: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   873: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   876: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc 203
    //   881: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 6
    //   886: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   895: bipush 249
    //   897: istore_1
    //   898: goto -66 -> 832
    //   901: astore 7
    //   903: aconst_null
    //   904: astore 6
    //   906: aload 6
    //   908: ifnull +8 -> 916
    //   911: aload 6
    //   913: invokevirtual 138	java/io/FileInputStream:close	()V
    //   916: aload_0
    //   917: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   920: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   923: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   926: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   929: ifeq +30 -> 959
    //   932: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq +11 -> 946
    //   938: ldc 145
    //   940: iconst_2
    //   941: ldc 178
    //   943: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 7
    //   948: athrow
    //   949: astore 6
    //   951: aload 6
    //   953: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   956: goto -40 -> 916
    //   959: aload_0
    //   960: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   963: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   966: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   969: ldc 186
    //   971: invokestatic 191	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   974: astore 6
    //   976: aload_0
    //   977: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   980: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   983: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   986: aload 6
    //   988: invokestatic 196	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   991: ifeq +19 -> 1010
    //   994: aload_0
    //   995: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   998: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1001: aload 6
    //   1003: invokestatic 53	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;Ljava/lang/String;)Ljava/lang/String;
    //   1006: pop
    //   1007: goto -61 -> 946
    //   1010: aload 6
    //   1012: invokestatic 199	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   1015: ifne -69 -> 946
    //   1018: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1021: ifeq -75 -> 946
    //   1024: ldc 145
    //   1026: iconst_2
    //   1027: new 147	java/lang/StringBuilder
    //   1030: dup
    //   1031: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   1034: ldc 201
    //   1036: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_0
    //   1040: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1043: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1046: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1049: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc 203
    //   1054: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload 6
    //   1059: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1065: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1068: goto -122 -> 946
    //   1071: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1074: ifeq +37 -> 1111
    //   1077: ldc 145
    //   1079: iconst_2
    //   1080: new 147	java/lang/StringBuilder
    //   1083: dup
    //   1084: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   1087: ldc 206
    //   1089: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: aload_0
    //   1093: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1096: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1099: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1102: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1111: bipush 248
    //   1113: istore_1
    //   1114: goto -937 -> 177
    //   1117: astore 6
    //   1119: aload 6
    //   1121: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   1124: iload_1
    //   1125: istore_2
    //   1126: goto -793 -> 333
    //   1129: astore 7
    //   1131: aload 9
    //   1133: astore 6
    //   1135: aload 7
    //   1137: invokevirtual 204	java/io/FileNotFoundException:printStackTrace	()V
    //   1140: bipush 246
    //   1142: istore_1
    //   1143: iload_1
    //   1144: istore_2
    //   1145: aload 6
    //   1147: ifnull -814 -> 333
    //   1150: aload 6
    //   1152: invokevirtual 138	java/io/FileInputStream:close	()V
    //   1155: iload_1
    //   1156: istore_2
    //   1157: goto -824 -> 333
    //   1160: astore 6
    //   1162: aload 6
    //   1164: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   1167: iload_1
    //   1168: istore_2
    //   1169: goto -836 -> 333
    //   1172: astore 6
    //   1174: aconst_null
    //   1175: astore 7
    //   1177: aload 7
    //   1179: ifnull +8 -> 1187
    //   1182: aload 7
    //   1184: invokevirtual 138	java/io/FileInputStream:close	()V
    //   1187: aload 6
    //   1189: athrow
    //   1190: astore 7
    //   1192: aload 7
    //   1194: invokevirtual 184	java/io/IOException:printStackTrace	()V
    //   1197: goto -10 -> 1187
    //   1200: bipush 247
    //   1202: istore_2
    //   1203: goto -870 -> 333
    //   1206: aload_0
    //   1207: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1210: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1213: invokestatic 209	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1216: ifeq +57 -> 1273
    //   1219: aload_0
    //   1220: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1223: getfield 212	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1226: astore 6
    //   1228: aload_0
    //   1229: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1232: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1235: invokestatic 214	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Z
    //   1238: ifeq +25 -> 1263
    //   1241: new 104	java/io/File
    //   1244: dup
    //   1245: aload_0
    //   1246: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1249: getfield 212	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   1252: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   1255: invokevirtual 218	java/io/File:getParentFile	()Ljava/io/File;
    //   1258: invokevirtual 221	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1261: astore 6
    //   1263: aload 6
    //   1265: invokestatic 225	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:c	(Ljava/lang/String;)V
    //   1268: aload 6
    //   1270: invokestatic 227	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)V
    //   1273: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1276: ifeq +180 -> 1456
    //   1279: ldc 145
    //   1281: iconst_2
    //   1282: new 147	java/lang/StringBuilder
    //   1285: dup
    //   1286: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   1289: ldc 229
    //   1291: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: aload_0
    //   1295: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1298: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1301: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1304: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc 231
    //   1309: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_0
    //   1313: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1316: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1319: invokestatic 176	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1322: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1325: ldc 236
    //   1327: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload_0
    //   1331: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1334: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1337: invokestatic 68	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1340: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: ldc 238
    //   1345: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload_0
    //   1349: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1352: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1355: invokestatic 241	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1358: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: ldc 243
    //   1363: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1366: aload_0
    //   1367: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1370: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1373: invokestatic 245	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1376: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1379: ldc 247
    //   1381: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload_0
    //   1385: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1388: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1391: invokestatic 102	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1394: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: ldc 249
    //   1399: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: aload_0
    //   1403: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1406: getfield 253	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1409: d2i
    //   1410: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1413: ldc 255
    //   1415: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: aload_0
    //   1419: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1422: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1425: invokestatic 128	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1428: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 257
    //   1434: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload_0
    //   1438: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1441: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1444: invokestatic 259	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:d	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1447: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1453: invokestatic 165	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1456: aload_0
    //   1457: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1460: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1463: invokestatic 262	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ResultListener;
    //   1466: ifnull -1090 -> 376
    //   1469: aload_0
    //   1470: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1473: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1476: invokestatic 262	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask$ResultListener;
    //   1479: aload_0
    //   1480: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1483: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1486: invokestatic 102	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:c	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1489: aload_0
    //   1490: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1493: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1496: invokestatic 128	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1499: aload_0
    //   1500: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1503: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1506: invokestatic 39	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)Ljava/lang/String;
    //   1509: aload_0
    //   1510: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1513: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1516: invokestatic 241	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1519: aload_0
    //   1520: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1523: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1526: invokestatic 245	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:b	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)I
    //   1529: aload_0
    //   1530: getfield 14	xzm:jdField_a_of_type_Xzl	Lxzl;
    //   1533: getfield 34	xzl:a	Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;
    //   1536: invokestatic 176	com/tencent/mobileqq/activity/shortvideo/EncodeVideoTask:a	(Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;)[B
    //   1539: aload_0
    //   1540: getfield 16	xzm:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   1543: getfield 253	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   1546: d2i
    //   1547: invokeinterface 267 8 0
    //   1552: return
    //   1553: astore 6
    //   1555: aload 6
    //   1557: invokevirtual 268	java/lang/Exception:printStackTrace	()V
    //   1560: goto -287 -> 1273
    //   1563: astore 6
    //   1565: goto -388 -> 1177
    //   1568: astore 8
    //   1570: aload 6
    //   1572: astore 7
    //   1574: aload 8
    //   1576: astore 6
    //   1578: goto -401 -> 1177
    //   1581: astore 8
    //   1583: aload 7
    //   1585: astore 6
    //   1587: aload 8
    //   1589: astore 7
    //   1591: goto -456 -> 1135
    //   1594: astore 7
    //   1596: goto -690 -> 906
    //   1599: astore 8
    //   1601: goto -884 -> 717
    //   1604: iconst_0
    //   1605: istore_1
    //   1606: goto -1025 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1609	0	this	xzm
    //   9	1597	1	i	int
    //   5	1198	2	j	int
    //   7	829	3	k	int
    //   275	227	4	l	long
    //   119	394	6	localObject1	Object
    //   584	3	6	localIOException1	java.io.IOException
    //   609	111	6	localObject2	Object
    //   772	3	6	localIOException2	java.io.IOException
    //   797	115	6	str1	String
    //   949	3	6	localIOException3	java.io.IOException
    //   974	84	6	str2	String
    //   1117	3	6	localIOException4	java.io.IOException
    //   1133	18	6	localObject3	Object
    //   1160	3	6	localIOException5	java.io.IOException
    //   1172	16	6	localObject4	Object
    //   1226	43	6	str3	String
    //   1553	3	6	localException	java.lang.Exception
    //   1563	8	6	localObject5	Object
    //   1576	10	6	localObject6	Object
    //   88	644	7	localObject7	Object
    //   901	46	7	localObject8	Object
    //   1129	7	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   1175	8	7	localObject9	Object
    //   1190	3	7	localIOException6	java.io.IOException
    //   1572	18	7	localObject10	Object
    //   1594	1	7	localObject11	Object
    //   448	34	8	localFile	java.io.File
    //   712	10	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   1568	7	8	localObject12	Object
    //   1581	7	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   1599	1	8	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	1131	9	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   543	548	584	java/io/IOException
    //   458	477	712	java/io/FileNotFoundException
    //   731	736	772	java/io/IOException
    //   458	477	901	finally
    //   911	916	949	java/io/IOException
    //   326	331	1117	java/io/IOException
    //   251	270	1129	java/io/FileNotFoundException
    //   1150	1155	1160	java/io/IOException
    //   251	270	1172	finally
    //   1182	1187	1190	java/io/IOException
    //   1206	1228	1553	java/lang/Exception
    //   1228	1263	1553	java/lang/Exception
    //   1263	1273	1553	java/lang/Exception
    //   270	319	1563	finally
    //   1135	1140	1568	finally
    //   270	319	1581	java/io/FileNotFoundException
    //   481	488	1594	finally
    //   492	510	1594	finally
    //   514	538	1594	finally
    //   721	726	1594	finally
    //   481	488	1599	java/io/FileNotFoundException
    //   492	510	1599	java/io/FileNotFoundException
    //   514	538	1599	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzm
 * JD-Core Version:    0.7.0.1
 */