import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.a;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreateContextException;
import dov.com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLMakeCurrentException;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class azbv
  implements Handler.Callback
{
  private static boolean cHB = anii.isFoundProductByRomID(anii.KEY_BLACK_OPENGL_ES20_NEED_FLUSH);
  private boolean Fn;
  public azbv.a a;
  private azbv.b jdField_a_of_type_Azbv$b;
  azbw jdField_a_of_type_Azbw;
  private PreviewContext jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext;
  OffScreenInputSurface jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  private AtomicInteger aO;
  private AtomicInteger aP;
  GLVideoClipUtil b;
  private boolean bAe;
  private boolean bAf;
  private boolean bAg;
  private volatile boolean bAh;
  private boolean cHC;
  private int ckW;
  private boolean hasInitContext;
  private boolean hasInitSize;
  private int mHeight;
  private int mPreviewHeight;
  private int mPreviewWidth;
  private Handler mUIHandler;
  private int mWidth;
  
  private void Qe(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.czk();
    }
    this.b.arF = 0;
    this.bAf = false;
  }
  
  private azca a()
  {
    azca localazca = this.jdField_a_of_type_Azbv$a.a.c();
    if (localazca != null) {
      return localazca;
    }
    localazca = this.jdField_a_of_type_Azbv$a.a.b();
    if (localazca != null)
    {
      this.jdField_a_of_type_Azbw.initSharedTextureMemory(localazca.mTextureId, this.mWidth, this.mHeight);
      return localazca;
    }
    return null;
  }
  
  private void a(AVIOStruct paramAVIOStruct)
  {
    this.jdField_a_of_type_Azbv$b.dJg = paramAVIOStruct.pFrameIndex;
    paramAVIOStruct.pFrameIndex = 0;
    this.jdField_a_of_type_Azbv$b.cHD = false;
    this.jdField_a_of_type_Azbv$b.dJh = 0;
    ayvy.GLLogMsg("handleMessage:writeVideoFrame[false]  mThumbPicControl.mSendThumbOKIndex=" + this.jdField_a_of_type_Azbv$b.dJg);
  }
  
  private boolean axU()
  {
    boolean bool2 = true;
    bool1 = false;
    synchronized (azbv.a.a(this.jdField_a_of_type_Azbv$a))
    {
      Object localObject2 = azbv.a.a(this.jdField_a_of_type_Azbv$a);
      if (localObject2 == null) {
        return false;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) && ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.axW()) || (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.a((EGLContext)localObject2))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]1 glContextH=" + OffScreenInputSurface.a((EGLContext)localObject2));
        }
        if ((!this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.axW()) && (QLog.isColorLevel())) {
          QLog.d("OffScreenGLSurface", 2, "initInputSurface[releasePBufferAndFrameBuffer]2 mSharedDataContextH=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.JR());
        }
        dRe();
      }
      OffScreenInputSurface localOffScreenInputSurface = this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localOffScreenInputSurface == null) {}
      try
      {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.mWidth, this.mHeight, (EGLContext)localObject2);
        bool1 = bool2;
      }
      catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLCreateContextException]exp=", localEGLCreateContextException);
          }
          azbl.UZ(1);
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
          bool1 = false;
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface;
      if (localObject2 != null)
      {
        try
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.makeCurrent();
          if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.axV()) {
            break label299;
          }
          throw new RuntimeException("checkEGL failed");
        }
        catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "createInputSurface[EGLMakeCurrentException]exp=", localEGLMakeCurrentException);
          }
          azbl.UZ(2);
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.release();
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
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
      ayvy.GLLogMsg("glDrawFrame:glError=" + i);
    }
    this.aP.set(0);
  }
  
  private void dRe()
  {
    if (this.jdField_a_of_type_Azbw != null) {
      this.jdField_a_of_type_Azbw.release();
    }
    this.jdField_a_of_type_Azbw = null;
    surfaceDestroyed();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface.release();
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public void Qd(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Azbw = new azbw();
        this.jdField_a_of_type_Azbw.l(false, false);
        dRd();
      }
      azbn.dQL();
      return;
    }
    this.jdField_a_of_type_Azbw = null;
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
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    if (paramMessage.what == -16716524)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OffScreenGLSurface", 2, "handleMessage SETPREVIEW=" + paramMessage.arg1 + "*" + paramMessage.arg2 + " " + this.hasInitSize);
      }
      setPreviewSize(paramMessage.arg1, paramMessage.arg2, (ayvd)paramMessage.obj);
      this.hasInitSize = true;
      if (this.hasInitContext)
      {
        Qd(axU());
        aytu.AK("SETPREVIEW OffScreenGLSurface");
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
          if (QLog.isColorLevel()) {
            QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT] before " + this.hasInitSize);
          }
          if (this.hasInitSize) {
            Qd(axU());
          }
        } while (!QLog.isColorLevel());
        QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_INIT]");
        aytu.AK("RANDER_DATA_INIT OffScreenGLSurface");
        return true;
        if (paramMessage.what != -16716522) {
          break;
        }
        cza();
        this.jdField_a_of_type_Azbv$a.dRf();
        this.jdField_a_of_type_Azbv$a.a = null;
        this.jdField_a_of_type_Azbv$b.dJh = 0;
        this.jdField_a_of_type_Azbv$b.cHD = false;
        this.jdField_a_of_type_Azbv$b.dJg = -1;
        dRe();
      } while (!QLog.isColorLevel());
      QLog.d("OffScreenGLSurface", 2, "[FILE_CACHE_OPENGL_RANDER_DATA_FINISH]");
      return true;
    } while (paramMessage.what != -16716526);
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("CAMERA_OPENGL_RANDER_DATA");; localStringBuilder = null)
    {
      int i = this.aO.get();
      if (i != 0)
      {
        ayvy.GLLogMsg("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i);
        return true;
      }
      if (this.jdField_a_of_type_Azbw != null) {
        azbn.ls(PtvFilterUtils.ha() / 1000L);
      }
      Object localObject;
      if (paramMessage.obj != null) {
        if (paramMessage.arg1 == 0) {
          localObject = (byte[])paramMessage.obj;
        }
      }
      for (;;)
      {
        long l = PtvFilterUtils.ha();
        this.b.ar((byte[])localObject);
        azbn.lv((PtvFilterUtils.ha() - l) / 1000L);
        if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle((byte[])localObject);
        }
        if (this.jdField_a_of_type_Azbw != null)
        {
          if (this.jdField_a_of_type_Azbv$a.a == null)
          {
            ayvy.GLLogMsg("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + i);
            return true;
            if (paramMessage.arg1 != 1) {
              break label1133;
            }
            localObject = ((PreviewContext.a)paramMessage.obj).data;
            continue;
          }
          l = PtvFilterUtils.ha();
          azca localazca = a();
          if (localazca != null)
          {
            this.jdField_a_of_type_Azbw.bindTexture(localazca.mTextureId);
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("bind t=").append(localazca.mTextureId).append("|");
              localStringBuilder.append("begin w=").append(this.mWidth).append("|");
              localStringBuilder.append("h=").append(this.mHeight).append("|");
            }
            drawFrame();
            if (!cHB) {}
            AVIOStruct localAVIOStruct;
            for (boolean bool1 = true;; bool1 = false)
            {
              PtvFilterUtils.Qf(bool1);
              if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
                localStringBuilder.append("end draw s=").append(cHB).append("|");
              }
              if (paramMessage.arg1 != 1) {
                break label1103;
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
              this.jdField_a_of_type_Azbv$b.cHD = true;
              localObject = localAVIOStruct;
            }
            label752:
            ((AVIOStruct)localObject).vFrameTime = SystemClock.elapsedRealtime();
            i = paramMessage.arg1;
            bool1 = bool2;
            if (!this.cHC) {
              bool1 = true;
            }
            localazca.a(i, localObject, bool1);
            localazca.makeDataReady();
            bool1 = this.jdField_a_of_type_Azbv$a.a.ayi();
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("write ns=").append(this.jdField_a_of_type_Azbv$b.cHD).append("|");
              localStringBuilder.append("fi=").append(((AVIOStruct)localObject).pFrameIndex).append("|");
              localStringBuilder.append("hrf=").append(bool1).append("|");
            }
            if (!bool1)
            {
              if (this.jdField_a_of_type_Azbv$b.cHD) {
                a((AVIOStruct)localObject);
              }
              localazca.dRp();
            }
            label905:
            azbn.lu((PtvFilterUtils.ha() - l) / 1000L);
          }
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (QLog.isColorLevel()))
          {
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append("context=").append(this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext).append("|");
              localStringBuilder.append("notify=").append(this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame).append("|");
            }
            if ((this.Fn) && (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
              QLog.d("OffScreenGLSurface", 2, "this log is for qzonetest : the camera create successful!");
            }
            this.Fn = this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame;
          }
          if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
            this.mUIHandler.post(new OffScreenGLSurface.1(this));
          }
          if (this.jdField_a_of_type_Azbw != null)
          {
            azbn.lt(PtvFilterUtils.ha() / 1000L);
            azbn.aBh();
          }
          if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
            break;
          }
          QLog.d("OffScreenGLSurface", 2, localStringBuilder.toString());
          return true;
          label1103:
          localObject = new AVIOStruct();
          break label752;
          ayvy.GLLogMsg("handleMessage:byteBufferProcessFrame: no texture");
          break label905;
          ayvy.GLLogMsg("handleMessage:byteBufferProcessFrame  framebuffer=null");
        }
        label1133:
        localObject = null;
      }
    }
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, ayvd paramayvd)
  {
    this.mPreviewWidth = paramInt1;
    this.mPreviewHeight = paramInt2;
    this.mWidth = paramayvd.cjG;
    this.mHeight = paramayvd.cjH;
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
  
  public void surfaceDestroyed()
  {
    Qe(false);
    aytu.AK("destroy OffScreenGLSurface");
  }
  
  public static class a
  {
    public azcb a;
    private Object eT;
    private EGLContext mSharedContext;
    
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
    public int dJg;
    public int dJh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbv
 * JD-Core Version:    0.7.0.1
 */