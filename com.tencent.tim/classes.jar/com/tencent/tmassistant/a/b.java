package com.tencent.tmassistant.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.tmassistant.common.jce.AppDataReportConfig;
import com.tencent.tmassistant.common.jce.AppExtInfoParam;
import com.tencent.tmassistant.common.jce.SDKDataReportRequest;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.n;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmassistantbase.util.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements f
{
  private static volatile b a = null;
  private PackageManager b;
  private e c = new e();
  private long d = 0L;
  private String e = "";
  private int f = 0;
  private boolean g = false;
  
  private b()
  {
    this.c.a(this);
    try
    {
      Context localContext = GlobalUtil.getInstance().getContext().getApplicationContext();
      this.b = localContext.getPackageManager();
      this.e = localContext.getExternalCacheDir().getParent();
      this.e = new File(this.e).getParent();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private long a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = this.e + File.separator + paramString1;; paramString1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + paramString2) {
      return a.a(new File(paramString1));
    }
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private d a(byte paramByte, AppExtInfoParam paramAppExtInfoParam, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo)
  {
    System.currentTimeMillis();
    d locald = new d(null);
    locald.a = paramPackageInfo.packageName;
    locald.b = paramByte;
    if (paramAppExtInfoParam == null) {
      return locald;
    }
    System.currentTimeMillis();
    int i = paramAppExtInfoParam.flag;
    File localFile = new File(paramApplicationInfo.sourceDir);
    if ((i & 0x1) != 0) {
      locald.c = localFile.length();
    }
    System.currentTimeMillis();
    if ((i & 0x2) != 0) {
      locald.d = b(paramApplicationInfo.packageName);
    }
    System.currentTimeMillis();
    if ((i & 0x4) != 0) {
      locald.e = a(paramApplicationInfo.packageName, paramAppExtInfoParam.oftenUsedPath);
    }
    System.currentTimeMillis();
    if ((i & 0x8) != 0) {
      locald.f = c(paramApplicationInfo.sourceDir);
    }
    System.currentTimeMillis();
    if ((i & 0x10) != 0)
    {
      locald.g = paramPackageInfo.firstInstallTime;
      locald.h = paramPackageInfo.lastUpdateTime;
    }
    if ((i & 0x20) != 0) {
      locald.i = paramPackageInfo.versionCode;
    }
    System.currentTimeMillis();
    if ((i & 0x40) != 0) {
      locald.j = a.a(paramPackageInfo.packageName, paramAppExtInfoParam.targetFileNameList);
    }
    System.currentTimeMillis();
    this.f += 1;
    return locald;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return paramString;
        i = paramString.indexOf(".");
      } while (i == -1);
      i = paramString.indexOf(".", i + 1);
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  private ArrayList<String> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = a((String)paramList.next());
      if (((Map)localObject).containsKey(str)) {
        ((Map)localObject).put(str, Integer.valueOf(((Integer)((Map)localObject).get(str)).intValue() + 1));
      } else {
        ((Map)localObject).put(str, Integer.valueOf(1));
      }
    }
    paramList = ((Map)localObject).entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      if (((Integer)((Map.Entry)localObject).getValue()).intValue() >= 7) {
        localArrayList.add(((Map.Entry)localObject).getKey());
      }
    }
    return localArrayList;
  }
  
  private int b(int paramInt)
  {
    int j = 0;
    if (!s.a()) {
      j = -1;
    }
    for (;;)
    {
      return j;
      if (paramInt == 0) {
        return -2;
      }
      String str = GlobalUtil.getCurrentDay();
      if (!str.equals(Settings.getInstance().getString("analysis_last_ana_day")))
      {
        Settings.getInstance().setString("analysis_last_ana_day", str);
        Settings.getInstance().setInt("analysis_succ_times", 0);
      }
      for (int i = 0; i >= paramInt; i = Settings.getInstance().getInt("analysis_succ_times")) {
        return -3;
      }
    }
  }
  
  private String b(String paramString)
  {
    try
    {
      paramString = n.c(this.b.getPackageInfo(paramString, 64).signatures[0].toByteArray()).toLowerCase();
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void b(AppDataReportConfig paramAppDataReportConfig)
  {
    this.g = true;
    long l = System.currentTimeMillis();
    this.f = 0;
    paramAppDataReportConfig = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    System.currentTimeMillis();
    System.currentTimeMillis();
    localArrayList3 = a(localArrayList3);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      ApplicationInfo localApplicationInfo = (ApplicationInfo)localHashMap1.get(str);
      AppExtInfoParam localAppExtInfoParam = (AppExtInfoParam)localHashMap2.get(str);
      PackageInfo localPackageInfo = (PackageInfo)localHashMap3.get(str);
      if (localArrayList3.contains(a(str))) {
        localArrayList1.add(a((byte)2, localAppExtInfoParam, localApplicationInfo, localPackageInfo));
      } else {
        ((List)localObject1).add(a((byte)1, localAppExtInfoParam, localApplicationInfo, localPackageInfo));
      }
    }
    System.currentTimeMillis();
    paramAppDataReportConfig.addAll((Collection)localObject1);
    paramAppDataReportConfig.addAll(localArrayList1);
    paramAppDataReportConfig.addAll(localArrayList2);
    localObject1 = new StringBuilder();
    paramAppDataReportConfig = paramAppDataReportConfig.iterator();
    while (paramAppDataReportConfig.hasNext()) {
      ((StringBuilder)localObject1).append(((d)paramAppDataReportConfig.next()).toString());
    }
    System.currentTimeMillis();
    paramAppDataReportConfig = new SDKDataReportRequest();
    paramAppDataReportConfig.appData = ((StringBuilder)localObject1).toString();
    paramAppDataReportConfig.timeCost = (System.currentTimeMillis() - l);
    paramAppDataReportConfig.uin = GlobalUtil.getUin();
    paramAppDataReportConfig.qimei = GlobalUtil.getInstance().getQimei();
    paramAppDataReportConfig.qadid = GlobalUtil.getInstance().getQadid();
    this.g = this.c.a(paramAppDataReportConfig);
    System.currentTimeMillis();
  }
  
  private String c(String paramString)
  {
    paramString = n.b(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.toLowerCase();
  }
  
  public void a(int paramInt)
  {
    ab.c("InfoAnalyzer_", "requestFailed errorCode=" + paramInt);
    this.g = false;
  }
  
  public void a(AppDataReportConfig paramAppDataReportConfig)
  {
    if (!o.a(GlobalUtil.getInstance().getContext())) {
      ab.c("InfoAnalyzer_", "[begin] no available network!");
    }
    int i;
    do
    {
      return;
      long l = System.currentTimeMillis();
      if (l - this.d < 60000L)
      {
        ab.c("InfoAnalyzer_", "[begin] < 60 * 1000");
        return;
      }
      this.d = l;
      if (this.g)
      {
        ab.c("InfoAnalyzer_", "[begin] analyzing ");
        return;
      }
      i = b(paramAppDataReportConfig.frequency);
      ab.c("InfoAnalyzer_", "[begin] ret=" + i + ",cfg.fre=" + paramAppDataReportConfig.frequency + ",today succeed.times=" + Settings.getInstance().getInt("analysis_succ_times"));
    } while (i != 0);
    paramAppDataReportConfig = new Thread(new c(this, paramAppDataReportConfig), l.c.toString());
    paramAppDataReportConfig.setPriority(1);
    paramAppDataReportConfig.start();
  }
  
  public void b()
  {
    ab.c("InfoAnalyzer_", "requestSucceed");
    Settings.getInstance().setInt("analysis_succ_times", Settings.getInstance().getInt("analysis_succ_times") + 1);
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.a.b
 * JD-Core Version:    0.7.0.1
 */