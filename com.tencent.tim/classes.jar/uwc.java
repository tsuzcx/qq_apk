import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class uwc
  extends Editable.Factory
{
  public uwc(EditInfoActivity paramEditInfoActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofr)) {
      return (Editable)paramCharSequence;
    }
    return new aofr(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwc
 * JD-Core Version:    0.7.0.1
 */