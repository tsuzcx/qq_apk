package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible
public final class ImmutableClassToInstanceMap<B>
  extends ForwardingMap<Class<? extends B>, B>
  implements ClassToInstanceMap<B>, Serializable
{
  private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
  private final ImmutableMap<Class<? extends B>, B> delegate;
  
  private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> paramImmutableMap)
  {
    this.delegate = paramImmutableMap;
  }
  
  public static <B> Builder<B> builder()
  {
    return new Builder();
  }
  
  public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> paramMap)
  {
    if ((paramMap instanceof ImmutableClassToInstanceMap)) {
      return (ImmutableClassToInstanceMap)paramMap;
    }
    return new Builder().putAll(paramMap).build();
  }
  
  public static <B> ImmutableClassToInstanceMap<B> of()
  {
    return EMPTY;
  }
  
  public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> paramClass, T paramT)
  {
    return new ImmutableClassToInstanceMap(ImmutableMap.of(paramClass, paramT));
  }
  
  protected Map<Class<? extends B>, B> delegate()
  {
    return this.delegate;
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return this.delegate.get(Preconditions.checkNotNull(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  Object readResolve()
  {
    ImmutableClassToInstanceMap localImmutableClassToInstanceMap = this;
    if (isEmpty()) {
      localImmutableClassToInstanceMap = of();
    }
    return localImmutableClassToInstanceMap;
  }
  
  public static final class Builder<B>
  {
    private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();
    
    private static <B, T extends B> T cast(Class<T> paramClass, B paramB)
    {
      return Primitives.wrap(paramClass).cast(paramB);
    }
    
    public ImmutableClassToInstanceMap<B> build()
    {
      ImmutableMap localImmutableMap = this.mapBuilder.build();
      if (localImmutableMap.isEmpty()) {
        return ImmutableClassToInstanceMap.of();
      }
      return new ImmutableClassToInstanceMap(localImmutableMap, null);
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(Class<T> paramClass, T paramT)
    {
      this.mapBuilder.put(paramClass, paramT);
      return this;
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> paramMap)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        Class localClass = (Class)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        this.mapBuilder.put(localClass, cast(localClass, localObject));
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableClassToInstanceMap
 * JD-Core Version:    0.7.0.1
 */