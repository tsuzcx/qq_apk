import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class cua
  implements View.OnFocusChangeListener
{
  public cua(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      this.a.a.setSelection(this.a.a.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cua
 * JD-Core Version:    0.7.0.1
 */