import android.text.Editable;
import android.text.Editable.Factory;

final class aofx
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofw)) {
      return (Editable)paramCharSequence;
    }
    return new aofw(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofx
 * JD-Core Version:    0.7.0.1
 */