import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.richstatus.EditActivity;

public class ebu
  implements TextWatcher
{
  public ebu(EditActivity paramEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    EditActivity.a(this.a);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebu
 * JD-Core Version:    0.7.0.1
 */