import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;

public class bm
  implements View.OnTouchListener
{
  public bm(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.a(this.a).setVisibility(8);
      LiteActivity.a(this.a).setImageResource(2130837644);
      LiteActivity.a(this.a);
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */