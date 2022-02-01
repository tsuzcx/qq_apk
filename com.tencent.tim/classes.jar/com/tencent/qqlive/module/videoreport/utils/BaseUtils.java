package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.tencent.qqlive.module.videoreport.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class BaseUtils
{
  public static <T> boolean contains(Collection<T> paramCollection, T paramT)
  {
    if ((isEmpty(paramCollection)) || (paramT == null)) {
      return false;
    }
    return paramCollection.contains(paramT);
  }
  
  @NonNull
  public static <K, V> Map<K, V> copyNonNull(@Nullable Map<K, V> paramMap)
  {
    return copyTo(paramMap, new ArrayMap());
  }
  
  @NonNull
  public static <K, V> Map<K, V> copyTo(@Nullable Map<K, V> paramMap1, @NonNull Map<K, V> paramMap2)
  {
    if (paramMap1 != null) {
      paramMap2.putAll(paramMap1);
    }
    return paramMap2;
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  public static <T> T nullAs(T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      return paramT2;
    }
    return paramT1;
  }
  
  public static String readFileFromAssets(Context paramContext, String paramString)
  {
    Object localObject = null;
    Context localContext = null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramContext = paramContext.getAssets().open(paramString);
      localContext = paramContext;
      localObject = paramContext;
      paramString = new byte[1024];
      for (;;)
      {
        localContext = paramContext;
        localObject = paramContext;
        int i = paramContext.read(paramString);
        if (i == -1) {
          break;
        }
        localContext = paramContext;
        localObject = paramContext;
        localByteArrayOutputStream.write(paramString, 0, i);
      }
      try
      {
        String str;
        localByteArrayOutputStream.close();
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext = paramContext;
      localObject = localContext;
      Log.e("readAssets", paramContext.getMessage());
      try
      {
        localByteArrayOutputStream.close();
        if (localContext != null) {
          localContext.close();
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      paramString = "";
      for (;;)
      {
        return paramString;
        localContext = paramContext;
        localObject = paramContext;
        str = localByteArrayOutputStream.toString();
        localContext = paramContext;
        localObject = paramContext;
        Log.v("readAssets", str);
        try
        {
          localByteArrayOutputStream.close();
          paramString = str;
          if (paramContext != null)
          {
            paramContext.close();
            return str;
          }
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          return str;
        }
      }
    }
    finally {}
    throw paramContext;
  }
  
  public static <T> int size(Collection<T> paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.BaseUtils
 * JD-Core Version:    0.7.0.1
 */