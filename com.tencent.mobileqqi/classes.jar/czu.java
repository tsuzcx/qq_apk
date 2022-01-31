import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class czu
  implements View.OnFocusChangeListener
{
  public czu(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      this.a.a.setSelection(this.a.a.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     czu
 * JD-Core Version:    0.7.0.1
 */