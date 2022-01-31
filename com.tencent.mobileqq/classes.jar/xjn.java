import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;

public class xjn
  implements View.OnTouchListener
{
  public xjn(LoginView paramLoginView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (LoginView.a(this.a) != null)) {
      LoginView.a(this.a).hideSoftInputFromWindow(this.a.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */