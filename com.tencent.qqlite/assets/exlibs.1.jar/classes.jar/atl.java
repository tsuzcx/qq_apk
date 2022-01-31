import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;

public class atl
  implements TextWatcher
{
  public atl(LoginActivity paramLoginActivity) {}
  
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
    this.a.a.setImageResource(2130838139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     atl
 * JD-Core Version:    0.7.0.1
 */