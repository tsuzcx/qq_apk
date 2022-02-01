package com.tencent.mobileqq.nativememorymonitor.library;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Utils
{
  public static long getArtMethod(Class paramClass, String paramString, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramString = paramClass.getClass().getSuperclass().getDeclaredField("artMethod");
      paramString.setAccessible(true);
      long l = ((Long)paramString.get(paramClass)).longValue();
      return l;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
      return 0L;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
    catch (NoSuchFieldException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static long getHiddenArtMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      paramString1 = (Method)Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class }).invoke(Class.forName(paramString1), new Object[] { paramString2, paramVarArgs });
      paramString2 = paramString1.getClass().getSuperclass().getDeclaredField("artMethod");
      paramString2.setAccessible(true);
      long l = ((Long)paramString2.get(paramString1)).longValue();
      return l;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return 0L;
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    catch (NoSuchFieldException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.Utils
 * JD-Core Version:    0.7.0.1
 */