import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.a;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreateContextException;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLMakeCurrentException;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class ankm
  implements Handler.Callback
{
  private static boolean cHB = anii.isFoundProductByRomID(anii.KEY_BLACK_OPENGL_ES20_NEED_FLUSH);
  private boolean Fn;
  public ankm.a a;
  private ankm.b jdField_a_of_type_Ankm$b = new ankm.b(null);
  ankp jdField_a_of_type_Ankp;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  OffScreenInputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  private AtomicInteger aO = new AtomicInteger(0);
  private AtomicInteger aP = new AtomicInteger(0);
  GLVideoClipUtil b;
  private boolean bAe;
  private boolean bAf;
  private boolean bAg;
  private volatile boolean bAh;
  private boolean cHC = true;
  private int ckW = 270;
  private boolean hasInitContext;
  private boolean hasInitSize;
  private HandlerThread mGlThreadMsg;
  private Handler mHandler;
  private int mHeight;
  private int mPreviewHeight;
  private int mPreviewWidth;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private int mWidth;
  
  public ankm()
  {
    this.jdField_a_of_type_Ankm$a = new ankm.a();
    cza();
    this.mGlThreadMsg = null;
    this.mHandler = null;
    this.b = new GLVideoClipUtil();
  }
  
  private void Qe(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.czk();
    }
    this.b.arF = 0;
    this.bAf = false;
  }
  
  private anky a()
  {
    anky localanky = this.jdField_a_of_type_Ankm$a.b.c();
    if (localanky != null) {
      return localanky;
    }
    localanky = this.jdField_a_of_type_Ankm$a.b.b();
    if (localanky != null)
    {
      this.jdField_a_of_type_Ankp.initSharedTextureMemory(localanky.mTextureId, this.mWidth, this.mHeight);
      return localanky;
    }
    return null;
  }
  
  private void a(AVIOStruct paramAVIOStruct)
  {
    this.jdField_a_of_type_Ankm$b.dJg = paramAVIOStruct.pFrameIndex;
    paramAVIOStruct.pFrameIndex = 0;
    this.jdField_a_of_type_Ankm$b.cHD = false;
    this.jdField_a_of_type_Ankm$b.dJh = 0;
    aavg.GLLogMsg("handleMessage:writeVideoFrame[false]  mThumbPicControl.mSendThumbOKIndex=" + this.jdField_a_of_type_Ankm$b.dJg);
  }
  
  private boolean axU()
  {
    boolean bool2 = true;
    bool1 = false;
    synchronized (ankm.a.a(this.jdField_a_of_type_Ankm$a))
    {
      Object localObject2 = ankm.a.a(this.jdField_a_of_type_Ankm$a);
      if (localObject2 == null) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.axW()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.a((EGLContext)localObject2))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]1 glContextH=" + OffScreenInputSurface.a((EGLContext)localObject2));
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.axW()) && (QLog.isColorLevel())) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]2 mSharedDataContextH=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.JR());
        }
        dRe();
      }
      OffScreenInputSurface localOffScreenInputSurface = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localOffScreenInputSurface == null) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.mWidth, this.mHeight, (EGLContext)localObject2);
        bool1 = bool2;
      }
      catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLCreateContextException]exp=", localEGLCreateContextException);
          }
          anjk.UZ(1);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
          bool1 = false;
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localObject2 != null)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.makeCurrent();
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.axV()) {
            break label300;
          }
          throw new RuntimeException("checkEGL failed");
        }
        catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLMakeCurrentException]exp=", localEGLMakeCurrentException);
          }
          anjk.UZ(2);
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.release();
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
        }
        return bool1;
      }
    }
  }
  
  private void cza()
  {
    this.bAe = true;
    this.bAf = false;
    this.bAh = false;
    this.hasInitSize = false;
    this.hasInitContext = false;
  }
  
  private void czc()
  {
    this.aP.set(1);
    this.bAg = this.b.aK(this.bAg);
    int i = GLES20.glGetError();
    if (i != 0) {
      aavg.GLLogMsg("glDrawFrame:err=" + i);
    }
    this.aP.set(0);
  }
  
  private void dRe()
  {
    if (this.jdField_a_of_type_Ankp != null) {
      this.jdField_a_of_type_Ankp.release();
    }
    this.jdField_a_of_type_Ankp = null;
    surfaceDestroyed();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public void Qd(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Ankp = new ankp();
        this.jdField_a_of_type_Ankp.l(false, false);
        dRd();
      }
      anjm.dQL();
      return;
    }
    this.jdField_a_of_type_Ankp = null;
  }
  
  public void createMsgThread()
  {
    if (this.mGlThreadMsg == null)
    {
      this.mGlThreadMsg = new HandlerThread("glProcess");
      this.mGlThreadMsg.start();
      this.mHandler = new Handler(this.mGlThreadMsg.getLooper(), this);
      this.aP.set(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.mHandler;
    }
  }
  
  public void dRd()
  {
    if (!this.b.Xw()) {
      this.bAe = false;
    }
    this.bAf = true;
    this.bAg = false;
  }
  
  public void drawFrame()
  {
    GLES20.glClear(16384);
    if ((this.bAh) && (this.bAe) && (this.bAf)) {
      czc();
    }
  }
  
  public Handler getMsgHandler()
  {
    if ((this.mGlThreadMsg != null) && (this.mHandler != null)) {
      return this.mHandler;
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = null;
    boolean bool2 = false;
    if (paramMessage.what == -16716524)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "handleMessage SETPREVIEW=" + paramMessage.arg1 + "*" + paramMessage.arg2);
      }
      setPreviewSize(paramMessage.arg1, paramMessage.arg2, (aasx)paramMessage.obj);
      this.hasInitSize = true;
      if (this.hasInitContext) {
        Qd(axU());
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (paramMessage.what != -16716523) {
            break;
          }
          this.hasInitContext = true;
          if (this.hasInitSize) {
            Qd(axU());
          }
        } while (!QLog.isColorLevel());
        QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT]");
        return true;
        if (paramMessage.what != -16716522) {
          break;
        }
        cza();
        this.jdField_a_of_type_Ankm$a.dRf();
        this.jdField_a_of_type_Ankm$a.b = null;
        this.jdField_a_of_type_Ankm$b.dJh = 0;
        this.jdField_a_of_type_Ankm$b.cHD = false;
        this.jdField_a_of_type_Ankm$b.dJg = -1;
        dRe();
      } while (!QLog.isColorLevel());
      QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_FINISH]");
      return true;
    } while (paramMessage.what != -16716526);
    if (QLog.isColorLevel()) {
      QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]");
    }
    int i = this.aO.get();
    if (i != 0)
    {
      aavg.GLLogMsg("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i);
      return true;
    }
    if (this.jdField_a_of_type_Ankp != null) {
      anjm.ls(PtvFilterUtils.ha() / 1000L);
    }
    boolean bool1;
    if (paramMessage.obj != null)
    {
      if (paramMessage.arg1 == 0) {
        localObject = (byte[])paramMessage.obj;
      }
      for (;;)
      {
        l1 = PtvFilterUtils.ha();
        this.b.ar((byte[])localObject);
        l1 = (PtvFilterUtils.ha() - l1) / 1000L;
        aavg.GLLogMsg("handleMessage:[copyDataToByteBuffer] steptime=" + l1 + " us");
        anjm.lv(l1);
        if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle((byte[])localObject);
        }
        if (this.jdField_a_of_type_Ankp == null) {
          break label1143;
        }
        if (this.jdField_a_of_type_Ankm$a.b != null) {
          break;
        }
        aavg.GLLogMsg("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i);
        return true;
        if (paramMessage.arg1 == 1) {
          localObject = ((PreviewContext.a)paramMessage.obj).data;
        }
      }
      long l1 = PtvFilterUtils.ha();
      anky localanky = a();
      if (localanky != null)
      {
        this.jdField_a_of_type_Ankp.bindTexture(localanky.mTextureId);
        aavg.GLLogMsg("handleMessage:[CAMERA_OPENGL_RANDER_DATA] bindTextureId=" + localanky.mTextureId);
        aavg.GLLogMsg("handleMessage:[CAMERA_OPENGL_RANDER_DATA] Begin drawFrame mWidth=" + this.mWidth + " mHeight=" + this.mHeight);
        drawFrame();
        aavg.GLLogMsg("handleMessage:[CAMERA_OPENGL_RANDER_DATA] End drawFrame");
        if (!cHB) {}
        AVIOStruct localAVIOStruct;
        for (bool1 = true;; bool1 = false)
        {
          PtvFilterUtils.Qf(bool1);
          aavg.GLLogMsg("handleMessage:[CAMERA_OPENGL_RANDER_DATA] glSyncCommand OK: sNeedSyncUseFlush=" + cHB);
          if (paramMessage.arg1 != 1) {
            break label1126;
          }
          localAVIOStruct = ((PreviewContext.a)paramMessage.obj).b;
          if (localAVIOStruct != null) {
            break;
          }
          throw new RuntimeException("OffScreenGLSurface:msg.arg1=" + paramMessage.arg1 + " frame=null");
        }
        localObject = localAVIOStruct;
        if (localAVIOStruct.pFrameIndex == 0)
        {
          this.jdField_a_of_type_Ankm$b.cHD = true;
          localObject = localAVIOStruct;
        }
        label713:
        long l2 = SystemClock.elapsedRealtime();
        ((AVIOStruct)localObject).vFrameTime = l2;
        i = paramMessage.arg1;
        if (this.cHC) {
          break label1138;
        }
        bool1 = true;
        label739:
        localanky.a(i, localObject, bool1);
        localanky.makeDataReady();
        bool1 = this.jdField_a_of_type_Ankm$a.b.ayi();
        aavg.GLLogMsg("handleMessage:writeVideoFrame  mNewSession=" + this.jdField_a_of_type_Ankm$b.cHD + "  Make data ready: frameIndex= " + ((AVIOStruct)localObject).pFrameIndex + "  hasRenaderFrame=" + bool1);
        if (!bool1)
        {
          if (this.jdField_a_of_type_Ankm$b.cHD) {
            a((AVIOStruct)localObject);
          }
          localanky.dRp();
        }
        aavg.GLLogMsg("handleMessage:writeVideoFrame frameBufferTime=" + l2 + "  sNeedSyncUseFlush=" + cHB);
      }
      l1 = (PtvFilterUtils.ha() - l1) / 1000L;
      anjm.lu(l1);
      paramMessage = new StringBuilder().append("handleMessage:writeVideoFrame[Draw] steptime=").append(l1).append("  currentPipe=");
      bool1 = bool2;
      if (localanky != null) {
        bool1 = true;
      }
      aavg.GLLogMsg(bool1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
        QLog.d("OffScreenGLSurface", 2, "[CAMERA_OPENGL_RANDER_DATA]videoContext.notifyFirstFrame=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (QLog.isColorLevel()))
      {
        if ((this.Fn) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
          QLog.d("OffScreenGLSurface", 2, "this log is for qzonetest : the camera create successful!");
        }
        this.Fn = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
        this.mUIHandler.post(new OffScreenGLSurface.1(this));
      }
      if (this.jdField_a_of_type_Ankp == null) {
        break;
      }
      anjm.lt(PtvFilterUtils.ha() / 1000L);
      anjm.aBh();
      return true;
      label1126:
      localObject = new AVIOStruct();
      break label713;
      label1138:
      bool1 = false;
      break label739;
      label1143:
      aavg.GLLogMsg("handleMessage:byteBufferProcessFrame  framebuffer=null");
    }
  }
  
  public void releaseMsgThread()
  {
    if (this.mGlThreadMsg != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
      }
      this.mHandler.removeCallbacksAndMessages(null);
      PtvFilterUtils.a(this.mGlThreadMsg);
      this.mGlThreadMsg = null;
      this.mHandler = null;
    }
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, aasx paramaasx)
  {
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.mWidth = paramaasx.cjG;
    this.mHeight = paramaasx.cjH;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_OUTPUT_WIDTH = this.mWidth;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_OUTPUT_HEIGHT = this.mHeight;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_IMAGE_WIDTH = this.mWidth;
    com.tencent.ttpic.openapi.config.MediaConfig.VIDEO_IMAGE_HEIGHT = this.mHeight;
    this.ckW = anij.a().JE();
    if (this.ckW == 270) {}
    for (this.cHC = false;; this.cHC = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "setPreviewSize: backCamera=" + this.cHC + " mVideoClipDegree=" + this.ckW);
      }
      this.b.f(this.mPreviewWidth, this.mPreviewHeight, this.mWidth, this.mHeight, this.cHC);
      this.bAh = true;
      return;
    }
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
      if (this.mHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.mHandler;
      }
    }
  }
  
  public void surfaceDestroyed()
  {
    Qe(false);
  }
  
  public static class a
  {
    public ankz b;
    private Object eT = new Object();
    private EGLContext mSharedContext;
    
    public void b(EGLContext paramEGLContext)
    {
      synchronized (this.eT)
      {
        this.mSharedContext = paramEGLContext;
        return;
      }
    }
    
    public void dRf()
    {
      synchronized (this.eT)
      {
        this.mSharedContext = null;
        return;
      }
    }
  }
  
  static class b
  {
    public boolean cHD;
    public int dJg = -1;
    public int dJh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankm
 * JD-Core Version:    0.7.0.1
 */