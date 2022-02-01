package moai.proxy;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;

public class JavaBeanProxy
{
  private static final LoadingCache<Object, Set<String>> propertyNames = CacheBuilder.newBuilder().weakKeys().build(new JavaBeanProxy.1());
  
  public static <T> T create(Class<T> paramClass)
  {
    try
    {
      paramClass = Reflections.proxyClass(paramClass, new BeanHandler(paramClass));
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass);
    }
  }
  
  public static String decapitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((paramString.length() > 1) && (Character.isUpperCase(paramString.charAt(1))) && (Character.isUpperCase(paramString.charAt(0)))) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    paramString[0] = Character.toLowerCase(paramString[0]);
    return new String(paramString);
  }
  
  public static boolean has(Object paramObject, String paramString)
  {
    if (!ClassProxyBuilder.isProxyClass(paramObject.getClass())) {}
    while (ClassProxyBuilder.getInvocationHandler(paramObject).getClass() != BeanHandler.class) {
      return true;
    }
    paramObject = (Set)propertyNames.getIfPresent(paramObject);
    if ((paramObject != null) && (paramObject.contains(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static class BeanHandler<T>
    implements InvocationHandler
  {
    private final Class<T> clazz;
    
    BeanHandler(Class<T> paramClass)
    {
      this.clazz = paramClass;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      int m = 0;
      int n = 1;
      String str = paramMethod.getName();
      int i;
      int j;
      label54:
      int k;
      label66:
      char c;
      if (str.length() < 4)
      {
        i = 1;
        if ((paramMethod.getReturnType().equals(Void.TYPE)) || (paramMethod.getReturnType().equals(this.clazz))) {
          break label164;
        }
        j = 1;
        if (paramMethod.getParameterTypes().length == 1) {
          break label170;
        }
        k = 1;
        if (!str.startsWith("set")) {
          m = 1;
        }
        i = k | j | i | m;
        if (i != 0) {
          break label284;
        }
        c = str.charAt(3);
        if (!Character.isUpperCase(c)) {
          break label176;
        }
        str = Character.toLowerCase(str.charAt(3)) + str.substring(4);
      }
      for (;;)
      {
        if (i != 0)
        {
          return ClassProxyBuilder.callSuper(paramObject, paramMethod, paramArrayOfObject);
          i = 0;
          break;
          label164:
          j = 0;
          break label54;
          label170:
          k = 0;
          break label66;
          label176:
          if (c == '_')
          {
            str = str.substring(4);
            continue;
          }
          if (c == 'f')
          {
            str = str.substring(3);
            continue;
          }
          if ((str.length() >= 5) && (Character.isUpperCase(str.charAt(4))))
          {
            str = JavaBeanProxy.decapitalize(str.substring(3));
            continue;
          }
          str = null;
          i = n;
          continue;
        }
        ((Set)JavaBeanProxy.propertyNames.get(paramObject)).add(str);
        return ClassProxyBuilder.callSuper(paramObject, paramMethod, paramArrayOfObject);
        label284:
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.JavaBeanProxy
 * JD-Core Version:    0.7.0.1
 */