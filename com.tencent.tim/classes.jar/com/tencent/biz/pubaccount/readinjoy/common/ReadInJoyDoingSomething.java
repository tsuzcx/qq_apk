package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import anpc;
import ausc;
import awit;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kxm;
import mqq.app.AppRuntime;
import org.w3c.dom.Node;

public class ReadInJoyDoingSomething
{
  public static String REPORT_TAG_NAME = "actKandianReportManyApps";
  public static String TAG;
  private static ConcurrentHashMap<String, String> aX;
  public static String acV = "read_in_joy_report_many_apps_key";
  public static String acW = "read_in_joy_report_many_apps_last_scan_date_key";
  public static String acX = "actKandianReportInstalledApps";
  public static String acY = "actKandianReportUsedApps";
  private static String acZ;
  public static String ada;
  private static String[] bk = { "cache", "databases", "files", "lib", "shared_prefs" };
  private static List<AppConfigInfo> gM;
  private static long sS;
  
  static
  {
    TAG = "ReadInJoyDoingSomething";
  }
  
  public static AppConfigInfoList a(AppRuntime paramAppRuntime)
  {
    if (awit.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(TAG, 1, "getReadInJoySP failed, can not get config.");
      return null;
    }
    Object localObject = kxm.a(paramAppRuntime, acV, true);
    String str;
    if (QLog.isColorLevel())
    {
      str = TAG;
      if (localObject == null) {
        break label71;
      }
    }
    label71:
    for (paramAppRuntime = localObject.toString();; paramAppRuntime = "null")
    {
      QLog.d(str, 2, new Object[] { "config: \n", paramAppRuntime });
      return (AppConfigInfoList)localObject;
    }
  }
  
  private static a a(AppConfigInfo paramAppConfigInfo)
  {
    a locala = new a();
    if (paramAppConfigInfo == null)
    {
      QLog.d(TAG, 1, "getReportData configInfo is null.");
      return locala;
    }
    locala.appCode = paramAppConfigInfo.appCode;
    locala.appVersion = getAppVersion(paramAppConfigInfo.appPackageName);
    return locala;
  }
  
