import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class amnh
  implements View.OnTouchListener
{
  public amnh(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!amxk.lo(SelectMemberContactSearchFragment.a(this.a))) && (!SelectMemberContactSearchFragment.a(this.a)) && (paramMotionEvent.getAction() == 1))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
      return false;
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnh
 * JD-Core Version:    0.7.0.1
 */