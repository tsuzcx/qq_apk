import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class udn
  implements TextWatcher
{
  public udn(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AddAccountActivity.a(this.this$0, null);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AddAccountActivity.a(this.this$0, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.c != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (AddAccountActivity.a(this.this$0) != null) && (AddAccountActivity.a(this.this$0).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        BaseApplicationImpl.sApplication.refreAccountList();
      }
      AddAccountActivity.a(this.this$0, null);
      if ((AddAccountActivity.a(this.this$0) == null) || (AddAccountActivity.a(this.this$0).length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != AddAccountActivity.a(this.this$0).length() + 1))
        {
          BaseApplicationImpl.sApplication.refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, AddAccountActivity.a(this.this$0).length()).equals(AddAccountActivity.a(this.this$0))) || (this.this$0.a == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(AddAccountActivity.a(this.this$0).length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.this$0.a.setText(paramCharSequence);
      this.this$0.a.setSelection(1);
    }
    AddAccountActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udn
 * JD-Core Version:    0.7.0.1
 */