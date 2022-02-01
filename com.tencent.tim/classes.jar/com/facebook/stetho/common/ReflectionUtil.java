package com.facebook.stetho.common;

import java.lang.reflect.Field;
import javax.annotation.Nullable;

public final class ReflectionUtil
{
  @Nullable
  public static Object getFieldValue(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
      throw new RuntimeException(paramField);
    }
  }
  
  @Nullable
  public static Class<?> tryGetClassForName(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString) {}
    return null;
  }
  
  @Nullable
  public static Field tryGetDeclaredField(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      LogUtil.d(localNoSuchFieldException, "Could not retrieve %s field from %s", new Object[] { paramString, paramClass });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.ReflectionUtil
 * JD-Core Version:    0.7.0.1
 */