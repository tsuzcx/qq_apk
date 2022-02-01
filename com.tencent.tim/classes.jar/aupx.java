import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.tim.todo.widget.ScheduleSwipListView;
import com.tencent.tim.todo.widget.ScheduleSwipListView.Direction;
import com.tencent.tim.todo.widget.ScheduleSwipListView.a;

public class aupx
  implements GestureDetector.OnGestureListener
{
  public aupx(ScheduleSwipListView paramScheduleSwipListView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((ScheduleSwipListView.a(this.b) == ScheduleSwipListView.Direction.HORIZONTAL) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (ScheduleSwipListView.a(this.b) != null))
    {
      paramMotionEvent1 = ScheduleSwipListView.a(this.b);
      if (paramFloat1 > 0.0F) {
        bool = true;
      }
      paramMotionEvent1.S(bool);
      ScheduleSwipListView.a(this.b, ScheduleSwipListView.Direction.NONE);
      return true;
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (ScheduleSwipListView.a(this.b) != null)
    {
      if (ScheduleSwipListView.a(this.b) == ScheduleSwipListView.Direction.NONE)
      {
        if (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) {
          break label62;
        }
        ScheduleSwipListView.a(this.b, ScheduleSwipListView.Direction.HORIZONTAL);
      }
      while (ScheduleSwipListView.a(this.b) == ScheduleSwipListView.Direction.HORIZONTAL)
      {
        return true;
        label62:
        ScheduleSwipListView.a(this.b, ScheduleSwipListView.Direction.VERTICAL);
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupx
 * JD-Core Version:    0.7.0.1
 */