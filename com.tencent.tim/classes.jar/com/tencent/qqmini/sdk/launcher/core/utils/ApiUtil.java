package com.tencent.qqmini.sdk.launcher.core.utils;

import android.text.TextUtils;
import org.json.JSONObject;

public final class ApiUtil
{
  private static final String TAG = "ApiUtil";
  
  public static JSONObject wrapCallbackCancel(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":cancel cancel");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
  
  public static JSONObject wrapCallbackFail(String paramString, JSONObject paramJSONObject)
  {
    return wrapCallbackFail(paramString, paramJSONObject, null);
  }
  
  /* Error */
  public static JSONObject wrapCallbackFail(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: aload_1
    //   8: astore_0
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 28	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 29	org/json/JSONObject:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_1
    //   24: ifnonnull +89 -> 113
    //   27: new 28	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 29	org/json/JSONObject:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_1
    //   37: new 33	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 54
    //   50: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +24 -> 82
    //   61: ldc 56
    //   63: astore_0
    //   64: aload_1
    //   65: ldc 31
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 48	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: goto +37 -> 116
    //   82: new 33	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   89: ldc 58
    //   91: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -38 -> 64
    //   105: astore_0
    //   106: goto +10 -> 116
    //   109: astore_0
    //   110: goto +6 -> 116
    //   113: goto -76 -> 37
    //   116: aload_1
    //   117: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString1	String
    //   0	118	1	paramJSONObject	JSONObject
    //   0	118	2	paramString2	String
    //   34	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	105	java/lang/Exception
    //   37	61	109	java/lang/Exception
    //   64	79	109	java/lang/Exception
    //   82	102	109	java/lang/Exception
  }
  
  public static JSONObject wrapCallbackOk(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
  
  public static abstract interface OnLocationFinish
  {
    public abstract void onLocationFinishCallback(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil
 * JD-Core Version:    0.7.0.1
 */