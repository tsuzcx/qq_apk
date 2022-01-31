import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.widget.ClearableEditText;

public class hfy
  implements TextWatcher
{
  public hfy(ClearableEditText paramClearableEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    libsafeedit.getLoginLegal(paramCharSequence.toString());
    paramCharSequence = this.a.getText().toString();
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.setClearButtonVisible(false);
      return;
    }
    if (ClearableEditText.a(this.a))
    {
      this.a.setClearButtonVisible(true);
      return;
    }
    this.a.setClearButtonVisible(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfy
 * JD-Core Version:    0.7.0.1
 */