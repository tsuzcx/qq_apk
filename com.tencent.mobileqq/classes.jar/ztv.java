import com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.qphone.base.util.QLog;

public class ztv
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  public ztv(QQConfMeetingLogReportHelper paramQQConfMeetingLogReportHelper) {}
  
  public void a(int paramInt)
  {
    QLog.e("QQConfMeetingLogReportHelper", 1, "doReportLocalLog OnGetLocalLogListener onError, code=" + paramInt);
  }
  
  public void a(String paramString)
  {
    QQConfMeetingLogReportHelper.a(this.a, paramString);
  }
  
  public void b(int paramInt)
  {
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztv
 * JD-Core Version:    0.7.0.1
 */