package com.tencent.token;

import java.lang.reflect.Method;

final class ib
{
  private final Method a;
  private final Method b;
  private final Method c;
  
  ib(Method paramMethod1, Method paramMethod2, Method paramMethod3)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
  }
  
  static ib a()
  {
    Object localObject1 = null;
    try
    {
      Object localObject3 = Class.forName("dalvik.system.CloseGuard");
      localMethod2 = ((Class)localObject3).getMethod("get", new Class[0]);
      localMethod1 = ((Class)localObject3).getMethod("open", new Class[] { String.class });
      localObject3 = ((Class)localObject3).getMethod("warnIfOpen", new Class[0]);
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Method localMethod1;
        Object localObject2 = null;
        Method localMethod2 = null;
      }
    }
    return new ib(localMethod2, localMethod1, localObject1);
  }
  
  Object a(String paramString)
  {
    if (this.a != null) {
      try
      {
        Object localObject = this.a.invoke(null, new Object[0]);
        this.b.invoke(localObject, new Object[] { paramString });
        return localObject;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  boolean a(Object paramObject)
  {
    boolean bool = false;
    if (paramObject != null) {}
    try
    {
      this.c.invoke(paramObject, new Object[0]);
      bool = true;
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ib
 * JD-Core Version:    0.7.0.1
 */