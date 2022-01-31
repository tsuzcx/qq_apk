package com.tencent.token;

import com.tencent.token.global.e;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class bi
{
  private static bi b;
  private HashMap a = new HashMap();
  
  private bi()
  {
    a(bh.class);
  }
  
  public static bm a(String paramString)
  {
    if (b == null) {
      b = new bi();
    }
    return b.b(paramString);
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
          localObject2 = (bv)((Field)localObject2).getAnnotation(bv.class);
          if ((localObject1 == null) || (localObject2 == null)) {
            break label135;
          }
          localObject2 = ((bv)localObject2).a();
          if (localObject2 == null) {
            e.c("protocol mapping definition in ProtocolConstant is error:" + (String)localObject1);
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
  
  private bm b(String paramString)
  {
    paramString = (Class)this.a.get(paramString);
    if (paramString != null) {
      try
      {
        paramString = (bm)paramString.newInstance();
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
 * Qualified Name:     com.tencent.token.bi
 * JD-Core Version:    0.7.0.1
 */