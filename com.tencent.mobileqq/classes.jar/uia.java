import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uia
  extends GestureDetector.SimpleOnGestureListener
{
  uia(uhz paramuhz) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    uqf.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    uhz.a(this.a, paramMotionEvent);
    uhz.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uqf.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    uhz.a(this.a);
    uhz.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uia
 * JD-Core Version:    0.7.0.1
 */