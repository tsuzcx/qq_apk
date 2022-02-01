import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class rmo
  extends rmm
{
  private ayyj a;
  long fR;
  private final Object mLock = new Object();
  
  private void a(DecodeConfig paramDecodeConfig, amae paramamae, int paramInt)
  {
    if (paramInt != 0)
    {
      paramamae.adjustRotation = paramInt;
      paramamae.orientation = 0;
    }
    paramInt = Math.min(paramamae.width, paramamae.height);
    int i = Math.max(paramamae.width, paramamae.height);
    paramamae.width = paramInt;
    paramamae.height = i;
    paramDecodeConfig.width = paramamae.width;
    paramDecodeConfig.height = paramamae.height;
  }
  
  private boolean a(SlideShowProcessor.a parama)
  {
    if (parama.mCanceled) {}
    while (!parama.mFinished) {
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
  public boolean a(SlideItemInfo arg1, SlideShowProcessor.a parama)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   8: ifnonnull +23 -> 31
    //   11: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 88
    //   19: iconst_2
    //   20: ldc 90
    //   22: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: iconst_0
    //   26: istore 6
    //   28: iload 6
    //   30: ireturn
    //   31: aload_0
    //   32: new 96	ayyj
    //   35: dup
    //   36: invokespecial 97	ayyj:<init>	()V
    //   39: putfield 99	rmo:a	Layyj;
    //   42: new 101	android/media/MediaMetadataRetriever
    //   45: dup
    //   46: invokespecial 102	android/media/MediaMetadataRetriever:<init>	()V
    //   49: astore 12
    //   51: aload 12
    //   53: aload_1
    //   54: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   57: getfield 106	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   60: invokevirtual 110	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   67: aload 12
    //   69: bipush 19
    //   71: invokevirtual 114	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   74: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: putfield 123	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   80: aload_1
    //   81: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   84: aload 12
    //   86: bipush 18
    //   88: invokevirtual 114	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   91: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: putfield 126	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   97: aload_1
    //   98: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   101: aload 12
    //   103: bipush 24
    //   105: invokevirtual 114	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   108: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: putfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   114: aload 12
    //   116: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   119: aload_1
    //   120: getfield 132	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   123: lstore 8
    //   125: aload_1
    //   126: getfield 135	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   129: lstore 10
    //   131: aload_1
    //   132: getfield 138	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:mSrcPath	Ljava/lang/String;
    //   135: astore 12
    //   137: aload_1
    //   138: getfield 141	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:aBo	Ljava/lang/String;
    //   141: astore 13
    //   143: aload_1
    //   144: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   147: getfield 126	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   150: istore_3
    //   151: aload_1
    //   152: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   155: getfield 123	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   158: istore_3
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   164: invokevirtual 143	rmo:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   167: istore 5
    //   169: new 24	amae
    //   172: dup
    //   173: aload 13
    //   175: sipush 720
    //   178: sipush 1280
    //   181: getstatic 148	aniq:dFI	I
    //   184: iconst_1
    //   185: iconst_0
    //   186: aload_1
    //   187: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   190: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   193: invokespecial 151	amae:<init>	(Ljava/lang/String;IIIIZI)V
    //   196: astore 14
    //   198: aload 14
    //   200: sipush 720
    //   203: putfield 34	amae:width	I
    //   206: aload 14
    //   208: sipush 1280
    //   211: putfield 37	amae:height	I
    //   214: aload_1
    //   215: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   218: astore 15
    //   220: aload 15
    //   222: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   225: bipush 90
    //   227: if_icmpeq +14 -> 241
    //   230: aload 15
    //   232: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   235: sipush 270
    //   238: if_icmpne +396 -> 634
    //   241: aload 15
    //   243: getfield 123	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   246: istore_3
    //   247: aload 15
    //   249: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   252: bipush 90
    //   254: if_icmpeq +14 -> 268
    //   257: aload 15
    //   259: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   262: sipush 270
    //   265: if_icmpne +378 -> 643
    //   268: aload 15
    //   270: getfield 126	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   273: istore 4
    //   275: iload_3
    //   276: i2f
    //   277: iload 4
    //   279: i2f
    //   280: fdiv
    //   281: ldc 152
    //   283: fcmpl
    //   284: iflt +24 -> 308
    //   287: iload_3
    //   288: iload 4
    //   290: sipush 720
    //   293: sipush 1280
    //   296: invokestatic 158	rpv:c	(IIII)Z
    //   299: ifeq +9 -> 308
    //   302: aload 14
    //   304: iconst_1
    //   305: putfield 161	amae:cBC	Z
    //   308: new 48	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   311: dup
    //   312: aload_1
    //   313: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   316: getfield 106	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: iconst_0
    //   320: iconst_0
    //   321: iconst_1
    //   322: aload_1
    //   323: getfield 132	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:startTime	J
    //   326: aload_1
    //   327: getfield 135	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:endTime	J
    //   330: invokespecial 164	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZJJ)V
    //   333: astore 15
    //   335: aload_0
    //   336: aload 15
    //   338: aload 14
    //   340: iload 5
    //   342: invokespecial 166	rmo:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lamae;I)V
    //   345: aload 15
    //   347: iconst_1
    //   348: putfield 169	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   351: aload 15
    //   353: aload_1
    //   354: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   357: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   360: putfield 170	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   363: aload 15
    //   365: aload_0
    //   366: aload_1
    //   367: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   370: invokevirtual 64	rmo:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   373: putfield 173	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   376: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +100 -> 479
    //   382: ldc 88
    //   384: iconst_2
    //   385: new 175	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   392: ldc 178
    //   394: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 12
    //   399: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc 184
    //   404: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 13
    //   409: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc 186
    //   414: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: lload 8
    //   419: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc 191
    //   424: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: lload 10
    //   429: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: ldc 193
    //   434: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_1
    //   438: getfield 80	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:d	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   441: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   444: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: ldc 198
    //   449: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 14
    //   454: getfield 28	amae:adjustRotation	I
    //   457: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: ldc 200
    //   462: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload 15
    //   467: getfield 173	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   470: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   473: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: aload_0
    //   480: getfield 99	rmo:a	Layyj;
    //   483: aload 15
    //   485: aload 14
    //   487: new 211	rmp
    //   490: dup
    //   491: aload_0
    //   492: aload_2
    //   493: invokespecial 214	rmp:<init>	(Lrmo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a;)V
    //   496: aconst_null
    //   497: invokevirtual 217	ayyj:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lamae;Lamal;Layyj$a;)V
    //   500: aload_0
    //   501: getfield 19	rmo:mLock	Ljava/lang/Object;
    //   504: astore_1
    //   505: aload_1
    //   506: monitorenter
    //   507: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +55 -> 565
    //   513: ldc 88
    //   515: iconst_2
    //   516: new 175	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   523: ldc 219
    //   525: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_2
    //   529: getfield 57	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:mCanceled	Z
    //   532: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   535: ldc 221
    //   537: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_2
    //   541: getfield 60	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:mFinished	Z
    //   544: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   547: ldc 223
    //   549: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_2
    //   553: getfield 226	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:aIP	Z
    //   556: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   559: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_2
    //   566: getfield 57	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:mCanceled	Z
    //   569: ifne +84 -> 653
    //   572: aload_2
    //   573: getfield 60	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:mFinished	Z
    //   576: ifne +77 -> 653
    //   579: aload_2
    //   580: getfield 226	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a:aIP	Z
    //   583: istore 6
    //   585: iload 6
    //   587: ifne +66 -> 653
    //   590: aload_0
    //   591: getfield 19	rmo:mLock	Ljava/lang/Object;
    //   594: invokevirtual 229	java/lang/Object:wait	()V
    //   597: goto -32 -> 565
    //   600: astore 12
    //   602: goto -37 -> 565
    //   605: astore 13
    //   607: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +8 -> 618
    //   613: aload 13
    //   615: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   618: aload 12
    //   620: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   623: goto -504 -> 119
    //   626: astore_1
    //   627: aload 12
    //   629: invokevirtual 129	android/media/MediaMetadataRetriever:release	()V
    //   632: aload_1
    //   633: athrow
    //   634: aload 15
    //   636: getfield 126	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   639: istore_3
    //   640: goto -393 -> 247
    //   643: aload 15
    //   645: getfield 123	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   648: istore 4
    //   650: goto -375 -> 275
    //   653: aload_1
    //   654: monitorexit
    //   655: aload_0
    //   656: aload_2
    //   657: invokespecial 234	rmo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$a;)Z
    //   660: istore 7
    //   662: iload 7
    //   664: istore 6
    //   666: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   669: ifeq -641 -> 28
    //   672: ldc 88
    //   674: iconst_2
    //   675: new 175	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   682: ldc 236
    //   684: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: iload 7
    //   689: invokevirtual 203	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   698: iload 7
    //   700: ireturn
    //   701: astore_2
    //   702: aload_1
    //   703: monitorexit
    //   704: aload_2
    //   705: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	706	0	this	rmo
    //   0	706	2	parama	SlideShowProcessor.a
    //   150	490	3	i	int
    //   273	376	4	j	int
    //   167	174	5	k	int
    //   26	639	6	bool1	boolean
    //   660	39	7	bool2	boolean
    //   123	295	8	l1	long
    //   129	299	10	l2	long
    //   49	349	12	localObject1	Object
    //   600	28	12	localInterruptedException	java.lang.InterruptedException
    //   141	267	13	str	String
    //   605	9	13	localException	java.lang.Exception
    //   196	290	14	localamae	amae
    //   218	426	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   590	597	600	java/lang/InterruptedException
    //   51	114	605	java/lang/Exception
    //   51	114	626	finally
    //   607	618	626	finally
    //   507	565	701	finally
    //   565	585	701	finally
    //   590	597	701	finally
    //   653	655	701	finally
    //   702	704	701	finally
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
  
  public void b(SlideShowProcessor.a parama)
  {
    if (parama == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "error currContext is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoToVideo", 2, "[runLocalVideo2Video]run begin, taskid:" + parama.Cj + " run:" + parama.isRun);
    }
    if (a(parama))
    {
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, parama.aBh, null, null, parama.a, parama);
      return;
    }
    Object localObject1 = new File(Image2Video.aBl);
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, createDir:" + bool);
      }
    }
    localObject1 = null;
    Object localObject2 = new File(parama.aBh);
    if (localObject2 != null)
    {
      localObject2 = ((File)localObject2).getName();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = ((String)localObject2).replace(".", "_");
        localObject1 = (String)localObject1 + ".mp4";
      }
    }
    this.aBi = (Image2Video.aBl + (String)localObject1);
    rox.fB(this.aBi);
    localObject1 = this.aBi + ".dat";
    if (rox.exists((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "before,getPCMFromFile[Have audio File]:  " + parama.Cj + " audioPath: " + (String)localObject1 + " audioFileSize=" + ahbj.getFileSize((String)localObject1));
      }
      localObject2 = new rou();
      l1 = System.currentTimeMillis();
      ((rou)localObject2).a(parama.aBh, parama.a);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "run,getMetaDataFromFile:  " + parama.Cj + " cost=" + (l2 - l1) + " ms audioTrack: " + parama.a.hasAudioTrack + " mSampleRate: " + parama.a.mSampleRate);
      }
    }
    for (;;)
    {
      this.aBj = ((String)localObject1);
      if (!a(parama)) {
        break;
      }
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, parama.aBh, null, null, parama.a, parama);
      return;
      localObject2 = new rou();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = parama.aBh;
      localLocalMediaInfo.mDuration = parama.a.mDuration;
      l1 = System.currentTimeMillis();
      bool = ((rou)localObject2).b(localLocalMediaInfo, 0, (int)parama.a.mDuration, (String)localObject1, parama.a);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "run,getPCMFromFile:  " + parama.Cj + " cost=" + (l2 - l1) + " ms audioTrack: " + parama.a.hasAudioTrack);
      }
      if (parama.a.hasAudioTrack)
      {
        if ((!bool) || (!rox.exists((String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoToVideo", 2, "run,getPCMFromFile: failed " + parama.Cj + " path=" + (String)localObject1 + " success=" + bool);
          }
          rox.fB((String)localObject1);
          rar.g("actVideo2VideoResult", new String[] { "8" });
          a(8, parama.aBh, null, null, parama.a, parama);
        }
      }
      else
      {
        rox.fB((String)localObject1);
        rou.by((String)localObject1, (int)parama.a.mDuration);
        if (!rox.exists((String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoToVideo", 2, "run[video convert],createSilentPCMFile: failed " + parama.Cj + " path=" + (String)localObject1);
          }
          rar.g("actVideo2VideoResult", new String[] { "8" });
          a(8, parama.aBh, null, null, parama.a, parama);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "After,getPCMFromFile: hasAudioTrack= " + parama.a.hasAudioTrack + " path=" + (String)localObject1 + " success=" + bool + " audioFileSize=" + ahbj.getFileSize((String)localObject1));
      }
    }
    parama.a.aBo = this.aBi;
    if (a(parama))
    {
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, parama.aBh, null, null, parama.a, parama);
      return;
    }
    long l1 = System.currentTimeMillis();
    boolean bool = a(parama.a, parama);
    long l2 = System.currentTimeMillis();
    if (a(parama))
    {
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, parama.aBh, null, null, parama.a, parama);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.fR;
    rar.g("actVideo2VideoTime", new String[] { l3 - l4 + "" });
    if ((bool) && (ahbj.isFileExists(this.aBi)))
    {
      l3 = ahbj.getFileSize(this.aBi);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, file exist, size:" + l3 + " file:" + this.aBi);
      }
      this.mResult = 0;
      rar.g("actVideo2VideoResult", new String[] { "0" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, taskid:" + parama.Cj + " run:" + parama.isRun + " cost:" + (l2 - l1) + " ms successVideo:" + bool);
      }
      if (!parama.isRun) {
        break;
      }
      a(this.mResult, parama.aBh, this.aBi, null, parama.a, parama);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, [failed]file not exist:" + parama.Cj + " file:" + this.aBi);
      }
      this.mResult = 7;
      rar.g("actVideo2VideoResult", new String[] { "7" });
      rox.fB(this.aBi);
    }
  }
  
  public void c(SlideShowProcessor.a parama)
  {
    if (this.a != null) {
      this.a.dJU();
    }
    synchronized (this.mLock)
    {
      parama.mCanceled = true;
      this.mLock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmo
 * JD-Core Version:    0.7.0.1
 */