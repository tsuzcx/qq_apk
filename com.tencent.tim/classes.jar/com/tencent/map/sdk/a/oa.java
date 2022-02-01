package com.tencent.map.sdk.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class oa
{
  oy a = new oy();
  private ConcurrentHashMap<String, Map<String, ny>> b = new ConcurrentHashMap();
  
  final <D extends nz, C extends ny<D>> C a(Class<D> paramClass, ny.a parama, Class<C> paramClass1)
  {
    Map localMap = (Map)this.b.get(paramClass1.getName());
    String str1 = oc.a(paramClass.getName() + parama.toString());
    String str2 = paramClass1.getName();
    if (localMap != null)
    {
      paramClass = (ny)localMap.get(str1);
      if (paramClass != null)
      {
        parama = paramClass;
        return parama;
      }
    }
    for (;;)
    {
      Constructor[] arrayOfConstructor = paramClass1.getDeclaredConstructors();
      paramClass1 = null;
      int j = arrayOfConstructor.length;
      int i = 0;
      label93:
      if (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        Class[] arrayOfClass = localConstructor.getParameterTypes();
        if ((arrayOfClass.length != 1) || (arrayOfClass[0] != parama.getClass())) {
          break label235;
        }
        paramClass1 = localConstructor;
      }
      label235:
      for (;;)
      {
        i += 1;
        break label93;
        if (paramClass1 != null) {}
        for (;;)
        {
          try
          {
            parama = (ny)paramClass1.newInstance(new Object[] { parama });
            paramClass = parama;
          }
          catch (IllegalAccessException parama)
          {
            parama.printStackTrace();
            continue;
          }
          catch (InstantiationException parama)
          {
            parama.printStackTrace();
            continue;
          }
          catch (InvocationTargetException parama)
          {
            parama.printStackTrace();
          }
          parama = paramClass;
          if (paramClass == null) {
            break;
          }
          parama = localMap;
          if (localMap == null) {
            parama = new HashMap();
          }
          parama.put(str1, paramClass);
          this.b.put(str2, parama);
          return paramClass;
        }
      }
      paramClass = null;
    }
  }
  
  public static final class a<D extends nz>
    extends ot<String, D>
  {
    private ny.b<D> a;
    
    a(int paramInt, ny.b<D> paramb)
    {
      super();
      this.a = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oa
 * JD-Core Version:    0.7.0.1
 */