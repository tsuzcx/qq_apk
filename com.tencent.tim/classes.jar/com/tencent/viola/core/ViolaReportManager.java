package com.tencent.viola.core;

import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViolaReportManager
{
  public static final String BEACON_URL = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
  public static final int EVENT_BASE_CODE = 1000;
  public static final String EVENT_NAME_HTTP_PAGEDATE = "actKanDianViolaHttpData";
  public static final String EVENT_NAME_PAGEDATE = "actKanDianViolaData";
  public static final String EVENT_NAME_PROCESS_PAGEDATE = "actKanDianViolaPageDataNew";
  public static final String EVENT_NAME_RUNNING_PAGEDATE = "actKanDianViolaJsError";
  public static final int HTTP_TIMEOUT = 5000;
  public static final String TAG = "ViolaReportManager";
  private static volatile ViolaReportManager sManager;
  
  private String getEventCode(String paramString)
  {
    int j = 1000;
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        i = j;
      }
      break;
    }
    for (;;)
    {
      return "" + i;
      if (!paramString.equals("actKanDianViolaData")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("actKanDianViolaJsError")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("actKanDianViolaHttpData")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("actKanDianViolaPageDataNew")) {
        break;
      }
      i = 3;
      break;
      i = 1001;
      continue;
      i = 1002;
      continue;
      i = 1003;
      continue;
      i = 1004;
    }
  }
  
  public static ViolaReportManager getInstance()
  {
    if (sManager == null) {}
    try
    {
      if (sManager == null) {
        sManager = new ViolaReportManager();
      }
      return sManager;
    }
    finally {}
  }
  
  private void postBaseEventToBeacon(HashMap<String, String> paramHashMap)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
    localHttpRequset.method = "POST";
    localHttpRequset.timeoutMs = 5000;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("Content-Type", "application/json;charset=UTF-8");
    localHttpRequset.paramMap = ((Map)localObject);
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("deviceId", FlexConvertUtils.getIMEI());
        ((JSONObject)localObject).put("appkey", "JS0FEI6B3PZTEN");
        ((JSONObject)localObject).put("versionCode", "1.0.1");
        ((JSONObject)localObject).put("language", "zh-CN");
        ((JSONObject)localObject).put("initTime", System.currentTimeMillis());
        ((JSONObject)localObject).put("sdkVersion", "js_v1.1.0");
        ((JSONObject)localObject).put("pixel", "2560*1440*2");
        ((JSONObject)localObject).put("channelID", "");
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("type", 2);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("id", Math.abs(new Random().nextInt()));
        localJSONObject2.put("start", System.currentTimeMillis());
        localJSONObject2.put("status", 2);
        localJSONObject2.put("duration", 0);
        localJSONObject3 = new JSONObject();
        if (!paramHashMap.containsKey(ViolaEnvironment.COMMON_PAGE_NAME)) {
          continue;
        }
        localJSONObject3.put("name", paramHashMap.get(ViolaEnvironment.COMMON_PAGE_NAME));
        localJSONObject3.put("start", System.currentTimeMillis());
        localJSONObject3.put("duration", 1000);
        localJSONObject3.put("refer", "");
        localJSONObject2.put("pages", new JSONArray().put(localJSONObject3));
        localJSONObject2.put("events", new JSONArray());
        localJSONObject1.put("data", localJSONObject2);
        ((JSONObject)localObject).put("msgs", new JSONArray().put(localJSONObject1));
      }
      catch (Exception paramHashMap)
      {
        JSONObject localJSONObject3;
        ViolaLogUtils.e("ViolaReportManager", "postDataToBeacon error:" + paramHashMap.getMessage());
        continue;
      }
      localHttpRequset.body = ((JSONObject)localObject).toString();
      paramHashMap = ViolaSDKManager.getInstance().getHttpAdapter();
      if (paramHashMap != null) {
        paramHashMap.sendRequest(localHttpRequset, new ViolaReportManager.3(this), true);
      }
      return;
      localJSONObject3.put("name", "http://viola.oa.com");
    }
  }
  
  private void postEventToBeacon(String paramString, HashMap<String, String> paramHashMap)
  {
    HttpRequset localHttpRequset = new HttpRequset();
    localHttpRequset.url = "https://otheve.beacon.qq.com/analytics/upload?tp=js";
    localHttpRequset.method = "POST";
    localHttpRequset.timeoutMs = 5000;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("Content-Type", "application/json;charset=UTF-8");
    localHttpRequset.paramMap = ((Map)localObject);
    localObject = new JSONObject();
    JSONObject localJSONObject2;
    JSONObject localJSONObject3;
    JSONObject localJSONObject4;
    try
    {
      ((JSONObject)localObject).put("deviceId", FlexConvertUtils.getIMEI());
      ((JSONObject)localObject).put("appkey", "JS0FEI6B3PZTEN");
      ((JSONObject)localObject).put("versionCode", "1.0.1");
      ((JSONObject)localObject).put("language", "zh-CN");
      ((JSONObject)localObject).put("initTime", System.currentTimeMillis());
      ((JSONObject)localObject).put("sdkVersion", "js_v1.1.0");
      ((JSONObject)localObject).put("pixel", "2560*1440*2");
      ((JSONObject)localObject).put("channelID", "");
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", 2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("id", Math.abs(new Random().nextInt()));
      localJSONObject2.put("start", System.currentTimeMillis());
      localJSONObject2.put("status", 2);
      localJSONObject2.put("duration", 0);
      localJSONObject2.put("pages", new JSONArray());
      localJSONObject3 = new JSONObject();
      localJSONObject3.put("count", 1);
      localJSONObject3.put("start", System.currentTimeMillis());
      localJSONObject3.put("id", getEventCode(paramString));
      localJSONObject3.put("name", paramString);
      localJSONObject4 = new JSONObject();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONObject4.put((String)localEntry.getKey(), localEntry.getValue());
        continue;
        localHttpRequset.body = ((JSONObject)localObject).toString();
      }
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("ViolaReportManager", "postDataToBeacon error:" + localException.getMessage());
    }
    for (;;)
    {
      localObject = ViolaSDKManager.getInstance().getHttpAdapter();
      if (localObject != null) {
        ((IHttpAdapter)localObject).sendRequest(localHttpRequset, new ViolaReportManager.2(this, paramString, paramHashMap), true);
      }
      return;
      localJSONObject3.put("params", localJSONObject4);
      localJSONObject2.put("events", new JSONArray().put(localJSONObject3));
      localException.put("data", localJSONObject2);
      ((JSONObject)localObject).put("msgs", new JSONArray().put(localException));
    }
  }
  
  public void postDataToBeacon(String paramString, HashMap<String, String> paramHashMap)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new ViolaReportManager.1(this, paramHashMap, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaReportManager
 * JD-Core Version:    0.7.0.1
 */