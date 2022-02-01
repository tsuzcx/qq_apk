package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap.SimpleImmutableEntry;
import javax.annotation.Nullable;

@GwtCompatible
public final class RemovalNotification<K, V>
  extends AbstractMap.SimpleImmutableEntry<K, V>
{
  private static final long serialVersionUID = 0L;
  private final RemovalCause cause;
  
  private RemovalNotification(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause)
  {
    super(paramK, paramV);
    this.cause = ((RemovalCause)Preconditions.checkNotNull(paramRemovalCause));
  }
  
  public static <K, V> RemovalNotification<K, V> create(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause)
  {
    return new RemovalNotification(paramK, paramV, paramRemovalCause);
  }
  
  public RemovalCause getCause()
  {
    return this.cause;
  }
  
  public boolean wasEvicted()
  {
    return this.cause.wasEvicted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.RemovalNotification
 * JD-Core Version:    0.7.0.1
 */