package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ank<T>
{
  private final Class<?> a;
  private final String b;
  private final Class[] c;
  
  ank(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class<?> paramClass)
  {
    String str = this.b;
    Method localMethod = null;
    if (str != null)
    {
      localMethod = a(paramClass, str, this.c);
      if (localMethod != null)
      {
        paramClass = this.a;
        if ((paramClass != null) && (!paramClass.isAssignableFrom(localMethod.getReturnType()))) {
          return null;
        }
      }
    }
    return localMethod;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      int i;
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        try
        {
          i = paramClass.getModifiers();
          if ((i & 0x1) == 0)
          {
            return null;
            paramClass = null;
          }
          return paramClass;
        }
        catch (NoSuchMethodException paramString) {}
        paramClass = paramClass;
      }
    }
  }
  
  private Object c(T paramT, Object... paramVarArgs)
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  private Object d(T paramT, Object... paramVarArgs)
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod != null) {
      try
      {
        paramT = localMethod.invoke(paramT, paramVarArgs);
        return paramT;
      }
      catch (IllegalAccessException paramT)
      {
        paramVarArgs = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(localMethod)));
        paramVarArgs.initCause(paramT);
        throw paramVarArgs;
      }
    }
    paramVarArgs = new StringBuilder("Method ");
    paramVarArgs.append(this.b);
    paramVarArgs.append(" not supported for object ");
    paramVarArgs.append(paramT);
    throw new AssertionError(paramVarArgs.toString());
  }
  
  public final Object a(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = c(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public final boolean a(T paramT)
  {
    return a(paramT.getClass()) != null;
  }
  
  public final Object b(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = d(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ank
 * JD-Core Version:    0.7.0.1
 */