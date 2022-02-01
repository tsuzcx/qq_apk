package com.tencent.ttpic.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.reflect.Type;
import java.util.List;

public final class GsonUtils
{
  private static final String TAG = GsonUtils.class.getName();
  private static Gson gson = new GsonBuilder().create();
  
  public static void confirmValueIsArray(JsonObject paramJsonObject, String paramString)
  {
    if ((paramJsonObject == null) || (paramString == null)) {}
    JsonElement localJsonElement;
    do
    {
      return;
      localJsonElement = paramJsonObject.get(paramString);
    } while ((localJsonElement == null) || (localJsonElement.isJsonArray()));
    JsonArray localJsonArray = new JsonArray();
    localJsonArray.add(localJsonElement);
    paramJsonObject.remove(paramString);
    paramJsonObject.add(paramString, localJsonArray);
  }
  
  public static double getDoubleUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsDouble();
  }
  
  public static float getFloatSafe(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= paramJsonArray.size()) {
      return 0.0F;
    }
    return paramJsonArray.get(paramInt).getAsFloat();
  }
  
  public static float getFloatUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsFloat();
  }
  
  public static int getIntUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsInt();
  }
  
  public static int getIntUnsafe(JsonObject paramJsonObject, String paramString)
  {
    return paramJsonObject.get(paramString).getAsInt();
  }
  
  public static JsonObject getJsonObjectUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsJsonObject();
  }
  
  public static String getStringUnsafe(JsonArray paramJsonArray, int paramInt)
  {
    return paramJsonArray.get(paramInt).getAsString();
  }
  
  public static String getStringUnsafe(JsonObject paramJsonObject, String paramString)
  {
    return paramJsonObject.get(paramString).getAsString();
  }
  
  public static JsonObject json2JsonObject(String paramString)
  {
    try
    {
      paramString = new JsonParser().parse(paramString);
      if ((paramString instanceof JsonObject))
      {
        paramString = (JsonObject)paramString;
        return paramString;
      }
    }
    catch (JsonSyntaxException paramString)
    {
      LogUtils.e(TAG, paramString);
    }
    return null;
  }
  
  public static <T> T json2Obj(Gson paramGson, String paramString, Class<T> paramClass)
  {
    try
    {
      paramGson = paramGson.fromJson(paramString, paramClass);
      return paramGson;
    }
    catch (Throwable paramGson)
    {
      LogUtils.e(TAG, paramGson);
    }
    return null;
  }
  
  public static <T> T json2Obj(Gson paramGson, String paramString, Type paramType)
  {
    try
    {
      paramGson = paramGson.fromJson(paramString, paramType);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      LogUtils.e(paramGson);
    }
    return null;
  }
  
  public static <T> T json2Obj(String paramString, Class<T> paramClass)
  {
    return json2Obj(gson, paramString, paramClass);
  }
  
  public static <T> T json2Obj(String paramString, Type paramType)
  {
    try
    {
      paramString = gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  /* Error */
  public static <T> List<T> json2ObjList(Gson paramGson, String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: new 102	com/google/gson/JsonParser
    //   3: dup
    //   4: invokespecial 103	com/google/gson/JsonParser:<init>	()V
    //   7: aload_1
    //   8: invokevirtual 106	com/google/gson/JsonParser:parse	(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   11: invokevirtual 144	com/google/gson/JsonElement:getAsJsonArray	()Lcom/google/gson/JsonArray;
    //   14: astore 6
    //   16: new 146	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 147	java/util/ArrayList:<init>	()V
    //   23: astore_1
    //   24: iconst_0
    //   25: istore_3
    //   26: aload 6
    //   28: invokevirtual 73	com/google/gson/JsonArray:size	()I
    //   31: istore 4
    //   33: aload_1
    //   34: astore 5
    //   36: iload_3
    //   37: iload 4
    //   39: if_icmpge +38 -> 77
    //   42: aload_1
    //   43: aload_0
    //   44: aload 6
    //   46: iload_3
    //   47: invokevirtual 63	com/google/gson/JsonArray:get	(I)Lcom/google/gson/JsonElement;
    //   50: aload_2
    //   51: invokevirtual 150	com/google/gson/Gson:fromJson	(Lcom/google/gson/JsonElement;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: invokeinterface 155 2 0
    //   59: pop
    //   60: iload_3
    //   61: iconst_1
    //   62: iadd
    //   63: istore_3
    //   64: goto -31 -> 33
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_1
    //   71: invokestatic 133	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: astore 5
    //   77: aload 5
    //   79: areturn
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: astore_1
    //   85: goto -15 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramGson	Gson
    //   0	88	1	paramString	String
    //   0	88	2	paramClass	Class<T>
    //   25	39	3	i	int
    //   31	9	4	j	int
    //   34	44	5	localObject	Object
    //   14	31	6	localJsonArray	JsonArray
    // Exception table:
    //   from	to	target	type
    //   0	24	67	java/lang/Exception
    //   26	33	80	java/lang/Exception
    //   42	60	80	java/lang/Exception
  }
  
  public static <T> List<T> json2ObjList(String paramString, Class<T> paramClass)
  {
    return json2ObjList(gson, paramString, paramClass);
  }
  
  public static <T> String obj2Json(Gson paramGson, T paramT)
  {
    try
    {
      paramGson = paramGson.toJson(paramT);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      LogUtils.e(paramGson);
    }
    return null;
  }
  
  public static <T> String obj2Json(Gson paramGson, T paramT, Type paramType)
  {
    try
    {
      paramGson = paramGson.toJson(paramT, paramType);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      LogUtils.e(paramGson);
    }
    return null;
  }
  
  public static <T> String obj2Json(T paramT)
  {
    return obj2Json(gson, paramT);
  }
  
  public static <T> String obj2Json(T paramT, Type paramType)
  {
    return obj2Json(gson, paramT, paramType);
  }
  
  public static <T> String objList2Json(Gson paramGson, List<T> paramList)
  {
    try
    {
      paramGson = paramGson.toJson(paramList);
      return paramGson;
    }
    catch (Exception paramGson)
    {
      LogUtils.e(paramGson);
    }
    return null;
  }
  
  public static <T> String objList2Json(List<T> paramList)
  {
    return objList2Json(gson, paramList);
  }
  
  public static boolean optBoolean(JsonObject paramJsonObject, String paramString)
  {
    return optBoolean(paramJsonObject, paramString, false);
  }
  
  public static boolean optBoolean(JsonObject paramJsonObject, String paramString, boolean paramBoolean)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      boolean bool = paramBoolean;
      if ((paramJsonObject instanceof JsonPrimitive)) {
        bool = paramJsonObject.getAsBoolean();
      }
      return bool;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramBoolean;
  }
  
  public static double optDouble(JsonArray paramJsonArray, int paramInt)
  {
    return optDouble(paramJsonArray, paramInt, (0.0D / 0.0D));
  }
  
  public static double optDouble(JsonArray paramJsonArray, int paramInt, double paramDouble)
  {
    double d = paramDouble;
    if (paramInt >= 0) {
      d = paramDouble;
    }
    try
    {
      if (paramInt < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt);
        d = paramDouble;
        if ((paramJsonArray instanceof JsonPrimitive)) {
          d = paramJsonArray.getAsDouble();
        }
      }
      return d;
    }
    catch (Exception paramJsonArray)
    {
      LogUtils.e(TAG, paramJsonArray);
    }
    return paramDouble;
  }
  
  public static double optDouble(JsonObject paramJsonObject, String paramString)
  {
    return optDouble(paramJsonObject, paramString, (0.0D / 0.0D));
  }
  
  public static double optDouble(JsonObject paramJsonObject, String paramString, double paramDouble)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      double d = paramDouble;
      if ((paramJsonObject instanceof JsonPrimitive)) {
        d = paramJsonObject.getAsDouble();
      }
      return d;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramDouble;
  }
  
  public static float optFloat(JsonObject paramJsonObject, String paramString)
  {
    return optFloat(paramJsonObject, paramString, (0.0F / 0.0F));
  }
  
  public static float optFloat(JsonObject paramJsonObject, String paramString, float paramFloat)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      float f = paramFloat;
      if ((paramJsonObject instanceof JsonPrimitive)) {
        f = paramJsonObject.getAsFloat();
      }
      return f;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramFloat;
  }
  
  public static int optInt(JsonArray paramJsonArray, int paramInt)
  {
    return optInt(paramJsonArray, paramInt, 0);
  }
  
  public static int optInt(JsonArray paramJsonArray, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt1 >= 0) {
      i = paramInt2;
    }
    try
    {
      if (paramInt1 < paramJsonArray.size())
      {
        paramJsonArray = paramJsonArray.get(paramInt1);
        i = paramInt2;
        if ((paramJsonArray instanceof JsonPrimitive)) {
          i = paramJsonArray.getAsInt();
        }
      }
      return i;
    }
    catch (Exception paramJsonArray)
    {
      LogUtils.e(TAG, paramJsonArray);
    }
    return paramInt2;
  }
  
  public static int optInt(JsonObject paramJsonObject, String paramString)
  {
    return optInt(paramJsonObject, paramString, 0);
  }
  
  public static int optInt(JsonObject paramJsonObject, String paramString, int paramInt)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      int i = paramInt;
      if ((paramJsonObject instanceof JsonPrimitive)) {
        i = paramJsonObject.getAsInt();
      }
      return i;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramInt;
  }
  
  public static JsonArray optJsonArray(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < paramJsonArray.size())
        {
          paramJsonArray = paramJsonArray.get(paramInt);
          if ((paramJsonArray instanceof JsonArray))
          {
            paramJsonArray = (JsonArray)paramJsonArray;
            return paramJsonArray;
          }
        }
      }
      catch (Exception paramJsonArray)
      {
        LogUtils.e(TAG, paramJsonArray);
      }
    }
    return null;
  }
  
  public static JsonArray optJsonArray(JsonObject paramJsonObject, String paramString)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonArray))
      {
        paramJsonObject = (JsonArray)paramJsonObject;
        return paramJsonObject;
      }
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return null;
  }
  
  public static JsonObject optJsonObject(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < paramJsonArray.size())
        {
          paramJsonArray = paramJsonArray.get(paramInt);
          if ((paramJsonArray instanceof JsonObject))
          {
            paramJsonArray = (JsonObject)paramJsonArray;
            return paramJsonArray;
          }
        }
      }
      catch (Exception paramJsonArray)
      {
        LogUtils.e(TAG, paramJsonArray);
      }
    }
    return null;
  }
  
  public static JsonObject optJsonObject(JsonObject paramJsonObject, String paramString)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      if ((paramJsonObject instanceof JsonObject))
      {
        paramJsonObject = (JsonObject)paramJsonObject;
        return paramJsonObject;
      }
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return null;
  }
  
  public static long optLong(JsonObject paramJsonObject, String paramString)
  {
    return optLong(paramJsonObject, paramString, 0L);
  }
  
  public static long optLong(JsonObject paramJsonObject, String paramString, long paramLong)
  {
    try
    {
      paramJsonObject = paramJsonObject.get(paramString);
      long l = paramLong;
      if ((paramJsonObject instanceof JsonPrimitive)) {
        l = paramJsonObject.getAsLong();
      }
      return l;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramLong;
  }
  
  public static String optString(JsonArray paramJsonArray, int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        if (paramInt < paramJsonArray.size())
        {
          paramJsonArray = paramJsonArray.get(paramInt);
          if ((paramJsonArray instanceof JsonPrimitive))
          {
            paramJsonArray = paramJsonArray.getAsString();
            return paramJsonArray;
          }
        }
      }
      catch (Exception paramJsonArray)
      {
        LogUtils.e(TAG, paramJsonArray);
      }
    }
    return "";
  }
  
  public static String optString(JsonObject paramJsonObject, String paramString)
  {
    return optString(paramJsonObject, paramString, "");
  }
  
  public static String optString(JsonObject paramJsonObject, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramJsonObject.get(paramString1);
      paramJsonObject = paramString2;
      if ((paramString1 instanceof JsonPrimitive)) {
        paramJsonObject = paramString1.getAsString();
      }
      return paramJsonObject;
    }
    catch (Exception paramJsonObject)
    {
      LogUtils.e(TAG, paramJsonObject);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.GsonUtils
 * JD-Core Version:    0.7.0.1
 */