import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;

public class amll
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public amll(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onGlobalLayout()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      this.a.b.requestFocus();
      localInputMethodManager.showSoftInput(this.a.b, 0);
    }
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amll
 * JD-Core Version:    0.7.0.1
 */