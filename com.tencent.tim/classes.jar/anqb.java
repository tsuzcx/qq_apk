import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.Foreground;

public class anqb
  implements NetworkMonitorCallback
{
  private static anqb a;
  private ConcurrentLinkedQueue<anqb.a> J;
  
  public anqb()
  {
    if (BaseApplication.networkMonitorCallback == null)
    {
      BaseApplication.networkMonitorCallback = this;
      if (QLog.isColorLevel()) {
        QLog.d("NetworkMonitor", 2, new Object[] { "NetworkMonitor init Success! Current ProcessID=", Integer.valueOf(BaseApplicationImpl.sProcessId) });
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("NetworkMonitor", 2, "BaseApplication.mNetworkMonitorCallback!=null");
  }
  
  private int X(String paramString1, String paramString2)
  {
    int n = paramString1.length();
    int i1 = paramString2.length();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, i1 });
    int i = 0;
    int j = 0;
    while (i < n)
    {
      int k = 0;
      if (k < i1)
      {
        int m = j;
        if (paramString1.charAt(i) == paramString2.charAt(k))
        {
          if ((i != 0) && (k != 0)) {
            break label130;
          }
          arrayOfInt[i][k] = 1;
        }
        for (;;)
        {
          m = j;
          if (j < arrayOfInt[i][k]) {
            m = arrayOfInt[i][k];
          }
          k += 1;
          j = m;
          break;
          label130:
          arrayOfInt[i][k] = (arrayOfInt[(i - 1)][(k - 1)] + 1);
        }
      }
      i += 1;
    }
    return j;
  }
  
  public static anqb a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new anqb();
      }
      anqb localanqb = a;
      return localanqb;
    }
    finally {}
  }
  
  public static void a(Context paramContext, MonitorHttpInfo paramMonitorHttpInfo, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramMonitorHttpInfo == null) || (paramContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NetworkMonitor", 2, "httpInfo is null");
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramMonitorHttpInfo.getHost() + ":" + paramMonitorHttpInfo.getPort() + "/" + paramMonitorHttpInfo.getUrl());
    localHashMap.put("fileSize", paramMonitorHttpInfo.getResponseLength() + "");
    localHashMap.put("mimeType", paramMonitorHttpInfo.getMimeType());
    localHashMap.put("method", paramMonitorHttpInfo.getMethod());
    localHashMap.put("ResponseBodyHex", paramMonitorHttpInfo.getResponseBodyHex());
    localHashMap.put("type", paramMonitorHttpInfo.getType());
    localHashMap.put("ResponseCode", paramMonitorHttpInfo.getResponseCode());
    localHashMap.put("processName", paramString1);
    paramMonitorHttpInfo = paramString2;
    if (paramString2 == null) {
      paramMonitorHttpInfo = "null";
    }
    localHashMap.put("CurrentActivity", paramMonitorHttpInfo);
    localHashMap.put("reportVia", "4");
    if (paramBoolean)
    {
      anpc.a(paramContext).collectPerformance(null, "MonitorApkDownload", true, 0L, 0L, localHashMap, "");
      label231:
      if (!QLog.isColorLevel()) {
        break label348;
      }
      if (!paramBoolean) {
        break label350;
      }
    }
    label348:
    label350:
    for (paramContext = "MonitorApkDownload{";; paramContext = "UnMonitorApkDownload{")
    {
      paramContext = new StringBuilder(paramContext);
      paramContext.append(" ProcessName=").append(paramString1).append(" ");
      paramMonitorHttpInfo = localHashMap.keySet().iterator();
      while (paramMonitorHttpInfo.hasNext())
      {
        paramString1 = (String)paramMonitorHttpInfo.next();
        paramContext.append(paramString1).append("=").append((String)localHashMap.get(paramString1)).append("\n");
      }
      anpc.a(paramContext).collectPerformance(null, "UnMonitorApkDownload", true, 0L, 0L, localHashMap, "");
      break label231;
      break;
    }
    QLog.d("NetworkMonitor", 2, paramContext.toString());
  }
  
  private void b(MonitorHttpInfo paramMonitorHttpInfo, String paramString1, String paramString2)
  {
    String str = paramMonitorHttpInfo.getHost() + ":" + paramMonitorHttpInfo.getPort() + "/" + paramMonitorHttpInfo.getUrl();
    if (px(str)) {
      return;
    }
    if (this.J != null)
    {
      Object[] arrayOfObject = this.J.toArray();
      int m = arrayOfObject.length;
      int i = 0;
      while (i < m)
      {
        Object localObject = arrayOfObject[i];
        if ((localObject instanceof anqb.a))
        {
          localObject = (anqb.a)localObject;
          int k = 0;
          try
          {
            j = X(str, ((anqb.a)localObject).getUrl());
            if (QLog.isColorLevel()) {
              QLog.d("NetworkMonitor", 2, new Object[] { "url=", str, " bean's url=", ((anqb.a)localObject).getUrl(), " lcs length=", Integer.valueOf(j) });
            }
            if (j < 10) {
              break label253;
            }
            a(BaseApplicationImpl.context, paramMonitorHttpInfo, true, paramString1, paramString2);
            return;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              int j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("NetworkMonitor", 2, "Exception", localThrowable);
                j = k;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("NetworkMonitor", 2, new Object[] { "class=", localObject.getClass().getSimpleName() });
        }
        label253:
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "needDoReport!", paramMonitorHttpInfo.getHost(), paramMonitorHttpInfo.getUrl() });
    }
    a(BaseApplicationImpl.context, paramMonitorHttpInfo, false, paramString1, paramString2);
  }
  
  private static boolean px(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.endsWith("patch")) || (paramString.contains("QQpeizhiwenjian")) || (paramString.contains("/qun/configs/")) || (paramString.contains("qzonestyle")) || (paramString.contains("gxh.vip.qq.com")) || (paramString.contains("/tmp_video/quic")) || (paramString.contains("groupgift")) || (paramString.contains("vac.gtimg.cn")) || (paramString.contains("sqimg.qq.com")) || (paramString.contains("imgcache.qq.com")) || (paramString.contains("imgcache.gtimg.cn")) || (paramString.contains("i.gtimg.cn")) || (paramString.contains("cmshow.gtimg.cn")) || (paramString.contains("myapp/qq_desk")) || (paramString.contains("myapp/qqteam")) || (paramString.contains("myapp/qqt")) || (paramString.contains("plugin")) || (paramString.contains("Plugin")) || (paramString.contains("cgi-bin/httpconn")) || (paramString.contains("mobileqq/FT")) || (paramString.contains("ftn_handler")) || (paramString.contains("comp_bsdiff")) || (paramString.contains("qqpitu/jsons")) || (paramString.contains("hudongzip-1251316161.file.myqcloud.com")) || (paramString.contains("sngapp/app/update")) || (paramString.contains("qqpitu/materials/")) || (paramString.contains("hotfiles")) || (paramString.contains("2Q2W")) || (paramString.contains("soft.tbs.imtt")) || (paramString.contains("AndroidQQPlugin")));
  }
  
  public void Rk(String paramString)
  {
    if (this.J == null) {
      this.J = new ConcurrentLinkedQueue();
    }
    anqb.a locala = new anqb.a(paramString);
    this.J.add(locala);
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "doRealAddDownloadURL=", paramString });
    }
    while (!this.J.isEmpty())
    {
      paramString = (anqb.a)this.J.peek();
      if ((paramString == null) || (paramString.time - locala.time <= 600000L)) {
        break;
      }
      this.J.poll();
    }
  }
  
  public void a(MonitorHttpInfo paramMonitorHttpInfo, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "doRealAddHttpInfo=", paramMonitorHttpInfo });
    }
    if ((paramMonitorHttpInfo.getFileType() == 1) || (paramMonitorHttpInfo.getFileType() == 2)) {
      b(paramMonitorHttpInfo, paramString1, paramString2);
    }
  }
  
  public void addDownloadURL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "addDownloadURL=", paramString });
    }
    if (1 != BaseApplicationImpl.sProcessId)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", paramString);
      QIPCClientHelper.getInstance().callServer("NetworkMonitorIPCModule", "ACTION_REPORT_DOWNLOAD_URL", localBundle, new anqc(this));
      return;
    }
    Rk(paramString);
  }
  
  public void addHttpInfo(MonitorHttpInfo paramMonitorHttpInfo)
  {
    if (paramMonitorHttpInfo == null) {
      return;
    }
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (Foreground.getTopActivity() != null) {
        localObject1 = Foreground.getTopActivity().getClass().getName();
      }
      if (1 != BaseApplicationImpl.sProcessId)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO", paramMonitorHttpInfo);
        ((Bundle)localObject3).putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", BaseApplicationImpl.processName);
        paramMonitorHttpInfo = (MonitorHttpInfo)localObject1;
        if (localObject1 == null) {
          paramMonitorHttpInfo = "Null";
        }
        ((Bundle)localObject3).putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", paramMonitorHttpInfo);
        QIPCClientHelper.getInstance().getClient().callServer("NetworkMonitorIPCModule", "ACTION_REPORT_HTTPINFO", (Bundle)localObject3);
        return;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = "Null";
      }
      try
      {
        a(paramMonitorHttpInfo, "com.tencent.mobileqq", (String)localObject3);
        return;
      }
      catch (Throwable paramMonitorHttpInfo) {}
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  class a
  {
    long time;
    String url;
    
    a(String paramString)
    {
      this.url = paramString;
      this.time = System.currentTimeMillis();
    }
    
    public String getUrl()
    {
      return this.url;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anqb
 * JD-Core Version:    0.7.0.1
 */