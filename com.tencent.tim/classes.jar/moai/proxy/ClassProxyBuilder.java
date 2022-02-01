package moai.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ClassProxyBuilder<T>
{
  private static final String FIELD_NAME_HANDLER = "$__handler";
  private static final String FIELD_NAME_METHODS = "$__methodArray";
  private static final String PROXY_CLASS_NAME_MODEL = "%s_proxy";
  private static final String PROXY_CLASS_PACKAGE = "moai.proxy";
  private static final ClassLoader sParentClassLoader = ClassProxyBuilder.class.getClassLoader();
  private static Map<MethodKey, Method> sSuperMethodMaps = new HashMap();
  private final Class<T> baseClass;
  private boolean onlyParent;
  
  private ClassProxyBuilder(Class<T> paramClass)
  {
    this.baseClass = paramClass;
  }
  
  public static Object callSuper(Object paramObject, Method paramMethod, Object... paramVarArgs)
    throws Throwable
  {
    try
    {
      MethodKey localMethodKey = new MethodKey(paramObject.getClass(), paramMethod);
      Method localMethod2 = (Method)sSuperMethodMaps.get(localMethodKey);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod1 = paramObject.getClass().getMethod(superMethodName(paramMethod), paramMethod.getParameterTypes());
        sSuperMethodMaps.put(localMethodKey, localMethod1);
      }
      paramObject = localMethod1.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      throw paramObject.getCause();
    }
  }
  
  public static <T> ClassProxyBuilder<T> forClass(Class<T> paramClass)
  {
    return new ClassProxyBuilder(paramClass);
  }
  
  private static Set<MethodSetEntry> getFinalMethods(Class<?> paramClass)
  {
    HashSet localHashSet = new HashSet();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = paramClass[i];
      if ((localMethod.getModifiers() & 0x10) != 0) {
        localHashSet.add(new MethodSetEntry(localMethod));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  public static InvocationHandler getInvocationHandler(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("$__handler");
      localField.setAccessible(true);
      paramObject = (InvocationHandler)localField.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      throw new IllegalArgumentException("Not a valid proxy instance", paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
  }
  
  private void getMethodsToProxy(Set<MethodSetEntry> paramSet1, Set<MethodSetEntry> paramSet2, Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramClass[i];
      if ((((Method)localObject).getModifiers() & 0x10) != 0)
      {
        localObject = new MethodSetEntry((Method)localObject);
        paramSet2.add(localObject);
        paramSet1.remove(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((((Method)localObject).getModifiers() & 0x8) == 0) && ((Modifier.isPublic(((Method)localObject).getModifiers())) || (Modifier.isProtected(((Method)localObject).getModifiers()))) && ((!((Method)localObject).getName().equals("finalize")) || (((Method)localObject).getParameterTypes().length != 0)))
        {
          localObject = new MethodSetEntry((Method)localObject);
          if ((!paramSet2.contains(localObject)) && (!paramSet1.contains(localObject))) {
            paramSet1.add(localObject);
          }
        }
      }
    }
  }
  
  private Method[] getMethodsToProxyRecursive(Class<?> paramClass, Set<MethodSetEntry> paramSet)
  {
    int j = 0;
    HashSet localHashSet = new HashSet();
    Object localObject1 = paramSet;
    if (paramSet == null) {
      localObject1 = new HashSet();
    }
    for (Object localObject2 = paramClass;; localObject2 = ((Class)localObject2).getSuperclass())
    {
      paramSet = paramClass;
      if (localObject2 == null) {
        break;
      }
      getMethodsToProxy(localHashSet, (Set)localObject1, (Class)localObject2);
    }
    for (;;)
    {
      paramSet = paramSet.getSuperclass();
      if (paramSet == null) {
        break;
      }
      paramClass = paramSet.getInterfaces();
      k = paramClass.length;
      i = 0;
      while (i < k)
      {
        getMethodsToProxy(localHashSet, (Set)localObject1, paramClass[i]);
        i += 1;
      }
    }
    paramClass = new MethodSetEntry[localHashSet.size()];
    paramSet = localHashSet.iterator();
    int i = 0;
    while (paramSet.hasNext())
    {
      paramClass[i] = ((MethodSetEntry)paramSet.next());
      i += 1;
    }
    Arrays.sort(paramClass);
    paramSet = new Method[localHashSet.size()];
    int k = paramClass.length;
    i = 0;
    while (j < k)
    {
      paramSet[i] = paramClass[j].originalMethod;
      j += 1;
      i += 1;
    }
    return paramSet;
  }
  
  public static boolean isProxyClass(Class<?> paramClass)
  {
    try
    {
      paramClass.getDeclaredField("$__handler");
      return true;
    }
    catch (NoSuchFieldException paramClass) {}
    return false;
  }
  
  public static void setInvocationHandler(Object paramObject, InvocationHandler paramInvocationHandler)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("$__handler");
      localField.setAccessible(true);
      localField.set(paramObject, paramInvocationHandler);
      return;
    }
    catch (NoSuchFieldException paramObject)
    {
      throw new IllegalArgumentException("Not a valid proxy instance", paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
  }
  
  private static void setMethodsStaticField(Class<?> paramClass, Method[] paramArrayOfMethod)
  {
    try
    {
      paramClass = paramClass.getDeclaredField("$__methodArray");
      paramClass.setAccessible(true);
      paramClass.set(null, paramArrayOfMethod);
      return;
    }
    catch (NoSuchFieldException paramClass)
    {
      throw new AssertionError(paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  private static String superMethodName(Method paramMethod)
  {
    String str = paramMethod.getReturnType().getName();
    return "super$" + paramMethod.getName() + "$" + str.replace('.', '_').replace('[', '_').replace(';', '_');
  }
  
  public Class<? extends T> buildProxyClass()
    throws ClassNotFoundException
  {
    Object localObject = String.format("%s_proxy", new Object[] { this.baseClass.getSimpleName() });
    Class localClass = sParentClassLoader.loadClass("moai.proxy." + (String)localObject);
    if (!this.onlyParent) {}
    for (localObject = getMethodsToProxyRecursive(this.baseClass, null);; localObject = getMethodsToProxyRecursive(this.baseClass.getSuperclass(), (Set)localObject))
    {
      setMethodsStaticField(localClass, (Method[])localObject);
      return localClass;
      localObject = getFinalMethods(this.baseClass);
    }
  }
  
  public ClassProxyBuilder<T> setProxyParent(boolean paramBoolean)
  {
    this.onlyParent = paramBoolean;
    return this;
  }
  
  static final class MethodKey
  {
    final Class<?> clz;
    final Method method;
    
    MethodKey(Class<?> paramClass, Method paramMethod)
    {
      this.clz = paramClass;
      this.method = paramMethod;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof MethodKey)) {}
      do
      {
        return false;
        paramObject = (MethodKey)paramObject;
      } while (!this.method.equals(paramObject.method));
      return this.clz.equals(paramObject.clz);
    }
    
    public int hashCode()
    {
      return this.method.hashCode();
    }
  }
  
  static class MethodSetEntry
    implements Comparable<MethodSetEntry>
  {
    private final String name;
    private final Method originalMethod;
    private final Class<?>[] paramTypes;
    private String paramsString;
    private final Class<?> returnType;
    
    public MethodSetEntry(Method paramMethod)
    {
      this.originalMethod = paramMethod;
      this.name = paramMethod.getName();
      this.paramTypes = paramMethod.getParameterTypes();
      this.returnType = paramMethod.getReturnType();
    }
    
    private String getParamsString()
    {
      if (this.paramsString == null) {
        this.paramsString = separateWithCommas(this.paramTypes);
      }
      return this.paramsString;
    }
    
    public int compareTo(MethodSetEntry paramMethodSetEntry)
    {
      int i = this.name.compareTo(paramMethodSetEntry.name);
      if (i != 0) {
        return i;
      }
      return getParamsString().compareTo(paramMethodSetEntry.getParamsString());
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof MethodSetEntry))
      {
        paramObject = (MethodSetEntry)paramObject;
        bool1 = bool2;
        if (this.name.equals(paramObject.name))
        {
          bool1 = bool2;
          if (Arrays.equals(this.paramTypes, paramObject.paramTypes)) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      int i = 17 + (this.name.hashCode() + 527);
      return i + (i * 31 + Arrays.hashCode(this.paramTypes));
    }
    
    String separateWithCommas(Class<?>[] paramArrayOfClass)
    {
      int i = 0;
      if ((paramArrayOfClass == null) || (paramArrayOfClass.length <= 0)) {
        return "";
      }
      if (paramArrayOfClass.length == 1) {
        return paramArrayOfClass[0].getName();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      while (i < paramArrayOfClass.length)
      {
        localStringBuilder.append(paramArrayOfClass[i].getName());
        if (i < paramArrayOfClass.length - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.ClassProxyBuilder
 * JD-Core Version:    0.7.0.1
 */