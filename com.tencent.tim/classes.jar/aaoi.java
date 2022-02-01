import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class aaoi
  implements TextWatcher
{
  public aaoi(TimLoginQQView paramTimLoginQQView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.c != null) {
      TimLoginQQView.a(this.this$0, null);
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
    if (this.this$0.mAppInterface == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label298;
      }
      if ((localSimpleAccount != null) && (localSimpleAccount.isLogined())) {
        if (!TimLoginQQView.f(this.this$0))
        {
          TimLoginQQView.g(this.this$0, true);
          this.this$0.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
          paramCharSequence = this.this$0.qX;
          if ((!TimLoginQQView.g(this.this$0)) && (!TimLoginQQView.h(this.this$0)) && (!TimLoginQQView.e(this.this$0))) {
            break label300;
          }
        }
      }
    }
    label298:
    label300:
    for (paramInt1 = 2130847848;; paramInt1 = 2130845569)
    {
      paramCharSequence.setImageResource(paramInt1);
      this.this$0.qX.setContentDescription(acfp.m(2131707946));
      this.this$0.a.setText("!@#ewaGbhkc$!!=");
      this.this$0.c = localSimpleAccount;
      TimLoginQQView.c(this.this$0);
      this.this$0.a.setClearButtonVisible(false);
      return;
      paramCharSequence = this.this$0.mAppInterface.jm(localSimpleAccount.getUin());
      break label126;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaoi
 * JD-Core Version:    0.7.0.1
 */