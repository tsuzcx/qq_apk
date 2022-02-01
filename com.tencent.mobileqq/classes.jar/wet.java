import java.util.concurrent.ConcurrentHashMap;

public class wet
{
  public static ConcurrentHashMap<Class<?>, Class<?>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
  
  static
  {
    a.put(xqh.class, weq.class);
    b.put(wjh.class, wer.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(xqh.class))
      {
        Object localObject = paramClass1.cast(new weq());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ykq.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)a.get(paramClass);
        if (paramClass != null)
        {
          if (wef.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        ykq.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return weu.a(paramClass1);
    }
    label110:
    paramClass = weu.a(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!wef.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)b.get(paramClass);
      if (localClass != null)
      {
        if (wef.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      ykq.c("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return weu.a(paramClass, paramVarArgs);
    label124:
    Object localObject = weu.a(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wet
 * JD-Core Version:    0.7.0.1
 */