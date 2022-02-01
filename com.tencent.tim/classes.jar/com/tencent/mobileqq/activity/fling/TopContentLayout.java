package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class TopContentLayout
  extends RelativeLayout
{
  private OnOutScreenListener a;
  private ContentWrapView b;
  private boolean bqP;
  private GestureDetector f;
  private Scroller mScroller;
  
  public TopContentLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.f = new GestureDetector(paramContext, new a(paramContext));
    this.mScroller = new Scroller(paramContext);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      int i = this.mScroller.getCurrX();
      int j = this.mScroller.getCurrY();
      movingViewTrans(i, j);
      if (this.a != null) {
        this.a.outing(i, j, this);
      }
      invalidate();
    }
  }
  
  public float getMovingViewTransX()
  {
    if (this.b != null) {
      return this.b.getTransX();
    }
    return 0.0F;
  }
  
  public int getMovingViewWidth()
  {
    if (this.b != null) {
      return this.b.getWidth();
    }
    return getWidth();
  }
  
  public OnOutScreenListener getOnOutScreenListener()
  {
    return this.a;
  }
  
  public void movingViewTrans(float paramFloat1, float paramFloat2)
  {
    if (this.b != null)
    {
      this.b.transX(paramFloat1);
      this.b.transY(paramFloat2);
    }
  }
  
  public void movingViewTransBy(float paramFloat1, float paramFloat2)
  {
    if (this.b != null)
    {
      this.b.transXBy(paramFloat1);
      this.b.transYBy(paramFloat2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.f.onTouchEvent(paramMotionEvent);
    int i;
    int j;
    if ((paramMotionEvent.getAction() == 1) && (this.bqP))
    {
      this.bqP = false;
      i = getMovingViewWidth();
      j = (int)Math.abs(getMovingViewTransX());
      if (j <= i / 2) {
        break label80;
      }
      i -= j;
    }
    for (;;)
    {
      this.mScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
      return bool;
      label80:
      i = -j;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    this.f.onTouchEvent(paramMotionEvent);
    int j;
    if ((i == 1) && (this.bqP))
    {
      this.bqP = false;
      i = getMovingViewWidth();
      j = (int)Math.abs(getMovingViewTransX());
      if (j <= i / 2) {
        break label80;
      }
      i -= j;
    }
    for (;;)
    {
      this.mScroller.startScroll((int)getMovingViewTransX(), 0, i, 0, 350);
      invalidate();
      return true;
      label80:
      i = -j;
    }
  }
  
  public void setContent(ContentWrapView paramContentWrapView)
  {
    if (this.b != null) {
      removeView(this.b);
    }
    this.b = paramContentWrapView;
    addView(this.b);
  }
  
  public void setOnOutScreenListener(OnOutScreenListener paramOnOutScreenListener)
  {
    this.a = paramOnOutScreenListener;
  }
  
  public static abstract interface OnOutScreenListener
  {
    public abstract void outing(int paramInt1, int paramInt2, View paramView);
    
    public abstract void startDrag();
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private float qY;
    
    public a(Context paramContext)
    {
      this.qY = TypedValue.applyDimension(1, 50.0F, paramContext.getResources().getDisplayMetrics());
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i;
      int j;
      if (TopContentLayout.a(TopContentLayout.this))
      {
        TopContentLayout.a(TopContentLayout.this, false);
        i = TopContentLayout.this.getWidth();
        j = Math.abs((int)TopContentLayout.this.getMovingViewTransX());
        if (paramFloat1 <= 0.0F) {
          break label96;
        }
        i -= j;
      }
      for (;;)
      {
        TopContentLayout.a(TopContentLayout.this).startScroll((int)TopContentLayout.this.getMovingViewTransX(), 0, i, 0, 350);
        TopContentLayout.this.invalidate();
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label96:
        i = -j;
      }
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f1;
      if (!TopContentLayout.a(TopContentLayout.this))
      {
        f1 = Math.abs(paramFloat2 / paramFloat1);
        float f2 = Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX());
        if ((paramFloat1 < 0.0F) && (f1 < 0.5F) && (f2 > this.qY))
        {
          TopContentLayout.a(TopContentLayout.this, true);
          if (TopContentLayout.a(TopContentLayout.this) != null) {
            TopContentLayout.a(TopContentLayout.this).startDrag();
          }
          return true;
        }
        f1 = paramFloat1;
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, f1, paramFloat2);
      }
      int i = TopContentLayout.this.getMovingViewWidth();
      int j = Math.abs((int)TopContentLayout.this.getMovingViewTransX());
      if ((paramFloat1 < 0.0F) && (j < i)) {
        if (Math.abs(paramFloat1) > i - j) {
          paramFloat1 = i - j;
        }
      }
      for (;;)
      {
        f1 = paramFloat1;
        if (Math.abs(paramFloat1) <= 0.0F) {
          break;
        }
        TopContentLayout.this.movingViewTransBy((int)paramFloat1, 0.0F);
        f1 = paramFloat1;
        if (TopContentLayout.a(TopContentLayout.this) == null) {
          break;
        }
        TopContentLayout.a(TopContentLayout.this).outing((int)TopContentLayout.this.getMovingViewTransX(), 0, TopContentLayout.this);
        f1 = paramFloat1;
        break;
        paramFloat1 = -paramFloat1;
        continue;
        if ((paramFloat1 > 0.0F) && (j > 0))
        {
          if (Math.abs(paramFloat1) > j) {
            paramFloat1 = -j;
          } else {
            paramFloat1 = -paramFloat1;
          }
        }
        else {
          paramFloat1 = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopContentLayout
 * JD-Core Version:    0.7.0.1
 */