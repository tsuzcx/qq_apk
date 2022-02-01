package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import arjv;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class WorkSpaceView
  extends FrameLayout
{
  private a b;
  private int bww = -2;
  boolean cZp = true;
  private boolean dbT = true;
  private boolean firstDown;
  private Handler handler = new arjv(this);
  public int mCurrentScreen = this.mDefaultScreen;
  private int mDefaultScreen;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
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
  
  private boolean mK(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < getChildCount());
  }
  
  private void snapToDestination()
  {
    int i = getWidth();
    snapToScreen((getScrollX() + i / 2) / i);
  }
  
  public void ch(int paramInt, boolean paramBoolean)
  {
    if (!this.mScroller.isFinished()) {
      return;
    }
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (i != this.mCurrentScreen) {}
    for (paramInt = 1;; paramInt = 0)
    {
      this.bww = i;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.mCurrentScreen))) {
        localView.clearFocus();
      }
      paramInt = getWidth();
      int j = getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt * i - j, 0, 400);
      if (this.b != null) {
        this.b.cJ(i);
      }
      invalidate();
      return;
    }
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    while (this.bww == -2) {
      return;
    }
    if (this.bww == -1)
    {
      this.mCurrentScreen = (getChildCount() - 1);
      scrollTo(this.mCurrentScreen * getWidth(), getScrollY());
    }
    for (;;)
    {
      this.bww = -2;
      return;
      if (this.bww == getChildCount())
      {
        this.mCurrentScreen = 0;
        scrollTo(0, getScrollY());
      }
      else
      {
        this.mCurrentScreen = Math.max(0, Math.min(this.bww, getChildCount() - 1));
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int k = 0;
    int m = 0;
    if ((this.mTouchState != 1) && (this.bww == -2)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if ((paramCanvas != null) && (getChildAt(this.mCurrentScreen) != null)) {
        drawChild(paramCanvas, getChildAt(this.mCurrentScreen), getDrawingTime());
      }
      return;
    }
    long l = getDrawingTime();
    int n = getWidth();
    float f = getScrollX() / n;
    boolean bool = this.cZp;
    int i1 = getChildCount();
    int j;
    if ((f < 0.0F) && (bool))
    {
      j = i1 - 1;
      k = 0;
      i = m;
    }
    for (;;)
    {
      if (mK(j))
      {
        if ((i != 0) || (k != 0)) {
          break label291;
        }
        m = i1 * n;
        paramCanvas.translate(-m, 0.0F);
        drawChild(paramCanvas, getChildAt(j), l);
        paramCanvas.translate(m, 0.0F);
      }
      for (;;)
      {
        if ((f == j) || (!mK(i))) {
          break label306;
        }
        if ((!bool) || (i != 0) || (k == 0)) {
          break label308;
        }
        j = i1 * n;
        paramCanvas.translate(j, 0.0F);
        drawChild(paramCanvas, getChildAt(i), l);
        paramCanvas.translate(-j, 0.0F);
        return;
        j = Math.min((int)f, i1 - 1);
        m = j + 1;
        if (!bool) {
          break label322;
        }
        i = k;
        if (i1 != 0) {
          i = m % i1;
        }
        k = 1;
        break;
        label291:
        drawChild(paramCanvas, getChildAt(j), l);
      }
      label306:
      break;
      label308:
      drawChild(paramCanvas, getChildAt(i), l);
      return;
      label322:
      k = 0;
      i = m;
    }
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
    int k = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (k)
    {
    default: 
      if (k == 0) {
        FrameHelperActivity.EO(false);
      }
      break;
    }
    for (;;)
    {
      if (this.mTouchState == 0) {
        break label236;
      }
      return true;
      int m = (int)Math.abs(f1 - this.mLastMotionX);
      int n = (int)Math.abs(f2 - this.mLastMotionY);
      int j = this.mTouchSlop;
      if (m > j)
      {
        i = 1;
        label108:
        if (n <= j) {
          break label150;
        }
      }
      label150:
      for (j = 1;; j = 0)
      {
        double d = n / m;
        if ((i == 0) && (j == 0)) {
          break label156;
        }
        this.mTouchState = 1;
        break;
        i = 0;
        break label108;
      }
      label156:
      this.mTouchState = 0;
      break;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      this.firstDown = true;
      if (this.mScroller.isFinished()) {}
      for (int i = 0;; i = 1)
      {
        this.mTouchState = i;
        break;
      }
      this.mTouchState = 0;
      break;
      if ((k == 1) || (k == 3)) {
        FrameHelperActivity.EO(true);
      }
    }
    label236:
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
    if (!this.dbT) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    label85:
    int k;
    switch (j)
    {
    default: 
    case 0: 
    case 2: 
      while (j == 0)
      {
        FrameHelperActivity.EO(false);
        return true;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.mLastMotionX = f;
        this.mTouchState = 1;
        continue;
        if (this.mTouchState == 1)
        {
          k = (int)(this.mLastMotionX - f);
          this.mLastMotionX = f;
          i = getScrollX();
          if (k < 0)
          {
            if (i > 0) {
              scrollBy(Math.max(-i, k), 0);
            } else if (i > -getWidth()) {
              scrollBy(k, 0);
            }
          }
          else if (k > 0)
          {
            int m = getChildCount();
            if (m <= 0) {
              break label376;
            }
            paramMotionEvent = getChildAt(m - 1);
            if (paramMotionEvent == null) {
              break label376;
            }
          }
        }
      }
    }
    label319:
    label376:
    for (int i = paramMotionEvent.getRight() - i; i > 0; i = 0)
    {
      scrollBy(Math.min(i, k), 0);
      break;
      if (this.mTouchState == 1)
      {
        paramMotionEvent = this.mVelocityTracker;
        paramMotionEvent.computeCurrentVelocity(1000);
        i = (int)paramMotionEvent.getXVelocity();
        if ((i <= 500) || (this.mCurrentScreen <= -1)) {
          break label319;
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
        break;
        if ((i < -500) && (this.mCurrentScreen < getChildCount())) {
          snapToScreen(this.mCurrentScreen + 1);
        } else {
          snapToDestination();
        }
      }
      if ((j != 1) && (j != 3)) {
        break label85;
      }
      FrameHelperActivity.EO(true);
      break label85;
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
    int i = indexOfChild(paramView);
    if ((i != this.mCurrentScreen) || (!this.mScroller.isFinished()))
    {
      snapToScreen(i);
      return true;
    }
    return false;
  }
  
  public void setCircle(boolean paramBoolean)
  {
    this.cZp = paramBoolean;
  }
  
  public void setOnScreenChangeListener(a parama)
  {
    this.b = parama;
  }
  
  public void snapToScreen(int paramInt)
  {
    int i = 1;
    if (!this.cZp) {
      ch(paramInt, true);
    }
    while (!this.mScroller.isFinished()) {
      return;
    }
    int j = Math.max(-1, Math.min(paramInt, getChildCount()));
    if (j != this.mCurrentScreen) {}
    for (paramInt = i;; paramInt = 0)
    {
      this.bww = j;
      View localView = getFocusedChild();
      if ((localView != null) && (paramInt != 0) && (localView == getChildAt(this.mCurrentScreen))) {
        localView.clearFocus();
      }
      paramInt = getWidth();
      i = getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt * j - i, 0, 400);
      if (this.b != null) {
        this.b.cJ(j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WorkSpaceView
 * JD-Core Version:    0.7.0.1
 */