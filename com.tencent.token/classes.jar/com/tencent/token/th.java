package com.tencent.token;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class th
{
  private static th b;
  private HashMap<String, Class<? extends tk>> a = new HashMap();
  
  private th()
  {
    a(tg.class);
  }
  
  public static tk a(String paramString)
  {
    if (b == null) {
      b = new th();
    }
    return b.b(paramString);
  }
  
  private void a(Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredFields();
    if (paramClass == null) {
      return;
    }
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramClass[i];
      try
      {
        Object localObject1 = ((Field)localObject2).get(null);
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
          localObject2 = (tm)((Field)localObject2).getAnnotation(tm.class);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject2 = ((tm)localObject2).a();
            if (localObject2 == null) {
              xb.c("protocol mapping definition in ProtocolConstant is error:".concat(String.valueOf(localObject1)));
            } else {
              this.a.put(localObject1, localObject2);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
  }
  
  private tk b(String paramString)
  {
    paramString = (Class)this.a.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (tk)paramString.newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.th
 * JD-Core Version:    0.7.0.1
 */