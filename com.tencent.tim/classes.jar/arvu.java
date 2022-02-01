import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadInfoReport.1;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public class arvu
{
  public static ConcurrentHashMap<String, String> jk = new ConcurrentHashMap();
  
  public static void a(int paramInt1, @Nullable String paramString, int paramInt2, @Nullable Object paramObject)
  {
    try
    {
      ThreadManager.executeOnSubThread(new DownloadInfoReport.1(paramInt1, paramString, paramObject, paramInt2));
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("UniformDownloadEvent", 2, paramString, new Object[] { " in reportSpecialCareAPKDownloadInfo" });
    }
  }
  
  public static void a(Context paramContext, DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "downloadInfo is null");
      }
    }
    do
    {
      return;
      anqb.a().addDownloadURL(paramDownloadInfo.urlStr);
    } while (px(paramDownloadInfo.urlStr));
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramDownloadInfo.urlStr);
    localHashMap.put("NetworkType", aqiw.getNetworkType(paramContext) + "");
    Object localObject1;
    if (isAppOnForeground(paramContext)) {
      localObject1 = "1";
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localHashMap.put("isForeground", localObject1);
      localHashMap.put("reportVia", "3");
      localObject1 = new Throwable().getStackTrace();
      localStringBuilder = new StringBuilder();
      try
      {
        if (jk.containsKey(paramDownloadInfo.appId)) {
          localStringBuilder.append((String)jk.remove(paramDownloadInfo.appId));
        }
        for (;;)
        {
          label175:
          int i = 1;
          while (i < localObject1.length)
          {
            localStringBuilder.append(localObject1[i].toString());
            i += 1;
          }
          localObject1 = "0";
          break;
          if (jk.containsKey(paramDownloadInfo.urlStr)) {
            localStringBuilder.append((String)jk.remove(paramDownloadInfo.urlStr));
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label175;
      }
    }
    Object localObject3;
    label335:
    label347:
    Object localObject2;
    if (localStringBuilder.length() < 950)
    {
      localHashMap.put("Stack", localStringBuilder.toString());
      localHashMap.put("_filesize_from_dlg", paramDownloadInfo.fileSize + "");
      localObject3 = paramDownloadInfo.packageName;
      localHashMap.put("_filename_from_dlg", localObject3);
      if (!paramDownloadInfo.ddw) {
        break label742;
      }
      localHashMap.put("isAPK", "1");
      if (paramDownloadInfo.via == null) {
        break label755;
      }
      localObject1 = paramDownloadInfo.via;
      localHashMap.put("ReferURL", localObject1);
      localObject1 = paramDownloadInfo.source;
      localObject2 = new StringBuilder(paramDownloadInfo.urlStr);
      ((StringBuilder)localObject2).append(";").append((String)localHashMap.get("NetworkType")).append(";").append((String)localObject1).append(";").append((String)localObject3).append(";").append((String)localHashMap.get("_filesize_from_dlg")).append(";").append((String)localHashMap.get("ReferURL"));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1180;
      }
      if (!localStringBuilder.toString().contains("DownloadInterface")) {
        break label761;
      }
      paramDownloadInfo = "DownloadAPI";
    }
    for (;;)
    {
      label473:
      if (TextUtils.isEmpty(paramDownloadInfo))
      {
        anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
        paramDownloadInfo = (String)localHashMap.get("isForeground");
        localObject1 = (String)localHashMap.get("isAPK");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder().append((String)localHashMap.get("Stack"));
        if (localHashMap.containsKey("Stack1")) {}
        for (paramContext = (String)localHashMap.get("Stack1");; paramContext = "")
        {
          anot.a(null, "dc00898", "", "", "0X800A003", "0X800A003", 1, 0, paramDownloadInfo, (String)localObject1, (String)localObject2, paramContext);
          if (!QLog.isColorLevel()) {
            break label1161;
          }
          paramContext = new StringBuilder();
          paramDownloadInfo = localHashMap.keySet().iterator();
          while (paramDownloadInfo.hasNext())
          {
            localObject1 = (String)paramDownloadInfo.next();
            paramContext.append((String)localObject1).append("=").append((String)localHashMap.get(localObject1)).append("\n");
          }
          localHashMap.put("Stack", localStringBuilder.substring(0, 950));
          if (localStringBuilder.length() < 1901)
          {
            localHashMap.put("Stack1", localStringBuilder.substring(950));
            break;
          }
          localHashMap.put("Stack1", localStringBuilder.substring(950, 1900));
          break;
          label742:
          localHashMap.put("isAPK", "0");
          break label335;
          label755:
          localObject1 = "";
          break label347;
          label761:
          if (localStringBuilder.toString().contains("DownloadReceiver"))
          {
            paramDownloadInfo = "DownloadManager";
            break label473;
          }
          if (localStringBuilder.toString().contains("now.download.js.DownloadJSApi"))
          {
            paramDownloadInfo = "biz_src_now";
            break label473;
          }
          if (localStringBuilder.toString().contains("DownloadApi"))
          {
            if (((String)localObject3).equals("com.tencent.qqmusic"))
            {
              paramDownloadInfo = "biz_src_qqmusic";
              break label473;
            }
            if (((String)localObject3).equals("com.tencent.nijigen"))
            {
              paramDownloadInfo = "biz_src_zz_bodong";
              break label473;
            }
            if (((String)localObject3).equals("com.tencent.mobileqq"))
            {
              paramDownloadInfo = "biz_src_yyb";
              break label473;
            }
            if (((String)localObject3).equals("com.tencent.reading"))
            {
              paramDownloadInfo = "biz_src_jc_neirong";
              break label473;
            }
            if (!((String)localObject3).equals("com.tencent.news.lite")) {
              break label1180;
            }
            paramDownloadInfo = "biz_src_news";
            break label473;
          }
          if (paramDownloadInfo.via != null) {}
          for (paramDownloadInfo = paramDownloadInfo.via;; paramDownloadInfo = "")
          {
            if (TextUtils.isEmpty(paramDownloadInfo)) {
              break label1180;
            }
            if (!paramDownloadInfo.equals("ANDROIDQQ.QQMUSIC.GENE")) {
              break label946;
            }
            paramDownloadInfo = "biz_src_qqmusic";
            break;
          }
          if (paramDownloadInfo.equals("1"))
          {
            paramDownloadInfo = "biz_src_zz_bodong";
            break label473;
          }
          if ((paramDownloadInfo.equals("ANDROID.QQ.NEWYYBAPK")) || (paramDownloadInfo.startsWith("YYBH5.STORE.COMMONDETAIL.FEED.ADVERTISE")) || (paramDownloadInfo.equals("ANDROIDQQ.NEWYYB.XINJIFUWUHAO")))
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label1180;
            }
            paramDownloadInfo = "biz_src_yyb";
            break label473;
          }
          if (!paramDownloadInfo.startsWith("ANDROIDQQ.FEED.ADVERTISE")) {
            break label1180;
          }
          paramDownloadInfo = "biz_src_ads";
          break label473;
        }
      }
      label598:
      localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramDownloadInfo);
      label946:
      anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      paramDownloadInfo = (String)localHashMap.get("isForeground");
      localObject1 = (String)localHashMap.get("isAPK");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder().append((String)localHashMap.get("Stack"));
      if (localHashMap.containsKey("Stack1")) {}
      for (paramContext = (String)localHashMap.get("Stack1");; paramContext = "")
      {
        anot.a(null, "dc00898", "", "", "0X800A002", "0X800A002", 1, 0, paramDownloadInfo, (String)localObject1, (String)localObject2, paramContext);
        break label598;
        label1161:
        break;
      }
      QLog.d("UniformDownloadEvent", 2, paramContext.toString());
      return;
      label1180:
      paramDownloadInfo = (DownloadInfo)localObject1;
    }
  }
  
  public static void a(Context paramContext, WadlParams paramWadlParams)
  {
    if ((paramWadlParams == null) || (paramContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "wadlParams is null");
      }
      return;
    }
    anqb.a().addDownloadURL(paramWadlParams.apkUrl);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramWadlParams.apkUrl);
    localHashMap.put("NetworkType", aqiw.getNetworkType(paramContext) + "");
    Object localObject;
    StringBuilder localStringBuilder;
    if (isAppOnForeground(paramContext))
    {
      localObject = "1";
      localHashMap.put("isForeground", localObject);
      localHashMap.put("reportVia", "2");
      localObject = new Throwable().getStackTrace();
      localStringBuilder = new StringBuilder();
      if (!jk.containsKey(paramWadlParams.appId)) {
        break label200;
      }
      localStringBuilder.append((String)jk.remove(paramWadlParams.appId));
    }
    for (;;)
    {
      int i = 1;
      while (i < localObject.length)
      {
        localStringBuilder.append(localObject[i].toString());
        i += 1;
      }
      localObject = "0";
      break;
      label200:
      if (jk.containsKey(paramWadlParams.apkUrl)) {
        localStringBuilder.append((String)jk.remove(paramWadlParams.apkUrl));
      }
    }
    if (localStringBuilder.length() < 950)
    {
      localHashMap.put("Stack", localStringBuilder.toString());
      localHashMap.put("_filesize_from_dlg", paramWadlParams.aBq + "");
      localHashMap.put("_filename_from_dlg", paramWadlParams.packageName);
      if (paramWadlParams.dqZ) {
        break label544;
      }
      localHashMap.put("isAPK", "1");
      label318:
      localHashMap.put("ReferURL", paramWadlParams.bLE);
      localObject = paramWadlParams.sourceId;
      if (paramWadlParams.bLE != null) {
        break label557;
      }
      paramWadlParams = "";
      label345:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label755;
      }
      if ((!paramWadlParams.contains("youxi.vip.qq.com/m/act/")) && (!paramWadlParams.contains("cmshow.qq.com"))) {
        break label565;
      }
      paramWadlParams = "biz_src_optools";
    }
    for (;;)
    {
      label376:
      if (TextUtils.isEmpty(paramWadlParams)) {
        anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        paramContext = new StringBuilder();
        paramWadlParams = localHashMap.keySet().iterator();
        while (paramWadlParams.hasNext())
        {
          localObject = (String)paramWadlParams.next();
          paramContext.append((String)localObject).append("=").append((String)localHashMap.get(localObject)).append("\n");
        }
        localHashMap.put("Stack", localStringBuilder.substring(0, 950));
        if (localStringBuilder.length() < 1901)
        {
          localHashMap.put("Stack1", localStringBuilder.substring(950));
          break;
        }
        localHashMap.put("Stack1", localStringBuilder.substring(950, 1900));
        break;
        label544:
        localHashMap.put("isAPK", "0");
        break label318;
        label557:
        paramWadlParams = paramWadlParams.bLE;
        break label345;
        label565:
        if (paramWadlParams.contains("ag.qq.com/kd/detail"))
        {
          paramWadlParams = "biz_src_zz_dianjing";
          break label376;
        }
        if ((paramWadlParams.contains("m.gamecenter.qq.com")) || (paramWadlParams.contains("imgcache.qq.com")) || (paramWadlParams.contains("sgame.gamecenter.qq.com")))
        {
          paramWadlParams = "biz_src_zf_games";
          break label376;
        }
        if (paramWadlParams.equals("publicAccount"))
        {
          paramWadlParams = "biz_src_zf_games";
          break label376;
        }
        if ((paramWadlParams.equals("YUYUE")) || (paramWadlParams.equals("YANCHI")))
        {
          paramWadlParams = "biz_src_zf_games";
          break label376;
        }
        if ((paramWadlParams.contains("cdn.vip.qq.com/club/client/comic/")) || (paramWadlParams.contains("qc.vip.qq.com")))
        {
          paramWadlParams = "biz_src_zz_bodong";
          break label376;
        }
        if (paramWadlParams.contains("m.egame.qq.com"))
        {
          paramWadlParams = "biz_src_zz_dianjing";
          break label376;
        }
        paramWadlParams = "biz_src_feeds_kandianads";
        break label376;
        localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramWadlParams);
        anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      }
      label742:
      break;
      QLog.d("UniformDownloadEvent", 2, paramContext.toString());
      return;
      label755:
      paramWadlParams = (WadlParams)localObject;
    }
  }
  
  public static void a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo)
  {
    a(paramAppInterface.getApp(), paramDownloadInfo);
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
      paramContext = paramContext.getApplicationContext().getPackageName();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null)) {
          if (!localRunningAppProcessInfo.processName.equals(paramContext))
          {
            boolean bool = localRunningAppProcessInfo.processName.startsWith(paramContext + ":");
            if (!bool) {
              break;
            }
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  private static boolean px(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.endsWith("zip")) || (paramString.endsWith("7z")));
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("UniformDownloadEvent", 2, "info or context is null");
      }
    }
    label408:
    label436:
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      localHashMap.put("url", paramString1);
      localHashMap.put("NetworkType", aqiw.getNetworkType(paramContext) + "");
      if (isAppOnForeground(paramContext)) {}
      StringBuilder localStringBuilder;
      for (paramString1 = "1";; paramString1 = "0")
      {
        localHashMap.put("isForeground", paramString1);
        localHashMap.put("reportVia", "6");
        paramString1 = new Throwable().getStackTrace();
        localStringBuilder = new StringBuilder();
        int i = 1;
        while (i < paramString1.length)
        {
          localStringBuilder.append(paramString1[i].toString());
          i += 1;
        }
      }
      if (localStringBuilder.length() < 950)
      {
        localHashMap.put("Stack", localStringBuilder.toString());
        localHashMap.put("_filesize_from_dlg", "");
        localHashMap.put("_filename_from_dlg", paramString2);
        localHashMap.put("isAPK", "1");
        localHashMap.put("ReferURL", "");
        if (!TextUtils.isEmpty(paramString3)) {
          break label408;
        }
        anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent_NO_SOURCE", true, 0L, 0L, localHashMap, "");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label436;
        }
        paramContext = new StringBuilder();
        paramString1 = localHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramContext.append(paramString2).append("=").append((String)localHashMap.get(paramString2)).append("\n");
        }
        localHashMap.put("Stack", localStringBuilder.substring(0, 950));
        if (localStringBuilder.length() < 1901)
        {
          localHashMap.put("Stack1", localStringBuilder.substring(950));
          break;
        }
        localHashMap.put("Stack1", localStringBuilder.substring(950, 1900));
        break;
        localHashMap.put("DOWNLOAD_BIG_BROTHER_SOURCE", paramString3);
        anpc.a(paramContext).collectPerformance(null, "UniformDownloadEvent", true, 0L, 0L, localHashMap, "");
      }
    }
    QLog.d("UniformDownloadEvent", 2, paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvu
 * JD-Core Version:    0.7.0.1
 */