package com.tencent.mobileqq.richmedia.capture.view;

import alxw;
import alxx;
import alzr;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.IOException;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(17)
public class FollowCaptureView
  extends EffectsCameraCaptureView
  implements MediaPlayer.OnPreparedListener
{
  private static boolean DEBUG = true;
  private SurfaceTexture.OnFrameAvailableListener jdField_a_of_type_AndroidGraphicsSurfaceTexture$OnFrameAvailableListener = new alxw(this);
  private FollowCaptureParam jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = new alxx(this);
  private long ahW;
  private long ahX = -1L;
  private boolean cAu;
  private SurfaceTexture d;
  private int dzI = -1;
  private int dzJ;
  private int dzK;
  private int dzL;
  private RenderBuffer g;
  private HWVideoDecoder hwVideoDecoder;
  private volatile boolean mIsPrepared;
  private MediaPlayer mMediaPlayer;
  private TextureRender textureRender;
  
  public FollowCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FollowCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void pausePlay()
  {
    if (this.mMediaPlayer != null) {
      this.mMediaPlayer.pause();
    }
    if (this.hwVideoDecoder != null)
    {
      this.hwVideoDecoder.pauseDecode();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "pausePlay : " + this.hwVideoDecoder.getLastFrameSampleTimeMs());
      }
    }
  }
  
  private void resumePlay()
  {
    if ((this.mMediaPlayer != null) && (this.mIsPrepared)) {
      this.mMediaPlayer.start();
    }
    if (this.hwVideoDecoder != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "resumePlay before : " + this.hwVideoDecoder.getLastFrameSampleTimeMs());
      }
      this.hwVideoDecoder.resumeDecode();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCaptureView", 2, "resumePlay after : " + this.hwVideoDecoder.getLastFrameSampleTimeMs());
      }
    }
  }
  
  private void startPlay()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath))) {
      this.mMediaPlayer = new MediaPlayer();
    }
    try
    {
      this.hwVideoDecoder = new HWVideoDecoder();
      DecodeConfig localDecodeConfig = new DecodeConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath, 0, true, false);
      this.hwVideoDecoder.startDecode(localDecodeConfig, this.dzI, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture$OnFrameAvailableListener, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener);
      this.hwVideoDecoder.pauseDecode();
      this.mMediaPlayer.setDataSource(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath);
      this.mMediaPlayer.setLooping(false);
      this.mMediaPlayer.setOnPreparedListener(this);
      this.mMediaPlayer.prepareAsync();
      ThreadManagerV2.excute(new FollowCaptureView.3(this), 16, null, true);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public int Gt()
  {
    return (int)(this.ahW / 1000000L);
  }
  
  protected int It()
  {
    return this.surfaceWidth / 2;
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    super.a(paramInt, paramThrowable);
    pausePlay();
  }
  
  protected void c(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.ahW <= this.ahX) && (isRecording()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("hwVideoFollowView", 2, "frameToMediaCodec null ");
      }
      return;
    }
    super.c(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, this.ahW);
    this.ahX = this.ahW;
  }
  
  public void dKM()
  {
    super.dKM();
    resumePlay();
  }
  
  public void dKN()
  {
    super.dKN();
    pausePlay();
  }
  
  protected int iU(int paramInt)
  {
    paramInt = super.iU(paramInt);
    this.g.bind();
    ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.dzc, this.dzd, this.surfaceWidth / 2, this.surfaceHeight);
    Matrix.scaleM((float[])???, 0, 0.5F, 1.0F, 1.0F);
    Matrix.translateM((float[])???, 0, -1.0F, 0.0F, 0.0F);
    this.textureRender.drawTexture(3553, paramInt, null, (float[])???);
    if ((this.cAu) && (this.d != null)) {}
    for (;;)
    {
      synchronized (this.d)
      {
        float[] arrayOfFloat1 = new float[16];
        this.d.getTransformMatrix(arrayOfFloat1);
        float[] arrayOfFloat2 = GPUBaseFilter.caculateCenterCropMvpMatrix(this.dzK, this.dzL, this.surfaceWidth / 2, this.surfaceHeight);
        Matrix.scaleM(arrayOfFloat2, 0, 0.5F, 1.0F, 1.0F);
        Matrix.translateM(arrayOfFloat2, 0, 1.0F, 0.0F, 0.0F);
        this.textureRender.drawTexture(36197, this.dzI, arrayOfFloat1, arrayOfFloat2);
        if ((QLog.isColorLevel()) && (DEBUG)) {
          QLog.d("FollowCaptureView", 2, "video texture time : " + this.hwVideoDecoder.getLastFrameSampleTimeMs());
        }
        this.g.unbind();
        return this.g.getTexId();
      }
      ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.dzK, this.dzL, this.surfaceWidth / 2, this.surfaceHeight);
      Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
      Matrix.scaleM((float[])???, 0, 0.5F, 1.0F, 1.0F);
      Matrix.translateM((float[])???, 0, 1.0F, 0.0F, 0.0F);
      this.textureRender.drawTexture(3553, this.dzJ, null, (float[])???);
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.mIsPrepared = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    if ((this.g == null) || ((this.g.getWidth() != paramInt1) && (this.g.getHeight() != paramInt2))) {
      this.g = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.textureRender = new TextureRender();
    this.dzI = alzr.createTexture(36197);
    this.dzJ = alzr.createTexture(3553);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) {
      startPlay();
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mMediaPlayer != null)
    {
      this.mMediaPlayer.stop();
      this.mMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mIsPrepared = false;
    }
    if (this.hwVideoDecoder != null)
    {
      this.hwVideoDecoder.stopDecode();
      this.hwVideoDecoder = null;
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hwVideoFollowView", 2, new Object[] { "seekTo : ", Integer.valueOf(paramInt) });
    }
    this.ahX = (paramInt - 1);
    if ((this.mMediaPlayer != null) && (this.mIsPrepared)) {
      this.mMediaPlayer.seekTo(paramInt);
    }
    if (this.hwVideoDecoder != null)
    {
      this.hwVideoDecoder.seekTo(paramInt);
      this.hwVideoDecoder.decodeFrame();
    }
  }
  
  public void setData(FollowCaptureParam paramFollowCaptureParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = paramFollowCaptureParam;
    if (this.dzI != -1) {
      startPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView
 * JD-Core Version:    0.7.0.1
 */