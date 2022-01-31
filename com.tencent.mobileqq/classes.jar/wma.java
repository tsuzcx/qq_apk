import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class wma
  implements View.OnTouchListener
{
  wma(wlu paramwlu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      wlu.a(this.a, 0);
    }
    if (wlu.a(this.a) != null) {
      wlu.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wma
 * JD-Core Version:    0.7.0.1
 */