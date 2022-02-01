import java.util.concurrent.ConcurrentHashMap;

public class woh
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(yab.class, woe.class);
    b.put(wsw.class, wof.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(yab.class))
      {
        Object localObject = paramClass1.cast(new woe());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      yuk.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (wnt.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        yuk.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return woi.a(paramClass1);
    }
    label110:
    paramClass = woi.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!wnt.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (wnt.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      yuk.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return woi.a(paramClass, paramVarArgs);
    label124:
    Object localObject = woi.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woh
 * JD-Core Version:    0.7.0.1
 */