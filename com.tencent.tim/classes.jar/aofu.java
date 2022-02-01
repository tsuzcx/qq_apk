import android.text.Editable;
import android.text.Editable.Factory;

final class aofu
  extends Editable.Factory
{
  aofu(int paramInt) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofr)) {
      return (Editable)paramCharSequence;
    }
    return new aofr(paramCharSequence, 3, this.val$size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofu
 * JD-Core Version:    0.7.0.1
 */