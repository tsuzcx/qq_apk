package org.apache.commons.lang3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

public class ConstructorUtils
{
  public static <T> Constructor<T> getAccessibleConstructor(Class<T> paramClass, Class<?>... paramVarArgs)
  {
    Validate.notNull(paramClass, "class cannot be null", new Object[0]);
    try
    {
      paramClass = getAccessibleConstructor(paramClass.getConstructor(paramVarArgs));
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> paramConstructor)
  {
    Validate.notNull(paramConstructor, "constructor cannot be null", new Object[0]);
    if ((MemberUtils.isAccessible(paramConstructor)) && (isAccessible(paramConstructor.getDeclaringClass()))) {
      return paramConstructor;
    }
    return null;
  }
  
  public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> paramClass, Class<?>... paramVarArgs)
  {
    Validate.notNull(paramClass, "class cannot be null", new Object[0]);
    Object localObject;
    Constructor[] arrayOfConstructor;
    int j;
    int i;
    try
    {
      Constructor localConstructor1 = paramClass.getConstructor(paramVarArgs);
      MemberUtils.setAccessibleWorkaround(localConstructor1);
      return localConstructor1;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localObject = null;
      arrayOfConstructor = paramClass.getConstructors();
      j = arrayOfConstructor.length;
      i = 0;
      paramClass = (Class<T>)localObject;
    }
    for (;;)
    {
      localObject = paramClass;
      if (i >= j) {
        break;
      }
      Constructor localConstructor2 = arrayOfConstructor[i];
      localObject = paramClass;
      if (ClassUtils.isAssignable(paramVarArgs, localConstructor2.getParameterTypes(), true))
      {
        localConstructor2 = getAccessibleConstructor(localConstructor2);
        localObject = paramClass;
        if (localConstructor2 != null)
        {
          MemberUtils.setAccessibleWorkaround(localConstructor2);
          if (paramClass != null)
          {
            localObject = paramClass;
            if (MemberUtils.compareParameterTypes(localConstructor2.getParameterTypes(), paramClass.getParameterTypes(), paramVarArgs) >= 0) {}
          }
          else
          {
            localObject = localConstructor2;
          }
        }
      }
      i += 1;
      paramClass = (Class<T>)localObject;
    }
  }
  
  public static <T> T invokeConstructor(Class<T> paramClass, Object... paramVarArgs)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
    return invokeConstructor(paramClass, paramVarArgs, ClassUtils.toClass(paramVarArgs));
  }
  
  public static <T> T invokeConstructor(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
    paramArrayOfClass = getMatchingAccessibleConstructor(paramClass, ArrayUtils.nullToEmpty(paramArrayOfClass));
    if (paramArrayOfClass == null) {
      throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
    }
    return paramArrayOfClass.newInstance(paramArrayOfObject);
  }
  
  public static <T> T invokeExactConstructor(Class<T> paramClass, Object... paramVarArgs)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
    return invokeExactConstructor(paramClass, paramVarArgs, ClassUtils.toClass(paramVarArgs));
  }
  
  public static <T> T invokeExactConstructor(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
    paramArrayOfClass = getAccessibleConstructor(paramClass, ArrayUtils.nullToEmpty(paramArrayOfClass));
    if (paramArrayOfClass == null) {
      throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass.getName());
    }
    return paramArrayOfClass.newInstance(paramArrayOfObject);
  }
  
  private static boolean isAccessible(Class<?> paramClass)
  {
    while (paramClass != null)
    {
      if (!Modifier.isPublic(paramClass.getModifiers())) {
        return false;
      }
      paramClass = paramClass.getEnclosingClass();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.reflect.ConstructorUtils
 * JD-Core Version:    0.7.0.1
 */