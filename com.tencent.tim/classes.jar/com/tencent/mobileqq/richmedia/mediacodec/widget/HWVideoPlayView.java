package com.tencent.mobileqq.richmedia.mediacodec.widget;

import alza;
import alzd;
import alze;
import amas;
import ambg;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.text.TextUtils;
import android.util.AttributeSet;
import azbt;
import azbt.a;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.a;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import pog;
import ram;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements alzd, SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  protected alze a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new ambg(this);
  protected AudioDecoder a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  protected final AudioDecoder.a b;
  private alzd c;
  public boolean cBS;
  public volatile boolean cBT;
  protected final alza d = new alza();
  int dBB = 0;
  int index = 0;
  private boolean isPaused;
  protected int mVideoHeight;
  protected int mVideoWidth;
  protected int surfaceHeight;
  protected SurfaceTexture surfaceTexture;
  protected int surfaceWidth;
  protected int textureId;
  public long videoDuration;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_Alze = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.b = new AudioDecoder.a();
    dLN();
  }
  
  protected alze a()
  {
    return new HWVideoDecoder();
  }
  
  protected void dLN()
  {
    setRenderer(this);
    setRenderMode(0);
  }
  
  public void dMb()
  {
    setPlayRange(0, 0);
  }
  
  public void dMc()
  {
    queueEvent(new HWVideoPlayView.2(this));
  }
  
  public void dMd()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.dLH();
  }
  
  public void fp(long paramLong)
    throws InterruptedException
  {
    if (this.c != null) {
      this.c.fp(paramLong);
    }
  }
  
  protected void g(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.textureId, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public int getSpeedType()
  {
    return this.d.speedType;
  }
  
  public String getVideoFilePath()
  {
    return this.d.inputFilePath;
  }
  
  public void onDecodeCancel()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeCancel");
    if (this.c != null) {
      this.c.onDecodeCancel();
    }
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    QLog.e("HWVideoPlayView", 4, "onDecodeError errorCode = " + paramInt, paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeFinish");
    if (this.c != null) {
      this.c.onDecodeFinish();
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.index = 0;
    this.dBB = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.dLH();
    if (this.c != null) {
      this.c.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.seekTo(paramLong);
  }
  
  public void onDecodeStart()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeStart");
    this.index = 0;
    if (this.c != null) {
      this.c.onDecodeStart();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    int i = this.dBB;
    this.dBB = (i + 1);
    ram.b("HWVideoPlayView", "onDrawFrame index = %d", Integer.valueOf(i));
    try
    {
      if (this.surfaceTexture != null)
      {
        this.surfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.surfaceTexture.getTransformMatrix(paramGL10);
        g(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.mVideoWidth, this.mVideoHeight, this.surfaceWidth, this.surfaceHeight));
      }
      return;
    }
    catch (Throwable paramGL10)
    {
      QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", paramGL10);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int i = this.index;
    this.index = (i + 1);
    ram.b("HWVideoPlayView", "yarkey onFrameAvailable %d", Integer.valueOf(i));
    this.surfaceTexture = paramSurfaceTexture;
    requestRender();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onPause");
    }
    this.isPaused = true;
    pausePlay();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onResume");
    }
    this.isPaused = false;
    resumePlay();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceChanged : " + paramInt1 + ";" + paramInt2);
    }
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.surfaceWidth, this.surfaceHeight);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)amas.a(102));
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    this.textureId = GlUtil.createTexture(36197);
    if (QLog.isColorLevel()) {
      QLog.d("DIDI", 1, "onSurfaceChanged mHaveDanceRankShowed=" + this.cBS);
    }
    if (!this.cBS)
    {
      startPlay();
      if (this.isPaused) {
        pausePlay();
      }
      this.cBT = true;
      return;
    }
    this.cBT = false;
  }
  
  public void onSurfaceDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    if (this.surfaceTexture != null)
    {
      this.surfaceTexture.release();
      this.surfaceTexture = null;
    }
    stopPlay();
  }
  
  public void pausePlay()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "pausePlay");
    }
    this.jdField_a_of_type_Alze.pauseDecode();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.pausePlay();
  }
  
  public void resumePlay()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "resumePlay");
    }
    this.jdField_a_of_type_Alze.resumeDecode();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.resumePlay();
  }
  
  public void setDecodeListener(alzd paramalzd)
  {
    this.c = paramalzd;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.d.inputFilePath = paramString1;
    this.b.audioFilePath = paramString2;
    this.b.a = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: videoFilePath = " + this.d.inputFilePath + " ; audioFilePath = " + paramString2);
    }
    this.videoDuration = pog.getDurationOfVideo(this.d.inputFilePath);
    this.b.videoDurationMs = this.videoDuration;
    paramString2 = new azbt.a();
    int i = azbt.a(paramString1, paramString2);
    this.mVideoWidth = paramString2.mMetaData[0];
    this.mVideoHeight = paramString2.mMetaData[1];
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, "setFilePath: errcode = " + i + " ; videoWidth = " + this.mVideoWidth + " , videoHeight=" + this.mVideoHeight);
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.b.mMuteAudio = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.setMuteAudio(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    this.d.startTimeMillSecond = paramInt1;
    this.d.endTimeMillSecond = paramInt2;
    this.jdField_a_of_type_Alze.setPlayRange(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.setPlayRange(paramInt1, paramInt2);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.d.repeat = paramBoolean;
    this.b.repeat = paramBoolean;
  }
  
  public void setRotate(int paramInt)
  {
    this.d.cBx = true;
    this.d.adjustRotation = paramInt;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.d.speedType = paramInt;
    this.b.speedType = paramInt;
    this.jdField_a_of_type_Alze.setSpeedType(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.setSpeedType(paramInt);
  }
  
  public void setVideoDecodeConfig(alza paramalza)
  {
    this.d.a(paramalza);
  }
  
  public void startPlay()
  {
    if (TextUtils.isEmpty(this.d.inputFilePath)) {
      throw new RuntimeException("startPlay failed. videoFilePath is empty.");
    }
    this.jdField_a_of_type_Alze.stopDecode();
    this.jdField_a_of_type_Alze.a(this.d, this.textureId, this, this);
    if (!TextUtils.isEmpty(this.b.audioFilePath)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.b);
    }
  }
  
  public void startPlayAudio()
  {
    if (!TextUtils.isEmpty(this.b.audioFilePath)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.a(this.b);
    }
  }
  
  public void stopPlay()
  {
    this.jdField_a_of_type_Alze.stopDecode();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder.stopAudio();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */