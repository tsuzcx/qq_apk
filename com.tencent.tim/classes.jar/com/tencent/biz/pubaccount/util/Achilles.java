package com.tencent.biz.pubaccount.util;

import adxc;
import aewh;
import android.text.TextUtils;
import anpc;
import awit;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kxm;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class Achilles
{
  private static String BUSINESS_NAME = "biz_src_feeds_kandian_tab";
  private static final Runnable de = new Achilles.1();
  private static Map<String, Long> eU = new HashMap();
  
  private static List<RockDownloadInfo> H(String paramString)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramString;
    localRockDownloadInfo.businessName = "biz_src_feeds_kandian_tab";
    paramString = adxc.a(localRockDownloadInfo);
    if ((paramString != null) && (paramString.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return paramString;
        localRockDownloadInfo.businessName = "biz_src_feeds_kandian_news";
        localArrayList = adxc.a(localRockDownloadInfo);
        if (localArrayList == null) {
          break;
        }
        paramString = localArrayList;
      } while (localArrayList.size() > 0);
      localRockDownloadInfo.businessName = "biz_src_feeds_kandian_daily";
      localArrayList = adxc.a(localRockDownloadInfo);
      if (localArrayList == null) {
        break;
      }
      paramString = localArrayList;
    } while (localArrayList.size() > 0);
    return null;
  }
  
  private static RockDownloadInfo a(AchillesParams paramAchillesParams)
  {
    RockDownloadInfo localRockDownloadInfo = new RockDownloadInfo();
    localRockDownloadInfo.packageName = paramAchillesParams.getPackageName();
    localRockDownloadInfo.businessName = BUSINESS_NAME;
    localRockDownloadInfo.businessScene = paramAchillesParams.getSceneId();
    localRockDownloadInfo.downloadURL = paramAchillesParams.getDownloadUrl();
    localRockDownloadInfo.versionCode = paramAchillesParams.getVersionCode();
    return localRockDownloadInfo;
  }
  
  public static RockDownloadInfo a(String paramString)
  {
    List localList = H(paramString);
    QLog.d("Achilles", 1, "[installIfDownloaded] downloadInfoList: " + localList);
    Iterator localIterator = null;
    paramString = null;
    Object localObject = localIterator;
    if (localList != null)
    {
      localObject = localIterator;
      if (localList.size() > 0)
      {
        int i = -1;
        localIterator = localList.iterator();
        localObject = paramString;
        if (localIterator.hasNext())
        {
          localObject = (RockDownloadInfo)localIterator.next();
          if (((RockDownloadInfo)localObject).getRealVersionCode() <= i) {
            break label106;
          }
          i = ((RockDownloadInfo)localObject).getRealVersionCode();
          paramString = (String)localObject;
        }
      }
    }
    label106:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private static void a(RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams)
  {
    QLog.d("Achilles", 1, "start download " + paramAchillesParams);
    AchillesFragmentUtils.a("download", "1", paramAchillesParams.getPackageName(), paramAchillesParams);
    adxc.a(paramRockDownloadInfo, new AchilesRockDownloadListener(null));
  }
  
  public static boolean a(String paramString1, String paramString2, WebViewPlugin.a parama, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        awit.eDN();
        localObject = t();
        if ((localObject == null) || (((Set)localObject).isEmpty()))
        {
          QLog.e("Achilles", 1, "[installIfDownloaded] empty param set");
          return false;
        }
        Iterator localIterator = ((Set)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (AchillesParams)localIterator.next();
          if (!TextUtils.equals(((AchillesParams)localObject).getPackageName(), paramString2)) {
            continue;
          }
          if ((localObject == null) || (!((AchillesParams)localObject).isEnable()))
          {
            QLog.e("Achilles", 1, "[installIfDownloaded] no enabled found in param set, package name: " + paramString2);
            return false;
          }
          if ((paramBoolean) && (!((AchillesParams)localObject).isInstallIfJump()))
          {
            QLog.e("Achilles", 1, "[installIfDownloaded] installIfJump is false " + paramString2);
            return false;
          }
          paramBoolean = AchillesFragmentUtils.a(paramString1, paramString2, parama);
          return paramBoolean;
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("Achilles", 1, "[installIfDownloaded] ", paramString1);
        return false;
      }
      Object localObject = null;
    }
  }
  
  private static void c(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = (Long)eU.get(paramString1);
    long l2 = System.currentTimeMillis();
    long l1;
    if (localObject == null)
    {
      l1 = 0L;
      localObject = kxm.getAccount();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("param_FailMsg", paramString2);
      localHashMap.put("uin", localObject);
      anpc.a(kxm.getAppRuntime().getApplication()).collectPerformance((String)localObject, "actAchilles", paramBoolean, l2 - l1, 0L, localHashMap, null, false);
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramString2 = "1";; paramString2 = "0")
    {
      AchillesFragmentUtils.a("downloadresult", paramString2, paramString1, null);
      return;
      l1 = ((Long)localObject).longValue();
      break;
    }
  }
  
  public static int compareVersion(String paramString1, String paramString2)
    throws NumberFormatException
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label80;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label80:
    return 0;
  }
  
  public static String fi(String paramString)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        awit.eDN();
        Object localObject2 = t();
        if ((localObject2 == null) || (((Set)localObject2).isEmpty()))
        {
          QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] empty param set.");
          return "";
        }
        Object localObject3 = ((Set)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (AchillesParams)((Iterator)localObject3).next();
          if (!TextUtils.equals(((AchillesParams)localObject2).getPackageName(), paramString)) {
            break label311;
          }
          localObject1 = localObject2;
          break label314;
        }
        if (localObject1 == null)
        {
          QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] param not found for " + paramString);
          return "";
        }
        localObject3 = a(paramString);
        if (localObject3 != null)
        {
          bool = true;
          QLog.i("Achilles", 1, "[queryPreDownloadInfoAladdin] download info pkgExist:" + bool + " packageName:" + ((AchillesParams)localObject1).getPackageName());
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("app_id", ((AchillesParams)localObject1).getAppId());
          if (localObject3 == null) {
            break label317;
          }
          paramString = ((RockDownloadInfo)localObject3).getDownloadURL();
          ((JSONObject)localObject2).put("download_url", paramString);
          if (!bool) {
            break label324;
          }
          i = 1;
          ((JSONObject)localObject2).put("download_finished", i);
          if (!((AchillesParams)localObject1).isEnable()) {
            break label329;
          }
          i = 1;
          ((JSONObject)localObject2).put("enable_predownload", i);
          if (!bool) {
            break label334;
          }
          paramString = "1";
          if (localObject3 != null)
          {
            localObject1 = ((RockDownloadInfo)localObject3).getPackageName();
            AchillesFragmentUtils.a("query", paramString, (String)localObject1, null);
            return ((JSONObject)localObject2).toString();
          }
          localObject1 = "";
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        QLog.e("Achilles", 1, "[queryPreDownloadInfoAladdin] ", paramString);
        return "";
      }
      continue;
      label311:
      label314:
      continue;
      label317:
      paramString = "";
      continue;
      label324:
      int i = 0;
      continue;
      label329:
      i = 0;
      continue;
      label334:
      paramString = "0";
    }
  }
  
  public static boolean isInstalled(String paramString)
  {
    try
    {
      if (aewh.g(paramString, BaseApplicationImpl.getContext()))
      {
        QLog.e("Achilles", 1, "[isInstalled] true");
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Achilles", 1, "[isInstalled] ", paramString);
      return false;
    }
    QLog.e("Achilles", 1, "[isInstalled] false");
    return false;
  }
  
  private static boolean isWifiConnected()
  {
    return NetworkState.isWifiConn();
  }
  
  public static void oX(String paramString)
  {
    QLog.d("Achilles", 2, "[maybeStart] ");
    BUSINESS_NAME = paramString;
    ThreadManager.executeOnFileThread(de);
  }
  
  public static boolean p(String paramString, boolean paramBoolean)
  {
    return a(null, paramString, null, true);
  }
  
  public static Set<AchillesParams> t()
  {
    return Aladdin.getConfig(140).getSet("param_set");
  }
  
  static class AchilesRockDownloadListener
    extends RockDownloadListener
  {
    public void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download cancel: " + paramRockDownloadInfo);
      if (paramRockDownloadInfo != null) {
        Achilles.d(false, paramRockDownloadInfo.getPackageName(), -1, "");
      }
    }
    
    public void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
    {
      QLog.d("Achilles", 1, "download fail: " + paramString + " " + paramInt + " " + paramRockDownloadInfo);
      if (paramRockDownloadInfo != null)
      {
        if (paramInt == 10010) {
          ThreadManager.getFileThreadHandler().postDelayed(Achilles.d(), 10000L);
        }
      }
      else {
        return;
      }
      Achilles.d(false, paramRockDownloadInfo.getPackageName(), paramInt, paramString);
    }
    
    public void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "downloadInfo: " + paramRockDownloadInfo);
    }
    
    public void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt)
    {
      QLog.d("Achilles", 2, "download process: " + paramRockDownloadInfo + " process: " + paramInt);
    }
    
    public void onDownloadStart(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download start: " + paramRockDownloadInfo);
      Achilles.K().put(paramRockDownloadInfo.getPackageName(), Long.valueOf(System.currentTimeMillis()));
    }
    
    public void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download success: " + paramRockDownloadInfo);
      if (paramRockDownloadInfo != null) {
        Achilles.d(true, paramRockDownloadInfo.getPackageName(), 0, "");
      }
    }
    
    public void onDownloadWait(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download wait: " + paramRockDownloadInfo);
    }
    
    public void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download permission denied: " + paramRockDownloadInfo);
    }
    
    public void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo)
    {
      QLog.d("Achilles", 1, "download permission permitted: " + paramRockDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Achilles
 * JD-Core Version:    0.7.0.1
 */