import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class who
  implements Runnable
{
  public who(TIMUserManager paramTIMUserManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, this.b))
      {
        TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager);
        TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, false);
        TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        localEditor.putBoolean("tim_user_special_need_force_download", TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadTimTheme TimIconsState " + TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager));
      }
      return;
      TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, 4);
      continue;
      TIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTimTIMUserManager, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */