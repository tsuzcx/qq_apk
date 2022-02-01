import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.notify.DownloadGlobalListener;
import com.tencent.tmdownloader.notify.DownloadTaskInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class arwd
  implements DownloadGlobalListener
{
  private static arwd a;
  
  private arwd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, "TMADownloadMonitor Init");
    }
  }
  
  public static arwd a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      a = new arwd();
      arwd localarwd = a;
      return localarwd;
    }
    finally {}
  }
  
  public static void a(Context paramContext, DownloadTaskInfo paramDownloadTaskInfo)
  {
    if ((paramDownloadTaskInfo == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "downloadTaskInfo is null or context==null");
      }
    }
    label401:
    for (;;)
    {
      return;
      anqb.a().addDownloadURL(paramDownloadTaskInfo.url);
      if (!px(paramDownloadTaskInfo.url))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("url", paramDownloadTaskInfo.url);
        localHashMap.put("NetworkType", aqiw.getNetworkType(paramContext) + "");
        localHashMap.put("reportVia", "5");
        if (paramDownloadTaskInfo.stackInfo.length() < 950)
        {
          localHashMap.put("Stack", paramDownloadTaskInfo.stackInfo);
          localHashMap.put("_filesize_from_dlg", "0");
          localHashMap.put("_filename_from_dlg", paramDownloadTaskInfo.pkgName);
          if (paramDownloadTaskInfo.versionCode <= 0) {
            break label364;
          }
          localHashMap.put("isAPK", "1");
          label160:
          localHashMap.put("VersionCode", paramDownloadTaskInfo.versionCode + "");
          paramDownloadTaskInfo = paramDownloadTaskInfo.source;
          if (!TextUtils.isEmpty(paramDownloadTaskInfo)) {
            break label376;
          }
          anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label401;
          }
          paramContext = new StringBuilder();
          paramDownloadTaskInfo = localHashMap.keySet().iterator();
          while (paramDownloadTaskInfo.hasNext())
          {
            String str = (String)paramDownloadTaskInfo.next();
            paramContext.append(str).append("=").append((String)localHashMap.get(str)).append("\n");
          }
          localHashMap.put("Stack", paramDownloadTaskInfo.stackInfo.substring(0, 950));
          if (paramDownloadTaskInfo.stackInfo.length() < 1901)
          {
            localHashMap.put("Stack1", paramDownloadTaskInfo.stackInfo.substring(950));
            break;
          }
          localHashMap.put("Stack1", paramDownloadTaskInfo.stackInfo.substring(950, 1900));
          break;
          label364:
          localHashMap.put("isAPK", "0");
          break label160;
          label376:
          localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramDownloadTaskInfo);
          anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
        }
      }
    }
    QLog.d("UniformDownloadEvent", 2, paramContext.toString());
  }
  
  private static boolean px(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.endsWith("zip")) || (paramString.endsWith("7z")));
  }
  
  public void onTaskCompleted(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskCompleted,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskFailed(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskFailed,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskPaused(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskPaused,", paramDownloadTaskInfo });
    }
  }
  
  public void onTaskStarted(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TMADownloadMonitor", 2, new Object[] { "onTaskStarted,", paramDownloadTaskInfo });
    }
    a(BaseApplicationImpl.getContext(), paramDownloadTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arwd
 * JD-Core Version:    0.7.0.1
 */