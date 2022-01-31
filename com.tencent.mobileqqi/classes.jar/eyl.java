import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;

public class eyl
  implements View.OnClickListener
{
  public eyl(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(View paramView)
  {
    VoipDialInterfaceActivity.a(this.a).setCursorVisible(true);
    VoipDialInterfaceActivity.b(this.a).setCursorVisible(false);
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(VoipDialInterfaceActivity.b(this.a).getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eyl
 * JD-Core Version:    0.7.0.1
 */