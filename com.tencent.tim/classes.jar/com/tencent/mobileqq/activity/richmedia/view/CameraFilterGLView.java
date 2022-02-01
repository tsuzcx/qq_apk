package com.tencent.mobileqq.activity.richmedia.view;

import aaqh;
import aarz;
import aaso;
import aaso.b;
import aasx;
import aavc;
import aavg;
import aavi;
import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import anhx;
import anir;
import anjd;
import anjf;
import anjl;
import ankd;
import anke;
import anke.a;
import anke.b;
import ankm;
import ankm.a;
import anks;
import anks.a;
import anky;
import anky.a;
import anky.b;
import ankz;
import awtj;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.a;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraFilterGLView
  extends GLSurfaceView
  implements aaso.b, GLSurfaceView.Renderer
{
  private static final anke jdField_a_of_type_Anke = new anke();
  private static ankm jdField_a_of_type_Ankm;
  public anir a;
  public anjd a;
  private anks jdField_a_of_type_Anks = new anks();
  private anky.b jdField_a_of_type_Anky$b = new aavc(this);
  private a jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b = new b(null);
  private c jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c = new c(null);
  private d jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d = new d(null);
  private e jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e = new e(null);
  public f a;
  public FramePerformanceMonitor a;
  private PreviewContext b;
  private String bet;
  private boolean byp;
  private boolean bzI;
  private boolean bzJ;
  private boolean bzK;
  private boolean bzL;
  private boolean bzM;
  private boolean bzN;
  private volatile boolean bzO;
  private volatile boolean bzP;
  private boolean bzQ;
  private boolean bzR;
  private final Object ch = new Object();
  private int ckR;
  private int ckS;
  private RenderBuffer e;
  public AppInterface mAppInterface;
  public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference(null);
  private int mLastOrientation = 90;
  private Handler mUIHandler;
  private int mWindowHeight = 240;
  private int mWindowWidth = 240;
  private int orientation = 90;
  private TextureRender textureRender;
  
  static
  {
    awtj.init();
    VideoPrefsUtil.init(VideoEnvironment.getContext(), ShortVideoUtils.z());
    VideoPrefsUtil.setMaterialMute(false);
    GraphicRenderMgr.loadSo();
  }
  
  public CameraFilterGLView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraFilterGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Anjd = new anjd();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f = new f();
    this.jdField_a_of_type_Anir = new anir();
    init();
  }
  
  private void GB(int paramInt)
  {
    this.bzQ = false;
    this.e.bind();
    this.textureRender.drawTexture(3553, paramInt, null, null);
    this.e.unbind();
    anks.a locala = a(this.e.getTexId());
    if (locala != null)
    {
      aaso.cxR();
      this.jdField_a_of_type_Anks.aj(new CameraFilterGLView.3(this, locala));
      return;
    }
    aaso.Gt(1);
    QLog.e("PtvFilterUtils", 2, "Capture picture failed, cacheSuccess == null.");
  }
  
  @TargetApi(17)
  private boolean Xs()
  {
    boolean bool = false;
    Handler localHandler = t();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716523;
    jdField_a_of_type_Ankm.a.b(EGL14.eglGetCurrentContext());
    jdField_a_of_type_Ankm.a.b = this.jdField_a_of_type_Anjd.a();
    if (localHandler != null)
    {
      localHandler.sendMessage(localMessage);
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("CameraFilterGLView", 2, "setSurfaceCreated mHandler is null=");
    return false;
  }
  
  private anks.a a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  private anks.a a(int paramInt, AVIOStruct paramAVIOStruct)
  {
    anks.a locala = this.jdField_a_of_type_Anks.a();
    if (locala == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (locala.p(this.ckR, this.ckS, 4))
    {
      PtvFilterUtils.a(paramInt, this.ckR, this.ckS, 4, locala.w, paramAVIOStruct);
      return locala;
    }
    locala.dRn();
    return null;
  }
  
  private void a(anks.a parama, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, anir paramanir)
  {
    SharedMemWriteFile localSharedMemWriteFile = anke.a(parama);
    localSharedMemWriteFile.mVideoWidth = this.ckR;
    localSharedMemWriteFile.mVideoHeight = this.ckS;
    localSharedMemWriteFile.mDegree = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_b_of_type_Anks$a = parama;
    localSharedMemWriteFile.bAc = paramBoolean;
    localSharedMemWriteFile.bAd = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.bAb;
    localSharedMemWriteFile.jdField_b_of_type_Anks = this.jdField_a_of_type_Anks;
    localSharedMemWriteFile.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
    localSharedMemWriteFile.mOrientationDegree = paramInt2;
    localSharedMemWriteFile.mEncodeRef = this.mEncodeRef;
    localSharedMemWriteFile.jdField_a_of_type_Anir = paramanir;
    this.jdField_a_of_type_Anks.aj(localSharedMemWriteFile);
  }
  
  private void a(anky paramanky)
  {
    paramanky = (AVIOStruct)paramanky.a.eW;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[printSourceDataTimeStamp=" + paramanky.vFrameTime + "ms]");
    }
  }
  
  private String cW(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return acfp.m(2131703365);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return acfp.m(2131703371);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return acfp.m(2131703370);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return acfp.m(2131703364);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return acfp.m(2131703369);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return acfp.m(2131703367);
    }
    return null;
  }
  
  public static void cyM()
  {
    jdField_a_of_type_Ankm = null;
  }
  
  private void cyN()
  {
    this.bzL = false;
    this.bzK = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzX = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = false;
    this.jdField_a_of_type_Anjd.mDetectedFace = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzX = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.ckU = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
    this.jdField_a_of_type_Anjd.mDetectedGesture = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.clear();
    GestureFilterManager.sGestureType = "";
    GestureFilterManager.sGestureTips = "";
  }
  
  private void cyP()
  {
    if (jdField_a_of_type_Ankm != null) {
      jdField_a_of_type_Ankm.setVideoContext(this.b);
    }
  }
  
  private void cyQ()
  {
    int k = this.ckR;
    int j = this.ckS;
    int i = k / 2;
    j /= 2;
    while ((i > 100) && (j > 100))
    {
      int m = i / 2;
      j /= 2;
      k = i;
      i = m;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame tempWidth=" + k + "mDrawVideoWidth=" + this.ckR);
    }
  }
  
  @TargetApi(17)
  private void cyR()
  {
    this.jdField_a_of_type_Anjd.jB(this.ckR, this.ckS);
    jdField_a_of_type_Anke.a.a(EGL14.eglGetCurrentContext(), this.ckR, this.ckS);
    Message localMessage = Message.obtain();
    localMessage.what = 57379;
    jdField_a_of_type_Anke.sendMessage(localMessage);
    cyQ();
    this.jdField_a_of_type_Anjd.bS(this.ckR, this.ckS);
  }
  
  private void cyT()
  {
    if (this.bzI) {
      this.bzJ = true;
    }
    this.jdField_a_of_type_Anjd.dQB();
    super.requestRender();
  }
  
  private void cyW()
  {
    Handler localHandler = null;
    if (jdField_a_of_type_Ankm != null)
    {
      localHandler = jdField_a_of_type_Ankm.getMsgHandler();
      jdField_a_of_type_Ankm.a.dRf();
    }
    if (localHandler != null)
    {
      Message localMessage = Message.obtain(localHandler);
      localMessage.what = -16716522;
      localHandler.sendMessage(localMessage);
    }
  }
  
  private void cyX()
  {
    if (jdField_a_of_type_Ankm != null) {
      jdField_a_of_type_Ankm.releaseMsgThread();
    }
  }
  
  public static boolean hG(int paramInt)
  {
    return paramInt == 180;
  }
  
  private void init()
  {
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.bzN = false;
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a = null;
    this.mUIHandler = null;
    cyN();
    cyO();
    jdField_a_of_type_Anke.dQZ();
    aaso.a(this);
  }
  
  private Handler t()
  {
    Handler localHandler1 = null;
    if (jdField_a_of_type_Ankm != null) {
      localHandler1 = jdField_a_of_type_Ankm.getMsgHandler();
    }
    Handler localHandler2 = localHandler1;
    if (localHandler1 == null) {
      localHandler2 = this.b.mMsghandler;
    }
    return localHandler2;
  }
  
  public void Dg(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzX) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 0)) {
      return;
    }
    queueEvent(new CameraFilterGLView.4(this));
  }
  
  public boolean Xr()
  {
    return this.jdField_a_of_type_Anks.ayh();
  }
  
  public void cX(String paramString, int paramInt)
  {
    this.bet = paramString;
    this.bzQ = true;
    this.orientation = paramInt;
  }
  
  public void cyO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "createInputSurface inputSurface=" + jdField_a_of_type_Ankm + "  preViewContext=" + this.b);
    }
    if (jdField_a_of_type_Ankm == null)
    {
      jdField_a_of_type_Ankm = new ankm();
      jdField_a_of_type_Ankm.createMsgThread();
    }
  }
  
  public void cyS()
  {
    if ((jdField_a_of_type_Ankm != null) && (jdField_a_of_type_Ankm.a.b != null)) {
      jdField_a_of_type_Ankm.a.b.ayk();
    }
    if (jdField_a_of_type_Anke != null) {
      jdField_a_of_type_Anke.dRa();
    }
    if (this.jdField_a_of_type_Anks != null)
    {
      this.jdField_a_of_type_Anks.dRm();
      this.jdField_a_of_type_Anks.dRl();
    }
  }
  
  public void cyU()
  {
    if (this.jdField_a_of_type_Anjd != null) {
      this.jdField_a_of_type_Anjd.cAg = true;
    }
  }
  
  public void cyV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.cc);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.cc.getAndSet(true)) {
      cyW();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg2=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.cc);
    }
  }
  
  public void cyY()
  {
    cyX();
  }
  
  public void cyZ()
  {
    jdField_a_of_type_Anke.dRb();
  }
  
  @TargetApi(17)
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.bzJ) {
      if (this.jdField_a_of_type_Anjd != null) {
        if (jdField_a_of_type_Ankm.a.b == null) {
          break label1446;
        }
      }
    }
    label153:
    label1052:
    label1058:
    label1446:
    for (paramGL10 = jdField_a_of_type_Ankm.a.b.d();; paramGL10 = null)
    {
      if (paramGL10 != null) {
        paramGL10.dRq();
      }
      int i = 90;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.yU();
      }
      if ((i == 90) || (i != this.mLastOrientation)) {}
      this.mLastOrientation = i;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      label241:
      Object localObject2;
      if (paramGL10 != null)
      {
        a(paramGL10);
        long l1 = PtvFilterUtils.ha();
        localObject1 = anjf.a();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2)) {
          break label1052;
        }
        bool1 = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2)) {
          break label1058;
        }
        bool2 = true;
        ((anjf)localObject1).ct(bool1, bool2);
        anjf.a().dQD();
        if (this.textureRender == null) {
          break label1064;
        }
        i = this.jdField_a_of_type_Anjd.a(this.mWindowWidth, this.mWindowHeight, paramGL10.mTextureId, true, paramGL10.a.mFrontCamera, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, false);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.mWindowWidth, this.mWindowHeight);
        this.textureRender.drawTexture(3553, i, null, null);
        l1 = (PtvFilterUtils.ha() - l1) / 1000L;
        anjf.a().dQE();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[showPreview=" + l1 / 1000.0D + "ms]");
        }
        if ((!this.bzL) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.cxq();
          this.bzL = true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzX) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null) && (this.jdField_a_of_type_Anjd.mNeedDoFaceDetect))
        {
          if (!this.jdField_a_of_type_Anjd.mDetectedFace) {
            break label1100;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.aM(true, 0);
            this.bzM = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace 1 = true;");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = false;
            if (!this.jdField_a_of_type_Anjd.mDetectedGesture)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
            }
          }
        }
        label477:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzX) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null) && (this.jdField_a_of_type_Anjd.mNeedDoGestureDetect))
        {
          if (!this.jdField_a_of_type_Anjd.mDetectedGesture) {
            break label1221;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.aM(true, 1);
            this.bzM = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace2 = true;");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.ckU = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
          }
        }
        label625:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.Gj(this.jdField_a_of_type_Anjd.getFaceCount());
        }
        long l2 = SystemClock.elapsedRealtime();
        if (!paramGL10.a.bEX) {
          break label1391;
        }
        localObject1 = (AVIOStruct)paramGL10.a.eW;
        ((AVIOStruct)localObject1).vFrameTime = l2;
        aavg.GLLogMsg("handleMessage:requestRender  renderTime=" + l2);
        if (((AVIOStruct)localObject1).pFrameIndex == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.bAb = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.mOrientation = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f;
            f localf = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f;
            ((f)localObject2).mOrientation = f.fP(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.yU());
          }
          this.jdField_a_of_type_Anir.cza();
        }
        ((AVIOStruct)localObject1).pFrameIndex = this.jdField_a_of_type_Anir.JF();
        if (this.byp) {
          break label1365;
        }
        l2 = PtvFilterUtils.ha();
        if (!jdField_a_of_type_Anke.axE()) {
          break label1290;
        }
        localObject2 = new anke.a();
        ((anke.a)localObject2).mVideoWidth = this.ckR;
        ((anke.a)localObject2).mVideoHeight = this.ckS;
        ((anke.a)localObject2).mTextureId = i;
        ((anke.a)localObject2).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)localObject1);
        ((anke.a)localObject2).mOrientation = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.mOrientation;
        ((anke.a)localObject2).jdField_b_of_type_Anks = this.jdField_a_of_type_Anks;
        ((anke.a)localObject2).dIJ = 4;
        ((anke.a)localObject2).cHA = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.bAb;
        ((anke.a)localObject2).mEncodeRef = this.mEncodeRef;
        ((anke.a)localObject2).jdField_a_of_type_Anir = this.jdField_a_of_type_Anir;
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 57380;
        ((Message)localObject1).obj = localObject2;
        jdField_a_of_type_Anke.sendMessage((Message)localObject1);
        paramGL10.makeFree();
        label938:
        l2 = (PtvFilterUtils.ha() - l2) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[recordToFile=" + l2 / 1000.0D + "ms]");
        }
        anjl.lr(l2 + (0L + l1));
      }
      for (;;)
      {
        localObject1 = null;
        paramGL10 = (GL10)localObject1;
        if (jdField_a_of_type_Ankm != null)
        {
          paramGL10 = (GL10)localObject1;
          if (jdField_a_of_type_Ankm.a.b != null) {
            paramGL10 = jdField_a_of_type_Ankm.a.b.d();
          }
        }
        if (paramGL10 != null) {
          paramGL10.dRp();
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label153;
        label1064:
        i = this.jdField_a_of_type_Anjd.a(this.mWindowWidth, this.mWindowHeight, paramGL10.mTextureId, true, paramGL10.a.mFrontCamera, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, true);
        break label241;
        label1100:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b;
        ((b)localObject1).ckU += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU < 4) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2)) || (this.jdField_a_of_type_Anjd.mDetectedGesture)) {
          break label477;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.aM(false, 0);
        this.bzM = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
        break label477;
        label1221:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2)) || (this.bzM)) {
          break label625;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.aM(false, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
        break label625;
        localObject2 = a(i, (AVIOStruct)localObject1);
        paramGL10.makeFree();
        if (localObject2 == null) {
          break label938;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.mOrientation == 180)
        {
          a((anks.a)localObject2, 0, false, (AVIOStruct)localObject1, 0, this.jdField_a_of_type_Anir);
          break label938;
        }
        a((anks.a)localObject2, 180, true, (AVIOStruct)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.mOrientation, this.jdField_a_of_type_Anir);
        break label938;
        label1365:
        paramGL10.makeFree();
        RMVideoStateMgr.a().a(3553, i, null, null, SystemClock.elapsedRealtimeNanos(), this.jdField_a_of_type_Anir);
        continue;
        label1391:
        if ((this.bzQ) && (this.bet != null))
        {
          aarz.AK("capture");
          GB(i);
          aarz.AK("frame captured;");
        }
        paramGL10.makeFree();
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glFinish();
      return;
    }
  }
  
  public void onPause()
  {
    if (this.bzN)
    {
      super.onPause();
      this.bzN = false;
    }
    cyN();
    this.jdField_a_of_type_Anjd.dQA();
  }
  
  public void onResume()
  {
    super.onResume();
    cyP();
    this.bzN = true;
    aaso.a(this);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.mWindowWidth = paramInt1;
    this.mWindowHeight = paramInt2;
    if (this.jdField_a_of_type_Anjd != null) {
      this.jdField_a_of_type_Anjd.onSurfaceChanged(this.ckR, this.ckS);
    }
    if ((!this.bzK) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.cxp();
      this.bzK = true;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.bAa) && (this.jdField_a_of_type_Anjd != null))
    {
      Xs();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.bAa = true;
    }
    this.e = new RenderBuffer(this.ckR, this.ckS, 33984);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onSurfaceCreated");
    }
    setSurfaceCreated();
    try
    {
      this.textureRender = new TextureRender();
      return;
    }
    catch (Exception paramGL10)
    {
      QLog.e("face", 2, paramGL10, new Object[0]);
    }
  }
  
  public void setEnableBeauty(boolean paramBoolean)
  {
    this.jdField_a_of_type_Anjd.cHb = paramBoolean;
  }
  
  public void setFilterListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a = parama;
    if ((parama instanceof Handler.Callback)) {
      this.mUIHandler = new Handler((Handler.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a);
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 2, "setNeedWrite isRecord" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$f.bAb = paramBoolean;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, aasx arg3)
  {
    this.ckR = ???.cjG;
    this.ckS = ???.cjH;
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setPreviewSize preViewContext=" + this.b + "  mMsghandler" + this.b.mMsghandler);
    }
    Handler localHandler = t();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716524;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = ???;
    if (localHandler != null) {
      localHandler.sendMessage(localMessage);
    }
    synchronized (this.ch)
    {
      do
      {
        if (this.bzP) {
          super.queueEvent(new CameraFilterGLView.1(this));
        }
        this.bzO = true;
        return;
      } while (!QLog.isColorLevel());
      QLog.d("CameraFilterGLView", 2, "setPreviewSize mHandler is null=");
    }
  }
  
  @TargetApi(17)
  public void setSurfaceCreated()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.bAa = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.cc.getAndSet(false);
    this.bzI = true;
    this.byp = RMVideoStateMgr.a().hB(5);
    this.jdField_a_of_type_Anjd.clear();
    this.jdField_a_of_type_Anjd.initial();
    this.jdField_a_of_type_Anks.dQZ();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$d.bAa = Xs();
    this.jdField_a_of_type_Anjd.a().a(this.jdField_a_of_type_Anky$b);
    this.jdField_a_of_type_Anjd.onSurfaceCreate();
    synchronized (this.ch)
    {
      if (this.bzO) {
        cyR();
      }
      this.bzP = true;
      return;
    }
  }
  
  public void setSurfaceDestroyed()
  {
    jdField_a_of_type_Anke.a.a(null, -1, -1);
    Message localMessage = Message.obtain();
    localMessage.what = 57381;
    jdField_a_of_type_Anke.sendMessage(localMessage);
    this.bzI = false;
    this.jdField_a_of_type_Anks.dRb();
    cyV();
    cyN();
    this.bzJ = false;
    super.queueEvent(new CameraFilterGLView.6(this));
    PtvFilterUtils.dRi();
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.b = paramPreviewContext;
    if (this.b != null) {
      this.b.mPTVRealBeauty = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setVideoContext preViewContext=" + this.b);
    }
    cyP();
  }
  
  public void setVideoFilter(String paramString)
  {
    setVideoFilter(paramString, true, false);
  }
  
  public void setVideoFilter(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 0)
    {
      this.bzM = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.mPath = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.beu = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.bev = paramString3;
    GestureFilterManager.sGestureType = paramString2;
    GestureFilterManager.sGestureTips = paramString3;
    this.bzR = true;
    paramString2 = anhx.getModelPath() + GestureFilterManager.sGestureType + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "mCurrentCategory:=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV + ",mCurrentgestureType:=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.beu + ",mGestureWording=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.bev + ":path =" + paramString2 + ";frameTime is" + PtvTemplateManager.cdw);
    }
    setVideoFilter(paramString1, true, false);
    this.bzR = false;
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((!this.bzR) || (paramString == null)) && ((paramString == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.mPath))))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.aM(true, 1);
        this.bzM = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzY = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.ckU = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$b.bzZ = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzY = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$e.bzZ = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.clear();
      GestureFilterManager.sGestureType = "";
      GestureFilterManager.sGestureTips = "";
    }
    int i = PTFaceAttr.PTExpression.UNKNOW.value;
    long l = SystemClock.elapsedRealtime();
    ankd.getRuntimeRemainSize(1);
    Object localObject2 = new File(paramString, "paramsback" + ".json");
    boolean bool2 = ((File)localObject2).exists();
    boolean[] arrayOfBoolean = new boolean[1];
    Object localObject1;
    if ((paramString != null) && (!"".equals(paramString)))
    {
      VideoMemoryManager.getInstance().clear();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (aaqh.cix == 2)
        {
          paramBoolean2 = true;
          QLog.d("CameraFilterGLView", 2, paramBoolean2);
        }
      }
      else
      {
        if (aaqh.cix != 2) {
          break label406;
        }
        paramBoolean2 = true;
        label270:
        localObject1 = aavi.a(this.mAppInterface).a(paramString, arrayOfBoolean, paramBoolean2);
        if ((localObject1 == null) || ("".equals(localObject1))) {
          break label411;
        }
        label302:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 0) {
          break label465;
        }
        localObject1 = QQTemplateParser.parseVideoMaterial(paramString, (String)localObject1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraFilterGLView", 2, "current patternPath:" + paramString);
        }
        if ((localObject1 != null) && (paramString != null)) {
          break label523;
        }
        QLog.d("CameraFilterGLView", 2, "current tempMaterail = " + localObject1 + " patternPath=" + paramString);
        return;
        paramBoolean2 = false;
        break;
        label406:
        paramBoolean2 = false;
        break label270;
        label411:
        if (!paramBoolean2) {
          break label1163;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraFilterGLView", 2, "parseVideoMaterial file : " + ((File)localObject2).getAbsolutePath());
        }
        if (!bool2) {
          break label1163;
        }
        localObject1 = "paramsback";
        break label302;
        label465:
        localObject2 = QQTemplateParser.parseVideoMaterial(paramString, (String)localObject1);
        ((VideoMaterial)localObject2).mHasGestureFilter = true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 1) {
          ((VideoMaterial)localObject2).isNeedDecodeFaceFilter = false;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraFilterGLView", 2, "gesture material parse here +");
          localObject1 = localObject2;
        }
      }
      label523:
      ((VideoMaterial)localObject1).setDataPath(paramString);
      if (((VideoMaterial)localObject1).getShaderType() == VideoMaterialUtil.SHADER_TYPE.SHADER_TYPE_2D_NON_FIT.value)
      {
        paramString = new ArrayList();
        localObject2 = ((VideoMaterial)localObject1).getItemList();
        List localList = ((VideoMaterial)localObject1).getNonFitItemList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          paramString.addAll((Collection)localObject2);
        }
        if ((localList != null) && (localList.size() > 0)) {
          paramString.addAll(localList);
        }
        localObject2 = new AESticker((VideoMaterial)localObject1, this.jdField_a_of_type_Anjd.getFaceDetector());
        if (VideoMaterialUtil.isActionTriggerType(i)) {
          break label1153;
        }
        i = ((VideoMaterial)localObject1).getTriggerType();
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null) && (paramString != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 0) {
          break label912;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
        bool1 = paramString.mEnableFaceDetect;
        if (this.jdField_a_of_type_Anjd != null) {
          break label896;
        }
        paramBoolean2 = false;
        label751:
        ((a)localObject2).j(bool1, paramBoolean2, 0);
        if (this.jdField_a_of_type_Anjd != null)
        {
          if (this.jdField_a_of_type_Anjd.mDetectedFace) {
            break label907;
          }
          paramBoolean2 = true;
          label781:
          this.bzM = paramBoolean2;
        }
      }
      label786:
      int j = arrayOfBoolean[0];
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 2))
      {
        paramBoolean2 = true;
        label816:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2)) {
          break label1147;
        }
      }
      label896:
      label907:
      label912:
      label1088:
      label1137:
      label1147:
      for (boolean bool1 = true;; bool1 = false)
      {
        super.queueEvent(new CameraFilterGLView.5(this, (AESticker)localObject1, paramBoolean1, bool2, bool1, paramString, paramBoolean2, i, j));
        return;
        if (((VideoMaterial)localObject1).mHasGestureFilter)
        {
          VideoMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
          break;
        }
        VideoMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
        break;
        paramBoolean2 = this.jdField_a_of_type_Anjd.mDetectedFace;
        break label751;
        paramBoolean2 = false;
        break label781;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV == 1)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
          if (this.jdField_a_of_type_Anjd == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_Anjd.mDetectedGesture)
          {
            ((a)localObject2).j(true, paramBoolean2, 1);
            this.bzM = false;
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$c.ckV != 2) {
          break label786;
        }
        if ((this.jdField_a_of_type_Anjd != null) && (this.jdField_a_of_type_Anjd.mDetectedGesture == true))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
          if (this.jdField_a_of_type_Anjd == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_Anjd.mDetectedGesture)
          {
            ((a)localObject2).j(true, paramBoolean2, 1);
            break;
          }
        }
        if ((this.jdField_a_of_type_Anjd != null) && (this.jdField_a_of_type_Anjd.mDetectedFace))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a.j(true, false, 1);
          break label786;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a;
        bool1 = paramString.mEnableFaceDetect;
        if (this.jdField_a_of_type_Anjd == null)
        {
          paramBoolean2 = false;
          ((a)localObject2).j(bool1, paramBoolean2, 0);
          if (this.jdField_a_of_type_Anjd == null) {
            break label786;
          }
          if (this.jdField_a_of_type_Anjd.mDetectedFace) {
            break label1137;
          }
        }
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          this.bzM = paramBoolean2;
          break;
          paramBoolean2 = this.jdField_a_of_type_Anjd.mDetectedFace;
          break label1088;
        }
        paramBoolean2 = false;
        break label816;
      }
      label1153:
      paramString = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label1163:
      localObject1 = "params";
      break;
      paramString = null;
      localObject1 = null;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "surfaceDestroyed");
    }
    setSurfaceDestroyed();
    anjl.aBh();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
  
  public static class SharedMemWriteFile
    implements Runnable
  {
    public anir a;
    public AVIOStruct a;
    public anks.a b;
    public anks b;
    public CameraFilterGLView.a b;
    public boolean bAc;
    public boolean bAd;
    public int mDegree;
    public AtomicReference<SVHwEncoder> mEncodeRef;
    public int mOrientationDegree;
    public int mVideoHeight;
    public int mVideoWidth;
    
    public void run()
    {
      SystemClock.uptimeMillis();
      QLog.d("PtvFilterUtils", 4, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]frameIndex=" + this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
      int i = PtvFilterUtils.a(this.mVideoWidth, this.mVideoHeight, 4, true, false, this.mDegree, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_b_of_type_Anks$a.dJi, this.bAc, this.mOrientationDegree);
      SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.mEncodeRef.get();
      if (localSVHwEncoder != null)
      {
        SVHwEncoder.a locala = localSVHwEncoder.b();
        if (locala == null) {
          break label235;
        }
        locala.offset = 0;
        locala.finish = false;
        locala.isVideo = true;
        locala.size = locala.data.length;
        locala.time = this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime;
        if (PtvFilterUtils.v(locala.data) == 0) {
          localSVHwEncoder.a(locala, true);
        }
      }
      if (i == 0) {
        i = PtvFilterUtils.a(this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct);
      }
      for (;;)
      {
        if ((i != 0) && (QLog.isColorLevel())) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]err=" + i);
        }
        this.jdField_b_of_type_Anks$a.dRn();
        this.jdField_a_of_type_Anir.JG();
        if ((!this.bAd) && (this.jdField_b_of_type_Anks.ayh()) && (this.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a != null)) {}
        return;
        label235:
        this.mEncodeRef.set(null);
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gj(int paramInt);
    
    public abstract void aM(boolean paramBoolean, int paramInt);
    
    public abstract void cxp();
    
    public abstract void cxq();
    
    public abstract void j(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
    
    public abstract void n(boolean paramBoolean, String paramString, int paramInt);
    
    public abstract int yU();
  }
  
  static class b
  {
    public boolean bzX;
    public boolean bzY;
    public boolean bzZ;
    public int ckU;
  }
  
  static class c
  {
    public String beu = "";
    public String bev = "";
    public int ckV;
    public String mPath = "";
    
    public void clear()
    {
      this.ckV = 0;
      this.beu = "";
      this.bev = "";
      this.mPath = "";
    }
  }
  
  class d
  {
    public boolean bAa;
    public AtomicBoolean cc = new AtomicBoolean(false);
    
    private d() {}
  }
  
  static class e
  {
    public boolean bzX;
    public boolean bzY;
    public boolean bzZ;
    public int ckU;
  }
  
  public static class f
  {
    public boolean bAb;
    public int mOrientation;
    
    public static int fP(int paramInt)
    {
      switch (paramInt)
      {
      case 90: 
      default: 
        return 0;
      case 0: 
        return 270;
      case 180: 
        return 90;
      }
      return 180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView
 * JD-Core Version:    0.7.0.1
 */