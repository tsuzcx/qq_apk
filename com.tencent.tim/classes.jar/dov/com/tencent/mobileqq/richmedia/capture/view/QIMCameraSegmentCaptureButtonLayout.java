package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import aniq;
import ayxx;
import ayxy;
import ayxz;
import ayya;
import ayyb;
import ayyc;
import ayyd;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.capture.view.QIMCircleProgress;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class QIMCameraSegmentCaptureButtonLayout
  extends QIMCameraCaptureButtonLayout
{
  protected static final int eNl = aniq.dHa;
  protected float GW = 0.0F;
  private float GX = this.za * 0.98F / 1000.0F;
  public float GY = -1.0F;
  protected ValueAnimator aZ = null;
  protected boolean cmo;
  public AtomicBoolean eT = new AtomicBoolean(false);
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMCameraSegmentCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void eUq()
  {
    boolean bool = true;
    if (this.dE.get())
    {
      if (!this.eT.get()) {
        break label193;
      }
      this.eT.set(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setVisibility(8);
      if (this.b.ak() < QIMCircleProgress.bCb * (float)(eNl - 500L) / eNl) {
        break label188;
      }
    }
    for (;;)
    {
      this.isOver = bool;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null)
      {
        if (this.isOver) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFi();
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.coB();
      }
      this.b.hW().add(Float.valueOf(this.b.ak()));
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints add, size = " + this.b.hW().size());
      }
      this.GW = this.b.ak();
      ZX(false);
      return;
      label188:
      bool = false;
    }
    label193:
    ZX(true);
  }
  
  @TargetApi(11)
  protected void ZX(boolean paramBoolean)
  {
    if (this.GY < 0.0F) {
      this.GY = 1.45F;
    }
    if ((this.aZ != null) && (this.aZ.isRunning()))
    {
      this.aZ.removeAllListeners();
      this.aZ.removeAllUpdateListeners();
      this.aZ.cancel();
    }
    this.aZ = ValueAnimator.ofFloat(new float[] { this.GY, 1.0F });
    this.aZ.setDuration((400.0F * (this.GY - 1.0F) / 0.45F));
    this.aZ.addUpdateListener(new ayxy(this));
    float f = this.GW;
    if ((!this.isOver) && (this.b.hW().size() > 0)) {
      this.aZ.addListener(new ayxz(this, paramBoolean, f));
    }
    this.aZ.start();
    this.P = ValueAnimator.ofFloat(new float[] { 0.85F, 1.0F });
    this.P.setDuration(400L);
    this.P.addUpdateListener(new ayya(this));
    this.P.start();
    this.b.aea(0);
  }
  
  @TargetApi(11)
  protected void ZY(boolean paramBoolean)
  {
    if (this.GY < 0.0F) {
      this.GY = 1.0F;
    }
    if ((this.aZ != null) && (this.aZ.isRunning()))
    {
      this.aZ.removeAllListeners();
      this.aZ.removeAllUpdateListeners();
      this.aZ.cancel();
    }
    this.aZ = ValueAnimator.ofFloat(new float[] { this.GY, 1.45F });
    this.aZ.setDuration((400.0F * (1.45F - this.GY) / 0.45F));
    this.aZ.addUpdateListener(new ayyb(this));
    this.aZ.addListener(new ayyc(this, paramBoolean));
    this.aZ.start();
    this.P = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F });
    this.P.setDuration(400L);
    this.P.addUpdateListener(new ayyd(this));
    this.P.start();
    this.b.aea(1);
    if (paramBoolean) {
      this.b.setStrokeWidth(3.0F);
    }
  }
  
  public boolean aRv()
  {
    float f1 = this.GW / QIMCircleProgress.bCb;
    float f2 = this.za;
    return this.za - f1 * f2 < 500.0F;
  }
  
  public boolean aRw()
  {
    return this.cmo;
  }
  
  protected void aZ(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "handleMessage what:" + paramMessage.what + ", shortVideoShot:" + this.dE.get() + ", segmentShot:" + this.eT.get());
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ZY(true);
            return;
          } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null);
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.coA();
          return;
        } while (!this.dE.get());
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.coB();
        }
        this.dE.set(false);
        AQ();
        return;
        eUq();
        return;
        ZY(false);
        return;
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.dKK();
        }
        AQ();
        return;
      } while ((!this.dE.get()) || (!this.eT.get()) || (this.isOver));
      adc();
      this.handler.sendEmptyMessageDelayed(5, 50L);
      return;
      reset();
      return;
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFf();
  }
  
  protected void adc()
  {
    float f1 = (float)(System.currentTimeMillis() - this.ahO) / this.za;
    float f2 = QIMCircleProgress.bCb;
    f1 = this.GW + f1 * f2;
    if (f1 >= QIMCircleProgress.bCb) {}
    for (boolean bool = true;; bool = false)
    {
      this.isOver = bool;
      f2 = f1 / QIMCircleProgress.bCb;
      f2 = this.za / 1000.0F * f2;
      String str = (int)f2 + "秒";
      if (f2 > this.GX) {
        str = (int)(this.za / 1000.0F) + "秒";
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText(str);
      this.b.setProgress(f1);
      if (QLog.isColorLevel()) {
        QLog.i("CameraSegmentCaptureLayout", 2, "updateProgress percent:" + f1 + ", time:" + str + ", maxDuration:" + this.za);
      }
      if (this.isOver)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFi();
        stopCapture();
      }
      return;
    }
  }
  
  public void bP(float paramFloat)
  {
    List localList = this.b.hW();
    paramFloat /= this.za;
    paramFloat = QIMCircleProgress.bCb * paramFloat;
    float f = this.GW;
    if ((localList.size() >= 1) && (this.GW < QIMCircleProgress.bCb))
    {
      localList.remove(localList.size() - 1);
      if (localList.size() < 1) {
        break label160;
      }
    }
    label160:
    for (this.GW = (((Float)localList.get(localList.size() - 1)).floatValue() + paramFloat);; this.GW = paramFloat)
    {
      localList.add(Float.valueOf(this.GW));
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "Adjust progress : before = " + f + " ; after = " + this.GW);
      }
      return;
    }
  }
  
  @TargetApi(11)
  public void cxg()
  {
    if (this.aZ != null) {
      this.aZ.cancel();
    }
    if (this.P != null) {
      this.P.cancel();
    }
  }
  
  protected void eFg()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFg();
    }
    ZX(true);
  }
  
  public void eNz()
  {
    Object localObject = this.b.hW();
    if (((List)localObject).size() > 0)
    {
      ((List)localObject).remove(((List)localObject).size() - 1);
      if (((List)localObject).size() != 0) {
        break label117;
      }
      this.GW = 0.0F;
      reset();
    }
    for (;;)
    {
      this.b.setProgress(this.GW);
      if (this.isOver) {
        this.isOver = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints delete, size = " + this.b.hW().size());
      }
      return;
      label117:
      this.GW = ((Float)((List)localObject).get(((List)localObject).size() - 1)).floatValue();
      localObject = (int)(this.GW / QIMCircleProgress.bCb * (this.za / 1000.0F)) + "秒";
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCountTimeLayout.setText((String)localObject);
      this.b.ePg();
    }
  }
  
  protected void eUp()
  {
    if (this.GY < 0.0F) {
      this.GY = 1.45F;
    }
    if ((this.aZ != null) && (this.aZ.isRunning()))
    {
      this.aZ.removeAllListeners();
      this.aZ.removeAllUpdateListeners();
      this.aZ.cancel();
    }
    this.aZ = ValueAnimator.ofFloat(new float[] { this.GY, 1.0F });
    this.aZ.setDuration((400.0F * (this.GY - 1.0F) / 0.45F));
    this.aZ.addUpdateListener(new ayxx(this));
    this.aZ.start();
  }
  
  protected void init()
  {
    super.init();
    this.b.ePf();
    this.za = eNl;
    this.cmo = true;
  }
  
  public void onResume()
  {
    this.isPaused = false;
    this.dF.set(false);
  }
  
  protected boolean r(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraSegmentCaptureLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.dE.get() + ", segmentShot:" + this.eT.get() + ", actionUp:" + this.dF.get() + ", isOver:" + this.isOver);
    }
    if (!this.cmo) {
      return super.r(paramView, paramMotionEvent);
    }
    dKJ();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.Ny, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    if (this.isOver) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if (this.isPaused) {
        return false;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null) || (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.aNv()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
        }
        return false;
      }
      if ((this.dyQ == 3) || (this.dyQ == 1))
      {
        this.dF.set(false);
        if (!this.dE.get()) {
          break label286;
        }
        this.handler.sendEmptyMessage(8);
      }
      for (;;)
      {
        this.cAn = true;
        return true;
        label286:
        this.handler.sendEmptyMessage(1);
      }
      stopCapture();
      return true;
      if ((this.Ny != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).auV())) {
        ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).dLg();
      }
    }
  }
  
  public void reset()
  {
    super.reset();
    this.eT.set(false);
    this.b.hW().clear();
    this.b.cancelAnimation();
    this.GW = 0.0F;
  }
  
  public void setCurrentAnimatorValue(float paramFloat)
  {
    this.GY = paramFloat;
  }
  
  public void setMaxDuration(float paramFloat)
  {
    super.setMaxDuration(paramFloat);
    this.GX = (this.za * 0.98F / 1000.0F);
  }
  
  public void setSegment(boolean paramBoolean)
  {
    this.cmo = paramBoolean;
  }
  
  public void stopCapture()
  {
    if (!this.cAn) {
      return;
    }
    if (!this.cmo)
    {
      super.stopCapture();
      return;
    }
    if ((this.dyQ == 3) || (this.dyQ == 1))
    {
      this.dF.set(true);
      this.handler.removeMessages(5);
      this.handler.removeMessages(9);
      cxg();
      if (this.dE.get()) {
        if (this.eT.get()) {
          this.handler.sendEmptyMessage(7);
        }
      }
    }
    for (;;)
    {
      this.cAn = false;
      this.b.aea(0);
      return;
      eFg();
      continue;
      eFg();
      this.handler.removeMessages(1);
      continue;
      if (this.dyQ == 2) {
        this.handler.sendEmptyMessage(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */