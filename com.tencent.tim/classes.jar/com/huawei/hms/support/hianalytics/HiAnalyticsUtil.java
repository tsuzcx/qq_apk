package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import com.huawei.hianalytics.hms.HiAnalytics;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class HiAnalyticsUtil
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  private static HiAnalyticsUtil c;
  private int d = 0;
  private final int e = -1;
  private int f = -1;
  
  private String a(Context paramContext, String paramString)
  {
    String str = paramContext.getPackageName();
    return "01|" + "" + "|" + str + "|" + Util.getAppId(paramContext) + "|" + 40002300 + "|" + paramString;
  }
  
  private String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    localJSONObject = new JSONObject();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramMap)
    {
      HMSLog.e("HiAnalyticsUtil", "AnalyticsHelper create json exception" + paramMap.getMessage());
    }
  }
  
  private void a()
  {
    synchronized (b)
    {
      if (this.d < 60)
      {
        this.d += 1;
        return;
      }
      this.d = 0;
      HiAnalytics.onReport();
    }
  }
  
  private static LinkedHashMap<String, String> b(Map<String, String> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, paramMap.get(str));
    }
    return localLinkedHashMap;
  }
  
  public static HiAnalyticsUtil getInstance()
  {
    synchronized (a)
    {
      if (c == null) {
        c = new HiAnalyticsUtil();
      }
      HiAnalyticsUtil localHiAnalyticsUtil = c;
      return localHiAnalyticsUtil;
    }
  }
  
  public static Map<String, String> getMapFromForegroundResponseHeader(ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramResponseHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramResponseHeader.getTransactionId());
    localHashMap.put("appid", paramResponseHeader.getActualAppID());
    localHashMap.put("service", paramResponseHeader.getSrvName());
    localHashMap.put("apiName", paramResponseHeader.getApiName());
    localHashMap.put("package", paramResponseHeader.getPkgName());
    localHashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    localHashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    localHashMap.put("errorReason", paramResponseHeader.getErrorReason());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "4.0.2.300");
    return localHashMap;
  }
  
  public static Map<String, String> getMapFromRequestHeader(ResponseHeader paramResponseHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramResponseHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramResponseHeader.getTransactionId());
    localHashMap.put("appid", paramResponseHeader.getActualAppID());
    localHashMap.put("service", paramResponseHeader.getSrvName());
    Object localObject = paramResponseHeader.getApiName();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\.");
      if (localObject.length >= 2) {
        localHashMap.put("apiName", localObject[1]);
      }
    }
    localHashMap.put("package", paramResponseHeader.getPkgName());
    localHashMap.put("statusCode", String.valueOf(paramResponseHeader.getStatusCode()));
    localHashMap.put("result", String.valueOf(paramResponseHeader.getErrorCode()));
    localHashMap.put("errorReason", paramResponseHeader.getErrorReason());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "4.0.2.300");
    return localHashMap;
  }
  
  public static String versionCodeToName(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.length() == 8) || (paramString.length() == 9))) {
      try
      {
        Integer.parseInt(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Integer.parseInt(paramString.substring(0, paramString.length() - 7)));
        localStringBuilder.append(".");
        localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 7, paramString.length() - 5)));
        localStringBuilder.append(".");
        localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 5, paramString.length() - 3)));
        localStringBuilder.append(".");
        localStringBuilder.append(Integer.parseInt(paramString.substring(paramString.length() - 3)));
        paramString = localStringBuilder.toString();
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        return "";
      }
    }
    return "";
  }
  
  @Deprecated
  public Map<String, String> getMapForBi(Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = paramString.split("\\.");
    if (localObject2.length >= 2)
    {
      Object localObject1 = localObject2[0];
      localObject2 = localObject2[1];
      String str = Util.getAppId(paramContext);
      localHashMap.put("transId", TransactionIdCreater.getId(str, paramString));
      localHashMap.put("appid", str);
      localHashMap.put("service", localObject1);
      localHashMap.put("apiName", localObject2);
      localHashMap.put("package", paramContext.getPackageName());
      localHashMap.put("version", "4.0.2.300");
      localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    }
    return localHashMap;
  }
  
  public Map<String, String> getMapFromForegroundRequestHeader(RequestHeader paramRequestHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramRequestHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramRequestHeader.getTransactionId());
    localHashMap.put("appid", paramRequestHeader.getActualAppID());
    localHashMap.put("service", paramRequestHeader.getSrvName());
    localHashMap.put("apiName", paramRequestHeader.getApiName());
    localHashMap.put("package", paramRequestHeader.getPkgName());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "4.0.2.300");
    return localHashMap;
  }
  
  public Map<String, String> getMapFromRequestHeader(RequestHeader paramRequestHeader)
  {
    HashMap localHashMap = new HashMap();
    if (paramRequestHeader == null) {
      return localHashMap;
    }
    localHashMap.put("transId", paramRequestHeader.getTransactionId());
    localHashMap.put("appid", paramRequestHeader.getActualAppID());
    localHashMap.put("service", paramRequestHeader.getSrvName());
    Object localObject = paramRequestHeader.getApiName();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\.");
      if (localObject.length >= 2) {
        localHashMap.put("apiName", localObject[1]);
      }
    }
    localHashMap.put("package", paramRequestHeader.getPkgName());
    localHashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
    localHashMap.put("baseVersion", "4.0.2.300");
    return localHashMap;
  }
  
  @Deprecated
  public boolean hasError()
  {
    if (!Util.isChinaROM())
    {
      HMSLog.i("HiAnalyticsUtil", "not ChinaROM ");
      return true;
    }
    return false;
  }
  
  public boolean hasError(Context paramContext)
  {
    if ((!Util.isChinaROM()) && (this.f == -1))
    {
      HMSLog.i("HiAnalyticsUtil", "not ChinaROM");
      if (paramContext != null) {}
    }
    while (this.f == 0) {
      for (;;)
      {
        return true;
        try
        {
          this.f = Settings.Secure.getInt(paramContext.getContentResolver(), "hw_app_analytics_state");
          HMSLog.i("HiAnalyticsUtil", "hw_app_analytics_state value is " + this.f);
          if (this.f == 1) {
            return false;
          }
        }
        catch (Settings.SettingNotFoundException paramContext)
        {
          HMSLog.i("HiAnalyticsUtil", "Get OOBE failed");
          return true;
        }
      }
    }
    return false;
  }
  
  public void onBuoyEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (getInstance().hasError(paramContext)) {}
    while (paramContext == null) {
      return;
    }
    onEvent2(paramContext, paramString1, paramString2);
  }
  
  public void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (getInstance().hasError(paramContext)) {}
    while (paramContext == null) {
      return;
    }
    onEvent2(paramContext, paramString1, a(paramContext, paramString2));
  }
  
  public void onEvent(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    String str = a(paramMap);
    if (!TextUtils.isEmpty(str))
    {
      onEvent2(paramContext, paramString, str);
      HiAnalytics.onEvent(1, paramString, b(paramMap));
      a();
    }
  }
  
  public void onEvent2(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (HiAnalytics.getInitFlag())) {
      HiAnalytics.onEvent(paramContext, paramString1, paramString2);
    }
  }
  
  public void onNewEvent(Context paramContext, String paramString, Map paramMap)
  {
    if (hasError(paramContext)) {}
    String str;
    do
    {
      return;
      str = a(paramMap);
    } while ((paramContext == null) || (!HiAnalytics.getInitFlag()));
    HiAnalytics.onEvent(paramContext, paramString, str);
    HiAnalytics.onEvent(1, paramString, b(paramMap));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.hianalytics.HiAnalyticsUtil
 * JD-Core Version:    0.7.0.1
 */