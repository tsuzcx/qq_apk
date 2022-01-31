import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;

public class czs
  implements View.OnTouchListener
{
  public czs(LoginActivity paramLoginActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a.isPopupShowing()) {
      this.a.a.dismissDropDown();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     czs
 * JD-Core Version:    0.7.0.1
 */