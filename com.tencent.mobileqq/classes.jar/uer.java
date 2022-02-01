import android.text.Editable;
import android.text.Editable.Factory;

final class uer
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof bdod)) {
      return (Editable)paramCharSequence;
    }
    return new bdod(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uer
 * JD-Core Version:    0.7.0.1
 */