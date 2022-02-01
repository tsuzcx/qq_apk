import android.text.Editable;
import android.text.Editable.Factory;

final class aofi
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofh)) {
      return (Editable)paramCharSequence;
    }
    return new aofh(paramCharSequence, 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofi
 * JD-Core Version:    0.7.0.1
 */