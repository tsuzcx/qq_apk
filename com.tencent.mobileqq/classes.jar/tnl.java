import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class tnl
  extends GestureDetector.SimpleOnGestureListener
{
  tnl(tnk paramtnk) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    tlo.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    tnk.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    tlo.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    tnk.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnl
 * JD-Core Version:    0.7.0.1
 */