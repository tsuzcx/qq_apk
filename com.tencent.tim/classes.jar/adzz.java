import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

public class adzz
  implements TextWatcher
{
  public adzz(ClearEllipsisEditText paramClearEllipsisEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ClearEllipsisEditText.a(this.this$0)) && (!ClearEllipsisEditText.b(this.this$0))) {
      ClearEllipsisEditText.a(this.this$0, paramCharSequence.toString());
    }
    ClearEllipsisEditText.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzz
 * JD-Core Version:    0.7.0.1
 */