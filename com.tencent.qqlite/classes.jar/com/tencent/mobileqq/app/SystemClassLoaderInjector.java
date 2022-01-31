package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SystemClassLoaderInjector
{
  private static Object a(Object paramObject)
  {
    return a(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  private static Object a(Object paramObject, Class paramClass, String paramString)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  private static Object a(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int k = Array.getLength(paramObject2) + j;
    localObject = Array.newInstance((Class)localObject, k);
    int i = 0;
    if (i < k)
    {
      if (i < j) {
        Array.set(localObject, i, Array.get(paramObject1, i));
      }
      for (;;)
      {
        i += 1;
        break;
        Array.set(localObject, i, Array.get(paramObject2, i - j));
      }
    }
    return localObject;
  }
  
  public static String a(Application paramApplication, String paramString1, String paramString2)
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      String str = b(paramApplication, paramString1, paramString2);
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return c(paramApplication, paramString1, paramString2);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return d(paramApplication, paramString1, paramString2);
  }
  
  private static void a(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  private static Object b(Object paramObject)
  {
    return a(paramObject, paramObject.getClass(), "dexElements");
  }
  
  private static Object b(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject1.getClass().getComponentType();
    int j = Array.getLength(paramObject1);
    int k = j + 1;
    localObject = Array.newInstance((Class)localObject, k);
    int i = 0;
    if (i < k)
    {
      if (i < j) {
        Array.set(localObject, i, Array.get(paramObject1, i));
      }
      for (;;)
      {
        i += 1;
        break;
        Array.set(localObject, i, paramObject2);
      }
    }
    return localObject;
  }
  
  private static String b(Application paramApplication, String paramString1, String paramString2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader);
    String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
    try
    {
      Class localClass = Class.forName("dalvik.system.LexClassLoader");
      paramApplication = localClass.getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class }).newInstance(new Object[] { paramApplication.getDir("dex", 0).getAbsolutePath() + File.separator + str, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, localPathClassLoader });
      localClass.getMethod("loadClass", new Class[] { String.class }).invoke(paramApplication, new Object[] { paramString2 });
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, localClass, "mRawDexPath")));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, localClass, "mFiles")));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, localClass, "mZips")));
      a(localPathClassLoader, PathClassLoader.class, "mLexs", a(a(localPathClassLoader, PathClassLoader.class, "mLexs"), a(paramApplication, localClass, "mDexs")));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectInAliyunOs error: " + Log.getStackTraceString(paramApplication);
  }
  
  @TargetApi(14)
  private static String c(Application paramApplication, String paramString1, String paramString2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    paramApplication = new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    try
    {
      paramApplication.loadClass(paramString2);
      a(localPathClassLoader, PathClassLoader.class, "mPaths", b(a(localPathClassLoader, PathClassLoader.class, "mPaths"), a(paramApplication, DexClassLoader.class, "mRawDexPath")));
      a(localPathClassLoader, PathClassLoader.class, "mFiles", a(a(localPathClassLoader, PathClassLoader.class, "mFiles"), a(paramApplication, DexClassLoader.class, "mFiles")));
      a(localPathClassLoader, PathClassLoader.class, "mZips", a(a(localPathClassLoader, PathClassLoader.class, "mZips"), a(paramApplication, DexClassLoader.class, "mZips")));
      a(localPathClassLoader, PathClassLoader.class, "mDexs", a(a(localPathClassLoader, PathClassLoader.class, "mDexs"), a(paramApplication, DexClassLoader.class, "mDexs")));
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectBelowApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
  
  @SuppressLint({"NewApi"})
  private static String d(Application paramApplication, String paramString1, String paramString2)
  {
    PathClassLoader localPathClassLoader = (PathClassLoader)paramApplication.getClassLoader();
    paramApplication = new DexClassLoader(paramString1, paramApplication.getDir("dex", 0).getAbsolutePath(), paramString1, paramApplication.getClassLoader());
    try
    {
      paramApplication.loadClass(paramString2);
      paramApplication = a(b(a(localPathClassLoader)), b(a(paramApplication)));
      paramString1 = a(localPathClassLoader);
      a(paramString1, paramString1.getClass(), "dexElements", paramApplication);
      return "Success";
    }
    catch (Throwable paramApplication)
    {
      paramApplication.printStackTrace();
    }
    return "injectAboveEqualApiLevel14 error: " + Log.getStackTraceString(paramApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SystemClassLoaderInjector
 * JD-Core Version:    0.7.0.1
 */