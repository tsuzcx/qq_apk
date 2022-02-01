import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aavy
  implements View.OnTouchListener
{
  aavy(aavx paramaavx) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      aavx.a(this.a).x = ((int)paramMotionEvent.getRawX());
      aavx.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavy
 * JD-Core Version:    0.7.0.1
 */