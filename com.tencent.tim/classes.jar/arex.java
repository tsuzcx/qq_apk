import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.ConfigClearableEditText;

public class arex
  implements TextWatcher
{
  public arex(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.c.getText().toString();
    if (this.c.isFocused())
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
        this.c.setClearButtonVisible(false);
      }
    }
    else {
      return;
    }
    if ((ConfigClearableEditText.b(this.c)) || (ConfigClearableEditText.c(this.c)))
    {
      this.c.setClearButtonVisible(true);
      return;
    }
    this.c.setClearButtonVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arex
 * JD-Core Version:    0.7.0.1
 */