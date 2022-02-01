import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class vcw
  implements View.OnTouchListener
{
  vcw(vcu paramvcu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    vcu.a(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcw
 * JD-Core Version:    0.7.0.1
 */