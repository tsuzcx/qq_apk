package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty0.Setter;
import kotlin.reflect.KProperty0.Getter;

public abstract class MutablePropertyReference0
  extends MutablePropertyReference
  implements KMutableProperty0
{
  public MutablePropertyReference0() {}
  
  @SinceKotlin(version="1.1")
  public MutablePropertyReference0(Object paramObject)
  {
    super(paramObject);
  }
  
  protected KCallable computeReflected()
  {
    return Reflection.mutableProperty0(this);
  }
  
  @SinceKotlin(version="1.1")
  public Object getDelegate()
  {
    return ((KMutableProperty0)getReflected()).getDelegate();
  }
  
  public KProperty0.Getter getGetter()
  {
    return ((KMutableProperty0)getReflected()).getGetter();
  }
  
  public KMutableProperty0.Setter getSetter()
  {
    return ((KMutableProperty0)getReflected()).getSetter();
  }
  
  public Object invoke()
  {
    return get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.MutablePropertyReference0
 * JD-Core Version:    0.7.0.1
 */