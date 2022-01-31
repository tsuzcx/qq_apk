import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

public class cdj
  implements MessageQueue.IdleHandler
{
  public cdj(SearchContactsActivity paramSearchContactsActivity) {}
  
  public boolean queueIdle()
  {
    this.a.a.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cdj
 * JD-Core Version:    0.7.0.1
 */