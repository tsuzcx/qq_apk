import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;

public class zko
{
  public static String a;
  private brfy jdField_a_of_type_Brfy;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Video2Video";
  }
  
  private void a(DecodeConfig paramDecodeConfig, bbmc parambbmc, int paramInt)
  {
    if (paramInt != 0)
    {
      parambbmc.h = paramInt;
      parambbmc.g = 0;
    }
    paramInt = Math.min(parambbmc.a, parambbmc.b);
    int i = Math.max(parambbmc.a, parambbmc.b);
    parambbmc.a = paramInt;
    parambbmc.b = i;
    paramDecodeConfig.width = parambbmc.a;
    paramDecodeConfig.height = parambbmc.b;
  }
  
  private boolean a()
  {
    if (this.c) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (a(paramLocalMediaInfo)) {
      return paramLocalMediaInfo.rotation + 90;
    }
    return paramLocalMediaInfo.rotation;
  }
  
  /* Error */
  public boolean a(com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   8: ifnonnull +24 -> 32
    //   11: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: getstatic 17	zko:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: iconst_2
    //   21: ldc 89
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: new 95	brfy
    //   36: dup
    //   37: invokespecial 96	brfy:<init>	()V
    //   40: putfield 98	zko:jdField_a_of_type_Brfy	Lbrfy;
    //   43: new 100	android/media/MediaMetadataRetriever
    //   46: dup
    //   47: invokespecial 101	android/media/MediaMetadataRetriever:<init>	()V
    //   50: astore 11
    //   52: aload 11
    //   54: aload_1
    //   55: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   58: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   61: invokevirtual 108	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   68: aload 11
    //   70: bipush 19
    //   72: invokevirtual 112	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   75: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: putfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   81: aload_1
    //   82: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   85: aload 11
    //   87: bipush 18
    //   89: invokevirtual 112	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   92: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: putfield 124	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   98: aload_1
    //   99: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   102: aload 11
    //   104: bipush 24
    //   106: invokevirtual 112	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: invokestatic 118	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: putfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   115: aload 11
    //   117: invokevirtual 127	android/media/MediaMetadataRetriever:release	()V
    //   120: aload_1
    //   121: getfield 130	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   124: lstore 7
    //   126: aload_1
    //   127: getfield 132	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   130: lstore 9
    //   132: aload_1
    //   133: getfield 134	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   136: astore 11
    //   138: aload_1
    //   139: getfield 136	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   142: astore 12
    //   144: aload_1
    //   145: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   148: getfield 124	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   151: istore_2
    //   152: aload_1
    //   153: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   156: getfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   159: istore_2
    //   160: aload_0
    //   161: aload_1
    //   162: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   165: invokevirtual 138	zko:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   168: istore 4
    //   170: new 27	bbmc
    //   173: dup
    //   174: aload 12
    //   176: sipush 720
    //   179: sipush 1280
    //   182: getstatic 143	bdbt:r	I
    //   185: iconst_1
    //   186: iconst_0
    //   187: aload_1
    //   188: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   191: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   194: invokespecial 146	bbmc:<init>	(Ljava/lang/String;IIIIZI)V
    //   197: astore 13
    //   199: aload 13
    //   201: sipush 720
    //   204: putfield 36	bbmc:a	I
    //   207: aload 13
    //   209: sipush 1280
    //   212: putfield 38	bbmc:b	I
    //   215: aload_1
    //   216: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   219: astore 14
    //   221: aload 14
    //   223: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   226: bipush 90
    //   228: if_icmpeq +14 -> 242
    //   231: aload 14
    //   233: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   236: sipush 270
    //   239: if_icmpne +335 -> 574
    //   242: aload 14
    //   244: getfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   247: istore_2
    //   248: aload 14
    //   250: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   253: bipush 90
    //   255: if_icmpeq +14 -> 269
    //   258: aload 14
    //   260: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   263: sipush 270
    //   266: if_icmpne +317 -> 583
    //   269: aload 14
    //   271: getfield 124	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   274: istore_3
    //   275: iload_2
    //   276: i2f
    //   277: iload_3
    //   278: i2f
    //   279: fdiv
    //   280: ldc 147
    //   282: fcmpl
    //   283: iflt +23 -> 306
    //   286: iload_2
    //   287: iload_3
    //   288: sipush 720
    //   291: sipush 1280
    //   294: invokestatic 152	zqb:a	(IIII)Z
    //   297: ifeq +9 -> 306
    //   300: aload 13
    //   302: iconst_1
    //   303: putfield 153	bbmc:c	Z
    //   306: new 49	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   309: dup
    //   310: aload_1
    //   311: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   314: getfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   317: iconst_0
    //   318: iconst_0
    //   319: iconst_1
    //   320: aload_1
    //   321: getfield 130	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   324: aload_1
    //   325: getfield 132	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   328: invokespecial 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZJJ)V
    //   331: astore 14
    //   333: aload_0
    //   334: aload 14
    //   336: aload 13
    //   338: iload 4
    //   340: invokespecial 158	zko:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lbbmc;I)V
    //   343: aload 14
    //   345: iconst_1
    //   346: putfield 161	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   349: aload 14
    //   351: aload_1
    //   352: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   355: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   358: putfield 164	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   361: aload 14
    //   363: aload_0
    //   364: aload_1
    //   365: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   368: invokevirtual 67	zko:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   371: putfield 167	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   374: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +101 -> 478
    //   380: getstatic 17	zko:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: iconst_2
    //   384: new 169	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   391: ldc 172
    //   393: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 11
    //   398: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: ldc 178
    //   403: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 12
    //   408: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc 180
    //   413: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: lload 7
    //   418: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: ldc 185
    //   423: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: lload 9
    //   428: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   431: ldc 187
    //   433: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_1
    //   437: getfield 82	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   440: getfield 72	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   443: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: ldc 192
    //   448: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 13
    //   453: getfield 31	bbmc:h	I
    //   456: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc 194
    //   461: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 14
    //   466: getfield 167	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   469: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   472: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload_0
    //   479: getfield 98	zko:jdField_a_of_type_Brfy	Lbrfy;
    //   482: aload 14
    //   484: aload 13
    //   486: new 206	zkp
    //   489: dup
    //   490: aload_0
    //   491: invokespecial 209	zkp:<init>	(Lzko;)V
    //   494: aconst_null
    //   495: invokevirtual 212	brfy:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lbbmc;Lbbmo;Lbrfz;)V
    //   498: aload_0
    //   499: getfield 23	zko:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   502: astore_1
    //   503: aload_1
    //   504: monitorenter
    //   505: aload_0
    //   506: getfield 58	zko:c	Z
    //   509: ifne +83 -> 592
    //   512: aload_0
    //   513: getfield 60	zko:jdField_a_of_type_Boolean	Z
    //   516: ifne +76 -> 592
    //   519: aload_0
    //   520: getfield 63	zko:b	Z
    //   523: istore 5
    //   525: iload 5
    //   527: ifne +65 -> 592
    //   530: aload_0
    //   531: getfield 23	zko:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   534: invokevirtual 215	java/lang/Object:wait	()V
    //   537: goto -32 -> 505
    //   540: astore 11
    //   542: goto -37 -> 505
    //   545: astore 12
    //   547: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +8 -> 558
    //   553: aload 12
    //   555: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   558: aload 11
    //   560: invokevirtual 127	android/media/MediaMetadataRetriever:release	()V
    //   563: goto -443 -> 120
    //   566: astore_1
    //   567: aload 11
    //   569: invokevirtual 127	android/media/MediaMetadataRetriever:release	()V
    //   572: aload_1
    //   573: athrow
    //   574: aload 14
    //   576: getfield 124	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   579: istore_2
    //   580: goto -332 -> 248
    //   583: aload 14
    //   585: getfield 121	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   588: istore_3
    //   589: goto -314 -> 275
    //   592: aload_1
    //   593: monitorexit
    //   594: aload_0
    //   595: invokespecial 220	zko:a	()Z
    //   598: istore 6
    //   600: iload 6
    //   602: istore 5
    //   604: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   607: ifeq -578 -> 29
    //   610: getstatic 17	zko:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   613: iconst_2
    //   614: new 169	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   621: ldc 222
    //   623: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: iload 6
    //   628: invokevirtual 197	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   631: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: iload 6
    //   639: ireturn
    //   640: astore 11
    //   642: aload_1
    //   643: monitorexit
    //   644: aload 11
    //   646: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	this	zko
    //   151	429	2	i	int
    //   274	315	3	j	int
    //   168	171	4	k	int
    //   27	576	5	bool1	boolean
    //   598	40	6	bool2	boolean
    //   124	293	7	l1	long
    //   130	297	9	l2	long
    //   50	347	11	localObject1	Object
    //   540	28	11	localInterruptedException	java.lang.InterruptedException
    //   640	5	11	localObject2	Object
    //   142	265	12	str	String
    //   545	9	12	localException	java.lang.Exception
    //   197	288	13	localbbmc	bbmc
    //   219	365	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   530	537	540	java/lang/InterruptedException
    //   52	115	545	java/lang/Exception
    //   52	115	566	finally
    //   547	558	566	finally
    //   505	525	640	finally
    //   530	537	640	finally
    //   592	594	640	finally
    //   642	644	640	finally
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo.mediaWidth > paramLocalMediaInfo.mediaHeight)
    {
      if (paramLocalMediaInfo.rotation % 180 != 0) {}
    }
    else {
      while ((paramLocalMediaInfo.rotation == 90) || (paramLocalMediaInfo.rotation == 270)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zko
 * JD-Core Version:    0.7.0.1
 */