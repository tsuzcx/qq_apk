package com.tencent.mobileqq.richmedia.capture.view;

import alwy;
import android.content.Context;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import aniq;
import atao;
import awtj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SimpleEffectsCaptureView
  extends CameraCaptureSegmentView
  implements CameraInterFace
{
  private static QQFilterRenderManager b;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$b;
  protected boolean cAR;
  private boolean cAY;
  private boolean cAi = true;
  private float[] dp = new float[50];
  private int dzE;
  private short[] i;
  protected QQFilterRenderManager mQQFilterRenderManager;
  private boolean soLoaded;
  
  static
  {
    atao.init();
    awtj.init();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.z());
  }
  
  public SimpleEffectsCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleEffectsCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static float a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    float f = 0.0F;
    int j = 0;
    while (j < paramInt2)
    {
      f += paramArrayOfShort[(paramInt1 + j)] * paramArrayOfShort[(paramInt1 + j)];
      j += 1;
    }
    return (float)(Math.log10(f / paramInt2) * 10.0D);
  }
  
  private short[] a(int paramInt)
  {
    if ((this.i == null) || (this.i.length < paramInt)) {
      this.i = new short[paramInt];
    }
    return this.i;
  }
  
  protected void Op(boolean paramBoolean)
  {
    super.Op(paramBoolean);
    if ((this.cAR) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.surfaceChange(this.dzc, this.dzd, getWidth(), getHeight());
    }
  }
  
  public short[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramInt2 >> 1;
    short[] arrayOfShort = a(j);
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      arrayOfShort[paramInt2] = ((short)(paramArrayOfByte[(paramInt2 * 2 + paramInt1)] & 0xFF | paramArrayOfByte[(paramInt2 * 2 + paramInt1 + 1)] << 8));
      paramInt2 += 1;
    }
    return arrayOfShort;
  }
  
  public void dKM()
  {
    super.dKM();
  }
  
  protected void dKX()
  {
    super.dKX();
    ThreadManager.postImmediately(new SimpleEffectsCaptureView.1(this), null, false);
  }
  
  public void dLh()
  {
    if (!this.cAR)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleEffectsCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.soLoaded = alwy.auK();
      QQFilterRenderManager localQQFilterRenderManager = new QQFilterRenderManager(new int[] { 25 });
      this.mQQFilterRenderManager = localQQFilterRenderManager;
      b = localQQFilterRenderManager;
      this.mQQFilterRenderManager.cameraInterFace = this;
    }
    queueEvent(new SimpleEffectsCaptureView.2(this));
  }
  
  public int getBeautyLevel()
  {
    int k = 0;
    int j = k;
    if (this.cAR)
    {
      j = k;
      if (this.cAi)
      {
        j = k;
        if (this.mQQFilterRenderManager != null) {
          j = this.mQQFilterRenderManager.getBusinessOperation().getPtuBeautyLevel();
        }
      }
    }
    return j;
  }
  
  public int getCameraID()
  {
    return Is();
  }
  
  protected int iU(int paramInt)
  {
    int j = paramInt;
    QQFilterRenderManager localQQFilterRenderManager;
    if (this.cAR)
    {
      j = paramInt;
      if (this.mQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.mQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.dzc, this.dzd);
        localQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(this.dzn));
        if (Is() != 1) {
          break label175;
        }
      }
    }
    label175:
    for (boolean bool = true;; bool = false)
    {
      localQQFilterRenderManager.setParam("key_front_camera", String.valueOf(bool));
      localQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(true));
      localQQFilterRenderManager.setParam("key_enable_beauty", String.valueOf(this.cAi));
      localQQFilterRenderManager.setParam("key_enable_filter", String.valueOf(false));
      localQQFilterRenderManager.setParam("key_enable_ptv", String.valueOf(false));
      localQQFilterRenderManager.setParam("key_width", String.valueOf(this.dzc));
      localQQFilterRenderManager.setParam("key_height", String.valueOf(this.dzd));
      j = localQQFilterRenderManager.drawFrame(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$b.kR(System.currentTimeMillis());
      }
      return j;
    }
  }
  
  public void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = a(paramArrayOfByte, paramInt1, paramInt2);
    paramInt2 >>= 1;
    paramInt1 = aniq.bth;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.getSampleRate();
    }
    int j = paramInt2 * 1000 / paramInt1;
    int k = j / 30;
    int m = paramInt1 * 30 / 1000;
    paramInt1 = 0;
    while (paramInt1 < k)
    {
      this.dp[paramInt1] = a(paramArrayOfByte, paramInt1 * m, m);
      paramInt1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onAudioFrames length=" + paramInt2 + " shData.length: " + paramArrayOfByte.length + " duration: " + j + " countRefreshMs: " + m);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$a.b(k, this.dp);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    b = this.mQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (this.cAR)
    {
      if (this.mQQFilterRenderManager != null) {
        this.mQQFilterRenderManager.surfaceChange(this.dzc, this.dzd, getWidth(), getHeight());
      }
      if (this.dzE != 0) {
        setBeauty(this.dzE);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (this.cAR) {
      dLh();
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SimpleEffectsCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (b == this.mQQFilterRenderManager) {
      b = null;
    }
    if (this.cAR)
    {
      if (this.mQQFilterRenderManager != null) {
        this.mQQFilterRenderManager.surfaceDestroyed();
      }
      this.mQQFilterRenderManager = null;
      this.cAR = false;
    }
  }
  
  public void setAudioVolumeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$a = parama;
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.cAR) && (this.cAi) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramInt);
    }
    this.dzE = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.cAR) && (this.cAi)) {
      this.mQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramArrayOfInt[0]);
    }
    this.dzE = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.cAi = paramBoolean;
  }
  
  public void setFaceEffectListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, float[] paramArrayOfFloat);
  }
  
  public static abstract interface b
  {
    public abstract void OB(boolean paramBoolean);
    
    public abstract void dLA();
    
    public abstract void kR(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView
 * JD-Core Version:    0.7.0.1
 */