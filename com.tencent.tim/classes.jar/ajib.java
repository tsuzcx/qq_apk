import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.widget.FitSystemWindowsRelativeLayout.a;

public class ajib
  implements FitSystemWindowsRelativeLayout.a
{
  public ajib(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    MultiAIOItemFragment.a(this.this$0).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajib
 * JD-Core Version:    0.7.0.1
 */