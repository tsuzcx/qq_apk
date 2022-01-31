import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class wlz
  implements RecyclerView.OnItemTouchListener
{
  wlz(wlu paramwlu) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    return wlu.a(this.a, paramMotionEvent);
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (wlu.a(this.a) != null) {
      wlu.a(this.a).a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wlz
 * JD-Core Version:    0.7.0.1
 */