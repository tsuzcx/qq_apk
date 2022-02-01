import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vrv
  extends GestureDetector.SimpleOnGestureListener
{
  vrv(vru paramvru) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    vmp.b("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
    vru.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    vmp.b("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
    vru.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrv
 * JD-Core Version:    0.7.0.1
 */