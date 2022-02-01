import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class udx
  implements View.OnTouchListener
{
  public udx(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    do
    {
      return false;
      paramView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    } while (!paramView.isActive());
    paramView.hideSoftInputFromWindow(this.this$0.getWindow().getDecorView().getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udx
 * JD-Core Version:    0.7.0.1
 */