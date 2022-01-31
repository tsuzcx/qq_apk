package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ig
{
  private final Class a;
  private final String b;
  private final Class[] c;
  
  ig(Class paramClass, String paramString, Class... paramVarArgs)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class paramClass)
  {
    if (this.b != null)
    {
      paramClass = a(paramClass, this.b, this.c);
      if ((paramClass == null) || (this.a == null) || (this.a.isAssignableFrom(paramClass.getReturnType()))) {}
    }
    else
    {
      return null;
    }
    return paramClass;
  }
  
  private static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      int i;
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      try
      {
        i = paramClass.getModifiers();
        if ((i & 0x1) != 0) {
          return paramClass;
        }
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        return paramClass;
      }
      paramClass = paramClass;
      return null;
    }
  }
  
  public Object a(Object paramObject, Object... paramVarArgs)
  {
    Method localMethod = a(paramObject.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramObject = localMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject) {}
    return null;
  }
  
  public boolean a(Object paramObject)
  {
    return a(paramObject.getClass()) != null;
  }
  
  public Object b(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramObject = a(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = paramObject.getTargetException();
      if ((paramObject instanceof RuntimeException)) {
        throw ((RuntimeException)paramObject);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramObject);
      throw paramVarArgs;
    }
  }
  
  public Object c(Object paramObject, Object... paramVarArgs)
  {
    Method localMethod = a(paramObject.getClass());
    if (localMethod == null) {
      throw new AssertionError("Method " + this.b + " not supported for object " + paramObject);
    }
    try
    {
      paramObject = localMethod.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      paramVarArgs = new AssertionError("Unexpectedly could not call: " + localMethod);
      paramVarArgs.initCause(paramObject);
      throw paramVarArgs;
    }
  }
  
  public Object d(Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramObject = c(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = paramObject.getTargetException();
      if ((paramObject instanceof RuntimeException)) {
        throw ((RuntimeException)paramObject);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramObject);
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ig
 * JD-Core Version:    0.7.0.1
 */