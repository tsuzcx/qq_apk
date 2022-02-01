import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.b;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.PhoneProperty;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.List;
import mqq.app.AppRuntime;

@SuppressLint({"NewApi"})
public class anjd
{
  private anjd.a jdField_a_of_type_Anjd$a = new anjd.a(null);
  private ankz jdField_a_of_type_Ankz = new ankz();
  BaseFilter b;
  public zxz b;
  volatile AESticker jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker;
  BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public volatile boolean cAg;
  public boolean cHb = true;
  private boolean cHc;
  private boolean cHd;
  private boolean cHe;
  private boolean cHf = true;
  private boolean cannotReuseFrameBuffer = PhoneProperty.instance().isCannotReuseFrameBuffer();
  public int dHG;
  public int dHH;
  private int dHI;
  private int[] ed = new int[3];
  Frame g = new Frame();
  Frame h = new Frame();
  private int height;
  private Frame i = new Frame();
  private double mAspectRatio;
  BeautyRender mBeautyRender = null;
  private long mBeginTime;
  public volatile boolean mDetectedFace;
  public volatile boolean mDetectedGesture;
  private long mEndTime;
  private PTFaceAttr mFaceAttr;
  private int mFaceDetectBuffer;
  private int mFaceDetectHeight;
  private double mFaceDetectScale;
  private int mFaceDetectWidth;
  PTFaceDetector mFaceDetector = null;
  private int[] mFilterTextureId = new int[1];
  BaseFilter mFlipFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  Frame mFlipFrame = new Frame();
  public boolean mHasBackFilter;
  public GestureKeyInfo mLastGestureDetector;
  public volatile boolean mNeedDoFaceDetect;
  public volatile boolean mNeedDoGestureDetect;
  Frame mTempFrame = new Frame();
  private double mUIAspectRatio;
  VideoMaterial material;
  private boolean shouldInitTexture;
  private int width;
  private double windowScale = 1.0D;
  
  public anjd()
  {
    this.jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = -1;
    BeautyRender localBeautyRender = a();
    if (localBeautyRender != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      j = localBeautyRender.process(paramInt1, -1, paramInt2, paramInt3).getTextureId();
      return j;
      label42:
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  private Frame a(Frame paramFrame)
  {
    if (paramFrame == null) {
      return null;
    }
    Frame localFrame2 = paramFrame;
    Frame localFrame1 = paramFrame;
    for (paramFrame = localFrame2; (paramFrame.nextFrame != null) && (paramFrame.nextFrame.getTextureId() != 0); paramFrame = localFrame2)
    {
      localFrame2 = paramFrame.nextFrame;
      localFrame1 = paramFrame;
    }
    localFrame1.nextFrame = null;
    return paramFrame;
  }
  
  private boolean a(FilterRender paramFilterRender)
  {
    if (!anki.isBeautySwitchOpen()) {
      return false;
    }
    if (aasr.uV())
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramFilterRender != null) {
        if (paramFilterRender.getFilterType() != 3)
        {
          bool1 = bool2;
          if (!aasr.a().WZ()) {}
        }
        else
        {
          bool1 = false;
        }
      }
      return bool1;
    }
    QLog.e("filterbeauty", 2, "checkSkinColorAvailable false");
    return false;
  }
  
