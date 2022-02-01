package dov.com.qq.im.ae.camera.core;

import aasq;
import aath;
import acfp;
import alwb;
import alwx;
import alwy;
import alxg;
import amae;
import amal;
import aman;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import anij;
import aniq;
import aqhq;
import awtj;
import awvv;
import awvw;
import awvy;
import awvz;
import awwa;
import awwf;
import awwg;
import awwg.a;
import awwi;
import awwj;
import awwk;
import awxg.a;
import awyu;
import awyw.d;
import axbf;
import axbu;
import axcm;
import axcm.a;
import axec;
import axgj;
import axgk;
import axgm;
import axim;
import axip;
import axiy;
import aywy;
import azaj;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.a;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements amal, GLSurfaceView.Renderer, awwg.a, CameraCover.a, AudioCapture.a
{
  private static volatile boolean dtd;
  private alwb jdField_a_of_type_Alwb;
  private amae jdField_a_of_type_Amae;
  private awvv jdField_a_of_type_Awvv;
  private awwa jdField_a_of_type_Awwa;
  private awwi jdField_a_of_type_Awwi;
  private awwk jdField_a_of_type_Awwk;
  private awxg.a jdField_a_of_type_Awxg$a;
  public awyw.d a;
  private axbf jdField_a_of_type_Axbf;
  private axcm.a jdField_a_of_type_Axcm$a;
  private axcm jdField_a_of_type_Axcm;
  private axgm jdField_a_of_type_Axgm = new axgj();
  private azaj jdField_a_of_type_Azaj = new azaj();
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private volatile SensorUtil2 jdField_a_of_type_ComTencentTtpicUtilSensorUtil2;
  private a jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a;
  private b jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$b;
  private c jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c;
  private e jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e;
  private final long aBD = 83L;
  private long aBE;
  private long aBF;
  private aman jdField_b_of_type_Aman;
  private AEVideoCaptureResult jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private volatile boolean bzJ;
  private boolean cAC = true;
  private boolean cAE;
  private boolean cAT;
  private volatile boolean cAt;
  private float[] dV = new float[16];
  private boolean dsB;
  private boolean dsX;
  private boolean dsY = true;
  private boolean dsZ;
  private boolean dta;
  private boolean dtb;
  private boolean dtc;
  private boolean dte;
  private int dzC;
  private int dzg;
  private int dzm;
  private VideoMaterial e;
  private int eDh;
  private int eDi;
  private int eDj;
  private final int eDk;
  private Runnable iJ;
  private boolean isFirstFrame = true;
  private boolean isInit;
  private boolean isPaused = true;
  private int mSurfaceHeight = 480;
  private int mSurfaceWidth = 320;
  private PointF mTouchStartPoint = new PointF(0.0F, 0.0F);
  private int orientation = 90;
  private int smoothLevel;
  private AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener;
  private int videoHeight;
  private int videoWidth;
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initEGL();
    this.eDk = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    axgk.a().acy("glSurfaceViewConstruct-begin");
    initEGL();
    this.eDk = System.identityHashCode(this);
    axgk.a().acy("glSurfaceViewConstruct-end");
  }
  
  private void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l = SystemClock.elapsedRealtimeNanos();
    if ((aNU()) && (aNW()))
    {
      h(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
      return;
    }
    i(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a.a(paramVideoMaterial);
    }
  }
  
  private boolean aNU()
  {
    return (FeatureManager.isBasicFeaturesFunctionReady()) && (this.jdField_a_of_type_Awwi != null) && ((this.jdField_a_of_type_Awwi instanceof awwg));
  }
  
  private boolean aNV()
  {
    if (!aNU()) {
      return true;
    }
    if (!((awwg)this.jdField_a_of_type_Awwi).hasEffect()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean aNW()
  {
    return (this.dtb) && (this.cAt) && (this.jdField_a_of_type_Amae != null);
  }
  
  private void aSE()
  {
    this.jdField_a_of_type_Axbf = new awvz(this, getContext());
    if (this.jdField_a_of_type_Axbf.canDetectOrientation()) {
      this.jdField_a_of_type_Axbf.enable();
    }
  }
  
  private void adq(int paramInt)
  {
    if ((aNW()) && (this.aBE > 0L))
    {
      Object localObject = (awwg)this.jdField_a_of_type_Awwi;
      if (this.jdField_a_of_type_Axcm == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.jdField_a_of_type_Axcm = new axcm();
        this.jdField_a_of_type_Axcm.init();
      }
      long l = (SystemClock.elapsedRealtimeNanos() - this.aBE) / 1000000L;
      int i = this.jdField_a_of_type_Axcm.getFrameCount();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i);
      if ((i < 3) && ((float)l > (i + 0.5F) * 1000.0F) && (((awwg)localObject).detectedFace()))
      {
        localObject = (PTFaceAttr)((awwg)localObject).getAIAttr().getFaceAttr();
        this.jdField_a_of_type_Axcm.b(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.eDi * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.eDj * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void b(aasq paramaasq)
  {
    if (this.jdField_a_of_type_Awwa.aOa()) {
      this.jdField_a_of_type_Awwa.k((Activity)getContext(), true);
    }
    Object localObject = this.jdField_a_of_type_Awvv.bZj + "/" + System.currentTimeMillis() + ".jpg";
    aqhq.UD((String)localObject);
    localObject = new File((String)localObject);
    boolean bool = this.jdField_a_of_type_Awwa.isFrontCamera();
    int i = alwy.iP(this.dzm);
    this.jdField_a_of_type_Awwa.a((File)localObject, i, bool, this, paramaasq);
  }
  
  private void b(CameraCaptureView.h paramh)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.a(paramh);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.7(this));
  }
  
  public static void boP()
  {
    try
    {
      axiy.i("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + dtd);
      long l = System.currentTimeMillis();
      if (!dtd)
      {
        axiy.i("AECameraGLSurfaceView", "[initSdk] do init");
        dtd = true;
        axgk.a().acy("glSurfaceViewStaticInit-begin");
        if (awtj.init()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.z());
        }
        axgk.a().acy("glSurfaceViewStaticInit-end");
      }
      axiy.i("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
    }
    finally {}
  }
  
  private void cR(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a.cQ(paramBoolean1, paramBoolean2);
    }
  }
  
  private void dKX()
  {
    aSE();
    this.jdField_a_of_type_Axgm.onFirstFrame();
  }
  
  private void dKZ()
  {
    if (this.dtb)
    {
      this.aBE = 0L;
      this.aBF = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.jdField_a_of_type_Axcm != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.jdField_a_of_type_Axcm.setRecommendTextCallback(this.jdField_a_of_type_Axcm$a);
        this.jdField_a_of_type_Axcm.ctT();
        this.jdField_a_of_type_Axcm.reset();
      }
    }
  }
  
  private void eGG()
  {
    axiy.i("AECameraGLSurfaceView", "preAction");
    if (!dtd) {
      boP();
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 = new SensorUtil2();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void eGH()
  {
    if (this.jdField_a_of_type_Awwi != null) {
      return;
    }
    axiy.i("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if (FeatureManager.loadBasicFeatures())
    {
      this.jdField_a_of_type_Awwi = new awwg(this.eDk);
      axiy.i("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.jdField_a_of_type_Awwi = new awwj();
    axiy.e("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void eGI()
  {
    axgk.a().log("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.jdField_a_of_type_Awwi == null) {
      eGH();
    }
    if ((this.jdField_a_of_type_Awwi instanceof awwg))
    {
      awwf.a((awwg)this.jdField_a_of_type_Awwi);
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$b != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$b.eGb();
      }
      ((awwg)this.jdField_a_of_type_Awwi).XL(false);
      ((awwg)this.jdField_a_of_type_Awwi).setStickerInnerLutFilterListener(this.stickerInnerLutFilterListener);
      ((awwg)this.jdField_a_of_type_Awwi).a().setParam("SET_AEPROFILER_OBJ", this.jdField_a_of_type_Axgm);
    }
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_Awwi.a();
    localSurfaceTexture.setOnFrameAvailableListener(new awvy(this));
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e.g(localSurfaceTexture);
    }
    axgk.a().log("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void eGJ()
  {
    if ((this.e != null) && (VideoMaterialUtil.isAudio2textMaterial(this.e))) {
      this.jdField_a_of_type_Azaj.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  private void eGK()
  {
    if (this.jdField_a_of_type_Awwi != null)
    {
      this.jdField_a_of_type_Awwi.clear();
      this.jdField_a_of_type_Awwi = null;
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e.eGo();
      }
    }
    awwf.a(null);
  }
  
  private void eGN()
  {
    if (!aNU()) {
      return;
    }
    awwg localawwg = (awwg)this.jdField_a_of_type_Awwi;
    if ((localawwg.isNeedFaceDetect()) && (!localawwg.detectedFace()) && (!this.cAT))
    {
      this.dzC += 1;
      if (this.dzC >= 4)
      {
        cR(localawwg.isNeedFaceDetect(), localawwg.detectedFace());
        this.dzC = 0;
      }
    }
    if ((!this.cAT) && (localawwg.detectedFace())) {
      cR(localawwg.isNeedFaceDetect(), localawwg.detectedFace());
    }
    if (!localawwg.isNeedFaceDetect()) {
      cR(localawwg.isNeedFaceDetect(), localawwg.detectedFace());
    }
    if ((this.cAT) && (localawwg.detectedFace())) {
      cR(localawwg.isNeedFaceDetect(), localawwg.detectedFace());
    }
    this.cAT = localawwg.detectedFace();
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void h(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Awwi == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (awwg)this.jdField_a_of_type_Awwi;
      if (this.aBE == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.aBE = paramLong;
        axec.allFacePoints = new ArrayList();
        axec.allFaceAngles = new ArrayList();
      }
      paramInt2 = ((awwg)localObject).lz(paramInt2);
    } while ((paramLong - this.aBE) / 1000000L <= 83L * this.aBF);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.aBF) });
    this.aBF += 1L;
    if (((awwg)localObject).getAIAttr() != null)
    {
      localObject = (PTFaceAttr)((awwg)localObject).getAIAttr().getFaceAttr();
      axec.allFacePoints.add(((PTFaceAttr)localObject).getAllFacePoints());
      axec.allFaceAngles.add(((PTFaceAttr)localObject).getAllFaceAngles());
      axec.faceDetectScale = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    i(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void initEGL()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new awvw(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    eGG();
  }
  
  private void lr(int paramInt1, int paramInt2) {}
  
  private void ls(int paramInt1, int paramInt2)
  {
    int i = (int)(this.mSurfaceHeight * 1.0F / this.mSurfaceWidth * this.jdField_a_of_type_Awvv.QI());
    if (aywy.a().aRp()) {
      i = this.jdField_a_of_type_Awvv.QH();
    }
    if (this.cAE)
    {
      arrayOfInt = alwy.b(i, paramInt1, paramInt2);
      arrayOfInt = alwy.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Awvv.getClipWidth(), this.jdField_a_of_type_Awvv.getClipHeight(), 1.0F);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = alwy.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, this.jdField_a_of_type_Awvv.bZ());
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
    arrayOfInt = alwy.b(i, this.videoWidth, this.videoHeight);
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
  }
  
  private void onSurfaceDestroy()
  {
    this.dtc = false;
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.10(this, paramString));
  }
  
  private short[] toShortArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  public void AE(String paramString)
  {
    b(new CameraCaptureView.h(1, 0, paramString, null, this.orientation));
  }
  
  public int Is()
  {
    return this.jdField_a_of_type_Awwa.Is();
  }
  
  public void Pl(String paramString)
  {
    if ((!this.dsX) && (!this.jdField_a_of_type_Alwb.isActive()))
    {
      axiy.e("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        c(this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void Pm(String paramString)
  {
    if (this.jdField_a_of_type_Alwb.isActive())
    {
      axiy.e("AECameraGLSurfaceView", "onAudioChangeCaptured---filePath=" + paramString);
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        c(this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void Pn(String paramString)
  {
    if ((this.dsX) && (!this.jdField_a_of_type_Alwb.isActive()))
    {
      axiy.e("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath != null) {
        c(this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      }
    }
  }
  
  public void Tx(int paramInt) {}
  
  public void X(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Awwa.b(paramFloat1, paramFloat2, this.mSurfaceWidth, this.mSurfaceHeight);
  }
  
  public void XL(boolean paramBoolean)
  {
    if ((!PTHumanSegmenter.HUMAN_SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131690026), 0).show();
    }
    while (!aNU()) {
      return;
    }
    ((awwg)this.jdField_a_of_type_Awwi).XL(paramBoolean);
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.onCaptureError(104);
    }
  }
  
  public void a(aasq paramaasq)
  {
    if (aNV())
    {
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByCameraProxy");
      awyu.a.dtF = false;
      b(paramaasq);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axgm.eJq();
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.bSU();
      }
      return;
      QLog.d("AECameraGLSurfaceView", 4, "capturePhotoByAEKit");
      awyu.a.dtF = true;
      eGM();
    }
  }
  
  public void a(awwa paramawwa, awvv paramawvv)
  {
    if ((this.jdField_a_of_type_Awvv != null) || (this.jdField_a_of_type_Awwa != null)) {
      throw new RuntimeException("init is already called");
    }
    if (paramawwa == null) {
      throw new IllegalArgumentException("param cameraManager is null");
    }
    if (paramawvv == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.jdField_a_of_type_Awvv = paramawvv;
    this.jdField_a_of_type_Awwa = paramawwa;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + paramawvv);
    }
    this.jdField_b_of_type_Aman = new aman();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Awvv.bZj, 1, aniq.bth, aniq.ckG, aniq.mAudioFormat, this, this.jdField_a_of_type_Awwa.D());
    this.jdField_a_of_type_Alwb = new alwb(this.jdField_a_of_type_Awvv.bZj, aniq.bth, this);
    this.jdField_a_of_type_Awwa.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    if (this.dsX)
    {
      paramawwa = this.jdField_a_of_type_Awvv.bZj + File.separator + System.currentTimeMillis() + ".aac";
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.aJ(true, paramawwa);
    }
    this.jdField_a_of_type_Axgm.eJs();
    this.isInit = true;
  }
  
  public boolean aNX()
  {
    return ((this.jdField_a_of_type_Awwi instanceof awwg)) && (((awwg)this.jdField_a_of_type_Awwi).a() != null) && (((awwg)this.jdField_a_of_type_Awwi).a().getmPTSticker() != null) && (((awwg)this.jdField_a_of_type_Awwi).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void ao(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.6(this, paramBitmap), 64, null, false);
  }
  
  public void auv()
  {
    this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (!this.jdField_a_of_type_Alwb.isActive()) {
        break label56;
      }
      this.jdField_a_of_type_Alwb.init();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.startRecord();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.bSV();
      }
      return;
      label56:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.startRecord();
    }
  }
  
  public void btD()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  protected void c(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i = 1;
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.a(paramAEVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.4(this));
    alxg.dKD();
    if (anij.a().dGP == 1) {}
    for (;;)
    {
      alwx.TH(i);
      return;
      i = 2;
    }
  }
  
  public void dKM()
  {
    axiy.i("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.cAt);
    this.jdField_a_of_type_Axgm.eJr();
    if ((this.jdField_a_of_type_Awwa.aOa()) && (!this.dtb)) {
      this.jdField_a_of_type_Awwa.k((Activity)getContext(), true);
    }
    String str = this.jdField_a_of_type_Awvv.bZj + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.cAC) && (!this.dtb)) {}
    for (int i = alwy.iO(this.orientation);; i = 0)
    {
      this.jdField_a_of_type_Amae = new amae(str, this.videoWidth, this.videoHeight, this.jdField_a_of_type_Awvv.QG(), this.jdField_a_of_type_Awvv.QJ(), false, i);
      this.jdField_a_of_type_Amae.dzA = this.jdField_a_of_type_Awvv.QL();
      this.jdField_a_of_type_Amae.dzB = this.jdField_a_of_type_Awvv.QM();
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult = new AEVideoCaptureResult();
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.orientation = this.orientation;
      this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.type = 0;
      if (this.jdField_a_of_type_Awwa.Is() == 2) {
        this.jdField_a_of_type_Awwa.dQp();
      }
      this.cAt = true;
      alwy.cr(false, false);
      return;
    }
  }
  
  public void dKN()
  {
    axiy.i("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.cAt + ", recordingStatus=" + this.dzg + ", isPaused=" + this.isPaused);
    if (this.cAt)
    {
      this.cAt = false;
      if (this.dzg != 0) {
        break label100;
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c.onCaptureError(102);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Awwa.cye();
      return;
      label100:
      if (this.isPaused) {
        a(0, null, null);
      }
    }
  }
  
  public void dKT()
  {
    if (this.jdField_a_of_type_Awwi != null) {
      this.jdField_a_of_type_Awwi.XP(false);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e != null) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e.eGq();
    }
    this.jdField_a_of_type_Axgm.Yg(this.jdField_a_of_type_Awwa.isFrontCamera());
    if (this.dtb) {
      return;
    }
    axim.a().eKR();
    axiy.i("AECameraGLSurfaceView", "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_Awwa.isFrontCamera());
  }
  
  public void dKe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      aath.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
      queueEvent(new AECameraGLSurfaceView.5(this));
    }
  }
  
  public void dKf()
  {
    aath.a().a(null);
  }
  
  public void eGL()
  {
    if (!aNU()) {}
    while (this.jdField_a_of_type_Awwi == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.13(this));
  }
  
  public void eGM()
  {
    int i = 0;
    if (this.jdField_a_of_type_Awwa.aOa())
    {
      this.jdField_a_of_type_Awwa.k((Activity)getContext(), true);
      i = 1500;
    }
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.14(this), i);
  }
  
  public void eGn()
  {
    this.jdField_a_of_type_Axgm.eJp();
    this.isFirstFrame = true;
  }
  
  public int getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  void i(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.cAt) && (this.jdField_a_of_type_Amae != null))
    {
      switch (this.dzg)
      {
      default: 
        throw new RuntimeException("unknown status " + this.dzg);
      case 0: 
        this.jdField_a_of_type_Amae.a(EGL14.eglGetCurrentContext());
        this.jdField_b_of_type_Aman.dLX();
        this.jdField_b_of_type_Aman.a(this.jdField_a_of_type_Amae, this);
        this.dzg = 1;
      }
      this.jdField_b_of_type_Aman.f(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.dzg)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.dzg);
    }
    this.jdField_b_of_type_Aman.stopRecording();
    dKZ();
    this.dzg = 0;
  }
  
  public boolean isFrontCamera()
  {
    return this.jdField_a_of_type_Awwa.isFrontCamera();
  }
  
  public boolean isRecording()
  {
    return this.cAt;
  }
  
  public void kf(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath != null)
      {
        c(this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult);
        return;
      }
      if (this.jdField_a_of_type_Alwb.isActive())
      {
        this.jdField_a_of_type_Alwb.dKg();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
      return;
    }
    paramString = this.jdField_a_of_type_Awvv.bZj + "/noaudio";
    aqhq.UD(paramString);
    this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath = paramString;
    c(this.jdField_b_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void lq(int paramInt1, int paramInt2)
  {
    int k = 720;
    axiy.i("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.mSurfaceWidth + ", mSurfaceHeight=" + this.mSurfaceHeight);
    double d = this.mSurfaceWidth / this.mSurfaceHeight;
    this.videoWidth = paramInt1;
    this.videoHeight = ((int)(this.videoWidth / d));
    int i;
    int j;
    if (this.dtb)
    {
      int[] arrayOfInt = alwy.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      arrayOfInt = alwy.b(640, arrayOfInt[0], arrayOfInt[1]);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      this.eDi = i;
      this.eDj = j;
      this.videoWidth = this.eDi;
      this.videoHeight = this.eDj;
      if (this.jdField_a_of_type_Awwi != null)
      {
        if (i <= 720) {
          break label289;
        }
        float f = 720.0F / i;
        j = (int)(j * f);
        i = k;
      }
    }
    label289:
    for (;;)
    {
      this.jdField_a_of_type_Awwi.g(this.mSurfaceWidth, this.mSurfaceHeight, paramInt1, paramInt2, i, j);
      this.jdField_a_of_type_Awwa.Y(i, j, this.mSurfaceWidth, this.mSurfaceHeight);
      this.jdField_a_of_type_Awwi.updateVideoSize(this.videoWidth, this.videoHeight);
      lr(paramInt1, paramInt2);
      return;
      ls(paramInt1, paramInt2);
      j = paramInt2;
      i = paramInt1;
      break;
    }
  }
  
  public void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (aath.a().isEnable()) {
      aath.a().k(paramArrayOfByte, paramInt1, paramInt2);
    }
    short[] arrayOfShort = toShortArray(paramArrayOfByte);
    double d = 0.0D;
    int i = 0;
    while (i < arrayOfShort.length)
    {
      d += arrayOfShort[i] * arrayOfShort[i];
      i += 1;
    }
    Math.log10(d / arrayOfShort.length);
    this.jdField_a_of_type_Alwb.o(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Azaj.o(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onCaptureError(int paramInt) {}
  
  public void onDestroy()
  {
    if (QLog.isDevelopLevel()) {
      axiy.d("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.eDk + " ###");
    }
    if (this.jdField_a_of_type_Azaj != null) {
      this.jdField_a_of_type_Azaj.eUC();
    }
    if (this.jdField_a_of_type_Awwi != null) {
      this.jdField_a_of_type_Awwi.XP(true);
    }
    this.jdField_a_of_type_Axgm.eJt();
    if (this.jdField_b_of_type_Aman != null) {
      this.jdField_b_of_type_Aman.release();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    boolean bool = this.bzJ;
    if (this.dsY)
    {
      this.eDh += 1;
      if (!bool) {
        break label61;
      }
    }
    label61:
    for (paramGL10 = "onDrawFrameReal-begin";; paramGL10 = "onDrawFrameFake-begin" + this.eDh)
    {
      axgk.a().acy(paramGL10);
      if (this.isFirstFrame)
      {
        this.isFirstFrame = false;
        dKX();
      }
      if (this.jdField_a_of_type_Awwi != null) {
        break;
      }
      return;
    }
    if (this.dsY) {
      axgk.a().acy("FilterProcessInitFilters-begin");
    }
    this.jdField_a_of_type_Awwi.initFilters();
    if (this.dsY) {
      axgk.a().acy("FilterProcessInitFilters-end");
    }
    paramGL10 = this.jdField_a_of_type_Awwi.b(this.mSurfaceWidth, this.mSurfaceHeight, this.dtb);
    if (aNU())
    {
      awwg localawwg = (awwg)this.jdField_a_of_type_Awwi;
      eGN();
      if (this.jdField_a_of_type_Awxg$a != null) {
        this.jdField_a_of_type_Awxg$a.b(this.jdField_a_of_type_Awwa.Is(), localawwg.a());
      }
      adq(paramGL10[1]);
    }
    if ((this.dte) && (!this.dtb)) {
      this.jdField_a_of_type_Awwi.adu(paramGL10[1]);
    }
    a(paramGL10[1], null, null);
    if (this.iJ != null) {
      queueEvent(new AECameraGLSurfaceView.8(this));
    }
    this.jdField_a_of_type_Axgm.onDrawFrame();
    if (!this.dsB)
    {
      this.dsB = true;
      axip.a().eLw();
      axim.a().reportLaunch();
      if (awyu.aOl()) {
        awyu.a(this.jdField_a_of_type_Awyw$d, 5000L);
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e.eGp();
      }
    }
    if (this.dsY) {
      if (!bool) {
        break label359;
      }
    }
    label359:
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.eDh)
    {
      axgk.a().acy(paramGL10);
      if (bool) {
        this.dsY = false;
      }
      if (!bool) {
        break;
      }
      axgk.a().eJw();
      return;
    }
  }
  
  public void onPause()
  {
    axiy.i("AECameraGLSurfaceView", "[onPause] hashCode=" + this.eDk + " ###");
    queueEvent(new AECameraGLSurfaceView.2(this));
    this.isPaused = true;
    if (this.jdField_a_of_type_Axbf != null) {
      this.jdField_a_of_type_Axbf.disable();
    }
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.stop();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2 != null) {
      this.jdField_a_of_type_ComTencentTtpicUtilSensorUtil2.start();
    }
    if (QLog.isDevelopLevel()) {
      axiy.d("AECameraGLSurfaceView", "### onResume, hashCode=" + this.eDk + " ###");
    }
    this.cAt = false;
    if ((this.jdField_a_of_type_Axbf != null) && (this.jdField_a_of_type_Axbf.canDetectOrientation())) {
      this.jdField_a_of_type_Axbf.enable();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    axiy.i("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    axgk.a().acy("onSurfaceChanged-begin");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.jdField_a_of_type_Awwi != null) {
      this.jdField_a_of_type_Awwi.g(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, paramInt1, paramInt2);
    }
    if (this.smoothLevel != 0) {
      setBeautyLevel(this.smoothLevel);
    }
    axgk.a().acy("onSurfaceChanged-end");
    axiy.i("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    axiy.i("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    axgk.a().acy("onSurfaceCreated-begin");
    eGI();
    axgk.a().acy("onSurfaceCreated-end");
    axiy.i("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!aNU()) || (this.jdField_a_of_type_Awwk == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    awwg localawwg = (awwg)this.jdField_a_of_type_Awwi;
    if ((paramMotionEvent != null) && (localawwg.needMaskRecordTouchPoint()) && (!this.jdField_a_of_type_Awwk.aOd()))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = DeviceUtils.getScreenWidth(AEModule.getContext());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.mTouchStartPoint.x = f1;
        this.mTouchStartPoint.y = f2;
        queueEvent(new AECameraGLSurfaceView.17(this, localawwg, f1, f2, i));
        continue;
        if (getDist(this.mTouchStartPoint.x, this.mTouchStartPoint.y, f1, f2) > i * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.18(this, localawwg, f1, f2, i));
          continue;
          queueEvent(new AECameraGLSurfaceView.19(this, localawwg, f1, f2, i));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAECaptureController(awwk paramawwk)
  {
    this.jdField_a_of_type_Awwk = paramawwk;
  }
  
  public void setAEKitInitListener(b paramb)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$b = paramb;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (!aNU())
    {
      axiy.i("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.smoothLevel = paramInt;
    queueEvent(new AECameraGLSurfaceView.15(this, paramInt));
  }
  
  public void setCaptureListener(c paramc)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$c = paramc;
  }
  
  public void setCaptureRequest(d paramd)
  {
    if (this.jdField_a_of_type_Awwi != null) {
      this.jdField_a_of_type_Awwi.setCaptureRequest(paramd);
    }
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.cAE = paramBoolean;
    this.jdField_a_of_type_Awwa.setDynamicResolutionMode(paramBoolean);
  }
  
  public void setEventCallback(e parame)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e = parame;
  }
  
  public void setFaceEffectListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$a = parama;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if (!aNU()) {}
    awwg localawwg;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localawwg = (awwg)this.jdField_a_of_type_Awwi;
          } while (paramFilterCategoryItem != null);
          localObject = paramFilterCategoryItem.a();
        } while (localObject == null);
        paramFilterCategoryItem = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (!TextUtils.isEmpty(((FilterDesc)localObject).resRootPath)) {
          paramFilterCategoryItem = ((FilterDesc)localObject).resRootPath;
        }
        paramFilterCategoryItem = ((FilterDesc)localObject).getResFold(paramFilterCategoryItem);
        localObject = QQPtColorFilter.getColorFilterInfo(paramFilterCategoryItem);
      } while (localObject == null);
      paramFilterCategoryItem = paramFilterCategoryItem + ((QQPtColorFilterInfo)localObject).getColorPng();
    } while (!new File(paramFilterCategoryItem).exists());
    localawwg.updateLutGL(paramFilterCategoryItem);
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Axgm.Yh(paramBoolean);
    this.dtb = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.dsX = paramBoolean;
  }
  
  public void setMaterial(String paramString)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.12(this, new AECameraGLSurfaceView.11(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(axbu paramaxbu)
  {
    if ((paramaxbu == null) || (paramaxbu.equals(axbu.i)))
    {
      setMaterial(null);
      return;
    }
    Object localObject = getContext();
    if (((localObject instanceof Activity)) && (!isRecording()))
    {
      localObject = ((Activity)localObject).getIntent();
      ((Intent)localObject).putExtra("widgetinfo", "camera^" + paramaxbu.id);
      String str = paramaxbu.cTC;
      axiy.i("AECameraGLSurfaceView", "selectSpecificMaterial---塞拍同款名 takeSameName=" + str);
      ((Intent)localObject).putExtra("key_camera_material_name", str);
    }
    setMaterial(paramaxbu.getLocalPath());
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.dte = paramBoolean;
  }
  
  public void setRecommendTextCallback(axcm.a parama)
  {
    this.jdField_a_of_type_Axcm$a = parama;
  }
  
  public void setSceneListener(awxg.a parama)
  {
    this.jdField_a_of_type_Awxg$a = parama;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if (!aNU()) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.16(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.stickerInnerLutFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.jdField_a_of_type_Awwi != null) && ((this.jdField_a_of_type_Awwi instanceof awwg))) {
      ((awwg)this.jdField_a_of_type_Awwi).setStickerInnerLutFilterListener(paramStickerInnerEffectFilterListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new TapRunnable(paramInt, paramFloat1 / this.mSurfaceWidth, paramFloat2 / this.mSurfaceHeight));
  }
  
  public void setZoom(int paramInt)
  {
    this.jdField_a_of_type_Awwa.setZoom(paramInt);
  }
  
  class TapRunnable
    implements Runnable
  {
    int eDl;
    float x;
    float y;
    
    public TapRunnable(int paramInt, float paramFloat1, float paramFloat2)
    {
      this.eDl = paramInt;
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public void run()
    {
      ((awwg)AECameraGLSurfaceView.a(AECameraGLSurfaceView.this)).a().setTouchTriggerEvent(this.eDl, this.x, this.y);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(VideoMaterial paramVideoMaterial);
    
    public abstract void cQ(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static abstract interface b
  {
    public abstract void eGb();
  }
  
  public static abstract interface c
  {
    public abstract void a(CameraCaptureView.h paramh);
    
    public abstract void a(AEVideoCaptureResult paramAEVideoCaptureResult);
    
    public abstract void bSU();
    
    public abstract void bSV();
    
    public abstract void onCaptureError(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void w(Bitmap paramBitmap);
  }
  
  public static abstract interface e
  {
    public abstract void adl(int paramInt);
    
    public abstract void eGo();
    
    public abstract void eGp();
    
    public abstract void eGq();
    
    public abstract void g(SurfaceTexture paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */