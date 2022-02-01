import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class aany
  implements View.OnTouchListener
{
  public aany(TimLoginQQView paramTimLoginQQView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.TimLoginQQView", 2, "mScrollRootView.setOnTouch action=" + paramMotionEvent.getAction() + " im:" + TimLoginQQView.a(this.this$0));
    }
    if ((paramMotionEvent.getAction() == 1) && (TimLoginQQView.a(this.this$0) != null)) {
      TimLoginQQView.a(this.this$0).hideSoftInputFromWindow(this.this$0.m.getWindow().getDecorView().getWindowToken(), 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aany
 * JD-Core Version:    0.7.0.1
 */