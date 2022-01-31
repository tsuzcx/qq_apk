import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;

public class at
  implements View.OnTouchListener
{
  public at(LiteActivity paramLiteActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((LiteActivity.a(this.a) != null) && (LiteActivity.a(this.a).getVisibility() == 0)) {
        LiteActivity.a(this.a, false);
      }
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     at
 * JD-Core Version:    0.7.0.1
 */