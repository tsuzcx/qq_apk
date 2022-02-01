import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class osh
  extends GestureDetector.SimpleOnGestureListener
{
  osh(osg paramosg) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ooz.d("WSVerticalVideoItemView", "itemView onDoubleTap");
    osg.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ooz.d("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    osg.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osh
 * JD-Core Version:    0.7.0.1
 */