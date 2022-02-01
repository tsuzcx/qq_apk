package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;

public final class acm<E>
  extends ahh<Object>
{
  public static final ahk a = new a();
  public final ahh<E> b;
  
  public acm(ahx paramahx, ahh<E> paramahh, Class<E> paramClass)
  {
    this.b = new adu(paramahx, paramahh, paramClass);
  }
  
  public final void a(aep paramaep, Object paramObject)
  {
    if (paramObject == null)
    {
      paramaep.e();
      return;
    }
    paramaep.a();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.b.a(paramaep, localObject);
      i += 1;
    }
    paramaep.b();
  }
  
  public final class a
    implements ahk
  {
    public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
    {
      paramaek = paramaek.b;
      boolean bool = paramaek instanceof GenericArrayType;
      if ((!bool) && ((!(paramaek instanceof Class)) || (!((Class)paramaek).isArray()))) {
        return null;
      }
      if (bool) {
        paramaek = ((GenericArrayType)paramaek).getGenericComponentType();
      } else {
        paramaek = ((Class)paramaek).getComponentType();
      }
      return new acm(paramahx, paramahx.a(new aek(paramaek)), switch.b(paramaek));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acm
 * JD-Core Version:    0.7.0.1
 */