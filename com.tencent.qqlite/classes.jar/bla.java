import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class bla
  implements Runnable
{
  public bla(SplashActivity paramSplashActivity, int paramInt) {}
  
  public void run()
  {
    String str2 = SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity);
    if (("消息".equals(str2)) || ("联系人".equals(str2))) {
      if (!"消息".equals(str2)) {
        break label171;
      }
    }
    label171:
    for (String str1 = "Msg_tab";; str1 = "Contacts_tab")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app, "CliOper", "", "", str1, str1, 0, 0, "", "", "", "");
      if ((SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != null) && (SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity).getBoolean("theme_voice_setting_" + this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(), true))) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.b(this.jdField_a_of_type_Int + 1);
      }
      if (str2 != null)
      {
        SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "消息", str2);
        SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "联系人", str2);
        SplashActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, "我", str2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bla
 * JD-Core Version:    0.7.0.1
 */