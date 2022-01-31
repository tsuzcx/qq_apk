import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class dbn
  implements Runnable
{
  public dbn(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    QLog.doReportLogSelf(AppSetting.a, "FeedbackReport", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbn
 * JD-Core Version:    0.7.0.1
 */