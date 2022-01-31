import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.qphone.base.util.QLog;

public class byf
  implements Runnable
{
  public byf(AccountManageActivity paramAccountManageActivity, String paramString) {}
  
  public void run()
  {
    int i = SubAccountAssistantImpl.a().a(this.jdField_a_of_type_JavaLangString);
    if (i >= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "set stick2top fail." + this.jdField_a_of_type_JavaLangString + " count=" + i + " >=max_stick2top_count , return.");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b.a().a().b(String.valueOf(AppConstants.O), 7000) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "subaccount ru is not null");
      }
      SubAccountAssistantImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b, System.currentTimeMillis() / 1000L);
    }
    for (;;)
    {
      SubAccountAssistantImpl.a().a(this.jdField_a_of_type_JavaLangString, i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "subaccount ru is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     byf
 * JD-Core Version:    0.7.0.1
 */