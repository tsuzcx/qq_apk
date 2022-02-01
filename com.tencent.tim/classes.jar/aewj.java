import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

class aewj
  implements TextWatcher
{
  aewj(aewi paramaewi) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      this.this$0.cXA();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aewj
 * JD-Core Version:    0.7.0.1
 */