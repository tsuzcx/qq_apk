import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.ClearableEditText;

public class aret
  implements TextWatcher
{
  public aret(ClearableEditText paramClearableEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.m.getText().toString();
    if (this.m.isFocused())
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {
        this.m.setClearButtonVisible(false);
      }
    }
    else {
      return;
    }
    if ((ClearableEditText.a(this.m)) || (ClearableEditText.b(this.m)))
    {
      this.m.setClearButtonVisible(true);
      return;
    }
    this.m.setClearButtonVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aret
 * JD-Core Version:    0.7.0.1
 */