import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class erp
  implements TextWatcher
{
  private erp(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = SelectMemberActivity.a(this.a).getText().toString().trim();
    this.a.b(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     erp
 * JD-Core Version:    0.7.0.1
 */