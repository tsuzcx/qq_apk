import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uty
  extends GestureDetector.SimpleOnGestureListener
{
  uty(utx paramutx) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    upe.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    utx.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    upe.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    utx.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */