package com.tencent.mobileqq.emosm.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DragSortController$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragSortController$1(DragSortController paramDragSortController) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.this$0.mDslv.isDragEnabled()) && (DragSortController.access$100(this.this$0) != -1)) {
      this.this$0.mDslv.setTapPos(DragSortController.access$100(this.this$0));
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.this$0.mDslv.isDragEnabled()) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) || (this.this$0.mDslv.isScrolling()) || (this.this$0.mDragging) || (Math.abs(paramFloat1) <= this.this$0.mSlideSlop) || ((paramFloat1 < 0.0F) && (DragSortController.access$000(this.this$0) == 2))) {}
    while ((paramFloat1 > 0.0F) && (DragSortController.access$000(this.this$0) == 1)) {
      return false;
    }
    int i = DragSortController.access$100(this.this$0);
    this.this$0.mDslv.setSrcPos(i);
    this.this$0.mDslv.showDelButton();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortController.1
 * JD-Core Version:    0.7.0.1
 */