import java.util.concurrent.ConcurrentHashMap;

public class wkm
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(xwg.class, wkj.class);
    b.put(wpb.class, wkk.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(xwg.class))
      {
        Object localObject = paramClass1.cast(new wkj());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      yqp.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (wjy.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        yqp.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return wkn.a(paramClass1);
    }
    label110:
    paramClass = wkn.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!wjy.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (wjy.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      yqp.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return wkn.a(paramClass, paramVarArgs);
    label124:
    Object localObject = wkn.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkm
 * JD-Core Version:    0.7.0.1
 */