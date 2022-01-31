package tmsdk.common.a;

import java.util.HashMap;

public class b
{
  public static String a = "ManagerCreatorC";
  private static Object b = new Object();
  private static HashMap c = new HashMap();
  
  public static Object a(Class paramClass)
  {
    Object localObject1 = c.get(paramClass);
    if (localObject1 != null) {
      return localObject1;
    }
    for (;;)
    {
      try
      {
        Object localObject2;
        synchronized (b)
        {
          localObject2 = c.get(paramClass);
          localObject1 = localObject2;
          localObject2 = localObject1;
          if (localObject1 != null) {}
        }
      }
      catch (Exception paramClass)
      {
        continue;
      }
      try
      {
        throw paramClass;
      }
      catch (Exception paramClass)
      {
        paramClass = a;
        return localObject1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.a.b
 * JD-Core Version:    0.7.0.1
 */