import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

public class ctr
  implements TextWatcher
{
  public ctr(LoginActivity paramLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (this.a.b != null) {
        this.a.b.setVisibility(0);
      }
    }
    while (paramCharSequence.length() > 4)
    {
      this.a.a(paramCharSequence.toString());
      return;
      if ((this.a.b != null) && (this.a.b.isShown())) {
        this.a.b.setVisibility(8);
      }
    }
    this.a.a.setImageResource(2130838113);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ctr
 * JD-Core Version:    0.7.0.1
 */