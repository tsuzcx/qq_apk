import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vcv
  extends GestureDetector.SimpleOnGestureListener
{
  vcv(vcu paramvcu) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    uya.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    vcu.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uya.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    vcu.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcv
 * JD-Core Version:    0.7.0.1
 */