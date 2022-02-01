package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class Lifecycling
{
  private static final int GENERATED_CALLBACK = 2;
  private static final int REFLECTIVE_CALLBACK = 1;
  private static Map<Class, Integer> sCallbackCache = new HashMap();
  private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters = new HashMap();
  
  private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (GeneratedAdapter)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  @Nullable
  private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        localObject = paramClass.getPackage();
        String str = paramClass.getCanonicalName();
        if (localObject != null)
        {
          localObject = ((Package)localObject).getName();
          if (((String)localObject).isEmpty())
          {
            str = getAdapterName(str);
            if (((String)localObject).isEmpty())
            {
              localObject = str;
              paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
              if (paramClass.isAccessible()) {
                break label124;
              }
              paramClass.setAccessible(true);
              return paramClass;
            }
          }
          else
          {
            str = str.substring(((String)localObject).length() + 1);
            continue;
          }
          localObject = (String)localObject + "." + str;
          continue;
          return paramClass;
        }
      }
      catch (ClassNotFoundException paramClass)
      {
        return null;
      }
      catch (NoSuchMethodException paramClass)
      {
        throw new RuntimeException(paramClass);
      }
      label124:
      Object localObject = "";
    }
  }
  
  public static String getAdapterName(String paramString)
  {
    return paramString.replace(".", "_") + "_LifecycleAdapter";
  }
  
  @Deprecated
  @NonNull
  static GenericLifecycleObserver getCallback(Object paramObject)
  {
    return new Lifecycling.1(lifecycleEventObserver(paramObject));
  }
  
  private static int getObserverConstructorType(Class<?> paramClass)
  {
    Integer localInteger = (Integer)sCallbackCache.get(paramClass);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    int i = resolveObserverCallbackType(paramClass);
    sCallbackCache.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static boolean isLifecycleParent(Class<?> paramClass)
  {
    return (paramClass != null) && (LifecycleObserver.class.isAssignableFrom(paramClass));
  }
  
  @NonNull
  static LifecycleEventObserver lifecycleEventObserver(Object paramObject)
  {
    boolean bool1 = paramObject instanceof LifecycleEventObserver;
    boolean bool2 = paramObject instanceof FullLifecycleObserver;
    if ((bool1) && (bool2)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject, (LifecycleEventObserver)paramObject);
    }
    if (bool2) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject, null);
    }
    if (bool1) {
      return (LifecycleEventObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (getObserverConstructorType((Class)localObject) == 2)
    {
      localObject = (List)sClassToAdapters.get(localObject);
      if (((List)localObject).size() == 1) {
        return new SingleGeneratedAdapterObserver(createGeneratedAdapter((Constructor)((List)localObject).get(0), paramObject));
      }
      GeneratedAdapter[] arrayOfGeneratedAdapter = new GeneratedAdapter[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfGeneratedAdapter[i] = createGeneratedAdapter((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfGeneratedAdapter);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static int resolveObserverCallbackType(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = generatedConstructor(paramClass);
    if (localObject1 != null)
    {
      sClassToAdapters.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (ClassesInfoCache.sInstance.hasLifecycleMethods(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (isLifecycleParent((Class)localObject2))
    {
      if (getObserverConstructorType((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)sClassToAdapters.get(localObject2));
    }
    localObject2 = paramClass.getInterfaces();
    int j = localObject2.length;
    int i = 0;
    Class localClass;
    while (i < j)
    {
      localClass = localObject2[i];
      if (!isLifecycleParent(localClass))
      {
        i += 1;
      }
      else
      {
        if (getObserverConstructorType(localClass) == 1) {
          return 1;
        }
        if (localObject1 != null) {
          break label197;
        }
        localObject1 = new ArrayList();
      }
    }
    label197:
    for (;;)
    {
      ((List)localObject1).addAll((Collection)sClassToAdapters.get(localClass));
      break;
      if (localObject1 != null)
      {
        sClassToAdapters.put(paramClass, localObject1);
        return 2;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.lifecycle.Lifecycling
 * JD-Core Version:    0.7.0.1
 */