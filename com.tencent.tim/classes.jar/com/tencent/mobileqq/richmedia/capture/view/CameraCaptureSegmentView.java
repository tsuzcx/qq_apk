package com.tencent.mobileqq.richmedia.capture.view;

import amag.a;
import amai;
import ambu;
import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaFormat;
import android.os.Message;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import aybo;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(18)
public class CameraCaptureSegmentView
  extends CameraCaptureView
  implements amai
{
  private ambu jdField_a_of_type_Ambu;
  private aybo jdField_a_of_type_Aybo;
  private boolean cAo = true;
  private boolean cAp;
  private int dyR = 300;
  private boolean mIsStarted;
  
  public CameraCaptureSegmentView(@NonNull Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public CameraCaptureSegmentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  private boolean auQ()
  {
    if (!this.cAp) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "restartCaptureVideo");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.ahU = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.dLd();
    this.jdField_a_of_type_Ambu = new ambu(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.ahU);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.hd(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$e.bZj, this.jdField_a_of_type_Ambu.getAudioPath());
    super.dKM();
    this.cAp = false;
    return true;
  }
  
  protected void Op(boolean paramBoolean)
  {
    super.Op(paramBoolean);
    if (this.jdField_a_of_type_Aybo != null) {
      this.jdField_a_of_type_Aybo.destroy();
    }
    this.jdField_a_of_type_Aybo = new aybo();
    this.jdField_a_of_type_Aybo.f(getContext(), this.dzc, this.dzd);
  }
  
  public void Pl(String paramString)
  {
    super.Pl(paramString);
    if (this.jdField_a_of_type_Ambu != null) {
      this.jdField_a_of_type_Ambu.b(paramString, getMediaFormat());
    }
  }
  
  public void Pn(String paramString)
  {
    if (this.jdField_a_of_type_Ambu != null) {
      this.jdField_a_of_type_Ambu.a(getMediaFormat(), paramString);
    }
    this.cAp = true;
  }
  
  public void Tx(int paramInt)
  {
    super.Tx(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureSegmentView", 2, "onAudioError:" + paramInt);
    }
    if (paramInt == -6)
    {
      if (this.jdField_a_of_type_Ambu != null) {
        this.jdField_a_of_type_Ambu.Uk(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.getSampleRate());
      }
      this.cAp = true;
    }
  }
  
  public void a(amag.a parama)
  {
    if ((this.jdField_a_of_type_Ambu != null) && (this.jdField_a_of_type_Ambu.b != null)) {
      this.jdField_a_of_type_Ambu.b.obtainMessage(2, parama).sendToTarget();
    }
  }
  
  public void dKL()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "cancelCaptureVideo,mIsStarted:" + this.mIsStarted);
    }
    if (this.jdField_a_of_type_Ambu != null)
    {
      ambu localambu = this.jdField_a_of_type_Ambu;
      this.jdField_a_of_type_Ambu = null;
      localambu.bme();
    }
    if (this.mIsStarted)
    {
      this.mIsStarted = false;
      super.dKN();
    }
  }
  
  public void dKM()
  {
    if (this.mIsStarted)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureSegmentView", 2, "startCaptureVideo fail,mIsStarted:" + this.mIsStarted);
      }
      return;
    }
    boolean bool2 = true;
    if (this.cAo)
    {
      this.cAo = false;
      super.dKM();
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureSegmentView", 2, "startCaptureVideo");
      }
    }
    for (boolean bool1 = bool2;; bool1 = auQ())
    {
      this.jdField_a_of_type_Amae.a = null;
      if ((this.jdField_a_of_type_Ambu != null) && (this.jdField_a_of_type_Ambu.avk())) {
        this.jdField_a_of_type_Amae.a = this;
      }
      this.mIsStarted = bool1;
      return;
    }
  }
  
  public void dKN()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureSegmentView", 2, "stopCaptureVideo, mIsStarted:" + this.mIsStarted);
    }
    if (this.mIsStarted)
    {
      super.dKN();
      if (this.jdField_a_of_type_Ambu != null) {
        this.jdField_a_of_type_Ambu.l(this.dyR, this.ahP, this.ahQ);
      }
      this.mIsStarted = false;
    }
  }
  
  public void dKO()
  {
    if ((this.jdField_a_of_type_Ambu != null) && (this.jdField_a_of_type_Ambu.b != null)) {
      this.jdField_a_of_type_Ambu.b.obtainMessage(3).sendToTarget();
    }
  }
  
  public void e(MediaFormat paramMediaFormat)
  {
    if ((this.jdField_a_of_type_Ambu != null) && (this.jdField_a_of_type_Ambu.b != null)) {
      this.jdField_a_of_type_Ambu.b.obtainMessage(1, paramMediaFormat).sendToTarget();
    }
  }
  
  protected int iT(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Aybo != null)
    {
      i = paramInt;
      if (this.jdField_a_of_type_Aybo.aQd())
      {
        this.jdField_a_of_type_Aybo.drawTexture(paramInt, null);
        i = this.jdField_a_of_type_Aybo.getOutTexture();
      }
    }
    return i;
  }
  
  protected void init()
  {
    this.cAN = false;
    super.init();
  }
  
  protected void initUI()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setZOrderOnTop(true);
    getHolder().setFormat(-3);
  }
  
  public void kf(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureSegmentView", 2, "onEncodeFinish filePath = " + paramString);
    }
    if (!this.cAt) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
    }
    if (this.jdField_a_of_type_Ambu != null) {
      this.jdField_a_of_type_Ambu.a(paramString, getMediaFormat());
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.jdField_a_of_type_Aybo != null) {
      this.jdField_a_of_type_Aybo = null;
    }
  }
  
  public void setCaptureParam(CameraCaptureView.e parame)
  {
    parame.dLd();
    super.setCaptureParam(parame);
    int i = VideoEnvironment.d("AVCodec", getContext());
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d("CameraCaptureSegmentView", 2, "loadAVCodecSo failed:" + i);
    }
    this.jdField_a_of_type_Ambu = new ambu(this, parame.ahU);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.aJ(true, this.jdField_a_of_type_Ambu.getAudioPath());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.Oh(true);
  }
  
  public void setFinishAnimatorDelay(int paramInt)
  {
    this.dyR = paramInt;
  }
  
  public void setSurfaceAlpha(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.jdField_a_of_type_Aybo != null) {
      this.jdField_a_of_type_Aybo.setAlpha(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView
 * JD-Core Version:    0.7.0.1
 */