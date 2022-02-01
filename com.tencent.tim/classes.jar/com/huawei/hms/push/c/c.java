package com.huawei.hms.push.c;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramJSONObject != null) {
      i = paramInt;
    }
    try
    {
      if (paramJSONObject.has(paramString)) {
        i = paramJSONObject.getInt(paramString);
      }
      return i;
    }
    catch (JSONException paramJSONObject)
    {
      HMSLog.w("JsonUtil", "JSONException: get " + paramString + " error.");
    }
    return paramInt;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramJSONObject != null) {
      str = paramString2;
    }
    try
    {
      if (paramJSONObject.has(paramString1))
      {
        str = paramString2;
        if (paramJSONObject.get(paramString1) != null) {
          str = String.valueOf(paramJSONObject.get(paramString1));
        }
      }
      return str;
    }
    catch (JSONException paramJSONObject)
    {
      HMSLog.w("JsonUtil", "JSONException: get " + paramString1 + " error.");
    }
    return paramString2;
  }
  
  public static void a(JSONObject paramJSONObject, Bundle paramBundle, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      a(paramJSONObject, (String)localEntry.getKey(), localEntry.getValue(), paramBundle);
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject, Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str = null;
    if (paramObject == null)
    {
      HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
      return;
    }
    if ((paramObject instanceof String))
    {
      str = (String)paramObject;
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = null;
      }
      paramBundle.putString(paramString, a(paramJSONObject, paramString, paramObject));
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, a(paramJSONObject, paramString, ((Integer)paramObject).intValue()));
      return;
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      if (paramObject.length == 0) {
        paramObject = str;
      }
      for (;;)
      {
        paramBundle.putIntArray(paramString, a(paramJSONObject, paramString, paramObject));
        return;
      }
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (long[])paramObject;
      if (paramObject.length == 0) {
        paramObject = localObject1;
      }
      for (;;)
      {
        paramBundle.putLongArray(paramString, a(paramJSONObject, paramString, paramObject));
        return;
      }
    }
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])paramObject;
      if (paramObject.length == 0) {
        paramObject = localObject2;
      }
      for (;;)
      {
        paramBundle.putStringArray(paramString, a(paramJSONObject, paramString, paramObject));
        return;
      }
    }
    HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
  }
  
  public static int[] a(JSONObject paramJSONObject, String paramString, int[] paramArrayOfInt)
  {
    JSONArray localJSONArray = null;
    localObject = localJSONArray;
    if (paramJSONObject != null)
    {
      localObject = localJSONArray;
      try
      {
        if (!paramJSONObject.has(paramString)) {
          break label111;
        }
        localJSONArray = paramJSONObject.getJSONArray(paramString);
        localObject = new int[localJSONArray.length()];
        i = 0;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          int i;
          if (i >= localJSONArray.length()) {
            break label108;
          }
          localObject[i] = ((Integer)localJSONArray.get(i)).intValue();
          i += 1;
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject = (JSONObject)localObject;
          }
        }
        paramJSONObject = paramJSONObject;
        paramJSONObject = null;
      }
      paramJSONObject = (JSONObject)localObject;
      HMSLog.w("JsonUtil", "JSONException: get " + paramString + " error.");
      label108:
      localObject = paramJSONObject;
    }
    label111:
    if (localObject == null) {
      return paramArrayOfInt;
    }
    return localObject;
  }
  
  public static long[] a(JSONObject paramJSONObject, String paramString, long[] paramArrayOfLong)
  {
    JSONArray localJSONArray = null;
    Object localObject3 = null;
    Object localObject2 = localJSONArray;
    if (paramJSONObject != null)
    {
      Object localObject1 = localObject3;
      localObject2 = localJSONArray;
      try
      {
        if (paramJSONObject.has(paramString))
        {
          localObject1 = localObject3;
          localJSONArray = paramJSONObject.getJSONArray(paramString);
          localObject1 = localObject3;
          paramJSONObject = new long[localJSONArray.length()];
          int i = 0;
          for (;;)
          {
            localObject1 = paramJSONObject;
            localObject2 = paramJSONObject;
            if (i >= localJSONArray.length()) {
              break;
            }
            localObject1 = paramJSONObject;
            paramJSONObject[i] = localJSONArray.getLong(i);
            i += 1;
          }
        }
        if (localObject2 != null) {
          break label130;
        }
      }
      catch (JSONException paramJSONObject)
      {
        HMSLog.w("JsonUtil", "JSONException: get " + paramString + " error.");
        localObject2 = localObject1;
      }
    }
    else
    {
      return paramArrayOfLong;
    }
    label130:
    return localObject2;
  }
  
  /* Error */
  public static String[] a(JSONObject paramJSONObject, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 5
    //   8: astore_2
    //   9: aload_0
    //   10: ifnull +91 -> 101
    //   13: aload 5
    //   15: astore_2
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 14	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   21: ifeq +80 -> 101
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 152	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 157	org/json/JSONArray:length	()I
    //   34: anewarray 52	java/lang/String
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_3
    //   40: iload_3
    //   41: aload_2
    //   42: invokevirtual 157	org/json/JSONArray:length	()I
    //   45: if_icmpge +62 -> 107
    //   48: aload_0
    //   49: iload_3
    //   50: aload_2
    //   51: iload_3
    //   52: invokevirtual 160	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   55: checkcast 52	java/lang/String
    //   58: aastore
    //   59: iload_3
    //   60: iconst_1
    //   61: iadd
    //   62: istore_3
    //   63: goto -23 -> 40
    //   66: astore_0
    //   67: aload 4
    //   69: astore_0
    //   70: ldc 20
    //   72: new 22	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   79: ldc 28
    //   81: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 34
    //   90: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 44	com/huawei/hms/support/log/HMSLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: astore_2
    //   101: aload_2
    //   102: areturn
    //   103: astore_2
    //   104: goto -34 -> 70
    //   107: aload_0
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramJSONObject	JSONObject
    //   0	109	1	paramString	String
    //   0	109	2	paramArrayOfString	String[]
    //   39	24	3	i	int
    //   4	64	4	localObject1	Object
    //   1	13	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	38	66	org/json/JSONException
    //   40	59	103	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.c.c
 * JD-Core Version:    0.7.0.1
 */