import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.PrivacyDeclareHelper.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;

public class dga
  implements PrivacyDeclareHelper.Callback
{
  public dga(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, boolean paramBoolean, String paramString) {}
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      EUCountryUtils.a(paramString);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("lich", 2, "in Register to privacy page, user reject, this to cancel");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("lich", 2, "in Register to privacy page, user FinishSelf, this go2finish");
    }
    a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.finish();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("lich", 2, "in Register to privacy page, user confirm, this go2next");
    }
    if (this.jdField_a_of_type_Boolean) {
      EUCountryUtils.a(this.jdField_a_of_type_JavaLangString, true);
    }
    RegisterPhoneNumActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dga
 * JD-Core Version:    0.7.0.1
 */