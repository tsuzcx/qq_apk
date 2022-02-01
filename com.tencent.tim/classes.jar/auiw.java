import android.text.Editable;
import android.text.TextWatcher;

class auiw
  implements TextWatcher
{
  auiw(auir paramauir) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = paramEditable.toString();
    if (str.length() > 64) {
      paramEditable.replace(0, str.length(), str.substring(0, 64));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auiw
 * JD-Core Version:    0.7.0.1
 */