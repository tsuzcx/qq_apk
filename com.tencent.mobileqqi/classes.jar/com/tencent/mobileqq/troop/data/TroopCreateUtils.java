package com.tencent.mobileqq.troop.data;

import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateUtils
{
  public static final String a = "troopUin";
  public static final String b = "troopLocation";
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramJSONObject.has(paramString)) {}
    try
    {
      i = paramJSONObject.getInt(paramString);
      return i;
    }
    catch (JSONException paramJSONObject) {}
    return paramInt;
  }
  
  public static String a(int paramInt)
  {
    long l1 = 0x7FFFFFFF & paramInt;
    long l2 = paramInt >> 31 & 0x1;
    return (l1 | l2 << 31) + "";
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramJSONObject.has(paramString1)) {}
    try
    {
      str = paramJSONObject.getString(paramString1);
      return str;
    }
    catch (JSONException paramJSONObject) {}
    return paramString2;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramJSONObject.has(paramString)) {}
    try
    {
      bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramJSONObject) {}
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateUtils
 * JD-Core Version:    0.7.0.1
 */