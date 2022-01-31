package com.tencent.commonsdk.soload;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.ZipFile;

public final class SoDexClassLoader
  extends DexClassLoader
{
  public SoDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    try
    {
      File localFile = new File(paramString1);
      Object localObject = new File(paramString2);
      paramString2 = getPathList(this);
      paramString3 = getPathList(paramClassLoader);
      paramString1 = getDexElements(paramString3);
      paramClassLoader = paramString3.getClass().getDeclaredMethod("loadDexFile", new Class[] { File.class, File.class });
      paramClassLoader.setAccessible(true);
      localObject = (DexFile)paramClassLoader.invoke(null, new Object[] { localFile, localObject });
      ZipFile localZipFile = new ZipFile(localFile);
      paramClassLoader = paramString1.getClass().getComponentType();
      try
      {
        paramClassLoader.getConstructors();
        paramString1 = paramClassLoader.getConstructor(new Class[] { File.class, File.class, DexFile.class }).newInstance(new Object[] { localFile, localFile, localObject });
        paramClassLoader = Array.newInstance(paramClassLoader, 1);
        Array.set(paramClassLoader, 0, paramString1);
        setField(paramString2, paramString3.getClass(), "dexElements", paramClassLoader);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          try
          {
            paramString1 = paramClassLoader.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class }).newInstance(new Object[] { localFile, localZipFile, localObject });
          }
          catch (Exception paramString1)
          {
            try
            {
              paramString1 = paramClassLoader.getConstructor(new Class[] { File.class, Boolean.TYPE, File.class, DexFile.class }).newInstance(new Object[] { localFile, Boolean.valueOf(false), localFile, localObject });
            }
            catch (Exception paramString1)
            {
              paramString1 = paramClassLoader.getConstructor(new Class[] { File.class, Boolean.TYPE, ZipFile.class, DexFile.class }).newInstance(new Object[] { localFile, Boolean.valueOf(false), localZipFile, localObject });
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public static Object getDexElements(Object paramObject)
    throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException
  {
    return getField(paramObject, paramObject.getClass(), "dexElements");
  }
  
  public static Object getField(Object paramObject, Class<?> paramClass, String paramString)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    return paramClass.get(paramObject);
  }
  
  public static Object getPathList(Object paramObject)
    throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException
  {
    return getField(paramObject, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
  }
  
  public static void setField(Object paramObject1, Class<?> paramClass, String paramString, Object paramObject2)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoDexClassLoader
 * JD-Core Version:    0.7.0.1
 */