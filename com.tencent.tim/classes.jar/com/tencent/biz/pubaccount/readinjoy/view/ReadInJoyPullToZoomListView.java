package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import ngz;

public class ReadInJoyPullToZoomListView
  extends ReadInJoyBaseListView
{
  private static boolean DEBUG;
  private static final Interpolator sInterpolator = new ngz();
  private ScalingRunnalable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$a;
  private int aYA;
  private int aYB;
  protected int aYC;
  private boolean afL;
  private FrameLayout ao;
  boolean asa;
  float kt = -1.0F;
  float ku = 1.235F;
  float mLastTouchY = -1.0F;
  float mMaxScale = 1.401F;
  private View mt;
  private TextView ta;
  private TextView tb;
  
  public ReadInJoyPullToZoomListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyPullToZoomListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aDz()
  {
    int i;
    int j;
    if ((this.ao != null) && (this.mt != null) && (this.ao.getBottom() > 0) && (this.mt.getBottom() > 0))
    {
      i = this.ao.getBottom();
      j = this.mt.getBottom();
      if (i > j) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      if (bool != this.afL)
      {
        this.afL = bool;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$a.mm(this.afL);
          if (QLog.isColorLevel()) {
            QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "checkIsTopFixed(): mFixed=" + this.afL);
          }
        }
      }
      if ((QLog.isColorLevel()) && (DEBUG)) {
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "checkIsTopFixed(): titleBarBottom=" + j + "， headerBottom=" + i + "， fixed = " + bool + ", mTopFixed=" + this.afL);
      }
      return;
    }
  }
  
  private void aWS()
  {
    if (this.ta == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(-1);
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = aqcx.dip2px(getContext(), 52.0F);
      this.ao.addView(localTextView, localLayoutParams);
      this.ta = localTextView;
    }
  }
  
  private void aWT()
  {
    if (this.tb == null)
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setTextColor(1728053247);
      localTextView.setTextSize(1, 12.0F);
      localTextView.setGravity(17);
      localTextView.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = aqcx.dip2px(getContext(), 58.0F);
      this.ao.addView(localTextView, localLayoutParams);
      this.tb = localTextView;
    }
  }
  
  private void aWU()
  {
    if ((this.ta != null) && (this.ta.getVisibility() == 8))
    {
      this.ta.setVisibility(0);
      Drawable localDrawable = getResources().getDrawable(2130839655);
      this.ta.setCompoundDrawablePadding(10);
      this.ta.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      ((Animatable)localDrawable).start();
    }
  }
  
  private void aWV()
  {
    if (this.ta != null) {
      this.ta.setVisibility(8);
    }
  }
  
  private void aWW()
  {
    if (this.tb != null) {
      this.tb.setVisibility(8);
    }
  }
  
  private void aWX()
  {
    if (this.asa)
    {
      pC(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.startAnimation(300L);
  }
  
  private void dc(View paramView)
  {
    if (this.ao == null)
    {
      this.ao = new FrameLayout(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.ao.addView(paramView, localLayoutParams);
    }
    aWS();
    aWT();
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
  }
  
  private void pC(boolean paramBoolean)
  {
    aWU();
    ReadInJoyBaseListView.c localc;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c != null)
    {
      localc = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$c;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 1;; i = 0)
    {
      localc.a(this, i);
      return;
    }
  }
  
  private void reset()
  {
    this.mLastTouchY = -1.0F;
    this.kt = -1.0F;
    this.asa = false;
  }
  
  public void addHeaderView(View paramView)
  {
    dc(paramView);
    super.addHeaderView(this.ao);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    dc(paramView);
    super.addHeaderView(this.ao, paramObject, paramBoolean);
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.init(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable = new ScalingRunnalable();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    aDz();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    aDz();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.aYC = ((int)paramMotionEvent.getRawY());
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.mIsFinished) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$ScalingRunnalable.abortAnimation();
      }
      this.mLastTouchY = paramMotionEvent.getY();
      this.kt = (this.ao.getBottom() / this.aYA);
      if ((QLog.isColorLevel()) && (DEBUG))
      {
        QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_DOWN ==>  mLastScale = " + this.kt + "， mHeaderMaxHeight = " + this.aYB);
        continue;
        this.aYh = ((int)paramMotionEvent.getRawY() - this.aYC);
        if (this.mLastTouchY == -1.0F) {
          this.mLastTouchY = paramMotionEvent.getY();
        }
        if (this.ao.getBottom() >= this.aYA)
        {
          ViewGroup.LayoutParams localLayoutParams = this.ao.getLayoutParams();
          float f = ((paramMotionEvent.getY() - this.mLastTouchY + this.ao.getBottom()) / this.aYA - this.kt) / 2.0F + this.kt;
          if ((this.kt <= 1.0D) && (f < this.kt))
          {
            localLayoutParams.height = this.aYA;
            this.ao.setLayoutParams(localLayoutParams);
            return super.onTouchEvent(paramMotionEvent);
          }
          this.kt = Math.min(Math.max(f, 1.0F), this.mMaxScale);
          localLayoutParams.height = ((int)(this.aYA * this.kt));
          if (localLayoutParams.height <= this.aYB) {
            this.ao.setLayoutParams(localLayoutParams);
          }
          if (this.kt >= this.ku) {
            aWU();
          }
          for (this.asa = true;; this.asa = false)
          {
            if ((QLog.isColorLevel()) && (DEBUG)) {
              QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_MOVE, f = " + f + ", mLastScale=" + this.kt + ", mEnterRefreshDefer=" + this.asa);
            }
            this.mLastTouchY = paramMotionEvent.getY();
            return true;
            aWV();
          }
        }
        this.mLastTouchY = paramMotionEvent.getY();
        continue;
        if ((QLog.isColorLevel()) && (DEBUG)) {
          QLog.i("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_UP <=====  mEnterRefreshDefer=" + this.asa);
        }
        aWX();
        reset();
        continue;
        this.mLastTouchY = paramMotionEvent.getY();
        if ((QLog.isColorLevel()) && (DEBUG)) {
          QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "onTouchEvent(): ACTION_CANCEL xxxx");
        }
      }
    }
  }
  
  public void setHeaderViewSize(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = this.ao.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new AbsListView.LayoutParams(paramInt1, paramInt2);
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.ao.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.aYA = paramInt2;
    this.aYB = ((int)(this.aYA * this.mMaxScale));
  }
  
  public void setOnTopCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyPullToZoomListView$a = parama;
  }
  
  class ScalingRunnalable
    implements Runnable
  {
    long mDuration;
    boolean mIsFinished = true;
    float mScale;
    long mStartTime;
    
    ScalingRunnalable() {}
    
    public void abortAnimation()
    {
      this.mIsFinished = true;
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.DEBUG)) {
        QLog.e("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# abortAnimation(): ");
      }
    }
    
    public void run()
    {
      ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this);
      float f1;
      float f2;
      if ((!this.mIsFinished) && (this.mScale > 1.0D))
      {
        f1 = ((float)AnimationUtils.currentAnimationTimeMillis() - (float)this.mStartTime) / (float)this.mDuration;
        f2 = this.mScale - (this.mScale - 1.0F) * ReadInJoyPullToZoomListView.sInterpolator.getInterpolation(f1);
        ViewGroup.LayoutParams localLayoutParams = ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this).getLayoutParams();
        if (f2 <= 1.0F) {
          break label173;
        }
        localLayoutParams.height = ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this);
        localLayoutParams.height = ((int)(ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this) * f2));
        ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this).setLayoutParams(localLayoutParams);
        ReadInJoyPullToZoomListView.this.post(this);
        if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.DEBUG)) {
          QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# runing...... f1 = " + f1 + ", f2=" + f2);
        }
      }
      return;
      label173:
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.DEBUG)) {
        QLog.w("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# run() end! f1 = " + f1 + ", f2=" + f2);
      }
      this.mIsFinished = true;
    }
    
    public void startAnimation(long paramLong)
    {
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mDuration = paramLong;
      this.mScale = (ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this).getBottom() / ReadInJoyPullToZoomListView.a(ReadInJoyPullToZoomListView.this));
      this.mIsFinished = false;
      ReadInJoyPullToZoomListView.this.post(this);
      if ((QLog.isColorLevel()) && (ReadInJoyPullToZoomListView.DEBUG)) {
        QLog.d("Q.readinjoy.video.PullToZoomListView", 2, "#ScalingRunnalable# startAnimation(): duration =" + paramLong + ", mScale=" + this.mScale);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void mm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyPullToZoomListView
 * JD-Core Version:    0.7.0.1
 */