import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.text.QQTextBuilder;

public final class egk
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egk
 * JD-Core Version:    0.7.0.1
 */