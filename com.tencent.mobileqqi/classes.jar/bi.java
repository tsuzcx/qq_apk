import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.dataline.activities.LiteActivity;

public class bi
  implements TextWatcher
{
  public bi(LiteActivity paramLiteActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable instanceof SpannableStringBuilder)) {}
    LiteActivity.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bi
 * JD-Core Version:    0.7.0.1
 */