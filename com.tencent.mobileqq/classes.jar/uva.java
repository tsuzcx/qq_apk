import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uva
  extends GestureDetector.SimpleOnGestureListener
{
  uva(uuz paramuuz) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    uqf.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    uuz.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uqf.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    uuz.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */