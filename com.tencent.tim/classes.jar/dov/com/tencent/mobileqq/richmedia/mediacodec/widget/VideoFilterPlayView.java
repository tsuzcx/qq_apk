package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import alwy;
import alzu;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import ankq;
import ankt;
import awte;
import ayyl;
import ayyq;
import ayyw;
import ayyy;
import ayyz;
import ayza;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import rpv;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int bmZ;
  private ayyw jdField_a_of_type_Ayyw;
  ayyy jdField_a_of_type_Ayyy;
  private ayyz jdField_a_of_type_Ayyz;
  private ayza jdField_a_of_type_Ayza;
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  PKFilter jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter;
  private a jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$a;
  private boolean cBE;
  String cYm;
  String cYn;
  String cYo;
  private GPUBaseFilter d;
  private boolean dCh;
  private boolean dCi = true;
  private boolean dCj;
  protected boolean dzp;
  protected boolean dzq;
  public boolean dzr;
  private boolean dzu;
  private GPUBaseFilter e;
  private GPUBaseFilter f;
  private QQFilterRenderManager h;
  private byte[] ib;
  private RenderBuffer mRenderFBO;
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  public int mSeq;
  private RenderBuffer o;
  private ByteBuffer y;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initFilter();
    int i = bmZ + 1;
    bmZ = i;
    this.mSeq = i;
  }
  
  private void c(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  private void initFilter()
  {
    this.h = awte.c();
    awte.a(this.h);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong, int paramInt) {}
  
  public void a(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramRenderBuffer != null) {
      i = paramRenderBuffer.getTexId();
    }
    if ((this.ib == null) || (this.y == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer trackData is null ");
      }
      return;
    }
    this.y.rewind();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        paramRenderBuffer = new int[1];
        GLES20.glGenFramebuffers(1, paramRenderBuffer, 0);
        GLES20.glBindFramebuffer(36160, paramRenderBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.y);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, paramRenderBuffer, 0);
        paramRenderBuffer[0] = 0;
        this.dCj = false;
        return;
      }
      catch (Exception paramRenderBuffer)
      {
        this.y.clear();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer error " + paramRenderBuffer.toString());
      return;
      GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.y);
    }
  }
  
  public void afQ(int paramInt)
  {
    this.jdField_a_of_type_Ayyz = new ayyz(paramInt);
  }
  
  public void eUw() {}
  
  public void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  protected void g(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.dCh) {
      return;
    }
    if ((this.dzp) && (this.dzq)) {
      if (this.dzr)
      {
        paramArrayOfFloat2 = new float[16];
        Matrix.setIdentityM(paramArrayOfFloat2, 0);
      }
    }
    for (;;)
    {
      c(this.mRunOnDraw);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      if (this.dzu) {
        Matrix.setIdentityM(paramArrayOfFloat2, 0);
      }
      if (this.cBE) {
        Matrix.setIdentityM(paramArrayOfFloat2, 0);
      }
      Matrix.rotateM(paramArrayOfFloat2, 0, this.eNx, 0.0F, 0.0F, 1.0F);
      Matrix.scaleM(paramArrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
      this.mRenderFBO.bind();
      super.g(paramArrayOfFloat1, paramArrayOfFloat2);
      this.mRenderFBO.unbind();
      paramArrayOfFloat1 = this.mRenderFBO;
      int j = paramArrayOfFloat1.getTexId();
      int i = j;
      if (this.dzu)
      {
        paramArrayOfFloat1.unbind();
        this.jdField_a_of_type_Ayyy.setInputTextureID(j);
        this.jdField_a_of_type_Ayyy.onDrawFrame();
        i = this.jdField_a_of_type_Ayyy.getOutputTextureID();
        paramArrayOfFloat1.bind();
      }
      j = i;
      if (this.cBE) {
        j = this.jdField_a_of_type_Ayza.mh(i);
      }
      i = j;
      if (this.jdField_a_of_type_Ayyz != null)
      {
        paramArrayOfFloat1.bind();
        i = this.jdField_a_of_type_Ayyz.mh(j);
        paramArrayOfFloat1.unbind();
      }
      j = i;
      if (this.h != null)
      {
        this.h.setParam("key_draw_screen", String.valueOf(false));
        this.h.setParam("key_width", String.valueOf(this.mVideoWidth));
        this.h.setParam("key_height", String.valueOf(this.mVideoHeight));
        int k = this.h.drawFrame(i);
        j = i;
        if (k != -1) {
          j = k;
        }
      }
      if (paramArrayOfFloat1 == this.mRenderFBO)
      {
        paramArrayOfFloat1 = this.o;
        label321:
        paramArrayOfFloat1.bind();
        this.e.drawTexture(j, null, null);
        i = paramArrayOfFloat1.getTexId();
        paramArrayOfFloat1.unbind();
        this.jdField_a_of_type_Ayyw.dMa();
        if (!this.jdField_a_of_type_Ayyw.ave()) {
          break label506;
        }
        if (paramArrayOfFloat1 != this.mRenderFBO) {
          break label498;
        }
        paramArrayOfFloat1 = this.o;
        label375:
        paramArrayOfFloat1.bind();
        this.jdField_a_of_type_Ayyw.drawTexture(i, null, null);
        i = paramArrayOfFloat1.getTexId();
        paramArrayOfFloat1.unbind();
      }
      label498:
      label506:
      for (;;)
      {
        if (this.dCj) {
          a(paramArrayOfFloat1, this.mVideoWidth, this.mVideoHeight);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
        paramArrayOfFloat1 = new float[16];
        Matrix.setIdentityM(paramArrayOfFloat1, 0);
        Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
        this.d.drawTexture(i, null, paramArrayOfFloat1);
        return;
        paramArrayOfFloat2 = GPUBaseFilter.caculateFitCenterMvpMatrix(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
        break;
        paramArrayOfFloat1 = this.mRenderFBO;
        break label321;
        paramArrayOfFloat1 = this.mRenderFBO;
        break label375;
      }
    }
  }
  
  public void hm(String paramString, int paramInt)
  {
    this.cBE = true;
    Pair localPair = rpv.a(this.mVideoWidth, this.mVideoHeight, ankt.SCREEN_WIDTH, ankt.cIE);
    this.mVideoWidth = ((Integer)localPair.first).intValue();
    this.mVideoHeight = ((Integer)localPair.second).intValue();
    this.jdField_a_of_type_Ayza = new ayza(getContext(), paramString, paramInt);
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
    throws InterruptedException
  {
    super.onDecodeFrame(paramLong1, paramLong2);
    if (this.h != null) {
      this.h.getBusinessOperation().SetTimeStamp(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat");
    super.onDecodeRepeat();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.onFilterDecodeRepeat();
    }
  }
  
  public void onDestroy() {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoFilterPlayView", 4, "onSurfaceChanged : " + paramGL10.hashCode());
    }
    if (!this.dCi) {}
    for (;;)
    {
      return;
      if ((this.dCf) && (this.mSurfaceWidth == paramInt1) && (this.mSurfaceHeight == paramInt2)) {
        continue;
      }
      this.dCf = true;
      super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
      this.mRenderFBO = new RenderBuffer(this.mVideoWidth, this.mVideoHeight, 33984);
      this.o = new RenderBuffer(this.mVideoWidth, this.mVideoHeight, 33984);
      if ((this.dzu) && (this.jdField_a_of_type_Ayyy != null))
      {
        paramGL10 = rpv.a(this.mVideoWidth, this.mVideoHeight, paramInt1, paramInt2);
        this.jdField_a_of_type_Ayyy.onSurfaceChange(((Integer)paramGL10.first).intValue(), ((Integer)paramGL10.second).intValue());
      }
      if (this.jdField_a_of_type_Ayyw != null) {
        this.jdField_a_of_type_Ayyw.onOutputSizeChanged(this.mVideoWidth, this.mVideoHeight);
      }
      if (this.jdField_a_of_type_Ayyz != null) {
        this.jdField_a_of_type_Ayyz.onSurfaceChange(this.mVideoWidth, this.mVideoHeight);
      }
      if (this.cBE)
      {
        if (this.mVideoWidth >= 720)
        {
          paramInt1 = this.mVideoWidth;
          label243:
          if (this.mVideoWidth < 720) {
            break label375;
          }
          paramInt2 = this.mVideoHeight;
          this.jdField_a_of_type_Ayza.onSurfaceChange(paramInt1, paramInt2);
        }
      }
      else
      {
        this.d.onOutputSizeChanged(this.mVideoWidth, this.mVideoHeight);
        if (this.y != null) {}
      }
      try
      {
        this.ib = new byte[this.mVideoWidth * this.mVideoHeight * 4];
        this.y = ByteBuffer.wrap(this.ib);
        if (this.h != null)
        {
          this.h.surfaceChange(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
          this.dCh = false;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFilterPlayView", 2, "onSurfaceChanged");
        return;
        paramInt1 = 720;
        break label243;
        label375:
        paramInt2 = alwy.iN((int)(720.0F / this.mVideoWidth * this.mVideoHeight));
      }
      catch (OutOfMemoryError paramGL10)
      {
        for (;;)
        {
          QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", paramGL10);
          if (this.y != null)
          {
            this.y.clear();
            this.y = null;
          }
        }
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    ankq.axX();
    if (VideoEnvironment.d("AVCodec", BaseApplication.getContext()) != 0)
    {
      ThreadManager.getUIHandler().post(new VideoFilterPlayView.2(this));
      this.dCi = false;
      QLog.e("VideoFilterPlayView", 1, "onSurfaceCreated : Load so fail");
    }
    do
    {
      return;
      this.dCf = false;
      paramGL10 = ayyl.a(101);
      this.e = paramGL10;
      this.d = paramGL10;
      this.e.init();
      if (this.f != null)
      {
        this.d = this.f;
        this.d.initForce();
      }
      this.jdField_a_of_type_Ayyw = new ayyw();
      this.jdField_a_of_type_Ayyw.init();
      if (this.jdField_a_of_type_Ayyz != null) {
        this.jdField_a_of_type_Ayyz.ac(this.eNv, this.eNw, this.mVideoWidth, this.mVideoHeight);
      }
      if (this.h != null)
      {
        this.h.surfaceCreate(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
        this.dCh = false;
        if (QLog.isColorLevel()) {
          QLog.w("VideoFilterPlayView", 2, "mFilterProcess, surfaceCreated success");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterPlayView", 2, "onSurfaceCreated");
      }
      if (this.dzu)
      {
        this.jdField_a_of_type_Ayyy = new ayyy();
        this.jdField_a_of_type_Ayyy.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
        this.jdField_a_of_type_Ayyy.setVideoSize(this.mVideoWidth, this.mVideoHeight);
        this.jdField_a_of_type_Ayyy.onSurfaceCreate();
      }
    } while (!this.cBE);
    this.jdField_a_of_type_Ayza.ac(this.eNv, this.eNw, this.mVideoWidth, this.mVideoHeight);
  }
  
  protected void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mRenderFBO != null) {
      this.mRenderFBO.destroy();
    }
    if (this.o != null) {
      this.o.destroy();
    }
    if (this.y != null)
    {
      this.y.clear();
      this.y = null;
    }
    if (this.e != null)
    {
      this.e.destroy();
      this.e = null;
    }
    if (this.jdField_a_of_type_Ayyz != null) {
      this.jdField_a_of_type_Ayyz.onSurfaceDestroy();
    }
    if (this.f != null)
    {
      this.f.destroy();
      this.f = null;
    }
    if (this.jdField_a_of_type_Ayyw != null)
    {
      this.jdField_a_of_type_Ayyw.destroy();
      this.jdField_a_of_type_Ayyw = null;
    }
    if (this.jdField_a_of_type_Ayyy != null) {
      this.jdField_a_of_type_Ayyy.onSurfaceDestroy();
    }
    if (this.h != null)
    {
      this.h.surfaceDestroyed();
      this.dCh = true;
      this.h = awte.c();
      awte.a(this.h);
    }
    if (this.jdField_a_of_type_Ayza != null) {
      this.jdField_a_of_type_Ayza.onSurfaceDestroy();
    }
  }
  
  protected void runOnDraw(@NonNull Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.add(paramRunnable);
      return;
    }
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((this.jdField_a_of_type_Ayyw == null) || ((!this.jdField_a_of_type_Ayyw.ave()) && (paramInt == 0))) {
      return;
    }
    this.jdField_a_of_type_Ayyw.aY(paramInt, this.mSurfaceWidth, this.mSurfaceHeight);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_Ayyw.a(paramInt1, paramInt2, paramFloat, paramInt3, this.mSurfaceWidth, this.mSurfaceHeight);
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    super.setFilePath(paramString1, paramString2);
    if ((!TextUtils.isEmpty(this.cYn)) && (FileUtil.checkFileExist(this.cYn)) && (!this.h.hasQQFilter(183)))
    {
      this.h.pushChainBasedStackTopChain(183, null);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter = ((PKFilter)this.h.getQQFilterByType(183));
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.enableDebug(false);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.config(this.cYm, this.cYn, this.cYo, this.videoDuration, false);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPkvideoPKFilter.prepare();
      }
      setProlong(alzu.getDuration(this.cYm));
    }
  }
  
  public void setFilePath(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.dzp = paramBoolean1;
    this.dzq = paramBoolean2;
    this.dzr = paramBoolean3;
    setFilePath(paramString1, paramString2);
    if ((this.dzp) && (this.dzr))
    {
      paramString1 = rpv.a(this.mVideoWidth, this.mVideoHeight, ankt.SCREEN_WIDTH, ankt.cIE);
      this.mVideoWidth = ((Integer)paramString1.first).intValue();
      this.mVideoHeight = ((Integer)paramString1.second).intValue();
    }
  }
  
  public void setFollowCaptureVideo(FollowCaptureParam paramFollowCaptureParam)
  {
    if (paramFollowCaptureParam != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.dzu = bool;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = paramFollowCaptureParam;
      return;
    }
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.d = this.e;
      this.f = null;
      return;
    }
    if (this.f == null)
    {
      this.f = ayyl.a(106);
      runOnDraw(new VideoFilterPlayView.1(this));
    }
    ((ayyq)this.f).ae(paramBitmap);
    this.d = this.f;
  }
  
  public void setSpeedType(int paramInt)
  {
    super.setSpeedType(paramInt);
    runOnDraw(new VideoFilterPlayView.3(this, paramInt));
  }
  
  public void setStoryGamePaths(String paramString1, String paramString2, String paramString3)
  {
    this.cYm = paramString1;
    this.cYn = paramString2;
    this.cYo = paramString3;
  }
  
  public void setTrackerCallback(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$a = parama;
  }
  
  public void setTransferData(TransferData paramTransferData)
  {
    runOnDraw(new VideoFilterPlayView.4(this, paramTransferData));
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */