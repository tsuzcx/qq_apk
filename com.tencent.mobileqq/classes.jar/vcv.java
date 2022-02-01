import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vcv
  extends GestureDetector.SimpleOnGestureListener
{
  vcv(vcu paramvcu) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    vmp.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    vcu.a(this.a, paramMotionEvent);
    vcu.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    vmp.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    vcu.a(this.a);
    vcu.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcv
 * JD-Core Version:    0.7.0.1
 */