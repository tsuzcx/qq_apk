import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class yhv
  implements Runnable
{
  public void run()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).toggleSoftInput(1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhv
 * JD-Core Version:    0.7.0.1
 */