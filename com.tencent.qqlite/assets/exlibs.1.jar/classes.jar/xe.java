import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class xe
  implements View.OnTouchListener
{
  public xe(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xe
 * JD-Core Version:    0.7.0.1
 */