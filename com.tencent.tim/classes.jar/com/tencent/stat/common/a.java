package com.tencent.stat.common;

import android.content.Context;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  static c a;
  private static StatLogger d = ;
  private static JSONObject e = new JSONObject();
  Integer b = null;
  String c = null;
  
  public a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      a(paramContext, paramStatSpecifyReportedInfo);
      this.b = StatCommonHelper.getTelephonyNetworkType(paramContext.getApplicationContext());
      this.c = NetworkManager.getInstance(paramContext).getCurNetwrokName();
      return;
    }
    catch (Throwable paramContext)
    {
      d.e(paramContext);
    }
  }
  
  static c a(Context paramContext, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    try
    {
      if (a == null) {
        a = new c(paramContext.getApplicationContext(), paramStatSpecifyReportedInfo, null);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, Map<String, String> paramMap)
    throws JSONException
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      paramContext = new HashMap(paramMap).entrySet().iterator();
      while (paramContext.hasNext())
      {
        paramMap = (Map.Entry)paramContext.next();
        e.put((String)paramMap.getKey(), paramMap.getValue());
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, Thread paramThread)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (a != null) {
        a.a(localJSONObject, paramThread);
      }
      Util.jsonPut(localJSONObject, "cn", this.c);
      if (this.b != null) {
        localJSONObject.put("tn", this.b);
      }
      if (paramThread == null) {
        paramJSONObject.put("ev", localJSONObject);
      }
      while ((e != null) && (e.length() > 0))
      {
        paramJSONObject.put("eva", e);
        return;
        paramJSONObject.put("errkv", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.e(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.common.a
 * JD-Core Version:    0.7.0.1
 */