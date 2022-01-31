import java.util.concurrent.ConcurrentHashMap;

public class umr
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(vym.class, umo.class);
    b.put(urg.class, ump.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(vym.class))
      {
        Object localObject = paramClass1.cast(new umo());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      wsv.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (umd.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        wsv.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return ums.a(paramClass1);
    }
    label110:
    paramClass = ums.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!umd.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (umd.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      wsv.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return ums.a(paramClass, paramVarArgs);
    label124:
    Object localObject = ums.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */