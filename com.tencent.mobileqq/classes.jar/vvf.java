import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vvf
  implements Runnable
{
  public vvf(QIMUserManager paramQIMUserManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    if (QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, this.jdField_a_of_type_JavaLangString, this.b) == 0) {
      if (QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, this.b))
      {
        QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager);
        QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, false);
        QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, 2);
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        localEditor.putBoolean("qim_user_special_need_force_download", QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager));
        localEditor.commit();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMUserManager", 2, this.jdField_a_of_type_Boolean + " startDownLoadQimTheme QimIconsState " + QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager));
      }
      return;
      QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, 4);
      continue;
      QIMUserManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioQimQIMUserManager, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vvf
 * JD-Core Version:    0.7.0.1
 */