import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageRoamConstants;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class zom
  implements Runnable
{
  public zom(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.a(MessageRoamConstants.a) == null))
    {
      Object localObject = new File(MessageRoamConstants.b);
      DownloadTask localDownloadTask = new DownloadTask(MessageRoamConstants.a, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.i)
        {
          localDownloadTask.k = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localDownloadTask.i);
          }
        }
      }
      localDownloadTask.h = true;
      localDownloadTask.n = false;
      localObject = new Bundle();
      localDownloaderInterface.a(localDownloadTask, this.a.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zom
 * JD-Core Version:    0.7.0.1
 */