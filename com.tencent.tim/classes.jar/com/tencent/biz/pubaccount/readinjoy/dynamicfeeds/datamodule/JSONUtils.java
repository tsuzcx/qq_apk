package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import jqc;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{
  public static SerializableJSONArray a(JSONArray paramJSONArray)
  {
    SerializableJSONArray localSerializableJSONArray = new SerializableJSONArray();
    if (paramJSONArray != null)
    {
      int i = 0;
      if (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if ((localObject instanceof JSONObject)) {
          localSerializableJSONArray.put(a((JSONObject)localObject));
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof JSONArray)) {
            localSerializableJSONArray.put(a((JSONArray)localObject));
          } else {
            localSerializableJSONArray.put(paramJSONArray.optString(i));
          }
        }
      }
    }
    return localSerializableJSONArray;
  }
  
  public static SerializableJSONObject a(JSONObject paramJSONObject)
  {
    SerializableJSONObject localSerializableJSONObject = new SerializableJSONObject();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject;
        try
        {
          localObject = paramJSONObject.get(str);
          if (!(localObject instanceof JSONObject)) {
            break label81;
          }
          localSerializableJSONObject.put(str, a((JSONObject)localObject));
        }
        catch (JSONException localJSONException)
        {
          QLog.d("JSONUtils", 2, "convertJSONObjectToSerializable, e = ", localJSONException);
        }
        continue;
        label81:
        if ((localObject instanceof JSONArray)) {
          localSerializableJSONObject.put(localJSONException, a((JSONArray)localObject));
        } else {
          localSerializableJSONObject.put(localJSONException, paramJSONObject.getString(localJSONException));
        }
      }
    }
    return localSerializableJSONObject;
  }
  
  public static Bundle b(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PostBodyType", 1);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getSkey(str1);
    localBundle.putString("Cookie", "uin=" + str1 + ";skey=" + str2);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("requestBody");
      if (paramJSONObject != null) {
        b(paramJSONObject, localBundle);
      }
    }
    QLog.d("JSONUtils", 2, new Object[] { "covertJSONToBundle, params = ", localBundle });
    return localBundle;
  }
  
  public static String b(JSONObject paramJSONObject, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new Bundle();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("queryParams");
      if (paramJSONObject != null) {
        b(paramJSONObject, (Bundle)localObject);
      }
    }
    localObject = jqc.b((Bundle)localObject);
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.contains("?")) {}
    for (paramJSONObject = "&";; paramJSONObject = "?")
    {
      paramJSONObject = paramJSONObject + (String)localObject;
      QLog.d("JSONUtils", 2, new Object[] { "encodeUrlWithQueryParams, url = ", paramString, ", encodeParams = ", localObject, ", finalUrl = ", paramJSONObject });
      return paramJSONObject;
    }
  }
  
  private static void b(JSONObject paramJSONObject, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject;
        try
        {
          localObject = paramJSONObject.get(str);
          if (!(localObject instanceof JSONObject)) {
            break label72;
          }
          paramBundle.putSerializable(str, a((JSONObject)localObject));
        }
        catch (JSONException localJSONException)
        {
          QLog.d("JSONUtils", 2, "iterateJSON, e = ", localJSONException);
        }
        continue;
        label72:
        if ((localObject instanceof JSONArray)) {
          paramBundle.putSerializable(localJSONException, a((JSONArray)localObject));
        } else {
          paramBundle.putString(localJSONException, paramJSONObject.getString(localJSONException));
        }
      }
    }
  }
  
  public static class SerializableJSONArray
    extends JSONArray
    implements Serializable
  {}
  
  public static class SerializableJSONObject
    extends JSONObject
    implements Serializable
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.JSONUtils
 * JD-Core Version:    0.7.0.1
 */