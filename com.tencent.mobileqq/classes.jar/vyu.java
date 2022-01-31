import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class vyu
  implements View.OnTouchListener
{
  vyu(vyo paramvyo) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      vyo.a(this.a, 0);
    }
    if (vyo.a(this.a) != null) {
      vyo.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vyu
 * JD-Core Version:    0.7.0.1
 */