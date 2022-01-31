import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ContactUtils;

public class tkv
  implements Runnable
{
  public tkv(QQSettingMe paramQQSettingMe, String paramString) {}
  
  public void run()
  {
    String str2 = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"".equals(str2.trim())) {}
    }
    else
    {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tkw(this, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkv
 * JD-Core Version:    0.7.0.1
 */