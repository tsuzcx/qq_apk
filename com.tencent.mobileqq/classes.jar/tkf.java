import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;

public class tkf
  implements TextWatcher
{
  public tkf(LimitWordCountEditText paramLimitWordCountEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null)
    {
      if (LimitWordCountEditText.a(this.a) != null) {
        LimitWordCountEditText.a(this.a).a(0);
      }
      LimitWordCountEditText.a(this.a).setText(LimitWordCountEditText.a(this.a));
      return;
    }
    if (LimitWordCountEditText.a(this.a) != null) {
      LimitWordCountEditText.a(this.a).a(paramCharSequence.length());
    }
    LimitWordCountEditText.a(this.a).setText(String.valueOf(LimitWordCountEditText.a(this.a) - paramCharSequence.length()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkf
 * JD-Core Version:    0.7.0.1
 */