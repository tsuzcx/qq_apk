package com.tencent.token;

import java.lang.reflect.Field;
import java.util.HashMap;

public final class to
{
  private static to b;
  private HashMap<String, Class<? extends tr>> a = new HashMap();
  
  private to()
  {
    a(tn.class);
  }
  
  public static tr a(String paramString)
  {
    if (b == null) {
      b = new to();
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
          localObject2 = (tt)((Field)localObject2).getAnnotation(tt.class);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject2 = ((tt)localObject2).a();
            if (localObject2 == null) {
              xj.c("protocol mapping definition in ProtocolConstant is error:".concat(String.valueOf(localObject1)));
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
  
  private tr b(String paramString)
  {
    paramString = (Class)this.a.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (tr)paramString.newInstance();
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
 * Qualified Name:     com.tencent.token.to
 * JD-Core Version:    0.7.0.1
 */