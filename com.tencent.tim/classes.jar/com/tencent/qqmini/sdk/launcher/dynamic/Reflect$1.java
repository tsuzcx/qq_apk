package com.tencent.qqmini.sdk.launcher.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class Reflect$1
  implements InvocationHandler
{
  Reflect$1(Reflect paramReflect, boolean paramBoolean) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    paramObject = paramMethod.getName();
    try
    {
      paramMethod = Reflect.on(Reflect.access$000(this.this$0)).call(paramObject, paramArrayOfObject).get();
      return paramMethod;
    }
    catch (ReflectException paramMethod)
    {
      if (this.val$isMap)
      {
        Map localMap = (Map)Reflect.access$000(this.this$0);
        if (paramArrayOfObject == null) {}
        for (int i = 0; (i == 0) && (paramObject.startsWith("get")); i = paramArrayOfObject.length) {
          return localMap.get(Reflect.access$100(paramObject.substring(3)));
        }
        if ((i == 0) && (paramObject.startsWith("is"))) {
          return localMap.get(Reflect.access$100(paramObject.substring(2)));
        }
        if ((i == 1) && (paramObject.startsWith("set")))
        {
          localMap.put(Reflect.access$100(paramObject.substring(3)), paramArrayOfObject[0]);
          return null;
        }
      }
      throw paramMethod;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.dynamic.Reflect.1
 * JD-Core Version:    0.7.0.1
 */