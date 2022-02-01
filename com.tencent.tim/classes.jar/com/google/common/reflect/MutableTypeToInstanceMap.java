package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class MutableTypeToInstanceMap<B>
  extends ForwardingMap<TypeToken<? extends B>, B>
  implements TypeToInstanceMap<B>
{
  private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();
  
  @Nullable
  private <T extends B> T trustedGet(TypeToken<T> paramTypeToken)
  {
    return this.backingMap.get(paramTypeToken);
  }
  
  @Nullable
  private <T extends B> T trustedPut(TypeToken<T> paramTypeToken, @Nullable T paramT)
  {
    return this.backingMap.put(paramTypeToken, paramT);
  }
  
  public Map<TypeToken<? extends B>, B> delegate()
  {
    return this.backingMap;
  }
  
  public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet()
  {
    return UnmodifiableEntry.transformEntries(super.entrySet());
  }
  
  @Nullable
  public <T extends B> T getInstance(TypeToken<T> paramTypeToken)
  {
    return trustedGet(paramTypeToken.rejectTypeVariables());
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> paramClass)
  {
    return trustedGet(TypeToken.of(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public B put(TypeToken<? extends B> paramTypeToken, B paramB)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(TypeToken<T> paramTypeToken, @Nullable T paramT)
  {
    return trustedPut(paramTypeToken.rejectTypeVariables(), paramT);
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, @Nullable T paramT)
  {
    return trustedPut(TypeToken.of(paramClass), paramT);
  }
  
  static final class UnmodifiableEntry<K, V>
    extends ForwardingMapEntry<K, V>
  {
    private final Map.Entry<K, V> delegate;
    
    private UnmodifiableEntry(Map.Entry<K, V> paramEntry)
    {
      this.delegate = ((Map.Entry)Preconditions.checkNotNull(paramEntry));
    }
    
    private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> paramIterator)
    {
      return Iterators.transform(paramIterator, new MutableTypeToInstanceMap.UnmodifiableEntry.2());
    }
    
    static <K, V> Set<Map.Entry<K, V>> transformEntries(Set<Map.Entry<K, V>> paramSet)
    {
      return new MutableTypeToInstanceMap.UnmodifiableEntry.1(paramSet);
    }
    
    public Map.Entry<K, V> delegate()
    {
      return this.delegate;
    }
    
    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.MutableTypeToInstanceMap
 * JD-Core Version:    0.7.0.1
 */