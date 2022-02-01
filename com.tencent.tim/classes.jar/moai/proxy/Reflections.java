package moai.proxy;

import com.google.common.reflect.Reflection;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Reflections
{
  private static final Field ifTable;
  
  static
  {
    Object localObject = null;
    try
    {
      Field localField = Class.class.getDeclaredField("ifTable");
      localObject = localField;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    ifTable = localObject;
  }
  
  private static <T> Class<? extends T> createProxyClass(Class<T> paramClass, boolean paramBoolean)
  {
    try
    {
      paramClass = ClassProxyBuilder.forClass(paramClass).setProxyParent(paramBoolean).buildProxyClass();
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      throw new AssertionError(paramClass);
    }
  }
  
  public static <T> HashSet<Class<? extends T>> filterSuperBy(Class<T> paramClass, Class<? extends T> paramClass1)
  {
    if (!paramClass.isInterface()) {
      throw new IllegalArgumentException("base should be a interface");
    }
    Object localObject = getAllInterfaces(paramClass1);
    ((HashSet)localObject).remove(paramClass);
    paramClass1 = new HashSet();
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Class localClass = (Class)((Iterator)localObject).next();
      if (isExtendsFrom(paramClass, localClass)) {
        paramClass1.add(localClass);
      }
    }
    return paramClass1;
  }
  
  public static HashSet<Class<?>> getAllInterfaces(Class<?> paramClass)
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = paramClass;
    int j;
    int i;
    Object localObject2;
    Class<?> localClass;
    if (ifTable != null)
    {
      ifTable.setAccessible(true);
      try
      {
        localObject1 = (Object[])ifTable.get(paramClass);
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if ((localObject2 instanceof Class)) {
            localHashSet.add((Class)localObject2);
          }
          i += 1;
        }
        return localHashSet;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localClass = paramClass;
      }
    }
    paramClass = localClass.getInterfaces();
    if (paramClass.length > 0)
    {
      j = paramClass.length;
      i = 0;
      while (i < j)
      {
        localObject2 = paramClass[i];
        if (!localHashSet.contains(localObject2)) {
          localHashSet.addAll(getAllInterfaces(localObject2));
        }
        i += 1;
      }
      localHashSet.addAll(Arrays.asList(paramClass));
    }
    paramClass = localClass.getSuperclass();
    if (paramClass == null) {}
    for (;;)
    {
      return localHashSet;
      localClass = paramClass;
      if (paramClass != Object.class) {
        break;
      }
    }
  }
  
  public static boolean isExtendsFrom(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass1 == paramClass2) {
      return true;
    }
    paramClass2 = paramClass2.getInterfaces();
    int j = paramClass2.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label39;
      }
      if (isExtendsFrom(paramClass1, paramClass2[i])) {
        break;
      }
      i += 1;
    }
    label39:
    return false;
  }
  
  public static <T> T nullable(Nullable<T> paramNullable)
  {
    return proxy(paramNullable.parameterizedType, new Reflections.1(paramNullable));
  }
  
  public static <T> Class<T> parameterizedType(Object paramObject, int paramInt)
  {
    paramObject = paramObject.getClass().getGenericSuperclass();
    if (!(paramObject instanceof ParameterizedType)) {
      throw new RuntimeException("object has a anonymous type.");
    }
    return (Class)((ParameterizedType)paramObject).getActualTypeArguments()[paramInt];
  }
  
  public static <T> T proxy(Class<T> paramClass, InvocationHandler paramInvocationHandler)
  {
    if (paramClass.isInterface()) {
      return Reflection.newProxy(paramClass, paramInvocationHandler);
    }
    return proxyClass(paramClass, paramInvocationHandler);
  }
  
  /* Error */
  public static <T> T proxyClass(Class<T> paramClass, InvocationHandler paramInvocationHandler)
  {
    // Byte code:
    //   0: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: ldc 184
    //   7: invokevirtual 188	java/lang/Class:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   10: checkcast 184	moai/proxy/annotation/OnlyParent
    //   13: ifnull +88 -> 101
    //   16: iconst_1
    //   17: istore 4
    //   19: aload_0
    //   20: iload 4
    //   22: invokestatic 190	moai/proxy/Reflections:createProxyClass	(Ljava/lang/Class;Z)Ljava/lang/Class;
    //   25: iconst_0
    //   26: anewarray 12	java/lang/Class
    //   29: invokevirtual 194	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   32: astore 5
    //   34: aload 5
    //   36: iconst_1
    //   37: invokevirtual 197	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   40: aload 5
    //   42: iconst_0
    //   43: anewarray 4	java/lang/Object
    //   46: invokevirtual 201	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 5
    //   51: aload 5
    //   53: aload_1
    //   54: invokestatic 205	moai/proxy/ClassProxyBuilder:setInvocationHandler	(Ljava/lang/Object;Ljava/lang/reflect/InvocationHandler;)V
    //   57: getstatic 209	java/lang/System:out	Ljava/io/PrintStream;
    //   60: new 211	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   67: ldc 214
    //   69: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: invokevirtual 222	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   76: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 224
    //   81: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   87: lload_2
    //   88: lsub
    //   89: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 235	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   98: aload 5
    //   100: areturn
    //   101: iconst_0
    //   102: istore 4
    //   104: goto -85 -> 19
    //   107: astore_1
    //   108: new 159	java/lang/RuntimeException
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   116: athrow
    //   117: astore_1
    //   118: getstatic 209	java/lang/System:out	Ljava/io/PrintStream;
    //   121: new 211	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   128: ldc 214
    //   130: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: invokevirtual 222	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   137: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc 224
    //   142: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokestatic 182	java/lang/System:currentTimeMillis	()J
    //   148: lload_2
    //   149: lsub
    //   150: invokevirtual 227	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 235	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramClass	Class<T>
    //   0	161	1	paramInvocationHandler	InvocationHandler
    //   3	146	2	l	long
    //   17	86	4	bool	boolean
    //   32	67	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	107	java/lang/Exception
    //   19	57	107	java/lang/Exception
    //   4	16	117	finally
    //   19	57	117	finally
    //   108	117	117	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.proxy.Reflections
 * JD-Core Version:    0.7.0.1
 */