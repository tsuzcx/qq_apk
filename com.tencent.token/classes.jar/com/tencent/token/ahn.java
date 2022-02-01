package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class ahn
{
  public final Map<Type, agu<?>> a;
  public final aeh b = aeh.a();
  
  public ahn(Map<Type, agu<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  public final <T> acj<T> a(aek<T> paramaek)
  {
    final Type localType = paramaek.b;
    Class localClass2 = paramaek.a;
    paramaek = (agu)this.a.get(localType);
    if (paramaek != null) {
      return new a(paramaek, localType);
    }
    paramaek = (agu)this.a.get(localClass2);
    if (paramaek != null) {
      return new b(paramaek, localType);
    }
    Class localClass1 = null;
    try
    {
      paramaek = localClass2.getDeclaredConstructor(new Class[0]);
      if (!paramaek.isAccessible()) {
        this.b.a(paramaek);
      }
      paramaek = new agt(paramaek);
    }
    catch (NoSuchMethodException paramaek)
    {
      label107:
      break label107;
    }
    paramaek = null;
    if (paramaek != null) {
      return paramaek;
    }
    if (Collection.class.isAssignableFrom(localClass2))
    {
      if (SortedSet.class.isAssignableFrom(localClass2)) {
        paramaek = new agy();
      } else if (EnumSet.class.isAssignableFrom(localClass2)) {
        paramaek = new ahs(localType);
      } else if (Set.class.isAssignableFrom(localClass2)) {
        paramaek = new ahy();
      } else if (Queue.class.isAssignableFrom(localClass2)) {
        paramaek = new ahj();
      } else {
        paramaek = new aho();
      }
    }
    else
    {
      paramaek = localClass1;
      if (Map.class.isAssignableFrom(localClass2)) {
        if (ConcurrentNavigableMap.class.isAssignableFrom(localClass2))
        {
          paramaek = new ahw();
        }
        else if (ConcurrentMap.class.isAssignableFrom(localClass2))
        {
          paramaek = new ahv();
        }
        else if (SortedMap.class.isAssignableFrom(localClass2))
        {
          paramaek = new agz();
        }
        else
        {
          if ((localType instanceof ParameterizedType))
          {
            paramaek = ((ParameterizedType)localType).getActualTypeArguments()[0];
            paramaek.getClass();
            paramaek = switch.a(paramaek);
            localClass1 = switch.b(paramaek);
            paramaek.hashCode();
            if (!String.class.isAssignableFrom(localClass1))
            {
              paramaek = new ahc();
              break label363;
            }
          }
          paramaek = new ahd();
        }
      }
    }
    label363:
    if (paramaek != null) {
      return paramaek;
    }
    return new ahm(localClass2, localType);
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
  
  public final class a
    implements acj<T>
  {
    public a(Type paramType) {}
    
    public final T a()
    {
      return ahn.this.a();
    }
  }
  
  public final class b
    implements acj<T>
  {
    public b(Type paramType) {}
    
    public final T a()
    {
      return ahn.this.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahn
 * JD-Core Version:    0.7.0.1
 */