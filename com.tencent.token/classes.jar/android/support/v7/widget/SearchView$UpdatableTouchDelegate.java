package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

class SearchView$UpdatableTouchDelegate
  extends TouchDelegate
{
  private final Rect mActualBounds;
  private boolean mDelegateTargeted;
  private final View mDelegateView;
  private final int mSlop;
  private final Rect mSlopBounds;
  private final Rect mTargetBounds;
  
  public SearchView$UpdatableTouchDelegate(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    this.mSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTargetBounds = new Rect();
    this.mSlopBounds = new Rect();
    this.mActualBounds = new Rect();
    setBounds(paramRect1, paramRect2);
    this.mDelegateView = paramView;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 1;
    boolean bool2 = false;
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    boolean bool1;
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
      i = j;
      label57:
      if (bool1)
      {
        if ((i == 0) || (this.mActualBounds.contains(k, m))) {
          break label206;
        }
        paramMotionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.mDelegateView.dispatchTouchEvent(paramMotionEvent);
      return bool2;
      if (!this.mTargetBounds.contains(k, m)) {
        break;
      }
      this.mDelegateTargeted = true;
      bool1 = true;
      i = j;
      break label57;
      boolean bool3 = this.mDelegateTargeted;
      i = j;
      bool1 = bool3;
      if (!bool3) {
        break label57;
      }
      i = j;
      bool1 = bool3;
      if (this.mSlopBounds.contains(k, m)) {
        break label57;
      }
      i = 0;
      bool1 = bool3;
      break label57;
      bool1 = this.mDelegateTargeted;
      this.mDelegateTargeted = false;
      i = j;
      break label57;
      label206:
      paramMotionEvent.setLocation(k - this.mActualBounds.left, m - this.mActualBounds.top);
    }
  }
  
  public void setBounds(Rect paramRect1, Rect paramRect2)
  {
    this.mTargetBounds.set(paramRect1);
    this.mSlopBounds.set(paramRect1);
    this.mSlopBounds.inset(-this.mSlop, -this.mSlop);
    this.mActualBounds.set(paramRect2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.SearchView.UpdatableTouchDelegate
 * JD-Core Version:    0.7.0.1
 */