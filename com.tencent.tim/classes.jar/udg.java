import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class udg
  implements TextWatcher
{
  public udg(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.c != null) {
      AddAccountActivity.a(this.this$0, null);
    }
    String str;
    SimpleAccount localSimpleAccount;
    for (;;)
    {
      return;
      if (paramCharSequence != null)
      {
        str = paramCharSequence.toString();
        if ((str == null) || (str.length() == 0) || (this.this$0.qh == null)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < this.this$0.qh.size())
        {
          localSimpleAccount = (SimpleAccount)this.this$0.qh.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
            break label110;
          }
          paramInt1 += 1;
        }
      }
    }
    label110:
    if (this.this$0.app == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label198;
      }
      if ((localSimpleAccount == null) || (!localSimpleAccount.isLogined())) {
        break label200;
      }
      this.this$0.a.setText("!@#ewaGbhkc$!!=");
      this.this$0.c = localSimpleAccount;
    }
    for (;;)
    {
      this.this$0.a.setClearButtonVisible(false);
      return;
      paramCharSequence = this.this$0.app.jm(localSimpleAccount.getUin());
      break label126;
      label198:
      break;
      label200:
      this.this$0.a.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udg
 * JD-Core Version:    0.7.0.1
 */