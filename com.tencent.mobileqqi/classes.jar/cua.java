import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

public class cua
  implements View.OnFocusChangeListener
{
  public cua(LoginActivity paramLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      if (this.a.a.isPopupShowing()) {
        this.a.a.dismissDropDown();
      }
      if ((this.a.b != null) && (this.a.a.getText().length() > 0)) {
        this.a.b.setVisibility(0);
      }
      this.a.a.setSelection(this.a.a.getText().length());
    }
    while ((this.a.b == null) || (!this.a.b.isShown())) {
      return;
    }
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cua
 * JD-Core Version:    0.7.0.1
 */