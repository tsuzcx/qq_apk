package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.b;

public class DragGallery
  extends ProGallery
{
  private MotionEvent mSingleTapConfirmedEvent;
  
  public DragGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void disPatchToParent()
  {
    if (Math.abs(this.scrollX) == 0) {}
    for (float f = 999.0F;; f = Math.abs(this.scrollY) / Math.abs(this.scrollX))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DragGallery", 2, "scrollY : " + Math.abs(this.scrollY) + " scrollX : " + Math.abs(this.scrollX) + " ratio : " + f);
      }
      if (((this.mScrollState == 1) || (this.mScrollState == -1)) && (f >= 6.0F) && (this.scrollX < 10))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        if (this.a != null) {
          this.a.onScrollEnd(this.mSelectedPosition);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.DragGallery
 * JD-Core Version:    0.7.0.1
 */