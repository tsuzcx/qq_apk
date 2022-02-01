import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.InterceptTouchEventListener;

class wfj
  implements TopGestureLayout.InterceptTouchEventListener
{
  wfj(wfi paramwfi) {}
  
  public void OnDispatchTouchEvent(MotionEvent paramMotionEvent) {}
  
  public boolean OnInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (wfi.a(this.a) == null) {}
    float f;
    do
    {
      return true;
      f = paramMotionEvent.getY();
      paramMotionEvent = new int[2];
      wfi.a(this.a).getLocationOnScreen(paramMotionEvent);
    } while ((f <= paramMotionEvent[1]) || (f >= paramMotionEvent[1] + wfi.a(this.a).getHeight()));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfj
 * JD-Core Version:    0.7.0.1
 */