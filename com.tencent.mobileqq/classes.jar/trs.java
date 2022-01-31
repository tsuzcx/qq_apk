import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

public class trs
  extends DownloadListener
{
  public trs(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onDone status: " + paramDownloadTask.e + ", url: " + paramDownloadTask.a);
    }
    int i = paramDownloadTask.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramDownloadTask.a;
      if (!"http://imgcache.qq.com/qqshow/admindata/comdata/chatHistoryEvent/xydata.json".contains(str)) {
        break label104;
      }
      QQSettingMsgHistoryActivity.a(this.a, paramDownloadTask);
    }
    label104:
    while (!QLog.isColorLevel())
    {
      return;
      str = paramDownloadTask.a.substring(0, i - 1);
      break;
    }
    QLog.e("IphoneTitleBarActivity", 2, "onDone unkonw url: " + paramDownloadTask.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trs
 * JD-Core Version:    0.7.0.1
 */