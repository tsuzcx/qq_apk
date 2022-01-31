import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class zwp
  implements AsyncBack, Runnable
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public zwp(UpgradeTIMManager paramUpgradeTIMManager, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private void a()
  {
    UpgradeTIMManager.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager).postDelayed(new zwq(this), 3000L);
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new zwr(this), 8, null, false);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(this, 5, null, false);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeTIMManager", 4, new Object[] { "downloading,  progress = ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("UpgradeTIMManager", 2, new Object[] { "on download result, code=", Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      UpgradeTIMManager.b(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager);
      return;
    }
    if (paramInt == 10)
    {
      paramInt = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (paramInt + 1);
      if (paramInt < 3)
      {
        a();
        return;
      }
    }
    UpgradeTIMManager.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "start download...");
    }
    if (!NetworkUtil.h(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "run download, wifi not connected...");
      }
      UpgradeTIMManager.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager);
      return;
    }
    ReportController.b(UpgradeTIMManager.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager), "CliOper", "", "", "0X8008A47", "0X8008A47", 0, 0, "", "", "", "");
    UpgradeTIMManager.a(this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMManager).a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, this.b, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwp
 * JD-Core Version:    0.7.0.1
 */