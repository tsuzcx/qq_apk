package com.tencent.biz.qqstory.takevideo.slideshow;

import ahbj;
import amal;
import aman;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import rar;
import rlt;
import rmg;
import rou;
import rox;

class ConvertRunnable
  implements amal, Runnable
{
  private long Cj = -1L;
  long Ck;
  long Cl;
  private aman jdField_a_of_type_Aman;
  private SlideItemInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo;
  QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
  rmg jdField_a_of_type_Rmg;
  private String aBh;
  private String aBi;
  private String aBj;
  private String aBk;
  private boolean aIM;
  private Bitmap cM;
  long fR;
  Context mContext;
  private long mDuration;
  private int mHeight;
  private WeakReference<a> mListenerRef;
  private int mResult;
  private volatile boolean mRun;
  private int mTextureID = -1;
  private long mTimeStamp;
  private int mWidth;
  
  public ConvertRunnable(Context paramContext, long paramLong1, SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, a parama)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo = paramSlideItemInfo;
    this.aBh = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mSrcPath;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mDuration = paramLong2;
    this.mListenerRef = new WeakReference(parama);
    this.aIM = paramBoolean;
    this.mRun = true;
    this.Cj = paramLong1;
    this.jdField_a_of_type_Rmg = null;
  }
  
  private boolean LG()
  {
    if ((!this.mRun) && (QLog.isColorLevel())) {
      QLog.d("ConvertRunnable", 2, "run exit:" + this.Cj + " run:" + this.mRun);
    }
    return !this.mRun;
  }
  
  private boolean LH()
  {
    if ((this.jdField_a_of_type_Aman != null) && (this.mTextureID > 0) && (this.mTimeStamp < this.mDuration))
    {
      this.jdField_a_of_type_Aman.f(3553, this.mTextureID, null, null, this.mTimeStamp);
      this.mTimeStamp += 42000000L;
      return true;
    }
    return false;
  }
  
  private int a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0)) {
      if (paramBitmap == null) {
        paramInt1 = i;
      }
    }
    do
    {
      return paramInt1;
      return GlUtil.createTexture(3553, paramBitmap);
      i = GlUtil.createTexture(3553, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChain(new int[] { 170 }, null);
      List localList = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(170);
      if ((localList != null) && (localList.size() > 0) && ((localList.get(0) instanceof QQImage2FrameFilter))) {
        ((QQImage2FrameFilter)localList.get(0)).setImageSize(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(i);
      paramInt1 = paramInt2;
    } while (i <= 0);
    GlUtil.deleteTexture(i);
    return paramInt2;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null)
      {
        rlt localrlt = new rlt();
        localrlt.mID = this.Cj;
        localrlt.mResult = paramInt;
        localrlt.mFile = paramString2;
        localrlt.aBm = paramString1;
        localrlt.mMediaFormat = paramMediaFormat;
        localrlt.aBn = this.aBj;
        localrlt.mHasAudioTrack = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.hasAudioTrack;
        localrlt.bth = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mSampleRate;
        locala.a(localrlt);
      }
    }
  }
  
  private int b(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if (paramBitmap == null) {
        return 0;
      }
      return GlUtil.createTexture(3553, paramBitmap);
    }
    Object localObject1 = Image2Video.a(paramBitmap, 0.05F, 5, false);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
    float f2 = paramInt1 * 1.0F / paramInt2;
    float f1 = paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localObject1 = new Matrix();
    ((Matrix)localObject1).postTranslate(i * -0.5F, j * -0.5F);
    float f3;
    float f4;
    Object localObject2;
    if (f1 > f2)
    {
      ((Matrix)localObject1).postScale(1.0F, paramInt1 * 1.0F / paramBitmap.getWidth() * paramBitmap.getHeight() / paramInt2);
      f2 = paramInt2;
      f3 = paramInt1 / f1;
      f4 = paramInt1;
      float f5 = paramInt2;
      localObject2 = new RectF(0.0F, 0.5F * (f2 - f3), f4, (paramInt1 / f1 + f5) * 0.5F);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), (RectF)localObject2, null);
    }
    for (;;)
    {
      ((Matrix)localObject1).postTranslate(paramInt1 * 0.5F, paramInt2 * 0.5F);
      return GlUtil.createTexture(3553, localBitmap);
      ((Matrix)localObject1).postScale(paramInt2 * 1.0F / paramBitmap.getHeight() * paramBitmap.getWidth() / paramInt1, 1.0F);
      localObject2 = new Rect(0, 0, i, j);
      f2 = paramInt1;
      f3 = paramInt2;
      f4 = paramInt1;
      localCanvas.drawBitmap(paramBitmap, (Rect)localObject2, new RectF((f2 - f3 * f1) * 0.5F, 0.0F, (f1 * paramInt2 + f4) * 0.5F, paramInt2), null);
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ConvertRunnable", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.Cj + " run:" + this.mRun);
    }
    if (this.mRun)
    {
      this.mRun = false;
      this.mResult = 7;
      a(this.mResult, this.aBh, this.aBi, null);
    }
  }
  
  public void auv()
  {
    if (this.mRun)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.Cj);
      }
      if (!this.aIM)
      {
        this.mTextureID = b(this.cM, this.mWidth, this.mHeight);
        if (this.cM != null)
        {
          this.cM.recycle();
          this.cM = null;
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.Cj + " run:" + this.mRun + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + this.aIM);
        }
        this.Ck = System.currentTimeMillis();
        LH();
      }
    }
    do
    {
      return;
      this.mTextureID = a(this.cM, this.mWidth, this.mHeight);
      break;
      if (this.cM != null)
      {
        this.cM.recycle();
        this.cM = null;
      }
    } while (this.jdField_a_of_type_Aman == null);
    this.jdField_a_of_type_Aman.stopRecording();
  }
  
  public void btD()
  {
    if (!this.mRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFrame, mRun is false, tasid." + this.Cj);
      }
      if (this.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Aman.stopRecording();
      }
    }
    do
    {
      do
      {
        return;
      } while (LH());
      if (this.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Aman.stopRecording();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConvertRunnable", 2, "onEncodeFrame, stop recoder, taskid:" + this.Cj);
  }
  
  public void bvm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "[runLocalVideo2Video]run begin, taskid:" + this.Cj + " run:" + this.mRun);
    }
    if (LG())
    {
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, this.aBh, null, null);
      return;
    }
    Object localObject1 = new File(Image2Video.aBl);
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, createDir:" + bool);
      }
    }
    localObject1 = null;
    Object localObject3 = new File(this.aBh);
    if (localObject3 != null)
    {
      localObject3 = ((File)localObject3).getName();
      localObject1 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = ((String)localObject3).replace(".", "_");
        localObject1 = (String)localObject1 + ".mp4";
      }
    }
    this.aBi = (Image2Video.aBl + (String)localObject1);
    rox.fB(this.aBi);
    localObject1 = this.aBi + ".dat";
    if (rox.exists((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "before,getPCMFromFile[Have audio File]:  " + this.Cj + " audioPath: " + (String)localObject1 + " audioFileSize=" + ahbj.getFileSize((String)localObject1));
      }
      localObject3 = new rou();
      l1 = System.currentTimeMillis();
      ((rou)localObject3).a(this.aBh, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run,getMetaDataFromFile:  " + this.Cj + " cost=" + (l2 - l1) + " ms audioTrack: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.hasAudioTrack + " mSampleRate: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mSampleRate);
      }
    }
    for (;;)
    {
      this.aBj = ((String)localObject1);
      if (!LG()) {
        break;
      }
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, this.aBh, null, null);
      return;
      localObject3 = new rou();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.aBh;
      localLocalMediaInfo.mDuration = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mDuration;
      l1 = System.currentTimeMillis();
      bool = ((rou)localObject3).b(localLocalMediaInfo, 0, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mDuration, (String)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "run,getPCMFromFile:  " + this.Cj + " cost=" + (l2 - l1) + " ms audioTrack: " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.hasAudioTrack);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.hasAudioTrack)
      {
        if ((!bool) || (!rox.exists((String)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run,getPCMFromFile: failed " + this.Cj + " path=" + (String)localObject1 + " success=" + bool);
          }
          rox.fB((String)localObject1);
          rar.g("actVideo2VideoResult", new String[] { "8" });
          a(8, this.aBh, null, null);
        }
      }
      else
      {
        rox.fB((String)localObject1);
        rou.by((String)localObject1, (int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mDuration);
        if (!rox.exists((String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run[video convert],createSilentPCMFile: failed " + this.Cj + " path=" + (String)localObject1);
          }
          rar.g("actVideo2VideoResult", new String[] { "8" });
          a(8, this.aBh, null, null);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "After,getPCMFromFile: hasAudioTrack= " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.hasAudioTrack + " path=" + (String)localObject1 + " success=" + bool + " audioFileSize=" + ahbj.getFileSize((String)localObject1));
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.aBo = this.aBi;
    try
    {
      this.jdField_a_of_type_Rmg = new rmg();
      if (LG())
      {
        rar.g("actVideo2VideoResult", new String[] { "9" });
        a(9, this.aBh, null, null);
        return;
      }
    }
    finally {}
    long l1 = System.currentTimeMillis();
    boolean bool = this.jdField_a_of_type_Rmg.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo);
    long l2 = System.currentTimeMillis();
    if (LG())
    {
      rar.g("actVideo2VideoResult", new String[] { "9" });
      a(9, this.aBh, null, null);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.fR;
    rar.g("actVideo2VideoTime", new String[] { l3 - l4 + "" });
    if ((bool) && (ahbj.isFileExists(this.aBi)))
    {
      l3 = ahbj.getFileSize(this.aBi);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, file exist, size:" + l3 + " file:" + this.aBi);
      }
      this.mResult = 0;
      rar.g("actVideo2VideoResult", new String[] { "0" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, taskid:" + this.Cj + " run:" + this.mRun + " cost:" + (l2 - l1) + " ms successVideo:" + bool);
      }
      if (!this.mRun) {
        break;
      }
      a(this.mResult, this.aBh, this.aBi, null);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, [failed]file not exist:" + this.Cj + " file:" + this.aBi);
      }
      this.mResult = 7;
      rar.g("actVideo2VideoResult", new String[] { "7" });
      rox.fB(this.aBi);
    }
  }
  
  /* Error */
  public void bvn()
  {
    // Byte code:
    //   0: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +44 -> 47
    //   6: ldc 95
    //   8: iconst_2
    //   9: new 97	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 490
    //   19: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   26: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc 109
    //   31: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 83	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mRun	Z
    //   38: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokespecial 337	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:LG	()Z
    //   51: ifeq +32 -> 83
    //   54: ldc_w 492
    //   57: iconst_1
    //   58: anewarray 341	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 343
    //   66: aastore
    //   67: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   70: aload_0
    //   71: bipush 9
    //   73: aload_0
    //   74: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   77: aconst_null
    //   78: aconst_null
    //   79: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   82: return
    //   83: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   86: lstore_2
    //   87: new 494	java/io/FileInputStream
    //   90: dup
    //   91: aload_0
    //   92: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   95: invokespecial 495	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   98: astore 9
    //   100: new 497	java/io/BufferedInputStream
    //   103: dup
    //   104: aload 9
    //   106: ldc_w 498
    //   109: invokespecial 501	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   112: astore 8
    //   114: aload_0
    //   115: aload 8
    //   117: aconst_null
    //   118: aload_0
    //   119: getfield 68	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mWidth	I
    //   122: aload_0
    //   123: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mHeight	I
    //   126: invokestatic 506	aqcu:a	(Ljava/io/InputStream;Landroid/graphics/Rect;II)Landroid/graphics/Bitmap;
    //   129: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   132: aload 8
    //   134: ifnull +8 -> 142
    //   137: aload 8
    //   139: invokevirtual 509	java/io/BufferedInputStream:close	()V
    //   142: aload 9
    //   144: ifnull +8 -> 152
    //   147: aload 9
    //   149: invokevirtual 510	java/io/FileInputStream:close	()V
    //   152: aload_0
    //   153: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   156: ifnonnull +22 -> 178
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   164: aload_0
    //   165: getfield 68	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mWidth	I
    //   168: aload_0
    //   169: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mHeight	I
    //   172: invokestatic 514	aqcu:decodeSampledBitmapFromFile	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   175: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   178: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   181: lstore 4
    //   183: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +51 -> 237
    //   189: ldc 95
    //   191: iconst_2
    //   192: new 97	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 516
    //   202: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   209: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 518
    //   215: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 4
    //   220: lload_2
    //   221: lsub
    //   222: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: ldc_w 520
    //   228: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_0
    //   238: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   241: ifnonnull +200 -> 441
    //   244: aload_0
    //   245: iconst_0
    //   246: putfield 83	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mRun	Z
    //   249: ldc_w 492
    //   252: iconst_1
    //   253: anewarray 341	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: ldc_w 522
    //   261: aastore
    //   262: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   265: aload_0
    //   266: iconst_5
    //   267: aload_0
    //   268: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   271: aconst_null
    //   272: aconst_null
    //   273: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   276: return
    //   277: astore 7
    //   279: aload_0
    //   280: aconst_null
    //   281: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   284: aload_0
    //   285: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   288: ifnonnull +305 -> 593
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 83	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mRun	Z
    //   296: ldc_w 492
    //   299: iconst_1
    //   300: anewarray 341	java/lang/String
    //   303: dup
    //   304: iconst_0
    //   305: ldc_w 522
    //   308: aastore
    //   309: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   312: aload_0
    //   313: iconst_5
    //   314: aload_0
    //   315: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   318: aconst_null
    //   319: aconst_null
    //   320: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   323: return
    //   324: astore 9
    //   326: aconst_null
    //   327: astore 7
    //   329: aconst_null
    //   330: astore 8
    //   332: aload 9
    //   334: invokevirtual 525	java/lang/Exception:printStackTrace	()V
    //   337: aload 8
    //   339: ifnull +8 -> 347
    //   342: aload 8
    //   344: invokevirtual 509	java/io/BufferedInputStream:close	()V
    //   347: aload 7
    //   349: ifnull -197 -> 152
    //   352: aload 7
    //   354: invokevirtual 510	java/io/FileInputStream:close	()V
    //   357: goto -205 -> 152
    //   360: astore 7
    //   362: goto -210 -> 152
    //   365: astore 7
    //   367: aconst_null
    //   368: astore 9
    //   370: aconst_null
    //   371: astore 8
    //   373: aload 8
    //   375: ifnull +8 -> 383
    //   378: aload 8
    //   380: invokevirtual 509	java/io/BufferedInputStream:close	()V
    //   383: aload 9
    //   385: ifnull +8 -> 393
    //   388: aload 9
    //   390: invokevirtual 510	java/io/FileInputStream:close	()V
    //   393: aload 7
    //   395: athrow
    //   396: astore 7
    //   398: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +32 -> 433
    //   404: ldc 95
    //   406: iconst_2
    //   407: new 97	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 527
    //   417: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_0
    //   421: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   424: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   427: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: aload_0
    //   434: aconst_null
    //   435: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   438: goto -154 -> 284
    //   441: aload_0
    //   442: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   445: invokestatic 533	aqhu:getExifOrientation	(Ljava/lang/String;)I
    //   448: istore_1
    //   449: iload_1
    //   450: ifeq +88 -> 538
    //   453: iload_1
    //   454: bipush 90
    //   456: irem
    //   457: ifne +81 -> 538
    //   460: new 260	android/graphics/Matrix
    //   463: dup
    //   464: invokespecial 261	android/graphics/Matrix:<init>	()V
    //   467: astore 7
    //   469: aload 7
    //   471: iload_1
    //   472: i2f
    //   473: aload_0
    //   474: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   477: invokevirtual 175	android/graphics/Bitmap:getWidth	()I
    //   480: i2f
    //   481: fconst_2
    //   482: fdiv
    //   483: aload_0
    //   484: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   487: invokevirtual 178	android/graphics/Bitmap:getHeight	()I
    //   490: i2f
    //   491: fconst_2
    //   492: fdiv
    //   493: invokevirtual 537	android/graphics/Matrix:postRotate	(FFF)Z
    //   496: pop
    //   497: aload_0
    //   498: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   501: iconst_0
    //   502: iconst_0
    //   503: aload_0
    //   504: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   507: invokevirtual 175	android/graphics/Bitmap:getWidth	()I
    //   510: aload_0
    //   511: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   514: invokevirtual 178	android/graphics/Bitmap:getHeight	()I
    //   517: aload 7
    //   519: iconst_1
    //   520: invokestatic 540	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   523: astore 7
    //   525: aload_0
    //   526: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   529: invokevirtual 314	android/graphics/Bitmap:recycle	()V
    //   532: aload_0
    //   533: aload 7
    //   535: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   538: aload_0
    //   539: invokespecial 337	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:LG	()Z
    //   542: ifeq -258 -> 284
    //   545: aload_0
    //   546: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   549: ifnull +15 -> 564
    //   552: aload_0
    //   553: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   556: invokevirtual 314	android/graphics/Bitmap:recycle	()V
    //   559: aload_0
    //   560: aconst_null
    //   561: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   564: ldc_w 492
    //   567: iconst_1
    //   568: anewarray 341	java/lang/String
    //   571: dup
    //   572: iconst_0
    //   573: ldc_w 343
    //   576: aastore
    //   577: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   580: aload_0
    //   581: bipush 9
    //   583: aload_0
    //   584: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   587: aconst_null
    //   588: aconst_null
    //   589: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   592: return
    //   593: new 351	java/io/File
    //   596: dup
    //   597: getstatic 354	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:aBl	Ljava/lang/String;
    //   600: invokespecial 357	java/io/File:<init>	(Ljava/lang/String;)V
    //   603: astore 7
    //   605: aload 7
    //   607: invokevirtual 360	java/io/File:exists	()Z
    //   610: ifne +43 -> 653
    //   613: aload 7
    //   615: invokevirtual 363	java/io/File:mkdirs	()Z
    //   618: istore 6
    //   620: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +30 -> 653
    //   626: ldc 95
    //   628: iconst_2
    //   629: new 97	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 542
    //   639: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: iload 6
    //   644: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   647: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aconst_null
    //   654: astore 7
    //   656: new 351	java/io/File
    //   659: dup
    //   660: aload_0
    //   661: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   664: invokespecial 357	java/io/File:<init>	(Ljava/lang/String;)V
    //   667: astore 8
    //   669: aload 8
    //   671: ifnull +58 -> 729
    //   674: aload 8
    //   676: invokevirtual 368	java/io/File:getName	()Ljava/lang/String;
    //   679: astore 8
    //   681: aload 8
    //   683: astore 7
    //   685: aload 8
    //   687: invokestatic 374	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   690: ifne +39 -> 729
    //   693: aload 8
    //   695: ldc_w 376
    //   698: ldc_w 378
    //   701: invokevirtual 382	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   704: astore 7
    //   706: new 97	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   713: aload 7
    //   715: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: ldc_w 384
    //   721: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: astore 7
    //   729: aload_0
    //   730: new 97	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   737: getstatic 354	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:aBl	Ljava/lang/String;
    //   740: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 7
    //   745: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: putfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBi	Ljava/lang/String;
    //   754: aload_0
    //   755: new 97	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   762: aload_0
    //   763: getfield 296	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBi	Ljava/lang/String;
    //   766: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 544
    //   772: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   778: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   781: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: putfield 546	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBk	Ljava/lang/String;
    //   787: aload_0
    //   788: getfield 546	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBk	Ljava/lang/String;
    //   791: invokestatic 390	rox:fB	(Ljava/lang/String;)Z
    //   794: pop
    //   795: aload_0
    //   796: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mDuration	J
    //   799: l2i
    //   800: istore_1
    //   801: aload_0
    //   802: lconst_0
    //   803: putfield 125	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mTimeStamp	J
    //   806: aload_0
    //   807: ldc2_w 547
    //   810: aload_0
    //   811: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mDuration	J
    //   814: lmul
    //   815: putfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mDuration	J
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mDuration	J
    //   823: ldc2_w 549
    //   826: ldiv
    //   827: putfield 72	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mDuration	J
    //   830: aload_0
    //   831: invokespecial 337	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:LG	()Z
    //   834: ifeq +51 -> 885
    //   837: aload_0
    //   838: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   841: ifnull +15 -> 856
    //   844: aload_0
    //   845: getfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   848: invokevirtual 314	android/graphics/Bitmap:recycle	()V
    //   851: aload_0
    //   852: aconst_null
    //   853: putfield 309	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:cM	Landroid/graphics/Bitmap;
    //   856: ldc_w 492
    //   859: iconst_1
    //   860: anewarray 341	java/lang/String
    //   863: dup
    //   864: iconst_0
    //   865: ldc_w 343
    //   868: aastore
    //   869: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   872: aload_0
    //   873: bipush 9
    //   875: aload_0
    //   876: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   879: aconst_null
    //   880: aconst_null
    //   881: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   884: return
    //   885: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   888: lstore 4
    //   890: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   893: ifeq +51 -> 944
    //   896: ldc 95
    //   898: iconst_2
    //   899: new 97	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 552
    //   909: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_0
    //   913: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   916: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   919: ldc_w 554
    //   922: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: lload 4
    //   927: lload_2
    //   928: lsub
    //   929: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   932: ldc_w 520
    //   935: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   947: lstore_2
    //   948: new 97	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   955: getstatic 354	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video:aBl	Ljava/lang/String;
    //   958: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload 7
    //   963: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: ldc_w 392
    //   969: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: astore 7
    //   977: aload 7
    //   979: invokestatic 394	rox:exists	(Ljava/lang/String;)Z
    //   982: ifeq +9 -> 991
    //   985: aload 7
    //   987: invokestatic 557	rox:deleteFile	(Ljava/lang/String;)Z
    //   990: pop
    //   991: aload 7
    //   993: iload_1
    //   994: bipush 42
    //   996: iadd
    //   997: bipush 15
    //   999: iadd
    //   1000: invokestatic 445	rou:by	(Ljava/lang/String;I)V
    //   1003: aload 7
    //   1005: invokestatic 394	rox:exists	(Ljava/lang/String;)Z
    //   1008: ifne +78 -> 1086
    //   1011: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1014: ifeq +43 -> 1057
    //   1017: ldc 95
    //   1019: iconst_2
    //   1020: new 97	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1027: ldc_w 559
    //   1030: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: aload_0
    //   1034: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   1037: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1040: ldc_w 437
    //   1043: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 7
    //   1048: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: ldc_w 492
    //   1060: iconst_1
    //   1061: anewarray 341	java/lang/String
    //   1064: dup
    //   1065: iconst_0
    //   1066: ldc_w 441
    //   1069: aastore
    //   1070: invokestatic 349	rar:g	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1073: aload_0
    //   1074: bipush 8
    //   1076: aload_0
    //   1077: getfield 66	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBh	Ljava/lang/String;
    //   1080: aconst_null
    //   1081: aconst_null
    //   1082: invokespecial 298	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:a	(ILjava/lang/String;Ljava/lang/String;Landroid/media/MediaFormat;)V
    //   1085: return
    //   1086: aload_0
    //   1087: aload 7
    //   1089: putfield 214	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBj	Ljava/lang/String;
    //   1092: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   1095: lstore 4
    //   1097: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1100: ifeq +51 -> 1151
    //   1103: ldc 95
    //   1105: iconst_2
    //   1106: new 97	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 561
    //   1116: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload_0
    //   1120: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   1123: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1126: ldc_w 563
    //   1129: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: lload 4
    //   1134: lload_2
    //   1135: lsub
    //   1136: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1139: ldc_w 520
    //   1142: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1151: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   1154: lstore_2
    //   1155: aload_0
    //   1156: new 127	aman
    //   1159: dup
    //   1160: invokespecial 564	aman:<init>	()V
    //   1163: putfield 123	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Aman	Laman;
    //   1166: new 566	amae
    //   1169: dup
    //   1170: aload_0
    //   1171: getfield 546	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:aBk	Ljava/lang/String;
    //   1174: aload_0
    //   1175: getfield 68	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mWidth	I
    //   1178: aload_0
    //   1179: getfield 70	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:mHeight	I
    //   1182: invokestatic 571	alxh:a	()Lalxh;
    //   1185: iconst_1
    //   1186: invokevirtual 574	alxh:iS	(I)I
    //   1189: sipush 1000
    //   1192: imul
    //   1193: iconst_1
    //   1194: iconst_0
    //   1195: iconst_0
    //   1196: invokespecial 577	amae:<init>	(Ljava/lang/String;IIIIZI)V
    //   1199: astore 7
    //   1201: aload 7
    //   1203: invokestatic 583	android/opengl/EGL14:eglGetCurrentContext	()Landroid/opengl/EGLContext;
    //   1206: invokevirtual 586	amae:a	(Landroid/opengl/EGLContext;)V
    //   1209: aload_0
    //   1210: getfield 123	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:jdField_a_of_type_Aman	Laman;
    //   1213: aload 7
    //   1215: aload_0
    //   1216: invokevirtual 589	aman:a	(Lamae;Lamal;)V
    //   1219: invokestatic 305	java/lang/System:currentTimeMillis	()J
    //   1222: lstore 4
    //   1224: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1227: ifeq +51 -> 1278
    //   1230: ldc 95
    //   1232: iconst_2
    //   1233: new 97	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 591
    //   1243: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload_0
    //   1247: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   1250: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1253: ldc_w 593
    //   1256: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: lload 4
    //   1261: lload_2
    //   1262: lsub
    //   1263: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1266: ldc_w 520
    //   1269: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1275: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1278: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1281: ifeq -1199 -> 82
    //   1284: ldc 95
    //   1286: iconst_2
    //   1287: new 97	java/lang/StringBuilder
    //   1290: dup
    //   1291: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1294: ldc_w 595
    //   1297: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: aload_0
    //   1301: getfield 53	com/tencent/biz/qqstory/takevideo/slideshow/ConvertRunnable:Cj	J
    //   1304: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1313: return
    //   1314: astore 7
    //   1316: goto -1174 -> 142
    //   1319: astore 7
    //   1321: goto -1169 -> 152
    //   1324: astore 8
    //   1326: goto -979 -> 347
    //   1329: astore 8
    //   1331: goto -948 -> 383
    //   1334: astore 8
    //   1336: goto -943 -> 393
    //   1339: astore 7
    //   1341: aconst_null
    //   1342: astore 8
    //   1344: goto -971 -> 373
    //   1347: astore 7
    //   1349: goto -976 -> 373
    //   1352: astore 10
    //   1354: aload 7
    //   1356: astore 9
    //   1358: aload 10
    //   1360: astore 7
    //   1362: goto -989 -> 373
    //   1365: astore 10
    //   1367: aconst_null
    //   1368: astore 8
    //   1370: aload 9
    //   1372: astore 7
    //   1374: aload 10
    //   1376: astore 9
    //   1378: goto -1046 -> 332
    //   1381: astore 10
    //   1383: aload 9
    //   1385: astore 7
    //   1387: aload 10
    //   1389: astore 9
    //   1391: goto -1059 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1394	0	this	ConvertRunnable
    //   448	549	1	i	int
    //   86	1176	2	l1	long
    //   181	1079	4	l2	long
    //   618	25	6	bool	boolean
    //   277	1	7	localException1	java.lang.Exception
    //   327	26	7	localObject1	Object
    //   360	1	7	localException2	java.lang.Exception
    //   365	29	7	localObject2	Object
    //   396	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   467	747	7	localObject3	Object
    //   1314	1	7	localException3	java.lang.Exception
    //   1319	1	7	localException4	java.lang.Exception
    //   1339	1	7	localObject4	Object
    //   1347	8	7	localObject5	Object
    //   1360	26	7	localObject6	Object
    //   112	582	8	localObject7	Object
    //   1324	1	8	localException5	java.lang.Exception
    //   1329	1	8	localException6	java.lang.Exception
    //   1334	1	8	localException7	java.lang.Exception
    //   1342	27	8	localObject8	Object
    //   98	50	9	localFileInputStream	java.io.FileInputStream
    //   324	9	9	localException8	java.lang.Exception
    //   368	1022	9	localObject9	Object
    //   1352	7	10	localObject10	Object
    //   1365	10	10	localException9	java.lang.Exception
    //   1381	7	10	localException10	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   152	178	277	java/lang/Exception
    //   178	237	277	java/lang/Exception
    //   237	276	277	java/lang/Exception
    //   393	396	277	java/lang/Exception
    //   441	449	277	java/lang/Exception
    //   460	538	277	java/lang/Exception
    //   538	564	277	java/lang/Exception
    //   564	592	277	java/lang/Exception
    //   87	100	324	java/lang/Exception
    //   352	357	360	java/lang/Exception
    //   87	100	365	finally
    //   137	142	396	java/lang/OutOfMemoryError
    //   147	152	396	java/lang/OutOfMemoryError
    //   152	178	396	java/lang/OutOfMemoryError
    //   178	237	396	java/lang/OutOfMemoryError
    //   237	276	396	java/lang/OutOfMemoryError
    //   342	347	396	java/lang/OutOfMemoryError
    //   352	357	396	java/lang/OutOfMemoryError
    //   378	383	396	java/lang/OutOfMemoryError
    //   388	393	396	java/lang/OutOfMemoryError
    //   393	396	396	java/lang/OutOfMemoryError
    //   441	449	396	java/lang/OutOfMemoryError
    //   460	538	396	java/lang/OutOfMemoryError
    //   538	564	396	java/lang/OutOfMemoryError
    //   564	592	396	java/lang/OutOfMemoryError
    //   137	142	1314	java/lang/Exception
    //   147	152	1319	java/lang/Exception
    //   342	347	1324	java/lang/Exception
    //   378	383	1329	java/lang/Exception
    //   388	393	1334	java/lang/Exception
    //   100	114	1339	finally
    //   114	132	1347	finally
    //   332	337	1352	finally
    //   100	114	1365	java/lang/Exception
    //   114	132	1381	java/lang/Exception
  }
  
  public void kf(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, taskid:" + this.Cj + " run:" + this.mRun + " finish cost: " + (l1 - this.Ck) + " ms");
    }
    if (this.mRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, delete old:" + this.Cj + " file:" + this.aBi);
      }
      rox.fB(this.aBi);
      if (QLog.isColorLevel()) {
        QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename start:" + this.Cj + " file:" + this.aBi);
      }
      if (rox.rename(paramString, this.aBi))
      {
        this.mResult = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename end:" + this.Cj + " file:" + this.aBi + " result:" + this.mResult);
        }
        if (!ahbj.isFileExists(this.aBi)) {
          break label458;
        }
        l1 = ahbj.getFileSize(this.aBi);
        if (QLog.isColorLevel()) {
          QLog.d("ConvertRunnable", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.aBi);
        }
        label323:
        paramString = this.jdField_a_of_type_Aman.getMediaFormat();
        l1 = System.currentTimeMillis();
        long l2 = this.Cl;
        rar.g("actImage2VideoTime", new String[] { l1 - l2 + "" });
        rar.g("actImage2VideoResult", new String[] { "0" });
        a(this.mResult, this.aBh, this.aBi, paramString);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      }
      if (this.jdField_a_of_type_Aman != null)
      {
        this.jdField_a_of_type_Aman.release();
        this.jdField_a_of_type_Aman = null;
      }
      return;
      this.mResult = 7;
      break;
      label458:
      if (!QLog.isColorLevel()) {
        break label323;
      }
      QLog.d("ConvertRunnable", 2, "onEncodeFinish, file not exist:" + this.Cj + " file:" + this.aBi);
      break label323;
      rar.g("actImage2VideoResult", new String[] { "3" });
      rox.fB(paramString);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.mediaType == 0)
    {
      this.Cl = System.currentTimeMillis();
      bvn();
      return;
    }
    this.fR = System.currentTimeMillis();
    bvm();
  }
  
  public static abstract interface a
  {
    public abstract void a(rlt paramrlt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.ConvertRunnable
 * JD-Core Version:    0.7.0.1
 */