package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class bc
{
  private static bc ab = null;
  private Context bc;
  private final Object cd = new Object();
  
  public static bc ab()
  {
    if (ab == null) {
      bc();
    }
    return ab;
  }
  
  private JSONObject ab(Map<String, String> paramMap)
  {
    localJSONObject = new JSONObject();
    if (paramMap != null) {
      try
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        return localJSONObject;
      }
      catch (JSONException paramMap)
      {
        com.huawei.hianalytics.ab.bc.ef.ab.de("HiAnalyticsEventManager", "Exception occured when transferring bundle to json");
      }
    }
  }
  
  private static void bc()
  {
    try
    {
      if (ab == null) {
        ab = new bc();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void ab(Context paramContext)
  {
    synchronized (this.cd)
    {
      if (this.bc != null) {
        return;
      }
      this.bc = paramContext;
      com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramContext);
      return;
    }
  }
  
  public void ab(String paramString, int paramInt)
  {
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString, paramInt);
  }
  
  public void ab(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = ab(paramLinkedHashMap);
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString1, paramInt, paramString2, paramLinkedHashMap);
  }
  
  public void ab(String paramString, Context paramContext)
  {
    paramContext = paramContext.getClass().getCanonicalName();
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString, paramContext, new JSONObject());
  }
  
  public void ab(String paramString1, Context paramContext, String paramString2, String paramString3)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("_constants", paramString3);
      com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString1, 0, paramString2, paramContext);
      return;
    }
    catch (JSONException paramString1)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("HiAnalyticsEventManager", "onEvent():JSON structure Exception!");
    }
  }
  
  public void ab(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = ab(paramLinkedHashMap);
    paramContext = paramContext.getClass().getCanonicalName();
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString, paramContext, paramLinkedHashMap);
  }
  
  public void ab(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = ab(paramLinkedHashMap);
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString1, paramString2, paramLinkedHashMap);
  }
  
  public void bc(String paramString1, int paramInt, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = ab(paramLinkedHashMap);
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().ab(paramString1, paramInt, paramString2, paramLinkedHashMap, System.currentTimeMillis());
  }
  
  public void bc(String paramString, Context paramContext)
  {
    paramContext = paramContext.getClass().getCanonicalName();
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().bc(paramString, paramContext, new JSONObject());
  }
  
  public void bc(String paramString, Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramContext = paramContext.getClass().getCanonicalName();
    paramLinkedHashMap = ab(paramLinkedHashMap);
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().bc(paramString, paramContext, paramLinkedHashMap);
  }
  
  public void bc(String paramString1, String paramString2, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    paramLinkedHashMap = ab(paramLinkedHashMap);
    com.huawei.hianalytics.ab.bc.ik.ab.ab.ab().bc(paramString1, paramString2, paramLinkedHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.fg.bc
 * JD-Core Version:    0.7.0.1
 */