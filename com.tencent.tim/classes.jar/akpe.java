import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public abstract interface akpe
{
  public abstract void ab(MotionEvent paramMotionEvent);
  
  public abstract void c(Matrix paramMatrix);
  
  public abstract boolean onDoubleTap(MotionEvent paramMotionEvent);
  
  public abstract void onDown(MotionEvent paramMotionEvent);
  
  public abstract boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract void onLongPress(MotionEvent paramMotionEvent);
  
  public abstract boolean onScale(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector);
  
  public abstract boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  
  public abstract boolean onSingleTapConfirmed(MotionEvent paramMotionEvent);
  
  public abstract boolean onSingleTapUp(MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akpe
 * JD-Core Version:    0.7.0.1
 */