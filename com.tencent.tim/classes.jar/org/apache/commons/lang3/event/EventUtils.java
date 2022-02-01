package org.apache.commons.lang3.event;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.reflect.MethodUtils;

public class EventUtils
{
  public static <L> void addEventListener(Object paramObject, Class<L> paramClass, L paramL)
  {
    try
    {
      MethodUtils.invokeMethod(paramObject, "add" + paramClass.getSimpleName(), new Object[] { paramL });
      return;
    }
    catch (NoSuchMethodException paramL)
    {
      throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have a public add" + paramClass.getSimpleName() + " method which takes a parameter of type " + paramClass.getName() + ".");
    }
    catch (IllegalAccessException paramL)
    {
      throw new IllegalArgumentException("Class " + paramObject.getClass().getName() + " does not have an accessible add" + paramClass.getSimpleName() + " method which takes a parameter of type " + paramClass.getName() + ".");
    }
    catch (InvocationTargetException paramObject)
    {
      throw new RuntimeException("Unable to add listener.", paramObject.getCause());
    }
  }
  
  public static <L> void bindEventsToMethod(Object paramObject1, String paramString, Object paramObject2, Class<L> paramClass, String... paramVarArgs)
  {
    ClassLoader localClassLoader = paramObject1.getClass().getClassLoader();
    paramObject1 = new EventBindingInvocationHandler(paramObject1, paramString, paramVarArgs);
    addEventListener(paramObject2, paramClass, paramClass.cast(Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, paramObject1)));
  }
  
  static class EventBindingInvocationHandler
    implements InvocationHandler
  {
    private final Set<String> eventTypes;
    private final String methodName;
    private final Object target;
    
    EventBindingInvocationHandler(Object paramObject, String paramString, String[] paramArrayOfString)
    {
      this.target = paramObject;
      this.methodName = paramString;
      this.eventTypes = new HashSet(Arrays.asList(paramArrayOfString));
    }
    
    private boolean hasMatchingParametersMethod(Method paramMethod)
    {
      return MethodUtils.getAccessibleMethod(this.target.getClass(), this.methodName, paramMethod.getParameterTypes()) != null;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      if ((this.eventTypes.isEmpty()) || (this.eventTypes.contains(paramMethod.getName())))
      {
        if (hasMatchingParametersMethod(paramMethod)) {
          return MethodUtils.invokeMethod(this.target, this.methodName, paramArrayOfObject);
        }
        return MethodUtils.invokeMethod(this.target, this.methodName);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.event.EventUtils
 * JD-Core Version:    0.7.0.1
 */