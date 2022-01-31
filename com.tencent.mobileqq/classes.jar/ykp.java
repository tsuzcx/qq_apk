import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class ykp
  extends DownloadListener
{
  public ykp(ApolloManager paramApolloManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (paramDownloadTask.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.b();
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    String str1;
    do
    {
      return;
      str1 = paramDownloadTask.c;
      paramDownloadTask = paramDownloadTask.a();
    } while (paramDownloadTask == null);
    paramDownloadTask = (ApolloActionData)paramDownloadTask.getSerializable(str1);
    String str2 = ApolloUtil.a(paramDownloadTask, 4);
    if (str1.equals(ApolloUtil.a(paramDownloadTask, 5))) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "action res zip done acitonid=" + paramDownloadTask.actionId + " action name =" + paramDownloadTask.actionName);
        }
        if (!ApolloUtil.a(paramDownloadTask.actionId, paramDownloadTask.personNum))
        {
          FileUtils.a(str2, ApolloUtil.a(paramDownloadTask, 6), false);
          FileUtils.d(str2);
          this.a.a(paramDownloadTask);
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloManager", 2, "uncompressZip fail zip file: " + str2, localException);
        continue;
      }
      if ((!ApolloUtil.a(paramDownloadTask)) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager == null)) {
        break;
      }
      paramDownloadTask.status = 1;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((ApolloDaoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154)).b(paramDownloadTask);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(paramDownloadTask);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + paramDownloadTask.actionId + " action name =" + paramDownloadTask.actionName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ykp
 * JD-Core Version:    0.7.0.1
 */