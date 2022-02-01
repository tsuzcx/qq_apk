package com.tencent.token;

import java.util.HashMap;

public final class aov
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
    localObject2 = localObject1;
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
      return localObject2;
    }
    catch (Exception paramClass) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aov
 * JD-Core Version:    0.7.0.1
 */