import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.dataline.activities.LiteActivity;

public class ar
  implements TextWatcher
{
  public ar(LiteActivity paramLiteActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable instanceof SpannableStringBuilder)) {}
    LiteActivity.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ar
 * JD-Core Version:    0.7.0.1
 */