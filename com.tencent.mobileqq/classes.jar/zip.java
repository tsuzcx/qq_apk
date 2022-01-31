import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class zip
  implements Runnable
{
  public zip(ConditionSearchManager.DownloadTask paramDownloadTask, String paramString, File paramFile, QQAppInterface paramQQAppInterface, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask runnable start, url=" + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(ConditionSearchManager.DownloadTask.a(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$DownloadTask), (String)localObject, this.jdField_a_of_type_JavaIoFile);
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | download result = " + bool);
      }
      localObject = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
      if (localObject != null) {
        ((ConditionSearchManager)localObject).a(i, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo);
      }
      localObject = (PreDownloadController)ConditionSearchManager.DownloadTask.b(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$DownloadTask).getManager(192);
      String str = this.jdField_a_of_type_JavaLangString;
      long l1 = l2;
      if (bool)
      {
        l1 = l2;
        if (this.jdField_a_of_type_JavaIoFile.exists()) {
          l1 = this.jdField_a_of_type_JavaIoFile.length();
        }
      }
      ((PreDownloadController)localObject).a(str, l1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zip
 * JD-Core Version:    0.7.0.1
 */