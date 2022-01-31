import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;

public class att
  implements View.OnTouchListener
{
  public att(LoginActivity paramLoginActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a.isPopupShowing()) {
      this.a.a.dismissDropDown();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     att
 * JD-Core Version:    0.7.0.1
 */