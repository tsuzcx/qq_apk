import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vrq
  extends GestureDetector.SimpleOnGestureListener
{
  vrq(vrp paramvrp) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    vmp.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    vrp.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    vmp.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    vrp.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrq
 * JD-Core Version:    0.7.0.1
 */