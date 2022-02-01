package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import oug;

public class QCircleDoubleClickLayout
  extends FrameLayout
{
  private int DOUBLE_TAP_TIMEOUT = oug.bgg;
  private int TOUCH_SLOP;
  private a a;
  private boolean azJ = true;
  private boolean azK;
  private boolean azL;
  private MotionEvent b;
  private int bif;
  private int big;
  private MotionEvent c;
  private MotionEvent d;
  private Runnable dj = new QCircleDoubleClickLayout.1(this);
  private MotionEvent e;
  private int mDoubleTapSlopSquare;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private MotionEvent mPreviousUpEvent;
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QCircleDoubleClickLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void I(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private void J(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      super.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, paramMotionEvent.getX(), paramMotionEvent.getY(), 0));
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent1.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent1.getY();
    } while (i * i + j * j <= this.TOUCH_SLOP);
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    while (a(paramMotionEvent1, paramMotionEvent2)) {
      return false;
    }
    return true;
  }
  
  private void bkq()
  {
    if (b(this.b, this.c))
    {
      I(this.b);
      J(this.c);
      QLog.d("QCircleDoubleClickLayout", 1, "singleTap success");
      return;
    }
    QLog.d("QCircleDoubleClickLayout", 1, "singleTap error");
  }
  
  private void bkr()
  {
    if (this.e != null)
    {
      I(this.e);
      QLog.d("QCircleDoubleClickLayout", 4, "move success");
      return;
    }
    QLog.d("QCircleDoubleClickLayout", 4, "move error");
  }
  
  private void init()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.bif = localViewConfiguration.getScaledDoubleTapSlop();
    this.mDoubleTapSlopSquare = (this.bif * this.bif);
    this.TOUCH_SLOP = localViewConfiguration.getScaledTouchSlop();
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > this.DOUBLE_TAP_TIMEOUT) || (a(paramMotionEvent1, paramMotionEvent2)));
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= this.mDoubleTapSlopSquare);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.azJ)
    {
      QLog.d("QCircleDoubleClickLayout", 4, "not intercept");
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      QLog.d("QCircleDoubleClickLayout", 4, "event:" + paramMotionEvent.getAction() + " mIsRunnablePosting:" + this.azK);
      if (paramMotionEvent.getAction() == 0)
      {
        if (this.b == null)
        {
          this.b = MotionEvent.obtain(paramMotionEvent);
          this.big = 1;
          QLog.d("QCircleDoubleClickLayout", 4, "firstdown clickcount:" + this.big);
        }
        if ((this.big >= 1) && (isConsideredDoubleTap(this.d, this.mPreviousUpEvent, paramMotionEvent)))
        {
          this.big += 1;
          QLog.d("QCircleDoubleClickLayout", 4, "considerdown clickcount:" + this.big);
        }
        if (!this.azK)
        {
          this.mHandler.postDelayed(this.dj, oug.bgg);
          this.azK = true;
        }
        if (this.d != null) {
          this.d.recycle();
        }
        this.d = MotionEvent.obtain(paramMotionEvent);
      }
      while (!this.azK)
      {
        return super.dispatchTouchEvent(paramMotionEvent);
        if (paramMotionEvent.getAction() == 1)
        {
          if (this.azL)
          {
            this.azL = false;
            return super.dispatchTouchEvent(paramMotionEvent);
          }
          if (this.c == null) {
            this.c = MotionEvent.obtain(paramMotionEvent);
          }
          if (this.mPreviousUpEvent != null) {
            this.mPreviousUpEvent.recycle();
          }
          this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        }
        else if (paramMotionEvent.getAction() == 2)
        {
          if (this.e != null) {
            this.e.recycle();
          }
          this.e = MotionEvent.obtain(paramMotionEvent);
          if (a(this.d, this.e))
          {
            bkr();
            reset();
            this.azL = true;
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void reset()
  {
    this.azJ = true;
    this.big = 0;
    this.azK = false;
    this.b = null;
    this.c = null;
    this.d = null;
    this.mPreviousUpEvent = null;
    this.e = null;
    this.mHandler.removeCallbacks(this.dj);
  }
  
  public void setEnableDoubleClick(boolean paramBoolean)
  {
    this.azJ = paramBoolean;
  }
  
  public void setOnDoubleClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void biX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout
 * JD-Core Version:    0.7.0.1
 */