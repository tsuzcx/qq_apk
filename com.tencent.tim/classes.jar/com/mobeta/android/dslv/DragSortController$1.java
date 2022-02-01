package com.mobeta.android.dslv;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DragSortController$1
  extends GestureDetector.SimpleOnGestureListener
{
  DragSortController$1(DragSortController paramDragSortController) {}
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i;
    if ((DragSortController.access$000(this.this$0)) && (DragSortController.access$100(this.this$0)))
    {
      i = DragSortController.access$200(this.this$0).getWidth() / 5;
      if (paramFloat1 <= DragSortController.access$300(this.this$0)) {
        break label83;
      }
      if (DragSortController.access$400(this.this$0) > -i) {
        DragSortController.access$200(this.this$0).stopDragWithVelocity(true, paramFloat1);
      }
    }
    for (;;)
    {
      DragSortController.access$102(this.this$0, false);
      return false;
      label83:
      if ((paramFloat1 < -DragSortController.access$300(this.this$0)) && (DragSortController.access$400(this.this$0) < i)) {
        DragSortController.access$200(this.this$0).stopDragWithVelocity(true, paramFloat1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.mobeta.android.dslv.DragSortController.1
 * JD-Core Version:    0.7.0.1
 */