import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class trr
  implements Runnable
{
  public trr(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "checkChatHistoryEventConfig start...");
    }
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.a.app.getManager(46)).a(1);
    if ((localDownloaderInterface != null) && (localDownloaderInterface.a("http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json") == null))
    {
      Object localObject = new File(QQSettingMsgHistoryActivity.c);
      DownloadTask localDownloadTask = new DownloadTask("http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json", (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localDownloadTask.i = this.a.app.getPreferences().getLong("chatHistoryEventJsonLastModified", 0L);
        if (((Long)localObject).longValue() != localDownloadTask.i)
        {
          localDownloadTask.k = true;
          if (QLog.isColorLevel()) {
            QLog.d("IphoneTitleBarActivity", 2, "checkChatHistoryEventConfig file modified local time: " + localObject + ", sp time: " + localDownloadTask.i);
          }
        }
      }
      localDownloadTask.h = true;
      localDownloadTask.n = false;
      localObject = new Bundle();
      localDownloaderInterface.a(localDownloadTask, this.a.a, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trr
 * JD-Core Version:    0.7.0.1
 */