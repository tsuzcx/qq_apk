package com.tencent.token;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class if
  implements InvocationHandler
{
  boolean a;
  String b;
  private final List c;
  
  if(List paramList)
  {
    this.c = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Class localClass = paramMethod.getReturnType();
    paramObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramObject = gn.b;
    }
    if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
      return Boolean.valueOf(true);
    }
    if ((str.equals("unsupported")) && (Void.TYPE == localClass))
    {
      this.a = true;
      return null;
    }
    if ((str.equals("protocols")) && (paramObject.length == 0)) {
      return this.c;
    }
    if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
    {
      paramObject = (List)paramObject[0];
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (this.c.contains(paramObject.get(i)))
        {
          paramObject = (String)paramObject.get(i);
          this.b = paramObject;
          return paramObject;
        }
        i += 1;
      }
      paramObject = (String)this.c.get(0);
      this.b = paramObject;
      return paramObject;
    }
    if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
    {
      this.b = ((String)paramObject[0]);
      return null;
    }
    return paramMethod.invoke(this, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.if
 * JD-Core Version:    0.7.0.1
 */