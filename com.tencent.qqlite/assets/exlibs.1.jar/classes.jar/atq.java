import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class atq
  implements View.OnFocusChangeListener
{
  public atq(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      this.a.a.setSelection(this.a.a.getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atq
 * JD-Core Version:    0.7.0.1
 */