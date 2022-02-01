package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface BiMap<K, V>
  extends Map<K, V>
{
  @Nullable
  @CanIgnoreReturnValue
  public abstract V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  public abstract BiMap<V, K> inverse();
  
  @Nullable
  @CanIgnoreReturnValue
  public abstract V put(@Nullable K paramK, @Nullable V paramV);
  
  public abstract void putAll(Map<? extends K, ? extends V> paramMap);
  
  public abstract Set<V> values();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.BiMap
 * JD-Core Version:    0.7.0.1
 */