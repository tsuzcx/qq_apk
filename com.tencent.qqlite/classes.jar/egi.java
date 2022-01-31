import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.mobileqq.text.QQText;

public final class egi
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egi
 * JD-Core Version:    0.7.0.1
 */