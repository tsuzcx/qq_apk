import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class wbt
  extends DownloadListener
{
  public wbt(BlessManager paramBlessManager, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).remove(this.jdField_a_of_type_JavaLangString);
    if (paramDownloadTask.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager) != null) && (this.b.equals(BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager).starVideo))) {
        BlessManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      BlessManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + paramDownloadTask.b + " code=" + paramDownloadTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbt
 * JD-Core Version:    0.7.0.1
 */