import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class osm
  extends GestureDetector.SimpleOnGestureListener
{
  osm(osl paramosl) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ooz.d("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
    osl.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ooz.d("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
    osl.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osm
 * JD-Core Version:    0.7.0.1
 */