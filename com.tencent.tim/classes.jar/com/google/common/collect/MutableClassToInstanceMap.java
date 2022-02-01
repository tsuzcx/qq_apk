package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@GwtIncompatible
public final class MutableClassToInstanceMap<B>
  extends MapConstraints.ConstrainedMap<Class<? extends B>, B>
  implements ClassToInstanceMap<B>, Serializable
{
  private static final MapConstraint<Class<?>, Object> VALUE_CAN_BE_CAST_TO_KEY = new MutableClassToInstanceMap.1();
  
  private MutableClassToInstanceMap(Map<Class<? extends B>, B> paramMap)
  {
    super(paramMap, VALUE_CAN_BE_CAST_TO_KEY);
  }
  
  @CanIgnoreReturnValue
  private static <B, T extends B> T cast(Class<T> paramClass, B paramB)
  {
    return Primitives.wrap(paramClass).cast(paramB);
  }
  
  public static <B> MutableClassToInstanceMap<B> create()
  {
    return new MutableClassToInstanceMap(new HashMap());
  }
  
  public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> paramMap)
  {
    return new MutableClassToInstanceMap(paramMap);
  }
  
  private Object writeReplace()
  {
    return new SerializedForm(delegate());
  }
  
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return cast(paramClass, get(paramClass));
  }
  
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    return cast(paramClass, put(paramClass, paramT));
  }
  
  static final class SerializedForm<B>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    private final Map<Class<? extends B>, B> backingMap;
    
    SerializedForm(Map<Class<? extends B>, B> paramMap)
    {
      this.backingMap = paramMap;
    }
    
    Object readResolve()
    {
      return MutableClassToInstanceMap.create(this.backingMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MutableClassToInstanceMap
 * JD-Core Version:    0.7.0.1
 */