  private boolean b(FilterRender paramFilterRender)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFilterRender != null) {
      if (paramFilterRender.getFilterType() != 1)
      {
        bool1 = bool2;
        if (paramFilterRender.getFilterType() != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void dQy()
  {
    boolean bool = ankq.axX();
    String str;
    if ((!this.cHd) && (bool))
    {
      YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getContext());
      str = ankq.aM(VideoEnvironment.getContext());
      if (!TextUtils.isEmpty(str)) {
        FeatureManager.setModelDir(str);
      }
    }
    try
    {
      this.mFaceDetector = new PTFaceDetector();
      this.mFaceDetector.init();
      this.cHd = true;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        VideoEnvironment.k("QQFilterRenderManager", "OutOfMemoryError:", localOutOfMemoryError);
        ambe.j(new RuntimeException("initFaceDetector failed"));
        this.cHd = false;
      }
    }
  }
  
  private void setBeautyLevel(float paramFloat)
  {
    a().setBeautyLevel(anki.getBeatyRate() * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("FilterBeauty", 2, "setBeautyLevel " + paramFloat + "rate : " + anki.getBeatyRate());
    }
  }
  
  public int JI()
  {
    return this.h.getLastRenderTextureId();
  }
  
  public void Qa(boolean paramBoolean)
  {
    this.mNeedDoGestureDetect = paramBoolean;
    if (this.mNeedDoGestureDetect)
    {
      GestureMgrRecognize.getInstance().start();
      return;
    }
    this.mDetectedGesture = false;
    GestureMgrRecognize.getInstance().stop();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean3)
  {
    return a(paramInt1, paramInt2, paramInt3, this.cHb, paramBoolean1, true, paramBoolean2, paramFramePerformanceMonitor, paramBoolean3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean5)
  {
    long l1 = PtvFilterUtils.ha();
    anjl.dQK();
    Object localObject = new float[16];
    Matrix.setIdentityM((float[])localObject, 0);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.updateMatrix((float[])localObject);
    FilterRender localFilterRender = aasr.a().a(this.width, this.height);
    anjl.cHs = paramBoolean4;
    boolean bool1 = a(localFilterRender);
    boolean bool2 = b(localFilterRender);
    int j;
    if ((paramBoolean4) && (this.cHb) && (bool1) && (paramBoolean1))
    {
      this.mBeginTime = SystemClock.elapsedRealtimeNanos();
      j = a(bool2, paramInt3, this.dHG, this.dHH);
      this.mEndTime = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.mEndTime - this.mBeginTime) / 1000L + "us]");
      }
      if (j != -1) {
        this.ed[2] = j;
      }
      j = this.ed[2];
      paramBoolean4 = true;
    }
    for (;;)
    {
      dQy();
      if (((this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null) && (paramBoolean2)) || (this.jdField_b_of_type_Zxz != null))
      {
        if (paramBoolean4) {
          break label1906;
        }
        if ((this.cHb) && (bool1) && (paramBoolean1))
        {
          this.mBeginTime = SystemClock.elapsedRealtimeNanos();
          j = a(bool2, paramInt3, this.dHG, this.dHH);
          this.mEndTime = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.mEndTime - this.mBeginTime) / 1000L + "us]");
          }
          if (j != -1) {
            this.ed[2] = j;
          }
          j = this.ed[2];
          paramBoolean1 = true;
        }
      }
      for (;;)
      {
        this.mBeginTime = SystemClock.elapsedRealtimeNanos();
        BaseFilter localBaseFilter = this.jdField_c_of_type_ComTencentFilterBaseFilter.getmNextFilter();
        this.jdField_c_of_type_ComTencentFilterBaseFilter.setNextFilter(null, null);
        this.mFlipFilter.RenderProcess(j, this.dHG, this.dHH, this.ed[0], this.mAspectRatio, this.mFlipFrame);
        this.mEndTime = SystemClock.elapsedRealtimeNanos();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[mFlipFrame=" + (this.mEndTime - this.mBeginTime) / 1000L + "us]");
        }
        label522:
        label626:
        VideoMaterial localVideoMaterial;
        int k;
        label792:
        long l2;
        if ((this.mNeedDoFaceDetect) && (this.cHd))
        {
          this.mFaceAttr = this.mFaceDetector.detectFrame(this.mFlipFrame, 0L, 0, false, this.mFaceDetectScale, 90.0F, false, false, new StarParam());
          if (this.mFaceAttr.getFaceCount() > 0)
          {
            this.mDetectedFace = true;
            if (this.mNeedDoGestureDetect)
            {
              anjf.a().dQF();
              GestureMgrRecognize.getInstance().transferRGBAbuffer(this.ed[0], this.mFaceDetectWidth, this.mFaceDetectHeight, this.dHG, this.dHH);
              localObject = GestureMgrRecognize.getInstance().getGestureInfo();
              if ((localObject != null) && (((GestureKeyInfo)localObject).vaild) && (((GestureKeyInfo)localObject).type.equalsIgnoreCase(GestureFilterManager.sGestureType)))
              {
                this.mLastGestureDetector = ((GestureKeyInfo)localObject);
                this.mLastGestureDetector.timeStamp = System.currentTimeMillis();
              }
              if (this.mLastGestureDetector != null) {
                break label1648;
              }
              this.mDetectedGesture = false;
              anjf.a().dQG();
              if ((this.cAg) && (this.mDetectedGesture))
              {
                anjg.Qb(this.mDetectedGesture);
                QLog.d("GestureTestUse", 2, "we have record sucess result");
              }
              if ((!QLog.isColorLevel()) || (this.mLastGestureDetector == null)) {}
            }
            j = 0;
            localVideoMaterial = null;
            k = j;
            localObject = localVideoMaterial;
            if (this.mFaceDetector != null)
            {
              k = j;
              localObject = localVideoMaterial;
              if (this.mNeedDoFaceDetect)
              {
                k = j;
                localObject = localVideoMaterial;
                if (this.cHd)
                {
                  k = this.mFaceAttr.getFaceCount();
                  localObject = this.mFaceAttr.getAllFacePoints();
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getFaceCount faceCount=" + k + "]");
            }
            if (k <= 0) {
              break label1682;
            }
            paramBoolean4 = true;
            NewFlowCameraActivity.bxs = paramBoolean4;
            this.mBeginTime = SystemClock.elapsedRealtimeNanos();
            if ((this.jdField_b_of_type_Zxz != null) && (this.width != 0) && (localObject != null)) {
              this.jdField_b_of_type_Zxz.a(k, paramInt1, paramInt2, paramInt1 * 1.0F / this.width / this.mFaceDetectScale, (List)localObject);
            }
            this.mEndTime = SystemClock.elapsedRealtimeNanos();
            l2 = (this.mEndTime - this.mBeginTime) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[onCameraCallBack<Qzone> steptime=" + l2 + "us]");
            }
            this.mBeginTime = SystemClock.elapsedRealtimeNanos();
            int m = this.ed[0];
            j = m;
            if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null)
            {
              j = m;
              if (this.mFaceAttr != null) {
                j = this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.processTransformRelatedFilters(this.mFlipFrame, this.mFaceAttr, null, null).getTextureId();
              }
            }
            this.mEndTime = SystemClock.elapsedRealtimeNanos();
            l2 = (this.mEndTime - this.mBeginTime) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<TempFrame> steptime=" + l2 + "us]");
            }
            this.mFlipFilter.RenderProcess(j, this.dHG, this.dHH, this.ed[1], this.mAspectRatio, this.mTempFrame);
            m = this.ed[1];
            j = m;
            if (localFilterRender != null)
            {
              j = m;
              if (paramBoolean3) {
                j = localFilterRender.process(m, -1, this.width, this.height).getTextureId();
              }
            }
            this.mBeginTime = SystemClock.elapsedRealtimeNanos();
            if (!paramBoolean5) {
              break label1688;
            }
            localBaseFilter.RenderProcess(j, this.width, this.height, -2, this.mAspectRatio, this.h);
          }
        }
        for (;;)
        {
          this.jdField_c_of_type_ComTencentFilterBaseFilter.setNextFilter(localBaseFilter, null);
          this.mEndTime = SystemClock.elapsedRealtimeNanos();
          l2 = (this.mEndTime - this.mBeginTime) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<filterDrawTexture> steptime=" + l2 + "us] faceCount=" + k);
          }
          this.mBeginTime = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<DrawWindow>  afterChange=" + this.cHc);
          }
          if (paramBoolean5)
          {
            if (!this.cHc) {
              break label1847;
            }
            this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.i.getTextureId(), paramInt1, paramInt2, 0, this.mAspectRatio, this.g);
            this.i.clear();
            this.cHc = false;
            label1317:
            paramInt3 = JI();
          }
          this.mEndTime = SystemClock.elapsedRealtimeNanos();
          l2 = (this.mEndTime - this.mBeginTime) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderOperation<DrawWindow> steptime=" + l2 + "us]");
          }
          this.mBeginTime = SystemClock.elapsedRealtimeNanos();
          if (this.cannotReuseFrameBuffer)
          {
            this.h.clear();
            this.mFlipFrame.clear();
            this.mTempFrame.clear();
          }
          this.mEndTime = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReuseFrameBuffer=" + (this.mEndTime - this.mBeginTime) / 1000L + "us] cannotReuseFrameBuffer=" + this.cannotReuseFrameBuffer);
          }
          l1 = (PtvFilterUtils.ha() - l1) / 1000L;
          if ((this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker == null) || (!paramBoolean2)) {
            break label1875;
          }
          localVideoMaterial = this.material;
          localObject = "";
          if (localVideoMaterial != null) {
            localObject = localVideoMaterial.getId();
          }
          anjl.aU((String)localObject, l1);
          label1536:
          paramInt1 = this.dHI + 1;
          this.dHI = paramInt1;
          if (paramInt1 >= 20)
          {
            if ((!paramBoolean1) && (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker == null) && (paramFramePerformanceMonitor != null)) {
              paramFramePerformanceMonitor.bP(l1 / 1000L);
            }
            if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
              break label1883;
            }
            paramFramePerformanceMonitor = null;
            label1593:
            if (aaqh.cix != 2) {
              break label1895;
            }
            localObject = "back";
            label1605:
            aarz.a((String)localObject, paramBoolean1, paramFramePerformanceMonitor, l1 / 1000L);
          }
          return paramInt3;
          j = paramInt3;
          paramBoolean1 = paramBoolean4;
          break;
          this.mDetectedFace = false;
          break label522;
          this.mFaceAttr = null;
          break label522;
          label1648:
          if (this.mLastGestureDetector.timeStamp + 2000L >= System.currentTimeMillis())
          {
            this.mDetectedGesture = true;
            break label626;
          }
          this.mDetectedGesture = false;
          break label626;
          label1682:
          paramBoolean4 = false;
          break label792;
          label1688:
          paramInt3 = j;
        }
        if ((localFilterRender != null) && (paramBoolean3)) {
          j = localFilterRender.process(j, -1, this.width, this.height).getTextureId();
        }
        for (;;)
        {
          NewFlowCameraActivity.bxs = false;
          this.mBeginTime = SystemClock.elapsedRealtimeNanos();
          if (paramBoolean5) {
            this.jdField_c_of_type_ComTencentFilterBaseFilter.RenderProcess(j, this.width, this.height, -2, this.mAspectRatio, this.h);
          }
          for (;;)
          {
            this.mEndTime = SystemClock.elapsedRealtimeNanos();
            l2 = (this.mEndTime - this.mBeginTime) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<NofilterDrawTexture>=" + l2 + "us]");
            }
            anjl.lp(l2);
            paramBoolean1 = paramBoolean4;
            break;
            paramInt3 = j;
          }
          label1847:
          this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.h.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.mAspectRatio, this.g);
          break label1317;
          label1875:
          anjl.lq(l1);
          break label1536;
          label1883:
          paramFramePerformanceMonitor = this.material.getId();
          break label1593;
          label1895:
          localObject = "front";
          break label1605;
        }
        label1906:
        paramBoolean1 = paramBoolean4;
      }
      paramBoolean4 = false;
      j = paramInt3;
    }
  }
  
  public ankz a()
  {
    return this.jdField_a_of_type_Ankz;
  }
  
  public BeautyRender a()
  {
    if (this.mBeautyRender == null) {
      this.mBeautyRender = new BeautyRender(BaseApplicationImpl.context, igg.gB());
    }
    return this.mBeautyRender;
  }
  
  public void a(AESticker paramAESticker, boolean paramBoolean)
  {
    this.cHc = true;
    this.i = a(this.h);
    this.i.nextFrame = null;
    if ((this.i != this.h) && (paramBoolean)) {
      this.h.clear();
    }
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null)
    {
      GestureMgrRecognize.getInstance().stop();
      this.mLastGestureDetector = null;
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.clear();
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.cAg = false;
      if (QLog.isColorLevel()) {
        QLog.d("GestureTestUse", 2, "have run destroy here");
      }
    }
    if (paramAESticker != null)
    {
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker = paramAESticker;
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.updateVideoSize(this.dHG, this.dHH, this.windowScale);
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.setRatio((float)this.mUIAspectRatio);
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.apply();
    }
  }
  
  public void bS(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    float f = VideoEnvironment.a.zH;
    if (Math.max(paramInt1, paramInt2) < 960) {
      f = 1.0F;
    }
    this.dHG = ((int)(paramInt1 * f));
    this.dHH = ((int)(f * paramInt2));
    this.mUIAspectRatio = (paramInt1 / paramInt2);
    this.mFaceDetectScale = (FaceDetector.FACE_DETECT_WIDTH / this.dHG);
    this.mFaceDetectWidth = ((int)(this.dHG * this.mFaceDetectScale));
    this.mFaceDetectHeight = ((int)(this.dHH * this.mFaceDetectScale));
    this.mFaceDetectBuffer = (this.mFaceDetectWidth * this.mFaceDetectHeight * 4);
    this.windowScale = (paramInt1 / paramInt1);
    if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.updateVideoSize(this.dHG, this.dHH, this.windowScale);
    }
    this.h.clear();
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "updatePreviewSize:: width=" + paramInt1 + ";height=" + paramInt2 + ";widthFilter=" + this.dHG + ";heightFilter=" + this.dHH + ";mFaceDetectWidth" + this.mFaceDetectWidth + ";mFaceDetectHeight=" + this.mFaceDetectHeight);
    }
  }
  
  public void clear()
  {
    this.h.clear();
    this.g.clear();
    this.mFlipFrame.clear();
    this.mTempFrame.clear();
    this.i.clear();
    GLES20.glDeleteTextures(this.ed.length, this.ed, 0);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.mFlipFilter.ClearGLSL();
    if (this.mBeautyRender != null)
    {
      this.mBeautyRender.destroy();
      this.mBeautyRender = null;
    }
    this.jdField_a_of_type_Ankz.dRs();
    if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null)
    {
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.clear();
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker = null;
    }
  }
  
  public void dQA()
  {
    if (this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
      this.jdField_c_of_type_ComTencentAekitApiStandardFilterAESticker.destroyAudio();
    }
  }
  
  public void dQB() {}
  
  public void dQC()
  {
    aasr.a().cxS();
    if (this.mBeautyRender != null)
    {
      this.mBeautyRender.destroy();
      this.mBeautyRender = null;
    }
  }
  
  public void dQz()
  {
    a(null, false);
    if (this.mFaceDetector != null)
    {
      this.mFaceDetector.destroy();
      this.mFaceDetector = null;
    }
    this.cHd = false;
    this.cHe = false;
  }
  
  public void e(boolean paramBoolean, float paramFloat)
  {
    if (paramBoolean)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramFloat = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0).getInt("beauty_level" + str, (int)(NewFlowCameraActivity.ry * 100.0F)) / 100.0F;
    }
    setBeautyLevel(paramFloat);
  }
  
  public int getFaceCount()
  {
    if (this.mFaceAttr != null) {
      return this.mFaceAttr.getFaceCount();
    }
    return 0;
  }
  
  public VideoPreviewFaceOutlineDetector getFaceDetector()
  {
    return this.mFaceDetector.getFaceDetector();
  }
  
  public void initial()
  {
    clear();
    this.cHd = false;
    this.cHe = false;
    this.jdField_a_of_type_Ankz.dRr();
    GLES20.glGenTextures(this.ed.length, this.ed, 0);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.setNextFilter(this.jdField_b_of_type_ComTencentFilterBaseFilter, null);
    this.mFlipFilter.apply();
    this.mFlipFilter.setRotationAndFlip(0, 0, 1);
    e(true, 0.0F);
    j = 200;
    n = 5;
    try
    {
      k = Integer.parseInt(PtvTemplateManager.cdw);
      j = k;
      m = Integer.parseInt(PtvTemplateManager.cdv);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int m = n;
        int k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("GestureTestUse", 2, "GestureMgr.getInstance().setRecognizeMillis number exception" + j);
          m = n;
          k = j;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GestureTestUse", 2, "PtvTemplateManager.mGestureGapTime raw value " + PtvTemplateManager.cdw + ":GestureMgr.getInstance().setRecognizeMillis normal result" + k + ",frameRate is:" + m);
    }
    GestureMgrRecognize.getInstance().setRecognizeMillis(k);
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(m);
  }
  
  public void jB(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, paramInt1, paramInt2);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    a(null, true);
    bS(paramInt1, paramInt2);
    this.shouldInitTexture = true;
  }
  
  public void onSurfaceCreate()
  {
    dQy();
  }
  
  public void setFaceDetectFlags(boolean paramBoolean)
  {
    this.mNeedDoFaceDetect = paramBoolean;
  }
  
  static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjd
 * JD-Core Version:    0.7.0.1
 */