import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class uhz
  implements View.OnTouchListener
{
  public uhz(AutoRemarkActivity paramAutoRemarkActivity) {}
  
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
 * Qualified Name:     uhz
 * JD-Core Version:    0.7.0.1
 */