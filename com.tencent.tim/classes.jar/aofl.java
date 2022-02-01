import android.text.Spannable;
import android.text.Spannable.Factory;

final class aofl
  extends Spannable.Factory
{
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!aofk.cLt) && ((paramCharSequence instanceof aofk))) {
      try
      {
        aofk localaofk = (aofk)((aofk)paramCharSequence).clone();
        return localaofk;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofl
 * JD-Core Version:    0.7.0.1
 */