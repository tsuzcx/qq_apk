package com.tencent.weseevideo.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.tencent.tavcut.util.Logger;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonUtils
{
  private static Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().serializeNulls().create();
  
  public static <T> T json2Obj(String paramString, Type paramType)
  {
    try
    {
      paramString = new ProxyJsonReader(new StringReader(paramString));
      paramString.setLenient(false);
      paramString = gson.fromJson(paramString, paramType);
      return paramString;
    }
    catch (Exception paramString)
    {
      Logger.e(paramString);
    }
    return null;
  }
  
  /* Error */
  public static <T> List<T> json2ObjList(String paramString, Type paramType)
  {
    // Byte code:
    //   0: new 67	com/google/gson/JsonParser
    //   3: dup
    //   4: invokespecial 68	com/google/gson/JsonParser:<init>	()V
    //   7: aload_0
    //   8: invokevirtual 72	com/google/gson/JsonParser:parse	(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    //   11: invokevirtual 78	com/google/gson/JsonElement:getAsJsonArray	()Lcom/google/gson/JsonArray;
    //   14: astore 5
    //   16: new 80	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 81	java/util/ArrayList:<init>	()V
    //   23: astore_0
    //   24: iconst_0
    //   25: istore_2
    //   26: aload 5
    //   28: invokevirtual 87	com/google/gson/JsonArray:size	()I
    //   31: istore_3
    //   32: aload_0
    //   33: astore 4
    //   35: iload_2
    //   36: iload_3
    //   37: if_icmpge +40 -> 77
    //   40: aload_0
    //   41: getstatic 29	com/tencent/weseevideo/common/utils/GsonUtils:gson	Lcom/google/gson/Gson;
    //   44: aload 5
    //   46: iload_2
    //   47: invokevirtual 91	com/google/gson/JsonArray:get	(I)Lcom/google/gson/JsonElement;
    //   50: aload_1
    //   51: invokevirtual 94	com/google/gson/Gson:fromJson	(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   54: invokeinterface 100 2 0
    //   59: pop
    //   60: iload_2
    //   61: iconst_1
    //   62: iadd
    //   63: istore_2
    //   64: goto -32 -> 32
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_1
    //   71: invokestatic 61	com/tencent/tavcut/util/Logger:e	(Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: astore 4
    //   77: aload 4
    //   79: areturn
    //   80: astore_1
    //   81: goto -11 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   0	84	1	paramType	Type
    //   25	39	2	i	int
    //   31	7	3	j	int
    //   33	45	4	str	String
    //   14	31	5	localJsonArray	com.google.gson.JsonArray
    // Exception table:
    //   from	to	target	type
    //   0	24	67	java/lang/Exception
    //   26	32	80	java/lang/Exception
    //   40	60	80	java/lang/Exception
  }
  
  public static <T> String obj2Json(T paramT)
  {
    try
    {
      paramT = gson.toJson(paramT);
      return paramT;
    }
    catch (Exception paramT)
    {
      Logger.e(paramT);
    }
    return null;
  }
  
  public static <T> String objList2Json(List<T> paramList)
  {
    try
    {
      paramList = gson.toJson(paramList);
      return paramList;
    }
    catch (Exception paramList)
    {
      Logger.e(paramList);
    }
    return null;
  }
  
  public static class ProxyJsonReader
    extends JsonReader
  {
    private static final String TAG = "ProxyJsonReader";
    
    public ProxyJsonReader(Reader paramReader)
    {
      super();
    }
    
    public boolean nextBoolean()
    {
      try
      {
        boolean bool = super.nextBoolean();
        return bool;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextBoolean", localException);
      }
      return false;
    }
    
    public double nextDouble()
    {
      try
      {
        double d = super.nextDouble();
        return d;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextDouble", localException);
      }
      return 0.0D;
    }
    
    public int nextInt()
    {
      try
      {
        int i = super.nextInt();
        return i;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextInt", localException);
      }
      return 0;
    }
    
    public long nextLong()
    {
      try
      {
        long l = super.nextLong();
        return l;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextLong", localException);
      }
      return 0L;
    }
    
    public String nextName()
    {
      try
      {
        String str = super.nextName();
        return str;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextName", localException);
      }
      return "";
    }
    
    public String nextString()
    {
      try
      {
        String str = super.nextString();
        return str;
      }
      catch (Exception localException)
      {
        Logger.e("ProxyJsonReader", "nextString", localException);
      }
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.common.utils.GsonUtils
 * JD-Core Version:    0.7.0.1
 */