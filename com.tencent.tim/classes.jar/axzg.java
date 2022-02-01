import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class axzg
{
  private static Map<Class, Integer> sCallbackCache = new HashMap();
  private static Map<Class, List<Constructor<? extends axzb>>> sClassToAdapters = new HashMap();
  
  private static axzb a(Constructor<? extends axzb> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (axzb)paramConstructor.newInstance(new Object[] { paramObject });
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
  
  @NonNull
  public static axzc a(Object paramObject)
  {
    if ((paramObject instanceof axyz)) {
      return new axza((axyz)paramObject);
    }
    if ((paramObject instanceof axzc)) {
      return (axzc)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (getObserverConstructorType((Class)localObject) == 2)
    {
      localObject = (List)sClassToAdapters.get(localObject);
      if (((List)localObject).size() == 1) {
        return new axzk(a((Constructor)((List)localObject).get(0), paramObject));
      }
      axzb[] arrayOfaxzb = new axzb[((List)localObject).size()];
      int i = 0;
      while (i < ((List)localObject).size())
      {
        arrayOfaxzb[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new axyy(arrayOfaxzb);
    }
    return new axzj(paramObject);
  }
  
  @Nullable
  private static Constructor<? extends axzb> generatedConstructor(Class<?> paramClass)
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
  
  private static int getObserverConstructorType(Class<?> paramClass)
  {
    if (sCallbackCache.containsKey(paramClass)) {
      return ((Integer)sCallbackCache.get(paramClass)).intValue();
    }
    int i = resolveObserverCallbackType(paramClass);
    sCallbackCache.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static boolean isLifecycleParent(Class<?> paramClass)
  {
    return (paramClass != null) && (axze.class.isAssignableFrom(paramClass));
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
    if (axyx.a.hasLifecycleMethods(paramClass)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axzg
 * JD-Core Version:    0.7.0.1
 */