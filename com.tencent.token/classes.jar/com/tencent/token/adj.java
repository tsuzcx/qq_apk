package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class adj
  implements ahk
{
  public final ahn a;
  public final ahl b;
  public final ahg c;
  public final ada d;
  public final aeh e = aeh.a();
  
  public adj(ahn paramahn, ahl paramahl, ahg paramahg, ada paramada)
  {
    this.a = paramahn;
    this.b = paramahl;
    this.c = paramahg;
    this.d = paramada;
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    Object localObject = this.c;
    boolean bool1 = ahg.a(paramField.getType());
    boolean bool2 = false;
    int i;
    if ((!bool1) && (!((ahg)localObject).a(paramBoolean))) {
      i = 0;
    } else {
      i = 1;
    }
    bool1 = bool2;
    if (i == 0)
    {
      if (((paramField.getModifiers() & 0x88) == 0) && (!paramField.isSynthetic()) && (!ahg.a(paramField.getType())))
      {
        if (paramBoolean) {
          localObject = ((ahg)localObject).b;
        } else {
          localObject = ((ahg)localObject).c;
        }
        if (!((List)localObject).isEmpty())
        {
          new ahf(paramField);
          paramField = ((List)localObject).iterator();
          while (paramField.hasNext()) {
            if (((aha)paramField.next()).a()) {
              break label157;
            }
          }
        }
        i = 0;
      }
      else
      {
        label157:
        i = 1;
      }
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
  {
    Class localClass = paramaek.a;
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    this.a.a(paramaek);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (!localClass.isInterface())
    {
      Type localType2 = paramaek.b;
      Object localObject3 = paramaek;
      while (localClass != Object.class)
      {
        paramaek = localClass.getDeclaredFields();
        int j = paramaek.length;
        int k;
        for (int i = 0;; i = k)
        {
          Object localObject1 = this;
          if (i >= j) {
            break label568;
          }
          Field localField = paramaek[i];
          boolean bool1 = ((adj)localObject1).a(localField, true);
          boolean bool2 = ((adj)localObject1).a(localField, false);
          if ((!bool1) && (!bool2))
          {
            k = i;
            i = j;
          }
          else
          {
            ((adj)localObject1).e.a(localField);
            Type localType1 = switch.a(((aek)localObject3).b, localClass, localField.getGenericType());
            Object localObject4 = (ahq)localField.getAnnotation(ahq.class);
            if (localObject4 == null)
            {
              localObject1 = Collections.singletonList(((adj)localObject1).b.a(localField));
            }
            else
            {
              localObject2 = ((ahq)localObject4).a();
              localObject4 = ((ahq)localObject4).b();
              if (localObject4.length == 0)
              {
                localObject1 = Collections.singletonList(localObject2);
              }
              else
              {
                localObject1 = new ArrayList(localObject4.length + 1);
                ((ArrayList)localObject1).add(localObject2);
                k = localObject4.length;
                m = 0;
                while (m < k)
                {
                  ((ArrayList)localObject1).add(localObject4[m]);
                  m += 1;
                }
              }
            }
            k = ((List)localObject1).size();
            Object localObject2 = null;
            int m = 0;
            localObject4 = localObject1;
            localObject1 = paramaek;
            for (paramaek = (aek<T>)localObject2;; paramaek = (aek<T>)localObject2)
            {
              ahx localahx = paramahx;
              if (m >= k) {
                break;
              }
              String str = (String)((List)localObject4).get(m);
              if (m != 0) {
                bool1 = false;
              }
              aek localaek = new aek(localType1);
              localObject2 = localaek.a;
              if ((localObject2 instanceof Class)) {
                ((Class)localObject2).isPrimitive();
              }
              localObject2 = (ahp)localField.getAnnotation(ahp.class);
              if (localObject2 != null) {
                localObject2 = ada.a(this.a, localahx, localaek, (ahp)localObject2);
              } else {
                localObject2 = null;
              }
              if (localObject2 != null) {
                bool2 = true;
              } else {
                bool2 = false;
              }
              if (localObject2 == null) {
                localObject2 = localahx.a(localaek);
              }
              localObject2 = (b)localLinkedHashMap.put(str, new adi(str, bool1, localField, bool2, (ahh)localObject2, paramahx, localaek));
              if (paramaek != null) {
                localObject2 = paramaek;
              }
              m += 1;
            }
            if (paramaek != null) {
              break;
            }
            k = i;
            i = j;
            paramaek = (aek<T>)localObject1;
          }
          k += 1;
          j = i;
        }
        paramahx = new StringBuilder();
        paramahx.append(localType2);
        paramahx.append(" declares multiple JSON fields named ");
        paramahx.append(paramaek.f);
        throw new IllegalArgumentException(paramahx.toString());
        label568:
        localObject3 = new aek(switch.a(((aek)localObject3).b, localClass, localClass.getGenericSuperclass()));
        localClass = ((aek)localObject3).a;
      }
    }
    return new a(localLinkedHashMap);
  }
  
  public static final class a<T>
    extends ahh<T>
  {
    public final Map<String, adj.b> a;
    
    public a(Map<String, adj.b> paramMap)
    {
      this.a = paramMap;
    }
    
    public final void a(aep paramaep, T paramT)
    {
      if (paramT == null)
      {
        paramaep.e();
        return;
      }
      paramaep.c();
      try
      {
        Iterator localIterator = this.a.values().iterator();
        while (localIterator.hasNext())
        {
          adj.b localb = (adj.b)localIterator.next();
          if (localb.a(paramT))
          {
            paramaep.a(localb.f);
            localb.a(paramaep, paramT);
          }
        }
        paramaep.d();
        return;
      }
      catch (IllegalAccessException paramaep)
      {
        throw new AssertionError(paramaep);
      }
    }
  }
  
  public static abstract class b
  {
    public final String f;
    public final boolean g;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.f = paramString;
      this.g = paramBoolean;
    }
    
    public abstract void a(aep paramaep, Object paramObject);
    
    public abstract boolean a(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adj
 * JD-Core Version:    0.7.0.1
 */