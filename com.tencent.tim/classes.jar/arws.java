import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

public class arws
  implements InputFilter
{
  protected EditText mEditText;
  protected int mMaxBytes;
  
  public arws(EditText paramEditText, int paramInt)
  {
    this.mEditText = paramEditText;
    this.mMaxBytes = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramSpanned = new StringBuilder(this.mEditText.getEditableText().toString());
    paramInt4 = this.mMaxBytes - arwx.fz(paramSpanned.toString());
    paramInt3 = arwx.fz(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt3) {
      return null;
    }
    paramInt3 = paramInt1;
    if (paramInt3 < paramInt2)
    {
      int j;
      if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3))) {
        j = arwx.fz(paramCharSequence.subSequence(paramInt3, paramInt3 + 2).toString());
      }
      for (int i = 2;; i = 1)
      {
        paramInt4 -= j;
        if (paramInt4 < 0) {
          break label161;
        }
        paramInt3 = i + paramInt3;
        break;
        j = arwx.fz(String.valueOf(paramCharSequence.charAt(paramInt3)));
      }
    }
    label161:
    if (paramInt3 == paramInt1) {
      return "";
    }
    return paramCharSequence.subSequence(paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arws
 * JD-Core Version:    0.7.0.1
 */