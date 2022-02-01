import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class aand
  implements TextWatcher
{
  public aand(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoginView.a(this.this$0, null);
    LoginView.c(this.this$0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LoginView.a(this.this$0, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.c != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (LoginView.a(this.this$0) != null) && (LoginView.a(this.this$0).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        BaseApplicationImpl.sApplication.refreAccountList();
      }
      LoginView.a(this.this$0, null);
      if ((LoginView.a(this.this$0) == null) || (LoginView.a(this.this$0).length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != LoginView.a(this.this$0).length() + 1))
        {
          BaseApplicationImpl.sApplication.refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, LoginView.a(this.this$0).length()).equals(LoginView.a(this.this$0))) || (this.this$0.a == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(LoginView.a(this.this$0).length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.this$0.a.setText(paramCharSequence);
      this.this$0.a.setSelection(1);
      LoginView.c(this.this$0);
    }
    LoginView.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aand
 * JD-Core Version:    0.7.0.1
 */