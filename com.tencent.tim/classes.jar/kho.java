import android.text.Editable;
import android.widget.EditText;

public final class kho
  implements ajdq<char[]>
{
  public kho(EditText paramEditText) {}
  
  public void b(char[] paramArrayOfChar)
  {
    int i = this.O.getSelectionStart();
    int j = this.O.getSelectionEnd();
    this.O.getEditableText().replace(i, j, String.valueOf(paramArrayOfChar));
    this.O.requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kho
 * JD-Core Version:    0.7.0.1
 */