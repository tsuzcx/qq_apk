import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class atdy
  implements TextWatcher
{
  atdy(atdx paramatdx) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = paramEditable.toString();
    int i = str.length();
    if (i > this.a.maxLength) {
      paramEditable.replace(0, str.length(), str.substring(0, this.a.maxLength));
    }
    if (i == 0) {}
    while ((atdx.a(this.a) == null) || (atdx.a(this.a).getBtnight().isEnabled())) {
      return;
    }
    atdx.a(this.a).getBtnight().setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdy
 * JD-Core Version:    0.7.0.1
 */