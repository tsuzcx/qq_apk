import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class aabi
  implements TextWatcher
{
  protected EditText editText;
  
  public aabi(EditText paramEditText)
  {
    this.editText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabi
 * JD-Core Version:    0.7.0.1
 */