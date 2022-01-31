import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;

public class dld
  implements Runnable
{
  public dld(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, Bundle paramBundle) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      boolean bool1;
      String str1;
      boolean bool2;
      String str2;
      String str3;
      do
      {
        return;
        bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("visibility", false);
        str1 = this.jdField_a_of_type_AndroidOsBundle.getString("enableVersion");
        bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("checked", false);
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockText");
        str3 = this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpText");
        RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, this.jdField_a_of_type_AndroidOsBundle.getString("openDevLockHelpURL"));
      } while ((!bool1) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, "6.0.1", str1) < 0));
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "update ui.");
      }
      if ((bool2) && (RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity) != null)) {
        RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity).setChecked(bool2);
      }
      if (RegisterPhoneNumActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity) != null) {
        RegisterPhoneNumActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity).setText(str2);
      }
      if (RegisterPhoneNumActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity) != null) {
        RegisterPhoneNumActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity).setText(str3);
      }
    } while (RegisterPhoneNumActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity) == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dld
 * JD-Core Version:    0.7.0.1
 */