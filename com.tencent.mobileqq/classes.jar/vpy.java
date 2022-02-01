import java.util.concurrent.ConcurrentHashMap;

public class vpy
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(xbm.class, vpv.class);
    b.put(vum.class, vpw.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(xbm.class))
      {
        Object localObject = paramClass1.cast(new vpv());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      xvv.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (vpk.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        xvv.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return vpz.a(paramClass1);
    }
    label110:
    paramClass = vpz.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!vpk.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (vpk.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      xvv.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return vpz.a(paramClass, paramVarArgs);
    label124:
    Object localObject = vpz.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpy
 * JD-Core Version:    0.7.0.1
 */