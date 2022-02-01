package com.tencent.tpns.reflecttools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class Reflect$1
  implements InvocationHandler
{
  Reflect$1(Reflect paramReflect, boolean paramBoolean) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    try
    {
      paramMethod = Reflect.access$200(Reflect.access$000(this.b), Reflect.access$100(this.b)).call(paramObject, paramArrayOfObject).get();
      return paramMethod;
    }
    catch (ReflectException paramMethod)
    {
      if (this.a)
      {
        Map localMap = (Map)Reflect.access$100(this.b);
        if (paramArrayOfObject == null) {}
        for (int i = 0; (i == 0) && (paramObject.startsWith("get")); i = paramArrayOfObject.length) {
          return localMap.get(Reflect.access$300(paramObject.substring(3)));
        }
        if ((i == 0) && (paramObject.startsWith("is"))) {
          return localMap.get(Reflect.access$300(paramObject.substring(2)));
        }
        if ((i == 1) && (paramObject.startsWith("set")))
        {
          localMap.put(Reflect.access$300(paramObject.substring(3)), paramArrayOfObject[0]);
          return null;
        }
      }
      throw paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.reflecttools.Reflect.1
 * JD-Core Version:    0.7.0.1
 */