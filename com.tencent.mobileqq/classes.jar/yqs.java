import android.os.Bundle;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class yqs
  extends DownloadListener
{
  public yqs(ApolloManager paramApolloManager) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + paramDownloadTask.e + ", status: " + paramDownloadTask.a());
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    int i = 0;
    if (paramDownloadTask == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramDownloadTask.a();
    } while (localBundle == null);
    int j = localBundle.getInt(paramDownloadTask.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + j + ",httpCode: " + paramDownloadTask.e + ", status: " + paramDownloadTask.a() + ",task.currUrl:" + paramDownloadTask.c);
    }
    if (1 == j) {}
    for (;;)
    {
      try
      {
        super.onDone(paramDownloadTask);
        if (paramDownloadTask.a() != 3) {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(false));
        }
        this.a.b();
        VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "json_download_success", i, 0, new String[0]);
        return;
      }
      catch (Exception paramDownloadTask)
      {
        QLog.e("ApolloManager", 1, "read apollo panel json content fail", paramDownloadTask);
        return;
      }
      if (2 == j)
      {
        if (paramDownloadTask.a() != 3) {
          this.a.jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloListenerManager.a(Boolean.valueOf(false));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "try to parse game json");
        }
        this.a.c();
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqs
 * JD-Core Version:    0.7.0.1
 */