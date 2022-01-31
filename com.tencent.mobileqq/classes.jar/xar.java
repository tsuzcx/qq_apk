import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

public final class xar
  implements Runnable
{
  public xar(EditText paramEditText) {}
  
  public void run()
  {
    MotionEvent localMotionEvent1 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0);
    this.a.dispatchTouchEvent(localMotionEvent1);
    MotionEvent localMotionEvent2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0);
    this.a.dispatchTouchEvent(localMotionEvent2);
    localMotionEvent1.recycle();
    localMotionEvent2.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xar
 * JD-Core Version:    0.7.0.1
 */