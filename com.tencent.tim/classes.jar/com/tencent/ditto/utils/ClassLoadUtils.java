package com.tencent.ditto.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClassLoadUtils
{
  private static final Set<ClassLoader> LOADERS = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public static void addSubstituteLoader(ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      return;
    }
    LOADERS.add(paramClassLoader);
  }
  
  public static Class<?> load(ClassLoader paramClassLoader, String paramString)
    throws ClassNotFoundException
  {
    Class localClass = null;
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      if (paramClassLoader != null) {
        return paramClassLoader;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      do
      {
        paramClassLoader = localClass;
      } while (!LOADERS.isEmpty());
      throw localClassNotFoundException2;
    }
    Iterator localIterator = LOADERS.iterator();
    if (localIterator.hasNext()) {}
    for (;;)
    {
      try
      {
        localClass = ((ClassLoader)localIterator.next()).loadClass(paramString);
        paramClassLoader = localClass;
        return paramClassLoader;
      }
      catch (ClassNotFoundException localClassNotFoundException1) {}
      if (localIterator.hasNext()) {
        break;
      }
      throw localClassNotFoundException1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.utils.ClassLoadUtils
 * JD-Core Version:    0.7.0.1
 */