  private static String a(AppConfigInfo paramAppConfigInfo)
  {
    Object localObject;
    if (paramAppConfigInfo == null)
    {
      QLog.d(TAG, 1, "configInfo is null.");
      localObject = "";
      return localObject;
    }
    if (paramAppConfigInfo.isAbsolutePath) {}
    for (paramAppConfigInfo = paramAppConfigInfo.appPath;; paramAppConfigInfo = Environment.getExternalStorageDirectory().getPath() + "/Android" + Environment.getDataDirectory() + "/" + paramAppConfigInfo.appPackageName + paramAppConfigInfo.appPath)
    {
      localObject = paramAppConfigInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, new Object[] { "path = ", paramAppConfigInfo });
      return paramAppConfigInfo;
    }
  }
  
  private static List<a> a(AppConfigInfo paramAppConfigInfo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramAppConfigInfo == null) {
      QLog.d(TAG, 2, "getReportDataList configInfo is null.");
    }
    do
    {
      String str;
      do
      {
        return localArrayList;
        str = a(paramAppConfigInfo);
      } while (TextUtils.isEmpty(str));
      sS = System.currentTimeMillis();
      a(str, localArrayList, paramAppConfigInfo);
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, new Object[] { "getReportDataList, totalScanTime = ", Long.valueOf(System.currentTimeMillis() - sS), " ms." });
    return localArrayList;
  }
  
  private static void a(AppConfigInfo paramAppConfigInfo)
  {
    a locala = a(paramAppConfigInfo);
    if ((paramAppConfigInfo == null) || (TextUtils.isEmpty(paramAppConfigInfo.appPackageName)) || (!ausc.bb(BaseApplicationImpl.getContext(), paramAppConfigInfo.appPackageName)))
    {
      String str;
      if (QLog.isColorLevel())
      {
        str = TAG;
        if (locala == null) {
          break label70;
        }
      }
      label70:
      for (paramAppConfigInfo = locala.toString();; paramAppConfigInfo = "null")
      {
        QLog.d(str, 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
        return;
      }
    }
    if (TextUtils.isEmpty(ada))
    {
      paramAppConfigInfo = new Date();
      ada = new SimpleDateFormat("yyyy.MM.dd").format(paramAppConfigInfo);
    }
    paramAppConfigInfo = new HashMap();
    paramAppConfigInfo.put("appCode", locala.appCode);
    paramAppConfigInfo.put("appVersion", locala.appVersion);
    paramAppConfigInfo.put("appScanDate", ada);
    paramAppConfigInfo.put("uin", kxm.getAccount());
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "tagName = ", acX, "\n", "reportData = \n", locala.toString(), "uin = ", kxm.getAccount(), "\n", "appScanDate = ", ada, "\n" });
    }
    anpc.a(kxm.getAppRuntime().getApplication()).collectPerformance(kxm.getAccount(), acX, true, 1L, 0L, paramAppConfigInfo, null, false);
  }
  
  private static void a(String paramString, List<a> paramList, AppConfigInfo paramAppConfigInfo)
  {
    int j = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      QLog.d(TAG, 1, "path or list is null, no need to scan.");
      return;
    }
    if (System.currentTimeMillis() - sS > 10000L)
    {
      QLog.d(TAG, 1, "scan one path more than one minute, it is time to stop");
      return;
    }
    if (r(paramList))
    {
      QLog.d(TAG, 1, "report data is enough, no need to scan any more.");
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        paramString = new File(paramString).listFiles();
        if (QLog.isColorLevel())
        {
          str = TAG;
          if (paramString != null)
          {
            i = paramString.length;
            QLog.d(str, 2, new Object[] { "files number = ", Integer.valueOf(i) });
          }
        }
        else
        {
          if (paramString == null) {
            break;
          }
          int k = paramString.length;
          i = j;
          if (i >= k) {
            break;
          }
          str = paramString[i];
          if (System.currentTimeMillis() - sS <= 10000L) {
            break label189;
          }
          QLog.d(TAG, 1, "scan one path more than one minute, it is time to stop");
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        QLog.d(TAG, 1, "scanPath throw Throwable.");
        return;
      }
      int i = 0;
      continue;
      label189:
      Object localObject = new Date(str.lastModified());
      localObject = new SimpleDateFormat("yyyy.MM.dd").format((Date)localObject);
      if (((TextUtils.isEmpty(acZ)) || (((String)localObject).compareTo(acZ) >= 0)) && (!a((String)localObject, paramList)))
      {
        a locala = a(paramAppConfigInfo);
        locala.adb = ((String)localObject);
        paramList.add(locala);
        if (r(paramList))
        {
          QLog.d(TAG, 1, "report data is enough, no need to scan any more.");
          return;
        }
      }
      if (str.isDirectory()) {
        a(str.getPath(), paramList, paramAppConfigInfo);
      }
      i += 1;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, AppConfigInfoList paramAppConfigInfoList)
  {
    if (awit.a(paramAppRuntime, true, true) == null)
    {
      QLog.d(TAG, 1, "getReadInJoySP failed, can not update config.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "updateConfig, appConfigInfoList = ", paramAppConfigInfoList.toString() });
    }
    kxm.b(acV, paramAppConfigInfoList, true);
  }
  
  public static void a(Node paramNode)
  {
    if (paramNode == null)
    {
      QLog.d(TAG, 1, "config node is null or empty, no need to parse.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "parseConfigToSP.");
    }
    AppConfigInfoList localAppConfigInfoList;
    label279:
    for (;;)
    {
      Node localNode1;
      AppConfigInfo localAppConfigInfo;
      String str1;
      String str2;
      try
      {
        localAppConfigInfoList = new AppConfigInfoList();
        paramNode = paramNode.getFirstChild();
        if (paramNode == null) {
          break;
        }
        if (!paramNode.getNodeName().equals("appLists")) {
          break label343;
        }
        localNode1 = paramNode.getFirstChild();
        if (localNode1 == null) {
          break label343;
        }
        localAppConfigInfo = new AppConfigInfo();
        Node localNode2 = localNode1.getFirstChild();
        if (localNode2 == null) {
          break label279;
        }
        if (localNode2.getNodeType() == 1)
        {
          str1 = localNode2.getNodeName();
          str2 = localNode2.getFirstChild().getNodeValue();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {}
        }
        else
        {
          localNode2 = localNode2.getNextSibling();
          continue;
        }
        if (str1.equals("appCode"))
        {
          localAppConfigInfo.appCode = str2;
          continue;
        }
        if (!str1.equals("appName")) {
          break label210;
        }
      }
      catch (Throwable paramNode)
      {
        paramNode.printStackTrace();
        QLog.d(TAG, 1, "parseConfigToSP failed, throw a throwable.");
        return;
      }
      localAppConfigInfo.appName = str2;
      continue;
      label210:
      if (str1.equals("appPackageName"))
      {
        localAppConfigInfo.appPackageName = str2;
      }
      else if (str1.equals("appPath"))
      {
        localAppConfigInfo.appPath = str2;
      }
      else if (str1.equals("isAbsolutePath"))
      {
        localAppConfigInfo.isAbsolutePath = str2.equals("1");
        continue;
        if (!TextUtils.isEmpty(localAppConfigInfo.appCode))
        {
          localAppConfigInfoList.list.add(localAppConfigInfo);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, new Object[] { "appConfigInfo = ", localAppConfigInfo.toString() });
          }
        }
        localNode1 = localNode1.getNextSibling();
        continue;
        label343:
        paramNode = paramNode.getNextSibling();
      }
    }
    a(kxm.getAppRuntime(), localAppConfigInfoList);
  }
  
  private static boolean a(String paramString, List<a> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (paramString.equals(((a)paramList.next()).adb)) {
        return true;
      }
    }
    return false;
  }
  
  private static void aHD()
  {
    Object localObject = awit.a(kxm.getAppRuntime(), true, true);
    if (localObject == null)
    {
      QLog.d(TAG, 1, "setLastScanDate failed, can not get config.");
      return;
    }
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(acW, localSimpleDateFormat.format(localDate));
    awit.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void aHE()
  {
    try
    {
      Object localObject = a(kxm.getAppRuntime());
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(TAG, 2, "config is null, no need to report.");
        return;
      }
      acZ = iN();
      gM = ((AppConfigInfoList)localObject).list;
      localObject = gM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AppConfigInfo localAppConfigInfo = (AppConfigInfo)((Iterator)localObject).next();
        a(localAppConfigInfo);
        g(a(localAppConfigInfo), REPORT_TAG_NAME);
        b(localAppConfigInfo);
      }
      aHD();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d(TAG, 1, "reportManyAppsData throwable, so sad.");
      return;
    }
    clear();
  }
  
  private static void b(AppConfigInfo paramAppConfigInfo)
  {
    int i = 0;
    Object localObject2 = a(paramAppConfigInfo);
    if ((localObject2 == null) || (TextUtils.isEmpty(((a)localObject2).appVersion)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        if (localObject2 == null) {
          break label59;
        }
      }
      label59:
      for (paramAppConfigInfo = ((a)localObject2).toString();; paramAppConfigInfo = "null")
      {
        QLog.d((String)localObject1, 2, new Object[] { "user do not install this app or reportData is null, reportData = ", paramAppConfigInfo });
        return;
      }
    }
    Object localObject1 = new ArrayList();
    localObject2 = new SimpleDateFormat("yyyy.MM.dd");
    for (;;)
    {
      if (i >= bk.length) {
        break label305;
      }
      Object localObject3 = new StringBuilder("/data/data/");
      ((StringBuilder)localObject3).append(paramAppConfigInfo.appPackageName).append("/").append(bk[i]);
      try
      {
        Object localObject4 = new File(((StringBuilder)localObject3).toString());
        if (((File)localObject4).exists())
        {
          localObject4 = ((DateFormat)localObject2).format(new Date(((File)localObject4).lastModified()));
          QLog.d(TAG, 2, new Object[] { "reportUsedApps path = ", localObject3, ", app = ", paramAppConfigInfo.appPackageName, ", lastModifiedDate = ", localObject4, ", lastScan = ", acZ });
          if (((TextUtils.isEmpty(acZ)) || (((String)localObject4).compareTo(acZ) >= 0)) && (!a((String)localObject4, (List)localObject1)))
          {
            localObject3 = a(paramAppConfigInfo);
            ((a)localObject3).adb = ((String)localObject4);
            ((List)localObject1).add(localObject3);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          QLog.d(TAG, 1, "reportUsedApps throw Throwable.");
        }
      }
      i += 1;
    }
    label305:
    g((List)localObject1, acY);
  }
  
  public static void clear()
  {
    if (gM != null) {
      gM.clear();
    }
    if (aX != null) {
      aX.clear();
    }
  }
  
  private static void g(List<a> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.d(TAG, 1, "reportData but list is null or empty.");
    }
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "tagName = ", paramString, ", reportDataList [ ", Integer.valueOf(i), " ] : \n", locala.toString(), "uin = ", kxm.getAccount(), "\n" });
        }
        localHashMap.clear();
        localHashMap.put("appCode", locala.appCode);
        localHashMap.put("appVersion", locala.appVersion);
        localHashMap.put("appUsedDate", locala.adb);
        localHashMap.put("uin", kxm.getAccount());
        anpc.a(kxm.getAppRuntime().getApplication()).collectPerformance(kxm.getAccount(), paramString, true, 1L, 0L, localHashMap, null, false);
        i += 1;
      }
    }
  }
  
  private static String getAppVersion(String paramString)
  {
    try
    {
      paramString = ausc.getPackageInfo(BaseApplicationImpl.getContext(), paramString);
      if (paramString != null)
      {
        paramString = paramString.versionName;
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      QLog.i(TAG, 1, "[getAppVersion], e = " + paramString);
    }
    return "null";
  }
  
  private static String iN()
  {
    Object localObject = awit.a(kxm.getAppRuntime(), true, true);
    if (localObject == null)
    {
      QLog.d(TAG, 1, "getLastScanDate failed, can not get config.");
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((SharedPreferences)localObject).getString(acW, "");
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, new Object[] { "lastScanDate = ", str });
    return str;
  }
  
  private static boolean r(List<a> paramList)
  {
    boolean bool = true;
    if ((paramList == null) || (paramList.size() <= 0) || (TextUtils.isEmpty(acZ))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        Object localObject = new SimpleDateFormat("yyyy.MM.dd");
        Date localDate = new Date();
        localObject = ((DateFormat)localObject).parse(acZ);
        long l1 = localDate.getTime();
        long l2 = ((Date)localObject).getTime();
        l1 = TimeUnit.DAYS.convert(l1 - l2, TimeUnit.MILLISECONDS);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, new Object[] { "list size = ", Integer.valueOf(paramList.size()), ", day = ", Long.valueOf(l1 + 1L) });
        }
        int i = paramList.size();
        if (i >= l1 + 1L) {}
      }
      catch (Throwable paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
          QLog.d(TAG, 1, "checkIsReportDataIsEnough throw a throwable.");
        }
      }
    }
    return false;
  }
  
  public static class AppConfigInfo
    implements Serializable
  {
    public String appCode;
    public String appName;
    public String appPackageName;
    public String appPath;
    public boolean isAbsolutePath;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append("appName = ").append(this.appName).append("\nappCode = ").append(this.appCode).append("\nappPackageName = ").append(this.appPackageName).append("\nappPath = ").append(this.appPath).append("\nisAbsolutePath = ");
      if (this.isAbsolutePath) {}
      for (String str = "1";; str = "0") {
        return str + "\n";
      }
    }
  }
  
  public static class AppConfigInfoList
    implements Serializable
  {
    public String actionName = ReadInJoyDoingSomething.REPORT_TAG_NAME;
    public List<ReadInJoyDoingSomething.AppConfigInfo> list = new ArrayList();
    
    public String toString()
    {
      int j = 0;
      StringBuilder localStringBuilder = new StringBuilder().append("actionName = ").append(this.actionName).append("\nappConfigInfoList size = ");
      int i;
      if (this.list != null) {
        i = this.list.size();
      }
      for (;;)
      {
        localStringBuilder = new StringBuilder(i + "\n");
        try
        {
          if (this.list != null)
          {
            i = j;
            while (i < this.list.size())
            {
              localStringBuilder.append("appConfigInfo [ ").append(i).append(" ]: \n").append(((ReadInJoyDoingSomething.AppConfigInfo)this.list.get(i)).toString());
              i += 1;
              continue;
              i = 0;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.d(ReadInJoyDoingSomething.TAG, 1, "AppConfigInfoList toString failed.");
        }
      }
      return localStringBuilder.toString();
    }
  }
  
  public static class a
  {
    String adb;
    String appCode;
    String appVersion;
    
    public String toString()
    {
      return "appCode = " + this.appCode + "\nappVersion = " + this.appVersion + "\nappUsedDate = " + this.adb + "\n";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDoingSomething
 * JD-Core Version:    0.7.0.1
 */