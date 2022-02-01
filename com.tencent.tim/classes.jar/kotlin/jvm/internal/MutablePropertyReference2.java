package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KMutableProperty2.Setter;
import kotlin.reflect.KProperty2.Getter;

public abstract class MutablePropertyReference2
  extends MutablePropertyReference
  implements KMutableProperty2
{
  protected KCallable computeReflected()
  {
    return Reflection.mutableProperty2(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate(Object paramObject1, Object paramObject2)
  {
    return ((KMutableProperty2)getReflected()).getDelegate(paramObject1, paramObject2);
  }
  
  public KProperty2.Getter getGetter()
  {
    return ((KMutableProperty2)getReflected()).getGetter();
  }
  
  public KMutableProperty2.Setter getSetter()
  {
    return ((KMutableProperty2)getReflected()).getSetter();
  }
  
  public Object invoke(Object paramObject1, Object paramObject2)
  {
    return get(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.MutablePropertyReference2
 * JD-Core Version:    0.7.0.1
 */