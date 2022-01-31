import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class bcb
  implements Runnable
{
  public bcb(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void run()
  {
    QLog.doReportLogSelf(AppSetting.a, "FeedbackReport", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bcb
 * JD-Core Version:    0.7.0.1
 */