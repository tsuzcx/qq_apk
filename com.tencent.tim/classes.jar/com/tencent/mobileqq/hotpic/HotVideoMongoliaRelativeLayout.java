package com.tencent.mobileqq.hotpic;

import acfp;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class HotVideoMongoliaRelativeLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  public static final String bMu = acfp.m(2131707279);
  public static final String bMv = acfp.m(2131707275);
  public static final String bMw = acfp.m(2131707277);
  public static final String bMx = acfp.m(2131707278);
  private View DG;
  public CircleProgressView a;
  a jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$a;
  private b jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b;
  private c jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$c;
  d jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d;
  ProgressBar ah;
  private VelocityTracker jdField_c_of_type_AndroidViewVelocityTracker;
  private HotVideoData jdField_c_of_type_ComTencentMobileqqHotpicHotVideoData;
  private boolean cjt = true;
  boolean cju = false;
  public int dcO = 0;
  private RelativeLayout kM;
  private RelativeLayout kN;
  final float wN = 1.777778F;
  
  public HotVideoMongoliaRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HotVideoMongoliaRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void is(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b.PF(paramInt2);
      }
      return;
      this.DG.setVisibility(0);
      this.kM.setVisibility(8);
      this.kN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.ah.setVisibility(8);
      continue;
      this.DG.setVisibility(8);
      this.kM.setVisibility(0);
      this.kN.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.ah.setVisibility(0);
      continue;
      this.DG.setVisibility(0);
      this.kM.setVisibility(0);
      this.kN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.ah.setVisibility(0);
      continue;
      this.DG.setVisibility(8);
      this.kM.setVisibility(0);
      this.kN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(0);
      this.ah.setVisibility(0);
      continue;
      this.DG.setVisibility(8);
      this.kM.setVisibility(8);
      this.kN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.ah.setVisibility(8);
      continue;
      this.DG.setVisibility(8);
      this.kM.setVisibility(0);
      this.kN.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicCircleProgressView.setVisibility(8);
      this.ah.setVisibility(0);
    }
  }
  
  public void PI(int paramInt)
  {
    if (paramInt == this.dcO) {
      return;
    }
    if (!isMainThread())
    {
      ThreadManager.getUIHandler().post(new HotVideoMongoliaRelativeLayout.4(this, paramInt));
      return;
    }
    is(this.dcO, paramInt);
    QLog.d("HotVideoRelativeLayout", 2, "updatePlayStatus currentStatus is " + this.dcO + " laterStatus is " + paramInt);
    this.dcO = paramInt;
  }
  
  public void a(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    if (this.DG.getVisibility() == 0) {
      this.DG.setAlpha(f);
    }
  }
  
  public void drA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d == null) {}
    do
    {
      return;
      if (this.dcO == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d.v(7, this);
        return;
      }
    } while (this.dcO != 3);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d.v(8, this);
  }
  
  public void drB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d == null) {}
    while (this.dcO != 5) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d.v(9, this);
  }
  
  public boolean isMainThread()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d.onDestroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d = null;
    if (this.jdField_c_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_c_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_c_of_type_AndroidViewVelocityTracker = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$c = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b != null) && (this.dcO != 0))
    {
      this.dcO = 0;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b.PF(0);
      if (QLog.isColorLevel()) {
        QLog.i("HotVideoRelativeLayout", 2, "HotVideoCtl onDetachedFromWindow OnStateChanged(PLAY_STATE_PREVIEW)");
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b = null;
      return;
    }
    PI(-11);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    HotPicPageView.cjn = true;
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.jdField_c_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_c_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      for (;;)
      {
        this.cju = false;
        this.jdField_c_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
        QLog.d("HotVideoRelativeLayout", 2, "onTouch event down");
        return true;
        this.jdField_c_of_type_AndroidViewVelocityTracker.clear();
      }
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.jdField_c_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_c_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      if (Math.abs(this.jdField_c_of_type_AndroidViewVelocityTracker.getYVelocity()) > 300.0F) {
        this.cju = true;
      }
      QLog.d("HotVideoRelativeLayout", 2, "onTouch event down" + this.jdField_c_of_type_AndroidViewVelocityTracker.getYVelocity());
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$a != null) && (!this.cju)) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$a.onClick(paramView);
        }
      }
      else if (paramMotionEvent.getAction() == 3) {
        QLog.d("HotVideoRelativeLayout", 2, "event have been intercepted");
      }
    }
  }
  
  public void pauseVideo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$d.pause();
    }
  }
  
  public void setControlStateListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$b = paramb;
  }
  
  public void setHotVideoData(HotVideoData paramHotVideoData)
  {
    this.jdField_c_of_type_ComTencentMobileqqHotpicHotVideoData = paramHotVideoData;
  }
  
  public void setOnClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$a = parama;
  }
  
  public void setVidoeControlListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotVideoMongoliaRelativeLayout$c = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView);
  }
  
  public static abstract interface b
  {
    public abstract void PF(int paramInt);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract void onDestroy();
    
    public abstract void pause();
    
    public abstract void v(int paramInt, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoMongoliaRelativeLayout
 * JD-Core Version:    0.7.0.1
 */