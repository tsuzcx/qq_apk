import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class yfc
  implements View.OnTouchListener
{
  yfc(yew paramyew) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      yew.a(this.a, 0);
    }
    if (yew.a(this.a) != null) {
      yew.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yfc
 * JD-Core Version:    0.7.0.1
 */