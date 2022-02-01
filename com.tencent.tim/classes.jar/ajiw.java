import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class ajiw
  extends GestureDetector.SimpleOnGestureListener
{
  public ajiw(MultiAIOViewPager paramMultiAIOViewPager) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (MultiAIOViewPager.a(this.b) != null) {
      this.b.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajiw
 * JD-Core Version:    0.7.0.1
 */