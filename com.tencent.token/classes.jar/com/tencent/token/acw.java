package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;

public final class acw
  implements ahk
{
  public final ahn a;
  
  public acw(ahn paramahn)
  {
    this.a = paramahn;
  }
  
  public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
  {
    Object localObject1 = paramaek.b;
    Object localObject2 = paramaek.a;
    if (!Collection.class.isAssignableFrom((Class)localObject2)) {
      return null;
    }
    localObject2 = switch.a((Type)localObject1, (Class)localObject2, Collection.class);
    localObject1 = localObject2;
    if ((localObject2 instanceof WildcardType)) {
      localObject1 = ((WildcardType)localObject2).getUpperBounds()[0];
    }
    if ((localObject1 instanceof ParameterizedType)) {
      localObject1 = ((ParameterizedType)localObject1).getActualTypeArguments()[0];
    } else {
      localObject1 = Object.class;
    }
    localObject2 = paramahx.a(new aek((Type)localObject1));
    this.a.a(paramaek);
    return new a(paramahx, (Type)localObject1, (ahh)localObject2);
  }
  
  public static final class a<E>
    extends ahh<Collection<E>>
  {
    public final ahh<E> a;
    
    public a(ahx paramahx, Type paramType, ahh<E> paramahh)
    {
      this.a = new adu(paramahx, paramahh, paramType);
    }
    
    public final void a(aep paramaep, Object paramObject)
    {
      paramObject = (Collection)paramObject;
      if (paramObject == null)
      {
        paramaep.e();
        return;
      }
      paramaep.a();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        this.a.a(paramaep, localObject);
      }
      paramaep.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acw
 * JD-Core Version:    0.7.0.1
 */