package com.tencent.richmediabrowser.view.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class DragGallery
  extends ProGallery
{
  public static final String TAG = "DragGallery";
  private MotionEvent mSingleTapConfirmedEvent;
  
  public DragGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void disPatchToParent()
  {
    if (Math.abs(this.scrollX) == 0) {}
    for (float f = 999.0F;; f = Math.abs(this.scrollY) / Math.abs(this.scrollX))
    {
      if (((this.mScrollState == 1) || (this.mScrollState == -1)) && (f >= 6.0F) && (this.scrollX < 10))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        if (this.mOnScollListener != null) {
          this.mOnScollListener.onScrollEnd(this.mSelectedPosition);
        }
      }
      return;
    }
  }
  
  public MotionEvent getSingleTapConfirmedEvent()
  {
    return this.mSingleTapConfirmedEvent;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.mSingleTapConfirmedEvent = paramMotionEvent;
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.DragGallery
 * JD-Core Version:    0.7.0.1
 */