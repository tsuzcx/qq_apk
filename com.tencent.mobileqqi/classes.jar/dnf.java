import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class dnf
  implements View.OnFocusChangeListener
{
  public dnf(SubLoginActivity paramSubLoginActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean)
    {
      if ((SubLoginActivity.a(this.a) != null) && (SubLoginActivity.a(this.a).getText().length() > 0)) {
        SubLoginActivity.a(this.a).setVisibility(0);
      }
      SubLoginActivity.a(this.a).setSelection(SubLoginActivity.a(this.a).getText().length());
    }
    while ((SubLoginActivity.a(this.a) == null) || (!SubLoginActivity.a(this.a).isShown())) {
      return;
    }
    SubLoginActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnf
 * JD-Core Version:    0.7.0.1
 */