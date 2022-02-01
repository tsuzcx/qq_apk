import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarController;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView.Direction;

public class arjy
  extends GestureDetector.SimpleOnGestureListener
{
  public arjy(CompactCalendarView paramCompactCalendarView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (CompactCalendarView.a(this.b))
    {
      if (CompactCalendarView.a(this.b) == CompactCalendarView.Direction.NONE)
      {
        if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
          break label104;
        }
        CompactCalendarView.a(this.b, CompactCalendarView.Direction.HORIZONTAL);
      }
      while (CompactCalendarView.a(this.b) == CompactCalendarView.Direction.HORIZONTAL)
      {
        if ((Math.abs(paramFloat1) <= 0.0F) || (this.b.aGI())) {
          break label153;
        }
        CompactCalendarView.a(this.b).onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        this.b.invalidate();
        return true;
        label104:
        CompactCalendarView.a(this.b, CompactCalendarView.Direction.VERTICAL);
      }
      CompactCalendarView.a(this.b, (int)(paramMotionEvent1.getY() - paramMotionEvent2.getY()));
      this.b.mL(CompactCalendarView.a(this.b));
      return true;
    }
    label153:
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    CompactCalendarView.a(this.b).ag(paramMotionEvent);
    this.b.invalidate();
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjy
 * JD-Core Version:    0.7.0.1
 */