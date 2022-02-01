import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class vbd
  extends GestureDetector.SimpleOnGestureListener
{
  vbd(vbc paramvbc) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    uya.b("GdtAdWSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    vbc.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbd
 * JD-Core Version:    0.7.0.1
 */