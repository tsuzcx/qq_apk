package com.tencent.token;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class any
{
  public static Object a(JSONArray paramJSONArray, int paramInt)
  {
    if ((paramJSONArray != null) && (paramInt >= 0))
    {
      if (paramInt >= paramJSONArray.length()) {
        return null;
      }
      try
      {
        paramJSONArray = paramJSONArray.get(paramInt);
        return paramJSONArray;
      }
      catch (Throwable paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
    return null;
  }
  
  public static Object a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramJSONObject = paramJSONObject.get(paramString);
        return paramJSONObject;
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramJSONObject = paramJSONObject.getString(paramString);
        return paramJSONObject;
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.any
 * JD-Core Version:    0.7.0.1
 */