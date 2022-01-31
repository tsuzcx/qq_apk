import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.tencent.biz.ui.PopupWindows;

public class rk
  implements View.OnTouchListener
{
  public rk(PopupWindows paramPopupWindows) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     rk
 * JD-Core Version:    0.7.0.1
 */