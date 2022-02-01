import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class oiz
  extends GestureDetector.SimpleOnGestureListener
{
  oiz(oiy paramoiy) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ooz.d("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    oiy.a(this.a, paramMotionEvent);
    oiy.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ooz.d("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    oiy.a(this.a);
    oiy.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oiz
 * JD-Core Version:    0.7.0.1
 */