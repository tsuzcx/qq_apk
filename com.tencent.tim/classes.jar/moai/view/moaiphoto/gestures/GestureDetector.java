package moai.view.moaiphoto.gestures;

import android.view.MotionEvent;

public abstract interface GestureDetector
{
  public abstract boolean isDragging();
  
  public abstract boolean isScaling();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setOnGestureListener(OnGestureListener paramOnGestureListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.view.moaiphoto.gestures.GestureDetector
 * JD-Core Version:    0.7.0.1
 */