import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class osn
  implements View.OnTouchListener
{
  osn(osl paramosl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    osl.a(this.a).onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osn
 * JD-Core Version:    0.7.0.1
 */