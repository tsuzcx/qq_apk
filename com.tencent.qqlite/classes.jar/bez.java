import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class bez
  extends DownloadListener
{
  public bez(QQSettingMe paramQQSettingMe) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQSettingRedesign", 2, "-->download success!");
      }
      this.a.a.getPreferences().edit().putLong("vip_center_last_update_time", NetConnInfoCenter.getServerTimeMillis()).commit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQSettingRedesign", 2, "-->download failed!");
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->download progress!");
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->download start!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bez
 * JD-Core Version:    0.7.0.1
 */