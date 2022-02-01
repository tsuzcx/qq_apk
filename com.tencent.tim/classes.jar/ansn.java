import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class ansn
  implements View.OnTouchListener
{
  ansn(ansl paramansl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.hU != null)
    {
      wlz localwlz = (wlz)this.a.hU.get();
      if (localwlz != null) {
        return localwlz.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansn
 * JD-Core Version:    0.7.0.1
 */