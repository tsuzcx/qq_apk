import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class amms
  implements View.OnTouchListener
{
  public amms(BaseSearchFragment paramBaseSearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     amms
 * JD-Core Version:    0.7.0.1
 */