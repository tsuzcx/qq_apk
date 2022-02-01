import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class uud
  extends GestureDetector.SimpleOnGestureListener
{
  uud(uuc paramuuc) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    upe.b("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
    uuc.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    upe.b("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
    uuc.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uud
 * JD-Core Version:    0.7.0.1
 */