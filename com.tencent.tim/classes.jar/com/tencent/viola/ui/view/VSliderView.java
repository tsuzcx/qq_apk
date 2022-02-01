package com.tencent.viola.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.viola.ui.adapter.VLoopAbleSliderAdapter;
import com.tencent.viola.ui.component.VSlider;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class VSliderView
  extends ViewPager
  implements IVView<VSlider>
{
  public static final String TAG = "VSliderView";
  private VLoopAbleSliderAdapter mAdapter;
  private AutoSidleTimer mAutoSidleTimer;
  public int mCurrentItemIndex = 0;
  private Boolean mIsAutoMode = Boolean.valueOf(true);
  private boolean mIsScrollable;
  private VSliderListener mListener;
  private ViewPager.OnPageChangeListener mPageChangeListener;
  private float mStartRawX = -1.0F;
  private float mStartRawY = -1.0F;
  private int mTimeInterval = 2000;
  protected int mTouchSlop;
  private WeakReference<VSlider> mWeakReference;
  
  public VSliderView(Context paramContext, VLoopAbleSliderAdapter paramVLoopAbleSliderAdapter)
  {
    super(paramContext);
    setAdapter(paramVLoopAbleSliderAdapter);
    if (paramVLoopAbleSliderAdapter != null)
    {
      this.mAdapter = paramVLoopAbleSliderAdapter;
      setOffscreenPageLimit(2);
    }
    if ((this.mIsAutoMode.booleanValue()) && (this.mAutoSidleTimer == null)) {
      this.mAutoSidleTimer = new AutoSidleTimer(this);
    }
    this.mPageChangeListener = new VSliderView.1(this);
    setOnPageChangeListener(this.mPageChangeListener);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void setCurrentItemInMode()
  {
    if ((this.mIsAutoMode.booleanValue()) && (this.mAdapter != null) && (this.mAutoSidleTimer != null) && (this.mIsScrollable))
    {
      this.mCurrentItemIndex += 1;
      if (this.mCurrentItemIndex == this.mAdapter.getCount()) {
        this.mCurrentItemIndex = 0;
      }
      setCurrentItem(this.mCurrentItemIndex);
      ViolaLogUtils.i("VSliderView", "定时器setItem");
    }
  }
  
  public void bindComponent(VSlider paramVSlider)
  {
    this.mWeakReference = new WeakReference(paramVSlider);
  }
  
  public void destroy()
  {
    if (this.mPageChangeListener != null) {
      this.mPageChangeListener = null;
    }
    if (this.mAutoSidleTimer != null)
    {
      stopPlay();
      this.mAutoSidleTimer.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      stopPlay();
      continue;
      startPlay();
    }
  }
  
  public VSlider getComponent()
  {
    if (this.mWeakReference != null) {
      return (VSlider)this.mWeakReference.get();
    }
    return null;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mFirstLayout");
      localField.setAccessible(true);
      localField.set(this, Boolean.valueOf(false));
      startPlay();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mAutoSidleTimer != null)
    {
      stopPlay();
      this.mAutoSidleTimer.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsScrollable) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    ViewParent localViewParent = getParent();
    switch (i)
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      this.mStartRawY = paramMotionEvent.getRawY();
      this.mStartRawX = paramMotionEvent.getRawX();
      continue;
      float f3 = paramMotionEvent.getRawY();
      float f1 = paramMotionEvent.getRawX();
      float f2 = this.mStartRawX;
      f3 -= this.mStartRawY;
      if ((Math.abs(f3) > this.mTouchSlop) && (Math.abs(f1 - f2) / Math.abs(f3) < 0.5F) && (localViewParent != null))
      {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
      else if (localViewParent != null)
      {
        localViewParent.requestDisallowInterceptTouchEvent(true);
        continue;
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsScrollable) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsAutoMode(boolean paramBoolean)
  {
    this.mIsAutoMode = Boolean.valueOf(paramBoolean);
    startPlay();
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.mIsScrollable = paramBoolean;
  }
  
  public void setSliderListener(VSliderListener paramVSliderListener)
  {
    this.mListener = paramVSliderListener;
  }
  
  public void setStartIndexWithNoAnimate(int paramInt)
  {
    if (this.mAdapter == null) {
      return;
    }
    paramInt = this.mAdapter.getInitPosition() + paramInt;
    setCurrentItem(paramInt, false);
    this.mCurrentItemIndex = paramInt;
  }
  
  public void setStartItemIndex(int paramInt)
  {
    if (this.mAdapter == null) {
      return;
    }
    paramInt = this.mAdapter.getInitPosition() + paramInt;
    setCurrentItem(paramInt);
    this.mCurrentItemIndex = paramInt;
  }
  
  public void setTimeInterval(int paramInt)
  {
    this.mTimeInterval = paramInt;
  }
  
  public void startPlay()
  {
    if (this.mAdapter == null) {}
    while (!this.mIsAutoMode.booleanValue()) {
      return;
    }
    if (this.mAutoSidleTimer == null)
    {
      this.mAutoSidleTimer = new AutoSidleTimer(this);
      this.mAutoSidleTimer.startTimer(this.mTimeInterval);
      return;
    }
    this.mAutoSidleTimer.startTimer(this.mTimeInterval);
  }
  
  public void stopPlay()
  {
    if ((this.mAdapter == null) || (this.mAdapter.getCount() <= 1)) {}
    while ((!this.mIsAutoMode.booleanValue()) || (this.mAutoSidleTimer == null)) {
      return;
    }
    this.mAutoSidleTimer.stopTimer();
  }
  
  class AutoSidleTimer
    extends Handler
    implements Runnable
  {
    private WeakReference<VSliderView> mSliderViewPagerWeakReference;
    
    public AutoSidleTimer(VSliderView paramVSliderView)
    {
      super();
      this.mSliderViewPagerWeakReference = new WeakReference(paramVSliderView);
    }
    
    public void post()
    {
      postDelayed(0);
    }
    
    public void postDelayed(int paramInt)
    {
      if (paramInt == 0)
      {
        post(this);
        return;
      }
      postDelayed(this, paramInt);
    }
    
    public void run()
    {
      if ((VSliderView.this.isShown()) && (this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null))
      {
        ((VSliderView)this.mSliderViewPagerWeakReference.get()).setCurrentItemInMode();
        postDelayed(VSliderView.this.mTimeInterval);
      }
    }
    
    public void startTimer(int paramInt)
    {
      if ((this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null))
      {
        removeCallbacks(this);
        postDelayed(paramInt);
      }
    }
    
    public void stopTimer()
    {
      if ((this.mSliderViewPagerWeakReference != null) && (this.mSliderViewPagerWeakReference.get() != null)) {
        removeCallbacks(this);
      }
    }
  }
  
  public static abstract interface VSliderListener
  {
    public abstract void change(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSliderView
 * JD-Core Version:    0.7.0.1
 */