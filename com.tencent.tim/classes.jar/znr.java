import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;

class znr
  extends GestureDetector.SimpleOnGestureListener
{
  znr(znq paramznq) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (znq.a(this.a) != null)
    {
      znq.a(this.a).onClick(znq.a(this.a));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znr
 * JD-Core Version:    0.7.0.1
 */