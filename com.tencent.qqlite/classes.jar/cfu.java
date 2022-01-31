import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;

public class cfu
  implements View.OnTouchListener
{
  public cfu(MessageSearchDialog paramMessageSearchDialog) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)MessageSearchDialog.a(this.a).getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cfu
 * JD-Core Version:    0.7.0.1
 */