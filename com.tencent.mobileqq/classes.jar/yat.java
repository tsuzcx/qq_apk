import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class yat
  implements View.OnTouchListener
{
  yat(yan paramyan) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      yan.a(this.a, 0);
    }
    if (yan.a(this.a) != null) {
      yan.a(this.a).a(paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yat
 * JD-Core Version:    0.7.0.1
 */