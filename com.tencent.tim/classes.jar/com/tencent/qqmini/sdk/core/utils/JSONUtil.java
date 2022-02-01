package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class JSONUtil
{
  private static final String TAG = "JSONUtil";
  
  public static JSONObject append(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      QMLog.e("JSONUtil", "", paramJSONObject);
    }
    return localJSONObject;
  }
  
  public static JSONArray concatArray(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    throws JSONException
  {
    int k = 0;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramJSONArray1.length()) {
        break;
      }
      localJSONArray.put(paramJSONArray1.get(i));
      i += 1;
    }
    while (j < paramJSONArray2.length())
    {
      localJSONArray.put(paramJSONArray2.get(j));
      j += 1;
    }
    return localJSONArray;
  }
  
  public static String escapeStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("\\t", "").replace("\\n", "").replace("\\\"", "");
  }
  
  public static JSONObject headerToJson(Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, headerValueToString((List)paramMap.get(str)));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONObject;
  }
  
  private static String headerValueToString(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        if (i > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isJson(String paramString)
  {
    try
    {
      new JSONObject(paramString);
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static String json2Params(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJSONObject.getString(str1);
        localStringBuilder.append(str1).append("=").append(str2).append("&");
      }
      if (localStringBuilder.length() <= 0) {
        break label84;
      }
    }
    catch (Exception paramJSONObject)
    {
      return null;
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    label84:
    return localStringBuilder.toString();
  }
  
  public static int[] jsonArrayToIntArray(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = paramJSONArray.optInt(i);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static String[][] jsonArrayToMutiStringArray(JSONObject paramJSONObject, String paramString)
  {
    String[][] arrayOfString = (String[][])null;
    Object localObject1 = arrayOfString;
    localObject2 = arrayOfString;
    try
    {
      if (paramJSONObject.has(paramString))
      {
        localObject1 = arrayOfString;
        paramString = paramJSONObject.getJSONArray(paramString);
        localObject1 = arrayOfString;
        paramJSONObject = new String[paramString.length()][];
        int i = 0;
        for (;;)
        {
          localObject1 = paramJSONObject;
          localObject2 = paramJSONObject;
          if (i >= paramString.length()) {
            break;
          }
          localObject1 = paramJSONObject;
          localObject2 = paramString.getJSONArray(i);
          localObject1 = paramJSONObject;
          paramJSONObject[i] = new String[((JSONArray)localObject2).length()];
          int j = 0;
          for (;;)
          {
            localObject1 = paramJSONObject;
            if (j >= ((JSONArray)localObject2).length()) {
              break;
            }
            localObject1 = paramJSONObject;
            paramJSONObject[i][j] = ((JSONArray)localObject2).getString(j);
            j += 1;
          }
          i += 1;
        }
      }
      return localObject2;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      localObject2 = localObject1;
    }
  }
  
  public static String[] jsonArrayToStringArray(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    String[] arrayOfString = new String[paramJSONArray.length()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = paramJSONArray.optString(i);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static JSONObject listmapTojsonString(Map<String, List<String>> paramMap)
  {
    return toJson(paramMap);
  }
  
  public static JSONObject mapTojsonString(Map<String, String> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, (String)paramMap.get(str));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONObject;
  }
  
  public static JSONObject parse(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  private static Object toJavaObj(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof JSONObject)) {
      localObject = toMap((JSONObject)paramObject);
    }
    do
    {
      return localObject;
      localObject = paramObject;
    } while (!(paramObject instanceof JSONArray));
    return toList((JSONArray)paramObject);
  }
  
  public static JSONArray toJson(List<Object> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Map)) {
        localJSONArray.put(toJson((Map)localObject));
      } else if ((localObject instanceof List)) {
        localJSONArray.put(toJson((List)localObject));
      } else {
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  public static JSONObject toJson(Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, toJson((List)paramMap.get(str)));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONObject;
  }
  
  public static List toList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (!paramJSONArray.isNull(i)) {
        localArrayList.add(toJavaObj(paramJSONArray.opt(i)));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map toMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = paramJSONObject.opt(str);
        if (!paramJSONObject.isNull(str)) {
          localHashMap.put(str, toJavaObj(localObject));
        }
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.JSONUtil
 * JD-Core Version:    0.7.0.1
 */