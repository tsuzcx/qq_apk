package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kwz;
import mqq.os.MqqHandler;
import nco;
import ncp;

public class CaptureOperateTouchLayout
  extends FrameLayout
{
  private static int NONE = -1;
  public static int aXG = 200;
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$c;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
  private int aXH;
  private int aXI;
  private int aXJ = NONE;
  private int aXK = NONE;
  private boolean ark;
  private float currentProgress;
  private long duration;
  private MqqHandler g;
  private ImageView gd;
  private float kl = NONE;
  private TextView qQ;
  private TextView sK;
  private Scroller scroller = new Scroller(BaseApplication.getContext());
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CaptureOperateTouchLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int a(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, b(paramFloat, paramBoolean)), this.duration);
  }
  
  private void aVz()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$c != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$c.rX(qv());
    }
  }
  
  private void af(int paramInt, boolean paramBoolean)
  {
    int i = getWidth();
    int j = this.gd.getWidth();
    b(paramInt / (i - j), paramBoolean);
  }
  
  private float al()
  {
    return ((View)this.gd.getParent()).getRight() - this.gd.getWidth();
  }
  
  private int b(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (int)((paramFloat - this.kl) * this.aXK + this.aXJ);
    }
    return (int)((float)this.duration * paramFloat) / 1000 * 1000;
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getRawX() >= this.gd.getX()) && (paramMotionEvent.getRawX() <= this.gd.getX() + this.gd.getWidth())) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    af((int)(paramMotionEvent.getRawX() - this.gd.getWidth() / 3), false);
  }
  
  private void init()
  {
    this.g = ThreadManager.getUIHandler();
  }
  
  private int k(float paramFloat)
  {
    return (int)(this.aXI * paramFloat);
  }
  
  public float ak()
  {
    return this.currentProgress;
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    float f = (getWidth() - this.gd.getWidth()) * paramFloat;
    this.currentProgress = paramFloat;
    this.aXH = a(paramFloat, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureOperateTouchLayout", 2, "onIndicatorChange percent:" + paramFloat + " progressX:" + f + " duration:" + this.duration + " videoSeekPosition:" + this.aXH + " longPressStartVideoSeekPercent:" + this.kl);
    }
    int i = (this.gd.getWidth() - this.sK.getWidth()) / 2;
    this.gd.setX(f);
    this.sK.setX(f + i);
    this.sK.setText(kwz.ba(this.aXH / 1000));
    aVz();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.scroller.computeScrollOffset())
    {
      b(this.scroller.getCurrX() / al(), this.ark);
      invalidate();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getAction() == 0) {
      f(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public int qv()
  {
    return this.aXH;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setOnCaptureOperateCallback(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$c = paramc;
  }
  
  public void setup(ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    this.gd = paramImageView;
    this.sK = paramTextView1;
    this.qQ = paramTextView2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = paramVideoMeasureScaleView;
    this.aXI = paramInt;
    this.aXK = (aXG * paramInt);
    paramImageView.setOnTouchListener(new b(new nco(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
  
  public static abstract interface a
  {
    public abstract void aVA();
    
    public abstract void aVB();
    
    public abstract void aVC();
    
    public abstract void ps(boolean paramBoolean);
  }
  
  public class b
    implements View.OnTouchListener
  {
    private CaptureOperateTouchLayout.a a;
    private Runnable cM = new CaptureOperateTouchLayout.IndicatorTouchListener.2(this);
    private float ji;
    private float jj;
    private float km;
    private float kn;
    private float ko;
    private float kp;
    private float lastX;
    private Runnable runnable = new CaptureOperateTouchLayout.IndicatorTouchListener.1(this);
    
    public b(CaptureOperateTouchLayout.a parama)
    {
      this.a = parama;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        this.lastX = paramMotionEvent.getRawX();
        return true;
        this.km = paramView.getX();
        this.kn = paramView.getY();
        this.ji = paramMotionEvent.getRawX();
        this.jj = paramMotionEvent.getRawY();
        this.ko = paramView.getX();
        this.kp = paramView.getY();
        CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this, false);
        CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).setFinalX((int)CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).getX());
        CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).postDelayed(this.cM, 300L);
        CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).postDelayed(this.runnable, 1000L);
        continue;
        if (CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this))
        {
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this, false);
          int i = (int)(Math.abs(paramView.getX() - this.ko) / CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this) * 400.0F);
          ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramView.getScrollX(), this.ko }).setDuration(i);
          localValueAnimator.addUpdateListener(new ncp(this, paramView));
          localValueAnimator.start();
          this.a.ps(true);
        }
        for (;;)
        {
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).abortAnimation();
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this, CaptureOperateTouchLayout.NONE);
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this, CaptureOperateTouchLayout.NONE);
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).removeCallbacks(this.runnable);
          CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this).removeCallbacks(this.cM);
          break;
          this.a.ps(false);
        }
        float f2 = this.km;
        float f3 = paramMotionEvent.getRawX();
        float f4 = this.ji;
        float f1 = CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this);
        f2 = Math.min(Math.max(f2 + (f3 - f4), 0.0F), f1);
        paramView.setX(f2);
        f1 = f2 / f1;
        CaptureOperateTouchLayout.this.b(f1, CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this));
        if ((!CaptureOperateTouchLayout.a(CaptureOperateTouchLayout.this)) && ((Math.abs(this.ko - paramView.getX()) > 10.0F) || (Math.abs(this.kp - paramView.getY()) > 10.0F)))
        {
          this.ko = paramView.getX();
          this.kp = paramView.getY();
          ThreadManager.getUIHandler().removeCallbacks(this.cM);
          ThreadManager.getUIHandler().removeCallbacks(this.runnable);
          ThreadManager.getUIHandler().postDelayed(this.cM, 300L);
          ThreadManager.getUIHandler().postDelayed(this.runnable, 1000L);
          this.a.aVC();
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void aPT();
    
    public abstract void cR(int paramInt1, int paramInt2);
    
    public abstract void rX(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */