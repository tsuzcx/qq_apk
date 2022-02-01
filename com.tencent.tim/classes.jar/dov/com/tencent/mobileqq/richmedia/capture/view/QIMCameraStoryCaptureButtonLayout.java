package dov.com.tencent.mobileqq.richmedia.capture.view;

import alwx;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;
import rar;

public class QIMCameraStoryCaptureButtonLayout
  extends QIMCameraSegmentCaptureButtonLayout
  implements DragAnimationMgr.a
{
  private ImageView Jb;
  private ImageView Jc;
  private DragAnimationMgr jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr;
  private RunnableLW jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW = new RunnableLW(null);
  private a jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a;
  private long aDl;
  private ObjectAnimator bU;
  private ObjectAnimator bV;
  private ObjectAnimator bW;
  private ObjectAnimator bX;
  private boolean dBU;
  private boolean dBV = true;
  private MotionEvent m = null;
  
  public QIMCameraStoryCaptureButtonLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QIMCameraStoryCaptureButtonLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ar(MotionEvent paramMotionEvent)
  {
    if ((this.dBU) && (this.aDl != 0L)) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ap(paramMotionEvent);
  }
  
  private void at(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    if (this.m != null) {
      this.m.recycle();
    }
    this.m = paramMotionEvent;
  }
  
  private void dd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.Jb.getVisibility() != 0) {
        this.Jb.setVisibility(0);
      }
      if ((this.Jb.getAlpha() != 1.0F) && ((this.bU == null) || (!this.bU.isRunning()))) {}
    }
    while ((this.Jb.getAlpha() == 0.0F) || ((this.bV != null) && (this.bV.isRunning())))
    {
      return;
      if (paramBoolean2)
      {
        if (this.bU == null)
        {
          this.bU = DragAnimationMgr.c(this.Jb, null);
          return;
        }
        this.bU.start();
        return;
      }
      this.Jb.setAlpha(1.0F);
      return;
    }
    if (paramBoolean2)
    {
      if (this.bV == null)
      {
        this.bV = DragAnimationMgr.b(this.Jb, null);
        return;
      }
      this.bV.start();
      return;
    }
    this.Jb.setAlpha(0.0F);
  }
  
  private void de(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.Jc.getVisibility() != 0) {
        this.Jc.setVisibility(0);
      }
      if ((this.Jc.getAlpha() != 1.0F) && ((this.bW == null) || (!this.bW.isRunning()))) {}
    }
    while ((this.Jc.getAlpha() == 0.0F) || ((this.bX != null) && (this.bX.isRunning())))
    {
      return;
      if (paramBoolean2)
      {
        if (this.bW == null)
        {
          this.bW = DragAnimationMgr.c(this.Jc, null);
          return;
        }
        this.bW.start();
        return;
      }
      this.Jc.setAlpha(1.0F);
      return;
    }
    if (paramBoolean2)
    {
      if (this.bX == null)
      {
        this.bX = DragAnimationMgr.b(this.Jc, null);
        return;
      }
      this.bX.start();
      return;
    }
    this.Jc.setAlpha(0.0F);
  }
  
  protected void AQ()
  {
    super.AQ();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.resetUI();
  }
  
  public void ZU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onEnterRegion method,leftDirection:" + paramBoolean);
    }
    if (paramBoolean)
    {
      setSegment(true);
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(3);
      }
    }
    do
    {
      return;
      setLockStatus(true);
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(4);
  }
  
  public void ZV(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onExitRegion method,leftDirection:" + paramBoolean);
    }
    if (paramBoolean)
    {
      setSegment(false);
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(5);
      }
    }
    do
    {
      return;
      setLockStatus(false);
    } while (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a == null);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(6);
  }
  
  public void ZW(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "haveMoveInvalid:" + paramBoolean);
    }
    if (paramBoolean)
    {
      ZZ(true);
      this.b.setDrawCenterCircle(false);
    }
  }
  
  public void ZZ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "showStatusButton:" + paramBoolean + " mIsSegment:" + this.cmo + " mEnableSegment:" + this.dBV + " mLockStatus:" + this.dBU);
    }
    if (((!this.cmo) && (this.dBV)) || (!paramBoolean)) {
      dd(paramBoolean, true);
    }
    if ((!this.dBU) || (!paramBoolean)) {
      de(paramBoolean, true);
    }
  }
  
  public boolean aRx()
  {
    return this.dBU;
  }
  
  public void aaa(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "showStatusButtonWithAnim:" + paramBoolean + " mIsSegment:" + this.cmo + " mEnableSegment:" + this.dBV + " mLockStatus:" + this.dBU);
    }
    if (((!this.cmo) && (this.dBV)) || (!paramBoolean)) {
      dd(paramBoolean, false);
    }
    if ((!this.dBU) || (!paramBoolean)) {
      de(paramBoolean, false);
    }
  }
  
  protected void as(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ao(paramMotionEvent);
    at(paramMotionEvent);
    this.handler.postDelayed(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW, 100L);
  }
  
  public void dc(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onUpUINeedChange:leftDirection-" + paramBoolean1 + " selected:" + paramBoolean2);
    }
    if (paramBoolean2) {
      if (paramBoolean1)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(1);
        }
        setEnableSegment(false);
      }
    }
    for (;;)
    {
      if (!this.dBU) {
        stopCapture();
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.cO(paramBoolean1, paramBoolean2);
      }
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.adi(2);
      }
      int i = -1;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        i = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.QD();
      }
      rar.a("clk_lock", alwx.dyy, 0, new String[] { "" + i });
      continue;
      if (this.cmo) {
        ZZ(false);
      }
    }
  }
  
  protected void eTX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "startCaptureAnimationEnd method");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ZT(true);
  }
  
  public void eUj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "onDownUINeedChange method");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.eFQ();
    }
  }
  
  public void eUk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "execute rollBackAnimationEnd method");
    }
    this.b.setDrawCenterCircle(true);
    if (this.dBU) {
      this.b.aea(3);
    }
    for (;;)
    {
      aaa(false);
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a.cP(this.cmo, this.dBU);
      }
      return;
      this.b.aea(0);
    }
  }
  
  public void eUl()
  {
    eUp();
  }
  
  public void eUr()
  {
    setLockStatus(false);
    this.b.setDrawCenterCircle(true);
  }
  
  protected void init()
  {
    super.init();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131364260);
    int i = aqnm.dip2px(45.0F);
    int j = aqnm.dip2px(60.0F);
    int k = aqnm.dip2px(17.0F);
    this.Jb = new ImageView(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(j, 0, 0, 0);
    this.Jb.setTranslationY(k);
    this.Jb.setBackgroundResource(2130845328);
    this.Jb.setImageResource(2130845511);
    this.Jb.setVisibility(4);
    this.Jb.setAlpha(0.0F);
    localRelativeLayout.addView(this.Jb, localLayoutParams);
    this.Jc = new ImageView(getContext());
    localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(15, -1);
    localLayoutParams.setMargins(0, 0, j, 0);
    this.Jc.setTranslationY(k);
    this.Jc.setBackgroundResource(2130845328);
    this.Jc.setImageResource(2130845509);
    this.Jc.setVisibility(4);
    this.Jc.setAlpha(0.0F);
    localRelativeLayout.addView(this.Jc, localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr = new DragAnimationMgr();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a((ViewGroup)this.Nz, this.Ny, this.Jb, this.Jc);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.a(this);
    this.cmo = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.GY = 1.0F;
    this.b.setDrawCenterCircle(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.resetUI();
    aaa(false);
  }
  
  protected boolean r(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraStoryCaptureButtonLayout", 2, "touch action:" + (paramMotionEvent.getAction() & 0xFF) + ", shortVideoShot:" + this.dE.get() + ", segmentShot:" + this.eT.get() + ", actionUp:" + this.dF.get() + ", isOver:" + this.isOver);
    }
    int i = paramMotionEvent.getAction();
    dKJ();
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.Ny, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    if (this.isOver) {}
    do
    {
      do
      {
        do
        {
          return false;
          if (this.mIsEnable) {
            break;
          }
        } while ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a == null) || ((paramMotionEvent.getAction() & 0xFF) != 0));
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.eFe();
        return false;
        if (this.NA.getVisibility() == 0)
        {
          eUf();
          return false;
        }
        switch (i & 0xFF)
        {
        case 4: 
        default: 
          return false;
        }
      } while (this.isPaused);
      if (this.dBU)
      {
        this.aDl = System.currentTimeMillis();
        return true;
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout$a.aNv())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QIMCameraStoryCaptureButtonLayout", 2, "[segmentCapture] ignore down action, capture not ready");
    return false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ZT(false);
    if ((this.dyQ == 3) || (this.dyQ == 1))
    {
      this.dF.set(false);
      if (!this.dE.get()) {
        break label357;
      }
      this.handler.sendEmptyMessage(8);
    }
    for (;;)
    {
      as(paramMotionEvent);
      this.cAn = true;
      return true;
      label357:
      this.handler.sendEmptyMessageDelayed(1, 100L);
    }
    if ((this.dBU) && (this.aDl != 0L) && (this.aDl - System.currentTimeMillis() < 50L))
    {
      stopCapture();
      setLockStatus(false);
      this.aDl = 0L;
      return true;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ax(paramMotionEvent);
    this.handler.removeCallbacks(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$RunnableLW);
    return true;
    if ((this.Ny != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView)) && (((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).auV())) {
      ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView).dLg();
    }
    if ((this.dBU) && (this.aDl != 0L)) {
      return true;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.ap(paramMotionEvent);
    at(paramMotionEvent);
    return true;
  }
  
  public void setCaptureStatusChangeListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout$a = parama;
  }
  
  public void setDrawCenterCircle(boolean paramBoolean)
  {
    this.b.setDrawCenterCircle(paramBoolean);
  }
  
  public void setEnableSegment(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setEnableSegment:" + paramBoolean);
    }
    this.dBV = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.afN(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewDragAnimationMgr.afN(2);
  }
  
  public void setLockStatus(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setLockStatus:" + paramBoolean);
    }
    if (this.dBU != paramBoolean)
    {
      this.dBU = paramBoolean;
      setSelectLock(paramBoolean);
    }
  }
  
  public void setSegment(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraStoryCaptureButtonLayout", 2, "setSegment:" + paramBoolean);
    }
    super.setSegment(paramBoolean);
    setSelectPause(paramBoolean);
  }
  
  public void setSelectLock(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Jc.setBackgroundResource(2130845329);
      this.Jc.setImageResource(2130845508);
      return;
    }
    this.Jc.setBackgroundResource(2130845328);
    this.Jc.setImageResource(2130845509);
  }
  
  public void setSelectPause(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Jb.setBackgroundResource(2130845329);
      this.Jb.setImageResource(2130845510);
      return;
    }
    this.Jb.setBackgroundResource(2130845328);
    this.Jb.setImageResource(2130845511);
  }
  
  class RunnableLW
    implements Runnable
  {
    private RunnableLW() {}
    
    public void run()
    {
      QIMCameraStoryCaptureButtonLayout.a(QIMCameraStoryCaptureButtonLayout.this, QIMCameraStoryCaptureButtonLayout.a(QIMCameraStoryCaptureButtonLayout.this));
      QIMCameraStoryCaptureButtonLayout.this.handler.postDelayed(QIMCameraStoryCaptureButtonLayout.a(QIMCameraStoryCaptureButtonLayout.this), 100L);
    }
  }
  
  public static abstract interface a
  {
    public abstract int QD();
    
    public abstract void adi(int paramInt);
    
    public abstract void cO(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void cP(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void eFQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout
 * JD-Core Version:    0.7.0.1
 */