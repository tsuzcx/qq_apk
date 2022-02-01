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
    Object localObject2 = localObject1;
    try
    {
      Object localObject4 = b;
      localObject2 = localObject1;
      try
      {
        Object localObject3 = c.get(paramClass);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          localObject2 = paramClass.newInstance();
          localObject1 = localObject2;
          c.put(paramClass, localObject2);
        }
        localObject1 = localObject2;
        return localObject2;
      }
      finally
      {
        localObject2 = localObject1;
        localObject2 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      label75:
      break label75;
    }
    paramClass = a;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.a.b
 * JD-Core Version:    0.7.0.1
 */