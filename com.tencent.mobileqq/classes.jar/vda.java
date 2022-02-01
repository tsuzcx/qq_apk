import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vda
  extends GestureDetector.SimpleOnGestureListener
{
  vda(vcz paramvcz) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    uya.b("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
    vcz.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uya.b("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
    vcz.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vda
 * JD-Core Version:    0.7.0.1
 */