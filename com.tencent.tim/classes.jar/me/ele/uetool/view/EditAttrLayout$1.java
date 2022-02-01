package me.ele.uetool.view;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class EditAttrLayout$1
  implements GestureDetector.OnGestureListener
{
  EditAttrLayout$1(EditAttrLayout paramEditAttrLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    EditAttrLayout.access$002(this.this$0, paramMotionEvent.getX());
    EditAttrLayout.access$102(this.this$0, paramMotionEvent.getY());
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    EditAttrLayout.access$200(this.this$0).triggerActionLong(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    EditAttrLayout.access$200(this.this$0).triggerActionUp(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.1
 * JD-Core Version:    0.7.0.1
 */