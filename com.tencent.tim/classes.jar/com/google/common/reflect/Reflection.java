package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Beta
public final class Reflection
{
  public static String getPackageName(Class<?> paramClass)
  {
    return getPackageName(paramClass.getName());
  }
  
  public static String getPackageName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i < 0) {
      return "";
    }
    return paramString.substring(0, i);
  }
  
  public static void initialize(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramVarArgs[i];
      try
      {
        Class.forName(localClass.getName(), true, localClass.getClassLoader());
        i += 1;
      }
      catch (ClassNotFoundException paramVarArgs)
      {
        throw new AssertionError(paramVarArgs);
      }
    }
  }
  
  public static <T> T newProxy(Class<T> paramClass, InvocationHandler paramInvocationHandler)
  {
    Preconditions.checkNotNull(paramInvocationHandler);
    Preconditions.checkArgument(paramClass.isInterface(), "%s is not an interface", paramClass);
    return paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.Reflection
 * JD-Core Version:    0.7.0.1
 */