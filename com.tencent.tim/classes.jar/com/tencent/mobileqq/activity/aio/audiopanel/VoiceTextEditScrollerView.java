package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import ankt;
import anot;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import wql;
import wqm;
import wqr;

public class VoiceTextEditScrollerView
  extends RelativeLayout
{
  private final String TAG = "VoiceTextEditPanel";
  private wqr a;
  private boolean aAb;
  private int aXn;
  private int bQF = -1;
  private int bQG = -1;
  private boolean bfq;
  private boolean bfr = true;
  private boolean bfs;
  private Context mContext;
  private int mLastTop = -1;
  private float mLastY;
  private int mMaxHeight;
  private float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private float pV;
  private float pW;
  private float pX;
  private float pY;
  
  public VoiceTextEditScrollerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoiceTextEditScrollerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    paramContext = ViewConfiguration.get(this.mContext);
    this.aXn = paramContext.getScaledMaximumFlingVelocity();
    this.mTouchSlop = (paramContext.getScaledTouchSlop() * 2);
    paramContext = (WindowManager)this.mContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  private void a(ValueAnimator paramValueAnimator, int paramInt1, int paramInt2, View paramView)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = paramValueAnimator.getAnimatedFraction();
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 - paramInt2 * f2), 1073741824));
    paramView.layout(getLeft(), (int)f1, getRight(), (int)f1 + (int)(paramInt1 - f2 * paramInt2));
  }
  
  private void addMovement(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void caU()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.aXn);
    this.pV = this.mVelocityTracker.getYVelocity();
  }
  
  private void caV()
  {
    if (this.bfr)
    {
      if (this.a != null) {
        this.a.hideSoftInput();
      }
      this.bfr = false;
    }
  }
  
  private boolean g(float paramFloat)
  {
    paramFloat = t(paramFloat);
    return (this.pY > 2000.0F) || (paramFloat > ankt.dip2px(150.0F)) || (!this.aAb);
  }
  
  private void handleActionMove(MotionEvent paramMotionEvent)
  {
    float f1 = Math.abs(paramMotionEvent.getRawX() - this.pW);
    float f2 = Math.abs(paramMotionEvent.getRawY() - this.pX);
    int i;
    int j;
    int k;
    if ((f1 > this.mTouchSlop) || (f2 > this.mTouchSlop))
    {
      this.aAb = true;
      if (f2 > 3.0F * this.mTouchSlop) {
        caV();
      }
      i = (int)(paramMotionEvent.getRawY() - this.mLastY);
      j = getTop() + i;
      k = getBottom();
      if (j >= this.mLastTop) {
        break label102;
      }
    }
    label102:
    while (j >= this.mMaxHeight - XPanelContainer.aLe - this.bQF) {
      return;
    }
    setTop(j);
    setBottom(i + k);
    this.pY = this.pV;
    this.mLastY = paramMotionEvent.getRawY();
  }
  
  private float t(float paramFloat)
  {
    return paramFloat - this.pX;
  }
  
  public void Cz(int paramInt)
  {
    int i = XPanelContainer.aLe;
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextEditPanel", 2, "ACTION_DOWN mExternalPanelheight = " + XPanelContainer.aLe + " getHeight()=" + getHeight());
    }
    int j = getHeight();
    int k = getHeight();
    if (this.a != null) {
      this.a.at(this.mMaxHeight - i - paramInt, j - i, k);
    }
    if (!this.aAb)
    {
      if (this.bfs)
      {
        this.bfs = false;
        anot.a(null, "dc00898", "", "", "0X800A8A0", "0X800A8A0", 3, 0, "", "", "", "");
        return;
      }
      anot.a(null, "dc00898", "", "", "0X800A8A0", "0X800A8A0", 2, 0, "", "", "", "");
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800A8A0", "0X800A8A0", 1, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View paramView)
  {
    ValueAnimator localValueAnimator = ObjectAnimator.ofFloat(new float[] { paramInt1, paramInt2 }).setDuration(paramInt6);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new wql(this, paramInt4, paramInt3, paramView));
    localValueAnimator.start();
    localValueAnimator.addListener(new wqm(this, paramInt5));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bfq) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.bfq;
      this.bfr = true;
      this.pW = paramMotionEvent.getRawX();
      float f = paramMotionEvent.getRawY();
      this.pX = f;
      this.mLastY = f;
      this.pY = -1.0F;
      this.aAb = false;
      addMovement(paramMotionEvent);
      if (this.a != null)
      {
        this.a.Cy(this.mMaxHeight);
        continue;
        addMovement(paramMotionEvent);
        caU();
        handleActionMove(paramMotionEvent);
        continue;
        if (this.a != null)
        {
          caV();
          if (g(paramMotionEvent.getRawY()))
          {
            Cz(this.bQF);
          }
          else
          {
            int i = this.bQG;
            int j = this.bQF;
            this.a.fq(i - j, this.bQF);
          }
        }
      }
    }
  }
  
  public void setListener(wqr paramwqr)
  {
    this.a = paramwqr;
  }
  
  public void setMaskClick(boolean paramBoolean)
  {
    this.bfs = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
  
  public void setPanelActionDownPos(int paramInt1, int paramInt2)
  {
    this.bQF = paramInt1;
    this.bQG = paramInt2;
    this.mLastTop = getTop();
  }
  
  public void setSlideEnable(boolean paramBoolean)
  {
    this.bfq = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditScrollerView
 * JD-Core Version:    0.7.0.1
 */