import android.text.Editable;
import android.text.Editable.Factory;

public final class amik
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofr)) {
      return (Editable)paramCharSequence;
    }
    return new aofr(paramCharSequence, 1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amik
 * JD-Core Version:    0.7.0.1
 */