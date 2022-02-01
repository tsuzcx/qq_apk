package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class ImmutableMapValues<K, V>
  extends ImmutableCollection<V>
{
  @Weak
  private final ImmutableMap<K, V> map;
  
  ImmutableMapValues(ImmutableMap<K, V> paramImmutableMap)
  {
    this.map = paramImmutableMap;
  }
  
  public ImmutableList<V> asList()
  {
    return new ImmutableMapValues.2(this, this.map.entrySet().asList());
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (paramObject != null) && (Iterators.contains(iterator(), paramObject));
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public UnmodifiableIterator<V> iterator()
  {
    return new ImmutableMapValues.1(this);
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  @GwtIncompatible
  Object writeReplace()
  {
    return new SerializedForm(this.map);
  }
  
  @GwtIncompatible
  static class SerializedForm<V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final ImmutableMap<?, V> map;
    
    SerializedForm(ImmutableMap<?, V> paramImmutableMap)
    {
      this.map = paramImmutableMap;
    }
    
    Object readResolve()
    {
      return this.map.values();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMapValues
 * JD-Core Version:    0.7.0.1
 */