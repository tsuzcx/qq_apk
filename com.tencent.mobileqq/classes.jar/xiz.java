import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class xiz
  implements TextWatcher
{
  public xiz(LoginView paramLoginView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      LoginView.a(this.a, null);
    }
    String str;
    SimpleAccount localSimpleAccount;
    for (;;)
    {
      return;
      if (paramCharSequence != null)
      {
        str = paramCharSequence.toString();
        if ((str == null) || (str.length() == 0) || (this.a.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < this.a.jdField_a_of_type_JavaUtilList.size())
        {
          localSimpleAccount = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
            break label110;
          }
          paramInt1 += 1;
        }
      }
    }
    label110:
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      paramCharSequence = localSimpleAccount.getUin();
      label126:
      if (!str.equals(paramCharSequence)) {
        break label288;
      }
      if ((localSimpleAccount == null) || (!localSimpleAccount.isLogined())) {
        break label296;
      }
      if (!LoginView.c(this.a))
      {
        LoginView.c(this.a, true);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        paramCharSequence = this.a.c;
        if ((!LoginView.d(this.a)) && (!LoginView.e(this.a)) && (!LoginView.b(this.a))) {
          break label290;
        }
        paramInt1 = 2130843744;
        paramCharSequence.setImageResource(paramInt1);
        this.a.c.setContentDescription("隐藏密码");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = localSimpleAccount;
    }
    for (;;)
    {
      label221:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      return;
      paramCharSequence = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin());
      break label126;
      label288:
      break;
      label290:
      paramInt1 = 2130842041;
      break label221;
      label296:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xiz
 * JD-Core Version:    0.7.0.1
 */