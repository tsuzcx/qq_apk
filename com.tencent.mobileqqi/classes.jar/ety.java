import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class ety
  implements View.OnClickListener
{
  public ety(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    if (VoipDialInterfaceActivity.a(this.a).getText().toString().trim().length() >= 0)
    {
      VoipDialInterfaceActivity.a(this.a).setCursorVisible(true);
      VoipDialInterfaceActivity.a(this.a, true);
    }
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(VoipDialInterfaceActivity.a(this.a).getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ety
 * JD-Core Version:    0.7.0.1
 */