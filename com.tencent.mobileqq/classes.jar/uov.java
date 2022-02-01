import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uov
  extends GestureDetector.SimpleOnGestureListener
{
  uov(uou paramuou) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    uya.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    uou.a(this.a, paramMotionEvent);
    uou.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uya.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    uou.a(this.a);
    uou.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uov
 * JD-Core Version:    0.7.0.1
 */