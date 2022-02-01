package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class WorkSpaceView
  extends FrameLayout
{
  private static final double bs = Math.tan(Math.toRadians(30.0D));
  private a a;
  private boolean aKZ;
  private int bww = -1;
  private int mCurrentScreen = 0;
  private Handler mHandler;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller = new Scroller(getContext());
  private int mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private int mTouchState = 0;
  private VelocityTracker mVelocityTracker;
  
  public WorkSpaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WorkSpaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void snapToDestination()
  {
    int i = getWidth();
    snapToScreen((getScrollX() + i / 2) / i);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    while (this.bww == -1) {
      return;
    }
    this.mCurrentScreen = Math.max(0, Math.min(this.bww, getChildCount() - 1));
    this.bww = -1;
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (paramInt == 17)
    {
      if (getCurrentScreen() > 0)
      {
        snapToScreen(getCurrentScreen() - 1);
        return true;
      }
    }
    else if ((paramInt == 66) && (getCurrentScreen() < getChildCount() - 1))
    {
      snapToScreen(getCurrentScreen() + 1);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.mCurrentScreen;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.mTouchState != 0)
    {
      return true;
      int k = (int)Math.abs(f1 - this.mLastMotionX);
      int m = (int)Math.abs(f2 - this.mLastMotionY);
      int j = this.mTouchSlop;
      if (k > j)
      {
        i = 1;
        label103:
        if (m <= j) {
          break label181;
        }
      }
      label181:
      for (j = 1;; j = 0)
      {
        double d = m / k;
        if (((i == 0) && (j == 0)) || (d >= bs)) {
          break;
        }
        if (i != 0) {
          this.mTouchState = 1;
        }
        if (!this.aKZ) {
          break;
        }
        this.aKZ = false;
        getChildAt(this.mCurrentScreen).cancelLongPress();
        break;
        i = 0;
        break label103;
      }
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      this.aKZ = true;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.mTouchState = i;
        break;
      }
      this.mTouchState = 0;
      this.aKZ = false;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          do
          {
            return true;
            if (!this.mScroller.isFinished()) {
              this.mScroller.abortAnimation();
            }
            this.mLastMotionX = f;
            this.mTouchState = 1;
            return true;
          } while (this.mTouchState != 1);
          i = (int)(this.mLastMotionX - f);
          this.mLastMotionX = f;
          j = getScrollX();
          if (i >= 0) {
            break;
          }
        } while (j <= 0);
        scrollBy(Math.max(-j, i), 0);
        return true;
      } while (i <= 0);
      int j = getChildAt(getChildCount() - 1).getRight() - j - getWidth();
      if (j > 0) {
        scrollBy(Math.min(j, i), 0);
      }
      paramMotionEvent = Message.obtain();
      paramMotionEvent.what = 0;
      this.mHandler.sendMessage(paramMotionEvent);
      return true;
    }
    if (this.mTouchState == 1)
    {
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      i = (int)paramMotionEvent.getXVelocity();
      if ((i <= 500) || (this.mCurrentScreen <= 0)) {
        break label284;
      }
      snapToScreen(this.mCurrentScreen - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.mTouchState = 0;
      return true;
      label284:
      if ((i < -500) && (this.mCurrentScreen < getChildCount() - 1)) {
        snapToScreen(this.mCurrentScreen + 1);
      } else {
        snapToDestination();
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    paramView1 = new Rect();
    paramView2.getDrawingRect(paramView1);
    paramView2.requestRectangleOnScreen(paramView1);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return (indexOfChild(paramView) != this.mCurrentScreen) || (!this.mScroller.isFinished());
  }
  
  public void setAllowLongPress(boolean paramBoolean)
  {
    this.aKZ = paramBoolean;
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public void setOnScreenChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void snapToScreen(int paramInt)
  {
    if (!this.mScroller.isFinished()) {
      return;
    }
    yq(paramInt);
  }
  
  public void yq(int paramInt)
  {
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.mCurrentScreen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.bww = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.mCurrentScreen))) {
        localView.clearFocus();
      }
      paramInt = getWidth() * i - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt) * 2);
      if (this.a != null) {
        this.a.cJ(i);
      }
      invalidate();
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */