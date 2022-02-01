package com.tencent.token.core.protocolcenter;

import com.tencent.token.global.g;
import java.lang.reflect.Field;
import java.util.HashMap;

public class b
{
  private static b b;
  private HashMap<String, Class<? extends d>> a = new HashMap();
  
  private b()
  {
    b();
  }
  
  public static b a()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  public static d a(String paramString)
  {
    return a().b(paramString);
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
          localObject2 = (f)((Field)localObject2).getAnnotation(f.class);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject2 = ((f)localObject2).a();
            if (localObject2 == null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("protocol mapping definition in ProtocolConstant is error:");
              ((StringBuilder)localObject2).append((String)localObject1);
              g.c(((StringBuilder)localObject2).toString());
            }
            else
            {
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
  
  private d b(String paramString)
  {
    paramString = (Class)this.a.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (d)paramString.newInstance();
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private void b()
  {
    a(a.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.b
 * JD-Core Version:    0.7.0.1
 */