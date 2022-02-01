import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.report.AppCenterReporter.1;
import com.tencent.open.appstore.report.AppCenterReporter.2;
import com.tencent.open.appstore.report.AppCenterReporter.3;
import com.tencent.open.appstore.report.AppCenterReporter.4;
import com.tencent.open.appstore.report.AppCenterReporter.5;
import com.tencent.open.appstore.report.AppCenterReporter.6;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class arwk
{
  private static MonitorTask a(DownloadInfo paramDownloadInfo)
  {
    MonitorTask localMonitorTask = new MonitorTask();
    localMonitorTask.appName = paramDownloadInfo.pushTitle;
    localMonitorTask.packageName = paramDownloadInfo.packageName;
    localMonitorTask.versionCode = paramDownloadInfo.versionCode;
    localMonitorTask.fileMd5 = paramDownloadInfo.fileMd5;
    try
    {
      localMonitorTask.yybApkId = Long.parseLong(paramDownloadInfo.cCL);
      localMonitorTask.yybAppId = Long.parseLong(paramDownloadInfo.appId);
      label62:
      localMonitorTask.downloadUrl = paramDownloadInfo.urlStr;
      localMonitorTask.additionalId = paramDownloadInfo.ticket;
      localMonitorTask.filePath = paramDownloadInfo.filePath;
      localMonitorTask.traceId = paramDownloadInfo.uniqueId;
      localMonitorTask.externalParams = new HashMap();
      localMonitorTask.externalParams.put("via", paramDownloadInfo.via);
      return localMonitorTask;
    }
    catch (Throwable localThrowable)
    {
      break label62;
    }
  }
  
  private static String a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return arwn.a().i(paramDownloadInfo.extraData).k(paramDownloadInfo.pageId).j(paramDownloadInfo.kx).l(paramDownloadInfo.cDH).m(paramDownloadInfo.via).Dv();
  }
  
  public static void a(arwn paramarwn)
  {
    paramarwn = paramarwn.Du();
    arwt.i("AppCenterReporter", "[reportExposure] type=3002\ndata=" + paramarwn);
    SDKReportManager2.getInstance().postReport(3002, paramarwn);
  }
  
  private static String b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return "";
    }
    return arwn.a().a(paramDownloadInfo.pushTitle).b(paramDownloadInfo.packageName).a(paramDownloadInfo.versionCode).c(paramDownloadInfo.appId).d(paramDownloadInfo.cCL).e(paramDownloadInfo.cCM).f(paramDownloadInfo.channelId).g(paramDownloadInfo.urlStr).h(paramDownloadInfo.recommendId).Dw();
  }
  
  public static void b(arwn paramarwn)
  {
    paramarwn = paramarwn.Du();
    arwt.i("AppCenterReporter", "[reportClick] type=3003\ndata=" + paramarwn);
    SDKReportManager2.getInstance().postReport(3003, paramarwn);
  }
  
  public static void b(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    ThreadManager.excute(new AppCenterReporter.3(paramDownloadInfo, paramInt, paramString), 16, null, true);
  }
  
  private static long bk(String paramString)
  {
    if (aewh.g(paramString, aroi.a().getContext())) {}
    try
    {
      long l = new File(GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir).length();
      return l;
    }
    catch (Throwable paramString)
    {
      label77:
      break label77;
    }
    arwt.i("AppCenterReporter", "[getInstalledAppFileSize]" + paramString + ": NOT INSTALLED!");
    return 0L;
  }
  
  public static void dA(String paramString, boolean paramBoolean)
  {
    arwt.i("AppCenterReporter", ">notifyInstallFinish " + paramString + "|" + paramBoolean);
    ThreadManager.excute(new AppCenterReporter.6(paramString, paramBoolean), 16, null, true);
  }
  
  private static String e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return arwn.a().i(paramString5).k(paramString1).j(paramString2).l(paramString3).m(paramString4).Dv();
  }
  
  public static void g(DownloadInfo paramDownloadInfo, int paramInt)
  {
    ThreadManager.excute(new AppCenterReporter.5(paramDownloadInfo, paramInt), 16, null, true);
  }
  
  public static void p(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = e(paramString1, paramString2, paramString3, paramString4, paramString5);
    arwt.i("AppCenterReporter", "[reportNormalExposure] type=3001\ndata=" + paramString1);
    SDKReportManager2.getInstance().postReport(3001, paramString1);
  }
  
  public static void q(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.1(paramDownloadInfo), 16, null, true);
  }
  
  public static void q(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = e(paramString1, paramString2, paramString3, paramString4, paramString5) + "|" + arwn.a().Dx() + "|" + "200";
    arwt.i("AppCenterReporter", "[reportClick] type=3003\ndata=" + paramString1);
    SDKReportManager2.getInstance().postReport(3003, paramString1);
  }
  
  public static void r(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new AppCenterReporter.2(paramDownloadInfo), 16, null, true);
  }
  
  public static void report(int paramInt, String paramString)
  {
    arwt.i("AppCenterReporter", "[report] type=" + paramInt + "\ndata=" + paramString);
    SDKReportManager2.getInstance().postReport(paramInt, paramString);
  }
  
  public static void s(DownloadInfo paramDownloadInfo)
  {
    w(paramDownloadInfo);
    ThreadManager.excute(new AppCenterReporter.4(paramDownloadInfo), 16, null, true);
  }
  
  public static void t(DownloadInfo paramDownloadInfo)
  {
    arwt.i("AppCenterReporter", ">tryInitMonitorTask info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask = ReplaceMonitor.get().getTask(paramDownloadInfo.ticket);
    arwt.i("AppCenterReporter", ">tryInitMonitorTask info=" + paramDownloadInfo);
    if (localMonitorTask == null) {}
    for (paramDownloadInfo = a(paramDownloadInfo);; paramDownloadInfo = localMonitorTask)
    {
      ReplaceMonitor.get().addTask(paramDownloadInfo);
      return;
      if (TextUtils.isEmpty(localMonitorTask.filePath)) {
        localMonitorTask.filePath = paramDownloadInfo.filePath;
      }
      arwt.i("AppCenterReporter", ">tryInitMonitorTask 已有task2:" + localMonitorTask);
    }
  }
  
  public static void u(DownloadInfo paramDownloadInfo)
  {
    arwt.i("AppCenterReporter", ">downloadSuccCheck info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask2 = ReplaceMonitor.get().getTask(paramDownloadInfo.ticket);
    MonitorTask localMonitorTask1;
    if (localMonitorTask2 == null)
    {
      localMonitorTask1 = a(paramDownloadInfo);
      ReplaceMonitor.get().addTask(localMonitorTask1);
    }
    for (;;)
    {
      arwt.i("AppCenterReporter", ">downloadSuccCheck task:" + localMonitorTask1);
      if (localMonitorTask1 == null) {
        break;
      }
      ReplaceMonitor.get().execSync(localMonitorTask1, MonitorStep.DOWNLOADING);
      return;
      localMonitorTask1 = localMonitorTask2;
      if (TextUtils.isEmpty(localMonitorTask2.filePath))
      {
        localMonitorTask2.filePath = paramDownloadInfo.filePath;
        localMonitorTask1 = localMonitorTask2;
      }
    }
  }
  
  public static void v(DownloadInfo paramDownloadInfo)
  {
    arwt.i("AppCenterReporter", ">deleteCheck info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {}
    do
    {
      return;
      paramDownloadInfo = ReplaceMonitor.get().getTask(paramDownloadInfo.ticket);
    } while (paramDownloadInfo == null);
    ReplaceMonitor.get().deleteTask(paramDownloadInfo);
  }
  
  public static void w(DownloadInfo paramDownloadInfo)
  {
    arwt.i("AppCenterReporter", ">installStartCheck ,info:" + paramDownloadInfo);
    if (paramDownloadInfo == null) {
      return;
    }
    MonitorTask localMonitorTask2 = ReplaceMonitor.get().getTask(paramDownloadInfo.ticket);
    MonitorTask localMonitorTask1;
    if (localMonitorTask2 == null)
    {
      localMonitorTask1 = a(paramDownloadInfo);
      ReplaceMonitor.get().addTask(localMonitorTask1);
    }
    for (;;)
    {
      arwt.i("AppCenterReporter", ">installStartCheck task:" + localMonitorTask1);
      if (localMonitorTask1 == null) {
        break;
      }
      ReplaceMonitor.get().execSync(localMonitorTask1, MonitorStep.BEFORE_INSTALL);
      return;
      localMonitorTask1 = localMonitorTask2;
      if (TextUtils.isEmpty(localMonitorTask2.filePath))
      {
        localMonitorTask2.filePath = paramDownloadInfo.filePath;
        localMonitorTask1 = localMonitorTask2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwk
 * JD-Core Version:    0.7.0.1
 */