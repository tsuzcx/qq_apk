import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;

public class ynp
  implements View.OnTouchListener
{
  public ynp(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (InputMethodManager)this.this$0.getSystemService("input_method");
    if (paramMotionEvent.isActive()) {
      paramMotionEvent.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    this.this$0.aN.clearFocus();
    paramView = this.this$0.aN.getText().toString();
    this.this$0.aN.setSelection(paramView.length());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynp
 * JD-Core Version:    0.7.0.1
 */