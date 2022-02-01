package com.tencent.biz.richframework.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import rxw;

public class RefreshHeaderView
  extends LinearLayout
{
  private long AK;
  private a a;
  private final String aDq = getResources().getString(2131720486);
  private final String aDr = getResources().getString(2131720482);
  private final String aDs = getResources().getString(2131720485);
  private final String aDt = getResources().getString(2131720483);
  private LinearLayout dE;
  private RotateAnimation j;
  private RotateAnimation k;
  private Handler mMainHandler;
  private int mMeasuredHeight;
  private ProgressBar mProgressBar;
  private Drawable mProgressDrawable;
  private boolean mRefreshing;
  private int mState;
  private ImageView nP;
  private float od;
  private float oe;
  private TextView zE;
  
  public RefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    this.dE = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131560949, null));
    addView(this.dE, new LinearLayout.LayoutParams(-1, 0));
    this.nP = ((ImageView)findViewById(2131369768));
    this.zE = ((TextView)findViewById(2131380889));
    this.mProgressBar = ((ProgressBar)findViewById(2131372948));
    this.j = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.j.setDuration(100L);
    this.j.setFillAfter(true);
    this.k = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.k.setDuration(100L);
    this.k.setFillAfter(true);
    measure(-2, -2);
    this.mMeasuredHeight = getMeasuredHeight();
    this.mProgressDrawable = getResources().getDrawable(2130839657);
  }
  
  private boolean isOnTop()
  {
    return getParent() != null;
  }
  
  private void jX(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { getVisibleHeight(), paramInt });
    localValueAnimator.setDuration(200L).start();
    localValueAnimator.addUpdateListener(new rxw(this, paramInt));
    localValueAnimator.start();
  }
  
  private void uq(boolean paramBoolean)
  {
    this.mProgressBar.setIndeterminate(paramBoolean);
    ProgressBar localProgressBar = this.mProgressBar;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  public boolean P(MotionEvent paramMotionEvent)
  {
    if (this.od == -1.0F) {
      this.od = paramMotionEvent.getRawY();
    }
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      this.od = -1.0F;
      if ((isOnTop()) && (!this.mRefreshing)) {
        onRelease();
      }
      break;
    }
    do
    {
      float f;
      do
      {
        for (;;)
        {
          return super.onTouchEvent(paramMotionEvent);
          this.od = paramMotionEvent.getRawY();
          this.oe = 0.0F;
        }
        f = (paramMotionEvent.getRawY() - this.od) / 2.0F;
        this.od = paramMotionEvent.getRawY();
        this.oe += f;
      } while ((!isOnTop()) || (this.mRefreshing));
      onMove(f, this.oe);
    } while (getVisibleHeight() <= 0);
    return false;
  }
  
  public void bxq()
  {
    long l = 1000L - this.AK;
    if (l > 0L)
    {
      getMainHandler().postDelayed(new RefreshHeaderView.1(this), l);
      return;
    }
    setState(3);
  }
  
  public Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public int getVisibleHeight()
  {
    return ((LinearLayout.LayoutParams)this.dE.getLayoutParams()).height;
  }
  
  public boolean mm()
  {
    return this.mRefreshing;
  }
  
  public void onDestroy()
  {
    if (getMainHandler() != null) {
      getMainHandler().removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mState == 1) {
      setState(2);
    }
  }
  
  public void onMove(float paramFloat1, float paramFloat2)
  {
    if ((getVisibleHeight() > 0) || (paramFloat1 > 0.0F))
    {
      setVisibleHeight((int)paramFloat1 + getVisibleHeight());
      if (this.mState <= 1)
      {
        if (getVisibleHeight() <= this.mMeasuredHeight) {
          break label48;
        }
        onPrepare();
      }
    }
    return;
    label48:
    onReset();
  }
  
  public void onPrepare()
  {
    setState(1);
  }
  
  public boolean onRelease()
  {
    int i = getVisibleHeight();
    if ((i != 0) || ((getVisibleHeight() > this.mMeasuredHeight) && (this.mState < 2))) {
      setState(2);
    }
    for (boolean bool = true;; bool = false)
    {
      if ((this.mState == 2) && (i > this.mMeasuredHeight)) {
        jX(this.mMeasuredHeight);
      }
      if (this.mState != 2) {
        jX(0);
      }
      if (this.mState == 2) {
        jX(this.mMeasuredHeight);
      }
      return bool;
    }
  }
  
  public void onReset()
  {
    setState(0);
  }
  
  public void setOnRefreshListener(a parama)
  {
    this.a = parama;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.mRefreshing = paramBoolean;
    if (!paramBoolean) {
      bxq();
    }
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == this.mState) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      QLog.d("RefreshHeaderView", 1, "state:" + paramInt);
      this.mState = paramInt;
      return;
      if (this.mState == 1) {
        this.nP.startAnimation(this.k);
      }
      if (this.mState == 2) {
        this.nP.clearAnimation();
      }
      this.zE.setText(this.aDt);
      continue;
      this.nP.setVisibility(0);
      uq(false);
      if (this.mState != 1)
      {
        this.nP.clearAnimation();
        this.nP.startAnimation(this.j);
        this.zE.setText(this.aDs);
        continue;
        this.AK = System.currentTimeMillis();
        this.nP.clearAnimation();
        this.nP.setVisibility(8);
        uq(true);
        jX(this.mMeasuredHeight);
        this.zE.setText(this.aDr);
        if (this.a != null)
        {
          this.a.onRefresh();
          continue;
          this.nP.setVisibility(8);
          uq(false);
          this.zE.setText(this.aDq);
          jX(0);
        }
      }
    }
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.dE.getLayoutParams();
    localLayoutParams.height = i;
    this.dE.setLayoutParams(localLayoutParams);
  }
  
  public static abstract interface a
  {
    public abstract void onRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.RefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */