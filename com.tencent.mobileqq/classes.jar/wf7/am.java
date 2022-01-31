package wf7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class am
  implements InvocationHandler
{
  static <T> T a(Class<T> paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    am localam = new am();
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localam);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getReturnType();
    if (paramObject == Void.TYPE) {}
    do
    {
      return null;
      if (paramObject == Integer.TYPE) {
        return Integer.valueOf(0);
      }
      if (paramObject == Long.TYPE) {
        return Long.valueOf(0L);
      }
      if (paramObject == Float.TYPE) {
        return Float.valueOf(0.0F);
      }
      if (paramObject == Double.TYPE) {
        return Double.valueOf(0.0D);
      }
      if (paramObject == Short.TYPE) {
        return Short.valueOf((short)0);
      }
      if (paramObject == Boolean.TYPE) {
        return Boolean.valueOf(false);
      }
    } while (paramObject != Byte.TYPE);
    return Byte.valueOf((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.am
 * JD-Core Version:    0.7.0.1
 */