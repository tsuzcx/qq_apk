import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class sbw
  implements View.OnTouchListener
{
  sbw(sbq paramsbq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      sbq.a(this.a, 0);
    }
    if (sbq.a(this.a) != null) {
      sbq.a(this.a).onTouchEvent(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbw
 * JD-Core Version:    0.7.0.1
 */