package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

@Beta
public final class ImmutableTypeToInstanceMap<B>
  extends ForwardingMap<TypeToken<? extends B>, B>
  implements TypeToInstanceMap<B>
{
  private final ImmutableMap<TypeToken<? extends B>, B> delegate;
  
  private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> paramImmutableMap)
  {
    this.delegate = paramImmutableMap;
  }
  
  public static <B> Builder<B> builder()
  {
    return new Builder(null);
  }
  
  public static <B> ImmutableTypeToInstanceMap<B> of()
  {
    return new ImmutableTypeToInstanceMap(ImmutableMap.of());
  }
  
  private <T extends B> T trustedGet(TypeToken<T> paramTypeToken)
  {
    return this.delegate.get(paramTypeToken);
  }
  
  public Map<TypeToken<? extends B>, B> delegate()
  {
    return this.delegate;
  }
  
  public <T extends B> T getInstance(TypeToken<T> paramTypeToken)
  {
    return trustedGet(paramTypeToken.rejectTypeVariables());
  }
  
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return trustedGet(TypeToken.of(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public B put(TypeToken<? extends B> paramTypeToken, B paramB)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(TypeToken<T> paramTypeToken, T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  @Beta
  public static final class Builder<B>
  {
    private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder = ImmutableMap.builder();
    
    public ImmutableTypeToInstanceMap<B> build()
    {
      return new ImmutableTypeToInstanceMap(this.mapBuilder.build(), null);
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(TypeToken<T> paramTypeToken, T paramT)
    {
      this.mapBuilder.put(paramTypeToken.rejectTypeVariables(), paramT);
      return this;
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(Class<T> paramClass, T paramT)
    {
      this.mapBuilder.put(TypeToken.of(paramClass), paramT);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.ImmutableTypeToInstanceMap
 * JD-Core Version:    0.7.0.1
 */