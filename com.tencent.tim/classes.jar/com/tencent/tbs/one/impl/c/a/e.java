package com.tencent.tbs.one.impl.c.a;

import dalvik.system.DexClassLoader;

public final class e
  extends DexClassLoader
{
  private final String[] a;
  private final boolean b;
  
  public e(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String[] paramArrayOfString)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.a = paramArrayOfString;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return;
    }
  }
  
  private Class<?> a(String paramString)
    throws ClassNotFoundException
  {
    Object localObject2 = findLoadedClass(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = findClass(paramString);
      localObject2 = localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label20:
      ClassLoader localClassLoader;
      break label20;
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localClassLoader = getParent();
      localObject1 = localObject2;
      if (localClassLoader != null) {
        localObject1 = localClassLoader.loadClass(paramString);
      }
    }
    return localObject1;
  }
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    if ((this.b) && (paramString != null))
    {
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i])) {
          return super.loadClass(paramString, paramBoolean);
        }
        i += 1;
      }
    }
    return a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.e
 * JD-Core Version:    0.7.0.1
 */