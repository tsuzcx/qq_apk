import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class wmd
  implements View.OnTouchListener
{
  wmd(wlx paramwlx) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      wlx.a(this.a, 0);
    }
    if (wlx.a(this.a) != null) {
      wlx.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wmd
 * JD-Core Version:    0.7.0.1
 */