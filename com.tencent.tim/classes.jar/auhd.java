import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class auhd
  implements TextWatcher
{
  auhd(auha paramauha) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = paramEditable.toString();
    int i = str.length();
    if (i > 64) {
      paramEditable.replace(0, str.length(), str.substring(0, 64));
    }
    if (i == 0) {
      if ((auha.a(this.this$0) != null) && (auha.a(this.this$0).getBtnight().isEnabled())) {
        auha.a(this.this$0).getBtnight().setEnabled(false);
      }
    }
    while ((auha.a(this.this$0) == null) || (auha.a(this.this$0).getBtnight().isEnabled())) {
      return;
    }
    auha.a(this.this$0).getBtnight().setEnabled(true);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhd
 * JD-Core Version:    0.7.0.1
 */