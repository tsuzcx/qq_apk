import java.util.concurrent.ConcurrentHashMap;

public class ppl
{
  public static ConcurrentHashMap<Class<?>, Class<?>> bT = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class<?>, Class<?>> bU = new ConcurrentHashMap();
  
  static
  {
    bT.put(qoo.class, ppj.class);
    bU.put(psp.class, ppk.class);
  }
  
  public static <I> I a(Class<? extends I> paramClass, Class<I> paramClass1, Object... paramVarArgs)
  {
    try
    {
      if (paramClass.equals(qoo.class))
      {
        Object localObject = paramClass1.cast(new ppj());
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ram.e("ExtensionFactoryImplement", "parse int exception");
      try
      {
        paramClass = (Class)bT.get(paramClass);
        if (paramClass != null)
        {
          if (ppe.class.isAssignableFrom(paramClass)) {
            break label110;
          }
          throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
        }
      }
      catch (Exception paramClass)
      {
        ram.e("ExtensionFactoryImplement", "createImplement Error", new Throwable());
      }
      return ppm.b(paramClass1);
    }
    label110:
    paramClass = ppm.b(paramClass, paramVarArgs);
    return paramClass;
  }
  
  public static <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    if (!ppe.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("createExtendableObject class " + paramClass.getName() + " should have a KeepConstructor interface");
    }
    try
    {
      Class localClass = (Class)bU.get(paramClass);
      if (localClass != null)
      {
        if (ppe.class.isAssignableFrom(localClass)) {
          break label124;
        }
        throw new IllegalArgumentException("createExtendableObject class " + localClass.getName() + " should have a KeepConstructor interface");
      }
    }
    catch (Exception localException)
    {
      ram.e("ExtensionFactoryImplement", "createImplement Error", new Throwable());
    }
    return ppm.b(paramClass, paramVarArgs);
    label124:
    Object localObject = ppm.b(localException, paramVarArgs);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ppl
 * JD-Core Version:    0.7.0.1
 */