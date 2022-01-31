import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class xsm
  implements TextWatcher
{
  public xsm(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoginView.a(this.a, null);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from_register_choose", false))
    {
      paramEditable = paramEditable.toString();
      if ((!TextUtils.isEmpty(paramEditable)) && (paramEditable.length() >= 6)) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    LoginView.a(this.a, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if ((paramCharSequence != null) && (LoginView.a(this.a) != null) && (LoginView.a(this.a).length() != paramCharSequence.length()) && (paramInt3 != 0)) {
        BaseApplicationImpl.sApplication.refreAccountList();
      }
      LoginView.a(this.a, null);
      if ((LoginView.a(this.a) == null) || (LoginView.a(this.a).length() == 0)) {}
      do
      {
        return;
        if ((paramCharSequence == null) || (paramCharSequence.length() == 0) || (paramCharSequence.length() != LoginView.a(this.a).length() + 1))
        {
          BaseApplicationImpl.sApplication.refreAccountList();
          return;
        }
        if ((!paramCharSequence.substring(0, LoginView.a(this.a).length()).equals(LoginView.a(this.a))) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText == null)) {
          break;
        }
        paramCharSequence = paramCharSequence.substring(LoginView.a(this.a).length());
      } while ((paramCharSequence == null) || (paramCharSequence.length() != 1));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramCharSequence);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(1);
    }
    LoginView.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsm
 * JD-Core Version:    0.7.0.1
 */