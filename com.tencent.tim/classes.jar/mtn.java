import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class mtn
  extends GestureDetector.SimpleOnGestureListener
{
  mtn(mtg.a parama) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((mtg.a.a(this.a) != null) && (mtg.a.a(this.a).a != null)) {
      this.a.this$0.l(mtg.a.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((mtg.a.a(this.a) != null) && (mtg.a.a(this.a).ly != null)) {
      this.a.this$0.onClick(mtg.a.a(this.a).ly);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtn
 * JD-Core Version:    0.7.0.1
 */