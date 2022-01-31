import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.AddFriendActivity;

public class bti
  implements View.OnTouchListener
{
  public bti(AddFriendActivity paramAddFriendActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((AddFriendActivity.a(this.a) != null) && (paramMotionEvent.getAction() == 0)) {
      AddFriendActivity.a(this.a).hideSoftInputFromWindow(this.a.getWindow().peekDecorView().getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bti
 * JD-Core Version:    0.7.0.1
 */