import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.book.BookEditText;

public class ymf
  implements InputFilter
{
  public ymf(BookEditText paramBookEditText) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    this.a.bQ(paramSpanned.toString());
    if (this.a.bQ(paramCharSequence.toString()) == 0) {
      BookEditText.a(this.a);
    }
    while (!aofk.containsEmoji(paramCharSequence.toString())) {
      return paramCharSequence.subSequence(paramInt1, paramInt2 - paramInt1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymf
 * JD-Core Version:    0.7.0.1
 */