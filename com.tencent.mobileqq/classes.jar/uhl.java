import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uhl
  extends GestureDetector.SimpleOnGestureListener
{
  uhl(uhk paramuhk) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    upe.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    uhk.a(this.a, paramMotionEvent);
    uhk.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    upe.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    uhk.a(this.a);
    uhk.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhl
 * JD-Core Version:    0.7.0.1
 */