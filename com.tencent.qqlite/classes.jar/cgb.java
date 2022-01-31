import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class cgb
  implements Runnable
{
  public cgb(BindNumberActivity paramBindNumberActivity) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.a.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.a.a.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.a.a.setSelection(this.a.a.getText().toString().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgb
 * JD-Core Version:    0.7.0.1
 */