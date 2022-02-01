import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class ahiu
  implements TextWatcher
{
  ahiu(ahio paramahio, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ahio.a(this.this$0).getText().length() == this.cZV) && (paramCharSequence.charAt(this.cZV - 1) == '\024'))
    {
      ahio.a(this.this$0).setText(paramCharSequence.subSequence(0, this.cZV - 1));
      ahio.a(this.this$0).setSelection(this.cZV - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahiu
 * JD-Core Version:    0.7.0.1
 */