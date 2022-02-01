import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class aqks
  implements TextWatcher
{
  aqks(aqkk paramaqkk, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.this$0.U.getText().length() == this.cZV) && (paramCharSequence.charAt(this.cZV - 1) == '\024'))
    {
      this.this$0.U.setText(paramCharSequence.subSequence(0, this.cZV - 1));
      this.this$0.U.setSelection(this.cZV - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqks
 * JD-Core Version:    0.7.0.1
 */