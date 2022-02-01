package com.tencent.mobileqq.triton.sdk.utils;

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
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errMsg", paramString + ":fail cancel");
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        return localJSONObject;
      }
      return paramJSONObject;
    }
    catch (Exception paramString) {}
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
    //   24: astore 4
    //   26: aload_1
    //   27: ifnonnull +12 -> 39
    //   30: new 28	org/json/JSONObject
    //   33: dup
    //   34: invokespecial 29	org/json/JSONObject:<init>	()V
    //   37: astore 4
    //   39: new 33	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 54
    //   52: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: astore_1
    //   56: aload_2
    //   57: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: istore_3
    //   61: iload_3
    //   62: ifeq +25 -> 87
    //   65: ldc 56
    //   67: astore_0
    //   68: aload 4
    //   70: ldc 31
    //   72: aload_1
    //   73: aload_0
    //   74: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 48	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload 4
    //   86: areturn
    //   87: new 33	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   94: ldc 58
    //   96: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_0
    //   107: goto -39 -> 68
    //   110: astore_0
    //   111: aload_1
    //   112: areturn
    //   113: astore_0
    //   114: aload 4
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString1	String
    //   0	117	1	paramJSONObject	JSONObject
    //   0	117	2	paramString2	String
    //   60	2	3	bool	boolean
    //   24	91	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   30	39	110	java/lang/Exception
    //   39	61	113	java/lang/Exception
    //   68	84	113	java/lang/Exception
    //   87	107	113	java/lang/Exception
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
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errMsg", paramString + ":ok");
        return localJSONObject;
      }
      catch (Exception paramString)
      {
        return localJSONObject;
      }
      return paramJSONObject;
    }
    catch (Exception paramString) {}
  }
  
  public static abstract interface OnLocationFinish
  {
    public abstract void onLocationFinishCallback(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.utils.ApiUtil
 * JD-Core Version:    0.7.0.1
 */