package com.huawei.hianalytics.ab.bc.ik.ab;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.ab.de;
import com.huawei.hianalytics.ab.bc.de.fg;
import com.huawei.hianalytics.ab.bc.kl.ef;
import com.huawei.hianalytics.ab.bc.kl.gh;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ab
{
  private static ab ab;
  private static Map<String, Long> cd = new HashMap();
  private Context bc;
  private long de = 0L;
  
  public static ab ab()
  {
    return bc();
  }
  
  private static void ab(String paramString1, String paramString2, long paramLong1, long paramLong2, JSONObject paramJSONObject, String paramString3, String paramString4)
  {
    paramString1 = new com.huawei.hianalytics.ab.bc.ik.bc.bc(paramString3, ef.ab(paramJSONObject, paramString2, String.valueOf(paramLong2), paramString4), paramString1, "oper", paramLong1);
    com.huawei.hianalytics.ab.bc.ik.cd.bc.ab().ab(paramString1);
  }
  
  private static ab bc()
  {
    try
    {
      if (ab == null) {
        ab = new ab();
      }
      ab localab = ab;
      return localab;
    }
    finally {}
  }
  
  private void bc(Context paramContext)
  {
    String str1 = com.huawei.hianalytics.ab.bc.bc.ab.bc(paramContext);
    com.huawei.hianalytics.ab.ab.bc.bc(str1);
    if (gh.ab().bc())
    {
      String str2 = com.huawei.hianalytics.ab.bc.ij.ab.bc(paramContext, "global_v2", "app_ver", "");
      com.huawei.hianalytics.ab.bc.ij.ab.ab(paramContext, "global_v2", "app_ver", str1);
      com.huawei.hianalytics.ab.ab.bc.cd(str2);
      if (TextUtils.isEmpty(str2)) {
        com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsEventServer", "app ver is first save!");
      }
      while (str2.equals(str1)) {
        return;
      }
      com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsEventServer", "the appVers are different!");
      ab().ab("", "alltype", str2);
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsEventServer", "userManager.isUserUnlocked() == false");
  }
  
  private static void cd(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    long l2 = 0L;
    long l3 = System.currentTimeMillis();
    if (cd.containsKey(paramString1)) {}
    for (long l1 = ((Long)cd.get(paramString1)).longValue();; l1 = 0L)
    {
      if (l1 == 0L) {}
      for (l1 = l2;; l1 = l3 - l1)
      {
        ab(paramString1, paramString3, l3, l1, paramJSONObject, paramString2, "OnPause");
        return;
      }
    }
  }
  
  public void ab(Context paramContext)
  {
    this.bc = paramContext;
    bc(paramContext);
    com.huawei.hianalytics.ab.bc.cd.ab.ab.ab().cd().cd(com.huawei.hianalytics.ab.bc.bc.ab.ab());
  }
  
  public void ab(String paramString, int paramInt)
  {
    if (this.bc == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsEventServer", "onReport() null context or SDK was not init.");
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "onReport: Before calling runtaskhandler()");
    ab(paramString, ef.ab(paramInt), com.huawei.hianalytics.ab.ab.bc.fg());
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    long l2 = System.currentTimeMillis();
    long l1 = l2;
    if (2 == paramInt) {
      l1 = ef.ab("yyyy-MM-dd", l2);
    }
    paramString1 = new com.huawei.hianalytics.ab.bc.ik.bc.bc(paramString2, paramJSONObject, paramString1, ef.ab(paramInt), l1);
    com.huawei.hianalytics.ab.bc.ik.cd.bc.ab().ab(paramString1);
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject, long paramLong)
  {
    new fg(paramString1, ef.ab(paramInt), paramString2, paramJSONObject.toString(), paramLong).ab();
  }
  
  public void ab(String paramString1, String paramString2)
  {
    if (com.huawei.hianalytics.ab.ab.cd.ij(paramString1, paramString2))
    {
      long l = System.currentTimeMillis();
      if (l - this.de > 30000L)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.ab("HiAnalyticsEventServer", "begin to call onReport!");
        this.de = l;
        ab(paramString1, paramString2, com.huawei.hianalytics.ab.ab.bc.fg());
        return;
      }
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsEventServer", "autoReport timeout. interval < 30s ");
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsEventServer", "auto report is closed tag:" + paramString1);
  }
  
  public void ab(String paramString1, String paramString2, String paramString3)
  {
    if (com.huawei.hianalytics.ab.ab.cd.ik(paramString1, paramString2))
    {
      String str = com.huawei.hianalytics.ab.bc.bc.cd.ab(this.bc);
      if (!"WIFI".equals(str))
      {
        com.huawei.hianalytics.ab.bc.ef.ab.bc("HiAnalyticsEventServer", "strNetworkType is :" + str);
        return;
      }
    }
    paramString1 = new com.huawei.hianalytics.ab.bc.ik.bc.cd(paramString1, paramString2, paramString3);
    com.huawei.hianalytics.ab.bc.ik.cd.bc.ab().ab(paramString1);
  }
  
  public void ab(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    if (this.bc == null)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsEventServer", "onPause null context or SDK was not init.");
      return;
    }
    cd(paramString1, paramString2, paramString3, paramJSONObject);
    cd.put(paramString1, Long.valueOf(0L));
  }
  
  public void ab(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    ab(paramString1, "$AppOnPause", paramString2, paramJSONObject);
  }
  
  public void bc(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    long l = System.currentTimeMillis();
    cd.put(paramString1, Long.valueOf(l));
    ab(paramString1, paramString3, l, 0L, paramJSONObject, paramString2, "OnResume");
  }
  
  public void bc(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    bc(paramString1, "$AppOnResume", paramString2, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.ab.ab
 * JD-Core Version:    0.7.0.1
 */