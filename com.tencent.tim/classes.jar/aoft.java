import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;

final class aoft
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof aofr)) {
      return (Editable)paramCharSequence;
    }
    return new aofr(paramCharSequence, 3, ChatTextSizeSettingActivity.vq() + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoft
 * JD-Core Version:    0.7.0.1
 */