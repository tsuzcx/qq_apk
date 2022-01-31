package com.tencent.token.core.protocolcenter;

import com.tencent.token.global.h;
import java.lang.reflect.Field;
import java.util.HashMap;

public class b
{
  private static b b;
  private HashMap a = new HashMap();
  
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
  
  public static e a(String paramString)
  {
    return a().b(paramString);
  }
  
  private void a(Class paramClass)
  {
    paramClass = paramClass.getDeclaredFields();
    if (paramClass == null) {}
    for (;;)
    {
      return;
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramClass[i];
        try
        {
          Object localObject1 = ((Field)localObject2).get(null);
          if (!(localObject1 instanceof String)) {
            break label135;
          }
          localObject1 = (String)localObject1;
          localObject2 = (n)((Field)localObject2).getAnnotation(n.class);
          if ((localObject1 == null) || (localObject2 == null)) {
            break label135;
          }
          localObject2 = ((n)localObject2).a();
          if (localObject2 == null) {
            h.c("protocol mapping definition in ProtocolConstant is error:" + (String)localObject1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.a.put(localException, localObject2);
        label135:
        i += 1;
      }
    }
  }
  
  private e b(String paramString)
  {
    paramString = (Class)this.a.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (e)paramString.newInstance();
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