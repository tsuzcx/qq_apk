import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class xjm
  extends xji
{
  long jdField_a_of_type_Long;
  private bnjh jdField_a_of_type_Bnjh;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  
  private void a(DecodeConfig paramDecodeConfig, axqz paramaxqz, int paramInt)
  {
    if (paramInt != 0)
    {
      paramaxqz.h = paramInt;
      paramaxqz.g = 0;
    }
    paramInt = Math.min(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
    int i = Math.max(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
    paramaxqz.jdField_a_of_type_Int = paramInt;
    paramaxqz.b = i;
    paramDecodeConfig.width = paramaxqz.jdField_a_of_type_Int;
    paramDecodeConfig.height = paramaxqz.b;
  }
  
  private boolean a(xjf paramxjf)
  {
    if (paramxjf.jdField_b_of_type_Boolean) {}
    while (!paramxjf.c) {
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
  
  public void a(xjf paramxjf)
  {
    if (paramxjf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "error currContext is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoToVideo", 2, "[runLocalVideo2Video]run begin, taskid:" + paramxjf.jdField_b_of_type_Long + " run:" + paramxjf.d);
    }
    if (a(paramxjf))
    {
      wta.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
      return;
    }
    Object localObject1 = new File(Image2Video.jdField_b_of_type_JavaLangString);
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, createDir:" + bool);
      }
    }
    localObject1 = null;
    Object localObject2 = new File(paramxjf.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_JavaLangString = (Image2Video.jdField_b_of_type_JavaLangString + (String)localObject1);
    xmx.g(this.jdField_a_of_type_JavaLangString);
    localObject1 = this.jdField_a_of_type_JavaLangString + ".dat";
    if (xmx.e((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "before,getPCMFromFile[Have audio File]:  " + paramxjf.jdField_b_of_type_Long + " audioPath: " + (String)localObject1 + " audioFileSize=" + arof.a((String)localObject1));
      }
      localObject2 = new xmu();
      l1 = System.currentTimeMillis();
      ((xmu)localObject2).a(paramxjf.jdField_a_of_type_JavaLangString, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "run,getMetaDataFromFile:  " + paramxjf.jdField_b_of_type_Long + " cost=" + (l2 - l1) + " ms audioTrack: " + paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean + " mSampleRate: " + paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_Int);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (!a(paramxjf)) {
        break;
      }
      wta.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
      return;
      localObject2 = new xmu();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramxjf.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mDuration = paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long;
      l1 = System.currentTimeMillis();
      bool = ((xmu)localObject2).a(localLocalMediaInfo, 0, (int)paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long, (String)localObject1, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "run,getPCMFromFile:  " + paramxjf.jdField_b_of_type_Long + " cost=" + (l2 - l1) + " ms audioTrack: " + paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean);
      }
      if (paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean)
      {
        if ((!bool) || (!xmx.e((String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoToVideo", 2, "run,getPCMFromFile: failed " + paramxjf.jdField_b_of_type_Long + " path=" + (String)localObject1 + " success=" + bool);
          }
          xmx.g((String)localObject1);
          wta.a("actVideo2VideoResult", new String[] { "8" });
          a(8, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
        }
      }
      else
      {
        xmx.g((String)localObject1);
        xmu.a((String)localObject1, (int)paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Long);
        if (!xmx.e((String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoToVideo", 2, "run[video convert],createSilentPCMFile: failed " + paramxjf.jdField_b_of_type_Long + " path=" + (String)localObject1);
          }
          wta.a("actVideo2VideoResult", new String[] { "8" });
          a(8, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "After,getPCMFromFile: hasAudioTrack= " + paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_a_of_type_Boolean + " path=" + (String)localObject1 + " success=" + bool + " audioFileSize=" + arof.a((String)localObject1));
      }
    }
    paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (a(paramxjf))
    {
      wta.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
      return;
    }
    long l1 = System.currentTimeMillis();
    boolean bool = a(paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
    long l2 = System.currentTimeMillis();
    if (a(paramxjf))
    {
      wta.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramxjf.jdField_a_of_type_JavaLangString, null, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_a_of_type_Long;
    wta.a("actVideo2VideoTime", new String[] { l3 - l4 + "" });
    if ((bool) && (arof.a(this.jdField_a_of_type_JavaLangString)))
    {
      l3 = arof.a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, file exist, size:" + l3 + " file:" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = 0;
      wta.a("actVideo2VideoResult", new String[] { "0" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, taskid:" + paramxjf.jdField_b_of_type_Long + " run:" + paramxjf.d + " cost:" + (l2 - l1) + " ms successVideo:" + bool);
      }
      if (!paramxjf.d) {
        break;
      }
      a(this.jdField_a_of_type_Int, paramxjf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, null, paramxjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, paramxjf);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "runLocalVideo2Video, [failed]file not exist:" + paramxjf.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Int = 7;
      wta.a("actVideo2VideoResult", new String[] { "7" });
      xmx.g(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  /* Error */
  public boolean a(SlideItemInfo arg1, xjf paramxjf)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   8: ifnonnull +24 -> 32
    //   11: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: ldc 78
    //   19: iconst_2
    //   20: ldc_w 287
    //   23: invokestatic 289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: istore 6
    //   29: iload 6
    //   31: ireturn
    //   32: aload_0
    //   33: new 291	bnjh
    //   36: dup
    //   37: invokespecial 292	bnjh:<init>	()V
    //   40: putfield 294	xjm:jdField_a_of_type_Bnjh	Lbnjh;
    //   43: new 296	android/media/MediaMetadataRetriever
    //   46: dup
    //   47: invokespecial 297	android/media/MediaMetadataRetriever:<init>	()V
    //   50: astore 12
    //   52: aload 12
    //   54: aload_1
    //   55: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   58: getfield 224	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   61: invokevirtual 300	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   68: aload 12
    //   70: bipush 19
    //   72: invokevirtual 304	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   75: invokestatic 310	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: putfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   81: aload_1
    //   82: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   85: aload 12
    //   87: bipush 18
    //   89: invokevirtual 304	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   92: invokestatic 310	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   95: putfield 316	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   98: aload_1
    //   99: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   102: aload 12
    //   104: bipush 24
    //   106: invokevirtual 304	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   109: invokestatic 310	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   112: putfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   115: aload 12
    //   117: invokevirtual 319	android/media/MediaMetadataRetriever:release	()V
    //   120: aload_1
    //   121: getfield 320	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   124: lstore 8
    //   126: aload_1
    //   127: getfield 322	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   130: lstore 10
    //   132: aload_1
    //   133: getfield 323	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   136: astore 12
    //   138: aload_1
    //   139: getfield 251	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   142: astore 13
    //   144: aload_1
    //   145: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   148: getfield 316	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   151: istore_3
    //   152: aload_1
    //   153: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   156: getfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   159: istore_3
    //   160: aload_0
    //   161: aload_1
    //   162: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   165: invokevirtual 325	xjm:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   168: istore 5
    //   170: new 22	axqz
    //   173: dup
    //   174: aload 13
    //   176: sipush 720
    //   179: sipush 1280
    //   182: getstatic 330	azds:r	I
    //   185: iconst_1
    //   186: iconst_0
    //   187: aload_1
    //   188: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   191: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   194: invokespecial 333	axqz:<init>	(Ljava/lang/String;IIIIZI)V
    //   197: astore 14
    //   199: aload 14
    //   201: sipush 720
    //   204: putfield 31	axqz:jdField_a_of_type_Int	I
    //   207: aload 14
    //   209: sipush 1280
    //   212: putfield 34	axqz:b	I
    //   215: aload_1
    //   216: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   219: astore 15
    //   221: aload 15
    //   223: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   226: bipush 90
    //   228: if_icmpeq +14 -> 242
    //   231: aload 15
    //   233: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   236: sipush 270
    //   239: if_icmpne +407 -> 646
    //   242: aload 15
    //   244: getfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   247: istore_3
    //   248: aload 15
    //   250: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   253: bipush 90
    //   255: if_icmpeq +14 -> 269
    //   258: aload 15
    //   260: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   263: sipush 270
    //   266: if_icmpne +389 -> 655
    //   269: aload 15
    //   271: getfield 316	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   274: istore 4
    //   276: iload_3
    //   277: i2f
    //   278: iload 4
    //   280: i2f
    //   281: fdiv
    //   282: ldc_w 334
    //   285: fcmpl
    //   286: iflt +24 -> 310
    //   289: iload_3
    //   290: iload 4
    //   292: sipush 720
    //   295: sipush 1280
    //   298: invokestatic 339	xom:a	(IIII)Z
    //   301: ifeq +9 -> 310
    //   304: aload 14
    //   306: iconst_1
    //   307: putfield 340	axqz:c	Z
    //   310: new 45	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   313: dup
    //   314: aload_1
    //   315: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   318: getfield 224	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: iconst_0
    //   322: iconst_0
    //   323: iconst_1
    //   324: aload_1
    //   325: getfield 320	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Long	J
    //   328: aload_1
    //   329: getfield 322	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_c_of_type_Long	J
    //   332: invokespecial 343	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZJJ)V
    //   335: astore 15
    //   337: aload_0
    //   338: aload 15
    //   340: aload 14
    //   342: iload 5
    //   344: invokespecial 345	xjm:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Laxqz;I)V
    //   347: aload 15
    //   349: iconst_1
    //   350: putfield 348	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   353: aload 15
    //   355: aload_1
    //   356: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   359: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   362: putfield 351	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   365: aload 15
    //   367: aload_0
    //   368: aload_1
    //   369: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   372: invokevirtual 64	xjm:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   375: putfield 354	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   378: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +107 -> 488
    //   384: ldc 78
    //   386: iconst_2
    //   387: new 86	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 356
    //   397: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 12
    //   402: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc_w 358
    //   408: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 13
    //   413: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 360
    //   419: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: lload 8
    //   424: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: ldc_w 362
    //   430: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: lload 10
    //   435: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   438: ldc_w 364
    //   441: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_1
    //   445: getfield 285	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   448: getfield 69	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   451: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: ldc_w 366
    //   457: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 14
    //   462: getfield 26	axqz:h	I
    //   465: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc_w 368
    //   471: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 15
    //   476: getfield 354	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   479: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   482: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload_0
    //   489: getfield 294	xjm:jdField_a_of_type_Bnjh	Lbnjh;
    //   492: aload 15
    //   494: aload 14
    //   496: new 370	xjn
    //   499: dup
    //   500: aload_0
    //   501: aload_2
    //   502: invokespecial 373	xjn:<init>	(Lxjm;Lxjf;)V
    //   505: aconst_null
    //   506: invokevirtual 376	bnjh:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Laxqz;Laxrl;Lbnji;)V
    //   509: aload_0
    //   510: getfield 17	xjm:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   513: astore_1
    //   514: aload_1
    //   515: monitorenter
    //   516: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +58 -> 577
    //   522: ldc 78
    //   524: iconst_2
    //   525: new 86	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 378
    //   535: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_2
    //   539: getfield 57	xjf:jdField_b_of_type_Boolean	Z
    //   542: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: ldc_w 380
    //   548: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_2
    //   552: getfield 60	xjf:c	Z
    //   555: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   558: ldc_w 382
    //   561: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_2
    //   565: getfield 383	xjf:jdField_a_of_type_Boolean	Z
    //   568: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload_2
    //   578: getfield 57	xjf:jdField_b_of_type_Boolean	Z
    //   581: ifne +84 -> 665
    //   584: aload_2
    //   585: getfield 60	xjf:c	Z
    //   588: ifne +77 -> 665
    //   591: aload_2
    //   592: getfield 383	xjf:jdField_a_of_type_Boolean	Z
    //   595: istore 6
    //   597: iload 6
    //   599: ifne +66 -> 665
    //   602: aload_0
    //   603: getfield 17	xjm:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   606: invokevirtual 386	java/lang/Object:wait	()V
    //   609: goto -32 -> 577
    //   612: astore 12
    //   614: goto -37 -> 577
    //   617: astore 13
    //   619: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +8 -> 630
    //   625: aload 13
    //   627: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   630: aload 12
    //   632: invokevirtual 319	android/media/MediaMetadataRetriever:release	()V
    //   635: goto -515 -> 120
    //   638: astore_1
    //   639: aload 12
    //   641: invokevirtual 319	android/media/MediaMetadataRetriever:release	()V
    //   644: aload_1
    //   645: athrow
    //   646: aload 15
    //   648: getfield 316	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   651: istore_3
    //   652: goto -404 -> 248
    //   655: aload 15
    //   657: getfield 313	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   660: istore 4
    //   662: goto -386 -> 276
    //   665: aload_1
    //   666: monitorexit
    //   667: aload_0
    //   668: aload_2
    //   669: invokespecial 391	xjm:a	(Lxjf;)Z
    //   672: istore 7
    //   674: iload 7
    //   676: istore 6
    //   678: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -652 -> 29
    //   684: ldc 78
    //   686: iconst_2
    //   687: new 86	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 393
    //   697: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: iload 7
    //   702: invokevirtual 105	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   705: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: iload 7
    //   713: ireturn
    //   714: astore_2
    //   715: aload_1
    //   716: monitorexit
    //   717: aload_2
    //   718: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	xjm
    //   0	719	2	paramxjf	xjf
    //   151	501	3	i	int
    //   274	387	4	j	int
    //   168	175	5	k	int
    //   27	650	6	bool1	boolean
    //   672	40	7	bool2	boolean
    //   124	299	8	l1	long
    //   130	304	10	l2	long
    //   50	351	12	localObject1	Object
    //   612	28	12	localInterruptedException	java.lang.InterruptedException
    //   142	270	13	str	String
    //   617	9	13	localException	java.lang.Exception
    //   197	298	14	localaxqz	axqz
    //   219	437	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   602	609	612	java/lang/InterruptedException
    //   52	115	617	java/lang/Exception
    //   52	115	638	finally
    //   619	630	638	finally
    //   516	577	714	finally
    //   577	597	714	finally
    //   602	609	714	finally
    //   665	667	714	finally
    //   715	717	714	finally
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
  
  public void b(xjf paramxjf)
  {
    if (this.jdField_a_of_type_Bnjh != null) {
      this.jdField_a_of_type_Bnjh.c();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramxjf.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */