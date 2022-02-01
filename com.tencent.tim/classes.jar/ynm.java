import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;

public class ynm
  implements MessageQueue.IdleHandler
{
  public ynm(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean queueIdle()
  {
    this.this$0.aN.requestFocus();
    ((InputMethodManager)this.this$0.getSystemService("input_method")).showSoftInput(this.this$0.aN, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynm
 * JD-Core Version:    0.7.0.1
 */