import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class anns
{
  private static String a(anqe paramanqe)
  {
    if (paramanqe == null) {
      return null;
    }
    return paramanqe.getDetail();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, anqf paramanqf)
  {
    a("dc02181", paramQQAppInterface, paramanqf);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, anqe paramanqe)
  {
    if (paramanqe == null)
    {
      ExceptionTracker.trackException("CaptureReportController", "Capture Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramanqe.Uq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
    if (QLog.isColorLevel()) {}
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a(paramanqe);
      paramanqe = new Intent();
      paramanqe.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramanqe.putExtra("reporting_tag", paramString);
      paramanqe.putExtra("reporting_detail", paramQQAppInterface);
      paramanqe.putExtra("reporting_count", 1);
      paramanqe.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramanqe);
      return;
    }
    b(paramString, localQQAppInterface, a(paramanqe));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureReportController", 2, "app or detail invalid. app : " + paramQQAppInterface + "  detail : " + paramString2);
      }
      return;
    }
    String str = paramString2;
    if (paramString2.contains("${count_unknown}")) {
      str = paramString2.replace("${count_unknown}", "1");
    }
    paramString2 = new NewIntent(paramQQAppInterface.getApplication(), anfa.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", paramString1);
    paramString2.putExtra("content", str);
    paramString2.setWithouLogin(true);
    paramQQAppInterface.startServlet(paramString2);
  }
  
  public static void b(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramQQAppInterface == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.U(paramString1, paramString2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anns
 * JD-Core Version:    0.7.0.1
 */