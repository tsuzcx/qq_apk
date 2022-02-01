package com.tencent.token;

import com.tencent.turingfd.sdk.qps.break;
import com.tencent.turingfd.sdk.qps.switch;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public final class adb
  implements ahk
{
  public final ahn a;
  public final boolean b;
  
  public adb(ahn paramahn)
  {
    this.a = paramahn;
    this.b = false;
  }
  
  public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
  {
    Object localObject1 = paramaek.b;
    if (!Map.class.isAssignableFrom(paramaek.a)) {
      return null;
    }
    Object localObject2 = switch.b((Type)localObject1);
    if (localObject1 == Properties.class)
    {
      localObject1 = new Type[2];
      localObject1[0] = String.class;
      localObject1[1] = String.class;
    }
    else
    {
      localObject1 = switch.a((Type)localObject1, (Class)localObject2, Map.class);
      if ((localObject1 instanceof ParameterizedType))
      {
        localObject1 = ((ParameterizedType)localObject1).getActualTypeArguments();
      }
      else
      {
        localObject1 = new Type[2];
        localObject1[0] = Object.class;
        localObject1[1] = Object.class;
      }
    }
    localObject2 = localObject1[0];
    if ((localObject2 != Boolean.TYPE) && (localObject2 != Boolean.class)) {
      localObject2 = paramahx.a(new aek((Type)localObject2));
    } else {
      localObject2 = ady.f;
    }
    ahh localahh = paramahx.a(new aek(localObject1[1]));
    this.a.a(paramaek);
    return new a(paramahx, localObject1[0], (ahh)localObject2, localObject1[1], localahh);
  }
  
  public final class a<K, V>
    extends ahh<Map<K, V>>
  {
    public final ahh<K> a;
    public final ahh<V> b;
    
    public a(Type paramType1, ahh<K> paramahh, Type paramType2, ahh<V> paramahh1, acj<? extends Map<K, V>> paramacj)
    {
      this.a = new adu(paramType1, paramType2, paramahh);
      this.b = new adu(paramType1, paramacj, paramahh1);
    }
    
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Map)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      if (!adb.this.b)
      {
        paramaep.c();
        paramObject = paramObject.entrySet().iterator();
        while (paramObject.hasNext())
        {
          localObject1 = (Map.Entry)paramObject.next();
          paramaep.a(String.valueOf(((Map.Entry)localObject1).getKey()));
          this.b.a(paramaep, ((Map.Entry)localObject1).getValue());
        }
        paramaep.d();
        return;
      }
      Object localObject1 = new ArrayList(paramObject.size());
      ArrayList localArrayList = new ArrayList(paramObject.size());
      paramObject = paramObject.entrySet().iterator();
      int m = 0;
      int k = 0;
      int i = 0;
      Object localObject2;
      while (paramObject.hasNext())
      {
        localObject2 = (Map.Entry)paramObject.next();
        ahh localahh = this.a;
        Object localObject4 = ((Map.Entry)localObject2).getKey();
        localahh.getClass();
        try
        {
          Object localObject3 = new adc();
          localahh.a((aep)localObject3, localObject4);
          if (((adc)localObject3).c.isEmpty())
          {
            localObject3 = ((adc)localObject3).e;
            ((ArrayList)localObject1).add(localObject3);
            localArrayList.add(((Map.Entry)localObject2).getValue());
            localObject3.getClass();
            if ((!(localObject3 instanceof ahb)) && (!(localObject3 instanceof agw))) {
              j = 0;
            } else {
              j = 1;
            }
            i |= j;
          }
          else
          {
            paramaep = new StringBuilder("Expected one JSON element but was ");
            paramaep.append(((adc)localObject3).c);
            throw new IllegalStateException(paramaep.toString());
          }
        }
        catch (IOException paramaep)
        {
          throw new break(paramaep);
        }
      }
      if (i != 0)
      {
        paramaep.a();
        j = ((ArrayList)localObject1).size();
        i = k;
        while (i < j)
        {
          paramaep.a();
          paramObject = (ahu)((ArrayList)localObject1).get(i);
          ady.X.a(paramaep, paramObject);
          this.b.a(paramaep, localArrayList.get(i));
          paramaep.b();
          i += 1;
        }
        paramaep.b();
        return;
      }
      paramaep.c();
      int j = ((ArrayList)localObject1).size();
      i = m;
      while (i < j)
      {
        paramObject = (ahu)((ArrayList)localObject1).get(i);
        paramObject.getClass();
        if ((paramObject instanceof agx))
        {
          paramObject = paramObject.c();
          localObject2 = paramObject.a;
          if ((localObject2 instanceof Number))
          {
            paramObject = String.valueOf(paramObject.a());
          }
          else
          {
            boolean bool = localObject2 instanceof Boolean;
            if (bool)
            {
              if (bool) {
                bool = ((Boolean)localObject2).booleanValue();
              } else {
                bool = Boolean.parseBoolean(paramObject.b());
              }
              paramObject = Boolean.toString(bool);
            }
            else if ((localObject2 instanceof String))
            {
              paramObject = paramObject.b();
            }
            else
            {
              throw new AssertionError();
            }
          }
        }
        else
        {
          if (!(paramObject instanceof agv)) {
            break label594;
          }
          paramObject = "null";
        }
        paramaep.a(paramObject);
        this.b.a(paramaep, localArrayList.get(i));
        i += 1;
        continue;
        label594:
        throw new AssertionError();
      }
      paramaep.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adb
 * JD-Core Version:    0.7.0.1
 */