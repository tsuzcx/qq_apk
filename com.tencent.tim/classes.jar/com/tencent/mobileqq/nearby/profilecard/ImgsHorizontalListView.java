package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import auup;
import com.tencent.widget.HorizontalListView;

public class ImgsHorizontalListView
  extends HorizontalListView
{
  public View Fd;
  
  public ImgsHorizontalListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImgsHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean checkScrollToChild()
  {
    if (!this.mStayDisplayOffsetZero) {}
    int i;
    do
    {
      View localView;
      do
      {
        return false;
        if (!this.isFromRightToLeft) {
          if (Math.abs(this.mCurrentX - this.mMaxX) < this.mTouchSlop) {
            i = 1;
          }
        }
        while (i != 0)
        {
          this.Fd.setVisibility(8);
          i = this.mMaxX;
          this.mCurrentX = i;
          this.mNextX = i;
          invalidate();
          return false;
          i = 0;
          continue;
          if (Math.abs(this.mCurrentX - this.mMinX) < this.mTouchSlop) {
            i = 1;
          } else {
            i = 0;
          }
        }
        this.Fd.setVisibility(0);
        if (this.mTouchSlop + this.mDisplayOffset >= 0)
        {
          this.mNextX += this.mDisplayOffset;
          invalidate();
          return false;
        }
        localView = getChildAt(0);
      } while (localView == null);
      i = this.mNextX;
      int j = this.mDisplayOffset + i;
      int k = localView.getMeasuredWidth();
      i = j;
      if (this.mDisplayOffset <= -(k / 2 + 0.5D)) {
        i = j + k;
      }
    } while (!this.mScroller.springBack(this.mNextX + getScrollX(), 0, i, i, 0, 0));
    invalidate();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setArrow(View paramView)
  {
    this.Fd = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ImgsHorizontalListView
 * JD-Core Version:    0.7.0.1
 */