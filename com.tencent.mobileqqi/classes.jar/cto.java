import android.os.SystemClock;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper;
import com.tencent.mobileqq.app.PrivacyDeclareHelper.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;
import mqq.app.AppRuntime;

public class cto
  implements PrivacyDeclareHelper.Callback
{
  public cto(LoginActivity paramLoginActivity, String paramString, byte[] paramArrayOfByte) {}
  
  public void a()
  {
    PrivacyDeclareHelper.a(LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity));
  }
  
  public void b() {}
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(i) == null) || (((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(i)).getUin() == null)) {}
        while (!((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(i)).getUin().equals(str))
        {
          i += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Long = SystemClock.uptimeMillis() - LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
    {
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.showDialog(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.b.login(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
    }
    for (;;)
    {
      AlbumUtil.b();
      return;
      com.tencent.common.app.BaseApplicationImpl.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.showDialog(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.getAppRuntime().login(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, LoginActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cto
 * JD-Core Version:    0.7.0.1
 */