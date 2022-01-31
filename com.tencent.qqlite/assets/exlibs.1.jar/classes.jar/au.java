import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;

public class au
  implements View.OnTouchListener
{
  public au(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.a(this.a).setVisibility(8);
      if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).getVisibility() == 0)) {
        LiteActivity.a(this.a, false);
      }
      LiteActivity.a(this.a).setImageResource(2130837545);
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     au
 * JD-Core Version:    0.7.0.1
 */