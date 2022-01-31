import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import java.lang.ref.SoftReference;
import java.util.TimerTask;

public class hhj
  extends TimerTask
{
  public hhj(QQCustomDialogWtihInput paramQQCustomDialogWtihInput) {}
  
  public void run()
  {
    Context localContext = (Context)QQCustomDialogWtihInput.a(this.a).get();
    if (localContext != null) {
      ((InputMethodManager)localContext.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhj
 * JD-Core Version:    0.7.0.1
 */