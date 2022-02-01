package com.tencent.qqmail.utilities.json;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.utilities.log.QMLog;

public final class JSONReader
{
  private void JSONReader() {}
  
  public static float getFloat(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    if (paramJSONObject == null) {
      return paramFloat;
    }
    try
    {
      float f = paramJSONObject.getFloat(paramString).floatValue();
      return f;
    }
    catch (Exception paramJSONObject) {}
    return paramFloat;
  }
  
  public static int getInt(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null) {
      return paramInt;
    }
    try
    {
      int i = paramJSONObject.getInteger(paramString).intValue();
      return i;
    }
    catch (Exception paramJSONObject) {}
    return paramInt;
  }
  
  public static long getLong(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if (paramJSONObject == null) {
      return paramLong;
    }
    try
    {
      long l = paramJSONObject.getLong(paramString).longValue();
      return l;
    }
    catch (Exception paramJSONObject) {}
    return paramLong;
  }
  
  @Nullable
  public static Object parse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = JSON.parse(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof OutOfMemoryError))
      {
        System.gc();
        SystemClock.sleep(100L);
      }
      QMLog.log(5, "JSONReader", "parse error, jsonString: " + paramString + ", " + localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.json.JSONReader
 * JD-Core Version:    0.7.0.1
 */