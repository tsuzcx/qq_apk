import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.mobileqq.text.QQText;

public final class gmp
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!QQText.b) && ((paramCharSequence instanceof QQText))) {
      try
      {
        QQText localQQText = (QQText)((QQText)paramCharSequence).clone();
        return localQQText;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gmp
 * JD-Core Version:    0.7.0.1
 */